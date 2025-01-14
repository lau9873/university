package c.d.a.a.e;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class j implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        int i2 = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i4 == 2) {
                i3 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) c.d.a.a.h.b.a(parcel, readInt, PendingIntent.CREATOR);
            } else if (i4 != 4) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                str = c.d.a.a.h.b.h(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new a(i2, i3, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a[] newArray(int i2) {
        return new a[i2];
    }
}
