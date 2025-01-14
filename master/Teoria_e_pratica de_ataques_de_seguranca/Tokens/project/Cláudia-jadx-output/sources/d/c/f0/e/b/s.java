package d.c.f0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FlowableRepeat.java */
/* loaded from: classes.dex */
public final class s<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f4922c;

    /* compiled from: FlowableRepeat.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements d.c.k<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4923a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.f0.i.f f4924b;

        /* renamed from: c  reason: collision with root package name */
        public final g.b.b<? extends T> f4925c;

        /* renamed from: d  reason: collision with root package name */
        public long f4926d;

        public a(g.b.c<? super T> cVar, long j, d.c.f0.i.f fVar, g.b.b<? extends T> bVar) {
            this.f4923a = cVar;
            this.f4924b = fVar;
            this.f4925c = bVar;
            this.f4926d = j;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            this.f4924b.b(dVar);
        }

        public void b() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f4924b.d()) {
                    this.f4925c.a(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.b.c
        public void a(T t) {
            this.f4923a.a((g.b.c<? super T>) t);
            this.f4924b.b(1L);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.f4923a.a(th);
        }

        @Override // g.b.c
        public void a() {
            long j = this.f4926d;
            if (j != Long.MAX_VALUE) {
                this.f4926d = j - 1;
            }
            if (j != 0) {
                b();
            } else {
                this.f4923a.a();
            }
        }
    }

    public s(d.c.j<T> jVar, long j) {
        super(jVar);
        this.f4922c = j;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        d.c.f0.i.f fVar = new d.c.f0.i.f();
        cVar.a((g.b.d) fVar);
        long j = this.f4922c;
        new a(cVar, j != Long.MAX_VALUE ? j - 1 : Long.MAX_VALUE, fVar, this.f4795b).b();
    }
}
