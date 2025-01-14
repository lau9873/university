package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleObserveOn.java */
/* loaded from: classes.dex */
public final class i0<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5123a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.t f5124b;

    public i0(d.c.z<T> zVar, d.c.t tVar) {
        this.f5123a = zVar;
        this.f5124b = tVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5123a.subscribe(new a(wVar, this.f5124b));
    }

    /* compiled from: SingleObserveOn.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.c0.b> implements d.c.w<T>, d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5125a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.t f5126b;

        /* renamed from: c  reason: collision with root package name */
        public T f5127c;

        /* renamed from: d  reason: collision with root package name */
        public Throwable f5128d;

        public a(d.c.w<? super T> wVar, d.c.t tVar) {
            this.f5125a = wVar;
            this.f5126b = tVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.c(this, bVar)) {
                this.f5125a.a(this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5127c = t;
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this, this.f5126b.a(this));
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f5128d;
            if (th != null) {
                this.f5125a.a(th);
            } else {
                this.f5125a.b((T) this.f5127c);
            }
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5128d = th;
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this, this.f5126b.a(this));
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }
    }
}
