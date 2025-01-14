package org.catacombae.hfsexplorer.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.catacombae.jparted.lib.fs.FSAttributes;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/POSIXAttributesPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/POSIXAttributesPanel.class */
public class POSIXAttributesPanel extends JPanel implements ChainedPanel {
    private JPanel chainedContentsPanel;
    private JCheckBox groupExecuteBox;
    private JTextField groupIDField;
    private JLabel groupIDLabel;
    private JLabel groupLabel;
    private JCheckBox groupReadBox;
    private JCheckBox groupWriteBox;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JSeparator jSeparator1;
    private JCheckBox otherExecuteBox;
    private JLabel otherLabel;
    private JCheckBox otherReadBox;
    private JCheckBox otherWriteBox;
    private JTextField ownerIDField;
    private JLabel ownerIDLabel;
    private JTextField permissionStringField;
    private JCheckBox setGidBox;
    private JCheckBox setUidBox;
    private JCheckBox stickyBitBox;
    private JCheckBox userExecuteBox;
    private JLabel userLabel;
    private JCheckBox userReadBox;
    private JCheckBox userWriteBox;

    public POSIXAttributesPanel(FSAttributes.POSIXFileAttributes attrs) {
        this();
        this.permissionStringField.setText(attrs.getPermissionString());
        this.userReadBox.setSelected(attrs.canUserRead());
        this.userWriteBox.setSelected(attrs.canUserWrite());
        this.userExecuteBox.setSelected(attrs.canUserExecute());
        this.groupReadBox.setSelected(attrs.canGroupRead());
        this.groupWriteBox.setSelected(attrs.canGroupWrite());
        this.groupExecuteBox.setSelected(attrs.canGroupExecute());
        this.otherReadBox.setSelected(attrs.canOthersRead());
        this.otherWriteBox.setSelected(attrs.canOthersWrite());
        this.otherExecuteBox.setSelected(attrs.canOthersExecute());
        this.setUidBox.setSelected(attrs.isSetUID());
        this.setGidBox.setSelected(attrs.isSetGID());
        this.stickyBitBox.setSelected(attrs.isStickyBit());
        this.ownerIDField.setText(attrs.getUserID() + "");
        this.groupIDField.setText(attrs.getGroupID() + "");
    }

    private POSIXAttributesPanel() {
        initComponents();
    }

    @Override // org.catacombae.hfsexplorer.gui.ChainedPanel
    public void setChainedContents(Component c2) {
        this.chainedContentsPanel.removeAll();
        this.chainedContentsPanel.add(c2);
    }

    private void initComponents() {
        this.groupIDField = new JTextField();
        this.ownerIDField = new JTextField();
        this.ownerIDLabel = new JLabel();
        this.groupIDLabel = new JLabel();
        this.stickyBitBox = new JCheckBox();
        this.setGidBox = new JCheckBox();
        this.setUidBox = new JCheckBox();
        this.otherLabel = new JLabel();
        this.otherReadBox = new JCheckBox();
        this.otherWriteBox = new JCheckBox();
        this.otherExecuteBox = new JCheckBox();
        this.groupExecuteBox = new JCheckBox();
        this.userExecuteBox = new JCheckBox();
        this.userWriteBox = new JCheckBox();
        this.groupWriteBox = new JCheckBox();
        this.groupReadBox = new JCheckBox();
        this.userReadBox = new JCheckBox();
        this.groupLabel = new JLabel();
        this.userLabel = new JLabel();
        this.permissionStringField = new JTextField();
        this.jLabel10 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.chainedContentsPanel = new JPanel();
        this.groupIDField.setEditable(false);
        this.groupIDField.setText("jTextField5");
        this.groupIDField.setBorder((Border) null);
        this.groupIDField.setOpaque(false);
        this.ownerIDField.setEditable(false);
        this.ownerIDField.setText("jTextField4");
        this.ownerIDField.setBorder((Border) null);
        this.ownerIDField.setOpaque(false);
        this.ownerIDLabel.setText("Owner ID:");
        this.groupIDLabel.setText("Group ID:");
        this.stickyBitBox.setBorder((Border) null);
        this.stickyBitBox.setEnabled(false);
        this.setGidBox.setBorder((Border) null);
        this.setGidBox.setEnabled(false);
        this.setUidBox.setBorder((Border) null);
        this.setUidBox.setEnabled(false);
        this.otherLabel.setText("Other:");
        this.otherReadBox.setBorder((Border) null);
        this.otherReadBox.setEnabled(false);
        this.otherWriteBox.setBorder((Border) null);
        this.otherWriteBox.setEnabled(false);
        this.otherExecuteBox.setBorder((Border) null);
        this.otherExecuteBox.setEnabled(false);
        this.groupExecuteBox.setBorder((Border) null);
        this.groupExecuteBox.setEnabled(false);
        this.userExecuteBox.setBorder((Border) null);
        this.userExecuteBox.setEnabled(false);
        this.userWriteBox.setBorder((Border) null);
        this.userWriteBox.setEnabled(false);
        this.groupWriteBox.setBorder((Border) null);
        this.groupWriteBox.setEnabled(false);
        this.groupReadBox.setBorder((Border) null);
        this.groupReadBox.setEnabled(false);
        this.userReadBox.setBorder((Border) null);
        this.userReadBox.setEnabled(false);
        this.groupLabel.setText("Group:");
        this.userLabel.setText("User:");
        this.permissionStringField.setEditable(false);
        this.permissionStringField.setText("jTextField6");
        this.permissionStringField.setOpaque(false);
        this.jLabel10.setText("Permission string:");
        this.jLabel4.setText("POSIX permissions:");
        this.jLabel1.setText("Execute");
        this.jLabel2.setText("Write");
        this.jLabel3.setText("Read");
        this.jLabel5.setText("Execute");
        this.jLabel6.setText("Write");
        this.jLabel7.setText("Read");
        this.jLabel8.setText("Execute");
        this.jLabel9.setText("Write");
        this.jLabel11.setText("Read");
        this.jLabel12.setText("Set user ID on execution");
        this.jLabel13.setText("Set group ID on execution");
        this.jLabel14.setText("Sticky bit");
        this.chainedContentsPanel.setLayout(new BorderLayout());
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add((Component) this.jLabel4).add(2, layout.createSequentialGroup().add(layout.createParallelGroup(2).add(1, this.jSeparator1, -1, 326, 32767).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.jLabel10).addPreferredGap(0).add(this.permissionStringField, -1, 228, 32767)).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add((Component) this.userLabel).add((Component) this.groupLabel).add((Component) this.otherLabel)).add(7, 7, 7).add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.otherReadBox).addPreferredGap(0).add((Component) this.jLabel11).addPreferredGap(0).add((Component) this.otherWriteBox).addPreferredGap(0).add((Component) this.jLabel9).addPreferredGap(0).add((Component) this.otherExecuteBox).addPreferredGap(0).add((Component) this.jLabel8)).add(layout.createSequentialGroup().add((Component) this.groupReadBox).addPreferredGap(0).add((Component) this.jLabel7).addPreferredGap(0).add((Component) this.groupWriteBox).addPreferredGap(0).add((Component) this.jLabel6).addPreferredGap(0).add((Component) this.groupExecuteBox).addPreferredGap(0).add((Component) this.jLabel5)).add(layout.createSequentialGroup().add((Component) this.userReadBox).addPreferredGap(0).add((Component) this.jLabel3).addPreferredGap(0).add((Component) this.userWriteBox).addPreferredGap(0).add((Component) this.jLabel2).addPreferredGap(0).add((Component) this.userExecuteBox).addPreferredGap(0).add((Component) this.jLabel1)))).add(layout.createSequentialGroup().add((Component) this.setUidBox).addPreferredGap(0).add((Component) this.jLabel12)).add(layout.createSequentialGroup().add((Component) this.setGidBox).addPreferredGap(0).add((Component) this.jLabel13)).add(layout.createSequentialGroup().add((Component) this.stickyBitBox).addPreferredGap(0).add((Component) this.jLabel14)).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add((Component) this.ownerIDLabel).add((Component) this.groupIDLabel)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.ownerIDField, -1, 262, 32767).add(this.groupIDField, -1, 262, 32767))))).add(1, this.chainedContentsPanel, -1, 326, 32767)).addPreferredGap(0))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.jLabel4).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.jLabel10).add(this.permissionStringField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.userReadBox).add((Component) this.userWriteBox).add((Component) this.userExecuteBox).add((Component) this.jLabel1).add((Component) this.jLabel2).add((Component) this.jLabel3).add((Component) this.userLabel)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.groupReadBox).add((Component) this.groupWriteBox).add((Component) this.groupExecuteBox).add((Component) this.jLabel5).add((Component) this.jLabel6).add((Component) this.jLabel7).add((Component) this.groupLabel)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.otherReadBox).add((Component) this.otherWriteBox).add((Component) this.otherExecuteBox).add((Component) this.jLabel8).add((Component) this.jLabel9).add((Component) this.jLabel11).add((Component) this.otherLabel)).addPreferredGap(1).add(layout.createParallelGroup(3).add((Component) this.setUidBox).add((Component) this.jLabel12)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.setGidBox).add((Component) this.jLabel13)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.stickyBitBox).add((Component) this.jLabel14)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.ownerIDLabel).add(this.ownerIDField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.groupIDLabel).add(this.groupIDField, -2, -1, -2)).addPreferredGap(0).add(this.jSeparator1, -2, -1, -2).addPreferredGap(0).add(this.chainedContentsPanel, -1, 21, 32767)));
    }
}
