package p136d.p153c.p160f0.p165e.p167b;

import java.util.NoSuchElementException;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p163c.FuseToFlowable;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.a0 */
/* loaded from: classes.dex */
public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* renamed from: a */
    public final Flowable<T> f7091a;

    /* renamed from: b */
    public final T f7092b;

    public FlowableSingleSingle(Flowable<T> flowable, T t) {
        this.f7091a = flowable;
        this.f7092b = t;
    }

    @Override // p136d.p153c.p160f0.p163c.FuseToFlowable
    /* renamed from: a */
    public Flowable<T> mo3570a() {
        return RxJavaPlugins.m3384a(new FlowableSingle(this.f7091a, this.f7092b));
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7091a.m3347a((FlowableSubscriber) new C1598a(singleObserver, this.f7092b));
    }

    /* compiled from: FlowableSingleSingle.java */
    /* renamed from: d.c.f0.e.b.a0$a */
    /* loaded from: classes.dex */
    public static final class C1598a<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7093a;

        /* renamed from: b */
        public final T f7094b;

        /* renamed from: c */
        public Subscription f7095c;

        /* renamed from: d */
        public boolean f7096d;

        /* renamed from: e */
        public T f7097e;

        public C1598a(SingleObserver<? super T> singleObserver, T t) {
            this.f7093a = singleObserver;
            this.f7094b = t;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7095c, subscription)) {
                this.f7095c = subscription;
                this.f7093a.mo3284a(this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7095c.cancel();
            this.f7095c = SubscriptionHelper.CANCELLED;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7095c == SubscriptionHelper.CANCELLED;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            if (this.f7096d) {
                return;
            }
            if (this.f7097e != null) {
                this.f7096d = true;
                this.f7095c.cancel();
                this.f7095c = SubscriptionHelper.CANCELLED;
                this.f7093a.mo3283a(new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f7097e = t;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7096d) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7096d = true;
            this.f7095c = SubscriptionHelper.CANCELLED;
            this.f7093a.mo3283a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7096d) {
                return;
            }
            this.f7096d = true;
            this.f7095c = SubscriptionHelper.CANCELLED;
            T t = this.f7097e;
            this.f7097e = null;
            if (t == null) {
                t = this.f7094b;
            }
            if (t != null) {
                this.f7093a.mo3282b(t);
            } else {
                this.f7093a.mo3283a(new NoSuchElementException());
            }
        }
    }
}
