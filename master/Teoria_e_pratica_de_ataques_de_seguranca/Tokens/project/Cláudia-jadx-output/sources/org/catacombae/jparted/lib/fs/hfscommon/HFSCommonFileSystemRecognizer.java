package org.catacombae.jparted.lib.fs.hfscommon;

import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.util.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFileSystemRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFileSystemRecognizer.class */
public class HFSCommonFileSystemRecognizer {
    private static final short SIGNATURE_MFS = -11561;
    private static final short SIGNATURE_HFS = 16964;
    private static final short SIGNATURE_HFS_PLUS = 18475;
    private static final short SIGNATURE_HFSX = 18520;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFileSystemRecognizer$FileSystemType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFileSystemRecognizer$FileSystemType.class */
    public enum FileSystemType {
        MFS,
        HFS,
        HFS_PLUS,
        HFS_WRAPPED_HFS_PLUS,
        HFSX,
        UNKNOWN
    }

    public static FileSystemType detectFileSystem(ReadableRandomAccessStream bitstream, long offset) {
        try {
            bitstream.seek(offset + 1024);
            byte[] signatureData = new byte[2];
            bitstream.readFully(signatureData);
            short signature = Util.readShortBE(signatureData);
            switch (signature) {
                case -11561:
                    return FileSystemType.MFS;
                case 16964:
                    try {
                        bitstream.seek(offset + 1024 + 124);
                        bitstream.readFully(signatureData);
                        short embeddedSignature = Util.readShortBE(signatureData);
                        if (embeddedSignature == 18475) {
                            return FileSystemType.HFS_WRAPPED_HFS_PLUS;
                        }
                        return FileSystemType.HFS;
                    } catch (Exception e2) {
                        return FileSystemType.HFS;
                    }
                case 18475:
                    return FileSystemType.HFS_PLUS;
                case 18520:
                    return FileSystemType.HFSX;
                default:
                    return FileSystemType.UNKNOWN;
            }
        } catch (Exception e3) {
            System.err.println("Exception while detecting file system:");
            e3.printStackTrace();
            return FileSystemType.UNKNOWN;
        }
    }
}
