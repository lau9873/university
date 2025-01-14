package p136d.p153c.p160f0.p172g;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p157c0.Disposables;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.g.j */
/* loaded from: classes.dex */
public final class TrampolineScheduler extends Scheduler {

    /* renamed from: b */
    public static final TrampolineScheduler f7668b = new TrampolineScheduler();

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: d.c.f0.g.j$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1711a implements Runnable {

        /* renamed from: a */
        public final Runnable f7669a;

        /* renamed from: b */
        public final C1713c f7670b;

        /* renamed from: c */
        public final long f7671c;

        public RunnableC1711a(Runnable runnable, C1713c c1713c, long j) {
            this.f7669a = runnable;
            this.f7670b = c1713c;
            this.f7671c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7670b.f7679d) {
                return;
            }
            long m3286a = this.f7670b.m3286a(TimeUnit.MILLISECONDS);
            long j = this.f7671c;
            if (j > m3286a) {
                long j2 = j - m3286a;
                if (j2 > 0) {
                    try {
                        Thread.sleep(j2);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.m3371b(e);
                        return;
                    }
                }
            }
            if (this.f7670b.f7679d) {
                return;
            }
            this.f7669a.run();
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: d.c.f0.g.j$b */
    /* loaded from: classes.dex */
    public static final class C1712b implements Comparable<C1712b> {

        /* renamed from: a */
        public final Runnable f7672a;

        /* renamed from: b */
        public final long f7673b;

        /* renamed from: c */
        public final int f7674c;

        /* renamed from: d */
        public volatile boolean f7675d;

        public C1712b(Runnable runnable, Long l, int i) {
            this.f7672a = runnable;
            this.f7673b = l.longValue();
            this.f7674c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C1712b c1712b) {
            int m3600a = ObjectHelper.m3600a(this.f7673b, c1712b.f7673b);
            return m3600a == 0 ? ObjectHelper.m3602a(this.f7674c, c1712b.f7674c) : m3600a;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: d.c.f0.g.j$c */
    /* loaded from: classes.dex */
    public static final class C1713c extends Scheduler.AbstractC1733c implements Disposable {

        /* renamed from: a */
        public final PriorityBlockingQueue<C1712b> f7676a = new PriorityBlockingQueue<>();

        /* renamed from: b */
        public final AtomicInteger f7677b = new AtomicInteger();

        /* renamed from: c */
        public final AtomicInteger f7678c = new AtomicInteger();

        /* renamed from: d */
        public volatile boolean f7679d;

        /* compiled from: TrampolineScheduler.java */
        /* renamed from: d.c.f0.g.j$c$a */
        /* loaded from: classes.dex */
        public class RunnableC1714a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ C1712b f7680a;

            public RunnableC1714a(C1712b c1712b) {
                this.f7680a = c1712b;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1712b c1712b = this.f7680a;
                c1712b.f7675d = true;
                C1713c.this.f7676a.remove(c1712b);
            }
        }

        @Override // p136d.p153c.Scheduler.AbstractC1733c
        /* renamed from: a */
        public Disposable mo3289a(Runnable runnable) {
            return m3443a(runnable, m3286a(TimeUnit.MILLISECONDS));
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7679d = true;
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7679d;
        }

        @Override // p136d.p153c.Scheduler.AbstractC1733c
        /* renamed from: a */
        public Disposable mo3287a(Runnable runnable, long j, TimeUnit timeUnit) {
            long m3286a = m3286a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return m3443a(new RunnableC1711a(runnable, this, m3286a), m3286a);
        }

        /* renamed from: a */
        public Disposable m3443a(Runnable runnable, long j) {
            if (this.f7679d) {
                return EmptyDisposable.INSTANCE;
            }
            C1712b c1712b = new C1712b(runnable, Long.valueOf(j), this.f7678c.incrementAndGet());
            this.f7676a.add(c1712b);
            if (this.f7677b.getAndIncrement() != 0) {
                return Disposables.m3667a(new RunnableC1714a(c1712b));
            }
            int i = 1;
            while (true) {
                C1712b poll = this.f7676a.poll();
                if (poll == null) {
                    i = this.f7677b.addAndGet(-i);
                    if (i == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f7675d) {
                    poll.f7672a.run();
                }
            }
        }
    }

    /* renamed from: b */
    public static TrampolineScheduler m3445b() {
        return f7668b;
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC1733c mo3293a() {
        return new C1713c();
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Disposable mo3292a(Runnable runnable) {
        runnable.run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // p136d.p153c.Scheduler
    /* renamed from: a */
    public Disposable mo3290a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            runnable.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.m3371b(e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
