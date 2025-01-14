package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import p070c.p084d.p085a.p086a.p093e.p096f.C1095z;

/* renamed from: c.d.a.a.h.o0 */
/* loaded from: classes.dex */
public final class C1177o0 extends AbstractC1134a {

    /* renamed from: a */
    public LocationRequest f5561a;

    /* renamed from: b */
    public List<C1192u> f5562b;

    /* renamed from: c */
    public String f5563c;

    /* renamed from: d */
    public boolean f5564d;

    /* renamed from: e */
    public boolean f5565e;

    /* renamed from: f */
    public boolean f5566f;

    /* renamed from: g */
    public String f5567g;

    /* renamed from: h */
    public static final List<C1192u> f5560h = Collections.emptyList();
    public static final Parcelable.Creator<C1177o0> CREATOR = new C1180p0();

    public C1177o0(LocationRequest locationRequest, List<C1192u> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.f5561a = locationRequest;
        this.f5562b = list;
        this.f5563c = str;
        this.f5564d = z;
        this.f5565e = z2;
        this.f5566f = z3;
        this.f5567g = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1177o0) {
            C1177o0 c1177o0 = (C1177o0) obj;
            return C1095z.m5149a(this.f5561a, c1177o0.f5561a) && C1095z.m5149a(this.f5562b, c1177o0.f5562b) && C1095z.m5149a(this.f5563c, c1177o0.f5563c) && this.f5564d == c1177o0.f5564d && this.f5565e == c1177o0.f5565e && this.f5566f == c1177o0.f5566f && C1095z.m5149a(this.f5567g, c1177o0.f5567g);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5561a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5561a.toString());
        if (this.f5563c != null) {
            sb.append(" tag=");
            sb.append(this.f5563c);
        }
        if (this.f5567g != null) {
            sb.append(" moduleId=");
            sb.append(this.f5567g);
        }
        sb.append(" hideAppOps=");
        sb.append(this.f5564d);
        sb.append(" clients=");
        sb.append(this.f5562b);
        sb.append(" forceCoarseLocation=");
        sb.append(this.f5565e);
        if (this.f5566f) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5073a(parcel, 1, (Parcelable) this.f5561a, i, false);
        C1140c.m5071a(parcel, 5, (List) this.f5562b, false);
        C1140c.m5072a(parcel, 6, this.f5563c, false);
        C1140c.m5070a(parcel, 7, this.f5564d);
        C1140c.m5070a(parcel, 8, this.f5565e);
        C1140c.m5070a(parcel, 9, this.f5566f);
        C1140c.m5072a(parcel, 10, this.f5567g, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
