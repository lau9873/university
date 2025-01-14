package org.catacombae.jparted.lib.fs.hfs;

import org.catacombae.hfsexplorer.fs.ImplHFSFileSystemView;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFileSystemHandler;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfs/HFSFileSystemHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfs/HFSFileSystemHandler.class */
public class HFSFileSystemHandler extends HFSCommonFileSystemHandler {
    public HFSFileSystemHandler(DataLocator fsLocator, boolean useCaching, String encodingName) {
        super(new ImplHFSFileSystemView(fsLocator.createReadOnlyFile(), 0L, useCaching, encodingName), false);
    }
}
