package d.c.f0.e.b;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FlowableRetryBiPredicate.java */
/* loaded from: classes.dex */
public final class v<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.d<? super Integer, ? super Throwable> f4939c;

    /* compiled from: FlowableRetryBiPredicate.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements d.c.k<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4940a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.f0.i.f f4941b;

        /* renamed from: c  reason: collision with root package name */
        public final g.b.b<? extends T> f4942c;

        /* renamed from: d  reason: collision with root package name */
        public final d.c.e0.d<? super Integer, ? super Throwable> f4943d;

        /* renamed from: e  reason: collision with root package name */
        public int f4944e;

        public a(g.b.c<? super T> cVar, d.c.e0.d<? super Integer, ? super Throwable> dVar, d.c.f0.i.f fVar, g.b.b<? extends T> bVar) {
            this.f4940a = cVar;
            this.f4941b = fVar;
            this.f4942c = bVar;
            this.f4943d = dVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            this.f4941b.b(dVar);
        }

        public void b() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f4941b.d()) {
                    this.f4942c.a(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.b.c
        public void a(T t) {
            this.f4940a.a((g.b.c<? super T>) t);
            this.f4941b.b(1L);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            try {
                d.c.e0.d<? super Integer, ? super Throwable> dVar = this.f4943d;
                int i2 = this.f4944e + 1;
                this.f4944e = i2;
                if (!dVar.a(Integer.valueOf(i2), th)) {
                    this.f4940a.a(th);
                } else {
                    b();
                }
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                this.f4940a.a((Throwable) new CompositeException(th, th2));
            }
        }

        @Override // g.b.c
        public void a() {
            this.f4940a.a();
        }
    }

    public v(d.c.j<T> jVar, d.c.e0.d<? super Integer, ? super Throwable> dVar) {
        super(jVar);
        this.f4939c = dVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        d.c.f0.i.f fVar = new d.c.f0.i.f();
        cVar.a((g.b.d) fVar);
        new a(cVar, this.f4939c, fVar, this.f4795b).b();
    }
}
