package p136d.p153c.p160f0.p174i;

import p136d.p153c.p160f0.p163c.QueueSubscription;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.i.d */
/* loaded from: classes.dex */
public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    @Override // p136d.p153c.p160f0.p163c.QueueFuseable
    /* renamed from: a */
    public int mo3356a(int i) {
        return i & 2;
    }

    @Override // p193g.p204b.Subscription
    /* renamed from: a */
    public void mo2185a(long j) {
        SubscriptionHelper.m3424c(j);
    }

    @Override // p193g.p204b.Subscription
    public void cancel() {
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public void clear() {
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    /* renamed from: a */
    public static void m3439a(Throwable th, Subscriber<?> subscriber) {
        subscriber.mo2188a((Subscription) INSTANCE);
        subscriber.mo2186a(th);
    }

    /* renamed from: a */
    public static void m3440a(Subscriber<?> subscriber) {
        subscriber.mo2188a((Subscription) INSTANCE);
        subscriber.mo2189a();
    }
}
