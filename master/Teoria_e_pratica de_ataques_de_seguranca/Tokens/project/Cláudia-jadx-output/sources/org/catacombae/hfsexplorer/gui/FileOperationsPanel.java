package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/FileOperationsPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/FileOperationsPanel.class */
public class FileOperationsPanel extends JPanel {
    private JTextField filenameField;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton openFileButton;
    private JButton saveFileButton;
    private JTextField sizeField;

    public FileOperationsPanel(JDialog dialog, String filename, long fileSize, ActionListener openListener, ActionListener saveListener) {
        initComponents();
        this.filenameField.setText(filename);
        this.sizeField.setText("" + fileSize + " bytes");
        if (openListener != null) {
            this.openFileButton.addActionListener(openListener);
            this.openFileButton.setEnabled(true);
            dialog.getRootPane().setDefaultButton(this.openFileButton);
        } else {
            dialog.getRootPane().setDefaultButton(this.saveFileButton);
        }
        this.saveFileButton.addActionListener(saveListener);
    }

    private void initComponents() {
        this.openFileButton = new JButton();
        this.saveFileButton = new JButton();
        this.jLabel1 = new JLabel();
        this.filenameField = new JTextField();
        this.jLabel2 = new JLabel();
        this.sizeField = new JTextField();
        this.openFileButton.setText("Open file");
        this.openFileButton.setToolTipText("Extracts the file to a temporary folder and\nopens it with the platform's default helper");
        this.openFileButton.setEnabled(false);
        this.saveFileButton.setText("Save file to...");
        this.jLabel1.setText("Filename:");
        this.filenameField.setEditable(false);
        this.filenameField.setText("jTextField1");
        this.filenameField.setBorder((Border) null);
        this.filenameField.setOpaque(false);
        this.jLabel2.setText("Size:");
        this.sizeField.setEditable(false);
        this.sizeField.setText("jTextField2");
        this.sizeField.setBorder((Border) null);
        this.sizeField.setOpaque(false);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.openFileButton).addPreferredGap(0).add((Component) this.saveFileButton)).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add((Component) this.jLabel1).add((Component) this.jLabel2)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.sizeField, -1, 275, 32767).add(this.filenameField, -1, 275, 32767)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.jLabel1).add(this.filenameField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.jLabel2).add(this.sizeField, -2, -1, -2)).addPreferredGap(0, -1, 32767).add(layout.createParallelGroup(3).add((Component) this.openFileButton).add((Component) this.saveFileButton)).addContainerGap()));
    }
}
