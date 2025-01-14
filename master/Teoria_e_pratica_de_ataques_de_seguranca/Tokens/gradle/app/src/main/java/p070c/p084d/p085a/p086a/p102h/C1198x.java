package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import p070c.p084d.p085a.p086a.p103i.C1227s;

/* renamed from: c.d.a.a.h.x */
/* loaded from: classes.dex */
public final class C1198x implements Parcelable.Creator<C1196w> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1196w createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        C1227s c1227s = C1196w.f5588e;
        List<C1192u> list = C1196w.f5587d;
        String str = null;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                c1227s = (C1227s) C1137b.m5092a(parcel, readInt, C1227s.CREATOR);
            } else if (i == 2) {
                list = C1137b.m5088c(parcel, readInt, C1192u.CREATOR);
            } else if (i != 3) {
                C1137b.m5089c(parcel, readInt);
            } else {
                str = C1137b.m5083h(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1196w(c1227s, list, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1196w[] newArray(int i) {
        return new C1196w[i];
    }
}
