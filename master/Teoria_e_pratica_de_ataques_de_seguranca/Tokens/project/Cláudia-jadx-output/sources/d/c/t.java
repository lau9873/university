package d.c;

import java.util.concurrent.TimeUnit;
/* compiled from: Scheduler.java */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    public static final long f5440a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f5441a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f5442b;

        public a(t tVar, Runnable runnable, c cVar) {
            this.f5441a = runnable;
            this.f5442b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f5441a.run();
            } finally {
                this.f5442b.b();
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f5443a;

        /* renamed from: b  reason: collision with root package name */
        public final c f5444b;

        /* renamed from: c  reason: collision with root package name */
        public volatile boolean f5445c;

        public b(Runnable runnable, c cVar) {
            this.f5443a = runnable;
            this.f5444b = cVar;
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5445c = true;
            this.f5444b.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5445c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5445c) {
                return;
            }
            try {
                this.f5443a.run();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f5444b.b();
                throw d.c.f0.j.f.a(th);
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public static abstract class c implements d.c.c0.b {

        /* compiled from: Scheduler.java */
        /* loaded from: classes.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final Runnable f5446a;

            /* renamed from: b  reason: collision with root package name */
            public final d.c.f0.a.e f5447b;

            /* renamed from: c  reason: collision with root package name */
            public final long f5448c;

            /* renamed from: d  reason: collision with root package name */
            public long f5449d;

            /* renamed from: e  reason: collision with root package name */
            public long f5450e;

            /* renamed from: f  reason: collision with root package name */
            public long f5451f;

            public a(long j, Runnable runnable, long j2, d.c.f0.a.e eVar, long j3) {
                this.f5446a = runnable;
                this.f5447b = eVar;
                this.f5448c = j3;
                this.f5450e = j2;
                this.f5451f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.f5446a.run();
                if (this.f5447b.c()) {
                    return;
                }
                long a2 = c.this.a(TimeUnit.NANOSECONDS);
                long j2 = t.f5440a;
                long j3 = this.f5450e;
                if (a2 + j2 >= j3) {
                    long j4 = this.f5448c;
                    if (a2 < j3 + j4 + j2) {
                        long j5 = this.f5451f;
                        long j6 = this.f5449d + 1;
                        this.f5449d = j6;
                        j = j5 + (j6 * j4);
                        this.f5450e = a2;
                        this.f5447b.a(c.this.a(this, j - a2, TimeUnit.NANOSECONDS));
                    }
                }
                long j7 = this.f5448c;
                long j8 = a2 + j7;
                long j9 = this.f5449d + 1;
                this.f5449d = j9;
                this.f5451f = j8 - (j7 * j9);
                j = j8;
                this.f5450e = a2;
                this.f5447b.a(c.this.a(this, j - a2, TimeUnit.NANOSECONDS));
            }
        }

        public d.c.c0.b a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit);

        public d.c.c0.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            d.c.f0.a.e eVar = new d.c.f0.a.e();
            d.c.f0.a.e eVar2 = new d.c.f0.a.e(eVar);
            Runnable a2 = d.c.h0.a.a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a3 = a(TimeUnit.NANOSECONDS);
            d.c.c0.b a4 = a(new a(a3 + timeUnit.toNanos(j), a2, a3, eVar2, nanos), j, timeUnit);
            if (a4 == d.c.f0.a.c.INSTANCE) {
                return a4;
            }
            eVar.a(a4);
            return eVar2;
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public d.c.c0.b a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public abstract c a();

    public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        c a2 = a();
        a2.a(new a(this, d.c.h0.a.a(runnable), a2), j, timeUnit);
        return a2;
    }

    public d.c.c0.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(d.c.h0.a.a(runnable), a2);
        d.c.c0.b a3 = a2.a(bVar, j, j2, timeUnit);
        return a3 == d.c.f0.a.c.INSTANCE ? a3 : bVar;
    }
}
