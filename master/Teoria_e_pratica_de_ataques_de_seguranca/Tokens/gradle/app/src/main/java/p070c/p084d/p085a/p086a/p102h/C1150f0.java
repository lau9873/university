package p070c.p084d.p085a.p086a.p102h;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: c.d.a.a.h.f0 */
/* loaded from: classes.dex */
public final class C1150f0 extends C1172m1 implements InterfaceC1147e0 {
    public C1150f0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1147e0
    /* renamed from: a */
    public final void mo5057a(long j, boolean z, PendingIntent pendingIntent) {
        Parcel m5032h = m5032h();
        m5032h.writeLong(j);
        C1178o1.m5021a(m5032h, true);
        C1178o1.m5022a(m5032h, pendingIntent);
        m5033b(5, m5032h);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1147e0
    /* renamed from: a */
    public final void mo5056a(PendingIntent pendingIntent) {
        Parcel m5032h = m5032h();
        C1178o1.m5022a(m5032h, pendingIntent);
        m5033b(6, m5032h);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1147e0
    /* renamed from: a */
    public final void mo5055a(C1183q0 c1183q0) {
        Parcel m5032h = m5032h();
        C1178o1.m5022a(m5032h, c1183q0);
        m5033b(59, m5032h);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1147e0
    /* renamed from: a */
    public final void mo5054a(C1200y c1200y) {
        Parcel m5032h = m5032h();
        C1178o1.m5022a(m5032h, c1200y);
        m5033b(75, m5032h);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1147e0
    /* renamed from: b */
    public final Location mo5053b(String str) {
        Parcel m5032h = m5032h();
        m5032h.writeString(str);
        Parcel m5034a = m5034a(21, m5032h);
        Location location = (Location) C1178o1.m5023a(m5034a, Location.CREATOR);
        m5034a.recycle();
        return location;
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1147e0
    /* renamed from: c */
    public final void mo5052c(boolean z) {
        Parcel m5032h = m5032h();
        C1178o1.m5021a(m5032h, z);
        m5033b(12, m5032h);
    }
}
