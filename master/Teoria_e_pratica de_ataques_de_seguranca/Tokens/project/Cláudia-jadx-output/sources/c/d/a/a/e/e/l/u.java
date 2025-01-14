package c.d.a.a.e.e.l;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class u extends c.d.a.a.h.c1 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<n> f3415a;

    public u(n nVar) {
        this.f3415a = new WeakReference<>(nVar);
    }

    @Override // c.d.a.a.h.d1
    public final void a(c.d.a.a.h.k1 k1Var) {
        f0 f0Var;
        n nVar = this.f3415a.get();
        if (nVar == null) {
            return;
        }
        f0Var = nVar.f3354a;
        f0Var.a(new v(this, nVar, nVar, k1Var));
    }
}
