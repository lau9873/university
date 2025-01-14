package p181e;

import java.util.concurrent.TimeUnit;

/* renamed from: e.d */
/* loaded from: classes.dex */
public final class CacheControl {

    /* renamed from: a */
    public final boolean f7842a;

    /* renamed from: b */
    public final boolean f7843b;

    /* renamed from: c */
    public final int f7844c;

    /* renamed from: d */
    public final int f7845d;

    /* renamed from: e */
    public final boolean f7846e;

    /* renamed from: f */
    public final boolean f7847f;

    /* renamed from: g */
    public final boolean f7848g;

    /* renamed from: h */
    public final int f7849h;

    /* renamed from: i */
    public final int f7850i;

    /* renamed from: j */
    public final boolean f7851j;

    /* renamed from: k */
    public final boolean f7852k;

    /* renamed from: l */
    public final boolean f7853l;

    /* renamed from: m */
    public String f7854m;

    static {
        C1743a c1743a = new C1743a();
        c1743a.m3229b();
        c1743a.m3231a();
        C1743a c1743a2 = new C1743a();
        c1743a2.m3228c();
        c1743a2.m3230a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        c1743a2.m3231a();
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f7842a = z;
        this.f7843b = z2;
        this.f7844c = i;
        this.f7845d = i2;
        this.f7846e = z3;
        this.f7847f = z4;
        this.f7848g = z5;
        this.f7849h = i3;
        this.f7850i = i4;
        this.f7851j = z6;
        this.f7852k = z7;
        this.f7853l = z8;
        this.f7854m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p181e.CacheControl m3241a(p181e.Headers r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p181e.CacheControl.m3241a(e.t):e.d");
    }

    /* renamed from: b */
    public boolean m3240b() {
        return this.f7846e;
    }

    /* renamed from: c */
    public boolean m3239c() {
        return this.f7847f;
    }

    /* renamed from: d */
    public int m3238d() {
        return this.f7844c;
    }

    /* renamed from: e */
    public int m3237e() {
        return this.f7849h;
    }

    /* renamed from: f */
    public int m3236f() {
        return this.f7850i;
    }

    /* renamed from: g */
    public boolean m3235g() {
        return this.f7848g;
    }

    /* renamed from: h */
    public boolean m3234h() {
        return this.f7842a;
    }

    /* renamed from: i */
    public boolean m3233i() {
        return this.f7843b;
    }

    /* renamed from: j */
    public boolean m3232j() {
        return this.f7851j;
    }

    public String toString() {
        String str = this.f7854m;
        if (str != null) {
            return str;
        }
        String m3242a = m3242a();
        this.f7854m = m3242a;
        return m3242a;
    }

    /* compiled from: CacheControl.java */
    /* renamed from: e.d$a */
    /* loaded from: classes.dex */
    public static final class C1743a {

        /* renamed from: a */
        public boolean f7855a;

        /* renamed from: b */
        public boolean f7856b;

        /* renamed from: c */
        public int f7857c = -1;

        /* renamed from: d */
        public int f7858d = -1;

        /* renamed from: e */
        public int f7859e = -1;

        /* renamed from: f */
        public boolean f7860f;

        /* renamed from: g */
        public boolean f7861g;

        /* renamed from: h */
        public boolean f7862h;

        /* renamed from: a */
        public C1743a m3230a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f7858d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        /* renamed from: b */
        public C1743a m3229b() {
            this.f7855a = true;
            return this;
        }

        /* renamed from: c */
        public C1743a m3228c() {
            this.f7860f = true;
            return this;
        }

        /* renamed from: a */
        public CacheControl m3231a() {
            return new CacheControl(this);
        }
    }

    public CacheControl(C1743a c1743a) {
        this.f7842a = c1743a.f7855a;
        this.f7843b = c1743a.f7856b;
        this.f7844c = c1743a.f7857c;
        this.f7845d = -1;
        this.f7846e = false;
        this.f7847f = false;
        this.f7848g = false;
        this.f7849h = c1743a.f7858d;
        this.f7850i = c1743a.f7859e;
        this.f7851j = c1743a.f7860f;
        this.f7852k = c1743a.f7861g;
        this.f7853l = c1743a.f7862h;
    }

    /* renamed from: a */
    public final String m3242a() {
        StringBuilder sb = new StringBuilder();
        if (this.f7842a) {
            sb.append("no-cache, ");
        }
        if (this.f7843b) {
            sb.append("no-store, ");
        }
        if (this.f7844c != -1) {
            sb.append("max-age=");
            sb.append(this.f7844c);
            sb.append(", ");
        }
        if (this.f7845d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f7845d);
            sb.append(", ");
        }
        if (this.f7846e) {
            sb.append("private, ");
        }
        if (this.f7847f) {
            sb.append("public, ");
        }
        if (this.f7848g) {
            sb.append("must-revalidate, ");
        }
        if (this.f7849h != -1) {
            sb.append("max-stale=");
            sb.append(this.f7849h);
            sb.append(", ");
        }
        if (this.f7850i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f7850i);
            sb.append(", ");
        }
        if (this.f7851j) {
            sb.append("only-if-cached, ");
        }
        if (this.f7852k) {
            sb.append("no-transform, ");
        }
        if (this.f7853l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
