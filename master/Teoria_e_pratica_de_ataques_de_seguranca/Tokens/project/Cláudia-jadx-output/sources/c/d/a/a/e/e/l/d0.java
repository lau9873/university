package c.d.a.a.e.e.l;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class d0 extends v0 {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<a0> f3277a;

    public d0(a0 a0Var) {
        this.f3277a = new WeakReference<>(a0Var);
    }

    @Override // c.d.a.a.e.e.l.v0
    public final void a() {
        a0 a0Var = this.f3277a.get();
        if (a0Var == null) {
            return;
        }
        a0Var.f();
    }
}
