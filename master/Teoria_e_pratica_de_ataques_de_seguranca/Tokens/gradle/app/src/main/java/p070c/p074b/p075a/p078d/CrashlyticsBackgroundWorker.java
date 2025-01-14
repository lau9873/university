package p070c.p074b.p075a.p078d;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: c.b.a.d.g */
/* loaded from: classes.dex */
public class CrashlyticsBackgroundWorker {

    /* renamed from: a */
    public final ExecutorService f4826a;

    /* compiled from: CrashlyticsBackgroundWorker.java */
    /* renamed from: c.b.a.d.g$a */
    /* loaded from: classes.dex */
    public class RunnableC0827a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Runnable f4827a;

        public RunnableC0827a(CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, Runnable runnable) {
            this.f4827a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4827a.run();
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Failed to execute task.", e);
            }
        }
    }

    /* compiled from: CrashlyticsBackgroundWorker.java */
    /* renamed from: c.b.a.d.g$b */
    /* loaded from: classes.dex */
    public class CallableC0828b implements Callable<T> {

        /* renamed from: a */
        public final /* synthetic */ Callable f4828a;

        public CallableC0828b(CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, Callable callable) {
            this.f4828a = callable;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public T call() {
            try {
                return this.f4828a.call();
            } catch (Exception e) {
                Fabric.m4197h().mo4159c("CrashlyticsCore", "Failed to execute task.", e);
                return null;
            }
        }
    }

    public CrashlyticsBackgroundWorker(ExecutorService executorService) {
        this.f4826a = executorService;
    }

    /* renamed from: a */
    public Future<?> m5893a(Runnable runnable) {
        try {
            return this.f4826a.submit(new RunnableC0827a(this, runnable));
        } catch (RejectedExecutionException unused) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    /* renamed from: b */
    public <T> T m5891b(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f4826a.submit(callable).get(4L, TimeUnit.SECONDS);
            }
            return this.f4826a.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }

    /* renamed from: a */
    public <T> Future<T> m5892a(Callable<T> callable) {
        try {
            return this.f4826a.submit(new CallableC0828b(this, callable));
        } catch (RejectedExecutionException unused) {
            Fabric.m4197h().mo4157e("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
