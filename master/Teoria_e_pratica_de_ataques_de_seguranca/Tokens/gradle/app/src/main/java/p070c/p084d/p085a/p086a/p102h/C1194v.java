package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c.d.a.a.h.v */
/* loaded from: classes.dex */
public final class C1194v implements Parcelable.Creator<C1192u> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1192u createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i2 != 2) {
                C1137b.m5089c(parcel, readInt);
            } else {
                str = C1137b.m5083h(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1192u(i, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1192u[] newArray(int i) {
        return new C1192u[i];
    }
}
