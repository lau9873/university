package org.catacombae.dmgextractor.ui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/ui/PasswordPanel.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/ui/PasswordPanel.class */
class PasswordPanel extends JPanel {
    private JPanel buttonLayoutHelper;
    private JButton cancelButton;
    private JLabel instructionsLabel;
    private JButton okButton;
    private JPasswordField passwordField;

    public PasswordPanel(String messageLine, ActionListener okButtonListener, ActionListener cancelButtonListener) {
        this();
        this.instructionsLabel.setText(messageLine);
        this.passwordField.addActionListener(okButtonListener);
        this.okButton.addActionListener(okButtonListener);
        this.cancelButton.addActionListener(cancelButtonListener);
    }

    private PasswordPanel() {
        initComponents();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char[] getPassword() {
        return this.passwordField.getPassword();
    }

    private void initComponents() {
        this.passwordField = new JPasswordField();
        this.instructionsLabel = new JLabel();
        this.buttonLayoutHelper = new JPanel();
        this.okButton = new JButton();
        this.cancelButton = new JButton();
        this.instructionsLabel.setHorizontalAlignment(0);
        this.instructionsLabel.setText("You need to enter a password to unlock this disk image:");
        this.buttonLayoutHelper.setLayout(new FlowLayout(1, 5, 0));
        this.okButton.setText("OK");
        this.buttonLayoutHelper.add(this.okButton);
        this.cancelButton.setText("Cancel");
        this.buttonLayoutHelper.add(this.cancelButton);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.passwordField, -1, 306, 32767).add(this.instructionsLabel, -1, 306, 32767).add(this.buttonLayoutHelper, -1, 306, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.instructionsLabel).addPreferredGap(0).add(this.passwordField, -2, -1, -2).addPreferredGap(1).add(this.buttonLayoutHelper, -2, -1, -2).addContainerGap(-1, 32767)));
    }
}
