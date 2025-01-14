package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p093e.p096f.C1052d0;

/* renamed from: c.d.a.a.h.j1 */
/* loaded from: classes.dex */
public final class C1163j1 implements Parcelable.Creator<C1160i1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1160i1 createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        int i = 0;
        C1052d0 c1052d0 = null;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i2 != 2) {
                C1137b.m5089c(parcel, readInt);
            } else {
                c1052d0 = (C1052d0) C1137b.m5092a(parcel, readInt, C1052d0.CREATOR);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1160i1(i, c1052d0);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1160i1[] newArray(int i) {
        return new C1160i1[i];
    }
}
