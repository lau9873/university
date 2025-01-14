package p136d.p153c.p160f0.p174i;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.p160f0.p163c.QueueSubscription;
import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.i.e */
/* loaded from: classes.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {

    /* renamed from: a */
    public final T f7692a;

    /* renamed from: b */
    public final Subscriber<? super T> f7693b;

    public ScalarSubscription(Subscriber<? super T> subscriber, T t) {
        this.f7693b = subscriber;
        this.f7692a = t;
    }

    @Override // p136d.p153c.p160f0.p163c.QueueFuseable
    /* renamed from: a */
    public int mo3356a(int i) {
        return i & 1;
    }

    @Override // p193g.p204b.Subscription
    /* renamed from: a */
    public void mo2185a(long j) {
        if (SubscriptionHelper.m3424c(j) && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber = this.f7693b;
            subscriber.mo2187a((Subscriber<? super T>) ((T) this.f7692a));
            if (get() != 2) {
                subscriber.mo2189a();
            }
        }
    }

    @Override // p193g.p204b.Subscription
    public void cancel() {
        lazySet(2);
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public void clear() {
        lazySet(1);
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.f7692a;
        }
        return null;
    }
}
