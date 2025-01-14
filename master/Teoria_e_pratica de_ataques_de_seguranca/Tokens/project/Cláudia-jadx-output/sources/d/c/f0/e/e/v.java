package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleFlatMapCompletable.java */
/* loaded from: classes.dex */
public final class v<T> extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5244a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends d.c.g> f5245b;

    /* compiled from: SingleFlatMapCompletable.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.c0.b> implements d.c.w<T>, d.c.d, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f5246a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends d.c.g> f5247b;

        public a(d.c.d dVar, d.c.e0.n<? super T, ? extends d.c.g> nVar) {
            this.f5246a = dVar;
            this.f5247b = nVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this, bVar);
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5246a.a(th);
        }

        @Override // d.c.w
        public void b(T t) {
            try {
                d.c.g a2 = this.f5247b.a(t);
                d.c.f0.b.b.a(a2, "The mapper returned a null CompletableSource");
                d.c.g gVar = a2;
                if (c()) {
                    return;
                }
                gVar.subscribe(this);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                a(th);
            }
        }

        @Override // d.c.d
        public void a() {
            this.f5246a.a();
        }
    }

    public v(d.c.z<T> zVar, d.c.e0.n<? super T, ? extends d.c.g> nVar) {
        this.f5244a = zVar;
        this.f5245b = nVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        a aVar = new a(dVar, this.f5245b);
        dVar.a(aVar);
        this.f5244a.subscribe(aVar);
    }
}
