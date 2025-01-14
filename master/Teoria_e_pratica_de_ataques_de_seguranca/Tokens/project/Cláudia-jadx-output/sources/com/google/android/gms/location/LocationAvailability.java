package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import c.d.a.a.h.a;
import c.d.a.a.h.c;
import c.d.a.a.i.j;
import c.d.a.a.i.n;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class LocationAvailability extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new j();
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public int f4093a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public int f4094b;

    /* renamed from: c  reason: collision with root package name */
    public long f4095c;

    /* renamed from: d  reason: collision with root package name */
    public int f4096d;

    /* renamed from: e  reason: collision with root package name */
    public n[] f4097e;

    public LocationAvailability(int i2, int i3, int i4, long j, n[] nVarArr) {
        this.f4096d = i2;
        this.f4093a = i3;
        this.f4094b = i4;
        this.f4095c = j;
        this.f4097e = nVarArr;
    }

    public final boolean b() {
        return this.f4096d < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LocationAvailability.class == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f4093a == locationAvailability.f4093a && this.f4094b == locationAvailability.f4094b && this.f4095c == locationAvailability.f4095c && this.f4096d == locationAvailability.f4096d && Arrays.equals(this.f4097e, locationAvailability.f4097e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4096d), Integer.valueOf(this.f4093a), Integer.valueOf(this.f4094b), Long.valueOf(this.f4095c), this.f4097e});
    }

    public final String toString() {
        boolean b2 = b();
        StringBuilder sb = new StringBuilder(48);
        sb.append("LocationAvailability[isLocationAvailable: ");
        sb.append(b2);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f4093a);
        c.b(parcel, 2, this.f4094b);
        c.a(parcel, 3, this.f4095c);
        c.b(parcel, 4, this.f4096d);
        c.a(parcel, 5, (Parcelable[]) this.f4097e, i2, false);
        c.c(parcel, a2);
    }
}
