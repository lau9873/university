package p136d.p153c.p160f0.p175j;

import java.util.concurrent.atomic.AtomicLong;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.j.c */
/* loaded from: classes.dex */
public final class BackpressureHelper {
    /* renamed from: a */
    public static long m3417a(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    /* renamed from: a */
    public static long m3416a(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, m3417a(j2, j)));
        return j2;
    }

    /* renamed from: b */
    public static long m3415b(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j3 = j2 - j;
            if (j3 < 0) {
                RxJavaPlugins.m3371b(new IllegalStateException("More produced than requested: " + j3));
                j3 = 0L;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j3;
    }
}
