package d.c.f0.e.e;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleDelayWithCompletable.java */
/* loaded from: classes.dex */
public final class g<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5103a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.g f5104b;

    public g(d.c.z<T> zVar, d.c.g gVar) {
        this.f5103a = zVar;
        this.f5104b = gVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5104b.subscribe(new a(wVar, this.f5103a));
    }

    /* compiled from: SingleDelayWithCompletable.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicReference<d.c.c0.b> implements d.c.d, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5105a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.z<T> f5106b;

        public a(d.c.w<? super T> wVar, d.c.z<T> zVar) {
            this.f5105a = wVar;
            this.f5106b = zVar;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.c(this, bVar)) {
                this.f5105a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f5105a.a(th);
        }

        @Override // d.c.d
        public void a() {
            this.f5106b.subscribe(new d.c.f0.d.j(this, this.f5105a));
        }
    }
}
