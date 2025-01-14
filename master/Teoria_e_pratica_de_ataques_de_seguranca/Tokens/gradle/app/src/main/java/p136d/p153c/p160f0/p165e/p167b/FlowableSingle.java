package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p160f0.p174i.DeferredScalarSubscription;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.z */
/* loaded from: classes.dex */
public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final T f7275c;

    public FlowableSingle(Flowable<T> flowable, T t) {
        super(flowable);
        this.f7275c = t;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7090b.m3347a((FlowableSubscriber) new C1634a(subscriber, this.f7275c));
    }

    /* compiled from: FlowableSingle.java */
    /* renamed from: d.c.f0.e.b.z$a */
    /* loaded from: classes.dex */
    public static final class C1634a<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {

        /* renamed from: c */
        public final T f7276c;

        /* renamed from: d */
        public Subscription f7277d;

        /* renamed from: e */
        public boolean f7278e;

        public C1634a(Subscriber<? super T> subscriber, T t) {
            super(subscriber);
            this.f7276c = t;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7277d, subscription)) {
                this.f7277d = subscription;
                this.f7688a.mo2188a((Subscription) this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        @Override // p136d.p153c.p160f0.p174i.DeferredScalarSubscription, p193g.p204b.Subscription
        public void cancel() {
            super.cancel();
            this.f7277d.cancel();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            if (this.f7278e) {
                return;
            }
            if (this.f7689b != null) {
                this.f7278e = true;
                this.f7277d.cancel();
                this.f7688a.mo2186a((Throwable) new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f7689b = t;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7278e) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7278e = true;
            this.f7688a.mo2186a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7278e) {
                return;
            }
            this.f7278e = true;
            T t = this.f7689b;
            this.f7689b = null;
            if (t == null) {
                t = this.f7276c;
            }
            if (t == null) {
                this.f7688a.mo2189a();
            } else {
                m3441d(t);
            }
        }
    }
}
