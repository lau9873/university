package i;

import e.d0;
import e.e0;
import e.w;
import f.r;
import java.io.IOException;
/* compiled from: OkHttpCall.java */
/* loaded from: classes.dex */
public final class h<T> implements i.b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final n<T, ?> f7439a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f7440b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f7441c;

    /* renamed from: d  reason: collision with root package name */
    public e.e f7442d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f7443e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7444f;

    /* compiled from: OkHttpCall.java */
    /* loaded from: classes.dex */
    public static final class b extends e0 {

        /* renamed from: b  reason: collision with root package name */
        public final e0 f7447b;

        /* renamed from: c  reason: collision with root package name */
        public IOException f7448c;

        /* compiled from: OkHttpCall.java */
        /* loaded from: classes.dex */
        public class a extends f.g {
            public a(r rVar) {
                super(rVar);
            }

            @Override // f.g, f.r
            public long a(f.c cVar, long j) {
                try {
                    return super.a(cVar, j);
                } catch (IOException e2) {
                    b.this.f7448c = e2;
                    throw e2;
                }
            }
        }

        public b(e0 e0Var) {
            this.f7447b = e0Var;
        }

        @Override // e.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f7447b.close();
        }

        @Override // e.e0
        public long l() {
            return this.f7447b.l();
        }

        @Override // e.e0
        public w m() {
            return this.f7447b.m();
        }

        @Override // e.e0
        public f.e n() {
            return f.k.a(new a(this.f7447b.n()));
        }

        public void o() {
            IOException iOException = this.f7448c;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* compiled from: OkHttpCall.java */
    /* loaded from: classes.dex */
    public static final class c extends e0 {

        /* renamed from: b  reason: collision with root package name */
        public final w f7450b;

        /* renamed from: c  reason: collision with root package name */
        public final long f7451c;

        public c(w wVar, long j) {
            this.f7450b = wVar;
            this.f7451c = j;
        }

        @Override // e.e0
        public long l() {
            return this.f7451c;
        }

        @Override // e.e0
        public w m() {
            return this.f7450b;
        }

        @Override // e.e0
        public f.e n() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public h(n<T, ?> nVar, Object[] objArr) {
        this.f7439a = nVar;
        this.f7440b = objArr;
    }

    @Override // i.b
    public void a(d<T> dVar) {
        e.e eVar;
        Throwable th;
        o.a(dVar, "callback == null");
        synchronized (this) {
            if (!this.f7444f) {
                this.f7444f = true;
                eVar = this.f7442d;
                th = this.f7443e;
                if (eVar == null && th == null) {
                    e.e a2 = a();
                    this.f7442d = a2;
                    eVar = a2;
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.f7441c) {
            eVar.cancel();
        }
        eVar.a(new a(dVar));
    }

    @Override // i.b
    public void cancel() {
        e.e eVar;
        this.f7441c = true;
        synchronized (this) {
            eVar = this.f7442d;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // i.b
    public l<T> j() {
        e.e eVar;
        synchronized (this) {
            if (!this.f7444f) {
                this.f7444f = true;
                if (this.f7443e != null) {
                    if (this.f7443e instanceof IOException) {
                        throw ((IOException) this.f7443e);
                    }
                    throw ((RuntimeException) this.f7443e);
                }
                eVar = this.f7442d;
                if (eVar == null) {
                    try {
                        eVar = a();
                        this.f7442d = eVar;
                    } catch (IOException | RuntimeException e2) {
                        this.f7443e = e2;
                        throw e2;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f7441c) {
            eVar.cancel();
        }
        return a(eVar.j());
    }

    @Override // i.b
    public boolean k() {
        boolean z = true;
        if (this.f7441c) {
            return true;
        }
        synchronized (this) {
            if (this.f7442d == null || !this.f7442d.k()) {
                z = false;
            }
        }
        return z;
    }

    /* compiled from: OkHttpCall.java */
    /* loaded from: classes.dex */
    public class a implements e.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f7445a;

        public a(d dVar) {
            this.f7445a = dVar;
        }

        @Override // e.f
        public void a(e.e eVar, d0 d0Var) {
            try {
                a(h.this.a(d0Var));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // e.f
        public void a(e.e eVar, IOException iOException) {
            try {
                this.f7445a.a(h.this, iOException);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final void a(Throwable th) {
            try {
                this.f7445a.a(h.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        public final void a(l<T> lVar) {
            try {
                this.f7445a.a(h.this, lVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // i.b
    public h<T> clone() {
        return new h<>(this.f7439a, this.f7440b);
    }

    public final e.e a() {
        e.e a2 = this.f7439a.f7508a.a(this.f7439a.a(this.f7440b));
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    public l<T> a(d0 d0Var) {
        e0 j = d0Var.j();
        d0.a q = d0Var.q();
        q.a(new c(j.m(), j.l()));
        d0 a2 = q.a();
        int l = a2.l();
        if (l < 200 || l >= 300) {
            try {
                return l.a(o.a(j), a2);
            } finally {
                j.close();
            }
        } else if (l != 204 && l != 205) {
            b bVar = new b(j);
            try {
                return l.a(this.f7439a.a(bVar), a2);
            } catch (RuntimeException e2) {
                bVar.o();
                throw e2;
            }
        } else {
            j.close();
            return l.a((Object) null, a2);
        }
    }
}
