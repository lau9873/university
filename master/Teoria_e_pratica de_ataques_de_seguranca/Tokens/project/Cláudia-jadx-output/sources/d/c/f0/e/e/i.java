package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleDelayWithPublisher.java */
/* loaded from: classes.dex */
public final class i<T, U> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5117a;

    /* renamed from: b  reason: collision with root package name */
    public final g.b.b<U> f5118b;

    public i(d.c.z<T> zVar, g.b.b<U> bVar) {
        this.f5117a = zVar;
        this.f5118b = bVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5118b.a(new a(wVar, this.f5117a));
    }

    /* compiled from: SingleDelayWithPublisher.java */
    /* loaded from: classes.dex */
    public static final class a<T, U> extends AtomicReference<d.c.c0.b> implements d.c.k<U>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5119a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.z<T> f5120b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5121c;

        /* renamed from: d  reason: collision with root package name */
        public g.b.d f5122d;

        public a(d.c.w<? super T> wVar, d.c.z<T> zVar) {
            this.f5119a = wVar;
            this.f5120b = zVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f5122d, dVar)) {
                this.f5122d = dVar;
                this.f5119a.a(this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5122d.cancel();
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // g.b.c
        public void a(U u) {
            this.f5122d.cancel();
            a();
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f5121c) {
                d.c.h0.a.b(th);
                return;
            }
            this.f5121c = true;
            this.f5119a.a(th);
        }

        @Override // g.b.c
        public void a() {
            if (this.f5121c) {
                return;
            }
            this.f5121c = true;
            this.f5120b.subscribe(new d.c.f0.d.j(this, this.f5119a));
        }
    }
}
