package c.d.a.a.i;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class r implements Parcelable.Creator<c> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i4 != 2) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                i3 = c.d.a.a.h.b.e(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new c(i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ c[] newArray(int i2) {
        return new c[i2];
    }
}
