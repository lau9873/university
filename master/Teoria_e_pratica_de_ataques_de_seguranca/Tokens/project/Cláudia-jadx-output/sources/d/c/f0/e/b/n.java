package d.c.f0.e.b;
/* compiled from: FlowableJust.java */
/* loaded from: classes.dex */
public final class n<T> extends d.c.j<T> implements d.c.f0.c.l<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f4893b;

    public n(T t) {
        this.f4893b = t;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        cVar.a((g.b.d) new d.c.f0.i.e(cVar, this.f4893b));
    }

    @Override // d.c.f0.c.l, java.util.concurrent.Callable
    public T call() {
        return this.f4893b;
    }
}
