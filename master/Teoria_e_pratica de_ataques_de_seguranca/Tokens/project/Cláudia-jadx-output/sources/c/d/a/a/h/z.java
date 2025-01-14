package c.d.a.a.h;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class z implements Parcelable.Creator<y> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ y createFromParcel(Parcel parcel) {
        int a2 = b.a(parcel);
        w wVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i2 = 1;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = b.e(parcel, readInt);
            } else if (i3 == 2) {
                wVar = (w) b.a(parcel, readInt, w.CREATOR);
            } else if (i3 == 3) {
                iBinder = b.i(parcel, readInt);
            } else if (i3 != 4) {
                b.c(parcel, readInt);
            } else {
                iBinder2 = b.i(parcel, readInt);
            }
        }
        b.b(parcel, a2);
        return new y(i2, wVar, iBinder, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ y[] newArray(int i2) {
        return new y[i2];
    }
}
