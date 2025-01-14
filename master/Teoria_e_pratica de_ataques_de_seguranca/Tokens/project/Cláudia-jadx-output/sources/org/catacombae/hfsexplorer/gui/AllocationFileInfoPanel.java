package org.catacombae.hfsexplorer.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import org.catacombae.csjc.structelements.ArrayBuilder;
import org.catacombae.hfsexplorer.ObjectContainer;
import org.catacombae.hfsexplorer.fs.BaseHFSAllocationFileView;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor;
import org.jdesktop.layout.GroupLayout;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/AllocationFileInfoPanel.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/AllocationFileInfoPanel.class */
public class AllocationFileInfoPanel extends JPanel {
    private final BaseHFSAllocationFileView afView;
    private final ObjectContainer<Boolean> stopCountBlocksProcess = new ObjectContainer<>(false);
    private JButton allocateButton;
    private JTextField allocateSizeField;
    private JLabel allocateSizeLabel;
    private JLabel allocateUnitLabel;
    private JTextField allocatedBlocksField;
    private JLabel allocatedBlocksLabel;
    private JLabel allocationHeader;
    private JTextField freeBlocksField;
    private JLabel freeBlocksLabel;
    private JLabel resultLabel;
    private JPanel resultPanel;
    private JScrollPane resultScroller;

    public AllocationFileInfoPanel(JFrame window, final BaseHFSAllocationFileView afView) {
        this.afView = afView;
        initComponents();
        window.addWindowListener(new WindowAdapter() { // from class: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel.1
            /* JADX WARN: Type inference failed for: r1v1, types: [A, java.lang.Boolean] */
            public void windowClosing(WindowEvent e2) {
                AllocationFileInfoPanel.this.stopCountBlocksProcess.o = true;
            }
        });
        Thread t = new Thread(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel.2
            @Override // java.lang.Runnable
            public void run() {
                final ObjectContainer<Long> freeBlocks = new ObjectContainer<>(-1L);
                final ObjectContainer<Long> usedBlocks = new ObjectContainer<>(-1L);
                afView.countBlocks(freeBlocks, usedBlocks, AllocationFileInfoPanel.this.stopCountBlocksProcess);
                if (!((Boolean) AllocationFileInfoPanel.this.stopCountBlocksProcess.o).booleanValue()) {
                    SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AllocationFileInfoPanel.this.allocatedBlocksField.setText(((Long) usedBlocks.o).toString());
                            AllocationFileInfoPanel.this.freeBlocksField.setText(((Long) freeBlocks.o).toString());
                        }
                    });
                } else {
                    System.err.println("AllocationFileInfoPanel thread aborted.");
                }
            }
        });
        t.start();
        this.allocateButton.addActionListener(new AnonymousClass3(afView));
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/gui/AllocationFileInfoPanel$3.class
     */
    /* renamed from: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel$3  reason: invalid class name */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/gui/AllocationFileInfoPanel$3.class */
    class AnonymousClass3 implements ActionListener {
        final /* synthetic */ BaseHFSAllocationFileView val$afView;

        AnonymousClass3(BaseHFSAllocationFileView baseHFSAllocationFileView) {
            this.val$afView = baseHFSAllocationFileView;
        }

        public void actionPerformed(ActionEvent e2) {
            AllocationFileInfoPanel.this.allocateButton.setEnabled(false);
            Thread t = new Thread(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel.3.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            long l = Long.parseLong(AllocationFileInfoPanel.this.allocateSizeField.getText());
                            CommonHFSExtentDescriptor[] descs = AnonymousClass3.this.val$afView.findFreeSpace(l);
                            if (descs != null) {
                                final ArrayBuilder ab = new ArrayBuilder("CommonHFSExtentDescriptor[" + descs.length + "]");
                                for (CommonHFSExtentDescriptor desc : descs) {
                                    System.err.println("Found descriptor: ");
                                    desc.print(System.err, "  ");
                                    ab.add(desc.getStructElements());
                                }
                                SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel.3.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AllocationFileInfoPanel.this.resultScroller.setViewportView(new StructViewPanel("Possible allocations", ab.getResult()));
                                    }
                                });
                            } else {
                                JOptionPane.showMessageDialog(AllocationFileInfoPanel.this, "Not enough space on volume!", "Info", 1);
                            }
                            SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel.3.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AllocationFileInfoPanel.this.allocateButton.setEnabled(true);
                                }
                            });
                        } catch (NumberFormatException e3) {
                            JOptionPane.showMessageDialog(AllocationFileInfoPanel.this, "Invalid long value.", "Error", 0);
                            SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel.3.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AllocationFileInfoPanel.this.allocateButton.setEnabled(true);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        SwingUtilities.invokeLater(new Runnable() { // from class: org.catacombae.hfsexplorer.gui.AllocationFileInfoPanel.3.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AllocationFileInfoPanel.this.allocateButton.setEnabled(true);
                            }
                        });
                        throw th;
                    }
                }
            });
            t.start();
        }
    }

    private void initComponents() {
        this.allocatedBlocksLabel = new JLabel();
        this.allocatedBlocksField = new JTextField();
        this.freeBlocksLabel = new JLabel();
        this.freeBlocksField = new JTextField();
        this.allocationHeader = new JLabel();
        this.allocateSizeField = new JTextField();
        this.allocateSizeLabel = new JLabel();
        this.allocateButton = new JButton();
        this.allocateUnitLabel = new JLabel();
        this.resultScroller = new JScrollPane();
        this.resultPanel = new JPanel();
        this.resultLabel = new JLabel();
        this.allocatedBlocksLabel.setText("Number of allocated blocks:");
        this.allocatedBlocksField.setEditable(false);
        this.allocatedBlocksField.setText("calculating...");
        this.allocatedBlocksField.setBorder((Border) null);
        this.allocatedBlocksField.setOpaque(false);
        this.freeBlocksLabel.setText("Number of free blocks:");
        this.freeBlocksField.setEditable(false);
        this.freeBlocksField.setText("calculating...");
        this.freeBlocksField.setBorder((Border) null);
        this.freeBlocksField.setOpaque(false);
        this.allocationHeader.setText("Attempt allocation of a region");
        this.allocateSizeField.setHorizontalAlignment(11);
        this.allocateSizeLabel.setText("Size:");
        this.allocateButton.setText("Allocate");
        this.allocateUnitLabel.setText("bytes");
        GroupLayout resultPanelLayout = new GroupLayout(this.resultPanel);
        this.resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(resultPanelLayout.createParallelGroup(1).add(0, 340, 32767));
        resultPanelLayout.setVerticalGroup(resultPanelLayout.createParallelGroup(1).add(0, 194, 32767));
        this.resultScroller.setViewportView(this.resultPanel);
        this.resultLabel.setText("Result");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2).add(1, this.resultScroller, -1, 344, 32767).add(1, layout.createSequentialGroup().add(layout.createParallelGroup(1).add((Component) this.allocationHeader).add(layout.createSequentialGroup().add((Component) this.allocateSizeLabel).addPreferredGap(0).add(this.allocateSizeField, -1, 173, 32767).addPreferredGap(0).add((Component) this.allocateUnitLabel))).addPreferredGap(0).add((Component) this.allocateButton)).add(1, layout.createSequentialGroup().add((Component) this.allocatedBlocksLabel).addPreferredGap(0).add(this.allocatedBlocksField, -1, 156, 32767)).add(1, layout.createSequentialGroup().add((Component) this.freeBlocksLabel).addPreferredGap(0).add(this.freeBlocksField, -1, 189, 32767)).add(1, (Component) this.resultLabel)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(3).add((Component) this.allocatedBlocksLabel).add(this.allocatedBlocksField, -2, -1, -2)).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.freeBlocksLabel).add(this.freeBlocksField, -2, -1, -2)).add(18, 18, 18).add((Component) this.allocationHeader).addPreferredGap(0).add(layout.createParallelGroup(3).add((Component) this.allocateSizeLabel).add(this.allocateSizeField, -2, -1, -2).add((Component) this.allocateButton).add((Component) this.allocateUnitLabel)).addPreferredGap(0).add((Component) this.resultLabel).addPreferredGap(0).add(this.resultScroller, -1, 198, 32767).addContainerGap()));
    }
}
