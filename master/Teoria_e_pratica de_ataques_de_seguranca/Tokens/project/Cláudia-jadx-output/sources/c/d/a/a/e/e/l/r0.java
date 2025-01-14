package c.d.a.a.e.e.l;

import android.os.Handler;
import android.util.Log;
import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Scope;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class r0 implements q1, c.d.a.a.e.f.n0 {

    /* renamed from: a  reason: collision with root package name */
    public final a.f f3397a;

    /* renamed from: b  reason: collision with root package name */
    public final g2<?> f3398b;

    /* renamed from: c  reason: collision with root package name */
    public c.d.a.a.e.f.n f3399c = null;

    /* renamed from: d  reason: collision with root package name */
    public Set<Scope> f3400d = null;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3401e = false;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ j0 f3402f;

    public r0(j0 j0Var, a.f fVar, g2<?> g2Var) {
        this.f3402f = j0Var;
        this.f3397a = fVar;
        this.f3398b = g2Var;
    }

    public final void a() {
        c.d.a.a.e.f.n nVar;
        if (!this.f3401e || (nVar = this.f3399c) == null) {
            return;
        }
        this.f3397a.a(nVar, this.f3400d);
    }

    @Override // c.d.a.a.e.f.n0
    public final void a(c.d.a.a.e.a aVar) {
        Handler handler;
        handler = this.f3402f.m;
        handler.post(new s0(this, aVar));
    }

    @Override // c.d.a.a.e.e.l.q1
    public final void a(c.d.a.a.e.f.n nVar, Set<Scope> set) {
        if (nVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new c.d.a.a.e.a(4));
            return;
        }
        this.f3399c = nVar;
        this.f3400d = set;
        a();
    }

    @Override // c.d.a.a.e.e.l.q1
    public final void b(c.d.a.a.e.a aVar) {
        Map map;
        map = this.f3402f.f3330i;
        ((l0) map.get(this.f3398b)).a(aVar);
    }
}
