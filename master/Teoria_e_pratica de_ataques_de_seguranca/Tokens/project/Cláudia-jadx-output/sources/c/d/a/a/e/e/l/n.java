package c.d.a.a.e.e.l;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class n implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public final f0 f3354a;

    /* renamed from: b  reason: collision with root package name */
    public final Lock f3355b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f3356c;

    /* renamed from: d  reason: collision with root package name */
    public final c.d.a.a.e.m f3357d;

    /* renamed from: e  reason: collision with root package name */
    public c.d.a.a.e.a f3358e;

    /* renamed from: f  reason: collision with root package name */
    public int f3359f;

    /* renamed from: h  reason: collision with root package name */
    public int f3361h;
    public c.d.a.a.h.x0 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c.d.a.a.e.f.n o;
    public boolean p;
    public boolean q;
    public final c.d.a.a.e.f.u0 r;
    public final Map<c.d.a.a.e.e.a<?>, Boolean> s;
    public final a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> t;

    /* renamed from: g  reason: collision with root package name */
    public int f3360g = 0;

    /* renamed from: i  reason: collision with root package name */
    public final Bundle f3362i = new Bundle();
    public final Set<a.d> j = new HashSet();
    public ArrayList<Future<?>> u = new ArrayList<>();

    public n(f0 f0Var, c.d.a.a.e.f.u0 u0Var, Map<c.d.a.a.e.e.a<?>, Boolean> map, c.d.a.a.e.m mVar, a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar, Lock lock, Context context) {
        this.f3354a = f0Var;
        this.r = u0Var;
        this.s = map;
        this.f3357d = mVar;
        this.t = bVar;
        this.f3355b = lock;
        this.f3356c = context;
    }

    public static String b(int i2) {
        return i2 != 0 ? i2 != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    @Override // c.d.a.a.e.e.l.e0
    public final <A extends a.c, T extends l2<? extends c.d.a.a.e.e.g, A>> T a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void a(c.d.a.a.e.a aVar, c.d.a.a.e.e.a<?> aVar2, boolean z) {
        if (a(1)) {
            b(aVar, aVar2, z);
            if (d()) {
                f();
            }
        }
    }

    public final void a(c.d.a.a.h.k1 k1Var) {
        if (a(0)) {
            c.d.a.a.e.a b2 = k1Var.b();
            if (!b2.f()) {
                if (!a(b2)) {
                    b(b2);
                    return;
                }
                g();
                e();
                return;
            }
            c.d.a.a.e.f.f0 c2 = k1Var.c();
            c.d.a.a.e.a b3 = c2.b();
            if (b3.f()) {
                this.n = true;
                this.o = c2.c();
                this.p = c2.d();
                this.q = c2.e();
                e();
                return;
            }
            String valueOf = String.valueOf(b3);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
            sb.append("Sign-in succeeded with resolve account failure: ");
            sb.append(valueOf);
            Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
            b(b3);
        }
    }

    public final void a(boolean z) {
        c.d.a.a.h.x0 x0Var = this.k;
        if (x0Var != null) {
            if (x0Var.c() && z) {
                this.k.f();
            }
            this.k.a();
            this.o = null;
        }
    }

    @Override // c.d.a.a.e.e.l.e0
    public final boolean a() {
        h();
        a(true);
        this.f3354a.a((c.d.a.a.e.a) null);
        return true;
    }

    public final boolean a(int i2) {
        if (this.f3360g != i2) {
            Log.w("GoogleApiClientConnecting", this.f3354a.m.k());
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Unexpected callback in ");
            sb.append(valueOf);
            Log.w("GoogleApiClientConnecting", sb.toString());
            int i3 = this.f3361h;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("mRemainingConnections=");
            sb2.append(i3);
            Log.w("GoogleApiClientConnecting", sb2.toString());
            String b2 = b(this.f3360g);
            String b3 = b(i2);
            StringBuilder sb3 = new StringBuilder(String.valueOf(b2).length() + 70 + String.valueOf(b3).length());
            sb3.append("GoogleApiClient connecting is in step ");
            sb3.append(b2);
            sb3.append(" but received callback for step ");
            sb3.append(b3);
            Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
            b(new c.d.a.a.e.a(8, null));
            return false;
        }
        return true;
    }

    public final boolean a(c.d.a.a.e.a aVar) {
        return this.l && !aVar.e();
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void b() {
    }

    public final void b(c.d.a.a.e.a aVar) {
        h();
        a(!aVar.e());
        this.f3354a.a(aVar);
        this.f3354a.n.a(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        if ((r5.e() || r4.f3357d.c(r5.b()) != null) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(c.d.a.a.e.a r5, c.d.a.a.e.e.a<?> r6, boolean r7) {
        /*
            r4 = this;
            c.d.a.a.e.e.a$e r0 = r6.b()
            int r0 = r0.a()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L24
            boolean r7 = r5.e()
            if (r7 == 0) goto L14
        L12:
            r7 = 1
            goto L22
        L14:
            c.d.a.a.e.m r7 = r4.f3357d
            int r3 = r5.b()
            android.content.Intent r7 = r7.c(r3)
            if (r7 == 0) goto L21
            goto L12
        L21:
            r7 = 0
        L22:
            if (r7 == 0) goto L2d
        L24:
            c.d.a.a.e.a r7 = r4.f3358e
            if (r7 == 0) goto L2c
            int r7 = r4.f3359f
            if (r0 >= r7) goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == 0) goto L33
            r4.f3358e = r5
            r4.f3359f = r0
        L33:
            c.d.a.a.e.e.l.f0 r7 = r4.f3354a
            java.util.Map<c.d.a.a.e.e.a$d<?>, c.d.a.a.e.a> r7 = r7.f3291g
            c.d.a.a.e.e.a$d r6 = r6.d()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.a.e.e.l.n.b(c.d.a.a.e.a, c.d.a.a.e.e.a, boolean):void");
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void c() {
        this.f3354a.f3291g.clear();
        this.m = false;
        this.f3358e = null;
        this.f3360g = 0;
        this.l = true;
        this.n = false;
        this.p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (c.d.a.a.e.e.a<?> aVar : this.s.keySet()) {
            a.f fVar = this.f3354a.f3290f.get(aVar.d());
            z |= aVar.b().a() == 1;
            boolean booleanValue = this.s.get(aVar).booleanValue();
            if (fVar.e()) {
                this.m = true;
                if (booleanValue) {
                    this.j.add(aVar.d());
                } else {
                    this.l = false;
                }
            }
            hashMap.put(fVar, new p(this, aVar, booleanValue));
        }
        if (z) {
            this.m = false;
        }
        if (this.m) {
            this.r.a(Integer.valueOf(System.identityHashCode(this.f3354a.m)));
            w wVar = new w(this, null);
            a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar = this.t;
            Context context = this.f3356c;
            Looper c2 = this.f3354a.m.c();
            c.d.a.a.e.f.u0 u0Var = this.r;
            this.k = bVar.a(context, c2, u0Var, u0Var.h(), wVar, wVar);
        }
        this.f3361h = this.f3354a.f3290f.size();
        this.u.add(i0.a().submit(new q(this, hashMap)));
    }

    public final boolean d() {
        c.d.a.a.e.a aVar;
        this.f3361h--;
        int i2 = this.f3361h;
        if (i2 > 0) {
            return false;
        }
        if (i2 < 0) {
            Log.w("GoogleApiClientConnecting", this.f3354a.m.k());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            aVar = new c.d.a.a.e.a(8, null);
        } else {
            aVar = this.f3358e;
            if (aVar == null) {
                return true;
            }
            this.f3354a.l = this.f3359f;
        }
        b(aVar);
        return false;
    }

    public final void e() {
        if (this.f3361h != 0) {
            return;
        }
        if (!this.m || this.n) {
            ArrayList arrayList = new ArrayList();
            this.f3360g = 1;
            this.f3361h = this.f3354a.f3290f.size();
            for (a.d<?> dVar : this.f3354a.f3290f.keySet()) {
                if (!this.f3354a.f3291g.containsKey(dVar)) {
                    arrayList.add(this.f3354a.f3290f.get(dVar));
                } else if (d()) {
                    f();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.u.add(i0.a().submit(new t(this, arrayList)));
        }
    }

    public final void f() {
        this.f3354a.f();
        i0.a().execute(new o(this));
        c.d.a.a.h.x0 x0Var = this.k;
        if (x0Var != null) {
            if (this.p) {
                x0Var.a(this.o, this.q);
            }
            a(false);
        }
        for (a.d<?> dVar : this.f3354a.f3291g.keySet()) {
            this.f3354a.f3290f.get(dVar).a();
        }
        this.f3354a.n.a(this.f3362i.isEmpty() ? null : this.f3362i);
    }

    public final void g() {
        this.m = false;
        this.f3354a.m.q = Collections.emptySet();
        for (a.d<?> dVar : this.j) {
            if (!this.f3354a.f3291g.containsKey(dVar)) {
                this.f3354a.f3291g.put(dVar, new c.d.a.a.e.a(17, null));
            }
        }
    }

    public final void h() {
        ArrayList<Future<?>> arrayList = this.u;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Future<?> future = arrayList.get(i2);
            i2++;
            future.cancel(true);
        }
        this.u.clear();
    }

    public final Set<Scope> i() {
        c.d.a.a.e.f.u0 u0Var = this.r;
        if (u0Var == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(u0Var.c());
        Map<c.d.a.a.e.e.a<?>, c.d.a.a.e.f.w0> e2 = this.r.e();
        for (c.d.a.a.e.e.a<?> aVar : e2.keySet()) {
            if (!this.f3354a.f3291g.containsKey(aVar.d())) {
                hashSet.addAll(e2.get(aVar).f3552a);
            }
        }
        return hashSet;
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void onConnected(Bundle bundle) {
        if (a(1)) {
            if (bundle != null) {
                this.f3362i.putAll(bundle);
            }
            if (d()) {
                f();
            }
        }
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void onConnectionSuspended(int i2) {
        b(new c.d.a.a.e.a(8, null));
    }
}
