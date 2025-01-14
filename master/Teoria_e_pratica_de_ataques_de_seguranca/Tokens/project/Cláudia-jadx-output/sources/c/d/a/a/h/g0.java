package c.d.a.a.h;

import android.content.Context;
import android.location.Location;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final s0<e0> f3602a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f3603b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3604c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Map<c.d.a.a.e.e.l.f1<Object>, l0> f3605d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<c.d.a.a.e.e.l.f1<Object>, k0> f3606e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final Map<c.d.a.a.e.e.l.f1<Object>, h0> f3607f = new HashMap();

    public g0(Context context, s0<e0> s0Var) {
        this.f3603b = context;
        this.f3602a = s0Var;
    }

    public final Location a() {
        this.f3602a.a();
        return this.f3602a.b().b(this.f3603b.getPackageName());
    }

    public final void a(boolean z) {
        this.f3602a.a();
        this.f3602a.b().c(z);
        this.f3604c = z;
    }

    public final void b() {
        synchronized (this.f3605d) {
            for (l0 l0Var : this.f3605d.values()) {
                if (l0Var != null) {
                    this.f3602a.b().a(q0.a(l0Var, (c0) null));
                }
            }
            this.f3605d.clear();
        }
        synchronized (this.f3607f) {
            for (h0 h0Var : this.f3607f.values()) {
                if (h0Var != null) {
                    this.f3602a.b().a(q0.a(h0Var, (c0) null));
                }
            }
            this.f3607f.clear();
        }
        synchronized (this.f3606e) {
            for (k0 k0Var : this.f3606e.values()) {
                if (k0Var != null) {
                    this.f3602a.b().a(new y(2, null, k0Var.asBinder(), null));
                }
            }
            this.f3606e.clear();
        }
    }

    public final void c() {
        if (this.f3604c) {
            a(false);
        }
    }
}
