package p181e.p182i0.p187i;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import p181e.p182i0.Util;
import p181e.p182i0.p187i.Hpack;
import p192f.Buffer;
import p192f.BufferedSource;
import p192f.C1822f;
import p192f.Source;
import p192f.Timeout;

/* renamed from: e.i0.i.g */
/* loaded from: classes.dex */
public final class Http2Reader implements Closeable {

    /* renamed from: e */
    public static final Logger f8172e = Logger.getLogger(Http2.class.getName());

    /* renamed from: a */
    public final BufferedSource f8173a;

    /* renamed from: b */
    public final C1784a f8174b;

    /* renamed from: c */
    public final boolean f8175c;

    /* renamed from: d */
    public final Hpack.C1767a f8176d;

    /* compiled from: Http2Reader.java */
    /* renamed from: e.i0.i.g$a */
    /* loaded from: classes.dex */
    public static final class C1784a implements Source {

        /* renamed from: a */
        public final BufferedSource f8177a;

        /* renamed from: b */
        public int f8178b;

        /* renamed from: c */
        public byte f8179c;

        /* renamed from: d */
        public int f8180d;

        /* renamed from: e */
        public int f8181e;

        /* renamed from: f */
        public short f8182f;

        public C1784a(BufferedSource bufferedSource) {
            this.f8177a = bufferedSource;
        }

        @Override // p192f.Source
        /* renamed from: a */
        public long mo673a(Buffer buffer, long j) {
            while (true) {
                int i = this.f8181e;
                if (i == 0) {
                    this.f8177a.skip(this.f8182f);
                    this.f8182f = (short) 0;
                    if ((this.f8179c & 4) != 0) {
                        return -1L;
                    }
                    m2949i();
                } else {
                    long mo673a = this.f8177a.mo673a(buffer, Math.min(j, i));
                    if (mo673a == -1) {
                        return -1L;
                    }
                    this.f8181e = (int) (this.f8181e - mo673a);
                    return mo673a;
                }
            }
        }

        @Override // p192f.Source
        /* renamed from: b */
        public Timeout mo2528b() {
            return this.f8177a.mo2528b();
        }

        @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* renamed from: i */
        public final void m2949i() {
            int i = this.f8180d;
            int m2959a = Http2Reader.m2959a(this.f8177a);
            this.f8181e = m2959a;
            this.f8178b = m2959a;
            byte readByte = (byte) (this.f8177a.readByte() & 255);
            this.f8179c = (byte) (this.f8177a.readByte() & 255);
            if (Http2Reader.f8172e.isLoggable(Level.FINE)) {
                Http2Reader.f8172e.fine(Http2.m3004a(true, this.f8180d, this.f8178b, readByte, this.f8179c));
            }
            this.f8180d = this.f8177a.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                Http2.m3003b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (this.f8180d == i) {
            } else {
                Http2.m3003b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }
    }

    /* compiled from: Http2Reader.java */
    /* renamed from: e.i0.i.g$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1785b {
        /* renamed from: a */
        void mo2948a();

        /* renamed from: a */
        void mo2947a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo2946a(int i, int i2, List<C1766b> list);

        /* renamed from: a */
        void mo2945a(int i, long j);

        /* renamed from: a */
        void mo2944a(int i, ErrorCode errorCode);

        /* renamed from: a */
        void mo2943a(int i, ErrorCode errorCode, C1822f c1822f);

        /* renamed from: a */
        void mo2942a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo2941a(boolean z, int i, int i2, List<C1766b> list);

        /* renamed from: a */
        void mo2940a(boolean z, int i, BufferedSource bufferedSource, int i2);

        /* renamed from: a */
        void mo2939a(boolean z, C1791m c1791m);
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f8173a = bufferedSource;
        this.f8175c = z;
        this.f8174b = new C1784a(this.f8173a);
        this.f8176d = new Hpack.C1767a(4096, this.f8174b);
    }

    /* renamed from: a */
    public void m2962a(InterfaceC1785b interfaceC1785b) {
        if (this.f8175c) {
            if (m2958a(true, interfaceC1785b)) {
                return;
            }
            Http2.m3003b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        C1822f mo2562b = this.f8173a.mo2562b(Http2.f8092a.mo2535f());
        if (f8172e.isLoggable(Level.FINE)) {
            f8172e.fine(Util.m3161a("<< CONNECTION %s", mo2562b.mo2538c()));
        }
        if (Http2.f8092a.equals(mo2562b)) {
            return;
        }
        Http2.m3003b("Expected a connection header but was %s", mo2562b.mo2532i());
        throw null;
    }

    /* renamed from: b */
    public final void m2957b(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i < 8) {
            Http2.m3003b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            int readInt = this.f8173a.readInt();
            int readInt2 = this.f8173a.readInt();
            int i3 = i - 8;
            ErrorCode m3034a = ErrorCode.m3034a(readInt2);
            if (m3034a == null) {
                Http2.m3003b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                throw null;
            }
            C1822f c1822f = C1822f.f8454e;
            if (i3 > 0) {
                c1822f = this.f8173a.mo2562b(i3);
            }
            interfaceC1785b.mo2943a(readInt, m3034a, c1822f);
        } else {
            Http2.m3003b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: c */
    public final void m2956c(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            short readByte = (b & 8) != 0 ? (short) (this.f8173a.readByte() & 255) : (short) 0;
            if ((b & 32) != 0) {
                m2961a(interfaceC1785b, i2);
                i -= 5;
            }
            interfaceC1785b.mo2941a(z, i2, -1, m2963a(m2964a(i, b, readByte), readByte, b, i2));
            return;
        }
        Http2.m3003b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8173a.close();
    }

    /* renamed from: d */
    public final void m2955d(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i != 8) {
            Http2.m3003b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        } else if (i2 == 0) {
            interfaceC1785b.mo2942a((b & 1) != 0, this.f8173a.readInt(), this.f8173a.readInt());
        } else {
            Http2.m3003b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: e */
    public final void m2954e(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i != 5) {
            Http2.m3003b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            m2961a(interfaceC1785b, i2);
        } else {
            Http2.m3003b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: f */
    public final void m2953f(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i2 != 0) {
            short readByte = (b & 8) != 0 ? (short) (this.f8173a.readByte() & 255) : (short) 0;
            interfaceC1785b.mo2946a(i2, this.f8173a.readInt() & Integer.MAX_VALUE, m2963a(m2964a(i - 4, b, readByte), readByte, b, i2));
            return;
        }
        Http2.m3003b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    }

    /* renamed from: g */
    public final void m2952g(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i != 4) {
            Http2.m3003b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        } else if (i2 != 0) {
            int readInt = this.f8173a.readInt();
            ErrorCode m3034a = ErrorCode.m3034a(readInt);
            if (m3034a != null) {
                interfaceC1785b.mo2944a(i2, m3034a);
            } else {
                Http2.m3003b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                throw null;
            }
        } else {
            Http2.m3003b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: h */
    public final void m2951h(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i2 != 0) {
            Http2.m3003b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b & 1) != 0) {
            if (i == 0) {
                interfaceC1785b.mo2948a();
            } else {
                Http2.m3003b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        } else if (i % 6 != 0) {
            Http2.m3003b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        } else {
            C1791m c1791m = new C1791m();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.f8173a.readShort();
                int readInt = this.f8173a.readInt();
                switch (readShort) {
                    case 2:
                        if (readInt != 0 && readInt != 1) {
                            Http2.m3003b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            throw null;
                        }
                        break;
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        readShort = 7;
                        if (readInt < 0) {
                            Http2.m3003b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                        break;
                    case 5:
                        if (readInt < 16384 || readInt > 16777215) {
                            Http2.m3003b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            throw null;
                        }
                        break;
                        break;
                }
                c1791m.m2883a(readShort, readInt);
            }
            interfaceC1785b.mo2939a(false, c1791m);
        }
    }

    /* renamed from: i */
    public final void m2950i(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i != 4) {
            Http2.m3003b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            throw null;
        }
        long readInt = this.f8173a.readInt() & 2147483647L;
        if (readInt != 0) {
            interfaceC1785b.mo2945a(i2, readInt);
        } else {
            Http2.m3003b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    /* renamed from: a */
    public boolean m2958a(boolean z, InterfaceC1785b interfaceC1785b) {
        try {
            this.f8173a.mo2558d(9L);
            int m2959a = m2959a(this.f8173a);
            if (m2959a < 0 || m2959a > 16384) {
                Http2.m3003b("FRAME_SIZE_ERROR: %s", Integer.valueOf(m2959a));
                throw null;
            }
            byte readByte = (byte) (this.f8173a.readByte() & 255);
            if (z && readByte != 4) {
                Http2.m3003b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.f8173a.readByte() & 255);
            int readInt = this.f8173a.readInt() & Integer.MAX_VALUE;
            if (f8172e.isLoggable(Level.FINE)) {
                f8172e.fine(Http2.m3004a(true, readInt, m2959a, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    m2960a(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                case 1:
                    m2956c(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                case 2:
                    m2954e(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                case 3:
                    m2952g(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                case 4:
                    m2951h(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                case 5:
                    m2953f(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                case 6:
                    m2955d(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                case 7:
                    m2957b(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                case 8:
                    m2950i(interfaceC1785b, m2959a, readByte2, readInt);
                    break;
                default:
                    this.f8173a.skip(m2959a);
                    break;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public final List<C1766b> m2963a(int i, short s, byte b, int i2) {
        C1784a c1784a = this.f8174b;
        c1784a.f8181e = i;
        c1784a.f8178b = i;
        c1784a.f8182f = s;
        c1784a.f8179c = b;
        c1784a.f8180d = i2;
        this.f8176d.m3019f();
        return this.f8176d.m3025c();
    }

    /* renamed from: a */
    public final void m2960a(InterfaceC1785b interfaceC1785b, int i, byte b, int i2) {
        if (i2 == 0) {
            Http2.m3003b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b & 1) != 0;
        if (!((b & 32) != 0)) {
            short readByte = (b & 8) != 0 ? (short) (this.f8173a.readByte() & 255) : (short) 0;
            interfaceC1785b.mo2940a(z, i2, this.f8173a, m2964a(i, b, readByte));
            this.f8173a.skip(readByte);
            return;
        }
        Http2.m3003b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    /* renamed from: a */
    public final void m2961a(InterfaceC1785b interfaceC1785b, int i) {
        int readInt = this.f8173a.readInt();
        interfaceC1785b.mo2947a(i, readInt & Integer.MAX_VALUE, (this.f8173a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: a */
    public static int m2959a(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* renamed from: a */
    public static int m2964a(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        Http2.m3003b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }
}
