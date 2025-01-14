package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import org.catacombae.hfsexplorer.Util;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/MemoryStatisticsPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/MemoryStatisticsPanel.class */
public class MemoryStatisticsPanel extends JPanel {
    private final Object syncObj = new Object();
    private boolean abortThread = false;
    private JTextField allocatedMemoryField;
    private JTextField currentMaxMemoryField;
    private JTextField freeMemoryField;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField maxMemoryField;
    private JButton runGcButton;

    public MemoryStatisticsPanel() {
        initComponents();
        this.runGcButton.addActionListener(new ActionListener() { // from class: org.catacombae.hfsexplorer.gui.MemoryStatisticsPanel.1
            public void actionPerformed(ActionEvent e2) {
                Runtime.getRuntime().gc();
            }
        });
    }

    public void startThread() {
        Runnable r = new Runnable() { // from class: org.catacombae.hfsexplorer.gui.MemoryStatisticsPanel.2
            @Override // java.lang.Runnable
            public void run() {
                Runtime rt = Runtime.getRuntime();
                synchronized (MemoryStatisticsPanel.this.syncObj) {
                    while (!MemoryStatisticsPanel.this.abortThread) {
                        final long curMaxMem = rt.totalMemory();
                        final long maxMem = rt.maxMemory();
                        final long freeMem = rt.freeMemory();
                        final long allocatedMem = curMaxMem - freeMem;
                        SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.MemoryStatisticsPanel.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MemoryStatisticsPanel.this.allocatedMemoryField.setText(Util.addUnitSpaces("" + allocatedMem, 3) + " bytes");
                                MemoryStatisticsPanel.this.freeMemoryField.setText(Util.addUnitSpaces("" + freeMem, 3) + " bytes");
                                MemoryStatisticsPanel.this.currentMaxMemoryField.setText(Util.addUnitSpaces("" + curMaxMem, 3) + " bytes");
                                MemoryStatisticsPanel.this.maxMemoryField.setText(Util.addUnitSpaces("" + maxMem, 3) + " bytes");
                            }
                        });
                        try {
                            MemoryStatisticsPanel.this.syncObj.wait(500L);
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                    MemoryStatisticsPanel.this.syncObj.notify();
                }
                System.err.println("MemoryStatisticsPanel thread aborted.");
            }
        };
        synchronized (this.syncObj) {
            new Thread(r).start();
        }
    }

    public void stopThread() {
        synchronized (this.syncObj) {
            this.abortThread = true;
            this.syncObj.notify();
            try {
                this.syncObj.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public static JFrame createMemoryStatisticsWindow() {
        final JFrame memoryStatisticsWindow = new JFrame("Memory statistics");
        MemoryStatisticsPanel msp = new MemoryStatisticsPanel();
        memoryStatisticsWindow.add(msp);
        memoryStatisticsWindow.setDefaultCloseOperation(0);
        memoryStatisticsWindow.addWindowListener(new WindowAdapter() { // from class: org.catacombae.hfsexplorer.gui.MemoryStatisticsPanel.3
            public void windowOpened(WindowEvent e2) {
                MemoryStatisticsPanel.this.startThread();
            }

            public void windowClosing(WindowEvent e2) {
                MemoryStatisticsPanel.this.stopThread();
                memoryStatisticsWindow.dispose();
            }
        });
        memoryStatisticsWindow.pack();
        memoryStatisticsWindow.setLocationRelativeTo((Component) null);
        memoryStatisticsWindow.setResizable(false);
        return memoryStatisticsWindow;
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.runGcButton = new JButton();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.allocatedMemoryField = new JTextField();
        this.freeMemoryField = new JTextField();
        this.currentMaxMemoryField = new JTextField();
        this.maxMemoryField = new JTextField();
        this.jLabel1.setText("Allocated memory:");
        this.runGcButton.setText("Run GC");
        this.jLabel2.setText("Free memory:");
        this.jLabel3.setText("Current max:");
        this.jLabel4.setText("Total max:");
        this.allocatedMemoryField.setEditable(false);
        this.allocatedMemoryField.setBorder((Border) null);
        this.allocatedMemoryField.setOpaque(false);
        this.freeMemoryField.setEditable(false);
        this.freeMemoryField.setBorder((Border) null);
        this.freeMemoryField.setOpaque(false);
        this.currentMaxMemoryField.setEditable(false);
        this.currentMaxMemoryField.setBorder((Border) null);
        this.currentMaxMemoryField.setOpaque(false);
        this.maxMemoryField.setEditable(false);
        this.maxMemoryField.setBorder((Border) null);
        this.maxMemoryField.setOpaque(false);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(layout.createParallelGroup(1).add((Component) this.jLabel1).add((Component) this.jLabel2).add((Component) this.jLabel3).add((Component) this.jLabel4)).addPreferredGap(0).add(layout.createParallelGroup(1).add(this.freeMemoryField, -1, 228, 32767).add(this.allocatedMemoryField, -1, 228, 32767).add(this.currentMaxMemoryField, -1, 228, 32767).add(this.maxMemoryField, -1, 228, 32767))).add(2, (Component) this.runGcButton)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.jLabel1).add(this.allocatedMemoryField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.jLabel2).add(this.freeMemoryField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.jLabel3).add(this.currentMaxMemoryField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.jLabel4).add(this.maxMemoryField, -2, -1, -2)).addPreferredGap(0).add((Component) this.runGcButton).addContainerGap(-1, 32767)));
    }
}
