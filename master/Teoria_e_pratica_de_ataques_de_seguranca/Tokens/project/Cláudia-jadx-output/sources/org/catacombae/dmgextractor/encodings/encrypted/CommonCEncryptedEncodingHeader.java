package org.catacombae.dmgextractor.encodings.encrypted;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import org.catacombae.dmgextractor.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CommonCEncryptedEncodingHeader.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CommonCEncryptedEncodingHeader.class */
public abstract class CommonCEncryptedEncodingHeader {
    public abstract int getBlockSize();

    public abstract long getBlockDataStart();

    public abstract byte[] getKdfSalt();

    public abstract int getKdfIterationCount();

    public abstract byte[] getUnwrapInitializationVector();

    public abstract long getTrailingReservedBytes();

    public abstract long getEncryptedDataLength();

    public abstract KeySet unwrapKeys(Key key, Cipher cipher) throws GeneralSecurityException, InvalidKeyException, InvalidAlgorithmParameterException;

    public static CommonCEncryptedEncodingHeader create(V1Header header) {
        return new V1Implementation(header);
    }

    public static CommonCEncryptedEncodingHeader create(V2Header header) {
        return new V2Implementation(header);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CommonCEncryptedEncodingHeader$KeySet.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CommonCEncryptedEncodingHeader$KeySet.class */
    public static class KeySet {
        private final byte[] aesKey;
        private final byte[] hmacSha1Key;

        private KeySet(byte[] aesKey, byte[] hmacSha1Key) {
            this.aesKey = aesKey;
            this.hmacSha1Key = hmacSha1Key;
        }

        public byte[] getAesKey() {
            return this.aesKey;
        }

        public byte[] getHmacSha1Key() {
            return this.hmacSha1Key;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [byte[], byte[][]] */
        /* JADX WARN: Type inference failed for: r0v3, types: [byte[], byte[][]] */
        public void clearData() {
            Util.zero((byte[][]) new byte[]{this.aesKey});
            Util.zero((byte[][]) new byte[]{this.hmacSha1Key});
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CommonCEncryptedEncodingHeader$V1Implementation.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CommonCEncryptedEncodingHeader$V1Implementation.class */
    private static class V1Implementation extends CommonCEncryptedEncodingHeader {
        private final V1Header header;

        public V1Implementation(V1Header header) {
            this.header = header;
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public int getBlockSize() {
            return this.header.getBlockSize();
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public long getBlockDataStart() {
            return 0L;
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public long getTrailingReservedBytes() {
            V1Header v1Header = this.header;
            return V1Header.length();
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public byte[] getKdfSalt() {
            return Util.createCopy(this.header.getKdfSalt(), 0, this.header.getKdfSaltLen());
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public int getKdfIterationCount() {
            return this.header.getKdfIterationCount();
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public byte[] getUnwrapInitializationVector() {
            return this.header.getUnwrapIv();
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public long getEncryptedDataLength() {
            return this.header.getDecryptedDataLength();
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public KeySet unwrapKeys(Key derivedKey, Cipher cph) throws GeneralSecurityException, InvalidKeyException, InvalidAlgorithmParameterException {
            byte[] aesKey = unwrapIndividualKey(derivedKey, cph, Util.createCopy(this.header.getWrappedAesKey(), 0, this.header.getLenWrappedAesKey()));
            byte[] hmacSha1Key = unwrapIndividualKey(derivedKey, cph, Util.createCopy(this.header.getWrappedHmacSha1Key(), 0, this.header.getLenWrappedHmacSha1Key()));
            return new KeySet(aesKey, hmacSha1Key);
        }

        /* JADX WARN: Type inference failed for: r0v59, types: [byte[], byte[][]] */
        public byte[] unwrapIndividualKey(Key key, Cipher cph, byte[] wrappedKey) throws InvalidKeyException, InvalidAlgorithmParameterException, GeneralSecurityException {
            Debug.print("unwrapIndividualKey(" + key + ", " + cph + ", byte[" + wrappedKey.length + "]);");
            Debug.print("  wrappedKey: 0x" + Util.byteArrayToHexString(wrappedKey));
            byte[] initialIv = {74, -35, -94, 44, 121, -24, 33, 5};
            byte[] ir1 = new byte[wrappedKey.length];
            cph.init(2, key, new IvParameterSpec(initialIv));
            int ir1Len = cph.doFinal(wrappedKey, 0, wrappedKey.length, ir1, 0);
            Debug.print("  ir1: 0x" + Util.byteArrayToHexString(ir1, 0, ir1Len));
            Debug.print("  ir1Len: " + ir1Len);
            byte[] ir2 = new byte[ir1Len];
            for (int i2 = 0; i2 < ir1Len; i2++) {
                ir2[i2] = ir1[(ir1Len - 1) - i2];
            }
            Debug.print("  ir2: 0x" + Util.byteArrayToHexString(ir2));
            Debug.print("  ir2.length: " + ir2.length);
            byte[] ir3 = new byte[ir2.length - 8];
            cph.init(2, key, new IvParameterSpec(ir2, 0, 8));
            int ir3Len = cph.doFinal(ir2, 8, ir2.length - 8, ir3, 0);
            Debug.print("  ir3: 0x" + Util.byteArrayToHexString(ir3, 0, ir3Len));
            Debug.print("  ir3Len: " + ir3Len);
            byte[] result = Util.createCopy(ir3, 4, ir3Len - 4);
            Util.zero((byte[][]) new byte[]{ir1, ir2, ir3});
            return result;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CommonCEncryptedEncodingHeader$V2Implementation.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/CommonCEncryptedEncodingHeader$V2Implementation.class */
    private static class V2Implementation extends CommonCEncryptedEncodingHeader {
        private final V2Header header;

        public V2Implementation(V2Header header) {
            this.header = header;
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public int getBlockSize() {
            return this.header.getBlockSize();
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public long getBlockDataStart() {
            return this.header.getOffsetToDataStart();
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public long getTrailingReservedBytes() {
            return 0L;
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public byte[] getKdfSalt() {
            return Util.createCopy(this.header.getKdfSalt(), 0, this.header.getKdfSaltLen());
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public int getKdfIterationCount() {
            return this.header.getKdfIterationCount();
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public byte[] getUnwrapInitializationVector() {
            return Util.createCopy(this.header.getBlobEncIv(), 0, this.header.getBlobEncIvSize());
        }

        private byte[] getEncryptedKeyBlob() {
            return Util.createCopy(this.header.getEncryptedKeyblob(), 0, this.header.getEncryptedKeyblobSize());
        }

        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public long getEncryptedDataLength() {
            return this.header.getEncryptedDataLength();
        }

        /* JADX WARN: Type inference failed for: r0v50, types: [byte[], byte[][]] */
        @Override // org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader
        public KeySet unwrapKeys(Key derivedKey, Cipher cph) throws InvalidKeyException, InvalidAlgorithmParameterException, GeneralSecurityException {
            Debug.print("V2Implementation.unwrapKeys(" + derivedKey + ", " + cph + ");");
            cph.init(2, derivedKey, new IvParameterSpec(getUnwrapInitializationVector()));
            byte[] encryptedKeyBlob = getEncryptedKeyBlob();
            Debug.print("  encryptedKeyBlob.length=" + encryptedKeyBlob.length);
            byte[] decryptedKeyBlob = new byte[encryptedKeyBlob.length];
            Debug.print("  doing update....");
            int bp = cph.update(encryptedKeyBlob, 0, encryptedKeyBlob.length, decryptedKeyBlob);
            Debug.print("    bp == " + bp);
            Debug.print("  doing final....");
            Debug.print("    bp == " + (bp + cph.doFinal(decryptedKeyBlob, bp)));
            Debug.print("  decryptedKeyBlob: 0x" + Util.byteArrayToHexString(decryptedKeyBlob));
            byte[] aesKey = new byte[16];
            byte[] hmacSha1Key = new byte[20];
            System.arraycopy(decryptedKeyBlob, 0, aesKey, 0, 16);
            Debug.print("  aesKey: 0x" + Util.byteArrayToHexString(aesKey));
            System.arraycopy(decryptedKeyBlob, 16, hmacSha1Key, 0, 20);
            Debug.print("  hmacSha1Key: 0x" + Util.byteArrayToHexString(hmacSha1Key));
            Util.zero((byte[][]) new byte[]{decryptedKeyBlob});
            Debug.print("  decryptedKeyBlob: 0x" + Util.byteArrayToHexString(decryptedKeyBlob));
            Debug.print("returning from V2Implementation.unwrapKeys...");
            return new KeySet(aesKey, hmacSha1Key);
        }
    }
}
