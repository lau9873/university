package c.d.a.a.e;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class l implements Parcelable.Creator<k> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                str = c.d.a.a.h.b.h(parcel, readInt);
            } else if (i3 != 2) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new k(str, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k[] newArray(int i2) {
        return new k[i2];
    }
}
