package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.List;
/* loaded from: classes.dex */
public final class p0 implements Parcelable.Creator<o0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o0 createFromParcel(Parcel parcel) {
        int a2 = b.a(parcel);
        List<u> list = o0.f3622h;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 != 1) {
                switch (i2) {
                    case 5:
                        list = b.c(parcel, readInt, u.CREATOR);
                        continue;
                    case 6:
                        str = b.h(parcel, readInt);
                        continue;
                    case 7:
                        z = b.d(parcel, readInt);
                        continue;
                    case 8:
                        z2 = b.d(parcel, readInt);
                        continue;
                    case 9:
                        z3 = b.d(parcel, readInt);
                        continue;
                    case 10:
                        str2 = b.h(parcel, readInt);
                        continue;
                    default:
                        b.c(parcel, readInt);
                        continue;
                }
            } else {
                locationRequest = (LocationRequest) b.a(parcel, readInt, LocationRequest.CREATOR);
            }
        }
        b.b(parcel, a2);
        return new o0(locationRequest, list, str, z, z2, z3, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o0[] newArray(int i2) {
        return new o0[i2];
    }
}
