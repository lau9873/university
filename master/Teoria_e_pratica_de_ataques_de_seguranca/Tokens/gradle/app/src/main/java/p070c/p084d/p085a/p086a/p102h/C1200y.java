package p070c.p084d.p085a.p086a.p102h;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import p070c.p084d.p085a.p086a.p103i.BinderC1231w;
import p070c.p084d.p085a.p086a.p103i.InterfaceC1230v;

/* renamed from: c.d.a.a.h.y */
/* loaded from: classes.dex */
public final class C1200y extends AbstractC1134a {
    public static final Parcelable.Creator<C1200y> CREATOR = new C1202z();

    /* renamed from: a */
    public int f5592a;

    /* renamed from: b */
    public C1196w f5593b;

    /* renamed from: c */
    public InterfaceC1230v f5594c;

    /* renamed from: d */
    public InterfaceC1141c0 f5595d;

    public C1200y(int i, C1196w c1196w, IBinder iBinder, IBinder iBinder2) {
        this.f5592a = i;
        this.f5593b = c1196w;
        InterfaceC1141c0 interfaceC1141c0 = null;
        this.f5594c = iBinder == null ? null : BinderC1231w.m4985a(iBinder);
        if (iBinder2 != null && iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            interfaceC1141c0 = queryLocalInterface instanceof InterfaceC1141c0 ? (InterfaceC1141c0) queryLocalInterface : new C1144d0(iBinder2);
        }
        this.f5595d = interfaceC1141c0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f5592a);
        C1140c.m5073a(parcel, 2, (Parcelable) this.f5593b, i, false);
        InterfaceC1230v interfaceC1230v = this.f5594c;
        C1140c.m5074a(parcel, 3, interfaceC1230v == null ? null : interfaceC1230v.asBinder(), false);
        InterfaceC1141c0 interfaceC1141c0 = this.f5595d;
        C1140c.m5074a(parcel, 4, interfaceC1141c0 != null ? interfaceC1141c0.asBinder() : null, false);
        C1140c.m5065c(parcel, m5080a);
    }
}
