package e.i0.e;

import e.b0;
import e.d0;
import e.e0;
import e.i0.e.c;
import e.i0.g.f;
import e.i0.g.h;
import e.t;
import e.v;
import e.z;
import f.e;
import f.k;
import f.q;
import f.r;
import f.s;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* compiled from: CacheInterceptor.java */
/* loaded from: classes.dex */
public final class a implements v {

    /* renamed from: a  reason: collision with root package name */
    public final d f5573a;

    /* compiled from: CacheInterceptor.java */
    /* renamed from: e.i0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0115a implements r {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5574a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f5575b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f5576c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f.d f5577d;

        public C0115a(a aVar, e eVar, b bVar, f.d dVar) {
            this.f5575b = eVar;
            this.f5576c = bVar;
            this.f5577d = dVar;
        }

        @Override // f.r
        public long a(f.c cVar, long j) {
            try {
                long a2 = this.f5575b.a(cVar, j);
                if (a2 == -1) {
                    if (!this.f5574a) {
                        this.f5574a = true;
                        this.f5577d.close();
                    }
                    return -1L;
                }
                cVar.a(this.f5577d.a(), cVar.s() - a2, a2);
                this.f5577d.i();
                return a2;
            } catch (IOException e2) {
                if (!this.f5574a) {
                    this.f5574a = true;
                    this.f5576c.abort();
                }
                throw e2;
            }
        }

        @Override // f.r
        public s b() {
            return this.f5575b.b();
        }

        @Override // f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f5574a && !e.i0.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f5574a = true;
                this.f5576c.abort();
            }
            this.f5575b.close();
        }
    }

    public a(d dVar) {
        this.f5573a = dVar;
    }

    public static d0 a(d0 d0Var) {
        if (d0Var == null || d0Var.j() == null) {
            return d0Var;
        }
        d0.a q = d0Var.q();
        q.a((e0) null);
        return q.a();
    }

    @Override // e.v
    public d0 intercept(v.a aVar) {
        d dVar = this.f5573a;
        d0 a2 = dVar != null ? dVar.a(aVar.a()) : null;
        c c2 = new c.a(System.currentTimeMillis(), aVar.a(), a2).c();
        b0 b0Var = c2.f5578a;
        d0 d0Var = c2.f5579b;
        d dVar2 = this.f5573a;
        if (dVar2 != null) {
            dVar2.a(c2);
        }
        if (a2 != null && d0Var == null) {
            e.i0.c.a(a2.j());
        }
        if (b0Var == null && d0Var == null) {
            d0.a aVar2 = new d0.a();
            aVar2.a(aVar.a());
            aVar2.a(z.HTTP_1_1);
            aVar2.a(504);
            aVar2.a("Unsatisfiable Request (only-if-cached)");
            aVar2.a(e.i0.c.f5564c);
            aVar2.b(-1L);
            aVar2.a(System.currentTimeMillis());
            return aVar2.a();
        } else if (b0Var == null) {
            d0.a q = d0Var.q();
            q.a(a(d0Var));
            return q.a();
        } else {
            try {
                d0 a3 = aVar.a(b0Var);
                if (a3 == null && a2 != null) {
                }
                if (d0Var != null) {
                    if (a3.l() == 304) {
                        d0.a q2 = d0Var.q();
                        q2.a(a(d0Var.n(), a3.n()));
                        q2.b(a3.t());
                        q2.a(a3.r());
                        q2.a(a(d0Var));
                        q2.c(a(a3));
                        d0 a4 = q2.a();
                        a3.j().close();
                        this.f5573a.a();
                        this.f5573a.a(d0Var, a4);
                        return a4;
                    }
                    e.i0.c.a(d0Var.j());
                }
                d0.a q3 = a3.q();
                q3.a(a(d0Var));
                q3.c(a(a3));
                d0 a5 = q3.a();
                if (this.f5573a != null) {
                    if (e.i0.g.e.b(a5) && c.a(a5, b0Var)) {
                        return a(this.f5573a.a(a5), a5);
                    }
                    if (f.a(b0Var.e())) {
                        try {
                            this.f5573a.b(b0Var);
                        } catch (IOException unused) {
                        }
                    }
                }
                return a5;
            } finally {
                if (a2 != null) {
                    e.i0.c.a(a2.j());
                }
            }
        }
    }

    public final d0 a(b bVar, d0 d0Var) {
        q a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return d0Var;
        }
        C0115a c0115a = new C0115a(this, d0Var.j().n(), bVar, k.a(a2));
        d0.a q = d0Var.q();
        q.a(new h(d0Var.n(), k.a(c0115a)));
        return q.a();
    }

    public static t a(t tVar, t tVar2) {
        t.a aVar = new t.a();
        int b2 = tVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            String a2 = tVar.a(i2);
            String b3 = tVar.b(i2);
            if ((!"Warning".equalsIgnoreCase(a2) || !b3.startsWith("1")) && (!a(a2) || tVar2.a(a2) == null)) {
                e.i0.a.f5560a.a(aVar, a2, b3);
            }
        }
        int b4 = tVar2.b();
        for (int i3 = 0; i3 < b4; i3++) {
            String a3 = tVar2.a(i3);
            if (!"Content-Length".equalsIgnoreCase(a3) && a(a3)) {
                e.i0.a.f5560a.a(aVar, a3, tVar2.b(i3));
            }
        }
        return aVar.a();
    }

    public static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
