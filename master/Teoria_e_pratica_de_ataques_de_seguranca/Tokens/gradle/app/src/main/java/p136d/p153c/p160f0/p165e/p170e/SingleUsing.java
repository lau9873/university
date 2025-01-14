package p136d.p153c.p160f0.p165e.p170e;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.r0 */
/* loaded from: classes.dex */
public final class SingleUsing<T, U> extends Single<T> {

    /* renamed from: a */
    public final Callable<U> f7545a;

    /* renamed from: b */
    public final Function<? super U, ? extends SingleSource<? extends T>> f7546b;

    /* renamed from: c */
    public final Consumer<? super U> f7547c;

    /* renamed from: d */
    public final boolean f7548d;

    public SingleUsing(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        this.f7545a = callable;
        this.f7546b = function;
        this.f7547c = consumer;
        this.f7548d = z;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            U call = this.f7545a.call();
            try {
                SingleSource<? extends T> mo3490a = this.f7546b.mo3490a(call);
                ObjectHelper.m3598a(mo3490a, "The singleFunction returned a null SingleSource");
                mo3490a.subscribe(new C1691a(singleObserver, call, this.f7548d, this.f7547c));
            } catch (Throwable th) {
                th = th;
                Exceptions.m3660b(th);
                if (this.f7548d) {
                    try {
                        this.f7547c.accept(call);
                    } catch (Throwable th2) {
                        Exceptions.m3660b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                EmptyDisposable.m3637a(th, singleObserver);
                if (this.f7548d) {
                    return;
                }
                try {
                    this.f7547c.accept(call);
                } catch (Throwable th3) {
                    Exceptions.m3660b(th3);
                    RxJavaPlugins.m3371b(th3);
                }
            }
        } catch (Throwable th4) {
            Exceptions.m3660b(th4);
            EmptyDisposable.m3637a(th4, singleObserver);
        }
    }

    /* compiled from: SingleUsing.java */
    /* renamed from: d.c.f0.e.e.r0$a */
    /* loaded from: classes.dex */
    public static final class C1691a<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7549a;

        /* renamed from: b */
        public final Consumer<? super U> f7550b;

        /* renamed from: c */
        public final boolean f7551c;

        /* renamed from: d */
        public Disposable f7552d;

        public C1691a(SingleObserver<? super T> singleObserver, U u, boolean z, Consumer<? super U> consumer) {
            super(u);
            this.f7549a = singleObserver;
            this.f7551c = z;
            this.f7550b = consumer;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7552d, disposable)) {
                this.f7552d = disposable;
                this.f7549a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7552d.mo578b();
            this.f7552d = DisposableHelper.DISPOSED;
            m3495a();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7552d.mo577c();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7552d = DisposableHelper.DISPOSED;
            if (this.f7551c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f7550b.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f7549a.mo3283a(th);
            if (this.f7551c) {
                return;
            }
            m3495a();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7552d = DisposableHelper.DISPOSED;
            if (this.f7551c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f7550b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    this.f7549a.mo3283a(th);
                    return;
                }
            }
            this.f7549a.mo3282b(t);
            if (this.f7551c) {
                return;
            }
            m3495a();
        }

        /* renamed from: a */
        public void m3495a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f7550b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    RxJavaPlugins.m3371b(th);
                }
            }
        }
    }
}
