package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class o0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public LocationRequest f3623a;

    /* renamed from: b  reason: collision with root package name */
    public List<u> f3624b;

    /* renamed from: c  reason: collision with root package name */
    public String f3625c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3626d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3627e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3628f;

    /* renamed from: g  reason: collision with root package name */
    public String f3629g;

    /* renamed from: h  reason: collision with root package name */
    public static final List<u> f3622h = Collections.emptyList();
    public static final Parcelable.Creator<o0> CREATOR = new p0();

    public o0(LocationRequest locationRequest, List<u> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f3623a = locationRequest;
        this.f3624b = list;
        this.f3625c = str;
        this.f3626d = z;
        this.f3627e = z2;
        this.f3628f = z3;
        this.f3629g = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o0) {
            o0 o0Var = (o0) obj;
            return c.d.a.a.e.f.z.a(this.f3623a, o0Var.f3623a) && c.d.a.a.e.f.z.a(this.f3624b, o0Var.f3624b) && c.d.a.a.e.f.z.a(this.f3625c, o0Var.f3625c) && this.f3626d == o0Var.f3626d && this.f3627e == o0Var.f3627e && this.f3628f == o0Var.f3628f && c.d.a.a.e.f.z.a(this.f3629g, o0Var.f3629g);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3623a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3623a.toString());
        if (this.f3625c != null) {
            sb.append(" tag=");
            sb.append(this.f3625c);
        }
        if (this.f3629g != null) {
            sb.append(" moduleId=");
            sb.append(this.f3629g);
        }
        sb.append(" hideAppOps=");
        sb.append(this.f3626d);
        sb.append(" clients=");
        sb.append(this.f3624b);
        sb.append(" forceCoarseLocation=");
        sb.append(this.f3627e);
        if (this.f3628f) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.a(parcel, 1, (Parcelable) this.f3623a, i2, false);
        c.a(parcel, 5, (List) this.f3624b, false);
        c.a(parcel, 6, this.f3625c, false);
        c.a(parcel, 7, this.f3626d);
        c.a(parcel, 8, this.f3627e);
        c.a(parcel, 9, this.f3628f);
        c.a(parcel, 10, this.f3629g, false);
        c.c(parcel, a2);
    }
}
