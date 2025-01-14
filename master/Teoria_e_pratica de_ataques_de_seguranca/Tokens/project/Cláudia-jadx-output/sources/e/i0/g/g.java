package e.i0.g;

import e.b0;
import e.d0;
import e.v;
import java.util.List;
/* compiled from: RealInterceptorChain.java */
/* loaded from: classes.dex */
public final class g implements v.a {

    /* renamed from: a  reason: collision with root package name */
    public final List<v> f5627a;

    /* renamed from: b  reason: collision with root package name */
    public final e.i0.f.f f5628b;

    /* renamed from: c  reason: collision with root package name */
    public final c f5629c;

    /* renamed from: d  reason: collision with root package name */
    public final e.i0.f.c f5630d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5631e;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f5632f;

    /* renamed from: g  reason: collision with root package name */
    public int f5633g;

    public g(List<v> list, e.i0.f.f fVar, c cVar, e.i0.f.c cVar2, int i2, b0 b0Var) {
        this.f5627a = list;
        this.f5630d = cVar2;
        this.f5628b = fVar;
        this.f5629c = cVar;
        this.f5631e = i2;
        this.f5632f = b0Var;
    }

    @Override // e.v.a
    public b0 a() {
        return this.f5632f;
    }

    @Override // e.v.a
    public e.i b() {
        return this.f5630d;
    }

    public c c() {
        return this.f5629c;
    }

    public e.i0.f.f d() {
        return this.f5628b;
    }

    @Override // e.v.a
    public d0 a(b0 b0Var) {
        return a(b0Var, this.f5628b, this.f5629c, this.f5630d);
    }

    public d0 a(b0 b0Var, e.i0.f.f fVar, c cVar, e.i0.f.c cVar2) {
        if (this.f5631e < this.f5627a.size()) {
            this.f5633g++;
            if (this.f5629c != null && !this.f5630d.a(b0Var.g())) {
                throw new IllegalStateException("network interceptor " + this.f5627a.get(this.f5631e - 1) + " must retain the same host and port");
            } else if (this.f5629c != null && this.f5633g > 1) {
                throw new IllegalStateException("network interceptor " + this.f5627a.get(this.f5631e - 1) + " must call proceed() exactly once");
            } else {
                g gVar = new g(this.f5627a, fVar, cVar, cVar2, this.f5631e + 1, b0Var);
                v vVar = this.f5627a.get(this.f5631e);
                d0 intercept = vVar.intercept(gVar);
                if (cVar != null && this.f5631e + 1 < this.f5627a.size() && gVar.f5633g != 1) {
                    throw new IllegalStateException("network interceptor " + vVar + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("interceptor " + vVar + " returned null");
                }
            }
        }
        throw new AssertionError();
    }
}
