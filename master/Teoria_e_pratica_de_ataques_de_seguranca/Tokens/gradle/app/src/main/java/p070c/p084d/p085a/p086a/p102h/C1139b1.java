package p070c.p084d.p085a.p086a.p102h;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c.d.a.a.h.b1 */
/* loaded from: classes.dex */
public final class C1139b1 implements Parcelable.Creator<C1136a1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1136a1 createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i3 == 2) {
                i2 = C1137b.m5086e(parcel, readInt);
            } else if (i3 != 3) {
                C1137b.m5089c(parcel, readInt);
            } else {
                intent = (Intent) C1137b.m5092a(parcel, readInt, Intent.CREATOR);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1136a1(i, i2, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1136a1[] newArray(int i) {
        return new C1136a1[i];
    }
}
