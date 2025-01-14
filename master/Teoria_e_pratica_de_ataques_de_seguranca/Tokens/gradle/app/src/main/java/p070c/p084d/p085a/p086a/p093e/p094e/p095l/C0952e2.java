package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import p070c.p084d.p085a.p086a.p104j.C1238d;

/* renamed from: c.d.a.a.e.e.l.e2 */
/* loaded from: classes.dex */
public final class C0952e2 extends AbstractC1034z<Boolean> {

    /* renamed from: b */
    public C0955f1<?> f5157b;

    public C0952e2(C0955f1<?> c0955f1, C1238d<Boolean> c1238d) {
        super(4, c1238d);
        this.f5157b = c0955f1;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo5333a(C0953f c0953f, boolean z) {
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC1034z
    /* renamed from: b */
    public final void mo5308b(C0979l0<?> c0979l0) {
        C0976k1 remove = c0979l0.m5446l().remove(this.f5157b);
        if (remove == null) {
            this.f5366a.m4977b((C1238d<T>) false);
            return;
        }
        remove.f5228b.m5541a(c0979l0.m5451g(), this.f5366a);
        remove.f5227a.m5476a();
    }
}
