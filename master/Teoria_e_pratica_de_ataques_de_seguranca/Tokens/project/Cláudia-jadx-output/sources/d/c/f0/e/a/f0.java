package d.c.f0.e.a;

import io.reactivex.exceptions.CompositeException;
/* compiled from: CompletablePeek.java */
/* loaded from: classes.dex */
public final class f0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4676a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.f<? super d.c.c0.b> f4677b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.f<? super Throwable> f4678c;

    /* renamed from: d  reason: collision with root package name */
    public final d.c.e0.a f4679d;

    /* renamed from: e  reason: collision with root package name */
    public final d.c.e0.a f4680e;

    /* renamed from: f  reason: collision with root package name */
    public final d.c.e0.a f4681f;

    /* renamed from: g  reason: collision with root package name */
    public final d.c.e0.a f4682g;

    /* compiled from: CompletablePeek.java */
    /* loaded from: classes.dex */
    public final class b implements d.c.d, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4683a;

        /* renamed from: b  reason: collision with root package name */
        public d.c.c0.b f4684b;

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            try {
                f0.this.f4677b.accept(bVar);
                if (d.c.f0.a.b.a(this.f4684b, bVar)) {
                    this.f4684b = bVar;
                    this.f4683a.a(this);
                }
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                bVar.b();
                this.f4684b = d.c.f0.a.b.DISPOSED;
                d.c.f0.a.c.a(th, this.f4683a);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            try {
                f0.this.f4682g.run();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                d.c.h0.a.b(th);
            }
            this.f4684b.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4684b.c();
        }

        public void d() {
            try {
                f0.this.f4681f.run();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                d.c.h0.a.b(th);
            }
        }

        public b(d.c.d dVar) {
            this.f4683a = dVar;
        }

        @Override // d.c.d
        public void a(Throwable th) {
            if (this.f4684b == d.c.f0.a.b.DISPOSED) {
                d.c.h0.a.b(th);
                return;
            }
            try {
                f0.this.f4678c.accept(th);
                f0.this.f4680e.run();
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f4683a.a(th);
            d();
        }

        @Override // d.c.d
        public void a() {
            if (this.f4684b == d.c.f0.a.b.DISPOSED) {
                return;
            }
            try {
                f0.this.f4679d.run();
                f0.this.f4680e.run();
                this.f4683a.a();
                d();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f4683a.a(th);
            }
        }
    }

    public f0(d.c.g gVar, d.c.e0.f<? super d.c.c0.b> fVar, d.c.e0.f<? super Throwable> fVar2, d.c.e0.a aVar, d.c.e0.a aVar2, d.c.e0.a aVar3, d.c.e0.a aVar4) {
        this.f4676a = gVar;
        this.f4677b = fVar;
        this.f4678c = fVar2;
        this.f4679d = aVar;
        this.f4680e = aVar2;
        this.f4681f = aVar3;
        this.f4682g = aVar4;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4676a.subscribe(new b(dVar));
    }
}
