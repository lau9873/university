package d.a.a.a.m.b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: ExecutorUtils.java */
/* loaded from: classes.dex */
public final class n {

    /* compiled from: ExecutorUtils.java */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4263a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicLong f4264b;

        /* compiled from: ExecutorUtils.java */
        /* renamed from: d.a.a.a.m.b.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0087a extends h {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Runnable f4265a;

            public C0087a(a aVar, Runnable runnable) {
                this.f4265a = runnable;
            }

            @Override // d.a.a.a.m.b.h
            public void a() {
                this.f4265a.run();
            }
        }

        public a(String str, AtomicLong atomicLong) {
            this.f4263a = str;
            this.f4264b = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C0087a(this, runnable));
            newThread.setName(this.f4263a + this.f4264b.getAndIncrement());
            return newThread;
        }
    }

    /* compiled from: ExecutorUtils.java */
    /* loaded from: classes.dex */
    public static class b extends h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4266a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f4267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f4268c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TimeUnit f4269d;

        public b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.f4266a = str;
            this.f4267b = executorService;
            this.f4268c = j;
            this.f4269d = timeUnit;
        }

        @Override // d.a.a.a.m.b.h
        public void a() {
            try {
                d.a.a.a.k h2 = d.a.a.a.c.h();
                h2.e("Fabric", "Executing shutdown hook for " + this.f4266a);
                this.f4267b.shutdown();
                if (this.f4267b.awaitTermination(this.f4268c, this.f4269d)) {
                    return;
                }
                d.a.a.a.k h3 = d.a.a.a.c.h();
                h3.e("Fabric", this.f4266a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f4267b.shutdownNow();
            } catch (InterruptedException unused) {
                d.a.a.a.c.h().e("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f4266a));
                this.f4267b.shutdownNow();
            }
        }
    }

    public static ExecutorService a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(c(str));
        a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService b(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(c(str));
        a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory c(String str) {
        return new a(str, new AtomicLong(1L));
    }

    public static final void a(String str, ExecutorService executorService) {
        a(str, executorService, 2L, TimeUnit.SECONDS);
    }

    public static final void a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        b bVar = new b(str, executorService, j, timeUnit);
        runtime.addShutdownHook(new Thread(bVar, "Crashlytics Shutdown Hook for " + str));
    }
}
