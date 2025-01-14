package org.apache.tools.bzip2;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/apache-ant-1.7.0-bzip2.jar:org/apache/tools/bzip2/CBZip2InputStream.class */
public class CBZip2InputStream extends InputStream implements BZip2Constants {
    private int last;
    private int origPtr;
    private int blockSize100k;
    private boolean blockRandomised;
    private int bsBuff;
    private int bsLive;
    private int nInUse;
    private InputStream in;
    private static final int EOF = 0;
    private static final int START_BLOCK_STATE = 1;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    private int su_count;
    private int su_ch2;
    private int su_chPrev;
    private int su_i2;
    private int su_j2;
    private int su_rNToGo;
    private int su_rTPos;
    private int su_tPos;
    private char su_z;
    private Data data;
    private final CRC crc = new CRC();
    private int currentChar = -1;
    private int currentState = 1;

    private static void reportCRCError() throws IOException {
        System.err.println("BZip2 CRC error");
    }

    private void makeMaps() {
        boolean[] zArr = this.data.inUse;
        byte[] bArr = this.data.seqToUnseq;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (zArr[i3]) {
                int i4 = i2;
                i2++;
                bArr[i4] = (byte) i3;
            }
        }
        this.nInUse = i2;
    }

    public CBZip2InputStream(InputStream inputStream) throws IOException {
        this.in = inputStream;
        init();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.in != null) {
            return read0();
        }
        throw new IOException("stream closed");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("offs(" + i2 + ") < 0.");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("len(" + i3 + ") < 0.");
        }
        if (i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException("offs(" + i2 + ") + len(" + i3 + ") > dest.length(" + bArr.length + ").");
        }
        if (this.in == null) {
            throw new IOException("stream closed");
        }
        int i4 = i2 + i3;
        int i5 = i2;
        while (i5 < i4 && (read0 = read0()) >= 0) {
            int i6 = i5;
            i5++;
            bArr[i6] = (byte) read0;
        }
        if (i5 == i2) {
            return -1;
        }
        return i5 - i2;
    }

    private int read0() throws IOException {
        int i2 = this.currentChar;
        switch (this.currentState) {
            case 0:
                return -1;
            case 1:
                throw new IllegalStateException();
            case 2:
                throw new IllegalStateException();
            case 3:
                setupRandPartB();
                break;
            case 4:
                setupRandPartC();
                break;
            case 5:
                throw new IllegalStateException();
            case 6:
                setupNoRandPartB();
                break;
            case 7:
                setupNoRandPartC();
                break;
            default:
                throw new IllegalStateException();
        }
        return i2;
    }

    private void init() throws IOException {
        int read = this.in.read();
        if (read != 104) {
            throw new IOException("Stream is not BZip2 formatted: expected 'h' as first byte but got '" + ((char) read) + "'");
        }
        int read2 = this.in.read();
        if (read2 < 49 || read2 > 57) {
            throw new IOException("Stream is not BZip2 formatted: illegal blocksize " + ((char) read2));
        }
        this.blockSize100k = read2 - 48;
        initBlock();
        setupBlock();
    }

    private void initBlock() throws IOException {
        char bsGetUByte = bsGetUByte();
        char bsGetUByte2 = bsGetUByte();
        char bsGetUByte3 = bsGetUByte();
        char bsGetUByte4 = bsGetUByte();
        char bsGetUByte5 = bsGetUByte();
        char bsGetUByte6 = bsGetUByte();
        if (bsGetUByte == 23 && bsGetUByte2 == 'r' && bsGetUByte3 == 'E' && bsGetUByte4 == '8' && bsGetUByte5 == 'P' && bsGetUByte6 == 144) {
            complete();
        } else if (bsGetUByte != '1' || bsGetUByte2 != 'A' || bsGetUByte3 != 'Y' || bsGetUByte4 != '&' || bsGetUByte5 != 'S' || bsGetUByte6 != 'Y') {
            this.currentState = 0;
            throw new IOException("bad block header");
        } else {
            this.storedBlockCRC = bsGetInt();
            this.blockRandomised = bsR(1) == 1;
            if (this.data == null) {
                this.data = new Data(this.blockSize100k);
            }
            getAndMoveToFrontDecode();
            this.crc.initialiseCRC();
            this.currentState = 1;
        }
    }

    private void endBlock() throws IOException {
        this.computedBlockCRC = this.crc.getFinalCRC();
        if (this.storedBlockCRC != this.computedBlockCRC) {
            this.computedCombinedCRC = (this.storedCombinedCRC << 1) | (this.storedCombinedCRC >>> 31);
            this.computedCombinedCRC ^= this.storedBlockCRC;
            reportCRCError();
        }
        this.computedCombinedCRC = (this.computedCombinedCRC << 1) | (this.computedCombinedCRC >>> 31);
        this.computedCombinedCRC ^= this.computedBlockCRC;
    }

    private void complete() throws IOException {
        this.storedCombinedCRC = bsGetInt();
        this.currentState = 0;
        this.data = null;
        if (this.storedCombinedCRC != this.computedCombinedCRC) {
            reportCRCError();
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            try {
                if (inputStream != System.in) {
                    inputStream.close();
                }
            } finally {
                this.data = null;
                this.in = null;
            }
        }
    }

    private int bsR(int i2) throws IOException {
        int i3 = this.bsLive;
        int i4 = this.bsBuff;
        if (i3 < i2) {
            InputStream inputStream = this.in;
            do {
                int read = inputStream.read();
                if (read < 0) {
                    throw new IOException("unexpected end of stream");
                }
                i4 = (i4 << 8) | read;
                i3 += 8;
            } while (i3 < i2);
            this.bsBuff = i4;
        }
        this.bsLive = i3 - i2;
        return (i4 >> (i3 - i2)) & ((1 << i2) - 1);
    }

    private boolean bsGetBit() throws IOException {
        int i2 = this.bsLive;
        int i3 = this.bsBuff;
        if (i2 < 1) {
            int read = this.in.read();
            if (read < 0) {
                throw new IOException("unexpected end of stream");
            }
            i3 = (i3 << 8) | read;
            i2 += 8;
            this.bsBuff = i3;
        }
        this.bsLive = i2 - 1;
        return ((i3 >> (i2 - 1)) & 1) != 0;
    }

    private char bsGetUByte() throws IOException {
        return (char) bsR(8);
    }

    private int bsGetInt() throws IOException {
        return (((((bsR(8) << 8) | bsR(8)) << 8) | bsR(8)) << 8) | bsR(8);
    }

    private static void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = i2; i6 <= i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                if (cArr[i7] == i6) {
                    int i8 = i5;
                    i5++;
                    iArr3[i8] = i7;
                }
            }
        }
        int i9 = 23;
        while (true) {
            i9--;
            if (i9 <= 0) {
                break;
            }
            iArr2[i9] = 0;
            iArr[i9] = 0;
        }
        for (int i10 = 0; i10 < i4; i10++) {
            int i11 = cArr[i10] + 1;
            iArr2[i11] = iArr2[i11] + 1;
        }
        int i12 = iArr2[0];
        for (int i13 = 1; i13 < 23; i13++) {
            i12 += iArr2[i13];
            iArr2[i13] = i12;
        }
        int i14 = i2;
        int i15 = 0;
        int i16 = iArr2[i14];
        while (i14 <= i3) {
            int i17 = iArr2[i14 + 1];
            int i18 = i15 + (i17 - i16);
            i16 = i17;
            iArr[i14] = i18 - 1;
            i15 = i18 << 1;
            i14++;
        }
        for (int i19 = i2 + 1; i19 <= i3; i19++) {
            iArr2[i19] = ((iArr[i19 - 1] + 1) << 1) - iArr2[i19];
        }
    }

    private void recvDecodingTables() throws IOException {
        Data data = this.data;
        boolean[] zArr = data.inUse;
        byte[] bArr = data.recvDecodingTables_pos;
        byte[] bArr2 = data.selector;
        byte[] bArr3 = data.selectorMtf;
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            if (bsGetBit()) {
                i2 |= 1 << i3;
            }
        }
        int i4 = 256;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            zArr[i4] = false;
        }
        for (int i5 = 0; i5 < 16; i5++) {
            if ((i2 & (1 << i5)) != 0) {
                int i6 = i5 << 4;
                for (int i7 = 0; i7 < 16; i7++) {
                    if (bsGetBit()) {
                        zArr[i6 + i7] = true;
                    }
                }
            }
        }
        makeMaps();
        int i8 = this.nInUse + 2;
        int bsR = bsR(3);
        int bsR2 = bsR(15);
        for (int i9 = 0; i9 < bsR2; i9++) {
            int i10 = 0;
            while (bsGetBit()) {
                i10++;
            }
            bArr3[i9] = (byte) i10;
        }
        int i11 = bsR;
        while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            bArr[i11] = (byte) i11;
        }
        for (int i12 = 0; i12 < bsR2; i12++) {
            int i13 = bArr3[i12] & 255;
            byte b2 = bArr[i13];
            while (i13 > 0) {
                bArr[i13] = bArr[i13 - 1];
                i13--;
            }
            bArr[0] = b2;
            bArr2[i12] = b2;
        }
        char[][] cArr = data.temp_charArray2d;
        for (int i14 = 0; i14 < bsR; i14++) {
            int bsR3 = bsR(5);
            char[] cArr2 = cArr[i14];
            for (int i15 = 0; i15 < i8; i15++) {
                while (bsGetBit()) {
                    bsR3 += bsGetBit() ? -1 : 1;
                }
                cArr2[i15] = (char) bsR3;
            }
        }
        createHuffmanDecodingTables(i8, bsR);
    }

    private void createHuffmanDecodingTables(int i2, int i3) {
        Data data = this.data;
        char[][] cArr = data.temp_charArray2d;
        int[] iArr = data.minLens;
        int[][] iArr2 = data.limit;
        int[][] iArr3 = data.base;
        int[][] iArr4 = data.perm;
        for (int i4 = 0; i4 < i3; i4++) {
            char c2 = ' ';
            char c3 = 0;
            char[] cArr2 = cArr[i4];
            int i5 = i2;
            while (true) {
                i5--;
                if (i5 >= 0) {
                    char c4 = cArr2[i5];
                    if (c4 > c3) {
                        c3 = c4;
                    }
                    if (c4 < c2) {
                        c2 = c4;
                    }
                }
            }
            hbCreateDecodeTables(iArr2[i4], iArr3[i4], iArr4[i4], cArr[i4], c2, c3, i2);
            iArr[i4] = c2;
        }
    }

    private void getAndMoveToFrontDecode() throws IOException {
        this.origPtr = bsR(24);
        recvDecodingTables();
        InputStream inputStream = this.in;
        Data data = this.data;
        byte[] bArr = data.ll8;
        int[] iArr = data.unzftab;
        byte[] bArr2 = data.selector;
        byte[] bArr3 = data.seqToUnseq;
        char[] cArr = data.getAndMoveToFrontDecode_yy;
        int[] iArr2 = data.minLens;
        int[][] iArr3 = data.limit;
        int[][] iArr4 = data.base;
        int[][] iArr5 = data.perm;
        int i2 = this.blockSize100k * BZip2Constants.baseBlockSize;
        int i3 = 256;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            cArr[i3] = (char) i3;
            iArr[i3] = 0;
        }
        int i4 = 0;
        int i5 = 49;
        int i6 = this.nInUse + 1;
        int andMoveToFrontDecode0 = getAndMoveToFrontDecode0(0);
        int i7 = this.bsBuff;
        int i8 = this.bsLive;
        int i9 = -1;
        int i10 = bArr2[0] & 255;
        int[] iArr6 = iArr4[i10];
        int[] iArr7 = iArr3[i10];
        int[] iArr8 = iArr5[i10];
        int i11 = iArr2[i10];
        while (andMoveToFrontDecode0 != i6) {
            if (andMoveToFrontDecode0 == 0 || andMoveToFrontDecode0 == 1) {
                int i12 = -1;
                int i13 = 1;
                while (true) {
                    int i14 = i13;
                    if (andMoveToFrontDecode0 == 0) {
                        i12 += i14;
                    } else if (andMoveToFrontDecode0 == 1) {
                        i12 += i14 << 1;
                    } else {
                        byte b2 = bArr3[cArr[0]];
                        int i15 = b2 & 255;
                        iArr[i15] = iArr[i15] + i12 + 1;
                        while (true) {
                            int i16 = i12;
                            i12 = i16 - 1;
                            if (i16 < 0) {
                                break;
                            }
                            i9++;
                            bArr[i9] = b2;
                        }
                        if (i9 >= i2) {
                            throw new IOException("block overrun");
                        }
                    }
                    if (i5 == 0) {
                        i5 = 49;
                        i4++;
                        int i17 = bArr2[i4] & 255;
                        iArr6 = iArr4[i17];
                        iArr7 = iArr3[i17];
                        iArr8 = iArr5[i17];
                        i11 = iArr2[i17];
                    } else {
                        i5--;
                    }
                    int i18 = i11;
                    while (i8 < i18) {
                        int read = inputStream.read();
                        if (read >= 0) {
                            i7 = (i7 << 8) | read;
                            i8 += 8;
                        } else {
                            throw new IOException("unexpected end of stream");
                        }
                    }
                    int i19 = (i7 >> (i8 - i18)) & ((1 << i18) - 1);
                    i8 -= i18;
                    while (i19 > iArr7[i18]) {
                        i18++;
                        while (i8 < 1) {
                            int read2 = inputStream.read();
                            if (read2 >= 0) {
                                i7 = (i7 << 8) | read2;
                                i8 += 8;
                            } else {
                                throw new IOException("unexpected end of stream");
                            }
                        }
                        i8--;
                        i19 = (i19 << 1) | ((i7 >> i8) & 1);
                    }
                    andMoveToFrontDecode0 = iArr8[i19 - iArr6[i18]];
                    i13 = i14 << 1;
                }
            } else {
                i9++;
                if (i9 >= i2) {
                    throw new IOException("block overrun");
                }
                char c2 = cArr[andMoveToFrontDecode0 - 1];
                int i20 = bArr3[c2] & 255;
                iArr[i20] = iArr[i20] + 1;
                bArr[i9] = bArr3[c2];
                if (andMoveToFrontDecode0 <= 16) {
                    int i21 = andMoveToFrontDecode0 - 1;
                    while (i21 > 0) {
                        int i22 = i21;
                        i21--;
                        cArr[i22] = cArr[i21];
                    }
                } else {
                    System.arraycopy(cArr, 0, cArr, 1, andMoveToFrontDecode0 - 1);
                }
                cArr[0] = c2;
                if (i5 == 0) {
                    i5 = 49;
                    i4++;
                    int i23 = bArr2[i4] & 255;
                    iArr6 = iArr4[i23];
                    iArr7 = iArr3[i23];
                    iArr8 = iArr5[i23];
                    i11 = iArr2[i23];
                } else {
                    i5--;
                }
                int i24 = i11;
                while (i8 < i24) {
                    int read3 = inputStream.read();
                    if (read3 >= 0) {
                        i7 = (i7 << 8) | read3;
                        i8 += 8;
                    } else {
                        throw new IOException("unexpected end of stream");
                    }
                }
                int i25 = (i7 >> (i8 - i24)) & ((1 << i24) - 1);
                i8 -= i24;
                while (i25 > iArr7[i24]) {
                    i24++;
                    while (i8 < 1) {
                        int read4 = inputStream.read();
                        if (read4 >= 0) {
                            i7 = (i7 << 8) | read4;
                            i8 += 8;
                        } else {
                            throw new IOException("unexpected end of stream");
                        }
                    }
                    i8--;
                    i25 = (i25 << 1) | ((i7 >> i8) & 1);
                }
                andMoveToFrontDecode0 = iArr8[i25 - iArr6[i24]];
            }
        }
        this.last = i9;
        this.bsLive = i8;
        this.bsBuff = i7;
    }

    private int getAndMoveToFrontDecode0(int i2) throws IOException {
        InputStream inputStream = this.in;
        Data data = this.data;
        int i3 = data.selector[i2] & 255;
        int[] iArr = data.limit[i3];
        int i4 = data.minLens[i3];
        int bsR = bsR(i4);
        int i5 = this.bsLive;
        int i6 = this.bsBuff;
        while (bsR > iArr[i4]) {
            i4++;
            while (i5 < 1) {
                int read = inputStream.read();
                if (read >= 0) {
                    i6 = (i6 << 8) | read;
                    i5 += 8;
                } else {
                    throw new IOException("unexpected end of stream");
                }
            }
            i5--;
            bsR = (bsR << 1) | ((i6 >> i5) & 1);
        }
        this.bsLive = i5;
        this.bsBuff = i6;
        return data.perm[i3][bsR - data.base[i3][i4]];
    }

    private void setupBlock() throws IOException {
        if (this.data == null) {
            return;
        }
        int[] iArr = this.data.cftab;
        int[] initTT = this.data.initTT(this.last + 1);
        byte[] bArr = this.data.ll8;
        iArr[0] = 0;
        System.arraycopy(this.data.unzftab, 0, iArr, 1, 256);
        int i2 = iArr[0];
        for (int i3 = 1; i3 <= 256; i3++) {
            i2 += iArr[i3];
            iArr[i3] = i2;
        }
        int i4 = this.last;
        for (int i5 = 0; i5 <= i4; i5++) {
            int i6 = bArr[i5] & 255;
            int i7 = iArr[i6];
            iArr[i6] = i7 + 1;
            initTT[i7] = i5;
        }
        if (this.origPtr < 0 || this.origPtr >= initTT.length) {
            throw new IOException("stream corrupted");
        }
        this.su_tPos = initTT[this.origPtr];
        this.su_count = 0;
        this.su_i2 = 0;
        this.su_ch2 = 256;
        if (this.blockRandomised) {
            this.su_rNToGo = 0;
            this.su_rTPos = 0;
            setupRandPartA();
            return;
        }
        setupNoRandPartA();
    }

    private void setupRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            int i2 = this.data.ll8[this.su_tPos] & 255;
            this.su_tPos = this.data.tt[this.su_tPos];
            if (this.su_rNToGo == 0) {
                this.su_rNToGo = BZip2Constants.rNums[this.su_rTPos] - 1;
                int i3 = this.su_rTPos + 1;
                this.su_rTPos = i3;
                if (i3 == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo--;
            }
            int i4 = i2 ^ (this.su_rNToGo == 1 ? 1 : 0);
            this.su_ch2 = i4;
            this.su_i2++;
            this.currentChar = i4;
            this.currentState = 3;
            this.crc.updateCRC(i4);
            return;
        }
        endBlock();
        initBlock();
        setupBlock();
    }

    private void setupNoRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            int i2 = this.data.ll8[this.su_tPos] & 255;
            this.su_ch2 = i2;
            this.su_tPos = this.data.tt[this.su_tPos];
            this.su_i2++;
            this.currentChar = i2;
            this.currentState = 6;
            this.crc.updateCRC(i2);
            return;
        }
        this.currentState = 5;
        endBlock();
        initBlock();
        setupBlock();
    }

    private void setupRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.currentState = 2;
            this.su_count = 1;
            setupRandPartA();
            return;
        }
        int i2 = this.su_count + 1;
        this.su_count = i2;
        if (i2 >= 4) {
            this.su_z = (char) (this.data.ll8[this.su_tPos] & 255);
            this.su_tPos = this.data.tt[this.su_tPos];
            if (this.su_rNToGo == 0) {
                this.su_rNToGo = BZip2Constants.rNums[this.su_rTPos] - 1;
                int i3 = this.su_rTPos + 1;
                this.su_rTPos = i3;
                if (i3 == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo--;
            }
            this.su_j2 = 0;
            this.currentState = 4;
            if (this.su_rNToGo == 1) {
                this.su_z = (char) (this.su_z ^ 1);
            }
            setupRandPartC();
            return;
        }
        this.currentState = 2;
        setupRandPartA();
    }

    private void setupRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            this.currentChar = this.su_ch2;
            this.crc.updateCRC(this.su_ch2);
            this.su_j2++;
            return;
        }
        this.currentState = 2;
        this.su_i2++;
        this.su_count = 0;
        setupRandPartA();
    }

    private void setupNoRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.su_count = 1;
            setupNoRandPartA();
            return;
        }
        int i2 = this.su_count + 1;
        this.su_count = i2;
        if (i2 >= 4) {
            this.su_z = (char) (this.data.ll8[this.su_tPos] & 255);
            this.su_tPos = this.data.tt[this.su_tPos];
            this.su_j2 = 0;
            setupNoRandPartC();
            return;
        }
        setupNoRandPartA();
    }

    private void setupNoRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            int i2 = this.su_ch2;
            this.currentChar = i2;
            this.crc.updateCRC(i2);
            this.su_j2++;
            this.currentState = 7;
            return;
        }
        this.su_i2++;
        this.su_count = 0;
        setupNoRandPartA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/apache-ant-1.7.0-bzip2.jar:org/apache/tools/bzip2/CBZip2InputStream$Data.class */
    public static final class Data {
        final boolean[] inUse = new boolean[256];
        final byte[] seqToUnseq = new byte[256];
        final byte[] selector = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
        final int[] unzftab = new int[256];
        final int[][] limit = new int[6][BZip2Constants.MAX_ALPHA_SIZE];
        final int[][] base = new int[6][BZip2Constants.MAX_ALPHA_SIZE];
        final int[][] perm = new int[6][BZip2Constants.MAX_ALPHA_SIZE];
        final int[] minLens = new int[6];
        final int[] cftab = new int[257];
        final char[] getAndMoveToFrontDecode_yy = new char[256];
        final char[][] temp_charArray2d = new char[6][BZip2Constants.MAX_ALPHA_SIZE];
        final byte[] recvDecodingTables_pos = new byte[6];
        int[] tt;
        byte[] ll8;

        Data(int i2) {
            this.ll8 = new byte[i2 * BZip2Constants.baseBlockSize];
        }

        final int[] initTT(int i2) {
            int[] iArr = this.tt;
            if (iArr == null || iArr.length < i2) {
                int[] iArr2 = new int[i2];
                iArr = iArr2;
                this.tt = iArr2;
            }
            return iArr;
        }
    }
}
