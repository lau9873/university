package c.d.a.a.e.e.l;

import android.os.Bundle;
import android.os.DeadObjectException;
import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class k implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public final f0 f3336a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3337b = false;

    public k(f0 f0Var) {
        this.f3336a = f0Var;
    }

    @Override // c.d.a.a.e.e.l.e0
    public final <A extends a.c, T extends l2<? extends c.d.a.a.e.e.g, A>> T a(T t) {
        try {
            this.f3336a.m.y.a(t);
            a0 a0Var = this.f3336a.m;
            a.f fVar = a0Var.p.get(t.h());
            c.d.a.a.e.f.c0.a(fVar, "Appropriate Api was not requested.");
            if (fVar.c() || !this.f3336a.f3291g.containsKey(t.h())) {
                t.b(fVar);
            } else {
                t.c(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f3336a.a(new l(this, this));
        }
        return t;
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void a(c.d.a.a.e.a aVar, c.d.a.a.e.e.a<?> aVar2, boolean z) {
    }

    @Override // c.d.a.a.e.e.l.e0
    public final boolean a() {
        if (this.f3337b) {
            return false;
        }
        if (!this.f3336a.m.j()) {
            this.f3336a.a((c.d.a.a.e.a) null);
            return true;
        }
        this.f3337b = true;
        for (v1 v1Var : this.f3336a.m.x) {
            v1Var.a();
        }
        return false;
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void b() {
        if (this.f3337b) {
            this.f3337b = false;
            this.f3336a.a(new m(this, this));
        }
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void c() {
    }

    public final void d() {
        if (this.f3337b) {
            this.f3337b = false;
            this.f3336a.m.y.a();
            a();
        }
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void onConnected(Bundle bundle) {
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void onConnectionSuspended(int i2) {
        this.f3336a.a((c.d.a.a.e.a) null);
        this.f3336a.n.a(i2, this.f3337b);
    }
}
