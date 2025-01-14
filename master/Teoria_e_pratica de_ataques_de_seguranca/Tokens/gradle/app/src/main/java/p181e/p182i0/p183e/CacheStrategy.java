package p181e.p182i0.p183e;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.CacheControl;
import p181e.Headers;
import p181e.p182i0.Internal;
import p181e.p182i0.p185g.HttpDate;
import p181e.p182i0.p185g.HttpHeaders;

/* renamed from: e.i0.e.c */
/* loaded from: classes.dex */
public final class CacheStrategy {

    /* renamed from: a */
    public final C1737b0 f7957a;

    /* renamed from: b */
    public final C1744d0 f7958b;

    public CacheStrategy(C1737b0 c1737b0, C1744d0 c1744d0) {
        this.f7957a = c1737b0;
        this.f7958b = c1744d0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r3.m3224k().m3240b() == false) goto L22;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m3140a(p181e.C1744d0 r3, p181e.C1737b0 r4) {
        /*
            int r0 = r3.m3223l()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.m3226b(r0)
            if (r0 != 0) goto L5a
            e.d r0 = r3.m3224k()
            int r0 = r0.m3238d()
            r1 = -1
            if (r0 != r1) goto L5a
            e.d r0 = r3.m3224k()
            boolean r0 = r0.m3239c()
            if (r0 != 0) goto L5a
            e.d r0 = r3.m3224k()
            boolean r0 = r0.m3240b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            e.d r3 = r3.m3224k()
            boolean r3 = r3.m3233i()
            if (r3 != 0) goto L6f
            e.d r3 = r4.m3259b()
            boolean r3 = r3.m3233i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p181e.p182i0.p183e.CacheStrategy.m3140a(e.d0, e.b0):boolean");
    }

    /* compiled from: CacheStrategy.java */
    /* renamed from: e.i0.e.c$a */
    /* loaded from: classes.dex */
    public static class C1755a {

        /* renamed from: a */
        public final long f7959a;

        /* renamed from: b */
        public final C1737b0 f7960b;

        /* renamed from: c */
        public final C1744d0 f7961c;

        /* renamed from: d */
        public Date f7962d;

        /* renamed from: e */
        public String f7963e;

        /* renamed from: f */
        public Date f7964f;

        /* renamed from: g */
        public String f7965g;

        /* renamed from: h */
        public Date f7966h;

        /* renamed from: i */
        public long f7967i;

        /* renamed from: j */
        public long f7968j;

        /* renamed from: k */
        public String f7969k;

        /* renamed from: l */
        public int f7970l;

        public C1755a(long j, C1737b0 c1737b0, C1744d0 c1744d0) {
            this.f7970l = -1;
            this.f7959a = j;
            this.f7960b = c1737b0;
            this.f7961c = c1744d0;
            if (c1744d0 != null) {
                this.f7967i = c1744d0.m3215t();
                this.f7968j = c1744d0.m3217r();
                Headers m3221n = c1744d0.m3221n();
                int m2762b = m3221n.m2762b();
                for (int i = 0; i < m2762b; i++) {
                    String m2766a = m3221n.m2766a(i);
                    String m2761b = m3221n.m2761b(i);
                    if ("Date".equalsIgnoreCase(m2766a)) {
                        this.f7962d = HttpDate.m3075a(m2761b);
                        this.f7963e = m2761b;
                    } else if ("Expires".equalsIgnoreCase(m2766a)) {
                        this.f7966h = HttpDate.m3075a(m2761b);
                    } else if ("Last-Modified".equalsIgnoreCase(m2766a)) {
                        this.f7964f = HttpDate.m3075a(m2761b);
                        this.f7965g = m2761b;
                    } else if ("ETag".equalsIgnoreCase(m2766a)) {
                        this.f7969k = m2761b;
                    } else if ("Age".equalsIgnoreCase(m2766a)) {
                        this.f7970l = HttpHeaders.m3069a(m2761b, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        public final long m3139a() {
            Date date = this.f7962d;
            long max = date != null ? Math.max(0L, this.f7968j - date.getTime()) : 0L;
            int i = this.f7970l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.f7968j;
            return max + (j - this.f7967i) + (this.f7959a - j);
        }

        /* renamed from: b */
        public final long m3137b() {
            long j;
            long j2;
            CacheControl m3224k = this.f7961c.m3224k();
            if (m3224k.m3238d() != -1) {
                return TimeUnit.SECONDS.toMillis(m3224k.m3238d());
            }
            if (this.f7966h != null) {
                Date date = this.f7962d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.f7968j;
                }
                long time = this.f7966h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f7964f == null || this.f7961c.m3216s().m3254g().m2725l() != null) {
                return 0L;
            } else {
                Date date2 = this.f7962d;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.f7967i;
                }
                long time2 = j - this.f7964f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        /* renamed from: c */
        public CacheStrategy m3136c() {
            CacheStrategy m3135d = m3135d();
            return (m3135d.f7957a == null || !this.f7960b.m3259b().m3232j()) ? m3135d : new CacheStrategy(null, null);
        }

        /* renamed from: d */
        public final CacheStrategy m3135d() {
            if (this.f7961c == null) {
                return new CacheStrategy(this.f7960b, null);
            }
            if (this.f7960b.m3257d() && this.f7961c.m3222m() == null) {
                return new CacheStrategy(this.f7960b, null);
            }
            if (!CacheStrategy.m3140a(this.f7961c, this.f7960b)) {
                return new CacheStrategy(this.f7960b, null);
            }
            CacheControl m3259b = this.f7960b.m3259b();
            if (!m3259b.m3234h() && !m3138a(this.f7960b)) {
                long m3139a = m3139a();
                long m3137b = m3137b();
                if (m3259b.m3238d() != -1) {
                    m3137b = Math.min(m3137b, TimeUnit.SECONDS.toMillis(m3259b.m3238d()));
                }
                long j = 0;
                long millis = m3259b.m3236f() != -1 ? TimeUnit.SECONDS.toMillis(m3259b.m3236f()) : 0L;
                CacheControl m3224k = this.f7961c.m3224k();
                if (!m3224k.m3235g() && m3259b.m3237e() != -1) {
                    j = TimeUnit.SECONDS.toMillis(m3259b.m3237e());
                }
                if (!m3224k.m3234h()) {
                    long j2 = millis + m3139a;
                    if (j2 < j + m3137b) {
                        C1744d0.C1745a m3218q = this.f7961c.m3218q();
                        if (j2 >= m3137b) {
                            m3218q.m3203a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (m3139a > 86400000 && m3134e()) {
                            m3218q.m3203a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new CacheStrategy(null, m3218q.m3214a());
                    }
                }
                String str = this.f7969k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f7964f != null) {
                    str = this.f7965g;
                } else if (this.f7962d != null) {
                    str = this.f7963e;
                } else {
                    return new CacheStrategy(this.f7960b, null);
                }
                Headers.C1809a m2767a = this.f7960b.m3258c().m2767a();
                Internal.f7932a.mo2647a(m2767a, str2, str);
                C1737b0.C1738a m3255f = this.f7960b.m3255f();
                m3255f.m3252a(m2767a.m2759a());
                return new CacheStrategy(m3255f.m3253a(), this.f7961c);
            }
            return new CacheStrategy(this.f7960b, null);
        }

        /* renamed from: e */
        public final boolean m3134e() {
            return this.f7961c.m3224k().m3238d() == -1 && this.f7966h == null;
        }

        /* renamed from: a */
        public static boolean m3138a(C1737b0 c1737b0) {
            return (c1737b0.m3260a("If-Modified-Since") == null && c1737b0.m3260a("If-None-Match") == null) ? false : true;
        }
    }
}
