package c.d.a.a.h;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class f0 extends m1 implements e0 {
    public f0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // c.d.a.a.h.e0
    public final void a(long j, boolean z, PendingIntent pendingIntent) {
        Parcel h2 = h();
        h2.writeLong(j);
        o1.a(h2, true);
        o1.a(h2, pendingIntent);
        b(5, h2);
    }

    @Override // c.d.a.a.h.e0
    public final void a(PendingIntent pendingIntent) {
        Parcel h2 = h();
        o1.a(h2, pendingIntent);
        b(6, h2);
    }

    @Override // c.d.a.a.h.e0
    public final void a(q0 q0Var) {
        Parcel h2 = h();
        o1.a(h2, q0Var);
        b(59, h2);
    }

    @Override // c.d.a.a.h.e0
    public final void a(y yVar) {
        Parcel h2 = h();
        o1.a(h2, yVar);
        b(75, h2);
    }

    @Override // c.d.a.a.h.e0
    public final Location b(String str) {
        Parcel h2 = h();
        h2.writeString(str);
        Parcel a2 = a(21, h2);
        Location location = (Location) o1.a(a2, Location.CREATOR);
        a2.recycle();
        return location;
    }

    @Override // c.d.a.a.h.e0
    public final void c(boolean z) {
        Parcel h2 = h();
        o1.a(h2, z);
        b(12, h2);
    }
}
