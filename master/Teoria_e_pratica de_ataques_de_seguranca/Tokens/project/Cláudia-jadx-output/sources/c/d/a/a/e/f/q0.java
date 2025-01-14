package c.d.a.a.e.f;
/* loaded from: classes.dex */
public final class q0 implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ h0 f3534a;

    public q0(h0 h0Var) {
        this.f3534a = h0Var;
    }

    @Override // c.d.a.a.e.f.n0
    public final void a(c.d.a.a.e.a aVar) {
        k0 k0Var;
        k0 k0Var2;
        if (aVar.f()) {
            h0 h0Var = this.f3534a;
            h0Var.a((n) null, h0Var.x());
            return;
        }
        k0Var = this.f3534a.s;
        if (k0Var != null) {
            k0Var2 = this.f3534a.s;
            k0Var2.onConnectionFailed(aVar);
        }
    }
}
