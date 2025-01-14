package c.d.a.a.e.e.l;

import android.os.Bundle;
import c.d.a.a.e.e.a;
import java.util.Collections;
/* loaded from: classes.dex */
public final class y implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public final f0 f3443a;

    public y(f0 f0Var) {
        this.f3443a = f0Var;
    }

    @Override // c.d.a.a.e.e.l.e0
    public final <A extends a.c, T extends l2<? extends c.d.a.a.e.e.g, A>> T a(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void a(c.d.a.a.e.a aVar, c.d.a.a.e.e.a<?> aVar2, boolean z) {
    }

    @Override // c.d.a.a.e.e.l.e0
    public final boolean a() {
        return true;
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void b() {
        this.f3443a.e();
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void c() {
        for (a.f fVar : this.f3443a.f3290f.values()) {
            fVar.a();
        }
        this.f3443a.m.q = Collections.emptySet();
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void onConnected(Bundle bundle) {
    }

    @Override // c.d.a.a.e.e.l.e0
    public final void onConnectionSuspended(int i2) {
    }
}
