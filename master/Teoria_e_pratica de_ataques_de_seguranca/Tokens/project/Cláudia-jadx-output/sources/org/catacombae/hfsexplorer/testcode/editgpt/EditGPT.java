package org.catacombae.hfsexplorer.testcode.editgpt;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import org.catacombae.hfsexplorer.partitioning.GUIDPartitionTable;
import org.catacombae.hfsexplorer.partitioning.MutableGUIDPartitionTable;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.hfsexplorer.win32.WritableWin32File;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/editgpt/EditGPT.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/editgpt/EditGPT.class */
public class EditGPT extends JPanel {
    private GUIDPartitionTable originalGPT = null;
    private MutableGUIDPartitionTable modifiedGPT = null;
    private ContainerPanel containerPanel = new ContainerPanel();

    public EditGPT() {
        initComponents();
        add(this.containerPanel, "Center");
    }

    public void loadFile(File f2) {
        ReadableRandomAccessStream llf;
        if (WritableWin32File.isSystemSupported()) {
            llf = new WindowsLowLevelIO(f2.getAbsolutePath());
        } else {
            llf = new ReadableFileStream(f2.getAbsolutePath());
        }
        GUIDPartitionTable gpt = new GUIDPartitionTable(llf, 0);
        setFields(gpt);
    }

    private void initComponents() {
        setLayout(new BorderLayout());
    }

    private void setFields(GUIDPartitionTable gpt) {
        this.originalGPT = gpt;
        this.containerPanel.setFields(this.originalGPT.getStructElements());
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable th) {
        }
        File gptFile = new File(args[0]);
        JFrame jf = new JFrame("EditGPT");
        EditGPT egpt = new EditGPT();
        jf.add(new JScrollPane(egpt));
        egpt.loadFile(gptFile);
        jf.pack();
        jf.setLocationRelativeTo((Component) null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(3);
    }
}
