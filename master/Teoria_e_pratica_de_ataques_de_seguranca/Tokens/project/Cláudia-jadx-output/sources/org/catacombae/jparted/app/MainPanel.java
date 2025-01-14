package org.catacombae.jparted.app;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/app/MainPanel.class */
public class MainPanel extends JPanel {
    private final PartitionTableModel partitionTableModel;
    private JScrollPane jScrollPane1;
    private JComboBox partitionSystemsBox;
    private JLabel partitionSystemsLabel;
    private JTable partitionTable;
    private JButton synchronizeButton;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainPanel$PartitionTableRow.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/app/MainPanel$PartitionTableRow.class */
    private class PartitionTableRow {
        public String number;
        public String type;
        public String name;
        public String start;
        public String end;

        public PartitionTableRow(String number, String type, String name, String start, String end) {
            this.number = number;
            this.type = type;
            this.name = name;
            this.start = start;
            this.end = end;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainPanel$PartitionTableModel.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/app/MainPanel$PartitionTableModel.class */
    private class PartitionTableModel extends DefaultTableModel {
        private PartitionTableModel() {
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }
    }

    public MainPanel() {
        initComponents();
        this.partitionTableModel = new PartitionTableModel();
        this.partitionTableModel.setColumnIdentifiers(new String[]{"Number", "Type", "Name", "Start", "End"});
        this.partitionTable.setModel(this.partitionTableModel);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.partitionSystemsLabel = new JLabel();
        this.partitionSystemsBox = new JComboBox();
        this.synchronizeButton = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.partitionTable = new JTable();
        this.partitionSystemsLabel.setText("Detected partition systems:");
        this.partitionSystemsBox.setModel(new DefaultComboBoxModel(new String[]{"GUID Partition Table (6 partitions)", "Protective MBR (4 partitions)"}));
        this.synchronizeButton.setText("Synchronize");
        this.partitionTable.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[]{null, null, null, null, null}, new Object[]{null, null, null, null, null}, new Object[]{null, null, null, null, null}, new Object[]{null, null, null, null, null}}, new String[]{"Number", "Type", "Name", "Start", "End"}));
        this.jScrollPane1.setViewportView(this.partitionTable);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.partitionSystemsLabel).addPreferredGap(0).add(this.partitionSystemsBox, 0, 285, 32767).addPreferredGap(0).add((Component) this.synchronizeButton).addContainerGap()).add(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jScrollPane1, -1, 571, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.synchronizeButton).add(this.partitionSystemsBox, -2, -1, -2).add((Component) this.partitionSystemsLabel)).addContainerGap(260, 32767)).add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(76, 76, 76).add(this.jScrollPane1, -2, 211, -2).addContainerGap(-1, 32767))));
    }

    public void setPartitionSystemsBoxContents(Vector<String> contents) {
        this.partitionSystemsBox.removeAllItems();
        Iterator i$ = contents.iterator();
        while (i$.hasNext()) {
            String currentItem = i$.next();
            this.partitionSystemsBox.addItem(currentItem);
        }
    }

    public void setPartitionSystemsBoxEnabled(boolean enabled) {
        this.partitionSystemsBox.setEnabled(enabled);
    }

    public void setSynchronizeButtonEnabled(boolean enabled) {
        this.synchronizeButton.setEnabled(enabled);
    }

    public void setPartitionSystemsBoxListener(ActionListener listener) {
        ActionListener[] arr$ = this.partitionSystemsBox.getActionListeners();
        for (ActionListener al : arr$) {
            this.partitionSystemsBox.removeActionListener(al);
        }
        this.partitionSystemsBox.addActionListener(listener);
    }

    public void setSynchronizeButtonListener(ActionListener listener) {
        ActionListener[] arr$ = this.synchronizeButton.getActionListeners();
        for (ActionListener al : arr$) {
            this.synchronizeButton.removeActionListener(al);
        }
        this.synchronizeButton.addActionListener(listener);
    }

    public void clearPartitionList() {
        int rowCount = this.partitionTableModel.getRowCount();
        for (int i2 = rowCount - 1; i2 >= 0; i2--) {
            this.partitionTableModel.removeRow(i2);
        }
    }

    public void addPartition(String number, String type, String name, String start, String end) {
        this.partitionTableModel.addRow(new String[]{number, type, name, start, end});
    }
}
