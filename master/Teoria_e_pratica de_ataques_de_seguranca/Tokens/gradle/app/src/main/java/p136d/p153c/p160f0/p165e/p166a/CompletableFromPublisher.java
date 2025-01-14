package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p193g.p204b.Publisher;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.a.r */
/* loaded from: classes.dex */
public final class CompletableFromPublisher<T> extends Completable {

    /* renamed from: a */
    public final Publisher<T> f7059a;

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.f7059a = publisher;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7059a.mo2190a(new C1591a(completableObserver));
    }

    /* compiled from: CompletableFromPublisher.java */
    /* renamed from: d.c.f0.e.a.r$a */
    /* loaded from: classes.dex */
    public static final class C1591a<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: a */
        public final CompletableObserver f7060a;

        /* renamed from: b */
        public Subscription f7061b;

        public C1591a(CompletableObserver completableObserver) {
            this.f7060a = completableObserver;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7061b, subscription)) {
                this.f7061b = subscription;
                this.f7060a.mo3502a(this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7061b.cancel();
            this.f7061b = SubscriptionHelper.CANCELLED;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7061b == SubscriptionHelper.CANCELLED;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7060a.mo3501a(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7060a.mo3489a();
        }
    }
}
