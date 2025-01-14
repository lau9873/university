package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class l1 implements Parcelable.Creator<k1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k1 createFromParcel(Parcel parcel) {
        int a2 = b.a(parcel);
        c.d.a.a.e.a aVar = null;
        int i2 = 0;
        c.d.a.a.e.f.f0 f0Var = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = b.e(parcel, readInt);
            } else if (i3 == 2) {
                aVar = (c.d.a.a.e.a) b.a(parcel, readInt, c.d.a.a.e.a.CREATOR);
            } else if (i3 != 3) {
                b.c(parcel, readInt);
            } else {
                f0Var = (c.d.a.a.e.f.f0) b.a(parcel, readInt, c.d.a.a.e.f.f0.CREATOR);
            }
        }
        b.b(parcel, a2);
        return new k1(i2, aVar, f0Var);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k1[] newArray(int i2) {
        return new k1[i2];
    }
}
