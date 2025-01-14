package p070c.p084d.p085a.p086a.p103i;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationResult;
import java.util.List;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.i.l */
/* loaded from: classes.dex */
public final class C1220l implements Parcelable.Creator<LocationResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        List<Location> list = LocationResult.f6152b;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                C1137b.m5089c(parcel, readInt);
            } else {
                list = C1137b.m5088c(parcel, readInt, Location.CREATOR);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new LocationResult(list);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult[] newArray(int i) {
        return new LocationResult[i];
    }
}
