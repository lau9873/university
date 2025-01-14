package c.d.a.a.i;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
/* loaded from: classes.dex */
public final class k implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        long j4 = 0;
        int i2 = 102;
        boolean z = false;
        int i3 = Integer.MAX_VALUE;
        float f2 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = c.d.a.a.h.b.e(parcel, readInt);
                    break;
                case 2:
                    j = c.d.a.a.h.b.f(parcel, readInt);
                    break;
                case 3:
                    j2 = c.d.a.a.h.b.f(parcel, readInt);
                    break;
                case 4:
                    z = c.d.a.a.h.b.d(parcel, readInt);
                    break;
                case 5:
                    j3 = c.d.a.a.h.b.f(parcel, readInt);
                    break;
                case 6:
                    i3 = c.d.a.a.h.b.e(parcel, readInt);
                    break;
                case 7:
                    f2 = c.d.a.a.h.b.g(parcel, readInt);
                    break;
                case 8:
                    j4 = c.d.a.a.h.b.f(parcel, readInt);
                    break;
                default:
                    c.d.a.a.h.b.c(parcel, readInt);
                    break;
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new LocationRequest(i2, j, j2, z, j3, i3, f2, j4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest[] newArray(int i2) {
        return new LocationRequest[i2];
    }
}
