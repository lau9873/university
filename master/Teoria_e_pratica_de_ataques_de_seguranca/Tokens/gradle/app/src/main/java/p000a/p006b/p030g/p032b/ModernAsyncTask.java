package p000a.p006b.p030g.p032b;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.j256.ormlite.logger.Logger;
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

/* renamed from: a.b.g.b.e */
/* loaded from: classes.dex */
public abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: f */
    public static final ThreadFactory f1370f = new ThreadFactoryC0197a();

    /* renamed from: g */
    public static final BlockingQueue<Runnable> f1371g = new LinkedBlockingQueue(10);

    /* renamed from: h */
    public static final Executor f1372h = new ThreadPoolExecutor(5, (int) Logger.DEFAULT_FULL_MESSAGE_LENGTH, 1, TimeUnit.SECONDS, f1371g, f1370f);

    /* renamed from: i */
    public static HandlerC0202f f1373i;

    /* renamed from: c */
    public volatile EnumC0203g f1376c = EnumC0203g.PENDING;

    /* renamed from: d */
    public final AtomicBoolean f1377d = new AtomicBoolean();

    /* renamed from: e */
    public final AtomicBoolean f1378e = new AtomicBoolean();

    /* renamed from: a */
    public final AbstractCallableC0204h<Params, Result> f1374a = new C0198b();

    /* renamed from: b */
    public final FutureTask<Result> f1375b = new C0199c(this.f1374a);

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$a */
    /* loaded from: classes.dex */
    public static class ThreadFactoryC0197a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f1379a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f1379a.getAndIncrement());
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$b */
    /* loaded from: classes.dex */
    public class C0198b extends AbstractCallableC0204h<Params, Result> {
        public C0198b() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() {
            ModernAsyncTask.this.f1378e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) ModernAsyncTask.this.mo10005a((Object[]) this.f1389a);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$c */
    /* loaded from: classes.dex */
    public class C0199c extends FutureTask<Result> {
        public C0199c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                ModernAsyncTask.this.m9997e(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (CancellationException unused) {
                ModernAsyncTask.this.m9997e(null);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$d */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0200d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f1382a = new int[EnumC0203g.values().length];

        static {
            try {
                f1382a[EnumC0203g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1382a[EnumC0203g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$e */
    /* loaded from: classes.dex */
    public static class C0201e<Data> {

        /* renamed from: a */
        public final ModernAsyncTask f1383a;

        /* renamed from: b */
        public final Data[] f1384b;

        public C0201e(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f1383a = modernAsyncTask;
            this.f1384b = dataArr;
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$f */
    /* loaded from: classes.dex */
    public static class HandlerC0202f extends Handler {
        public HandlerC0202f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0201e c0201e = (C0201e) message.obj;
            int i = message.what;
            if (i == 1) {
                c0201e.f1383a.m10008a((ModernAsyncTask) c0201e.f1384b[0]);
            } else if (i != 2) {
            } else {
                c0201e.f1383a.m10002b((Object[]) c0201e.f1384b);
            }
        }
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$g */
    /* loaded from: classes.dex */
    public enum EnumC0203g {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* compiled from: ModernAsyncTask.java */
    /* renamed from: a.b.g.b.e$h */
    /* loaded from: classes.dex */
    public static abstract class AbstractCallableC0204h<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        public Params[] f1389a;
    }

    /* renamed from: d */
    public static Handler m9999d() {
        HandlerC0202f handlerC0202f;
        synchronized (ModernAsyncTask.class) {
            if (f1373i == null) {
                f1373i = new HandlerC0202f();
            }
            handlerC0202f = f1373i;
        }
        return handlerC0202f;
    }

    /* renamed from: a */
    public abstract Result mo10005a(Params... paramsArr);

    /* renamed from: a */
    public final boolean m10009a() {
        return this.f1377d.get();
    }

    /* renamed from: b */
    public void m10004b() {
    }

    /* renamed from: b */
    public void mo10003b(Result result) {
        m10004b();
    }

    /* renamed from: b */
    public void m10002b(Progress... progressArr) {
    }

    /* renamed from: c */
    public void m10001c() {
    }

    /* renamed from: c */
    public void mo10000c(Result result) {
    }

    /* renamed from: e */
    public void m9997e(Result result) {
        if (this.f1378e.get()) {
            return;
        }
        m9998d(result);
    }

    /* renamed from: a */
    public final boolean m10006a(boolean z) {
        this.f1377d.set(true);
        return this.f1375b.cancel(z);
    }

    /* renamed from: a */
    public final ModernAsyncTask<Params, Progress, Result> m10007a(Executor executor, Params... paramsArr) {
        if (this.f1376c != EnumC0203g.PENDING) {
            int i = C0200d.f1382a[this.f1376c.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("We should never reach this state");
                }
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        this.f1376c = EnumC0203g.RUNNING;
        m10001c();
        this.f1374a.f1389a = paramsArr;
        executor.execute(this.f1375b);
        return this;
    }

    /* renamed from: d */
    public Result m9998d(Result result) {
        m9999d().obtainMessage(1, new C0201e(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: a */
    public void m10008a(Result result) {
        if (m10009a()) {
            mo10003b((ModernAsyncTask<Params, Progress, Result>) result);
        } else {
            mo10000c(result);
        }
        this.f1376c = EnumC0203g.FINISHED;
    }
}
