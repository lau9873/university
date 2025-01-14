package c.d.a.a.h;

import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class g1 extends m1 implements f1 {
    public g1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // c.d.a.a.h.f1
    public final void a(c.d.a.a.e.f.n nVar, int i2, boolean z) {
        Parcel h2 = h();
        o1.a(h2, nVar);
        h2.writeInt(i2);
        o1.a(h2, z);
        b(9, h2);
    }

    @Override // c.d.a.a.h.f1
    public final void a(i1 i1Var, d1 d1Var) {
        Parcel h2 = h();
        o1.a(h2, i1Var);
        o1.a(h2, d1Var);
        b(12, h2);
    }

    @Override // c.d.a.a.h.f1
    public final void c(int i2) {
        Parcel h2 = h();
        h2.writeInt(i2);
        b(7, h2);
    }
}
