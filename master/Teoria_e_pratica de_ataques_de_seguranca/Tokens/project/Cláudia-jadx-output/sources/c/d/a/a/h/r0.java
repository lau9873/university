package c.d.a.a.h;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class r0 implements Parcelable.Creator<q0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q0 createFromParcel(Parcel parcel) {
        int a2 = b.a(parcel);
        o0 o0Var = null;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        int i2 = 1;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = b.e(parcel, readInt);
                    break;
                case 2:
                    o0Var = (o0) b.a(parcel, readInt, o0.CREATOR);
                    break;
                case 3:
                    iBinder = b.i(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) b.a(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = b.i(parcel, readInt);
                    break;
                case 6:
                    iBinder3 = b.i(parcel, readInt);
                    break;
                default:
                    b.c(parcel, readInt);
                    break;
            }
        }
        b.b(parcel, a2);
        return new q0(i2, o0Var, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ q0[] newArray(int i2) {
        return new q0[i2];
    }
}
