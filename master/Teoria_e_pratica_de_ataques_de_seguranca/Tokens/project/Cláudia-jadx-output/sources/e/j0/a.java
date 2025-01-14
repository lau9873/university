package e.j0;

import e.b0;
import e.c0;
import e.d0;
import e.e0;
import e.i;
import e.i0.j.e;
import e.t;
import e.v;
import e.w;
import e.z;
import f.c;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
/* compiled from: HttpLoggingInterceptor.java */
/* loaded from: classes.dex */
public final class a implements v {

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f5870c = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public final b f5871a;

    /* renamed from: b  reason: collision with root package name */
    public volatile EnumC0119a f5872b;

    /* compiled from: HttpLoggingInterceptor.java */
    /* renamed from: e.j0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0119a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.java */
    /* loaded from: classes.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f5878a = new C0120a();

        /* compiled from: HttpLoggingInterceptor.java */
        /* renamed from: e.j0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0120a implements b {
            @Override // e.j0.a.b
            public void a(String str) {
                e.b().a(4, str, (Throwable) null);
            }
        }

        void a(String str);
    }

    public a() {
        this(b.f5878a);
    }

    public a a(EnumC0119a enumC0119a) {
        if (enumC0119a != null) {
            this.f5872b = enumC0119a;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    @Override // e.v
    public d0 intercept(v.a aVar) {
        boolean z;
        t n;
        boolean z2;
        EnumC0119a enumC0119a = this.f5872b;
        b0 a2 = aVar.a();
        if (enumC0119a == EnumC0119a.NONE) {
            return aVar.a(a2);
        }
        boolean z3 = enumC0119a == EnumC0119a.BODY;
        boolean z4 = z3 || enumC0119a == EnumC0119a.HEADERS;
        c0 a3 = a2.a();
        boolean z5 = a3 != null;
        i b2 = aVar.b();
        String str = "--> " + a2.e() + ' ' + a2.g() + ' ' + (b2 != null ? b2.a() : z.HTTP_1_1);
        if (!z4 && z5) {
            str = str + " (" + a3.a() + "-byte body)";
        }
        this.f5871a.a(str);
        if (z4) {
            if (z5) {
                if (a3.b() != null) {
                    this.f5871a.a("Content-Type: " + a3.b());
                }
                if (a3.a() != -1) {
                    this.f5871a.a("Content-Length: " + a3.a());
                }
            }
            t c2 = a2.c();
            int b3 = c2.b();
            int i2 = 0;
            while (i2 < b3) {
                String a4 = c2.a(i2);
                int i3 = b3;
                if ("Content-Type".equalsIgnoreCase(a4) || "Content-Length".equalsIgnoreCase(a4)) {
                    z2 = z4;
                } else {
                    z2 = z4;
                    this.f5871a.a(a4 + ": " + c2.b(i2));
                }
                i2++;
                b3 = i3;
                z4 = z2;
            }
            z = z4;
            if (z3 && z5) {
                if (a(a2.c())) {
                    this.f5871a.a("--> END " + a2.e() + " (encoded body omitted)");
                } else {
                    c cVar = new c();
                    a3.a(cVar);
                    Charset charset = f5870c;
                    w b4 = a3.b();
                    if (b4 != null) {
                        charset = b4.a(f5870c);
                    }
                    this.f5871a.a("");
                    if (a(cVar)) {
                        this.f5871a.a(cVar.a(charset));
                        this.f5871a.a("--> END " + a2.e() + " (" + a3.a() + "-byte body)");
                    } else {
                        this.f5871a.a("--> END " + a2.e() + " (binary " + a3.a() + "-byte body omitted)");
                    }
                }
            } else {
                this.f5871a.a("--> END " + a2.e());
            }
        } else {
            z = z4;
        }
        long nanoTime = System.nanoTime();
        try {
            d0 a5 = aVar.a(a2);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            e0 j = a5.j();
            long l = j.l();
            String str2 = l != -1 ? l + "-byte" : "unknown-length";
            b bVar = this.f5871a;
            StringBuilder sb = new StringBuilder();
            sb.append("<-- ");
            sb.append(a5.l());
            sb.append(' ');
            sb.append(a5.p());
            sb.append(' ');
            sb.append(a5.s().g());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            sb.append(z ? "" : ", " + str2 + " body");
            sb.append(')');
            bVar.a(sb.toString());
            if (z) {
                int b5 = a5.n().b();
                for (int i4 = 0; i4 < b5; i4++) {
                    this.f5871a.a(n.a(i4) + ": " + n.b(i4));
                }
                if (z3 && e.i0.g.e.b(a5)) {
                    if (a(a5.n())) {
                        this.f5871a.a("<-- END HTTP (encoded body omitted)");
                    } else {
                        f.e n2 = j.n();
                        n2.a(Long.MAX_VALUE);
                        c a6 = n2.a();
                        Charset charset2 = f5870c;
                        w m = j.m();
                        if (m != null) {
                            try {
                                charset2 = m.a(f5870c);
                            } catch (UnsupportedCharsetException unused) {
                                this.f5871a.a("");
                                this.f5871a.a("Couldn't decode the response body; charset is likely malformed.");
                                this.f5871a.a("<-- END HTTP");
                                return a5;
                            }
                        }
                        if (!a(a6)) {
                            this.f5871a.a("");
                            this.f5871a.a("<-- END HTTP (binary " + a6.s() + "-byte body omitted)");
                            return a5;
                        }
                        if (l != 0) {
                            this.f5871a.a("");
                            this.f5871a.a(a6.m9clone().a(charset2));
                        }
                        this.f5871a.a("<-- END HTTP (" + a6.s() + "-byte body)");
                    }
                } else {
                    this.f5871a.a("<-- END HTTP");
                }
            }
            return a5;
        } catch (Exception e2) {
            this.f5871a.a("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }

    public a(b bVar) {
        this.f5872b = EnumC0119a.NONE;
        this.f5871a = bVar;
    }

    public static boolean a(c cVar) {
        try {
            c cVar2 = new c();
            cVar.a(cVar2, 0L, cVar.s() < 64 ? cVar.s() : 64L);
            for (int i2 = 0; i2 < 16; i2++) {
                if (cVar2.e()) {
                    return true;
                }
                int r = cVar2.r();
                if (Character.isISOControl(r) && !Character.isWhitespace(r)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public final boolean a(t tVar) {
        String a2 = tVar.a("Content-Encoding");
        return (a2 == null || a2.equalsIgnoreCase("identity")) ? false : true;
    }
}
