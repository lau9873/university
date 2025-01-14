package org.catacombae.jparted.lib.fs.hfsx;

import org.catacombae.hfsexplorer.fs.ImplHFSXFileSystemView;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFileSystemHandler;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfsx/HFSXFileSystemHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfsx/HFSXFileSystemHandler.class */
public class HFSXFileSystemHandler extends HFSCommonFileSystemHandler {
    public HFSXFileSystemHandler(DataLocator fsLocator, boolean useCaching, boolean doUnicodeFileNameComposition) {
        super(new ImplHFSXFileSystemView(fsLocator.createReadOnlyFile(), 0L, useCaching), doUnicodeFileNameComposition);
    }
}
