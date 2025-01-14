package d.c.f0.e.b;
/* compiled from: FlowableFlatMapPublisher.java */
/* loaded from: classes.dex */
public final class h<T, U> extends d.c.j<U> {

    /* renamed from: b  reason: collision with root package name */
    public final g.b.b<T> f4869b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends g.b.b<? extends U>> f4870c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4871d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4872e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4873f;

    public h(g.b.b<T> bVar, d.c.e0.n<? super T, ? extends g.b.b<? extends U>> nVar, boolean z, int i2, int i3) {
        this.f4869b = bVar;
        this.f4870c = nVar;
        this.f4871d = z;
        this.f4872e = i2;
        this.f4873f = i3;
    }

    @Override // d.c.j
    public void b(g.b.c<? super U> cVar) {
        if (y.a(this.f4869b, cVar, this.f4870c)) {
            return;
        }
        this.f4869b.a(g.a(cVar, this.f4870c, this.f4871d, this.f4872e, this.f4873f));
    }
}
