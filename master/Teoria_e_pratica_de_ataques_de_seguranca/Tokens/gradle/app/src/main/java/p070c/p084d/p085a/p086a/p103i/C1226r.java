package p070c.p084d.p085a.p086a.p103i;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.i.r */
/* loaded from: classes.dex */
public final class C1226r implements Parcelable.Creator<C1209c> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1209c createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i3 != 2) {
                C1137b.m5089c(parcel, readInt);
            } else {
                i2 = C1137b.m5086e(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1209c(i, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1209c[] newArray(int i) {
        return new C1209c[i];
    }
}
