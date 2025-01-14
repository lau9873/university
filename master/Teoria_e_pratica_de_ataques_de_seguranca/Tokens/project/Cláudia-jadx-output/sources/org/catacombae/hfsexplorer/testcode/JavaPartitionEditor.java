package org.catacombae.hfsexplorer.testcode;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/JavaPartitionEditor.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/JavaPartitionEditor.class */
public class JavaPartitionEditor extends JPanel {
    private JScrollPane jScrollPane1;
    private JTable jTable1;

    public JavaPartitionEditor() {
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jTable1.setModel(new DefaultTableModel(new Object[]{new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}}, new String[]{"Number", "Type", "Offset", "Length"}) { // from class: org.catacombae.hfsexplorer.testcode.JavaPartitionEditor.1
            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.jScrollPane1.setViewportView(this.jTable1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jScrollPane1, -1, 505, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jScrollPane1, -2, 260, -2).addContainerGap(92, 32767)));
    }
}
