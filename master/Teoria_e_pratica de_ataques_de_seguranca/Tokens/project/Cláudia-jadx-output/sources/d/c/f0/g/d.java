package d.c.f0.g;

import d.c.t;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* compiled from: NewThreadWorker.java */
/* loaded from: classes.dex */
public class d extends t.c implements d.c.c0.b {

    /* renamed from: a  reason: collision with root package name */
    public final ScheduledExecutorService f5315a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f5316b;

    public d(ThreadFactory threadFactory) {
        this.f5315a = h.a(threadFactory);
    }

    @Override // d.c.t.c
    public d.c.c0.b a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    public d.c.c0.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable a2 = d.c.h0.a.a(runnable);
        try {
            if (j <= 0) {
                schedule = this.f5315a.submit(a2);
            } else {
                schedule = this.f5315a.schedule(a2, j, timeUnit);
            }
            return d.c.c0.c.a(schedule);
        } catch (RejectedExecutionException e2) {
            d.c.h0.a.b(e2);
            return d.c.f0.a.c.INSTANCE;
        }
    }

    @Override // d.c.c0.b
    public boolean c() {
        return this.f5316b;
    }

    @Override // d.c.t.c
    public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f5316b) {
            return d.c.f0.a.c.INSTANCE;
        }
        return a(runnable, j, timeUnit, (d.c.f0.a.a) null);
    }

    public g a(Runnable runnable, long j, TimeUnit timeUnit, d.c.f0.a.a aVar) {
        Future<?> schedule;
        g gVar = new g(d.c.h0.a.a(runnable), aVar);
        if (aVar == null || aVar.c(gVar)) {
            try {
                if (j <= 0) {
                    schedule = this.f5315a.submit((Callable) gVar);
                } else {
                    schedule = this.f5315a.schedule((Callable) gVar, j, timeUnit);
                }
                gVar.a(schedule);
            } catch (RejectedExecutionException e2) {
                if (aVar != null) {
                    aVar.b(gVar);
                }
                d.c.h0.a.b(e2);
            }
            return gVar;
        }
        return gVar;
    }

    public d.c.c0.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        try {
            return d.c.c0.c.a(this.f5315a.scheduleAtFixedRate(d.c.h0.a.a(runnable), j, j2, timeUnit));
        } catch (RejectedExecutionException e2) {
            d.c.h0.a.b(e2);
            return d.c.f0.a.c.INSTANCE;
        }
    }

    @Override // d.c.c0.b
    public void b() {
        if (this.f5316b) {
            return;
        }
        this.f5316b = true;
        this.f5315a.shutdownNow();
    }
}
