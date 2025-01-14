package org.apache.tools.bzip2;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/apache-ant-1.7.0-bzip2.jar:org/apache/tools/bzip2/CBZip2OutputStream.class */
public class CBZip2OutputStream extends OutputStream implements BZip2Constants {
    public static final int MIN_BLOCKSIZE = 1;
    public static final int MAX_BLOCKSIZE = 9;
    protected static final int SETMASK = 2097152;
    protected static final int CLEARMASK = -2097153;
    protected static final int GREATER_ICOST = 15;
    protected static final int LESSER_ICOST = 0;
    protected static final int SMALL_THRESH = 20;
    protected static final int DEPTH_THRESH = 10;
    protected static final int WORK_FACTOR = 30;
    protected static final int QSORT_STACK_SIZE = 1000;
    private static final int[] INCS = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private int last;
    private int origPtr;
    private final int blockSize100k;
    private boolean blockRandomised;
    private int bsBuff;
    private int bsLive;
    private final CRC crc;
    private int nInUse;
    private int nMTF;
    private int workDone;
    private int workLimit;
    private boolean firstAttempt;
    private int currentChar;
    private int runLength;
    private int blockCRC;
    private int combinedCRC;
    private int allowableBlockSize;
    private Data data;
    private OutputStream out;

    protected static void hbMakeCodeLengths(char[] cArr, int[] iArr, int i2, int i3) {
        int[] iArr2 = new int[516];
        int[] iArr3 = new int[516];
        int[] iArr4 = new int[516];
        int i4 = i2;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            iArr3[i4 + 1] = (iArr[i4] == 0 ? 1 : iArr[i4]) << 8;
        }
        boolean z = true;
        while (z) {
            z = false;
            int i5 = i2;
            int i6 = 0;
            iArr2[0] = 0;
            iArr3[0] = 0;
            iArr4[0] = -2;
            for (int i7 = 1; i7 <= i2; i7++) {
                iArr4[i7] = -1;
                i6++;
                iArr2[i6] = i7;
                int i8 = i6;
                int i9 = iArr2[i8];
                while (iArr3[i9] < iArr3[iArr2[i8 >> 1]]) {
                    iArr2[i8] = iArr2[i8 >> 1];
                    i8 >>= 1;
                }
                iArr2[i8] = i9;
            }
            while (i6 > 1) {
                int i10 = iArr2[1];
                iArr2[1] = iArr2[i6];
                int i11 = i6 - 1;
                int i12 = 1;
                int i13 = iArr2[1];
                while (true) {
                    int i14 = i12 << 1;
                    if (i14 > i11) {
                        break;
                    }
                    if (i14 < i11 && iArr3[iArr2[i14 + 1]] < iArr3[iArr2[i14]]) {
                        i14++;
                    }
                    if (iArr3[i13] < iArr3[iArr2[i14]]) {
                        break;
                    }
                    iArr2[i12] = iArr2[i14];
                    i12 = i14;
                }
                iArr2[i12] = i13;
                int i15 = iArr2[1];
                iArr2[1] = iArr2[i11];
                int i16 = i11 - 1;
                int i17 = 1;
                int i18 = iArr2[1];
                while (true) {
                    int i19 = i17 << 1;
                    if (i19 > i16) {
                        break;
                    }
                    if (i19 < i16 && iArr3[iArr2[i19 + 1]] < iArr3[iArr2[i19]]) {
                        i19++;
                    }
                    if (iArr3[i18] < iArr3[iArr2[i19]]) {
                        break;
                    }
                    iArr2[i17] = iArr2[i19];
                    i17 = i19;
                }
                iArr2[i17] = i18;
                i5++;
                iArr4[i15] = i5;
                iArr4[i10] = i5;
                int i20 = iArr3[i10];
                int i21 = iArr3[i15];
                iArr3[i5] = ((i20 & (-256)) + (i21 & (-256))) | (1 + ((i20 & 255) > (i21 & 255) ? i20 & 255 : i21 & 255));
                iArr4[i5] = -1;
                i6 = i16 + 1;
                iArr2[i6] = i5;
                int i22 = i6;
                int i23 = iArr2[i22];
                int i24 = iArr3[i23];
                while (i24 < iArr3[iArr2[i22 >> 1]]) {
                    iArr2[i22] = iArr2[i22 >> 1];
                    i22 >>= 1;
                }
                iArr2[i22] = i23;
            }
            for (int i25 = 1; i25 <= i2; i25++) {
                int i26 = 0;
                int i27 = i25;
                while (true) {
                    int i28 = iArr4[i27];
                    if (i28 < 0) {
                        break;
                    }
                    i27 = i28;
                    i26++;
                }
                cArr[i25 - 1] = (char) i26;
                if (i26 > i3) {
                    z = true;
                }
            }
            if (z) {
                for (int i29 = 1; i29 < i2; i29++) {
                    iArr3[i29] = (1 + ((iArr3[i29] >> 8) >> 1)) << 8;
                }
            }
        }
    }

    private static void hbMakeCodeLengths(byte[] bArr, int[] iArr, Data data, int i2, int i3) {
        int[] iArr2 = data.heap;
        int[] iArr3 = data.weight;
        int[] iArr4 = data.parent;
        int i4 = i2;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            iArr3[i4 + 1] = (iArr[i4] == 0 ? 1 : iArr[i4]) << 8;
        }
        boolean z = true;
        while (z) {
            z = false;
            int i5 = i2;
            int i6 = 0;
            iArr2[0] = 0;
            iArr3[0] = 0;
            iArr4[0] = -2;
            for (int i7 = 1; i7 <= i2; i7++) {
                iArr4[i7] = -1;
                i6++;
                iArr2[i6] = i7;
                int i8 = i6;
                int i9 = iArr2[i8];
                while (iArr3[i9] < iArr3[iArr2[i8 >> 1]]) {
                    iArr2[i8] = iArr2[i8 >> 1];
                    i8 >>= 1;
                }
                iArr2[i8] = i9;
            }
            while (i6 > 1) {
                int i10 = iArr2[1];
                iArr2[1] = iArr2[i6];
                int i11 = i6 - 1;
                int i12 = 1;
                int i13 = iArr2[1];
                while (true) {
                    int i14 = i12 << 1;
                    if (i14 > i11) {
                        break;
                    }
                    if (i14 < i11 && iArr3[iArr2[i14 + 1]] < iArr3[iArr2[i14]]) {
                        i14++;
                    }
                    if (iArr3[i13] < iArr3[iArr2[i14]]) {
                        break;
                    }
                    iArr2[i12] = iArr2[i14];
                    i12 = i14;
                }
                iArr2[i12] = i13;
                int i15 = iArr2[1];
                iArr2[1] = iArr2[i11];
                int i16 = i11 - 1;
                int i17 = 1;
                int i18 = iArr2[1];
                while (true) {
                    int i19 = i17 << 1;
                    if (i19 > i16) {
                        break;
                    }
                    if (i19 < i16 && iArr3[iArr2[i19 + 1]] < iArr3[iArr2[i19]]) {
                        i19++;
                    }
                    if (iArr3[i18] < iArr3[iArr2[i19]]) {
                        break;
                    }
                    iArr2[i17] = iArr2[i19];
                    i17 = i19;
                }
                iArr2[i17] = i18;
                i5++;
                iArr4[i15] = i5;
                iArr4[i10] = i5;
                int i20 = iArr3[i10];
                int i21 = iArr3[i15];
                iArr3[i5] = ((i20 & (-256)) + (i21 & (-256))) | (1 + ((i20 & 255) > (i21 & 255) ? i20 & 255 : i21 & 255));
                iArr4[i5] = -1;
                i6 = i16 + 1;
                iArr2[i6] = i5;
                int i22 = i6;
                int i23 = iArr2[i22];
                int i24 = iArr3[i23];
                while (i24 < iArr3[iArr2[i22 >> 1]]) {
                    iArr2[i22] = iArr2[i22 >> 1];
                    i22 >>= 1;
                }
                iArr2[i22] = i23;
            }
            for (int i25 = 1; i25 <= i2; i25++) {
                int i26 = 0;
                int i27 = i25;
                while (true) {
                    int i28 = iArr4[i27];
                    if (i28 < 0) {
                        break;
                    }
                    i27 = i28;
                    i26++;
                }
                bArr[i25 - 1] = (byte) i26;
                if (i26 > i3) {
                    z = true;
                }
            }
            if (z) {
                for (int i29 = 1; i29 < i2; i29++) {
                    iArr3[i29] = (1 + ((iArr3[i29] >> 8) >> 1)) << 8;
                }
            }
        }
    }

    public static int chooseBlockSize(long j) {
        if (j > 0) {
            return (int) Math.min((j / 132000) + 1, 9L);
        }
        return 9;
    }

    public CBZip2OutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 9);
    }

    public CBZip2OutputStream(OutputStream outputStream, int i2) throws IOException {
        this.crc = new CRC();
        this.currentChar = -1;
        this.runLength = 0;
        if (i2 < 1) {
            throw new IllegalArgumentException("blockSize(" + i2 + ") < 1");
        }
        if (i2 > 9) {
            throw new IllegalArgumentException("blockSize(" + i2 + ") > 9");
        }
        this.blockSize100k = i2;
        this.out = outputStream;
        init();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        if (this.out != null) {
            write0(i2);
            return;
        }
        throw new IOException("closed");
    }

    private void writeRun() throws IOException {
        int i2 = this.last;
        if (i2 < this.allowableBlockSize) {
            int i3 = this.currentChar;
            Data data = this.data;
            data.inUse[i3] = true;
            byte b2 = (byte) i3;
            int i4 = this.runLength;
            this.crc.updateCRC(i3, i4);
            switch (i4) {
                case 1:
                    data.block[i2 + 2] = b2;
                    this.last = i2 + 1;
                    return;
                case 2:
                    data.block[i2 + 2] = b2;
                    data.block[i2 + 3] = b2;
                    this.last = i2 + 2;
                    return;
                case 3:
                    byte[] bArr = data.block;
                    bArr[i2 + 2] = b2;
                    bArr[i2 + 3] = b2;
                    bArr[i2 + 4] = b2;
                    this.last = i2 + 3;
                    return;
                default:
                    int i5 = i4 - 4;
                    data.inUse[i5] = true;
                    byte[] bArr2 = data.block;
                    bArr2[i2 + 2] = b2;
                    bArr2[i2 + 3] = b2;
                    bArr2[i2 + 4] = b2;
                    bArr2[i2 + 5] = b2;
                    bArr2[i2 + 6] = (byte) i5;
                    this.last = i2 + 5;
                    return;
            }
        }
        endBlock();
        initBlock();
        writeRun();
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            try {
                if (this.runLength > 0) {
                    writeRun();
                }
                this.currentChar = -1;
                endBlock();
                endCompression();
                outputStream.close();
                this.out = null;
                this.data = null;
            } catch (Throwable th) {
                this.out = null;
                this.data = null;
                throw th;
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    private void init() throws IOException {
        this.data = new Data(this.blockSize100k);
        bsPutUByte(104);
        bsPutUByte(48 + this.blockSize100k);
        this.combinedCRC = 0;
        initBlock();
    }

    private void initBlock() {
        this.crc.initialiseCRC();
        this.last = -1;
        boolean[] zArr = this.data.inUse;
        int i2 = 256;
        while (true) {
            i2--;
            if (i2 >= 0) {
                zArr[i2] = false;
            } else {
                this.allowableBlockSize = (this.blockSize100k * BZip2Constants.baseBlockSize) - 20;
                return;
            }
        }
    }

    private void endBlock() throws IOException {
        this.blockCRC = this.crc.getFinalCRC();
        this.combinedCRC = (this.combinedCRC << 1) | (this.combinedCRC >>> 31);
        this.combinedCRC ^= this.blockCRC;
        if (this.last == -1) {
            return;
        }
        blockSort();
        bsPutUByte(49);
        bsPutUByte(65);
        bsPutUByte(89);
        bsPutUByte(38);
        bsPutUByte(83);
        bsPutUByte(89);
        bsPutInt(this.blockCRC);
        if (this.blockRandomised) {
            bsW(1, 1);
        } else {
            bsW(1, 0);
        }
        moveToFrontCodeAndSend();
    }

    private void endCompression() throws IOException {
        bsPutUByte(23);
        bsPutUByte(114);
        bsPutUByte(69);
        bsPutUByte(56);
        bsPutUByte(80);
        bsPutUByte(144);
        bsPutInt(this.combinedCRC);
        bsFinishedWithStream();
    }

    public final int getBlockSize() {
        return this.blockSize100k;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("offs(" + i2 + ") < 0.");
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("len(" + i3 + ") < 0.");
        }
        if (i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException("offs(" + i2 + ") + len(" + i3 + ") > buf.length(" + bArr.length + ").");
        }
        if (this.out == null) {
            throw new IOException("stream closed");
        }
        int i4 = i2 + i3;
        while (i2 < i4) {
            int i5 = i2;
            i2++;
            write0(bArr[i5]);
        }
    }

    private void write0(int i2) throws IOException {
        if (this.currentChar != -1) {
            int i3 = i2 & 255;
            if (this.currentChar == i3) {
                int i4 = this.runLength + 1;
                this.runLength = i4;
                if (i4 > 254) {
                    writeRun();
                    this.currentChar = -1;
                    this.runLength = 0;
                    return;
                }
                return;
            }
            writeRun();
            this.runLength = 1;
            this.currentChar = i3;
            return;
        }
        this.currentChar = i2 & 255;
        this.runLength++;
    }

    private static void hbAssignCodes(int[] iArr, byte[] bArr, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = i2; i6 <= i3; i6++) {
            for (int i7 = 0; i7 < i4; i7++) {
                if ((bArr[i7] & 255) == i6) {
                    iArr[i7] = i5;
                    i5++;
                }
            }
            i5 <<= 1;
        }
    }

    private void bsFinishedWithStream() throws IOException {
        while (this.bsLive > 0) {
            this.out.write(this.bsBuff >> 24);
            this.bsBuff <<= 8;
            this.bsLive -= 8;
        }
    }

    private void bsW(int i2, int i3) throws IOException {
        OutputStream outputStream = this.out;
        int i4 = this.bsLive;
        int i5 = this.bsBuff;
        while (i4 >= 8) {
            outputStream.write(i5 >> 24);
            i5 <<= 8;
            i4 -= 8;
        }
        this.bsBuff = i5 | (i3 << ((32 - i4) - i2));
        this.bsLive = i4 + i2;
    }

    private void bsPutUByte(int i2) throws IOException {
        bsW(8, i2);
    }

    private void bsPutInt(int i2) throws IOException {
        bsW(8, (i2 >> 24) & 255);
        bsW(8, (i2 >> 16) & 255);
        bsW(8, (i2 >> 8) & 255);
        bsW(8, i2 & 255);
    }

    private void sendMTFValues() throws IOException {
        byte[][] bArr = this.data.sendMTFValues_len;
        int i2 = this.nInUse + 2;
        int i3 = 6;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            byte[] bArr2 = bArr[i3];
            int i4 = i2;
            while (true) {
                i4--;
                if (i4 >= 0) {
                    bArr2[i4] = 15;
                }
            }
        }
        int i5 = this.nMTF < 200 ? 2 : this.nMTF < 600 ? 3 : this.nMTF < 1200 ? 4 : this.nMTF < 2400 ? 5 : 6;
        sendMTFValues0(i5, i2);
        int sendMTFValues1 = sendMTFValues1(i5, i2);
        sendMTFValues2(i5, sendMTFValues1);
        sendMTFValues3(i5, i2);
        sendMTFValues4();
        sendMTFValues5(i5, sendMTFValues1);
        sendMTFValues6(i5, i2);
        sendMTFValues7(sendMTFValues1);
    }

    private void sendMTFValues0(int i2, int i3) {
        byte[][] bArr = this.data.sendMTFValues_len;
        int[] iArr = this.data.mtfFreq;
        int i4 = this.nMTF;
        int i5 = 0;
        for (int i6 = i2; i6 > 0; i6--) {
            int i7 = i4 / i6;
            int i8 = i5 - 1;
            int i9 = 0;
            int i10 = i3 - 1;
            while (i9 < i7 && i8 < i10) {
                i8++;
                i9 += iArr[i8];
            }
            if (i8 > i5 && i6 != i2 && i6 != 1 && ((i2 - i6) & 1) != 0) {
                int i11 = i8;
                i8 = i11 - 1;
                i9 -= iArr[i11];
            }
            byte[] bArr2 = bArr[i6 - 1];
            int i12 = i3;
            while (true) {
                i12--;
                if (i12 >= 0) {
                    if (i12 >= i5 && i12 <= i8) {
                        bArr2[i12] = 0;
                    } else {
                        bArr2[i12] = 15;
                    }
                }
            }
            i5 = i8 + 1;
            i4 -= i9;
        }
    }

    private int sendMTFValues1(int i2, int i3) {
        Data data = this.data;
        int[][] iArr = data.sendMTFValues_rfreq;
        int[] iArr2 = data.sendMTFValues_fave;
        short[] sArr = data.sendMTFValues_cost;
        char[] cArr = data.sfmap;
        byte[] bArr = data.selector;
        byte[][] bArr2 = data.sendMTFValues_len;
        byte[] bArr3 = bArr2[0];
        byte[] bArr4 = bArr2[1];
        byte[] bArr5 = bArr2[2];
        byte[] bArr6 = bArr2[3];
        byte[] bArr7 = bArr2[4];
        byte[] bArr8 = bArr2[5];
        int i4 = this.nMTF;
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = i2;
            while (true) {
                i7--;
                if (i7 < 0) {
                    break;
                }
                iArr2[i7] = 0;
                int[] iArr3 = iArr[i7];
                int i8 = i3;
                while (true) {
                    i8--;
                    if (i8 >= 0) {
                        iArr3[i8] = 0;
                    }
                }
            }
            i5 = 0;
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.nMTF) {
                    break;
                }
                int min = Math.min((i10 + 50) - 1, i4 - 1);
                if (i2 == 6) {
                    short s = 0;
                    short s2 = 0;
                    short s3 = 0;
                    short s4 = 0;
                    short s5 = 0;
                    short s6 = 0;
                    for (int i11 = i10; i11 <= min; i11++) {
                        char c2 = cArr[i11];
                        s = (short) (s + (bArr3[c2] & 255));
                        s2 = (short) (s2 + (bArr4[c2] & 255));
                        s3 = (short) (s3 + (bArr5[c2] & 255));
                        s4 = (short) (s4 + (bArr6[c2] & 255));
                        s5 = (short) (s5 + (bArr7[c2] & 255));
                        s6 = (short) (s6 + (bArr8[c2] & 255));
                    }
                    sArr[0] = s;
                    sArr[1] = s2;
                    sArr[2] = s3;
                    sArr[3] = s4;
                    sArr[4] = s5;
                    sArr[5] = s6;
                } else {
                    int i12 = i2;
                    while (true) {
                        i12--;
                        if (i12 < 0) {
                            break;
                        }
                        sArr[i12] = 0;
                    }
                    for (int i13 = i10; i13 <= min; i13++) {
                        char c3 = cArr[i13];
                        int i14 = i2;
                        while (true) {
                            i14--;
                            if (i14 >= 0) {
                                sArr[i14] = (short) (sArr[i14] + (bArr2[i14][c3] & 255));
                            }
                        }
                    }
                }
                int i15 = -1;
                int i16 = i2;
                short s7 = 999999999;
                while (true) {
                    i16--;
                    if (i16 < 0) {
                        break;
                    }
                    short s8 = sArr[i16];
                    if (s8 < s7) {
                        s7 = s8;
                        i15 = i16;
                    }
                }
                int i17 = i15;
                iArr2[i17] = iArr2[i17] + 1;
                bArr[i5] = (byte) i15;
                i5++;
                int[] iArr4 = iArr[i15];
                for (int i18 = i10; i18 <= min; i18++) {
                    char c4 = cArr[i18];
                    iArr4[c4] = iArr4[c4] + 1;
                }
                i9 = min + 1;
            }
            for (int i19 = 0; i19 < i2; i19++) {
                hbMakeCodeLengths(bArr2[i19], iArr[i19], this.data, i3, 20);
            }
        }
        return i5;
    }

    private void sendMTFValues2(int i2, int i3) {
        Data data = this.data;
        byte[] bArr = data.sendMTFValues2_pos;
        int i4 = i2;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            bArr[i4] = (byte) i4;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            byte b2 = data.selector[i5];
            byte b3 = bArr[0];
            int i6 = 0;
            while (b2 != b3) {
                i6++;
                byte b4 = b3;
                b3 = bArr[i6];
                bArr[i6] = b4;
            }
            bArr[0] = b3;
            data.selectorMtf[i5] = (byte) i6;
        }
    }

    private void sendMTFValues3(int i2, int i3) {
        int[][] iArr = this.data.sendMTFValues_code;
        byte[][] bArr = this.data.sendMTFValues_len;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 32;
            int i6 = 0;
            byte[] bArr2 = bArr[i4];
            int i7 = i3;
            while (true) {
                i7--;
                if (i7 >= 0) {
                    int i8 = bArr2[i7] & 255;
                    if (i8 > i6) {
                        i6 = i8;
                    }
                    if (i8 < i5) {
                        i5 = i8;
                    }
                }
            }
            hbAssignCodes(iArr[i4], bArr[i4], i5, i6, i3);
        }
    }

    private void sendMTFValues4() throws IOException {
        boolean[] zArr = this.data.inUse;
        boolean[] zArr2 = this.data.sentMTFValues4_inUse16;
        int i2 = 16;
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            zArr2[i2] = false;
            int i3 = i2 * 16;
            int i4 = 16;
            while (true) {
                i4--;
                if (i4 >= 0) {
                    if (zArr[i3 + i4]) {
                        zArr2[i2] = true;
                    }
                }
            }
        }
        for (int i5 = 0; i5 < 16; i5++) {
            bsW(1, zArr2[i5] ? 1 : 0);
        }
        OutputStream outputStream = this.out;
        int i6 = this.bsLive;
        int i7 = this.bsBuff;
        for (int i8 = 0; i8 < 16; i8++) {
            if (zArr2[i8]) {
                int i9 = i8 * 16;
                for (int i10 = 0; i10 < 16; i10++) {
                    while (i6 >= 8) {
                        outputStream.write(i7 >> 24);
                        i7 <<= 8;
                        i6 -= 8;
                    }
                    if (zArr[i9 + i10]) {
                        i7 |= 1 << ((32 - i6) - 1);
                    }
                    i6++;
                }
            }
        }
        this.bsBuff = i7;
        this.bsLive = i6;
    }

    private void sendMTFValues5(int i2, int i3) throws IOException {
        bsW(3, i2);
        bsW(15, i3);
        OutputStream outputStream = this.out;
        byte[] bArr = this.data.selectorMtf;
        int i4 = this.bsLive;
        int i5 = this.bsBuff;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = bArr[i6] & 255;
            for (int i8 = 0; i8 < i7; i8++) {
                while (i4 >= 8) {
                    outputStream.write(i5 >> 24);
                    i5 <<= 8;
                    i4 -= 8;
                }
                i5 |= 1 << ((32 - i4) - 1);
                i4++;
            }
            while (i4 >= 8) {
                outputStream.write(i5 >> 24);
                i5 <<= 8;
                i4 -= 8;
            }
            i4++;
        }
        this.bsBuff = i5;
        this.bsLive = i4;
    }

    private void sendMTFValues6(int i2, int i3) throws IOException {
        byte[][] bArr = this.data.sendMTFValues_len;
        OutputStream outputStream = this.out;
        int i4 = this.bsLive;
        int i5 = this.bsBuff;
        for (int i6 = 0; i6 < i2; i6++) {
            byte[] bArr2 = bArr[i6];
            int i7 = bArr2[0] & 255;
            while (i4 >= 8) {
                outputStream.write(i5 >> 24);
                i5 <<= 8;
                i4 -= 8;
            }
            i5 |= i7 << ((32 - i4) - 5);
            i4 += 5;
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = bArr2[i8] & 255;
                while (i7 < i9) {
                    while (i4 >= 8) {
                        outputStream.write(i5 >> 24);
                        i5 <<= 8;
                        i4 -= 8;
                    }
                    i5 |= 2 << ((32 - i4) - 2);
                    i4 += 2;
                    i7++;
                }
                while (i7 > i9) {
                    while (i4 >= 8) {
                        outputStream.write(i5 >> 24);
                        i5 <<= 8;
                        i4 -= 8;
                    }
                    i5 |= 3 << ((32 - i4) - 2);
                    i4 += 2;
                    i7--;
                }
                while (i4 >= 8) {
                    outputStream.write(i5 >> 24);
                    i5 <<= 8;
                    i4 -= 8;
                }
                i4++;
            }
        }
        this.bsBuff = i5;
        this.bsLive = i4;
    }

    private void sendMTFValues7(int i2) throws IOException {
        Data data = this.data;
        byte[][] bArr = data.sendMTFValues_len;
        int[][] iArr = data.sendMTFValues_code;
        OutputStream outputStream = this.out;
        byte[] bArr2 = data.selector;
        char[] cArr = data.sfmap;
        int i3 = this.nMTF;
        int i4 = 0;
        int i5 = this.bsLive;
        int i6 = this.bsBuff;
        int i7 = 0;
        while (i7 < i3) {
            int min = Math.min((i7 + 50) - 1, i3 - 1);
            int i8 = bArr2[i4] & 255;
            int[] iArr2 = iArr[i8];
            byte[] bArr3 = bArr[i8];
            while (i7 <= min) {
                char c2 = cArr[i7];
                while (i5 >= 8) {
                    outputStream.write(i6 >> 24);
                    i6 <<= 8;
                    i5 -= 8;
                }
                int i9 = bArr3[c2] & 255;
                i6 |= iArr2[c2] << ((32 - i5) - i9);
                i5 += i9;
                i7++;
            }
            i7 = min + 1;
            i4++;
        }
        this.bsBuff = i6;
        this.bsLive = i5;
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsW(24, this.origPtr);
        generateMTFValues();
        sendMTFValues();
    }

    private boolean mainSimpleSort(Data data, int i2, int i3, int i4) {
        int i5 = (i3 - i2) + 1;
        if (i5 < 2) {
            return this.firstAttempt && this.workDone > this.workLimit;
        }
        int i6 = 0;
        while (INCS[i6] < i5) {
            i6++;
        }
        int[] iArr = data.fmap;
        char[] cArr = data.quadrant;
        byte[] bArr = data.block;
        int i7 = this.last;
        int i8 = i7 + 1;
        boolean z = this.firstAttempt;
        int i9 = this.workLimit;
        int i10 = this.workDone;
        loop1: while (true) {
            i6--;
            if (i6 < 0) {
                break;
            }
            int i11 = INCS[i6];
            int i12 = (i2 + i11) - 1;
            int i13 = i2 + i11;
            while (i13 <= i3) {
                int i14 = 3;
                while (i13 <= i3) {
                    i14--;
                    if (i14 < 0) {
                        break;
                    }
                    int i15 = iArr[i13];
                    int i16 = i15 + i4;
                    int i17 = i13;
                    boolean z2 = false;
                    int i18 = 0;
                    while (true) {
                        if (z2) {
                            iArr[i17] = i18;
                            int i19 = i17 - i11;
                            i17 = i19;
                            if (i19 <= i12) {
                                break;
                            }
                        } else {
                            z2 = true;
                        }
                        i18 = iArr[i17 - i11];
                        int i20 = i18 + i4;
                        if (bArr[i20 + 1] == bArr[i16 + 1]) {
                            if (bArr[i20 + 2] == bArr[i16 + 2]) {
                                if (bArr[i20 + 3] == bArr[i16 + 3]) {
                                    if (bArr[i20 + 4] == bArr[i16 + 4]) {
                                        if (bArr[i20 + 5] == bArr[i16 + 5]) {
                                            int i21 = i20 + 6;
                                            int i22 = i16 + 6;
                                            if (bArr[i21] == bArr[i22]) {
                                                int i23 = i7;
                                                while (true) {
                                                    if (i23 > 0) {
                                                        i23 -= 4;
                                                        if (bArr[i21 + 1] == bArr[i22 + 1]) {
                                                            if (cArr[i21] == cArr[i22]) {
                                                                if (bArr[i21 + 2] == bArr[i22 + 2]) {
                                                                    if (cArr[i21 + 1] == cArr[i22 + 1]) {
                                                                        if (bArr[i21 + 3] == bArr[i22 + 3]) {
                                                                            if (cArr[i21 + 2] == cArr[i22 + 2]) {
                                                                                if (bArr[i21 + 4] == bArr[i22 + 4]) {
                                                                                    if (cArr[i21 + 3] == cArr[i22 + 3]) {
                                                                                        i21 += 4;
                                                                                        if (i21 >= i8) {
                                                                                            i21 -= i8;
                                                                                        }
                                                                                        i22 += 4;
                                                                                        if (i22 >= i8) {
                                                                                            i22 -= i8;
                                                                                        }
                                                                                        i10++;
                                                                                    } else if (cArr[i21 + 3] > cArr[i22 + 3]) {
                                                                                    }
                                                                                } else if ((bArr[i21 + 4] & 255) > (bArr[i22 + 4] & 255)) {
                                                                                }
                                                                            } else if (cArr[i21 + 2] > cArr[i22 + 2]) {
                                                                            }
                                                                        } else if ((bArr[i21 + 3] & 255) > (bArr[i22 + 3] & 255)) {
                                                                        }
                                                                    } else if (cArr[i21 + 1] > cArr[i22 + 1]) {
                                                                    }
                                                                } else if ((bArr[i21 + 2] & 255) > (bArr[i22 + 2] & 255)) {
                                                                }
                                                            } else if (cArr[i21] > cArr[i22]) {
                                                            }
                                                        } else if ((bArr[i21 + 1] & 255) > (bArr[i22 + 1] & 255)) {
                                                        }
                                                    }
                                                }
                                            } else if ((bArr[i21] & 255) > (bArr[i22] & 255)) {
                                            }
                                        } else if ((bArr[i20 + 5] & 255) > (bArr[i16 + 5] & 255)) {
                                        }
                                    } else if ((bArr[i20 + 4] & 255) > (bArr[i16 + 4] & 255)) {
                                    }
                                } else if ((bArr[i20 + 3] & 255) > (bArr[i16 + 3] & 255)) {
                                }
                            } else if ((bArr[i20 + 2] & 255) > (bArr[i16 + 2] & 255)) {
                            }
                        } else if ((bArr[i20 + 1] & 255) > (bArr[i16 + 1] & 255)) {
                        }
                    }
                    iArr[i17] = i15;
                    i13++;
                }
                if (z && i13 <= i3 && i10 > i9) {
                    break loop1;
                }
            }
        }
        this.workDone = i10;
        return z && i10 > i9;
    }

    private static void vswap(int[] iArr, int i2, int i3, int i4) {
        int i5 = i4 + i2;
        while (i2 < i5) {
            int i6 = iArr[i2];
            int i7 = i2;
            i2++;
            iArr[i7] = iArr[i3];
            int i8 = i3;
            i3++;
            iArr[i8] = i6;
        }
    }

    private static byte med3(byte b2, byte b3, byte b4) {
        return b2 < b3 ? b3 < b4 ? b3 : b2 < b4 ? b4 : b2 : b3 > b4 ? b3 : b2 > b4 ? b4 : b2;
    }

    private void blockSort() {
        this.workLimit = 30 * this.last;
        this.workDone = 0;
        this.blockRandomised = false;
        this.firstAttempt = true;
        mainSort();
        if (this.firstAttempt && this.workDone > this.workLimit) {
            randomiseBlock();
            this.workDone = 0;
            this.workLimit = 0;
            this.firstAttempt = false;
            mainSort();
        }
        int[] iArr = this.data.fmap;
        this.origPtr = -1;
        int i2 = this.last;
        for (int i3 = 0; i3 <= i2; i3++) {
            if (iArr[i3] == 0) {
                this.origPtr = i3;
                return;
            }
        }
    }

    private void mainQSort3(Data data, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr = data.stack_ll;
        int[] iArr2 = data.stack_hh;
        int[] iArr3 = data.stack_dd;
        int[] iArr4 = data.fmap;
        byte[] bArr = data.block;
        iArr[0] = i2;
        iArr2[0] = i3;
        iArr3[0] = i4;
        int i7 = 1;
        while (true) {
            i7--;
            if (i7 >= 0) {
                int i8 = iArr[i7];
                int i9 = iArr2[i7];
                int i10 = iArr3[i7];
                if (i9 - i8 < 20 || i10 > 10) {
                    if (mainSimpleSort(data, i8, i9, i10)) {
                        return;
                    }
                } else {
                    int i11 = i10 + 1;
                    int med3 = med3(bArr[iArr4[i8] + i11], bArr[iArr4[i9] + i11], bArr[iArr4[(i8 + i9) >> 1] + i11]) & 255;
                    int i12 = i8;
                    int i13 = i9;
                    int i14 = i8;
                    int i15 = i9;
                    while (true) {
                        if (i12 <= i13) {
                            int i16 = (bArr[iArr4[i12] + i11] & 255) - med3;
                            if (i16 == 0) {
                                int i17 = iArr4[i12];
                                int i18 = i12;
                                i12++;
                                iArr4[i18] = iArr4[i14];
                                int i19 = i14;
                                i14++;
                                iArr4[i19] = i17;
                            } else if (i16 < 0) {
                                i12++;
                            }
                        }
                        while (i12 <= i13) {
                            int i20 = (bArr[iArr4[i13] + i11] & 255) - med3;
                            if (i20 != 0) {
                                if (i20 <= 0) {
                                    break;
                                }
                                i13--;
                            } else {
                                int i21 = iArr4[i13];
                                int i22 = i13;
                                i13 = i22 - 1;
                                iArr4[i22] = iArr4[i15];
                                int i23 = i15;
                                i15 = i23 - 1;
                                iArr4[i23] = i21;
                            }
                        }
                        if (i12 > i13) {
                            break;
                        }
                        int i24 = iArr4[i12];
                        int i25 = i12;
                        i12++;
                        iArr4[i25] = iArr4[i13];
                        int i26 = i13;
                        i13 = i26 - 1;
                        iArr4[i26] = i24;
                    }
                    if (i15 < i14) {
                        iArr[i7] = i8;
                        iArr2[i7] = i9;
                        iArr3[i7] = i11;
                        i7++;
                    } else {
                        int i27 = i14 - i8 < i12 - i14 ? i14 - i8 : i12 - i14;
                        vswap(iArr4, i8, i12 - i27, i27);
                        if (i9 - i15 < i15 - i13) {
                            i5 = i9;
                            i6 = i15;
                        } else {
                            i5 = i15;
                            i6 = i13;
                        }
                        int i28 = i5 - i6;
                        vswap(iArr4, i12, (i9 - i28) + 1, i28);
                        int i29 = ((i8 + i12) - i14) - 1;
                        int i30 = (i9 - (i15 - i13)) + 1;
                        iArr[i7] = i8;
                        iArr2[i7] = i29;
                        iArr3[i7] = i10;
                        int i31 = i7 + 1;
                        iArr[i31] = i29 + 1;
                        iArr2[i31] = i30 - 1;
                        iArr3[i31] = i11;
                        int i32 = i31 + 1;
                        iArr[i32] = i30;
                        iArr2[i32] = i9;
                        iArr3[i32] = i10;
                        i7 = i32 + 1;
                    }
                }
            } else {
                return;
            }
        }
    }

    private void mainSort() {
        Data data = this.data;
        int[] iArr = data.mainSort_runningOrder;
        int[] iArr2 = data.mainSort_copy;
        boolean[] zArr = data.mainSort_bigDone;
        int[] iArr3 = data.ftab;
        byte[] bArr = data.block;
        int[] iArr4 = data.fmap;
        char[] cArr = data.quadrant;
        int i2 = this.last;
        int i3 = this.workLimit;
        boolean z = this.firstAttempt;
        int i4 = 65537;
        while (true) {
            i4--;
            if (i4 < 0) {
                break;
            }
            iArr3[i4] = 0;
        }
        for (int i5 = 0; i5 < 20; i5++) {
            bArr[i2 + i5 + 2] = bArr[(i5 % (i2 + 1)) + 1];
        }
        int i6 = i2 + 20;
        while (true) {
            i6--;
            if (i6 < 0) {
                break;
            }
            cArr[i6] = 0;
        }
        bArr[0] = bArr[i2 + 1];
        int i7 = bArr[0] & 255;
        for (int i8 = 0; i8 <= i2; i8++) {
            int i9 = bArr[i8 + 1] & 255;
            int i10 = (i7 << 8) + i9;
            iArr3[i10] = iArr3[i10] + 1;
            i7 = i9;
        }
        for (int i11 = 1; i11 <= 65536; i11++) {
            int i12 = i11;
            iArr3[i12] = iArr3[i12] + iArr3[i11 - 1];
        }
        int i13 = bArr[1] & 255;
        for (int i14 = 0; i14 < i2; i14++) {
            int i15 = bArr[i14 + 2] & 255;
            int i16 = (i13 << 8) + i15;
            int i17 = iArr3[i16] - 1;
            iArr3[i16] = i17;
            iArr4[i17] = i14;
            i13 = i15;
        }
        int i18 = ((bArr[i2 + 1] & 255) << 8) + (bArr[1] & 255);
        int i19 = iArr3[i18] - 1;
        iArr3[i18] = i19;
        iArr4[i19] = i2;
        int i20 = 256;
        while (true) {
            i20--;
            if (i20 < 0) {
                break;
            }
            zArr[i20] = false;
            iArr[i20] = i20;
        }
        int i21 = 364;
        while (i21 != 1) {
            i21 /= 3;
            for (int i22 = i21; i22 <= 255; i22++) {
                int i23 = iArr[i22];
                int i24 = iArr3[(i23 + 1) << 8] - iArr3[i23 << 8];
                int i25 = i21 - 1;
                int i26 = i22;
                int i27 = iArr[i26 - i21];
                while (true) {
                    int i28 = i27;
                    if (iArr3[(i28 + 1) << 8] - iArr3[i28 << 8] > i24) {
                        iArr[i26] = i28;
                        i26 -= i21;
                        if (i26 <= i25) {
                            break;
                        }
                        i27 = iArr[i26 - i21];
                    }
                }
                iArr[i26] = i23;
            }
        }
        for (int i29 = 0; i29 <= 255; i29++) {
            int i30 = iArr[i29];
            for (int i31 = 0; i31 <= 255; i31++) {
                int i32 = (i30 << 8) + i31;
                int i33 = iArr3[i32];
                if ((i33 & SETMASK) != SETMASK) {
                    int i34 = i33 & CLEARMASK;
                    int i35 = (iArr3[i32 + 1] & CLEARMASK) - 1;
                    if (i35 > i34) {
                        mainQSort3(data, i34, i35, 2);
                        if (z && this.workDone > i3) {
                            return;
                        }
                    }
                    iArr3[i32] = i33 | SETMASK;
                }
            }
            for (int i36 = 0; i36 <= 255; i36++) {
                iArr2[i36] = iArr3[(i36 << 8) + i30] & CLEARMASK;
            }
            int i37 = iArr3[(i30 + 1) << 8] & CLEARMASK;
            for (int i38 = iArr3[i30 << 8] & CLEARMASK; i38 < i37; i38++) {
                int i39 = iArr4[i38];
                int i40 = bArr[i39] & 255;
                if (!zArr[i40]) {
                    iArr4[iArr2[i40]] = i39 == 0 ? i2 : i39 - 1;
                    iArr2[i40] = iArr2[i40] + 1;
                }
            }
            int i41 = 256;
            while (true) {
                i41--;
                if (i41 < 0) {
                    break;
                }
                int i42 = (i41 << 8) + i30;
                iArr3[i42] = iArr3[i42] | SETMASK;
            }
            zArr[i30] = true;
            if (i29 < 255) {
                int i43 = iArr3[i30 << 8] & CLEARMASK;
                int i44 = (iArr3[(i30 + 1) << 8] & CLEARMASK) - i43;
                int i45 = 0;
                while ((i44 >> i45) > 65534) {
                    i45++;
                }
                for (int i46 = 0; i46 < i44; i46++) {
                    int i47 = iArr4[i43 + i46];
                    char c2 = (char) (i46 >> i45);
                    cArr[i47] = c2;
                    if (i47 < 20) {
                        cArr[i47 + i2 + 1] = c2;
                    }
                }
            }
        }
    }

    private void randomiseBlock() {
        boolean[] zArr = this.data.inUse;
        byte[] bArr = this.data.block;
        int i2 = this.last;
        int i3 = 256;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            zArr[i3] = false;
        }
        char c2 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i5 <= i2) {
            if (c2 == 0) {
                c2 = (char) BZip2Constants.rNums[i4];
                i4++;
                if (i4 == 512) {
                    i4 = 0;
                }
            }
            c2--;
            int i7 = i6;
            bArr[i7] = (byte) (bArr[i7] ^ (c2 == 1 ? (byte) 1 : (byte) 0));
            zArr[bArr[i6] & 255] = true;
            i5 = i6;
            i6++;
        }
        this.blockRandomised = true;
    }

    private void generateMTFValues() {
        int i2 = this.last;
        Data data = this.data;
        boolean[] zArr = data.inUse;
        byte[] bArr = data.block;
        int[] iArr = data.fmap;
        char[] cArr = data.sfmap;
        int[] iArr2 = data.mtfFreq;
        byte[] bArr2 = data.unseqToSeq;
        byte[] bArr3 = data.generateMTFValues_yy;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            if (zArr[i4]) {
                bArr2[i4] = (byte) i3;
                i3++;
            }
        }
        this.nInUse = i3;
        int i5 = i3 + 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            iArr2[i6] = 0;
        }
        int i7 = i3;
        while (true) {
            i7--;
            if (i7 < 0) {
                break;
            }
            bArr3[i7] = (byte) i7;
        }
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 <= i2; i10++) {
            byte b2 = bArr2[bArr[iArr[i10]] & 255];
            byte b3 = bArr3[0];
            int i11 = 0;
            while (b2 != b3) {
                i11++;
                byte b4 = b3;
                b3 = bArr3[i11];
                bArr3[i11] = b4;
            }
            bArr3[0] = b3;
            if (i11 == 0) {
                i9++;
            } else {
                if (i9 > 0) {
                    int i12 = i9 - 1;
                    while (true) {
                        if ((i12 & 1) == 0) {
                            cArr[i8] = 0;
                            i8++;
                            iArr2[0] = iArr2[0] + 1;
                        } else {
                            cArr[i8] = 1;
                            i8++;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i12 < 2) {
                            break;
                        }
                        i12 = (i12 - 2) >> 1;
                    }
                    i9 = 0;
                }
                cArr[i8] = (char) (i11 + 1);
                i8++;
                int i13 = i11 + 1;
                iArr2[i13] = iArr2[i13] + 1;
            }
        }
        if (i9 > 0) {
            int i14 = i9 - 1;
            while (true) {
                if ((i14 & 1) == 0) {
                    cArr[i8] = 0;
                    i8++;
                    iArr2[0] = iArr2[0] + 1;
                } else {
                    cArr[i8] = 1;
                    i8++;
                    iArr2[1] = iArr2[1] + 1;
                }
                if (i14 < 2) {
                    break;
                }
                i14 = (i14 - 2) >> 1;
            }
        }
        cArr[i8] = (char) i5;
        iArr2[i5] = iArr2[i5] + 1;
        this.nMTF = i8 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/apache-ant-1.7.0-bzip2.jar:org/apache/tools/bzip2/CBZip2OutputStream$Data.class */
    public static final class Data {
        final boolean[] inUse = new boolean[256];
        final byte[] unseqToSeq = new byte[256];
        final int[] mtfFreq = new int[BZip2Constants.MAX_ALPHA_SIZE];
        final byte[] selector = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] generateMTFValues_yy = new byte[256];
        final byte[][] sendMTFValues_len = new byte[6][BZip2Constants.MAX_ALPHA_SIZE];
        final int[][] sendMTFValues_rfreq = new int[6][BZip2Constants.MAX_ALPHA_SIZE];
        final int[] sendMTFValues_fave = new int[6];
        final short[] sendMTFValues_cost = new short[6];
        final int[][] sendMTFValues_code = new int[6][BZip2Constants.MAX_ALPHA_SIZE];
        final byte[] sendMTFValues2_pos = new byte[6];
        final boolean[] sentMTFValues4_inUse16 = new boolean[16];
        final int[] stack_ll = new int[CBZip2OutputStream.QSORT_STACK_SIZE];
        final int[] stack_hh = new int[CBZip2OutputStream.QSORT_STACK_SIZE];
        final int[] stack_dd = new int[CBZip2OutputStream.QSORT_STACK_SIZE];
        final int[] mainSort_runningOrder = new int[256];
        final int[] mainSort_copy = new int[256];
        final boolean[] mainSort_bigDone = new boolean[256];
        final int[] heap = new int[260];
        final int[] weight = new int[516];
        final int[] parent = new int[516];
        final int[] ftab = new int[65537];
        final byte[] block;
        final int[] fmap;
        final char[] sfmap;
        final char[] quadrant;

        Data(int i2) {
            int i3 = i2 * BZip2Constants.baseBlockSize;
            this.block = new byte[i3 + 1 + 20];
            this.fmap = new int[i3];
            this.sfmap = new char[2 * i3];
            this.quadrant = this.sfmap;
        }
    }
}
