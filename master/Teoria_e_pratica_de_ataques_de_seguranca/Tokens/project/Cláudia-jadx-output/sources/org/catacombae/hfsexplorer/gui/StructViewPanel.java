package org.catacombae.hfsexplorer.gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.catacombae.csjc.structelements.Array;
import org.catacombae.csjc.structelements.Dictionary;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/StructViewPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/StructViewPanel.class */
public class StructViewPanel extends JPanel {
    private JPanel containerPanel;

    public StructViewPanel(String label, Dictionary dict) {
        this();
        this.containerPanel.add(new InternalStructViewPanel(label, dict));
    }

    public StructViewPanel(String label, Array array) {
        this();
        this.containerPanel.add(new InternalStructViewPanel(label, array));
    }

    private StructViewPanel() {
        initComponents();
    }

    private void initComponents() {
        this.containerPanel = new JPanel();
        this.containerPanel.setLayout(new BorderLayout());
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.containerPanel, -1, 360, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.containerPanel, -1, 260, 32767).addContainerGap()));
    }
}
