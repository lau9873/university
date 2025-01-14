package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.catacombae.csjc.structelements.StringRepresentableField;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/TextViewPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/TextViewPanel.class */
public class TextViewPanel extends JPanel {
    private JTextField fieldContents;
    private JLabel fieldLabel;
    private JLabel jLabel1;

    public TextViewPanel(String label, StringRepresentableField field) {
        initComponents();
        this.fieldLabel.setText(label);
        String fieldContentsText = field.getValueAsString();
        String suffix = field.getUnitComponent();
        this.fieldContents.setText(suffix != null ? fieldContentsText + " " + suffix : fieldContentsText);
        this.jLabel1.setVisible(false);
    }

    private void initComponents() {
        this.fieldLabel = new JLabel();
        this.fieldContents = new JTextField();
        this.jLabel1 = new JLabel();
        this.fieldLabel.setText("jLabel1");
        this.fieldContents.setEditable(false);
        this.fieldContents.setText("jTextField1");
        this.fieldContents.setBorder((Border) null);
        this.fieldContents.setOpaque(false);
        this.jLabel1.setText("jLabel1");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.fieldLabel).addPreferredGap(0).add(this.fieldContents, -1, 87, 32767)).add(layout.createSequentialGroup().add((Component) this.jLabel1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(3).add((Component) this.fieldLabel).add(this.fieldContents, -2, -1, -2)).addPreferredGap(0).add((Component) this.jLabel1)));
    }
}
