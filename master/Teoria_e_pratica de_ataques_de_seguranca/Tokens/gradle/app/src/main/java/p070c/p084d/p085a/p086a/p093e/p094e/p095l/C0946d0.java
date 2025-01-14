package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import java.lang.ref.WeakReference;

/* renamed from: c.d.a.a.e.e.l.d0 */
/* loaded from: classes.dex */
public final class C0946d0 extends AbstractC1019v0 {

    /* renamed from: a */
    public WeakReference<C0934a0> f5152a;

    public C0946d0(C0934a0 c0934a0) {
        this.f5152a = new WeakReference<>(c0934a0);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC1019v0
    /* renamed from: a */
    public final void mo5343a() {
        C0934a0 c0934a0 = this.f5152a.get();
        if (c0934a0 == null) {
            return;
        }
        c0934a0.m5574f();
    }
}
