package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleDoOnDispose.java */
/* loaded from: classes.dex */
public final class n<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5167a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.a f5168b;

    public n(d.c.z<T> zVar, d.c.e0.a aVar) {
        this.f5167a = zVar;
        this.f5168b = aVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5167a.subscribe(new a(wVar, this.f5168b));
    }

    /* compiled from: SingleDoOnDispose.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.e0.a> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5169a;

        /* renamed from: b  reason: collision with root package name */
        public d.c.c0.b f5170b;

        public a(d.c.w<? super T> wVar, d.c.e0.a aVar) {
            this.f5169a = wVar;
            lazySet(aVar);
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5170b, bVar)) {
                this.f5170b = bVar;
                this.f5169a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.e0.a andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    d.c.d0.a.b(th);
                    d.c.h0.a.b(th);
                }
                this.f5170b.b();
            }
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5170b.c();
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5169a.a(th);
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5169a.b(t);
        }
    }
}
