package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CompletableMerge.java */
/* loaded from: classes.dex */
public final class x extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final g.b.b<? extends d.c.g> f4776a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4777b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f4778c;

    /* compiled from: CompletableMerge.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicInteger implements d.c.k<d.c.g>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4779a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4780b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4781c;

        /* renamed from: f  reason: collision with root package name */
        public g.b.d f4784f;

        /* renamed from: e  reason: collision with root package name */
        public final d.c.c0.a f4783e = new d.c.c0.a();

        /* renamed from: d  reason: collision with root package name */
        public final d.c.f0.j.b f4782d = new d.c.f0.j.b();

        /* compiled from: CompletableMerge.java */
        /* renamed from: d.c.f0.e.a.x$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public final class C0101a extends AtomicReference<d.c.c0.b> implements d.c.d, d.c.c0.b {
            public C0101a() {
            }

            @Override // d.c.d
            public void a(d.c.c0.b bVar) {
                d.c.f0.a.b.c(this, bVar);
            }

            @Override // d.c.c0.b
            public void b() {
                d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
            }

            @Override // d.c.c0.b
            public boolean c() {
                return d.c.f0.a.b.a(get());
            }

            @Override // d.c.d
            public void a(Throwable th) {
                a.this.a(this, th);
            }

            @Override // d.c.d
            public void a() {
                a.this.a(this);
            }
        }

        public a(d.c.d dVar, int i2, boolean z) {
            this.f4779a = dVar;
            this.f4780b = i2;
            this.f4781c = z;
            lazySet(1);
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4784f.cancel();
            this.f4783e.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4783e.c();
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4784f, dVar)) {
                this.f4784f = dVar;
                this.f4779a.a(this);
                int i2 = this.f4780b;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.a(Long.MAX_VALUE);
                } else {
                    dVar.a(i2);
                }
            }
        }

        @Override // g.b.c
        public void a(d.c.g gVar) {
            getAndIncrement();
            C0101a c0101a = new C0101a();
            this.f4783e.c(c0101a);
            gVar.subscribe(c0101a);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (!this.f4781c) {
                this.f4783e.b();
                if (this.f4782d.a(th)) {
                    if (getAndSet(0) > 0) {
                        this.f4779a.a(this.f4782d.a());
                        return;
                    }
                    return;
                }
                d.c.h0.a.b(th);
            } else if (this.f4782d.a(th)) {
                if (decrementAndGet() == 0) {
                    this.f4779a.a(this.f4782d.a());
                }
            } else {
                d.c.h0.a.b(th);
            }
        }

        @Override // g.b.c
        public void a() {
            if (decrementAndGet() == 0) {
                if (this.f4782d.get() != null) {
                    this.f4779a.a(this.f4782d.a());
                } else {
                    this.f4779a.a();
                }
            }
        }

        public void a(C0101a c0101a, Throwable th) {
            this.f4783e.a(c0101a);
            if (!this.f4781c) {
                this.f4784f.cancel();
                this.f4783e.b();
                if (this.f4782d.a(th)) {
                    if (getAndSet(0) > 0) {
                        this.f4779a.a(this.f4782d.a());
                        return;
                    }
                    return;
                }
                d.c.h0.a.b(th);
            } else if (this.f4782d.a(th)) {
                if (decrementAndGet() == 0) {
                    this.f4779a.a(this.f4782d.a());
                } else if (this.f4780b != Integer.MAX_VALUE) {
                    this.f4784f.a(1L);
                }
            } else {
                d.c.h0.a.b(th);
            }
        }

        public void a(C0101a c0101a) {
            this.f4783e.a(c0101a);
            if (decrementAndGet() == 0) {
                Throwable th = this.f4782d.get();
                if (th != null) {
                    this.f4779a.a(th);
                } else {
                    this.f4779a.a();
                }
            } else if (this.f4780b != Integer.MAX_VALUE) {
                this.f4784f.a(1L);
            }
        }
    }

    public x(g.b.b<? extends d.c.g> bVar, int i2, boolean z) {
        this.f4776a = bVar;
        this.f4777b = i2;
        this.f4778c = z;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4776a.a(new a(dVar, this.f4777b, this.f4778c));
    }
}
