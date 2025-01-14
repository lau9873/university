package p136d.p153c.p160f0.p172g;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.g.h */
/* loaded from: classes.dex */
public final class SchedulerPoolFactory {

    /* renamed from: a */
    public static final int f7659a;

    /* renamed from: b */
    public static final AtomicReference<ScheduledExecutorService> f7660b = new AtomicReference<>();

    /* renamed from: c */
    public static final Map<ScheduledThreadPoolExecutor, Object> f7661c = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: d.c.f0.g.h$a */
    /* loaded from: classes.dex */
    public static class RunnableC1709a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = new ArrayList(SchedulerPoolFactory.f7661c.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        SchedulerPoolFactory.f7661c.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                RxJavaPlugins.m3371b(th);
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        int i = 1;
        if (properties.containsKey("rx2.purge-enabled") && Boolean.getBoolean("rx2.purge-enabled") && properties.containsKey("rx2.purge-period-seconds")) {
            i = Integer.getInteger("rx2.purge-period-seconds", 1).intValue();
        }
        f7659a = i;
        m3448a();
    }

    /* renamed from: a */
    public static void m3448a() {
        while (true) {
            ScheduledExecutorService scheduledExecutorService = f7660b.get();
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (f7660b.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                RunnableC1709a runnableC1709a = new RunnableC1709a();
                int i = f7659a;
                newScheduledThreadPool.scheduleAtFixedRate(runnableC1709a, i, i, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    /* renamed from: a */
    public static ScheduledExecutorService m3447a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor) {
            f7661c.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
