package c.d.a.a.e.e.l;

import android.os.Bundle;
import c.d.a.a.e.e.d;
/* loaded from: classes.dex */
public final class s2 implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    public final c.d.a.a.e.e.a<?> f3406a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f3407b;

    /* renamed from: c  reason: collision with root package name */
    public t2 f3408c;

    public s2(c.d.a.a.e.e.a<?> aVar, boolean z) {
        this.f3406a = aVar;
        this.f3407b = z;
    }

    public final void a() {
        c.d.a.a.e.f.c0.a(this.f3408c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public final void a(t2 t2Var) {
        this.f3408c = t2Var;
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnected(Bundle bundle) {
        a();
        this.f3408c.onConnected(bundle);
    }

    @Override // c.d.a.a.e.e.d.c
    public final void onConnectionFailed(c.d.a.a.e.a aVar) {
        a();
        this.f3408c.a(aVar, this.f3406a, this.f3407b);
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnectionSuspended(int i2) {
        a();
        this.f3408c.onConnectionSuspended(i2);
    }
}
