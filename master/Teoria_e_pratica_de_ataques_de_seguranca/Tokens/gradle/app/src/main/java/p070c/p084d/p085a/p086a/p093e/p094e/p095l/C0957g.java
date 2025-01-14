package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Map;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0925e;

/* renamed from: c.d.a.a.e.e.l.g */
/* loaded from: classes.dex */
public final class C0957g implements AbstractC0925e.InterfaceC0926a {

    /* renamed from: a */
    public /* synthetic */ BasePendingResult f5176a;

    /* renamed from: b */
    public /* synthetic */ C0953f f5177b;

    public C0957g(C0953f c0953f, BasePendingResult basePendingResult) {
        this.f5177b = c0953f;
        this.f5176a = basePendingResult;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0925e.InterfaceC0926a
    /* renamed from: a */
    public final void mo5522a(Status status) {
        Map map;
        map = this.f5177b.f5158a;
        map.remove(this.f5176a);
    }
}
