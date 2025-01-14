package org.catacombae.hfsexplorer.types.applesingle;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.fs.AppleSingleBuilder;
import org.catacombae.util.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/applesingle/AppleSingleHeader.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/applesingle/AppleSingleHeader.class */
public class AppleSingleHeader {
    public static final int STRUCTSIZE = 26;
    private static final long MAX_UINT = 4294967295L;
    private static final int MAX_USHORT = 65535;
    private final byte[] magicNumber;
    private final byte[] versionNumber;
    private final byte[] homeFileSystem;
    private final byte[] numEntries;

    public AppleSingleHeader(byte[] data, int offset) {
        this.magicNumber = new byte[4];
        this.versionNumber = new byte[4];
        this.homeFileSystem = new byte[16];
        this.numEntries = new byte[2];
        System.arraycopy(data, offset + 0, this.magicNumber, 0, 4);
        System.arraycopy(data, offset + 4, this.versionNumber, 0, 4);
        System.arraycopy(data, offset + 8, this.homeFileSystem, 0, 16);
        System.arraycopy(data, offset + 24, this.numEntries, 0, 2);
    }

    public AppleSingleHeader(long magicNumber, long versionNumber, AppleSingleBuilder.FileSystem homeFileSystem, int numEntries) {
        this.magicNumber = new byte[4];
        this.versionNumber = new byte[4];
        this.homeFileSystem = new byte[16];
        this.numEntries = new byte[2];
        if (magicNumber < 0 || magicNumber > 4294967295L) {
            throw new IllegalArgumentException("Illegal value for magicNumber (" + magicNumber + ")");
        }
        if (versionNumber < 0 || versionNumber > 4294967295L) {
            throw new IllegalArgumentException("Illegal value for versionNumber (" + versionNumber + ")");
        }
        if (homeFileSystem == null) {
            throw new IllegalArgumentException("homeFileSystem == null");
        }
        if (numEntries < 0 || numEntries > 65535) {
            throw new IllegalArgumentException("Illegal value for numEntries (" + numEntries + ")");
        }
        System.arraycopy(Util.toByteArrayBE((int) magicNumber), 0, this.magicNumber, 0, 4);
        System.arraycopy(Util.toByteArrayBE((int) versionNumber), 0, this.versionNumber, 0, 4);
        System.arraycopy(homeFileSystem.getIdentifier(), 0, this.homeFileSystem, 0, 16);
        System.arraycopy(Util.toByteArrayBE((short) numEntries), 0, this.numEntries, 0, 2);
    }

    public static int length() {
        return 26;
    }

    public int getMagicNumber() {
        return Util.readIntBE(this.magicNumber);
    }

    public int getVersionNumber() {
        return Util.readIntBE(this.versionNumber);
    }

    public byte[] getHomeFileSystem() {
        return Util.readByteArrayBE(this.homeFileSystem);
    }

    public short getNumEntries() {
        return Util.readShortBE(this.numEntries);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " magicNumber: " + getMagicNumber());
        ps.println(prefix + " versionNumber: 0x" + Util.toHexStringBE(getVersionNumber()));
        ps.println(prefix + " homeFileSystem: \"" + Util.readString(getHomeFileSystem(), "MacRoman") + "\"");
        ps.println(prefix + " numEntries: " + ((int) getNumEntries()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "AppleSingleHeader:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[26];
        System.arraycopy(this.magicNumber, 0, result, 0, this.magicNumber.length);
        int offset = 0 + this.magicNumber.length;
        System.arraycopy(this.versionNumber, 0, result, offset, this.versionNumber.length);
        int offset2 = offset + this.versionNumber.length;
        System.arraycopy(this.homeFileSystem, 0, result, offset2, this.homeFileSystem.length);
        int offset3 = offset2 + this.homeFileSystem.length;
        System.arraycopy(this.numEntries, 0, result, offset3, this.numEntries.length);
        int length = offset3 + this.numEntries.length;
        return result;
    }
}
