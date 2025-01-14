package e;

import e.t;
import java.io.Closeable;
/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class d0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f5507a;

    /* renamed from: b  reason: collision with root package name */
    public final z f5508b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5509c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5510d;

    /* renamed from: e  reason: collision with root package name */
    public final s f5511e;

    /* renamed from: f  reason: collision with root package name */
    public final t f5512f;

    /* renamed from: g  reason: collision with root package name */
    public final e0 f5513g;

    /* renamed from: h  reason: collision with root package name */
    public final d0 f5514h;

    /* renamed from: i  reason: collision with root package name */
    public final d0 f5515i;
    public final d0 j;
    public final long k;
    public final long m;
    public volatile d n;

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b0 f5516a;

        /* renamed from: b  reason: collision with root package name */
        public z f5517b;

        /* renamed from: c  reason: collision with root package name */
        public int f5518c;

        /* renamed from: d  reason: collision with root package name */
        public String f5519d;

        /* renamed from: e  reason: collision with root package name */
        public s f5520e;

        /* renamed from: f  reason: collision with root package name */
        public t.a f5521f;

        /* renamed from: g  reason: collision with root package name */
        public e0 f5522g;

        /* renamed from: h  reason: collision with root package name */
        public d0 f5523h;

        /* renamed from: i  reason: collision with root package name */
        public d0 f5524i;
        public d0 j;
        public long k;
        public long l;

        public a() {
            this.f5518c = -1;
            this.f5521f = new t.a();
        }

        public a a(b0 b0Var) {
            this.f5516a = b0Var;
            return this;
        }

        public final void b(d0 d0Var) {
            if (d0Var.f5513g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a c(d0 d0Var) {
            if (d0Var != null) {
                a("networkResponse", d0Var);
            }
            this.f5523h = d0Var;
            return this;
        }

        public a d(d0 d0Var) {
            if (d0Var != null) {
                b(d0Var);
            }
            this.j = d0Var;
            return this;
        }

        public a a(z zVar) {
            this.f5517b = zVar;
            return this;
        }

        public a a(int i2) {
            this.f5518c = i2;
            return this;
        }

        public a b(long j) {
            this.k = j;
            return this;
        }

        public a(d0 d0Var) {
            this.f5518c = -1;
            this.f5516a = d0Var.f5507a;
            this.f5517b = d0Var.f5508b;
            this.f5518c = d0Var.f5509c;
            this.f5519d = d0Var.f5510d;
            this.f5520e = d0Var.f5511e;
            this.f5521f = d0Var.f5512f.a();
            this.f5522g = d0Var.f5513g;
            this.f5523h = d0Var.f5514h;
            this.f5524i = d0Var.f5515i;
            this.j = d0Var.j;
            this.k = d0Var.k;
            this.l = d0Var.m;
        }

        public a a(String str) {
            this.f5519d = str;
            return this;
        }

        public a a(s sVar) {
            this.f5520e = sVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f5521f.a(str, str2);
            return this;
        }

        public a a(t tVar) {
            this.f5521f = tVar.a();
            return this;
        }

        public a a(e0 e0Var) {
            this.f5522g = e0Var;
            return this;
        }

        public a a(d0 d0Var) {
            if (d0Var != null) {
                a("cacheResponse", d0Var);
            }
            this.f5524i = d0Var;
            return this;
        }

        public final void a(String str, d0 d0Var) {
            if (d0Var.f5513g == null) {
                if (d0Var.f5514h == null) {
                    if (d0Var.f5515i == null) {
                        if (d0Var.j == null) {
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

        public a a(long j) {
            this.l = j;
            return this;
        }

        public d0 a() {
            if (this.f5516a != null) {
                if (this.f5517b != null) {
                    if (this.f5518c >= 0) {
                        if (this.f5519d != null) {
                            return new d0(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f5518c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    public d0(a aVar) {
        this.f5507a = aVar.f5516a;
        this.f5508b = aVar.f5517b;
        this.f5509c = aVar.f5518c;
        this.f5510d = aVar.f5519d;
        this.f5511e = aVar.f5520e;
        this.f5512f = aVar.f5521f.a();
        this.f5513g = aVar.f5522g;
        this.f5514h = aVar.f5523h;
        this.f5515i = aVar.f5524i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.m = aVar.l;
    }

    public String a(String str, String str2) {
        String a2 = this.f5512f.a(str);
        return a2 != null ? a2 : str2;
    }

    public String b(String str) {
        return a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5513g.close();
    }

    public e0 j() {
        return this.f5513g;
    }

    public d k() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f5512f);
        this.n = a2;
        return a2;
    }

    public int l() {
        return this.f5509c;
    }

    public s m() {
        return this.f5511e;
    }

    public t n() {
        return this.f5512f;
    }

    public boolean o() {
        int i2 = this.f5509c;
        return i2 >= 200 && i2 < 300;
    }

    public String p() {
        return this.f5510d;
    }

    public a q() {
        return new a(this);
    }

    public long r() {
        return this.m;
    }

    public b0 s() {
        return this.f5507a;
    }

    public long t() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.f5508b + ", code=" + this.f5509c + ", message=" + this.f5510d + ", url=" + this.f5507a.g() + '}';
    }
}
