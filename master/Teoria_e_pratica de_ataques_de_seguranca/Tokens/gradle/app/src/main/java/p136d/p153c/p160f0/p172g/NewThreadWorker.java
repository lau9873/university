package p136d.p153c.p160f0.p172g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p157c0.Disposables;
import p136d.p153c.p160f0.p161a.DisposableContainer;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.g.d */
/* loaded from: classes.dex */
public class NewThreadWorker extends Scheduler.AbstractC1733c implements Disposable {

    /* renamed from: a */
    public final ScheduledExecutorService f7651a;

    /* renamed from: b */
    public volatile boolean f7652b;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f7651a = SchedulerPoolFactory.m3447a(threadFactory);
    }

    @Override // p136d.p153c.Scheduler.AbstractC1733c
    /* renamed from: a */
    public Disposable mo3289a(Runnable runnable) {
        return mo3287a(runnable, 0L, null);
    }

    /* renamed from: b */
    public Disposable m3450b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable m3376a = RxJavaPlugins.m3376a(runnable);
        try {
            if (j <= 0) {
                schedule = this.f7651a.submit(m3376a);
            } else {
                schedule = this.f7651a.schedule(m3376a, j, timeUnit);
            }
            return Disposables.m3666a(schedule);
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.m3371b(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        return this.f7652b;
    }

    @Override // p136d.p153c.Scheduler.AbstractC1733c
    /* renamed from: a */
    public Disposable mo3287a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f7652b) {
            return EmptyDisposable.INSTANCE;
        }
        return m3452a(runnable, j, timeUnit, (DisposableContainer) null);
    }

    /* renamed from: a */
    public ScheduledRunnable m3452a(Runnable runnable, long j, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        Future<?> schedule;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.m3376a(runnable), disposableContainer);
        if (disposableContainer == null || disposableContainer.mo3633c(scheduledRunnable)) {
            try {
                if (j <= 0) {
                    schedule = this.f7651a.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.f7651a.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.m3449a(schedule);
            } catch (RejectedExecutionException e) {
                if (disposableContainer != null) {
                    disposableContainer.mo3634b(scheduledRunnable);
                }
                RxJavaPlugins.m3371b(e);
            }
            return scheduledRunnable;
        }
        return scheduledRunnable;
    }

    /* renamed from: b */
    public Disposable m3451b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        try {
            return Disposables.m3666a(this.f7651a.scheduleAtFixedRate(RxJavaPlugins.m3376a(runnable), j, j2, timeUnit));
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.m3371b(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        if (this.f7652b) {
            return;
        }
        this.f7652b = true;
        this.f7651a.shutdownNow();
    }
}
