package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;
import p070c.p084d.p085a.p086a.p103i.C1219k;
import p193g.p194a.p195a.p199n.ScanJobScheduler;

/* loaded from: classes.dex */
public final class LocationRequest extends AbstractC1134a implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new C1219k();

    /* renamed from: a */
    public int f6144a;

    /* renamed from: b */
    public long f6145b;

    /* renamed from: c */
    public long f6146c;

    /* renamed from: d */
    public boolean f6147d;

    /* renamed from: e */
    public long f6148e;

    /* renamed from: f */
    public int f6149f;

    /* renamed from: g */
    public float f6150g;

    /* renamed from: h */
    public long f6151h;

    public LocationRequest() {
        this.f6144a = 102;
        this.f6145b = 3600000L;
        this.f6146c = 600000L;
        this.f6147d = false;
        this.f6148e = Long.MAX_VALUE;
        this.f6149f = Integer.MAX_VALUE;
        this.f6150g = 0.0f;
        this.f6151h = 0L;
    }

    public LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4) {
        this.f6144a = i;
        this.f6145b = j;
        this.f6146c = j2;
        this.f6147d = z;
        this.f6148e = j3;
        this.f6149f = i2;
        this.f6150g = f;
        this.f6151h = j4;
    }

    /* renamed from: b */
    public final long m4330b() {
        long j = this.f6151h;
        long j2 = this.f6145b;
        return j < j2 ? j2 : j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            return this.f6144a == locationRequest.f6144a && this.f6145b == locationRequest.f6145b && this.f6146c == locationRequest.f6146c && this.f6147d == locationRequest.f6147d && this.f6148e == locationRequest.f6148e && this.f6149f == locationRequest.f6149f && this.f6150g == locationRequest.f6150g && m4330b() == locationRequest.m4330b();
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6144a), Long.valueOf(this.f6145b), Float.valueOf(this.f6150g), Long.valueOf(this.f6151h)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i = this.f6144a;
        sb.append(i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f6144a != 105) {
            sb.append(" requested=");
            sb.append(this.f6145b);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f6146c);
        sb.append("ms");
        if (this.f6151h > this.f6145b) {
            sb.append(" maxWait=");
            sb.append(this.f6151h);
            sb.append("ms");
        }
        if (this.f6150g > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.f6150g);
            sb.append(ScanJobScheduler.f8608d);
        }
        long j = this.f6148e;
        if (j != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.f6149f != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f6149f);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f6144a);
        C1140c.m5076a(parcel, 2, this.f6145b);
        C1140c.m5076a(parcel, 3, this.f6146c);
        C1140c.m5070a(parcel, 4, this.f6147d);
        C1140c.m5076a(parcel, 5, this.f6148e);
        C1140c.m5066b(parcel, 6, this.f6149f);
        C1140c.m5078a(parcel, 7, this.f6150g);
        C1140c.m5076a(parcel, 8, this.f6151h);
        C1140c.m5065c(parcel, m5080a);
    }
}
