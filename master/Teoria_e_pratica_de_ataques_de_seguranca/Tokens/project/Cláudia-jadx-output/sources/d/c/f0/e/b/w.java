package d.c.f0.e.b;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FlowableRetryPredicate.java */
/* loaded from: classes.dex */
public final class w<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.p<? super Throwable> f4945c;

    /* renamed from: d  reason: collision with root package name */
    public final long f4946d;

    /* compiled from: FlowableRetryPredicate.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements d.c.k<T> {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4947a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.f0.i.f f4948b;

        /* renamed from: c  reason: collision with root package name */
        public final g.b.b<? extends T> f4949c;

        /* renamed from: d  reason: collision with root package name */
        public final d.c.e0.p<? super Throwable> f4950d;

        /* renamed from: e  reason: collision with root package name */
        public long f4951e;

        public a(g.b.c<? super T> cVar, long j, d.c.e0.p<? super Throwable> pVar, d.c.f0.i.f fVar, g.b.b<? extends T> bVar) {
            this.f4947a = cVar;
            this.f4948b = fVar;
            this.f4949c = bVar;
            this.f4950d = pVar;
            this.f4951e = j;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            this.f4948b.b(dVar);
        }

        public void b() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f4948b.d()) {
                    this.f4949c.a(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.b.c
        public void a(T t) {
            this.f4947a.a((g.b.c<? super T>) t);
            this.f4948b.b(1L);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            long j = this.f4951e;
            if (j != Long.MAX_VALUE) {
                this.f4951e = j - 1;
            }
            if (j == 0) {
                this.f4947a.a(th);
                return;
            }
            try {
                if (!this.f4950d.a(th)) {
                    this.f4947a.a(th);
                } else {
                    b();
                }
            } catch (Throwable th2) {
                d.c.d0.a.b(th2);
                this.f4947a.a((Throwable) new CompositeException(th, th2));
            }
        }

        @Override // g.b.c
        public void a() {
            this.f4947a.a();
        }
    }

    public w(d.c.j<T> jVar, long j, d.c.e0.p<? super Throwable> pVar) {
        super(jVar);
        this.f4945c = pVar;
        this.f4946d = j;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        d.c.f0.i.f fVar = new d.c.f0.i.f();
        cVar.a((g.b.d) fVar);
        new a(cVar, this.f4946d, this.f4945c, fVar, this.f4795b).b();
    }
}
