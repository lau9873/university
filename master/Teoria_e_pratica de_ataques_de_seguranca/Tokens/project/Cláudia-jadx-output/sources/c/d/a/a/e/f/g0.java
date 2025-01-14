package c.d.a.a.e.f;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class g0 implements Parcelable.Creator<f0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0 createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        IBinder iBinder = null;
        c.d.a.a.e.a aVar = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i3 == 2) {
                iBinder = c.d.a.a.h.b.i(parcel, readInt);
            } else if (i3 == 3) {
                aVar = (c.d.a.a.e.a) c.d.a.a.h.b.a(parcel, readInt, c.d.a.a.e.a.CREATOR);
            } else if (i3 == 4) {
                z = c.d.a.a.h.b.d(parcel, readInt);
            } else if (i3 != 5) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                z2 = c.d.a.a.h.b.d(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new f0(i2, iBinder, aVar, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f0[] newArray(int i2) {
        return new f0[i2];
    }
}
