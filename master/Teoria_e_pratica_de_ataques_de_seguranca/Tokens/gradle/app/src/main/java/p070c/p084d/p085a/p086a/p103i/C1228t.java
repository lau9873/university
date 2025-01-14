package p070c.p084d.p085a.p086a.p103i;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.i.t */
/* loaded from: classes.dex */
public final class C1228t implements Parcelable.Creator<C1227s> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1227s createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        long j = 50;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        float f = 0.0f;
        int i = Integer.MAX_VALUE;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                z = C1137b.m5087d(parcel, readInt);
            } else if (i2 == 2) {
                j = C1137b.m5085f(parcel, readInt);
            } else if (i2 == 3) {
                f = C1137b.m5084g(parcel, readInt);
            } else if (i2 == 4) {
                j2 = C1137b.m5085f(parcel, readInt);
            } else if (i2 != 5) {
                C1137b.m5089c(parcel, readInt);
            } else {
                i = C1137b.m5086e(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1227s(z, j, f, j2, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1227s[] newArray(int i) {
        return new C1227s[i];
    }
}
