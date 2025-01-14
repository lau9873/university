package c.d.a.a.i;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationAvailability;
/* loaded from: classes.dex */
public final class j implements Parcelable.Creator<LocationAvailability> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        long j = 0;
        n[] nVarArr = null;
        int i2 = 1000;
        int i3 = 1;
        int i4 = 1;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i3 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i5 == 2) {
                i4 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i5 == 3) {
                j = c.d.a.a.h.b.f(parcel, readInt);
            } else if (i5 == 4) {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i5 != 5) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                nVarArr = (n[]) c.d.a.a.h.b.b(parcel, readInt, n.CREATOR);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new LocationAvailability(i2, i3, i4, j, nVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i2) {
        return new LocationAvailability[i2];
    }
}
