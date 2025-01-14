package d.c.b0.b;

import android.os.Handler;
import android.os.Message;
import d.c.c0.c;
import d.c.t;
import java.util.concurrent.TimeUnit;
/* compiled from: HandlerScheduler.java */
/* loaded from: classes.dex */
public final class b extends t {

    /* renamed from: b  reason: collision with root package name */
    public final Handler f4571b;

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes.dex */
    public static final class a extends t.c {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f4572a;

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f4573b;

        public a(Handler handler) {
            this.f4572a = handler;
        }

        @Override // d.c.t.c
        public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit != null) {
                    if (this.f4573b) {
                        return c.a();
                    }
                    RunnableC0094b runnableC0094b = new RunnableC0094b(this.f4572a, d.c.h0.a.a(runnable));
                    Message obtain = Message.obtain(this.f4572a, runnableC0094b);
                    obtain.obj = this;
                    this.f4572a.sendMessageDelayed(obtain, Math.max(0L, timeUnit.toMillis(j)));
                    if (this.f4573b) {
                        this.f4572a.removeCallbacks(runnableC0094b);
                        return c.a();
                    }
                    return runnableC0094b;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("run == null");
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4573b = true;
            this.f4572a.removeCallbacksAndMessages(this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4573b;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: d.c.b0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0094b implements Runnable, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final Handler f4574a;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f4575b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f4576c;

        public RunnableC0094b(Handler handler, Runnable runnable) {
            this.f4574a = handler;
            this.f4575b = runnable;
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4576c = true;
            this.f4574a.removeCallbacks(this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4576c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4575b.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                d.c.h0.a.b(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }
    }

    public b(Handler handler) {
        this.f4571b = handler;
    }

    @Override // d.c.t
    public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                RunnableC0094b runnableC0094b = new RunnableC0094b(this.f4571b, d.c.h0.a.a(runnable));
                this.f4571b.postDelayed(runnableC0094b, Math.max(0L, timeUnit.toMillis(j)));
                return runnableC0094b;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }

    @Override // d.c.t
    public t.c a() {
        return new a(this.f4571b);
    }
}
