package p136d.p153c.p160f0.p175j;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.j.g */
/* loaded from: classes.dex */
public final class HalfSerializer {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T> void m3410a(Subscriber<? super T> subscriber, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.mo2187a((Subscriber<? super T>) t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable m3419a = atomicThrowable.m3419a();
                if (m3419a != null) {
                    subscriber.mo2186a(m3419a);
                } else {
                    subscriber.mo2189a();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m3409a(Subscriber<?> subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.m3418a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                subscriber.mo2186a(atomicThrowable.m3419a());
                return;
            }
            return;
        }
        RxJavaPlugins.m3371b(th);
    }

    /* renamed from: a */
    public static void m3408a(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable m3419a = atomicThrowable.m3419a();
            if (m3419a != null) {
                subscriber.mo2186a(m3419a);
            } else {
                subscriber.mo2189a();
            }
        }
    }
}
