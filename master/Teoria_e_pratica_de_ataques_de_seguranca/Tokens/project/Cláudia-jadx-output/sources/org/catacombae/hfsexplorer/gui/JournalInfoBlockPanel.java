package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfsplus.JournalInfoBlock;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/JournalInfoBlockPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/JournalInfoBlockPanel.class */
public class JournalInfoBlockPanel extends JPanel {
    private JLabel deviceSignatureField0;
    private JLabel deviceSignatureField1;
    private JLabel deviceSignatureField2;
    private JLabel deviceSignatureField3;
    private JLabel deviceSignatureLabel;
    private JLabel flagsLabel;
    private JCheckBox journalInFSBox;
    private JLabel journalInFSLabel;
    private JCheckBox journalNeedInitBox;
    private JLabel journalNeedInitLabel;
    private JLabel journalOffsetField;
    private JLabel journalOffsetLabel;
    private JCheckBox journalOnOtherDeviceBox;
    private JLabel journalOnOtherDeviceLabel;
    private JLabel journalSizeField;
    private JLabel journalSizeLabel;
    private JLabel reservedField0;
    private JLabel reservedField1;
    private JLabel reservedField10;
    private JLabel reservedField11;
    private JLabel reservedField12;
    private JLabel reservedField13;
    private JLabel reservedField14;
    private JLabel reservedField15;
    private JLabel reservedField2;
    private JLabel reservedField3;
    private JLabel reservedField4;
    private JLabel reservedField5;
    private JLabel reservedField6;
    private JLabel reservedField7;
    private JLabel reservedField8;
    private JLabel reservedField9;
    private JLabel reservedLabel;

    public JournalInfoBlockPanel() {
        initComponents();
    }

    public void setFields(JournalInfoBlock jib) {
        int flags = jib.getFlags();
        this.journalInFSBox.setSelected((flags & 1) != 0);
        this.journalOnOtherDeviceBox.setSelected((flags & 2) != 0);
        this.journalNeedInitBox.setSelected((flags & 4) != 0);
        int[] deviceSignature = jib.getDeviceSignature();
        this.deviceSignatureField0.setText(Util.toHexStringBE(deviceSignature[0]) + Util.toHexStringBE(deviceSignature[1]));
        this.deviceSignatureField1.setText(Util.toHexStringBE(deviceSignature[2]) + Util.toHexStringBE(deviceSignature[3]));
        this.deviceSignatureField2.setText(Util.toHexStringBE(deviceSignature[4]) + Util.toHexStringBE(deviceSignature[5]));
        this.deviceSignatureField3.setText(Util.toHexStringBE(deviceSignature[6]) + Util.toHexStringBE(deviceSignature[7]));
        this.journalOffsetField.setText("0x" + Util.toHexStringBE(jib.getOffset()));
        this.journalSizeField.setText(jib.getSize() + " bytes");
        int[] reserved = jib.getReserved();
        this.reservedField0.setText(Util.toHexStringBE(reserved[0]) + Util.toHexStringBE(reserved[1]));
        this.reservedField1.setText(Util.toHexStringBE(reserved[2]) + Util.toHexStringBE(reserved[3]));
        this.reservedField2.setText(Util.toHexStringBE(reserved[4]) + Util.toHexStringBE(reserved[5]));
        this.reservedField3.setText(Util.toHexStringBE(reserved[6]) + Util.toHexStringBE(reserved[7]));
        this.reservedField4.setText(Util.toHexStringBE(reserved[8]) + Util.toHexStringBE(reserved[9]));
        this.reservedField5.setText(Util.toHexStringBE(reserved[10]) + Util.toHexStringBE(reserved[11]));
        this.reservedField6.setText(Util.toHexStringBE(reserved[12]) + Util.toHexStringBE(reserved[13]));
        this.reservedField7.setText(Util.toHexStringBE(reserved[14]) + Util.toHexStringBE(reserved[15]));
        this.reservedField8.setText(Util.toHexStringBE(reserved[16]) + Util.toHexStringBE(reserved[17]));
        this.reservedField9.setText(Util.toHexStringBE(reserved[18]) + Util.toHexStringBE(reserved[19]));
        this.reservedField10.setText(Util.toHexStringBE(reserved[20]) + Util.toHexStringBE(reserved[21]));
        this.reservedField11.setText(Util.toHexStringBE(reserved[22]) + Util.toHexStringBE(reserved[23]));
        this.reservedField12.setText(Util.toHexStringBE(reserved[24]) + Util.toHexStringBE(reserved[25]));
        this.reservedField13.setText(Util.toHexStringBE(reserved[26]) + Util.toHexStringBE(reserved[27]));
        this.reservedField14.setText(Util.toHexStringBE(reserved[28]) + Util.toHexStringBE(reserved[29]));
        this.reservedField15.setText(Util.toHexStringBE(reserved[30]) + Util.toHexStringBE(reserved[31]));
    }

    private void initComponents() {
        this.flagsLabel = new JLabel();
        this.journalInFSBox = new JCheckBox();
        this.journalOnOtherDeviceBox = new JCheckBox();
        this.journalNeedInitBox = new JCheckBox();
        this.journalInFSLabel = new JLabel();
        this.journalOnOtherDeviceLabel = new JLabel();
        this.journalNeedInitLabel = new JLabel();
        this.deviceSignatureLabel = new JLabel();
        this.journalOffsetLabel = new JLabel();
        this.journalSizeLabel = new JLabel();
        this.reservedLabel = new JLabel();
        this.deviceSignatureField0 = new JLabel();
        this.journalOffsetField = new JLabel();
        this.journalSizeField = new JLabel();
        this.reservedField0 = new JLabel();
        this.deviceSignatureField1 = new JLabel();
        this.deviceSignatureField2 = new JLabel();
        this.deviceSignatureField3 = new JLabel();
        this.reservedField1 = new JLabel();
        this.reservedField2 = new JLabel();
        this.reservedField3 = new JLabel();
        this.reservedField4 = new JLabel();
        this.reservedField5 = new JLabel();
        this.reservedField6 = new JLabel();
        this.reservedField7 = new JLabel();
        this.reservedField8 = new JLabel();
        this.reservedField9 = new JLabel();
        this.reservedField10 = new JLabel();
        this.reservedField11 = new JLabel();
        this.reservedField12 = new JLabel();
        this.reservedField13 = new JLabel();
        this.reservedField14 = new JLabel();
        this.reservedField15 = new JLabel();
        this.flagsLabel.setText("Flags:");
        this.journalInFSBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.journalInFSBox.setEnabled(false);
        this.journalInFSBox.setMargin(new Insets(0, 0, 0, 0));
        this.journalOnOtherDeviceBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.journalOnOtherDeviceBox.setEnabled(false);
        this.journalOnOtherDeviceBox.setMargin(new Insets(0, 0, 0, 0));
        this.journalNeedInitBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.journalNeedInitBox.setEnabled(false);
        this.journalNeedInitBox.setMargin(new Insets(0, 0, 0, 0));
        this.journalInFSLabel.setText("Journal is located in file system");
        this.journalOnOtherDeviceLabel.setText("Journal is located on other device");
        this.journalNeedInitLabel.setText("Journal needs to be initialized");
        this.deviceSignatureLabel.setText("Device signature:");
        this.journalOffsetLabel.setText("Journal offset:");
        this.journalSizeLabel.setText("Journal size:");
        this.reservedLabel.setText("Reserved:");
        this.deviceSignatureField0.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.journalOffsetField.setText("0xÖÖÖÖÖÖÖÖÖÖÖÖÖÖÖÖ");
        this.journalSizeField.setText("0 B");
        this.reservedField0.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.deviceSignatureField1.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.deviceSignatureField2.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.deviceSignatureField3.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField1.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField2.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField3.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField4.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField5.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField6.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField7.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField8.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField9.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField10.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField11.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField12.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField13.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField14.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        this.reservedField15.setText("ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ ÖÖ");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add((Component) this.flagsLabel).add(layout.createSequentialGroup().add(21, 21, 21).add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.journalOnOtherDeviceBox).addPreferredGap(0).add((Component) this.journalOnOtherDeviceLabel)).add(layout.createSequentialGroup().add((Component) this.journalInFSBox).addPreferredGap(0).add((Component) this.journalInFSLabel)).add(layout.createSequentialGroup().add((Component) this.journalNeedInitBox).addPreferredGap(0).add((Component) this.journalNeedInitLabel)))).add(layout.createSequentialGroup().add((Component) this.journalOffsetLabel).addPreferredGap(0).add(this.journalOffsetField, -1, 308, 32767)).add(layout.createSequentialGroup().add((Component) this.journalSizeLabel).addPreferredGap(0).add(this.journalSizeField, -1, 320, 32767)).add(layout.createSequentialGroup().add((Component) this.deviceSignatureLabel).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.deviceSignatureField3, -1, 288, 32767).add(this.deviceSignatureField0, -1, 288, 32767).add(this.deviceSignatureField1, -1, 288, 32767).add(this.deviceSignatureField2, -1, 288, 32767))).add(layout.createSequentialGroup().add((Component) this.reservedLabel).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.reservedField0, -1, 337, 32767).add(this.reservedField1, -1, 337, 32767).add(this.reservedField2, -1, 337, 32767).add(this.reservedField3, -1, 337, 32767).add(this.reservedField4, -1, 337, 32767).add(this.reservedField5, -1, 337, 32767).add(this.reservedField6, -1, 337, 32767).add(this.reservedField7, -1, 337, 32767).add(this.reservedField8, -1, 337, 32767).add(this.reservedField9, -1, 337, 32767).add(this.reservedField10, -1, 337, 32767).add(this.reservedField11, -1, 337, 32767).add(this.reservedField12, -1, 337, 32767).add(this.reservedField13, -1, 337, 32767).add(this.reservedField14, -1, 337, 32767).add(this.reservedField15, -1, 337, 32767)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.flagsLabel).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.journalInFSBox).add((Component) this.journalInFSLabel)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.journalOnOtherDeviceBox).add((Component) this.journalOnOtherDeviceLabel)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.journalNeedInitBox).add((Component) this.journalNeedInitLabel)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.deviceSignatureLabel).add((Component) this.deviceSignatureField0)).addPreferredGap(0).add((Component) this.deviceSignatureField1).addPreferredGap(0).add((Component) this.deviceSignatureField2).addPreferredGap(0).add((Component) this.deviceSignatureField3).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.journalOffsetLabel).add((Component) this.journalOffsetField)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.journalSizeLabel).add((Component) this.journalSizeField)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.reservedLabel).add((Component) this.reservedField0)).addPreferredGap(0).add((Component) this.reservedField1).addPreferredGap(0).add((Component) this.reservedField2).addPreferredGap(0).add((Component) this.reservedField3).addPreferredGap(0).add((Component) this.reservedField4).addPreferredGap(0).add((Component) this.reservedField5).addPreferredGap(0).add((Component) this.reservedField6).addPreferredGap(0).add((Component) this.reservedField7).addPreferredGap(0).add((Component) this.reservedField8).addPreferredGap(0).add((Component) this.reservedField9).addPreferredGap(0).add((Component) this.reservedField10).addPreferredGap(0).add((Component) this.reservedField11).addPreferredGap(0).add((Component) this.reservedField12).addPreferredGap(0).add((Component) this.reservedField13).addPreferredGap(0).add((Component) this.reservedField14).addPreferredGap(0).add((Component) this.reservedField15).addContainerGap(-1, 32767)));
    }
}
