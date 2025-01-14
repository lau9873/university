package org.catacombae.hfsexplorer.gui;

import com.j256.ormlite.android.AndroidLog;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/FilesystemBrowserPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/FilesystemBrowserPanel.class */
public class FilesystemBrowserPanel extends JPanel {
    private static final ImageIcon FORWARD_ICON = new ImageIcon(ClassLoader.getSystemResource("res/forward.png"));
    private static final ImageIcon EXTRACT_ICON = new ImageIcon(ClassLoader.getSystemResource("res/extract.png"));
    private static final ImageIcon BACK_ICON = new ImageIcon(ClassLoader.getSystemResource("res/back.png"));
    private static final ImageIcon UP_ICON = new ImageIcon(ClassLoader.getSystemResource("res/folderup.png"));
    private static final ImageIcon INFO_ICON = new ImageIcon(ClassLoader.getSystemResource("res/info.png"));
    public JTextField addressField;
    private JPanel boxPanel;
    public JTree dirTree;
    private JScrollPane dirTreeScroller;
    public JButton extractButton;
    public JTable fileTable;
    public JScrollPane fileTableScroller;
    public JButton goButton;
    public JButton infoButton;
    private JLabel pathLabel;
    public JLabel statusLabel;
    private JPanel statusLabelPanel;
    private JPanel treeTablePanel;
    private JSplitPane treeTableSplit;
    public JButton upButton;

    public FilesystemBrowserPanel() {
        initComponents();
        this.fileTableScroller.getViewport().setBackground(this.fileTable.getBackground());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.addressField = new JTextField();
        this.pathLabel = new JLabel();
        this.goButton = new JButton();
        this.extractButton = new JButton();
        this.upButton = new JButton();
        this.infoButton = new JButton();
        this.boxPanel = new JPanel();
        this.treeTablePanel = new JPanel();
        this.treeTableSplit = new JSplitPane();
        this.dirTreeScroller = new JScrollPane();
        this.dirTree = new JTree();
        this.fileTableScroller = new JScrollPane();
        this.fileTable = new JTable();
        this.statusLabelPanel = new JPanel();
        this.statusLabel = new JLabel();
        this.pathLabel.setText("Path:");
        this.goButton.setIcon(FORWARD_ICON);
        this.goButton.setText("Go");
        this.extractButton.setIcon(EXTRACT_ICON);
        this.extractButton.setText("Extract");
        this.upButton.setIcon(UP_ICON);
        this.upButton.setText("Up");
        this.infoButton.setIcon(INFO_ICON);
        this.infoButton.setText("Info");
        this.boxPanel.setLayout(new BorderLayout());
        this.treeTablePanel.setLayout(new BorderLayout());
        this.treeTableSplit.setDividerLocation((int) AndroidLog.REFRESH_LEVEL_CACHE_EVERY);
        this.treeTableSplit.setContinuousLayout(true);
        this.dirTreeScroller.setViewportView(this.dirTree);
        this.treeTableSplit.setLeftComponent(this.dirTreeScroller);
        this.fileTable.setModel(new DefaultTableModel(new Object[]{new Object[]{"yada.txt", "1 KiB", "Textdokument", "2006-06-11 14:34"}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}}, new String[]{"Namn", "Storlek", "Typ", "Senast ändrad"}) { // from class: org.catacombae.hfsexplorer.gui.FilesystemBrowserPanel.1
            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.fileTable.setIntercellSpacing(new Dimension(4, 0));
        this.fileTable.setShowHorizontalLines(false);
        this.fileTable.setShowVerticalLines(false);
        this.fileTableScroller.setViewportView(this.fileTable);
        this.treeTableSplit.setRightComponent(this.fileTableScroller);
        this.treeTablePanel.add(this.treeTableSplit, "Center");
        this.boxPanel.add(this.treeTablePanel, "Center");
        this.statusLabelPanel.setLayout(new BorderLayout());
        this.statusLabel.setText("No file system loaded");
        this.statusLabel.setBorder(BorderFactory.createBevelBorder(1));
        this.statusLabelPanel.add(this.statusLabel, "Center");
        this.boxPanel.add(this.statusLabelPanel, "South");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add((Component) this.pathLabel).addPreferredGap(0).add(this.addressField, -1, 631, 32767).addPreferredGap(0).add((Component) this.goButton).addContainerGap()).add(this.boxPanel, -1, 732, 32767).add(layout.createSequentialGroup().addContainerGap().add((Component) this.upButton).addPreferredGap(0).add((Component) this.extractButton).addPreferredGap(0).add((Component) this.infoButton).addContainerGap(545, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.upButton).add((Component) this.extractButton).add((Component) this.infoButton)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.addressField, -2, -1, -2).add((Component) this.goButton).add((Component) this.pathLabel)).addPreferredGap(0).add(this.boxPanel, -1, 429, 32767)));
    }
}
