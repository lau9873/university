package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;
import p070c.p084d.p085a.p086a.p103i.C1218j;
import p070c.p084d.p085a.p086a.p103i.C1222n;

/* loaded from: classes.dex */
public final class LocationAvailability extends AbstractC1134a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new C1218j();
    @Deprecated

    /* renamed from: a */
    public int f6139a;
    @Deprecated

    /* renamed from: b */
    public int f6140b;

    /* renamed from: c */
    public long f6141c;

    /* renamed from: d */
    public int f6142d;

    /* renamed from: e */
    public C1222n[] f6143e;

    public LocationAvailability(int i, int i2, int i3, long j, C1222n[] c1222nArr) {
        this.f6142d = i;
        this.f6139a = i2;
        this.f6140b = i3;
        this.f6141c = j;
        this.f6143e = c1222nArr;
    }

    /* renamed from: b */
    public final boolean m4331b() {
        return this.f6142d < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LocationAvailability.class == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f6139a == locationAvailability.f6139a && this.f6140b == locationAvailability.f6140b && this.f6141c == locationAvailability.f6141c && this.f6142d == locationAvailability.f6142d && Arrays.equals(this.f6143e, locationAvailability.f6143e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6142d), Integer.valueOf(this.f6139a), Integer.valueOf(this.f6140b), Long.valueOf(this.f6141c), this.f6143e});
    }

    public final String toString() {
        boolean m4331b = m4331b();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(m4331b);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f6139a);
        C1140c.m5066b(parcel, 2, this.f6140b);
        C1140c.m5076a(parcel, 3, this.f6141c);
        C1140c.m5066b(parcel, 4, this.f6142d);
        C1140c.m5069a(parcel, 5, (Parcelable[]) this.f6143e, i, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
