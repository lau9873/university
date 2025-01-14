package e.i0.g;

import e.b0;
import e.c0;
import e.d0;
import e.l;
import e.m;
import e.t;
import e.v;
import e.w;
import java.util.List;
/* compiled from: BridgeInterceptor.java */
/* loaded from: classes.dex */
public final class a implements v {

    /* renamed from: a  reason: collision with root package name */
    public final m f5622a;

    public a(m mVar) {
        this.f5622a = mVar;
    }

    public final String a(List<l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            l lVar = list.get(i2);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }

    @Override // e.v
    public d0 intercept(v.a aVar) {
        b0 a2 = aVar.a();
        b0.a f2 = a2.f();
        c0 a3 = a2.a();
        if (a3 != null) {
            w b2 = a3.b();
            if (b2 != null) {
                f2.b("Content-Type", b2.toString());
            }
            long a4 = a3.a();
            if (a4 != -1) {
                f2.b("Content-Length", Long.toString(a4));
                f2.a("Transfer-Encoding");
            } else {
                f2.b("Transfer-Encoding", "chunked");
                f2.a("Content-Length");
            }
        }
        boolean z = false;
        if (a2.a("Host") == null) {
            f2.b("Host", e.i0.c.a(a2.g(), false));
        }
        if (a2.a("Connection") == null) {
            f2.b("Connection", "Keep-Alive");
        }
        if (a2.a("Accept-Encoding") == null && a2.a("Range") == null) {
            z = true;
            f2.b("Accept-Encoding", "gzip");
        }
        List<l> a5 = this.f5622a.a(a2.g());
        if (!a5.isEmpty()) {
            f2.b("Cookie", a(a5));
        }
        if (a2.a("User-Agent") == null) {
            f2.b("User-Agent", e.i0.d.a());
        }
        d0 a6 = aVar.a(f2.a());
        e.a(this.f5622a, a2.g(), a6.n());
        d0.a q = a6.q();
        q.a(a2);
        if (z && "gzip".equalsIgnoreCase(a6.b("Content-Encoding")) && e.b(a6)) {
            f.i iVar = new f.i(a6.j().n());
            t.a a7 = a6.n().a();
            a7.b("Content-Encoding");
            a7.b("Content-Length");
            t a8 = a7.a();
            q.a(a8);
            q.a(new h(a8, f.k.a(iVar)));
        }
        return q.a();
    }
}
