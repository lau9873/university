package org.catacombae.dmgextractor.ui;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/ui/PasswordDialog.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/ui/PasswordDialog.class */
public class PasswordDialog extends JDialog {
    private final PasswordPanel passwordPanel;
    private char[] password;

    private PasswordDialog(Frame owner, boolean modal, String dialogTitle, String messageLine) {
        super(owner, dialogTitle, modal);
        this.password = null;
        ActionListener okButtonListener = new ActionListener() { // from class: org.catacombae.dmgextractor.ui.PasswordDialog.1
            public void actionPerformed(ActionEvent e2) {
                PasswordDialog.this.actionOkButtonClicked();
            }
        };
        ActionListener cancelButtonListener = new ActionListener() { // from class: org.catacombae.dmgextractor.ui.PasswordDialog.2
            public void actionPerformed(ActionEvent e2) {
                PasswordDialog.this.actionCancelButtonClicked();
            }
        };
        this.passwordPanel = new PasswordPanel(messageLine, okButtonListener, cancelButtonListener);
        add(this.passwordPanel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionOkButtonClicked() {
        this.password = this.passwordPanel.getPassword();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionCancelButtonClicked() {
        this.password = null;
        dispose();
    }

    private char[] getPassword() {
        return this.password;
    }

    public static char[] showDialog(Component parentComponent, String dialogTitle, String messageLine) {
        PasswordDialog pd = new PasswordDialog(JOptionPane.getFrameForComponent(parentComponent), true, dialogTitle, messageLine);
        pd.pack();
        pd.setResizable(false);
        pd.setLocationRelativeTo(null);
        pd.setDefaultCloseOperation(2);
        pd.setVisible(true);
        return pd.getPassword();
    }
}
