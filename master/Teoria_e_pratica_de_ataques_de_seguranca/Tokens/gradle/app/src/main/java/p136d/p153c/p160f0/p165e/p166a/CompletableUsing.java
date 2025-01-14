package p136d.p153c.p160f0.p165e.p166a;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.n0 */
/* loaded from: classes.dex */
public final class CompletableUsing<R> extends Completable {

    /* renamed from: a */
    public final Callable<R> f7047a;

    /* renamed from: b */
    public final Function<? super R, ? extends CompletableSource> f7048b;

    /* renamed from: c */
    public final Consumer<? super R> f7049c;

    /* renamed from: d */
    public final boolean f7050d;

    public CompletableUsing(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        this.f7047a = callable;
        this.f7048b = function;
        this.f7049c = consumer;
        this.f7050d = z;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            R call = this.f7047a.call();
            try {
                CompletableSource mo3490a = this.f7048b.mo3490a(call);
                ObjectHelper.m3598a(mo3490a, "The completableFunction returned a null CompletableSource");
                mo3490a.subscribe(new C1589a(completableObserver, call, this.f7049c, this.f7050d));
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                if (this.f7050d) {
                    try {
                        this.f7049c.accept(call);
                    } catch (Throwable th2) {
                        Exceptions.m3660b(th2);
                        EmptyDisposable.m3639a(new CompositeException(th, th2), completableObserver);
                        return;
                    }
                }
                EmptyDisposable.m3639a(th, completableObserver);
                if (this.f7050d) {
                    return;
                }
                try {
                    this.f7049c.accept(call);
                } catch (Throwable th3) {
                    Exceptions.m3660b(th3);
                    RxJavaPlugins.m3371b(th3);
                }
            }
        } catch (Throwable th4) {
            Exceptions.m3660b(th4);
            EmptyDisposable.m3639a(th4, completableObserver);
        }
    }

    /* compiled from: CompletableUsing.java */
    /* renamed from: d.c.f0.e.a.n0$a */
    /* loaded from: classes.dex */
    public static final class C1589a<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {

        /* renamed from: a */
        public final CompletableObserver f7051a;

        /* renamed from: b */
        public final Consumer<? super R> f7052b;

        /* renamed from: c */
        public final boolean f7053c;

        /* renamed from: d */
        public Disposable f7054d;

        public C1589a(CompletableObserver completableObserver, R r, Consumer<? super R> consumer, boolean z) {
            super(r);
            this.f7051a = completableObserver;
            this.f7052b = consumer;
            this.f7053c = z;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7054d, disposable)) {
                this.f7054d = disposable;
                this.f7051a.mo3502a(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7054d.mo578b();
            this.f7054d = DisposableHelper.DISPOSED;
            m3575d();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7054d.mo577c();
        }

        /* renamed from: d */
        public void m3575d() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f7052b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    RxJavaPlugins.m3371b(th);
                }
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f7054d = DisposableHelper.DISPOSED;
            if (this.f7053c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f7052b.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f7051a.mo3501a(th);
            if (this.f7053c) {
                return;
            }
            m3575d();
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f7054d = DisposableHelper.DISPOSED;
            if (this.f7053c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f7052b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    this.f7051a.mo3501a(th);
                    return;
                }
            }
            this.f7051a.mo3489a();
            if (this.f7053c) {
                return;
            }
            m3575d();
        }
    }
}
