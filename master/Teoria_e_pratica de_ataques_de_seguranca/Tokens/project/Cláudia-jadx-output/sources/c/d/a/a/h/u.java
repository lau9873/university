package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class u extends a {
    public static final Parcelable.Creator<u> CREATOR = new v();

    /* renamed from: a  reason: collision with root package name */
    public int f3637a;

    /* renamed from: b  reason: collision with root package name */
    public String f3638b;

    public u(int i2, String str) {
        this.f3637a = i2;
        this.f3638b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof u)) {
            u uVar = (u) obj;
            if (uVar.f3637a == this.f3637a && c.d.a.a.e.f.z.a(uVar.f3638b, this.f3638b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3637a;
    }

    public final String toString() {
        return String.format("%d:%s", Integer.valueOf(this.f3637a), this.f3638b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f3637a);
        c.a(parcel, 2, this.f3638b, false);
        c.c(parcel, a2);
    }
}
