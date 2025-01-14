package p136d.p153c.p160f0.p165e.p167b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.q */
/* loaded from: classes.dex */
public final class FlowableOnBackpressureError<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableOnBackpressureError(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7090b.m3347a((FlowableSubscriber) new C1623a(subscriber));
    }

    /* compiled from: FlowableOnBackpressureError.java */
    /* renamed from: d.c.f0.e.b.q$a */
    /* loaded from: classes.dex */
    public static final class C1623a<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {

        /* renamed from: a */
        public final Subscriber<? super T> f7230a;

        /* renamed from: b */
        public Subscription f7231b;

        /* renamed from: c */
        public boolean f7232c;

        public C1623a(Subscriber<? super T> subscriber) {
            this.f7230a = subscriber;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7231b, subscription)) {
                this.f7231b = subscription;
                this.f7230a.mo2188a((Subscription) this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            this.f7231b.cancel();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            if (this.f7232c) {
                return;
            }
            if (get() != 0) {
                this.f7230a.mo2187a((Subscriber<? super T>) t);
                BackpressureHelper.m3415b(this, 1L);
                return;
            }
            mo2186a((Throwable) new MissingBackpressureException("could not emit value due to lack of requests"));
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7232c) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7232c = true;
            this.f7230a.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7232c) {
                return;
            }
            this.f7232c = true;
            this.f7230a.mo2189a();
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
