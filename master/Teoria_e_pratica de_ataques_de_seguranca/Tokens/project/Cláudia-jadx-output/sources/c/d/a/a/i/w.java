package c.d.a.a.i;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.a.h.n1;
/* loaded from: classes.dex */
public class w extends n1 implements v {
    public static v a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return queryLocalInterface instanceof v ? (v) queryLocalInterface : new x(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        throw new NoSuchMethodError();
    }
}
