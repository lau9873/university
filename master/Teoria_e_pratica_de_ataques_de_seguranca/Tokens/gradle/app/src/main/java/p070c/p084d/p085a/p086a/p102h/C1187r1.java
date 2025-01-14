package p070c.p084d.p085a.p086a.p102h;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: c.d.a.a.h.r1 */
/* loaded from: classes.dex */
public final class C1187r1 extends C1172m1 implements InterfaceC1181p1 {
    public C1187r1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1181p1
    /* renamed from: a */
    public final String mo5016a() {
        Parcel m5034a = m5034a(1, m5032h());
        String readString = m5034a.readString();
        m5034a.recycle();
        return readString;
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1181p1
    /* renamed from: d */
    public final boolean mo5015d(boolean z) {
        Parcel m5032h = m5032h();
        C1178o1.m5021a(m5032h, true);
        Parcel m5034a = m5034a(2, m5032h);
        boolean m5025a = C1178o1.m5025a(m5034a);
        m5034a.recycle();
        return m5025a;
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1181p1
    /* renamed from: f */
    public final boolean mo5014f() {
        Parcel m5034a = m5034a(6, m5032h());
        boolean m5025a = C1178o1.m5025a(m5034a);
        m5034a.recycle();
        return m5025a;
    }
}
