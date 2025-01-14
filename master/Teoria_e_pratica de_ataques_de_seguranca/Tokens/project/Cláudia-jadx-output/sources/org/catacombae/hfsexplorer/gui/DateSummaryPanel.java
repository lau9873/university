package org.catacombae.hfsexplorer.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.text.DateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.catacombae.jparted.lib.fs.FSAttributes;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/DateSummaryPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/DateSummaryPanel.class */
public class DateSummaryPanel extends JPanel implements ChainedPanel {
    private JTextField accessField;
    private JLabel accessLabel;
    private JTextField attributeModField;
    private JLabel attributeModLabel;
    private JTextField backupField;
    private JLabel backupLabel;
    private JPanel chainedContentsPanel;
    private JTextField contentModField;
    private JLabel contentModLabel;
    private JTextField createField;
    private JLabel createLabel;
    private JSeparator jSeparator1;

    public DateSummaryPanel(FSAttributes attributes) {
        initComponents();
        DateFormat df = DateFormat.getDateTimeInstance(3, 2);
        if (attributes.hasCreateDate()) {
            this.createField.setText(df.format(attributes.getCreateDate()));
        } else {
            this.createField.setText("<not available>");
        }
        if (attributes.hasModifyDate()) {
            this.contentModField.setText(df.format(attributes.getModifyDate()));
        } else {
            this.contentModField.setText("<not available>");
        }
        if (attributes.hasAttributeModifyDate()) {
            this.attributeModField.setText(df.format(attributes.getAttributeModifyDate()));
        } else {
            this.attributeModField.setText("<not available>");
        }
        if (attributes.hasAccessDate()) {
            this.accessField.setText(df.format(attributes.getAccessDate()));
        } else {
            this.accessField.setText("<not available>");
        }
        if (attributes.hasBackupDate()) {
            this.backupField.setText(df.format(attributes.getBackupDate()));
        } else {
            this.backupField.setText("<not available>");
        }
    }

    @Override // org.catacombae.hfsexplorer.gui.ChainedPanel
    public void setChainedContents(Component c2) {
        this.chainedContentsPanel.removeAll();
        this.chainedContentsPanel.add(c2);
    }

    private void initComponents() {
        this.createLabel = new JLabel();
        this.contentModLabel = new JLabel();
        this.attributeModLabel = new JLabel();
        this.accessLabel = new JLabel();
        this.backupLabel = new JLabel();
        this.createField = new JTextField();
        this.contentModField = new JTextField();
        this.attributeModField = new JTextField();
        this.accessField = new JTextField();
        this.backupField = new JTextField();
        this.jSeparator1 = new JSeparator();
        this.chainedContentsPanel = new JPanel();
        this.createLabel.setText("Created:");
        this.contentModLabel.setText("Contents modified:");
        this.attributeModLabel.setText("Attributes modified:");
        this.accessLabel.setText("Last accessed:");
        this.backupLabel.setText("Last backuped:");
        this.createField.setEditable(false);
        this.createField.setText("jTextField1");
        this.createField.setBorder((Border) null);
        this.createField.setOpaque(false);
        this.contentModField.setEditable(false);
        this.contentModField.setText("jTextField2");
        this.contentModField.setBorder((Border) null);
        this.contentModField.setOpaque(false);
        this.attributeModField.setEditable(false);
        this.attributeModField.setText("jTextField5");
        this.attributeModField.setBorder((Border) null);
        this.attributeModField.setOpaque(false);
        this.accessField.setEditable(false);
        this.accessField.setText("jTextField3");
        this.accessField.setBorder((Border) null);
        this.accessField.setOpaque(false);
        this.backupField.setEditable(false);
        this.backupField.setText("jTextField4");
        this.backupField.setBorder((Border) null);
        this.backupField.setOpaque(false);
        this.chainedContentsPanel.setLayout(new BorderLayout());
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add((Component) this.attributeModLabel).add((Component) this.contentModLabel).add((Component) this.accessLabel).add((Component) this.backupLabel).add((Component) this.createLabel)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.createField, -1, 133, 32767).add(this.backupField, -1, 133, 32767).add(this.accessField, -1, 133, 32767).add(2, this.contentModField, -1, 133, 32767).add(this.attributeModField, -1, 133, 32767))).add(this.jSeparator1, -1, 270, 32767).add(this.chainedContentsPanel, -1, 270, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(3).add((Component) this.createLabel).add(this.createField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.contentModLabel).add(this.contentModField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.attributeModLabel).add(this.attributeModField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.accessLabel).add(this.accessField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.backupLabel).add(this.backupField, -2, -1, -2)).addPreferredGap(0).add(this.jSeparator1, -2, -1, -2).addPreferredGap(0).add(this.chainedContentsPanel, -1, 10, 32767)));
    }
}
