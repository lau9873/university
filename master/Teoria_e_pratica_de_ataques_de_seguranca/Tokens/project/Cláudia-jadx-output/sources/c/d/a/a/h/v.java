package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class v implements Parcelable.Creator<u> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u createFromParcel(Parcel parcel) {
        int a2 = b.a(parcel);
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = b.e(parcel, readInt);
            } else if (i3 != 2) {
                b.c(parcel, readInt);
            } else {
                str = b.h(parcel, readInt);
            }
        }
        b.b(parcel, a2);
        return new u(i2, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u[] newArray(int i2) {
        return new u[i2];
    }
}
