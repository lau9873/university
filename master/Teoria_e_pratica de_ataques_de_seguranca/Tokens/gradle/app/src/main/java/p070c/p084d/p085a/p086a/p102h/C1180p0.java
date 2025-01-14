package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* renamed from: c.d.a.a.h.p0 */
/* loaded from: classes.dex */
public final class C1180p0 implements Parcelable.Creator<C1177o0> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1177o0 createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        List<C1192u> list = C1177o0.f5560h;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i != 1) {
                switch (i) {
                    case 5:
                        list = C1137b.m5088c(parcel, readInt, C1192u.CREATOR);
                        continue;
                    case 6:
                        str = C1137b.m5083h(parcel, readInt);
                        continue;
                    case 7:
                        z = C1137b.m5087d(parcel, readInt);
                        continue;
                    case 8:
                        z2 = C1137b.m5087d(parcel, readInt);
                        continue;
                    case 9:
                        z3 = C1137b.m5087d(parcel, readInt);
                        continue;
                    case 10:
                        str2 = C1137b.m5083h(parcel, readInt);
                        continue;
                    default:
                        C1137b.m5089c(parcel, readInt);
                        continue;
                }
            } else {
                locationRequest = (LocationRequest) C1137b.m5092a(parcel, readInt, LocationRequest.CREATOR);
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new C1177o0(locationRequest, list, str, z, z2, z3, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ C1177o0[] newArray(int i) {
        return new C1177o0[i];
    }
}
