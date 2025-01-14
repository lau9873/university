package c.d.a.a.e.f;

import android.os.Bundle;
import android.os.IBinder;
/* loaded from: classes.dex */
public final class r0 extends i0 {

    /* renamed from: g  reason: collision with root package name */
    public IBinder f3535g;

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ h0 f3536h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(h0 h0Var, int i2, IBinder iBinder, Bundle bundle) {
        super(h0Var, i2, bundle);
        this.f3536h = h0Var;
        this.f3535g = iBinder;
    }

    @Override // c.d.a.a.e.f.i0
    public final void a(c.d.a.a.e.a aVar) {
        k0 k0Var;
        k0 k0Var2;
        k0Var = this.f3536h.s;
        if (k0Var != null) {
            k0Var2 = this.f3536h.s;
            k0Var2.onConnectionFailed(aVar);
        }
        this.f3536h.a(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0066, code lost:
        if (r0 != false) goto L15;
     */
    @Override // c.d.a.a.e.f.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() {
        /*
            r6 = this;
            java.lang.String r0 = "GmsClient"
            r1 = 0
            android.os.IBinder r2 = r6.f3535g     // Catch: android.os.RemoteException -> L88
            java.lang.String r2 = r2.getInterfaceDescriptor()     // Catch: android.os.RemoteException -> L88
            c.d.a.a.e.f.h0 r3 = r6.f3536h
            java.lang.String r3 = r3.A()
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L4b
            c.d.a.a.e.f.h0 r3 = r6.f3536h
            java.lang.String r3 = r3.A()
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
            c.d.a.a.e.f.h0 r0 = r6.f3536h
            android.os.IBinder r2 = r6.f3535g
            android.os.IInterface r0 = r0.a(r2)
            if (r0 == 0) goto L87
            c.d.a.a.e.f.h0 r2 = r6.f3536h
            r3 = 2
            r4 = 4
            boolean r2 = c.d.a.a.e.f.h0.a(r2, r3, r4, r0)
            if (r2 != 0) goto L68
            c.d.a.a.e.f.h0 r2 = r6.f3536h
            r3 = 3
            boolean r0 = c.d.a.a.e.f.h0.a(r2, r3, r4, r0)
            if (r0 == 0) goto L87
        L68:
            c.d.a.a.e.f.h0 r0 = r6.f3536h
            r1 = 0
            c.d.a.a.e.f.h0.a(r0, r1)
            c.d.a.a.e.f.h0 r0 = r6.f3536h
            android.os.Bundle r0 = r0.m()
            c.d.a.a.e.f.h0 r1 = r6.f3536h
            c.d.a.a.e.f.j0 r1 = c.d.a.a.e.f.h0.e(r1)
            if (r1 == 0) goto L85
            c.d.a.a.e.f.h0 r1 = r6.f3536h
            c.d.a.a.e.f.j0 r1 = c.d.a.a.e.f.h0.e(r1)
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
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.a.e.f.r0.e():boolean");
    }
}
