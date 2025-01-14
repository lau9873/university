package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import org.catacombae.hfsexplorer.ObjectContainer;
import org.catacombae.hfsexplorer.SpeedUnitUtils;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.jparted.lib.fs.FSAttributes;
import org.catacombae.jparted.lib.fs.FSEntry;
import org.catacombae.jparted.lib.fs.FSFile;
import org.catacombae.jparted.lib.fs.FSFolder;
import org.catacombae.jparted.lib.fs.FSLink;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/FSEntrySummaryPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/FSEntrySummaryPanel.class */
public class FSEntrySummaryPanel extends JPanel implements ChainedPanel {
    private volatile boolean cancelSignaled;
    private DecimalFormat sizeFormatter;
    private JPanel extendedInfoStackPanel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JSeparator jSeparator1;
    private JTextField nameField;
    private JTextField sizeField;
    private JTextField typeField;

    FSEntrySummaryPanel() {
        this.cancelSignaled = false;
        this.sizeFormatter = new DecimalFormat("0.00");
        initComponents();
    }

    public FSEntrySummaryPanel(Window window, FSEntry entry, String[] parentPath) {
        this();
        String typeString;
        String sizeString;
        window.addWindowListener(new WindowAdapter() { // from class: org.catacombae.hfsexplorer.gui.FSEntrySummaryPanel.1
            public void windowClosing(WindowEvent e2) {
                FSEntrySummaryPanel.this.cancelSignaled = true;
            }
        });
        this.nameField.setText(entry.getName());
        if (entry instanceof FSFile) {
            FSFile file = (FSFile) entry;
            typeString = "File";
            sizeString = getSizeString(file.getMainFork().getLength());
        } else if (entry instanceof FSFolder) {
            FSFolder folder = (FSFolder) entry;
            typeString = "Folder";
            sizeString = "Calculating...";
            startFolderSizeCalculation(folder);
        } else if (entry instanceof FSLink) {
            FSLink link = (FSLink) entry;
            FSEntry linkTarget = link.getLinkTarget(parentPath);
            if (linkTarget == null) {
                typeString = "Symbolic link (broken)";
                sizeString = "- (broken link)";
            } else if (linkTarget instanceof FSFile) {
                FSFile file2 = (FSFile) linkTarget;
                typeString = "Symbolic link (file)";
                sizeString = getSizeString(file2.getMainFork().getLength());
            } else if (linkTarget instanceof FSFolder) {
                FSFolder folder2 = (FSFolder) linkTarget;
                typeString = "Symbolic link (folder)";
                sizeString = "Calculating...";
                startFolderSizeCalculation(folder2);
            } else {
                typeString = "Symbolic link (unknown [" + linkTarget.getClass() + "])";
                sizeString = "- (unknown type)";
            }
        } else {
            typeString = "Unknown [" + entry.getClass() + "]";
            sizeString = "- (unknown type)";
        }
        this.typeField.setText(typeString);
        this.sizeField.setText(sizeString);
        FSAttributes attrs = entry.getAttributes();
        Component component = this;
        if (entry instanceof FSLink) {
            Component linkTargetPanel = new LinkTargetPanel((FSLink) entry);
            component.setChainedContents(linkTargetPanel);
            component = linkTargetPanel;
        }
        DateSummaryPanel dsp = new DateSummaryPanel(attrs);
        component.setChainedContents(dsp);
        if (attrs.hasPOSIXFileAttributes()) {
            POSIXAttributesPanel attributesPanel = new POSIXAttributesPanel(attrs.getPOSIXFileAttributes());
            dsp.setChainedContents(attributesPanel);
        }
    }

    @Override // org.catacombae.hfsexplorer.gui.ChainedPanel
    public void setChainedContents(Component c2) {
        this.extendedInfoStackPanel.removeAll();
        this.extendedInfoStackPanel.add(c2);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.nameField = new JTextField();
        this.jLabel2 = new JLabel();
        this.typeField = new JTextField();
        this.jLabel3 = new JLabel();
        this.sizeField = new JTextField();
        this.jSeparator1 = new JSeparator();
        this.extendedInfoStackPanel = new JPanel();
        this.jLabel1.setText("Name:");
        this.nameField.setEditable(false);
        this.nameField.setText("jTextField1");
        this.nameField.setOpaque(false);
        this.jLabel2.setText("Type:");
        this.typeField.setEditable(false);
        this.typeField.setText("jTextField2");
        this.typeField.setBorder((Border) null);
        this.typeField.setOpaque(false);
        this.jLabel3.setText("Size:");
        this.sizeField.setEditable(false);
        this.sizeField.setText("jTextField3");
        this.sizeField.setBorder((Border) null);
        this.sizeField.setOpaque(false);
        this.extendedInfoStackPanel.setLayout(new BoxLayout(this.extendedInfoStackPanel, 3));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2).add(1, this.extendedInfoStackPanel, -1, 340, 32767).add(1, this.jSeparator1, -1, 340, 32767).add(1, layout.createSequentialGroup().add(layout.createParallelGroup(1).add((Component) this.jLabel1).add((Component) this.jLabel2).add((Component) this.jLabel3)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.sizeField, -1, 305, 32767).add(this.typeField, -1, 305, 32767).add(this.nameField, -1, 305, 32767)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.jLabel1).add(this.nameField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.jLabel2).add(this.typeField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.jLabel3).add(this.sizeField, -2, -1, -2)).addPreferredGap(0).add(this.jSeparator1, -2, -1, -2).addPreferredGap(0).add(this.extendedInfoStackPanel, -1, 119, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSizeString(long result) {
        String baseString = Long.toString(result);
        if (result >= 1000) {
            String spacedString = Util.addUnitSpaces(baseString, 3);
            if (result >= 1024) {
                return SpeedUnitUtils.bytesToBinaryUnit(result, this.sizeFormatter) + " (" + spacedString + " bytes)";
            }
            return spacedString + " bytes";
        }
        return baseString + " bytes";
    }

    private void startFolderSizeCalculation(final FSFolder folder) {
        Runnable r = new Runnable() { // from class: org.catacombae.hfsexplorer.gui.FSEntrySummaryPanel.2
            @Override // java.lang.Runnable
            public void run() {
                String resultString;
                String finalResultString;
                try {
                    ObjectContainer<Long> result = new ObjectContainer<>(0L);
                    FSEntrySummaryPanel.this.calculateFolderSize(folder, result);
                    resultString = FSEntrySummaryPanel.this.getSizeString(((Long) result.o).longValue());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    resultString = "Exception while calculating! See debug console for info...";
                }
                if (!FSEntrySummaryPanel.this.cancelSignaled) {
                    finalResultString = resultString;
                } else {
                    finalResultString = "Canceled";
                }
                final String str = finalResultString;
                SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.FSEntrySummaryPanel.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FSEntrySummaryPanel.this.sizeField.setText(str);
                    }
                });
            }
        };
        new Thread(r).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v20, types: [A, java.lang.Long] */
    public void calculateFolderSize(FSFolder folder, ObjectContainer<Long> result) {
        if (this.cancelSignaled) {
            System.err.println("Calculate process stopping for folder \"" + folder.getName() + "\"");
            return;
        }
        FSEntry[] arr$ = folder.listEntries();
        for (FSEntry entry : arr$) {
            if (this.cancelSignaled) {
                System.err.println("Calculate process stopping for folder \"" + folder.getName() + "\", entry \"" + entry.getName() + "\"");
                return;
            }
            if (entry instanceof FSFile) {
                result.o = Long.valueOf(result.o.longValue() + ((FSFile) entry).getMainFork().getLength());
            } else if (entry instanceof FSFolder) {
                calculateFolderSize((FSFolder) entry, result);
            } else if (!(entry instanceof FSLink)) {
                System.err.println("FSEntrySummaryPanel.calculateFolderSize(): unexpected type " + entry.getClass());
            }
        }
    }
}
