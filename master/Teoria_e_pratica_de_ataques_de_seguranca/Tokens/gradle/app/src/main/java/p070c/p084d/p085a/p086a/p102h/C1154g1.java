package p070c.p084d.p085a.p086a.p102h;

import android.os.IBinder;
import android.os.Parcel;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1071n;

/* renamed from: c.d.a.a.h.g1 */
/* loaded from: classes.dex */
public final class C1154g1 extends C1172m1 implements InterfaceC1151f1 {
    public C1154g1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1151f1
    /* renamed from: a */
    public final void mo5047a(InterfaceC1071n interfaceC1071n, int i, boolean z) {
        Parcel m5032h = m5032h();
        C1178o1.m5024a(m5032h, interfaceC1071n);
        m5032h.writeInt(i);
        C1178o1.m5021a(m5032h, z);
        m5033b(9, m5032h);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1151f1
    /* renamed from: a */
    public final void mo5046a(C1160i1 c1160i1, InterfaceC1145d1 interfaceC1145d1) {
        Parcel m5032h = m5032h();
        C1178o1.m5022a(m5032h, c1160i1);
        C1178o1.m5024a(m5032h, interfaceC1145d1);
        m5033b(12, m5032h);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1151f1
    /* renamed from: c */
    public final void mo5045c(int i) {
        Parcel m5032h = m5032h();
        m5032h.writeInt(i);
        m5033b(7, m5032h);
    }
}
