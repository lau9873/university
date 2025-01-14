package p136d.p153c.p160f0.p165e.p169d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.ObservableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p161a.SequentialDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.QueueDisposable;
import p136d.p153c.p160f0.p163c.SimpleQueue;
import p136d.p153c.p160f0.p171f.SpscLinkedArrayQueue;
import p136d.p153c.p160f0.p175j.AtomicThrowable;
import p136d.p153c.p160f0.p175j.ErrorMode;
import p136d.p153c.p176g0.SerializedObserver;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.d.b */
/* loaded from: classes.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: b */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f7280b;

    /* renamed from: c */
    public final int f7281c;

    /* renamed from: d */
    public final ErrorMode f7282d;

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i, ErrorMode errorMode) {
        super(observableSource);
        this.f7280b = function;
        this.f7282d = errorMode;
        this.f7281c = Math.max(8, i);
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super U> interfaceC1730s) {
        if (ObservableScalarXMap.m3514a(this.f7279a, interfaceC1730s, this.f7280b)) {
            return;
        }
        ErrorMode errorMode = this.f7282d;
        if (errorMode == ErrorMode.IMMEDIATE) {
            this.f7279a.mo3294a(new C1637b(new SerializedObserver(interfaceC1730s), this.f7280b, this.f7281c));
        } else {
            this.f7279a.mo3294a(new C1635a(interfaceC1730s, this.f7280b, this.f7281c, errorMode == ErrorMode.END));
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: d.c.f0.e.d.b$b */
    /* loaded from: classes.dex */
    public static final class C1637b<T, U> extends AtomicInteger implements InterfaceC1730s<T>, Disposable {

        /* renamed from: a */
        public final InterfaceC1730s<? super U> f7298a;

        /* renamed from: b */
        public final SequentialDisposable f7299b = new SequentialDisposable();

        /* renamed from: c */
        public final Function<? super T, ? extends ObservableSource<? extends U>> f7300c;

        /* renamed from: d */
        public final InterfaceC1730s<U> f7301d;

        /* renamed from: e */
        public final int f7302e;

        /* renamed from: f */
        public SimpleQueue<T> f7303f;

        /* renamed from: g */
        public Disposable f7304g;

        /* renamed from: h */
        public volatile boolean f7305h;

        /* renamed from: i */
        public volatile boolean f7306i;

        /* renamed from: j */
        public volatile boolean f7307j;

        /* renamed from: k */
        public int f7308k;

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: d.c.f0.e.d.b$b$a */
        /* loaded from: classes.dex */
        public static final class C1638a<U> implements InterfaceC1730s<U> {

            /* renamed from: a */
            public final InterfaceC1730s<? super U> f7309a;

            /* renamed from: b */
            public final C1637b<?, ?> f7310b;

            public C1638a(InterfaceC1730s<? super U> interfaceC1730s, C1637b<?, ?> c1637b) {
                this.f7309a = interfaceC1730s;
                this.f7310b = c1637b;
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo572a(Disposable disposable) {
                this.f7310b.m3531b(disposable);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo570a(U u) {
                this.f7309a.mo570a((InterfaceC1730s<? super U>) u);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo569a(Throwable th) {
                this.f7310b.mo578b();
                this.f7309a.mo569a(th);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo573a() {
                this.f7310b.m3529e();
            }
        }

        public C1637b(InterfaceC1730s<? super U> interfaceC1730s, Function<? super T, ? extends ObservableSource<? extends U>> function, int i) {
            this.f7298a = interfaceC1730s;
            this.f7300c = function;
            this.f7302e = i;
            this.f7301d = new C1638a(interfaceC1730s, this);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7304g, disposable)) {
                this.f7304g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int mo3356a = queueDisposable.mo3356a(3);
                    if (mo3356a == 1) {
                        this.f7308k = mo3356a;
                        this.f7303f = queueDisposable;
                        this.f7307j = true;
                        this.f7298a.mo572a((Disposable) this);
                        m3530d();
                        return;
                    } else if (mo3356a == 2) {
                        this.f7308k = mo3356a;
                        this.f7303f = queueDisposable;
                        this.f7298a.mo572a((Disposable) this);
                        return;
                    }
                }
                this.f7303f = new SpscLinkedArrayQueue(this.f7302e);
                this.f7298a.mo572a((Disposable) this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7306i = true;
            this.f7299b.mo578b();
            this.f7304g.mo578b();
            if (getAndIncrement() == 0) {
                this.f7303f.clear();
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7306i;
        }

        /* renamed from: d */
        public void m3530d() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f7306i) {
                if (!this.f7305h) {
                    boolean z = this.f7307j;
                    try {
                        T poll = this.f7303f.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.f7298a.mo573a();
                            return;
                        } else if (!z2) {
                            try {
                                ObservableSource<? extends U> mo3490a = this.f7300c.mo3490a(poll);
                                ObjectHelper.m3598a(mo3490a, "The mapper returned a null ObservableSource");
                                ObservableSource<? extends U> observableSource = mo3490a;
                                this.f7305h = true;
                                observableSource.mo3294a(this.f7301d);
                            } catch (Throwable th) {
                                Exceptions.m3660b(th);
                                mo578b();
                                this.f7303f.clear();
                                this.f7298a.mo569a(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.m3660b(th2);
                        mo578b();
                        this.f7303f.clear();
                        this.f7298a.mo569a(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f7303f.clear();
        }

        /* renamed from: e */
        public void m3529e() {
            this.f7305h = false;
            m3530d();
        }

        /* renamed from: b */
        public void m3531b(Disposable disposable) {
            this.f7299b.m3631b(disposable);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
            if (this.f7307j) {
                return;
            }
            if (this.f7308k == 0) {
                this.f7303f.offer(t);
            }
            m3530d();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            if (this.f7307j) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7307j = true;
            mo578b();
            this.f7298a.mo569a(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            if (this.f7307j) {
                return;
            }
            this.f7307j = true;
            m3530d();
        }
    }

    /* compiled from: ObservableConcatMap.java */
    /* renamed from: d.c.f0.e.d.b$a */
    /* loaded from: classes.dex */
    public static final class C1635a<T, R> extends AtomicInteger implements InterfaceC1730s<T>, Disposable {

        /* renamed from: a */
        public final InterfaceC1730s<? super R> f7283a;

        /* renamed from: b */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f7284b;

        /* renamed from: c */
        public final int f7285c;

        /* renamed from: e */
        public final C1636a<R> f7287e;

        /* renamed from: g */
        public final boolean f7289g;

        /* renamed from: h */
        public SimpleQueue<T> f7290h;

        /* renamed from: i */
        public Disposable f7291i;

        /* renamed from: j */
        public volatile boolean f7292j;

        /* renamed from: k */
        public volatile boolean f7293k;

        /* renamed from: m */
        public volatile boolean f7294m;

        /* renamed from: n */
        public int f7295n;

        /* renamed from: d */
        public final AtomicThrowable f7286d = new AtomicThrowable();

        /* renamed from: f */
        public final SequentialDisposable f7288f = new SequentialDisposable();

        /* compiled from: ObservableConcatMap.java */
        /* renamed from: d.c.f0.e.d.b$a$a */
        /* loaded from: classes.dex */
        public static final class C1636a<R> implements InterfaceC1730s<R> {

            /* renamed from: a */
            public final InterfaceC1730s<? super R> f7296a;

            /* renamed from: b */
            public final C1635a<?, R> f7297b;

            public C1636a(InterfaceC1730s<? super R> interfaceC1730s, C1635a<?, R> c1635a) {
                this.f7296a = interfaceC1730s;
                this.f7297b = c1635a;
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo572a(Disposable disposable) {
                this.f7297b.f7288f.m3632a(disposable);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo570a(R r) {
                this.f7296a.mo570a((InterfaceC1730s<? super R>) r);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo569a(Throwable th) {
                C1635a<?, R> c1635a = this.f7297b;
                if (c1635a.f7286d.m3418a(th)) {
                    if (!c1635a.f7289g) {
                        c1635a.f7291i.mo578b();
                    }
                    c1635a.f7292j = false;
                    c1635a.m3532d();
                    return;
                }
                RxJavaPlugins.m3371b(th);
            }

            @Override // p136d.p153c.InterfaceC1730s
            /* renamed from: a */
            public void mo573a() {
                C1635a<?, R> c1635a = this.f7297b;
                c1635a.f7292j = false;
                c1635a.m3532d();
            }
        }

        public C1635a(InterfaceC1730s<? super R> interfaceC1730s, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
            this.f7283a = interfaceC1730s;
            this.f7284b = function;
            this.f7285c = i;
            this.f7289g = z;
            this.f7287e = new C1636a<>(interfaceC1730s, this);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7291i, disposable)) {
                this.f7291i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int mo3356a = queueDisposable.mo3356a(3);
                    if (mo3356a == 1) {
                        this.f7295n = mo3356a;
                        this.f7290h = queueDisposable;
                        this.f7293k = true;
                        this.f7283a.mo572a((Disposable) this);
                        m3532d();
                        return;
                    } else if (mo3356a == 2) {
                        this.f7295n = mo3356a;
                        this.f7290h = queueDisposable;
                        this.f7283a.mo572a((Disposable) this);
                        return;
                    }
                }
                this.f7290h = new SpscLinkedArrayQueue(this.f7285c);
                this.f7283a.mo572a((Disposable) this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7294m = true;
            this.f7291i.mo578b();
            this.f7288f.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7291i.mo577c();
        }

        /* renamed from: d */
        public void m3532d() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC1730s<? super R> interfaceC1730s = this.f7283a;
            SimpleQueue<T> simpleQueue = this.f7290h;
            AtomicThrowable atomicThrowable = this.f7286d;
            while (true) {
                if (!this.f7292j) {
                    if (this.f7294m) {
                        simpleQueue.clear();
                        return;
                    } else if (!this.f7289g && atomicThrowable.get() != null) {
                        simpleQueue.clear();
                        interfaceC1730s.mo569a(atomicThrowable.m3419a());
                        return;
                    } else {
                        boolean z = this.f7293k;
                        try {
                            T poll = simpleQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable m3419a = atomicThrowable.m3419a();
                                if (m3419a != null) {
                                    interfaceC1730s.mo569a(m3419a);
                                    return;
                                } else {
                                    interfaceC1730s.mo573a();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    ObservableSource<? extends R> mo3490a = this.f7284b.mo3490a(poll);
                                    ObjectHelper.m3598a(mo3490a, "The mapper returned a null ObservableSource");
                                    ObservableSource<? extends R> observableSource = mo3490a;
                                    if (observableSource instanceof Callable) {
                                        try {
                                            Object obj = (Object) ((Callable) observableSource).call();
                                            if (obj != 0 && !this.f7294m) {
                                                interfaceC1730s.mo570a((InterfaceC1730s<? super R>) obj);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.m3660b(th);
                                            atomicThrowable.m3418a(th);
                                        }
                                    } else {
                                        this.f7292j = true;
                                        observableSource.mo3294a(this.f7287e);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.m3660b(th2);
                                    this.f7291i.mo578b();
                                    simpleQueue.clear();
                                    atomicThrowable.m3418a(th2);
                                    interfaceC1730s.mo569a(atomicThrowable.m3419a());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.m3660b(th3);
                            this.f7291i.mo578b();
                            atomicThrowable.m3418a(th3);
                            interfaceC1730s.mo569a(atomicThrowable.m3419a());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
            if (this.f7295n == 0) {
                this.f7290h.offer(t);
            }
            m3532d();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            if (this.f7286d.m3418a(th)) {
                this.f7293k = true;
                m3532d();
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            this.f7293k = true;
            m3532d();
        }
    }
}
