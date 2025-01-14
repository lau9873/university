package c.d.a.a.e.e.l;

import android.os.Handler;
/* loaded from: classes.dex */
public final class k0 implements k2 {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ j0 f3338a;

    public k0(j0 j0Var) {
        this.f3338a = j0Var;
    }

    @Override // c.d.a.a.e.e.l.k2
    public final void a(boolean z) {
        Handler handler;
        Handler handler2;
        handler = this.f3338a.m;
        handler2 = this.f3338a.m;
        handler.sendMessage(handler2.obtainMessage(1, Boolean.valueOf(z)));
    }
}
