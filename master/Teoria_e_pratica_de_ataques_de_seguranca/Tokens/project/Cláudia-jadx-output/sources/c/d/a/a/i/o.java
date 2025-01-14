package c.d.a.a.i;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class o implements Parcelable.Creator<n> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        long j = -1;
        long j2 = -1;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i4 == 2) {
                i3 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i4 == 3) {
                j = c.d.a.a.h.b.f(parcel, readInt);
            } else if (i4 != 4) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                j2 = c.d.a.a.h.b.f(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new n(i2, i3, j, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ n[] newArray(int i2) {
        return new n[i2];
    }
}
