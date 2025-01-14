package p070c.p084d.p085a.p086a.p093e;

import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* renamed from: c.d.a.a.e.k */
/* loaded from: classes.dex */
public final class C1107k extends AbstractC1134a {
    public static final Parcelable.Creator<C1107k> CREATOR = new C1108l();

    /* renamed from: a */
    public String f5501a;

    /* renamed from: b */
    public int f5502b;

    public C1107k(String str, int i) {
        this.f5501a = str;
        this.f5502b = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5072a(parcel, 1, this.f5501a, false);
        C1140c.m5066b(parcel, 2, this.f5502b);
        C1140c.m5065c(parcel, m5080a);
    }
}
