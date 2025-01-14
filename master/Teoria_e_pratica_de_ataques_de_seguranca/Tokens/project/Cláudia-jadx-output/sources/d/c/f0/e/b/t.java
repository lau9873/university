package d.c.f0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FlowableRepeatUntil.java */
/* loaded from: classes.dex */
public final class t<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.e f4927c;

    /* compiled from: FlowableRepeatUntil.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements d.c.k<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4928a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.f0.i.f f4929b;

        /* renamed from: c  reason: collision with root package name */
        public final g.b.b<? extends T> f4930c;

        /* renamed from: d  reason: collision with root package name */
        public final d.c.e0.e f4931d;

        public a(g.b.c<? super T> cVar, d.c.e0.e eVar, d.c.f0.i.f fVar, g.b.b<? extends T> bVar) {
            this.f4928a = cVar;
            this.f4929b = fVar;
            this.f4930c = bVar;
            this.f4931d = eVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            this.f4929b.b(dVar);
        }

        public void b() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    this.f4930c.a(this);
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        @Override // g.b.c
        public void a(T t) {
            this.f4928a.a((g.b.c<? super T>) t);
            this.f4929b.b(1L);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.f4928a.a(th);
        }

        @Override // g.b.c
        public void a() {
            try {
                if (this.f4931d.a()) {
                    this.f4928a.a();
                } else {
                    b();
                }
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f4928a.a(th);
            }
        }
    }

    public t(d.c.j<T> jVar, d.c.e0.e eVar) {
        super(jVar);
        this.f4927c = eVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        d.c.f0.i.f fVar = new d.c.f0.i.f();
        cVar.a((g.b.d) fVar);
        new a(cVar, this.f4927c, fVar, this.f4795b).b();
    }
}
