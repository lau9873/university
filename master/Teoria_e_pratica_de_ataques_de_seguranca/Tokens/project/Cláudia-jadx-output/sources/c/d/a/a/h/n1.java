package c.d.a.a.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public class n1 extends Binder implements IInterface {
    public final boolean a(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 > 16777215) {
            return super.onTransact(i2, parcel, parcel2, i3);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
