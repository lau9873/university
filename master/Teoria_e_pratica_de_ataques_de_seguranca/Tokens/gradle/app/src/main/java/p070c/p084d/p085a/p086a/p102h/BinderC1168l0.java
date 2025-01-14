package p070c.p084d.p085a.p086a.p102h;

import android.location.Location;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0947d1;
import p070c.p084d.p085a.p086a.p103i.AbstractBinderC1210c0;

/* renamed from: c.d.a.a.h.l0 */
/* loaded from: classes.dex */
public final class BinderC1168l0 extends AbstractBinderC1210c0 {

    /* renamed from: a */
    public final C0947d1<Object> f5556a;

    @Override // p070c.p084d.p085a.p086a.p103i.InterfaceC1208b0
    public final synchronized void onLocationChanged(Location location) {
        this.f5556a.m5539a(new C1171m0(this, location));
    }
}
