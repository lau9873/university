package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class i1 extends a {
    public static final Parcelable.Creator<i1> CREATOR = new j1();

    /* renamed from: a  reason: collision with root package name */
    public int f3612a;

    /* renamed from: b  reason: collision with root package name */
    public c.d.a.a.e.f.d0 f3613b;

    public i1(int i2, c.d.a.a.e.f.d0 d0Var) {
        this.f3612a = i2;
        this.f3613b = d0Var;
    }

    public i1(c.d.a.a.e.f.d0 d0Var) {
        this(1, d0Var);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f3612a);
        c.a(parcel, 2, (Parcelable) this.f3613b, i2, false);
        c.c(parcel, a2);
    }
}
