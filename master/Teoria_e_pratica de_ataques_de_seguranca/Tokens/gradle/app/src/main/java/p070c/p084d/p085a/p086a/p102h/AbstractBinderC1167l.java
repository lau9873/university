package p070c.p084d.p085a.p086a.p102h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p070c.p084d.p085a.p086a.p099f.InterfaceC1119a;

/* renamed from: c.d.a.a.h.l */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1167l extends BinderC1175n1 implements InterfaceC1164k {
    public AbstractBinderC1167l() {
        attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
    }

    public static InterfaceC1164k asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return queryLocalInterface instanceof InterfaceC1164k ? (InterfaceC1164k) queryLocalInterface : new C1170m(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (m5026a(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i == 1) {
            init(InterfaceC1119a.AbstractBinderC1120a.m5103a(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i == 2) {
            boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), C1178o1.m5025a(parcel), parcel.readInt());
            parcel2.writeNoException();
            C1178o1.m5021a(parcel2, booleanFlagValue);
        } else if (i == 3) {
            int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeInt(intFlagValue);
        } else if (i == 4) {
            long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeLong(longFlagValue);
        } else if (i != 5) {
            return false;
        } else {
            String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
            parcel2.writeNoException();
            parcel2.writeString(stringFlagValue);
        }
        return true;
    }
}
