package c.d.a.a.e.e.l;

import android.os.Looper;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.a.InterfaceC0057a;
/* loaded from: classes.dex */
public final class t0<O extends a.InterfaceC0057a> extends j {

    /* renamed from: c  reason: collision with root package name */
    public final c.d.a.a.e.e.c<O> f3411c;

    public t0(c.d.a.a.e.e.c<O> cVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f3411c = cVar;
    }

    @Override // c.d.a.a.e.e.d
    public final <A extends a.c, T extends l2<? extends c.d.a.a.e.e.g, A>> T a(T t) {
        this.f3411c.a((c.d.a.a.e.e.c<O>) t);
        return t;
    }

    @Override // c.d.a.a.e.e.d
    public final void a(v1 v1Var) {
    }

    @Override // c.d.a.a.e.e.d
    public final Looper c() {
        return this.f3411c.b();
    }
}
