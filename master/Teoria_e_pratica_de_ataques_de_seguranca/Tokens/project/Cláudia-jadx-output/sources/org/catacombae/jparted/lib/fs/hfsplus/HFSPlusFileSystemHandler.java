package org.catacombae.jparted.lib.fs.hfsplus;

import org.catacombae.hfsexplorer.fs.ImplHFSPlusFileSystemView;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFileSystemHandler;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfsplus/HFSPlusFileSystemHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfsplus/HFSPlusFileSystemHandler.class */
public class HFSPlusFileSystemHandler extends HFSCommonFileSystemHandler {
    public HFSPlusFileSystemHandler(DataLocator fsLocator, boolean useCaching, boolean iDoUnicodeFileNameComposition) {
        super(new ImplHFSPlusFileSystemView(fsLocator.createReadOnlyFile(), 0L, useCaching), iDoUnicodeFileNameComposition);
    }
}
