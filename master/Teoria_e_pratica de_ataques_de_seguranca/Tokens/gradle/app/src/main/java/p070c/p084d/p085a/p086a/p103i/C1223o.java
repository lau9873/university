package p070c.p084d.p085a.p086a.p103i;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.i.o */
/* loaded from: classes.dex */
public final class C1223o implements Parcelable.Creator<C1222n> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1222n createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        long j = -1;
        long j2 = -1;
        int i = 1;
        int i2 = 1;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i3 == 2) {
                i2 = C1137b.m5086e(parcel, readInt);
            } else if (i3 == 3) {
                j = C1137b.m5085f(parcel, readInt);
            } else if (i3 != 4) {
                C1137b.m5089c(parcel, readInt);
            } else {
                j2 = C1137b.m5085f(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1222n(i, i2, j, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1222n[] newArray(int i) {
        return new C1222n[i];
    }
}
