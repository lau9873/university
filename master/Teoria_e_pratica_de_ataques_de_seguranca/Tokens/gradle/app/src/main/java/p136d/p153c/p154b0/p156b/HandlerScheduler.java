package p136d.p153c.p154b0.p156b;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p157c0.Disposables;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.b0.b.b */
/* loaded from: classes.dex */
public final class HandlerScheduler extends Scheduler {

    /* renamed from: b */
    public final Handler f6864b;

    /* compiled from: HandlerScheduler.java */
    /* renamed from: d.c.b0.b.b$a */
    /* loaded from: classes.dex */
    public static final class C1536a extends Scheduler.AbstractC1733c {

        /* renamed from: a */
        public final Handler f6865a;

        /* renamed from: b */
        public volatile boolean f6866b;

        public C1536a(Handler handler) {
            this.f6865a = handler;
        }

        @Override // p136d.p153c.Scheduler.AbstractC1733c
        /* renamed from: a */
        public Disposable mo3287a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit != null) {
                    if (this.f6866b) {
                        return Disposables.m3668a();
                    }
                    RunnableC1537b runnableC1537b = new RunnableC1537b(this.f6865a, RxJavaPlugins.m3376a(runnable));
                    Message obtain = Message.obtain(this.f6865a, runnableC1537b);
                    obtain.obj = this;
                    this.f6865a.sendMessageDelayed(obtain, Math.max(0L, timeUnit.toMillis(j)));
                    if (this.f6866b) {
                        this.f6865a.removeCallbacks(runnableC1537b);
                        return Disposables.m3668a();
                    }
                    return runnableC1537b;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("run == null");
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f6866b = true;
            this.f6865a.removeCallbacksAndMessages(this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f6866b;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: d.c.b0.b.b$b */
    /* loaded from: classes.dex */
    public static final class RunnableC1537b implements Runnable, Disposable {

        /* renamed from: a */
        public final Handler f6867a;

        /* renamed from: b */
        public final Runnable f6868b;

        /* renamed from: c */
        public volatile boolean f6869c;

        public RunnableC1537b(Handler handler, Runnable runnable) {
            this.f6867a = handler;
            this.f6868b = runnable;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f6869c = true;
            this.f6867a.removeCallbacks(this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f6869c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6868b.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                RxJavaPlugins.m3371b(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }
    }

    public HandlerScheduler(Handler handler) {
        this.f6864b = handler;
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Disposable mo3290a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                RunnableC1537b runnableC1537b = new RunnableC1537b(this.f6864b, RxJavaPlugins.m3376a(runnable));
                this.f6864b.postDelayed(runnableC1537b, Math.max(0L, timeUnit.toMillis(j)));
                return runnableC1537b;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC1733c mo3293a() {
        return new C1536a(this.f6864b);
    }
}
