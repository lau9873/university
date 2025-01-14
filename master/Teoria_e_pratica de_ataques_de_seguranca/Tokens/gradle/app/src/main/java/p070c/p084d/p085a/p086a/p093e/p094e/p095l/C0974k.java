package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.e.l.k */
/* loaded from: classes.dex */
public final class C0974k implements InterfaceC0950e0 {

    /* renamed from: a */
    public final C0954f0 f5224a;

    /* renamed from: b */
    public boolean f5225b = false;

    public C0974k(C0954f0 c0954f0) {
        this.f5224a = c0954f0;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5323a(T t) {
        try {
            this.f5224a.f5172m.f5119y.m5316a(t);
            C0934a0 c0934a0 = this.f5224a.f5172m;
            C0905a.InterfaceC0916f interfaceC0916f = c0934a0.f5110p.get(t.m5435h());
            C1049c0.m5293a(interfaceC0916f, "Appropriate Api was not requested.");
            if (interfaceC0916f.m5610c() || !this.f5224a.f5166g.containsKey(t.m5435h())) {
                t.m5437b(interfaceC0916f);
            } else {
                t.m5436c(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f5224a.m5527a(new C0978l(this, this));
        }
        return t;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final void mo5324a(C0900a c0900a, C0905a<?> c0905a, boolean z) {
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: a */
    public final boolean mo5325a() {
        if (this.f5225b) {
            return false;
        }
        if (!this.f5224a.f5172m.m5570j()) {
            this.f5224a.m5529a((C0900a) null);
            return true;
        }
        this.f5225b = true;
        for (C1020v1 c1020v1 : this.f5224a.f5172m.f5118x) {
            c1020v1.m5342a();
        }
        return false;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: b */
    public final void mo5322b() {
        if (this.f5225b) {
            this.f5225b = false;
            this.f5224a.m5527a(new C0982m(this, this));
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    /* renamed from: c */
    public final void mo5321c() {
    }

    /* renamed from: d */
    public final void m5468d() {
        if (this.f5225b) {
            this.f5225b = false;
            this.f5224a.f5172m.f5119y.m5317a();
            mo5325a();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    public final void onConnected(Bundle bundle) {
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0950e0
    public final void onConnectionSuspended(int i) {
        this.f5224a.m5529a((C0900a) null);
        this.f5224a.f5173n.mo5320a(i, this.f5225b);
    }
}
