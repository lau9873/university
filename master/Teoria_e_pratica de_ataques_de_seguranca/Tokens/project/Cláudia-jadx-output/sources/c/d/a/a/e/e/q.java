package c.d.a.a.e.e;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class q implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        int i2 = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i3 = c.d.a.a.h.b.e(parcel, readInt);
            } else if (i4 == 2) {
                str = c.d.a.a.h.b.h(parcel, readInt);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) c.d.a.a.h.b.a(parcel, readInt, PendingIntent.CREATOR);
            } else if (i4 != 1000) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                i2 = c.d.a.a.h.b.e(parcel, readInt);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new Status(i2, i3, str, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i2) {
        return new Status[i2];
    }
}
