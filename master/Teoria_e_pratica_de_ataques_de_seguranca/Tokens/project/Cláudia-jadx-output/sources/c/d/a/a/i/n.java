package c.d.a.a.i;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class n extends c.d.a.a.h.a {
    public static final Parcelable.Creator<n> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    public int f3671a;

    /* renamed from: b  reason: collision with root package name */
    public int f3672b;

    /* renamed from: c  reason: collision with root package name */
    public long f3673c;

    /* renamed from: d  reason: collision with root package name */
    public long f3674d;

    public n(int i2, int i3, long j, long j2) {
        this.f3671a = i2;
        this.f3672b = i3;
        this.f3673c = j;
        this.f3674d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            if (this.f3671a == nVar.f3671a && this.f3672b == nVar.f3672b && this.f3673c == nVar.f3673c && this.f3674d == nVar.f3674d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3672b), Integer.valueOf(this.f3671a), Long.valueOf(this.f3674d), Long.valueOf(this.f3673c)});
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f3671a + " Cell status: " + this.f3672b + " elapsed time NS: " + this.f3674d + " system time ms: " + this.f3673c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.b(parcel, 1, this.f3671a);
        c.d.a.a.h.c.b(parcel, 2, this.f3672b);
        c.d.a.a.h.c.a(parcel, 3, this.f3673c);
        c.d.a.a.h.c.a(parcel, 4, this.f3674d);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
