package c.d.a.a.e.e.l;

import c.d.a.a.e.e.a;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes.dex */
public final class s0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ c.d.a.a.e.a f3404a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ r0 f3405b;

    public s0(r0 r0Var, c.d.a.a.e.a aVar) {
        this.f3405b = r0Var;
        this.f3404a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        g2 g2Var;
        a.f fVar;
        a.f fVar2;
        if (!this.f3404a.f()) {
            map = this.f3405b.f3402f.f3330i;
            g2Var = this.f3405b.f3398b;
            ((l0) map.get(g2Var)).onConnectionFailed(this.f3404a);
            return;
        }
        this.f3405b.f3401e = true;
        fVar = this.f3405b.f3397a;
        if (fVar.e()) {
            this.f3405b.a();
            return;
        }
        fVar2 = this.f3405b.f3397a;
        fVar2.a(null, Collections.emptySet());
    }
}
