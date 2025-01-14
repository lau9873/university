package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Bundle;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.e.l.s2 */
/* loaded from: classes.dex */
public final class C1009s2 implements AbstractC0921d.InterfaceC0923b, AbstractC0921d.InterfaceC0924c {

    /* renamed from: a */
    public final C0905a<?> f5315a;

    /* renamed from: b */
    public final boolean f5316b;

    /* renamed from: c */
    public InterfaceC1013t2 f5317c;

    public C1009s2(C0905a<?> c0905a, boolean z) {
        this.f5315a = c0905a;
        this.f5316b = z;
    }

    /* renamed from: a */
    public final void m5373a() {
        C1049c0.m5293a(this.f5317c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    /* renamed from: a */
    public final void m5372a(InterfaceC1013t2 interfaceC1013t2) {
        this.f5317c = interfaceC1013t2;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnected(Bundle bundle) {
        m5373a();
        this.f5317c.onConnected(bundle);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0924c
    public final void onConnectionFailed(C0900a c0900a) {
        m5373a();
        this.f5317c.mo5368a(c0900a, this.f5315a, this.f5316b);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnectionSuspended(int i) {
        m5373a();
        this.f5317c.onConnectionSuspended(i);
    }
}
