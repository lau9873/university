package p136d.p153c.p160f0.p165e.p169d;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.ObservableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.QueueDisposable;
import p136d.p153c.p160f0.p163c.SimplePlainQueue;
import p136d.p153c.p160f0.p163c.SimpleQueue;
import p136d.p153c.p160f0.p171f.SpscArrayQueue;
import p136d.p153c.p160f0.p171f.SpscLinkedArrayQueue;
import p136d.p153c.p160f0.p175j.AtomicThrowable;
import p136d.p153c.p160f0.p175j.ExceptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.d.f */
/* loaded from: classes.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: b */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f7321b;

    /* renamed from: c */
    public final boolean f7322c;

    /* renamed from: d */
    public final int f7323d;

    /* renamed from: e */
    public final int f7324e;

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
        super(observableSource);
        this.f7321b = function;
        this.f7322c = z;
        this.f7323d = i;
        this.f7324e = i2;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super U> interfaceC1730s) {
        if (ObservableScalarXMap.m3514a(this.f7279a, interfaceC1730s, this.f7321b)) {
            return;
        }
        this.f7279a.mo3294a(new C1643b(interfaceC1730s, this.f7321b, this.f7322c, this.f7323d, this.f7324e));
    }

    /* compiled from: ObservableFlatMap.java */
    /* renamed from: d.c.f0.e.d.f$b */
    /* loaded from: classes.dex */
    public static final class C1643b<T, U> extends AtomicInteger implements Disposable, InterfaceC1730s<T> {

        /* renamed from: r */
        public static final C1642a<?, ?>[] f7330r = new C1642a[0];

        /* renamed from: s */
        public static final C1642a<?, ?>[] f7331s = new C1642a[0];

        /* renamed from: a */
        public final InterfaceC1730s<? super U> f7332a;

        /* renamed from: b */
        public final Function<? super T, ? extends ObservableSource<? extends U>> f7333b;

        /* renamed from: c */
        public final boolean f7334c;

        /* renamed from: d */
        public final int f7335d;

        /* renamed from: e */
        public final int f7336e;

        /* renamed from: f */
        public volatile SimplePlainQueue<U> f7337f;

        /* renamed from: g */
        public volatile boolean f7338g;

        /* renamed from: h */
        public final AtomicThrowable f7339h = new AtomicThrowable();

        /* renamed from: i */
        public volatile boolean f7340i;

        /* renamed from: j */
        public final AtomicReference<C1642a<?, ?>[]> f7341j;

        /* renamed from: k */
        public Disposable f7342k;

        /* renamed from: m */
        public long f7343m;

        /* renamed from: n */
        public long f7344n;

        /* renamed from: o */
        public int f7345o;

        /* renamed from: p */
        public Queue<ObservableSource<? extends U>> f7346p;

        /* renamed from: q */
        public int f7347q;

        public C1643b(InterfaceC1730s<? super U> interfaceC1730s, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
            this.f7332a = interfaceC1730s;
            this.f7333b = function;
            this.f7334c = z;
            this.f7335d = i;
            this.f7336e = i2;
            if (i != Integer.MAX_VALUE) {
                this.f7346p = new ArrayDeque(i);
            }
            this.f7341j = new AtomicReference<>(f7330r);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7342k, disposable)) {
                this.f7342k = disposable;
                this.f7332a.mo572a((Disposable) this);
            }
        }

        /* renamed from: b */
        public void m3522b(C1642a<T, U> c1642a) {
            C1642a<?, ?>[] c1642aArr;
            C1642a<?, ?>[] c1642aArr2;
            do {
                c1642aArr = this.f7341j.get();
                int length = c1642aArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (c1642aArr[i2] == c1642a) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    c1642aArr2 = f7330r;
                } else {
                    C1642a<?, ?>[] c1642aArr3 = new C1642a[length - 1];
                    System.arraycopy(c1642aArr, 0, c1642aArr3, 0, i);
                    System.arraycopy(c1642aArr, i + 1, c1642aArr3, i, (length - i) - 1);
                    c1642aArr2 = c1642aArr3;
                }
            } while (!this.f7341j.compareAndSet(c1642aArr, c1642aArr2));
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7340i;
        }

        /* renamed from: d */
        public boolean m3521d() {
            if (this.f7340i) {
                return true;
            }
            Throwable th = this.f7339h.get();
            if (this.f7334c || th == null) {
                return false;
            }
            m3520e();
            this.f7332a.mo569a(this.f7339h.m3419a());
            return true;
        }

        /* renamed from: e */
        public boolean m3520e() {
            C1642a<?, ?>[] andSet;
            this.f7342k.mo578b();
            C1642a<?, ?>[] c1642aArr = this.f7341j.get();
            C1642a<?, ?>[] c1642aArr2 = f7331s;
            if (c1642aArr == c1642aArr2 || (andSet = this.f7341j.getAndSet(c1642aArr2)) == f7331s) {
                return false;
            }
            for (C1642a<?, ?> c1642a : andSet) {
                c1642a.m3527b();
            }
            return true;
        }

        /* renamed from: f */
        public void m3519f() {
            if (getAndIncrement() == 0) {
                m3518g();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x00a6, code lost:
            if (r11 != null) goto L45;
         */
        /* renamed from: g */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m3518g() {
            /*
                Method dump skipped, instructions count: 290
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p136d.p153c.p160f0.p165e.p169d.ObservableFlatMap.C1643b.m3518g():void");
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
            if (this.f7338g) {
                return;
            }
            try {
                ObservableSource<? extends U> mo3490a = this.f7333b.mo3490a(t);
                ObjectHelper.m3598a(mo3490a, "The mapper returned a null ObservableSource");
                ObservableSource<? extends U> observableSource = mo3490a;
                if (this.f7335d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.f7347q == this.f7335d) {
                            this.f7346p.offer(observableSource);
                            return;
                        }
                        this.f7347q++;
                    }
                }
                m3525a((ObservableSource) observableSource);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7342k.mo578b();
                mo569a(th);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            Throwable m3419a;
            if (this.f7340i) {
                return;
            }
            this.f7340i = true;
            if (!m3520e() || (m3419a = this.f7339h.m3419a()) == null || m3419a == ExceptionHelper.f7711a) {
                return;
            }
            RxJavaPlugins.m3371b(m3419a);
        }

        /* renamed from: a */
        public void m3525a(ObservableSource<? extends U> observableSource) {
            while (observableSource instanceof Callable) {
                m3523a((Callable) ((Callable) observableSource));
                if (this.f7335d == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    observableSource = this.f7346p.poll();
                    if (observableSource == null) {
                        this.f7347q--;
                        return;
                    }
                }
            }
            long j = this.f7343m;
            this.f7343m = 1 + j;
            C1642a<T, U> c1642a = new C1642a<>(this, j);
            if (m3526a((C1642a) c1642a)) {
                observableSource.mo3294a(c1642a);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public boolean m3526a(C1642a<T, U> c1642a) {
            C1642a<?, ?>[] c1642aArr;
            C1642a[] c1642aArr2;
            do {
                c1642aArr = this.f7341j.get();
                if (c1642aArr == f7331s) {
                    c1642a.m3527b();
                    return false;
                }
                int length = c1642aArr.length;
                c1642aArr2 = new C1642a[length + 1];
                System.arraycopy(c1642aArr, 0, c1642aArr2, 0, length);
                c1642aArr2[length] = c1642a;
            } while (!this.f7341j.compareAndSet(c1642aArr, c1642aArr2));
            return true;
        }

        /* renamed from: a */
        public void m3523a(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f7332a.mo570a((InterfaceC1730s<? super U>) call);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    SimplePlainQueue<U> simplePlainQueue = this.f7337f;
                    if (simplePlainQueue == null) {
                        int i = this.f7335d;
                        if (i == Integer.MAX_VALUE) {
                            simplePlainQueue = new SpscLinkedArrayQueue<>(this.f7336e);
                        } else {
                            simplePlainQueue = new SpscArrayQueue(i);
                        }
                        this.f7337f = simplePlainQueue;
                    }
                    if (!simplePlainQueue.offer(call)) {
                        mo569a((Throwable) new IllegalStateException("Scalar queue full?!"));
                        return;
                    } else if (getAndIncrement() != 0) {
                        return;
                    }
                }
                m3518g();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7339h.m3418a(th);
                m3519f();
            }
        }

        /* renamed from: a */
        public void m3524a(U u, C1642a<T, U> c1642a) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f7332a.mo570a((InterfaceC1730s<? super U>) u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue = c1642a.f7328d;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.f7336e);
                    c1642a.f7328d = simpleQueue;
                }
                simpleQueue.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            m3518g();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            if (this.f7338g) {
                RxJavaPlugins.m3371b(th);
            } else if (this.f7339h.m3418a(th)) {
                this.f7338g = true;
                m3519f();
            } else {
                RxJavaPlugins.m3371b(th);
            }
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            if (this.f7338g) {
                return;
            }
            this.f7338g = true;
            m3519f();
        }
    }

    /* compiled from: ObservableFlatMap.java */
    /* renamed from: d.c.f0.e.d.f$a */
    /* loaded from: classes.dex */
    public static final class C1642a<T, U> extends AtomicReference<Disposable> implements InterfaceC1730s<U> {

        /* renamed from: a */
        public final long f7325a;

        /* renamed from: b */
        public final C1643b<T, U> f7326b;

        /* renamed from: c */
        public volatile boolean f7327c;

        /* renamed from: d */
        public volatile SimpleQueue<U> f7328d;

        /* renamed from: e */
        public int f7329e;

        public C1642a(C1643b<T, U> c1643b, long j) {
            this.f7325a = j;
            this.f7326b = c1643b;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            if (DisposableHelper.m3644c(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int mo3356a = queueDisposable.mo3356a(7);
                if (mo3356a == 1) {
                    this.f7329e = mo3356a;
                    this.f7328d = queueDisposable;
                    this.f7327c = true;
                    this.f7326b.m3519f();
                } else if (mo3356a == 2) {
                    this.f7329e = mo3356a;
                    this.f7328d = queueDisposable;
                }
            }
        }

        /* renamed from: b */
        public void m3527b() {
            DisposableHelper.m3647a(this);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(U u) {
            if (this.f7329e == 0) {
                this.f7326b.m3524a(u, this);
            } else {
                this.f7326b.m3519f();
            }
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            if (this.f7326b.f7339h.m3418a(th)) {
                C1643b<T, U> c1643b = this.f7326b;
                if (!c1643b.f7334c) {
                    c1643b.m3520e();
                }
                this.f7327c = true;
                this.f7326b.m3519f();
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            this.f7327c = true;
            this.f7326b.m3519f();
        }
    }
}
