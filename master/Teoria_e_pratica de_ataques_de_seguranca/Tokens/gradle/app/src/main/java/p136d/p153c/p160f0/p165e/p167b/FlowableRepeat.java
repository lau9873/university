package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p160f0.p174i.SubscriptionArbiter;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.s */
/* loaded from: classes.dex */
public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final long f7240c;

    /* compiled from: FlowableRepeat.java */
    /* renamed from: d.c.f0.e.b.s$a */
    /* loaded from: classes.dex */
    public static final class C1625a<T> extends AtomicInteger implements FlowableSubscriber<T> {

        /* renamed from: a */
        public final Subscriber<? super T> f7241a;

        /* renamed from: b */
        public final SubscriptionArbiter f7242b;

        /* renamed from: c */
        public final Publisher<? extends T> f7243c;

        /* renamed from: d */
        public long f7244d;

        public C1625a(Subscriber<? super T> subscriber, long j, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f7241a = subscriber;
            this.f7242b = subscriptionArbiter;
            this.f7243c = publisher;
            this.f7244d = j;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            this.f7242b.m3436b(subscription);
        }

        /* renamed from: b */
        public void m3539b() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f7242b.m3434d()) {
                    this.f7243c.mo2190a(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            this.f7241a.mo2187a((Subscriber<? super T>) t);
            this.f7242b.m3437b(1L);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7241a.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            long j = this.f7244d;
            if (j != Long.MAX_VALUE) {
                this.f7244d = j - 1;
            }
            if (j != 0) {
                m3539b();
            } else {
                this.f7241a.mo2189a();
            }
        }
    }

    public FlowableRepeat(Flowable<T> flowable, long j) {
        super(flowable);
        this.f7240c = j;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo2188a((Subscription) subscriptionArbiter);
        long j = this.f7240c;
        new C1625a(subscriber, j != Long.MAX_VALUE ? j - 1 : Long.MAX_VALUE, subscriptionArbiter, this.f7090b).m3539b();
    }
}
