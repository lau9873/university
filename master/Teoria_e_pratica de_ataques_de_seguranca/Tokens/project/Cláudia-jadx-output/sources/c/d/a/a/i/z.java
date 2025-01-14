package c.d.a.a.i;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.a.h.n1;
import c.d.a.a.h.o1;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
/* loaded from: classes.dex */
public abstract class z extends n1 implements y {
    public static y a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof y ? (y) queryLocalInterface : new a0(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (a(i2, parcel, parcel2, i3)) {
            return true;
        }
        if (i2 == 1) {
            a((LocationResult) o1.a(parcel, LocationResult.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            a((LocationAvailability) o1.a(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
