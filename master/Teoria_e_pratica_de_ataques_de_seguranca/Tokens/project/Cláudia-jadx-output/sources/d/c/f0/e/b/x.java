package d.c.f0.e.b;

import d.c.f0.e.b.u;
/* compiled from: FlowableRetryWhen.java */
/* loaded from: classes.dex */
public final class x<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.n<? super d.c.j<Throwable>, ? extends g.b.b<?>> f4952c;

    /* compiled from: FlowableRetryWhen.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends u.c<T, Throwable> {
        public a(g.b.c<? super T> cVar, d.c.i0.a<Throwable> aVar, g.b.d dVar) {
            super(cVar, aVar, dVar);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            b((a<T>) th);
        }

        @Override // g.b.c
        public void a() {
            this.j.cancel();
            this.f4937h.a();
        }
    }

    public x(d.c.j<T> jVar, d.c.e0.n<? super d.c.j<Throwable>, ? extends g.b.b<?>> nVar) {
        super(jVar);
        this.f4952c = nVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        d.c.k0.a aVar = new d.c.k0.a(cVar);
        d.c.i0.a<T> i2 = d.c.i0.c.a(8).i();
        try {
            g.b.b<?> a2 = this.f4952c.a(i2);
            d.c.f0.b.b.a(a2, "handler returned a null Publisher");
            g.b.b<?> bVar = a2;
            u.b bVar2 = new u.b(this.f4795b);
            a aVar2 = new a(aVar, i2, bVar2);
            bVar2.f4936d = aVar2;
            cVar.a((g.b.d) aVar2);
            bVar.a(bVar2);
            bVar2.a((Object) 0);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.i.d.a(th, cVar);
        }
    }
}
