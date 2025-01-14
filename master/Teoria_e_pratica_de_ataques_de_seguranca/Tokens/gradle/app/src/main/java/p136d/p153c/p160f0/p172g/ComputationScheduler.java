package p136d.p153c.p160f0.p172g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p161a.ListCompositeDisposable;

/* renamed from: d.c.f0.g.a */
/* loaded from: classes.dex */
public final class ComputationScheduler extends Scheduler {

    /* renamed from: d */
    public static final C1703b f7617d;

    /* renamed from: e */
    public static final RxThreadFactory f7618e;

    /* renamed from: f */
    public static final int f7619f = m3464a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: g */
    public static final C1704c f7620g = new C1704c(new RxThreadFactory("RxComputationShutdown"));

    /* renamed from: b */
    public final ThreadFactory f7621b;

    /* renamed from: c */
    public final AtomicReference<C1703b> f7622c;

    /* compiled from: ComputationScheduler.java */
    /* renamed from: d.c.f0.g.a$b */
    /* loaded from: classes.dex */
    public static final class C1703b {

        /* renamed from: a */
        public final int f7628a;

        /* renamed from: b */
        public final C1704c[] f7629b;

        /* renamed from: c */
        public long f7630c;

        public C1703b(int i, ThreadFactory threadFactory) {
            this.f7628a = i;
            this.f7629b = new C1704c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f7629b[i2] = new C1704c(threadFactory);
            }
        }

        /* renamed from: a */
        public C1704c m3462a() {
            int i = this.f7628a;
            if (i == 0) {
                return ComputationScheduler.f7620g;
            }
            C1704c[] c1704cArr = this.f7629b;
            long j = this.f7630c;
            this.f7630c = 1 + j;
            return c1704cArr[(int) (j % i)];
        }

        /* renamed from: b */
        public void m3461b() {
            for (C1704c c1704c : this.f7629b) {
                c1704c.mo578b();
            }
        }
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: d.c.f0.g.a$c */
    /* loaded from: classes.dex */
    public static final class C1704c extends NewThreadWorker {
        public C1704c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f7620g.mo578b();
        f7618e = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f7617d = new C1703b(0, f7618e);
        f7617d.m3461b();
    }

    public ComputationScheduler() {
        this(f7618e);
    }

    /* renamed from: a */
    public static int m3464a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC1733c mo3293a() {
        return new C1702a(this.f7622c.get().m3462a());
    }

    /* renamed from: b */
    public void m3463b() {
        C1703b c1703b = new C1703b(f7619f, this.f7621b);
        if (this.f7622c.compareAndSet(f7617d, c1703b)) {
            return;
        }
        c1703b.m3461b();
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f7621b = threadFactory;
        this.f7622c = new AtomicReference<>(f7617d);
        m3463b();
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Disposable mo3290a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f7622c.get().m3462a().m3450b(runnable, j, timeUnit);
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: d.c.f0.g.a$a */
    /* loaded from: classes.dex */
    public static final class C1702a extends Scheduler.AbstractC1733c {

        /* renamed from: a */
        public final ListCompositeDisposable f7623a = new ListCompositeDisposable();

        /* renamed from: b */
        public final CompositeDisposable f7624b = new CompositeDisposable();

        /* renamed from: c */
        public final ListCompositeDisposable f7625c = new ListCompositeDisposable();

        /* renamed from: d */
        public final C1704c f7626d;

        /* renamed from: e */
        public volatile boolean f7627e;

        public C1702a(C1704c c1704c) {
            this.f7626d = c1704c;
            this.f7625c.mo3633c(this.f7623a);
            this.f7625c.mo3633c(this.f7624b);
        }

        @Override // p136d.p153c.Scheduler.AbstractC1733c
        /* renamed from: a */
        public Disposable mo3289a(Runnable runnable) {
            if (this.f7627e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f7626d.m3452a(runnable, 0L, TimeUnit.MILLISECONDS, this.f7623a);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            if (this.f7627e) {
                return;
            }
            this.f7627e = true;
            this.f7625c.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7627e;
        }

        @Override // p136d.p153c.Scheduler.AbstractC1733c
        /* renamed from: a */
        public Disposable mo3287a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f7627e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f7626d.m3452a(runnable, j, timeUnit, this.f7624b);
        }
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Disposable mo3291a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f7622c.get().m3462a().m3451b(runnable, j, j2, timeUnit);
    }
}
