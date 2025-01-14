package f;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class c implements e, d, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f5997c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    public n f5998a;

    /* renamed from: b  reason: collision with root package name */
    public long f5999b;

    /* compiled from: Buffer.java */
    /* loaded from: classes.dex */
    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return c.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            c.this.writeByte((int) ((byte) i2));
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            c.this.write(bArr, i2, i3);
        }
    }

    /* compiled from: Buffer.java */
    /* loaded from: classes.dex */
    public class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.f5999b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.f5999b > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            return c.this.a(bArr, i2, i3);
        }
    }

    @Override // f.e, f.d
    public c a() {
        return this;
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d a(f fVar) {
        a(fVar);
        return this;
    }

    @Override // f.e
    public f b(long j) {
        return new f(c(j));
    }

    @Override // f.e
    public String c() {
        return j(Long.MAX_VALUE);
    }

    @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // f.e
    public void d(long j) {
        if (this.f5999b < j) {
            throw new EOFException();
        }
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d e(long j) {
        e(j);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            long j = this.f5999b;
            if (j != cVar.f5999b) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            n nVar = this.f5998a;
            n nVar2 = cVar.f5998a;
            int i2 = nVar.f6031b;
            int i3 = nVar2.f6031b;
            while (j2 < this.f5999b) {
                long min = Math.min(nVar.f6032c - i2, nVar2.f6032c - i3);
                int i4 = i3;
                int i5 = i2;
                int i6 = 0;
                while (i6 < min) {
                    int i7 = i5 + 1;
                    int i8 = i4 + 1;
                    if (nVar.f6030a[i5] != nVar2.f6030a[i4]) {
                        return false;
                    }
                    i6++;
                    i5 = i7;
                    i4 = i8;
                }
                if (i5 == nVar.f6032c) {
                    nVar = nVar.f6035f;
                    i2 = nVar.f6031b;
                } else {
                    i2 = i5;
                }
                if (i4 == nVar2.f6032c) {
                    nVar2 = nVar2.f6035f;
                    i3 = nVar2.f6031b;
                } else {
                    i3 = i4;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d f(long j) {
        f(j);
        return this;
    }

    @Override // f.d, f.q, java.io.Flushable
    public void flush() {
    }

    public byte g(long j) {
        t.a(this.f5999b, j, 1L);
        n nVar = this.f5998a;
        while (true) {
            int i2 = nVar.f6032c;
            int i3 = nVar.f6031b;
            long j2 = i2 - i3;
            if (j < j2) {
                return nVar.f6030a[i3 + ((int) j)];
            }
            j -= j2;
            nVar = nVar.f6035f;
        }
    }

    @Override // f.e
    public InputStream h() {
        return new b();
    }

    public int hashCode() {
        n nVar = this.f5998a;
        if (nVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = nVar.f6032c;
            for (int i4 = nVar.f6031b; i4 < i3; i4++) {
                i2 = (i2 * 31) + nVar.f6030a[i4];
            }
            nVar = nVar.f6035f;
        } while (nVar != this.f5998a);
        return i2;
    }

    @Override // f.d
    public c i() {
        return this;
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d i() {
        i();
        return this;
    }

    public String j(long j) {
        if (j >= 0) {
            long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return i(a2);
            }
            if (j2 < s() && g(j2 - 1) == 13 && g(j2) == 10) {
                return i(j2);
            }
            c cVar = new c();
            a(cVar, 0L, Math.min(32L, s()));
            throw new EOFException("\\n not found: limit=" + Math.min(s(), j) + " content=" + cVar.p().c() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    public void l() {
        try {
            skip(this.f5999b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public long m() {
        long j = this.f5999b;
        if (j == 0) {
            return 0L;
        }
        n nVar = this.f5998a.f6036g;
        int i2 = nVar.f6032c;
        return (i2 >= 8192 || !nVar.f6034e) ? j : j - (i2 - nVar.f6031b);
    }

    public OutputStream n() {
        return new a();
    }

    public byte[] o() {
        try {
            return c(this.f5999b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public f p() {
        return new f(o());
    }

    public String q() {
        try {
            return a(this.f5999b, t.f6045a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int r() {
        int i2;
        int i3;
        int i4;
        if (this.f5999b != 0) {
            byte g2 = g(0L);
            if ((g2 & 128) == 0) {
                i2 = g2 & Byte.MAX_VALUE;
                i3 = 1;
                i4 = 0;
            } else if ((g2 & 224) == 192) {
                i2 = g2 & 31;
                i3 = 2;
                i4 = 128;
            } else if ((g2 & 240) == 224) {
                i2 = g2 & 15;
                i3 = 3;
                i4 = 2048;
            } else if ((g2 & 248) != 240) {
                skip(1L);
                return 65533;
            } else {
                i2 = g2 & 7;
                i3 = 4;
                i4 = 65536;
            }
            long j = i3;
            if (this.f5999b >= j) {
                for (int i5 = 1; i5 < i3; i5++) {
                    long j2 = i5;
                    byte g3 = g(j2);
                    if ((g3 & 192) != 128) {
                        skip(j2);
                        return 65533;
                    }
                    i2 = (i2 << 6) | (g3 & 63);
                }
                skip(j);
                if (i2 > 1114111) {
                    return 65533;
                }
                if ((i2 < 55296 || i2 > 57343) && i2 >= i4) {
                    return i2;
                }
                return 65533;
            }
            throw new EOFException("size < " + i3 + ": " + this.f5999b + " (to read code point prefixed 0x" + Integer.toHexString(g2) + ")");
        }
        throw new EOFException();
    }

    @Override // f.e
    public byte readByte() {
        long j = this.f5999b;
        if (j != 0) {
            n nVar = this.f5998a;
            int i2 = nVar.f6031b;
            int i3 = nVar.f6032c;
            int i4 = i2 + 1;
            byte b2 = nVar.f6030a[i2];
            this.f5999b = j - 1;
            if (i4 == i3) {
                this.f5998a = nVar.b();
                o.a(nVar);
            } else {
                nVar.f6031b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // f.e
    public void readFully(byte[] bArr) {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 == -1) {
                throw new EOFException();
            }
            i2 += a2;
        }
    }

    @Override // f.e
    public int readInt() {
        long j = this.f5999b;
        if (j >= 4) {
            n nVar = this.f5998a;
            int i2 = nVar.f6031b;
            int i3 = nVar.f6032c;
            if (i3 - i2 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = nVar.f6030a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & 255);
            this.f5999b = j - 4;
            if (i9 == i3) {
                this.f5998a = nVar.b();
                o.a(nVar);
            } else {
                nVar.f6031b = i9;
            }
            return i10;
        }
        throw new IllegalStateException("size < 4: " + this.f5999b);
    }

    @Override // f.e
    public short readShort() {
        long j = this.f5999b;
        if (j >= 2) {
            n nVar = this.f5998a;
            int i2 = nVar.f6031b;
            int i3 = nVar.f6032c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = nVar.f6030a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.f5999b = j - 2;
            if (i5 == i3) {
                this.f5998a = nVar.b();
                o.a(nVar);
            } else {
                nVar.f6031b = i5;
            }
            return (short) i6;
        }
        throw new IllegalStateException("size < 2: " + this.f5999b);
    }

    public long s() {
        return this.f5999b;
    }

    @Override // f.e
    public void skip(long j) {
        n nVar;
        while (j > 0) {
            if (this.f5998a != null) {
                int min = (int) Math.min(j, nVar.f6032c - nVar.f6031b);
                long j2 = min;
                this.f5999b -= j2;
                j -= j2;
                n nVar2 = this.f5998a;
                nVar2.f6031b += min;
                if (nVar2.f6031b == nVar2.f6032c) {
                    this.f5998a = nVar2.b();
                    o.a(nVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public f t() {
        long j = this.f5999b;
        if (j <= 2147483647L) {
            return a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f5999b);
    }

    public String toString() {
        return t().toString();
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d write(byte[] bArr) {
        write(bArr);
        return this;
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d writeByte(int i2) {
        writeByte(i2);
        return this;
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d writeInt(int i2) {
        writeInt(i2);
        return this;
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d writeShort(int i2) {
        writeShort(i2);
        return this;
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d a(String str) {
        a(str);
        return this;
    }

    public n b(int i2) {
        if (i2 >= 1 && i2 <= 8192) {
            n nVar = this.f5998a;
            if (nVar == null) {
                this.f5998a = o.a();
                n nVar2 = this.f5998a;
                nVar2.f6036g = nVar2;
                nVar2.f6035f = nVar2;
                return nVar2;
            }
            n nVar3 = nVar.f6036g;
            if (nVar3.f6032c + i2 > 8192 || !nVar3.f6034e) {
                n a2 = o.a();
                nVar3.a(a2);
                return a2;
            }
            return nVar3;
        }
        throw new IllegalArgumentException();
    }

    @Override // f.e
    public byte[] c(long j) {
        t.a(this.f5999b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    /* renamed from: clone */
    public c m9clone() {
        c cVar = new c();
        if (this.f5999b == 0) {
            return cVar;
        }
        cVar.f5998a = new n(this.f5998a);
        n nVar = cVar.f5998a;
        nVar.f6036g = nVar;
        nVar.f6035f = nVar;
        n nVar2 = this.f5998a;
        while (true) {
            nVar2 = nVar2.f6035f;
            if (nVar2 != this.f5998a) {
                cVar.f5998a.f6036g.a(new n(nVar2));
            } else {
                cVar.f5999b = this.f5999b;
                return cVar;
            }
        }
    }

    @Override // f.e
    public int d() {
        return t.a(readInt());
    }

    @Override // f.e
    public boolean e() {
        return this.f5999b == 0;
    }

    @Override // f.e
    public short f() {
        return t.a(readShort());
    }

    public String h(long j) {
        return a(j, t.f6045a);
    }

    public String i(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (g(j2) == 13) {
                String h2 = h(j2);
                skip(2L);
                return h2;
            }
        }
        String h3 = h(j);
        skip(1L);
        return h3;
    }

    @Override // f.d
    public /* bridge */ /* synthetic */ d write(byte[] bArr, int i2, int i3) {
        write(bArr, i2, i3);
        return this;
    }

    @Override // f.d
    public c writeByte(int i2) {
        n b2 = b(1);
        byte[] bArr = b2.f6030a;
        int i3 = b2.f6032c;
        b2.f6032c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f5999b++;
        return this;
    }

    @Override // f.d
    public c writeInt(int i2) {
        n b2 = b(4);
        byte[] bArr = b2.f6030a;
        int i3 = b2.f6032c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        b2.f6032c = i6 + 1;
        this.f5999b += 4;
        return this;
    }

    @Override // f.d
    public c writeShort(int i2) {
        n b2 = b(2);
        byte[] bArr = b2.f6030a;
        int i3 = b2.f6032c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        b2.f6032c = i4 + 1;
        this.f5999b += 2;
        return this;
    }

    @Override // f.e
    public boolean a(long j) {
        return this.f5999b >= j;
    }

    @Override // f.d
    public c e(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        n b2 = b(numberOfTrailingZeros);
        byte[] bArr = b2.f6030a;
        int i2 = b2.f6032c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f5997c[(int) (15 & j)];
            j >>>= 4;
        }
        b2.f6032c += numberOfTrailingZeros;
        this.f5999b += numberOfTrailingZeros;
        return this;
    }

    @Override // f.d
    public c f(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 == 0) {
            writeByte(48);
            return this;
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j = -j;
            if (j < 0) {
                a("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i3 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i3 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i3 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        n b2 = b(i3);
        byte[] bArr = b2.f6030a;
        int i4 = b2.f6032c + i3;
        while (j != 0) {
            i4--;
            bArr[i4] = f5997c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        b2.f6032c += i3;
        this.f5999b += i3;
        return this;
    }

    @Override // f.d
    public c write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c a(c cVar, long j, long j2) {
        if (cVar != null) {
            t.a(this.f5999b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f5999b += j2;
            n nVar = this.f5998a;
            while (true) {
                int i2 = nVar.f6032c;
                int i3 = nVar.f6031b;
                if (j < i2 - i3) {
                    break;
                }
                j -= i2 - i3;
                nVar = nVar.f6035f;
            }
            while (j2 > 0) {
                n nVar2 = new n(nVar);
                nVar2.f6031b = (int) (nVar2.f6031b + j);
                nVar2.f6032c = Math.min(nVar2.f6031b + ((int) j2), nVar2.f6032c);
                n nVar3 = cVar.f5998a;
                if (nVar3 == null) {
                    nVar2.f6036g = nVar2;
                    nVar2.f6035f = nVar2;
                    cVar.f5998a = nVar2;
                } else {
                    nVar3.f6036g.a(nVar2);
                }
                j2 -= nVar2.f6032c - nVar2.f6031b;
                nVar = nVar.f6035f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // f.d
    public c write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = i3;
            t.a(bArr.length, i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                n b2 = b(1);
                int min = Math.min(i4 - i2, 8192 - b2.f6032c);
                System.arraycopy(bArr, i2, b2.f6030a, b2.f6032c, min);
                i2 += min;
                b2.f6032c += min;
            }
            this.f5999b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public c c(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            writeByte((i2 >> 6) | 192);
            writeByte((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 >= 55296 && i2 <= 57343) {
                writeByte(63);
            } else {
                writeByte((i2 >> 12) | 224);
                writeByte(((i2 >> 6) & 63) | 128);
                writeByte((i2 & 63) | 128);
            }
        } else if (i2 <= 1114111) {
            writeByte((i2 >> 18) | 240);
            writeByte(((i2 >> 12) & 63) | 128);
            writeByte(((i2 >> 6) & 63) | 128);
            writeByte((i2 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3 A[EDGE_INSN: B:42:0x00a3->B:38:0x00a3 ?: BREAK  , SYNTHETIC] */
    @Override // f.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long g() {
        /*
            r15 = this;
            long r0 = r15.f5999b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Laa
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            f.n r6 = r15.f5998a
            byte[] r7 = r6.f6030a
            int r8 = r6.f6031b
            int r9 = r6.f6032c
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
            r0.e(r4)
            r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.q()
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
            f.n r7 = r6.b()
            r15.f5998a = r7
            f.o.a(r6)
            goto L9d
        L9b:
            r6.f6031b = r8
        L9d:
            if (r0 != 0) goto La3
            f.n r6 = r15.f5998a
            if (r6 != 0) goto Lb
        La3:
            long r2 = r15.f5999b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f5999b = r2
            return r4
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f.c.g():long");
    }

    @Override // f.q
    public void b(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            t.a(cVar.f5999b, 0L, j);
            while (j > 0) {
                n nVar = cVar.f5998a;
                if (j < nVar.f6032c - nVar.f6031b) {
                    n nVar2 = this.f5998a;
                    n nVar3 = nVar2 != null ? nVar2.f6036g : null;
                    if (nVar3 != null && nVar3.f6034e) {
                        if ((nVar3.f6032c + j) - (nVar3.f6033d ? 0 : nVar3.f6031b) <= 8192) {
                            cVar.f5998a.a(nVar3, (int) j);
                            cVar.f5999b -= j;
                            this.f5999b += j;
                            return;
                        }
                    }
                    cVar.f5998a = cVar.f5998a.a((int) j);
                }
                n nVar4 = cVar.f5998a;
                long j2 = nVar4.f6032c - nVar4.f6031b;
                cVar.f5998a = nVar4.b();
                n nVar5 = this.f5998a;
                if (nVar5 == null) {
                    this.f5998a = nVar4;
                    n nVar6 = this.f5998a;
                    nVar6.f6036g = nVar6;
                    nVar6.f6035f = nVar6;
                } else {
                    nVar5.f6036g.a(nVar4);
                    nVar4.a();
                }
                cVar.f5999b -= j2;
                this.f5999b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // f.e
    public long a(q qVar) {
        long j = this.f5999b;
        if (j > 0) {
            qVar.b(this, j);
        }
        return j;
    }

    public String a(Charset charset) {
        try {
            return a(this.f5999b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(long j, Charset charset) {
        t.a(this.f5999b, 0L, j);
        if (charset != null) {
            if (j > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
            } else if (j == 0) {
                return "";
            } else {
                n nVar = this.f5998a;
                int i2 = nVar.f6031b;
                if (i2 + j > nVar.f6032c) {
                    return new String(c(j), charset);
                }
                String str = new String(nVar.f6030a, i2, (int) j, charset);
                nVar.f6031b = (int) (nVar.f6031b + j);
                this.f5999b -= j;
                if (nVar.f6031b == nVar.f6032c) {
                    this.f5998a = nVar.b();
                    o.a(nVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // f.r
    public s b() {
        return s.f6041d;
    }

    public int a(byte[] bArr, int i2, int i3) {
        t.a(bArr.length, i2, i3);
        n nVar = this.f5998a;
        if (nVar == null) {
            return -1;
        }
        int min = Math.min(i3, nVar.f6032c - nVar.f6031b);
        System.arraycopy(nVar.f6030a, nVar.f6031b, bArr, i2, min);
        nVar.f6031b += min;
        this.f5999b -= min;
        if (nVar.f6031b == nVar.f6032c) {
            this.f5998a = nVar.b();
            o.a(nVar);
        }
        return min;
    }

    @Override // f.d
    public c a(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // f.d
    public c a(String str) {
        a(str, 0, str.length());
        return this;
    }

    public c a(String str, int i2, int i3) {
        if (str != null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i2);
            } else if (i3 >= i2) {
                if (i3 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                }
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt < 128) {
                        n b2 = b(1);
                        byte[] bArr = b2.f6030a;
                        int i4 = b2.f6032c - i2;
                        int min = Math.min(i3, 8192 - i4);
                        int i5 = i2 + 1;
                        bArr[i2 + i4] = (byte) charAt;
                        while (i5 < min) {
                            char charAt2 = str.charAt(i5);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i5 + i4] = (byte) charAt2;
                            i5++;
                        }
                        int i6 = b2.f6032c;
                        int i7 = (i4 + i5) - i6;
                        b2.f6032c = i6 + i7;
                        this.f5999b += i7;
                        i2 = i5;
                    } else {
                        if (charAt < 2048) {
                            writeByte((charAt >> 6) | 192);
                            writeByte((charAt & '?') | 128);
                        } else if (charAt >= 55296 && charAt <= 57343) {
                            int i8 = i2 + 1;
                            char charAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                            if (charAt <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                                int i9 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i9 >> 18) | 240);
                                writeByte(((i9 >> 12) & 63) | 128);
                                writeByte(((i9 >> 6) & 63) | 128);
                                writeByte((i9 & 63) | 128);
                                i2 += 2;
                            } else {
                                writeByte(63);
                                i2 = i8;
                            }
                        } else {
                            writeByte((charAt >> '\f') | 224);
                            writeByte(((charAt >> 6) & 63) | 128);
                            writeByte((charAt & '?') | 128);
                        }
                        i2++;
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override // f.d
    public long a(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a2 = rVar.a(this, 8192L);
            if (a2 == -1) {
                return j;
            }
            j += a2;
        }
    }

    @Override // f.r
    public long a(c cVar, long j) {
        if (cVar != null) {
            if (j >= 0) {
                long j2 = this.f5999b;
                if (j2 == 0) {
                    return -1L;
                }
                if (j > j2) {
                    j = j2;
                }
                cVar.b(this, j);
                return j;
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // f.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        n nVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f5999b;
            if (j2 <= j4) {
                j4 = j2;
            }
            if (j == j4 || (nVar = this.f5998a) == null) {
                return -1L;
            }
            long j5 = this.f5999b;
            if (j5 - j >= j) {
                while (true) {
                    j5 = j3;
                    j3 = (nVar.f6032c - nVar.f6031b) + j5;
                    if (j3 >= j) {
                        break;
                    }
                    nVar = nVar.f6035f;
                }
            } else {
                while (j5 > j) {
                    nVar = nVar.f6036g;
                    j5 -= nVar.f6032c - nVar.f6031b;
                }
            }
            long j6 = j;
            while (j5 < j4) {
                byte[] bArr = nVar.f6030a;
                int min = (int) Math.min(nVar.f6032c, (nVar.f6031b + j4) - j5);
                for (int i2 = (int) ((nVar.f6031b + j6) - j5); i2 < min; i2++) {
                    if (bArr[i2] == b2) {
                        return (i2 - nVar.f6031b) + j5;
                    }
                }
                j6 = (nVar.f6032c - nVar.f6031b) + j5;
                nVar = nVar.f6035f;
                j5 = j6;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f5999b), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // f.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.f());
    }

    public boolean a(long j, f fVar, int i2, int i3) {
        if (j < 0 || i2 < 0 || i3 < 0 || this.f5999b - j < i3 || fVar.f() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (g(i4 + j) != fVar.a(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public f a(int i2) {
        if (i2 == 0) {
            return f.f6003e;
        }
        return new p(this, i2);
    }
}
