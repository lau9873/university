package c.d.a.a.h;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class b1 implements Parcelable.Creator<a1> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a1 createFromParcel(Parcel parcel) {
        int a2 = b.a(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = b.e(parcel, readInt);
            } else if (i4 == 2) {
                i3 = b.e(parcel, readInt);
            } else if (i4 != 3) {
                b.c(parcel, readInt);
            } else {
                intent = (Intent) b.a(parcel, readInt, Intent.CREATOR);
            }
        }
        b.b(parcel, a2);
        return new a1(i2, i3, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a1[] newArray(int i2) {
        return new a1[i2];
    }
}
