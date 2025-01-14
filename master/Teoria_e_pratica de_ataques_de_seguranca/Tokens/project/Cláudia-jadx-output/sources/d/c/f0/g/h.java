package d.c.f0.g;

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
/* compiled from: SchedulerPoolFactory.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5323a;

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f5324b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<ScheduledThreadPoolExecutor, Object> f5325c = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                Iterator it = new ArrayList(h.f5325c.keySet()).iterator();
                while (it.hasNext()) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        h.f5325c.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
            } catch (Throwable th) {
                d.c.h0.a.b(th);
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        int i2 = 1;
        if (properties.containsKey("rx2.purge-enabled") && Boolean.getBoolean("rx2.purge-enabled") && properties.containsKey("rx2.purge-period-seconds")) {
            i2 = Integer.getInteger("rx2.purge-period-seconds", 1).intValue();
        }
        f5323a = i2;
        a();
    }

    public static void a() {
        while (true) {
            ScheduledExecutorService scheduledExecutorService = f5324b.get();
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new f("RxSchedulerPurge"));
            if (f5324b.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                a aVar = new a();
                int i2 = f5323a;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor) {
            f5325c.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }
}
