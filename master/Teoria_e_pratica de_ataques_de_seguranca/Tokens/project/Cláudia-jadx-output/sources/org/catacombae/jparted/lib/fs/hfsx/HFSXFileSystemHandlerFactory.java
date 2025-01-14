package org.catacombae.jparted.lib.fs.hfsx;

import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.fs.DefaultFileSystemHandlerInfo;
import org.catacombae.jparted.lib.fs.FileSystemHandler;
import org.catacombae.jparted.lib.fs.FileSystemHandlerFactory;
import org.catacombae.jparted.lib.fs.FileSystemHandlerInfo;
import org.catacombae.jparted.lib.fs.FileSystemRecognizer;
import org.catacombae.jparted.lib.fs.hfsplus.HFSPlusFileSystemHandlerFactory;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfsx/HFSXFileSystemHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfsx/HFSXFileSystemHandlerFactory.class */
public class HFSXFileSystemHandlerFactory extends HFSPlusFileSystemHandlerFactory {
    private static final FileSystemRecognizer recognizer = new HFSXFileSystemRecognizer();
    private static final FileSystemHandlerInfo handlerInfo = new DefaultFileSystemHandlerInfo("HFSX file system handler", "1.0", 0, "Erik Larsson, Catacombae Software");

    @Override // org.catacombae.jparted.lib.fs.hfsplus.HFSPlusFileSystemHandlerFactory
    protected FileSystemHandler createHandlerInternal(DataLocator data, boolean useCaching, boolean composeFilename) {
        return new HFSXFileSystemHandler(data, useCaching, composeFilename);
    }

    @Override // org.catacombae.jparted.lib.fs.hfsplus.HFSPlusFileSystemHandlerFactory, org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandlerInfo getHandlerInfo() {
        return handlerInfo;
    }

    @Override // org.catacombae.jparted.lib.fs.hfsplus.HFSPlusFileSystemHandlerFactory, org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandlerFactory newInstance() {
        return new HFSXFileSystemHandlerFactory();
    }

    @Override // org.catacombae.jparted.lib.fs.hfsplus.HFSPlusFileSystemHandlerFactory, org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemRecognizer getRecognizer() {
        return recognizer;
    }
}
