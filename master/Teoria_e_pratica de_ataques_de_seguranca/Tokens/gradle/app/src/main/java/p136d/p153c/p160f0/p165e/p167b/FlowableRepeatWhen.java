package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p174i.EmptySubscription;
import p136d.p153c.p160f0.p174i.SubscriptionArbiter;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p178i0.FlowableProcessor;
import p136d.p153c.p178i0.UnicastProcessor;
import p136d.p153c.p180k0.SerializedSubscriber;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.u */
/* loaded from: classes.dex */
public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final Function<? super Flowable<Object>, ? extends Publisher<?>> f7250c;

    /* compiled from: FlowableRepeatWhen.java */
    /* renamed from: d.c.f0.e.b.u$b */
    /* loaded from: classes.dex */
    public static final class C1628b<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {

        /* renamed from: a */
        public final Publisher<T> f7251a;

        /* renamed from: b */
        public final AtomicReference<Subscription> f7252b = new AtomicReference<>();

        /* renamed from: c */
        public final AtomicLong f7253c = new AtomicLong();

        /* renamed from: d */
        public AbstractC1629c<T, U> f7254d;

        public C1628b(Publisher<T> publisher) {
            this.f7251a = publisher;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            SubscriptionHelper.m3427a(this.f7252b, this.f7253c, subscription);
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            SubscriptionHelper.m3430a(this.f7252b);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(Object obj) {
            if (getAndIncrement() == 0) {
                while (!SubscriptionHelper.m3432a(this.f7252b.get())) {
                    this.f7251a.mo2190a(this.f7254d);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7254d.cancel();
            this.f7254d.f7255h.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7254d.cancel();
            this.f7254d.f7255h.mo2189a();
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            SubscriptionHelper.m3428a(this.f7252b, this.f7253c, j);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    /* renamed from: d.c.f0.e.b.u$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1629c<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {

        /* renamed from: h */
        public final Subscriber<? super T> f7255h;

        /* renamed from: i */
        public final FlowableProcessor<U> f7256i;

        /* renamed from: j */
        public final Subscription f7257j;

        /* renamed from: k */
        public long f7258k;

        public AbstractC1629c(Subscriber<? super T> subscriber, FlowableProcessor<U> flowableProcessor, Subscription subscription) {
            this.f7255h = subscriber;
            this.f7256i = flowableProcessor;
            this.f7257j = subscription;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public final void mo2188a(Subscription subscription) {
            m3436b(subscription);
        }

        /* renamed from: b */
        public final void m3537b(U u) {
            long j = this.f7258k;
            if (j != 0) {
                this.f7258k = 0L;
                m3437b(j);
            }
            this.f7257j.mo2185a(1L);
            this.f7256i.mo2187a((FlowableProcessor<U>) u);
        }

        @Override // p136d.p153c.p160f0.p174i.SubscriptionArbiter, p193g.p204b.Subscription
        public final void cancel() {
            super.cancel();
            this.f7257j.cancel();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public final void mo2187a(T t) {
            this.f7258k++;
            this.f7255h.mo2187a((Subscriber<? super T>) t);
        }
    }

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f7250c = function;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor<T> m3364i = UnicastProcessor.m3362a(8).m3364i();
        try {
            Publisher<?> mo3490a = this.f7250c.mo3490a(m3364i);
            ObjectHelper.m3598a(mo3490a, "handler returned a null Publisher");
            Publisher<?> publisher = mo3490a;
            C1628b c1628b = new C1628b(this.f7090b);
            C1627a c1627a = new C1627a(serializedSubscriber, m3364i, c1628b);
            c1628b.f7254d = c1627a;
            subscriber.mo2188a((Subscription) c1627a);
            publisher.mo2190a(c1628b);
            c1628b.mo2187a((Object) 0);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptySubscription.m3439a(th, subscriber);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    /* renamed from: d.c.f0.e.b.u$a */
    /* loaded from: classes.dex */
    public static final class C1627a<T> extends AbstractC1629c<T, Object> {
        public C1627a(Subscriber<? super T> subscriber, FlowableProcessor<Object> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7257j.cancel();
            this.f7255h.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            m3537b((C1627a<T>) 0);
        }
    }
}
