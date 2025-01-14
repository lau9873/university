package c.d.a.a.e.e.l;

import android.os.Handler;
/* loaded from: classes.dex */
public final class p0 implements c.d.a.a.e.f.t0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f3385a;

    public p0(l0 l0Var) {
        this.f3385a = l0Var;
    }

    @Override // c.d.a.a.e.f.t0
    public final void a() {
        Handler handler;
        handler = this.f3385a.l.m;
        handler.post(new q0(this));
    }
}
