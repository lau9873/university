package p181e.p182i0.p183e;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Headers;
import p181e.Interceptor;
import p181e.Protocol;
import p181e.ResponseBody;
import p181e.p182i0.Internal;
import p181e.p182i0.Util;
import p181e.p182i0.p183e.CacheStrategy;
import p181e.p182i0.p185g.C1758f;
import p181e.p182i0.p185g.HttpHeaders;
import p181e.p182i0.p185g.RealResponseBody;
import p192f.Buffer;
import p192f.BufferedSink;
import p192f.BufferedSource;
import p192f.Okio;
import p192f.Sink;
import p192f.Source;
import p192f.Timeout;

/* renamed from: e.i0.e.a */
/* loaded from: classes.dex */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: a */
    public final InternalCache f7952a;

    /* compiled from: CacheInterceptor.java */
    /* renamed from: e.i0.e.a$a */
    /* loaded from: classes.dex */
    public class C1754a implements Source {

        /* renamed from: a */
        public boolean f7953a;

        /* renamed from: b */
        public final /* synthetic */ BufferedSource f7954b;

        /* renamed from: c */
        public final /* synthetic */ CacheRequest f7955c;

        /* renamed from: d */
        public final /* synthetic */ BufferedSink f7956d;

        public C1754a(CacheInterceptor cacheInterceptor, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.f7954b = bufferedSource;
            this.f7955c = cacheRequest;
            this.f7956d = bufferedSink;
        }

        @Override // p192f.Source
        /* renamed from: a */
        public long mo673a(Buffer buffer, long j) {
            try {
                long mo673a = this.f7954b.mo673a(buffer, j);
                if (mo673a == -1) {
                    if (!this.f7953a) {
                        this.f7953a = true;
                        this.f7956d.close();
                    }
                    return -1L;
                }
                buffer.m2622a(this.f7956d.mo2569a(), buffer.m2605s() - mo673a, mo673a);
                this.f7956d.mo2570i();
                return mo673a;
            } catch (IOException e) {
                if (!this.f7953a) {
                    this.f7953a = true;
                    this.f7955c.abort();
                }
                throw e;
            }
        }

        @Override // p192f.Source
        /* renamed from: b */
        public Timeout mo2528b() {
            return this.f7954b.mo2528b();
        }

        @Override // p192f.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f7953a && !Util.m3170a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f7953a = true;
                this.f7955c.abort();
            }
            this.f7954b.close();
        }
    }

    public CacheInterceptor(InternalCache internalCache) {
        this.f7952a = internalCache;
    }

    /* renamed from: a */
    public static C1744d0 m3145a(C1744d0 c1744d0) {
        if (c1744d0 == null || c1744d0.m3225j() == null) {
            return c1744d0;
        }
        C1744d0.C1745a m3218q = c1744d0.m3218q();
        m3218q.m3209a((ResponseBody) null);
        return m3218q.m3214a();
    }

    @Override // p181e.Interceptor
    public C1744d0 intercept(Interceptor.InterfaceC1812a interfaceC1812a) {
        InternalCache internalCache = this.f7952a;
        C1744d0 m3132a = internalCache != null ? internalCache.m3132a(interfaceC1812a.mo2696a()) : null;
        CacheStrategy m3136c = new CacheStrategy.C1755a(System.currentTimeMillis(), interfaceC1812a.mo2696a(), m3132a).m3136c();
        C1737b0 c1737b0 = m3136c.f7957a;
        C1744d0 c1744d0 = m3136c.f7958b;
        InternalCache internalCache2 = this.f7952a;
        if (internalCache2 != null) {
            internalCache2.m3129a(m3136c);
        }
        if (m3132a != null && c1744d0 == null) {
            Util.m3169a(m3132a.m3225j());
        }
        if (c1737b0 == null && c1744d0 == null) {
            C1744d0.C1745a c1745a = new C1744d0.C1745a();
            c1745a.m3211a(interfaceC1812a.mo2696a());
            c1745a.m3206a(Protocol.HTTP_1_1);
            c1745a.m3213a(504);
            c1745a.m3205a("Unsatisfiable Request (only-if-cached)");
            c1745a.m3209a(Util.f7936c);
            c1745a.m3202b(-1L);
            c1745a.m3212a(System.currentTimeMillis());
            return c1745a.m3214a();
        } else if (c1737b0 == null) {
            C1744d0.C1745a m3218q = c1744d0.m3218q();
            m3218q.m3210a(m3145a(c1744d0));
            return m3218q.m3214a();
        } else {
            try {
                C1744d0 mo2695a = interfaceC1812a.mo2695a(c1737b0);
                if (mo2695a == null && m3132a != null) {
                }
                if (c1744d0 != null) {
                    if (mo2695a.m3223l() == 304) {
                        C1744d0.C1745a m3218q2 = c1744d0.m3218q();
                        m3218q2.m3207a(m3143a(c1744d0.m3221n(), mo2695a.m3221n()));
                        m3218q2.m3202b(mo2695a.m3215t());
                        m3218q2.m3212a(mo2695a.m3217r());
                        m3218q2.m3210a(m3145a(c1744d0));
                        m3218q2.m3200c(m3145a(mo2695a));
                        C1744d0 m3214a = m3218q2.m3214a();
                        mo2695a.m3225j().close();
                        this.f7952a.m3133a();
                        this.f7952a.m3130a(c1744d0, m3214a);
                        return m3214a;
                    }
                    Util.m3169a(c1744d0.m3225j());
                }
                C1744d0.C1745a m3218q3 = mo2695a.m3218q();
                m3218q3.m3210a(m3145a(c1744d0));
                m3218q3.m3200c(m3145a(mo2695a));
                C1744d0 m3214a2 = m3218q3.m3214a();
                if (this.f7952a != null) {
                    if (HttpHeaders.m3067b(m3214a2) && CacheStrategy.m3140a(m3214a2, c1737b0)) {
                        return m3144a(this.f7952a.m3131a(m3214a2), m3214a2);
                    }
                    if (C1758f.m3065a(c1737b0.m3256e())) {
                        try {
                            this.f7952a.m3128b(c1737b0);
                        } catch (IOException unused) {
                        }
                    }
                }
                return m3214a2;
            } finally {
                if (m3132a != null) {
                    Util.m3169a(m3132a.m3225j());
                }
            }
        }
    }

    /* renamed from: a */
    public final C1744d0 m3144a(CacheRequest cacheRequest, C1744d0 c1744d0) {
        Sink m3141a;
        if (cacheRequest == null || (m3141a = cacheRequest.m3141a()) == null) {
            return c1744d0;
        }
        C1754a c1754a = new C1754a(this, c1744d0.m3225j().mo670n(), cacheRequest, Okio.m2587a(m3141a));
        C1744d0.C1745a m3218q = c1744d0.m3218q();
        m3218q.m3209a(new RealResponseBody(c1744d0.m3221n(), Okio.m2586a(c1754a)));
        return m3218q.m3214a();
    }

    /* renamed from: a */
    public static Headers m3143a(Headers headers, Headers headers2) {
        Headers.C1809a c1809a = new Headers.C1809a();
        int m2762b = headers.m2762b();
        for (int i = 0; i < m2762b; i++) {
            String m2766a = headers.m2766a(i);
            String m2761b = headers.m2761b(i);
            if ((!"Warning".equalsIgnoreCase(m2766a) || !m2761b.startsWith("1")) && (!m3142a(m2766a) || headers2.m2765a(m2766a) == null)) {
                Internal.f7932a.mo2647a(c1809a, m2766a, m2761b);
            }
        }
        int m2762b2 = headers2.m2762b();
        for (int i2 = 0; i2 < m2762b2; i2++) {
            String m2766a2 = headers2.m2766a(i2);
            if (!"Content-Length".equalsIgnoreCase(m2766a2) && m3142a(m2766a2)) {
                Internal.f7932a.mo2647a(c1809a, m2766a2, headers2.m2761b(i2));
            }
        }
        return c1809a.m2759a();
    }

    /* renamed from: a */
    public static boolean m3142a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
