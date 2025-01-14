package e.i0.i;

import e.i0.i.c;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: Http2Writer.java */
/* loaded from: classes.dex */
public final class i implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    public static final Logger f5797g = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final f.d f5798a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5799b;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5802e;

    /* renamed from: c  reason: collision with root package name */
    public final f.c f5800c = new f.c();

    /* renamed from: f  reason: collision with root package name */
    public final c.b f5803f = new c.b(this.f5800c);

    /* renamed from: d  reason: collision with root package name */
    public int f5801d = 16384;

    public i(f.d dVar, boolean z) {
        this.f5798a = dVar;
        this.f5799b = z;
    }

    public synchronized void a(m mVar) {
        if (!this.f5802e) {
            this.f5801d = mVar.c(this.f5801d);
            if (mVar.b() != -1) {
                this.f5803f.b(mVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f5798a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b(m mVar) {
        if (!this.f5802e) {
            int i2 = 0;
            a(0, mVar.d() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (mVar.d(i2)) {
                    this.f5798a.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.f5798a.writeInt(mVar.a(i2));
                }
                i2++;
            }
            this.f5798a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f5802e = true;
        this.f5798a.close();
    }

    public synchronized void flush() {
        if (!this.f5802e) {
            this.f5798a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void j() {
        if (!this.f5802e) {
            if (this.f5799b) {
                if (f5797g.isLoggable(Level.FINE)) {
                    f5797g.fine(e.i0.c.a(">> CONNECTION %s", d.f5703a.c()));
                }
                this.f5798a.write(d.f5703a.h());
                this.f5798a.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int k() {
        return this.f5801d;
    }

    public synchronized void a(int i2, int i3, List<b> list) {
        if (!this.f5802e) {
            this.f5803f.a(list);
            long s = this.f5800c.s();
            int min = (int) Math.min(this.f5801d - 4, s);
            long j = min;
            int i4 = (s > j ? 1 : (s == j ? 0 : -1));
            a(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : (byte) 0);
            this.f5798a.writeInt(i3 & Integer.MAX_VALUE);
            this.f5798a.b(this.f5800c, j);
            if (i4 > 0) {
                b(i2, s - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final void b(int i2, long j) {
        while (j > 0) {
            int min = (int) Math.min(this.f5801d, j);
            long j2 = min;
            j -= j2;
            a(i2, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f5798a.b(this.f5800c, j2);
        }
    }

    public synchronized void a(boolean z, int i2, int i3, List<b> list) {
        if (!this.f5802e) {
            a(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, a aVar) {
        if (!this.f5802e) {
            if (aVar.f5674a != -1) {
                a(i2, 4, (byte) 3, (byte) 0);
                this.f5798a.writeInt(aVar.f5674a);
                this.f5798a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i2, f.c cVar, int i3) {
        if (!this.f5802e) {
            a(i2, z ? (byte) 1 : (byte) 0, cVar, i3);
        } else {
            throw new IOException("closed");
        }
    }

    public void a(int i2, byte b2, f.c cVar, int i3) {
        a(i2, i3, (byte) 0, b2);
        if (i3 > 0) {
            this.f5798a.b(cVar, i3);
        }
    }

    public synchronized void a(boolean z, int i2, int i3) {
        if (!this.f5802e) {
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f5798a.writeInt(i2);
            this.f5798a.writeInt(i3);
            this.f5798a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, a aVar, byte[] bArr) {
        if (!this.f5802e) {
            if (aVar.f5674a != -1) {
                a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f5798a.writeInt(i2);
                this.f5798a.writeInt(aVar.f5674a);
                if (bArr.length > 0) {
                    this.f5798a.write(bArr);
                }
                this.f5798a.flush();
            } else {
                d.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i2, long j) {
        if (this.f5802e) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            a(i2, 4, (byte) 8, (byte) 0);
            this.f5798a.writeInt((int) j);
            this.f5798a.flush();
        } else {
            d.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    public void a(int i2, int i3, byte b2, byte b3) {
        if (f5797g.isLoggable(Level.FINE)) {
            f5797g.fine(d.a(false, i2, i3, b2, b3));
        }
        int i4 = this.f5801d;
        if (i3 > i4) {
            d.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        } else if ((Integer.MIN_VALUE & i2) != 0) {
            d.a("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        } else {
            a(this.f5798a, i3);
            this.f5798a.writeByte(b2 & 255);
            this.f5798a.writeByte(b3 & 255);
            this.f5798a.writeInt(i2 & Integer.MAX_VALUE);
        }
    }

    public static void a(f.d dVar, int i2) {
        dVar.writeByte((i2 >>> 16) & 255);
        dVar.writeByte((i2 >>> 8) & 255);
        dVar.writeByte(i2 & 255);
    }

    public void a(boolean z, int i2, List<b> list) {
        if (!this.f5802e) {
            this.f5803f.a(list);
            long s = this.f5800c.s();
            int min = (int) Math.min(this.f5801d, s);
            long j = min;
            int i3 = (s > j ? 1 : (s == j ? 0 : -1));
            byte b2 = i3 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i2, min, (byte) 1, b2);
            this.f5798a.b(this.f5800c, j);
            if (i3 > 0) {
                b(i2, s - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
