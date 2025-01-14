package p136d.p153c.p160f0.p174i;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.i.f */
/* loaded from: classes.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {

    /* renamed from: a */
    public Subscription f7694a;

    /* renamed from: b */
    public long f7695b;

    /* renamed from: c */
    public final AtomicReference<Subscription> f7696c = new AtomicReference<>();

    /* renamed from: d */
    public final AtomicLong f7697d = new AtomicLong();

    /* renamed from: e */
    public final AtomicLong f7698e = new AtomicLong();

    /* renamed from: f */
    public volatile boolean f7699f;

    /* renamed from: g */
    public boolean f7700g;

    @Override // p193g.p204b.Subscription
    /* renamed from: a */
    public final void mo2185a(long j) {
        if (!SubscriptionHelper.m3424c(j) || this.f7700g) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.f7695b;
            if (j2 != Long.MAX_VALUE) {
                long m3417a = BackpressureHelper.m3417a(j2, j);
                this.f7695b = m3417a;
                if (m3417a == Long.MAX_VALUE) {
                    this.f7700g = true;
                }
            }
            Subscription subscription = this.f7694a;
            if (decrementAndGet() != 0) {
                m3435c();
            }
            if (subscription != null) {
                subscription.mo2185a(j);
                return;
            }
            return;
        }
        BackpressureHelper.m3416a(this.f7697d, j);
        m3438b();
    }

    /* renamed from: b */
    public final void m3436b(Subscription subscription) {
        if (this.f7699f) {
            subscription.cancel();
            return;
        }
        ObjectHelper.m3598a(subscription, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscription subscription2 = this.f7694a;
            if (subscription2 != null) {
                subscription2.cancel();
            }
            this.f7694a = subscription;
            long j = this.f7695b;
            if (decrementAndGet() != 0) {
                m3435c();
            }
            if (j != 0) {
                subscription.mo2185a(j);
                return;
            }
            return;
        }
        Subscription andSet = this.f7696c.getAndSet(subscription);
        if (andSet != null) {
            andSet.cancel();
        }
        m3438b();
    }

    /* renamed from: c */
    public final void m3435c() {
        Subscription subscription = null;
        long j = 0;
        int i = 1;
        do {
            Subscription subscription2 = this.f7696c.get();
            if (subscription2 != null) {
                subscription2 = this.f7696c.getAndSet(null);
            }
            long j2 = this.f7697d.get();
            if (j2 != 0) {
                j2 = this.f7697d.getAndSet(0L);
            }
            long j3 = this.f7698e.get();
            if (j3 != 0) {
                j3 = this.f7698e.getAndSet(0L);
            }
            Subscription subscription3 = this.f7694a;
            if (this.f7699f) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.f7694a = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j4 = this.f7695b;
                if (j4 != Long.MAX_VALUE) {
                    j4 = BackpressureHelper.m3417a(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        long j5 = j4 - j3;
                        if (j5 < 0) {
                            SubscriptionHelper.m3425b(j5);
                            j5 = 0;
                        }
                        j4 = j5;
                    }
                    this.f7695b = j4;
                }
                if (subscription2 != null) {
                    if (subscription3 != null) {
                        subscription3.cancel();
                    }
                    this.f7694a = subscription2;
                    if (j4 != 0) {
                        j = BackpressureHelper.m3417a(j, j4);
                        subscription = subscription2;
                    }
                } else if (subscription3 != null && j2 != 0) {
                    j = BackpressureHelper.m3417a(j, j2);
                    subscription = subscription3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            subscription.mo2185a(j);
        }
    }

    public void cancel() {
        if (this.f7699f) {
            return;
        }
        this.f7699f = true;
        m3438b();
    }

    /* renamed from: d */
    public final boolean m3434d() {
        return this.f7699f;
    }

    /* renamed from: e */
    public final boolean m3433e() {
        return this.f7700g;
    }

    /* renamed from: b */
    public final void m3437b(long j) {
        if (this.f7700g) {
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            long j2 = this.f7695b;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                long j4 = 0;
                if (j3 < 0) {
                    SubscriptionHelper.m3425b(j3);
                } else {
                    j4 = j3;
                }
                this.f7695b = j4;
            }
            if (decrementAndGet() == 0) {
                return;
            }
            m3435c();
            return;
        }
        BackpressureHelper.m3416a(this.f7698e, j);
        m3438b();
    }

    /* renamed from: b */
    public final void m3438b() {
        if (getAndIncrement() != 0) {
            return;
        }
        m3435c();
    }
}
