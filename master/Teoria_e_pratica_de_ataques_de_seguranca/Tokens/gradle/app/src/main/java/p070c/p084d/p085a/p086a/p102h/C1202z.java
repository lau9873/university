package p070c.p084d.p085a.p086a.p102h;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c.d.a.a.h.z */
/* loaded from: classes.dex */
public final class C1202z implements Parcelable.Creator<C1200y> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1200y createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        C1196w c1196w = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i = 1;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i2 == 2) {
                c1196w = (C1196w) C1137b.m5092a(parcel, readInt, C1196w.CREATOR);
            } else if (i2 == 3) {
                iBinder = C1137b.m5082i(parcel, readInt);
            } else if (i2 != 4) {
                C1137b.m5089c(parcel, readInt);
            } else {
                iBinder2 = C1137b.m5082i(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1200y(i, c1196w, iBinder, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1200y[] newArray(int i) {
        return new C1200y[i];
    }
}
