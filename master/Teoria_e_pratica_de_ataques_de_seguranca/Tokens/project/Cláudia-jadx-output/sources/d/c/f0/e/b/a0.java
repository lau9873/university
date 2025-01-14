package d.c.f0.e.b;

import java.util.NoSuchElementException;
/* compiled from: FlowableSingleSingle.java */
/* loaded from: classes.dex */
public final class a0<T> extends d.c.u<T> implements d.c.f0.c.b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.j<T> f4796a;

    /* renamed from: b  reason: collision with root package name */
    public final T f4797b;

    public a0(d.c.j<T> jVar, T t) {
        this.f4796a = jVar;
        this.f4797b = t;
    }

    @Override // d.c.f0.c.b
    public d.c.j<T> a() {
        return d.c.h0.a.a(new z(this.f4796a, this.f4797b));
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f4796a.a((d.c.k) new a(wVar, this.f4797b));
    }

    /* compiled from: FlowableSingleSingle.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.k<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f4798a;

        /* renamed from: b  reason: collision with root package name */
        public final T f4799b;

        /* renamed from: c  reason: collision with root package name */
        public g.b.d f4800c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4801d;

        /* renamed from: e  reason: collision with root package name */
        public T f4802e;

        public a(d.c.w<? super T> wVar, T t) {
            this.f4798a = wVar;
            this.f4799b = t;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4800c, dVar)) {
                this.f4800c = dVar;
                this.f4798a.a(this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4800c.cancel();
            this.f4800c = d.c.f0.i.g.CANCELLED;
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4800c == d.c.f0.i.g.CANCELLED;
        }

        @Override // g.b.c
        public void a(T t) {
            if (this.f4801d) {
                return;
            }
            if (this.f4802e != null) {
                this.f4801d = true;
                this.f4800c.cancel();
                this.f4800c = d.c.f0.i.g.CANCELLED;
                this.f4798a.a(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f4802e = t;
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f4801d) {
                d.c.h0.a.b(th);
                return;
            }
            this.f4801d = true;
            this.f4800c = d.c.f0.i.g.CANCELLED;
            this.f4798a.a(th);
        }

        @Override // g.b.c
        public void a() {
            if (this.f4801d) {
                return;
            }
            this.f4801d = true;
            this.f4800c = d.c.f0.i.g.CANCELLED;
            T t = this.f4802e;
            this.f4802e = null;
            if (t == null) {
                t = this.f4799b;
            }
            if (t != null) {
                this.f4798a.b(t);
            } else {
                this.f4798a.a(new NoSuchElementException());
            }
        }
    }
}
