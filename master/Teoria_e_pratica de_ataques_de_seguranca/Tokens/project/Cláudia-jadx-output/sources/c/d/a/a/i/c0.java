package c.d.a.a.i;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.a.h.n1;
import c.d.a.a.h.o1;
/* loaded from: classes.dex */
public abstract class c0 extends n1 implements b0 {
    public static b0 a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof b0 ? (b0) queryLocalInterface : new d0(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (a(i2, parcel, parcel2, i3)) {
            return true;
        }
        if (i2 == 1) {
            onLocationChanged((Location) o1.a(parcel, Location.CREATOR));
            return true;
        }
        return false;
    }
}
