package d.c.f0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FlowableConcatMap.java */
/* loaded from: classes.dex */
public final class c<T, R> extends d.c.f0.e.b.a<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends g.b.b<? extends R>> f4817c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4818d;

    /* renamed from: e  reason: collision with root package name */
    public final d.c.f0.j.e f4819e;

    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4820a = new int[d.c.f0.j.e.values().length];

        static {
            try {
                f4820a[d.c.f0.j.e.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4820a[d.c.f0.j.e.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: d.c.f0.e.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0103c<T, R> extends b<T, R> {
        public final g.b.c<? super R> n;
        public final boolean o;

        public C0103c(g.b.c<? super R> cVar, d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar, int i2, boolean z) {
            super(nVar, i2);
            this.n = cVar;
            this.o = z;
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.j.a(th)) {
                this.f4828h = true;
                c();
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // d.c.f0.e.b.c.f
        public void b(R r) {
            this.n.a((g.b.c<? super R>) r);
        }

        @Override // d.c.f0.e.b.c.b
        public void c() {
            if (getAndIncrement() == 0) {
                while (!this.f4829i) {
                    if (!this.k) {
                        boolean z = this.f4828h;
                        if (z && !this.o && this.j.get() != null) {
                            this.n.a(this.j.a());
                            return;
                        }
                        try {
                            T poll = this.f4827g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable a2 = this.j.a();
                                if (a2 != null) {
                                    this.n.a(a2);
                                    return;
                                } else {
                                    this.n.a();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    g.b.b<? extends R> a3 = this.f4822b.a(poll);
                                    d.c.f0.b.b.a(a3, "The mapper returned a null Publisher");
                                    g.b.b<? extends R> bVar = a3;
                                    if (this.m != 1) {
                                        int i2 = this.f4826f + 1;
                                        if (i2 == this.f4824d) {
                                            this.f4826f = 0;
                                            this.f4825e.a(i2);
                                        } else {
                                            this.f4826f = i2;
                                        }
                                    }
                                    if (bVar instanceof Callable) {
                                        try {
                                            Object call = ((Callable) bVar).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.f4821a.e()) {
                                                this.n.a((g.b.c<? super R>) call);
                                            } else {
                                                this.k = true;
                                                e<R> eVar = this.f4821a;
                                                eVar.b(new g(call, eVar));
                                            }
                                        } catch (Throwable th) {
                                            d.c.d0.a.b(th);
                                            this.f4825e.cancel();
                                            this.j.a(th);
                                            this.n.a(this.j.a());
                                            return;
                                        }
                                    } else {
                                        this.k = true;
                                        bVar.a(this.f4821a);
                                    }
                                } catch (Throwable th2) {
                                    d.c.d0.a.b(th2);
                                    this.f4825e.cancel();
                                    this.j.a(th2);
                                    this.n.a(this.j.a());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            d.c.d0.a.b(th3);
                            this.f4825e.cancel();
                            this.j.a(th3);
                            this.n.a(this.j.a());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.b.d
        public void cancel() {
            if (this.f4829i) {
                return;
            }
            this.f4829i = true;
            this.f4821a.cancel();
            this.f4825e.cancel();
        }

        @Override // d.c.f0.e.b.c.b
        public void d() {
            this.n.a((g.b.d) this);
        }

        @Override // d.c.f0.e.b.c.f
        public void b(Throwable th) {
            if (this.j.a(th)) {
                if (!this.o) {
                    this.f4825e.cancel();
                    this.f4828h = true;
                }
                this.k = false;
                c();
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // g.b.d
        public void a(long j) {
            this.f4821a.a(j);
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes.dex */
    public static final class e<R> extends d.c.f0.i.f implements d.c.k<R> {

        /* renamed from: h  reason: collision with root package name */
        public final f<R> f4830h;

        /* renamed from: i  reason: collision with root package name */
        public long f4831i;

        public e(f<R> fVar) {
            this.f4830h = fVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            b(dVar);
        }

        @Override // g.b.c
        public void a(R r) {
            this.f4831i++;
            this.f4830h.b((f<R>) r);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            long j = this.f4831i;
            if (j != 0) {
                this.f4831i = 0L;
                b(j);
            }
            this.f4830h.b(th);
        }

        @Override // g.b.c
        public void a() {
            long j = this.f4831i;
            if (j != 0) {
                this.f4831i = 0L;
                b(j);
            }
            this.f4830h.b();
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes.dex */
    public interface f<T> {
        void b();

        void b(T t);

        void b(Throwable th);
    }

    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes.dex */
    public static final class g<T> implements g.b.d {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4832a;

        /* renamed from: b  reason: collision with root package name */
        public final T f4833b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4834c;

        public g(T t, g.b.c<? super T> cVar) {
            this.f4833b = t;
            this.f4832a = cVar;
        }

        @Override // g.b.d
        public void a(long j) {
            if (j <= 0 || this.f4834c) {
                return;
            }
            this.f4834c = true;
            g.b.c<? super T> cVar = this.f4832a;
            cVar.a((g.b.c<? super T>) ((T) this.f4833b));
            cVar.a();
        }

        @Override // g.b.d
        public void cancel() {
        }
    }

    public c(d.c.j<T> jVar, d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar, int i2, d.c.f0.j.e eVar) {
        super(jVar);
        this.f4817c = nVar;
        this.f4818d = i2;
        this.f4819e = eVar;
    }

    public static <T, R> g.b.c<T> a(g.b.c<? super R> cVar, d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar, int i2, d.c.f0.j.e eVar) {
        int i3 = a.f4820a[eVar.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return new d(cVar, nVar, i2);
            }
            return new C0103c(cVar, nVar, i2, true);
        }
        return new C0103c(cVar, nVar, i2, false);
    }

    @Override // d.c.j
    public void b(g.b.c<? super R> cVar) {
        if (y.a(this.f4795b, cVar, this.f4817c)) {
            return;
        }
        this.f4795b.a(a(cVar, this.f4817c, this.f4818d, this.f4819e));
    }

    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes.dex */
    public static final class d<T, R> extends b<T, R> {
        public final g.b.c<? super R> n;
        public final AtomicInteger o;

        public d(g.b.c<? super R> cVar, d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar, int i2) {
            super(nVar, i2);
            this.n = cVar;
            this.o = new AtomicInteger();
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.j.a(th)) {
                this.f4821a.cancel();
                if (getAndIncrement() == 0) {
                    this.n.a(this.j.a());
                    return;
                }
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // d.c.f0.e.b.c.f
        public void b(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.n.a((g.b.c<? super R>) r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.n.a(this.j.a());
            }
        }

        @Override // d.c.f0.e.b.c.b
        public void c() {
            if (this.o.getAndIncrement() == 0) {
                while (!this.f4829i) {
                    if (!this.k) {
                        boolean z = this.f4828h;
                        try {
                            T poll = this.f4827g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.n.a();
                                return;
                            } else if (!z2) {
                                try {
                                    g.b.b<? extends R> a2 = this.f4822b.a(poll);
                                    d.c.f0.b.b.a(a2, "The mapper returned a null Publisher");
                                    g.b.b<? extends R> bVar = a2;
                                    if (this.m != 1) {
                                        int i2 = this.f4826f + 1;
                                        if (i2 == this.f4824d) {
                                            this.f4826f = 0;
                                            this.f4825e.a(i2);
                                        } else {
                                            this.f4826f = i2;
                                        }
                                    }
                                    if (bVar instanceof Callable) {
                                        try {
                                            Object call = ((Callable) bVar).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.f4821a.e()) {
                                                if (get() == 0 && compareAndSet(0, 1)) {
                                                    this.n.a((g.b.c<? super R>) call);
                                                    if (!compareAndSet(1, 0)) {
                                                        this.n.a(this.j.a());
                                                        return;
                                                    }
                                                }
                                            } else {
                                                this.k = true;
                                                e<R> eVar = this.f4821a;
                                                eVar.b(new g(call, eVar));
                                            }
                                        } catch (Throwable th) {
                                            d.c.d0.a.b(th);
                                            this.f4825e.cancel();
                                            this.j.a(th);
                                            this.n.a(this.j.a());
                                            return;
                                        }
                                    } else {
                                        this.k = true;
                                        bVar.a(this.f4821a);
                                    }
                                } catch (Throwable th2) {
                                    d.c.d0.a.b(th2);
                                    this.f4825e.cancel();
                                    this.j.a(th2);
                                    this.n.a(this.j.a());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            d.c.d0.a.b(th3);
                            this.f4825e.cancel();
                            this.j.a(th3);
                            this.n.a(this.j.a());
                            return;
                        }
                    }
                    if (this.o.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.b.d
        public void cancel() {
            if (this.f4829i) {
                return;
            }
            this.f4829i = true;
            this.f4821a.cancel();
            this.f4825e.cancel();
        }

        @Override // d.c.f0.e.b.c.b
        public void d() {
            this.n.a((g.b.d) this);
        }

        @Override // d.c.f0.e.b.c.f
        public void b(Throwable th) {
            if (this.j.a(th)) {
                this.f4825e.cancel();
                if (getAndIncrement() == 0) {
                    this.n.a(this.j.a());
                    return;
                }
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // g.b.d
        public void a(long j) {
            this.f4821a.a(j);
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* loaded from: classes.dex */
    public static abstract class b<T, R> extends AtomicInteger implements d.c.k<T>, f<R>, g.b.d {

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends g.b.b<? extends R>> f4822b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4823c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4824d;

        /* renamed from: e  reason: collision with root package name */
        public g.b.d f4825e;

        /* renamed from: f  reason: collision with root package name */
        public int f4826f;

        /* renamed from: g  reason: collision with root package name */
        public d.c.f0.c.n<T> f4827g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f4828h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f4829i;
        public volatile boolean k;
        public int m;

        /* renamed from: a  reason: collision with root package name */
        public final e<R> f4821a = new e<>(this);
        public final d.c.f0.j.b j = new d.c.f0.j.b();

        public b(d.c.e0.n<? super T, ? extends g.b.b<? extends R>> nVar, int i2) {
            this.f4822b = nVar;
            this.f4823c = i2;
            this.f4824d = i2 - (i2 >> 2);
        }

        @Override // g.b.c
        public final void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4825e, dVar)) {
                this.f4825e = dVar;
                if (dVar instanceof d.c.f0.c.k) {
                    d.c.f0.c.k kVar = (d.c.f0.c.k) dVar;
                    int a2 = kVar.a(3);
                    if (a2 == 1) {
                        this.m = a2;
                        this.f4827g = kVar;
                        this.f4828h = true;
                        d();
                        c();
                        return;
                    } else if (a2 == 2) {
                        this.m = a2;
                        this.f4827g = kVar;
                        d();
                        dVar.a(this.f4823c);
                        return;
                    }
                }
                this.f4827g = new d.c.f0.f.a(this.f4823c);
                d();
                dVar.a(this.f4823c);
            }
        }

        @Override // d.c.f0.e.b.c.f
        public final void b() {
            this.k = false;
            c();
        }

        public abstract void c();

        public abstract void d();

        @Override // g.b.c
        public final void a(T t) {
            if (this.m != 2 && !this.f4827g.offer(t)) {
                this.f4825e.cancel();
                a((Throwable) new IllegalStateException("Queue full?!"));
                return;
            }
            c();
        }

        @Override // g.b.c
        public final void a() {
            this.f4828h = true;
            c();
        }
    }
}
