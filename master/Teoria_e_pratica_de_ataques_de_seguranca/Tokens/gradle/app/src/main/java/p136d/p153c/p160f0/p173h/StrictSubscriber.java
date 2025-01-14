package p136d.p153c.p160f0.p173h;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.AtomicThrowable;
import p136d.p153c.p160f0.p175j.HalfSerializer;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.h.a */
/* loaded from: classes.dex */
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

    /* renamed from: a */
    public final Subscriber<? super T> f7682a;

    /* renamed from: b */
    public final AtomicThrowable f7683b = new AtomicThrowable();

    /* renamed from: c */
    public final AtomicLong f7684c = new AtomicLong();

    /* renamed from: d */
    public final AtomicReference<Subscription> f7685d = new AtomicReference<>();

    /* renamed from: e */
    public final AtomicBoolean f7686e = new AtomicBoolean();

    /* renamed from: f */
    public volatile boolean f7687f;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.f7682a = subscriber;
    }

    @Override // p193g.p204b.Subscription
    /* renamed from: a */
    public void mo2185a(long j) {
        if (j <= 0) {
            cancel();
            mo2186a((Throwable) new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
            return;
        }
        SubscriptionHelper.m3428a(this.f7685d, this.f7684c, j);
    }

    @Override // p193g.p204b.Subscription
    public void cancel() {
        if (this.f7687f) {
            return;
        }
        SubscriptionHelper.m3430a(this.f7685d);
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2188a(Subscription subscription) {
        if (this.f7686e.compareAndSet(false, true)) {
            this.f7682a.mo2188a((Subscription) this);
            SubscriptionHelper.m3427a(this.f7685d, this.f7684c, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        mo2186a((Throwable) new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2187a(T t) {
        HalfSerializer.m3410a(this.f7682a, t, this, this.f7683b);
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2186a(Throwable th) {
        this.f7687f = true;
        HalfSerializer.m3409a((Subscriber<?>) this.f7682a, th, (AtomicInteger) this, this.f7683b);
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2189a() {
        this.f7687f = true;
        HalfSerializer.m3408a(this.f7682a, this, this.f7683b);
    }
}
