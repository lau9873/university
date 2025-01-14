package org.catacombae.hfsexplorer.tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import org.catacombae.dmgextractor.encodings.encrypted.ReadableCEncryptedEncodingStream;
import org.catacombae.hfsexplorer.IOUtil;
import org.catacombae.hfsexplorer.UDIFRecognizer;
import org.catacombae.hfsexplorer.fs.AppleSingleBuilder;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ReadableStreamDataLocator;
import org.catacombae.jparted.lib.SubDataLocator;
import org.catacombae.jparted.lib.fs.FSEntry;
import org.catacombae.jparted.lib.fs.FSFile;
import org.catacombae.jparted.lib.fs.FSFolder;
import org.catacombae.jparted.lib.fs.FSFork;
import org.catacombae.jparted.lib.fs.FSForkType;
import org.catacombae.jparted.lib.fs.FSLink;
import org.catacombae.jparted.lib.fs.FileSystemDetector;
import org.catacombae.jparted.lib.fs.FileSystemHandler;
import org.catacombae.jparted.lib.fs.FileSystemHandlerFactory;
import org.catacombae.jparted.lib.fs.FileSystemMajorType;
import org.catacombae.jparted.lib.ps.Partition;
import org.catacombae.jparted.lib.ps.PartitionSystemDetector;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory;
import org.catacombae.jparted.lib.ps.PartitionSystemType;
import org.catacombae.jparted.lib.ps.PartitionType;
import org.catacombae.udif.UDIFRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/tools/UnHFS.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/tools/UnHFS.class */
public class UnHFS {
    private static boolean debug = false;
    private static final int RETVAL_NEED_PASSWORD = 10;
    private static final int RETVAL_INCORRECT_PASSWORD = 11;

    private static void printUsage(PrintStream ps) {
        ps.println("usage: unhfs [options...] <input file>");
        ps.println("  Input file can be in raw, UDIF (.dmg) and/or encrypted format.");
        ps.println("  Options:");
        ps.println("    -o <output dir>");
        ps.println("      The target directory in the local file system where all extracted files");
        ps.println("      should go.");
        ps.println("      When this option is omitted, all files go to the currect working");
        ps.println("      directory.");
        ps.println("    -fsroot <path to extract>");
        ps.println("      A POSIX path in the HFS file system that should be extracted.");
        ps.println("      Example which extracts all the contents of joe's user dir from a backup");
        ps.println("      disk image to the current directory:");
        ps.println("        unhfs -o . -fsroot /Users/joe FullBackup.dmg");
        ps.println("      When this option is omitted, all the contents of the file system is");
        ps.println("      extracted.");
        ps.println("    -create");
        ps.println("      If the -fsroot path refers to a folder, create that folder inside");
        ps.println("      the output directory, rather than extracting into the output directory");
        ps.println("      itself.");
        ps.println("    -resforks NONE|APPLEDOUBLE");
        ps.println("      Determines whether resource forks should be extracted, and in what");
        ps.println("      format. Currently only the APPLEDOUBLE format, which puts each resource");
        ps.println("      fork in its own file with the '._' prefix, is supported.");
        ps.println("      When this option is omitted, no resource forks are extracted.");
        ps.println("    -partition <partition number>");
        ps.println("      If the input file is partitioned, extracts files from the specified HFS");
        ps.println("      partition. Partitions are numbered from 0 and up.");
        ps.println("      When this options is omitted, the application chooses the first");
        ps.println("      available HFS partition.");
        ps.println("    -password <password>");
        ps.println("      Specifies the password for an encrypted image.");
        ps.println("    -v");
        ps.println("      Verbose mode. Prints the POSIX path of every extracted file to stdout.");
        ps.println("    --");
        ps.println("      Signals that there are no more option arguments. Useful for accessing");
        ps.println("      input files with names identical to an option signature.");
    }

    public static void main(String[] args) {
        ReadableRandomAccessStream inputStream;
        String outputDirname = ".";
        String fsRoot = "/";
        boolean extractFolderDirectly = true;
        boolean extractResourceForks = false;
        boolean verbose = false;
        int partitionNumber = -1;
        char[] password = null;
        int i2 = 0;
        while (true) {
            if (i2 >= args.length) {
                break;
            }
            String curArg = args[i2];
            if (curArg.equals("-o")) {
                if (i2 + 1 < args.length) {
                    i2++;
                    outputDirname = args[i2];
                } else {
                    printUsage(System.err);
                    System.exit(1);
                }
            } else if (curArg.equals("-fsroot")) {
                if (i2 + 1 < args.length) {
                    i2++;
                    fsRoot = args[i2];
                } else {
                    printUsage(System.err);
                    System.exit(1);
                }
            } else if (curArg.equals("-create")) {
                extractFolderDirectly = false;
            } else if (curArg.equals("-resforks")) {
                if (i2 + 1 < args.length) {
                    i2++;
                    String value = args[i2];
                    if (value.equalsIgnoreCase("NONE")) {
                        extractResourceForks = false;
                    } else if (value.equalsIgnoreCase("APPLEDOUBLE")) {
                        extractResourceForks = true;
                    } else {
                        System.err.println("Error: Invalid value \"" + value + "\" for -resforks!");
                        printUsage(System.err);
                        System.exit(1);
                    }
                } else {
                    printUsage(System.err);
                    System.exit(1);
                }
            } else if (curArg.equals("-partition")) {
                if (i2 + 1 < args.length) {
                    try {
                        i2++;
                        partitionNumber = Integer.parseInt(args[i2]);
                    } catch (NumberFormatException e2) {
                        System.err.println("Error: Invalid partition number \"" + args[i2] + "\"!");
                        printUsage(System.err);
                        System.exit(1);
                    }
                } else {
                    printUsage(System.err);
                    System.exit(1);
                }
            } else if (curArg.equals("-password")) {
                if (i2 + 1 < args.length) {
                    i2++;
                    password = args[i2].toCharArray();
                } else {
                    printUsage(System.err);
                    System.exit(1);
                }
            } else if (curArg.equals("-v")) {
                verbose = true;
            } else if (curArg.equals("--")) {
                i2++;
            }
            i2++;
        }
        if (i2 != args.length - 1) {
            printUsage(System.err);
            System.exit(1);
        }
        String inputFilename = args[i2];
        File inputFile = new File(inputFilename);
        if (!inputFile.exists() || !inputFile.isFile() || !inputFile.canRead()) {
            System.err.println("Error: Input file \"" + inputFilename + "\" can not be read!");
            printUsage(System.err);
            System.exit(1);
        }
        File outputDir = new File(outputDirname);
        if (!outputDir.exists() || !outputDir.isDirectory()) {
            System.err.println("Error: Invalid output directory \"" + outputDirname + "\"!");
            printUsage(System.err);
            System.exit(1);
        }
        if (WindowsLowLevelIO.isSystemSupported()) {
            inputStream = new WindowsLowLevelIO(inputFilename);
        } else {
            inputStream = new ReadableFileStream(inputFilename);
        }
        try {
            unhfs(System.out, inputStream, outputDir, fsRoot, password, extractFolderDirectly, extractResourceForks, partitionNumber, verbose);
            System.exit(0);
        } catch (RuntimeIOException e3) {
            System.err.println("Exception while executing main routine:");
            e3.printStackTrace();
            System.exit(1);
        }
    }

    public static void unhfs(PrintStream outputStream, ReadableRandomAccessStream inFileStream, File outputDir, String fsRoot, char[] password, boolean extractFolderDirectly, boolean extractResourceForks, int partitionNumber, boolean verbose) throws RuntimeIOException {
        File dirForFolder;
        Partition[] partitionsToProbe;
        logDebug("Trying to detect encrypted structure...");
        if (ReadableCEncryptedEncodingStream.isCEncryptedEncoding(inFileStream)) {
            if (password != null) {
                try {
                    ReadableCEncryptedEncodingStream stream = new ReadableCEncryptedEncodingStream(inFileStream, password);
                    inFileStream = stream;
                } catch (Exception e2) {
                    System.err.println("Incorrect password for encrypted image.");
                    System.exit(11);
                }
            } else {
                System.err.println("Image is encrypted, and no password was specified.");
                System.exit(10);
            }
        }
        logDebug("Trying to detect UDIF structure...");
        if (UDIFRecognizer.isUDIF(inFileStream)) {
            try {
                ReadableRandomAccessStream stream2 = new UDIFRandomAccessStream(inFileStream);
                inFileStream = stream2;
            } catch (Exception e3) {
                e3.printStackTrace();
                System.err.println("Unhandled exception while trying to load UDIF wrapper.");
                System.exit(1);
            }
        }
        DataLocator inputDataLocator = new ReadableStreamDataLocator(inFileStream);
        PartitionSystemType[] psTypes = PartitionSystemDetector.detectPartitionSystem(inputDataLocator);
        if (psTypes.length >= 1) {
            int len$ = psTypes.length;
            int i$ = 0;
            loop0: while (true) {
                if (i$ >= len$) {
                    break;
                }
                PartitionSystemType chosenType = psTypes[i$];
                PartitionSystemHandlerFactory fact = chosenType.createDefaultHandlerFactory();
                PartitionSystemHandler psHandler = fact.createHandler(inputDataLocator);
                if (psHandler.getPartitionCount() > 0) {
                    if (partitionNumber >= 0) {
                        if (partitionNumber >= psHandler.getPartitionCount()) {
                            break;
                        }
                        partitionsToProbe = new Partition[]{psHandler.getPartition(partitionNumber)};
                    } else if (partitionNumber == -1) {
                        partitionsToProbe = psHandler.getPartitions();
                    } else {
                        System.err.println("Invalid partition number: " + partitionNumber);
                        System.exit(1);
                        return;
                    }
                    Partition[] arr$ = partitionsToProbe;
                    for (Partition p : arr$) {
                        if (p.getType() == PartitionType.APPLE_HFS_CONTAINER) {
                            inputDataLocator = new SubDataLocator(inputDataLocator, p.getStartOffset(), p.getLength());
                            break loop0;
                        } else if (p.getType() == PartitionType.APPLE_HFSX) {
                            inputDataLocator = new SubDataLocator(inputDataLocator, p.getStartOffset(), p.getLength());
                            break loop0;
                        }
                    }
                    continue;
                }
                i$++;
            }
        }
        FileSystemMajorType[] fsTypes = FileSystemDetector.detectFileSystem(inputDataLocator);
        FileSystemHandlerFactory fact2 = null;
        int len$2 = fsTypes.length;
        int i$2 = 0;
        while (true) {
            if (i$2 < len$2) {
                FileSystemMajorType type = fsTypes[i$2];
                switch (type) {
                    case APPLE_HFS:
                    case APPLE_HFS_PLUS:
                    case APPLE_HFSX:
                        fact2 = type.createDefaultHandlerFactory();
                        break;
                    default:
                        i$2++;
                }
            }
        }
        if (fact2 == null) {
            System.err.println("No HFS file system found.");
            System.exit(1);
        }
        FileSystemHandler fsHandler = fact2.createHandler(inputDataLocator);
        logDebug("Getting entry by posix path: \"" + fsRoot + "\"");
        FSEntry entry = fsHandler.getEntryByPosixPath(fsRoot, new String[0]);
        if (entry instanceof FSFolder) {
            FSFolder folder = (FSFolder) entry;
            String folderName = folder.getName();
            if (extractFolderDirectly || folderName.equals("/") || folderName.length() == 0) {
                dirForFolder = outputDir;
            } else {
                dirForFolder = getFileForFolder(outputDir, folder, verbose);
            }
            if (dirForFolder != null) {
                extractFolder(folder, dirForFolder, extractResourceForks, verbose);
            }
        } else if (entry instanceof FSFile) {
            FSFile file = (FSFile) entry;
            extractFile(file, outputDir, extractResourceForks, verbose);
        } else {
            System.err.println("Requested path is not a folder or a file!");
            System.exit(1);
        }
    }

    private static void extractFolder(FSFolder folder, File targetDir, boolean extractResourceForks, boolean verbose) {
        boolean wasEmpty = targetDir.list().length == 0;
        FSEntry[] arr$ = folder.listEntries();
        for (FSEntry e2 : arr$) {
            if (e2 instanceof FSFile) {
                FSFile file = (FSFile) e2;
                extractFile(file, targetDir, extractResourceForks, verbose);
            } else if (e2 instanceof FSFolder) {
                FSFolder subFolder = (FSFolder) e2;
                File subFolderFile = getFileForFolder(targetDir, subFolder, verbose);
                if (subFolderFile != null) {
                    extractFolder(subFolder, subFolderFile, extractResourceForks, verbose);
                }
            } else if (e2 instanceof FSLink) {
            }
        }
        if (wasEmpty) {
            long lastModified = folder.getAttributes().getModifyDate().getTime();
            targetDir.setLastModified(lastModified);
        }
    }

    private static void extractFile(FSFile file, File targetDir, boolean extractResourceForks, boolean verbose) throws RuntimeIOException {
        long lastModified = file.getAttributes().getModifyDate().getTime();
        File dataFile = new File(targetDir, scrub(file.getName()));
        if (!extractRawForkToFile(file.getMainFork(), dataFile)) {
            System.err.println("Failed to extract data fork to " + dataFile.getPath());
        } else if (verbose) {
            System.out.println(dataFile.getPath());
        }
        dataFile.setLastModified(lastModified);
        if (extractResourceForks) {
            FSFork resourceFork = file.getForkByType(FSForkType.MACOS_RESOURCE);
            if (resourceFork.getLength() > 0) {
                File resFile = new File(targetDir, "._" + scrub(file.getName()));
                if (!extractResourceForkToAppleDoubleFile(resourceFork, resFile)) {
                    System.err.println("Failed to extract resource fork to " + resFile.getPath());
                } else if (verbose) {
                    System.out.println(resFile.getPath());
                }
                resFile.setLastModified(lastModified);
            }
        }
    }

    private static File getFileForFolder(File targetDir, FSFolder folder, boolean verbose) {
        File folderFile = new File(targetDir, scrub(folder.getName()));
        if (folderFile.isDirectory() || folderFile.mkdir()) {
            if (verbose) {
                System.out.println(folderFile.getPath());
            }
        } else {
            System.err.println("Failed to create directory " + folderFile.getPath());
            folderFile = null;
        }
        return folderFile;
    }

    private static boolean extractRawForkToFile(FSFork fork, File targetFile) throws RuntimeIOException {
        FileOutputStream os = null;
        ReadableRandomAccessStream in = null;
        try {
            os = new FileOutputStream(targetFile);
            in = fork.getReadableRandomAccessStream();
            long extractedBytes = IOUtil.streamCopy(in, os, 131072);
            if (extractedBytes != fork.getLength()) {
                System.err.println("WARNING: Did not extract intended number of bytes to \"" + targetFile.getPath() + "\"! Intended: " + fork.getLength() + " Extracted: " + extractedBytes);
            }
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e2) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
            return true;
        } catch (FileNotFoundException e4) {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e5) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e6) {
                }
            }
            return false;
        } catch (Exception e7) {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e8) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e9) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e10) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e11) {
                }
            }
            throw th;
        }
    }

    private static boolean extractResourceForkToAppleDoubleFile(FSFork resourceFork, File targetFile) {
        FileOutputStream os = null;
        ReadableRandomAccessStream in = null;
        try {
            try {
                AppleSingleBuilder builder = new AppleSingleBuilder(AppleSingleBuilder.FileType.APPLEDOUBLE, AppleSingleBuilder.AppleSingleVersion.VERSION_2_0, AppleSingleBuilder.FileSystem.MACOS_X);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                in = resourceFork.getReadableRandomAccessStream();
                long extractedBytes = IOUtil.streamCopy(in, baos, 131072);
                if (extractedBytes != resourceFork.getLength()) {
                    System.err.println("WARNING: Did not extract intended number of bytes to \"" + targetFile.getPath() + "\"! Intended: " + resourceFork.getLength() + " Extracted: " + extractedBytes);
                }
                builder.addResourceFork(baos.toByteArray());
                os = new FileOutputStream(targetFile);
                os.write(builder.getResult());
                if (os != null) {
                    try {
                        os.close();
                    } catch (Exception e2) {
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e3) {
                    }
                }
                return true;
            } catch (Throwable th) {
                if (os != null) {
                    try {
                        os.close();
                    } catch (Exception e4) {
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e7) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e8) {
                }
            }
            return false;
        } catch (Exception ioe) {
            ioe.printStackTrace();
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e9) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e10) {
                }
            }
            return false;
        }
    }

    private static String scrub(String s) {
        char[] cdata = s.toCharArray();
        for (int i2 = 0; i2 < cdata.length; i2++) {
            if ((cdata[i2] >= 0 && cdata[i2] <= 31) || cdata[i2] == 127) {
                cdata[i2] = '_';
            }
        }
        return new String(cdata);
    }

    private static void logDebug(String s) {
        if (debug) {
            System.err.println("DEBUG: " + s);
        }
    }
}
