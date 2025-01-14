package org.catacombae.hfsexplorer.types.hfs;

import java.io.PrintStream;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfs/BootBlkHdr.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfs/BootBlkHdr.class */
public class BootBlkHdr {
    public static final int STRUCTSIZE = 148;
    private final byte[] bbID = new byte[2];
    private final byte[] bbEntry = new byte[4];
    private final byte[] bbVersion = new byte[2];
    private final byte[] bbPageFlags = new byte[2];
    private final byte[] bbSysName = new byte[16];
    private final byte[] bbShellName = new byte[16];
    private final byte[] bbDbg1Name = new byte[16];
    private final byte[] bbDbg2Name = new byte[16];
    private final byte[] bbScreenName = new byte[16];
    private final byte[] bbHelloName = new byte[16];
    private final byte[] bbScrapName = new byte[16];
    private final byte[] bbCntFCBs = new byte[2];
    private final byte[] bbCntEvts = new byte[2];
    private final byte[] bb128KSHeap = new byte[4];
    private final byte[] bb256KSHeap = new byte[4];
    private final byte[] bbSysHeapSize = new byte[4];
    private final byte[] filler = new byte[2];
    private final byte[] bbSysHeapExtra = new byte[4];
    private final byte[] bbSysHeapFract = new byte[4];

    public BootBlkHdr(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.bbID, 0, 2);
        System.arraycopy(data, offset + 2, this.bbEntry, 0, 4);
        System.arraycopy(data, offset + 6, this.bbVersion, 0, 2);
        System.arraycopy(data, offset + 8, this.bbPageFlags, 0, 2);
        System.arraycopy(data, offset + 10, this.bbSysName, 0, 16);
        System.arraycopy(data, offset + 26, this.bbShellName, 0, 16);
        System.arraycopy(data, offset + 42, this.bbDbg1Name, 0, 16);
        System.arraycopy(data, offset + 58, this.bbDbg2Name, 0, 16);
        System.arraycopy(data, offset + 74, this.bbScreenName, 0, 16);
        System.arraycopy(data, offset + 90, this.bbHelloName, 0, 16);
        System.arraycopy(data, offset + 106, this.bbScrapName, 0, 16);
        System.arraycopy(data, offset + 122, this.bbCntFCBs, 0, 2);
        System.arraycopy(data, offset + 124, this.bbCntEvts, 0, 2);
        System.arraycopy(data, offset + 126, this.bb128KSHeap, 0, 4);
        System.arraycopy(data, offset + 130, this.bb256KSHeap, 0, 4);
        System.arraycopy(data, offset + 134, this.bbSysHeapSize, 0, 4);
        System.arraycopy(data, offset + 138, this.filler, 0, 2);
        System.arraycopy(data, offset + 140, this.bbSysHeapExtra, 0, 4);
        System.arraycopy(data, offset + 144, this.bbSysHeapFract, 0, 4);
    }

    public static int length() {
        return 148;
    }

    public short getBbID() {
        return Util.readShortBE(this.bbID);
    }

    public int getBbEntry() {
        return Util.readIntBE(this.bbEntry);
    }

    public short getBbVersion() {
        return Util.readShortBE(this.bbVersion);
    }

    public short getBbPageFlags() {
        return Util.readShortBE(this.bbPageFlags);
    }

    public byte[] getBbSysName() {
        return Util.readByteArrayBE(this.bbSysName);
    }

    public byte[] getBbShellName() {
        return Util.readByteArrayBE(this.bbShellName);
    }

    public byte[] getBbDbg1Name() {
        return Util.readByteArrayBE(this.bbDbg1Name);
    }

    public byte[] getBbDbg2Name() {
        return Util.readByteArrayBE(this.bbDbg2Name);
    }

    public byte[] getBbScreenName() {
        return Util.readByteArrayBE(this.bbScreenName);
    }

    public byte[] getBbHelloName() {
        return Util.readByteArrayBE(this.bbHelloName);
    }

    public byte[] getBbScrapName() {
        return Util.readByteArrayBE(this.bbScrapName);
    }

    public short getBbCntFCBs() {
        return Util.readShortBE(this.bbCntFCBs);
    }

    public short getBbCntEvts() {
        return Util.readShortBE(this.bbCntEvts);
    }

    public int getBb128KSHeap() {
        return Util.readIntBE(this.bb128KSHeap);
    }

    public int getBb256KSHeap() {
        return Util.readIntBE(this.bb256KSHeap);
    }

    public int getBbSysHeapSize() {
        return Util.readIntBE(this.bbSysHeapSize);
    }

    public short getFiller() {
        return Util.readShortBE(this.filler);
    }

    public int getBbSysHeapExtra() {
        return Util.readIntBE(this.bbSysHeapExtra);
    }

    public int getBbSysHeapFract() {
        return Util.readIntBE(this.bbSysHeapFract);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " bbID: " + ((int) getBbID()));
        ps.println(prefix + " bbEntry: " + getBbEntry());
        ps.println(prefix + " bbVersion: " + ((int) getBbVersion()));
        ps.println(prefix + " bbPageFlags: " + ((int) getBbPageFlags()));
        ps.println(prefix + " bbSysName: " + getBbSysName());
        ps.println(prefix + " bbShellName: " + getBbShellName());
        ps.println(prefix + " bbDbg1Name: " + getBbDbg1Name());
        ps.println(prefix + " bbDbg2Name: " + getBbDbg2Name());
        ps.println(prefix + " bbScreenName: " + getBbScreenName());
        ps.println(prefix + " bbHelloName: " + getBbHelloName());
        ps.println(prefix + " bbScrapName: " + getBbScrapName());
        ps.println(prefix + " bbCntFCBs: " + ((int) getBbCntFCBs()));
        ps.println(prefix + " bbCntEvts: " + ((int) getBbCntEvts()));
        ps.println(prefix + " bb128KSHeap: " + getBb128KSHeap());
        ps.println(prefix + " bb256KSHeap: " + getBb256KSHeap());
        ps.println(prefix + " bbSysHeapSize: " + getBbSysHeapSize());
        ps.println(prefix + " filler: " + ((int) getFiller()));
        ps.println(prefix + " bbSysHeapExtra: " + getBbSysHeapExtra());
        ps.println(prefix + " bbSysHeapFract: " + getBbSysHeapFract());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "BootBlkHdr:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[148];
        System.arraycopy(this.bbID, 0, result, 0, this.bbID.length);
        int offset = 0 + this.bbID.length;
        System.arraycopy(this.bbEntry, 0, result, offset, this.bbEntry.length);
        int offset2 = offset + this.bbEntry.length;
        System.arraycopy(this.bbVersion, 0, result, offset2, this.bbVersion.length);
        int offset3 = offset2 + this.bbVersion.length;
        System.arraycopy(this.bbPageFlags, 0, result, offset3, this.bbPageFlags.length);
        int offset4 = offset3 + this.bbPageFlags.length;
        System.arraycopy(this.bbSysName, 0, result, offset4, this.bbSysName.length);
        int offset5 = offset4 + this.bbSysName.length;
        System.arraycopy(this.bbShellName, 0, result, offset5, this.bbShellName.length);
        int offset6 = offset5 + this.bbShellName.length;
        System.arraycopy(this.bbDbg1Name, 0, result, offset6, this.bbDbg1Name.length);
        int offset7 = offset6 + this.bbDbg1Name.length;
        System.arraycopy(this.bbDbg2Name, 0, result, offset7, this.bbDbg2Name.length);
        int offset8 = offset7 + this.bbDbg2Name.length;
        System.arraycopy(this.bbScreenName, 0, result, offset8, this.bbScreenName.length);
        int offset9 = offset8 + this.bbScreenName.length;
        System.arraycopy(this.bbHelloName, 0, result, offset9, this.bbHelloName.length);
        int offset10 = offset9 + this.bbHelloName.length;
        System.arraycopy(this.bbScrapName, 0, result, offset10, this.bbScrapName.length);
        int offset11 = offset10 + this.bbScrapName.length;
        System.arraycopy(this.bbCntFCBs, 0, result, offset11, this.bbCntFCBs.length);
        int offset12 = offset11 + this.bbCntFCBs.length;
        System.arraycopy(this.bbCntEvts, 0, result, offset12, this.bbCntEvts.length);
        int offset13 = offset12 + this.bbCntEvts.length;
        System.arraycopy(this.bb128KSHeap, 0, result, offset13, this.bb128KSHeap.length);
        int offset14 = offset13 + this.bb128KSHeap.length;
        System.arraycopy(this.bb256KSHeap, 0, result, offset14, this.bb256KSHeap.length);
        int offset15 = offset14 + this.bb256KSHeap.length;
        System.arraycopy(this.bbSysHeapSize, 0, result, offset15, this.bbSysHeapSize.length);
        int offset16 = offset15 + this.bbSysHeapSize.length;
        System.arraycopy(this.filler, 0, result, offset16, this.filler.length);
        int offset17 = offset16 + this.filler.length;
        System.arraycopy(this.bbSysHeapExtra, 0, result, offset17, this.bbSysHeapExtra.length);
        int offset18 = offset17 + this.bbSysHeapExtra.length;
        System.arraycopy(this.bbSysHeapFract, 0, result, offset18, this.bbSysHeapFract.length);
        int length = offset18 + this.bbSysHeapFract.length;
        return result;
    }
}
