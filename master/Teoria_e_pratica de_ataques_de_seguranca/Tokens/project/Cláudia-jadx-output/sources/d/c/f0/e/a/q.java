package d.c.f0.e.a;
/* compiled from: CompletableFromObservable.java */
/* loaded from: classes.dex */
public final class q<T> extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.r<T> f4762a;

    /* compiled from: CompletableFromObservable.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.s<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4763a;

        public a(d.c.d dVar) {
            this.f4763a = dVar;
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            this.f4763a.a(bVar);
        }

        @Override // d.c.s
        public void a(T t) {
        }

        @Override // d.c.s
        public void a(Throwable th) {
            this.f4763a.a(th);
        }

        @Override // d.c.s
        public void a() {
            this.f4763a.a();
        }
    }

    public q(d.c.r<T> rVar) {
        this.f4762a = rVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4762a.a(new a(dVar));
    }
}
