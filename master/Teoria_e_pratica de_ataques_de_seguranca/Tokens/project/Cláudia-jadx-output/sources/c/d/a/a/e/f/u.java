package c.d.a.a.e.f;

import android.os.Bundle;
import android.os.Parcel;
import c.d.a.a.h.n1;
import c.d.a.a.h.o1;
/* loaded from: classes.dex */
public abstract class u extends n1 implements t {
    public u() {
        attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (a(i2, parcel, parcel2, i3)) {
            return true;
        }
        if (i2 == 1) {
            a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) o1.a(parcel, Bundle.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            b(parcel.readInt(), (Bundle) o1.a(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
