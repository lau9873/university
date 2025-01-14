package org.catacombae.hfsexplorer.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.catacombae.hfsexplorer.types.hfsplus.JournalInfoBlock;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/JournalInfoPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/JournalInfoPanel.class */
public class JournalInfoPanel extends JPanel {
    private JPanel contentsPanel = new JPanel();
    private JournalInfoBlockPanel infoBlockPanel = new JournalInfoBlockPanel();
    private JPanel noJournalPanel = new JPanel();
    private JLabel noJournalLabel = new JLabel("No journal present", 0);
    private CardLayout layout = new CardLayout();

    public JournalInfoPanel(JournalInfoBlock jib) {
        this.contentsPanel.setLayout(new BorderLayout());
        this.contentsPanel.add(this.infoBlockPanel, "Center");
        this.noJournalPanel.setLayout(new BorderLayout());
        this.noJournalPanel.add(this.noJournalLabel, "Center");
        setLayout(this.layout);
        add(this.noJournalPanel, "A");
        add(this.contentsPanel, "B");
        this.layout.show(this, "A");
        setFields(jib);
    }

    public void setFields(JournalInfoBlock jib) {
        this.infoBlockPanel.setFields(jib);
        this.layout.show(this, "B");
    }
}
