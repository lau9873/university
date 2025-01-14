package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p136d.p153c.Flowable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p174i.DeferredScalarSubscription;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.j */
/* loaded from: classes.dex */
public final class FlowableFromFuture<T> extends Flowable<T> {

    /* renamed from: b */
    public final Future<? extends T> f7197b;

    /* renamed from: c */
    public final long f7198c;

    /* renamed from: d */
    public final TimeUnit f7199d;

    public FlowableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f7197b = future;
        this.f7198c = j;
        this.f7199d = timeUnit;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.mo2188a((Subscription) deferredScalarSubscription);
        try {
            T t = this.f7199d != null ? this.f7197b.get(this.f7198c, this.f7199d) : this.f7197b.get();
            if (t == null) {
                subscriber.mo2186a((Throwable) new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.m3441d(t);
            }
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            if (deferredScalarSubscription.m3442b()) {
                return;
            }
            subscriber.mo2186a(th);
        }
    }
}
