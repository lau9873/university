package c.d.a.a.i;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationResult;
import java.util.List;
/* loaded from: classes.dex */
public final class l implements Parcelable.Creator<LocationResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult createFromParcel(Parcel parcel) {
        int a2 = c.d.a.a.h.b.a(parcel);
        List<Location> list = LocationResult.f4106b;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                c.d.a.a.h.b.c(parcel, readInt);
            } else {
                list = c.d.a.a.h.b.c(parcel, readInt, Location.CREATOR);
            }
        }
        c.d.a.a.h.b.b(parcel, a2);
        return new LocationResult(list);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult[] newArray(int i2) {
        return new LocationResult[i2];
    }
}
