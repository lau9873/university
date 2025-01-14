package org.catacombae.jparted.app;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/TreeViewConcept.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/app/TreeViewConcept.class */
public class TreeViewConcept extends JPanel {
    private JScrollPane jScrollPane1;
    private JTree jTree1;

    public TreeViewConcept() {
        initComponents();
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("File [/Users/erik/totalimage.dmg]", true);
        DefaultMutableTreeNode udifNode = new DefaultMutableTreeNode("UDIF Backing Store [type=UDBZ]", true);
        rootNode.add(udifNode);
        DefaultMutableTreeNode mbrNode = new DefaultMutableTreeNode("MBR Partition Table [4 partitions]", true);
        udifNode.add(mbrNode);
        mbrNode.add(new DefaultMutableTreeNode("1. Microsoft Basic Data", false));
        mbrNode.add(new DefaultMutableTreeNode("2. HFS+ File System", false));
        DefaultMutableTreeNode lvmNode = new DefaultMutableTreeNode("3. Linux LVM Volume Manager [3 partitions]", true);
        mbrNode.add(lvmNode);
        lvmNode.add(new DefaultMutableTreeNode("1. Linux Ext3 File System", false));
        lvmNode.add(new DefaultMutableTreeNode("2. Linux Swap Partition", false));
        lvmNode.add(new DefaultMutableTreeNode("3. Linux ReiserFS File System", false));
        DefaultMutableTreeNode dosxNode = new DefaultMutableTreeNode("4. DOS Extended Partition Table [2 partitions]", true);
        mbrNode.add(dosxNode);
        dosxNode.add(new DefaultMutableTreeNode("1. FAT32 File System", false));
        dosxNode.add(new DefaultMutableTreeNode("2. FAT16 File System", false));
        DefaultMutableTreeNode gptNode = new DefaultMutableTreeNode("GPT Partition Table [6 partitions]", true);
        udifNode.add(gptNode);
        gptNode.add(new DefaultMutableTreeNode("1. Microsoft Basic Data", false));
        gptNode.add(new DefaultMutableTreeNode("2. HFS+ File System", false));
        DefaultMutableTreeNode lvmNode2 = new DefaultMutableTreeNode("3. Linux LVM Volume Manager [3 partitions]", true);
        gptNode.add(lvmNode2);
        lvmNode2.add(new DefaultMutableTreeNode("1. Linux Ext3 File System", false));
        lvmNode2.add(new DefaultMutableTreeNode("2. Linux Swap Partition", false));
        lvmNode2.add(new DefaultMutableTreeNode("3. Linux ReiserFS File System", false));
        gptNode.add(new DefaultMutableTreeNode("4. FAT32 File System", false));
        gptNode.add(new DefaultMutableTreeNode("5. FAT16 File System", false));
        this.jTree1.setModel(new DefaultTreeModel(rootNode));
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jTree1 = new JTree();
        this.jTree1.setModel((TreeModel) null);
        this.jScrollPane1.setViewportView(this.jTree1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jScrollPane1, -1, 360, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jScrollPane1, -2, 183, -2).addContainerGap(112, 32767)));
    }

    public static void main(String[] args) {
        JFrame w = new JFrame("jParted Tree view concept");
        w.add(new TreeViewConcept());
        w.pack();
        w.setLocationRelativeTo((Component) null);
        w.setDefaultCloseOperation(3);
        w.setVisible(true);
    }
}
