package d.c.f0.e.d;

import d.c.r;
import d.c.s;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableConcatMap.java */
/* loaded from: classes.dex */
public final class b<T, U> extends d.c.f0.e.d.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends r<? extends U>> f4960b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4961c;

    /* renamed from: d  reason: collision with root package name */
    public final d.c.f0.j.e f4962d;

    public b(r<T> rVar, d.c.e0.n<? super T, ? extends r<? extends U>> nVar, int i2, d.c.f0.j.e eVar) {
        super(rVar);
        this.f4960b = nVar;
        this.f4962d = eVar;
        this.f4961c = Math.max(8, i2);
    }

    @Override // d.c.o
    public void b(s<? super U> sVar) {
        if (m.a(this.f4959a, sVar, this.f4960b)) {
            return;
        }
        d.c.f0.j.e eVar = this.f4962d;
        if (eVar == d.c.f0.j.e.IMMEDIATE) {
            this.f4959a.a(new C0106b(new d.c.g0.b(sVar), this.f4960b, this.f4961c));
        } else {
            this.f4959a.a(new a(sVar, this.f4960b, this.f4961c, eVar == d.c.f0.j.e.END));
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: d.c.f0.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0106b<T, U> extends AtomicInteger implements s<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super U> f4974a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.f0.a.e f4975b = new d.c.f0.a.e();

        /* renamed from: c  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends r<? extends U>> f4976c;

        /* renamed from: d  reason: collision with root package name */
        public final s<U> f4977d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4978e;

        /* renamed from: f  reason: collision with root package name */
        public d.c.f0.c.n<T> f4979f;

        /* renamed from: g  reason: collision with root package name */
        public d.c.c0.b f4980g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f4981h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f4982i;
        public volatile boolean j;
        public int k;

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: d.c.f0.e.d.b$b$a */
        /* loaded from: classes.dex */
        public static final class a<U> implements s<U> {

            /* renamed from: a  reason: collision with root package name */
            public final s<? super U> f4983a;

            /* renamed from: b  reason: collision with root package name */
            public final C0106b<?, ?> f4984b;

            public a(s<? super U> sVar, C0106b<?, ?> c0106b) {
                this.f4983a = sVar;
                this.f4984b = c0106b;
            }

            @Override // d.c.s
            public void a(d.c.c0.b bVar) {
                this.f4984b.b(bVar);
            }

            @Override // d.c.s
            public void a(U u) {
                this.f4983a.a((s<? super U>) u);
            }

            @Override // d.c.s
            public void a(Throwable th) {
                this.f4984b.b();
                this.f4983a.a(th);
            }

            @Override // d.c.s
            public void a() {
                this.f4984b.e();
            }
        }

        public C0106b(s<? super U> sVar, d.c.e0.n<? super T, ? extends r<? extends U>> nVar, int i2) {
            this.f4974a = sVar;
            this.f4976c = nVar;
            this.f4978e = i2;
            this.f4977d = new a(sVar, this);
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f4980g, bVar)) {
                this.f4980g = bVar;
                if (bVar instanceof d.c.f0.c.i) {
                    d.c.f0.c.i iVar = (d.c.f0.c.i) bVar;
                    int a2 = iVar.a(3);
                    if (a2 == 1) {
                        this.k = a2;
                        this.f4979f = iVar;
                        this.j = true;
                        this.f4974a.a((d.c.c0.b) this);
                        d();
                        return;
                    } else if (a2 == 2) {
                        this.k = a2;
                        this.f4979f = iVar;
                        this.f4974a.a((d.c.c0.b) this);
                        return;
                    }
                }
                this.f4979f = new d.c.f0.f.b(this.f4978e);
                this.f4974a.a((d.c.c0.b) this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4982i = true;
            this.f4975b.b();
            this.f4980g.b();
            if (getAndIncrement() == 0) {
                this.f4979f.clear();
            }
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4982i;
        }

        public void d() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f4982i) {
                if (!this.f4981h) {
                    boolean z = this.j;
                    try {
                        T poll = this.f4979f.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.f4974a.a();
                            return;
                        } else if (!z2) {
                            try {
                                r<? extends U> a2 = this.f4976c.a(poll);
                                d.c.f0.b.b.a(a2, "The mapper returned a null ObservableSource");
                                r<? extends U> rVar = a2;
                                this.f4981h = true;
                                rVar.a(this.f4977d);
                            } catch (Throwable th) {
                                d.c.d0.a.b(th);
                                b();
                                this.f4979f.clear();
                                this.f4974a.a(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        d.c.d0.a.b(th2);
                        b();
                        this.f4979f.clear();
                        this.f4974a.a(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f4979f.clear();
        }

        public void e() {
            this.f4981h = false;
            d();
        }

        public void b(d.c.c0.b bVar) {
            this.f4975b.b(bVar);
        }

        @Override // d.c.s
        public void a(T t) {
            if (this.j) {
                return;
            }
            if (this.k == 0) {
                this.f4979f.offer(t);
            }
            d();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            if (this.j) {
                d.c.h0.a.b(th);
                return;
            }
            this.j = true;
            b();
            this.f4974a.a(th);
        }

        @Override // d.c.s
        public void a() {
            if (this.j) {
                return;
            }
            this.j = true;
            d();
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* loaded from: classes.dex */
    public static final class a<T, R> extends AtomicInteger implements s<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super R> f4963a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends r<? extends R>> f4964b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4965c;

        /* renamed from: e  reason: collision with root package name */
        public final C0105a<R> f4967e;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f4969g;

        /* renamed from: h  reason: collision with root package name */
        public d.c.f0.c.n<T> f4970h;

        /* renamed from: i  reason: collision with root package name */
        public d.c.c0.b f4971i;
        public volatile boolean j;
        public volatile boolean k;
        public volatile boolean m;
        public int n;

        /* renamed from: d  reason: collision with root package name */
        public final d.c.f0.j.b f4966d = new d.c.f0.j.b();

        /* renamed from: f  reason: collision with root package name */
        public final d.c.f0.a.e f4968f = new d.c.f0.a.e();

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: d.c.f0.e.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0105a<R> implements s<R> {

            /* renamed from: a  reason: collision with root package name */
            public final s<? super R> f4972a;

            /* renamed from: b  reason: collision with root package name */
            public final a<?, R> f4973b;

            public C0105a(s<? super R> sVar, a<?, R> aVar) {
                this.f4972a = sVar;
                this.f4973b = aVar;
            }

            @Override // d.c.s
            public void a(d.c.c0.b bVar) {
                this.f4973b.f4968f.a(bVar);
            }

            @Override // d.c.s
            public void a(R r) {
                this.f4972a.a((s<? super R>) r);
            }

            @Override // d.c.s
            public void a(Throwable th) {
                a<?, R> aVar = this.f4973b;
                if (aVar.f4966d.a(th)) {
                    if (!aVar.f4969g) {
                        aVar.f4971i.b();
                    }
                    aVar.j = false;
                    aVar.d();
                    return;
                }
                d.c.h0.a.b(th);
            }

            @Override // d.c.s
            public void a() {
                a<?, R> aVar = this.f4973b;
                aVar.j = false;
                aVar.d();
            }
        }

        public a(s<? super R> sVar, d.c.e0.n<? super T, ? extends r<? extends R>> nVar, int i2, boolean z) {
            this.f4963a = sVar;
            this.f4964b = nVar;
            this.f4965c = i2;
            this.f4969g = z;
            this.f4967e = new C0105a<>(sVar, this);
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f4971i, bVar)) {
                this.f4971i = bVar;
                if (bVar instanceof d.c.f0.c.i) {
                    d.c.f0.c.i iVar = (d.c.f0.c.i) bVar;
                    int a2 = iVar.a(3);
                    if (a2 == 1) {
                        this.n = a2;
                        this.f4970h = iVar;
                        this.k = true;
                        this.f4963a.a((d.c.c0.b) this);
                        d();
                        return;
                    } else if (a2 == 2) {
                        this.n = a2;
                        this.f4970h = iVar;
                        this.f4963a.a((d.c.c0.b) this);
                        return;
                    }
                }
                this.f4970h = new d.c.f0.f.b(this.f4965c);
                this.f4963a.a((d.c.c0.b) this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.m = true;
            this.f4971i.b();
            this.f4968f.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4971i.c();
        }

        public void d() {
            if (getAndIncrement() != 0) {
                return;
            }
            s<? super R> sVar = this.f4963a;
            d.c.f0.c.n<T> nVar = this.f4970h;
            d.c.f0.j.b bVar = this.f4966d;
            while (true) {
                if (!this.j) {
                    if (this.m) {
                        nVar.clear();
                        return;
                    } else if (!this.f4969g && bVar.get() != null) {
                        nVar.clear();
                        sVar.a(bVar.a());
                        return;
                    } else {
                        boolean z = this.k;
                        try {
                            T poll = nVar.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable a2 = bVar.a();
                                if (a2 != null) {
                                    sVar.a(a2);
                                    return;
                                } else {
                                    sVar.a();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    r<? extends R> a3 = this.f4964b.a(poll);
                                    d.c.f0.b.b.a(a3, "The mapper returned a null ObservableSource");
                                    r<? extends R> rVar = a3;
                                    if (rVar instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) rVar).call();
                                            if (obj != 0 && !this.m) {
                                                sVar.a((s<? super R>) obj);
                                            }
                                        } catch (Throwable th) {
                                            d.c.d0.a.b(th);
                                            bVar.a(th);
                                        }
                                    } else {
                                        this.j = true;
                                        rVar.a(this.f4967e);
                                    }
                                } catch (Throwable th2) {
                                    d.c.d0.a.b(th2);
                                    this.f4971i.b();
                                    nVar.clear();
                                    bVar.a(th2);
                                    sVar.a(bVar.a());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            d.c.d0.a.b(th3);
                            this.f4971i.b();
                            bVar.a(th3);
                            sVar.a(bVar.a());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // d.c.s
        public void a(T t) {
            if (this.n == 0) {
                this.f4970h.offer(t);
            }
            d();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            if (this.f4966d.a(th)) {
                this.k = true;
                d();
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // d.c.s
        public void a() {
            this.k = true;
            d();
        }
    }
}
