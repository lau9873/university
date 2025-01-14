package d.c.f0.e.b;

import java.util.concurrent.atomic.AtomicLong;
/* compiled from: FlowableOnBackpressureDrop.java */
/* loaded from: classes.dex */
public final class p<T> extends d.c.f0.e.b.a<T, T> implements d.c.e0.f<T> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.f<? super T> f4907c;

    public p(d.c.j<T> jVar) {
        super(jVar);
        this.f4907c = this;
    }

    @Override // d.c.e0.f
    public void accept(T t) {
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f4795b.a((d.c.k) new a(cVar, this.f4907c));
    }

    /* compiled from: FlowableOnBackpressureDrop.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicLong implements d.c.k<T>, g.b.d {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4908a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.f<? super T> f4909b;

        /* renamed from: c  reason: collision with root package name */
        public g.b.d f4910c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4911d;

        public a(g.b.c<? super T> cVar, d.c.e0.f<? super T> fVar) {
            this.f4908a = cVar;
            this.f4909b = fVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4910c, dVar)) {
                this.f4910c = dVar;
                this.f4908a.a((g.b.d) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        @Override // g.b.d
        public void cancel() {
            this.f4910c.cancel();
        }

        @Override // g.b.c
        public void a(T t) {
            if (this.f4911d) {
                return;
            }
            if (get() != 0) {
                this.f4908a.a((g.b.c<? super T>) t);
                d.c.f0.j.c.b(this, 1L);
                return;
            }
            try {
                this.f4909b.accept(t);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                cancel();
                a(th);
            }
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f4911d) {
                d.c.h0.a.b(th);
                return;
            }
            this.f4911d = true;
            this.f4908a.a(th);
        }

        @Override // g.b.c
        public void a() {
            if (this.f4911d) {
                return;
            }
            this.f4911d = true;
            this.f4908a.a();
        }

        @Override // g.b.d
        public void a(long j) {
            if (d.c.f0.i.g.c(j)) {
                d.c.f0.j.c.a(this, j);
            }
        }
    }
}
