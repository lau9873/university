package p136d.p153c.p160f0.p165e.p169d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.ObservableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.QueueDisposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.d.m */
/* loaded from: classes.dex */
public final class ObservableScalarXMap {

    /* compiled from: ObservableScalarXMap.java */
    /* renamed from: d.c.f0.e.d.m$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1648a<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {

        /* renamed from: a */
        public final InterfaceC1730s<? super T> f7367a;

        /* renamed from: b */
        public final T f7368b;

        public RunnableC1648a(InterfaceC1730s<? super T> interfaceC1730s, T t) {
            this.f7367a = interfaceC1730s;
            this.f7368b = t;
        }

        @Override // p136d.p153c.p160f0.p163c.QueueFuseable
        /* renamed from: a */
        public int mo3356a(int i) {
            if ((i & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            set(3);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return get() == 3;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public void clear() {
            lazySet(3);
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public T poll() {
            if (get() == 1) {
                lazySet(3);
                return this.f7368b;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f7367a.mo570a((InterfaceC1730s<? super T>) ((T) this.f7368b));
                if (get() == 2) {
                    lazySet(3);
                    this.f7367a.mo573a();
                }
            }
        }
    }

    /* compiled from: ObservableScalarXMap.java */
    /* renamed from: d.c.f0.e.d.m$b */
    /* loaded from: classes.dex */
    public static final class C1649b<T, R> extends Observable<R> {

        /* renamed from: a */
        public final T f7369a;

        /* renamed from: b */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f7370b;

        public C1649b(T t, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f7369a = t;
            this.f7370b = function;
        }

        @Override // p136d.p153c.Observable
        /* renamed from: b */
        public void mo574b(InterfaceC1730s<? super R> interfaceC1730s) {
            try {
                ObservableSource<? extends R> mo3490a = this.f7370b.mo3490a((T) this.f7369a);
                ObjectHelper.m3598a(mo3490a, "The mapper returned a null ObservableSource");
                ObservableSource<? extends R> observableSource = mo3490a;
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.m3640a(interfaceC1730s);
                            return;
                        }
                        RunnableC1648a runnableC1648a = new RunnableC1648a(interfaceC1730s, call);
                        interfaceC1730s.mo572a((Disposable) runnableC1648a);
                        runnableC1648a.run();
                        return;
                    } catch (Throwable th) {
                        Exceptions.m3660b(th);
                        EmptyDisposable.m3638a(th, interfaceC1730s);
                        return;
                    }
                }
                observableSource.mo3294a(interfaceC1730s);
            } catch (Throwable th2) {
                EmptyDisposable.m3638a(th2, interfaceC1730s);
            }
        }
    }

    /* renamed from: a */
    public static <T, R> boolean m3514a(ObservableSource<T> observableSource, InterfaceC1730s<? super R> interfaceC1730s, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (observableSource instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) observableSource).call();
                if (obj == 0) {
                    EmptyDisposable.m3640a(interfaceC1730s);
                    return true;
                }
                try {
                    ObservableSource<? extends R> mo3490a = function.mo3490a(obj);
                    ObjectHelper.m3598a(mo3490a, "The mapper returned a null ObservableSource");
                    ObservableSource<? extends R> observableSource2 = mo3490a;
                    if (observableSource2 instanceof Callable) {
                        try {
                            Object call = ((Callable) observableSource2).call();
                            if (call == null) {
                                EmptyDisposable.m3640a(interfaceC1730s);
                                return true;
                            }
                            RunnableC1648a runnableC1648a = new RunnableC1648a(interfaceC1730s, call);
                            interfaceC1730s.mo572a((Disposable) runnableC1648a);
                            runnableC1648a.run();
                        } catch (Throwable th) {
                            Exceptions.m3660b(th);
                            EmptyDisposable.m3638a(th, interfaceC1730s);
                            return true;
                        }
                    } else {
                        observableSource2.mo3294a(interfaceC1730s);
                    }
                    return true;
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    EmptyDisposable.m3638a(th2, interfaceC1730s);
                    return true;
                }
            } catch (Throwable th3) {
                Exceptions.m3660b(th3);
                EmptyDisposable.m3638a(th3, interfaceC1730s);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static <T, U> Observable<U> m3513a(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.m3381a(new C1649b(t, function));
    }
}
