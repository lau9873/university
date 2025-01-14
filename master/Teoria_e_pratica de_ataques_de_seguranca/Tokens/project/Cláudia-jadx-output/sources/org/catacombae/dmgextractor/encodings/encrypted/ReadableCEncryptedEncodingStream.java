package org.catacombae.dmgextractor.encodings.encrypted;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.catacombae.dmgextractor.Util;
import org.catacombae.dmgextractor.encodings.encrypted.CommonCEncryptedEncodingHeader;
import org.catacombae.io.BasicReadableRandomAccessStream;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/ReadableCEncryptedEncodingStream.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/encodings/encrypted/ReadableCEncryptedEncodingStream.class */
public class ReadableCEncryptedEncodingStream extends BasicReadableRandomAccessStream {
    private final ReadableRandomAccessStream backingStream;
    private final CommonCEncryptedEncodingHeader header;
    private final SecretKeySpec aesKey;
    private final SecretKeySpec hmacSha1Key;
    private final Mac hmacSha1;
    private final Cipher aesCipher;
    private final long streamLength;
    private long blockNumber = 0;
    private int posInBlock = 0;

    public ReadableCEncryptedEncodingStream(ReadableRandomAccessStream backingStream, char[] password) throws RuntimeIOException {
        Debug.print("ReadableCEncryptedEncodingStream(" + backingStream + ", " + ((Object) password) + ");");
        this.backingStream = backingStream;
        int headerVersion = CEncryptedEncodingUtil.detectVersion(backingStream);
        Debug.print("  headerVersion = " + headerVersion);
        switch (headerVersion) {
            case -1:
                throw new RuntimeException("No CEncryptedEncoding header found!");
            case 0:
            default:
                throw new RuntimeException("Unknown header version: " + headerVersion);
            case 1:
                byte[] v1HeaderData = new byte[V1Header.length()];
                backingStream.seek(backingStream.length() - V1Header.length());
                backingStream.readFully(v1HeaderData);
                V1Header v1header = new V1Header(v1HeaderData, 0);
                Debug.print("  V1 header:");
                v1header.print(Debug.ps, "    ");
                this.header = CommonCEncryptedEncodingHeader.create(v1header);
                break;
            case 2:
                byte[] v2HeaderData = new byte[V2Header.length()];
                backingStream.seek(0L);
                backingStream.readFully(v2HeaderData);
                V2Header v2header = new V2Header(v2HeaderData, 0);
                Debug.print("  V2 header:");
                v2header.print(Debug.ps, "    ");
                this.header = CommonCEncryptedEncodingHeader.create(v2header);
                break;
        }
        this.streamLength = this.header.getEncryptedDataLength();
        try {
            PBEKeySpec ks = new PBEKeySpec(password, this.header.getKdfSalt(), this.header.getKdfIterationCount(), 192);
            SecretKeyFactory fact = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            Key k = fact.generateSecret(ks);
            byte[] keyData = k.getEncoded();
            Debug.print("Derived key: 0x" + Util.byteArrayToHexString(keyData));
            Cipher keyDecryptionCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            SecretKeyFactory fact2 = SecretKeyFactory.getInstance("DESede");
            Key k2 = fact2.generateSecret(new DESedeKeySpec(keyData));
            CommonCEncryptedEncodingHeader.KeySet keys = this.header.unwrapKeys(k2, keyDecryptionCipher);
            Debug.print("AES key: 0x" + Util.byteArrayToHexString(keys.getAesKey()));
            Debug.print("HmacSHA1 key: 0x" + Util.byteArrayToHexString(keys.getHmacSha1Key()));
            this.aesKey = new SecretKeySpec(keys.getAesKey(), "AES");
            this.hmacSha1Key = new SecretKeySpec(keys.getHmacSha1Key(), "HmacSHA1");
            keys.clearData();
            this.hmacSha1 = Mac.getInstance("HmacSHA1");
            this.hmacSha1.init(this.hmacSha1Key);
            this.aesCipher = Cipher.getInstance("AES/CBC/NoPadding");
        } catch (Exception e2) {
            throw new RuntimeException("Exception while trying to decrypt keys.", e2);
        }
    }

    public static boolean isCEncryptedEncoding(ReadableRandomAccessStream stream) {
        int version = CEncryptedEncodingUtil.detectVersion(stream);
        return version == 1 || version == 2;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.Stream
    public void close() throws RuntimeIOException {
        this.backingStream.close();
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public void seek(long pos) throws RuntimeIOException {
        if (pos < 0) {
            throw new IllegalArgumentException("Negative seek request: pos (" + pos + ") < 0");
        }
        if (pos > this.streamLength) {
            this.blockNumber = this.streamLength / this.header.getBlockSize();
            this.posInBlock = 0;
            return;
        }
        long nextBlockNumber = pos / this.header.getBlockSize();
        int nextPosInBlock = (int) (pos % this.header.getBlockSize());
        this.blockNumber = nextBlockNumber;
        this.posInBlock = nextPosInBlock;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long length() throws RuntimeIOException {
        return this.streamLength;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long getFilePointer() throws RuntimeIOException {
        return (this.blockNumber * this.header.getBlockSize()) + this.posInBlock;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e7, code lost:
        if (r0 <= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ea, code lost:
        java.lang.System.err.println("WARNING: Could not read entire block! blockNumber=" + r8.blockNumber + ", bytesRead=" + r0);
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v21, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v25, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v27, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v30, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v32, types: [byte[], byte[][]] */
    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(byte[] r9, int r10, int r11) throws org.catacombae.io.RuntimeIOException {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.catacombae.dmgextractor.encodings.encrypted.ReadableCEncryptedEncodingStream.read(byte[], int, int):int");
    }

    /* JADX WARN: Type inference failed for: r0v28, types: [byte[], byte[][]] */
    /* JADX WARN: Type inference failed for: r0v37, types: [byte[], byte[][]] */
    private int decrypt(byte[] encBlockData, byte[] decBlockData, long blockNumber) {
        Debug.print("decrypt(byte[" + encBlockData.length + "], byte[" + decBlockData.length + "], " + blockNumber + ");");
        if (blockNumber < 0 || blockNumber > 2147483647L) {
            throw new RuntimeException("Block number out of range: " + blockNumber);
        }
        int blockNumberInt = (int) (blockNumber & (-1));
        this.hmacSha1.reset();
        this.hmacSha1.update(Util.toByteArrayBE(blockNumberInt));
        byte[] iv = new byte[16];
        System.arraycopy(this.hmacSha1.doFinal(), 0, iv, 0, iv.length);
        try {
            try {
                this.aesCipher.init(2, this.aesKey, new IvParameterSpec(iv));
                int bytesDecrypted = this.aesCipher.doFinal(encBlockData, 0, encBlockData.length, decBlockData, 0);
                Util.zero((byte[][]) new byte[]{iv});
                return bytesDecrypted;
            } catch (Exception e2) {
                throw new RuntimeException("Unexpected exception when trying to decrypt block " + blockNumber + ".", e2);
            }
        } catch (Throwable th) {
            Util.zero((byte[][]) new byte[]{iv});
            throw th;
        }
    }

    private static void printHelp() {
        System.err.println("usage: " + ReadableCEncryptedEncodingStream.class.getName() + " -i in-file -p password -o out-file");
        System.exit(-1);
    }

    public static void main(String[] args) throws IOException {
        String inputFilename = null;
        String outputFilename = null;
        String password = null;
        for (int i2 = 0; i2 < args.length; i2++) {
            String curArg = args[i2];
            if (curArg.startsWith("-i")) {
                if (i2 + 1 < args.length) {
                    inputFilename = args[i2 + 1];
                } else {
                    printHelp();
                }
            } else if (curArg.startsWith("-p")) {
                if (i2 + 1 < args.length) {
                    password = args[i2 + 1];
                } else {
                    printHelp();
                }
            } else if (curArg.startsWith("-o")) {
                if (i2 + 1 < args.length) {
                    outputFilename = args[i2 + 1];
                } else {
                    printHelp();
                }
            }
        }
        if (inputFilename == null || outputFilename == null || password == null) {
            printHelp();
        }
        runTest(inputFilename, outputFilename, password);
    }

    private static void runTest(String inputFilename, String outputFilename, String password) throws IOException {
        ReadableRandomAccessStream backingStream = new ReadableFileStream(inputFilename);
        ReadableRandomAccessStream rras = new ReadableCEncryptedEncodingStream(backingStream, password.toCharArray());
        System.out.println("Length of encrypted data: " + rras.length() + " bytes");
        byte[] lastBlock = new byte[4096];
        rras.seek(rras.length() - 4096);
        rras.readFully(lastBlock);
        System.out.println("Last block: 0x" + Util.byteArrayToHexString(lastBlock));
        byte[] sig = new byte[2];
        rras.seek(0L);
        rras.readFully(sig);
        System.out.println("Signature: " + Util.toASCIIString(sig));
        System.out.println("fp=" + rras.getFilePointer());
        byte[] following = new byte[3];
        rras.readFully(following);
        System.out.println("Following(" + following.length + "): 0x" + Util.byteArrayToHexString(following));
        System.out.println("fp=" + rras.getFilePointer());
        rras.readFully(following);
        System.out.println("Following(" + following.length + "): 0x" + Util.byteArrayToHexString(following));
        System.out.println("fp=" + rras.getFilePointer());
        rras.readFully(following);
        System.out.println("Following(" + following.length + "): 0x" + Util.byteArrayToHexString(following));
        System.out.println("fp=" + rras.getFilePointer());
        rras.seek(33792L);
        rras.readFully(sig);
        System.out.println("Signature: " + Util.toASCIIString(sig));
        System.out.println("fp=" + rras.getFilePointer());
        System.out.println("Checking boundary passage:");
        byte[] boundaryBytes = new byte[9];
        rras.seek(36859L);
        rras.readFully(boundaryBytes);
        System.out.println("boundaryBytes(" + boundaryBytes.length + "): 0x" + Util.byteArrayToHexString(boundaryBytes));
        System.out.println("fp=" + rras.getFilePointer());
        System.out.println("Checking reading until eof:");
        byte[] buffer = new byte[5001];
        rras.seek(rras.length() - 12288);
        int bytesRead = rras.read(buffer);
        long totBytesRead = 0;
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead + " bytes.");
            totBytesRead += bytesRead;
            bytesRead = rras.read(buffer);
        }
        System.out.println("Finished. bytesRead=" + bytesRead + " totBytesRead=" + totBytesRead);
        FileOutputStream out = new FileOutputStream(outputFilename);
        System.out.println("Extracting encrypted data to file: " + outputFilename);
        rras.seek(0L);
        byte[] buffer2 = new byte[9119];
        long totalBytesWritten = 0;
        for (int bytesRead2 = rras.read(buffer2); bytesRead2 > 0; bytesRead2 = rras.read(buffer2)) {
            System.out.println("Read " + bytesRead2 + " bytes.");
            out.write(buffer2, 0, bytesRead2);
            totalBytesWritten += bytesRead2;
        }
        System.out.println("Wrote " + totalBytesWritten + " bytes.");
        out.close();
    }
}
