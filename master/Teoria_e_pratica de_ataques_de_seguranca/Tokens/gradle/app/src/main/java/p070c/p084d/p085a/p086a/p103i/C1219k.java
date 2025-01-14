package p070c.p084d.p085a.p086a.p103i;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import p070c.p084d.p085a.p086a.p102h.C1137b;

/* renamed from: c.d.a.a.i.k */
/* loaded from: classes.dex */
public final class C1219k implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int m5095a = C1137b.m5095a(parcel);
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        long j4 = 0;
        int i = 102;
        boolean z = false;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        while (parcel.dataPosition() < m5095a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = C1137b.m5086e(parcel, readInt);
                    break;
                case 2:
                    j = C1137b.m5085f(parcel, readInt);
                    break;
                case 3:
                    j2 = C1137b.m5085f(parcel, readInt);
                    break;
                case 4:
                    z = C1137b.m5087d(parcel, readInt);
                    break;
                case 5:
                    j3 = C1137b.m5085f(parcel, readInt);
                    break;
                case 6:
                    i2 = C1137b.m5086e(parcel, readInt);
                    break;
                case 7:
                    f = C1137b.m5084g(parcel, readInt);
                    break;
                case 8:
                    j4 = C1137b.m5085f(parcel, readInt);
                    break;
                default:
                    C1137b.m5089c(parcel, readInt);
                    break;
            }
        }
        C1137b.m5091b(parcel, m5095a);
        return new LocationRequest(i, j, j2, z, j3, i2, f, j4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationRequest[] newArray(int i) {
        return new LocationRequest[i];
    }
}
