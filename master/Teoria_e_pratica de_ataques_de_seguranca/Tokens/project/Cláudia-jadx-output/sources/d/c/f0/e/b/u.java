package d.c.f0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: FlowableRepeatWhen.java */
/* loaded from: classes.dex */
public final class u<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final d.c.e0.n<? super d.c.j<Object>, ? extends g.b.b<?>> f4932c;

    /* compiled from: FlowableRepeatWhen.java */
    /* loaded from: classes.dex */
    public static final class b<T, U> extends AtomicInteger implements d.c.k<Object>, g.b.d {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.b<T> f4933a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<g.b.d> f4934b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f4935c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public c<T, U> f4936d;

        public b(g.b.b<T> bVar) {
            this.f4933a = bVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            d.c.f0.i.g.a(this.f4934b, this.f4935c, dVar);
        }

        @Override // g.b.d
        public void cancel() {
            d.c.f0.i.g.a(this.f4934b);
        }

        @Override // g.b.c
        public void a(Object obj) {
            if (getAndIncrement() == 0) {
                while (!d.c.f0.i.g.a(this.f4934b.get())) {
                    this.f4933a.a(this.f4936d);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.f4936d.cancel();
            this.f4936d.f4937h.a(th);
        }

        @Override // g.b.c
        public void a() {
            this.f4936d.cancel();
            this.f4936d.f4937h.a();
        }

        @Override // g.b.d
        public void a(long j) {
            d.c.f0.i.g.a(this.f4934b, this.f4935c, j);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    /* loaded from: classes.dex */
    public static abstract class c<T, U> extends d.c.f0.i.f implements d.c.k<T> {

        /* renamed from: h  reason: collision with root package name */
        public final g.b.c<? super T> f4937h;

        /* renamed from: i  reason: collision with root package name */
        public final d.c.i0.a<U> f4938i;
        public final g.b.d j;
        public long k;

        public c(g.b.c<? super T> cVar, d.c.i0.a<U> aVar, g.b.d dVar) {
            this.f4937h = cVar;
            this.f4938i = aVar;
            this.j = dVar;
        }

        @Override // g.b.c
        public final void a(g.b.d dVar) {
            b(dVar);
        }

        public final void b(U u) {
            long j = this.k;
            if (j != 0) {
                this.k = 0L;
                b(j);
            }
            this.j.a(1L);
            this.f4938i.a((d.c.i0.a<U>) u);
        }

        @Override // d.c.f0.i.f, g.b.d
        public final void cancel() {
            super.cancel();
            this.j.cancel();
        }

        @Override // g.b.c
        public final void a(T t) {
            this.k++;
            this.f4937h.a((g.b.c<? super T>) t);
        }
    }

    public u(d.c.j<T> jVar, d.c.e0.n<? super d.c.j<Object>, ? extends g.b.b<?>> nVar) {
        super(jVar);
        this.f4932c = nVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        d.c.k0.a aVar = new d.c.k0.a(cVar);
        d.c.i0.a<T> i2 = d.c.i0.c.a(8).i();
        try {
            g.b.b<?> a2 = this.f4932c.a(i2);
            d.c.f0.b.b.a(a2, "handler returned a null Publisher");
            g.b.b<?> bVar = a2;
            b bVar2 = new b(this.f4795b);
            a aVar2 = new a(aVar, i2, bVar2);
            bVar2.f4936d = aVar2;
            cVar.a((g.b.d) aVar2);
            bVar.a(bVar2);
            bVar2.a((Object) 0);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.i.d.a(th, cVar);
        }
    }

    /* compiled from: FlowableRepeatWhen.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends c<T, Object> {
        public a(g.b.c<? super T> cVar, d.c.i0.a<Object> aVar, g.b.d dVar) {
            super(cVar, aVar, dVar);
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.j.cancel();
            this.f4937h.a(th);
        }

        @Override // g.b.c
        public void a() {
            b((a<T>) 0);
        }
    }
}
