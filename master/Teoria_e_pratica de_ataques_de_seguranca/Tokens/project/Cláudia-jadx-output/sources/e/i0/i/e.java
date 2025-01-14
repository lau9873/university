package e.i0.i;

import e.b0;
import e.d0;
import e.e0;
import e.t;
import e.y;
import e.z;
import f.q;
import f.r;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* compiled from: Http2Codec.java */
/* loaded from: classes.dex */
public final class e implements e.i0.g.c {

    /* renamed from: e  reason: collision with root package name */
    public static final f.f f5707e = f.f.c("connection");

    /* renamed from: f  reason: collision with root package name */
    public static final f.f f5708f = f.f.c("host");

    /* renamed from: g  reason: collision with root package name */
    public static final f.f f5709g = f.f.c("keep-alive");

    /* renamed from: h  reason: collision with root package name */
    public static final f.f f5710h = f.f.c("proxy-connection");

    /* renamed from: i  reason: collision with root package name */
    public static final f.f f5711i = f.f.c("transfer-encoding");
    public static final f.f j = f.f.c("te");
    public static final f.f k = f.f.c("encoding");
    public static final f.f l = f.f.c("upgrade");
    public static final List<f.f> m = e.i0.c.a(f5707e, f5708f, f5709g, f5710h, j, f5711i, k, l, b.f5677f, b.f5678g, b.f5679h, b.f5680i);
    public static final List<f.f> n = e.i0.c.a(f5707e, f5708f, f5709g, f5710h, j, f5711i, k, l);

    /* renamed from: a  reason: collision with root package name */
    public final y f5712a;

    /* renamed from: b  reason: collision with root package name */
    public final e.i0.f.f f5713b;

    /* renamed from: c  reason: collision with root package name */
    public final f f5714c;

    /* renamed from: d  reason: collision with root package name */
    public h f5715d;

    /* compiled from: Http2Codec.java */
    /* loaded from: classes.dex */
    public class a extends f.g {
        public a(r rVar) {
            super(rVar);
        }

        @Override // f.g, f.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            e eVar = e.this;
            eVar.f5713b.a(false, (e.i0.g.c) eVar);
            super.close();
        }
    }

    public e(y yVar, e.i0.f.f fVar, f fVar2) {
        this.f5712a = yVar;
        this.f5713b = fVar;
        this.f5714c = fVar2;
    }

    @Override // e.i0.g.c
    public q a(b0 b0Var, long j2) {
        return this.f5715d.d();
    }

    @Override // e.i0.g.c
    public void b() {
        this.f5714c.flush();
    }

    @Override // e.i0.g.c
    public void cancel() {
        h hVar = this.f5715d;
        if (hVar != null) {
            hVar.c(e.i0.i.a.CANCEL);
        }
    }

    public static List<b> b(b0 b0Var) {
        t c2 = b0Var.c();
        ArrayList arrayList = new ArrayList(c2.b() + 4);
        arrayList.add(new b(b.f5677f, b0Var.e()));
        arrayList.add(new b(b.f5678g, e.i0.g.i.a(b0Var.g())));
        String a2 = b0Var.a("Host");
        if (a2 != null) {
            arrayList.add(new b(b.f5680i, a2));
        }
        arrayList.add(new b(b.f5679h, b0Var.g().n()));
        int b2 = c2.b();
        for (int i2 = 0; i2 < b2; i2++) {
            f.f c3 = f.f.c(c2.a(i2).toLowerCase(Locale.US));
            if (!m.contains(c3)) {
                arrayList.add(new b(c3, c2.b(i2)));
            }
        }
        return arrayList;
    }

    @Override // e.i0.g.c
    public void a(b0 b0Var) {
        if (this.f5715d != null) {
            return;
        }
        this.f5715d = this.f5714c.a(b(b0Var), b0Var.a() != null);
        this.f5715d.h().a(this.f5712a.v(), TimeUnit.MILLISECONDS);
        this.f5715d.l().a(this.f5712a.A(), TimeUnit.MILLISECONDS);
    }

    @Override // e.i0.g.c
    public void a() {
        this.f5715d.d().close();
    }

    @Override // e.i0.g.c
    public d0.a a(boolean z) {
        d0.a a2 = a(this.f5715d.j());
        if (z && e.i0.a.f5560a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    public static d0.a a(List<b> list) {
        t.a aVar = new t.a();
        int size = list.size();
        t.a aVar2 = aVar;
        e.i0.g.k kVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = list.get(i2);
            if (bVar == null) {
                if (kVar != null && kVar.f5642b == 100) {
                    aVar2 = new t.a();
                    kVar = null;
                }
            } else {
                f.f fVar = bVar.f5681a;
                String i3 = bVar.f5682b.i();
                if (fVar.equals(b.f5676e)) {
                    kVar = e.i0.g.k.a("HTTP/1.1 " + i3);
                } else if (!n.contains(fVar)) {
                    e.i0.a.f5560a.a(aVar2, fVar.i(), i3);
                }
            }
        }
        if (kVar != null) {
            d0.a aVar3 = new d0.a();
            aVar3.a(z.HTTP_2);
            aVar3.a(kVar.f5642b);
            aVar3.a(kVar.f5643c);
            aVar3.a(aVar2.a());
            return aVar3;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // e.i0.g.c
    public e0 a(d0 d0Var) {
        return new e.i0.g.h(d0Var.n(), f.k.a(new a(this.f5715d.e())));
    }
}
