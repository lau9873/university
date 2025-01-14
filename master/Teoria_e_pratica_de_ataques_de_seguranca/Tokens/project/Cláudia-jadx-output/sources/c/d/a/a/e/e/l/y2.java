package c.d.a.a.e.e.l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.a.InterfaceC0057a;
/* loaded from: classes.dex */
public final class y2<O extends a.InterfaceC0057a> extends c.d.a.a.e.e.c<O> {

    /* renamed from: i  reason: collision with root package name */
    public final a.f f3449i;
    public final s2 j;
    public final c.d.a.a.e.f.u0 k;
    public final a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> l;

    public y2(Context context, c.d.a.a.e.e.a<O> aVar, Looper looper, a.f fVar, s2 s2Var, c.d.a.a.e.f.u0 u0Var, a.b<? extends c.d.a.a.h.x0, c.d.a.a.h.y0> bVar) {
        super(context, aVar, looper);
        this.f3449i = fVar;
        this.j = s2Var;
        this.k = u0Var;
        this.l = bVar;
        this.f3234h.a(this);
    }

    @Override // c.d.a.a.e.e.c
    public final a.f a(Looper looper, l0<O> l0Var) {
        this.j.a(l0Var);
        return this.f3449i;
    }

    @Override // c.d.a.a.e.e.c
    public final n1 a(Context context, Handler handler) {
        return new n1(context, handler, this.k, this.l);
    }

    public final a.f f() {
        return this.f3449i;
    }
}
