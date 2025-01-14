package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p164d.ResumeSingleObserver;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.e.i */
/* loaded from: classes.dex */
public final class SingleDelayWithPublisher<T, U> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7452a;

    /* renamed from: b */
    public final Publisher<U> f7453b;

    public SingleDelayWithPublisher(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f7452a = singleSource;
        this.f7453b = publisher;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7453b.mo2190a(new C1669a(singleObserver, this.f7452a));
    }

    /* compiled from: SingleDelayWithPublisher.java */
    /* renamed from: d.c.f0.e.e.i$a */
    /* loaded from: classes.dex */
    public static final class C1669a<T, U> extends AtomicReference<Disposable> implements FlowableSubscriber<U>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7454a;

        /* renamed from: b */
        public final SingleSource<T> f7455b;

        /* renamed from: c */
        public boolean f7456c;

        /* renamed from: d */
        public Subscription f7457d;

        public C1669a(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f7454a = singleObserver;
            this.f7455b = singleSource;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7457d, subscription)) {
                this.f7457d = subscription;
                this.f7454a.mo3284a(this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7457d.cancel();
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(U u) {
            this.f7457d.cancel();
            mo2189a();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7456c) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7456c = true;
            this.f7454a.mo3283a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7456c) {
                return;
            }
            this.f7456c = true;
            this.f7455b.subscribe(new ResumeSingleObserver(this, this.f7454a));
        }
    }
}
