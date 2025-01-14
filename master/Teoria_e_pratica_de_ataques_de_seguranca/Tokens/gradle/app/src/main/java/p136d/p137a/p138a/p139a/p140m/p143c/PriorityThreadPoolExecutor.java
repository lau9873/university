package p136d.p137a.p138a.p139a.p140m.p143c;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: d.a.a.a.m.c.l */
/* loaded from: classes.dex */
public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {

    /* renamed from: a */
    public static final int f6552a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    public static final int f6553b;

    /* renamed from: c */
    public static final int f6554c;

    /* compiled from: PriorityThreadPoolExecutor.java */
    /* renamed from: d.a.a.a.m.c.l$a */
    /* loaded from: classes.dex */
    public static final class ThreadFactoryC1515a implements ThreadFactory {

        /* renamed from: a */
        public final int f6555a;

        public ThreadFactoryC1515a(int i) {
            this.f6555a = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f6555a);
            thread.setName("Queue");
            return thread;
        }
    }

    static {
        int i = f6552a;
        f6553b = i + 1;
        f6554c = (i * 2) + 1;
    }

    public <T extends Runnable & Dependency & Task & PriorityProvider> PriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        prestartAllCoreThreads();
    }

    /* renamed from: a */
    public static <T extends Runnable & Dependency & Task & PriorityProvider> PriorityThreadPoolExecutor m3965a(int i, int i2) {
        return new PriorityThreadPoolExecutor(i, i2, 1L, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new ThreadFactoryC1515a(10));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        Task task = (Task) runnable;
        task.mo3963a(true);
        task.mo3964a(th);
        getQueue().m3986a();
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (PriorityTask.m3969b(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new PriorityFutureTask(runnable, t);
    }

    /* renamed from: a */
    public static PriorityThreadPoolExecutor m3966a() {
        return m3965a(f6553b, f6554c);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public DependencyPriorityBlockingQueue getQueue() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new PriorityFutureTask(callable);
    }
}
