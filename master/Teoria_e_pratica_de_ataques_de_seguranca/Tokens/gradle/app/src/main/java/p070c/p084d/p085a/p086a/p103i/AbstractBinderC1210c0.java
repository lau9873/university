package p070c.p084d.p085a.p086a.p103i;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p070c.p084d.p085a.p086a.p102h.BinderC1175n1;
import p070c.p084d.p085a.p086a.p102h.C1178o1;

/* renamed from: c.d.a.a.i.c0 */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1210c0 extends BinderC1175n1 implements InterfaceC1208b0 {
    /* renamed from: a */
    public static InterfaceC1208b0 m4990a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof InterfaceC1208b0 ? (InterfaceC1208b0) queryLocalInterface : new C1212d0(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (m5026a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            onLocationChanged((Location) C1178o1.m5023a(parcel, Location.CREATOR));
            return true;
        }
        return false;
    }
}
