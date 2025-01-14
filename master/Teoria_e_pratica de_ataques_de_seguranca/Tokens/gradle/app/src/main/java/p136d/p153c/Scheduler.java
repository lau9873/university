package p136d.p153c;

import java.util.concurrent.TimeUnit;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p161a.SequentialDisposable;
import p136d.p153c.p160f0.p175j.ExceptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.t */
/* loaded from: classes.dex */
public abstract class Scheduler {

    /* renamed from: a */
    public static final long f7790a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    /* renamed from: d.c.t$a */
    /* loaded from: classes.dex */
    public class RunnableC1731a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Runnable f7791a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC1733c f7792b;

        public RunnableC1731a(Scheduler scheduler, Runnable runnable, AbstractC1733c abstractC1733c) {
            this.f7791a = runnable;
            this.f7792b = abstractC1733c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f7791a.run();
            } finally {
                this.f7792b.mo578b();
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: d.c.t$b */
    /* loaded from: classes.dex */
    public static class RunnableC1732b implements Runnable, Disposable {

        /* renamed from: a */
        public final Runnable f7793a;

        /* renamed from: b */
        public final AbstractC1733c f7794b;

        /* renamed from: c */
        public volatile boolean f7795c;

        public RunnableC1732b(Runnable runnable, AbstractC1733c abstractC1733c) {
            this.f7793a = runnable;
            this.f7794b = abstractC1733c;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7795c = true;
            this.f7794b.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7795c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7795c) {
                return;
            }
            try {
                this.f7793a.run();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7794b.mo578b();
                throw ExceptionHelper.m3413a(th);
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: d.c.t$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1733c implements Disposable {

        /* compiled from: Scheduler.java */
        /* renamed from: d.c.t$c$a */
        /* loaded from: classes.dex */
        public final class RunnableC1734a implements Runnable {

            /* renamed from: a */
            public final Runnable f7796a;

            /* renamed from: b */
            public final SequentialDisposable f7797b;

            /* renamed from: c */
            public final long f7798c;

            /* renamed from: d */
            public long f7799d;

            /* renamed from: e */
            public long f7800e;

            /* renamed from: f */
            public long f7801f;

            public RunnableC1734a(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.f7796a = runnable;
                this.f7797b = sequentialDisposable;
                this.f7798c = j3;
                this.f7800e = j2;
                this.f7801f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.f7796a.run();
                if (this.f7797b.mo577c()) {
                    return;
                }
                long m3286a = AbstractC1733c.this.m3286a(TimeUnit.NANOSECONDS);
                long j2 = Scheduler.f7790a;
                long j3 = this.f7800e;
                if (m3286a + j2 >= j3) {
                    long j4 = this.f7798c;
                    if (m3286a < j3 + j4 + j2) {
                        long j5 = this.f7801f;
                        long j6 = this.f7799d + 1;
                        this.f7799d = j6;
                        j = j5 + (j6 * j4);
                        this.f7800e = m3286a;
                        this.f7797b.m3632a(AbstractC1733c.this.mo3287a(this, j - m3286a, TimeUnit.NANOSECONDS));
                    }
                }
                long j7 = this.f7798c;
                long j8 = m3286a + j7;
                long j9 = this.f7799d + 1;
                this.f7799d = j9;
                this.f7801f = j8 - (j7 * j9);
                j = j8;
                this.f7800e = m3286a;
                this.f7797b.m3632a(AbstractC1733c.this.mo3287a(this, j - m3286a, TimeUnit.NANOSECONDS));
            }
        }

        /* renamed from: a */
        public Disposable mo3289a(Runnable runnable) {
            return mo3287a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        /* renamed from: a */
        public abstract Disposable mo3287a(Runnable runnable, long j, TimeUnit timeUnit);

        /* renamed from: a */
        public Disposable m3288a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable m3376a = RxJavaPlugins.m3376a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long m3286a = m3286a(TimeUnit.NANOSECONDS);
            Disposable mo3287a = mo3287a(new RunnableC1734a(m3286a + timeUnit.toNanos(j), m3376a, m3286a, sequentialDisposable2, nanos), j, timeUnit);
            if (mo3287a == EmptyDisposable.INSTANCE) {
                return mo3287a;
            }
            sequentialDisposable.m3632a(mo3287a);
            return sequentialDisposable2;
        }

        /* renamed from: a */
        public long m3286a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public Disposable mo3292a(Runnable runnable) {
        return mo3290a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    /* renamed from: a */
    public abstract AbstractC1733c mo3293a();

    /* renamed from: a */
    public Disposable mo3290a(Runnable runnable, long j, TimeUnit timeUnit) {
        AbstractC1733c mo3293a = mo3293a();
        mo3293a.mo3287a(new RunnableC1731a(this, RxJavaPlugins.m3376a(runnable), mo3293a), j, timeUnit);
        return mo3293a;
    }

    /* renamed from: a */
    public Disposable mo3291a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        AbstractC1733c mo3293a = mo3293a();
        RunnableC1732b runnableC1732b = new RunnableC1732b(RxJavaPlugins.m3376a(runnable), mo3293a);
        Disposable m3288a = mo3293a.m3288a(runnableC1732b, j, j2, timeUnit);
        return m3288a == EmptyDisposable.INSTANCE ? m3288a : runnableC1732b;
    }
}
