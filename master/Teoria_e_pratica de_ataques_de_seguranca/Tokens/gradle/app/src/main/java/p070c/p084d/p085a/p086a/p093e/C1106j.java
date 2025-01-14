package p070c.p084d.p085a.p086a.p093e;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.e.j */
/* loaded from: classes.dex */
public final class C1106j implements Parcelable.Creator<C0900a> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C0900a createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = C1137b.m5086e(parcel, readInt);
            } else if (i3 == 2) {
                i2 = C1137b.m5086e(parcel, readInt);
            } else if (i3 == 3) {
                pendingIntent = (PendingIntent) C1137b.m5092a(parcel, readInt, PendingIntent.CREATOR);
            } else if (i3 != 4) {
                C1137b.m5089c(parcel, readInt);
            } else {
                str = C1137b.m5083h(parcel, readInt);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C0900a(i, i2, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C0900a[] newArray(int i) {
        return new C0900a[i];
    }
}
