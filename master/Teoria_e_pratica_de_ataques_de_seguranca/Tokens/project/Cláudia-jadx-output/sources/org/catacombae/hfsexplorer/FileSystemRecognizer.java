package org.catacombae.hfsexplorer;

import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemRecognizer.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemRecognizer.class */
public class FileSystemRecognizer {
    private static final short SIGNATURE_MFS = -11561;
    private static final short SIGNATURE_HFS = 16964;
    private static final short SIGNATURE_HFS_PLUS = 18475;
    private static final short SIGNATURE_HFSX = 18520;
    public static final FileSystemType[] supportedTypes = {FileSystemType.HFS, FileSystemType.HFS_PLUS, FileSystemType.HFS_WRAPPED_HFS_PLUS, FileSystemType.HFSX};
    private ReadableRandomAccessStream bitstream;
    private long offset;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/FileSystemRecognizer$FileSystemType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/FileSystemRecognizer$FileSystemType.class */
    public enum FileSystemType {
        MFS,
        HFS,
        HFS_PLUS,
        HFS_WRAPPED_HFS_PLUS,
        HFSX,
        UNKNOWN
    }

    public FileSystemRecognizer(ReadableRandomAccessStream bitstream, long offset) {
        this.bitstream = bitstream;
        this.offset = offset;
    }

    public FileSystemType detectFileSystem() {
        try {
            this.bitstream.seek(this.offset + 1024);
            byte[] signatureData = new byte[2];
            this.bitstream.readFully(signatureData);
            short signature = Util.readShortBE(signatureData);
            switch (signature) {
                case -11561:
                    return FileSystemType.MFS;
                case 16964:
                    try {
                        this.bitstream.seek(this.offset + 1024 + 124);
                        this.bitstream.readFully(signatureData);
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
            return FileSystemType.UNKNOWN;
        }
    }

    public boolean isTypeSupported(FileSystemType fst) {
        FileSystemType[] arr$ = supportedTypes;
        for (FileSystemType cur : arr$) {
            if (cur == fst) {
                return true;
            }
        }
        return false;
    }

    public FileSystemType[] getSupportedTypes() {
        FileSystemType[] res = new FileSystemType[supportedTypes.length];
        System.arraycopy(supportedTypes, 0, res, 0, supportedTypes.length);
        return res;
    }
}
