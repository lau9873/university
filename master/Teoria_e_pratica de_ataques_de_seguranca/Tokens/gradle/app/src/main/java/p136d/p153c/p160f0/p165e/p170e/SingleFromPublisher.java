package p136d.p153c.p160f0.p165e.p170e;

import java.util.NoSuchElementException;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.e.a0 */
/* loaded from: classes.dex */
public final class SingleFromPublisher<T> extends Single<T> {

    /* renamed from: a */
    public final Publisher<? extends T> f7391a;

    public SingleFromPublisher(Publisher<? extends T> publisher) {
        this.f7391a = publisher;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7391a.mo2190a(new C1655a(singleObserver));
    }

    /* compiled from: SingleFromPublisher.java */
    /* renamed from: d.c.f0.e.e.a0$a */
    /* loaded from: classes.dex */
    public static final class C1655a<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7392a;

        /* renamed from: b */
        public Subscription f7393b;

        /* renamed from: c */
        public T f7394c;

        /* renamed from: d */
        public boolean f7395d;

        /* renamed from: e */
        public volatile boolean f7396e;

        public C1655a(SingleObserver<? super T> singleObserver) {
            this.f7392a = singleObserver;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7393b, subscription)) {
                this.f7393b = subscription;
                this.f7392a.mo3284a(this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7396e = true;
            this.f7393b.cancel();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7396e;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            if (this.f7395d) {
                return;
            }
            if (this.f7394c != null) {
                this.f7393b.cancel();
                this.f7395d = true;
                this.f7394c = null;
                this.f7392a.mo3283a(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                return;
            }
            this.f7394c = t;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7395d) {
                RxJavaPlugins.m3371b(th);
                return;
            }
            this.f7395d = true;
            this.f7394c = null;
            this.f7392a.mo3283a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7395d) {
                return;
            }
            this.f7395d = true;
            T t = this.f7394c;
            this.f7394c = null;
            if (t == null) {
                this.f7392a.mo3283a(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.f7392a.mo3282b(t);
            }
        }
    }
}
