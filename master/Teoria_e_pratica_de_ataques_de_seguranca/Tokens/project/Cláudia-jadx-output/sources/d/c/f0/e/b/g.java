package d.c.f0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: FlowableFlatMap.java */
/* loaded from: classes.dex */
public final class g<T, U> extends d.c.f0.e.b.a<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends g.b.b<? extends U>> f4848c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f4849d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4850e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4851f;

    public g(d.c.j<T> jVar, d.c.e0.n<? super T, ? extends g.b.b<? extends U>> nVar, boolean z, int i2, int i3) {
        super(jVar);
        this.f4848c = nVar;
        this.f4849d = z;
        this.f4850e = i2;
        this.f4851f = i3;
    }

    public static <T, U> d.c.k<T> a(g.b.c<? super U> cVar, d.c.e0.n<? super T, ? extends g.b.b<? extends U>> nVar, boolean z, int i2, int i3) {
        return new b(cVar, nVar, z, i2, i3);
    }

    @Override // d.c.j
    public void b(g.b.c<? super U> cVar) {
        if (y.a(this.f4795b, cVar, this.f4848c)) {
            return;
        }
        this.f4795b.a((d.c.k) a(cVar, this.f4848c, this.f4849d, this.f4850e, this.f4851f));
    }

    /* compiled from: FlowableFlatMap.java */
    /* loaded from: classes.dex */
    public static final class b<T, U> extends AtomicInteger implements d.c.k<T>, g.b.d {
        public static final a<?, ?>[] s = new a[0];
        public static final a<?, ?>[] t = new a[0];

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super U> f4860a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends g.b.b<? extends U>> f4861b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4862c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4863d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4864e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.c.f0.c.m<U> f4865f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f4866g;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f4868i;
        public g.b.d m;
        public long n;
        public long o;
        public int p;
        public int q;
        public final int r;

        /* renamed from: h  reason: collision with root package name */
        public final d.c.f0.j.b f4867h = new d.c.f0.j.b();
        public final AtomicReference<a<?, ?>[]> j = new AtomicReference<>();
        public final AtomicLong k = new AtomicLong();

        public b(g.b.c<? super U> cVar, d.c.e0.n<? super T, ? extends g.b.b<? extends U>> nVar, boolean z, int i2, int i3) {
            this.f4860a = cVar;
            this.f4861b = nVar;
            this.f4862c = z;
            this.f4863d = i2;
            this.f4864e = i3;
            this.r = Math.max(1, i2 >> 1);
            this.j.lazySet(s);
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.m, dVar)) {
                this.m = dVar;
                this.f4860a.a((g.b.d) this);
                if (this.f4868i) {
                    return;
                }
                int i2 = this.f4863d;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.a(Long.MAX_VALUE);
                } else {
                    dVar.a(i2);
                }
            }
        }

        public void b(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.k.get();
                d.c.f0.c.n<U> nVar = this.f4865f;
                if (j != 0 && (nVar == null || nVar.isEmpty())) {
                    this.f4860a.a((g.b.c<? super U>) u);
                    if (j != Long.MAX_VALUE) {
                        this.k.decrementAndGet();
                    }
                    if (this.f4863d != Integer.MAX_VALUE && !this.f4868i) {
                        int i2 = this.q + 1;
                        this.q = i2;
                        int i3 = this.r;
                        if (i2 == i3) {
                            this.q = 0;
                            this.m.a(i3);
                        }
                    }
                } else {
                    if (nVar == null) {
                        nVar = g();
                    }
                    if (!nVar.offer(u)) {
                        a((Throwable) new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!g().offer(u)) {
                a((Throwable) new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            f();
        }

        public void c(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.j.get();
                if (aVarArr == t || aVarArr == s) {
                    return;
                }
                int length = aVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = s;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.j.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // g.b.d
        public void cancel() {
            d.c.f0.c.m<U> mVar;
            if (this.f4868i) {
                return;
            }
            this.f4868i = true;
            this.m.cancel();
            d();
            if (getAndIncrement() != 0 || (mVar = this.f4865f) == null) {
                return;
            }
            mVar.clear();
        }

        public void d() {
            a<?, ?>[] andSet;
            a<?, ?>[] aVarArr = this.j.get();
            a<?, ?>[] aVarArr2 = t;
            if (aVarArr == aVarArr2 || (andSet = this.j.getAndSet(aVarArr2)) == t) {
                return;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.b();
            }
            Throwable a2 = this.f4867h.a();
            if (a2 == null || a2 == d.c.f0.j.f.f5375a) {
                return;
            }
            d.c.h0.a.b(a2);
        }

        public void e() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:118:0x0188, code lost:
            r24.p = r4;
            r24.o = r11[r4].f4852a;
            r3 = r16;
            r5 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x012b, code lost:
            if (r8 == r14) goto L124;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x012d, code lost:
            if (r10 != false) goto L123;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x012f, code lost:
            r5 = r24.k.addAndGet(-r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0137, code lost:
            r5 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x013c, code lost:
            r7.a(r8);
            r8 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0142, code lost:
            r8 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0145, code lost:
            if (r5 == r8) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0147, code lost:
            if (r22 != null) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x014a, code lost:
            r8 = r11;
            r9 = r13;
            r11 = r22;
            r14 = 0;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void f() {
            /*
                Method dump skipped, instructions count: 440
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: d.c.f0.e.b.g.b.f():void");
        }

        public d.c.f0.c.n<U> g() {
            d.c.f0.c.m<U> mVar = this.f4865f;
            if (mVar == null) {
                int i2 = this.f4863d;
                if (i2 == Integer.MAX_VALUE) {
                    mVar = new d.c.f0.f.b<>(this.f4864e);
                } else {
                    mVar = new d.c.f0.f.a(i2);
                }
                this.f4865f = mVar;
            }
            return mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.b.c
        public void a(T t2) {
            if (this.f4866g) {
                return;
            }
            try {
                g.b.b<? extends U> a2 = this.f4861b.a(t2);
                d.c.f0.b.b.a(a2, "The mapper returned a null Publisher");
                g.b.b<? extends U> bVar = a2;
                if (bVar instanceof Callable) {
                    try {
                        Object call = ((Callable) bVar).call();
                        if (call != null) {
                            b((b<T, U>) call);
                            return;
                        } else if (this.f4863d == Integer.MAX_VALUE || this.f4868i) {
                            return;
                        } else {
                            int i2 = this.q + 1;
                            this.q = i2;
                            int i3 = this.r;
                            if (i2 == i3) {
                                this.q = 0;
                                this.m.a(i3);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        d.c.d0.a.b(th);
                        this.f4867h.a(th);
                        e();
                        return;
                    }
                }
                long j = this.n;
                this.n = 1 + j;
                a aVar = new a(this, j);
                if (a(aVar)) {
                    bVar.a(aVar);
                }
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                this.m.cancel();
                a(th2);
            }
        }

        public void c() {
            d.c.f0.c.m<U> mVar = this.f4865f;
            if (mVar != null) {
                mVar.clear();
            }
        }

        public d.c.f0.c.n<U> b(a<T, U> aVar) {
            d.c.f0.c.n<U> nVar = aVar.f4857f;
            if (nVar == null) {
                d.c.f0.f.a aVar2 = new d.c.f0.f.a(this.f4864e);
                aVar.f4857f = aVar2;
                return aVar2;
            }
            return nVar;
        }

        public boolean b() {
            if (this.f4868i) {
                c();
                return true;
            } else if (this.f4862c || this.f4867h.get() == null) {
                return false;
            } else {
                c();
                this.f4860a.a(this.f4867h.a());
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.j.get();
                if (aVarArr == t) {
                    aVar.b();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.j.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        public void a(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.k.get();
                d.c.f0.c.n<U> nVar = aVar.f4857f;
                if (j != 0 && (nVar == null || nVar.isEmpty())) {
                    this.f4860a.a((g.b.c<? super U>) u);
                    if (j != Long.MAX_VALUE) {
                        this.k.decrementAndGet();
                    }
                    aVar.a(1L);
                } else {
                    if (nVar == null) {
                        nVar = b((a) aVar);
                    }
                    if (!nVar.offer(u)) {
                        a((Throwable) new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                d.c.f0.c.n nVar2 = aVar.f4857f;
                if (nVar2 == null) {
                    nVar2 = new d.c.f0.f.a(this.f4864e);
                    aVar.f4857f = nVar2;
                }
                if (!nVar2.offer(u)) {
                    a((Throwable) new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            f();
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f4866g) {
                d.c.h0.a.b(th);
            } else if (this.f4867h.a(th)) {
                this.f4866g = true;
                e();
            } else {
                d.c.h0.a.b(th);
            }
        }

        @Override // g.b.c
        public void a() {
            if (this.f4866g) {
                return;
            }
            this.f4866g = true;
            e();
        }

        @Override // g.b.d
        public void a(long j) {
            if (d.c.f0.i.g.c(j)) {
                d.c.f0.j.c.a(this.k, j);
                e();
            }
        }

        public void a(a<T, U> aVar, Throwable th) {
            if (this.f4867h.a(th)) {
                aVar.f4856e = true;
                if (!this.f4862c) {
                    this.m.cancel();
                    for (a<?, ?> aVar2 : this.j.getAndSet(t)) {
                        aVar2.b();
                    }
                }
                e();
                return;
            }
            d.c.h0.a.b(th);
        }
    }

    /* compiled from: FlowableFlatMap.java */
    /* loaded from: classes.dex */
    public static final class a<T, U> extends AtomicReference<g.b.d> implements d.c.k<U>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final long f4852a;

        /* renamed from: b  reason: collision with root package name */
        public final b<T, U> f4853b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4854c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4855d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f4856e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.c.f0.c.n<U> f4857f;

        /* renamed from: g  reason: collision with root package name */
        public long f4858g;

        /* renamed from: h  reason: collision with root package name */
        public int f4859h;

        public a(b<T, U> bVar, long j) {
            this.f4852a = j;
            this.f4853b = bVar;
            this.f4855d = bVar.f4864e;
            this.f4854c = this.f4855d >> 2;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this, dVar)) {
                if (dVar instanceof d.c.f0.c.k) {
                    d.c.f0.c.k kVar = (d.c.f0.c.k) dVar;
                    int a2 = kVar.a(7);
                    if (a2 == 1) {
                        this.f4859h = a2;
                        this.f4857f = kVar;
                        this.f4856e = true;
                        this.f4853b.e();
                        return;
                    } else if (a2 == 2) {
                        this.f4859h = a2;
                        this.f4857f = kVar;
                    }
                }
                dVar.a(this.f4855d);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.i.g.a(this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return get() == d.c.f0.i.g.CANCELLED;
        }

        @Override // g.b.c
        public void a(U u) {
            if (this.f4859h != 2) {
                this.f4853b.a((b<T, U>) u, (a<T, b<T, U>>) this);
            } else {
                this.f4853b.e();
            }
        }

        @Override // g.b.c
        public void a(Throwable th) {
            lazySet(d.c.f0.i.g.CANCELLED);
            this.f4853b.a(this, th);
        }

        @Override // g.b.c
        public void a() {
            this.f4856e = true;
            this.f4853b.e();
        }

        public void a(long j) {
            if (this.f4859h != 1) {
                long j2 = this.f4858g + j;
                if (j2 >= this.f4854c) {
                    this.f4858g = 0L;
                    get().a(j2);
                    return;
                }
                this.f4858g = j2;
            }
        }
    }
}
