package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Flowable;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p174i.DeferredScalarSubscription;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.e.p0 */
/* loaded from: classes.dex */
public final class SingleToFlowable<T> extends Flowable<T> {

    /* renamed from: b */
    public final SingleSource<? extends T> f7531b;

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.f7531b = singleSource;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7531b.subscribe(new C1687a(subscriber));
    }

    /* compiled from: SingleToFlowable.java */
    /* renamed from: d.c.f0.e.e.p0$a */
    /* loaded from: classes.dex */
    public static final class C1687a<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {

        /* renamed from: c */
        public Disposable f7532c;

        public C1687a(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7532c, disposable)) {
                this.f7532c = disposable;
                this.f7688a.mo2188a((Subscription) this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            m3441d(t);
        }

        @Override // p136d.p153c.p160f0.p174i.DeferredScalarSubscription, p193g.p204b.Subscription
        public void cancel() {
            super.cancel();
            this.f7532c.mo578b();
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7688a.mo2186a(th);
        }
    }
}
