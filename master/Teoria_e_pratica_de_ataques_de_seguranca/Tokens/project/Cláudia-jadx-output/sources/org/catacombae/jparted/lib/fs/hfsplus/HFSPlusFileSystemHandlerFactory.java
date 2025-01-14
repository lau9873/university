package org.catacombae.jparted.lib.fs.hfsplus;

import org.catacombae.hfsexplorer.types.hfs.ExtDescriptor;
import org.catacombae.hfsexplorer.types.hfs.HFSPlusWrapperMDB;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.SubDataLocator;
import org.catacombae.jparted.lib.fs.DefaultFileSystemHandlerInfo;
import org.catacombae.jparted.lib.fs.FileSystemHandler;
import org.catacombae.jparted.lib.fs.FileSystemHandlerFactory;
import org.catacombae.jparted.lib.fs.FileSystemHandlerInfo;
import org.catacombae.jparted.lib.fs.FileSystemRecognizer;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFileSystemRecognizer;
import org.catacombae.util.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfsplus/HFSPlusFileSystemHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfsplus/HFSPlusFileSystemHandlerFactory.class */
public class HFSPlusFileSystemHandlerFactory extends FileSystemHandlerFactory {
    private static final FileSystemRecognizer recognizer = new HFSPlusFileSystemRecognizer();
    private static final FileSystemHandlerInfo handlerInfo = new DefaultFileSystemHandlerInfo("HFS+ file system handler", "1.0", 0, "Erik Larsson, Catacombae Software");
    private static final FileSystemHandlerFactory.CustomAttribute compositionEnabledAttribute = createCustomAttribute(FileSystemHandlerFactory.AttributeType.BOOLEAN, "COMPOSE_UNICODE_FILENAMES", "Decides whether Unicode filenames should be composed or left in their original decomposed form.", true);

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandler createHandler(DataLocator data) {
        DataLocator dataToLoad;
        boolean useCaching = this.createAttributes.getBooleanAttribute(FileSystemHandlerFactory.StandardAttribute.CACHING_ENABLED).booleanValue();
        boolean composeFilename = this.createAttributes.getBooleanAttribute(compositionEnabledAttribute).booleanValue();
        ReadableRandomAccessStream recognizerStream = data.createReadOnlyFile();
        if (HFSCommonFileSystemRecognizer.detectFileSystem(recognizerStream, 0L) == HFSCommonFileSystemRecognizer.FileSystemType.HFS_WRAPPED_HFS_PLUS) {
            dataToLoad = hfsUnwrap(data);
        } else {
            dataToLoad = data;
        }
        recognizerStream.close();
        return createHandlerInternal(dataToLoad, useCaching, composeFilename);
    }

    protected FileSystemHandler createHandlerInternal(DataLocator data, boolean useCaching, boolean composeFilename) {
        return new HFSPlusFileSystemHandler(data, useCaching, composeFilename);
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandlerInfo getHandlerInfo() {
        return handlerInfo;
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandlerFactory.StandardAttribute[] getSupportedStandardAttributes() {
        setStandardAttributeDefaultValue(FileSystemHandlerFactory.StandardAttribute.CACHING_ENABLED, true);
        return new FileSystemHandlerFactory.StandardAttribute[]{FileSystemHandlerFactory.StandardAttribute.CACHING_ENABLED};
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandlerFactory.CustomAttribute[] getSupportedCustomAttributes() {
        return new FileSystemHandlerFactory.CustomAttribute[]{compositionEnabledAttribute};
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandlerFactory newInstance() {
        return new HFSPlusFileSystemHandlerFactory();
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemRecognizer getRecognizer() {
        return recognizer;
    }

    private static DataLocator hfsUnwrap(DataLocator data) {
        ReadableRandomAccessStream fsStream = data.createReadOnlyFile();
        byte[] mdbData = new byte[170];
        fsStream.seek(1024L);
        fsStream.read(mdbData);
        HFSPlusWrapperMDB mdb = new HFSPlusWrapperMDB(mdbData, 0);
        ExtDescriptor xd = mdb.getDrEmbedExtent();
        int hfsBlockSize = mdb.getDrAlBlkSiz();
        long fsOffset = (Util.unsign(mdb.getDrAlBlSt()) * 512) + (Util.unsign(xd.getXdrStABN()) * hfsBlockSize);
        long fsLength = Util.unsign(xd.getXdrNumABlks() * hfsBlockSize);
        return new SubDataLocator(data, fsOffset, fsLength);
    }
}
