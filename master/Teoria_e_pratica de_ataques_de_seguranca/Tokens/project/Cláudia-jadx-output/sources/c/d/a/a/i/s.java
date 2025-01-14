package c.d.a.a.i;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class s extends c.d.a.a.h.a {
    public static final Parcelable.Creator<s> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    public boolean f3675a;

    /* renamed from: b  reason: collision with root package name */
    public long f3676b;

    /* renamed from: c  reason: collision with root package name */
    public float f3677c;

    /* renamed from: d  reason: collision with root package name */
    public long f3678d;

    /* renamed from: e  reason: collision with root package name */
    public int f3679e;

    public s() {
        this(true, 50L, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    public s(boolean z, long j, float f2, long j2, int i2) {
        this.f3675a = z;
        this.f3676b = j;
        this.f3677c = f2;
        this.f3678d = j2;
        this.f3679e = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            s sVar = (s) obj;
            return this.f3675a == sVar.f3675a && this.f3676b == sVar.f3676b && Float.compare(this.f3677c, sVar.f3677c) == 0 && this.f3678d == sVar.f3678d && this.f3679e == sVar.f3679e;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f3675a), Long.valueOf(this.f3676b), Float.valueOf(this.f3677c), Long.valueOf(this.f3678d), Integer.valueOf(this.f3679e)});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOrientationRequest[mShouldUseMag=");
        sb.append(this.f3675a);
        sb.append(" mMinimumSamplingPeriodMs=");
        sb.append(this.f3676b);
        sb.append(" mSmallestAngleChangeRadians=");
        sb.append(this.f3677c);
        long j = this.f3678d;
        if (j != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.f3679e != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f3679e);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.a(parcel, 1, this.f3675a);
        c.d.a.a.h.c.a(parcel, 2, this.f3676b);
        c.d.a.a.h.c.a(parcel, 3, this.f3677c);
        c.d.a.a.h.c.a(parcel, 4, this.f3678d);
        c.d.a.a.h.c.b(parcel, 5, this.f3679e);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
