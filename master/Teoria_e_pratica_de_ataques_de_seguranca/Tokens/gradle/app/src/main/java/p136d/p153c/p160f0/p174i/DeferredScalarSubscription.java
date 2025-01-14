package p136d.p153c.p160f0.p174i;

import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.i.c */
/* loaded from: classes.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {

    /* renamed from: a */
    public final Subscriber<? super T> f7688a;

    /* renamed from: b */
    public T f7689b;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.f7688a = subscriber;
    }

    @Override // p193g.p204b.Subscription
    /* renamed from: a */
    public final void mo2185a(long j) {
        T t;
        if (SubscriptionHelper.m3424c(j)) {
            do {
                int i = get();
                if ((i & (-2)) != 0) {
                    return;
                }
                if (i == 1) {
                    if (!compareAndSet(1, 3) || (t = this.f7689b) == null) {
                        return;
                    }
                    this.f7689b = null;
                    Subscriber<? super T> subscriber = this.f7688a;
                    subscriber.mo2187a((Subscriber<? super T>) t);
                    if (get() != 4) {
                        subscriber.mo2189a();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    /* renamed from: b */
    public final boolean m3442b() {
        return get() == 4;
    }

    public void cancel() {
        set(4);
        this.f7689b = null;
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.f7689b = null;
    }

    /* renamed from: d */
    public final void m3441d(T t) {
        int i = get();
        while (i != 8) {
            if ((i & (-3)) != 0) {
                return;
            }
            if (i == 2) {
                lazySet(3);
                Subscriber<? super T> subscriber = this.f7688a;
                subscriber.mo2187a((Subscriber<? super T>) t);
                if (get() != 4) {
                    subscriber.mo2189a();
                    return;
                }
                return;
            }
            this.f7689b = t;
            if (compareAndSet(0, 1)) {
                return;
            }
            i = get();
            if (i == 4) {
                this.f7689b = null;
                return;
            }
        }
        this.f7689b = t;
        lazySet(16);
        Subscriber<? super T> subscriber2 = this.f7688a;
        subscriber2.mo2187a((Subscriber<? super T>) t);
        if (get() != 4) {
            subscriber2.mo2189a();
        }
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public final T poll() {
        if (get() == 16) {
            lazySet(32);
            T t = this.f7689b;
            this.f7689b = null;
            return t;
        }
        return null;
    }

    @Override // p136d.p153c.p160f0.p163c.QueueFuseable
    /* renamed from: a */
    public final int mo3356a(int i) {
        if ((i & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }
}
