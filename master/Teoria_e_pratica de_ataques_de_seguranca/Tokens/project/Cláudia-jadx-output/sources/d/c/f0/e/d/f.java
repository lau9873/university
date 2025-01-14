package d.c.f0.e.d;

import d.c.r;
import d.c.s;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableFlatMap.java */
/* loaded from: classes.dex */
public final class f<T, U> extends d.c.f0.e.d.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends r<? extends U>> f4995b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4996c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4997d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4998e;

    public f(r<T> rVar, d.c.e0.n<? super T, ? extends r<? extends U>> nVar, boolean z, int i2, int i3) {
        super(rVar);
        this.f4995b = nVar;
        this.f4996c = z;
        this.f4997d = i2;
        this.f4998e = i3;
    }

    @Override // d.c.o
    public void b(s<? super U> sVar) {
        if (m.a(this.f4959a, sVar, this.f4995b)) {
            return;
        }
        this.f4959a.a(new b(sVar, this.f4995b, this.f4996c, this.f4997d, this.f4998e));
    }

    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes.dex */
    public static final class b<T, U> extends AtomicInteger implements d.c.c0.b, s<T> {
        public static final a<?, ?>[] r = new a[0];
        public static final a<?, ?>[] s = new a[0];

        /* renamed from: a  reason: collision with root package name */
        public final s<? super U> f5004a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends r<? extends U>> f5005b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5006c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5007d;

        /* renamed from: e  reason: collision with root package name */
        public final int f5008e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.c.f0.c.m<U> f5009f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f5010g;

        /* renamed from: h  reason: collision with root package name */
        public final d.c.f0.j.b f5011h = new d.c.f0.j.b();

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f5012i;
        public final AtomicReference<a<?, ?>[]> j;
        public d.c.c0.b k;
        public long m;
        public long n;
        public int o;
        public Queue<r<? extends U>> p;
        public int q;

        public b(s<? super U> sVar, d.c.e0.n<? super T, ? extends r<? extends U>> nVar, boolean z, int i2, int i3) {
            this.f5004a = sVar;
            this.f5005b = nVar;
            this.f5006c = z;
            this.f5007d = i2;
            this.f5008e = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.p = new ArrayDeque(i2);
            }
            this.j = new AtomicReference<>(r);
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.k, bVar)) {
                this.k = bVar;
                this.f5004a.a((d.c.c0.b) this);
            }
        }

        public void b(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.j.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
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
                    aVarArr2 = r;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.j.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5012i;
        }

        public boolean d() {
            if (this.f5012i) {
                return true;
            }
            Throwable th = this.f5011h.get();
            if (this.f5006c || th == null) {
                return false;
            }
            e();
            this.f5004a.a(this.f5011h.a());
            return true;
        }

        public boolean e() {
            a<?, ?>[] andSet;
            this.k.b();
            a<?, ?>[] aVarArr = this.j.get();
            a<?, ?>[] aVarArr2 = s;
            if (aVarArr == aVarArr2 || (andSet = this.j.getAndSet(aVarArr2)) == s) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.b();
            }
            return true;
        }

        public void f() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x00a6, code lost:
            if (r11 != null) goto L45;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void g() {
            /*
                Method dump skipped, instructions count: 290
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: d.c.f0.e.d.f.b.g():void");
        }

        @Override // d.c.s
        public void a(T t) {
            if (this.f5010g) {
                return;
            }
            try {
                r<? extends U> a2 = this.f5005b.a(t);
                d.c.f0.b.b.a(a2, "The mapper returned a null ObservableSource");
                r<? extends U> rVar = a2;
                if (this.f5007d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.q == this.f5007d) {
                            this.p.offer(rVar);
                            return;
                        }
                        this.q++;
                    }
                }
                a((r) rVar);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.k.b();
                a(th);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            Throwable a2;
            if (this.f5012i) {
                return;
            }
            this.f5012i = true;
            if (!e() || (a2 = this.f5011h.a()) == null || a2 == d.c.f0.j.f.f5375a) {
                return;
            }
            d.c.h0.a.b(a2);
        }

        public void a(r<? extends U> rVar) {
            while (rVar instanceof Callable) {
                a((Callable) ((Callable) rVar));
                if (this.f5007d == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    rVar = this.p.poll();
                    if (rVar == null) {
                        this.q--;
                        return;
                    }
                }
            }
            long j = this.m;
            this.m = 1 + j;
            a<T, U> aVar = new a<>(this, j);
            if (a((a) aVar)) {
                rVar.a(aVar);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.j.get();
                if (aVarArr == s) {
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

        public void a(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f5004a.a((s<? super U>) call);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    d.c.f0.c.m<U> mVar = this.f5009f;
                    if (mVar == null) {
                        int i2 = this.f5007d;
                        if (i2 == Integer.MAX_VALUE) {
                            mVar = new d.c.f0.f.b<>(this.f5008e);
                        } else {
                            mVar = new d.c.f0.f.a(i2);
                        }
                        this.f5009f = mVar;
                    }
                    if (!mVar.offer(call)) {
                        a((Throwable) new IllegalStateException("Scalar queue full?!"));
                        return;
                    } else if (getAndIncrement() != 0) {
                        return;
                    }
                }
                g();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f5011h.a(th);
                f();
            }
        }

        public void a(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f5004a.a((s<? super U>) u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                d.c.f0.c.n nVar = aVar.f5002d;
                if (nVar == null) {
                    nVar = new d.c.f0.f.b(this.f5008e);
                    aVar.f5002d = nVar;
                }
                nVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            g();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            if (this.f5010g) {
                d.c.h0.a.b(th);
            } else if (this.f5011h.a(th)) {
                this.f5010g = true;
                f();
            } else {
                d.c.h0.a.b(th);
            }
        }

        @Override // d.c.s
        public void a() {
            if (this.f5010g) {
                return;
            }
            this.f5010g = true;
            f();
        }
    }

    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes.dex */
    public static final class a<T, U> extends AtomicReference<d.c.c0.b> implements s<U> {

        /* renamed from: a  reason: collision with root package name */
        public final long f4999a;

        /* renamed from: b  reason: collision with root package name */
        public final b<T, U> f5000b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f5001c;

        /* renamed from: d  reason: collision with root package name */
        public volatile d.c.f0.c.n<U> f5002d;

        /* renamed from: e  reason: collision with root package name */
        public int f5003e;

        public a(b<T, U> bVar, long j) {
            this.f4999a = j;
            this.f5000b = bVar;
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.c(this, bVar) && (bVar instanceof d.c.f0.c.i)) {
                d.c.f0.c.i iVar = (d.c.f0.c.i) bVar;
                int a2 = iVar.a(7);
                if (a2 == 1) {
                    this.f5003e = a2;
                    this.f5002d = iVar;
                    this.f5001c = true;
                    this.f5000b.f();
                } else if (a2 == 2) {
                    this.f5003e = a2;
                    this.f5002d = iVar;
                }
            }
        }

        public void b() {
            d.c.f0.a.b.a(this);
        }

        @Override // d.c.s
        public void a(U u) {
            if (this.f5003e == 0) {
                this.f5000b.a(u, this);
            } else {
                this.f5000b.f();
            }
        }

        @Override // d.c.s
        public void a(Throwable th) {
            if (this.f5000b.f5011h.a(th)) {
                b<T, U> bVar = this.f5000b;
                if (!bVar.f5006c) {
                    bVar.e();
                }
                this.f5001c = true;
                this.f5000b.f();
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // d.c.s
        public void a() {
            this.f5001c = true;
            this.f5000b.f();
        }
    }
}
