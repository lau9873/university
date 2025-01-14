package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class x implements Parcelable.Creator<w> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w createFromParcel(Parcel parcel) {
        int a2 = b.a(parcel);
        c.d.a.a.i.s sVar = w.f3645e;
        List<u> list = w.f3644d;
        String str = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                sVar = (c.d.a.a.i.s) b.a(parcel, readInt, c.d.a.a.i.s.CREATOR);
            } else if (i2 == 2) {
                list = b.c(parcel, readInt, u.CREATOR);
            } else if (i2 != 3) {
                b.c(parcel, readInt);
            } else {
                str = b.h(parcel, readInt);
            }
        }
        b.b(parcel, a2);
        return new w(sVar, list, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w[] newArray(int i2) {
        return new w[i2];
    }
}
