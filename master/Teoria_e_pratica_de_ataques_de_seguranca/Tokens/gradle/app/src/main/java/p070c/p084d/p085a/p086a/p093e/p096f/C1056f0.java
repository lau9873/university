package p070c.p084d.p085a.p086a.p093e.p096f;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* renamed from: c.d.a.a.e.f.f0 */
/* loaded from: classes.dex */
public final class C1056f0 extends AbstractC1134a {
    public static final Parcelable.Creator<C1056f0> CREATOR = new C1058g0();

    /* renamed from: a */
    public int f5405a;

    /* renamed from: b */
    public IBinder f5406b;

    /* renamed from: c */
    public C0900a f5407c;

    /* renamed from: d */
    public boolean f5408d;

    /* renamed from: e */
    public boolean f5409e;

    public C1056f0(int i, IBinder iBinder, C0900a c0900a, boolean z, boolean z2) {
        this.f5405a = i;
        this.f5406b = iBinder;
        this.f5407c = c0900a;
        this.f5408d = z;
        this.f5409e = z2;
    }

    /* renamed from: b */
    public final C0900a m5276b() {
        return this.f5407c;
    }

    /* renamed from: c */
    public final InterfaceC1071n m5275c() {
        IBinder iBinder = this.f5406b;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return queryLocalInterface instanceof InterfaceC1071n ? (InterfaceC1071n) queryLocalInterface : new C1075p(iBinder);
    }

    /* renamed from: d */
    public final boolean m5274d() {
        return this.f5408d;
    }

    /* renamed from: e */
    public final boolean m5273e() {
        return this.f5409e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1056f0) {
            C1056f0 c1056f0 = (C1056f0) obj;
            return this.f5407c.equals(c1056f0.f5407c) && m5275c().equals(c1056f0.m5275c());
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5405a);
        C1140c.m5074a(parcel, 2, this.f5406b, false);
        C1140c.m5073a(parcel, 3, (Parcelable) this.f5407c, i, false);
        C1140c.m5070a(parcel, 4, this.f5408d);
        C1140c.m5070a(parcel, 5, this.f5409e);
        C1140c.m5065c(parcel, m5080a);
    }
}
