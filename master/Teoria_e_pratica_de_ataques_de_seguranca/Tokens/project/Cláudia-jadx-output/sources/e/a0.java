package e;

import e.q;
import java.io.IOException;
import java.util.ArrayList;
/* compiled from: RealCall.java */
/* loaded from: classes.dex */
public final class a0 implements e {

    /* renamed from: a  reason: collision with root package name */
    public final y f5462a;

    /* renamed from: b  reason: collision with root package name */
    public final e.i0.g.j f5463b;

    /* renamed from: c  reason: collision with root package name */
    public final b0 f5464c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f5465d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5466e;

    /* compiled from: RealCall.java */
    /* loaded from: classes.dex */
    public final class a extends e.i0.b {

        /* renamed from: b  reason: collision with root package name */
        public final f f5467b;

        public a(f fVar) {
            super("OkHttp %s", a0.this.c());
            this.f5467b = fVar;
        }

        @Override // e.i0.b
        public void b() {
            IOException e2;
            boolean z = true;
            try {
                try {
                    d0 b2 = a0.this.b();
                    try {
                        if (a0.this.f5463b.b()) {
                            this.f5467b.a(a0.this, new IOException("Canceled"));
                        } else {
                            this.f5467b.a(a0.this, b2);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        if (z) {
                            e.i0.j.e b3 = e.i0.j.e.b();
                            b3.a(4, "Callback failure for " + a0.this.d(), e2);
                        } else {
                            this.f5467b.a(a0.this, e2);
                        }
                    }
                } finally {
                    a0.this.f5462a.g().b(this);
                }
            } catch (IOException e4) {
                e2 = e4;
                z = false;
            }
        }

        public String c() {
            return a0.this.f5464c.g().g();
        }
    }

    public a0(y yVar, b0 b0Var, boolean z) {
        q.c i2 = yVar.i();
        this.f5462a = yVar;
        this.f5464c = b0Var;
        this.f5465d = z;
        this.f5463b = new e.i0.g.j(yVar, z);
        i2.a(this);
    }

    public final void a() {
        this.f5463b.a(e.i0.j.e.b().a("response.body().close()"));
    }

    public d0 b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5462a.o());
        arrayList.add(this.f5463b);
        arrayList.add(new e.i0.g.a(this.f5462a.f()));
        arrayList.add(new e.i0.e.a(this.f5462a.p()));
        arrayList.add(new e.i0.f.a(this.f5462a));
        if (!this.f5465d) {
            arrayList.addAll(this.f5462a.q());
        }
        arrayList.add(new e.i0.g.b(this.f5465d));
        return new e.i0.g.g(arrayList, null, null, null, 0, this.f5464c).a(this.f5464c);
    }

    public String c() {
        return this.f5464c.g().m();
    }

    @Override // e.e
    public void cancel() {
        this.f5463b.a();
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(k() ? "canceled " : "");
        sb.append(this.f5465d ? "web socket" : "call");
        sb.append(" to ");
        sb.append(c());
        return sb.toString();
    }

    @Override // e.e
    public d0 j() {
        synchronized (this) {
            if (!this.f5466e) {
                this.f5466e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        a();
        try {
            this.f5462a.g().a(this);
            d0 b2 = b();
            if (b2 != null) {
                return b2;
            }
            throw new IOException("Canceled");
        } finally {
            this.f5462a.g().b(this);
        }
    }

    @Override // e.e
    public boolean k() {
        return this.f5463b.b();
    }

    /* renamed from: clone */
    public a0 m8clone() {
        return new a0(this.f5462a, this.f5464c, this.f5465d);
    }

    @Override // e.e
    public void a(f fVar) {
        synchronized (this) {
            if (!this.f5466e) {
                this.f5466e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        a();
        this.f5462a.g().a(new a(fVar));
    }
}
