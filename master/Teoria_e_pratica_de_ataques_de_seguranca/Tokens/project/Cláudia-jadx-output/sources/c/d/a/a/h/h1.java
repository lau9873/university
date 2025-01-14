package c.d.a.a.h;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import c.d.a.a.e.e.d;
/* loaded from: classes.dex */
public final class h1 extends c.d.a.a.e.f.c<f1> implements x0 {
    public final boolean A;
    public final c.d.a.a.e.f.u0 B;
    public final Bundle C;
    public Integer D;

    public h1(Context context, Looper looper, boolean z, c.d.a.a.e.f.u0 u0Var, Bundle bundle, d.b bVar, d.c cVar) {
        super(context, looper, 44, u0Var, bVar, cVar);
        this.A = true;
        this.B = u0Var;
        this.C = bundle;
        this.D = u0Var.i();
    }

    public h1(Context context, Looper looper, boolean z, c.d.a.a.e.f.u0 u0Var, y0 y0Var, d.b bVar, d.c cVar) {
        this(context, looper, true, u0Var, a(u0Var), bVar, cVar);
    }

    public static Bundle a(c.d.a.a.e.f.u0 u0Var) {
        y0 h2 = u0Var.h();
        Integer i2 = u0Var.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", u0Var.a());
        if (i2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", i2.intValue());
        }
        if (h2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", h2.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", h2.b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", h2.a());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", h2.d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", h2.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", h2.f());
            if (h2.g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", h2.g().longValue());
            }
            if (h2.h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", h2.h().longValue());
            }
        }
        return bundle;
    }

    @Override // c.d.a.a.e.f.h0
    public final String A() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // c.d.a.a.e.f.h0
    public final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof f1 ? (f1) queryLocalInterface : new g1(iBinder);
    }

    @Override // c.d.a.a.h.x0
    public final void a(c.d.a.a.e.f.n nVar, boolean z) {
        try {
            ((f1) v()).a(nVar, this.D.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // c.d.a.a.h.x0
    public final void a(d1 d1Var) {
        c.d.a.a.e.f.c0.a(d1Var, "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.B.b();
            ((f1) v()).a(new i1(new c.d.a.a.e.f.d0(b2, this.D.intValue(), "<<default account>>".equals(b2.name) ? c.d.a.a.d.a.a.a.a.a(o()).a() : null)), d1Var);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                d1Var.a(new k1(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // c.d.a.a.h.x0
    public final void b() {
        a(new c.d.a.a.e.f.q0(this));
    }

    @Override // c.d.a.a.e.f.h0, c.d.a.a.e.e.a.f
    public final boolean e() {
        return this.A;
    }

    @Override // c.d.a.a.h.x0
    public final void f() {
        try {
            ((f1) v()).c(this.D.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // c.d.a.a.e.f.h0
    public final Bundle p() {
        if (!o().getPackageName().equals(this.B.f())) {
            this.C.putString("com.google.android.gms.signin.internal.realClientPackageName", this.B.f());
        }
        return this.C;
    }

    @Override // c.d.a.a.e.f.h0
    public final String z() {
        return "com.google.android.gms.signin.service.START";
    }
}
