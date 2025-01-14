package p070c.p084d.p085a.p086a.p093e.p096f;

import android.os.Bundle;
import android.os.IBinder;
import p070c.p084d.p085a.p086a.p093e.C0900a;

/* renamed from: c.d.a.a.e.f.r0 */
/* loaded from: classes.dex */
public final class C1080r0 extends AbstractC1062i0 {

    /* renamed from: g */
    public IBinder f5468g;

    /* renamed from: h */
    public /* synthetic */ AbstractC1060h0 f5469h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1080r0(AbstractC1060h0 abstractC1060h0, int i, IBinder iBinder, Bundle bundle) {
        super(abstractC1060h0, i, bundle);
        this.f5469h = abstractC1060h0;
        this.f5468g = iBinder;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1062i0
    /* renamed from: a */
    public final void mo5187a(C0900a c0900a) {
        InterfaceC1066k0 interfaceC1066k0;
        InterfaceC1066k0 interfaceC1066k02;
        interfaceC1066k0 = this.f5469h.f5430s;
        if (interfaceC1066k0 != null) {
            interfaceC1066k02 = this.f5469h.f5430s;
            interfaceC1066k02.onConnectionFailed(c0900a);
        }
        this.f5469h.m5262a(c0900a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0066, code lost:
        if (r0 != false) goto L15;
     */
    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1062i0
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo5186e() {
        /*
            r6 = this;
            java.lang.String r0 = "GmsClient"
            r1 = 0
            android.os.IBinder r2 = r6.f5468g     // Catch: android.os.RemoteException -> L88
            java.lang.String r2 = r2.getInterfaceDescriptor()     // Catch: android.os.RemoteException -> L88
            c.d.a.a.e.f.h0 r3 = r6.f5469h
            java.lang.String r3 = r3.mo5013A()
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L4b
            c.d.a.a.e.f.h0 r3 = r6.f5469h
            java.lang.String r3 = r3.mo5013A()
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 34
            java.lang.String r5 = java.lang.String.valueOf(r2)
            int r5 = r5.length()
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "service descriptor mismatch: "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = " vs. "
            r5.append(r3)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.e(r0, r2)
            return r1
        L4b:
            c.d.a.a.e.f.h0 r0 = r6.f5469h
            android.os.IBinder r2 = r6.f5468g
            android.os.IInterface r0 = r0.mo5012a(r2)
            if (r0 == 0) goto L87
            c.d.a.a.e.f.h0 r2 = r6.f5469h
            r3 = 2
            r4 = 4
            boolean r2 = p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0.m5259a(r2, r3, r4, r0)
            if (r2 != 0) goto L68
            c.d.a.a.e.f.h0 r2 = r6.f5469h
            r3 = 3
            boolean r0 = p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0.m5259a(r2, r3, r4, r0)
            if (r0 == 0) goto L87
        L68:
            c.d.a.a.e.f.h0 r0 = r6.f5469h
            r1 = 0
            p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0.m5257a(r0, r1)
            c.d.a.a.e.f.h0 r0 = r6.f5469h
            android.os.Bundle r0 = r0.m5235m()
            c.d.a.a.e.f.h0 r1 = r6.f5469h
            c.d.a.a.e.f.j0 r1 = p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0.m5244e(r1)
            if (r1 == 0) goto L85
            c.d.a.a.e.f.h0 r1 = r6.f5469h
            c.d.a.a.e.f.j0 r1 = p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0.m5244e(r1)
            r1.onConnected(r0)
        L85:
            r0 = 1
            return r0
        L87:
            return r1
        L88:
            java.lang.String r2 = "service probably died"
            android.util.Log.w(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p085a.p086a.p093e.p096f.C1080r0.mo5186e():boolean");
    }
}
