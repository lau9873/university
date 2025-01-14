package d.c.f0.e.a;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CompletableConcat.java */
/* loaded from: classes.dex */
public final class c extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final g.b.b<? extends d.c.g> f4643a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4644b;

    /* compiled from: CompletableConcat.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicInteger implements d.c.k<d.c.g>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4645a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4646b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4647c;

        /* renamed from: d  reason: collision with root package name */
        public final C0097a f4648d = new C0097a(this);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f4649e = new AtomicBoolean();

        /* renamed from: f  reason: collision with root package name */
        public int f4650f;

        /* renamed from: g  reason: collision with root package name */
        public int f4651g;

        /* renamed from: h  reason: collision with root package name */
        public d.c.f0.c.n<d.c.g> f4652h;

        /* renamed from: i  reason: collision with root package name */
        public g.b.d f4653i;
        public volatile boolean j;
        public volatile boolean k;

        /* compiled from: CompletableConcat.java */
        /* renamed from: d.c.f0.e.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0097a extends AtomicReference<d.c.c0.b> implements d.c.d {

            /* renamed from: a  reason: collision with root package name */
            public final a f4654a;

            public C0097a(a aVar) {
                this.f4654a = aVar;
            }

            @Override // d.c.d
            public void a(d.c.c0.b bVar) {
                d.c.f0.a.b.a(this, bVar);
            }

            @Override // d.c.d
            public void a(Throwable th) {
                this.f4654a.b(th);
            }

            @Override // d.c.d
            public void a() {
                this.f4654a.e();
            }
        }

        public a(d.c.d dVar, int i2) {
            this.f4645a = dVar;
            this.f4646b = i2;
            this.f4647c = i2 - (i2 >> 2);
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4653i.cancel();
            d.c.f0.a.b.a(this.f4648d);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(this.f4648d.get());
        }

        public void d() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!c()) {
                if (!this.k) {
                    boolean z = this.j;
                    try {
                        d.c.g poll = this.f4652h.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            if (this.f4649e.compareAndSet(false, true)) {
                                this.f4645a.a();
                                return;
                            }
                            return;
                        } else if (!z2) {
                            this.k = true;
                            poll.subscribe(this.f4648d);
                            f();
                        }
                    } catch (Throwable th) {
                        d.c.d0.a.b(th);
                        b(th);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        public void e() {
            this.k = false;
            d();
        }

        public void f() {
            if (this.f4650f != 1) {
                int i2 = this.f4651g + 1;
                if (i2 == this.f4647c) {
                    this.f4651g = 0;
                    this.f4653i.a(i2);
                    return;
                }
                this.f4651g = i2;
            }
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4653i, dVar)) {
                this.f4653i = dVar;
                int i2 = this.f4646b;
                long j = i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : i2;
                if (dVar instanceof d.c.f0.c.k) {
                    d.c.f0.c.k kVar = (d.c.f0.c.k) dVar;
                    int a2 = kVar.a(3);
                    if (a2 == 1) {
                        this.f4650f = a2;
                        this.f4652h = kVar;
                        this.j = true;
                        this.f4645a.a(this);
                        d();
                        return;
                    } else if (a2 == 2) {
                        this.f4650f = a2;
                        this.f4652h = kVar;
                        this.f4645a.a(this);
                        dVar.a(j);
                        return;
                    }
                }
                int i3 = this.f4646b;
                if (i3 == Integer.MAX_VALUE) {
                    this.f4652h = new d.c.f0.f.b(d.c.j.g());
                } else {
                    this.f4652h = new d.c.f0.f.a(i3);
                }
                this.f4645a.a(this);
                dVar.a(j);
            }
        }

        public void b(Throwable th) {
            if (this.f4649e.compareAndSet(false, true)) {
                this.f4653i.cancel();
                this.f4645a.a(th);
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // g.b.c
        public void a(d.c.g gVar) {
            if (this.f4650f == 0 && !this.f4652h.offer(gVar)) {
                a((Throwable) new MissingBackpressureException());
            } else {
                d();
            }
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f4649e.compareAndSet(false, true)) {
                d.c.f0.a.b.a(this.f4648d);
                this.f4645a.a(th);
                return;
            }
            d.c.h0.a.b(th);
        }

        @Override // g.b.c
        public void a() {
            this.j = true;
            d();
        }
    }

    public c(g.b.b<? extends d.c.g> bVar, int i2) {
        this.f4643a = bVar;
        this.f4644b = i2;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4643a.a(new a(dVar, this.f4644b));
    }
}
