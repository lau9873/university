package f;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
public final class m implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f6026a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final r f6027b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6028c;

    public m(r rVar) {
        if (rVar != null) {
            this.f6027b = rVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // f.e, f.d
    public c a() {
        return this.f6026a;
    }

    @Override // f.e
    public f b(long j) {
        d(j);
        return this.f6026a.b(j);
    }

    @Override // f.e
    public byte[] c(long j) {
        d(j);
        return this.f6026a.c(j);
    }

    @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f6028c) {
            return;
        }
        this.f6028c = true;
        this.f6027b.close();
        this.f6026a.l();
    }

    @Override // f.e
    public void d(long j) {
        if (!a(j)) {
            throw new EOFException();
        }
    }

    @Override // f.e
    public boolean e() {
        if (this.f6028c) {
            throw new IllegalStateException("closed");
        }
        return this.f6026a.e() && this.f6027b.a(this.f6026a, 8192L) == -1;
    }

    @Override // f.e
    public short f() {
        d(2L);
        return this.f6026a.f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // f.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long g() {
        /*
            r6 = this;
            r0 = 1
            r6.d(r0)
            r0 = 0
            r1 = 0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.a(r3)
            if (r3 == 0) goto L4a
            f.c r3 = r6.f6026a
            long r4 = (long) r1
            byte r3 = r3.g(r4)
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
            f.c r0 = r6.f6026a
            long r0 = r0.g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f.m.g():long");
    }

    @Override // f.e
    public InputStream h() {
        return new a();
    }

    @Override // f.e
    public byte readByte() {
        d(1L);
        return this.f6026a.readByte();
    }

    @Override // f.e
    public void readFully(byte[] bArr) {
        try {
            d(bArr.length);
            this.f6026a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                c cVar = this.f6026a;
                long j = cVar.f5999b;
                if (j > 0) {
                    int a2 = cVar.a(bArr, i2, (int) j);
                    if (a2 == -1) {
                        throw new AssertionError();
                    }
                    i2 += a2;
                } else {
                    throw e2;
                }
            }
        }
    }

    @Override // f.e
    public int readInt() {
        d(4L);
        return this.f6026a.readInt();
    }

    @Override // f.e
    public short readShort() {
        d(2L);
        return this.f6026a.readShort();
    }

    @Override // f.e
    public void skip(long j) {
        if (this.f6028c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            c cVar = this.f6026a;
            if (cVar.f5999b == 0 && this.f6027b.a(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f6026a.s());
            this.f6026a.skip(min);
            j -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.f6027b + ")";
    }

    @Override // f.r
    public long a(c cVar, long j) {
        if (cVar != null) {
            if (j >= 0) {
                if (!this.f6028c) {
                    c cVar2 = this.f6026a;
                    if (cVar2.f5999b == 0 && this.f6027b.a(cVar2, 8192L) == -1) {
                        return -1L;
                    }
                    return this.f6026a.a(cVar, Math.min(j, this.f6026a.f5999b));
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // f.e
    public int d() {
        d(4L);
        return this.f6026a.d();
    }

    @Override // f.r
    public s b() {
        return this.f6027b.b();
    }

    @Override // f.e
    public String c() {
        return e(Long.MAX_VALUE);
    }

    public String e(long j) {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long a2 = a((byte) 10, 0L, j2);
            if (a2 != -1) {
                return this.f6026a.i(a2);
            }
            if (j2 < Long.MAX_VALUE && a(j2) && this.f6026a.g(j2 - 1) == 13 && a(1 + j2) && this.f6026a.g(j2) == 10) {
                return this.f6026a.i(j2);
            }
            c cVar = new c();
            c cVar2 = this.f6026a;
            cVar2.a(cVar, 0L, Math.min(32L, cVar2.s()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f6026a.s(), j) + " content=" + cVar.p().c() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    /* compiled from: RealBufferedSource.java */
    /* loaded from: classes.dex */
    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            m mVar = m.this;
            if (!mVar.f6028c) {
                return (int) Math.min(mVar.f6026a.f5999b, 2147483647L);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            m mVar = m.this;
            if (!mVar.f6028c) {
                c cVar = mVar.f6026a;
                if (cVar.f5999b == 0 && mVar.f6027b.a(cVar, 8192L) == -1) {
                    return -1;
                }
                return m.this.f6026a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return m.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            if (!m.this.f6028c) {
                t.a(bArr.length, i2, i3);
                m mVar = m.this;
                c cVar = mVar.f6026a;
                if (cVar.f5999b == 0 && mVar.f6027b.a(cVar, 8192L) == -1) {
                    return -1;
                }
                return m.this.f6026a.a(bArr, i2, i3);
            }
            throw new IOException("closed");
        }
    }

    @Override // f.e
    public boolean a(long j) {
        c cVar;
        if (j >= 0) {
            if (!this.f6028c) {
                do {
                    cVar = this.f6026a;
                    if (cVar.f5999b >= j) {
                        return true;
                    }
                } while (this.f6027b.a(cVar, 8192L) != -1);
                return false;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // f.e
    public long a(q qVar) {
        if (qVar != null) {
            long j = 0;
            while (this.f6027b.a(this.f6026a, 8192L) != -1) {
                long m = this.f6026a.m();
                if (m > 0) {
                    j += m;
                    qVar.b(this.f6026a, m);
                }
            }
            if (this.f6026a.s() > 0) {
                long s = j + this.f6026a.s();
                c cVar = this.f6026a;
                qVar.b(cVar, cVar.s());
                return s;
            }
            return j;
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // f.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        if (this.f6028c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long a2 = this.f6026a.a(b2, j, j2);
            if (a2 == -1) {
                c cVar = this.f6026a;
                long j3 = cVar.f5999b;
                if (j3 >= j2 || this.f6027b.a(cVar, 8192L) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return a2;
            }
        }
        return -1L;
    }

    @Override // f.e
    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.f());
    }

    public boolean a(long j, f fVar, int i2, int i3) {
        if (!this.f6028c) {
            if (j < 0 || i2 < 0 || i3 < 0 || fVar.f() - i2 < i3) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                long j2 = i4 + j;
                if (!a(1 + j2) || this.f6026a.g(j2) != fVar.a(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }
}
