package org.catacombae.hfsexplorer;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.catacombae.hfsexplorer.ExtractProgressMonitor;
import org.catacombae.hfsexplorer.gui.ExtractProgressPanel;
import org.catacombae.hfsexplorer.gui.ExtractSettingsPanel;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressDialog.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/ExtractProgressDialog.class */
public class ExtractProgressDialog extends JDialog implements ExtractProgressMonitor {
    private final ExtractProgressPanel progressPanel;
    private final ExtractSettingsPanel settingsPanel;
    private final ExtractProgressMonitor.ExtractProperties extractProperties;
    private final JButton cancelButton;
    private volatile boolean cancelSignaled;
    private long completedSize;
    private long totalSize;
    private DecimalFormat sizeFormatter;

    public ExtractProgressDialog(Frame owner) {
        this(owner, false);
    }

    private ExtractProgressDialog(Frame owner, boolean modal) {
        super(owner, "Extracting...", modal);
        this.cancelSignaled = false;
        this.completedSize = 0L;
        this.totalSize = -1L;
        this.sizeFormatter = new DecimalFormat("0.00");
        final JPanel backgroundPanel = new JPanel();
        this.extractProperties = new ExtractProgressMonitor.ExtractProperties();
        this.progressPanel = new ExtractProgressPanel();
        this.settingsPanel = new ExtractSettingsPanel(this.extractProperties);
        this.cancelButton = this.progressPanel.cancelButton;
        this.cancelButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.ExtractProgressDialog.1
            public void actionPerformed(ActionEvent ae) {
                ExtractProgressDialog.this.signalCancel();
            }
        });
        this.progressPanel.addShowSettingsButtonListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.ExtractProgressDialog.2
            public void actionPerformed(ActionEvent e2) {
                boolean selected = ExtractProgressDialog.this.progressPanel.getShowSettingsButtonSelected();
                if (selected) {
                    backgroundPanel.add(ExtractProgressDialog.this.settingsPanel);
                } else {
                    backgroundPanel.remove(ExtractProgressDialog.this.settingsPanel);
                }
                ExtractProgressDialog.this.pack();
            }
        });
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, 3));
        backgroundPanel.add(this.progressPanel);
        setDefaultCloseOperation(0);
        addWindowListener(new WindowAdapter() { // from class: org.catacombae.hfsexplorer.ExtractProgressDialog.3
            public void windowClosing(WindowEvent we) {
                ExtractProgressDialog.this.requestCloseWindow();
            }
        });
        add(backgroundPanel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void updateCalculateDir(String dirname) {
        this.progressPanel.updateCalculateDir(dirname);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void updateTotalProgress(double fraction, String message) {
        this.progressPanel.updateTotalProgress(fraction, message);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void updateCurrentDir(String dirname) {
        this.progressPanel.updateCurrentDir(dirname);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void updateCurrentFile(String filename, long fileSize) {
        this.progressPanel.updateCurrentFile(filename, fileSize);
    }

    @Override // org.catacombae.hfsexplorer.fs.ProgressMonitor
    public synchronized void signalCancel() {
        this.cancelButton.setEnabled(false);
        this.cancelSignaled = true;
    }

    @Override // org.catacombae.hfsexplorer.fs.ProgressMonitor
    public boolean cancelSignaled() {
        return this.cancelSignaled;
    }

    @Override // org.catacombae.hfsexplorer.fs.ProgressMonitor
    public void confirmCancel() {
        if (isVisible()) {
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void requestCloseWindow() {
        if (!this.cancelSignaled) {
            signalCancel();
        }
        dispose();
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public void setDataSize(long totalSize) {
        this.totalSize = totalSize;
        addDataProgress(0L);
    }

    @Override // org.catacombae.hfsexplorer.fs.ProgressMonitor
    public void addDataProgress(long dataSize) {
        this.completedSize += dataSize;
        String message = SpeedUnitUtils.bytesToBinaryUnit(this.completedSize, this.sizeFormatter) + "/" + SpeedUnitUtils.bytesToBinaryUnit(this.totalSize, this.sizeFormatter);
        updateTotalProgress(this.completedSize / this.totalSize, message);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.CreateDirectoryFailedAction createDirectoryFailed(String dirname, File parentDirectory) {
        return SimpleGUIProgressMonitor.createDirectoryFailed(this, dirname, parentDirectory);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.CreateFileFailedAction createFileFailed(String filename, File parentDirectory) {
        return SimpleGUIProgressMonitor.createFileFailed(this, filename, parentDirectory);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.DirectoryExistsAction directoryExists(File directory) {
        return SimpleGUIProgressMonitor.directoryExists(this, directory);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.FileExistsAction fileExists(File file) {
        return SimpleGUIProgressMonitor.fileExists(this, file);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public String displayRenamePrompt(String currentName, File outDir) {
        return SimpleGUIProgressMonitor.displayRenamePrompt(this, currentName, outDir);
    }

    @Override // org.catacombae.hfsexplorer.ExtractProgressMonitor
    public ExtractProgressMonitor.ExtractProperties getExtractProperties() {
        return this.extractProperties;
    }
}
