package org.catacombae.jparted.lib.fs.hfs;

import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.fs.FileSystemRecognizer;
import org.catacombae.jparted.lib.fs.hfscommon.HFSCommonFileSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfs/HFSFileSystemRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfs/HFSFileSystemRecognizer.class */
public class HFSFileSystemRecognizer implements FileSystemRecognizer {
    @Override // org.catacombae.jparted.lib.fs.FileSystemRecognizer
    public boolean detect(ReadableRandomAccessStream fsStream, long offset, long length) {
        switch (HFSCommonFileSystemRecognizer.detectFileSystem(fsStream, offset)) {
            case HFS:
                return true;
            default:
                return false;
        }
    }
}
