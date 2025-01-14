package org.catacombae.hfsexplorer.deprecated;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.catacombae.hfsexplorer.gui.FolderInfoPanel;
import org.catacombae.hfsexplorer.gui.StructViewPanel;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolder;
import org.catacombae.jparted.lib.fs.FSFolder;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFSFolder;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/deprecated/FolderInfoWindow.class
 */
@Deprecated
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/deprecated/FolderInfoWindow.class */
public class FolderInfoWindow extends JFrame {
    private JTabbedPane tabs;
    private JScrollPane infoPanelScroller;

    public FolderInfoWindow(FSFolder fsFolder) {
        super("Info - " + fsFolder.getName());
        this.tabs = new JTabbedPane();
        this.infoPanelScroller = new JScrollPane(20, 31);
        if (fsFolder instanceof HFSCommonFSFolder) {
            CommonHFSCatalogFolder fld = ((HFSCommonFSFolder) fsFolder).getInternalCatalogFolder();
            if (fld instanceof CommonHFSCatalogFolder.HFSPlusImplementation) {
                FolderInfoPanel infoPanel = new FolderInfoPanel();
                infoPanel.setFields(((CommonHFSCatalogFolder.HFSPlusImplementation) fld).getUnderlying());
                this.infoPanelScroller.setViewportView(infoPanel);
            } else {
                StructViewPanel svp = new StructViewPanel("Folder", fld.getStructElements());
                this.infoPanelScroller.setViewportView(svp);
            }
            this.tabs.addTab("Detailed", this.infoPanelScroller);
            add(this.tabs, "Center");
            this.infoPanelScroller.getVerticalScrollBar().setUnitIncrement(10);
            setDefaultCloseOperation(2);
            pack();
            int width = getSize().width;
            int height = getSize().height;
            int adjustedHeight = width + (width / 2);
            if (adjustedHeight < height) {
                setSize(width, adjustedHeight);
            }
            setLocationRelativeTo(null);
            return;
        }
        throw new RuntimeException("FSFolder type " + fsFolder.getClass() + " not yet supported!");
    }
}
