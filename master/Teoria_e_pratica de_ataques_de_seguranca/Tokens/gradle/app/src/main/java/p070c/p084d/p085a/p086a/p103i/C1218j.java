package p070c.p084d.p085a.p086a.p103i;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationAvailability;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.i.j */
/* loaded from: classes.dex */
public final class C1218j implements Parcelable.Creator<LocationAvailability> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        long j = 0;
        C1222n[] c1222nArr = null;
        int i = 1000;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = C1137b.m5086e(parcel, readInt);
            } else if (i4 == 2) {
                i3 = C1137b.m5086e(parcel, readInt);
            } else if (i4 == 3) {
                j = C1137b.m5085f(parcel, readInt);
            } else if (i4 == 4) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i4 != 5) {
                C1137b.m5089c(parcel, readInt);
            } else {
                c1222nArr = (C1222n[]) C1137b.m5090b(parcel, readInt, C1222n.CREATOR);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new LocationAvailability(i, i2, i3, j, c1222nArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
