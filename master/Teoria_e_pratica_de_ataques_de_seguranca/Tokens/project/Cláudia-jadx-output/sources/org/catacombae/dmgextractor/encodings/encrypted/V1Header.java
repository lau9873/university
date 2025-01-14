package org.catacombae.dmgextractor.encodings.encrypted;

import java.io.PrintStream;
import org.catacombae.dmgextractor.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/V1Header.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/V1Header.class */
public class V1Header {
    public static final int STRUCTSIZE = 1276;
    private final byte[] unknown0 = new byte[16];
    private final byte[] blockSize = new byte[4];
    private final byte[] unknownInt20 = new byte[4];
    private final byte[] unknownInt24 = new byte[4];
    private final byte[] unknownInt28 = new byte[4];
    private final byte[] unknownInt32 = new byte[4];
    private final byte[] unknownInt36 = new byte[4];
    private final byte[] unknownInt40 = new byte[4];
    private final byte[] unknownInt44 = new byte[4];
    private final byte[] kdfIterationCount = new byte[4];
    private final byte[] kdfSaltLen = new byte[4];
    private final byte[] kdfSalt = new byte[32];
    private final byte[] unknownInt88 = new byte[4];
    private final byte[] unknownInt92 = new byte[4];
    private final byte[] unknownInt96 = new byte[4];
    private final byte[] unknownInt100 = new byte[4];
    private final byte[] unwrapIv = new byte[32];
    private final byte[] lenWrappedAesKey = new byte[4];
    private final byte[] wrappedAesKey = new byte[256];
    private final byte[] unknownInt396 = new byte[4];
    private final byte[] unknownInt400 = new byte[4];
    private final byte[] unknown404 = new byte[32];
    private final byte[] lenWrappedHmacSha1Key = new byte[4];
    private final byte[] wrappedHmacSha1Key = new byte[256];
    private final byte[] unknownInt696 = new byte[4];
    private final byte[] unknownInt700 = new byte[4];
    private final byte[] unknown704 = new byte[32];
    private final byte[] lenWrappedIntegrityKey = new byte[4];
    private final byte[] wrappedIntegrityKey = new byte[256];
    private final byte[] lenUnknown1000 = new byte[4];
    private final byte[] unknown1000 = new byte[256];
    private final byte[] decryptedDataLength = new byte[8];
    private final byte[] possibleHeaderVersion = new byte[4];
    private final byte[] signature = new byte[8];

    public V1Header(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.unknown0, 0, 16);
        System.arraycopy(data, offset + 16, this.blockSize, 0, 4);
        System.arraycopy(data, offset + 20, this.unknownInt20, 0, 4);
        System.arraycopy(data, offset + 24, this.unknownInt24, 0, 4);
        System.arraycopy(data, offset + 28, this.unknownInt28, 0, 4);
        System.arraycopy(data, offset + 32, this.unknownInt32, 0, 4);
        System.arraycopy(data, offset + 36, this.unknownInt36, 0, 4);
        System.arraycopy(data, offset + 40, this.unknownInt40, 0, 4);
        System.arraycopy(data, offset + 44, this.unknownInt44, 0, 4);
        System.arraycopy(data, offset + 48, this.kdfIterationCount, 0, 4);
        System.arraycopy(data, offset + 52, this.kdfSaltLen, 0, 4);
        System.arraycopy(data, offset + 56, this.kdfSalt, 0, 32);
        System.arraycopy(data, offset + 88, this.unknownInt88, 0, 4);
        System.arraycopy(data, offset + 92, this.unknownInt92, 0, 4);
        System.arraycopy(data, offset + 96, this.unknownInt96, 0, 4);
        System.arraycopy(data, offset + 100, this.unknownInt100, 0, 4);
        System.arraycopy(data, offset + 104, this.unwrapIv, 0, 32);
        System.arraycopy(data, offset + 136, this.lenWrappedAesKey, 0, 4);
        System.arraycopy(data, offset + 140, this.wrappedAesKey, 0, 256);
        System.arraycopy(data, offset + 396, this.unknownInt396, 0, 4);
        System.arraycopy(data, offset + 400, this.unknownInt400, 0, 4);
        System.arraycopy(data, offset + 404, this.unknown404, 0, 32);
        System.arraycopy(data, offset + 436, this.lenWrappedHmacSha1Key, 0, 4);
        System.arraycopy(data, offset + 440, this.wrappedHmacSha1Key, 0, 256);
        System.arraycopy(data, offset + 696, this.unknownInt696, 0, 4);
        System.arraycopy(data, offset + 700, this.unknownInt700, 0, 4);
        System.arraycopy(data, offset + 704, this.unknown704, 0, 32);
        System.arraycopy(data, offset + 736, this.lenWrappedIntegrityKey, 0, 4);
        System.arraycopy(data, offset + 740, this.wrappedIntegrityKey, 0, 256);
        System.arraycopy(data, offset + 996, this.lenUnknown1000, 0, 4);
        System.arraycopy(data, offset + 1000, this.unknown1000, 0, 256);
        System.arraycopy(data, offset + 1256, this.decryptedDataLength, 0, 8);
        System.arraycopy(data, offset + 1264, this.possibleHeaderVersion, 0, 4);
        System.arraycopy(data, offset + 1268, this.signature, 0, 8);
    }

    public static int length() {
        return 1276;
    }

    public byte[] getUnknown0() {
        return Util.readByteArrayBE(this.unknown0);
    }

    public int getBlockSize() {
        return Util.readIntBE(this.blockSize);
    }

    public int getUnknownInt20() {
        return Util.readIntBE(this.unknownInt20);
    }

    public int getUnknownInt24() {
        return Util.readIntBE(this.unknownInt24);
    }

    public int getUnknownInt28() {
        return Util.readIntBE(this.unknownInt28);
    }

    public int getUnknownInt32() {
        return Util.readIntBE(this.unknownInt32);
    }

    public int getUnknownInt36() {
        return Util.readIntBE(this.unknownInt36);
    }

    public int getUnknownInt40() {
        return Util.readIntBE(this.unknownInt40);
    }

    public int getUnknownInt44() {
        return Util.readIntBE(this.unknownInt44);
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

    public int getUnknownInt88() {
        return Util.readIntBE(this.unknownInt88);
    }

    public int getUnknownInt92() {
        return Util.readIntBE(this.unknownInt92);
    }

    public int getUnknownInt96() {
        return Util.readIntBE(this.unknownInt96);
    }

    public int getUnknownInt100() {
        return Util.readIntBE(this.unknownInt100);
    }

    public byte[] getUnwrapIv() {
        return Util.readByteArrayBE(this.unwrapIv);
    }

    public int getLenWrappedAesKey() {
        return Util.readIntBE(this.lenWrappedAesKey);
    }

    public byte[] getWrappedAesKey() {
        return Util.readByteArrayBE(this.wrappedAesKey);
    }

    public int getUnknownInt396() {
        return Util.readIntBE(this.unknownInt396);
    }

    public int getUnknownInt400() {
        return Util.readIntBE(this.unknownInt400);
    }

    public byte[] getUnknown404() {
        return Util.readByteArrayBE(this.unknown404);
    }

    public int getLenWrappedHmacSha1Key() {
        return Util.readIntBE(this.lenWrappedHmacSha1Key);
    }

    public byte[] getWrappedHmacSha1Key() {
        return Util.readByteArrayBE(this.wrappedHmacSha1Key);
    }

    public int getUnknownInt696() {
        return Util.readIntBE(this.unknownInt696);
    }

    public int getUnknownInt700() {
        return Util.readIntBE(this.unknownInt700);
    }

    public byte[] getUnknown704() {
        return Util.readByteArrayBE(this.unknown704);
    }

    public int getLenWrappedIntegrityKey() {
        return Util.readIntBE(this.lenWrappedIntegrityKey);
    }

    public byte[] getWrappedIntegrityKey() {
        return Util.readByteArrayBE(this.wrappedIntegrityKey);
    }

    public int getLenUnknown1000() {
        return Util.readIntBE(this.lenUnknown1000);
    }

    public byte[] getUnknown1000() {
        return Util.readByteArrayBE(this.unknown1000);
    }

    public long getDecryptedDataLength() {
        return Util.readLongBE(this.decryptedDataLength);
    }

    public int getPossibleHeaderVersion() {
        return Util.readIntBE(this.possibleHeaderVersion);
    }

    public byte[] getSignature() {
        return Util.readByteArrayBE(this.signature);
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " unknown0: 0x" + Util.byteArrayToHexString(getUnknown0()));
        ps.println(prefix + " blockSize: " + Util.unsign(getBlockSize()));
        ps.println(prefix + " unknownInt20: " + getUnknownInt20());
        ps.println(prefix + " unknownInt24: " + getUnknownInt24());
        ps.println(prefix + " unknownInt28: " + getUnknownInt28());
        ps.println(prefix + " unknownInt32: " + getUnknownInt32());
        ps.println(prefix + " unknownInt36: " + getUnknownInt36());
        ps.println(prefix + " unknownInt40: " + getUnknownInt40());
        ps.println(prefix + " unknownInt44: " + getUnknownInt44());
        ps.println(prefix + " kdfIterationCount: " + Util.unsign(getKdfIterationCount()));
        ps.println(prefix + " kdfSaltLen: " + Util.unsign(getKdfSaltLen()));
        ps.println(prefix + " kdfSalt: 0x" + Util.byteArrayToHexString(getKdfSalt()));
        ps.println(prefix + " unknownInt88: " + getUnknownInt88());
        ps.println(prefix + " unknownInt92: " + getUnknownInt92());
        ps.println(prefix + " unknownInt96: " + getUnknownInt96());
        ps.println(prefix + " unknownInt100: " + getUnknownInt100());
        ps.println(prefix + " unwrapIv: 0x" + Util.byteArrayToHexString(getUnwrapIv()));
        ps.println(prefix + " lenWrappedAesKey: " + Util.unsign(getLenWrappedAesKey()));
        ps.println(prefix + " wrappedAesKey: 0x" + Util.byteArrayToHexString(getWrappedAesKey()));
        ps.println(prefix + " unknownInt396: " + getUnknownInt396());
        ps.println(prefix + " unknownInt400: " + getUnknownInt400());
        ps.println(prefix + " unknown404: 0x" + Util.byteArrayToHexString(getUnknown404()));
        ps.println(prefix + " lenWrappedHmacSha1Key: " + Util.unsign(getLenWrappedHmacSha1Key()));
        ps.println(prefix + " wrappedHmacSha1Key: 0x" + Util.byteArrayToHexString(getWrappedHmacSha1Key()));
        ps.println(prefix + " unknownInt696: " + getUnknownInt696());
        ps.println(prefix + " unknownInt700: " + getUnknownInt700());
        ps.println(prefix + " unknown704: 0x" + Util.byteArrayToHexString(getUnknown704()));
        ps.println(prefix + " lenWrappedIntegrityKey: " + Util.unsign(getLenWrappedIntegrityKey()));
        ps.println(prefix + " wrappedIntegrityKey: 0x" + Util.byteArrayToHexString(getWrappedIntegrityKey()));
        ps.println(prefix + " lenUnknown1000: " + getLenUnknown1000());
        ps.println(prefix + " unknown1000: 0x" + Util.byteArrayToHexString(getUnknown1000()));
        ps.println(prefix + " decryptedDataLength: " + getDecryptedDataLength());
        ps.println(prefix + " possibleHeaderVersion: " + getPossibleHeaderVersion());
        ps.println(prefix + " signature: \"" + Util.toASCIIString(getSignature()) + "\"");
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "V1Header:");
        printFields(ps, prefix);
    }

    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.unknown0, 0, result, 0, this.unknown0.length);
        int offset = 0 + this.unknown0.length;
        System.arraycopy(this.blockSize, 0, result, offset, this.blockSize.length);
        int offset2 = offset + this.blockSize.length;
        System.arraycopy(this.unknownInt20, 0, result, offset2, this.unknownInt20.length);
        int offset3 = offset2 + this.unknownInt20.length;
        System.arraycopy(this.unknownInt24, 0, result, offset3, this.unknownInt24.length);
        int offset4 = offset3 + this.unknownInt24.length;
        System.arraycopy(this.unknownInt28, 0, result, offset4, this.unknownInt28.length);
        int offset5 = offset4 + this.unknownInt28.length;
        System.arraycopy(this.unknownInt32, 0, result, offset5, this.unknownInt32.length);
        int offset6 = offset5 + this.unknownInt32.length;
        System.arraycopy(this.unknownInt36, 0, result, offset6, this.unknownInt36.length);
        int offset7 = offset6 + this.unknownInt36.length;
        System.arraycopy(this.unknownInt40, 0, result, offset7, this.unknownInt40.length);
        int offset8 = offset7 + this.unknownInt40.length;
        System.arraycopy(this.unknownInt44, 0, result, offset8, this.unknownInt44.length);
        int offset9 = offset8 + this.unknownInt44.length;
        System.arraycopy(this.kdfIterationCount, 0, result, offset9, this.kdfIterationCount.length);
        int offset10 = offset9 + this.kdfIterationCount.length;
        System.arraycopy(this.kdfSaltLen, 0, result, offset10, this.kdfSaltLen.length);
        int offset11 = offset10 + this.kdfSaltLen.length;
        System.arraycopy(this.kdfSalt, 0, result, offset11, this.kdfSalt.length);
        int offset12 = offset11 + this.kdfSalt.length;
        System.arraycopy(this.unknownInt88, 0, result, offset12, this.unknownInt88.length);
        int offset13 = offset12 + this.unknownInt88.length;
        System.arraycopy(this.unknownInt92, 0, result, offset13, this.unknownInt92.length);
        int offset14 = offset13 + this.unknownInt92.length;
        System.arraycopy(this.unknownInt96, 0, result, offset14, this.unknownInt96.length);
        int offset15 = offset14 + this.unknownInt96.length;
        System.arraycopy(this.unknownInt100, 0, result, offset15, this.unknownInt100.length);
        int offset16 = offset15 + this.unknownInt100.length;
        System.arraycopy(this.unwrapIv, 0, result, offset16, this.unwrapIv.length);
        int offset17 = offset16 + this.unwrapIv.length;
        System.arraycopy(this.lenWrappedAesKey, 0, result, offset17, this.lenWrappedAesKey.length);
        int offset18 = offset17 + this.lenWrappedAesKey.length;
        System.arraycopy(this.wrappedAesKey, 0, result, offset18, this.wrappedAesKey.length);
        int offset19 = offset18 + this.wrappedAesKey.length;
        System.arraycopy(this.unknownInt396, 0, result, offset19, this.unknownInt396.length);
        int offset20 = offset19 + this.unknownInt396.length;
        System.arraycopy(this.unknownInt400, 0, result, offset20, this.unknownInt400.length);
        int offset21 = offset20 + this.unknownInt400.length;
        System.arraycopy(this.unknown404, 0, result, offset21, this.unknown404.length);
        int offset22 = offset21 + this.unknown404.length;
        System.arraycopy(this.lenWrappedHmacSha1Key, 0, result, offset22, this.lenWrappedHmacSha1Key.length);
        int offset23 = offset22 + this.lenWrappedHmacSha1Key.length;
        System.arraycopy(this.wrappedHmacSha1Key, 0, result, offset23, this.wrappedHmacSha1Key.length);
        int offset24 = offset23 + this.wrappedHmacSha1Key.length;
        System.arraycopy(this.unknownInt696, 0, result, offset24, this.unknownInt696.length);
        int offset25 = offset24 + this.unknownInt696.length;
        System.arraycopy(this.unknownInt700, 0, result, offset25, this.unknownInt700.length);
        int offset26 = offset25 + this.unknownInt700.length;
        System.arraycopy(this.unknown704, 0, result, offset26, this.unknown704.length);
        int offset27 = offset26 + this.unknown704.length;
        System.arraycopy(this.lenWrappedIntegrityKey, 0, result, offset27, this.lenWrappedIntegrityKey.length);
        int offset28 = offset27 + this.lenWrappedIntegrityKey.length;
        System.arraycopy(this.wrappedIntegrityKey, 0, result, offset28, this.wrappedIntegrityKey.length);
        int offset29 = offset28 + this.wrappedIntegrityKey.length;
        System.arraycopy(this.lenUnknown1000, 0, result, offset29, this.lenUnknown1000.length);
        int offset30 = offset29 + this.lenUnknown1000.length;
        System.arraycopy(this.unknown1000, 0, result, offset30, this.unknown1000.length);
        int offset31 = offset30 + this.unknown1000.length;
        System.arraycopy(this.decryptedDataLength, 0, result, offset31, this.decryptedDataLength.length);
        int offset32 = offset31 + this.decryptedDataLength.length;
        System.arraycopy(this.possibleHeaderVersion, 0, result, offset32, this.possibleHeaderVersion.length);
        int offset33 = offset32 + this.possibleHeaderVersion.length;
        System.arraycopy(this.signature, 0, result, offset33, this.signature.length);
        int length = offset33 + this.signature.length;
        return result;
    }
}
