package e.i0.e;

import e.b0;
import e.d0;
import e.i0.g.e;
import e.t;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* compiled from: CacheStrategy.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f5578a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f5579b;

    public c(b0 b0Var, d0 d0Var) {
        this.f5578a = b0Var;
        this.f5579b = d0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
        if (r3.k().b() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(e.d0 r3, e.b0 r4) {
        /*
            int r0 = r3.l()
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
            java.lang.String r0 = r3.b(r0)
            if (r0 != 0) goto L5a
            e.d r0 = r3.k()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            e.d r0 = r3.k()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            e.d r0 = r3.k()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            e.d r3 = r3.k()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            e.d r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i0.e.c.a(e.d0, e.b0):boolean");
    }

    /* compiled from: CacheStrategy.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f5580a;

        /* renamed from: b  reason: collision with root package name */
        public final b0 f5581b;

        /* renamed from: c  reason: collision with root package name */
        public final d0 f5582c;

        /* renamed from: d  reason: collision with root package name */
        public Date f5583d;

        /* renamed from: e  reason: collision with root package name */
        public String f5584e;

        /* renamed from: f  reason: collision with root package name */
        public Date f5585f;

        /* renamed from: g  reason: collision with root package name */
        public String f5586g;

        /* renamed from: h  reason: collision with root package name */
        public Date f5587h;

        /* renamed from: i  reason: collision with root package name */
        public long f5588i;
        public long j;
        public String k;
        public int l;

        public a(long j, b0 b0Var, d0 d0Var) {
            this.l = -1;
            this.f5580a = j;
            this.f5581b = b0Var;
            this.f5582c = d0Var;
            if (d0Var != null) {
                this.f5588i = d0Var.t();
                this.j = d0Var.r();
                t n = d0Var.n();
                int b2 = n.b();
                for (int i2 = 0; i2 < b2; i2++) {
                    String a2 = n.a(i2);
                    String b3 = n.b(i2);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f5583d = e.i0.g.d.a(b3);
                        this.f5584e = b3;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.f5587h = e.i0.g.d.a(b3);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f5585f = e.i0.g.d.a(b3);
                        this.f5586g = b3;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.k = b3;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.l = e.a(b3, -1);
                    }
                }
            }
        }

        public final long a() {
            Date date = this.f5583d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i2 = this.l;
            if (i2 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i2));
            }
            long j = this.j;
            return max + (j - this.f5588i) + (this.f5580a - j);
        }

        public final long b() {
            long j;
            long j2;
            e.d k = this.f5582c.k();
            if (k.d() != -1) {
                return TimeUnit.SECONDS.toMillis(k.d());
            }
            if (this.f5587h != null) {
                Date date = this.f5583d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.j;
                }
                long time = this.f5587h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f5585f == null || this.f5582c.s().g().l() != null) {
                return 0L;
            } else {
                Date date2 = this.f5583d;
                if (date2 != null) {
                    j = date2.getTime();
                } else {
                    j = this.f5588i;
                }
                long time2 = j - this.f5585f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0L;
            }
        }

        public c c() {
            c d2 = d();
            return (d2.f5578a == null || !this.f5581b.b().j()) ? d2 : new c(null, null);
        }

        public final c d() {
            if (this.f5582c == null) {
                return new c(this.f5581b, null);
            }
            if (this.f5581b.d() && this.f5582c.m() == null) {
                return new c(this.f5581b, null);
            }
            if (!c.a(this.f5582c, this.f5581b)) {
                return new c(this.f5581b, null);
            }
            e.d b2 = this.f5581b.b();
            if (!b2.h() && !a(this.f5581b)) {
                long a2 = a();
                long b3 = b();
                if (b2.d() != -1) {
                    b3 = Math.min(b3, TimeUnit.SECONDS.toMillis(b2.d()));
                }
                long j = 0;
                long millis = b2.f() != -1 ? TimeUnit.SECONDS.toMillis(b2.f()) : 0L;
                e.d k = this.f5582c.k();
                if (!k.g() && b2.e() != -1) {
                    j = TimeUnit.SECONDS.toMillis(b2.e());
                }
                if (!k.h()) {
                    long j2 = millis + a2;
                    if (j2 < j + b3) {
                        d0.a q = this.f5582c.q();
                        if (j2 >= b3) {
                            q.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (a2 > 86400000 && e()) {
                            q.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new c(null, q.a());
                    }
                }
                String str = this.k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f5585f != null) {
                    str = this.f5586g;
                } else if (this.f5583d != null) {
                    str = this.f5584e;
                } else {
                    return new c(this.f5581b, null);
                }
                t.a a3 = this.f5581b.c().a();
                e.i0.a.f5560a.a(a3, str2, str);
                b0.a f2 = this.f5581b.f();
                f2.a(a3.a());
                return new c(f2.a(), this.f5582c);
            }
            return new c(this.f5581b, null);
        }

        public final boolean e() {
            return this.f5582c.k().d() == -1 && this.f5587h == null;
        }

        public static boolean a(b0 b0Var) {
            return (b0Var.a("If-Modified-Since") == null && b0Var.a("If-None-Match") == null) ? false : true;
        }
    }
}
