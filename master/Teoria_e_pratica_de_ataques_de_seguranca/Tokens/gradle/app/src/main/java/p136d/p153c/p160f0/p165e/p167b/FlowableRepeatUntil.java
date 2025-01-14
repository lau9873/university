package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.BooleanSupplier;
import p136d.p153c.p160f0.p174i.SubscriptionArbiter;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.t */
/* loaded from: classes.dex */
public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final BooleanSupplier f7245c;

    /* compiled from: FlowableRepeatUntil.java */
    /* renamed from: d.c.f0.e.b.t$a */
    /* loaded from: classes.dex */
    public static final class C1626a<T> extends AtomicInteger implements FlowableSubscriber<T> {

        /* renamed from: a */
        public final Subscriber<? super T> f7246a;

        /* renamed from: b */
        public final SubscriptionArbiter f7247b;

        /* renamed from: c */
        public final Publisher<? extends T> f7248c;

        /* renamed from: d */
        public final BooleanSupplier f7249d;

        public C1626a(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f7246a = subscriber;
            this.f7247b = subscriptionArbiter;
            this.f7248c = publisher;
            this.f7249d = booleanSupplier;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            this.f7247b.m3436b(subscription);
        }

        /* renamed from: b */
        public void m3538b() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    this.f7248c.mo2190a(this);
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            this.f7246a.mo2187a((Subscriber<? super T>) t);
            this.f7247b.m3437b(1L);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7246a.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            try {
                if (this.f7249d.m3656a()) {
                    this.f7246a.mo2189a();
                } else {
                    m3538b();
                }
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7246a.mo2186a(th);
            }
        }
    }

    public FlowableRepeatUntil(Flowable<T> flowable, BooleanSupplier booleanSupplier) {
        super(flowable);
        this.f7245c = booleanSupplier;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo2188a((Subscription) subscriptionArbiter);
        new C1626a(subscriber, this.f7245c, subscriptionArbiter, this.f7090b).m3538b();
    }
}
