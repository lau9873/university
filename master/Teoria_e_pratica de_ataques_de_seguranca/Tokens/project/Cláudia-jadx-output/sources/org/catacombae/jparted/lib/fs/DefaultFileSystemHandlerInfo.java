package org.catacombae.jparted.lib.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/DefaultFileSystemHandlerInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/DefaultFileSystemHandlerInfo.class */
public class DefaultFileSystemHandlerInfo implements FileSystemHandlerInfo {
    private final String handlerName;
    private final String handlerVersion;
    private final long revision;
    private final String author;

    public DefaultFileSystemHandlerInfo(String iHandlerName, String iHandlerVersion, long iRevision, String iAuthor) {
        this.handlerName = iHandlerName;
        this.handlerVersion = iHandlerVersion;
        this.revision = iRevision;
        this.author = iAuthor;
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerInfo
    public String getHandlerName() {
        return this.handlerName;
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerInfo
    public String getHandlerVersion() {
        return this.handlerVersion;
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerInfo
    public long getRevision() {
        return this.revision;
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandlerInfo
    public String getAuthor() {
        return this.author;
    }
}
