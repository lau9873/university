package org.catacombae.hfsexplorer;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import org.catacombae.dmgextractor.encodings.encrypted.ReadableCEncryptedEncodingStream;
import org.catacombae.dmgextractor.ui.PasswordDialog;
import org.catacombae.hfsexplorer.ExtractProgressMonitor;
import org.catacombae.hfsexplorer.FileSystemBrowser;
import org.catacombae.hfsexplorer.MacSpecific;
import org.catacombae.hfsexplorer.fs.AppleSingleBuilder;
import org.catacombae.hfsexplorer.fs.ProgressMonitor;
import org.catacombae.hfsexplorer.gui.ErrorSummaryPanel;
import org.catacombae.hfsexplorer.gui.FileOperationsPanel;
import org.catacombae.hfsexplorer.gui.MemoryStatisticsPanel;
import org.catacombae.hfsexplorer.helpbrowser.HelpBrowserPanel;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableConcatenatedStream;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.fs.FSEntry;
import org.catacombae.jparted.lib.fs.FSFile;
import org.catacombae.jparted.lib.fs.FSFolder;
import org.catacombae.jparted.lib.fs.FSFork;
import org.catacombae.jparted.lib.fs.FSForkType;
import org.catacombae.jparted.lib.fs.FSLink;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFileSystemHandler;
import org.catacombae.udif.UDIFRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow.class */
public class FileSystemBrowserWindow extends JFrame {
    private static final String TITLE_STRING = "HFSExplorer 0.21";
    private static final ImageIcon[] WINDOW_ICONS = {new ImageIcon(ClassLoader.getSystemResource("res/finderdrive_folderback_16.png")), new ImageIcon(ClassLoader.getSystemResource("res/finderdrive_folderback_32.png")), new ImageIcon(ClassLoader.getSystemResource("res/finderdrive_folderback_48.png"))};
    private static final String[] VERSION_INFO_DICTIONARY = {"http://www.typhontools.cjb.net/hfsx/version.sdic.txt", "http://hem.bredband.net/unsound/hfsx/version.sdic.txt"};
    private static final String DEBUG_CONSOLE_ARG = "-dbgconsole";
    private FileSystemBrowser<FSEntry> fsb;
    private JCheckBoxMenuItem toggleCachingItem;
    private final LinkedList<File> tempFiles;
    private final JFileChooser fileChooser;
    private final DebugConsoleWindow dcw;
    private HFSCommonFileSystemHandler fsHandler;
    private DataLocator fsDataLocator;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$TreeVisitor.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$TreeVisitor.class */
    public interface TreeVisitor {
        boolean startDirectory(String[] strArr, FSFolder fSFolder);

        void endDirectory(String[] strArr, FSFolder fSFolder);

        void file(FSFile fSFile);

        void link(FSLink fSLink);

        void traversalError(String str);

        boolean cancelTraversal();
    }

    public FileSystemBrowserWindow() {
        this(null);
    }

    public FileSystemBrowserWindow(DebugConsoleWindow dcw) {
        super("HFSExplorer 0.21");
        this.tempFiles = new LinkedList<>();
        this.fileChooser = new JFileChooser();
        this.fsHandler = null;
        this.dcw = dcw;
        if (Java6Util.isJava6OrHigher()) {
            Java6Specific.setIconImages(WINDOW_ICONS, this);
        } else {
            setIconImage(WINDOW_ICONS[0].getImage());
        }
        this.fsb = new FileSystemBrowser<>(new FileSystemProvider());
        setUpMenus();
        if (System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
            MacSpecific.registerMacApplicationHandler(new MacSpecific.MacApplicationHandler() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.1
                @Override // org.catacombae.hfsexplorer.MacSpecific.MacApplicationHandler
                public boolean acceptQuit() {
                    FileSystemBrowserWindow.this.exitApplication();
                    return false;
                }

                @Override // org.catacombae.hfsexplorer.MacSpecific.MacApplicationHandler
                public void showAboutDialog() {
                    FileSystemBrowserWindow.this.actionShowAboutDialog();
                }
            });
        }
        addWindowListener(new WindowAdapter() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.2
            public void windowClosing(WindowEvent we) {
                FileSystemBrowserWindow.this.exitApplication();
            }
        });
        setDefaultCloseOperation(0);
        add(this.fsb.getViewComponent(), "Center");
        pack();
        setLocationRelativeTo(null);
    }

    private void setUpMenus() {
        JMenuItem loadFSFromDeviceItem = null;
        if (WindowsLowLevelIO.isSystemSupported()) {
            loadFSFromDeviceItem = new JMenuItem("Load file system from device...");
            loadFSFromDeviceItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.3
                public void actionPerformed(ActionEvent ae) {
                    SelectWindowsDeviceDialog deviceDialog = new SelectWindowsDeviceDialog(FileSystemBrowserWindow.this, true, "Load file system from device");
                    deviceDialog.setVisible(true);
                    ReadableRandomAccessStream io2 = deviceDialog.getPartitionStream();
                    String pathName = deviceDialog.getPathName();
                    if (io2 != null) {
                        try {
                            FileSystemBrowserWindow.this.loadFS(io2, pathName);
                        } catch (Exception e2) {
                            System.err.print("INFO: Non-critical exception when trying to load file system from \"" + pathName + "\": ");
                            e2.printStackTrace();
                            JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Could not find any file systems on device!", "Error", 0);
                        }
                    }
                }
            });
            loadFSFromDeviceItem.setAccelerator(KeyStroke.getKeyStroke(76, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        }
        JMenuItem openUDIFItem = new JMenuItem("Load file system from file...");
        openUDIFItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.4
            public void actionPerformed(ActionEvent ae) {
                FileSystemBrowserWindow.this.fileChooser.setMultiSelectionEnabled(false);
                FileSystemBrowserWindow.this.fileChooser.setFileSelectionMode(0);
                SimpleFileFilter dmgFilter = new SimpleFileFilter();
                dmgFilter.addExtension("dmg");
                dmgFilter.setDescription("Mac OS X disk images (*.dmg)");
                FileSystemBrowserWindow.this.fileChooser.addChoosableFileFilter(dmgFilter);
                SimpleFileFilter cdrFilter = new SimpleFileFilter();
                cdrFilter.addExtension("iso");
                cdrFilter.addExtension("cdr");
                cdrFilter.setDescription("CD/DVD image (*.iso,*.cdr)");
                FileSystemBrowserWindow.this.fileChooser.addChoosableFileFilter(cdrFilter);
                SimpleFileFilter imgFilter = new SimpleFileFilter();
                imgFilter.addExtension("img");
                imgFilter.setDescription("Raw disk image (*.img)");
                FileSystemBrowserWindow.this.fileChooser.addChoosableFileFilter(imgFilter);
                FileSystemBrowserWindow.this.fileChooser.setFileFilter(FileSystemBrowserWindow.this.fileChooser.getAcceptAllFileFilter());
                int res = FileSystemBrowserWindow.this.fileChooser.showOpenDialog(FileSystemBrowserWindow.this);
                if (res == 0) {
                    try {
                        File selectedFile = FileSystemBrowserWindow.this.fileChooser.getSelectedFile();
                        String pathName = selectedFile.getCanonicalPath();
                        FileSystemBrowserWindow.this.loadFSWithUDIFAutodetect(pathName);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                        JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Count not resolve pathname!", "Error", 0);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Could not read contents of partition!", "Error", 0);
                    }
                }
                FileSystemBrowserWindow.this.fileChooser.resetChoosableFileFilters();
            }
        });
        openUDIFItem.setAccelerator(KeyStroke.getKeyStroke(79, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        JMenuItem loadFromPathItem = new JMenuItem("Load file system from path...");
        loadFromPathItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.5
            public void actionPerformed(ActionEvent ae) {
                String path = JOptionPane.showInputDialog(FileSystemBrowserWindow.this, "Pathname to load:", "Load file system from path", 3);
                if (path != null) {
                    try {
                        FileSystemBrowserWindow.this.loadFSWithUDIFAutodetect(path);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Could not read contents of partition!", "Error", 0);
                    }
                }
            }
        });
        loadFromPathItem.setAccelerator(KeyStroke.getKeyStroke(80, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        JMenuItem debugConsoleItem = null;
        if (this.dcw != null) {
            debugConsoleItem = new JMenuItem("Debug console");
            debugConsoleItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.6
                public void actionPerformed(ActionEvent ae) {
                    FileSystemBrowserWindow.this.dcw.setVisible(true);
                }
            });
        }
        JMenuItem exitProgramItem = null;
        if (!System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
            exitProgramItem = new JMenuItem("Exit");
            exitProgramItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.7
                public void actionPerformed(ActionEvent ae) {
                    FileSystemBrowserWindow.this.exitApplication();
                }
            });
            exitProgramItem.setAccelerator(KeyStroke.getKeyStroke(81, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        }
        JMenuItem fsInfoItem = new JMenuItem("File system info");
        fsInfoItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.8
            public void actionPerformed(ActionEvent ae) {
                if (FileSystemBrowserWindow.this.ensureFileSystemLoaded()) {
                    VolumeInfoWindow infoWindow = new VolumeInfoWindow(FileSystemBrowserWindow.this.fsHandler.getFSView());
                    infoWindow.setVisible(true);
                    CommonHFSVolumeHeader cvh = FileSystemBrowserWindow.this.fsHandler.getFSView().getVolumeHeader();
                    if (cvh instanceof CommonHFSVolumeHeader.HFSPlusImplementation) {
                        ((CommonHFSVolumeHeader.HFSPlusImplementation) cvh).getUnderlying();
                    }
                }
            }
        });
        fsInfoItem.setAccelerator(KeyStroke.getKeyStroke(73, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        this.toggleCachingItem = new JCheckBoxMenuItem("Use file system caching");
        this.toggleCachingItem.setState(true);
        this.toggleCachingItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.9
            public void actionPerformed(ActionEvent ae) {
                if (FileSystemBrowserWindow.this.fsHandler != null) {
                    if (FileSystemBrowserWindow.this.toggleCachingItem.getState()) {
                        System.out.print("Enabling caching...");
                        FileSystemBrowserWindow.this.fsHandler.getFSView().enableFileSystemCaching();
                        System.out.println("done!");
                        return;
                    }
                    System.out.print("Disabling caching...");
                    FileSystemBrowserWindow.this.fsHandler.getFSView().disableFileSystemCaching();
                    System.out.println("done!");
                }
            }
        });
        JMenuItem memoryStatisticsItem = new JMenuItem("Memory statistics");
        memoryStatisticsItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.10
            public void actionPerformed(ActionEvent ae) {
                MemoryStatisticsPanel.createMemoryStatisticsWindow().setVisible(true);
            }
        });
        JMenuItem createDiskImageItem = new JMenuItem("Create disk image...");
        createDiskImageItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.11
            public void actionPerformed(ActionEvent ae) {
                if (FileSystemBrowserWindow.this.ensureFileSystemLoaded()) {
                    FileSystemBrowserWindow.this.actionExtractToDiskImage();
                }
            }
        });
        JMenuItem startHelpBrowserItem = new JMenuItem("Help browser");
        startHelpBrowserItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.12
            public void actionPerformed(ActionEvent ae) {
                File f2 = new File("doc/html/index.html");
                if (f2.exists()) {
                    try {
                        HelpBrowserPanel.showHelpBrowserWindow("HFSExplorer help browser", f2.toURI().toURL());
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(FileSystemBrowserWindow.class.getName()).log(Level.WARNING, (String) null, (Throwable) ex);
                    }
                }
            }
        });
        JMenuItem checkUpdatesItem = new JMenuItem("Check for updates...");
        checkUpdatesItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.13
            public void actionPerformed(ActionEvent ae) {
                String[] arr$ = FileSystemBrowserWindow.VERSION_INFO_DICTIONARY;
                for (String s : arr$) {
                    try {
                        System.out.println("Retrieving version info from " + s + "...");
                        InputStream infoDictStream = new URL(s).openStream();
                        SimpleDictionaryParser sdp = new SimpleDictionaryParser(infoDictStream);
                        String dictVersion = sdp.getValue("Version");
                        long dictBuildNumber = Long.parseLong(sdp.getValue("Build"));
                        System.out.println("  Version: " + dictVersion);
                        System.out.println("  Build number: " + dictBuildNumber);
                        boolean dictVersionIsHigher = dictBuildNumber > 1081;
                        if (dictVersionIsHigher) {
                            JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "There are updates available!\nLatest version is: " + dictVersion + " (build number #" + dictBuildNumber + ")", "Information", 1);
                            return;
                        } else {
                            JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "There are no updates available.", "Information", 1);
                            return;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Could not contact version URL.", "Error", 0);
            }
        });
        JMenuItem aboutItem = null;
        if (!System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
            aboutItem = new JMenuItem("About...");
            aboutItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.14
                public void actionPerformed(ActionEvent ae) {
                    FileSystemBrowserWindow.this.actionShowAboutDialog();
                }
            });
        }
        JMenu fileMenu = new JMenu("File");
        JMenu infoMenu = new JMenu("Tools");
        JMenu helpMenu = new JMenu("Help");
        if (loadFSFromDeviceItem != null) {
            fileMenu.add(loadFSFromDeviceItem);
        }
        fileMenu.add(openUDIFItem);
        fileMenu.add(loadFromPathItem);
        if (debugConsoleItem != null) {
            fileMenu.add(debugConsoleItem);
        }
        if (exitProgramItem != null) {
            fileMenu.add(exitProgramItem);
        }
        infoMenu.add(fsInfoItem);
        infoMenu.add(this.toggleCachingItem);
        infoMenu.add(createDiskImageItem);
        infoMenu.add(memoryStatisticsItem);
        helpMenu.add(startHelpBrowserItem);
        helpMenu.add(checkUpdatesItem);
        if (aboutItem != null) {
            helpMenu.add(aboutItem);
        }
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(infoMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ensureFileSystemLoaded() {
        if (this.fsHandler != null) {
            return true;
        }
        JOptionPane.showMessageDialog(this, "No file system loaded.", "Error", 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitApplication() {
        FileSystemBrowserWindow fileSystemBrowserWindow;
        try {
            if (this.tempFiles.size() > 0) {
                long totalFileSize = 0;
                Iterator i$ = this.tempFiles.iterator();
                while (i$.hasNext()) {
                    totalFileSize += i$.next().length();
                }
                int res = JOptionPane.showConfirmDialog(this, "You have " + this.tempFiles.size() + " temporary files with a total size of " + totalFileSize + " bytes in:\n    \"" + System.getProperty("java.io.tmpdir") + "\"\nDo you want to delete them now?", "Cleanup on program exit", 1, 3);
                if (res == 0) {
                    Iterator i$2 = this.tempFiles.iterator();
                    while (i$2.hasNext()) {
                        File tempFile = i$2.next();
                        if (tempFile.exists()) {
                            boolean delRes = tempFile.delete();
                            while (true) {
                                if (delRes) {
                                    break;
                                }
                                String str = "Could not delete file:\n    \"" + tempFile.getAbsolutePath() + "\"\nTry again?";
                                if (res2 == 0) {
                                    delRes = tempFile.delete();
                                } else if (res2 != 1) {
                                    return;
                                }
                            }
                        }
                    }
                } else if (res != 1) {
                    System.exit(0);
                    return;
                }
            }
            setVisible(false);
            if (this.fsHandler != null) {
                this.fsHandler.close();
            }
            System.exit(0);
        } catch (Throwable t) {
            try {
                GUIUtil.displayExceptionDialog(t, 20, this, "Exception when exiting application");
                System.exit(0);
            } finally {
                System.exit(0);
            }
        }
    }

    public void loadFSWithUDIFAutodetect(String filename) {
        loadFSWithUDIFAutodetect(filename, 0L);
    }

    public void loadFSWithUDIFAutodetect(String filename, long pos) {
        ReadableRandomAccessStream fsFile;
        String displayName;
        try {
            if (WindowsLowLevelIO.isSystemSupported()) {
                fsFile = new WindowsLowLevelIO(filename);
            } else {
                fsFile = new ReadableFileStream(filename);
            }
            try {
                System.err.println("Trying to detect CEncryptedEncoding structure...");
                if (ReadableCEncryptedEncodingStream.isCEncryptedEncoding(fsFile)) {
                    System.err.println("CEncryptedEncoding structure found! Creating filter stream...");
                    while (true) {
                        char[] res = PasswordDialog.showDialog(null, "Reading encrypted disk image...", "You need to enter a password to unlock this disk image:");
                        if (res == null) {
                            return;
                        }
                        try {
                            fsFile = new ReadableCEncryptedEncodingStream(fsFile, res);
                            break;
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog((Component) null, "Incorrect password.", "Reading encrypted disk image...", 0);
                        }
                    }
                } else {
                    System.err.println("CEncryptedEncoding structure not found. Proceeding...");
                }
            } catch (Exception e3) {
                System.err.println("[INFO] Non-critical exception while trying to detect CEncryptedEncoding structure:");
                e3.printStackTrace();
            }
            try {
                System.err.println("Trying to detect UDIF structure...");
                if (UDIFRecognizer.isUDIF(fsFile)) {
                    System.err.println("UDIF structure found! Creating filter stream...");
                    try {
                        ReadableRandomAccessStream stream = new UDIFRandomAccessStream(fsFile);
                        if (stream != null) {
                            fsFile = stream;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        if (e4.getMessage().startsWith("java.lang.RuntimeException: No handler for block type")) {
                            JOptionPane.showMessageDialog(this, "UDIF file contains unsupported block types!\n(The file was probably created with BZIP2 or ADC compression, which is unsupported currently)", "Error", 0);
                            return;
                        } else {
                            JOptionPane.showMessageDialog(this, "UDIF file unsupported or damaged!", "Error", 0);
                            return;
                        }
                    }
                } else {
                    System.err.println("UDIF structure not found. Proceeding...");
                }
            } catch (Exception e5) {
                System.err.println("[INFO] Non-critical exception while trying to detect UDIF structure:");
                e5.printStackTrace();
            }
            if (pos != 0) {
                fsFile = new ReadableConcatenatedStream(fsFile, pos, fsFile.length() - pos);
            }
            try {
                displayName = new File(filename).getCanonicalFile().getName();
            } catch (Exception e6) {
                displayName = filename;
            }
            loadFS(fsFile, displayName);
        } catch (Exception e7) {
            System.err.println("Could not open file! Exception thrown:");
            e7.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not open file:\n    \"" + filename + "\"", "Error", 0);
        }
    }

    public void loadFS(String filename) {
        ReadableRandomAccessStream fsFile;
        if (WindowsLowLevelIO.isSystemSupported()) {
            fsFile = new WindowsLowLevelIO(filename);
        } else {
            fsFile = new ReadableFileStream(filename);
        }
        loadFS(fsFile, new File(filename).getName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x010e, code lost:
        if ((r0 instanceof org.catacombae.hfsexplorer.partitioning.Partition) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0111, code lost:
        r0 = (org.catacombae.hfsexplorer.partitioning.Partition) r0;
        r14 = r0.getStartOffset();
        r16 = r0.getLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0136, code lost:
        throw new java.lang.RuntimeException("Impossible error!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadFS(org.catacombae.io.ReadableRandomAccessStream r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.catacombae.hfsexplorer.FileSystemBrowserWindow.loadFS(org.catacombae.io.ReadableRandomAccessStream, java.lang.String):void");
    }

    private long extractForkToStream(FSFork theFork, OutputStream os, ProgressMonitor pm) throws IOException {
        ReadableRandomAccessStream forkFilter = theFork.getReadableRandomAccessStream();
        long originalLength = theFork.getLength();
        long bytesToRead = originalLength;
        byte[] buffer = new byte[4096];
        while (bytesToRead > 0 && !pm.cancelSignaled()) {
            int bytesRead = forkFilter.read(buffer, 0, bytesToRead < ((long) buffer.length) ? (int) bytesToRead : buffer.length);
            if (bytesRead < 0) {
                break;
            }
            pm.addDataProgress(bytesRead);
            os.write(buffer, 0, bytesRead);
            bytesToRead -= bytesRead;
        }
        return originalLength - bytesToRead;
    }

    private long extractResourceForkToAppleDoubleStream(FSFork resourceFork, OutputStream os, ProgressMonitor pm) throws IOException {
        ReadableRandomAccessStream in = null;
        try {
            AppleSingleBuilder builder = new AppleSingleBuilder(AppleSingleBuilder.FileType.APPLEDOUBLE, AppleSingleBuilder.AppleSingleVersion.VERSION_2_0, AppleSingleBuilder.FileSystem.MACOS_X);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            in = resourceFork.getReadableRandomAccessStream();
            long extractedBytes = IOUtil.streamCopy(in, baos, 131072);
            if (extractedBytes != resourceFork.getLength()) {
                System.err.println("WARNING: Did not extract intended number of bytes to resource fork! Intended: " + resourceFork.getLength() + " Extracted: " + extractedBytes);
            }
            builder.addResourceFork(baos.toByteArray());
            os.write(builder.getResult());
            pm.addDataProgress(extractedBytes);
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e2) {
                }
            }
            return extractedBytes;
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    private void populateFilesystemGUI(FSFolder rootFolder) {
        FileSystemBrowser.Record<FSEntry> rootRecord = new FileSystemBrowser.Record<>(FileSystemBrowser.RecordType.FOLDER, rootFolder.getName(), 0L, rootFolder.getAttributes().getModifyDate(), rootFolder);
        this.fsb.setRoot(rootRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionDoubleClickFile(final String[] parentPath, final FSFile rec) {
        final JDialog fopFrame = new JDialog(this, rec.getName(), true);
        fopFrame.setDefaultCloseOperation(2);
        ActionListener alOpen = null;
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            final String finalCommand = "cmd.exe /c start \"HFSExplorer invoker\" \"" + rec.getName() + "\"";
            alOpen = new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.15
                public void actionPerformed(ActionEvent ae) {
                    File tempDir = new File(System.getProperty("java.io.tmpdir"));
                    LinkedList<String> errorMessages = new LinkedList<>();
                    FileSystemBrowserWindow.this.extract(parentPath, rec, tempDir, new SimpleGUIProgressMonitor(fopFrame), errorMessages, true);
                    if (errorMessages.size() == 0) {
                        FileSystemBrowserWindow.this.tempFiles.add(new File(tempDir, rec.getName()));
                        try {
                            Runtime.getRuntime().exec(finalCommand, (String[]) null, tempDir);
                            fopFrame.dispose();
                            return;
                        } catch (Exception e2) {
                            String stackTrace = e2.toString() + "\n";
                            StackTraceElement[] arr$ = e2.getStackTrace();
                            for (StackTraceElement ste : arr$) {
                                stackTrace = stackTrace + "    " + ste.toString() + "\n";
                            }
                            JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Open failed. Exception caught:\n" + stackTrace, "Error", 0);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Error while extracting file to temp dir.", "Error", 0);
                }
            };
        } else if (Java6Util.isJava6OrHigher() && Java6Specific.canOpen()) {
            alOpen = new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.16
                public void actionPerformed(ActionEvent ae) {
                    File tempDir = new File(System.getProperty("java.io.tmpdir"));
                    LinkedList<String> errorMessages = new LinkedList<>();
                    FileSystemBrowserWindow.this.extract(parentPath, rec, tempDir, new SimpleGUIProgressMonitor(fopFrame), errorMessages, true);
                    if (errorMessages.size() == 0) {
                        File extractedFile = new File(tempDir, rec.getName());
                        FileSystemBrowserWindow.this.tempFiles.add(new File(tempDir, rec.getName()));
                        try {
                            Java6Specific.openFile(extractedFile);
                            fopFrame.dispose();
                        } catch (IOException e2) {
                            JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Could not find a handler to open the file with.\nThe file remains in\n    \"" + tempDir + "\"\nuntil you exit the program.", "Error", 0);
                        } catch (Exception e3) {
                            String stackTrace = e3.toString() + "\n";
                            StackTraceElement[] arr$ = e3.getStackTrace();
                            for (StackTraceElement ste : arr$) {
                                stackTrace = stackTrace + "    " + ste.toString() + "\n";
                            }
                            JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Open failed. Exception caught:\n" + stackTrace, "Error", 0);
                        }
                    }
                }
            };
        } else if (System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
            final String[] finalCommand2 = {"open", rec.getName()};
            alOpen = new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.17
                public void actionPerformed(ActionEvent ae) {
                    File tempDir = new File(System.getProperty("java.io.tmpdir"));
                    LinkedList<String> errorMessages = new LinkedList<>();
                    FileSystemBrowserWindow.this.extract(parentPath, rec, tempDir, new SimpleGUIProgressMonitor(fopFrame), errorMessages, true);
                    if (errorMessages.size() == 0) {
                        FileSystemBrowserWindow.this.tempFiles.add(new File(tempDir, rec.getName()));
                        try {
                            Runtime.getRuntime().exec(finalCommand2, (String[]) null, tempDir);
                            fopFrame.dispose();
                            return;
                        } catch (Exception e2) {
                            String stackTrace = e2.toString() + "\n";
                            StackTraceElement[] arr$ = e2.getStackTrace();
                            for (StackTraceElement ste : arr$) {
                                stackTrace = stackTrace + "    " + ste.toString() + "\n";
                            }
                            JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Open failed. Exception caught:\n" + stackTrace, "Error", 0);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "Error while extracting file to temp dir.", "Error", 0);
                }
            };
        }
        ActionListener alSave = new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.18
            public void actionPerformed(ActionEvent ae) {
                FileSystemBrowserWindow.this.actionExtractToDir(parentPath, rec);
                fopFrame.dispose();
            }
        };
        FileOperationsPanel fop = new FileOperationsPanel(fopFrame, rec.getName(), rec.getMainFork().getLength(), alOpen, alSave);
        fopFrame.add(fop, "Center");
        fopFrame.pack();
        fopFrame.setLocationRelativeTo((Component) null);
        fopFrame.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionExtractToDiskImage() {
        File saveFile;
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(0);
        jfc.setMultiSelectionEnabled(false);
        SimplerFileFilter ffDmg = new SimplerFileFilter(".dmg", "Mac OS X read/write disk image (.dmg)");
        jfc.setFileFilter(ffDmg);
        if (jfc.showSaveDialog(this) == 0) {
            File selectedFile = jfc.getSelectedFile();
            FileFilter selectedFileFilter = jfc.getFileFilter();
            if (selectedFileFilter instanceof SimplerFileFilter) {
                SimplerFileFilter sff = (SimplerFileFilter) selectedFileFilter;
                if (!selectedFile.getName().endsWith(sff.getExtension())) {
                    saveFile = new File(selectedFile.getParentFile(), selectedFile.getName() + sff.getExtension());
                } else {
                    saveFile = selectedFile;
                }
            } else {
                saveFile = selectedFile;
            }
            if (saveFile.exists()) {
                int res = JOptionPane.showConfirmDialog(this, "The file:\n  " + saveFile.getPath() + "\nAlready exists. Do you want to overwrite?", "Confirm overwrite", 0, 3);
                if (res != 0) {
                    return;
                }
            }
            final javax.swing.ProgressMonitor pm = new javax.swing.ProgressMonitor(this, "Extracting file system data to disk image...", "Starting extraction...", 0, Integer.MAX_VALUE);
            pm.setMillisToDecideToPopup(0);
            pm.setMillisToPopup(0);
            pm.setProgress(0);
            final File file = saveFile;
            Runnable r = new Runnable() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.19
                @Override // java.lang.Runnable
                public void run() {
                    ReadableRandomAccessStream fsStream = FileSystemBrowserWindow.this.fsDataLocator.createReadOnlyFile();
                    FileOutputStream fileOut = null;
                    try {
                        try {
                            fileOut = new FileOutputStream(file);
                            DecimalFormat df = new DecimalFormat("0.00");
                            CommonHFSVolumeHeader vh = FileSystemBrowserWindow.this.fsHandler.getFSView().getVolumeHeader();
                            long bytesToExtract = vh.getFileSystemEnd();
                            String bytesToExtractString = SpeedUnitUtils.bytesToBinaryUnit(bytesToExtract, df);
                            long lastUpdateTimestamp = 0;
                            long bytesExtracted = 0;
                            byte[] buffer = new byte[65536];
                            while (bytesExtracted < bytesToExtract && !pm.isCanceled()) {
                                long bytesLeftToRead = bytesToExtract - bytesExtracted;
                                int curBytesToRead = (int) (bytesLeftToRead < ((long) buffer.length) ? bytesLeftToRead : buffer.length);
                                int bytesRead = fsStream.read(buffer, 0, curBytesToRead);
                                if (bytesRead <= 0) {
                                    throw new RuntimeException("Unexpectedly reached end of file! fp=" + fsStream.getFilePointer() + " length=" + fsStream.length() + " bytesExtracted=" + bytesExtracted + " bytesToExtract=" + bytesToExtract);
                                }
                                fileOut.write(buffer, 0, bytesRead);
                                bytesExtracted += bytesRead;
                                long currentTimestamp = System.currentTimeMillis();
                                long millisSinceLastUpdate = currentTimestamp - lastUpdateTimestamp;
                                if (millisSinceLastUpdate >= 40) {
                                    pm.setProgress((int) ((bytesExtracted / bytesToExtract) * 2.147483647E9d));
                                    pm.setNote("Extracted " + SpeedUnitUtils.bytesToBinaryUnit(bytesExtracted, df) + " / " + bytesToExtractString + " ...");
                                    lastUpdateTimestamp = currentTimestamp;
                                }
                            }
                            pm.close();
                            try {
                                fsStream.close();
                                if (fileOut != null) {
                                    fileOut.close();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                GUIUtil.displayExceptionDialog(e2, FileSystemBrowserWindow.this);
                            }
                        } catch (Throwable th) {
                            pm.close();
                            try {
                                fsStream.close();
                                if (fileOut != null) {
                                    fileOut.close();
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                GUIUtil.displayExceptionDialog(e3, FileSystemBrowserWindow.this);
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        GUIUtil.displayExceptionDialog(e4, 15, FileSystemBrowserWindow.this, "Exception while extracting data!");
                        pm.close();
                        try {
                            fsStream.close();
                            if (fileOut != null) {
                                fileOut.close();
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            GUIUtil.displayExceptionDialog(e5, FileSystemBrowserWindow.this);
                        }
                    }
                }
            };
            new Thread(r).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionExtractToDir(String[] parentPath, FSEntry entry) {
        actionExtractToDir(parentPath, Arrays.asList(entry));
    }

    private void actionExtractToDir(String[] parentPath, List<FSEntry> selection) {
        actionExtractToDir(parentPath, selection, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionExtractToDir(final String[] parentPath, final List<FSEntry> selection, final boolean dataFork, final boolean resourceFork) {
        if (!dataFork && !resourceFork) {
            throw new IllegalArgumentException("Can't choose to extract nothing!");
        }
        try {
            if (selection.size() > 0) {
                this.fileChooser.setMultiSelectionEnabled(false);
                this.fileChooser.setFileSelectionMode(1);
                this.fileChooser.setSelectedFiles(new File[0]);
                if (this.fileChooser.showDialog(this, "Extract here") == 0) {
                    final File outDir = this.fileChooser.getSelectedFile();
                    final ExtractProgressDialog progress = new ExtractProgressDialog(this);
                    Runnable r = new Runnable() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.20
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean followSymlinks;
                            try {
                                LinkedList<FSForkType> forkTypes = new LinkedList<>();
                                if (dataFork) {
                                    forkTypes.add(FSForkType.DATA);
                                }
                                if (resourceFork) {
                                    forkTypes.add(FSForkType.MACOS_RESOURCE);
                                }
                                LinkedList<String> dirStack = new LinkedList<>();
                                if (parentPath != null) {
                                    String[] arr$ = parentPath;
                                    for (String pathComponent : arr$) {
                                        dirStack.addLast(pathComponent);
                                    }
                                }
                                int res = JOptionPane.showConfirmDialog(progress, "Do you want to follow symbolic links while extracting?\nFollowing symbolic links means that the extracted tree willmore closely match the percieved file system tree, but it\nincreases the size of the extracted data, the time that it takes to extract it, and puts a lot of identical files at\ndifferent locations in your target folder.", "Follow symbolic links?", 1, 3);
                                if (res == 0) {
                                    followSymlinks = true;
                                } else if (res != 1) {
                                    progress.dispose();
                                    return;
                                } else {
                                    followSymlinks = false;
                                }
                                long dataSize = FileSystemBrowserWindow.this.calculateForkSizeRecursive(parentPath, selection, progress, forkTypes, followSymlinks);
                                if (progress.cancelSignaled()) {
                                    progress.confirmCancel();
                                } else {
                                    progress.setDataSize(dataSize);
                                    LinkedList<String> errorMessages = new LinkedList<>();
                                    FileSystemBrowserWindow.this.extract(parentPath, selection, outDir, progress, errorMessages, followSymlinks, forkTypes);
                                    if (progress.cancelSignaled()) {
                                        errorMessages.addLast("User aborted extraction.");
                                    }
                                    if (progress.cancelSignaled()) {
                                        JOptionPane.showMessageDialog(progress, "Extraction was aborted.\nPlease remove the extracted files manually.", "Aborted extraction", 2);
                                        progress.confirmCancel();
                                    } else if (errorMessages.size() == 0) {
                                        JOptionPane.showMessageDialog(progress, "Extraction finished.", "Information", 1);
                                    } else {
                                        ErrorSummaryPanel.createErrorSummaryDialog((Dialog) progress, (List<String>) errorMessages).setVisible(true);
                                    }
                                }
                            } catch (Throwable t) {
                                try {
                                    t.printStackTrace();
                                    GUIUtil.displayExceptionDialog(t, progress);
                                    progress.dispose();
                                } finally {
                                    progress.dispose();
                                }
                            }
                        }
                    };
                    new Thread(r).start();
                    progress.setVisible(true);
                }
            } else if (selection.size() == 0) {
                JOptionPane.showMessageDialog(this, "No file or folder selected.", "Information", 1);
            } else {
                throw new RuntimeException("wtf?");
            }
        } catch (RuntimeException re) {
            re.printStackTrace();
            GUIUtil.displayExceptionDialog(re, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long calculateForkSizeRecursive(String[] parentPath, List<FSEntry> selection, ExtractProgressMonitor progress, LinkedList<FSForkType> forkTypes, boolean followSymlinks) {
        if (forkTypes.size() == 0) {
            FSForkType[] arr$ = this.fsHandler.getSupportedForkTypes();
            for (FSForkType forkType : arr$) {
                forkTypes.add(forkType);
            }
        }
        CalculateTreeSizeVisitor sizeVisitor = new CalculateTreeSizeVisitor(this, progress, forkTypes);
        traverseTree(parentPath, selection, sizeVisitor, followSymlinks);
        return sizeVisitor.getSize();
    }

    private void traverseTree(String[] parentPath, List<FSEntry> entries, TreeVisitor visitor, boolean followSymbolicLinks) {
        LinkedList<String[]> absPathsStack = new LinkedList<>();
        LinkedList<String> pathStack = new LinkedList<>();
        if (parentPath != null) {
            absPathsStack.addLast(parentPath);
            for (String pathComponent : parentPath) {
                pathStack.addLast(pathComponent);
            }
        }
        FSEntry[] children = (FSEntry[]) entries.toArray(new FSEntry[entries.size()]);
        traverseTreeRecursive(children, pathStack, absPathsStack, visitor, followSymbolicLinks);
    }

    private void traverseTreeRecursive(FSEntry[] selection, LinkedList<String> pathStack, LinkedList<String[]> absPathsStack, TreeVisitor visitor, boolean followSymbolicLinks) {
        String[] absolutePath;
        if (visitor.cancelTraversal()) {
            return;
        }
        String[] pathStackArray = (String[]) pathStack.toArray(new String[pathStack.size()]);
        String pathStackString = Util.concatenateStrings(pathStack, "/");
        int len$ = selection.length;
        for (int i$ = 0; i$ < len$; i$++) {
            FSEntry curEntry = selection[i$];
            if (!visitor.cancelTraversal()) {
                String curEntryString = (pathStackString.length() > 0 ? pathStackString + "/" : "") + curEntry.getName();
                String[] linkTargetPath = null;
                if (followSymbolicLinks && (curEntry instanceof FSLink)) {
                    FSLink curLink = (FSLink) curEntry;
                    String[] targetPath = this.fsHandler.getTargetPath(curLink, pathStackArray);
                    if (targetPath != null) {
                        if (Util.contains(absPathsStack, targetPath)) {
                            String msg = "Circular symlink detected: \"" + curEntryString + "\" -> \"" + curLink.getLinkTargetString() + "\"";
                            System.err.println();
                            System.err.println("traverseTreeRecursive: " + msg);
                            System.err.println();
                            visitor.traversalError(msg);
                        } else {
                            FSEntry linkTarget = this.fsHandler.getEntry(targetPath);
                            if (linkTarget != null) {
                                curEntry = linkTarget;
                                linkTargetPath = targetPath;
                            } else {
                                String msg2 = "Could not get link target entry \"" + curLink.getLinkTargetString() + "\"";
                                System.err.println("WARNING: " + msg2);
                                visitor.traversalError(msg2);
                            }
                        }
                    } else {
                        String msg3 = "Could not resolve link \"" + curEntryString + "\" -> \"" + curLink.getLinkTargetString() + "\"";
                        System.err.println("WARNING: " + msg3);
                        visitor.traversalError(msg3);
                    }
                }
                if (linkTargetPath != null) {
                    absolutePath = linkTargetPath;
                } else if (absPathsStack.size() > 0) {
                    absolutePath = Util.concatenate(absPathsStack.getLast(), curEntry.getName());
                } else {
                    absolutePath = new String[0];
                }
                if (curEntry instanceof FSFile) {
                    visitor.file((FSFile) curEntry);
                } else if (curEntry instanceof FSFolder) {
                    FSFolder curFolder = (FSFolder) curEntry;
                    if (absPathsStack.size() > 0) {
                        pathStack.addLast(curFolder.getName());
                    }
                    absPathsStack.addLast(absolutePath);
                    try {
                        if (visitor.startDirectory(pathStackArray, curFolder)) {
                            traverseTreeRecursive(curFolder.listEntries(), pathStack, absPathsStack, visitor, followSymbolicLinks);
                            visitor.endDirectory(pathStackArray, curFolder);
                        }
                    } finally {
                        absPathsStack.removeLast();
                        if (absPathsStack.size() > 0) {
                            pathStack.removeLast();
                        }
                    }
                } else if (curEntry instanceof FSLink) {
                    FSLink curLink2 = (FSLink) curEntry;
                    if (followSymbolicLinks) {
                        System.err.println("Unresolved link \"" + curEntryString + "\" -> \"" + curLink2.getLinkTargetString() + "\"");
                    }
                    visitor.link((FSLink) curEntry);
                } else {
                    throw new RuntimeException("Unexpected FSEntry subclass: " + curEntry.getClass());
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionShowAboutDialog() {
        String message = "HFSExplorer 0.21 Build #1081\n";
        String message2 = message + "Copyright © Erik Larsson 2006-2008\n";
        String[] arr$ = HFSExplorer.NOTICES;
        for (String notice : arr$) {
            message2 = message2 + notice + "\n";
        }
        JOptionPane.showMessageDialog(this, (((message2 + "\nOperating system: " + System.getProperty("os.name") + " " + System.getProperty("os.version")) + "\nArchitecture: " + System.getProperty("os.arch")) + "\nJava Runtime Environment: " + System.getProperty("java.version")) + "\nVirtual machine: " + System.getProperty("java.vm.vendor") + " " + System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version"), "About", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionGetInfo(String[] parentPath, List<FSEntry> entries) {
        if (entries.size() != 1) {
            JOptionPane.showMessageDialog(this, "Get info for multiple selections not yet possible.\nPlease select one item at a time.", "Error", 0);
            return;
        }
        FSEntry entry = entries.get(0);
        if ((entry instanceof FSFile) || (entry instanceof FSLink) || (entry instanceof FSFolder)) {
            FileInfoWindow fiw = new FileInfoWindow(entry, parentPath);
            fiw.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "[actionGetInfo()] Record data has unexpected type (" + entry.getClass() + ").\nReport bug to developer.", "Error", 0);
    }

    protected void extract(String[] parentPath, FSEntry rec, File outDir, ExtractProgressMonitor progressDialog, LinkedList<String> errorMessages, boolean followSymbolicLinks) {
        extract(parentPath, Arrays.asList(rec), outDir, progressDialog, errorMessages, followSymbolicLinks, FSForkType.DATA);
    }

    protected void extract(String[] parentPath, List<FSEntry> recs, File outDir, ExtractProgressMonitor progressDialog, LinkedList<String> errorMessages, boolean followSymbolicLinks, List<FSForkType> forkTypes) {
        extract(parentPath, recs, outDir, progressDialog, errorMessages, followSymbolicLinks, (FSForkType[]) forkTypes.toArray(new FSForkType[forkTypes.size()]));
    }

    protected void extract(String[] parentPath, List<FSEntry> recs, File outDir, ExtractProgressMonitor progressDialog, LinkedList<String> errorMessages, boolean followSymbolicLinks, FSForkType... forkTypes) {
        if (!outDir.exists()) {
            String[] options = {"Create directory", "Cancel"};
            int reply = JOptionPane.showOptionDialog(this, "Warning! Target directory:\n    \"" + outDir.getAbsolutePath() + "\"\ndoes not exist. Do you want to create this directory?", "Warning", 1, 2, (Icon) null, options, options[0]);
            if (reply != 0) {
                errorMessages.addLast("Skipping all files in " + outDir.getAbsolutePath() + " as user chose not to create directory.");
                progressDialog.signalCancel();
                return;
            } else if (!outDir.mkdirs()) {
                JOptionPane.showMessageDialog(this, "Could not create directory:\n    \"" + outDir.getAbsolutePath() + "\"\n", "Error", 0);
                errorMessages.addLast("Could not create directory \"" + outDir.getAbsolutePath() + "\".");
                progressDialog.signalCancel();
                return;
            }
        }
        ExtractVisitor ev = new ExtractVisitor(progressDialog, errorMessages, outDir, forkTypes);
        traverseTree(parentPath, recs, ev, followSymbolicLinks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v135, types: [A, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r1v87, types: [A, java.lang.Boolean] */
    public void extractFile(FSFile rec, File outDir, ExtractProgressMonitor progressDialog, LinkedList<String> errorMessages, ExtractProgressMonitor.ExtractProperties extractProperties, ObjectContainer<Boolean> skipDirectory, FSForkType forkType) {
        String originalFileName;
        ExtractProgressMonitor.CreateFileFailedAction a2;
        ExtractProgressMonitor.FileExistsAction a3;
        if (forkType == FSForkType.DATA) {
            originalFileName = rec.getName();
        } else if (forkType == FSForkType.MACOS_RESOURCE) {
            originalFileName = "._" + rec.getName();
        } else {
            throw new RuntimeException("Unexpected fork type: " + forkType);
        }
        ExtractProgressMonitor.CreateFileFailedAction defaultCreateFileFailedAction = extractProperties.getCreateFileFailedAction();
        ExtractProgressMonitor.FileExistsAction defaultFileExistsAction = extractProperties.getFileExistsAction();
        String fileName = originalFileName;
        while (fileName != null) {
            String curFileName = fileName;
            FSFork theFork = rec.getForkByType(forkType);
            if (theFork == null) {
                throw new RuntimeException("Could not find a fork of type: " + forkType);
            }
            if (forkType == FSForkType.MACOS_RESOURCE && theFork.getLength() == 0) {
                return;
            }
            progressDialog.updateCurrentFile(curFileName, theFork.getLength());
            File outFile = new File(outDir, curFileName);
            if (defaultFileExistsAction != ExtractProgressMonitor.FileExistsAction.OVERWRITE && outFile.exists()) {
                if (defaultFileExistsAction == ExtractProgressMonitor.FileExistsAction.PROMPT_USER) {
                    a3 = progressDialog.fileExists(outFile);
                } else {
                    a3 = defaultFileExistsAction;
                    defaultFileExistsAction = ExtractProgressMonitor.FileExistsAction.PROMPT_USER;
                }
                if (a3 != ExtractProgressMonitor.FileExistsAction.OVERWRITE) {
                    if (a3 == ExtractProgressMonitor.FileExistsAction.OVERWRITE_ALL) {
                        extractProperties.setFileExistsAction(ExtractProgressMonitor.FileExistsAction.OVERWRITE);
                        defaultFileExistsAction = ExtractProgressMonitor.FileExistsAction.OVERWRITE;
                    } else if (a3 == ExtractProgressMonitor.FileExistsAction.SKIP_FILE) {
                        errorMessages.addLast("Skipped extracting file \"" + outFile.getAbsolutePath() + "\" due to user interaction.");
                        return;
                    } else if (a3 == ExtractProgressMonitor.FileExistsAction.SKIP_DIRECTORY) {
                        errorMessages.addLast("Skipping entire directory \"" + outDir.getAbsolutePath() + "\" due to user interaction.");
                        skipDirectory.o = true;
                        return;
                    } else if (a3 == ExtractProgressMonitor.FileExistsAction.RENAME) {
                        fileName = progressDialog.displayRenamePrompt(curFileName, outDir);
                        if (fileName == null) {
                            fileName = curFileName;
                        }
                    } else if (a3 == ExtractProgressMonitor.FileExistsAction.AUTO_RENAME) {
                        fileName = FileNameTools.autoRenameIllegalFilename(curFileName, outDir, false);
                        if (fileName == null) {
                            fileName = curFileName;
                        }
                    } else if (a3 == ExtractProgressMonitor.FileExistsAction.CANCEL) {
                        progressDialog.signalCancel();
                        return;
                    } else {
                        throw new RuntimeException("Internal error! Did not expect a: " + a3);
                    }
                }
            }
            try {
                try {
                    outFile.getCanonicalPath();
                    if (!outFile.getParentFile().equals(outDir) || !outFile.getName().equals(curFileName)) {
                        throw new FileNotFoundException();
                    }
                    FileOutputStream fos = new FileOutputStream(outFile);
                    if (forkType == FSForkType.MACOS_RESOURCE) {
                        extractResourceForkToAppleDoubleStream(theFork, fos, progressDialog);
                    } else {
                        extractForkToStream(theFork, fos, progressDialog);
                    }
                    fos.close();
                    if (curFileName != originalFileName && !curFileName.equals(originalFileName)) {
                        errorMessages.addLast("File \"" + originalFileName + "\" was renamed to \"" + curFileName + "\" in parent folder \"" + outDir.getAbsolutePath() + "\".");
                    }
                    return;
                } catch (Exception e2) {
                    throw new FileNotFoundException();
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println("Could not create file \"" + outFile + "\". The following exception was thrown:");
                fnfe.printStackTrace();
                char[] filenameChars = curFileName.toCharArray();
                System.out.println("Filename in hex (" + filenameChars.length + " UTF-16BE units):");
                System.out.print("  0x");
                for (char c2 : filenameChars) {
                    System.out.print(" " + Util.toHexStringBE(c2));
                }
                System.out.println();
                if (defaultCreateFileFailedAction == ExtractProgressMonitor.CreateFileFailedAction.PROMPT_USER) {
                    a2 = progressDialog.createFileFailed(curFileName, outDir);
                } else {
                    a2 = defaultCreateFileFailedAction;
                    defaultCreateFileFailedAction = ExtractProgressMonitor.CreateFileFailedAction.PROMPT_USER;
                }
                if (a2 == ExtractProgressMonitor.CreateFileFailedAction.SKIP_FILE) {
                    errorMessages.addLast("Skipped extracting file \"" + outFile.getAbsolutePath() + "\" due to user interaction.");
                    return;
                } else if (a2 == ExtractProgressMonitor.CreateFileFailedAction.SKIP_DIRECTORY) {
                    errorMessages.addLast("Skipping entire directory \"" + outDir.getAbsolutePath() + "\" due to user interaction.");
                    skipDirectory.o = true;
                    return;
                } else if (a2 == ExtractProgressMonitor.CreateFileFailedAction.RENAME) {
                    fileName = progressDialog.displayRenamePrompt(curFileName, outDir);
                    if (fileName == null) {
                        fileName = curFileName;
                    }
                } else if (a2 == ExtractProgressMonitor.CreateFileFailedAction.AUTO_RENAME) {
                    fileName = FileNameTools.autoRenameIllegalFilename(curFileName, outDir, false);
                    if (fileName == null) {
                        fileName = curFileName;
                    }
                } else if (a2 == ExtractProgressMonitor.CreateFileFailedAction.CANCEL) {
                    progressDialog.signalCancel();
                    return;
                } else {
                    throw new RuntimeException("Internal error! Did not expect a: " + a2);
                }
            } catch (IOException ioe) {
                System.err.println("Received I/O exception when trying to write to file \"" + outFile + "\":");
                ioe.printStackTrace();
                String msg = ioe.getMessage();
                int reply = JOptionPane.showConfirmDialog(this, "Could not write to file \"" + curFileName + "\" under folder:\n  " + outDir.getAbsolutePath() + (msg != null ? "\nSystem message: \"" + msg + "\"" : "") + "\nDo you want to continue?", "I/O Error", 0, 0);
                errorMessages.addLast("Could not write to file \"" + curFileName + "\"");
                if (reply == 1) {
                    progressDialog.signalCancel();
                    return;
                }
                return;
            } catch (Throwable e3) {
                e3.printStackTrace();
                String message = "An exception occurred while extracting \"" + curFileName + "\"!";
                String message2 = message + "\n  " + e3.toString();
                StackTraceElement[] arr$ = e3.getStackTrace();
                for (StackTraceElement ste : arr$) {
                    message2 = message2 + "\n    " + ste.toString();
                }
                int reply2 = JOptionPane.showConfirmDialog(this, (message2 + "\n\nThe file has probably not been extracted.") + "\nDo you want to continue with the extraction?", "Error", 0, 0);
                errorMessages.addLast("An unhandled exception occurred when exctracting file \"" + curFileName + "\". See debug console for more info.");
                if (reply2 == 1) {
                    progressDialog.signalCancel();
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$NullTreeVisitor.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$NullTreeVisitor.class */
    public class NullTreeVisitor implements TreeVisitor {
        public NullTreeVisitor() {
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public boolean startDirectory(String[] parentPath, FSFolder folder) {
            return true;
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void endDirectory(String[] parentPath, FSFolder folder) {
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void file(FSFile fsf) {
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void link(FSLink fsl) {
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void traversalError(String message) {
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public boolean cancelTraversal() {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$CalculateTreeSizeVisitor.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$CalculateTreeSizeVisitor.class */
    public class CalculateTreeSizeVisitor extends NullTreeVisitor {
        private final ExtractProgressMonitor pm;
        private final StringBuilder sb;
        private final FSForkType[] forkTypes;
        private long size;

        public CalculateTreeSizeVisitor(FileSystemBrowserWindow fileSystemBrowserWindow, ExtractProgressMonitor pm, List<FSForkType> forkTypes) {
            this(pm, (FSForkType[]) forkTypes.toArray(new FSForkType[forkTypes.size()]));
        }

        public CalculateTreeSizeVisitor(ExtractProgressMonitor pm, FSForkType... forkTypes) {
            super();
            this.sb = new StringBuilder();
            this.size = 0L;
            this.pm = pm;
            this.forkTypes = forkTypes;
            if (this.pm == null) {
                throw new IllegalArgumentException("pm == null");
            }
            if (this.forkTypes == null) {
                throw new IllegalArgumentException("forkTypes == null");
            }
            if (forkTypes.length == 0) {
                throw new IllegalArgumentException("No fork types to extract.");
            }
        }

        public long getSize() {
            return this.size;
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public boolean startDirectory(String[] parentPath, FSFolder folder) {
            this.sb.setLength(0);
            for (String s : parentPath) {
                this.sb.append(s).append("/");
            }
            this.sb.append(folder.getName());
            this.pm.updateCalculateDir(this.sb.toString());
            return true;
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void file(FSFile file) {
            FSForkType[] arr$ = this.forkTypes;
            for (FSForkType forkType : arr$) {
                FSFork fork = file.getForkByType(forkType);
                if (fork != null) {
                    this.size += fork.getLength();
                }
            }
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public boolean cancelTraversal() {
            return this.pm.cancelSignaled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$ExtractVisitor.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$ExtractVisitor.class */
    public class ExtractVisitor extends NullTreeVisitor {
        private final ExtractProgressMonitor pm;
        private final LinkedList<String> errorMessages;
        private final File outRootDir;
        private final ObjectContainer<Boolean> skipDirectory;
        private final ExtractProgressMonitor.ExtractProperties extractProperties;
        private final FSForkType[] forkTypes;
        private final LinkedList<File> outDirStack;

        public ExtractVisitor(FileSystemBrowserWindow fileSystemBrowserWindow, ExtractProgressMonitor pm, LinkedList<String> errorMessages, File outDir, List<FSForkType> forkTypes) {
            this(pm, errorMessages, outDir, (FSForkType[]) forkTypes.toArray(new FSForkType[forkTypes.size()]));
        }

        public ExtractVisitor(ExtractProgressMonitor pm, LinkedList<String> errorMessages, File outDir, FSForkType... forkTypes) {
            super();
            this.skipDirectory = new ObjectContainer<>(false);
            this.outDirStack = new LinkedList<>();
            this.pm = pm;
            this.errorMessages = errorMessages;
            this.outRootDir = outDir;
            this.forkTypes = forkTypes;
            this.extractProperties = this.pm.getExtractProperties();
            if (this.pm == null) {
                throw new IllegalArgumentException("pm == null");
            }
            if (this.errorMessages == null) {
                throw new IllegalArgumentException("errorMessages == null");
            }
            if (this.outRootDir == null) {
                throw new IllegalArgumentException("outDir == null");
            }
            if (this.forkTypes == null) {
                throw new IllegalArgumentException("forkTypes == null");
            }
            if (forkTypes.length == 0) {
                throw new IllegalArgumentException("No fork types to extract.");
            }
            this.outDirStack.addLast(outDir);
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public boolean startDirectory(String[] parentPath, FSFolder folder) {
            ExtractProgressMonitor.CreateDirectoryFailedAction a2;
            ExtractProgressMonitor.DirectoryExistsAction a3;
            File outDir = this.outDirStack.getLast();
            ExtractProgressMonitor.CreateDirectoryFailedAction originalCreateDirectoryFailedAction = this.extractProperties.getCreateDirectoryFailedAction();
            ExtractProgressMonitor.DirectoryExistsAction originalDirectoryExistsAction = this.extractProperties.getDirectoryExistsAction();
            ExtractProgressMonitor.CreateDirectoryFailedAction defaultCreateDirectoryFailedAction = originalCreateDirectoryFailedAction;
            String originalDirName = folder.getName();
            String dirName = originalDirName;
            while (dirName != null) {
                String curDirName = dirName;
                dirName = null;
                this.pm.updateCurrentDir(curDirName);
                File thisDir = new File(outDir, curDirName);
                if (originalDirectoryExistsAction != ExtractProgressMonitor.DirectoryExistsAction.CONTINUE && thisDir.exists()) {
                    if (originalDirectoryExistsAction == ExtractProgressMonitor.DirectoryExistsAction.PROMPT_USER) {
                        a3 = this.pm.directoryExists(thisDir);
                    } else {
                        a3 = originalDirectoryExistsAction;
                    }
                    boolean resetLoop = false;
                    switch (a3) {
                        case CONTINUE:
                            break;
                        case RENAME:
                            dirName = this.pm.displayRenamePrompt(curDirName, outDir);
                            if (dirName == null) {
                                dirName = curDirName;
                            }
                            resetLoop = true;
                            break;
                        case AUTO_RENAME:
                            dirName = FileNameTools.autoRenameIllegalFilename(curDirName, outDir, true);
                            if (dirName == null) {
                                dirName = curDirName;
                            }
                            resetLoop = true;
                            break;
                        case SKIP_DIRECTORY:
                            resetLoop = true;
                            break;
                        case CANCEL:
                            resetLoop = true;
                            this.pm.signalCancel();
                            break;
                        default:
                            throw new RuntimeException("Internal error! Did not expect a: " + a3);
                    }
                    if (resetLoop) {
                        continue;
                    }
                }
                if (thisDir.mkdir() || thisDir.exists()) {
                    if (curDirName != originalDirName && !curDirName.equals(originalDirName)) {
                        this.errorMessages.addLast("Directory \"" + originalDirName + "\" was renamed to \"" + curDirName + "\" in parent folder \"" + outDir.getAbsolutePath() + "\".");
                    }
                    this.outDirStack.addLast(thisDir);
                    return true;
                }
                if (defaultCreateDirectoryFailedAction == ExtractProgressMonitor.CreateDirectoryFailedAction.PROMPT_USER) {
                    a2 = this.pm.createDirectoryFailed(curDirName, outDir);
                } else {
                    a2 = defaultCreateDirectoryFailedAction;
                    defaultCreateDirectoryFailedAction = ExtractProgressMonitor.CreateDirectoryFailedAction.PROMPT_USER;
                }
                switch (a2) {
                    case SKIP_DIRECTORY:
                        this.errorMessages.addLast("Could not create directory \"" + thisDir.getAbsolutePath() + "\". All files under this directory will be skipped.");
                        continue;
                    case RENAME:
                        dirName = this.pm.displayRenamePrompt(curDirName, outDir);
                        if (dirName == null) {
                            dirName = curDirName;
                            break;
                        } else {
                            continue;
                        }
                    case AUTO_RENAME:
                        dirName = FileNameTools.autoRenameIllegalFilename(curDirName, outDir, true);
                        if (dirName == null) {
                            dirName = curDirName;
                            break;
                        } else {
                            continue;
                        }
                    case CANCEL:
                        this.pm.signalCancel();
                        continue;
                    default:
                        throw new RuntimeException("Internal error! Did not expect a: " + a2);
                }
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [A, java.lang.Boolean] */
        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void endDirectory(String[] parentPath, FSFolder folder) {
            this.outDirStack.removeLast();
            this.skipDirectory.o = false;
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void file(FSFile fsf) {
            if (this.skipDirectory.o.booleanValue()) {
                return;
            }
            File outDir = this.outDirStack.getLast();
            FSForkType[] arr$ = this.forkTypes;
            for (FSForkType forkType : arr$) {
                FileSystemBrowserWindow.this.extractFile(fsf, outDir, this.pm, this.errorMessages, this.extractProperties, this.skipDirectory, forkType);
            }
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void link(FSLink fsl) {
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public void traversalError(String message) {
            this.errorMessages.addLast(message);
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowserWindow.NullTreeVisitor, org.catacombae.hfsexplorer.FileSystemBrowserWindow.TreeVisitor
        public boolean cancelTraversal() {
            return this.pm.cancelSignaled();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$FileSystemProvider.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$FileSystemProvider.class */
    private class FileSystemProvider implements FileSystemBrowser.FileSystemProvider<FSEntry> {
        private FileSystemProvider() {
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowser.FileSystemProvider
        public void actionDoubleClickFile(List<FileSystemBrowser.Record<FSEntry>> recordPath) {
            if (recordPath.size() < 1) {
                throw new IllegalArgumentException("Empty path to file!");
            }
            String[] parentPath = new String[recordPath.size() - 1];
            int i2 = 0;
            for (FileSystemBrowser.Record<FSEntry> curEntry : recordPath) {
                if (i2 >= parentPath.length) {
                    break;
                }
                int i3 = i2;
                i2++;
                parentPath[i3] = curEntry.getUserObject().getName();
            }
            FileSystemBrowser.Record<FSEntry> record = recordPath.get(recordPath.size() - 1);
            FSEntry entry = record.getUserObject();
            if (entry instanceof FSFile) {
                FileSystemBrowserWindow.this.actionDoubleClickFile(parentPath, (FSFile) entry);
            } else if (entry instanceof FSLink) {
                FSLink link = (FSLink) entry;
                FSEntry linkTarget = link.getLinkTarget(parentPath);
                if (linkTarget == null) {
                    JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "The link you clicked is broken.", "Error", 0);
                } else if (linkTarget instanceof FSFile) {
                    FileSystemBrowserWindow.this.actionDoubleClickFile(parentPath, (FSFile) linkTarget);
                } else {
                    throw new RuntimeException("Unexpected FSEntry link target: " + entry.getClass());
                }
            } else {
                throw new RuntimeException("Unexpected FSEntry type: " + entry.getClass());
            }
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowser.FileSystemProvider
        public void actionExtractToDir(List<FileSystemBrowser.Record<FSEntry>> parentPathList, List<FileSystemBrowser.Record<FSEntry>> recordList) {
            String[] parentPath = getFSPath(parentPathList);
            List<FSEntry> fsEntryList = new ArrayList<>(recordList.size());
            for (FileSystemBrowser.Record<FSEntry> rec : recordList) {
                fsEntryList.add(rec.getUserObject());
            }
            FileSystemBrowserWindow.this.actionExtractToDir(parentPath, fsEntryList, true, false);
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowser.FileSystemProvider
        public void actionGetInfo(List<FileSystemBrowser.Record<FSEntry>> parentPathList, List<FileSystemBrowser.Record<FSEntry>> recordList) {
            List<FSEntry> entryList = new ArrayList<>(recordList.size());
            for (FileSystemBrowser.Record<FSEntry> rec : recordList) {
                entryList.add(rec.getUserObject());
            }
            FileSystemBrowserWindow.this.actionGetInfo(getFSPath(parentPathList), entryList);
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowser.FileSystemProvider
        public JPopupMenu getRightClickRecordPopupMenu(List<FileSystemBrowser.Record<FSEntry>> parentPathList, List<FileSystemBrowser.Record<FSEntry>> recordList) {
            final String[] parentPath = getFSPath(parentPathList);
            final ArrayList<FSEntry> userObjectList = new ArrayList<>(recordList.size());
            for (FileSystemBrowser.Record<FSEntry> rec : recordList) {
                userObjectList.add(rec.getUserObject());
            }
            JPopupMenu jpm = new JPopupMenu();
            JMenuItem infoItem = new JMenuItem("Information");
            infoItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.FileSystemProvider.1
                public void actionPerformed(ActionEvent e2) {
                    FileSystemBrowserWindow.this.actionGetInfo(parentPath, userObjectList);
                }
            });
            jpm.add(infoItem);
            JMenuItem dataExtractItem = new JMenuItem("Extract data");
            dataExtractItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.FileSystemProvider.2
                public void actionPerformed(ActionEvent e2) {
                    FileSystemBrowserWindow.this.actionExtractToDir(parentPath, userObjectList, true, false);
                }
            });
            jpm.add(dataExtractItem);
            JMenuItem resExtractItem = new JMenuItem("Extract resource fork(s)");
            resExtractItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.FileSystemProvider.3
                public void actionPerformed(ActionEvent e2) {
                    FileSystemBrowserWindow.this.actionExtractToDir(parentPath, userObjectList, false, true);
                }
            });
            jpm.add(resExtractItem);
            JMenuItem bothExtractItem = new JMenuItem("Extract data and resource fork(s)");
            bothExtractItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.FileSystemProvider.4
                public void actionPerformed(ActionEvent e2) {
                    FileSystemBrowserWindow.this.actionExtractToDir(parentPath, userObjectList, true, true);
                }
            });
            jpm.add(bothExtractItem);
            return jpm;
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowser.FileSystemProvider
        public boolean isFileSystemLoaded() {
            return FileSystemBrowserWindow.this.fsHandler != null;
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowser.FileSystemProvider
        public List<FileSystemBrowser.Record<FSEntry>> getFolderContents(List<FileSystemBrowser.Record<FSEntry>> folderRecordPath) {
            FSEntry lastEntry = folderRecordPath.get(folderRecordPath.size() - 1).getUserObject();
            if (lastEntry instanceof FSLink) {
                String[] parentPath = getFSPath(folderRecordPath, folderRecordPath.size() - 1);
                FSEntry linkTarget = ((FSLink) lastEntry).getLinkTarget(parentPath);
                if (linkTarget == null) {
                    JOptionPane.showMessageDialog(FileSystemBrowserWindow.this, "The link you clicked is broken.", "Error", 0);
                    throw new RuntimeException("Broken link");
                } else if (linkTarget instanceof FSFolder) {
                    lastEntry = linkTarget;
                } else {
                    throw new RuntimeException("Tried to get folder contents for link target type " + lastEntry.getClass());
                }
            }
            if (lastEntry instanceof FSFolder) {
                String[] folderPath = getFSPath(folderRecordPath);
                FSEntry[] entryArray = ((FSFolder) lastEntry).listEntries();
                ArrayList<FileSystemBrowser.Record<FSEntry>> entryList = new ArrayList<>(entryArray.length);
                for (FSEntry entry : entryArray) {
                    FileSystemBrowser.Record<FSEntry> rec = new FSEntryRecord(entry, folderPath);
                    entryList.add(rec);
                }
                return entryList;
            }
            throw new RuntimeException("Tried to get folder contents for type " + lastEntry.getClass());
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowser.FileSystemProvider
        public String getAddressPath(List<String> pathComponents) {
            StringBuilder sb = new StringBuilder("/");
            for (String name : pathComponents) {
                sb.append(FileSystemBrowserWindow.this.fsHandler.generatePosixPathnameComponent(name));
                sb.append("/");
            }
            return sb.toString();
        }

        @Override // org.catacombae.hfsexplorer.FileSystemBrowser.FileSystemProvider
        public String[] parseAddressPath(String targetAddress) {
            if (!targetAddress.startsWith("/")) {
                return null;
            }
            String remainder = targetAddress.substring(1);
            if (remainder.length() == 0) {
                return new String[0];
            }
            String[] res = remainder.split("/");
            for (int i2 = 0; i2 < res.length; i2++) {
                res[i2] = FileSystemBrowserWindow.this.fsHandler.parsePosixPathnameComponent(res[i2]);
            }
            return res;
        }

        private String[] getFSPath(List<FileSystemBrowser.Record<FSEntry>> fsbPathList) {
            if (fsbPathList == null) {
                return null;
            }
            return getFSPath(fsbPathList, fsbPathList.size());
        }

        private String[] getFSPath(List<FileSystemBrowser.Record<FSEntry>> fsbPathList, int len) {
            if (len < 1) {
                throw new IllegalArgumentException("A FileSystemBrowser parent path list must have at least one component (the root folder).");
            }
            if (fsbPathList == null) {
                return null;
            }
            String[] res = new String[len - 1];
            Iterator<FileSystemBrowser.Record<FSEntry>> it = fsbPathList.iterator();
            it.next();
            for (int i2 = 0; i2 < res.length; i2++) {
                res[i2] = it.next().getUserObject().getName();
            }
            while (it.hasNext()) {
                it.next();
            }
            return res;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$FSEntryRecord.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowserWindow$FSEntryRecord.class */
    private static class FSEntryRecord extends FileSystemBrowser.Record<FSEntry> {
        public FSEntryRecord(FSEntry entry, String[] parentDirPath) {
            super(entryTypeToRecordType(entry, parentDirPath), entry.getName(), getEntrySize(entry, parentDirPath), entry.getAttributes().getModifyDate(), entry);
        }

        public static FileSystemBrowser.RecordType entryTypeToRecordType(FSEntry entry, String[] parentDirPath) {
            if (entry instanceof FSFile) {
                return FileSystemBrowser.RecordType.FILE;
            }
            if (entry instanceof FSFolder) {
                return FileSystemBrowser.RecordType.FOLDER;
            }
            if (entry instanceof FSLink) {
                FSLink fsl = (FSLink) entry;
                FSEntry linkTarget = fsl.getLinkTarget(parentDirPath);
                if (linkTarget == null) {
                    return FileSystemBrowser.RecordType.BROKEN_LINK;
                }
                if (linkTarget instanceof FSFile) {
                    return FileSystemBrowser.RecordType.FILE_LINK;
                }
                if (linkTarget instanceof FSFolder) {
                    return FileSystemBrowser.RecordType.FOLDER_LINK;
                }
                throw new IllegalArgumentException("Unsupported FSEntry link target: " + entry.getClass());
            }
            throw new IllegalArgumentException("Unsupported FSEntry type: " + entry.getClass());
        }

        public static long getEntrySize(FSEntry entry, String[] parentDirPath) {
            if (entry instanceof FSFile) {
                return ((FSFile) entry).getMainFork().getLength();
            }
            if (entry instanceof FSFolder) {
                return 0L;
            }
            if (entry instanceof FSLink) {
                FSLink fsl = (FSLink) entry;
                FSEntry linkTarget = fsl.getLinkTarget(parentDirPath);
                if (linkTarget == null) {
                    return 0L;
                }
                if (linkTarget instanceof FSFile) {
                    return ((FSFile) linkTarget).getMainFork().getLength();
                }
                if (linkTarget instanceof FSFolder) {
                    return 0L;
                }
                throw new IllegalArgumentException("Unsupported FSEntry link target: " + entry.getClass());
            }
            throw new IllegalArgumentException("Unsupported FSEntry type: " + entry.getClass());
        }
    }

    public static void main(String[] args) {
        FileSystemBrowserWindow fsbWindow;
        String pathNameTmp;
        if (System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e2) {
        }
        int parsedArgs = 0;
        if (args.length > 0 && args[0].equals("-dbgconsole")) {
            DebugConsoleWindow dcw = new DebugConsoleWindow(System.err);
            System.setOut(new PrintStream(dcw.getDebugStream()));
            System.setErr(new PrintStream(dcw.getDebugStream()));
            fsbWindow = new FileSystemBrowserWindow(dcw);
            parsedArgs = 0 + 1;
        } else {
            fsbWindow = new FileSystemBrowserWindow();
        }
        fsbWindow.setVisible(true);
        if (args.length > parsedArgs) {
            String filename = args[parsedArgs];
            try {
                try {
                    pathNameTmp = new File(filename).getCanonicalPath();
                } catch (Exception ioe) {
                    if (ioe.getMessage().equals("Could not open file.")) {
                        JOptionPane.showMessageDialog(fsbWindow, "Failed to open file:\n\"" + filename + "\"", "Error", 0);
                        return;
                    }
                    ioe.printStackTrace();
                    String msg = "Exception while loading file:\n    \"" + filename + "\"\n" + ioe.toString();
                    StackTraceElement[] arr$ = ioe.getStackTrace();
                    for (StackTraceElement ste : arr$) {
                        msg = msg + "\n" + ste.toString();
                    }
                    JOptionPane.showMessageDialog(fsbWindow, msg, "Exception while loading file", 0);
                    return;
                }
            } catch (Exception e3) {
                pathNameTmp = filename;
            }
            final String pathName = pathNameTmp;
            SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.FileSystemBrowserWindow.21
                @Override // java.lang.Runnable
                public void run() {
                    FileSystemBrowserWindow.this.loadFSWithUDIFAutodetect(pathName);
                }
            });
        }
    }
}
