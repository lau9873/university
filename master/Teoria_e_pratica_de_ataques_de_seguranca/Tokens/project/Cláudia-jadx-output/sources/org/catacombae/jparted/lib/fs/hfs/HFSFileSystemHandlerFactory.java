package org.catacombae.jparted.lib.fs.hfs;

import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.fs.DefaultFileSystemHandlerInfo;
import org.catacombae.jparted.lib.fs.FileSystemHandler;
import org.catacombae.jparted.lib.fs.FileSystemHandlerFactory;
import org.catacombae.jparted.lib.fs.FileSystemHandlerInfo;
import org.catacombae.jparted.lib.fs.FileSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfs/HFSFileSystemHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfs/HFSFileSystemHandlerFactory.class */
public class HFSFileSystemHandlerFactory extends FileSystemHandlerFactory {
    private static final FileSystemRecognizer recognizer = new HFSFileSystemRecognizer();
    private static final FileSystemHandlerInfo handlerInfo = new DefaultFileSystemHandlerInfo("HFS file system handler", "1.0", 0, "Erik Larsson, Catacombae Software");
    private static final FileSystemHandlerFactory.CustomAttribute stringEncodingAttribute = createCustomAttribute(FileSystemHandlerFactory.AttributeType.STRING, "HFS_STRING_ENCODING", "The string encoding for filenames in the current HFS file system", "MacRoman");

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandler createHandler(DataLocator data) {
        boolean useCaching = this.createAttributes.getBooleanAttribute(FileSystemHandlerFactory.StandardAttribute.CACHING_ENABLED).booleanValue();
        String encoding = this.createAttributes.getStringAttribute(stringEncodingAttribute);
        return createHandlerInternal(data, useCaching, encoding);
    }

    protected FileSystemHandler createHandlerInternal(DataLocator data, boolean useCaching, String encoding) {
        return new HFSFileSystemHandler(data, useCaching, encoding);
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
        return new FileSystemHandlerFactory.CustomAttribute[]{stringEncodingAttribute};
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemHandlerFactory newInstance() {
        return new HFSFileSystemHandlerFactory();
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerFactory
    public FileSystemRecognizer getRecognizer() {
        return recognizer;
    }
}
