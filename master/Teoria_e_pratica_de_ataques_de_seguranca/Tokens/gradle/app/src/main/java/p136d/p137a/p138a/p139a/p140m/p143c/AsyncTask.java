package p136d.p137a.p138a.p139a.p140m.p143c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.j256.ormlite.logger.Logger;
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

/* renamed from: d.a.a.a.m.c.a */
/* loaded from: classes.dex */
public abstract class AsyncTask<Params, Progress, Result> {

    /* renamed from: f */
    public static final int f6509f = Runtime.getRuntime().availableProcessors();

    /* renamed from: g */
    public static final int f6510g;

    /* renamed from: h */
    public static final int f6511h;

    /* renamed from: i */
    public static final ThreadFactory f6512i;

    /* renamed from: j */
    public static final BlockingQueue<Runnable> f6513j;

    /* renamed from: k */
    public static final Executor f6514k;

    /* renamed from: m */
    public static final Executor f6515m;

    /* renamed from: n */
    public static final HandlerC1508f f6516n;

    /* renamed from: c */
    public volatile EnumC1511h f6519c = EnumC1511h.PENDING;

    /* renamed from: d */
    public final AtomicBoolean f6520d = new AtomicBoolean();

    /* renamed from: e */
    public final AtomicBoolean f6521e = new AtomicBoolean();

    /* renamed from: a */
    public final AbstractCallableC1512i<Params, Result> f6517a = new C1504b();

    /* renamed from: b */
    public final FutureTask<Result> f6518b = new C1505c(this.f6517a);

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$a */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC1503a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f6522a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f6522a.getAndIncrement());
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$b */
    /* loaded from: classes.dex */
    public class C1504b extends AbstractCallableC1512i<Params, Result> {
        public C1504b() {
            super(null);
        }

        @Override // java.util.concurrent.Callable
        public Result call() {
            AsyncTask.this.f6521e.set(true);
            Process.setThreadPriority(10);
            AsyncTask asyncTask = AsyncTask.this;
            Result result = (Result) asyncTask.mo4000a(this.f6536a);
            asyncTask.m3991e(result);
            return result;
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$c */
    /* loaded from: classes.dex */
    public class C1505c extends FutureTask<Result> {
        public C1505c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                AsyncTask.this.m3989f(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (CancellationException unused) {
                AsyncTask.this.m3989f(null);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            }
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$d */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1506d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6525a = new int[EnumC1511h.values().length];

        static {
            try {
                f6525a[EnumC1511h.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6525a[EnumC1511h.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$e */
    /* loaded from: classes.dex */
    public static class C1507e<Data> {

        /* renamed from: a */
        public final AsyncTask f6526a;

        /* renamed from: b */
        public final Data[] f6527b;

        public C1507e(AsyncTask asyncTask, Data... dataArr) {
            this.f6526a = asyncTask;
            this.f6527b = dataArr;
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$f */
    /* loaded from: classes.dex */
    public static class HandlerC1508f extends Handler {
        public HandlerC1508f() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1507e c1507e = (C1507e) message.obj;
            int i = message.what;
            if (i == 1) {
                c1507e.f6526a.m3998b((AsyncTask) c1507e.f6527b[0]);
            } else if (i != 2) {
            } else {
                c1507e.f6526a.m3996b((Object[]) c1507e.f6527b);
            }
        }
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$h */
    /* loaded from: classes.dex */
    public enum EnumC1511h {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$i */
    /* loaded from: classes.dex */
    public static abstract class AbstractCallableC1512i<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        public Params[] f6536a;

        public AbstractCallableC1512i() {
        }

        public /* synthetic */ AbstractCallableC1512i(ThreadFactoryC1503a threadFactoryC1503a) {
            this();
        }
    }

    static {
        int i = f6509f;
        f6510g = i + 1;
        f6511h = (i * 2) + 1;
        f6512i = new ThreadFactoryC1503a();
        f6513j = new LinkedBlockingQueue((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        f6514k = new ThreadPoolExecutor(f6510g, f6511h, 1L, TimeUnit.SECONDS, f6513j, f6512i);
        f6515m = new ExecutorC1509g(null);
        f6516n = new HandlerC1508f();
    }

    /* renamed from: a */
    public abstract Result mo4000a(Params... paramsArr);

    /* renamed from: b */
    public void m3996b(Progress... progressArr) {
    }

    /* renamed from: c */
    public abstract void mo3994c(Result result);

    /* renamed from: d */
    public abstract void mo3993d(Result result);

    /* renamed from: e */
    public final Result m3991e(Result result) {
        f6516n.obtainMessage(1, new C1507e(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: f */
    public final void m3989f(Result result) {
        if (this.f6521e.get()) {
            return;
        }
        m3991e(result);
    }

    /* renamed from: g */
    public void mo3988g() {
    }

    /* compiled from: AsyncTask.java */
    /* renamed from: d.a.a.a.m.c.a$g */
    /* loaded from: classes.dex */
    public static class ExecutorC1509g implements Executor {

        /* renamed from: a */
        public final LinkedList<Runnable> f6528a;

        /* renamed from: b */
        public Runnable f6529b;

        /* compiled from: AsyncTask.java */
        /* renamed from: d.a.a.a.m.c.a$g$a */
        /* loaded from: classes.dex */
        public class RunnableC1510a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Runnable f6530a;

            public RunnableC1510a(Runnable runnable) {
                this.f6530a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f6530a.run();
                } finally {
                    ExecutorC1509g.this.m3987a();
                }
            }
        }

        public ExecutorC1509g() {
            this.f6528a = new LinkedList<>();
        }

        /* renamed from: a */
        public synchronized void m3987a() {
            Runnable poll = this.f6528a.poll();
            this.f6529b = poll;
            if (poll != null) {
                AsyncTask.f6514k.execute(this.f6529b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f6528a.offer(new RunnableC1510a(runnable));
            if (this.f6529b == null) {
                m3987a();
            }
        }

        public /* synthetic */ ExecutorC1509g(ThreadFactoryC1503a threadFactoryC1503a) {
            this();
        }
    }

    /* renamed from: b */
    public final boolean m3997b(boolean z) {
        this.f6520d.set(true);
        return this.f6518b.cancel(z);
    }

    /* renamed from: a */
    public final AsyncTask<Params, Progress, Result> m4001a(Executor executor, Params... paramsArr) {
        if (this.f6519c != EnumC1511h.PENDING) {
            int i = C1506d.f6525a[this.f6519c.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f6519c = EnumC1511h.RUNNING;
        mo3988g();
        this.f6517a.f6536a = paramsArr;
        executor.execute(this.f6518b);
        return this;
    }

    /* renamed from: e */
    public final EnumC1511h m3992e() {
        return this.f6519c;
    }

    /* renamed from: f */
    public final boolean m3990f() {
        return this.f6520d.get();
    }

    /* renamed from: b */
    public final void m3998b(Result result) {
        if (m3990f()) {
            mo3994c(result);
        } else {
            mo3993d(result);
        }
        this.f6519c = EnumC1511h.FINISHED;
    }
}
