package org.catacombae.hfsexplorer.win32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/win32/WindowsLowLevelIO.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/win32/WindowsLowLevelIO.class */
public class WindowsLowLevelIO implements ReadableRandomAccessStream {
    protected byte[] fileHandle;
    protected final int sectorSize;
    protected long filePointer = 0;
    private static final Object loadLibSync = new Object();
    private static boolean libraryLoaded = false;
    public static boolean verboseLoadLibrary = false;

    protected static native byte[] openNative(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native void seek(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native int read(byte[] bArr, int i2, int i3, byte[] bArr2);

    protected static native void close(byte[] bArr);

    protected static native void ejectMedia(byte[] bArr);

    protected static native void loadMedia(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native long length(byte[] bArr);

    protected static native long getFilePointer(byte[] bArr);

    protected static native int getSectorSize(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/win32/WindowsLowLevelIO$ArchitectureIdentifier.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/win32/WindowsLowLevelIO$ArchitectureIdentifier.class */
    public enum ArchitectureIdentifier {
        I386("i386"),
        AMD64("amd64"),
        IA64("ia64"),
        POWERPC("ppc32"),
        POWERPC64("ppc64"),
        SPARC("sparc32"),
        SPARC64("sparc64"),
        MIPS("mips32"),
        MIPS64("mips64"),
        ALPHA("alpha"),
        UNKNOWN;
        
        private final String idString;

        ArchitectureIdentifier() {
            this.idString = null;
        }

        ArchitectureIdentifier(String idString) {
            this.idString = idString;
        }

        public String getArchitectureString() {
            return this.idString;
        }
    }

    private static ArchitectureIdentifier getJVMArchitecture() {
        String osArch = System.getProperty("os.arch");
        if (osArch.equalsIgnoreCase("x86") || osArch.equalsIgnoreCase("i386") || osArch.equalsIgnoreCase("i486") || osArch.equalsIgnoreCase("i586") || osArch.equalsIgnoreCase("i686")) {
            return ArchitectureIdentifier.I386;
        }
        if (osArch.equalsIgnoreCase("amd64") || osArch.equalsIgnoreCase("x86_64") || osArch.equalsIgnoreCase("x64")) {
            return ArchitectureIdentifier.AMD64;
        }
        if (osArch.equalsIgnoreCase("ia64") || osArch.equalsIgnoreCase("ia64n")) {
            return ArchitectureIdentifier.IA64;
        }
        return ArchitectureIdentifier.UNKNOWN;
    }

    public static boolean isSystemSupported() {
        ArchitectureIdentifier archId = getJVMArchitecture();
        return System.getProperty("os.name").toLowerCase().startsWith("windows") && (archId == ArchitectureIdentifier.I386 || archId == ArchitectureIdentifier.AMD64 || archId == ArchitectureIdentifier.IA64);
    }

    private static void loadLibrary() {
        ArchitectureIdentifier archId = getJVMArchitecture();
        if (archId == ArchitectureIdentifier.UNKNOWN) {
            System.err.println(System.getProperty("os.arch") + ": architecture unknown! Cannot locate appropriate native I/O library.");
            throw new RuntimeException("loadLibrary(): CPU architecture unknown!");
        }
        String libName = "llio_" + archId.getArchitectureString();
        try {
            if (verboseLoadLibrary) {
                System.err.println("Trying to load native library \"" + libName + "\"...");
            }
            System.loadLibrary(libName);
            if (verboseLoadLibrary) {
                System.err.println("Native library \"" + libName + "\" successfully loaded.");
            }
            libraryLoaded = true;
        } catch (UnsatisfiedLinkError e2) {
            System.err.println("ERROR: Native library \"" + libName + "\" failed to load!");
            System.err.println("java.library.path=\"" + System.getProperty("java.library.path") + "\"");
            throw e2;
        }
    }

    public WindowsLowLevelIO(String filename) {
        synchronized (loadLibSync) {
            if (!libraryLoaded) {
                loadLibrary();
            }
        }
        this.fileHandle = open(filename);
        int tmpSectorSize = getSectorSize(this.fileHandle);
        if (tmpSectorSize > 0) {
            if (0 != 0) {
                System.out.println("Sector size determined: " + tmpSectorSize);
            }
            this.sectorSize = tmpSectorSize;
            return;
        }
        if (0 != 0) {
            System.out.println("Could not determine sector size.");
        }
        this.sectorSize = 512;
    }

    @Override // org.catacombae.io.RandomAccess
    public void seek(long pos) {
        if (this.fileHandle != null) {
            seek((pos / this.sectorSize) * this.sectorSize, this.fileHandle);
            this.filePointer = pos;
            return;
        }
        throw new RuntimeException("File closed!");
    }

    @Override // org.catacombae.io.Readable
    public int read() {
        byte[] oneByte = new byte[1];
        if (read(oneByte) == 1) {
            return oneByte[0] & 255;
        }
        return -1;
    }

    @Override // org.catacombae.io.Readable
    public int read(byte[] data) {
        return read(data, 0, data.length);
    }

    @Override // org.catacombae.io.Readable
    public int read(byte[] data, int pos, int len) {
        if (this.fileHandle != null) {
            seek((this.filePointer / this.sectorSize) * this.sectorSize, this.fileHandle);
            long trueFp = getFilePointer(this.fileHandle);
            long fpDiff = this.filePointer - trueFp;
            if (fpDiff < 0) {
                throw new RuntimeException("Program error: fpDiff < 0 (" + fpDiff + " < 0)");
            }
            if (fpDiff > this.sectorSize) {
                throw new RuntimeException("Program error: fpDiff > sectorSize (" + fpDiff + " > " + this.sectorSize + ")");
            }
            int alignedLen = ((int) fpDiff) + len;
            byte[] tmp = new byte[((alignedLen / this.sectorSize) + (alignedLen % this.sectorSize != 0 ? 1 : 0)) * this.sectorSize];
            int bytesRead = read(tmp, 0, tmp.length, this.fileHandle);
            int bytesRead2 = bytesRead >= alignedLen ? len : bytesRead - ((int) fpDiff);
            this.filePointer += bytesRead2;
            System.arraycopy(tmp, (int) fpDiff, data, pos, bytesRead2);
            return bytesRead2;
        }
        throw new RuntimeException("File closed!");
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data) {
        readFully(data, 0, data.length);
    }

    @Override // org.catacombae.io.Readable
    public void readFully(byte[] data, int offset, int length) {
        if (this.fileHandle != null) {
            int i2 = 0;
            while (true) {
                int bytesRead = i2;
                if (bytesRead < length) {
                    int curBytesRead = read(data, offset + bytesRead, length - bytesRead);
                    if (curBytesRead > 0) {
                        i2 = bytesRead + curBytesRead;
                    } else {
                        throw new RuntimeException("Couldn't read the entire length.");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new RuntimeException("File closed!");
        }
    }

    @Override // org.catacombae.io.RandomAccess
    public long length() {
        if (this.fileHandle != null) {
            return length(this.fileHandle);
        }
        throw new RuntimeException("File closed!");
    }

    @Override // org.catacombae.io.RandomAccess
    public long getFilePointer() {
        if (this.fileHandle != null) {
            return this.filePointer;
        }
        throw new RuntimeException("File closed!");
    }

    @Override // org.catacombae.io.Stream
    public void close() {
        if (this.fileHandle != null) {
            close(this.fileHandle);
            this.fileHandle = null;
            return;
        }
        throw new RuntimeException("File closed!");
    }

    public void ejectMedia() {
        if (this.fileHandle != null) {
            ejectMedia(this.fileHandle);
            return;
        }
        throw new RuntimeException("File closed!");
    }

    public void loadMedia() {
        if (this.fileHandle != null) {
            loadMedia(this.fileHandle);
            return;
        }
        throw new RuntimeException("File closed!");
    }

    protected byte[] open(String filename) {
        return openNative(filename);
    }

    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        WindowsLowLevelIO wllio1 = new WindowsLowLevelIO(args[0]);
        try {
            if (args[1].equals("testread")) {
                System.out.println("Seeking to 1024...");
                wllio1.seek(1024L);
                byte[] buf = new byte[4096];
                System.out.println("Reading " + buf.length + " bytes from file: ");
                int bytesRead = wllio1.read(buf);
                System.out.println(" Bytes read: " + bytesRead);
                System.out.println(" As hex:    0x" + Util.byteArrayToHexString(buf));
                System.out.println(" As string: \"" + new String(buf, "US-ASCII") + "\"");
            } else if (args[1].equals("eject")) {
                System.out.print("Press any key to eject media...");
                stdin.readLine();
                wllio1.ejectMedia();
                System.out.print("Press any key to load media...");
                stdin.readLine();
                wllio1.loadMedia();
            } else {
                System.out.println("Nothing to do.");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        wllio1.close();
    }
}
