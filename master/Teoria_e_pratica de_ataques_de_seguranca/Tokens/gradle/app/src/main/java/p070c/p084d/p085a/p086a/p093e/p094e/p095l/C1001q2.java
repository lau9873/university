package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.app.Dialog;

/* renamed from: c.d.a.a.e.e.l.q2 */
/* loaded from: classes.dex */
public final class C1001q2 extends AbstractC1019v0 {

    /* renamed from: a */
    public /* synthetic */ Dialog f5298a;

    /* renamed from: b */
    public /* synthetic */ RunnableC0997p2 f5299b;

    public C1001q2(RunnableC0997p2 runnableC0997p2, Dialog dialog) {
        this.f5299b = runnableC0997p2;
        this.f5298a = dialog;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC1019v0
    /* renamed from: a */
    public final void mo5343a() {
        this.f5299b.f5294b.m5394g();
        if (this.f5298a.isShowing()) {
            this.f5298a.dismiss();
        }
    }
}
