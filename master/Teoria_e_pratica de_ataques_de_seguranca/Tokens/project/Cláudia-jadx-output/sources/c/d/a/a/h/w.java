package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class w extends a {

    /* renamed from: a  reason: collision with root package name */
    public c.d.a.a.i.s f3646a;

    /* renamed from: b  reason: collision with root package name */
    public List<u> f3647b;

    /* renamed from: c  reason: collision with root package name */
    public String f3648c;

    /* renamed from: d  reason: collision with root package name */
    public static final List<u> f3644d = Collections.emptyList();

    /* renamed from: e  reason: collision with root package name */
    public static final c.d.a.a.i.s f3645e = new c.d.a.a.i.s();
    public static final Parcelable.Creator<w> CREATOR = new x();

    public w(c.d.a.a.i.s sVar, List<u> list, String str) {
        this.f3646a = sVar;
        this.f3647b = list;
        this.f3648c = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            return c.d.a.a.e.f.z.a(this.f3646a, wVar.f3646a) && c.d.a.a.e.f.z.a(this.f3647b, wVar.f3647b) && c.d.a.a.e.f.z.a(this.f3648c, wVar.f3648c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3646a.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.a(parcel, 1, (Parcelable) this.f3646a, i2, false);
        c.a(parcel, 2, (List) this.f3647b, false);
        c.a(parcel, 3, this.f3648c, false);
        c.c(parcel, a2);
    }
}
