package p136d.p153c.p160f0.p165e.p167b;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Predicate;
import p136d.p153c.p160f0.p174i.SubscriptionArbiter;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.w */
/* loaded from: classes.dex */
public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final Predicate<? super Throwable> f7265c;

    /* renamed from: d */
    public final long f7266d;

    /* compiled from: FlowableRetryPredicate.java */
    /* renamed from: d.c.f0.e.b.w$a */
    /* loaded from: classes.dex */
    public static final class C1631a<T> extends AtomicInteger implements FlowableSubscriber<T> {

        /* renamed from: a */
        public final Subscriber<? super T> f7267a;

        /* renamed from: b */
        public final SubscriptionArbiter f7268b;

        /* renamed from: c */
        public final Publisher<? extends T> f7269c;

        /* renamed from: d */
        public final Predicate<? super Throwable> f7270d;

        /* renamed from: e */
        public long f7271e;

        public C1631a(Subscriber<? super T> subscriber, long j, Predicate<? super Throwable> predicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f7267a = subscriber;
            this.f7268b = subscriptionArbiter;
            this.f7269c = publisher;
            this.f7270d = predicate;
            this.f7271e = j;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            this.f7268b.m3436b(subscription);
        }

        /* renamed from: b */
        public void m3535b() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f7268b.m3434d()) {
                    this.f7269c.mo2190a(this);
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
            this.f7267a.mo2187a((Subscriber<? super T>) t);
            this.f7268b.m3437b(1L);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            long j = this.f7271e;
            if (j != Long.MAX_VALUE) {
                this.f7271e = j - 1;
            }
            if (j == 0) {
                this.f7267a.mo2186a(th);
                return;
            }
            try {
                if (!this.f7270d.mo3613a(th)) {
                    this.f7267a.mo2186a(th);
                } else {
                    m3535b();
                }
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                this.f7267a.mo2186a((Throwable) new CompositeException(th, th2));
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7267a.mo2189a();
        }
    }

    public FlowableRetryPredicate(Flowable<T> flowable, long j, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.f7265c = predicate;
        this.f7266d = j;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo2188a((Subscription) subscriptionArbiter);
        new C1631a(subscriber, this.f7266d, this.f7265c, subscriptionArbiter, this.f7090b).m3535b();
    }
}
