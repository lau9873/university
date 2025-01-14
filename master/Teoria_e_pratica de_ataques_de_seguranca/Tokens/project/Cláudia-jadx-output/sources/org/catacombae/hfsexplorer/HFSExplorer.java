package org.catacombae.hfsexplorer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.catacombae.hfsexplorer.deprecated.HFSPlusFileSystemView;
import org.catacombae.hfsexplorer.fs.NullProgressMonitor;
import org.catacombae.hfsexplorer.io.ForkFilter;
import org.catacombae.hfsexplorer.partitioning.APMPartition;
import org.catacombae.hfsexplorer.types.hfsplus.BTHeaderRec;
import org.catacombae.hfsexplorer.types.hfsplus.BTNodeDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSCatalogNodeID;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFile;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogFolder;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogKey;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafNode;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecord;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogLeafRecordData;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusCatalogThread;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusForkData;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusVolumeHeader;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/HFSExplorer.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/HFSExplorer.class */
public class HFSExplorer {
    public static final String VERSION = "0.21";
    public static final String COPYRIGHT = "Copyright © Erik Larsson 2006-2008";
    private static Operation operation;
    public static final String[] NOTICES = {"This program is distributed under the GNU General Public License version 3.", "See <http://www.gnu.org/copyleft/gpl.html> for the details.", "", "Libraries used:", "    swing-layout <https://swing-layout.dev.java.net/>", "        Copyright © 2005-2006 Sun Microsystems, Inc. Licensed under", "        the Lesser General Public License.", "        See <http://www.gnu.org/licenses/lgpl.html> for the details.", "    iHarder Base64 encoder/decoder <http://iharder.sourceforge.net>", "        Public domain software.", "    Apache Ant bzip2 library <http://ant.apache.org/>", "        Copyright © the Apache Software Foundation (ASF). Licensed", "        under the Apache License, Version 2.0.", "        See <http://www.apache.org/licenses/LICENSE-2.0> for the details."};
    public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    private static Options options = new Options();
    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/HFSExplorer$Options.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/HFSExplorer$Options.class */
    public static class Options {
        public boolean readAPM;
        public boolean verbose;

        private Options() {
            this.readAPM = false;
            this.verbose = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/HFSExplorer$Operation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/HFSExplorer$Operation.class */
    public enum Operation {
        BROWSE,
        FRAGCHECK,
        TEST,
        SYSTEMFILEINFO;
        
        private String filename;
        private LinkedList<String> argsList = new LinkedList<>();

        Operation() {
        }

        public void addArg(String argument) {
            this.argsList.add(argument);
        }

        public String[] getArgs() {
            return (String[]) this.argsList.toArray(new String[this.argsList.size()]);
        }

        public String getFilename() {
            return this.argsList.getLast();
        }
    }

    public static void main(String[] args) throws IOException {
        ReadableRandomAccessStream isoRaf;
        long offset;
        long length;
        if (args.length == 0) {
            printUsageInfo();
            System.exit(0);
        }
        parseOptions(args, 0, args.length);
        if (WindowsLowLevelIO.isSystemSupported()) {
            isoRaf = new WindowsLowLevelIO(operation.getFilename());
        } else {
            isoRaf = new ReadableFileStream(operation.getFilename());
        }
        if (options.readAPM) {
            println("Reading the Apple Partition Map...");
            isoRaf.seek(512L);
            byte[] currentBlock = new byte[512];
            byte[] signature = new byte[2];
            ArrayList<APMPartition> partitions = new ArrayList<>();
            for (int i2 = 0; i2 < 20; i2++) {
                isoRaf.readFully(currentBlock);
                signature[0] = currentBlock[0];
                signature[1] = currentBlock[1];
                if (!new String(signature, "ASCII").equals("PM")) {
                    break;
                }
                print("Partition " + i2 + ": ");
                APMPartition p = new APMPartition(currentBlock, 0, 512);
                partitions.add(p);
                if (options.verbose) {
                    println();
                    p.printPartitionInfo(System.out);
                } else {
                    println("\"" + p.getPmPartNameAsString() + "\" (" + p.getPmParTypeAsString() + ")");
                }
            }
            print("Which partition do you wish to explore [0-" + (partitions.size() - 1) + "]? ");
            int partNum = Integer.parseInt(stdin.readLine());
            APMPartition chosenPartition = partitions.get(partNum);
            String partitionType = chosenPartition.getPmParTypeAsString();
            if (!partitionType.trim().equals("Apple_HFS")) {
                println("The partition is not an HFS partition!");
                System.exit(0);
            }
            println("Parsing partition " + partNum + " (" + chosenPartition.getPmPartNameAsString().trim() + "/" + partitionType.trim() + ")");
            offset = (chosenPartition.getPmPyPartStart() + chosenPartition.getPmLgDataStart()) * 512;
            length = chosenPartition.getPmDataCnt() * 512;
        } else {
            offset = 0;
            length = isoRaf.length();
        }
        if (operation == Operation.BROWSE) {
            operationBrowse(operation, isoRaf, offset, length);
        } else if (operation == Operation.FRAGCHECK) {
            operationFragCheck(operation, isoRaf, offset, length);
        } else if (operation == Operation.TEST) {
            operationTest(operation, isoRaf, offset, length);
        } else if (operation == Operation.SYSTEMFILEINFO) {
            operationSystemFileInfo(operation, isoRaf, offset, length);
        }
    }

    private static void operationTest(Operation operation2, ReadableRandomAccessStream isoRaf, long offset, long length) throws IOException {
        System.out.println("Reading partition data starting at " + offset + "...");
        byte[] currentBlock = new byte[512];
        isoRaf.seek(offset + 1024);
        isoRaf.read(currentBlock);
        HFSPlusVolumeHeader header = new HFSPlusVolumeHeader(currentBlock);
        header.print(System.out, "  ");
        long catalogFilePosition = header.getBlockSize() * header.getCatalogFile().getExtents().getExtentDescriptor(0).getStartBlock();
        long catalogFileLength = header.getBlockSize() * header.getCatalogFile().getExtents().getExtentDescriptor(0).getBlockCount();
        System.out.println("Catalog file offset: " + catalogFilePosition);
        System.out.println("Catalog file length: " + catalogFileLength + " bytes");
        System.out.println("Seeking...");
        isoRaf.seek(offset + catalogFilePosition);
        System.out.println("Current file pointer: " + isoRaf.getFilePointer());
        System.out.println("length of file: " + isoRaf.length());
        byte[] nodeDescriptorData = new byte[14];
        if (isoRaf.read(nodeDescriptorData) != nodeDescriptorData.length) {
            System.out.println("ERROR: Did not read nodeDescriptor completely.");
        }
        BTNodeDescriptor btnd = new BTNodeDescriptor(nodeDescriptorData, 0);
        btnd.print(System.out, "");
        byte[] headerRec = new byte[BTHeaderRec.length()];
        if (isoRaf.read(headerRec) != headerRec.length) {
            System.out.println("ERROR: Did not read headerRec completely.");
        }
        BTHeaderRec bthr = new BTHeaderRec(headerRec, 0);
        bthr.print(System.out, "");
        if (catalogFileLength % bthr.getNodeSize() != 0) {
            System.out.println("catalogFileLength is not aligned to node size! (" + catalogFileLength + " % " + ((int) bthr.getNodeSize()) + " = " + (catalogFileLength % bthr.getNodeSize()));
            return;
        }
        System.out.println("Number of nodes in the catalog file: " + (catalogFileLength / bthr.getNodeSize()));
        int nodeSize = bthr.getNodeSize();
        byte[] currentNode = new byte[nodeSize];
        System.out.println();
        System.out.println();
        ForkFilter catalogFile = new ForkFilter(header.getCatalogFile(), header.getCatalogFile().getExtents().getExtentDescriptors(), isoRaf, offset, header.getBlockSize(), 0L);
        HFSPlusCatalogLeafRecord[] f2 = HFSPlusFileSystemView.collectFilesInDir(new HFSCatalogNodeID(1), bthr.getRootNode(), isoRaf, offset, header, bthr, catalogFile);
        System.out.println("Found " + f2.length + " items in subroot.");
        for (HFSPlusCatalogLeafRecord rec : f2) {
            System.out.print("  \"" + rec.getKey().getNodeName().toString() + "\"");
            HFSPlusCatalogLeafRecordData data = rec.getData();
            if (data.getRecordType() == 1 && (data instanceof HFSPlusCatalogFolder)) {
                HFSPlusCatalogFolder folderData = (HFSPlusCatalogFolder) data;
                System.out.println(" (dir, id: " + folderData.getFolderID().toInt() + ")");
                HFSPlusCatalogLeafRecord[] f22 = HFSPlusFileSystemView.collectFilesInDir(folderData.getFolderID(), bthr.getRootNode(), isoRaf, offset, header, bthr, catalogFile);
                System.out.println("  Found " + f22.length + " items in " + rec.getKey().getNodeName().toString() + ".");
                for (HFSPlusCatalogLeafRecord rec2 : f22) {
                    System.out.println("    \"" + rec2.getKey().getNodeName() + "\"");
                }
            } else if (data.getRecordType() == 2 && (data instanceof HFSPlusCatalogFile)) {
                HFSPlusCatalogFile fileData = (HFSPlusCatalogFile) data;
                System.out.println(" (file, id: " + fileData.getFileID().toInt() + ")");
            } else if (data.getRecordType() == 3 && (data instanceof HFSPlusCatalogThread)) {
                System.out.println(" (folder thread)");
            } else if (data.getRecordType() == 4 && (data instanceof HFSPlusCatalogThread)) {
                System.out.println(" (file thread)");
            } else {
                System.out.println(" (ENCOUNTERED UNKNOWN DATA. record type: " + ((int) data.getRecordType()) + " rec: " + rec + ")");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Reading node by node...");
        isoRaf.seek(offset + catalogFilePosition);
        int nodeNumber = 0;
        int bytesRead = nodeSize;
        while ((isoRaf.getFilePointer() - catalogFilePosition) + nodeSize <= catalogFileLength) {
            System.out.println("Reading node " + nodeNumber + "...");
            isoRaf.readFully(currentNode);
            bytesRead += nodeSize;
            BTNodeDescriptor nodeDescriptor = new BTNodeDescriptor(currentNode, 0);
            System.out.println("  Kind: " + nodeDescriptor.getKindAsString());
            System.out.println("  Number of records: " + ((int) nodeDescriptor.getNumRecords()));
            short[] offsets = new short[nodeDescriptor.getNumRecords()];
            for (int i2 = 0; i2 < offsets.length; i2++) {
                offsets[i2] = Util.readShortBE(currentNode, currentNode.length - ((i2 + 1) * 2));
            }
            for (int i3 = 0; i3 < offsets.length; i3++) {
                int currentOffset = Util.unsign(offsets[i3]);
                if (i3 < offsets.length - 1 && nodeDescriptor.getKind() != 1) {
                    HFSPlusCatalogKey currentKey = new HFSPlusCatalogKey(currentNode, currentOffset);
                    if (nodeDescriptor.getKind() == -1) {
                        System.out.println("  [" + nodeNumber + "]  Key: " + ((int) currentKey.getKeyLength()) + ", " + currentKey.getParentID().toString() + ", \"" + currentKey.getNodeName().toString() + "\"");
                        short recordType = Util.readShortBE(currentNode, currentOffset + currentKey.length());
                        System.out.print("  [" + nodeNumber + "]   Record type: ");
                        if (recordType == 1) {
                            System.out.print("kHFSPlusFolderRecord");
                        } else if (recordType == 2) {
                            System.out.print("kHFSPlusFileRecord");
                        } else if (recordType == 3) {
                            System.out.print("kHFSPlusFolderThreadRecord");
                        } else if (recordType == 4) {
                            System.out.print("kHFSPlusFileThreadRecord");
                        } else {
                            System.out.print("UNKNOWN! (" + ((int) recordType) + ")");
                        }
                        System.out.println();
                        if (recordType == 1) {
                            HFSPlusCatalogFolder folderRec = new HFSPlusCatalogFolder(currentNode, currentOffset + currentKey.length());
                            System.out.println("  [" + nodeNumber + "]   Node ID: " + folderRec.getFolderID());
                            System.out.println("  [" + nodeNumber + "]   Valence: " + folderRec.getValence());
                        } else if (recordType == 2) {
                            HFSPlusCatalogFile fileRec = new HFSPlusCatalogFile(currentNode, currentOffset + currentKey.length());
                            System.out.println("  [" + nodeNumber + "]   Node ID: " + fileRec.getFileID());
                        } else if (recordType == 3) {
                            new HFSPlusCatalogThread(currentNode, currentOffset + currentKey.length());
                        } else if (recordType == 4) {
                            new HFSPlusCatalogThread(currentNode, currentOffset + currentKey.length());
                        }
                    } else if (nodeDescriptor.getKind() == 0) {
                        System.out.println("  [" + nodeNumber + "]    \"" + currentKey.getNodeName().toString() + "\" (parent: " + currentKey.getParentID() + ") -> " + Util.unsign(Util.readIntBE(currentNode, currentOffset + currentKey.length())));
                    }
                }
            }
            System.out.print("Press enter to read next node (q and enter to exit)...");
            if (stdIn.readLine().trim().equalsIgnoreCase("q")) {
                return;
            }
            nodeNumber++;
        }
        System.out.println("FP: " + isoRaf.getFilePointer() + " diff: " + (isoRaf.getFilePointer() - catalogFilePosition) + " (catalogFileLength: " + catalogFileLength + ")");
        System.out.println("bytesRead: " + bytesRead + " nodeSize: " + nodeSize + " number of nodes: " + (catalogFileLength / nodeSize));
        System.out.println("Nodes read: " + nodeNumber);
    }

    public static void operationBrowse(Operation op, ReadableRandomAccessStream hfsFile, long fsOffset, long fsLength) {
        HFSPlusFileSystemView fsView = new HFSPlusFileSystemView(hfsFile, fsOffset);
        HFSPlusCatalogLeafRecord rootRecord = fsView.getRoot();
        HFSPlusCatalogLeafRecord currentDir = rootRecord;
        LinkedList<String> pathStack = new LinkedList<>();
        LinkedList<HFSPlusCatalogLeafRecord> pathThread = new LinkedList<>();
        pathStack.addLast("");
        BufferedReader stdIn2 = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            HFSPlusCatalogThread currentThread = null;
            StringBuilder currentPath = new StringBuilder();
            Iterator i$ = pathStack.iterator();
            while (i$.hasNext()) {
                String pathComponent = i$.next();
                currentPath.append(pathComponent);
                currentPath.append("/");
            }
            println("Listing files in \"" + currentPath.toString() + "\":");
            boolean atLeastOneNonThreadEntryFound = false;
            HFSPlusCatalogLeafRecord[] recordsInDir = fsView.listRecords(currentDir);
            for (HFSPlusCatalogLeafRecord rec : recordsInDir) {
                HFSPlusCatalogLeafRecordData recData = rec.getData();
                if (recData.getRecordType() == 2 && (recData instanceof HFSPlusCatalogFile)) {
                    HFSPlusCatalogFile catFile = (HFSPlusCatalogFile) recData;
                    println("  [" + catFile.getFileID() + "] \"" + rec.getKey().getNodeName() + "\" (" + catFile.getDataFork().getLogicalSize() + " B)");
                    if (!atLeastOneNonThreadEntryFound) {
                        atLeastOneNonThreadEntryFound = true;
                    }
                } else if (recData.getRecordType() == 1 && (recData instanceof HFSPlusCatalogFolder)) {
                    HFSPlusCatalogFolder catFolder = (HFSPlusCatalogFolder) recData;
                    println("  [" + catFolder.getFolderID() + "] \"" + rec.getKey().getNodeName() + "/\"");
                    if (!atLeastOneNonThreadEntryFound) {
                        atLeastOneNonThreadEntryFound = true;
                    }
                } else if (recData.getRecordType() == 3 && (recData instanceof HFSPlusCatalogThread)) {
                    HFSPlusCatalogThread catThread = (HFSPlusCatalogThread) recData;
                    println("  [Folder Thread: [" + catThread.getParentID() + "] \"" + catThread.getNodeName() + "\"]");
                    if (currentThread == null) {
                        currentThread = catThread;
                    } else {
                        println("WARNING: Found more than one folder thread in " + ((Object) currentPath) + "!");
                    }
                } else if (recData.getRecordType() == 4 && (recData instanceof HFSPlusCatalogThread)) {
                    HFSPlusCatalogThread catThread2 = (HFSPlusCatalogThread) recData;
                    println("  [File Thread: [" + catThread2.getParentID() + "] \"" + catThread2.getNodeName() + "\"]");
                }
            }
            if (currentThread == null && atLeastOneNonThreadEntryFound) {
                println("WARNING: Found no folder thread in " + ((Object) currentPath) + "! Won't be able to go back from children in hierarchy.");
            }
            while (true) {
                print("Command[?]: ");
                try {
                    String input = stdIn2.readLine().trim();
                    if (input.equalsIgnoreCase("?")) {
                        println("Available commands:");
                        println(" ls                List contents of current directory");
                        println(" cd <dirName>      Changes directory by name");
                        println(" cdn <dirID>       Changes directory by ID");
                        println(" info <fileID>     Gets extensive information about the file.");
                        println(" extract <fileID>  Extracts <fileID> to current directory");
                        println(" q                 Quits program");
                    } else if (input.equals("q")) {
                        return;
                    } else {
                        if (!input.equals("ls")) {
                            if (input.startsWith("extract ")) {
                                try {
                                    long nextID = Long.parseLong(input.substring("extract ".length()).trim());
                                    HFSPlusCatalogLeafRecord selectedFileRecord = null;
                                    int len$ = recordsInDir.length;
                                    int i$2 = 0;
                                    while (true) {
                                        if (i$2 >= len$) {
                                            break;
                                        }
                                        HFSPlusCatalogLeafRecord rec2 = recordsInDir[i$2];
                                        HFSPlusCatalogLeafRecordData recData2 = rec2.getData();
                                        if (recData2.getRecordType() == 2 && (recData2 instanceof HFSPlusCatalogFile)) {
                                            HFSPlusCatalogFile catFile2 = (HFSPlusCatalogFile) recData2;
                                            if (Util.unsign(catFile2.getFileID().toInt()) == nextID) {
                                                selectedFileRecord = rec2;
                                                HFSPlusCatalogFile hFSPlusCatalogFile = (HFSPlusCatalogFile) recData2;
                                                break;
                                            }
                                        }
                                        i$2++;
                                    }
                                    if (selectedFileRecord == null) {
                                        println("ID not present in dir.");
                                    } else {
                                        String dataForkFilename = selectedFileRecord.getKey().getNodeName().toString();
                                        FileOutputStream dataOut = new FileOutputStream(dataForkFilename);
                                        print("Extracting data fork to file \"" + dataForkFilename + "\"...");
                                        try {
                                            long bytesExtracted = fsView.extractDataForkToStream(selectedFileRecord, dataOut, NullProgressMonitor.getInstance());
                                            println("extracted " + bytesExtracted + " bytes.");
                                            dataOut.close();
                                            String resourceForkFilename = dataForkFilename + ".resourcefork";
                                            FileOutputStream resourceOut = new FileOutputStream(resourceForkFilename);
                                            print("Extracting resource fork to file \"" + resourceForkFilename + "\"...");
                                            try {
                                                long bytesExtracted2 = fsView.extractResourceForkToStream(selectedFileRecord, resourceOut, NullProgressMonitor.getInstance());
                                                println("extracted " + bytesExtracted2 + " bytes.");
                                                resourceOut.close();
                                            } catch (IOException ioe) {
                                                ioe.printStackTrace();
                                                try {
                                                    dataOut.close();
                                                } catch (IOException e2) {
                                                }
                                            }
                                        } catch (IOException ioe2) {
                                            ioe2.printStackTrace();
                                            try {
                                                dataOut.close();
                                            } catch (IOException e3) {
                                            }
                                        }
                                    }
                                } catch (FileNotFoundException fnfe) {
                                    fnfe.printStackTrace();
                                } catch (NumberFormatException e4) {
                                    println("Invalid input!");
                                }
                            } else if (input.startsWith("info ")) {
                                try {
                                    long nextID2 = Long.parseLong(input.substring("info ".length()).trim());
                                    HFSPlusCatalogLeafRecord selectedFileRecord2 = null;
                                    int len$2 = recordsInDir.length;
                                    int i$3 = 0;
                                    while (true) {
                                        if (i$3 >= len$2) {
                                            break;
                                        }
                                        HFSPlusCatalogLeafRecord rec3 = recordsInDir[i$3];
                                        HFSPlusCatalogLeafRecordData recData3 = rec3.getData();
                                        if (recData3.getRecordType() == 2 && (recData3 instanceof HFSPlusCatalogFile)) {
                                            HFSPlusCatalogFile catFile3 = (HFSPlusCatalogFile) recData3;
                                            if (Util.unsign(catFile3.getFileID().toInt()) == nextID2) {
                                                selectedFileRecord2 = rec3;
                                                rec3.print(System.out, "");
                                                break;
                                            }
                                        }
                                        i$3++;
                                    }
                                    if (selectedFileRecord2 == null) {
                                        println("ID not present in dir.");
                                    }
                                } catch (NumberFormatException e5) {
                                    println("Invalid input!");
                                }
                            } else if (input.startsWith("cdn ")) {
                                String input2 = input.substring("cdn ".length()).trim();
                                if (input2.equals("..")) {
                                    println("Not yet implemented.");
                                } else {
                                    try {
                                        long nextID3 = Long.parseLong(input2);
                                        HFSPlusCatalogLeafRecord nextDir = null;
                                        int len$3 = recordsInDir.length;
                                        int i$4 = 0;
                                        while (true) {
                                            if (i$4 >= len$3) {
                                                break;
                                            }
                                            HFSPlusCatalogLeafRecord rec4 = recordsInDir[i$4];
                                            HFSPlusCatalogLeafRecordData recData4 = rec4.getData();
                                            if (recData4.getRecordType() == 1 && (recData4 instanceof HFSPlusCatalogFolder)) {
                                                HFSPlusCatalogFolder catFolder2 = (HFSPlusCatalogFolder) recData4;
                                                if (Util.unsign(catFolder2.getFolderID().toInt()) == nextID3) {
                                                    nextDir = rec4;
                                                    break;
                                                }
                                            }
                                            i$4++;
                                        }
                                        if (nextDir == null) {
                                            println("ID not present in dir.");
                                        } else {
                                            pathStack.addLast(nextDir.getKey().getNodeName().toString());
                                            pathThread.addLast(currentDir);
                                            currentDir = nextDir;
                                            break;
                                        }
                                    } catch (Exception e6) {
                                        println("Invalid input!");
                                    }
                                }
                            } else if (input.startsWith("cd ")) {
                                String input3 = input.substring("cd ".length());
                                if (input3.equals("..")) {
                                    pathStack.removeLast();
                                    currentDir = pathThread.removeLast();
                                    break;
                                }
                                try {
                                    HFSPlusCatalogLeafRecord nextDir2 = null;
                                    int len$4 = recordsInDir.length;
                                    int i$5 = 0;
                                    while (true) {
                                        if (i$5 >= len$4) {
                                            break;
                                        }
                                        HFSPlusCatalogLeafRecord rec5 = recordsInDir[i$5];
                                        HFSPlusCatalogLeafRecordData recData5 = rec5.getData();
                                        if (recData5.getRecordType() != 1 || !(recData5 instanceof HFSPlusCatalogFolder) || !rec5.getKey().getNodeName().toString().equals(input3)) {
                                            i$5++;
                                        } else {
                                            nextDir2 = rec5;
                                            HFSPlusCatalogFolder hFSPlusCatalogFolder = (HFSPlusCatalogFolder) recData5;
                                            break;
                                        }
                                    }
                                    if (nextDir2 == null) {
                                        println("Unknown directory.");
                                    } else {
                                        pathStack.addLast(nextDir2.getKey().getNodeName().toString());
                                        pathThread.addLast(currentDir);
                                        currentDir = nextDir2;
                                        break;
                                    }
                                } catch (Exception e7) {
                                    println("Invalid input!");
                                }
                            } else {
                                println("Unknown command.");
                            }
                        }
                    }
                } catch (IOException ioe3) {
                    ioe3.printStackTrace();
                    return;
                }
            }
            println();
        }
    }

    private static void operationFragCheck(Operation op, ReadableRandomAccessStream hfsFile, long fsOffset, long fsLength) {
        println("Gathering information about the files on the volume...");
        ArrayList<Pair<HFSPlusCatalogLeafRecord, Integer>> mostFragmentedList = new ArrayList<>(11);
        HFSPlusFileSystemView fsView = new HFSPlusFileSystemView(hfsFile, fsOffset);
        HFSPlusCatalogLeafRecord rootRecord = fsView.getRoot();
        recursiveFragmentSearch(fsView, rootRecord, mostFragmentedList, 10, options.verbose);
        if (!options.verbose) {
            println();
        }
        println("Most fragmented files: ");
        Iterator i$ = mostFragmentedList.iterator();
        while (i$.hasNext()) {
            Pair<HFSPlusCatalogLeafRecord, Integer> phi = i$.next();
            println(phi.f7639b + " - \"" + ((HFSPlusCatalogLeafRecord) phi.f7638a).getKey().getNodeName() + "\"");
        }
    }

    private static void recursiveFragmentSearch(HFSPlusFileSystemView fsView, HFSPlusCatalogLeafRecord currentDir, ArrayList<Pair<HFSPlusCatalogLeafRecord, Integer>> mostFragmentedList, int listMaxLength, boolean verbose) {
        HFSPlusCatalogLeafRecord[] arr$ = fsView.listRecords(currentDir);
        for (HFSPlusCatalogLeafRecord rec : arr$) {
            HFSPlusCatalogLeafRecordData recData = rec.getData();
            if (recData.getRecordType() == 2 && (recData instanceof HFSPlusCatalogFile)) {
                HFSPlusCatalogFile hFSPlusCatalogFile = (HFSPlusCatalogFile) recData;
                HFSPlusExtentDescriptor[] descs = fsView.getAllDataExtentDescriptors(rec);
                mostFragmentedList.add(new Pair<>(rec, Integer.valueOf(descs.length)));
                for (int i2 = mostFragmentedList.size() - 1; i2 > 0; i2--) {
                    Pair<HFSPlusCatalogLeafRecord, Integer> lower = mostFragmentedList.get(i2);
                    Pair<HFSPlusCatalogLeafRecord, Integer> higher = mostFragmentedList.get(i2 - 1);
                    if (lower.f7639b.intValue() <= higher.f7639b.intValue()) {
                        break;
                    }
                    mostFragmentedList.set(i2 - 1, lower);
                    mostFragmentedList.set(i2, higher);
                }
                while (mostFragmentedList.size() > listMaxLength) {
                    mostFragmentedList.remove(mostFragmentedList.size() - 1);
                }
            } else if (recData.getRecordType() == 1 && (recData instanceof HFSPlusCatalogFolder)) {
                HFSPlusCatalogFolder hFSPlusCatalogFolder = (HFSPlusCatalogFolder) recData;
                if (verbose) {
                    println("  Processing folder \"" + rec.getKey().getNodeName().toString() + "\"");
                } else {
                    print(".");
                }
                recursiveFragmentSearch(fsView, rec, mostFragmentedList, listMaxLength, verbose);
            } else if (recData.getRecordType() == 3 && (recData instanceof HFSPlusCatalogThread)) {
                HFSPlusCatalogThread hFSPlusCatalogThread = (HFSPlusCatalogThread) recData;
            } else if (recData.getRecordType() == 4 && (recData instanceof HFSPlusCatalogThread)) {
                HFSPlusCatalogThread hFSPlusCatalogThread2 = (HFSPlusCatalogThread) recData;
            }
        }
    }

    private static void operationSystemFileInfo(Operation op, ReadableRandomAccessStream hfsFile, long fsOffset, long fsLength) {
        HFSPlusFileSystemView fsView = new HFSPlusFileSystemView(hfsFile, fsOffset);
        HFSPlusVolumeHeader header = fsView.getVolumeHeader();
        header.getBlockSize();
        HFSCatalogNodeID[] ids = {HFSCatalogNodeID.kHFSAllocationFileID, HFSCatalogNodeID.kHFSExtentsFileID, HFSCatalogNodeID.kHFSCatalogFileID, HFSCatalogNodeID.kHFSAttributesFileID, HFSCatalogNodeID.kHFSStartupFileID};
        HFSPlusForkData[] intrestingFiles = {header.getAllocationFile(), header.getExtentsFile(), header.getCatalogFile(), header.getAttributesFile(), header.getStartupFile()};
        for (HFSPlusForkData f2 : intrestingFiles) {
            f2.print(System.out, "");
        }
        String[] labels = {"Allocation file", "Extents file", "Catalog file", "Attributes file", "Startup file"};
        for (int i2 = 0; i2 < intrestingFiles.length; i2++) {
            System.out.println(labels[i2] + ":");
            HFSPlusForkData currentFile = intrestingFiles[i2];
            long basicExtentsBlockCount = 0;
            HFSPlusExtentDescriptor[] basicExtents = currentFile.getExtents().getExtentDescriptors();
            long numberOfExtents = 0;
            for (HFSPlusExtentDescriptor cur : basicExtents) {
                if (cur.getStartBlock() == 0 && cur.getBlockCount() == 0) {
                    break;
                }
                basicExtentsBlockCount += Util.unsign(cur.getBlockCount());
                numberOfExtents++;
            }
            if (basicExtentsBlockCount == currentFile.getTotalBlocks()) {
                System.out.println("  Number of extents: " + numberOfExtents + " (all in basic)");
            } else {
                HFSCatalogNodeID currentID = ids[i2];
                if (currentID == HFSCatalogNodeID.kHFSExtentsFileID) {
                    System.out.println("  OVERFLOW IN EXTENTS OVERFLOW FILE!!");
                } else {
                    HFSPlusExtentDescriptor[] allDescriptors = fsView.getAllDataExtentDescriptors(currentID, currentFile);
                    System.out.println("  Number of extents: " + allDescriptors.length + " (overflowed)");
                }
            }
        }
    }

    public static void printUsageInfo() {
        println("HFSExplorer v0.21 Build #1081");
        println("Copyright © Erik Larsson 2006-2008");
        println("  displays information about an HFS filesystem.");
        println("  usage: java HFSExplorer [common options] <verb> [verb options] <file/device>");
        println();
        println("  Common options:");
        println("    -apm  Specifies that the HFS partition is embedded within an Apple");
        println("          Partition Map. The user will be allowed to choose which partition in");
        println("          the map to attempt reading.");
        println("    -v    Verbose operation.");
        println();
        println("  Verbs:");
        println("    browse  Launches a mode where the user can browse the files in a HFS+ file");
        println("            system.");
        println("    chfrag  Lists the 10 most fragmented files of the volume.");
        println("    test    Launches a test mode for extensive exploration of file system");
        println("            structures. Only for debugging purposes.");
        println();
        println("  Verb options:");
        println("    <none defined>");
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void vprintln() {
        if (options.verbose) {
            System.out.println();
        }
    }

    public static void vprintln(String s) {
        if (options.verbose) {
            System.out.println(s);
        }
    }

    public static void vprint(String s) {
        if (options.verbose) {
            System.out.print(s);
        }
    }

    public static void parseOptions(String[] arguments, int offset, int length) {
        String currentArg = null;
        int i2 = offset;
        while (i2 < length) {
            currentArg = arguments[i2];
            if (!currentArg.startsWith("-")) {
                break;
            }
            if (currentArg.equals("-apm")) {
                options.readAPM = true;
            } else if (currentArg.equals("-v")) {
                options.verbose = true;
            } else {
                println("\"" + currentArg + "\" is not a valid parameter.");
            }
            i2++;
        }
        if (currentArg.equals("browse")) {
            operation = Operation.BROWSE;
        } else if (currentArg.equals("chfrag")) {
            operation = Operation.FRAGCHECK;
        } else if (currentArg.equals("test")) {
            operation = Operation.TEST;
        } else if (currentArg.equals("systemfileinfo")) {
            operation = Operation.SYSTEMFILEINFO;
        }
        while (true) {
            i2++;
            if (i2 < length) {
                operation.addArg(arguments[i2]);
            } else {
                return;
            }
        }
    }

    public static HFSPlusCatalogFile findFileID(HFSPlusCatalogLeafNode leafNode, HFSCatalogNodeID nodeID) {
        HFSPlusCatalogLeafRecord[] records = leafNode.getLeafRecords();
        for (HFSPlusCatalogLeafRecord curRec : records) {
            HFSPlusCatalogLeafRecordData curRecData = curRec.getData();
            if ((curRecData instanceof HFSPlusCatalogFile) && ((HFSPlusCatalogFile) curRecData).getFileID().toInt() == nodeID.toInt()) {
                return (HFSPlusCatalogFile) curRecData;
            }
        }
        return null;
    }

    public static HFSPlusCatalogFolder findFolderID(HFSPlusCatalogLeafNode leafNode, HFSCatalogNodeID nodeID) {
        HFSPlusCatalogLeafRecord[] records = leafNode.getLeafRecords();
        for (HFSPlusCatalogLeafRecord curRec : records) {
            HFSPlusCatalogLeafRecordData curRecData = curRec.getData();
            if ((curRecData instanceof HFSPlusCatalogFolder) && ((HFSPlusCatalogFolder) curRecData).getFolderID().toInt() == nodeID.toInt()) {
                return (HFSPlusCatalogFolder) curRecData;
            }
        }
        return null;
    }
}
