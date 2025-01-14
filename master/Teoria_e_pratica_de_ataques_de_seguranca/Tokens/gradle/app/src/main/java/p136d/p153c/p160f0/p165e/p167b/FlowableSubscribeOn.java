package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.Scheduler;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.b0 */
/* loaded from: classes.dex */
public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final Scheduler f7107c;

    /* renamed from: d */
    public final boolean f7108d;

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f7107c = scheduler;
        this.f7108d = z;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC1733c mo3293a = this.f7107c.mo3293a();
        RunnableC1600a runnableC1600a = new RunnableC1600a(subscriber, mo3293a, this.f7090b, this.f7108d);
        subscriber.mo2188a((Subscription) runnableC1600a);
        mo3293a.mo3289a(runnableC1600a);
    }

    /* compiled from: FlowableSubscribeOn.java */
    /* renamed from: d.c.f0.e.b.b0$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1600a<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {

        /* renamed from: a */
        public final Subscriber<? super T> f7109a;

        /* renamed from: b */
        public final Scheduler.AbstractC1733c f7110b;

        /* renamed from: c */
        public final AtomicReference<Subscription> f7111c = new AtomicReference<>();

        /* renamed from: d */
        public final AtomicLong f7112d = new AtomicLong();

        /* renamed from: e */
        public final boolean f7113e;

        /* renamed from: f */
        public Publisher<T> f7114f;

        /* compiled from: FlowableSubscribeOn.java */
        /* renamed from: d.c.f0.e.b.b0$a$a */
        /* loaded from: classes.dex */
        public class RunnableC1601a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Subscription f7115a;

            /* renamed from: b */
            public final /* synthetic */ long f7116b;

            public RunnableC1601a(RunnableC1600a runnableC1600a, Subscription subscription, long j) {
                this.f7115a = subscription;
                this.f7116b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7115a.mo2185a(this.f7116b);
            }
        }

        public RunnableC1600a(Subscriber<? super T> subscriber, Scheduler.AbstractC1733c abstractC1733c, Publisher<T> publisher, boolean z) {
            this.f7109a = subscriber;
            this.f7110b = abstractC1733c;
            this.f7114f = publisher;
            this.f7113e = z;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3429a(this.f7111c, subscription)) {
                long andSet = this.f7112d.getAndSet(0L);
                if (andSet != 0) {
                    m3569a(andSet, subscription);
                }
            }
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            SubscriptionHelper.m3430a(this.f7111c);
            this.f7110b.mo578b();
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.f7114f;
            this.f7114f = null;
            publisher.mo2190a(this);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            this.f7109a.mo2187a((Subscriber<? super T>) t);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7109a.mo2186a(th);
            this.f7110b.mo578b();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7109a.mo2189a();
            this.f7110b.mo578b();
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            if (SubscriptionHelper.m3424c(j)) {
                Subscription subscription = this.f7111c.get();
                if (subscription != null) {
                    m3569a(j, subscription);
                    return;
                }
                BackpressureHelper.m3416a(this.f7112d, j);
                Subscription subscription2 = this.f7111c.get();
                if (subscription2 != null) {
                    long andSet = this.f7112d.getAndSet(0L);
                    if (andSet != 0) {
                        m3569a(andSet, subscription2);
                    }
                }
            }
        }

        /* renamed from: a */
        public void m3569a(long j, Subscription subscription) {
            if (!this.f7113e && Thread.currentThread() != get()) {
                this.f7110b.mo3289a(new RunnableC1601a(this, subscription, j));
            } else {
                subscription.mo2185a(j);
            }
        }
    }
}
