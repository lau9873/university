package org.catacombae.hfsexplorer.unfinished;

import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/unfinished/CacheSettingsPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/unfinished/CacheSettingsPanel.class */
public class CacheSettingsPanel extends JPanel {
    private JButton applyButton;
    private JTextField blockSizeField;
    private JLabel blockSizeLabel;
    private JTextField blocksInCacheField;
    private JLabel blocksInCacheLabel;
    private JCheckBox cachingEnabledBox;
    private JButton cancelButton;
    private JTextField totalCacheSizeField;
    private JLabel totalCacheSizeLabel;

    public CacheSettingsPanel(BaseHFSFileSystemView fsView) {
        initComponents();
        this.cachingEnabledBox.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.unfinished.CacheSettingsPanel.1
            public void actionPerformed(ActionEvent ae) {
                boolean b2 = CacheSettingsPanel.this.cachingEnabledBox.isSelected();
                CacheSettingsPanel.this.blockSizeField.setEnabled(b2);
                CacheSettingsPanel.this.blocksInCacheField.setEnabled(b2);
            }
        });
        this.applyButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.unfinished.CacheSettingsPanel.2
            public void actionPerformed(ActionEvent ae) {
            }
        });
    }

    public static void main(String[] args) {
        CacheSettingsPanel csp = new CacheSettingsPanel(null);
        JFrame jf = new JFrame();
        jf.add(csp);
        jf.pack();
        jf.setLocationRelativeTo((Component) null);
        jf.setVisible(true);
    }

    private void initComponents() {
        this.cachingEnabledBox = new JCheckBox();
        this.blockSizeLabel = new JLabel();
        this.blocksInCacheLabel = new JLabel();
        this.blocksInCacheField = new JTextField();
        this.blockSizeField = new JTextField();
        this.totalCacheSizeLabel = new JLabel();
        this.totalCacheSizeField = new JTextField();
        this.applyButton = new JButton();
        this.cancelButton = new JButton();
        this.cachingEnabledBox.setText("Caching enabled");
        this.cachingEnabledBox.setMargin(new Insets(0, 0, 0, 0));
        this.blockSizeLabel.setHorizontalAlignment(11);
        this.blockSizeLabel.setText("Block size:");
        this.blocksInCacheLabel.setHorizontalAlignment(11);
        this.blocksInCacheLabel.setText("Blocks in cache:");
        this.blocksInCacheField.setColumns(9);
        this.blocksInCacheField.setEnabled(false);
        this.blockSizeField.setColumns(9);
        this.blockSizeField.setEnabled(false);
        this.totalCacheSizeLabel.setHorizontalAlignment(11);
        this.totalCacheSizeLabel.setText("Total cache size:");
        this.totalCacheSizeField.setEditable(false);
        this.totalCacheSizeField.setText("0 B");
        this.totalCacheSizeField.setBorder((Border) null);
        this.totalCacheSizeField.setOpaque(false);
        this.applyButton.setText("Apply");
        this.cancelButton.setText("Cancel");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().add((Component) this.cancelButton).addPreferredGap(0, 102, 32767).add((Component) this.applyButton)).add(layout.createSequentialGroup().add(layout.createParallelGroup(2, false).add(this.totalCacheSizeLabel, -1, -1, 32767).add(1, this.blocksInCacheLabel, -1, -1, 32767).add(1, this.blockSizeLabel, -1, -1, 32767).add(1, this.cachingEnabledBox, -1, -1, 32767)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.blocksInCacheField, -2, -1, -2).add(this.blockSizeField, -2, -1, -2).add(this.totalCacheSizeField, -1, 116, 32767)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add((Component) this.cachingEnabledBox).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.blockSizeLabel).add(this.blockSizeField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.blocksInCacheLabel).add(this.blocksInCacheField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add(this.totalCacheSizeField, -2, -1, -2).add((Component) this.totalCacheSizeLabel)).addPreferredGap(0, -1, 32767).add(layout.createParallelGroup(3).add((Component) this.applyButton).add((Component) this.cancelButton)).addContainerGap()));
    }
}
