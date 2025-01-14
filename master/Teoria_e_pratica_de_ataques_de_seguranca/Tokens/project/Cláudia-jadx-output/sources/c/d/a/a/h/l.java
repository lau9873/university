package c.d.a.a.h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import c.d.a.a.f.a;
/* loaded from: classes.dex */
public abstract class l extends n1 implements k {
    public l() {
        attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
    }

    public static k asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return queryLocalInterface instanceof k ? (k) queryLocalInterface : new m(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (a(i2, parcel, parcel2, i3)) {
            return true;
        }
        if (i2 == 1) {
            init(a.AbstractBinderC0059a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i2 == 2) {
            boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), o1.a(parcel), parcel.readInt());
            parcel2.writeNoException();
            o1.a(parcel2, booleanFlagValue);
        } else if (i2 == 3) {
            int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(intFlagValue);
        } else if (i2 == 4) {
            long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(longFlagValue);
        } else if (i2 != 5) {
            return false;
        } else {
            String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeString(stringFlagValue);
        }
        return true;
    }
}
