package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.atomic.AtomicLong;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.p */
/* loaded from: classes.dex */
public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {

    /* renamed from: c */
    public final Consumer<? super T> f7225c;

    public FlowableOnBackpressureDrop(Flowable<T> flowable) {
        super(flowable);
        this.f7225c = this;
    }

    @Override // p136d.p153c.p159e0.Consumer
    public void accept(T t) {
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7090b.m3347a((FlowableSubscriber) new C1622a(subscriber, this.f7225c));
    }

    /* compiled from: FlowableOnBackpressureDrop.java */
    /* renamed from: d.c.f0.e.b.p$a */
    /* loaded from: classes.dex */
    public static final class C1622a<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {

        /* renamed from: a */
        public final Subscriber<? super T> f7226a;

        /* renamed from: b */
        public final Consumer<? super T> f7227b;

        /* renamed from: c */
        public Subscription f7228c;

        /* renamed from: d */
        public boolean f7229d;

        public C1622a(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
            this.f7226a = subscriber;
            this.f7227b = consumer;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7228c, subscription)) {
                this.f7228c = subscription;
                this.f7226a.mo2188a((Subscription) this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            this.f7228c.cancel();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            if (this.f7229d) {
                return;
            }
            if (get() != 0) {
                this.f7226a.mo2187a((Subscriber<? super T>) t);
                BackpressureHelper.m3415b(this, 1L);
                return;
            }
            try {
                this.f7227b.accept(t);
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                cancel();
                mo2186a(th);
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7229d) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7229d = true;
            this.f7226a.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7229d) {
                return;
            }
            this.f7229d = true;
            this.f7226a.mo2189a();
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            if (SubscriptionHelper.m3424c(j)) {
                BackpressureHelper.m3416a(this, j);
            }
        }
    }
}
