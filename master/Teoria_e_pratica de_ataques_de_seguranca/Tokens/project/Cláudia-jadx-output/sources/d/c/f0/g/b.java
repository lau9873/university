package d.c.f0.g;

import d.c.t;
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
/* compiled from: IoScheduler.java */
/* loaded from: classes.dex */
public final class b extends t {

    /* renamed from: d  reason: collision with root package name */
    public static final f f5295d;

    /* renamed from: e  reason: collision with root package name */
    public static final f f5296e;

    /* renamed from: f  reason: collision with root package name */
    public static final TimeUnit f5297f = TimeUnit.SECONDS;

    /* renamed from: g  reason: collision with root package name */
    public static final c f5298g = new c(new f("RxCachedThreadSchedulerShutdown"));

    /* renamed from: h  reason: collision with root package name */
    public static final a f5299h;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadFactory f5300b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<a> f5301c;

    /* compiled from: IoScheduler.java */
    /* renamed from: d.c.f0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0113b extends t.c {

        /* renamed from: b  reason: collision with root package name */
        public final a f5309b;

        /* renamed from: c  reason: collision with root package name */
        public final c f5310c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f5311d = new AtomicBoolean();

        /* renamed from: a  reason: collision with root package name */
        public final d.c.c0.a f5308a = new d.c.c0.a();

        public C0113b(a aVar) {
            this.f5309b = aVar;
            this.f5310c = aVar.b();
        }

        @Override // d.c.t.c
        public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f5308a.c()) {
                return d.c.f0.a.c.INSTANCE;
            }
            return this.f5310c.a(runnable, j, timeUnit, this.f5308a);
        }

        @Override // d.c.c0.b
        public void b() {
            if (this.f5311d.compareAndSet(false, true)) {
                this.f5308a.b();
                this.f5309b.a(this.f5310c);
            }
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5311d.get();
        }
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends d {

        /* renamed from: c  reason: collision with root package name */
        public long f5312c;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f5312c = 0L;
        }

        public long a() {
            return this.f5312c;
        }

        public void a(long j) {
            this.f5312c = j;
        }
    }

    static {
        f5298g.b();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f5295d = new f("RxCachedThreadScheduler", max);
        f5296e = new f("RxCachedWorkerPoolEvictor", max);
        f5299h = new a(0L, null, f5295d);
        f5299h.d();
    }

    public b() {
        this(f5295d);
    }

    @Override // d.c.t
    public t.c a() {
        return new C0113b(this.f5301c.get());
    }

    public void b() {
        a aVar = new a(60L, f5297f, this.f5300b);
        if (this.f5301c.compareAndSet(f5299h, aVar)) {
            return;
        }
        aVar.d();
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final long f5302a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f5303b;

        /* renamed from: c  reason: collision with root package name */
        public final d.c.c0.a f5304c;

        /* renamed from: d  reason: collision with root package name */
        public final ScheduledExecutorService f5305d;

        /* renamed from: e  reason: collision with root package name */
        public final Future<?> f5306e;

        /* renamed from: f  reason: collision with root package name */
        public final ThreadFactory f5307f;

        public a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f5302a = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f5303b = new ConcurrentLinkedQueue<>();
            this.f5304c = new d.c.c0.a();
            this.f5307f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, b.f5296e);
                long j2 = this.f5302a;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f5305d = scheduledExecutorService;
            this.f5306e = scheduledFuture;
        }

        public void a(c cVar) {
            cVar.a(c() + this.f5302a);
            this.f5303b.offer(cVar);
        }

        public c b() {
            if (this.f5304c.c()) {
                return b.f5298g;
            }
            while (!this.f5303b.isEmpty()) {
                c poll = this.f5303b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f5307f);
            this.f5304c.c(cVar);
            return cVar;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d() {
            this.f5304c.b();
            Future<?> future = this.f5306e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f5305d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        public void a() {
            if (this.f5303b.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f5303b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.a() > c2) {
                    return;
                }
                if (this.f5303b.remove(next)) {
                    this.f5304c.b(next);
                }
            }
        }
    }

    public b(ThreadFactory threadFactory) {
        this.f5300b = threadFactory;
        this.f5301c = new AtomicReference<>(f5299h);
        b();
    }
}
