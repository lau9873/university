package f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* compiled from: GzipSource.java */
/* loaded from: classes.dex */
public final class i implements r {

    /* renamed from: b  reason: collision with root package name */
    public final e f6010b;

    /* renamed from: c  reason: collision with root package name */
    public final Inflater f6011c;

    /* renamed from: d  reason: collision with root package name */
    public final j f6012d;

    /* renamed from: a  reason: collision with root package name */
    public int f6009a = 0;

    /* renamed from: e  reason: collision with root package name */
    public final CRC32 f6013e = new CRC32();

    public i(r rVar) {
        if (rVar != null) {
            this.f6011c = new Inflater(true);
            this.f6010b = k.a(rVar);
            this.f6012d = new j(this.f6010b, this.f6011c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // f.r
    public long a(c cVar, long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (i2 == 0) {
            return 0L;
        } else {
            if (this.f6009a == 0) {
                i();
                this.f6009a = 1;
            }
            if (this.f6009a == 1) {
                long j2 = cVar.f5999b;
                long a2 = this.f6012d.a(cVar, j);
                if (a2 != -1) {
                    a(cVar, j2, a2);
                    return a2;
                }
                this.f6009a = 2;
            }
            if (this.f6009a == 2) {
                j();
                this.f6009a = 3;
                if (!this.f6010b.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // f.r
    public s b() {
        return this.f6010b.b();
    }

    @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6012d.close();
    }

    public final void i() {
        this.f6010b.d(10L);
        byte g2 = this.f6010b.a().g(3L);
        boolean z = ((g2 >> 1) & 1) == 1;
        if (z) {
            a(this.f6010b.a(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f6010b.readShort());
        this.f6010b.skip(8L);
        if (((g2 >> 2) & 1) == 1) {
            this.f6010b.d(2L);
            if (z) {
                a(this.f6010b.a(), 0L, 2L);
            }
            long f2 = this.f6010b.a().f();
            this.f6010b.d(f2);
            if (z) {
                a(this.f6010b.a(), 0L, f2);
            }
            this.f6010b.skip(f2);
        }
        if (((g2 >> 3) & 1) == 1) {
            long a2 = this.f6010b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.f6010b.a(), 0L, a2 + 1);
                }
                this.f6010b.skip(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((g2 >> 4) & 1) == 1) {
            long a3 = this.f6010b.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.f6010b.a(), 0L, a3 + 1);
                }
                this.f6010b.skip(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.f6010b.f(), (short) this.f6013e.getValue());
            this.f6013e.reset();
        }
    }

    public final void j() {
        a("CRC", this.f6010b.d(), (int) this.f6013e.getValue());
        a("ISIZE", this.f6010b.d(), (int) this.f6011c.getBytesWritten());
    }

    public final void a(c cVar, long j, long j2) {
        int i2;
        n nVar = cVar.f5998a;
        while (true) {
            int i3 = nVar.f6032c;
            int i4 = nVar.f6031b;
            if (j < i3 - i4) {
                break;
            }
            j -= i3 - i4;
            nVar = nVar.f6035f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(nVar.f6032c - i2, j2);
            this.f6013e.update(nVar.f6030a, (int) (nVar.f6031b + j), min);
            j2 -= min;
            nVar = nVar.f6035f;
            j = 0;
        }
    }

    public final void a(String str, int i2, int i3) {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }
}
