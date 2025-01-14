package p070c.p084d.p085a.p086a.p103i;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* renamed from: c.d.a.a.i.n */
/* loaded from: classes.dex */
public final class C1222n extends AbstractC1134a {
    public static final Parcelable.Creator<C1222n> CREATOR = new C1223o();

    /* renamed from: a */
    public int f5614a;

    /* renamed from: b */
    public int f5615b;

    /* renamed from: c */
    public long f5616c;

    /* renamed from: d */
    public long f5617d;

    public C1222n(int i, int i2, long j, long j2) {
        this.f5614a = i;
        this.f5615b = i2;
        this.f5616c = j;
        this.f5617d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C1222n.class == obj.getClass()) {
            C1222n c1222n = (C1222n) obj;
            if (this.f5614a == c1222n.f5614a && this.f5615b == c1222n.f5615b && this.f5616c == c1222n.f5616c && this.f5617d == c1222n.f5617d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5615b), Integer.valueOf(this.f5614a), Long.valueOf(this.f5617d), Long.valueOf(this.f5616c)});
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f5614a + " Cell status: " + this.f5615b + " elapsed time NS: " + this.f5617d + " system time ms: " + this.f5616c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5614a);
        C1140c.m5066b(parcel, 2, this.f5615b);
        C1140c.m5076a(parcel, 3, this.f5616c);
        C1140c.m5076a(parcel, 4, this.f5617d);
        C1140c.m5065c(parcel, m5080a);
    }
}
