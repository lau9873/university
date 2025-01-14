package c.d.a.a.e.e.l;

import android.app.Dialog;
/* loaded from: classes.dex */
public final class q2 extends v0 {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ Dialog f3393a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ p2 f3394b;

    public q2(p2 p2Var, Dialog dialog) {
        this.f3394b = p2Var;
        this.f3393a = dialog;
    }

    @Override // c.d.a.a.e.e.l.v0
    public final void a() {
        this.f3394b.f3389b.g();
        if (this.f3393a.isShowing()) {
            this.f3393a.dismiss();
        }
    }
}
