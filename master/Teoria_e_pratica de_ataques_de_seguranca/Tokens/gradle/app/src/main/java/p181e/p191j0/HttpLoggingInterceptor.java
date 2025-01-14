package p181e.p191j0;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Connection;
import p181e.Headers;
import p181e.Interceptor;
import p181e.MediaType;
import p181e.Protocol;
import p181e.RequestBody;
import p181e.ResponseBody;
import p181e.p182i0.p185g.HttpHeaders;
import p181e.p182i0.p188j.Platform;
import p192f.Buffer;
import p192f.BufferedSource;

/* renamed from: e.j0.a */
/* loaded from: classes.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: c */
    public static final Charset f8278c = Charset.forName("UTF-8");

    /* renamed from: a */
    public final InterfaceC1800b f8279a;

    /* renamed from: b */
    public volatile EnumC1799a f8280b;

    /* compiled from: HttpLoggingInterceptor.java */
    /* renamed from: e.j0.a$a */
    /* loaded from: classes.dex */
    public enum EnumC1799a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.java */
    /* renamed from: e.j0.a$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1800b {

        /* renamed from: a */
        public static final InterfaceC1800b f8286a = new C1801a();

        /* compiled from: HttpLoggingInterceptor.java */
        /* renamed from: e.j0.a$b$a */
        /* loaded from: classes.dex */
        public static class C1801a implements InterfaceC1800b {
            @Override // p181e.p191j0.HttpLoggingInterceptor.InterfaceC1800b
            /* renamed from: a */
            public void mo2815a(String str) {
                Platform.m2853b().mo2861a(4, str, (Throwable) null);
            }
        }

        /* renamed from: a */
        void mo2815a(String str);
    }

    public HttpLoggingInterceptor() {
        this(InterfaceC1800b.f8286a);
    }

    /* renamed from: a */
    public HttpLoggingInterceptor m2818a(EnumC1799a enumC1799a) {
        if (enumC1799a != null) {
            this.f8280b = enumC1799a;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    @Override // p181e.Interceptor
    public C1744d0 intercept(Interceptor.InterfaceC1812a interfaceC1812a) {
        boolean z;
        Headers m3221n;
        boolean z2;
        EnumC1799a enumC1799a = this.f8280b;
        C1737b0 mo2696a = interfaceC1812a.mo2696a();
        if (enumC1799a == EnumC1799a.NONE) {
            return interfaceC1812a.mo2695a(mo2696a);
        }
        boolean z3 = enumC1799a == EnumC1799a.BODY;
        boolean z4 = z3 || enumC1799a == EnumC1799a.HEADERS;
        RequestBody m3261a = mo2696a.m3261a();
        boolean z5 = m3261a != null;
        Connection mo2694b = interfaceC1812a.mo2694b();
        String str = "--> " + mo2696a.m3256e() + ' ' + mo2696a.m3254g() + ' ' + (mo2694b != null ? mo2694b.mo3124a() : Protocol.HTTP_1_1);
        if (!z4 && z5) {
            str = str + " (" + m3261a.mo645a() + "-byte body)";
        }
        this.f8279a.mo2815a(str);
        if (z4) {
            if (z5) {
                if (m3261a.mo643b() != null) {
                    this.f8279a.mo2815a("Content-Type: " + m3261a.mo643b());
                }
                if (m3261a.mo645a() != -1) {
                    this.f8279a.mo2815a("Content-Length: " + m3261a.mo645a());
                }
            }
            Headers m3258c = mo2696a.m3258c();
            int m2762b = m3258c.m2762b();
            int i = 0;
            while (i < m2762b) {
                String m2766a = m3258c.m2766a(i);
                int i2 = m2762b;
                if ("Content-Type".equalsIgnoreCase(m2766a) || "Content-Length".equalsIgnoreCase(m2766a)) {
                    z2 = z4;
                } else {
                    z2 = z4;
                    this.f8279a.mo2815a(m2766a + ": " + m3258c.m2761b(i));
                }
                i++;
                m2762b = i2;
                z4 = z2;
            }
            z = z4;
            if (z3 && z5) {
                if (m2817a(mo2696a.m3258c())) {
                    this.f8279a.mo2815a("--> END " + mo2696a.m3256e() + " (encoded body omitted)");
                } else {
                    Buffer buffer = new Buffer();
                    m3261a.mo644a(buffer);
                    Charset charset = f8278c;
                    MediaType mo643b = m3261a.mo643b();
                    if (mo643b != null) {
                        charset = mo643b.m2691a(f8278c);
                    }
                    this.f8279a.mo2815a("");
                    if (m2816a(buffer)) {
                        this.f8279a.mo2815a(buffer.m2620a(charset));
                        this.f8279a.mo2815a("--> END " + mo2696a.m3256e() + " (" + m3261a.mo645a() + "-byte body)");
                    } else {
                        this.f8279a.mo2815a("--> END " + mo2696a.m3256e() + " (binary " + m3261a.mo645a() + "-byte body omitted)");
                    }
                }
            } else {
                this.f8279a.mo2815a("--> END " + mo2696a.m3256e());
            }
        } else {
            z = z4;
        }
        long nanoTime = System.nanoTime();
        try {
            C1744d0 mo2695a = interfaceC1812a.mo2695a(mo2696a);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody m3225j = mo2695a.m3225j();
            long mo672l = m3225j.mo672l();
            String str2 = mo672l != -1 ? mo672l + "-byte" : "unknown-length";
            InterfaceC1800b interfaceC1800b = this.f8279a;
            StringBuilder sb = new StringBuilder();
            sb.append("<-- ");
            sb.append(mo2695a.m3223l());
            sb.append(' ');
            sb.append(mo2695a.m3219p());
            sb.append(' ');
            sb.append(mo2695a.m3216s().m3254g());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            sb.append(z ? "" : ", " + str2 + " body");
            sb.append(')');
            interfaceC1800b.mo2815a(sb.toString());
            if (z) {
                int m2762b2 = mo2695a.m3221n().m2762b();
                for (int i3 = 0; i3 < m2762b2; i3++) {
                    this.f8279a.mo2815a(m3221n.m2766a(i3) + ": " + m3221n.m2761b(i3));
                }
                if (z3 && HttpHeaders.m3067b(mo2695a)) {
                    if (m2817a(mo2695a.m3221n())) {
                        this.f8279a.mo2815a("<-- END HTTP (encoded body omitted)");
                    } else {
                        BufferedSource mo670n = m3225j.mo670n();
                        mo670n.mo2566a(Long.MAX_VALUE);
                        Buffer mo2569a = mo670n.mo2569a();
                        Charset charset2 = f8278c;
                        MediaType mo671m = m3225j.mo671m();
                        if (mo671m != null) {
                            try {
                                charset2 = mo671m.m2691a(f8278c);
                            } catch (UnsupportedCharsetException unused) {
                                this.f8279a.mo2815a("");
                                this.f8279a.mo2815a("Couldn't decode the response body; charset is likely malformed.");
                                this.f8279a.mo2815a("<-- END HTTP");
                                return mo2695a;
                            }
                        }
                        if (!m2816a(mo2569a)) {
                            this.f8279a.mo2815a("");
                            this.f8279a.mo2815a("<-- END HTTP (binary " + mo2569a.m2605s() + "-byte body omitted)");
                            return mo2695a;
                        }
                        if (mo672l != 0) {
                            this.f8279a.mo2815a("");
                            this.f8279a.mo2815a(mo2569a.m11332clone().m2620a(charset2));
                        }
                        this.f8279a.mo2815a("<-- END HTTP (" + mo2569a.m2605s() + "-byte body)");
                    }
                } else {
                    this.f8279a.mo2815a("<-- END HTTP");
                }
            }
            return mo2695a;
        } catch (Exception e) {
            this.f8279a.mo2815a("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public HttpLoggingInterceptor(InterfaceC1800b interfaceC1800b) {
        this.f8280b = EnumC1799a.NONE;
        this.f8279a = interfaceC1800b;
    }

    /* renamed from: a */
    public static boolean m2816a(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.m2622a(buffer2, 0L, buffer.m2605s() < 64 ? buffer.m2605s() : 64L);
            for (int i = 0; i < 16; i++) {
                if (buffer2.mo2557e()) {
                    return true;
                }
                int m2606r = buffer2.m2606r();
                if (Character.isISOControl(m2606r) && !Character.isWhitespace(m2606r)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m2817a(Headers headers) {
        String m2765a = headers.m2765a("Content-Encoding");
        return (m2765a == null || m2765a.equalsIgnoreCase("identity")) ? false : true;
    }
}
