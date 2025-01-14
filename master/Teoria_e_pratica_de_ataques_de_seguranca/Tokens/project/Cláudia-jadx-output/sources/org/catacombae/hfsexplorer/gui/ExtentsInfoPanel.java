package org.catacombae.hfsexplorer.gui;

import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.PrintStream;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.hfsexplorer.FileSystemBrowser;
import org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView;
import org.catacombae.hfsexplorer.io.JTextAreaOutputStream;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTIndexRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNodeDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentIndexNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentKey;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafNode;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentLeafRecord;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtentsInfoPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtentsInfoPanel.class */
public class ExtentsInfoPanel extends JPanel {
    private static final int UNIT_INCREMENT = 10;
    public JTree catalogTree;
    private JScrollPane catalogTreeScroller;
    private JLabel descriptionLabel;
    private JPanel infoPanel;
    private JPanel jPanel1;
    private JSplitPane jSplitPane1;

    public ExtentsInfoPanel(final BaseHFSFileSystemView fsView) {
        initComponents();
        JTree dirTree = this.catalogTree;
        CommonBTNode iNode = fsView.getExtentsOverflowNode(-1L);
        if (iNode == null) {
            DefaultTreeModel model = new DefaultTreeModel(new FileSystemBrowser.NoLeafMutableTreeNode("<empty>"));
            dirTree.setModel(model);
            return;
        }
        DefaultMutableTreeNode rootNode = new FileSystemBrowser.NoLeafMutableTreeNode(new BTNodeStorage(iNode, "Extents overflow root"));
        expandNode(rootNode, iNode, fsView);
        DefaultTreeModel model2 = new DefaultTreeModel(rootNode);
        dirTree.setModel(model2);
        dirTree.addTreeWillExpandListener(new TreeWillExpandListener() { // from class: org.catacombae.hfsexplorer.gui.ExtentsInfoPanel.1
            public void treeWillExpand(TreeExpansionEvent e2) throws ExpandVetoException {
                TreePath tp = e2.getPath();
                Object obj = tp.getLastPathComponent();
                if (obj instanceof DefaultMutableTreeNode) {
                    DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) obj;
                    Object obj2 = dmtn.getUserObject();
                    if (obj2 instanceof BTNodeStorage) {
                        CommonBTNode node = ((BTNodeStorage) obj2).getNode();
                        ExtentsInfoPanel.this.expandNode(dmtn, node, fsView);
                        return;
                    }
                    throw new RuntimeException("Wrong user object type in expandable node!");
                }
                throw new RuntimeException("Wrong node type in tree!");
            }

            public void treeWillCollapse(TreeExpansionEvent e2) {
            }
        });
        final CardLayout clRoot = new CardLayout();
        final JPanel leafPanel = new JPanel();
        final CardLayout clLeaf = new CardLayout();
        leafPanel.setLayout(clLeaf);
        leafPanel.add(new JLabel("INTERNAL ERROR!", 0), "other");
        leafPanel.add(new JLabel("Displaying file thread information is not yet supported.", 0), "filethread");
        leafPanel.add(new JLabel("Displaying folder thread information is not yet supported.", 0), "folderthread");
        final JScrollPane structViewPanelScroller = new JScrollPane();
        structViewPanelScroller.getVerticalScrollBar().setUnitIncrement(10);
        structViewPanelScroller.getHorizontalScrollBar().setUnitIncrement(10);
        leafPanel.add(structViewPanelScroller, "structview");
        FileInfoPanel fileInfoPanel = new FileInfoPanel();
        JScrollPane fileInfoPanelScroller = new JScrollPane(fileInfoPanel);
        fileInfoPanelScroller.getVerticalScrollBar().setUnitIncrement(10);
        fileInfoPanelScroller.getHorizontalScrollBar().setUnitIncrement(10);
        leafPanel.add(fileInfoPanelScroller, "file");
        FolderInfoPanel folderInfoPanel = new FolderInfoPanel();
        JScrollPane folderInfoPanelScroller = new JScrollPane(folderInfoPanel);
        folderInfoPanelScroller.getVerticalScrollBar().setUnitIncrement(10);
        folderInfoPanelScroller.getHorizontalScrollBar().setUnitIncrement(10);
        leafPanel.add(folderInfoPanelScroller, "folder");
        final JTextArea printFieldsTextArea = new JTextArea(0, 0);
        printFieldsTextArea.setEditable(false);
        printFieldsTextArea.setLineWrap(false);
        JScrollPane printFieldsTextAreaScroller = new JScrollPane(printFieldsTextArea);
        printFieldsTextAreaScroller.getVerticalScrollBar().setUnitIncrement(10);
        printFieldsTextAreaScroller.getHorizontalScrollBar().setUnitIncrement(10);
        leafPanel.add(printFieldsTextAreaScroller, "printfieldsarea");
        this.infoPanel.setLayout(clRoot);
        final JLabel indexNodeLabel = new JLabel("No selection.", 0);
        this.infoPanel.add(indexNodeLabel, DatabaseFieldConfigLoader.FIELD_NAME_INDEX);
        this.infoPanel.add(leafPanel, "leaf");
        this.catalogTree.addTreeSelectionListener(new TreeSelectionListener() { // from class: org.catacombae.hfsexplorer.gui.ExtentsInfoPanel.2
            public void valueChanged(TreeSelectionEvent te) {
                Object o = te.getPath().getLastPathComponent();
                if (o instanceof DefaultMutableTreeNode) {
                    Object o2 = ((DefaultMutableTreeNode) o).getUserObject();
                    if (o2 instanceof BTNodeStorage) {
                        CommonBTNode btn = ((BTNodeStorage) o2).getNode();
                        CommonBTNodeDescriptor btnd = btn.getNodeDescriptor();
                        switch (AnonymousClass3.$SwitchMap$org$catacombae$hfsexplorer$types$hfscommon$CommonBTNodeDescriptor$NodeType[btnd.getNodeType().ordinal()]) {
                            case 1:
                                indexNodeLabel.setText("Index node with " + btnd.getNumberOfRecords() + " records.");
                                break;
                            case 2:
                                indexNodeLabel.setText("Leaf node with " + btnd.getNumberOfRecords() + " records.");
                                break;
                            default:
                                indexNodeLabel.setText("Unknown error!");
                                break;
                        }
                        clRoot.show(ExtentsInfoPanel.this.infoPanel, DatabaseFieldConfigLoader.FIELD_NAME_INDEX);
                        return;
                    } else if (o2 instanceof ExtentLeafStorage) {
                        CommonHFSExtentLeafRecord rec = ((ExtentLeafStorage) o2).getRecord();
                        if (rec instanceof StructElements) {
                            Dictionary dict = rec.getStructElements();
                            String label = dict.getTypeDescription();
                            if (label == null) {
                                label = dict.getTypeName();
                            }
                            structViewPanelScroller.setViewportView(new StructViewPanel(label + ":", dict));
                            clLeaf.show(leafPanel, "structview");
                        } else if (rec instanceof PrintableStruct) {
                            PrintStream ps = new PrintStream(new JTextAreaOutputStream(System.err, printFieldsTextArea));
                            printFieldsTextArea.setText("");
                            rec.print(ps, "");
                            ps.close();
                            printFieldsTextArea.setCaretPosition(0);
                            clLeaf.show(leafPanel, "printfieldsarea");
                        } else {
                            System.err.println("CatalogInfoPanel: Could not show record type " + rec.getClass());
                            clLeaf.show(leafPanel, "other");
                        }
                        clRoot.show(ExtentsInfoPanel.this.infoPanel, "leaf");
                        return;
                    } else {
                        System.err.println("WARNING: unknown type in catalog tree user object - " + o2.getClass().toString());
                        return;
                    }
                }
                System.err.println("WARNING: unknown type in catalog tree - " + o.getClass().toString());
            }
        });
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtentsInfoPanel$3.class
     */
    /* renamed from: org.catacombae.hfsexplorer.gui.ExtentsInfoPanel$3  reason: invalid class name */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtentsInfoPanel$3.class */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$catacombae$hfsexplorer$types$hfscommon$CommonBTNodeDescriptor$NodeType = new int[CommonBTNodeDescriptor.NodeType.values().length];

        static {
            try {
                $SwitchMap$org$catacombae$hfsexplorer$types$hfscommon$CommonBTNodeDescriptor$NodeType[CommonBTNodeDescriptor.NodeType.INDEX.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$catacombae$hfsexplorer$types$hfscommon$CommonBTNodeDescriptor$NodeType[CommonBTNodeDescriptor.NodeType.LEAF.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void expandNode(DefaultMutableTreeNode dmtn, CommonBTNode node, BaseHFSFileSystemView fsView) {
        if (node instanceof CommonHFSExtentIndexNode) {
            Iterator i$ = ((CommonHFSExtentIndexNode) node).getBTRecords().iterator();
            while (i$.hasNext()) {
                CommonBTIndexRecord<CommonHFSExtentKey> rec = (CommonBTIndexRecord) i$.next();
                CommonBTNode curNode = fsView.getExtentsOverflowNode(rec.getIndex());
                CommonHFSExtentKey key = rec.getKey();
                dmtn.add(new FileSystemBrowser.NoLeafMutableTreeNode(new BTNodeStorage(curNode, key.getForkType() + ":" + key.getFileID().toLong() + ":" + key.getStartBlock())));
            }
        } else if (node instanceof CommonHFSExtentLeafNode) {
            CommonHFSExtentLeafRecord[] recs = ((CommonHFSExtentLeafNode) node).getLeafRecords();
            for (CommonHFSExtentLeafRecord rec2 : recs) {
                CommonHFSExtentKey key2 = rec2.getKey();
                dmtn.add(new DefaultMutableTreeNode(new ExtentLeafStorage(rec2, key2.getForkType() + ":" + key2.getFileID().toLong() + ":" + key2.getStartBlock())));
            }
        } else {
            throw new RuntimeException("Invalid node type in tree: " + node);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtentsInfoPanel$BTNodeStorage.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtentsInfoPanel$BTNodeStorage.class */
    public static class BTNodeStorage {
        private CommonBTNode node;
        private String text;

        public BTNodeStorage(CommonBTNode node, String text) {
            this.node = node;
            this.text = text;
        }

        public CommonBTNode getNode() {
            return this.node;
        }

        public String toString() {
            return this.text;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtentsInfoPanel$ExtentLeafStorage.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtentsInfoPanel$ExtentLeafStorage.class */
    public static class ExtentLeafStorage {
        private CommonHFSExtentLeafRecord rec;
        private String text;

        public ExtentLeafStorage(CommonHFSExtentLeafRecord rec, String text) {
            this.rec = rec;
            this.text = text;
        }

        public CommonHFSExtentLeafRecord getRecord() {
            return this.rec;
        }

        public String toString() {
            return this.text;
        }
    }

    private void initComponents() {
        this.jSplitPane1 = new JSplitPane();
        this.jPanel1 = new JPanel();
        this.catalogTreeScroller = new JScrollPane();
        this.catalogTree = new JTree();
        this.infoPanel = new JPanel();
        this.descriptionLabel = new JLabel();
        this.jSplitPane1.setDividerLocation(330);
        this.jSplitPane1.setOrientation(0);
        this.jSplitPane1.setResizeWeight(1.0d);
        this.catalogTreeScroller.setViewportView(this.catalogTree);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(1).add(this.catalogTreeScroller, -1, 359, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(1).add(2, this.catalogTreeScroller, -1, 329, 32767));
        this.jSplitPane1.setLeftComponent(this.jPanel1);
        this.infoPanel.setPreferredSize(new Dimension(100, 140));
        GroupLayout infoPanelLayout = new GroupLayout(this.infoPanel);
        this.infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(infoPanelLayout.createParallelGroup(1).add(0, 359, 32767));
        infoPanelLayout.setVerticalGroup(infoPanelLayout.createParallelGroup(1).add(0, 101, 32767));
        this.jSplitPane1.setRightComponent(this.infoPanel);
        this.descriptionLabel.setText("View of the extent overflow file's B*-tree:");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.jSplitPane1, -1, 361, 32767).add((Component) this.descriptionLabel)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.descriptionLabel).addPreferredGap(0).add(this.jSplitPane1, -1, 437, 32767).addContainerGap()));
    }
}
