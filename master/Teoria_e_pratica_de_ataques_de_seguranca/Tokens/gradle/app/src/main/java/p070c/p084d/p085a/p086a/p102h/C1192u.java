package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p093e.p096f.C1095z;

/* renamed from: c.d.a.a.h.u */
/* loaded from: classes.dex */
public final class C1192u extends AbstractC1134a {
    public static final Parcelable.Creator<C1192u> CREATOR = new C1194v();

    /* renamed from: a */
    public int f5580a;

    /* renamed from: b */
    public String f5581b;

    public C1192u(int i, String str) {
        this.f5580a = i;
        this.f5581b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof C1192u)) {
            C1192u c1192u = (C1192u) obj;
            if (c1192u.f5580a == this.f5580a && C1095z.m5149a(c1192u.f5581b, this.f5581b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5580a;
    }

    public final String toString() {
        return String.format("%d:%s", Integer.valueOf(this.f5580a), this.f5581b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5580a);
        C1140c.m5072a(parcel, 2, this.f5581b, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
