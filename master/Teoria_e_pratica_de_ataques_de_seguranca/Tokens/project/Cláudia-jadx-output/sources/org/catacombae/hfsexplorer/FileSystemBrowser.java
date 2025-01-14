package org.catacombae.hfsexplorer;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.catacombae.hfsexplorer.gui.FilesystemBrowserPanel;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser.class */
public class FileSystemBrowser<A> {
    private final FileSystemProvider<A> controller;
    private final DefaultTableModel tableModel;
    private int totalColumnWidth;
    private DefaultTreeModel treeModel;
    private final Vector<String> colNames = new Vector<>();
    private long fileTableLastFocus = 0;
    private long dirTreeLastFocus = 0;
    private final DecimalFormat sizeFormat = new DecimalFormat("0.00");
    private final boolean[] disableColumnListener = {false};
    private final ObjectContainer<int[]> lastWidths = new ObjectContainer<>(null);
    private final GenericPlaceholder<A> genericPlaceholder = new GenericPlaceholder<>();
    private TreePath lastTreeSelectionPath = null;
    private final FilesystemBrowserPanel viewComponent = new FilesystemBrowserPanel();
    private final JTextField addressField = this.viewComponent.addressField;
    private final JButton upButton = this.viewComponent.upButton;
    private final JButton infoButton = this.viewComponent.infoButton;
    private final JButton extractButton = this.viewComponent.extractButton;
    private final JButton goButton = this.viewComponent.goButton;
    private final JLabel statusLabel = this.viewComponent.statusLabel;
    private final JTable fileTable = this.viewComponent.fileTable;
    private final JScrollPane fileTableScroller = this.viewComponent.fileTableScroller;
    private final JTree dirTree = this.viewComponent.dirTree;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$FileSystemProvider.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$FileSystemProvider.class */
    public interface FileSystemProvider<A> {
        void actionDoubleClickFile(List<Record<A>> list);

        void actionExtractToDir(List<Record<A>> list, List<Record<A>> list2);

        void actionGetInfo(List<Record<A>> list, List<Record<A>> list2);

        JPopupMenu getRightClickRecordPopupMenu(List<Record<A>> list, List<Record<A>> list2);

        boolean isFileSystemLoaded();

        List<Record<A>> getFolderContents(List<Record<A>> list);

        String getAddressPath(List<String> list);

        String[] parseAddressPath(String str);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$RecordType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$RecordType.class */
    public enum RecordType {
        FILE,
        FOLDER,
        FILE_LINK,
        FOLDER_LINK,
        BROKEN_LINK
    }

    public FileSystemBrowser(FileSystemProvider<A> iController) {
        this.totalColumnWidth = 0;
        this.controller = iController;
        this.upButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.1
            public void actionPerformed(ActionEvent e2) {
                FileSystemBrowser.this.actionGotoParentDir();
            }
        });
        this.extractButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.2
            public void actionPerformed(ActionEvent e2) {
                FileSystemBrowser.this.actionExtractToDir();
            }
        });
        this.infoButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.3
            public void actionPerformed(ActionEvent e2) {
                FileSystemBrowser.this.actionGetInfo();
            }
        });
        this.goButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.4
            public void actionPerformed(ActionEvent e2) {
                FileSystemBrowser.this.actionGotoDir();
            }
        });
        this.addressField.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.5
            public void actionPerformed(ActionEvent e2) {
                FileSystemBrowser.this.actionGotoDir();
            }
        });
        Class objectClass = new Object().getClass();
        this.colNames.add("Name");
        this.colNames.add("Size");
        this.colNames.add("Type");
        this.colNames.add("Date Modified");
        this.colNames.add("");
        this.tableModel = new DefaultTableModel(this.colNames, 0) { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.6
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        this.fileTable.setModel(this.tableModel);
        this.fileTable.setSelectionMode(2);
        this.fileTable.setAutoResizeMode(0);
        this.fileTable.getColumnModel().getColumn(0).setPreferredWidth(180);
        this.fileTable.getColumnModel().getColumn(1).setPreferredWidth(96);
        this.fileTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.fileTable.getColumnModel().getColumn(3).setPreferredWidth(130);
        this.fileTable.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.totalColumnWidth = 526;
        this.fileTable.getColumnModel().getColumn(4).setMinWidth(0);
        this.fileTable.getColumnModel().getColumn(4).setResizable(false);
        if (Java6Util.isJava6OrHigher()) {
            Comparator<?> comparableComparator = new ComparableComparator();
            ArrayList<Comparator<?>> rowComparators = new ArrayList<>(5);
            for (int i2 = 0; i2 < 5; i2++) {
                rowComparators.add(comparableComparator);
            }
            Java6Specific.addRowSorter(this.fileTable, this.tableModel, 4, rowComparators);
        }
        TableColumnModelListener columnListener = new TableColumnModelListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.7
            private boolean locked = false;
            private int[] w1 = null;

            public void columnAdded(TableColumnModelEvent e2) {
            }

            public void columnMarginChanged(ChangeEvent e2) {
                if (FileSystemBrowser.this.disableColumnListener[0]) {
                    return;
                }
                synchronized (this) {
                    if (this.locked) {
                        return;
                    }
                    this.locked = true;
                    int columnCount = FileSystemBrowser.this.fileTable.getColumnModel().getColumnCount();
                    TableColumn lastColumn = FileSystemBrowser.this.fileTable.getColumnModel().getColumn(columnCount - 1);
                    if (FileSystemBrowser.this.lastWidths.o == null) {
                        FileSystemBrowser.this.lastWidths.o = (A) new int[columnCount];
                    }
                    if (this.w1 == null || this.w1.length != columnCount) {
                        this.w1 = new int[columnCount];
                    }
                    int diffSum = 0;
                    int currentWidth = 0;
                    for (int i3 = 0; i3 < this.w1.length; i3++) {
                        this.w1[i3] = FileSystemBrowser.this.fileTable.getColumnModel().getColumn(i3).getWidth();
                        currentWidth += this.w1[i3];
                        int diff = this.w1[i3] - ((int[]) FileSystemBrowser.this.lastWidths.o)[i3];
                        if (i3 < this.w1.length - 1) {
                            diffSum += diff;
                        }
                    }
                    int lastDiff = this.w1[columnCount - 1] - ((int[]) FileSystemBrowser.this.lastWidths.o)[columnCount - 1];
                    if (lastDiff != (-diffSum)) {
                        int importantColsWidth = currentWidth - this.w1[columnCount - 1];
                        int newLastColumnWidth = FileSystemBrowser.this.totalColumnWidth - importantColsWidth;
                        int nextTotalWidth = importantColsWidth + newLastColumnWidth;
                        if (newLastColumnWidth >= 0) {
                            if (nextTotalWidth <= FileSystemBrowser.this.totalColumnWidth || diffSum > 0) {
                                lastColumn.setPreferredWidth(newLastColumnWidth);
                                lastColumn.setWidth(newLastColumnWidth);
                                FileSystemBrowser.this.fileTableScroller.invalidate();
                                FileSystemBrowser.this.fileTableScroller.validate();
                            }
                        } else if (lastColumn.getWidth() != 0) {
                            lastColumn.setPreferredWidth(0);
                            lastColumn.setWidth(0);
                            FileSystemBrowser.this.fileTableScroller.invalidate();
                            FileSystemBrowser.this.fileTableScroller.validate();
                        }
                    }
                    for (int i4 = 0; i4 < this.w1.length; i4++) {
                        this.w1[i4] = FileSystemBrowser.this.fileTable.getColumnModel().getColumn(i4).getWidth();
                    }
                    int[] usedArray = (int[]) FileSystemBrowser.this.lastWidths.o;
                    FileSystemBrowser.this.lastWidths.o = (A) this.w1;
                    this.w1 = usedArray;
                    synchronized (this) {
                        this.locked = false;
                    }
                }
            }

            public void columnMoved(TableColumnModelEvent e2) {
            }

            public void columnRemoved(TableColumnModelEvent e2) {
            }

            public void columnSelectionChanged(ListSelectionEvent e2) {
            }
        };
        this.fileTable.getColumnModel().addColumnModelListener(columnListener);
        final TableCellRenderer objectRenderer = this.fileTable.getDefaultRenderer(objectClass);
        this.fileTable.setDefaultRenderer(objectClass, new TableCellRenderer() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.8
            private JLabel theOne = new JLabel();
            private JLabel theTwo = new JLabel("", 4);
            private ImageIcon documentIcon = new ImageIcon(ClassLoader.getSystemResource("res/emptydocument.png"));
            private ImageIcon folderIcon = new ImageIcon(ClassLoader.getSystemResource("res/folder.png"));
            private ImageIcon emptyIcon = new ImageIcon(ClassLoader.getSystemResource("res/nothing.png"));

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof RecordContainer) {
                    final Component objectComponent = objectRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    final JLabel jl = this.theOne;
                    Record rec = ((RecordContainer) value).getRecord(FileSystemBrowser.this.genericPlaceholder);
                    switch (rec.getType()) {
                        case FOLDER:
                        case FOLDER_LINK:
                            jl.setIcon(this.folderIcon);
                            break;
                        case FILE:
                        case FILE_LINK:
                            jl.setIcon(this.documentIcon);
                            break;
                        case BROKEN_LINK:
                            jl.setIcon(this.emptyIcon);
                            break;
                        default:
                            throw new RuntimeException("Unhandled RecordType: " + rec.getType());
                    }
                    jl.setVisible(true);
                    Component c2 = new Component() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.8.1
                        {
                            jl.setSize(jl.getPreferredSize());
                            jl.setLocation(0, 0);
                            objectComponent.setSize(objectComponent.getPreferredSize());
                            objectComponent.setLocation(jl.getWidth(), 0);
                            setSize(jl.getWidth() + objectComponent.getWidth(), Math.max(jl.getHeight(), objectComponent.getHeight()));
                        }

                        public void paint(Graphics g2) {
                            jl.paint(g2);
                            int translatex = jl.getWidth();
                            g2.translate(translatex, 0);
                            objectComponent.paint(g2);
                            g2.translate(-translatex, 0);
                        }
                    };
                    return c2;
                } else if (column == 1) {
                    this.theTwo.setText(value.toString());
                    return this.theTwo;
                } else {
                    return objectRenderer.getTableCellRendererComponent(table, value, false, false, row, column);
                }
            }
        });
        this.fileTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.9
            public void valueChanged(ListSelectionEvent e2) {
                int[] selection = FileSystemBrowser.this.fileTable.getSelectedRows();
                long selectionSize = 0;
                for (int selectedRow : selection) {
                    Object o = FileSystemBrowser.this.fileTable.getValueAt(selectedRow, 0);
                    if (o instanceof RecordContainer) {
                        Record rec = ((RecordContainer) o).getRecord(FileSystemBrowser.this.genericPlaceholder);
                        if (rec.getType() == RecordType.FILE || rec.getType() == RecordType.FILE_LINK) {
                            selectionSize += rec.getSize();
                        }
                    }
                }
                FileSystemBrowser.this.setSelectionStatus(selection.length, selectionSize);
            }
        });
        this.fileTableScroller.addMouseListener(new MouseAdapter() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.10
            public void mouseClicked(MouseEvent e2) {
                int row = FileSystemBrowser.this.fileTable.rowAtPoint(e2.getPoint());
                if (row == -1) {
                    FileSystemBrowser.this.fileTable.clearSelection();
                }
            }
        });
        this.fileTable.addMouseListener(new MouseAdapter() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.11
            public void mouseClicked(MouseEvent e2) {
                if (e2.getButton() == 3) {
                    int row = FileSystemBrowser.this.fileTable.rowAtPoint(e2.getPoint());
                    int col = FileSystemBrowser.this.fileTable.columnAtPoint(e2.getPoint());
                    if (col == 0 && row >= 0) {
                        int[] currentSelection = FileSystemBrowser.this.fileTable.getSelectedRows();
                        if (!Util.contains(currentSelection, row)) {
                            FileSystemBrowser.this.fileTable.clearSelection();
                            FileSystemBrowser.this.fileTable.changeSelection(row, col, false, false);
                        }
                        FileSystemBrowser.this.fileTable.requestFocus();
                        List<Record<A>> selection = FileSystemBrowser.this.getTableSelection();
                        List<Record<A>> selectionParentPath = FileSystemBrowser.this.getRecordPath(FileSystemBrowser.this.lastTreeSelectionPath);
                        JPopupMenu jpm = FileSystemBrowser.this.controller.getRightClickRecordPopupMenu(selectionParentPath, selection);
                        jpm.show(FileSystemBrowser.this.fileTable, e2.getX(), e2.getY());
                    }
                } else if (e2.getButton() == 1 && e2.getClickCount() == 2) {
                    int row2 = FileSystemBrowser.this.fileTable.rowAtPoint(e2.getPoint());
                    int col2 = FileSystemBrowser.this.fileTable.columnAtPoint(e2.getPoint());
                    if (col2 == 0 && row2 >= 0) {
                        Object colValue = FileSystemBrowser.this.fileTable.getValueAt(row2, col2);
                        if (colValue instanceof RecordContainer) {
                            Record<A> rec = ((RecordContainer) colValue).getRecord(FileSystemBrowser.this.genericPlaceholder);
                            if (rec.getType() == RecordType.FILE || rec.getType() == RecordType.FILE_LINK) {
                                List<Record<A>> dirPath = FileSystemBrowser.this.getRecordPath(FileSystemBrowser.this.lastTreeSelectionPath);
                                ArrayList<Record<A>> completePath = new ArrayList<>(dirPath.size() + 1);
                                completePath.addAll(dirPath);
                                completePath.add(rec);
                                FileSystemBrowser.this.controller.actionDoubleClickFile(completePath);
                                return;
                            } else if (rec.getType() == RecordType.FOLDER || rec.getType() == RecordType.FOLDER_LINK) {
                                FileSystemBrowser.this.actionChangeDir(rec);
                                return;
                            } else {
                                return;
                            }
                        }
                        throw new RuntimeException("Invalid type in column 0 in fileTable!");
                    }
                }
            }
        });
        this.dirTree.addMouseListener(new MouseAdapter() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.12
            public void mousePressed(MouseEvent e2) {
                TreePath tp;
                if (e2.getButton() == 3 && FileSystemBrowser.this.controller.isFileSystemLoaded() && (tp = FileSystemBrowser.this.dirTree.getPathForLocation(e2.getX(), e2.getY())) != null) {
                    FileSystemBrowser.this.dirTree.clearSelection();
                    FileSystemBrowser.this.dirTree.setSelectionPath(tp);
                    FileSystemBrowser.this.dirTree.requestFocus();
                    List<Record<A>> recList = Collections.singletonList(FileSystemBrowser.this.getTreeSelection());
                    List<Record<A>> selectionParentPath = FileSystemBrowser.this.getRecordPath(FileSystemBrowser.this.lastTreeSelectionPath.getParentPath());
                    FileSystemBrowser.this.controller.getRightClickRecordPopupMenu(selectionParentPath, recList).show(FileSystemBrowser.this.dirTree, e2.getX(), e2.getY());
                }
            }
        });
        setRoot(null);
        this.dirTree.getSelectionModel().setSelectionMode(1);
        this.dirTree.addTreeSelectionListener(new TreeSelectionListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.13
            public void valueChanged(TreeSelectionEvent e2) {
                TreePath tp = e2.getPath();
                FileSystemBrowser.this.actionTreeNodeSelected(tp);
            }
        });
        this.dirTree.addTreeWillExpandListener(new TreeWillExpandListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.14
            public void treeWillExpand(TreeExpansionEvent e2) throws ExpandVetoException {
                FileSystemBrowser.this.actionExpandDirTreeNode(e2.getPath());
            }

            public void treeWillCollapse(TreeExpansionEvent e2) {
            }
        });
        this.fileTable.addFocusListener(new FocusListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.15
            public void focusGained(FocusEvent e2) {
                FileSystemBrowser.this.fileTableLastFocus = System.nanoTime();
            }

            public void focusLost(FocusEvent e2) {
            }
        });
        this.dirTree.addFocusListener(new FocusListener() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.16
            public void focusGained(FocusEvent e2) {
                FileSystemBrowser.this.dirTreeLastFocus = System.nanoTime();
            }

            public void focusLost(FocusEvent e2) {
            }
        });
        this.fileTableScroller.addComponentListener(new ComponentAdapter() { // from class: org.catacombae.hfsexplorer.FileSystemBrowser.17
            public void componentResized(ComponentEvent e2) {
                FileSystemBrowser.this.adjustTableWidth();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionGotoParentDir() {
        if (ensureFileSystemLoaded() && this.lastTreeSelectionPath.getPathCount() > 1) {
            TreePath parentPath = this.lastTreeSelectionPath.getParentPath();
            selectInTree(parentPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionExtractToDir() {
        if (ensureFileSystemLoaded()) {
            this.controller.actionExtractToDir(getSelectionParentPath(), getSelection());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionChangeDir(Record<A> subDir) {
        TreePath currentTreeSelection = this.lastTreeSelectionPath;
        Object objectToPopulate = this.lastTreeSelectionPath.getLastPathComponent();
        if (objectToPopulate instanceof FolderTreeNode) {
            FolderTreeNode nodeToPopulate = (FolderTreeNode) objectToPopulate;
            List<Record<A>> recordPath = getRecordPath(currentTreeSelection);
            populateTreeNodeFromPath(nodeToPopulate, recordPath);
            this.dirTree.expandPath(this.lastTreeSelectionPath);
            int childCount = this.treeModel.getChildCount(nodeToPopulate);
            Object finalChild = null;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                Object curChild = this.treeModel.getChild(nodeToPopulate, i2);
                if (!(curChild instanceof FolderTreeNode) || !((FolderTreeNode) curChild).getRecordContainer().getRecord(this.genericPlaceholder).getName().equals(subDir.getName())) {
                    i2++;
                } else {
                    TreePath childPath = this.lastTreeSelectionPath.pathByAddingChild(curChild);
                    selectInTree(childPath);
                    finalChild = curChild;
                    break;
                }
            }
            if (finalChild == null) {
                throw new RuntimeException("Selection path to leaf child not found!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionGetInfo() {
        if (ensureFileSystemLoaded()) {
            this.controller.actionGetInfo(getSelectionParentPath(), getSelection());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionGotoDir() {
        if (ensureFileSystemLoaded()) {
            String targetAddress = this.addressField.getText();
            String[] addressComponents = this.controller.parseAddressPath(targetAddress);
            if (addressComponents != null) {
                setCurrentDirectory(addressComponents);
            } else {
                JOptionPane.showMessageDialog(this.viewComponent, "Invalid pathname.", "Error", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionExpandDirTreeNode(TreePath targetNodePath) {
        if (ensureFileSystemLoaded()) {
            try {
                Object objToExpand = targetNodePath.getLastPathComponent();
                if (objToExpand instanceof FolderTreeNode) {
                    FolderTreeNode nodeToPopulate = (FolderTreeNode) objToExpand;
                    List<Record<A>> recordPath = getRecordPath(targetNodePath);
                    populateTreeNodeFromPath(nodeToPopulate, recordPath);
                    return;
                }
                throw new RuntimeException("Unexpected node class in tree: " + objToExpand.getClass());
            } catch (Throwable e2) {
                displayUnhandledException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionTreeNodeSelected(TreePath selectionPath) {
        if ((selectionPath.getLastPathComponent() instanceof FolderTreeNode) && ensureFileSystemLoaded()) {
            try {
                List<Record<A>> recordPath = getRecordPath(selectionPath);
                populateTableFromPath(recordPath);
                this.lastTreeSelectionPath = selectionPath;
            } catch (Throwable e2) {
                displayUnhandledException(e2);
            }
        }
    }

    private void displayUnhandledException(Throwable e2) {
        e2.printStackTrace();
        JOptionPane.showMessageDialog(this.viewComponent, e2.getClass() + " while populating tree node:\n  " + e2.getMessage(), "Error", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Record<A>> getRecordPath(TreePath tp) {
        if (tp == null) {
            return null;
        }
        List<Record<A>> recordPath = new ArrayList<>(tp.getPathCount());
        Object[] arr$ = tp.getPath();
        for (Object obj : arr$) {
            if (obj instanceof FolderTreeNode) {
                FolderTreeNode noLeafMutableTreeNode = (FolderTreeNode) obj;
                Object userObj = noLeafMutableTreeNode.getUserObject();
                if (userObj instanceof RecordContainer) {
                    Record<A> rec = ((RecordContainer) userObj).getRecord(this.genericPlaceholder);
                    if (rec.getType() == RecordType.FOLDER || rec.getType() == RecordType.FOLDER_LINK) {
                        recordPath.add(rec);
                    } else {
                        throw new RuntimeException("Unexpected record type in tree: " + rec.getType());
                    }
                } else {
                    throw new RuntimeException("Unexpected user object class in tree: " + userObj.getClass());
                }
            } else {
                throw new RuntimeException("Unexpected node class in tree: " + obj.getClass());
            }
        }
        return recordPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustTableWidth() {
        int columnCount = this.fileTable.getColumnModel().getColumnCount();
        int[] w1 = new int[columnCount];
        for (int i2 = 0; i2 < w1.length; i2++) {
            w1[i2] = this.fileTable.getColumnModel().getColumn(i2).getPreferredWidth();
        }
        this.disableColumnListener[0] = true;
        this.fileTable.setAutoResizeMode(3);
        this.fileTableScroller.invalidate();
        this.fileTableScroller.validate();
        int[] w2 = new int[columnCount];
        int newTotalWidth = 0;
        for (int i3 = 0; i3 < columnCount; i3++) {
            w2[i3] = this.fileTable.getColumnModel().getColumn(i3).getWidth();
            newTotalWidth += w2[i3];
        }
        this.totalColumnWidth = newTotalWidth;
        int newLastColumnWidth = newTotalWidth;
        for (int i4 = 0; i4 < w1.length - 1; i4++) {
            newLastColumnWidth -= w1[i4];
        }
        if (newLastColumnWidth < 0) {
            newLastColumnWidth = 0;
        }
        this.fileTable.getColumnModel().getColumn(columnCount - 1).setPreferredWidth(newLastColumnWidth);
        this.fileTable.setAutoResizeMode(0);
        this.fileTableScroller.invalidate();
        this.fileTableScroller.validate();
        this.lastWidths.o = null;
        this.disableColumnListener[0] = false;
    }

    private void populateTreeNodeFromPath(FolderTreeNode nodeToPopulate, List<Record<A>> recordPath) {
        List<Record<A>> childRecords = this.controller.getFolderContents(recordPath);
        populateTreeNodeFromContents(nodeToPopulate, childRecords);
    }

    private void populateTreeNodeFromContents(FolderTreeNode nodeToPopulate, List<Record<A>> childRecords) {
        Record<A> firstRemainingRecord;
        LinkedList<Record<A>> remainingRecords = new LinkedList<>();
        for (Record<A> childRecord : childRecords) {
            if (childRecord.getType() == RecordType.FOLDER || childRecord.getType() == RecordType.FOLDER_LINK) {
                remainingRecords.add(childRecord);
            }
        }
        List<FolderTreeNode> currentNodes = new ArrayList<>(nodeToPopulate.getChildCount());
        Enumeration en = nodeToPopulate.children();
        while (en.hasMoreElements()) {
            Object o = en.nextElement();
            if (o instanceof FolderTreeNode) {
                currentNodes.add((FolderTreeNode) o);
            } else {
                throw new RuntimeException("Unexpected child type: " + o.getClass());
            }
        }
        LinkedList<Pair<FolderTreeNode, Record<A>>> nodesToUpdate = new LinkedList<>();
        LinkedList<FolderTreeNode> nodesToRemove = new LinkedList<>();
        LinkedList<Integer> insertedRecordIndices = new LinkedList<>();
        int currentIndex = 0;
        for (FolderTreeNode node : currentNodes) {
            String nodeName = node.getRecordContainer().getRecord(this.genericPlaceholder).getName();
            Record<A> peek = remainingRecords.peek();
            while (true) {
                firstRemainingRecord = peek;
                if (firstRemainingRecord == null || firstRemainingRecord.getName().compareTo(nodeName) >= 0) {
                    break;
                }
                FolderTreeNode newNode = new FolderTreeNode(new RecordContainer(remainingRecords.remove()));
                insertedRecordIndices.add(Integer.valueOf(currentIndex));
                int i2 = currentIndex;
                currentIndex++;
                nodeToPopulate.insert(newNode, i2);
                peek = remainingRecords.peek();
            }
            if (firstRemainingRecord != null && firstRemainingRecord.getName().compareTo(nodeName) == 0) {
                nodesToUpdate.add(new Pair<>(node, remainingRecords.remove()));
            } else {
                nodesToRemove.add(node);
            }
            currentIndex++;
        }
        while (remainingRecords.peek() != null) {
            FolderTreeNode newNode2 = new FolderTreeNode(new RecordContainer(remainingRecords.remove()));
            insertedRecordIndices.add(Integer.valueOf(currentIndex));
            int i3 = currentIndex;
            currentIndex++;
            nodeToPopulate.insert(newNode2, i3);
        }
        int[] insertedRecordIndicesArray = new int[insertedRecordIndices.size()];
        int i4 = 0;
        Iterator i$ = insertedRecordIndices.iterator();
        while (i$.hasNext()) {
            int index = i$.next().intValue();
            int i5 = i4;
            i4++;
            insertedRecordIndicesArray[i5] = index;
        }
        if (insertedRecordIndicesArray.length > 0) {
            this.treeModel.nodesWereInserted(nodeToPopulate, insertedRecordIndicesArray);
        }
        FolderTreeNode[] removedChildren = new FolderTreeNode[nodesToRemove.size()];
        int[] removedIndices = new int[removedChildren.length];
        int index2 = 0;
        Iterator i$2 = nodesToRemove.iterator();
        while (i$2.hasNext()) {
            FolderTreeNode node2 = i$2.next();
            removedChildren[index2] = node2;
            removedIndices[index2] = nodeToPopulate.getIndex(node2);
            if (removedIndices[index2] < 0) {
                throw new RuntimeException("INTERNAL ERROR: Can't find node in nodeToPopulate!");
            }
            index2++;
        }
        for (int i6 : removedIndices) {
            nodeToPopulate.remove(i6);
        }
        if (removedIndices.length > 0) {
            this.treeModel.nodesWereRemoved(nodeToPopulate, removedIndices, removedChildren);
        }
        int[] updatedIndices = new int[nodesToUpdate.size()];
        int index3 = 0;
        Iterator i$3 = nodesToUpdate.iterator();
        while (i$3.hasNext()) {
            Pair<FolderTreeNode, Record<A>> p = i$3.next();
            ((FolderTreeNode) p.f7638a).setUserObject(new RecordContainer((Record) p.f7639b));
            updatedIndices[index3] = nodeToPopulate.getIndex((TreeNode) p.f7638a);
            if (updatedIndices[index3] < 0) {
                throw new RuntimeException("INTERNAL ERROR: Can't find node in nodeToPopulate!");
            }
            index3++;
        }
        if (updatedIndices.length > 0) {
            this.treeModel.nodesChanged(nodeToPopulate, updatedIndices);
        }
    }

    private List<String> asNameList(List<Record<A>> recordList) {
        ArrayList<String> res = new ArrayList<>();
        for (Record<A> rec : recordList) {
            res.add(rec.getName());
        }
        return res;
    }

    private void populateTableFromPath(List<Record<A>> folderRecordPath) {
        List<Record<A>> childRecords = this.controller.getFolderContents(folderRecordPath);
        List<String> nameList = asNameList(folderRecordPath.subList(1, folderRecordPath.size()));
        String displayPath = this.controller.getAddressPath(nameList);
        populateTableFromContents(childRecords, displayPath);
    }

    private void populateTableFromContents(List<Record<A>> contents, String displayPath) {
        while (this.tableModel.getRowCount() > 0) {
            this.tableModel.removeRow(this.tableModel.getRowCount() - 1);
        }
        DateFormat dti = DateFormat.getDateTimeInstance(3, 3);
        int i2 = 0;
        for (Record<A> rec : contents) {
            Vector<Object> currentRow = new Vector<>(4);
            currentRow.add(new RecordContainer(rec));
            currentRow.add(new SizeEntry(rec.getSize()));
            currentRow.add(new RecordTypeEntry(rec.getType()));
            currentRow.add(new DateEntry(rec.getModifyDate(), dti));
            int i3 = i2;
            i2++;
            currentRow.add(new IndexEntry(i3));
            this.tableModel.addRow(currentRow);
        }
        adjustTableWidth();
        this.fileTableScroller.getVerticalScrollBar().setValue(0);
        this.addressField.setText(displayPath);
    }

    public JComponent getViewComponent() {
        return this.viewComponent;
    }

    public List<A> getUserObjectSelection() {
        List<Record<A>> recs = getSelection();
        ArrayList<A> result = new ArrayList<>(recs.size());
        for (Record<A> rec : recs) {
            result.add(rec.getUserObject());
        }
        return result;
    }

    public List<Record<A>> getSelection() {
        List<Record<A>> result;
        if (this.dirTreeLastFocus > this.fileTableLastFocus) {
            Record<A> treeSelection = getTreeSelection();
            result = new ArrayList<>(1);
            result.add(treeSelection);
        } else {
            result = getTableSelection();
        }
        return result;
    }

    public List<Record<A>> getSelectionParentPath() {
        if (this.dirTreeLastFocus > this.fileTableLastFocus) {
            return getRecordPath(this.lastTreeSelectionPath.getParentPath());
        }
        return getRecordPath(this.lastTreeSelectionPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Record<A> getTreeSelection() {
        Record<A> result;
        Object o = this.lastTreeSelectionPath.getLastPathComponent();
        if (o == null) {
            JOptionPane.showMessageDialog(this.viewComponent, "No file or folder selected.", "Information", 1);
            result = null;
        } else if (o instanceof DefaultMutableTreeNode) {
            Object o2 = ((DefaultMutableTreeNode) o).getUserObject();
            if (o2 instanceof RecordContainer) {
                Record<A> rec = ((RecordContainer) o2).getRecord(this.genericPlaceholder);
                result = rec;
            } else {
                JOptionPane.showMessageDialog(this.viewComponent, "[getTreeSelection()] Unexpected data in tree model: " + o2.getClass() + ". (Internal error, report to developer)", "Error", 0);
                result = null;
            }
        } else {
            JOptionPane.showMessageDialog(this.viewComponent, "[getTreeSelection()] Unexpected tree node type: " + o.getClass() + "! (Internal error, report to developer)", "Error", 0);
            result = null;
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Record<A>> getTableSelection() {
        List<Record<A>> result;
        int[] selectedRows = this.fileTable.getSelectedRows();
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this.viewComponent, "No file selected.", "Information", 1);
            result = null;
        } else {
            ArrayList<Record<A>> actualResult = new ArrayList<>(selectedRows.length);
            int i2 = 0;
            while (true) {
                if (i2 >= selectedRows.length) {
                    break;
                }
                Object o = this.fileTable.getValueAt(selectedRows[i2], 0);
                if (o instanceof RecordContainer) {
                    Record<A> rekk = ((RecordContainer) o).getRecord(this.genericPlaceholder);
                    actualResult.add(rekk);
                    i2++;
                } else {
                    JOptionPane.showMessageDialog(this.viewComponent, "[getTableSelection()] Unexpected data in table model. (Internal error, report to developer)", "Error", 0);
                    actualResult = null;
                    break;
                }
            }
            result = actualResult;
        }
        return result;
    }

    private boolean ensureFileSystemLoaded() {
        if (this.controller.isFileSystemLoaded()) {
            return true;
        }
        JOptionPane.showMessageDialog(this.viewComponent, "No file system loaded.", "Error", 0);
        return false;
    }

    public void setRoot(Record<A> rootRecord) {
        List<Record<A>> rootRecordPath;
        FolderTreeNode noLeafMutableTreeNode;
        if (rootRecord != null) {
            rootRecordPath = new ArrayList<>(1);
            rootRecordPath.add(rootRecord);
            FolderTreeNode rootTreeNode = new FolderTreeNode(new RecordContainer(rootRecord));
            populateTreeNodeFromPath(rootTreeNode, rootRecordPath);
            noLeafMutableTreeNode = rootTreeNode;
        } else {
            rootRecordPath = null;
            noLeafMutableTreeNode = new NoLeafMutableTreeNode("No file system loaded");
        }
        this.treeModel = new DefaultTreeModel(noLeafMutableTreeNode);
        this.dirTree.setModel(this.treeModel);
        this.lastTreeSelectionPath = new TreePath(noLeafMutableTreeNode);
        selectInTree(this.lastTreeSelectionPath);
        if (rootRecordPath != null) {
            populateTableFromPath(rootRecordPath);
        } else {
            populateTableFromContents(new ArrayList(0), "");
        }
        setSelectionStatus(0L, 0L);
    }

    private void selectInTree(TreePath childPath) {
        if (childPath.getPathCount() > 1) {
            this.dirTree.expandPath(childPath.getParentPath());
        }
        this.dirTree.setSelectionPath(childPath);
        this.dirTree.scrollPathToVisible(childPath);
    }

    private void setCurrentDirectory(String[] pathnameComponents) {
        System.err.println("setCurrentDirectory(): printing pathnameComponents");
        for (int i2 = 0; i2 < pathnameComponents.length; i2++) {
            System.err.println("  [" + i2 + "]: " + pathnameComponents[i2]);
        }
        Object rootObj = this.treeModel.getRoot();
        if (rootObj instanceof FolderTreeNode) {
            FolderTreeNode curNode = (FolderTreeNode) rootObj;
            LinkedList<Record<A>> dirStack = new LinkedList<>();
            TreePath treePath = new TreePath(curNode);
            for (String currentComponent : pathnameComponents) {
                dirStack.addLast(curNode.getRecordContainer().getRecord(this.genericPlaceholder));
                populateTreeNodeFromPath(curNode, dirStack);
                this.dirTree.expandPath(treePath);
                int childCount = this.treeModel.getChildCount(curNode);
                FolderTreeNode requestedNode = null;
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    Object curChild = this.treeModel.getChild(curNode, i3);
                    if (curChild instanceof FolderTreeNode) {
                        FolderTreeNode curChildNode = (FolderTreeNode) curChild;
                        Record<A> rec = curChildNode.getRecordContainer().getRecord(this.genericPlaceholder);
                        if (!rec.getName().equals(currentComponent)) {
                            i3++;
                        } else {
                            requestedNode = curChildNode;
                            break;
                        }
                    } else {
                        throw new RuntimeException("Unexpected tree node class: " + curChild.getClass());
                    }
                }
                if (requestedNode != null) {
                    curNode = requestedNode;
                    treePath = treePath.pathByAddingChild(curNode);
                } else {
                    JOptionPane.showMessageDialog(this.viewComponent, "No such directory.", "Error", 0);
                    return;
                }
            }
            System.err.println("setCurrentDirectory(): selecting the following path in tree:");
            Object[] arr$ = treePath.getPath();
            for (Object o : arr$) {
                System.err.print(" \"" + o.toString() + "\"");
            }
            selectInTree(treePath);
            return;
        }
        throw new RuntimeException("Unexpected root node class: " + rootObj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectionStatus(long selectedFilesCount, long selectionSize) {
        String sizeString;
        if (selectionSize >= 1024) {
            sizeString = SpeedUnitUtils.bytesToBinaryUnit(selectionSize, this.sizeFormat);
        } else {
            sizeString = selectionSize + " bytes";
        }
        this.statusLabel.setText(selectedFilesCount + (selectedFilesCount == 1 ? " object" : " objects") + " selected (" + sizeString + ")");
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$Record.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$Record.class */
    public static class Record<A> {
        private RecordType type;
        private String name;
        private long size;
        private Date modifyDate;
        private A userObject;

        public Record(RecordType iType, String iName, long iSize, Date iModifyDate, A iUserObject) {
            this.type = iType;
            this.name = iName;
            this.size = iSize;
            this.modifyDate = iModifyDate;
            this.userObject = iUserObject;
        }

        public RecordType getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public long getSize() {
            return this.size;
        }

        public Date getModifyDate() {
            return this.modifyDate;
        }

        public A getUserObject() {
            return this.userObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$RecordContainer.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$RecordContainer.class */
    public static class RecordContainer implements Comparable {
        private Record rec;

        private RecordContainer() {
        }

        public RecordContainer(Record rec) {
            this.rec = rec;
        }

        public <T> Record<T> getRecord(GenericPlaceholder<T> placeholder) {
            return this.rec;
        }

        public String toString() {
            return this.rec.getName();
        }

        @Override // java.lang.Comparable
        public int compareTo(Object o) {
            if (o instanceof RecordContainer) {
                RecordContainer rc = (RecordContainer) o;
                return toString().compareTo(rc.toString());
            }
            throw new RuntimeException("Can not compare a RecordContainer with a " + o.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$SizeEntry.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$SizeEntry.class */
    public static class SizeEntry implements Comparable {
        private final String presentedSize;
        private final long trueSize;

        public SizeEntry(long trueSize) {
            this.trueSize = trueSize;
            this.presentedSize = SpeedUnitUtils.bytesToBinaryUnit(trueSize);
        }

        public long getSize() {
            return this.trueSize;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object o) {
            if (o instanceof SizeEntry) {
                SizeEntry se = (SizeEntry) o;
                long res = this.trueSize - se.trueSize;
                if (res > 0) {
                    return 1;
                }
                if (res < 0) {
                    return -1;
                }
                return 0;
            }
            throw new RuntimeException("Can not compare a SizeEntry with a " + o.getClass());
        }

        public String toString() {
            return this.presentedSize;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$RecordTypeEntry.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$RecordTypeEntry.class */
    public static class RecordTypeEntry implements Comparable {
        private final RecordType recordType;
        private final String displayString;

        public RecordTypeEntry(RecordType recordType) {
            this.recordType = recordType;
            switch (recordType) {
                case FOLDER:
                    this.displayString = "Folder";
                    return;
                case FOLDER_LINK:
                    this.displayString = "Folder (symlink)";
                    return;
                case FILE:
                    this.displayString = "File";
                    return;
                case FILE_LINK:
                    this.displayString = "File (symlink)";
                    return;
                case BROKEN_LINK:
                    this.displayString = "Broken link";
                    return;
                default:
                    throw new RuntimeException("INTERNAL ERROR: Encountered unexpected record type (" + recordType + ")");
            }
        }

        public RecordType getRecordType() {
            return this.recordType;
        }

        public String toString() {
            return this.displayString;
        }

        private int getPriority() {
            switch (this.recordType) {
                case FOLDER:
                    return 0;
                case FOLDER_LINK:
                    return 1;
                case FILE:
                    return 2;
                case FILE_LINK:
                    return 3;
                case BROKEN_LINK:
                    return 4;
                default:
                    throw new RuntimeException("INTERNAL ERROR: Encountered unexpected record type (" + this.recordType + ")");
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Object o) {
            if (o instanceof RecordTypeEntry) {
                RecordTypeEntry rte = (RecordTypeEntry) o;
                return getPriority() - rte.getPriority();
            }
            throw new RuntimeException("Can not compare a RecordTypeEntry to a " + o.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$DateEntry.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$DateEntry.class */
    public static class DateEntry implements Comparable {
        private final Date date;
        private final String displayString;

        public DateEntry(Date date, DateFormat formatter) {
            this.date = date;
            this.displayString = formatter.format(date);
        }

        public Date getDate() {
            return this.date;
        }

        public String toString() {
            return this.displayString;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object o) {
            if (o instanceof DateEntry) {
                DateEntry de = (DateEntry) o;
                return this.date.compareTo(de.date);
            }
            throw new RuntimeException("Can not compare a DateEntry to a " + o.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$IndexEntry.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$IndexEntry.class */
    public static class IndexEntry implements Comparable<IndexEntry> {
        private final int index;

        public IndexEntry(int index) {
            this.index = index;
        }

        @Override // java.lang.Comparable
        public int compareTo(IndexEntry o) {
            return this.index - o.index;
        }

        public String toString() {
            return "";
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$ComparableComparator.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$ComparableComparator.class */
    private static class ComparableComparator implements Comparator<Comparable<Comparable>> {
        private ComparableComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Comparable<Comparable> o1, Comparable<Comparable> o2) {
            return o1.compareTo(o2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$NoLeafMutableTreeNode.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$NoLeafMutableTreeNode.class */
    public static class NoLeafMutableTreeNode extends DefaultMutableTreeNode {
        public NoLeafMutableTreeNode(Object userObject) {
            super(userObject);
        }

        public boolean isLeaf() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$FolderTreeNode.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$FolderTreeNode.class */
    public static class FolderTreeNode extends NoLeafMutableTreeNode {
        private final RecordContainer rc;

        public FolderTreeNode(RecordContainer o) {
            super(o);
            this.rc = o;
        }

        public RecordContainer getRecordContainer() {
            return this.rc;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$ObjectContainer.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$ObjectContainer.class */
    public static class ObjectContainer<A> {
        public A o;

        public ObjectContainer(A o) {
            this.o = o;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$GenericPlaceholder.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemBrowser$GenericPlaceholder.class */
    public static class GenericPlaceholder<A> {
        private GenericPlaceholder() {
        }
    }
}
