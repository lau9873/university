package p136d.p153c.p160f0.p174i;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.i.g */
/* loaded from: classes.dex */
public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    /* renamed from: a */
    public static boolean m3431a(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.m3371b(new NullPointerException("next is null"));
            return false;
        } else if (subscription != null) {
            subscription2.cancel();
            m3426b();
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: b */
    public static void m3426b() {
        RxJavaPlugins.m3371b(new ProtocolViolationException("Subscription already set!"));
    }

    /* renamed from: c */
    public static boolean m3424c(long j) {
        if (j <= 0) {
            RxJavaPlugins.m3371b(new IllegalArgumentException("n > 0 required but it was " + j));
            return false;
        }
        return true;
    }

    @Override // p193g.p204b.Subscription
    /* renamed from: a */
    public void mo2185a(long j) {
    }

    @Override // p193g.p204b.Subscription
    public void cancel() {
    }

    /* renamed from: b */
    public static void m3425b(long j) {
        RxJavaPlugins.m3371b(new ProtocolViolationException("More produced than requested: " + j));
    }

    /* renamed from: a */
    public static boolean m3432a(Subscription subscription) {
        return subscription == CANCELLED;
    }

    /* renamed from: a */
    public static boolean m3429a(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        ObjectHelper.m3598a(subscription, "d is null");
        if (atomicReference.compareAndSet(null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() != CANCELLED) {
            m3426b();
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3430a(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == CANCELLED) {
            return false;
        }
        if (andSet != null) {
            andSet.cancel();
            return true;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m3427a(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (m3429a(atomicReference, subscription)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                subscription.mo2185a(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static void m3428a(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.mo2185a(j);
        } else if (m3424c(j)) {
            BackpressureHelper.m3416a(atomicLong, j);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.mo2185a(andSet);
                }
            }
        }
    }
}
