package c.d.a.a.e.f;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
/* loaded from: classes.dex */
public final class o0 extends u {

    /* renamed from: a  reason: collision with root package name */
    public h0 f3530a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3531b;

    public o0(h0 h0Var, int i2) {
        this.f3530a = h0Var;
        this.f3531b = i2;
    }

    @Override // c.d.a.a.e.f.t
    public final void a(int i2, IBinder iBinder, Bundle bundle) {
        c0.a(this.f3530a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f3530a.a(i2, iBinder, bundle, this.f3531b);
        this.f3530a = null;
    }

    @Override // c.d.a.a.e.f.t
    public final void b(int i2, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
