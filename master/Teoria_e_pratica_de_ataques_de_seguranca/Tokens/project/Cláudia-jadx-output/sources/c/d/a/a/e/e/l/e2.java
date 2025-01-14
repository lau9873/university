package c.d.a.a.e.e.l;
/* loaded from: classes.dex */
public final class e2 extends z<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public f1<?> f3282b;

    public e2(f1<?> f1Var, c.d.a.a.j.d<Boolean> dVar) {
        super(4, dVar);
        this.f3282b = f1Var;
    }

    @Override // c.d.a.a.e.e.l.a
    public final /* bridge */ /* synthetic */ void a(f fVar, boolean z) {
    }

    @Override // c.d.a.a.e.e.l.z
    public final void b(l0<?> l0Var) {
        k1 remove = l0Var.l().remove(this.f3282b);
        if (remove == null) {
            this.f3450a.b((c.d.a.a.j.d<T>) false);
            return;
        }
        remove.f3340b.a(l0Var.g(), this.f3450a);
        remove.f3339a.a();
    }
}
