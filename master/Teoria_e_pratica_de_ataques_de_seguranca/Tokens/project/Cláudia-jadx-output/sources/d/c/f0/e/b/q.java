package d.c.f0.e.b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: FlowableOnBackpressureError.java */
/* loaded from: classes.dex */
public final class q<T> extends d.c.f0.e.b.a<T, T> {
    public q(d.c.j<T> jVar) {
        super(jVar);
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f4795b.a((d.c.k) new a(cVar));
    }

    /* compiled from: FlowableOnBackpressureError.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicLong implements d.c.k<T>, g.b.d {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4912a;

        /* renamed from: b  reason: collision with root package name */
        public g.b.d f4913b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4914c;

        public a(g.b.c<? super T> cVar) {
            this.f4912a = cVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4913b, dVar)) {
                this.f4913b = dVar;
                this.f4912a.a((g.b.d) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        @Override // g.b.d
        public void cancel() {
            this.f4913b.cancel();
        }

        @Override // g.b.c
        public void a(T t) {
            if (this.f4914c) {
                return;
            }
            if (get() != 0) {
                this.f4912a.a((g.b.c<? super T>) t);
                d.c.f0.j.c.b(this, 1L);
                return;
            }
            a((Throwable) new MissingBackpressureException("could not emit value due to lack of requests"));
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f4914c) {
                d.c.h0.a.b(th);
                return;
            }
            this.f4914c = true;
            this.f4912a.a(th);
        }

        @Override // g.b.c
        public void a() {
            if (this.f4914c) {
                return;
            }
            this.f4914c = true;
            this.f4912a.a();
        }

        @Override // g.b.d
        public void a(long j) {
            if (d.c.f0.i.g.c(j)) {
                d.c.f0.j.c.a(this, j);
            }
        }
    }
}
