package c.d.a.a.i;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class t implements Parcelable.Creator<s> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        long j = 50;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        float f2 = 0.0f;
        int i2 = Integer.MAX_VALUE;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                z = c.d.a.a.h.b.d(parcel, readInt);
            } else if (i3 == 2) {
                j = c.d.a.a.h.b.f(parcel, readInt);
            } else if (i3 == 3) {
                f2 = c.d.a.a.h.b.g(parcel, readInt);
            } else if (i3 == 4) {
                j2 = c.d.a.a.h.b.f(parcel, readInt);
            } else if (i3 != 5) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new s(z, j, f2, j2, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ s[] newArray(int i2) {
        return new s[i2];
    }
}
