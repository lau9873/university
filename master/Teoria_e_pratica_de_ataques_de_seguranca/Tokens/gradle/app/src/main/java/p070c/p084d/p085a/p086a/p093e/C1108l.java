package p070c.p084d.p085a.p086a.p093e;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.e.l */
/* loaded from: classes.dex */
public final class C1108l implements Parcelable.Creator<C1107k> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1107k createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = C1137b.m5083h(parcel, readInt);
            } else if (i2 != 2) {
                C1137b.m5089c(parcel, readInt);
            } else {
                i = C1137b.m5086e(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1107k(str, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1107k[] newArray(int i) {
        return new C1107k[i];
    }
}
