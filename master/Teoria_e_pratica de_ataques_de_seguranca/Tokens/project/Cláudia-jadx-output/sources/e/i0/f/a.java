package e.i0.f;

import e.b0;
import e.d0;
import e.i0.g.g;
import e.v;
import e.y;
/* compiled from: ConnectInterceptor.java */
/* loaded from: classes.dex */
public final class a implements v {

    /* renamed from: a  reason: collision with root package name */
    public final y f5589a;

    public a(y yVar) {
        this.f5589a = yVar;
    }

    @Override // e.v
    public d0 intercept(v.a aVar) {
        g gVar = (g) aVar;
        b0 a2 = gVar.a();
        f d2 = gVar.d();
        return gVar.a(a2, d2, d2.a(this.f5589a, !a2.e().equals("GET")), d2.c());
    }
}
