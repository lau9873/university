package c.d.a.a.h;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class q0 extends a {
    public static final Parcelable.Creator<q0> CREATOR = new r0();

    /* renamed from: a  reason: collision with root package name */
    public int f3630a;

    /* renamed from: b  reason: collision with root package name */
    public o0 f3631b;

    /* renamed from: c  reason: collision with root package name */
    public c.d.a.a.i.b0 f3632c;

    /* renamed from: d  reason: collision with root package name */
    public PendingIntent f3633d;

    /* renamed from: e  reason: collision with root package name */
    public c.d.a.a.i.y f3634e;

    /* renamed from: f  reason: collision with root package name */
    public c0 f3635f;

    public q0(int i2, o0 o0Var, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.f3630a = i2;
        this.f3631b = o0Var;
        c0 c0Var = null;
        this.f3632c = iBinder == null ? null : c.d.a.a.i.c0.a(iBinder);
        this.f3633d = pendingIntent;
        this.f3634e = iBinder2 == null ? null : c.d.a.a.i.z.a(iBinder2);
        if (iBinder3 != null && iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            c0Var = queryLocalInterface instanceof c0 ? (c0) queryLocalInterface : new d0(iBinder3);
        }
        this.f3635f = c0Var;
    }

    public static q0 a(c.d.a.a.i.b0 b0Var, c0 c0Var) {
        return new q0(2, null, b0Var.asBinder(), null, null, c0Var != null ? c0Var.asBinder() : null);
    }

    public static q0 a(c.d.a.a.i.y yVar, c0 c0Var) {
        return new q0(2, null, null, null, yVar.asBinder(), c0Var != null ? c0Var.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.a(parcel);
        c.b(parcel, 1, this.f3630a);
        c.a(parcel, 2, (Parcelable) this.f3631b, i2, false);
        c.d.a.a.i.b0 b0Var = this.f3632c;
        c.a(parcel, 3, b0Var == null ? null : b0Var.asBinder(), false);
        c.a(parcel, 4, (Parcelable) this.f3633d, i2, false);
        c.d.a.a.i.y yVar = this.f3634e;
        c.a(parcel, 5, yVar == null ? null : yVar.asBinder(), false);
        c0 c0Var = this.f3635f;
        c.a(parcel, 6, c0Var != null ? c0Var.asBinder() : null, false);
        c.c(parcel, a2);
    }
}
