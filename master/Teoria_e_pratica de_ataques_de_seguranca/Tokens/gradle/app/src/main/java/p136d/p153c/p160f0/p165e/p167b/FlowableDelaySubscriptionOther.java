package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p160f0.p174i.SubscriptionArbiter;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.e */
/* loaded from: classes.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher<? extends T> f7146b;

    /* renamed from: c */
    public final Publisher<U> f7147c;

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        this.f7146b = publisher;
        this.f7147c = publisher2;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo2188a((Subscription) subscriptionArbiter);
        this.f7147c.mo2190a(new C1609a(subscriptionArbiter, subscriber));
    }

    /* compiled from: FlowableDelaySubscriptionOther.java */
    /* renamed from: d.c.f0.e.b.e$a */
    /* loaded from: classes.dex */
    public class C1609a implements FlowableSubscriber<U> {

        /* renamed from: a */
        public boolean f7148a;

        /* renamed from: b */
        public final /* synthetic */ SubscriptionArbiter f7149b;

        /* renamed from: c */
        public final /* synthetic */ Subscriber f7150c;

        /* compiled from: FlowableDelaySubscriptionOther.java */
        /* renamed from: d.c.f0.e.b.e$a$a */
        /* loaded from: classes.dex */
        public class C1610a implements Subscription {

            /* renamed from: a */
            public final /* synthetic */ Subscription f7152a;

            public C1610a(C1609a c1609a, Subscription subscription) {
                this.f7152a = subscription;
            }

            @Override // p193g.p204b.Subscription
            /* renamed from: a */
            public void mo2185a(long j) {
            }

            @Override // p193g.p204b.Subscription
            public void cancel() {
                this.f7152a.cancel();
            }
        }

        /* compiled from: FlowableDelaySubscriptionOther.java */
        /* renamed from: d.c.f0.e.b.e$a$b */
        /* loaded from: classes.dex */
        public class C1611b implements FlowableSubscriber<T> {
            public C1611b() {
            }

            @Override // p193g.p204b.Subscriber
            /* renamed from: a */
            public void mo2188a(Subscription subscription) {
                C1609a.this.f7149b.m3436b(subscription);
            }

            @Override // p193g.p204b.Subscriber
            /* renamed from: a */
            public void mo2187a(T t) {
                C1609a.this.f7150c.mo2187a((Subscriber) t);
            }

            @Override // p193g.p204b.Subscriber
            /* renamed from: a */
            public void mo2186a(Throwable th) {
                C1609a.this.f7150c.mo2186a(th);
            }

            @Override // p193g.p204b.Subscriber
            /* renamed from: a */
            public void mo2189a() {
                C1609a.this.f7150c.mo2189a();
            }
        }

        public C1609a(SubscriptionArbiter subscriptionArbiter, Subscriber subscriber) {
            this.f7149b = subscriptionArbiter;
            this.f7150c = subscriber;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            this.f7149b.m3436b(new C1610a(this, subscription));
            subscription.mo2185a(Long.MAX_VALUE);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(U u) {
            mo2189a();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7148a) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7148a = true;
            this.f7150c.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7148a) {
                return;
            }
            this.f7148a = true;
            FlowableDelaySubscriptionOther.this.f7146b.mo2190a(new C1611b());
        }
    }
}
