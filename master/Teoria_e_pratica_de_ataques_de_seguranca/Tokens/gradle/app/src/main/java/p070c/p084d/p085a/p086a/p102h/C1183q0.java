package p070c.p084d.p085a.p086a.p102h;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p103i.AbstractBinderC1210c0;
import p070c.p084d.p085a.p086a.p103i.AbstractBinderC1234z;
import p070c.p084d.p085a.p086a.p103i.InterfaceC1208b0;
import p070c.p084d.p085a.p086a.p103i.InterfaceC1233y;

/* renamed from: c.d.a.a.h.q0 */
/* loaded from: classes.dex */
public final class C1183q0 extends AbstractC1134a {
    public static final Parcelable.Creator<C1183q0> CREATOR = new C1186r0();

    /* renamed from: a */
    public int f5571a;

    /* renamed from: b */
    public C1177o0 f5572b;

    /* renamed from: c */
    public InterfaceC1208b0 f5573c;

    /* renamed from: d */
    public PendingIntent f5574d;

    /* renamed from: e */
    public InterfaceC1233y f5575e;

    /* renamed from: f */
    public InterfaceC1141c0 f5576f;

    public C1183q0(int i, C1177o0 c1177o0, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        this.f5571a = i;
        this.f5572b = c1177o0;
        InterfaceC1141c0 interfaceC1141c0 = null;
        this.f5573c = iBinder == null ? null : AbstractBinderC1210c0.m4990a(iBinder);
        this.f5574d = pendingIntent;
        this.f5575e = iBinder2 == null ? null : AbstractBinderC1234z.m4982a(iBinder2);
        if (iBinder3 != null && iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            interfaceC1141c0 = queryLocalInterface instanceof InterfaceC1141c0 ? (InterfaceC1141c0) queryLocalInterface : new C1144d0(iBinder3);
        }
        this.f5576f = interfaceC1141c0;
    }

    /* renamed from: a */
    public static C1183q0 m5019a(InterfaceC1208b0 interfaceC1208b0, InterfaceC1141c0 interfaceC1141c0) {
        return new C1183q0(2, null, interfaceC1208b0.asBinder(), null, null, interfaceC1141c0 != null ? interfaceC1141c0.asBinder() : null);
    }

    /* renamed from: a */
    public static C1183q0 m5018a(InterfaceC1233y interfaceC1233y, InterfaceC1141c0 interfaceC1141c0) {
        return new C1183q0(2, null, null, null, interfaceC1233y.asBinder(), interfaceC1141c0 != null ? interfaceC1141c0.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5571a);
        C1140c.m5073a(parcel, 2, (Parcelable) this.f5572b, i, false);
        InterfaceC1208b0 interfaceC1208b0 = this.f5573c;
        C1140c.m5074a(parcel, 3, interfaceC1208b0 == null ? null : interfaceC1208b0.asBinder(), false);
        C1140c.m5073a(parcel, 4, (Parcelable) this.f5574d, i, false);
        InterfaceC1233y interfaceC1233y = this.f5575e;
        C1140c.m5074a(parcel, 5, interfaceC1233y == null ? null : interfaceC1233y.asBinder(), false);
        InterfaceC1141c0 interfaceC1141c0 = this.f5576f;
        C1140c.m5074a(parcel, 6, interfaceC1141c0 != null ? interfaceC1141c0.asBinder() : null, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
