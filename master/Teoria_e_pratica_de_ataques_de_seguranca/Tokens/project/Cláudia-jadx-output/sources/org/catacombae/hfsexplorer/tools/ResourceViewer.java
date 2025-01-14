package org.catacombae.hfsexplorer.tools;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import org.catacombae.hfsexplorer.GUIUtil;
import org.catacombae.hfsexplorer.PrefixFileFilter;
import org.catacombae.hfsexplorer.fs.AppleSingleHandler;
import org.catacombae.hfsexplorer.fs.ResourceForkReader;
import org.catacombae.hfsexplorer.gui.ResourceForkViewPanel;
import org.catacombae.hfsexplorer.types.applesingle.EntryDescriptor;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/tools/ResourceViewer.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/tools/ResourceViewer.class */
public class ResourceViewer extends JFrame {
    private final ResourceForkViewPanel resourceForkViewPanel;
    private JPanel backgroundPanel;
    private JMenuBar menuBar;
    private JMenu openMenu;
    private JMenuItem openMenuItem;

    public ResourceViewer() {
        super("Resource Viewer");
        this.resourceForkViewPanel = new ResourceForkViewPanel(null);
        initComponents();
        this.openMenuItem.setAccelerator(KeyStroke.getKeyStroke(79, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        this.backgroundPanel.add(this.resourceForkViewPanel);
        this.openMenuItem.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.tools.ResourceViewer.1
            private JFileChooser jfc = new JFileChooser();

            {
                this.jfc.setFileSelectionMode(0);
                this.jfc.setMultiSelectionEnabled(false);
                this.jfc.setFileFilter(new PrefixFileFilter("AppleDouble resource forks (._*)", "._"));
            }

            public void actionPerformed(ActionEvent e2) {
                if (this.jfc.showOpenDialog(ResourceViewer.this) == 0) {
                    ResourceViewer.this.loadFile(this.jfc.getSelectedFile());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFile(File f2) {
        ReadableRandomAccessStream fileStream = null;
        ResourceForkReader reader = null;
        try {
            fileStream = new ReadableFileStream(f2);
            if (AppleSingleHandler.detectFileFormat(fileStream, 0L) != null) {
                try {
                    AppleSingleHandler handler = new AppleSingleHandler(fileStream);
                    EntryDescriptor desc = handler.getResourceEntryDescriptor();
                    if (desc != null) {
                        fileStream = handler.getEntryStream(desc);
                    }
                } catch (Exception e2) {
                    System.err.println("Unhandled exception while detecting AppleSingle format:");
                    e2.printStackTrace();
                }
            } else {
                int res = JOptionPane.showConfirmDialog(this, "Invalid AppleDouble file.\nDo you want to attempt to load the file as raw resource fork data?", "Invalid file format", 0, 2);
                if (res != 0) {
                    fileStream.close();
                    return;
                }
            }
            ResourceForkReader reader2 = new ResourceForkReader(fileStream);
            this.resourceForkViewPanel.loadResourceFork(reader2);
            setTitle("Resource Viewer - [" + f2.getName() + "]");
        } catch (Exception e3) {
            e3.printStackTrace();
            GUIUtil.displayExceptionDialog(e3, this);
            this.resourceForkViewPanel.loadResourceFork(null);
            if (0 != 0) {
                reader.close();
            }
            if (fileStream != null) {
                fileStream.close();
            }
        }
    }

    private void initComponents() {
        this.backgroundPanel = new JPanel();
        this.menuBar = new JMenuBar();
        this.openMenu = new JMenu();
        this.openMenuItem = new JMenuItem();
        setDefaultCloseOperation(3);
        this.backgroundPanel.setLayout(new BorderLayout());
        this.openMenu.setText("File");
        this.openMenuItem.setText("Open...");
        this.openMenu.add(this.openMenuItem);
        this.menuBar.add(this.openMenu);
        setJMenuBar(this.menuBar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(this.backgroundPanel, -1, 377, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(this.backgroundPanel, -1, 279, 32767));
        pack();
    }

    public static void main(final String[] args) {
        if (System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e2) {
        }
        EventQueue.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.tools.ResourceViewer.2
            @Override // java.lang.Runnable
            public void run() {
                ResourceViewer rv = new ResourceViewer();
                rv.pack();
                rv.setLocationRelativeTo(null);
                rv.setVisible(true);
                if (args.length > 0) {
                    rv.loadFile(new File(args[0]));
                }
            }
        });
    }
}
