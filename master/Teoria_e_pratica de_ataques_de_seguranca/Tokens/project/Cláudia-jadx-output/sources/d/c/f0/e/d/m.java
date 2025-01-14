package d.c.f0.e.d;

import d.c.r;
import d.c.s;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableScalarXMap.java */
/* loaded from: classes.dex */
public final class m {

    /* compiled from: ObservableScalarXMap.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements d.c.f0.c.i<T>, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super T> f5032a;

        /* renamed from: b  reason: collision with root package name */
        public final T f5033b;

        public a(s<? super T> sVar, T t) {
            this.f5032a = sVar;
            this.f5033b = t;
        }

        @Override // d.c.f0.c.j
        public int a(int i2) {
            if ((i2 & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // d.c.c0.b
        public void b() {
            set(3);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return get() == 3;
        }

        @Override // d.c.f0.c.n
        public void clear() {
            lazySet(3);
        }

        @Override // d.c.f0.c.n
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // d.c.f0.c.n
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // d.c.f0.c.n
        public T poll() {
            if (get() == 1) {
                lazySet(3);
                return this.f5033b;
            }
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f5032a.a((s<? super T>) ((T) this.f5033b));
                if (get() == 2) {
                    lazySet(3);
                    this.f5032a.a();
                }
            }
        }
    }

    /* compiled from: ObservableScalarXMap.java */
    /* loaded from: classes.dex */
    public static final class b<T, R> extends d.c.o<R> {

        /* renamed from: a  reason: collision with root package name */
        public final T f5034a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends r<? extends R>> f5035b;

        public b(T t, d.c.e0.n<? super T, ? extends r<? extends R>> nVar) {
            this.f5034a = t;
            this.f5035b = nVar;
        }

        @Override // d.c.o
        public void b(s<? super R> sVar) {
            try {
                r<? extends R> a2 = this.f5035b.a((T) this.f5034a);
                d.c.f0.b.b.a(a2, "The mapper returned a null ObservableSource");
                r<? extends R> rVar = a2;
                if (rVar instanceof Callable) {
                    try {
                        Object call = ((Callable) rVar).call();
                        if (call == null) {
                            d.c.f0.a.c.a(sVar);
                            return;
                        }
                        a aVar = new a(sVar, call);
                        sVar.a((d.c.c0.b) aVar);
                        aVar.run();
                        return;
                    } catch (Throwable th) {
                        d.c.d0.a.b(th);
                        d.c.f0.a.c.a(th, sVar);
                        return;
                    }
                }
                rVar.a(sVar);
            } catch (Throwable th2) {
                d.c.f0.a.c.a(th2, sVar);
            }
        }
    }

    public static <T, R> boolean a(r<T> rVar, s<? super R> sVar, d.c.e0.n<? super T, ? extends r<? extends R>> nVar) {
        if (rVar instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) rVar).call();
                if (obj == 0) {
                    d.c.f0.a.c.a(sVar);
                    return true;
                }
                try {
                    r<? extends R> a2 = nVar.a(obj);
                    d.c.f0.b.b.a(a2, "The mapper returned a null ObservableSource");
                    r<? extends R> rVar2 = a2;
                    if (rVar2 instanceof Callable) {
                        try {
                            Object call = ((Callable) rVar2).call();
                            if (call == null) {
                                d.c.f0.a.c.a(sVar);
                                return true;
                            }
                            a aVar = new a(sVar, call);
                            sVar.a((d.c.c0.b) aVar);
                            aVar.run();
                        } catch (Throwable th) {
                            d.c.d0.a.b(th);
                            d.c.f0.a.c.a(th, sVar);
                            return true;
                        }
                    } else {
                        rVar2.a(sVar);
                    }
                    return true;
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    d.c.f0.a.c.a(th2, sVar);
                    return true;
                }
            } catch (Throwable th3) {
                d.c.d0.a.b(th3);
                d.c.f0.a.c.a(th3, sVar);
                return true;
            }
        }
        return false;
    }

    public static <T, U> d.c.o<U> a(T t, d.c.e0.n<? super T, ? extends r<? extends U>> nVar) {
        return d.c.h0.a.a(new b(t, nVar));
    }
}
