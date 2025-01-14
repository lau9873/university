package e.i0.i;

import e.i0.i.c;
import f.r;
import f.s;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: Http2Reader.java */
/* loaded from: classes.dex */
public final class g implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f5767e = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final f.e f5768a;

    /* renamed from: b  reason: collision with root package name */
    public final a f5769b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5770c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a f5771d;

    /* compiled from: Http2Reader.java */
    /* loaded from: classes.dex */
    public static final class a implements r {

        /* renamed from: a  reason: collision with root package name */
        public final f.e f5772a;

        /* renamed from: b  reason: collision with root package name */
        public int f5773b;

        /* renamed from: c  reason: collision with root package name */
        public byte f5774c;

        /* renamed from: d  reason: collision with root package name */
        public int f5775d;

        /* renamed from: e  reason: collision with root package name */
        public int f5776e;

        /* renamed from: f  reason: collision with root package name */
        public short f5777f;

        public a(f.e eVar) {
            this.f5772a = eVar;
        }

        @Override // f.r
        public long a(f.c cVar, long j) {
            while (true) {
                int i2 = this.f5776e;
                if (i2 == 0) {
                    this.f5772a.skip(this.f5777f);
                    this.f5777f = (short) 0;
                    if ((this.f5774c & 4) != 0) {
                        return -1L;
                    }
                    i();
                } else {
                    long a2 = this.f5772a.a(cVar, Math.min(j, i2));
                    if (a2 == -1) {
                        return -1L;
                    }
                    this.f5776e = (int) (this.f5776e - a2);
                    return a2;
                }
            }
        }

        @Override // f.r
        public s b() {
            return this.f5772a.b();
        }

        @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final void i() {
            int i2 = this.f5775d;
            int a2 = g.a(this.f5772a);
            this.f5776e = a2;
            this.f5773b = a2;
            byte readByte = (byte) (this.f5772a.readByte() & 255);
            this.f5774c = (byte) (this.f5772a.readByte() & 255);
            if (g.f5767e.isLoggable(Level.FINE)) {
                g.f5767e.fine(d.a(true, this.f5775d, this.f5773b, readByte, this.f5774c));
            }
            this.f5775d = this.f5772a.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                d.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (this.f5775d == i2) {
            } else {
                d.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }
    }

    /* compiled from: Http2Reader.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(int i2, int i3, int i4, boolean z);

        void a(int i2, int i3, List<e.i0.i.b> list);

        void a(int i2, long j);

        void a(int i2, e.i0.i.a aVar);

        void a(int i2, e.i0.i.a aVar, f.f fVar);

        void a(boolean z, int i2, int i3);

        void a(boolean z, int i2, int i3, List<e.i0.i.b> list);

        void a(boolean z, int i2, f.e eVar, int i3);

        void a(boolean z, m mVar);
    }

    public g(f.e eVar, boolean z) {
        this.f5768a = eVar;
        this.f5770c = z;
        this.f5769b = new a(this.f5768a);
        this.f5771d = new c.a(4096, this.f5769b);
    }

    public void a(b bVar) {
        if (this.f5770c) {
            if (a(true, bVar)) {
                return;
            }
            d.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        f.f b2 = this.f5768a.b(d.f5703a.f());
        if (f5767e.isLoggable(Level.FINE)) {
            f5767e.fine(e.i0.c.a("<< CONNECTION %s", b2.c()));
        }
        if (d.f5703a.equals(b2)) {
            return;
        }
        d.b("Expected a connection header but was %s", b2.i());
        throw null;
    }

    public final void b(b bVar, int i2, byte b2, int i3) {
        if (i2 < 8) {
            d.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            int readInt = this.f5768a.readInt();
            int readInt2 = this.f5768a.readInt();
            int i4 = i2 - 8;
            e.i0.i.a a2 = e.i0.i.a.a(readInt2);
            if (a2 == null) {
                d.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                throw null;
            }
            f.f fVar = f.f.f6003e;
            if (i4 > 0) {
                fVar = this.f5768a.b(i4);
            }
            bVar.a(readInt, a2, fVar);
        } else {
            d.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    public final void c(b bVar, int i2, byte b2, int i3) {
        if (i3 != 0) {
            boolean z = (b2 & 1) != 0;
            short readByte = (b2 & 8) != 0 ? (short) (this.f5768a.readByte() & 255) : (short) 0;
            if ((b2 & 32) != 0) {
                a(bVar, i3);
                i2 -= 5;
            }
            bVar.a(z, i3, -1, a(a(i2, b2, readByte), readByte, b2, i3));
            return;
        }
        d.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5768a.close();
    }

    public final void d(b bVar, int i2, byte b2, int i3) {
        if (i2 != 8) {
            d.b("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            bVar.a((b2 & 1) != 0, this.f5768a.readInt(), this.f5768a.readInt());
        } else {
            d.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    public final void e(b bVar, int i2, byte b2, int i3) {
        if (i2 != 5) {
            d.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            a(bVar, i3);
        } else {
            d.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void f(b bVar, int i2, byte b2, int i3) {
        if (i3 != 0) {
            short readByte = (b2 & 8) != 0 ? (short) (this.f5768a.readByte() & 255) : (short) 0;
            bVar.a(i3, this.f5768a.readInt() & Integer.MAX_VALUE, a(a(i2 - 4, b2, readByte), readByte, b2, i3));
            return;
        }
        d.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    public final void g(b bVar, int i2, byte b2, int i3) {
        if (i2 != 4) {
            d.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            int readInt = this.f5768a.readInt();
            e.i0.i.a a2 = e.i0.i.a.a(readInt);
            if (a2 != null) {
                bVar.a(i3, a2);
            } else {
                d.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                throw null;
            }
        } else {
            d.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    public final void h(b bVar, int i2, byte b2, int i3) {
        if (i3 != 0) {
            d.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b2 & 1) != 0) {
            if (i2 == 0) {
                bVar.a();
            } else {
                d.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i2 % 6 != 0) {
            d.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        } else {
            m mVar = new m();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short readShort = this.f5768a.readShort();
                int readInt = this.f5768a.readInt();
                switch (readShort) {
                    case 2:
                        if (readInt != 0 && readInt != 1) {
                            d.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            throw null;
                        }
                        break;
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        readShort = 7;
                        if (readInt < 0) {
                            d.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                        break;
                    case 5:
                        if (readInt < 16384 || readInt > 16777215) {
                            d.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            throw null;
                        }
                        break;
                        break;
                }
                mVar.a(readShort, readInt);
            }
            bVar.a(false, mVar);
        }
    }

    public final void i(b bVar, int i2, byte b2, int i3) {
        if (i2 != 4) {
            d.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
            throw null;
        }
        long readInt = this.f5768a.readInt() & 2147483647L;
        if (readInt != 0) {
            bVar.a(i3, readInt);
        } else {
            d.b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    public boolean a(boolean z, b bVar) {
        try {
            this.f5768a.d(9L);
            int a2 = a(this.f5768a);
            if (a2 < 0 || a2 > 16384) {
                d.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
                throw null;
            }
            byte readByte = (byte) (this.f5768a.readByte() & 255);
            if (z && readByte != 4) {
                d.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.f5768a.readByte() & 255);
            int readInt = this.f5768a.readInt() & Integer.MAX_VALUE;
            if (f5767e.isLoggable(Level.FINE)) {
                f5767e.fine(d.a(true, readInt, a2, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    a(bVar, a2, readByte2, readInt);
                    break;
                case 1:
                    c(bVar, a2, readByte2, readInt);
                    break;
                case 2:
                    e(bVar, a2, readByte2, readInt);
                    break;
                case 3:
                    g(bVar, a2, readByte2, readInt);
                    break;
                case 4:
                    h(bVar, a2, readByte2, readInt);
                    break;
                case 5:
                    f(bVar, a2, readByte2, readInt);
                    break;
                case 6:
                    d(bVar, a2, readByte2, readInt);
                    break;
                case 7:
                    b(bVar, a2, readByte2, readInt);
                    break;
                case 8:
                    i(bVar, a2, readByte2, readInt);
                    break;
                default:
                    this.f5768a.skip(a2);
                    break;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final List<e.i0.i.b> a(int i2, short s, byte b2, int i3) {
        a aVar = this.f5769b;
        aVar.f5776e = i2;
        aVar.f5773b = i2;
        aVar.f5777f = s;
        aVar.f5774c = b2;
        aVar.f5775d = i3;
        this.f5771d.f();
        return this.f5771d.c();
    }

    public final void a(b bVar, int i2, byte b2, int i3) {
        if (i3 == 0) {
            d.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if (!((b2 & 32) != 0)) {
            short readByte = (b2 & 8) != 0 ? (short) (this.f5768a.readByte() & 255) : (short) 0;
            bVar.a(z, i3, this.f5768a, a(i2, b2, readByte));
            this.f5768a.skip(readByte);
            return;
        }
        d.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    public final void a(b bVar, int i2) {
        int readInt = this.f5768a.readInt();
        bVar.a(i2, readInt & Integer.MAX_VALUE, (this.f5768a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    public static int a(f.e eVar) {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    public static int a(int i2, byte b2, short s) {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        d.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }
}
