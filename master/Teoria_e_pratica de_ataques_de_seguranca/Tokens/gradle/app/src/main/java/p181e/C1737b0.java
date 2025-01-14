package p181e;

import p181e.Headers;
import p181e.p182i0.p185g.C1758f;

/* compiled from: Request.java */
/* renamed from: e.b0 */
/* loaded from: classes.dex */
public final class C1737b0 {

    /* renamed from: a */
    public final HttpUrl f7822a;

    /* renamed from: b */
    public final String f7823b;

    /* renamed from: c */
    public final Headers f7824c;

    /* renamed from: d */
    public final RequestBody f7825d;

    /* renamed from: e */
    public final Object f7826e;

    /* renamed from: f */
    public volatile CacheControl f7827f;

    public C1737b0(C1738a c1738a) {
        this.f7822a = c1738a.f7828a;
        this.f7823b = c1738a.f7829b;
        this.f7824c = c1738a.f7830c.m2759a();
        this.f7825d = c1738a.f7831d;
        Object obj = c1738a.f7832e;
        this.f7826e = obj == null ? this : obj;
    }

    /* renamed from: a */
    public String m3260a(String str) {
        return this.f7824c.m2765a(str);
    }

    /* renamed from: b */
    public CacheControl m3259b() {
        CacheControl cacheControl = this.f7827f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl m3241a = CacheControl.m3241a(this.f7824c);
        this.f7827f = m3241a;
        return m3241a;
    }

    /* renamed from: c */
    public Headers m3258c() {
        return this.f7824c;
    }

    /* renamed from: d */
    public boolean m3257d() {
        return this.f7822a.m2729h();
    }

    /* renamed from: e */
    public String m3256e() {
        return this.f7823b;
    }

    /* renamed from: f */
    public C1738a m3255f() {
        return new C1738a(this);
    }

    /* renamed from: g */
    public HttpUrl m3254g() {
        return this.f7822a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f7823b);
        sb.append(", url=");
        sb.append(this.f7822a);
        sb.append(", tag=");
        Object obj = this.f7826e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* compiled from: Request.java */
    /* renamed from: e.b0$a */
    /* loaded from: classes.dex */
    public static class C1738a {

        /* renamed from: a */
        public HttpUrl f7828a;

        /* renamed from: b */
        public String f7829b;

        /* renamed from: c */
        public Headers.C1809a f7830c;

        /* renamed from: d */
        public RequestBody f7831d;

        /* renamed from: e */
        public Object f7832e;

        public C1738a() {
            this.f7829b = "GET";
            this.f7830c = new Headers.C1809a();
        }

        /* renamed from: a */
        public C1738a m3251a(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.f7828a = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: b */
        public C1738a m3247b(String str, String str2) {
            this.f7830c.m2753d(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1738a m3248a(String str, String str2) {
            this.f7830c.m2757a(str, str2);
            return this;
        }

        public C1738a(C1737b0 c1737b0) {
            this.f7828a = c1737b0.f7822a;
            this.f7829b = c1737b0.f7823b;
            this.f7831d = c1737b0.f7825d;
            this.f7832e = c1737b0.f7826e;
            this.f7830c = c1737b0.f7824c.m2767a();
        }

        /* renamed from: a */
        public C1738a m3250a(String str) {
            this.f7830c.m2756b(str);
            return this;
        }

        /* renamed from: a */
        public C1738a m3252a(Headers headers) {
            this.f7830c = headers.m2767a();
            return this;
        }

        /* renamed from: a */
        public C1738a m3249a(String str, RequestBody requestBody) {
            if (str != null) {
                if (str.length() != 0) {
                    if (requestBody != null && !C1758f.m3064b(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    } else if (requestBody == null && C1758f.m3061e(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    } else {
                        this.f7829b = str;
                        this.f7831d = requestBody;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        /* renamed from: a */
        public C1737b0 m3253a() {
            if (this.f7828a != null) {
                return new C1737b0(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    /* renamed from: a */
    public RequestBody m3261a() {
        return this.f7825d;
    }
}
