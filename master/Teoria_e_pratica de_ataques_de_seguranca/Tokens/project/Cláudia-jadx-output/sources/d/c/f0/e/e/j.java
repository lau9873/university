package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleDelayWithSingle.java */
/* loaded from: classes.dex */
public final class j<T, U> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5129a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.z<U> f5130b;

    /* compiled from: SingleDelayWithSingle.java */
    /* loaded from: classes.dex */
    public static final class a<T, U> extends AtomicReference<d.c.c0.b> implements d.c.w<U>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5131a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.z<T> f5132b;

        public a(d.c.w<? super T> wVar, d.c.z<T> zVar) {
            this.f5131a = wVar;
            this.f5132b = zVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.b(this, bVar)) {
                this.f5131a.a(this);
            }
        }

        @Override // d.c.w
        public void b(U u) {
            this.f5132b.subscribe(new d.c.f0.d.j(this, this.f5131a));
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5131a.a(th);
        }
    }

    public j(d.c.z<T> zVar, d.c.z<U> zVar2) {
        this.f5129a = zVar;
        this.f5130b = zVar2;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5130b.subscribe(new a(wVar, this.f5129a));
    }
}
