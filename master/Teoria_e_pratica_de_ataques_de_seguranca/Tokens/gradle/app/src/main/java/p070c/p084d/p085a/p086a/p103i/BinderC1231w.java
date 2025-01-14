package p070c.p084d.p085a.p086a.p103i;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p070c.p084d.p085a.p086a.p102h.BinderC1175n1;

/* renamed from: c.d.a.a.i.w */
/* loaded from: classes.dex */
public class BinderC1231w extends BinderC1175n1 implements InterfaceC1230v {
    /* renamed from: a */
    public static InterfaceC1230v m4985a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return queryLocalInterface instanceof InterfaceC1230v ? (InterfaceC1230v) queryLocalInterface : new C1232x(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        throw new NoSuchMethodError();
    }
}
