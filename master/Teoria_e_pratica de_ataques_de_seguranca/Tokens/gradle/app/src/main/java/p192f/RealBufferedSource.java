package p192f;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: f.m */
/* loaded from: classes.dex */
public final class RealBufferedSource implements BufferedSource {

    /* renamed from: a */
    public final Buffer f8478a = new Buffer();

    /* renamed from: b */
    public final Source f8479b;

    /* renamed from: c */
    public boolean f8480c;

    public RealBufferedSource(Source source) {
        if (source != null) {
            this.f8479b = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // p192f.BufferedSource, p192f.BufferedSink
    /* renamed from: a */
    public Buffer mo2569a() {
        return this.f8478a;
    }

    @Override // p192f.BufferedSource
    /* renamed from: b */
    public C1822f mo2562b(long j) {
        mo2558d(j);
        return this.f8478a.mo2562b(j);
    }

    @Override // p192f.BufferedSource
    /* renamed from: c */
    public byte[] mo2560c(long j) {
        mo2558d(j);
        return this.f8478a.mo2560c(j);
    }

    @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8480c) {
            return;
        }
        this.f8480c = true;
        this.f8479b.close();
        this.f8478a.m2612l();
    }

    @Override // p192f.BufferedSource
    /* renamed from: d */
    public void mo2558d(long j) {
        if (!mo2566a(j)) {
            throw new EOFException();
        }
    }

    @Override // p192f.BufferedSource
    /* renamed from: e */
    public boolean mo2557e() {
        if (this.f8480c) {
            throw new IllegalStateException("closed");
        }
        return this.f8478a.mo2557e() && this.f8479b.mo673a(this.f8478a, 8192L) == -1;
    }

    @Override // p192f.BufferedSource
    /* renamed from: f */
    public short mo2555f() {
        mo2558d(2L);
        return this.f8478a.mo2555f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // p192f.BufferedSource
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo2554g() {
        /*
            r6 = this;
            r0 = 1
            r6.mo2558d(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.mo2566a(r3)
            if (r3 == 0) goto L4a
            f.c r3 = r6.f8478a
            long r4 = (long) r1
            byte r3 = r3.m2616g(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            f.c r0 = r6.f8478a
            long r0 = r0.mo2554g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p192f.RealBufferedSource.mo2554g():long");
    }

    @Override // p192f.BufferedSource
    /* renamed from: h */
    public InputStream mo2553h() {
        return new C1826a();
    }

    @Override // p192f.BufferedSource
    public byte readByte() {
        mo2558d(1L);
        return this.f8478a.readByte();
    }

    @Override // p192f.BufferedSource
    public void readFully(byte[] bArr) {
        try {
            mo2558d(bArr.length);
            this.f8478a.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer buffer = this.f8478a;
                long j = buffer.f8450b;
                if (j > 0) {
                    int m2619a = buffer.m2619a(bArr, i, (int) j);
                    if (m2619a == -1) {
                        throw new AssertionError();
                    }
                    i += m2619a;
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // p192f.BufferedSource
    public int readInt() {
        mo2558d(4L);
        return this.f8478a.readInt();
    }

    @Override // p192f.BufferedSource
    public short readShort() {
        mo2558d(2L);
        return this.f8478a.readShort();
    }

    @Override // p192f.BufferedSource
    public void skip(long j) {
        if (this.f8480c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            Buffer buffer = this.f8478a;
            if (buffer.f8450b == 0 && this.f8479b.mo673a(buffer, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f8478a.m2605s());
            this.f8478a.skip(min);
            j -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.f8479b + ")";
    }

    @Override // p192f.Source
    /* renamed from: a */
    public long mo673a(Buffer buffer, long j) {
        if (buffer != null) {
            if (j >= 0) {
                if (!this.f8480c) {
                    Buffer buffer2 = this.f8478a;
                    if (buffer2.f8450b == 0 && this.f8479b.mo673a(buffer2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.f8478a.mo673a(buffer, Math.min(j, this.f8478a.f8450b));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // p192f.BufferedSource
    /* renamed from: d */
    public int mo2559d() {
        mo2558d(4L);
        return this.f8478a.mo2559d();
    }

    @Override // p192f.Source
    /* renamed from: b */
    public Timeout mo2528b() {
        return this.f8479b.mo2528b();
    }

    @Override // p192f.BufferedSource
    /* renamed from: c */
    public String mo2561c() {
        return m2556e(Long.MAX_VALUE);
    }

    /* renamed from: e */
    public String m2556e(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long m2567a = m2567a((byte) 10, 0L, j2);
            if (m2567a != -1) {
                return this.f8478a.m2614i(m2567a);
            }
            if (j2 < Long.MAX_VALUE && mo2566a(j2) && this.f8478a.m2616g(j2 - 1) == 13 && mo2566a(1 + j2) && this.f8478a.m2616g(j2) == 10) {
                return this.f8478a.m2614i(j2);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.f8478a;
            buffer2.m2622a(buffer, 0L, Math.min(32L, buffer2.m2605s()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f8478a.m2605s(), j) + " content=" + buffer.m2608p().mo2538c() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    /* compiled from: RealBufferedSource.java */
    /* renamed from: f.m$a */
    /* loaded from: classes.dex */
    public class C1826a extends InputStream {
        public C1826a() {
        }

        @Override // java.io.InputStream
        public int available() {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (!realBufferedSource.f8480c) {
                return (int) Math.min(realBufferedSource.f8478a.f8450b, 2147483647L);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            RealBufferedSource.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (!realBufferedSource.f8480c) {
                Buffer buffer = realBufferedSource.f8478a;
                if (buffer.f8450b == 0 && realBufferedSource.f8479b.mo673a(buffer, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.f8478a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return RealBufferedSource.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (!RealBufferedSource.this.f8480c) {
                C1828t.m2518a(bArr.length, i, i2);
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                Buffer buffer = realBufferedSource.f8478a;
                if (buffer.f8450b == 0 && realBufferedSource.f8479b.mo673a(buffer, 8192L) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.f8478a.m2619a(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    @Override // p192f.BufferedSource
    /* renamed from: a */
    public boolean mo2566a(long j) {
        Buffer buffer;
        if (j >= 0) {
            if (!this.f8480c) {
                do {
                    buffer = this.f8478a;
                    if (buffer.f8450b >= j) {
                        return true;
                    }
                } while (this.f8479b.mo673a(buffer, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // p192f.BufferedSource
    /* renamed from: a */
    public long mo2563a(Sink sink) {
        if (sink != null) {
            long j = 0;
            while (this.f8479b.mo673a(this.f8478a, 8192L) != -1) {
                long m2611m = this.f8478a.m2611m();
                if (m2611m > 0) {
                    j += m2611m;
                    sink.mo2529b(this.f8478a, m2611m);
                }
            }
            if (this.f8478a.m2605s() > 0) {
                long m2605s = j + this.f8478a.m2605s();
                Buffer buffer = this.f8478a;
                sink.mo2529b(buffer, buffer.m2605s());
                return m2605s;
            }
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // p192f.BufferedSource
    /* renamed from: a */
    public long mo2568a(byte b) {
        return m2567a(b, 0L, Long.MAX_VALUE);
    }

    /* renamed from: a */
    public long m2567a(byte b, long j, long j2) {
        if (this.f8480c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long m2626a = this.f8478a.m2626a(b, j, j2);
            if (m2626a == -1) {
                Buffer buffer = this.f8478a;
                long j3 = buffer.f8450b;
                if (j3 >= j2 || this.f8479b.mo673a(buffer, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return m2626a;
            }
        }
        return -1L;
    }

    @Override // p192f.BufferedSource
    /* renamed from: a */
    public boolean mo2565a(long j, C1822f c1822f) {
        return m2564a(j, c1822f, 0, c1822f.mo2535f());
    }

    /* renamed from: a */
    public boolean m2564a(long j, C1822f c1822f, int i, int i2) {
        if (!this.f8480c) {
            if (j < 0 || i < 0 || i2 < 0 || c1822f.mo2535f() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = i3 + j;
                if (!mo2566a(1 + j2) || this.f8478a.m2616g(j2) != c1822f.mo2545a(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }
}
