package p136d.p153c.p160f0.p172g;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p157c0.Disposables;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.g.i */
/* loaded from: classes.dex */
public final class SingleScheduler extends Scheduler {

    /* renamed from: c */
    public static final RxThreadFactory f7662c;

    /* renamed from: d */
    public static final ScheduledExecutorService f7663d = Executors.newScheduledThreadPool(0);

    /* renamed from: b */
    public final AtomicReference<ScheduledExecutorService> f7664b;

    /* compiled from: SingleScheduler.java */
    /* renamed from: d.c.f0.g.i$a */
    /* loaded from: classes.dex */
    public static final class C1710a extends Scheduler.AbstractC1733c {

        /* renamed from: a */
        public final ScheduledExecutorService f7665a;

        /* renamed from: b */
        public final CompositeDisposable f7666b = new CompositeDisposable();

        /* renamed from: c */
        public volatile boolean f7667c;

        public C1710a(ScheduledExecutorService scheduledExecutorService) {
            this.f7665a = scheduledExecutorService;
        }

        @Override // p136d.p153c.Scheduler.AbstractC1733c
        /* renamed from: a */
        public Disposable mo3287a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f7667c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.m3376a(runnable), this.f7666b);
            this.f7666b.mo3633c(scheduledRunnable);
            try {
                if (j <= 0) {
                    schedule = this.f7665a.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.f7665a.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.m3449a(schedule);
                return scheduledRunnable;
            } catch (RejectedExecutionException e) {
                mo578b();
                RxJavaPlugins.m3371b(e);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            if (this.f7667c) {
                return;
            }
            this.f7667c = true;
            this.f7666b.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7667c;
        }
    }

    static {
        f7663d.shutdown();
        f7662c = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public SingleScheduler() {
        this(f7662c);
    }

    /* renamed from: a */
    public static ScheduledExecutorService m3446a(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.m3447a(threadFactory);
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        this.f7664b = new AtomicReference<>();
        this.f7664b.lazySet(m3446a(threadFactory));
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC1733c mo3293a() {
        return new C1710a(this.f7664b.get());
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Disposable mo3290a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable m3376a = RxJavaPlugins.m3376a(runnable);
        try {
            if (j <= 0) {
                schedule = this.f7664b.get().submit(m3376a);
            } else {
                schedule = this.f7664b.get().schedule(m3376a, j, timeUnit);
            }
            return Disposables.m3666a(schedule);
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.m3371b(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Disposable mo3291a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        try {
            return Disposables.m3666a(this.f7664b.get().scheduleAtFixedRate(RxJavaPlugins.m3376a(runnable), j, j2, timeUnit));
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.m3371b(e);
            return EmptyDisposable.INSTANCE;
        }
    }
}
