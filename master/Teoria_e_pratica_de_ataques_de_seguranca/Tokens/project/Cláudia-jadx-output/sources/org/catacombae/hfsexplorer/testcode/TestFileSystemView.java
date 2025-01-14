package org.catacombae.hfsexplorer.testcode;

import java.awt.Component;
import java.awt.EventQueue;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/TestFileSystemView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/TestFileSystemView.class */
public class TestFileSystemView extends JFrame {
    private JLabel fileIconLabel;
    private JLabel folderIconLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/TestFileSystemView$FakeFile.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/TestFileSystemView$FakeFile.class */
    private class FakeFile extends File {
        private boolean isDirectory;

        public FakeFile(boolean dir) {
            super(".");
            this.isDirectory = dir;
        }

        @Override // java.io.File
        public boolean isDirectory() {
            return this.isDirectory;
        }
    }

    public TestFileSystemView() {
        initComponents();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        this.fileIconLabel.setIcon(fsv.getSystemIcon(new File("file.withcompletelyunknownextension")));
        this.folderIconLabel.setIcon(fsv.getSystemIcon(new File("lib/")));
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.folderIconLabel = new JLabel();
        this.fileIconLabel = new JLabel();
        setDefaultCloseOperation(3);
        this.jLabel1.setText("Icon for virtual folder:");
        this.jLabel2.setText("Icon for virtual file:");
        this.folderIconLabel.setText("jLabel3");
        this.fileIconLabel.setText("jLabel4");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2).add((Component) this.jLabel2).add((Component) this.jLabel1)).addPreferredGap(0).add(layout.createParallelGroup(1).add((Component) this.folderIconLabel).add((Component) this.fileIconLabel)).addContainerGap(69, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.jLabel1).add((Component) this.folderIconLabel)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.jLabel2).add((Component) this.fileIconLabel)).addContainerGap(29, 32767)));
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.testcode.TestFileSystemView.1
            @Override // java.lang.Runnable
            public void run() {
                new TestFileSystemView().setVisible(true);
            }
        });
    }
}
