package d.c.f0.e.a;
/* compiled from: CompletableFromPublisher.java */
/* loaded from: classes.dex */
public final class r<T> extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final g.b.b<T> f4764a;

    public r(g.b.b<T> bVar) {
        this.f4764a = bVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4764a.a(new a(dVar));
    }

    /* compiled from: CompletableFromPublisher.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.k<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4765a;

        /* renamed from: b  reason: collision with root package name */
        public g.b.d f4766b;

        public a(d.c.d dVar) {
            this.f4765a = dVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4766b, dVar)) {
                this.f4766b = dVar;
                this.f4765a.a(this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        @Override // g.b.c
        public void a(T t) {
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4766b.cancel();
            this.f4766b = d.c.f0.i.g.CANCELLED;
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4766b == d.c.f0.i.g.CANCELLED;
        }

        @Override // g.b.c
        public void a(Throwable th) {
            this.f4765a.a(th);
        }

        @Override // g.b.c
        public void a() {
            this.f4765a.a();
        }
    }
}
