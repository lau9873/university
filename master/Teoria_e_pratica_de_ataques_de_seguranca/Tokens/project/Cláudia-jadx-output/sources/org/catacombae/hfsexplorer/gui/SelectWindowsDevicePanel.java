package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/SelectWindowsDevicePanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/SelectWindowsDevicePanel.class */
public class SelectWindowsDevicePanel extends JPanel {
    public JButton autodetectButton;
    private JLabel autodetectLabel;
    public JButton cancelButton;
    public JComboBox detectedDevicesCombo;
    private JLabel detectedDevicesLabel;
    public JButton loadButton;
    private ButtonGroup partitionGroup;
    public JRadioButton selectDeviceButton;
    private ButtonGroup selectSpecifyGroup;
    public JRadioButton specifyDeviceNameButton;
    public JTextField specifyDeviceNameField;
    private JLabel warningLabel;

    public SelectWindowsDevicePanel() {
        initComponents();
        this.selectSpecifyGroup.add(this.selectDeviceButton);
        this.selectSpecifyGroup.add(this.specifyDeviceNameButton);
    }

    private void initComponents() {
        this.selectSpecifyGroup = new ButtonGroup();
        this.partitionGroup = new ButtonGroup();
        this.selectDeviceButton = new JRadioButton();
        this.specifyDeviceNameButton = new JRadioButton();
        this.specifyDeviceNameField = new JTextField();
        this.detectedDevicesCombo = new JComboBox();
        this.detectedDevicesLabel = new JLabel();
        this.loadButton = new JButton();
        this.cancelButton = new JButton();
        this.warningLabel = new JLabel();
        this.autodetectButton = new JButton();
        this.autodetectLabel = new JLabel();
        this.selectDeviceButton.setSelected(true);
        this.selectDeviceButton.setText("Select a device");
        this.selectDeviceButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.selectDeviceButton.setMargin(new Insets(0, 0, 0, 0));
        this.specifyDeviceNameButton.setText("Specify device name (example: \\\\?\\GLOBALROOT\\Device\\Harddisk0\\Partition1)");
        this.specifyDeviceNameButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.specifyDeviceNameButton.setMargin(new Insets(0, 0, 0, 0));
        this.specifyDeviceNameField.setText("\\\\?\\");
        this.specifyDeviceNameField.setEnabled(false);
        this.detectedDevicesCombo.setModel(new DefaultComboBoxModel(new String[]{"Harddisk0\\Partition1", "Harddisk0\\Partition2", "Harddisk1\\Partition1", "CdRom0", "CdRom1"}));
        this.detectedDevicesLabel.setText("Detected devices:");
        this.loadButton.setText("Load");
        this.cancelButton.setText("Cancel");
        this.warningLabel.setText("(hybrid CD-ROMs with both HFS/+/X and ISO filesystems won't work)");
        this.autodetectButton.setText("Autodetect...");
        this.autodetectLabel.setText("Automatically detects HFS/HFS+/HFSX partitions on your system");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.autodetectButton).addPreferredGap(0).add((Component) this.autodetectLabel)).add(layout.createSequentialGroup().add((Component) this.detectedDevicesLabel).addPreferredGap(0).add(this.detectedDevicesCombo, -2, -1, -2).addPreferredGap(0).add((Component) this.warningLabel)).add((Component) this.selectDeviceButton).add((Component) this.specifyDeviceNameButton).add(layout.createSequentialGroup().add((Component) this.loadButton).addPreferredGap(0).add((Component) this.cancelButton)).add(this.specifyDeviceNameField, -1, 569, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.autodetectButton).add((Component) this.autodetectLabel)).addPreferredGap(0).add((Component) this.selectDeviceButton).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.detectedDevicesLabel).add(this.detectedDevicesCombo, -2, -1, -2).add((Component) this.warningLabel)).addPreferredGap(0).add((Component) this.specifyDeviceNameButton).addPreferredGap(0).add(this.specifyDeviceNameField, -2, -1, -2).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.loadButton).add((Component) this.cancelButton)).addContainerGap(-1, 32767)));
    }
}
