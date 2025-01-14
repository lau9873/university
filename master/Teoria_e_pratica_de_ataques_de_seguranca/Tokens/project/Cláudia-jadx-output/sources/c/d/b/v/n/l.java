package c.d.b.v.n;

import c.d.b.p;
import c.d.b.q;
import c.d.b.s;
import c.d.b.t;
/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes.dex */
public final class l<T> extends s<T> {

    /* renamed from: a  reason: collision with root package name */
    public final q<T> f3844a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.b.k<T> f3845b;

    /* renamed from: c  reason: collision with root package name */
    public final c.d.b.f f3846c;

    /* renamed from: d  reason: collision with root package name */
    public final c.d.b.w.a<T> f3847d;

    /* renamed from: e  reason: collision with root package name */
    public final t f3848e;

    /* renamed from: f  reason: collision with root package name */
    public final l<T>.b f3849f = new b();

    /* renamed from: g  reason: collision with root package name */
    public s<T> f3850g;

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes.dex */
    public final class b implements p, c.d.b.j {
        public b(l lVar) {
        }
    }

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes.dex */
    public static final class c implements t {

        /* renamed from: a  reason: collision with root package name */
        public final c.d.b.w.a<?> f3851a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f3852b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<?> f3853c;

        /* renamed from: d  reason: collision with root package name */
        public final q<?> f3854d;

        /* renamed from: e  reason: collision with root package name */
        public final c.d.b.k<?> f3855e;

        public c(Object obj, c.d.b.w.a<?> aVar, boolean z, Class<?> cls) {
            this.f3854d = obj instanceof q ? (q) obj : null;
            this.f3855e = obj instanceof c.d.b.k ? (c.d.b.k) obj : null;
            c.d.b.v.a.a((this.f3854d == null && this.f3855e == null) ? false : true);
            this.f3851a = aVar;
            this.f3852b = z;
            this.f3853c = cls;
        }

        @Override // c.d.b.t
        public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            boolean isAssignableFrom;
            c.d.b.w.a<?> aVar2 = this.f3851a;
            if (aVar2 != null) {
                isAssignableFrom = aVar2.equals(aVar) || (this.f3852b && this.f3851a.getType() == aVar.getRawType());
            } else {
                isAssignableFrom = this.f3853c.isAssignableFrom(aVar.getRawType());
            }
            if (isAssignableFrom) {
                return new l(this.f3854d, this.f3855e, fVar, aVar, this);
            }
            return null;
        }
    }

    public l(q<T> qVar, c.d.b.k<T> kVar, c.d.b.f fVar, c.d.b.w.a<T> aVar, t tVar) {
        this.f3844a = qVar;
        this.f3845b = kVar;
        this.f3846c = fVar;
        this.f3847d = aVar;
        this.f3848e = tVar;
    }

    @Override // c.d.b.s
    public T a(c.d.b.x.a aVar) {
        if (this.f3845b == null) {
            return b().a(aVar);
        }
        c.d.b.l a2 = c.d.b.v.l.a(aVar);
        if (a2.r()) {
            return null;
        }
        return this.f3845b.deserialize(a2, this.f3847d.getType(), this.f3849f);
    }

    public final s<T> b() {
        s<T> sVar = this.f3850g;
        if (sVar != null) {
            return sVar;
        }
        s<T> a2 = this.f3846c.a(this.f3848e, this.f3847d);
        this.f3850g = a2;
        return a2;
    }

    @Override // c.d.b.s
    public void a(c.d.b.x.c cVar, T t) {
        q<T> qVar = this.f3844a;
        if (qVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.t();
        } else {
            c.d.b.v.l.a(qVar.a(t, this.f3847d.getType(), this.f3849f), cVar);
        }
    }

    public static t a(c.d.b.w.a<?> aVar, Object obj) {
        return new c(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }
}
