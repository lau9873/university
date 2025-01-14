package e.i0.g;

import e.b0;
import e.d0;
import e.v;
import java.net.ProtocolException;
/* compiled from: CallServerInterceptor.java */
/* loaded from: classes.dex */
public final class b implements v {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5623a;

    public b(boolean z) {
        this.f5623a = z;
    }

    @Override // e.v
    public d0 intercept(v.a aVar) {
        d0 a2;
        g gVar = (g) aVar;
        c c2 = gVar.c();
        e.i0.f.f d2 = gVar.d();
        e.i0.f.c cVar = (e.i0.f.c) gVar.b();
        b0 a3 = gVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        c2.a(a3);
        d0.a aVar2 = null;
        if (f.b(a3.e()) && a3.a() != null) {
            if ("100-continue".equalsIgnoreCase(a3.a("Expect"))) {
                c2.b();
                aVar2 = c2.a(true);
            }
            if (aVar2 == null) {
                f.d a4 = f.k.a(c2.a(a3, a3.a().a()));
                a3.a().a(a4);
                a4.close();
            } else if (!cVar.f()) {
                d2.e();
            }
        }
        c2.a();
        if (aVar2 == null) {
            aVar2 = c2.a(false);
        }
        aVar2.a(a3);
        aVar2.a(d2.c().e());
        aVar2.b(currentTimeMillis);
        aVar2.a(System.currentTimeMillis());
        d0 a5 = aVar2.a();
        int l = a5.l();
        if (this.f5623a && l == 101) {
            d0.a q = a5.q();
            q.a(e.i0.c.f5564c);
            a2 = q.a();
        } else {
            d0.a q2 = a5.q();
            q2.a(c2.a(a5));
            a2 = q2.a();
        }
        if ("close".equalsIgnoreCase(a2.s().a("Connection")) || "close".equalsIgnoreCase(a2.b("Connection"))) {
            d2.e();
        }
        if ((l == 204 || l == 205) && a2.j().l() > 0) {
            throw new ProtocolException("HTTP " + l + " had non-zero Content-Length: " + a2.j().l());
        }
        return a2;
    }
}
