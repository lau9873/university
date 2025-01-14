package p070c.p084d.p085a.p086a.p103i;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import p070c.p084d.p085a.p086a.p102h.BinderC1175n1;
import p070c.p084d.p085a.p086a.p102h.C1178o1;

/* renamed from: c.d.a.a.i.z */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1234z extends BinderC1175n1 implements InterfaceC1233y {
    /* renamed from: a */
    public static InterfaceC1233y m4982a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof InterfaceC1233y ? (InterfaceC1233y) queryLocalInterface : new C1206a0(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (m5026a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            mo4983a((LocationResult) C1178o1.m5023a(parcel, LocationResult.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            mo4984a((LocationAvailability) C1178o1.m5023a(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
