package p070c.p084d.p085a.p086a.p103i;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.Arrays;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* renamed from: c.d.a.a.i.s */
/* loaded from: classes.dex */
public final class C1227s extends AbstractC1134a {
    public static final Parcelable.Creator<C1227s> CREATOR = new C1228t();

    /* renamed from: a */
    public boolean f5618a;

    /* renamed from: b */
    public long f5619b;

    /* renamed from: c */
    public float f5620c;

    /* renamed from: d */
    public long f5621d;

    /* renamed from: e */
    public int f5622e;

    public C1227s() {
        this(true, 50L, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public C1227s(boolean z, long j, float f, long j2, int i) {
        this.f5618a = z;
        this.f5619b = j;
        this.f5620c = f;
        this.f5621d = j2;
        this.f5622e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1227s) {
            C1227s c1227s = (C1227s) obj;
            return this.f5618a == c1227s.f5618a && this.f5619b == c1227s.f5619b && Float.compare(this.f5620c, c1227s.f5620c) == 0 && this.f5621d == c1227s.f5621d && this.f5622e == c1227s.f5622e;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f5618a), Long.valueOf(this.f5619b), Float.valueOf(this.f5620c), Long.valueOf(this.f5621d), Integer.valueOf(this.f5622e)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f5618a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f5619b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f5620c);
        long j = this.f5621d;
        if (j != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.f5622e != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f5622e);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5070a(parcel, 1, this.f5618a);
        C1140c.m5076a(parcel, 2, this.f5619b);
        C1140c.m5078a(parcel, 3, this.f5620c);
        C1140c.m5076a(parcel, 4, this.f5621d);
        C1140c.m5066b(parcel, 5, this.f5622e);
        C1140c.m5065c(parcel, m5080a);
    }
}
