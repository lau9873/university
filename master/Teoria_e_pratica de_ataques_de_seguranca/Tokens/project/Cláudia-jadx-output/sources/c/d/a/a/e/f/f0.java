package c.d.a.a.e.f;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class f0 extends c.d.a.a.h.a {
    public static final Parcelable.Creator<f0> CREATOR = new g0();

    /* renamed from: a  reason: collision with root package name */
    public int f3487a;

    /* renamed from: b  reason: collision with root package name */
    public IBinder f3488b;

    /* renamed from: c  reason: collision with root package name */
    public c.d.a.a.e.a f3489c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3490d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3491e;

    public f0(int i2, IBinder iBinder, c.d.a.a.e.a aVar, boolean z, boolean z2) {
        this.f3487a = i2;
        this.f3488b = iBinder;
        this.f3489c = aVar;
        this.f3490d = z;
        this.f3491e = z2;
    }

    public final c.d.a.a.e.a b() {
        return this.f3489c;
    }

    public final n c() {
        IBinder iBinder = this.f3488b;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return queryLocalInterface instanceof n ? (n) queryLocalInterface : new p(iBinder);
    }

    public final boolean d() {
        return this.f3490d;
    }

    public final boolean e() {
        return this.f3491e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            return this.f3489c.equals(f0Var.f3489c) && c().equals(f0Var.c());
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.b(parcel, 1, this.f3487a);
        c.d.a.a.h.c.a(parcel, 2, this.f3488b, false);
        c.d.a.a.h.c.a(parcel, 3, (Parcelable) this.f3489c, i2, false);
        c.d.a.a.h.c.a(parcel, 4, this.f3490d);
        c.d.a.a.h.c.a(parcel, 5, this.f3491e);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
