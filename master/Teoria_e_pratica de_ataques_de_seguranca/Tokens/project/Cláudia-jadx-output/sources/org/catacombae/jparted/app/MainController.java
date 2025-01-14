package org.catacombae.jparted.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.RandomAccessFileDataLocator;
import org.catacombae.jparted.lib.ps.Partition;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
import org.catacombae.jparted.lib.ps.PartitionSystemType;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainController.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/app/MainController.class */
public class MainController {
    LinkedList<PartitionSystemHandler> psHandlers = new LinkedList<>();
    private MainPanel mainPanel = new MainPanel();
    private MainWindow mainWindow = new MainWindow(this.mainPanel);

    public MainController() {
        this.mainWindow.setLoadFileItemListener(new LoadFileItemListener());
        this.mainWindow.setExitItemListener(new ExitItemListener());
        this.mainWindow.setAboutItemListener(new AboutItemListener());
        this.mainPanel.setPartitionSystemsBoxListener(new PartitionSystemsBoxListener());
        this.mainPanel.setSynchronizeButtonListener(new SynchronizeButtonListener());
        this.mainWindow.setDefaultCloseOperation(3);
    }

    public JPanel getPanel() {
        return this.mainPanel;
    }

    public void showMainWindow() {
        this.mainPanel.setPartitionSystemsBoxContents(new Vector<>());
        this.mainPanel.setPartitionSystemsBoxEnabled(false);
        this.mainPanel.setSynchronizeButtonEnabled(false);
        this.mainWindow.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitProgram() {
        this.mainWindow.setVisible(false);
        System.exit(0);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainController$LoadFileItemListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/app/MainController$LoadFileItemListener.class */
    private class LoadFileItemListener implements ActionListener {
        private LoadFileItemListener() {
        }

        public void actionPerformed(ActionEvent evt) {
            PartitionSystemHandlerFactory fac;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(false);
            fileChooser.setFileSelectionMode(0);
            if (fileChooser.showOpenDialog(MainController.this.mainPanel) == 0) {
                File selectedFile = fileChooser.getSelectedFile();
                RandomAccessFileDataLocator loc = new RandomAccessFileDataLocator(selectedFile);
                Vector<PartitionSystemHandler> detectedPartitionSystems = new Vector<>();
                Vector<String> detectedPartitionSystemDescriptions = new Vector<>();
                PartitionSystemType[] arr$ = PartitionSystemType.values();
                for (PartitionSystemType curType : arr$) {
                    if (curType.isTopLevelCapable() && (fac = curType.createDefaultHandlerFactory()) != null) {
                        PartitionSystemRecognizer recognizer = fac.getRecognizer();
                        ReadableRandomAccessStream stream = loc.createReadOnlyFile();
                        long streamLength = -1;
                        try {
                            streamLength = stream.length();
                        } catch (Exception e2) {
                        }
                        if (recognizer.detect(stream, 0L, streamLength)) {
                            PartitionSystemHandler handler = fac.createHandler(loc);
                            detectedPartitionSystems.add(fac.createHandler(loc));
                            detectedPartitionSystemDescriptions.add(fac.getInfo().getPartitionSystemName() + " (" + handler.getPartitionCount() + " partitions)");
                        }
                    }
                }
                if (detectedPartitionSystemDescriptions.size() > 0) {
                    MainController.this.mainPanel.setPartitionSystemsBoxEnabled(true);
                    MainController.this.mainPanel.setPartitionSystemsBoxContents(detectedPartitionSystemDescriptions);
                } else {
                    MainController.this.mainPanel.setPartitionSystemsBoxEnabled(false);
                }
                MainController.this.mainPanel.clearPartitionList();
                if (detectedPartitionSystems.size() <= 0) {
                    JOptionPane.showMessageDialog(MainController.this.mainPanel, "No partition systems found.", "Info", 1);
                    return;
                }
                PartitionSystemHandler handler2 = detectedPartitionSystems.get(0);
                Partition[] partitions = handler2.getPartitions();
                int i2 = 0;
                for (Partition p : partitions) {
                    int i3 = i2;
                    i2++;
                    MainController.this.mainPanel.addPartition("" + (i3 + 1), p.getType().toString(), "", "" + p.getStartOffset(), (p.getStartOffset() + p.getLength()) + "");
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainController$ExitItemListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/app/MainController$ExitItemListener.class */
    private class ExitItemListener implements ActionListener {
        private ExitItemListener() {
        }

        public void actionPerformed(ActionEvent evt) {
            MainController.this.exitProgram();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainController$AboutItemListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/app/MainController$AboutItemListener.class */
    private class AboutItemListener implements ActionListener {
        private AboutItemListener() {
        }

        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(MainController.this.mainPanel, "jParted 0.1", "About", 1);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainController$PartitionSystemsBoxListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/app/MainController$PartitionSystemsBoxListener.class */
    private class PartitionSystemsBoxListener implements ActionListener {
        private PartitionSystemsBoxListener() {
        }

        public void actionPerformed(ActionEvent evt) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/app/MainController$SynchronizeButtonListener.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/app/MainController$SynchronizeButtonListener.class */
    private class SynchronizeButtonListener implements ActionListener {
        private SynchronizeButtonListener() {
        }

        public void actionPerformed(ActionEvent evt) {
        }
    }
}
