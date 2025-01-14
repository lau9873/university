package org.catacombae.hfsexplorer.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import org.catacombae.jparted.lib.fs.FSLink;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/LinkTargetPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/LinkTargetPanel.class */
public class LinkTargetPanel extends JPanel implements ChainedPanel {
    private JPanel chainedContentsPanel;
    private JLabel jLabel1;
    private JSeparator jSeparator1;
    private JTextField linkTargetField;

    public LinkTargetPanel(FSLink link) {
        initComponents();
        this.linkTargetField.setText(link.getLinkTargetString());
    }

    @Override // org.catacombae.hfsexplorer.gui.ChainedPanel
    public void setChainedContents(Component c2) {
        this.chainedContentsPanel.removeAll();
        this.chainedContentsPanel.add(c2);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.linkTargetField = new JTextField();
        this.jSeparator1 = new JSeparator();
        this.chainedContentsPanel = new JPanel();
        this.jLabel1.setText("Link target:");
        this.linkTargetField.setEditable(false);
        this.linkTargetField.setText("jTextField1");
        this.linkTargetField.setOpaque(false);
        this.chainedContentsPanel.setLayout(new BorderLayout());
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add((Component) this.jLabel1).addPreferredGap(0).add(this.linkTargetField, -1, 95, 32767)).add(2, this.jSeparator1, -1, 177, 32767).add(this.chainedContentsPanel, -1, 177, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(3).add((Component) this.jLabel1).add(this.linkTargetField, -2, -1, -2)).addPreferredGap(0).add(this.jSeparator1, -2, -1, -2).addPreferredGap(0).add(this.chainedContentsPanel, -1, 8, 32767)));
    }
}
