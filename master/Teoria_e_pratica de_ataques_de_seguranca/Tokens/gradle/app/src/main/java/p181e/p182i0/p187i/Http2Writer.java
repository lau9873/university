package p181e.p182i0.p187i;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p181e.p182i0.Util;
import p181e.p182i0.p187i.Hpack;
import p192f.Buffer;
import p192f.BufferedSink;

/* renamed from: e.i0.i.i */
/* loaded from: classes.dex */
public final class Http2Writer implements Closeable {

    /* renamed from: g */
    public static final Logger f8205g = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    public final BufferedSink f8206a;

    /* renamed from: b */
    public final boolean f8207b;

    /* renamed from: e */
    public boolean f8210e;

    /* renamed from: c */
    public final Buffer f8208c = new Buffer();

    /* renamed from: f */
    public final Hpack.C1768b f8211f = new Hpack.C1768b(this.f8208c);

    /* renamed from: d */
    public int f8209d = 16384;

    public Http2Writer(BufferedSink bufferedSink, boolean z) {
        this.f8206a = bufferedSink;
        this.f8207b = z;
    }

    /* renamed from: a */
    public synchronized void m2908a(C1791m c1791m) {
        if (!this.f8210e) {
            this.f8209d = c1791m.m2878c(this.f8209d);
            if (c1791m.m2881b() != -1) {
                this.f8211f.m3007b(c1791m.m2881b());
            }
            m2913a(0, 0, (byte) 4, (byte) 1);
            this.f8206a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public synchronized void m2901b(C1791m c1791m) {
        if (!this.f8210e) {
            int i = 0;
            m2913a(0, c1791m.m2877d() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (c1791m.m2876d(i)) {
                    this.f8206a.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f8206a.writeInt(c1791m.m2884a(i));
                }
                i++;
            }
            this.f8206a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f8210e = true;
        this.f8206a.close();
    }

    public synchronized void flush() {
        if (!this.f8210e) {
            this.f8206a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: j */
    public synchronized void m2900j() {
        if (!this.f8210e) {
            if (this.f8207b) {
                if (f8205g.isLoggable(Level.FINE)) {
                    f8205g.fine(Util.m3161a(">> CONNECTION %s", Http2.f8092a.mo2538c()));
                }
                this.f8206a.write(Http2.f8092a.mo2533h());
                this.f8206a.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    /* renamed from: k */
    public int m2899k() {
        return this.f8209d;
    }

    /* renamed from: a */
    public synchronized void m2912a(int i, int i2, List<C1766b> list) {
        if (!this.f8210e) {
            this.f8211f.m3009a(list);
            long m2605s = this.f8208c.m2605s();
            int min = (int) Math.min(this.f8209d - 4, m2605s);
            long j = min;
            int i3 = (m2605s > j ? 1 : (m2605s == j ? 0 : -1));
            m2913a(i, min + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
            this.f8206a.writeInt(i2 & Integer.MAX_VALUE);
            this.f8206a.mo2529b(this.f8208c, j);
            if (i3 > 0) {
                m2902b(i, m2605s - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: b */
    public final void m2902b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min(this.f8209d, j);
            long j2 = min;
            j -= j2;
            m2913a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f8206a.mo2529b(this.f8208c, j2);
        }
    }

    /* renamed from: a */
    public synchronized void m2905a(boolean z, int i, int i2, List<C1766b> list) {
        if (!this.f8210e) {
            m2903a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m2910a(int i, ErrorCode errorCode) {
        if (!this.f8210e) {
            if (errorCode.f8063a != -1) {
                m2913a(i, 4, (byte) 3, (byte) 0);
                this.f8206a.writeInt(errorCode.f8063a);
                this.f8206a.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m2904a(boolean z, int i, Buffer buffer, int i2) {
        if (!this.f8210e) {
            m2914a(i, z ? (byte) 1 : (byte) 0, buffer, i2);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public void m2914a(int i, byte b, Buffer buffer, int i2) {
        m2913a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f8206a.mo2529b(buffer, i2);
        }
    }

    /* renamed from: a */
    public synchronized void m2906a(boolean z, int i, int i2) {
        if (!this.f8210e) {
            m2913a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f8206a.writeInt(i);
            this.f8206a.writeInt(i2);
            this.f8206a.flush();
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m2909a(int i, ErrorCode errorCode, byte[] bArr) {
        if (!this.f8210e) {
            if (errorCode.f8063a != -1) {
                m2913a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f8206a.writeInt(i);
                this.f8206a.writeInt(errorCode.f8063a);
                if (bArr.length > 0) {
                    this.f8206a.write(bArr);
                }
                this.f8206a.flush();
            } else {
                Http2.m3005a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m2911a(int i, long j) {
        if (this.f8210e) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            m2913a(i, 4, (byte) 8, (byte) 0);
            this.f8206a.writeInt((int) j);
            this.f8206a.flush();
        } else {
            Http2.m3005a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    /* renamed from: a */
    public void m2913a(int i, int i2, byte b, byte b2) {
        if (f8205g.isLoggable(Level.FINE)) {
            f8205g.fine(Http2.m3004a(false, i, i2, b, b2));
        }
        int i3 = this.f8209d;
        if (i2 > i3) {
            Http2.m3005a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        } else if ((Integer.MIN_VALUE & i) != 0) {
            Http2.m3005a("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        } else {
            m2907a(this.f8206a, i2);
            this.f8206a.writeByte(b & 255);
            this.f8206a.writeByte(b2 & 255);
            this.f8206a.writeInt(i & Integer.MAX_VALUE);
        }
    }

    /* renamed from: a */
    public static void m2907a(BufferedSink bufferedSink, int i) {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* renamed from: a */
    public void m2903a(boolean z, int i, List<C1766b> list) {
        if (!this.f8210e) {
            this.f8211f.m3009a(list);
            long m2605s = this.f8208c.m2605s();
            int min = (int) Math.min(this.f8209d, m2605s);
            long j = min;
            int i2 = (m2605s > j ? 1 : (m2605s == j ? 0 : -1));
            byte b = i2 == 0 ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            m2913a(i, min, (byte) 1, b);
            this.f8206a.mo2529b(this.f8208c, j);
            if (i2 > 0) {
                m2902b(i, m2605s - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
