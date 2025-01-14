package d.a.a.a.m.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
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
/* compiled from: AsyncTask.java */
/* loaded from: classes.dex */
public abstract class a<Params, Progress, Result> {

    /* renamed from: f  reason: collision with root package name */
    public static final int f4310f = Runtime.getRuntime().availableProcessors();

    /* renamed from: g  reason: collision with root package name */
    public static final int f4311g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f4312h;

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadFactory f4313i;
    public static final BlockingQueue<Runnable> j;
    public static final Executor k;
    public static final Executor m;
    public static final f n;

    /* renamed from: c  reason: collision with root package name */
    public volatile h f4316c = h.PENDING;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f4317d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f4318e = new AtomicBoolean();

    /* renamed from: a  reason: collision with root package name */
    public final i<Params, Result> f4314a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final FutureTask<Result> f4315b = new c(this.f4314a);

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC0088a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f4319a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f4319a.getAndIncrement());
        }
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public class b extends i<Params, Result> {
        public b() {
            super(null);
        }

        @Override // java.util.concurrent.Callable
        public Result call() {
            a.this.f4318e.set(true);
            Process.setThreadPriority(10);
            a aVar = a.this;
            Result result = (Result) aVar.a(this.f4333a);
            aVar.e(result);
            return result;
        }
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public class c extends FutureTask<Result> {
        public c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                a.this.f(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                a.this.f(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
            }
        }
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4322a = new int[h.values().length];

        static {
            try {
                f4322a[h.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4322a[h.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public static class e<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final a f4323a;

        /* renamed from: b  reason: collision with root package name */
        public final Data[] f4324b;

        public e(a aVar, Data... dataArr) {
            this.f4323a = aVar;
            this.f4324b = dataArr;
        }
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                eVar.f4323a.b((a) eVar.f4324b[0]);
            } else if (i2 != 2) {
            } else {
                eVar.f4323a.b((Object[]) eVar.f4324b);
            }
        }
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public enum h {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public static abstract class i<Params, Result> implements Callable<Result> {

        /* renamed from: a  reason: collision with root package name */
        public Params[] f4333a;

        public i() {
        }

        public /* synthetic */ i(ThreadFactoryC0088a threadFactoryC0088a) {
            this();
        }
    }

    static {
        int i2 = f4310f;
        f4311g = i2 + 1;
        f4312h = (i2 * 2) + 1;
        f4313i = new ThreadFactoryC0088a();
        j = new LinkedBlockingQueue(128);
        k = new ThreadPoolExecutor(f4311g, f4312h, 1L, TimeUnit.SECONDS, j, f4313i);
        m = new g(null);
        n = new f();
    }

    public abstract Result a(Params... paramsArr);

    public void b(Progress... progressArr) {
    }

    public abstract void c(Result result);

    public abstract void d(Result result);

    public final Result e(Result result) {
        n.obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    public final void f(Result result) {
        if (this.f4318e.get()) {
            return;
        }
        e(result);
    }

    public void g() {
    }

    /* compiled from: AsyncTask.java */
    /* loaded from: classes.dex */
    public static class g implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Runnable> f4325a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f4326b;

        /* compiled from: AsyncTask.java */
        /* renamed from: d.a.a.a.m.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0089a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Runnable f4327a;

            public RunnableC0089a(Runnable runnable) {
                this.f4327a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f4327a.run();
                } finally {
                    g.this.a();
                }
            }
        }

        public g() {
            this.f4325a = new LinkedList<>();
        }

        public synchronized void a() {
            Runnable poll = this.f4325a.poll();
            this.f4326b = poll;
            if (poll != null) {
                a.k.execute(this.f4326b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f4325a.offer(new RunnableC0089a(runnable));
            if (this.f4326b == null) {
                a();
            }
        }

        public /* synthetic */ g(ThreadFactoryC0088a threadFactoryC0088a) {
            this();
        }
    }

    public final boolean b(boolean z) {
        this.f4317d.set(true);
        return this.f4315b.cancel(z);
    }

    public final a<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.f4316c != h.PENDING) {
            int i2 = d.f4322a[this.f4316c.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f4316c = h.RUNNING;
        g();
        this.f4314a.f4333a = paramsArr;
        executor.execute(this.f4315b);
        return this;
    }

    public final h e() {
        return this.f4316c;
    }

    public final boolean f() {
        return this.f4317d.get();
    }

    public final void b(Result result) {
        if (f()) {
            c(result);
        } else {
            d(result);
        }
        this.f4316c = h.FINISHED;
    }
}
