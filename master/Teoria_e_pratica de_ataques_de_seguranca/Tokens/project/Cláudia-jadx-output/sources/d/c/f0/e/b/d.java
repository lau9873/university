package d.c.f0.e.b;
/* compiled from: FlowableConcatMapPublisher.java */
/* loaded from: classes.dex */
public final class d<T, R> extends d.c.j<R> {

    /* renamed from: b  reason: collision with root package name */
    public final g.b.b<T> f4835b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends g.b.b<? extends R>> f4836c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4837d;

    /* renamed from: e  reason: collision with root package name */
    public final d.c.f0.j.e f4838e;

    public d(g.b.b<T> bVar, d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar, int i2, d.c.f0.j.e eVar) {
        this.f4835b = bVar;
        this.f4836c = nVar;
        this.f4837d = i2;
        this.f4838e = eVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super R> cVar) {
        if (y.a(this.f4835b, cVar, this.f4836c)) {
            return;
        }
        this.f4835b.a(c.a(cVar, this.f4836c, this.f4837d, this.f4838e));
    }
}
