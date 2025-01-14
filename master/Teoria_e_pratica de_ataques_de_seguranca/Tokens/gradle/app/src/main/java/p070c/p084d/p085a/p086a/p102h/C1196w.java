package p070c.p084d.p085a.p086a.p102h;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;
import p070c.p084d.p085a.p086a.p093e.p096f.C1095z;
import p070c.p084d.p085a.p086a.p103i.C1227s;

/* renamed from: c.d.a.a.h.w */
/* loaded from: classes.dex */
public final class C1196w extends AbstractC1134a {

    /* renamed from: a */
    public C1227s f5589a;

    /* renamed from: b */
    public List<C1192u> f5590b;

    /* renamed from: c */
    public String f5591c;

    /* renamed from: d */
    public static final List<C1192u> f5587d = Collections.emptyList();

    /* renamed from: e */
    public static final C1227s f5588e = new C1227s();
    public static final Parcelable.Creator<C1196w> CREATOR = new C1198x();

    public C1196w(C1227s c1227s, List<C1192u> list, String str) {
        this.f5589a = c1227s;
        this.f5590b = list;
        this.f5591c = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1196w) {
            C1196w c1196w = (C1196w) obj;
            return C1095z.m5149a(this.f5589a, c1196w.f5589a) && C1095z.m5149a(this.f5590b, c1196w.f5590b) && C1095z.m5149a(this.f5591c, c1196w.f5591c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5589a.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5073a(parcel, 1, (Parcelable) this.f5589a, i, false);
        C1140c.m5071a(parcel, 2, (List) this.f5590b, false);
        C1140c.m5072a(parcel, 3, this.f5591c, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
