package c.d.a.a.e.e.l;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.d;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
/* loaded from: classes.dex */
public final class n1 extends c.d.a.a.h.c1 implements d.b, d.c {

    /* renamed from: h  reason: collision with root package name */
    public static a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> f3364h = c.d.a.a.h.u0.f3641c;

    /* renamed from: a  reason: collision with root package name */
    public final Context f3365a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f3366b;

    /* renamed from: c  reason: collision with root package name */
    public final a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> f3367c;

    /* renamed from: d  reason: collision with root package name */
    public Set<Scope> f3368d;

    /* renamed from: e  reason: collision with root package name */
    public c.d.a.a.e.f.u0 f3369e;

    /* renamed from: f  reason: collision with root package name */
    public c.d.a.a.h.x0 f3370f;

    /* renamed from: g  reason: collision with root package name */
    public q1 f3371g;

    public n1(Context context, Handler handler, c.d.a.a.e.f.u0 u0Var) {
        this(context, handler, u0Var, f3364h);
    }

    public n1(Context context, Handler handler, c.d.a.a.e.f.u0 u0Var, a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar) {
        this.f3365a = context;
        this.f3366b = handler;
        c.d.a.a.e.f.c0.a(u0Var, "ClientSettings must not be null");
        this.f3369e = u0Var;
        this.f3368d = u0Var.c();
        this.f3367c = bVar;
    }

    public final void a(q1 q1Var) {
        c.d.a.a.h.x0 x0Var = this.f3370f;
        if (x0Var != null) {
            x0Var.a();
        }
        this.f3369e.a(Integer.valueOf(System.identityHashCode(this)));
        a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar = this.f3367c;
        Context context = this.f3365a;
        Looper looper = this.f3366b.getLooper();
        c.d.a.a.e.f.u0 u0Var = this.f3369e;
        this.f3370f = bVar.a(context, looper, u0Var, u0Var.h(), this, this);
        this.f3371g = q1Var;
        Set<Scope> set = this.f3368d;
        if (set == null || set.isEmpty()) {
            this.f3366b.post(new o1(this));
        } else {
            this.f3370f.b();
        }
    }

    @Override // c.d.a.a.h.d1
    public final void a(c.d.a.a.h.k1 k1Var) {
        this.f3366b.post(new p1(this, k1Var));
    }

    public final void b(c.d.a.a.h.k1 k1Var) {
        c.d.a.a.e.a b2 = k1Var.b();
        if (b2.f()) {
            c.d.a.a.e.f.f0 c2 = k1Var.c();
            b2 = c2.b();
            if (b2.f()) {
                this.f3371g.a(c2.c(), this.f3368d);
                this.f3370f.a();
            }
            String valueOf = String.valueOf(b2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("Sign-in succeeded with resolve account failure: ");
            sb.append(valueOf);
            Log.wtf("SignInCoordinator", sb.toString(), new Exception());
        }
        this.f3371g.b(b2);
        this.f3370f.a();
    }

    public final c.d.a.a.h.x0 h() {
        return this.f3370f;
    }

    public final void i() {
        c.d.a.a.h.x0 x0Var = this.f3370f;
        if (x0Var != null) {
            x0Var.a();
        }
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnected(Bundle bundle) {
        this.f3370f.a(this);
    }

    @Override // c.d.a.a.e.e.d.c
    public final void onConnectionFailed(c.d.a.a.e.a aVar) {
        this.f3371g.b(aVar);
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnectionSuspended(int i2) {
        this.f3370f.a();
    }
}
