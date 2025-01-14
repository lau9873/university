package a.b.g.b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ModernAsyncTask.java */
/* loaded from: classes.dex */
public abstract class e<Params, Progress, Result> {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadFactory f864f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final BlockingQueue<Runnable> f865g = new LinkedBlockingQueue(10);

    /* renamed from: h  reason: collision with root package name */
    public static final Executor f866h = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f865g, f864f);

    /* renamed from: i  reason: collision with root package name */
    public static f f867i;

    /* renamed from: c  reason: collision with root package name */
    public volatile g f870c = g.PENDING;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f871d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f872e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final h<Params, Result> f868a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final FutureTask<Result> f869b = new c(this.f868a);

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f873a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f873a.getAndIncrement());
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public class b extends h<Params, Result> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() {
            e.this.f872e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) e.this.a((Object[]) this.f883a);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                e.this.e(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                e.this.e(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f876a = new int[g.values().length];

        static {
            try {
                f876a[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f876a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019e<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final e f877a;

        /* renamed from: b  reason: collision with root package name */
        public final Data[] f878b;

        public C0019e(e eVar, Data... dataArr) {
            this.f877a = eVar;
            this.f878b = dataArr;
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0019e c0019e = (C0019e) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                c0019e.f877a.a((e) c0019e.f878b[0]);
            } else if (i2 != 2) {
            } else {
                c0019e.f877a.b((Object[]) c0019e.f878b);
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: ModernAsyncTask.java */
    /* loaded from: classes.dex */
    public static abstract class h<Params, Result> implements Callable<Result> {

        /* renamed from: a  reason: collision with root package name */
        public Params[] f883a;
    }

    public static Handler d() {
        f fVar;
        synchronized (e.class) {
            if (f867i == null) {
                f867i = new f();
            }
            fVar = f867i;
        }
        return fVar;
    }

    public abstract Result a(Params... paramsArr);

    public final boolean a() {
        return this.f871d.get();
    }

    public void b() {
    }

    public void b(Result result) {
        b();
    }

    public void b(Progress... progressArr) {
    }

    public void c() {
    }

    public void c(Result result) {
    }

    public void e(Result result) {
        if (this.f872e.get()) {
            return;
        }
        d(result);
    }

    public final boolean a(boolean z) {
        this.f871d.set(true);
        return this.f869b.cancel(z);
    }

    public final e<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.f870c != g.PENDING) {
            int i2 = d.f876a[this.f870c.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.f870c = g.RUNNING;
        c();
        this.f868a.f883a = paramsArr;
        executor.execute(this.f869b);
        return this;
    }

    public Result d(Result result) {
        d().obtainMessage(1, new C0019e(this, result)).sendToTarget();
        return result;
    }

    public void a(Result result) {
        if (a()) {
            b((e<Params, Progress, Result>) result);
        } else {
            c(result);
        }
        this.f870c = g.FINISHED;
    }
}
