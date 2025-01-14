package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleFlatMap.java */
/* loaded from: classes.dex */
public final class u<T, R> extends d.c.u<R> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5238a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends d.c.z<? extends R>> f5239b;

    /* compiled from: SingleFlatMap.java */
    /* loaded from: classes.dex */
    public static final class a<T, R> extends AtomicReference<d.c.c0.b> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super R> f5240a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends d.c.z<? extends R>> f5241b;

        /* compiled from: SingleFlatMap.java */
        /* renamed from: d.c.f0.e.e.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0111a<R> implements d.c.w<R> {

            /* renamed from: a  reason: collision with root package name */
            public final AtomicReference<d.c.c0.b> f5242a;

            /* renamed from: b  reason: collision with root package name */
            public final d.c.w<? super R> f5243b;

            public C0111a(AtomicReference<d.c.c0.b> atomicReference, d.c.w<? super R> wVar) {
                this.f5242a = atomicReference;
                this.f5243b = wVar;
            }

            @Override // d.c.w
            public void a(d.c.c0.b bVar) {
                d.c.f0.a.b.a(this.f5242a, bVar);
            }

            @Override // d.c.w
            public void b(R r) {
                this.f5243b.b(r);
            }

            @Override // d.c.w
            public void a(Throwable th) {
                this.f5243b.a(th);
            }
        }

        public a(d.c.w<? super R> wVar, d.c.e0.n<? super T, ? extends d.c.z<? extends R>> nVar) {
            this.f5240a = wVar;
            this.f5241b = nVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.c(this, bVar)) {
                this.f5240a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.w
        public void b(T t) {
            try {
                d.c.z<? extends R> a2 = this.f5241b.a(t);
                d.c.f0.b.b.a(a2, "The single returned by the mapper is null");
                d.c.z<? extends R> zVar = a2;
                if (c()) {
                    return;
                }
                zVar.subscribe(new C0111a(this, this.f5240a));
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f5240a.a(th);
            }
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5240a.a(th);
        }
    }

    public u(d.c.z<? extends T> zVar, d.c.e0.n<? super T, ? extends d.c.z<? extends R>> nVar) {
        this.f5239b = nVar;
        this.f5238a = zVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super R> wVar) {
        this.f5238a.subscribe(new a(wVar, this.f5239b));
    }
}
