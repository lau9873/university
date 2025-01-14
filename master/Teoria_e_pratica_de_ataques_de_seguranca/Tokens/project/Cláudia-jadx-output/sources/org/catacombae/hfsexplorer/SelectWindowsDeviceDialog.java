package org.catacombae.hfsexplorer;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.catacombae.hfsexplorer.PartitionSystemRecognizer;
import org.catacombae.hfsexplorer.gui.SelectWindowsDevicePanel;
import org.catacombae.hfsexplorer.partitioning.APMPartition;
import org.catacombae.hfsexplorer.partitioning.ApplePartitionMap;
import org.catacombae.hfsexplorer.partitioning.DriverDescriptorRecord;
import org.catacombae.hfsexplorer.partitioning.GPTEntry;
import org.catacombae.hfsexplorer.partitioning.GUIDPartitionTable;
import org.catacombae.hfsexplorer.partitioning.MBRPartition;
import org.catacombae.hfsexplorer.partitioning.MBRPartitionTable;
import org.catacombae.hfsexplorer.partitioning.Partition;
import org.catacombae.hfsexplorer.partitioning.PartitionSystem;
import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.io.ReadableConcatenatedStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.ps.PartitionType;
import org.catacombae.jparted.lib.ps.ebr.EBRPartition;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/SelectWindowsDeviceDialog.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/SelectWindowsDeviceDialog.class */
public class SelectWindowsDeviceDialog extends JDialog {
    private static final String DEVICE_PREFIX = "\\\\?\\GLOBALROOT\\Device\\";
    private SelectWindowsDevicePanel guiPanel;
    private JButton autodetectButton;
    private JRadioButton selectDeviceButton;
    private JRadioButton specifyDeviceNameButton;
    private JButton loadButton;
    private JButton cancelButton;
    private JTextField specifyDeviceNameField;
    private JComboBox detectedDevicesCombo;
    private ButtonGroup selectSpecifyGroup;
    private ReadableRandomAccessStream result;
    private String resultCreatePath;
    private String[] detectedDeviceNames;

    public SelectWindowsDeviceDialog(Frame owner, boolean modal, String title) {
        super(owner, modal);
        this.result = null;
        this.resultCreatePath = null;
        setTitle(title);
        this.guiPanel = new SelectWindowsDevicePanel();
        this.autodetectButton = this.guiPanel.autodetectButton;
        this.selectDeviceButton = this.guiPanel.selectDeviceButton;
        this.specifyDeviceNameButton = this.guiPanel.specifyDeviceNameButton;
        this.loadButton = this.guiPanel.loadButton;
        this.cancelButton = this.guiPanel.cancelButton;
        this.specifyDeviceNameField = this.guiPanel.specifyDeviceNameField;
        this.detectedDevicesCombo = this.guiPanel.detectedDevicesCombo;
        this.selectSpecifyGroup = new ButtonGroup();
        this.selectSpecifyGroup.add(this.selectDeviceButton);
        this.selectSpecifyGroup.add(this.specifyDeviceNameButton);
        this.detectedDevicesCombo.removeAllItems();
        this.detectedDeviceNames = detectDevices();
        String[] arr$ = this.detectedDeviceNames;
        for (String name : arr$) {
            this.detectedDevicesCombo.addItem(name);
        }
        if (this.detectedDeviceNames.length > 0) {
            this.detectedDevicesCombo.setSelectedIndex(0);
            this.specifyDeviceNameField.setText("\\\\?\\GLOBALROOT\\Device\\" + this.detectedDevicesCombo.getSelectedItem().toString());
        }
        this.autodetectButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.SelectWindowsDeviceDialog.1
            public void actionPerformed(ActionEvent ae) {
                SelectWindowsDeviceDialog.this.autodetectFilesystems();
            }
        });
        this.detectedDevicesCombo.addItemListener(new ItemListener() { // from class: org.catacombae.hfsexplorer.SelectWindowsDeviceDialog.2
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == 1) {
                    SelectWindowsDeviceDialog.this.specifyDeviceNameField.setText("\\\\?\\GLOBALROOT\\Device\\" + ie.getItem().toString());
                }
            }
        });
        this.selectDeviceButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.SelectWindowsDeviceDialog.3
            public void actionPerformed(ActionEvent ae) {
                SelectWindowsDeviceDialog.this.detectedDevicesCombo.setEnabled(true);
                SelectWindowsDeviceDialog.this.specifyDeviceNameField.setEnabled(false);
                SelectWindowsDeviceDialog.this.specifyDeviceNameField.setText("\\\\?\\GLOBALROOT\\Device\\" + SelectWindowsDeviceDialog.this.detectedDevicesCombo.getSelectedItem().toString());
            }
        });
        this.specifyDeviceNameButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.SelectWindowsDeviceDialog.4
            public void actionPerformed(ActionEvent ae) {
                SelectWindowsDeviceDialog.this.detectedDevicesCombo.setEnabled(false);
                SelectWindowsDeviceDialog.this.specifyDeviceNameField.setEnabled(true);
            }
        });
        this.loadButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.SelectWindowsDeviceDialog.5
            public void actionPerformed(ActionEvent ae) {
                SelectWindowsDeviceDialog.this.resultCreatePath = SelectWindowsDeviceDialog.this.specifyDeviceNameField.getText();
                SelectWindowsDeviceDialog.this.result = new WindowsLowLevelIO(SelectWindowsDeviceDialog.this.resultCreatePath);
                SelectWindowsDeviceDialog.this.setVisible(false);
            }
        });
        this.cancelButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.SelectWindowsDeviceDialog.6
            public void actionPerformed(ActionEvent ae) {
                SelectWindowsDeviceDialog.this.setVisible(false);
            }
        });
        add(this.guiPanel, "Center");
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public ReadableRandomAccessStream getPartitionStream() {
        return this.result;
    }

    public String getPathName() {
        return this.resultCreatePath;
    }

    protected String[] detectDevices() {
        LinkedList<String> activeDeviceNames = new LinkedList<>();
        int i2 = 0;
        while (true) {
            boolean anyFound = false;
            int j = 0;
            while (true) {
                try {
                    String currentDevice = "Harddisk" + i2 + "\\Partition" + j;
                    WindowsLowLevelIO curFile = new WindowsLowLevelIO("\\\\?\\GLOBALROOT\\Device\\" + currentDevice);
                    curFile.close();
                    activeDeviceNames.addLast(currentDevice);
                    anyFound = true;
                } catch (Exception e2) {
                    if (j >= 20) {
                        if (anyFound) {
                        }
                        i2++;
                    }
                }
                j++;
            }
            if (anyFound && i2 >= 20) {
                break;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            try {
                String currentDevice2 = "CdRom" + i3;
                WindowsLowLevelIO curFile2 = new WindowsLowLevelIO("\\\\?\\GLOBALROOT\\Device\\" + currentDevice2);
                curFile2.close();
                activeDeviceNames.addLast(currentDevice2);
            } catch (Exception e3) {
                if (i3 >= 20) {
                    return (String[]) activeDeviceNames.toArray(new String[activeDeviceNames.size()]);
                }
            }
            i3++;
        }
    }

    protected void autodetectFilesystems() {
        LinkedList<String> plainFileSystems = new LinkedList<>();
        LinkedList<EmbeddedPartitionEntry> embeddedFileSystems = new LinkedList<>();
        for (int i2 = 0; i2 < this.detectedDeviceNames.length; i2++) {
            String deviceName = this.detectedDeviceNames[i2];
            ReadableRandomAccessStream llf = null;
            try {
                llf = new WindowsLowLevelIO("\\\\?\\GLOBALROOT\\Device\\" + deviceName);
                PartitionSystemRecognizer psr = new PartitionSystemRecognizer(llf);
                PartitionSystemRecognizer.PartitionSystemType pst = psr.detectPartitionSystem();
                boolean fileSystemFound = false;
                if (pst != PartitionSystemRecognizer.PartitionSystemType.NONE_FOUND) {
                    PartitionSystem partSys = psr.getPartitionSystem();
                    Partition[] parts = partSys.getUsedPartitionEntries();
                    for (int j = 0; j < parts.length; j++) {
                        Partition part = parts[j];
                        PartitionType pt2 = part.getType();
                        if (pt2 == PartitionType.APPLE_HFS_CONTAINER || pt2 == PartitionType.APPLE_HFSX) {
                            FileSystemRecognizer fsr = new FileSystemRecognizer(llf, part.getStartOffset());
                            if (fsr.isTypeSupported(fsr.detectFileSystem())) {
                                fileSystemFound = true;
                                embeddedFileSystems.add(new EmbeddedPartitionEntry(deviceName, j, part));
                            }
                        }
                    }
                }
                if (!fileSystemFound && deviceName.endsWith("Partition0")) {
                    FileSystemRecognizer fsr2 = new FileSystemRecognizer(llf, 0L);
                    if (fsr2.isTypeSupported(fsr2.detectFileSystem())) {
                        plainFileSystems.add(deviceName);
                    }
                }
                llf.close();
            } catch (Exception e2) {
                System.out.println("INFO: Non-critical exception while detecting partition system at \"\\\\?\\GLOBALROOT\\Device\\" + deviceName + "\": " + e2.toString());
                if (llf != null) {
                    FileSystemRecognizer fsr3 = new FileSystemRecognizer(llf, 0L);
                    if (fsr3.isTypeSupported(fsr3.detectFileSystem())) {
                        plainFileSystems.add(deviceName);
                    }
                    llf.close();
                }
            }
        }
        if (plainFileSystems.size() >= 1 || embeddedFileSystems.size() >= 1) {
            String[] plainStrings = (String[]) plainFileSystems.toArray(new String[plainFileSystems.size()]);
            String[] embeddedStrings = new String[embeddedFileSystems.size()];
            int i3 = 0;
            Iterator i$ = embeddedFileSystems.iterator();
            while (i$.hasNext()) {
                EmbeddedPartitionEntry cur = i$.next();
                int i4 = i3;
                i3++;
                embeddedStrings[i4] = cur.toString();
            }
            String[] allOptions = new String[plainStrings.length + embeddedStrings.length];
            for (int i5 = 0; i5 < plainStrings.length; i5++) {
                allOptions[i5] = plainStrings[i5];
            }
            for (int i6 = 0; i6 < embeddedStrings.length; i6++) {
                allOptions[plainStrings.length + i6] = embeddedStrings[i6];
            }
            Object selectedValue = JOptionPane.showInputDialog(this, "Autodetection complete! Found " + allOptions.length + " HFS+ file systems.\nPlease choose which one to load:", "Load HFS+ file system", 3, (Icon) null, allOptions, allOptions[0]);
            if (selectedValue != null) {
                int selectedIndex = -1;
                int i7 = 0;
                while (true) {
                    if (i7 < allOptions.length) {
                        if (!selectedValue.equals(allOptions[i7])) {
                            i7++;
                        } else {
                            selectedIndex = i7;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (selectedIndex == -1) {
                    throw new RuntimeException("Internal error!");
                }
                if (selectedIndex >= plainStrings.length) {
                    EmbeddedPartitionEntry embeddedInfo = embeddedFileSystems.get(selectedIndex - plainStrings.length);
                    if (embeddedInfo == null) {
                        throw new RuntimeException("Internal error again.");
                    }
                    if (embeddedInfo.partition instanceof APMPartition) {
                        ReadableRandomAccessStream llf2 = new WindowsLowLevelIO("\\\\?\\GLOBALROOT\\Device\\" + embeddedInfo.deviceName);
                        DriverDescriptorRecord ddr = new DriverDescriptorRecord(llf2, 0L);
                        ApplePartitionMap apm = new ApplePartitionMap(llf2, ddr.getSbBlkSize() * 1, ddr.getSbBlkSize());
                        Partition p = apm.getPartitionEntry((int) embeddedInfo.partitionNumber);
                        this.resultCreatePath = "\\\\?\\GLOBALROOT\\Device\\" + selectedValue.toString();
                        this.result = new ReadableConcatenatedStream(llf2, p.getStartOffset(), p.getLength());
                        setVisible(false);
                        return;
                    } else if (embeddedInfo.partition instanceof GPTEntry) {
                        ReadableRandomAccessStream llf3 = new WindowsLowLevelIO("\\\\?\\GLOBALROOT\\Device\\" + embeddedInfo.deviceName);
                        GUIDPartitionTable gpt = new GUIDPartitionTable(llf3, 0);
                        Partition p2 = gpt.getPartitionEntry((int) embeddedInfo.partitionNumber);
                        this.resultCreatePath = "\\\\?\\GLOBALROOT\\Device\\" + selectedValue.toString();
                        this.result = new ReadableConcatenatedStream(llf3, p2.getStartOffset(), p2.getLength());
                        setVisible(false);
                        return;
                    } else if (embeddedInfo.partition instanceof MBRPartition) {
                        ReadableRandomAccessStream llf4 = new WindowsLowLevelIO("\\\\?\\GLOBALROOT\\Device\\" + embeddedInfo.deviceName);
                        MBRPartitionTable mbt = new MBRPartitionTable(llf4, 0);
                        Partition p3 = mbt.getPartitionEntry((int) embeddedInfo.partitionNumber);
                        this.resultCreatePath = "\\\\?\\GLOBALROOT\\Device\\" + selectedValue.toString();
                        this.result = new ReadableConcatenatedStream(llf4, p3.getStartOffset(), p3.getLength());
                        setVisible(false);
                        return;
                    } else {
                        throw new RuntimeException("Unexpected partition system: " + embeddedInfo.partition.getClass());
                    }
                }
                this.resultCreatePath = "\\\\?\\GLOBALROOT\\Device\\" + selectedValue.toString();
                this.result = new WindowsLowLevelIO(this.resultCreatePath);
                setVisible(false);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "No HFS+ file systems found...", "Result", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/SelectWindowsDeviceDialog$EmbeddedPartitionEntry.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/SelectWindowsDeviceDialog$EmbeddedPartitionEntry.class */
    public static final class EmbeddedPartitionEntry {
        public final String deviceName;
        public final long partitionNumber;
        public final Partition partition;

        public EmbeddedPartitionEntry(String deviceName, long partitionNumber, Partition partition) {
            this.deviceName = deviceName;
            this.partitionNumber = partitionNumber;
            this.partition = partition;
        }

        private String getPartitionSystemString() {
            if (this.partition instanceof APMPartition) {
                return "APM";
            }
            if (this.partition instanceof GPTEntry) {
                return "GPT";
            }
            if (this.partition instanceof EBRPartition) {
                return "EBR";
            }
            if (this.partition instanceof MBRPartition) {
                return "MBR";
            }
            return "Unknown partition system";
        }

        public String toString() {
            return this.deviceName + "[" + getPartitionSystemString() + ":Partition" + this.partitionNumber + "]";
        }
    }
}
