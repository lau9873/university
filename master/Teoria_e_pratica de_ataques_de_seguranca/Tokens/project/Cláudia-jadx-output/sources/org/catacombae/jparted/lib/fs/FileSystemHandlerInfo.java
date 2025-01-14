package org.catacombae.jparted.lib.fs;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerInfo.class */
public interface FileSystemHandlerInfo {
    String getHandlerName();

    String getHandlerVersion();

    long getRevision();

    String getAuthor();
}
