package org.catacombae.hfsexplorer;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.catacombae.hfsexplorer.fs.ResourceForkReader;
import org.catacombae.hfsexplorer.gui.FSEntrySummaryPanel;
import org.catacombae.hfsexplorer.gui.FileInfoPanel;
import org.catacombae.hfsexplorer.gui.FolderInfoPanel;
import org.catacombae.hfsexplorer.gui.ResourceForkViewPanel;
import org.catacombae.hfsexplorer.gui.StructViewPanel;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFile;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder;
import org.catacombae.jparted.lib.fs.FSEntry;
import org.catacombae.jparted.lib.fs.FSFile;
import org.catacombae.jparted.lib.fs.FSFork;
import org.catacombae.jparted.lib.fs.FSForkType;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFSFile;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFSFolder;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFSLink;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileInfoWindow.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileInfoWindow.class */
public class FileInfoWindow extends JFrame {
    /* JADX WARN: Multi-variable type inference failed */
    public FileInfoWindow(FSEntry fsEntry, String[] parentPath) {
        super("Info - " + fsEntry.getName());
        CommonHFSCatalogFile hfsFile;
        Component component = null;
        Component component2 = null;
        JTabbedPane tabs = new JTabbedPane();
        try {
            FSEntrySummaryPanel summaryPanel = new FSEntrySummaryPanel(this, fsEntry, parentPath);
            component = new JScrollPane(summaryPanel, 20, 31);
            tabs.addTab("Summary", component);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            JPanel infoPanel = null;
            if ((fsEntry instanceof HFSCommonFSFile) || (fsEntry instanceof HFSCommonFSLink)) {
                if (fsEntry instanceof HFSCommonFSFile) {
                    hfsFile = ((HFSCommonFSFile) fsEntry).getInternalCatalogFile();
                } else if (fsEntry instanceof HFSCommonFSLink) {
                    hfsFile = ((HFSCommonFSLink) fsEntry).getInternalCatalogFileRecord().getData();
                } else {
                    throw new RuntimeException();
                }
                if (hfsFile instanceof CommonHFSCatalogFile.HFSPlusImplementation) {
                    FileInfoPanel fip = new FileInfoPanel();
                    fip.setFields(((CommonHFSCatalogFile.HFSPlusImplementation) hfsFile).getUnderlying());
                    infoPanel = fip;
                } else {
                    JPanel svp = new StructViewPanel("File", hfsFile.getStructElements());
                    infoPanel = svp;
                }
            } else if (fsEntry instanceof HFSCommonFSFolder) {
                CommonHFSCatalogFolder fld = ((HFSCommonFSFolder) fsEntry).getInternalCatalogFolder();
                if (fld instanceof CommonHFSCatalogFolder.HFSPlusImplementation) {
                    FolderInfoPanel fip2 = new FolderInfoPanel();
                    fip2.setFields(((CommonHFSCatalogFolder.HFSPlusImplementation) fld).getUnderlying());
                    infoPanel = fip2;
                } else {
                    JPanel svp2 = new StructViewPanel("Folder", fld.getStructElements());
                    infoPanel = svp2;
                }
            }
            if (infoPanel != null) {
                component2 = new JScrollPane(infoPanel, 20, 31);
                tabs.addTab("Detailed", component2);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            if (fsEntry instanceof FSFile) {
                FSFile fsFile = (FSFile) fsEntry;
                FSFork resourceFork = fsFile.getForkByType(FSForkType.MACOS_RESOURCE);
                if (resourceFork != null && resourceFork.getLength() > 0) {
                    ResourceForkReader resffReader = new ResourceForkReader(resourceFork.getReadableRandomAccessStream());
                    ResourceForkViewPanel resffPanel = new ResourceForkViewPanel(resffReader);
                    tabs.addTab("Resource fork", resffPanel);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            GUIUtil.displayExceptionDialog(e4, 20, this, "Exception while creating ResourceForkViewPanel.");
        }
        add(tabs, "Center");
        if (component != null) {
            component.getVerticalScrollBar().setUnitIncrement(10);
        }
        if (component2 != null) {
            component2.getVerticalScrollBar().setUnitIncrement(10);
        }
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
