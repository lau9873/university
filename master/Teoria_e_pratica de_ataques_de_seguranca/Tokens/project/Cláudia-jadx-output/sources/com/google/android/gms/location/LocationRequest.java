package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import c.d.a.a.h.a;
import c.d.a.a.h.c;
import c.d.a.a.i.k;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g.a.a.n.m;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class LocationRequest extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    public int f4098a;

    /* renamed from: b  reason: collision with root package name */
    public long f4099b;

    /* renamed from: c  reason: collision with root package name */
    public long f4100c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4101d;

    /* renamed from: e  reason: collision with root package name */
    public long f4102e;

    /* renamed from: f  reason: collision with root package name */
    public int f4103f;

    /* renamed from: g  reason: collision with root package name */
    public float f4104g;

    /* renamed from: h  reason: collision with root package name */
    public long f4105h;

    public LocationRequest() {
        this.f4098a = 102;
        this.f4099b = 3600000L;
        this.f4100c = 600000L;
        this.f4101d = false;
        this.f4102e = Long.MAX_VALUE;
        this.f4103f = Integer.MAX_VALUE;
        this.f4104g = 0.0f;
        this.f4105h = 0L;
    }

    public LocationRequest(int i2, long j, long j2, boolean z, long j3, int i3, float f2, long j4) {
        this.f4098a = i2;
        this.f4099b = j;
        this.f4100c = j2;
        this.f4101d = z;
        this.f4102e = j3;
        this.f4103f = i3;
        this.f4104g = f2;
        this.f4105h = j4;
    }

    public final long b() {
        long j = this.f4105h;
        long j2 = this.f4099b;
        return j < j2 ? j2 : j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            return this.f4098a == locationRequest.f4098a && this.f4099b == locationRequest.f4099b && this.f4100c == locationRequest.f4100c && this.f4101d == locationRequest.f4101d && this.f4102e == locationRequest.f4102e && this.f4103f == locationRequest.f4103f && this.f4104g == locationRequest.f4104g && b() == locationRequest.b();
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4098a), Long.valueOf(this.f4099b), Float.valueOf(this.f4104g), Long.valueOf(this.f4105h)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i2 = this.f4098a;
        sb.append(i2 != 100 ? i2 != 102 ? i2 != 104 ? i2 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f4098a != 105) {
            sb.append(" requested=");
            sb.append(this.f4099b);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f4100c);
        sb.append("ms");
        if (this.f4105h > this.f4099b) {
            sb.append(" maxWait=");
            sb.append(this.f4105h);
            sb.append("ms");
        }
        if (this.f4104g > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f4104g);
            sb.append(m.f6144d);
        }
        long j = this.f4102e;
        if (j != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.f4103f != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f4103f);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f4098a);
        c.a(parcel, 2, this.f4099b);
        c.a(parcel, 3, this.f4100c);
        c.a(parcel, 4, this.f4101d);
        c.a(parcel, 5, this.f4102e);
        c.b(parcel, 6, this.f4103f);
        c.a(parcel, 7, this.f4104g);
        c.a(parcel, 8, this.f4105h);
        c.c(parcel, a2);
    }
}
