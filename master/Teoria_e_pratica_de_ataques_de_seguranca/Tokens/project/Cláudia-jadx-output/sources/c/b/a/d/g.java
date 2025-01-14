package c.b.a.d;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
/* compiled from: CrashlyticsBackgroundWorker.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f3013a;

    /* compiled from: CrashlyticsBackgroundWorker.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f3014a;

        public a(g gVar, Runnable runnable) {
            this.f3014a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f3014a.run();
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "Failed to execute task.", e2);
            }
        }
    }

    /* compiled from: CrashlyticsBackgroundWorker.java */
    /* loaded from: classes.dex */
    public class b implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callable f3015a;

        public b(g gVar, Callable callable) {
            this.f3015a = callable;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public T call() {
            try {
                return this.f3015a.call();
            } catch (Exception e2) {
                d.a.a.a.c.h().c("CrashlyticsCore", "Failed to execute task.", e2);
                return null;
            }
        }
    }

    public g(ExecutorService executorService) {
        this.f3013a = executorService;
    }

    public Future<?> a(Runnable runnable) {
        try {
            return this.f3013a.submit(new a(this, runnable));
        } catch (RejectedExecutionException unused) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    public <T> T b(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f3013a.submit(callable).get(4L, TimeUnit.SECONDS);
            }
            return this.f3013a.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e2) {
            d.a.a.a.c.h().c("CrashlyticsCore", "Failed to execute task.", e2);
            return null;
        }
    }

    public <T> Future<T> a(Callable<T> callable) {
        try {
            return this.f3013a.submit(new b(this, callable));
        } catch (RejectedExecutionException unused) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
