package p136d.p153c.p160f0.p165e.p167b;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.BiPredicate;
import p136d.p153c.p160f0.p174i.SubscriptionArbiter;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.v */
/* loaded from: classes.dex */
public final class FlowableRetryBiPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final BiPredicate<? super Integer, ? super Throwable> f7259c;

    /* compiled from: FlowableRetryBiPredicate.java */
    /* renamed from: d.c.f0.e.b.v$a */
    /* loaded from: classes.dex */
    public static final class C1630a<T> extends AtomicInteger implements FlowableSubscriber<T> {

        /* renamed from: a */
        public final Subscriber<? super T> f7260a;

        /* renamed from: b */
        public final SubscriptionArbiter f7261b;

        /* renamed from: c */
        public final Publisher<? extends T> f7262c;

        /* renamed from: d */
        public final BiPredicate<? super Integer, ? super Throwable> f7263d;

        /* renamed from: e */
        public int f7264e;

        public C1630a(Subscriber<? super T> subscriber, BiPredicate<? super Integer, ? super Throwable> biPredicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f7260a = subscriber;
            this.f7261b = subscriptionArbiter;
            this.f7262c = publisher;
            this.f7263d = biPredicate;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            this.f7261b.m3436b(subscription);
        }

        /* renamed from: b */
        public void m3536b() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f7261b.m3434d()) {
                    this.f7262c.mo2190a(this);
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
            this.f7260a.mo2187a((Subscriber<? super T>) t);
            this.f7261b.m3437b(1L);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.f7263d;
                int i = this.f7264e + 1;
                this.f7264e = i;
                if (!biPredicate.mo3597a(Integer.valueOf(i), th)) {
                    this.f7260a.mo2186a(th);
                } else {
                    m3536b();
                }
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                this.f7260a.mo2186a((Throwable) new CompositeException(th, th2));
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7260a.mo2189a();
        }
    }

    public FlowableRetryBiPredicate(Flowable<T> flowable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(flowable);
        this.f7259c = biPredicate;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.mo2188a((Subscription) subscriptionArbiter);
        new C1630a(subscriber, this.f7259c, subscriptionArbiter, this.f7090b).m3536b();
    }
}
