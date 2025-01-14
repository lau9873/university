package p181e;

import java.io.Closeable;
import p181e.Headers;

/* compiled from: Response.java */
/* renamed from: e.d0 */
/* loaded from: classes.dex */
public final class C1744d0 implements Closeable {

    /* renamed from: a */
    public final C1737b0 f7863a;

    /* renamed from: b */
    public final Protocol f7864b;

    /* renamed from: c */
    public final int f7865c;

    /* renamed from: d */
    public final String f7866d;

    /* renamed from: e */
    public final Handshake f7867e;

    /* renamed from: f */
    public final Headers f7868f;

    /* renamed from: g */
    public final ResponseBody f7869g;

    /* renamed from: h */
    public final C1744d0 f7870h;

    /* renamed from: i */
    public final C1744d0 f7871i;

    /* renamed from: j */
    public final C1744d0 f7872j;

    /* renamed from: k */
    public final long f7873k;

    /* renamed from: m */
    public final long f7874m;

    /* renamed from: n */
    public volatile CacheControl f7875n;

    /* compiled from: Response.java */
    /* renamed from: e.d0$a */
    /* loaded from: classes.dex */
    public static class C1745a {

        /* renamed from: a */
        public C1737b0 f7876a;

        /* renamed from: b */
        public Protocol f7877b;

        /* renamed from: c */
        public int f7878c;

        /* renamed from: d */
        public String f7879d;

        /* renamed from: e */
        public Handshake f7880e;

        /* renamed from: f */
        public Headers.C1809a f7881f;

        /* renamed from: g */
        public ResponseBody f7882g;

        /* renamed from: h */
        public C1744d0 f7883h;

        /* renamed from: i */
        public C1744d0 f7884i;

        /* renamed from: j */
        public C1744d0 f7885j;

        /* renamed from: k */
        public long f7886k;

        /* renamed from: l */
        public long f7887l;

        public C1745a() {
            this.f7878c = -1;
            this.f7881f = new Headers.C1809a();
        }

        /* renamed from: a */
        public C1745a m3211a(C1737b0 c1737b0) {
            this.f7876a = c1737b0;
            return this;
        }

        /* renamed from: b */
        public final void m3201b(C1744d0 c1744d0) {
            if (c1744d0.f7869g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: c */
        public C1745a m3200c(C1744d0 c1744d0) {
            if (c1744d0 != null) {
                m3204a("networkResponse", c1744d0);
            }
            this.f7883h = c1744d0;
            return this;
        }

        /* renamed from: d */
        public C1745a m3199d(C1744d0 c1744d0) {
            if (c1744d0 != null) {
                m3201b(c1744d0);
            }
            this.f7885j = c1744d0;
            return this;
        }

        /* renamed from: a */
        public C1745a m3206a(Protocol protocol) {
            this.f7877b = protocol;
            return this;
        }

        /* renamed from: a */
        public C1745a m3213a(int i) {
            this.f7878c = i;
            return this;
        }

        /* renamed from: b */
        public C1745a m3202b(long j) {
            this.f7886k = j;
            return this;
        }

        public C1745a(C1744d0 c1744d0) {
            this.f7878c = -1;
            this.f7876a = c1744d0.f7863a;
            this.f7877b = c1744d0.f7864b;
            this.f7878c = c1744d0.f7865c;
            this.f7879d = c1744d0.f7866d;
            this.f7880e = c1744d0.f7867e;
            this.f7881f = c1744d0.f7868f.m2767a();
            this.f7882g = c1744d0.f7869g;
            this.f7883h = c1744d0.f7870h;
            this.f7884i = c1744d0.f7871i;
            this.f7885j = c1744d0.f7872j;
            this.f7886k = c1744d0.f7873k;
            this.f7887l = c1744d0.f7874m;
        }

        /* renamed from: a */
        public C1745a m3205a(String str) {
            this.f7879d = str;
            return this;
        }

        /* renamed from: a */
        public C1745a m3208a(Handshake handshake) {
            this.f7880e = handshake;
            return this;
        }

        /* renamed from: a */
        public C1745a m3203a(String str, String str2) {
            this.f7881f.m2757a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1745a m3207a(Headers headers) {
            this.f7881f = headers.m2767a();
            return this;
        }

        /* renamed from: a */
        public C1745a m3209a(ResponseBody responseBody) {
            this.f7882g = responseBody;
            return this;
        }

        /* renamed from: a */
        public C1745a m3210a(C1744d0 c1744d0) {
            if (c1744d0 != null) {
                m3204a("cacheResponse", c1744d0);
            }
            this.f7884i = c1744d0;
            return this;
        }

        /* renamed from: a */
        public final void m3204a(String str, C1744d0 c1744d0) {
            if (c1744d0.f7869g == null) {
                if (c1744d0.f7870h == null) {
                    if (c1744d0.f7871i == null) {
                        if (c1744d0.f7872j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        /* renamed from: a */
        public C1745a m3212a(long j) {
            this.f7887l = j;
            return this;
        }

        /* renamed from: a */
        public C1744d0 m3214a() {
            if (this.f7876a != null) {
                if (this.f7877b != null) {
                    if (this.f7878c >= 0) {
                        if (this.f7879d != null) {
                            return new C1744d0(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f7878c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public C1744d0(C1745a c1745a) {
        this.f7863a = c1745a.f7876a;
        this.f7864b = c1745a.f7877b;
        this.f7865c = c1745a.f7878c;
        this.f7866d = c1745a.f7879d;
        this.f7867e = c1745a.f7880e;
        this.f7868f = c1745a.f7881f.m2759a();
        this.f7869g = c1745a.f7882g;
        this.f7870h = c1745a.f7883h;
        this.f7871i = c1745a.f7884i;
        this.f7872j = c1745a.f7885j;
        this.f7873k = c1745a.f7886k;
        this.f7874m = c1745a.f7887l;
    }

    /* renamed from: a */
    public String m3227a(String str, String str2) {
        String m2765a = this.f7868f.m2765a(str);
        return m2765a != null ? m2765a : str2;
    }

    /* renamed from: b */
    public String m3226b(String str) {
        return m3227a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7869g.close();
    }

    /* renamed from: j */
    public ResponseBody m3225j() {
        return this.f7869g;
    }

    /* renamed from: k */
    public CacheControl m3224k() {
        CacheControl cacheControl = this.f7875n;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl m3241a = CacheControl.m3241a(this.f7868f);
        this.f7875n = m3241a;
        return m3241a;
    }

    /* renamed from: l */
    public int m3223l() {
        return this.f7865c;
    }

    /* renamed from: m */
    public Handshake m3222m() {
        return this.f7867e;
    }

    /* renamed from: n */
    public Headers m3221n() {
        return this.f7868f;
    }

    /* renamed from: o */
    public boolean m3220o() {
        int i = this.f7865c;
        return i >= 200 && i < 300;
    }

    /* renamed from: p */
    public String m3219p() {
        return this.f7866d;
    }

    /* renamed from: q */
    public C1745a m3218q() {
        return new C1745a(this);
    }

    /* renamed from: r */
    public long m3217r() {
        return this.f7874m;
    }

    /* renamed from: s */
    public C1737b0 m3216s() {
        return this.f7863a;
    }

    /* renamed from: t */
    public long m3215t() {
        return this.f7873k;
    }

    public String toString() {
        return "Response{protocol=" + this.f7864b + ", code=" + this.f7865c + ", message=" + this.f7866d + ", url=" + this.f7863a.m3254g() + '}';
    }
}
