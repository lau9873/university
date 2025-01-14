package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p093e.p096f.C1052d0;

/* renamed from: c.d.a.a.h.i1 */
/* loaded from: classes.dex */
public final class C1160i1 extends AbstractC1134a {
    public static final Parcelable.Creator<C1160i1> CREATOR = new C1163j1();

    /* renamed from: a */
    public int f5549a;

    /* renamed from: b */
    public C1052d0 f5550b;

    public C1160i1(int i, C1052d0 c1052d0) {
        this.f5549a = i;
        this.f5550b = c1052d0;
    }

    public C1160i1(C1052d0 c1052d0) {
        this(1, c1052d0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5549a);
        C1140c.m5073a(parcel, 2, (Parcelable) this.f5550b, i, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
