package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import java.util.Map;
import p070c.p084d.p085a.p086a.p104j.AbstractC1237c;
import p070c.p084d.p085a.p086a.p104j.C1238d;
import p070c.p084d.p085a.p086a.p104j.InterfaceC1235a;

/* renamed from: c.d.a.a.e.e.l.h */
/* loaded from: classes.dex */
public final class C0961h implements InterfaceC1235a<TResult> {

    /* renamed from: a */
    public /* synthetic */ C1238d f5183a;

    /* renamed from: b */
    public /* synthetic */ C0953f f5184b;

    public C0961h(C0953f c0953f, C1238d c1238d) {
        this.f5184b = c0953f;
        this.f5183a = c1238d;
    }

    @Override // p070c.p084d.p085a.p086a.p104j.InterfaceC1235a
    public final void onComplete(AbstractC1237c<TResult> abstractC1237c) {
        Map map;
        map = this.f5184b.f5159b;
        map.remove(this.f5183a);
    }
}
