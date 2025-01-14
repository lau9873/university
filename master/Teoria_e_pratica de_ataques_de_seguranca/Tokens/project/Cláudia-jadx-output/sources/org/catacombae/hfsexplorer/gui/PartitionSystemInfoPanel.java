package org.catacombae.hfsexplorer.gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/PartitionSystemInfoPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/PartitionSystemInfoPanel.class */
public class PartitionSystemInfoPanel extends JPanel {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextField1;

    public PartitionSystemInfoPanel() {
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTextField1 = new JTextField();
        this.jPanel1 = new JPanel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jTextField1.setEditable(false);
        this.jTextField1.setHorizontalAlignment(0);
        this.jTextField1.setText("GUID Partition Table");
        this.jTextField1.setBorder((Border) null);
        this.jTextField1.setOpaque(false);
        this.jPanel1.setBackground(new Color(255, 255, 255));
        this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.jButton1.setText("EFI Partition");
        this.jButton2.setText("HFS+ partition");
        this.jButton3.setText("NTFS partition");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createSequentialGroup().add((Component) this.jButton1).addPreferredGap(0).add(this.jButton2, -2, 127, -2).addPreferredGap(0).add(this.jButton3, -1, 307, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(jPanel1Layout.createParallelGroup(3).add(this.jButton1, -1, 54, 32767).add(this.jButton2, -1, 54, 32767)).add(this.jButton3, -1, 54, 32767));
        this.jTable1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}}, new String[]{"Number", "Name", "Type", "GUID Identifier"}));
        this.jScrollPane1.setViewportView(this.jTable1);
        this.jLabel1.setText("Detailed info here");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(112, 112, 112).add((Component) this.jLabel1).addContainerGap(344, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(1).add(jPanel2Layout.createSequentialGroup().add(28, 28, 28).add((Component) this.jLabel1).addContainerGap(74, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2).add(1, this.jScrollPane1, -1, 541, 32767).add(1, this.jPanel2, -1, -1, 32767).add(1, this.jPanel1, -1, -1, 32767).add(1, this.jTextField1, -1, 541, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jTextField1, -2, -1, -2).addPreferredGap(0).add(this.jPanel1, -2, -1, -2).addPreferredGap(0).add(this.jScrollPane1, -1, 175, 32767).addPreferredGap(0).add(this.jPanel2, -2, -1, -2).addContainerGap()));
    }
}
