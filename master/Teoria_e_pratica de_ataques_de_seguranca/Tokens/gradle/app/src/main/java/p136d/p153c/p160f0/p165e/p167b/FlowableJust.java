package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.p160f0.p163c.ScalarCallable;
import p136d.p153c.p160f0.p174i.ScalarSubscription;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.n */
/* loaded from: classes.dex */
public final class FlowableJust<T> extends Flowable<T> implements ScalarCallable<T> {

    /* renamed from: b */
    public final T f7210b;

    public FlowableJust(T t) {
        this.f7210b = t;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        subscriber.mo2188a((Subscription) new ScalarSubscription(subscriber, this.f7210b));
    }

    @Override // p136d.p153c.p160f0.p163c.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.f7210b;
    }
}
