package p070c.p084d.p085a.p086a.p093e.p096f;

import p070c.p084d.p085a.p086a.p093e.C0900a;

/* renamed from: c.d.a.a.e.f.q0 */
/* loaded from: classes.dex */
public final class C1078q0 implements InterfaceC1072n0 {

    /* renamed from: a */
    public /* synthetic */ AbstractC1060h0 f5467a;

    public C1078q0(AbstractC1060h0 abstractC1060h0) {
        this.f5467a = abstractC1060h0;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1072n0
    /* renamed from: a */
    public final void mo5188a(C0900a c0900a) {
        InterfaceC1066k0 interfaceC1066k0;
        InterfaceC1066k0 interfaceC1066k02;
        if (c0900a.m5641f()) {
            AbstractC1060h0 abstractC1060h0 = this.f5467a;
            abstractC1060h0.m5254a((InterfaceC1071n) null, abstractC1060h0.mo5225x());
            return;
        }
        interfaceC1066k0 = this.f5467a.f5430s;
        if (interfaceC1066k0 != null) {
            interfaceC1066k02 = this.f5467a.f5430s;
            interfaceC1066k02.onConnectionFailed(c0900a);
        }
    }
}
