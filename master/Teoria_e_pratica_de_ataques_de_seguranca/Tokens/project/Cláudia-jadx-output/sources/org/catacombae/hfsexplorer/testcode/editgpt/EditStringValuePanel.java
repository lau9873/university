package org.catacombae.hfsexplorer.testcode.editgpt;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.catacombae.csjc.structelements.StringRepresentableField;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/testcode/editgpt/EditStringValuePanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/testcode/editgpt/EditStringValuePanel.class */
public class EditStringValuePanel extends JPanel {
    private StringRepresentableField userData;
    private String originalValue;
    private JTextField contentsField;
    private JLabel descriptionLabel;
    private JCheckBox lockedCheckbox;

    public EditStringValuePanel() {
        initComponents();
    }

    private void initComponents() {
        this.contentsField = new JTextField();
        this.lockedCheckbox = new JCheckBox();
        this.descriptionLabel = new JLabel();
        this.contentsField.setColumns(9);
        this.contentsField.setEditable(false);
        this.contentsField.setText("jTextField1");
        this.lockedCheckbox.setSelected(true);
        this.lockedCheckbox.setText("Lock");
        this.lockedCheckbox.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.testcode.editgpt.EditStringValuePanel.1
            public void actionPerformed(ActionEvent evt) {
                EditStringValuePanel.this.lockedCheckboxActionPerformed(evt);
            }
        });
        this.descriptionLabel.setText("jLabel1");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.descriptionLabel).addPreferredGap(0).add(this.contentsField, -1, 362, 32767).addPreferredGap(0).add((Component) this.lockedCheckbox)));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createParallelGroup(3).add((Component) this.descriptionLabel).add(this.contentsField, -2, -1, -2).add((Component) this.lockedCheckbox)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lockedCheckboxActionPerformed(ActionEvent evt) {
        if (this.lockedCheckbox.isSelected()) {
            this.contentsField.setEditable(false);
        } else {
            this.contentsField.setEditable(true);
        }
    }

    public String getDescription() {
        return this.descriptionLabel.getText();
    }

    public void setDecription(String s) {
        this.descriptionLabel.setText(s);
    }

    public void setValue(String value) {
        this.contentsField.setText(value);
        this.originalValue = value;
    }

    public String getValue() {
        return this.contentsField.getText();
    }

    public boolean isModified() {
        return !this.contentsField.getText().equals(this.originalValue);
    }

    public void setUserData(StringRepresentableField data) {
        this.userData = data;
    }

    public StringRepresentableField getUserData() {
        return this.userData;
    }
}
