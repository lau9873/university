package d.a.a.a.m.c;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: PriorityThreadPoolExecutor.java */
/* loaded from: classes.dex */
public class l extends ThreadPoolExecutor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4348a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b  reason: collision with root package name */
    public static final int f4349b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4350c;

    /* compiled from: PriorityThreadPoolExecutor.java */
    /* loaded from: classes.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final int f4351a;

        public a(int i2) {
            this.f4351a = i2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f4351a);
            thread.setName("Queue");
            return thread;
        }
    }

    static {
        int i2 = f4348a;
        f4349b = i2 + 1;
        f4350c = (i2 * 2) + 1;
    }

    public <T extends Runnable & c & m & j> l(int i2, int i3, long j, TimeUnit timeUnit, d<T> dVar, ThreadFactory threadFactory) {
        super(i2, i3, j, timeUnit, dVar, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & c & m & j> l a(int i2, int i3) {
        return new l(i2, i3, 1L, TimeUnit.SECONDS, new d(), new a(10));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        m mVar = (m) runnable;
        mVar.a(true);
        mVar.a(th);
        getQueue().a();
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (k.b(runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new i(runnable, t);
    }

    public static l a() {
        return a(f4349b, f4350c);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public d getQueue() {
        return (d) super.getQueue();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new i(callable);
    }
}
