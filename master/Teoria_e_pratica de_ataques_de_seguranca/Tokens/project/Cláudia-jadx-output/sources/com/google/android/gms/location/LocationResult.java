package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import c.d.a.a.h.a;
import c.d.a.a.h.c;
import c.d.a.a.i.l;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class LocationResult extends a implements ReflectedParcelable {

    /* renamed from: a  reason: collision with root package name */
    public final List<Location> f4107a;

    /* renamed from: b  reason: collision with root package name */
    public static final List<Location> f4106b = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new l();

    public LocationResult(List<Location> list) {
        this.f4107a = list;
    }

    public final List<Location> b() {
        return this.f4107a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationResult) {
            LocationResult locationResult = (LocationResult) obj;
            if (locationResult.f4107a.size() != this.f4107a.size()) {
                return false;
            }
            Iterator<Location> it = locationResult.f4107a.iterator();
            Iterator<Location> it2 = this.f4107a.iterator();
            while (it.hasNext()) {
                if (it2.next().getTime() != it.next().getTime()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 17;
        for (Location location : this.f4107a) {
            long time = location.getTime();
            i2 = (i2 * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f4107a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.a(parcel, 1, (List) b(), false);
        c.c(parcel, a2);
    }
}
