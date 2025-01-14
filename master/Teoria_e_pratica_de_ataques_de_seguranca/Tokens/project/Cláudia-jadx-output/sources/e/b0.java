package e;

import e.t;
/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final u f5470a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5471b;

    /* renamed from: c  reason: collision with root package name */
    public final t f5472c;

    /* renamed from: d  reason: collision with root package name */
    public final c0 f5473d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f5474e;

    /* renamed from: f  reason: collision with root package name */
    public volatile d f5475f;

    public b0(a aVar) {
        this.f5470a = aVar.f5476a;
        this.f5471b = aVar.f5477b;
        this.f5472c = aVar.f5478c.a();
        this.f5473d = aVar.f5479d;
        Object obj = aVar.f5480e;
        this.f5474e = obj == null ? this : obj;
    }

    public String a(String str) {
        return this.f5472c.a(str);
    }

    public d b() {
        d dVar = this.f5475f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f5472c);
        this.f5475f = a2;
        return a2;
    }

    public t c() {
        return this.f5472c;
    }

    public boolean d() {
        return this.f5470a.h();
    }

    public String e() {
        return this.f5471b;
    }

    public a f() {
        return new a(this);
    }

    public u g() {
        return this.f5470a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f5471b);
        sb.append(", url=");
        sb.append(this.f5470a);
        sb.append(", tag=");
        Object obj = this.f5474e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* compiled from: Request.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public u f5476a;

        /* renamed from: b  reason: collision with root package name */
        public String f5477b;

        /* renamed from: c  reason: collision with root package name */
        public t.a f5478c;

        /* renamed from: d  reason: collision with root package name */
        public c0 f5479d;

        /* renamed from: e  reason: collision with root package name */
        public Object f5480e;

        public a() {
            this.f5477b = "GET";
            this.f5478c = new t.a();
        }

        public a a(u uVar) {
            if (uVar != null) {
                this.f5476a = uVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a b(String str, String str2) {
            this.f5478c.d(str, str2);
            return this;
        }

        public a a(String str, String str2) {
            this.f5478c.a(str, str2);
            return this;
        }

        public a(b0 b0Var) {
            this.f5476a = b0Var.f5470a;
            this.f5477b = b0Var.f5471b;
            this.f5479d = b0Var.f5473d;
            this.f5480e = b0Var.f5474e;
            this.f5478c = b0Var.f5472c.a();
        }

        public a a(String str) {
            this.f5478c.b(str);
            return this;
        }

        public a a(t tVar) {
            this.f5478c = tVar.a();
            return this;
        }

        public a a(String str, c0 c0Var) {
            if (str != null) {
                if (str.length() != 0) {
                    if (c0Var != null && !e.i0.g.f.b(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    } else if (c0Var == null && e.i0.g.f.e(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    } else {
                        this.f5477b = str;
                        this.f5479d = c0Var;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        public b0 a() {
            if (this.f5476a != null) {
                return new b0(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public c0 a() {
        return this.f5473d;
    }
}
