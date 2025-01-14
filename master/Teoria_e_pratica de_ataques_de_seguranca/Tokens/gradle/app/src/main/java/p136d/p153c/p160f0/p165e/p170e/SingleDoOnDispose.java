package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.e.n */
/* loaded from: classes.dex */
public final class SingleDoOnDispose<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7502a;

    /* renamed from: b */
    public final Action f7503b;

    public SingleDoOnDispose(SingleSource<T> singleSource, Action action) {
        this.f7502a = singleSource;
        this.f7503b = action;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7502a.subscribe(new C1680a(singleObserver, this.f7503b));
    }

    /* compiled from: SingleDoOnDispose.java */
    /* renamed from: d.c.f0.e.e.n$a */
    /* loaded from: classes.dex */
    public static final class C1680a<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7504a;

        /* renamed from: b */
        public Disposable f7505b;

        public C1680a(SingleObserver<? super T> singleObserver, Action action) {
            this.f7504a = singleObserver;
            lazySet(action);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7505b, disposable)) {
                this.f7505b = disposable;
                this.f7504a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            Action andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    RxJavaPlugins.m3371b(th);
                }
                this.f7505b.mo578b();
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7505b.mo577c();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7504a.mo3283a(th);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7504a.mo3282b(t);
        }
    }
}
