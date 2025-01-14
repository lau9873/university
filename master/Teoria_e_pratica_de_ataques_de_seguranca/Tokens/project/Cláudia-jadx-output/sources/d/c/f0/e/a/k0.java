package d.c.f0.e.a;
/* compiled from: CompletableToFlowable.java */
/* loaded from: classes.dex */
public final class k0<T> extends d.c.j<T> {

    /* renamed from: b  reason: collision with root package name */
    public final d.c.g f4741b;

    public k0(d.c.g gVar) {
        this.f4741b = gVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f4741b.subscribe(new d.c.f0.d.k(cVar));
    }
}
