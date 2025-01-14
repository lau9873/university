package p070c.p084d.p085a.p086a.p102h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: c.d.a.a.h.n1 */
/* loaded from: classes.dex */
public class BinderC1175n1 extends Binder implements IInterface {
    /* renamed from: a */
    public final boolean m5026a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
