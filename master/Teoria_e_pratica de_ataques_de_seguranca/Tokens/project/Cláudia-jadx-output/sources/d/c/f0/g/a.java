package d.c.f0.g;

import d.c.t;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* loaded from: classes.dex */
public final class a extends t {

    /* renamed from: d  reason: collision with root package name */
    public static final b f5281d;

    /* renamed from: e  reason: collision with root package name */
    public static final f f5282e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5283f = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: g  reason: collision with root package name */
    public static final c f5284g = new c(new f("RxComputationShutdown"));

    /* renamed from: b  reason: collision with root package name */
    public final ThreadFactory f5285b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<b> f5286c;

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f5292a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f5293b;

        /* renamed from: c  reason: collision with root package name */
        public long f5294c;

        public b(int i2, ThreadFactory threadFactory) {
            this.f5292a = i2;
            this.f5293b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f5293b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f5292a;
            if (i2 == 0) {
                return a.f5284g;
            }
            c[] cVarArr = this.f5293b;
            long j = this.f5294c;
            this.f5294c = 1 + j;
            return cVarArr[(int) (j % i2)];
        }

        public void b() {
            for (c cVar : this.f5293b) {
                cVar.b();
            }
        }
    }

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends d {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f5284g.b();
        f5282e = new f("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f5281d = new b(0, f5282e);
        f5281d.b();
    }

    public a() {
        this(f5282e);
    }

    public static int a(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    @Override // d.c.t
    public t.c a() {
        return new C0112a(this.f5286c.get().a());
    }

    public void b() {
        b bVar = new b(f5283f, this.f5285b);
        if (this.f5286c.compareAndSet(f5281d, bVar)) {
            return;
        }
        bVar.b();
    }

    public a(ThreadFactory threadFactory) {
        this.f5285b = threadFactory;
        this.f5286c = new AtomicReference<>(f5281d);
        b();
    }

    @Override // d.c.t
    public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f5286c.get().a().b(runnable, j, timeUnit);
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: d.c.f0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0112a extends t.c {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.f0.a.d f5287a = new d.c.f0.a.d();

        /* renamed from: b  reason: collision with root package name */
        public final d.c.c0.a f5288b = new d.c.c0.a();

        /* renamed from: c  reason: collision with root package name */
        public final d.c.f0.a.d f5289c = new d.c.f0.a.d();

        /* renamed from: d  reason: collision with root package name */
        public final c f5290d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f5291e;

        public C0112a(c cVar) {
            this.f5290d = cVar;
            this.f5289c.c(this.f5287a);
            this.f5289c.c(this.f5288b);
        }

        @Override // d.c.t.c
        public d.c.c0.b a(Runnable runnable) {
            if (this.f5291e) {
                return d.c.f0.a.c.INSTANCE;
            }
            return this.f5290d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f5287a);
        }

        @Override // d.c.c0.b
        public void b() {
            if (this.f5291e) {
                return;
            }
            this.f5291e = true;
            this.f5289c.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5291e;
        }

        @Override // d.c.t.c
        public d.c.c0.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f5291e) {
                return d.c.f0.a.c.INSTANCE;
            }
            return this.f5290d.a(runnable, j, timeUnit, this.f5288b);
        }
    }

    @Override // d.c.t
    public d.c.c0.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f5286c.get().a().b(runnable, j, j2, timeUnit);
    }
}
