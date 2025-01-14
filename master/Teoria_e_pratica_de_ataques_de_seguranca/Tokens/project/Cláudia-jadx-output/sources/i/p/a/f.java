package i.p.a;

import d.c.o;
import d.c.t;
import java.lang.reflect.Type;
/* compiled from: RxJava2CallAdapter.java */
/* loaded from: classes.dex */
public final class f<R> implements i.c<R, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final Type f7544a;

    /* renamed from: b  reason: collision with root package name */
    public final t f7545b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f7546c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f7547d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7548e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f7549f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f7550g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f7551h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f7552i;

    public f(Type type, t tVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f7544a = type;
        this.f7545b = tVar;
        this.f7546c = z;
        this.f7547d = z2;
        this.f7548e = z3;
        this.f7549f = z4;
        this.f7550g = z5;
        this.f7551h = z6;
        this.f7552i = z7;
    }

    @Override // i.c
    public Type a() {
        return this.f7544a;
    }

    @Override // i.c
    public Object a(i.b<R> bVar) {
        o cVar;
        o aVar;
        if (this.f7546c) {
            cVar = new b(bVar);
        } else {
            cVar = new c(bVar);
        }
        if (this.f7547d) {
            aVar = new e(cVar);
        } else {
            aVar = this.f7548e ? new a(cVar) : cVar;
        }
        t tVar = this.f7545b;
        if (tVar != null) {
            aVar = aVar.a(tVar);
        }
        if (this.f7549f) {
            return aVar.a(d.c.a.LATEST);
        }
        if (this.f7550g) {
            return aVar.c();
        }
        if (this.f7551h) {
            return aVar.b();
        }
        return this.f7552i ? aVar.a() : aVar;
    }
}
