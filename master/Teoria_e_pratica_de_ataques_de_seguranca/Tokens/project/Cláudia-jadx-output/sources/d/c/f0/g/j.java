package d.c.f0.g;

import d.c.t;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* loaded from: classes.dex */
public final class j extends t {

    /* renamed from: b  reason: collision with root package name */
    public static final j f5332b = new j();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f5333a;

        /* renamed from: b  reason: collision with root package name */
        public final c f5334b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5335c;

        public a(Runnable runnable, c cVar, long j) {
            this.f5333a = runnable;
            this.f5334b = cVar;
            this.f5335c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5334b.f5343d) {
                return;
            }
            long a2 = this.f5334b.a(TimeUnit.MILLISECONDS);
            long j = this.f5335c;
            if (j > a2) {
                long j2 = j - a2;
                if (j2 > 0) {
                    try {
                        Thread.sleep(j2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        d.c.h0.a.b(e2);
                        return;
                    }
                }
            }
            if (this.f5334b.f5343d) {
                return;
            }
            this.f5333a.run();
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f5336a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5337b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5338c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f5339d;

        public b(Runnable runnable, Long l, int i2) {
            this.f5336a = runnable;
            this.f5337b = l.longValue();
            this.f5338c = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int a2 = d.c.f0.b.b.a(this.f5337b, bVar.f5337b);
            return a2 == 0 ? d.c.f0.b.b.a(this.f5338c, bVar.f5338c) : a2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends t.c implements d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f5340a = new PriorityBlockingQueue<>();

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f5341b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f5342c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f5343d;

        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f5344a;

            public a(b bVar) {
                this.f5344a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = this.f5344a;
                bVar.f5339d = true;
                c.this.f5340a.remove(bVar);
            }
        }

        @Override // d.c.t.c
        public d.c.c0.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5343d = true;
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5343d;
        }

        @Override // d.c.t.c
        public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, a2), a2);
        }

        public d.c.c0.b a(Runnable runnable, long j) {
            if (this.f5343d) {
                return d.c.f0.a.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f5342c.incrementAndGet());
            this.f5340a.add(bVar);
            if (this.f5341b.getAndIncrement() != 0) {
                return d.c.c0.c.a(new a(bVar));
            }
            int i2 = 1;
            while (true) {
                b poll = this.f5340a.poll();
                if (poll == null) {
                    i2 = this.f5341b.addAndGet(-i2);
                    if (i2 == 0) {
                        return d.c.f0.a.c.INSTANCE;
                    }
                } else if (!poll.f5339d) {
                    poll.f5336a.run();
                }
            }
        }
    }

    public static j b() {
        return f5332b;
    }

    @Override // d.c.t
    public t.c a() {
        return new c();
    }

    @Override // d.c.t
    public d.c.c0.b a(Runnable runnable) {
        runnable.run();
        return d.c.f0.a.c.INSTANCE;
    }

    @Override // d.c.t
    public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            runnable.run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            d.c.h0.a.b(e2);
        }
        return d.c.f0.a.c.INSTANCE;
    }
}
