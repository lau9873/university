package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.catacombae.csjc.structelements.FlagField;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/FlagViewPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/FlagViewPanel.class */
public class FlagViewPanel extends JPanel {
    private JCheckBox flagBox;
    private JLabel flagLabel;

    public FlagViewPanel(String label, FlagField data) {
        initComponents();
        this.flagBox.setEnabled(false);
        this.flagBox.setSelected(data.getValueAsBoolean());
        this.flagLabel.setText(label);
    }

    private void initComponents() {
        this.flagBox = new JCheckBox();
        this.flagLabel = new JLabel();
        this.flagBox.setBorder((Border) null);
        this.flagBox.setFocusable(false);
        this.flagLabel.setText("jLabel1");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.flagBox).addPreferredGap(0).add(this.flagLabel, -1, 66, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createParallelGroup(3).add((Component) this.flagBox).add((Component) this.flagLabel)));
    }
}
