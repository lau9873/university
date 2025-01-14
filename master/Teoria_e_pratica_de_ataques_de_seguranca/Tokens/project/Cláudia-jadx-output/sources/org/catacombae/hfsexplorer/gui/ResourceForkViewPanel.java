package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.catacombae.hfsexplorer.GUIUtil;
import org.catacombae.hfsexplorer.IOUtil;
import org.catacombae.hfsexplorer.fs.ResourceForkReader;
import org.catacombae.hfsexplorer.types.resff.ReferenceListEntry;
import org.catacombae.hfsexplorer.types.resff.ResourceMap;
import org.catacombae.hfsexplorer.types.resff.ResourceName;
import org.catacombae.hfsexplorer.types.resff.ResourceType;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.util.Util;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ResourceForkViewPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ResourceForkViewPanel.class */
public class ResourceForkViewPanel extends JPanel {
    private ResourceForkReader reader = null;
    private JTextField attributesField;
    private JLabel attributesLabel;
    private JButton extractButton;
    private JPanel fieldsPanel;
    private JTextField idField;
    private JLabel idLabel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JList resourceList;
    private JLabel resourceListLabel;
    private JScrollPane resourceListScroller;
    private JTextField sizeField;
    private JLabel sizeLabel;
    private JTextField typeField;
    private JLabel typeLabel;
    private JButton viewButton;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ResourceForkViewPanel$ListItem.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ResourceForkViewPanel$ListItem.class */
    public class ListItem {
        ResourceType type;
        ReferenceListEntry entry;
        ResourceName name;
        long size;

        public ListItem(ResourceType type, ReferenceListEntry entry, ResourceName name, long size) {
            this.type = type;
            this.entry = entry;
            this.name = name;
            this.size = size;
        }

        public String toString() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(new String(this.type.getType(), "MacRoman"));
                if (this.name != null) {
                    sb.append(" \"").append(new String(this.name.getName(), "MacRoman")).append("\"");
                }
                return sb.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return "{" + e2.getClass().getSimpleName() + " in resource id " + ((int) this.entry.getResourceID()) + "}";
            }
        }
    }

    public ResourceForkViewPanel(ResourceForkReader startupReader) {
        initComponents();
        this.resourceList.setSelectionMode(0);
        loadResourceFork(startupReader);
        this.resourceList.addListSelectionListener(new ListSelectionListener() { // from class: org.catacombae.hfsexplorer.gui.ResourceForkViewPanel.1
            public void valueChanged(ListSelectionEvent e2) {
                Object o = ResourceForkViewPanel.this.resourceList.getSelectedValue();
                if (o instanceof ListItem) {
                    ResourceForkViewPanel.this.setSelectedItem((ListItem) o);
                } else if (o != null) {
                    JOptionPane.showMessageDialog(ResourceForkViewPanel.this.resourceList, "Unexpected type in list: " + o.getClass());
                }
            }
        });
        this.viewButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.gui.ResourceForkViewPanel.2
            public void actionPerformed(ActionEvent e2) {
                Object selection = ResourceForkViewPanel.this.resourceList.getSelectedValue();
                if (selection != null && (selection instanceof ListItem)) {
                    ListItem selectedItem = (ListItem) selection;
                    JDialog d2 = new JDialog(JOptionPane.getFrameForComponent(ResourceForkViewPanel.this), selection.toString(), true);
                    DisplayTextFilePanel dtfp = new DisplayTextFilePanel();
                    dtfp.loadStream(ResourceForkViewPanel.this.reader.getResourceStream(selectedItem.entry));
                    d2.add(dtfp);
                    d2.pack();
                    d2.setLocationRelativeTo((Component) null);
                    d2.setVisible(true);
                }
            }
        });
        this.extractButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.gui.ResourceForkViewPanel.3
            private JFileChooser fileChooser = new JFileChooser();

            {
                this.fileChooser.setFileSelectionMode(0);
                this.fileChooser.setMultiSelectionEnabled(false);
            }

            public void actionPerformed(ActionEvent e2) {
                Object selection = ResourceForkViewPanel.this.resourceList.getSelectedValue();
                if (selection == null || !(selection instanceof ListItem)) {
                    return;
                }
                ListItem selectedItem = (ListItem) selection;
                if (this.fileChooser.showSaveDialog(ResourceForkViewPanel.this) == 0) {
                    File saveFile = this.fileChooser.getSelectedFile();
                    if (saveFile.exists()) {
                        int res = JOptionPane.showConfirmDialog(ResourceForkViewPanel.this, "The file already exists. Do you want to overwrite?", "Confirm overwrite", 0, 3);
                        if (res != 0) {
                            return;
                        }
                    }
                    ReadableRandomAccessStream in = null;
                    FileOutputStream fos = null;
                    try {
                        try {
                            in = ResourceForkViewPanel.this.reader.getResourceStream(selectedItem.entry);
                            fos = new FileOutputStream(saveFile);
                            IOUtil.streamCopy(in, fos, 65536);
                            if (in != null) {
                                in.close();
                            }
                            if (fos != null) {
                                try {
                                    fos.close();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                    GUIUtil.displayExceptionDialog(ex, ResourceForkViewPanel.this);
                                }
                            }
                        } catch (Throwable th) {
                            if (in != null) {
                                in.close();
                            }
                            if (fos != null) {
                                try {
                                    fos.close();
                                } catch (IOException ex2) {
                                    ex2.printStackTrace();
                                    GUIUtil.displayExceptionDialog(ex2, ResourceForkViewPanel.this);
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e3) {
                        JOptionPane.showMessageDialog(ResourceForkViewPanel.this, "Could not open file \"" + saveFile.getPath() + "\" for writing...", "Error", 0);
                        if (in != null) {
                            in.close();
                        }
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException ex3) {
                                ex3.printStackTrace();
                                GUIUtil.displayExceptionDialog(ex3, ResourceForkViewPanel.this);
                            }
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                        GUIUtil.displayExceptionDialog(ioe, ResourceForkViewPanel.this);
                        if (in != null) {
                            in.close();
                        }
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException ex4) {
                                ex4.printStackTrace();
                                GUIUtil.displayExceptionDialog(ex4, ResourceForkViewPanel.this);
                            }
                        }
                    }
                }
            }
        });
    }

    public void loadResourceFork(ResourceForkReader reader) {
        if (reader != null) {
            ListItem[] allItems = listAllItems(reader);
            this.resourceList.setEnabled(true);
            this.resourceList.setListData(allItems);
            this.resourceListLabel.setText("Resource list (" + allItems.length + " items):");
        } else {
            this.resourceList.setEnabled(false);
            this.resourceList.setListData(new Object[0]);
            this.resourceListLabel.setText("Resource list:");
        }
        setSelectedItem(null);
        this.reader = reader;
    }

    private ListItem[] listAllItems(ResourceForkReader reader) {
        ResourceMap resMap = reader.getResourceMap();
        LinkedList<ListItem> result = new LinkedList<>();
        List<Util.Pair<ResourceType, ReferenceListEntry[]>> refList = resMap.getReferenceList();
        for (Util.Pair<ResourceType, ReferenceListEntry[]> p : refList) {
            ResourceType type = p.getA();
            ReferenceListEntry[] arr$ = p.getB();
            for (ReferenceListEntry entry : arr$) {
                ResourceName name = resMap.getNameByReferenceListEntry(entry);
                long size = reader.getDataLength(entry);
                result.add(new ListItem(type, entry, name, size));
            }
        }
        return (ListItem[]) result.toArray(new ListItem[result.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedItem(ListItem li) {
        boolean enabled;
        String nameString;
        String typeString;
        if (li == null) {
            enabled = false;
        } else {
            enabled = true;
        }
        this.extractButton.setEnabled(enabled);
        this.viewButton.setEnabled(enabled);
        this.nameField.setEnabled(enabled);
        this.typeField.setEnabled(enabled);
        this.idField.setEnabled(enabled);
        this.sizeField.setEnabled(enabled);
        this.attributesField.setEnabled(enabled);
        if (!enabled) {
            this.nameField.setText("");
            this.typeField.setText("");
            this.idField.setText("");
            this.sizeField.setText("");
            this.attributesField.setText("");
            return;
        }
        if (li.name != null) {
            try {
                nameString = new String(li.name.getName(), "MacRoman");
            } catch (Exception e2) {
                e2.printStackTrace();
                nameString = "[Could not decode: " + e2.toString() + "]";
            }
        } else {
            nameString = null;
        }
        try {
            typeString = new String(li.type.getType(), "MacRoman");
        } catch (Exception e3) {
            e3.printStackTrace();
            typeString = "[Could not decode: " + e3.toString() + "]";
        }
        if (this.nameField == null) {
            this.nameField.setEnabled(false);
            this.nameField.setName("");
        } else {
            this.nameField.setText(nameString);
        }
        this.typeField.setText(typeString);
        this.idField.setText("" + ((int) li.entry.getResourceID()));
        this.sizeField.setText(li.size + " bytes");
        this.attributesField.setText("0x" + org.catacombae.hfsexplorer.Util.toHexStringBE(li.entry.getResourceAttributes()));
    }

    private void initComponents() {
        this.resourceListLabel = new JLabel();
        this.resourceListScroller = new JScrollPane();
        this.resourceList = new JList();
        this.fieldsPanel = new JPanel();
        this.nameLabel = new JLabel();
        this.nameField = new JTextField();
        this.typeLabel = new JLabel();
        this.typeField = new JTextField();
        this.idLabel = new JLabel();
        this.idField = new JTextField();
        this.sizeLabel = new JLabel();
        this.sizeField = new JTextField();
        this.attributesLabel = new JLabel();
        this.attributesField = new JTextField();
        this.extractButton = new JButton();
        this.viewButton = new JButton();
        this.resourceListLabel.setText("[This label is set programmatically]");
        this.resourceList.setModel(new AbstractListModel() { // from class: org.catacombae.hfsexplorer.gui.ResourceForkViewPanel.4
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return this.strings.length;
            }

            public Object getElementAt(int i2) {
                return this.strings[i2];
            }
        });
        this.resourceListScroller.setViewportView(this.resourceList);
        this.nameLabel.setText("Name:");
        this.nameField.setEditable(false);
        this.nameField.setText("jTextField1");
        this.nameField.setOpaque(false);
        this.typeLabel.setText("Type:");
        this.typeField.setEditable(false);
        this.typeField.setText("jTextField2");
        this.typeField.setOpaque(false);
        this.idLabel.setText("ID:");
        this.idField.setEditable(false);
        this.idField.setText("jTextField3");
        this.idField.setOpaque(false);
        this.sizeLabel.setText("Size:");
        this.sizeField.setEditable(false);
        this.sizeField.setText("jTextField4");
        this.sizeField.setOpaque(false);
        this.attributesLabel.setText("Attributes:");
        this.attributesField.setEditable(false);
        this.attributesField.setText("jTextField5");
        this.attributesField.setOpaque(false);
        GroupLayout fieldsPanelLayout = new GroupLayout(this.fieldsPanel);
        this.fieldsPanel.setLayout(fieldsPanelLayout);
        fieldsPanelLayout.setHorizontalGroup(fieldsPanelLayout.createParallelGroup(1).add(fieldsPanelLayout.createSequentialGroup().add(fieldsPanelLayout.createParallelGroup(1).add((Component) this.nameLabel).add((Component) this.typeLabel).add((Component) this.idLabel).add((Component) this.sizeLabel).add((Component) this.attributesLabel)).addPreferredGap(0).add(fieldsPanelLayout.createParallelGroup(1).add(this.attributesField, -1, 227, 32767).add(this.sizeField, -1, 227, 32767).add(this.idField, -1, 227, 32767).add(this.nameField, -1, 227, 32767).add(this.typeField, -1, 227, 32767))));
        fieldsPanelLayout.setVerticalGroup(fieldsPanelLayout.createParallelGroup(1).add(fieldsPanelLayout.createSequentialGroup().add(fieldsPanelLayout.createParallelGroup(3).add((Component) this.nameLabel).add(this.nameField, -2, -1, -2)).addPreferredGap(0).add(fieldsPanelLayout.createParallelGroup(3).add((Component) this.typeLabel).add(this.typeField, -2, -1, -2)).addPreferredGap(0).add(fieldsPanelLayout.createParallelGroup(3).add((Component) this.idLabel).add(this.idField, -2, -1, -2)).addPreferredGap(0).add(fieldsPanelLayout.createParallelGroup(3).add((Component) this.sizeLabel).add(this.sizeField, -2, -1, -2)).addPreferredGap(0).add(fieldsPanelLayout.createParallelGroup(3).add((Component) this.attributesLabel).add(this.attributesField, -2, -1, -2))));
        this.extractButton.setText("Save to file...");
        this.viewButton.setText("View as text");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2).add(1, this.resourceListScroller, -1, 283, 32767).add(1, (Component) this.resourceListLabel).add(layout.createSequentialGroup().add((Component) this.viewButton).addPreferredGap(0).add((Component) this.extractButton)).add(1, this.fieldsPanel, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.resourceListLabel).addPreferredGap(0).add(this.resourceListScroller, -1, 99, 32767).addPreferredGap(0).add(this.fieldsPanel, -2, -1, -2).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.extractButton).add((Component) this.viewButton)).addContainerGap()));
    }
}
