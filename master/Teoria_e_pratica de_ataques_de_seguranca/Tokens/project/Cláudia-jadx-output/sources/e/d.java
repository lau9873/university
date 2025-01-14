package e;

import java.util.concurrent.TimeUnit;
/* compiled from: CacheControl.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5490a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5491b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5492c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5493d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5494e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5495f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5496g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5497h;

    /* renamed from: i  reason: collision with root package name */
    public final int f5498i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    static {
        a aVar = new a();
        aVar.b();
        aVar.a();
        a aVar2 = new a();
        aVar2.c();
        aVar2.a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        aVar2.a();
    }

    public d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.f5490a = z;
        this.f5491b = z2;
        this.f5492c = i2;
        this.f5493d = i3;
        this.f5494e = z3;
        this.f5495f = z4;
        this.f5496g = z5;
        this.f5497h = i4;
        this.f5498i = i5;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static e.d a(e.t r22) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a(e.t):e.d");
    }

    public boolean b() {
        return this.f5494e;
    }

    public boolean c() {
        return this.f5495f;
    }

    public int d() {
        return this.f5492c;
    }

    public int e() {
        return this.f5497h;
    }

    public int f() {
        return this.f5498i;
    }

    public boolean g() {
        return this.f5496g;
    }

    public boolean h() {
        return this.f5490a;
    }

    public boolean i() {
        return this.f5491b;
    }

    public boolean j() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String a2 = a();
        this.m = a2;
        return a2;
    }

    /* compiled from: CacheControl.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5499a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5500b;

        /* renamed from: c  reason: collision with root package name */
        public int f5501c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f5502d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f5503e = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f5504f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5505g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f5506h;

        public a a(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds(i2);
                this.f5502d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }

        public a b() {
            this.f5499a = true;
            return this;
        }

        public a c() {
            this.f5504f = true;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f5490a = aVar.f5499a;
        this.f5491b = aVar.f5500b;
        this.f5492c = aVar.f5501c;
        this.f5493d = -1;
        this.f5494e = false;
        this.f5495f = false;
        this.f5496g = false;
        this.f5497h = aVar.f5502d;
        this.f5498i = aVar.f5503e;
        this.j = aVar.f5504f;
        this.k = aVar.f5505g;
        this.l = aVar.f5506h;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        if (this.f5490a) {
            sb.append("no-cache, ");
        }
        if (this.f5491b) {
            sb.append("no-store, ");
        }
        if (this.f5492c != -1) {
            sb.append("max-age=");
            sb.append(this.f5492c);
            sb.append(", ");
        }
        if (this.f5493d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f5493d);
            sb.append(", ");
        }
        if (this.f5494e) {
            sb.append("private, ");
        }
        if (this.f5495f) {
            sb.append("public, ");
        }
        if (this.f5496g) {
            sb.append("must-revalidate, ");
        }
        if (this.f5497h != -1) {
            sb.append("max-stale=");
            sb.append(this.f5497h);
            sb.append(", ");
        }
        if (this.f5498i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f5498i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
