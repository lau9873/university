package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.r */
/* loaded from: classes.dex */
public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7090b.m3347a((FlowableSubscriber) new C1624a(subscriber));
    }

    /* compiled from: FlowableOnBackpressureLatest.java */
    /* renamed from: d.c.f0.e.b.r$a */
    /* loaded from: classes.dex */
    public static final class C1624a<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: a */
        public final Subscriber<? super T> f7233a;

        /* renamed from: b */
        public Subscription f7234b;

        /* renamed from: c */
        public volatile boolean f7235c;

        /* renamed from: d */
        public Throwable f7236d;

        /* renamed from: e */
        public volatile boolean f7237e;

        /* renamed from: f */
        public final AtomicLong f7238f = new AtomicLong();

        /* renamed from: g */
        public final AtomicReference<T> f7239g = new AtomicReference<>();

        public C1624a(Subscriber<? super T> subscriber) {
            this.f7233a = subscriber;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7234b, subscription)) {
                this.f7234b = subscription;
                this.f7233a.mo2188a((Subscription) this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        /* renamed from: b */
        public void m3540b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.f7233a;
            AtomicLong atomicLong = this.f7238f;
            AtomicReference<T> atomicReference = this.f7239g;
            int i = 1;
            do {
                long j = 0;
                while (true) {
                    if (j == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.f7235c;
                    Object obj = (T) atomicReference.getAndSet(null);
                    boolean z2 = obj == null;
                    if (m3541a(z, z2, subscriber, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.mo2187a((Subscriber<? super T>) obj);
                    j++;
                }
                if (j == atomicLong.get()) {
                    if (m3541a(this.f7235c, atomicReference.get() == null, subscriber, atomicReference)) {
                        return;
                    }
                }
                if (j != 0) {
                    BackpressureHelper.m3415b(atomicLong, j);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            if (this.f7237e) {
                return;
            }
            this.f7237e = true;
            this.f7234b.cancel();
            if (getAndIncrement() == 0) {
                this.f7239g.lazySet(null);
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            this.f7239g.lazySet(t);
            m3540b();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7236d = th;
            this.f7235c = true;
            m3540b();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7235c = true;
            m3540b();
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            if (SubscriptionHelper.m3424c(j)) {
                BackpressureHelper.m3416a(this.f7238f, j);
                m3540b();
            }
        }

        /* renamed from: a */
        public boolean m3541a(boolean z, boolean z2, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.f7237e) {
                atomicReference.lazySet(null);
                return true;
            } else if (z) {
                Throwable th = this.f7236d;
                if (th != null) {
                    atomicReference.lazySet(null);
                    subscriber.mo2186a(th);
                    return true;
                } else if (z2) {
                    subscriber.mo2189a();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
