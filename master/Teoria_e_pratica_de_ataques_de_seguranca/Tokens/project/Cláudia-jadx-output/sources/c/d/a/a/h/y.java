package c.d.a.a.h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class y extends a {
    public static final Parcelable.Creator<y> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    public int f3649a;

    /* renamed from: b  reason: collision with root package name */
    public w f3650b;

    /* renamed from: c  reason: collision with root package name */
    public c.d.a.a.i.v f3651c;

    /* renamed from: d  reason: collision with root package name */
    public c0 f3652d;

    public y(int i2, w wVar, IBinder iBinder, IBinder iBinder2) {
        this.f3649a = i2;
        this.f3650b = wVar;
        c0 c0Var = null;
        this.f3651c = iBinder == null ? null : c.d.a.a.i.w.a(iBinder);
        if (iBinder2 != null && iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            c0Var = queryLocalInterface instanceof c0 ? (c0) queryLocalInterface : new d0(iBinder2);
        }
        this.f3652d = c0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f3649a);
        c.a(parcel, 2, (Parcelable) this.f3650b, i2, false);
        c.d.a.a.i.v vVar = this.f3651c;
        c.a(parcel, 3, vVar == null ? null : vVar.asBinder(), false);
        c0 c0Var = this.f3652d;
        c.a(parcel, 4, c0Var != null ? c0Var.asBinder() : null, false);
        c.c(parcel, a2);
    }
}
