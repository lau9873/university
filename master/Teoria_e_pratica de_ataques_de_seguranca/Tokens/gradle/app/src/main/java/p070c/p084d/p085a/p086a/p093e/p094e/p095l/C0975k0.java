package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Handler;

/* renamed from: c.d.a.a.e.e.l.k0 */
/* loaded from: classes.dex */
public final class C0975k0 implements InterfaceC0977k2 {

    /* renamed from: a */
    public /* synthetic */ C0971j0 f5226a;

    public C0975k0(C0971j0 c0971j0) {
        this.f5226a = c0971j0;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0977k2
    /* renamed from: a */
    public final void mo5467a(boolean z) {
        Handler handler;
        Handler handler2;
        handler = this.f5226a.f5218m;
        handler2 = this.f5226a.f5218m;
        handler.sendMessage(handler2.obtainMessage(1, Boolean.valueOf(z)));
    }
}
