package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class j1 implements Parcelable.Creator<i1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i1 createFromParcel(Parcel parcel) {
        int a2 = b.a(parcel);
        int i2 = 0;
        c.d.a.a.e.f.d0 d0Var = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = b.e(parcel, readInt);
            } else if (i3 != 2) {
                b.c(parcel, readInt);
            } else {
                d0Var = (c.d.a.a.e.f.d0) b.a(parcel, readInt, c.d.a.a.e.f.d0.CREATOR);
            }
        }
        b.b(parcel, a2);
        return new i1(i2, d0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ i1[] newArray(int i2) {
        return new i1[i2];
    }
}
