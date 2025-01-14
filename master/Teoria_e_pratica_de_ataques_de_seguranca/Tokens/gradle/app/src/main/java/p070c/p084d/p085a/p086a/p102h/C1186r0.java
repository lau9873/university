package p070c.p084d.p085a.p086a.p102h;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: c.d.a.a.h.r0 */
/* loaded from: classes.dex */
public final class C1186r0 implements Parcelable.Creator<C1183q0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1183q0 createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        C1177o0 c1177o0 = null;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        int i = 1;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = C1137b.m5086e(parcel, readInt);
                    break;
                case 2:
                    c1177o0 = (C1177o0) C1137b.m5092a(parcel, readInt, C1177o0.CREATOR);
                    break;
                case 3:
                    iBinder = C1137b.m5082i(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) C1137b.m5092a(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = C1137b.m5082i(parcel, readInt);
                    break;
                case 6:
                    iBinder3 = C1137b.m5082i(parcel, readInt);
                    break;
                default:
                    C1137b.m5089c(parcel, readInt);
                    break;
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1183q0(i, c1177o0, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1183q0[] newArray(int i) {
        return new C1183q0[i];
    }
}
