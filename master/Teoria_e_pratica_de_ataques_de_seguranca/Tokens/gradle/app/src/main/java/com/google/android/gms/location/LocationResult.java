package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;
import p070c.p084d.p085a.p086a.p103i.C1220l;

/* loaded from: classes.dex */
public final class LocationResult extends AbstractC1134a implements ReflectedParcelable {

    /* renamed from: a */
    public final List<Location> f6153a;

    /* renamed from: b */
    public static final List<Location> f6152b = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new C1220l();

    public LocationResult(List<Location> list) {
        this.f6153a = list;
    }

    /* renamed from: b */
    public final List<Location> m4329b() {
        return this.f6153a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationResult) {
            LocationResult locationResult = (LocationResult) obj;
            if (locationResult.f6153a.size() != this.f6153a.size()) {
                return false;
            }
            Iterator<Location> it = locationResult.f6153a.iterator();
            Iterator<Location> it2 = this.f6153a.iterator();
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
        int i = 17;
        for (Location location : this.f6153a) {
            long time = location.getTime();
            i = (i * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f6153a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5071a(parcel, 1, (List) m4329b(), false);
        C1140c.m5065c(parcel, m5080a);
    }
}
