package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import org.catacombae.hfsexplorer.SpeedUnitUtils;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractProgressPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/ExtractProgressPanel.class */
public class ExtractProgressPanel extends JPanel {
    private final DecimalFormat progressFormatter = new DecimalFormat("0.0");
    private final DecimalFormat fileSizeFormatter = new DecimalFormat("0.00");
    public JButton cancelButton;
    private JLabel currentFilenameLabel;
    private JPanel internalPanel;
    private JProgressBar progressBar;
    private JToggleButton showSettingsButton;

    public ExtractProgressPanel() {
        initComponents();
        this.progressBar.setMinimum(0);
        this.progressBar.setMaximum(Integer.MAX_VALUE);
    }

    public void updateCalculateDir(final String dirname) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.ExtractProgressPanel.1
            @Override // java.lang.Runnable
            public void run() {
                ExtractProgressPanel.this.currentFilenameLabel.setText("Processing: " + dirname);
                ExtractProgressPanel.this.currentFilenameLabel.setToolTipText(dirname);
            }
        });
    }

    public void updateTotalProgress(final double fraction, final String message) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.ExtractProgressPanel.2
            @Override // java.lang.Runnable
            public void run() {
                ExtractProgressPanel.this.progressBar.setValue((int) (fraction * 2.147483647E9d));
                ExtractProgressPanel.this.progressBar.setString(ExtractProgressPanel.this.progressFormatter.format(100.0d * fraction) + "% (" + message + ")");
            }
        });
    }

    public void updateCurrentDir(final String dirname) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.ExtractProgressPanel.3
            @Override // java.lang.Runnable
            public void run() {
                ExtractProgressPanel.this.currentFilenameLabel.setText("Extracting: " + dirname);
                ExtractProgressPanel.this.currentFilenameLabel.setToolTipText(dirname);
            }
        });
    }

    public void updateCurrentFile(final String filename, final long fileSize) {
        SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.ExtractProgressPanel.4
            @Override // java.lang.Runnable
            public void run() {
                ExtractProgressPanel.this.currentFilenameLabel.setText("Extracting: " + filename + " (" + SpeedUnitUtils.bytesToBinaryUnit(fileSize, ExtractProgressPanel.this.fileSizeFormatter) + ")");
                ExtractProgressPanel.this.currentFilenameLabel.setToolTipText(filename);
            }
        });
    }

    public void addShowSettingsButtonListener(ActionListener al) {
        this.showSettingsButton.addActionListener(al);
    }

    public boolean getShowSettingsButtonSelected() {
        return this.showSettingsButton.isSelected();
    }

    private void initComponents() {
        this.internalPanel = new JPanel();
        this.currentFilenameLabel = new JLabel();
        this.progressBar = new JProgressBar();
        this.cancelButton = new JButton();
        this.showSettingsButton = new JToggleButton();
        this.currentFilenameLabel.setText("Calculating selection size...");
        this.progressBar.setString("Calculating selection size...");
        this.progressBar.setStringPainted(true);
        this.cancelButton.setText("Cancel");
        this.showSettingsButton.setText(">>");
        GroupLayout internalPanelLayout = new GroupLayout(this.internalPanel);
        this.internalPanel.setLayout(internalPanelLayout);
        internalPanelLayout.setHorizontalGroup(internalPanelLayout.createParallelGroup(1).add(this.currentFilenameLabel, -2, 400, -2).add(internalPanelLayout.createSequentialGroup().add(this.progressBar, -2, 274, -2).addPreferredGap(0).add((Component) this.cancelButton).addPreferredGap(0).add((Component) this.showSettingsButton)));
        internalPanelLayout.setVerticalGroup(internalPanelLayout.createParallelGroup(1).add(internalPanelLayout.createSequentialGroup().add((Component) this.currentFilenameLabel).addPreferredGap(0).add(internalPanelLayout.createParallelGroup(3).add(this.progressBar, -1, 24, 32767).add((Component) this.cancelButton).add((Component) this.showSettingsButton))));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.internalPanel, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.internalPanel, -2, -1, -2).addContainerGap(-1, 32767)));
    }
}
