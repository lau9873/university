package p070c.p084d.p085a.p086a.p093e.p096f;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.e.f.g0 */
/* loaded from: classes.dex */
public final class C1058g0 implements Parcelable.Creator<C1056f0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1056f0 createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        IBinder iBinder = null;
        C0900a c0900a = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i2 == 2) {
                iBinder = C1137b.m5082i(parcel, readInt);
            } else if (i2 == 3) {
                c0900a = (C0900a) C1137b.m5092a(parcel, readInt, C0900a.CREATOR);
            } else if (i2 == 4) {
                z = C1137b.m5087d(parcel, readInt);
            } else if (i2 != 5) {
                C1137b.m5089c(parcel, readInt);
            } else {
                z2 = C1137b.m5087d(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1056f0(i, iBinder, c0900a, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1056f0[] newArray(int i) {
        return new C1056f0[i];
    }
}
