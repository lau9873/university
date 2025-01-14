package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p096f.C1056f0;

/* renamed from: c.d.a.a.h.l1 */
/* loaded from: classes.dex */
public final class C1169l1 implements Parcelable.Creator<C1166k1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1166k1 createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        C0900a c0900a = null;
        int i = 0;
        C1056f0 c1056f0 = null;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i2 == 2) {
                c0900a = (C0900a) C1137b.m5092a(parcel, readInt, C0900a.CREATOR);
            } else if (i2 != 3) {
                C1137b.m5089c(parcel, readInt);
            } else {
                c1056f0 = (C1056f0) C1137b.m5092a(parcel, readInt, C1056f0.CREATOR);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1166k1(i, c0900a, c1056f0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1166k1[] newArray(int i) {
        return new C1166k1[i];
    }
}
