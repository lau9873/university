package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Bundle;
import java.util.Collections;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;

/* renamed from: c.d.a.a.e.e.l.y */
/* loaded from: classes.dex */
public final class C1030y implements InterfaceC0950e0 {

    /* renamed from: a */
    public final C0954f0 f5356a;

    public C1030y(C0954f0 c0954f0) {
        this.f5356a = c0954f0;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5323a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final void mo5324a(C0900a c0900a, C0905a<?> c0905a, boolean z) {
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final boolean mo5325a() {
        return true;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: b */
    public final void mo5322b() {
        this.f5356a.m5524e();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: c */
    public final void mo5321c() {
        for (C0905a.InterfaceC0916f interfaceC0916f : this.f5356a.f5165f.values()) {
            interfaceC0916f.mo5029a();
        }
        this.f5356a.f5172m.f5111q = Collections.emptySet();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    public final void onConnected(Bundle bundle) {
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    public final void onConnectionSuspended(int i) {
    }
}
