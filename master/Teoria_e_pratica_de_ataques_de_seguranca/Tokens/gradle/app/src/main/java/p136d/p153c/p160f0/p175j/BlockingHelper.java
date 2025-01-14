package p136d.p153c.p160f0.p175j;

import p136d.p153c.p160f0.p172g.NonBlockingThread;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.j.d */
/* loaded from: classes.dex */
public final class BlockingHelper {
    /* renamed from: a */
    public static void m3414a() {
        if (RxJavaPlugins.m3391a()) {
            if ((Thread.currentThread() instanceof NonBlockingThread) || RxJavaPlugins.m3373b()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
