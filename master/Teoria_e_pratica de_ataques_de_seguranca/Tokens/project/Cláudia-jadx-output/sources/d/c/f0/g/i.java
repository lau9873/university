package d.c.f0.g;

import d.c.t;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleScheduler.java */
/* loaded from: classes.dex */
public final class i extends t {

    /* renamed from: c  reason: collision with root package name */
    public static final f f5326c;

    /* renamed from: d  reason: collision with root package name */
    public static final ScheduledExecutorService f5327d = Executors.newScheduledThreadPool(0);

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f5328b;

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes.dex */
    public static final class a extends t.c {

        /* renamed from: a  reason: collision with root package name */
        public final ScheduledExecutorService f5329a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.c0.a f5330b = new d.c.c0.a();

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f5331c;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f5329a = scheduledExecutorService;
        }

        @Override // d.c.t.c
        public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f5331c) {
                return d.c.f0.a.c.INSTANCE;
            }
            g gVar = new g(d.c.h0.a.a(runnable), this.f5330b);
            this.f5330b.c(gVar);
            try {
                if (j <= 0) {
                    schedule = this.f5329a.submit((Callable) gVar);
                } else {
                    schedule = this.f5329a.schedule((Callable) gVar, j, timeUnit);
                }
                gVar.a(schedule);
                return gVar;
            } catch (RejectedExecutionException e2) {
                b();
                d.c.h0.a.b(e2);
                return d.c.f0.a.c.INSTANCE;
            }
        }

        @Override // d.c.c0.b
        public void b() {
            if (this.f5331c) {
                return;
            }
            this.f5331c = true;
            this.f5330b.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5331c;
        }
    }

    static {
        f5327d.shutdown();
        f5326c = new f("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public i() {
        this(f5326c);
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return h.a(threadFactory);
    }

    public i(ThreadFactory threadFactory) {
        this.f5328b = new AtomicReference<>();
        this.f5328b.lazySet(a(threadFactory));
    }

    @Override // d.c.t
    public t.c a() {
        return new a(this.f5328b.get());
    }

    @Override // d.c.t
    public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable a2 = d.c.h0.a.a(runnable);
        try {
            if (j <= 0) {
                schedule = this.f5328b.get().submit(a2);
            } else {
                schedule = this.f5328b.get().schedule(a2, j, timeUnit);
            }
            return d.c.c0.c.a(schedule);
        } catch (RejectedExecutionException e2) {
            d.c.h0.a.b(e2);
            return d.c.f0.a.c.INSTANCE;
        }
    }

    @Override // d.c.t
    public d.c.c0.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        try {
            return d.c.c0.c.a(this.f5328b.get().scheduleAtFixedRate(d.c.h0.a.a(runnable), j, j2, timeUnit));
        } catch (RejectedExecutionException e2) {
            d.c.h0.a.b(e2);
            return d.c.f0.a.c.INSTANCE;
        }
    }
}
