package p136d.p137a.p138a.p139a.p140m.p142b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;

/* renamed from: d.a.a.a.m.b.n */
/* loaded from: classes.dex */
public final class ExecutorUtils {

    /* compiled from: ExecutorUtils.java */
    /* renamed from: d.a.a.a.m.b.n$a */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC1494a implements ThreadFactory {

        /* renamed from: a */
        public final /* synthetic */ String f6458a;

        /* renamed from: b */
        public final /* synthetic */ AtomicLong f6459b;

        /* compiled from: ExecutorUtils.java */
        /* renamed from: d.a.a.a.m.b.n$a$a */
        /* loaded from: classes.dex */
        public class C1495a extends BackgroundPriorityRunnable {

            /* renamed from: a */
            public final /* synthetic */ Runnable f6460a;

            public C1495a(ThreadFactoryC1494a threadFactoryC1494a, Runnable runnable) {
                this.f6460a = runnable;
            }

            @Override // p136d.p137a.p138a.p139a.p140m.p142b.BackgroundPriorityRunnable
            /* renamed from: a */
            public void mo4057a() {
                this.f6460a.run();
            }
        }

        public ThreadFactoryC1494a(String str, AtomicLong atomicLong) {
            this.f6458a = str;
            this.f6459b = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C1495a(this, runnable));
            newThread.setName(this.f6458a + this.f6459b.getAndIncrement());
            return newThread;
        }
    }

    /* compiled from: ExecutorUtils.java */
    /* renamed from: d.a.a.a.m.b.n$b */
    /* loaded from: classes.dex */
    public static class C1496b extends BackgroundPriorityRunnable {

        /* renamed from: a */
        public final /* synthetic */ String f6461a;

        /* renamed from: b */
        public final /* synthetic */ ExecutorService f6462b;

        /* renamed from: c */
        public final /* synthetic */ long f6463c;

        /* renamed from: d */
        public final /* synthetic */ TimeUnit f6464d;

        public C1496b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.f6461a = str;
            this.f6462b = executorService;
            this.f6463c = j;
            this.f6464d = timeUnit;
        }

        @Override // p136d.p137a.p138a.p139a.p140m.p142b.BackgroundPriorityRunnable
        /* renamed from: a */
        public void mo4057a() {
            try {
                Logger m4197h = Fabric.m4197h();
                m4197h.mo4157e("Fabric", "Executing shutdown hook for " + this.f6461a);
                this.f6462b.shutdown();
                if (this.f6462b.awaitTermination(this.f6463c, this.f6464d)) {
                    return;
                }
                Logger m4197h2 = Fabric.m4197h();
                m4197h2.mo4157e("Fabric", this.f6461a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f6462b.shutdownNow();
            } catch (InterruptedException unused) {
                Fabric.m4197h().mo4157e("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f6461a));
                this.f6462b.shutdownNow();
            }
        }
    }

    /* renamed from: a */
    public static ExecutorService m4062a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(m4058c(str));
        m4061a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: b */
    public static ScheduledExecutorService m4059b(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(m4058c(str));
        m4061a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    /* renamed from: c */
    public static final ThreadFactory m4058c(String str) {
        return new ThreadFactoryC1494a(str, new AtomicLong(1L));
    }

    /* renamed from: a */
    public static final void m4061a(String str, ExecutorService executorService) {
        m4060a(str, executorService, 2L, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public static final void m4060a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        C1496b c1496b = new C1496b(str, executorService, j, timeUnit);
        runtime.addShutdownHook(new Thread(c1496b, "Crashlytics Shutdown Hook for " + str));
    }
}
