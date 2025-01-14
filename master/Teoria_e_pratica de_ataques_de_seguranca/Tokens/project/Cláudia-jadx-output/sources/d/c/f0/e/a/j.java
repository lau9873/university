package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: CompletableDoFinally.java */
/* loaded from: classes.dex */
public final class j extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4728a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.a f4729b;

    public j(d.c.g gVar, d.c.e0.a aVar) {
        this.f4728a = gVar;
        this.f4729b = aVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4728a.subscribe(new a(dVar, this.f4729b));
    }

    /* compiled from: CompletableDoFinally.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicInteger implements d.c.d, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4730a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.a f4731b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c0.b f4732c;

        public a(d.c.d dVar, d.c.e0.a aVar) {
            this.f4730a = dVar;
            this.f4731b = aVar;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f4732c, bVar)) {
                this.f4732c = bVar;
                this.f4730a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4732c.b();
            d();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4732c.c();
        }

        public void d() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f4731b.run();
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    d.c.h0.a.b(th);
                }
            }
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4730a.a(th);
            d();
        }

        @Override // d.c.d
        public void a() {
            this.f4730a.a();
            d();
        }
    }
}
