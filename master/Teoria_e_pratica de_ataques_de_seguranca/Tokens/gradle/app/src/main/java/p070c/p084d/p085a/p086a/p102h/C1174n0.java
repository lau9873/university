package p070c.p084d.p085a.p086a.p102h;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.util.Log;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;

/* renamed from: c.d.a.a.h.n0 */
/* loaded from: classes.dex */
public final class C1174n0 extends C1188s {

    /* renamed from: C */
    public final C1153g0 f5559C;

    public C1174n0(Context context, Looper looper, AbstractC0921d.InterfaceC0923b interfaceC0923b, AbstractC0921d.InterfaceC0924c interfaceC0924c, String str) {
        this(context, looper, interfaceC0923b, interfaceC0924c, str, C1086u0.m5181a(context));
    }

    public C1174n0(Context context, Looper looper, AbstractC0921d.InterfaceC0923b interfaceC0923b, AbstractC0921d.InterfaceC0924c interfaceC0924c, String str, C1086u0 c1086u0) {
        super(context, looper, interfaceC0923b, interfaceC0924c, str, c1086u0);
        this.f5559C = new C1153g0(context, this.f5578B);
    }

    /* renamed from: B */
    public final Location m5030B() {
        return this.f5559C.m5051a();
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0, p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0916f
    /* renamed from: a */
    public final void mo5029a() {
        synchronized (this.f5559C) {
            if (m5248c()) {
                try {
                    this.f5559C.m5049b();
                    this.f5559C.m5048c();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.mo5029a();
        }
    }

    /* renamed from: a */
    public final void m5028a(long j, PendingIntent pendingIntent) {
        m5228u();
        C1049c0.m5294a(pendingIntent);
        C1049c0.m5289a(j >= 0, "detectionIntervalMillis must be >= 0");
        ((InterfaceC1147e0) m5227v()).mo5057a(j, true, pendingIntent);
    }

    /* renamed from: a */
    public final void m5027a(PendingIntent pendingIntent) {
        m5228u();
        C1049c0.m5294a(pendingIntent);
        ((InterfaceC1147e0) m5227v()).mo5056a(pendingIntent);
    }
}
