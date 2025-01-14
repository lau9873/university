package org.catacombae.hfsexplorer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView;
import org.catacombae.hfsexplorer.gui.CatalogInfoPanel;
import org.catacombae.hfsexplorer.gui.ExtentsInfoPanel;
import org.catacombae.hfsexplorer.gui.HFSPlusVolumeInfoPanel;
import org.catacombae.hfsexplorer.gui.JournalInfoPanel;
import org.catacombae.hfsexplorer.gui.StructViewPanel;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSVolumeHeader;
import org.catacombae.hfsexplorer.types.hfsplus.JournalInfoBlock;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/VolumeInfoWindow.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/VolumeInfoWindow.class */
public class VolumeInfoWindow extends JFrame {
    public VolumeInfoWindow(BaseHFSFileSystemView fsView) {
        super("File system info");
        JPanel volumeInfoPanel;
        JTabbedPane tabs = new JTabbedPane();
        try {
            CommonHFSVolumeHeader volHeader = fsView.getVolumeHeader();
            if (volHeader instanceof CommonHFSVolumeHeader.HFSPlusImplementation) {
                volumeInfoPanel = new HFSPlusVolumeInfoPanel(((CommonHFSVolumeHeader.HFSPlusImplementation) volHeader).getUnderlying());
            } else {
                volumeInfoPanel = new StructViewPanel("Volume header", volHeader.getStructElements());
            }
            JScrollPane volumeInfoPanelScroller = new JScrollPane(volumeInfoPanel, 20, 31);
            tabs.addTab("Volume header", volumeInfoPanelScroller);
            volumeInfoPanelScroller.getVerticalScrollBar().setUnitIncrement(10);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            CatalogInfoPanel catalogInfoPanel = new CatalogInfoPanel(fsView);
            JScrollPane catalogInfoPanelScroller = new JScrollPane(catalogInfoPanel, 20, 31);
            tabs.addTab("Catalog file", catalogInfoPanelScroller);
            catalogInfoPanelScroller.getVerticalScrollBar().setUnitIncrement(10);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            ExtentsInfoPanel extentsInfoPanel = new ExtentsInfoPanel(fsView);
            JScrollPane scroller = new JScrollPane(extentsInfoPanel, 20, 31);
            tabs.addTab("Extents overflow file", scroller);
            scroller.getVerticalScrollBar().setUnitIncrement(10);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            JournalInfoBlock jib = fsView.getJournalInfoBlock();
            if (jib != null) {
                JournalInfoPanel journalInfoPanel = new JournalInfoPanel(jib);
                JScrollPane journalInfoPanelScroller = new JScrollPane(journalInfoPanel, 20, 31);
                tabs.addTab("Journal", journalInfoPanelScroller);
                journalInfoPanelScroller.getVerticalScrollBar().setUnitIncrement(10);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        add(tabs, "Center");
        setDefaultCloseOperation(2);
        pack();
        int width = getSize().width;
        int height = getSize().height;
        int adjustedHeight = width + (width / 2);
        if (adjustedHeight < height) {
            setSize(width, adjustedHeight);
        }
        setLocationRelativeTo(null);
    }
}
