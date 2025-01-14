package p192f;

import com.j256.ormlite.logger.Logger;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* renamed from: f.c */
/* loaded from: classes.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable {

    /* renamed from: c */
    public static final byte[] f8448c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a */
    public Segment f8449a;

    /* renamed from: b */
    public long f8450b;

    /* compiled from: Buffer.java */
    /* renamed from: f.c$a */
    /* loaded from: classes.dex */
    public class C1820a extends OutputStream {
        public C1820a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return Buffer.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            Buffer.this.writeByte((int) ((byte) i));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            Buffer.this.write(bArr, i, i2);
        }
    }

    /* compiled from: Buffer.java */
    /* renamed from: f.c$b */
    /* loaded from: classes.dex */
    public class C1821b extends InputStream {
        public C1821b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(Buffer.this.f8450b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            Buffer buffer = Buffer.this;
            if (buffer.f8450b > 0) {
                return buffer.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return Buffer.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return Buffer.this.m2619a(bArr, i, i2);
        }
    }

    @Override // p192f.BufferedSource, p192f.BufferedSink
    /* renamed from: a */
    public Buffer mo2569a() {
        return this;
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public /* bridge */ /* synthetic */ BufferedSink mo2575a(C1822f c1822f) {
        mo2575a(c1822f);
        return this;
    }

    @Override // p192f.BufferedSource
    /* renamed from: b */
    public C1822f mo2562b(long j) {
        return new C1822f(mo2560c(j));
    }

    @Override // p192f.BufferedSource
    /* renamed from: c */
    public String mo2561c() {
        return m2613j(Long.MAX_VALUE);
    }

    @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // p192f.BufferedSource
    /* renamed from: d */
    public void mo2558d(long j) {
        if (this.f8450b < j) {
            throw new EOFException();
        }
    }

    @Override // p192f.BufferedSink
    /* renamed from: e */
    public /* bridge */ /* synthetic */ BufferedSink mo2572e(long j) {
        mo2572e(j);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            long j = this.f8450b;
            if (j != buffer.f8450b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            Segment segment = this.f8449a;
            Segment segment2 = buffer.f8449a;
            int i = segment.f8483b;
            int i2 = segment2.f8483b;
            while (j2 < this.f8450b) {
                long min = Math.min(segment.f8484c - i, segment2.f8484c - i2);
                int i3 = i2;
                int i4 = i;
                int i5 = 0;
                while (i5 < min) {
                    int i6 = i4 + 1;
                    int i7 = i3 + 1;
                    if (segment.f8482a[i4] != segment2.f8482a[i3]) {
                        return false;
                    }
                    i5++;
                    i4 = i6;
                    i3 = i7;
                }
                if (i4 == segment.f8484c) {
                    segment = segment.f8487f;
                    i = segment.f8483b;
                } else {
                    i = i4;
                }
                if (i3 == segment2.f8484c) {
                    segment2 = segment2.f8487f;
                    i2 = segment2.f8483b;
                } else {
                    i2 = i3;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // p192f.BufferedSink
    /* renamed from: f */
    public /* bridge */ /* synthetic */ BufferedSink mo2571f(long j) {
        mo2571f(j);
        return this;
    }

    @Override // p192f.BufferedSink, p192f.Sink, java.io.Flushable
    public void flush() {
    }

    /* renamed from: g */
    public byte m2616g(long j) {
        C1828t.m2518a(this.f8450b, j, 1L);
        Segment segment = this.f8449a;
        while (true) {
            int i = segment.f8484c;
            int i2 = segment.f8483b;
            long j2 = i - i2;
            if (j < j2) {
                return segment.f8482a[i2 + ((int) j)];
            }
            j -= j2;
            segment = segment.f8487f;
        }
    }

    @Override // p192f.BufferedSource
    /* renamed from: h */
    public InputStream mo2553h() {
        return new C1821b();
    }

    public int hashCode() {
        Segment segment = this.f8449a;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.f8484c;
            for (int i3 = segment.f8483b; i3 < i2; i3++) {
                i = (i * 31) + segment.f8482a[i3];
            }
            segment = segment.f8487f;
        } while (segment != this.f8449a);
        return i;
    }

    @Override // p192f.BufferedSink
    /* renamed from: i */
    public Buffer mo2570i() {
        return this;
    }

    @Override // p192f.BufferedSink
    /* renamed from: i */
    public /* bridge */ /* synthetic */ BufferedSink mo2570i() {
        mo2570i();
        return this;
    }

    /* renamed from: j */
    public String m2613j(long j) {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long m2626a = m2626a((byte) 10, 0L, j2);
            if (m2626a != -1) {
                return m2614i(m2626a);
            }
            if (j2 < m2605s() && m2616g(j2 - 1) == 13 && m2616g(j2) == 10) {
                return m2614i(j2);
            }
            Buffer buffer = new Buffer();
            m2622a(buffer, 0L, Math.min(32L, m2605s()));
            throw new EOFException("\\n not found: limit=" + Math.min(m2605s(), j) + " content=" + buffer.m2608p().mo2538c() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    /* renamed from: l */
    public void m2612l() {
        try {
            skip(this.f8450b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: m */
    public long m2611m() {
        long j = this.f8450b;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.f8449a.f8488g;
        int i = segment.f8484c;
        return (i >= 8192 || !segment.f8486e) ? j : j - (i - segment.f8483b);
    }

    /* renamed from: n */
    public OutputStream m2610n() {
        return new C1820a();
    }

    /* renamed from: o */
    public byte[] m2609o() {
        try {
            return mo2560c(this.f8450b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: p */
    public C1822f m2608p() {
        return new C1822f(m2609o());
    }

    /* renamed from: q */
    public String m2607q() {
        try {
            return m2623a(this.f8450b, C1828t.f8497a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: r */
    public int m2606r() {
        int i;
        int i2;
        int i3;
        if (this.f8450b != 0) {
            byte m2616g = m2616g(0L);
            if ((m2616g & 128) == 0) {
                i = m2616g & Byte.MAX_VALUE;
                i2 = 1;
                i3 = 0;
            } else if ((m2616g & 224) == 192) {
                i = m2616g & 31;
                i2 = 2;
                i3 = Logger.DEFAULT_FULL_MESSAGE_LENGTH;
            } else if ((m2616g & 240) == 224) {
                i = m2616g & 15;
                i2 = 3;
                i3 = 2048;
            } else if ((m2616g & 248) != 240) {
                skip(1L);
                return 65533;
            } else {
                i = m2616g & 7;
                i2 = 4;
                i3 = 65536;
            }
            long j = i2;
            if (this.f8450b >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = i4;
                    byte m2616g2 = m2616g(j2);
                    if ((m2616g2 & 192) != 128) {
                        skip(j2);
                        return 65533;
                    }
                    i = (i << 6) | (m2616g2 & 63);
                }
                skip(j);
                if (i > 1114111) {
                    return 65533;
                }
                if ((i < 55296 || i > 57343) && i >= i3) {
                    return i;
                }
                return 65533;
            }
            throw new EOFException("size < " + i2 + ": " + this.f8450b + " (to read code point prefixed 0x" + Integer.toHexString(m2616g) + ")");
        }
        throw new EOFException();
    }

    @Override // p192f.BufferedSource
    public byte readByte() {
        long j = this.f8450b;
        if (j != 0) {
            Segment segment = this.f8449a;
            int i = segment.f8483b;
            int i2 = segment.f8484c;
            int i3 = i + 1;
            byte b = segment.f8482a[i];
            this.f8450b = j - 1;
            if (i3 == i2) {
                this.f8449a = segment.m2548b();
                SegmentPool.m2546a(segment);
            } else {
                segment.f8483b = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // p192f.BufferedSource
    public void readFully(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int m2619a = m2619a(bArr, i, bArr.length - i);
            if (m2619a == -1) {
                throw new EOFException();
            }
            i += m2619a;
        }
    }

    @Override // p192f.BufferedSource
    public int readInt() {
        long j = this.f8450b;
        if (j >= 4) {
            Segment segment = this.f8449a;
            int i = segment.f8483b;
            int i2 = segment.f8484c;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.f8482a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.f8450b = j - 4;
            if (i8 == i2) {
                this.f8449a = segment.m2548b();
                SegmentPool.m2546a(segment);
            } else {
                segment.f8483b = i8;
            }
            return i9;
        }
        throw new IllegalStateException("size < 4: " + this.f8450b);
    }

    @Override // p192f.BufferedSource
    public short readShort() {
        long j = this.f8450b;
        if (j >= 2) {
            Segment segment = this.f8449a;
            int i = segment.f8483b;
            int i2 = segment.f8484c;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.f8482a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f8450b = j - 2;
            if (i4 == i2) {
                this.f8449a = segment.m2548b();
                SegmentPool.m2546a(segment);
            } else {
                segment.f8483b = i4;
            }
            return (short) i5;
        }
        throw new IllegalStateException("size < 2: " + this.f8450b);
    }

    /* renamed from: s */
    public long m2605s() {
        return this.f8450b;
    }

    @Override // p192f.BufferedSource
    public void skip(long j) {
        Segment segment;
        while (j > 0) {
            if (this.f8449a != null) {
                int min = (int) Math.min(j, segment.f8484c - segment.f8483b);
                long j2 = min;
                this.f8450b -= j2;
                j -= j2;
                Segment segment2 = this.f8449a;
                segment2.f8483b += min;
                if (segment2.f8483b == segment2.f8484c) {
                    this.f8449a = segment2.m2548b();
                    SegmentPool.m2546a(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: t */
    public C1822f m2604t() {
        long j = this.f8450b;
        if (j <= 2147483647L) {
            return m2625a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f8450b);
    }

    public String toString() {
        return m2604t().toString();
    }

    @Override // p192f.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr) {
        write(bArr);
        return this;
    }

    @Override // p192f.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int i) {
        writeByte(i);
        return this;
    }

    @Override // p192f.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int i) {
        writeInt(i);
        return this;
    }

    @Override // p192f.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int i) {
        writeShort(i);
        return this;
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public /* bridge */ /* synthetic */ BufferedSink mo2573a(String str) {
        mo2573a(str);
        return this;
    }

    /* renamed from: b */
    public Segment m2618b(int i) {
        if (i >= 1 && i <= 8192) {
            Segment segment = this.f8449a;
            if (segment == null) {
                this.f8449a = SegmentPool.m2547a();
                Segment segment2 = this.f8449a;
                segment2.f8488g = segment2;
                segment2.f8487f = segment2;
                return segment2;
            }
            Segment segment3 = segment.f8488g;
            if (segment3.f8484c + i > 8192 || !segment3.f8486e) {
                Segment m2547a = SegmentPool.m2547a();
                segment3.m2550a(m2547a);
                return m2547a;
            }
            return segment3;
        }
        throw new IllegalArgumentException();
    }

    @Override // p192f.BufferedSource
    /* renamed from: c */
    public byte[] mo2560c(long j) {
        C1828t.m2518a(this.f8450b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    /* renamed from: clone */
    public Buffer m11332clone() {
        Buffer buffer = new Buffer();
        if (this.f8450b == 0) {
            return buffer;
        }
        buffer.f8449a = new Segment(this.f8449a);
        Segment segment = buffer.f8449a;
        segment.f8488g = segment;
        segment.f8487f = segment;
        Segment segment2 = this.f8449a;
        while (true) {
            segment2 = segment2.f8487f;
            if (segment2 != this.f8449a) {
                buffer.f8449a.f8488g.m2550a(new Segment(segment2));
            } else {
                buffer.f8450b = this.f8450b;
                return buffer;
            }
        }
    }

    @Override // p192f.BufferedSource
    /* renamed from: d */
    public int mo2559d() {
        return C1828t.m2519a(readInt());
    }

    @Override // p192f.BufferedSource
    /* renamed from: e */
    public boolean mo2557e() {
        return this.f8450b == 0;
    }

    @Override // p192f.BufferedSource
    /* renamed from: f */
    public short mo2555f() {
        return C1828t.m2516a(readShort());
    }

    /* renamed from: h */
    public String m2615h(long j) {
        return m2623a(j, C1828t.f8497a);
    }

    /* renamed from: i */
    public String m2614i(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (m2616g(j2) == 13) {
                String m2615h = m2615h(j2);
                skip(2L);
                return m2615h;
            }
        }
        String m2615h2 = m2615h(j);
        skip(1L);
        return m2615h2;
    }

    @Override // p192f.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr, int i, int i2) {
        write(bArr, i, i2);
        return this;
    }

    @Override // p192f.BufferedSink
    public Buffer writeByte(int i) {
        Segment m2618b = m2618b(1);
        byte[] bArr = m2618b.f8482a;
        int i2 = m2618b.f8484c;
        m2618b.f8484c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f8450b++;
        return this;
    }

    @Override // p192f.BufferedSink
    public Buffer writeInt(int i) {
        Segment m2618b = m2618b(4);
        byte[] bArr = m2618b.f8482a;
        int i2 = m2618b.f8484c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        m2618b.f8484c = i5 + 1;
        this.f8450b += 4;
        return this;
    }

    @Override // p192f.BufferedSink
    public Buffer writeShort(int i) {
        Segment m2618b = m2618b(2);
        byte[] bArr = m2618b.f8482a;
        int i2 = m2618b.f8484c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        m2618b.f8484c = i3 + 1;
        this.f8450b += 2;
        return this;
    }

    @Override // p192f.BufferedSource
    /* renamed from: a */
    public boolean mo2566a(long j) {
        return this.f8450b >= j;
    }

    @Override // p192f.BufferedSink
    /* renamed from: e */
    public Buffer mo2572e(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment m2618b = m2618b(numberOfTrailingZeros);
        byte[] bArr = m2618b.f8482a;
        int i = m2618b.f8484c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f8448c[(int) (15 & j)];
            j >>>= 4;
        }
        m2618b.f8484c += numberOfTrailingZeros;
        this.f8450b += numberOfTrailingZeros;
        return this;
    }

    @Override // p192f.BufferedSink
    /* renamed from: f */
    public Buffer mo2571f(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i == 0) {
            writeByte(48);
            return this;
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                mo2573a("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment m2618b = m2618b(i2);
        byte[] bArr = m2618b.f8482a;
        int i3 = m2618b.f8484c + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = f8448c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        m2618b.f8484c += i2;
        this.f8450b += i2;
        return this;
    }

    @Override // p192f.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public Buffer m2622a(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            C1828t.m2518a(this.f8450b, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.f8450b += j2;
            Segment segment = this.f8449a;
            while (true) {
                int i = segment.f8484c;
                int i2 = segment.f8483b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                segment = segment.f8487f;
            }
            while (j2 > 0) {
                Segment segment2 = new Segment(segment);
                segment2.f8483b = (int) (segment2.f8483b + j);
                segment2.f8484c = Math.min(segment2.f8483b + ((int) j2), segment2.f8484c);
                Segment segment3 = buffer.f8449a;
                if (segment3 == null) {
                    segment2.f8488g = segment2;
                    segment2.f8487f = segment2;
                    buffer.f8449a = segment2;
                } else {
                    segment3.f8488g.m2550a(segment2);
                }
                j2 -= segment2.f8484c - segment2.f8483b;
                segment = segment.f8487f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // p192f.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            C1828t.m2518a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment m2618b = m2618b(1);
                int min = Math.min(i3 - i, 8192 - m2618b.f8484c);
                System.arraycopy(bArr, i, m2618b.f8482a, m2618b.f8484c, min);
                i += min;
                m2618b.f8484c += min;
            }
            this.f8450b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: c */
    public Buffer m2617c(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                writeByte(63);
            } else {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                writeByte((i & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
            writeByte(((i >> 6) & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
            writeByte((i & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3 A[EDGE_INSN: B:42:0x00a3->B:38:0x00a3 ?: BREAK  , SYNTHETIC] */
    @Override // p192f.BufferedSource
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo2554g() {
        /*
            r15 = this;
            long r0 = r15.f8450b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Laa
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            f.n r6 = r15.f8449a
            byte[] r7 = r6.f8482a
            int r8 = r6.f8483b
            int r9 = r6.f8484c
        L13:
            if (r8 >= r9) goto L8f
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L70
            r11 = 70
            if (r10 > r11) goto L70
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4a:
            f.c r0 = new f.c
            r0.<init>()
            r0.mo2572e(r4)
            r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.m2607q()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L70:
            if (r1 == 0) goto L74
            r0 = 1
            goto L8f
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8f:
            if (r8 != r9) goto L9b
            f.n r7 = r6.m2548b()
            r15.f8449a = r7
            p192f.SegmentPool.m2546a(r6)
            goto L9d
        L9b:
            r6.f8483b = r8
        L9d:
            if (r0 != 0) goto La3
            f.n r6 = r15.f8449a
            if (r6 != 0) goto Lb
        La3:
            long r2 = r15.f8450b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f8450b = r2
            return r4
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p192f.Buffer.mo2554g():long");
    }

    @Override // p192f.Sink
    /* renamed from: b */
    public void mo2529b(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            C1828t.m2518a(buffer.f8450b, 0L, j);
            while (j > 0) {
                Segment segment = buffer.f8449a;
                if (j < segment.f8484c - segment.f8483b) {
                    Segment segment2 = this.f8449a;
                    Segment segment3 = segment2 != null ? segment2.f8488g : null;
                    if (segment3 != null && segment3.f8486e) {
                        if ((segment3.f8484c + j) - (segment3.f8485d ? 0 : segment3.f8483b) <= 8192) {
                            buffer.f8449a.m2549a(segment3, (int) j);
                            buffer.f8450b -= j;
                            this.f8450b += j;
                            return;
                        }
                    }
                    buffer.f8449a = buffer.f8449a.m2551a((int) j);
                }
                Segment segment4 = buffer.f8449a;
                long j2 = segment4.f8484c - segment4.f8483b;
                buffer.f8449a = segment4.m2548b();
                Segment segment5 = this.f8449a;
                if (segment5 == null) {
                    this.f8449a = segment4;
                    Segment segment6 = this.f8449a;
                    segment6.f8488g = segment6;
                    segment6.f8487f = segment6;
                } else {
                    segment5.f8488g.m2550a(segment4);
                    segment4.m2552a();
                }
                buffer.f8450b -= j2;
                this.f8450b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // p192f.BufferedSource
    /* renamed from: a */
    public long mo2563a(Sink sink) {
        long j = this.f8450b;
        if (j > 0) {
            sink.mo2529b(this, j);
        }
        return j;
    }

    /* renamed from: a */
    public String m2620a(Charset charset) {
        try {
            return m2623a(this.f8450b, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public String m2623a(long j, Charset charset) {
        C1828t.m2518a(this.f8450b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                Segment segment = this.f8449a;
                int i = segment.f8483b;
                if (i + j > segment.f8484c) {
                    return new String(mo2560c(j), charset);
                }
                String str = new String(segment.f8482a, i, (int) j, charset);
                segment.f8483b = (int) (segment.f8483b + j);
                this.f8450b -= j;
                if (segment.f8483b == segment.f8484c) {
                    this.f8449a = segment.m2548b();
                    SegmentPool.m2546a(segment);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // p192f.Source
    /* renamed from: b */
    public Timeout mo2528b() {
        return Timeout.f8493d;
    }

    /* renamed from: a */
    public int m2619a(byte[] bArr, int i, int i2) {
        C1828t.m2518a(bArr.length, i, i2);
        Segment segment = this.f8449a;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.f8484c - segment.f8483b);
        System.arraycopy(segment.f8482a, segment.f8483b, bArr, i, min);
        segment.f8483b += min;
        this.f8450b -= min;
        if (segment.f8483b == segment.f8484c) {
            this.f8449a = segment.m2548b();
            SegmentPool.m2546a(segment);
        }
        return min;
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public Buffer mo2575a(C1822f c1822f) {
        if (c1822f != null) {
            c1822f.mo2541a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public Buffer mo2573a(String str) {
        m2621a(str, 0, str.length());
        return this;
    }

    /* renamed from: a */
    public Buffer m2621a(String str, int i, int i2) {
        if (str != null) {
            if (i < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            } else if (i2 >= i) {
                if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                }
                while (i < i2) {
                    char charAt = str.charAt(i);
                    if (charAt < 128) {
                        Segment m2618b = m2618b(1);
                        byte[] bArr = m2618b.f8482a;
                        int i3 = m2618b.f8484c - i;
                        int min = Math.min(i2, 8192 - i3);
                        int i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                        while (i4 < min) {
                            char charAt2 = str.charAt(i4);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i4 + i3] = (byte) charAt2;
                            i4++;
                        }
                        int i5 = m2618b.f8484c;
                        int i6 = (i3 + i4) - i5;
                        m2618b.f8484c = i5 + i6;
                        this.f8450b += i6;
                        i = i4;
                    } else {
                        if (charAt < 2048) {
                            writeByte((charAt >> 6) | 192);
                            writeByte((charAt & '?') | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i7 = i + 1;
                            char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                            if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i8 >> 18) | 240);
                                writeByte(((i8 >> 12) & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                                writeByte(((i8 >> 6) & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                                writeByte((i8 & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                                i += 2;
                            } else {
                                writeByte(63);
                                i = i7;
                            }
                        } else {
                            writeByte((charAt >> '\f') | 224);
                            writeByte(((charAt >> 6) & 63) | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                            writeByte((charAt & '?') | Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                        }
                        i++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // p192f.BufferedSink
    /* renamed from: a */
    public long mo2574a(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long mo673a = source.mo673a(this, 8192L);
            if (mo673a == -1) {
                return j;
            }
            j += mo673a;
        }
    }

    @Override // p192f.Source
    /* renamed from: a */
    public long mo673a(Buffer buffer, long j) {
        if (buffer != null) {
            if (j >= 0) {
                long j2 = this.f8450b;
                if (j2 == 0) {
                    return -1L;
                }
                if (j > j2) {
                    j = j2;
                }
                buffer.mo2529b(this, j);
                return j;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // p192f.BufferedSource
    /* renamed from: a */
    public long mo2568a(byte b) {
        return m2626a(b, 0L, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long m2626a(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f8450b;
            if (j2 <= j4) {
                j4 = j2;
            }
            if (j == j4 || (segment = this.f8449a) == null) {
                return -1L;
            }
            long j5 = this.f8450b;
            if (j5 - j >= j) {
                while (true) {
                    j5 = j3;
                    j3 = (segment.f8484c - segment.f8483b) + j5;
                    if (j3 >= j) {
                        break;
                    }
                    segment = segment.f8487f;
                }
            } else {
                while (j5 > j) {
                    segment = segment.f8488g;
                    j5 -= segment.f8484c - segment.f8483b;
                }
            }
            long j6 = j;
            while (j5 < j4) {
                byte[] bArr = segment.f8482a;
                int min = (int) Math.min(segment.f8484c, (segment.f8483b + j4) - j5);
                for (int i = (int) ((segment.f8483b + j6) - j5); i < min; i++) {
                    if (bArr[i] == b) {
                        return (i - segment.f8483b) + j5;
                    }
                }
                j6 = (segment.f8484c - segment.f8483b) + j5;
                segment = segment.f8487f;
                j5 = j6;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f8450b), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // p192f.BufferedSource
    /* renamed from: a */
    public boolean mo2565a(long j, C1822f c1822f) {
        return m2624a(j, c1822f, 0, c1822f.mo2535f());
    }

    /* renamed from: a */
    public boolean m2624a(long j, C1822f c1822f, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f8450b - j < i2 || c1822f.mo2535f() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (m2616g(i3 + j) != c1822f.mo2545a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public C1822f m2625a(int i) {
        if (i == 0) {
            return C1822f.f8454e;
        }
        return new SegmentedByteString(this, i);
    }
}
