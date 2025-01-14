package c.d.a.a.h;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class k1 extends a {
    public static final Parcelable.Creator<k1> CREATOR = new l1();

    /* renamed from: a  reason: collision with root package name */
    public int f3616a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.a.a.e.a f3617b;

    /* renamed from: c  reason: collision with root package name */
    public final c.d.a.a.e.f.f0 f3618c;

    public k1(int i2) {
        this(new c.d.a.a.e.a(8, null), null);
    }

    public k1(int i2, c.d.a.a.e.a aVar, c.d.a.a.e.f.f0 f0Var) {
        this.f3616a = i2;
        this.f3617b = aVar;
        this.f3618c = f0Var;
    }

    public k1(c.d.a.a.e.a aVar, c.d.a.a.e.f.f0 f0Var) {
        this(1, aVar, null);
    }

    public final c.d.a.a.e.a b() {
        return this.f3617b;
    }

    public final c.d.a.a.e.f.f0 c() {
        return this.f3618c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f3616a);
        c.a(parcel, 2, (Parcelable) this.f3617b, i2, false);
        c.a(parcel, 3, (Parcelable) this.f3618c, i2, false);
        c.c(parcel, a2);
    }
}
