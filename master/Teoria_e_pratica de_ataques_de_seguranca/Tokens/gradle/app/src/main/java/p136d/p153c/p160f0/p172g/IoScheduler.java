package p136d.p153c.p160f0.p172g;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.EmptyDisposable;

/* renamed from: d.c.f0.g.b */
/* loaded from: classes.dex */
public final class IoScheduler extends Scheduler {

    /* renamed from: d */
    public static final RxThreadFactory f7631d;

    /* renamed from: e */
    public static final RxThreadFactory f7632e;

    /* renamed from: f */
    public static final TimeUnit f7633f = TimeUnit.SECONDS;

    /* renamed from: g */
    public static final C1707c f7634g = new C1707c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));

    /* renamed from: h */
    public static final RunnableC1705a f7635h;

    /* renamed from: b */
    public final ThreadFactory f7636b;

    /* renamed from: c */
    public final AtomicReference<RunnableC1705a> f7637c;

    /* compiled from: IoScheduler.java */
    /* renamed from: d.c.f0.g.b$b */
    /* loaded from: classes.dex */
    public static final class C1706b extends Scheduler.AbstractC1733c {

        /* renamed from: b */
        public final RunnableC1705a f7645b;

        /* renamed from: c */
        public final C1707c f7646c;

        /* renamed from: d */
        public final AtomicBoolean f7647d = new AtomicBoolean();

        /* renamed from: a */
        public final CompositeDisposable f7644a = new CompositeDisposable();

        public C1706b(RunnableC1705a runnableC1705a) {
            this.f7645b = runnableC1705a;
            this.f7646c = runnableC1705a.m3457b();
        }

        @Override // p136d.p153c.Scheduler.AbstractC1733c
        /* renamed from: a */
        public Disposable mo3287a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f7644a.mo577c()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f7646c.m3452a(runnable, j, timeUnit, this.f7644a);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            if (this.f7647d.compareAndSet(false, true)) {
                this.f7644a.mo578b();
                this.f7645b.m3458a(this.f7646c);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7647d.get();
        }
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: d.c.f0.g.b$c */
    /* loaded from: classes.dex */
    public static final class C1707c extends NewThreadWorker {

        /* renamed from: c */
        public long f7648c;

        public C1707c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f7648c = 0L;
        }

        /* renamed from: a */
        public long m3454a() {
            return this.f7648c;
        }

        /* renamed from: a */
        public void m3453a(long j) {
            this.f7648c = j;
        }
    }

    static {
        f7634g.mo578b();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f7631d = new RxThreadFactory("RxCachedThreadScheduler", max);
        f7632e = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        f7635h = new RunnableC1705a(0L, null, f7631d);
        f7635h.m3455d();
    }

    public IoScheduler() {
        this(f7631d);
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC1733c mo3293a() {
        return new C1706b(this.f7637c.get());
    }

    /* renamed from: b */
    public void m3460b() {
        RunnableC1705a runnableC1705a = new RunnableC1705a(60L, f7633f, this.f7636b);
        if (this.f7637c.compareAndSet(f7635h, runnableC1705a)) {
            return;
        }
        runnableC1705a.m3455d();
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: d.c.f0.g.b$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1705a implements Runnable {

        /* renamed from: a */
        public final long f7638a;

        /* renamed from: b */
        public final ConcurrentLinkedQueue<C1707c> f7639b;

        /* renamed from: c */
        public final CompositeDisposable f7640c;

        /* renamed from: d */
        public final ScheduledExecutorService f7641d;

        /* renamed from: e */
        public final Future<?> f7642e;

        /* renamed from: f */
        public final ThreadFactory f7643f;

        public RunnableC1705a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f7638a = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f7639b = new ConcurrentLinkedQueue<>();
            this.f7640c = new CompositeDisposable();
            this.f7643f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f7632e);
                long j2 = this.f7638a;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f7641d = scheduledExecutorService;
            this.f7642e = scheduledFuture;
        }

        /* renamed from: a */
        public void m3458a(C1707c c1707c) {
            c1707c.m3453a(m3456c() + this.f7638a);
            this.f7639b.offer(c1707c);
        }

        /* renamed from: b */
        public C1707c m3457b() {
            if (this.f7640c.mo577c()) {
                return IoScheduler.f7634g;
            }
            while (!this.f7639b.isEmpty()) {
                C1707c poll = this.f7639b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C1707c c1707c = new C1707c(this.f7643f);
            this.f7640c.mo3633c(c1707c);
            return c1707c;
        }

        /* renamed from: c */
        public long m3456c() {
            return System.nanoTime();
        }

        /* renamed from: d */
        public void m3455d() {
            this.f7640c.mo578b();
            Future<?> future = this.f7642e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f7641d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            m3459a();
        }

        /* renamed from: a */
        public void m3459a() {
            if (this.f7639b.isEmpty()) {
                return;
            }
            long m3456c = m3456c();
            Iterator<C1707c> it = this.f7639b.iterator();
            while (it.hasNext()) {
                C1707c next = it.next();
                if (next.m3454a() > m3456c) {
                    return;
                }
                if (this.f7639b.remove(next)) {
                    this.f7640c.mo3634b(next);
                }
            }
        }
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f7636b = threadFactory;
        this.f7637c = new AtomicReference<>(f7635h);
        m3460b();
    }
}
