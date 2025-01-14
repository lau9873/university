package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import p070c.p084d.p085a.p086a.p093e.C0900a;

/* renamed from: c.d.a.a.e.e.l.o0 */
/* loaded from: classes.dex */
public final class RunnableC0991o0 implements Runnable {

    /* renamed from: a */
    public /* synthetic */ C0900a f5282a;

    /* renamed from: b */
    public /* synthetic */ C0979l0 f5283b;

    public RunnableC0991o0(C0979l0 c0979l0, C0900a c0900a) {
        this.f5283b = c0979l0;
        this.f5282a = c0900a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5283b.onConnectionFailed(this.f5282a);
    }
}
