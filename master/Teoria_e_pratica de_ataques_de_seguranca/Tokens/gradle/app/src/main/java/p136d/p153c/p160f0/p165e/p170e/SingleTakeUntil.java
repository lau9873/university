package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.e.m0 */
/* loaded from: classes.dex */
public final class SingleTakeUntil<T, U> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7497a;

    /* renamed from: b */
    public final Publisher<U> f7498b;

    /* compiled from: SingleTakeUntil.java */
    /* renamed from: d.c.f0.e.e.m0$a */
    /* loaded from: classes.dex */
    public static final class C1678a<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7499a;

        /* renamed from: b */
        public final C1679b f7500b = new C1679b(this);

        public C1678a(SingleObserver<? super T> singleObserver) {
            this.f7499a = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            DisposableHelper.m3644c(this, disposable);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7500b.m3497b();
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && getAndSet(disposableHelper) != DisposableHelper.DISPOSED) {
                this.f7499a.mo3283a(th);
            } else {
                RxJavaPlugins.m3371b(th);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7500b.m3497b();
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || getAndSet(disposableHelper) == DisposableHelper.DISPOSED) {
                return;
            }
            this.f7499a.mo3282b(t);
        }

        /* renamed from: b */
        public void m3498b(Throwable th) {
            Disposable andSet;
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && (andSet = getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
                if (andSet != null) {
                    andSet.mo578b();
                }
                this.f7499a.mo3283a(th);
                return;
            }
            RxJavaPlugins.m3371b(th);
        }
    }

    public SingleTakeUntil(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f7497a = singleSource;
        this.f7498b = publisher;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        C1678a c1678a = new C1678a(singleObserver);
        singleObserver.mo3284a(c1678a);
        this.f7498b.mo2190a(c1678a.f7500b);
        this.f7497a.subscribe(c1678a);
    }

    /* compiled from: SingleTakeUntil.java */
    /* renamed from: d.c.f0.e.e.m0$b */
    /* loaded from: classes.dex */
    public static final class C1679b extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {

        /* renamed from: a */
        public final C1678a<?> f7501a;

        public C1679b(C1678a<?> c1678a) {
            this.f7501a = c1678a;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3429a(this, subscription)) {
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        /* renamed from: b */
        public void m3497b() {
            SubscriptionHelper.m3430a(this);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(Object obj) {
            if (SubscriptionHelper.m3430a(this)) {
                this.f7501a.m3498b((Throwable) new CancellationException());
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7501a.m3498b(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f7501a.m3498b((Throwable) new CancellationException());
            }
        }
    }
}
