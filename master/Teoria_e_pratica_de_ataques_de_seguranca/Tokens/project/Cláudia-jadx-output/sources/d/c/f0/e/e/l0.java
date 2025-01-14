package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleSubscribeOn.java */
/* loaded from: classes.dex */
public final class l0<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5152a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.t f5153b;

    /* compiled from: SingleSubscribeOn.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.c0.b> implements d.c.w<T>, d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5154a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.f0.a.e f5155b = new d.c.f0.a.e();

        /* renamed from: c  reason: collision with root package name */
        public final d.c.z<? extends T> f5156c;

        public a(d.c.w<? super T> wVar, d.c.z<? extends T> zVar) {
            this.f5154a = wVar;
            this.f5156c = zVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.c(this, bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5154a.b(t);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5156c.subscribe(this);
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5154a.a(th);
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
            this.f5155b.b();
        }
    }

    public l0(d.c.z<? extends T> zVar, d.c.t tVar) {
        this.f5152a = zVar;
        this.f5153b = tVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        a aVar = new a(wVar, this.f5152a);
        wVar.a(aVar);
        aVar.f5155b.a(this.f5153b.a(aVar));
    }
}
