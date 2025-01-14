package p070c.p084d.p085a.p086a.p093e.p094e;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.e.e.q */
/* loaded from: classes.dex */
public final class C1041q implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        int i = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = C1137b.m5086e(parcel, readInt);
            } else if (i3 == 2) {
                str = C1137b.m5083h(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) C1137b.m5092a(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 != 1000) {
                C1137b.m5089c(parcel, readInt);
            } else {
                i = C1137b.m5086e(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new Status(i, i2, str, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
