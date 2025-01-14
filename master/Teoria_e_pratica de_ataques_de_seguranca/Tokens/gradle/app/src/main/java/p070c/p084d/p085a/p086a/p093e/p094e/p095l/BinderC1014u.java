package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import java.lang.ref.WeakReference;
import p070c.p084d.p085a.p086a.p102h.BinderC1142c1;
import p070c.p084d.p085a.p086a.p102h.C1166k1;

/* renamed from: c.d.a.a.e.e.l.u */
/* loaded from: classes.dex */
public final class BinderC1014u extends BinderC1142c1 {

    /* renamed from: a */
    public final WeakReference<C0986n> f5324a;

    public BinderC1014u(C0986n c0986n) {
        this.f5324a = new WeakReference<>(c0986n);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1145d1
    /* renamed from: a */
    public final void mo5063a(C1166k1 c1166k1) {
        C0954f0 c0954f0;
        C0986n c0986n = this.f5324a.get();
        if (c0986n == null) {
            return;
        }
        c0954f0 = c0986n.f5247a;
        c0954f0.m5527a(new C1018v(this, c0986n, c0986n, c1166k1));
    }
}
