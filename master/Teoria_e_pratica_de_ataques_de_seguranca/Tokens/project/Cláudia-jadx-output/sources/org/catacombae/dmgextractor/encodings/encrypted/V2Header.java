package org.catacombae.dmgextractor.encodings.encrypted;

import com.j256.ormlite.android.AndroidLog;
import java.io.PrintStream;
import org.catacombae.dmgextractor.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/V2Header.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/V2Header.class */
public class V2Header {
    public static final int STRUCTSIZE = 248;
    private final byte[] signature = new byte[8];
    private final byte[] possibleHeaderVersion = new byte[4];
    private final byte[] laban = new byte[4];
    private final byte[] edward = new byte[4];
    private final byte[] palle = new byte[4];
    private final byte[] lisa = new byte[4];
    private final byte[] unknownInt28 = new byte[4];
    private final byte[] unknownInt32 = new byte[4];
    private final byte[] unknown1 = new byte[16];
    private final byte[] blockSize = new byte[4];
    private final byte[] encryptedDataLength = new byte[8];
    private final byte[] offsetToDataStart = new byte[8];
    private final byte[] unknownInt72 = new byte[4];
    private final byte[] unknownInt76 = new byte[4];
    private final byte[] possiblePointerToKdfAlgorithm = new byte[8];
    private final byte[] unknownLong88 = new byte[8];
    private final byte[] kdfAlgorithm = new byte[4];
    private final byte[] kdfPrngAlgorithm = new byte[4];
    private final byte[] kdfIterationCount = new byte[4];
    private final byte[] kdfSaltLen = new byte[4];
    private final byte[] kdfSalt = new byte[32];
    private final byte[] blobEncIvSize = new byte[4];
    private final byte[] blobEncIv = new byte[32];
    private final byte[] blobEncKeyBits = new byte[4];
    private final byte[] blobEncAlgorithm = new byte[4];
    private final byte[] blobEncPadding = new byte[4];
    private final byte[] blobEncMode = new byte[4];
    private final byte[] encryptedKeyblobSize = new byte[4];
    private final byte[] encryptedKeyblob = new byte[48];

    public V2Header(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.signature, 0, 8);
        System.arraycopy(data, offset + 8, this.possibleHeaderVersion, 0, 4);
        System.arraycopy(data, offset + 12, this.laban, 0, 4);
        System.arraycopy(data, offset + 16, this.edward, 0, 4);
        System.arraycopy(data, offset + 20, this.palle, 0, 4);
        System.arraycopy(data, offset + 24, this.lisa, 0, 4);
        System.arraycopy(data, offset + 28, this.unknownInt28, 0, 4);
        System.arraycopy(data, offset + 32, this.unknownInt32, 0, 4);
        System.arraycopy(data, offset + 36, this.unknown1, 0, 16);
        System.arraycopy(data, offset + 52, this.blockSize, 0, 4);
        System.arraycopy(data, offset + 56, this.encryptedDataLength, 0, 8);
        System.arraycopy(data, offset + 64, this.offsetToDataStart, 0, 8);
        System.arraycopy(data, offset + 72, this.unknownInt72, 0, 4);
        System.arraycopy(data, offset + 76, this.unknownInt76, 0, 4);
        System.arraycopy(data, offset + 80, this.possiblePointerToKdfAlgorithm, 0, 8);
        System.arraycopy(data, offset + 88, this.unknownLong88, 0, 8);
        System.arraycopy(data, offset + 96, this.kdfAlgorithm, 0, 4);
        System.arraycopy(data, offset + 100, this.kdfPrngAlgorithm, 0, 4);
        System.arraycopy(data, offset + 104, this.kdfIterationCount, 0, 4);
        System.arraycopy(data, offset + 108, this.kdfSaltLen, 0, 4);
        System.arraycopy(data, offset + 112, this.kdfSalt, 0, 32);
        System.arraycopy(data, offset + 144, this.blobEncIvSize, 0, 4);
        System.arraycopy(data, offset + 148, this.blobEncIv, 0, 32);
        System.arraycopy(data, offset + 180, this.blobEncKeyBits, 0, 4);
        System.arraycopy(data, offset + 184, this.blobEncAlgorithm, 0, 4);
        System.arraycopy(data, offset + 188, this.blobEncPadding, 0, 4);
        System.arraycopy(data, offset + 192, this.blobEncMode, 0, 4);
        System.arraycopy(data, offset + 196, this.encryptedKeyblobSize, 0, 4);
        System.arraycopy(data, offset + AndroidLog.REFRESH_LEVEL_CACHE_EVERY, this.encryptedKeyblob, 0, 48);
    }

    public static int length() {
        return 248;
    }

    public byte[] getSignature() {
        return Util.readByteArrayBE(this.signature);
    }

    public int getPossibleHeaderVersion() {
        return Util.readIntBE(this.possibleHeaderVersion);
    }

    public int getLaban() {
        return Util.readIntBE(this.laban);
    }

    public int getEdward() {
        return Util.readIntBE(this.edward);
    }

    public int getPalle() {
        return Util.readIntBE(this.palle);
    }

    public int getLisa() {
        return Util.readIntBE(this.lisa);
    }

    public int getUnknownInt28() {
        return Util.readIntBE(this.unknownInt28);
    }

    public int getUnknownInt32() {
        return Util.readIntBE(this.unknownInt32);
    }

    public byte[] getUnknown1() {
        return Util.readByteArrayBE(this.unknown1);
    }

    public int getBlockSize() {
        return Util.readIntBE(this.blockSize);
    }

    public long getEncryptedDataLength() {
        return Util.readLongBE(this.encryptedDataLength);
    }

    public long getOffsetToDataStart() {
        return Util.readLongBE(this.offsetToDataStart);
    }

    public int getUnknownInt72() {
        return Util.readIntBE(this.unknownInt72);
    }

    public int getUnknownInt76() {
        return Util.readIntBE(this.unknownInt76);
    }

    public long getPossiblePointerToKdfAlgorithm() {
        return Util.readLongBE(this.possiblePointerToKdfAlgorithm);
    }

    public long getUnknownLong88() {
        return Util.readLongBE(this.unknownLong88);
    }

    public int getKdfAlgorithm() {
        return Util.readIntBE(this.kdfAlgorithm);
    }

    public int getKdfPrngAlgorithm() {
        return Util.readIntBE(this.kdfPrngAlgorithm);
    }

    public int getKdfIterationCount() {
        return Util.readIntBE(this.kdfIterationCount);
    }

    public int getKdfSaltLen() {
        return Util.readIntBE(this.kdfSaltLen);
    }

    public byte[] getKdfSalt() {
        return Util.readByteArrayBE(this.kdfSalt);
    }

    public int getBlobEncIvSize() {
        return Util.readIntBE(this.blobEncIvSize);
    }

    public byte[] getBlobEncIv() {
        return Util.readByteArrayBE(this.blobEncIv);
    }

    public int getBlobEncKeyBits() {
        return Util.readIntBE(this.blobEncKeyBits);
    }

    public int getBlobEncAlgorithm() {
        return Util.readIntBE(this.blobEncAlgorithm);
    }

    public int getBlobEncPadding() {
        return Util.readIntBE(this.blobEncPadding);
    }

    public int getBlobEncMode() {
        return Util.readIntBE(this.blobEncMode);
    }

    public int getEncryptedKeyblobSize() {
        return Util.readIntBE(this.encryptedKeyblobSize);
    }

    public byte[] getEncryptedKeyblob() {
        return Util.readByteArrayBE(this.encryptedKeyblob);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " signature: \"" + Util.toASCIIString(getSignature()) + "\"");
        ps.println(prefix + " possibleHeaderVersion: " + getPossibleHeaderVersion());
        ps.println(prefix + " laban: " + getLaban());
        ps.println(prefix + " edward: " + getEdward());
        ps.println(prefix + " palle: " + getPalle());
        ps.println(prefix + " lisa: " + getLisa());
        ps.println(prefix + " unknownInt28: " + getUnknownInt28());
        ps.println(prefix + " unknownInt32: " + getUnknownInt32());
        ps.println(prefix + " unknown1: " + getUnknown1());
        ps.println(prefix + " blockSize: " + getBlockSize());
        ps.println(prefix + " encryptedDataLength: " + getEncryptedDataLength());
        ps.println(prefix + " offsetToDataStart: " + getOffsetToDataStart());
        ps.println(prefix + " unknownInt72: " + getUnknownInt72());
        ps.println(prefix + " unknownInt76: " + getUnknownInt76());
        ps.println(prefix + " possiblePointerToKdfAlgorithm: " + getPossiblePointerToKdfAlgorithm());
        ps.println(prefix + " unknownLong88: " + getUnknownLong88());
        ps.println(prefix + " kdfAlgorithm: " + getKdfAlgorithm());
        ps.println(prefix + " kdfPrngAlgorithm: " + getKdfPrngAlgorithm());
        ps.println(prefix + " kdfIterationCount: " + getKdfIterationCount());
        ps.println(prefix + " kdfSaltLen: " + getKdfSaltLen());
        ps.println(prefix + " kdfSalt: 0x" + Util.byteArrayToHexString(getKdfSalt()));
        ps.println(prefix + " blobEncIvSize: " + getBlobEncIvSize());
        ps.println(prefix + " blobEncIv: 0x" + Util.byteArrayToHexString(getBlobEncIv()));
        ps.println(prefix + " blobEncKeyBits: " + getBlobEncKeyBits());
        ps.println(prefix + " blobEncAlgorithm: " + getBlobEncAlgorithm());
        ps.println(prefix + " blobEncPadding: " + getBlobEncPadding());
        ps.println(prefix + " blobEncMode: " + getBlobEncMode());
        ps.println(prefix + " encryptedKeyblobSize: " + getEncryptedKeyblobSize());
        ps.println(prefix + " encryptedKeyblob: 0x" + Util.byteArrayToHexString(getEncryptedKeyblob()));
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "V2Header:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.signature, 0, result, 0, this.signature.length);
        int offset = 0 + this.signature.length;
        System.arraycopy(this.possibleHeaderVersion, 0, result, offset, this.possibleHeaderVersion.length);
        int offset2 = offset + this.possibleHeaderVersion.length;
        System.arraycopy(this.laban, 0, result, offset2, this.laban.length);
        int offset3 = offset2 + this.laban.length;
        System.arraycopy(this.edward, 0, result, offset3, this.edward.length);
        int offset4 = offset3 + this.edward.length;
        System.arraycopy(this.palle, 0, result, offset4, this.palle.length);
        int offset5 = offset4 + this.palle.length;
        System.arraycopy(this.lisa, 0, result, offset5, this.lisa.length);
        int offset6 = offset5 + this.lisa.length;
        System.arraycopy(this.unknownInt28, 0, result, offset6, this.unknownInt28.length);
        int offset7 = offset6 + this.unknownInt28.length;
        System.arraycopy(this.unknownInt32, 0, result, offset7, this.unknownInt32.length);
        int offset8 = offset7 + this.unknownInt32.length;
        System.arraycopy(this.unknown1, 0, result, offset8, this.unknown1.length);
        int offset9 = offset8 + this.unknown1.length;
        System.arraycopy(this.blockSize, 0, result, offset9, this.blockSize.length);
        int offset10 = offset9 + this.blockSize.length;
        System.arraycopy(this.encryptedDataLength, 0, result, offset10, this.encryptedDataLength.length);
        int offset11 = offset10 + this.encryptedDataLength.length;
        System.arraycopy(this.offsetToDataStart, 0, result, offset11, this.offsetToDataStart.length);
        int offset12 = offset11 + this.offsetToDataStart.length;
        System.arraycopy(this.unknownInt72, 0, result, offset12, this.unknownInt72.length);
        int offset13 = offset12 + this.unknownInt72.length;
        System.arraycopy(this.unknownInt76, 0, result, offset13, this.unknownInt76.length);
        int offset14 = offset13 + this.unknownInt76.length;
        System.arraycopy(this.possiblePointerToKdfAlgorithm, 0, result, offset14, this.possiblePointerToKdfAlgorithm.length);
        int offset15 = offset14 + this.possiblePointerToKdfAlgorithm.length;
        System.arraycopy(this.unknownLong88, 0, result, offset15, this.unknownLong88.length);
        int offset16 = offset15 + this.unknownLong88.length;
        System.arraycopy(this.kdfAlgorithm, 0, result, offset16, this.kdfAlgorithm.length);
        int offset17 = offset16 + this.kdfAlgorithm.length;
        System.arraycopy(this.kdfPrngAlgorithm, 0, result, offset17, this.kdfPrngAlgorithm.length);
        int offset18 = offset17 + this.kdfPrngAlgorithm.length;
        System.arraycopy(this.kdfIterationCount, 0, result, offset18, this.kdfIterationCount.length);
        int offset19 = offset18 + this.kdfIterationCount.length;
        System.arraycopy(this.kdfSaltLen, 0, result, offset19, this.kdfSaltLen.length);
        int offset20 = offset19 + this.kdfSaltLen.length;
        System.arraycopy(this.kdfSalt, 0, result, offset20, this.kdfSalt.length);
        int offset21 = offset20 + this.kdfSalt.length;
        System.arraycopy(this.blobEncIvSize, 0, result, offset21, this.blobEncIvSize.length);
        int offset22 = offset21 + this.blobEncIvSize.length;
        System.arraycopy(this.blobEncIv, 0, result, offset22, this.blobEncIv.length);
        int offset23 = offset22 + this.blobEncIv.length;
        System.arraycopy(this.blobEncKeyBits, 0, result, offset23, this.blobEncKeyBits.length);
        int offset24 = offset23 + this.blobEncKeyBits.length;
        System.arraycopy(this.blobEncAlgorithm, 0, result, offset24, this.blobEncAlgorithm.length);
        int offset25 = offset24 + this.blobEncAlgorithm.length;
        System.arraycopy(this.blobEncPadding, 0, result, offset25, this.blobEncPadding.length);
        int offset26 = offset25 + this.blobEncPadding.length;
        System.arraycopy(this.blobEncMode, 0, result, offset26, this.blobEncMode.length);
        int offset27 = offset26 + this.blobEncMode.length;
        System.arraycopy(this.encryptedKeyblobSize, 0, result, offset27, this.encryptedKeyblobSize.length);
        int offset28 = offset27 + this.encryptedKeyblobSize.length;
        System.arraycopy(this.encryptedKeyblob, 0, result, offset28, this.encryptedKeyblob.length);
        int length = offset28 + this.encryptedKeyblob.length;
        return result;
    }
}
