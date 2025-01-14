package d.c.f0.e.e;
/* compiled from: SingleToFlowable.java */
/* loaded from: classes.dex */
public final class p0<T> extends d.c.j<T> {

    /* renamed from: b  reason: collision with root package name */
    public final d.c.z<? extends T> f5196b;

    public p0(d.c.z<? extends T> zVar) {
        this.f5196b = zVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f5196b.subscribe(new a(cVar));
    }

    /* compiled from: SingleToFlowable.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends d.c.f0.i.c<T> implements d.c.w<T> {

        /* renamed from: c  reason: collision with root package name */
        public d.c.c0.b f5197c;

        public a(g.b.c<? super T> cVar) {
            super(cVar);
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5197c, bVar)) {
                this.f5197c = bVar;
                this.f5352a.a((g.b.d) this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            d(t);
        }

        @Override // d.c.f0.i.c, g.b.d
        public void cancel() {
            super.cancel();
            this.f5197c.b();
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5352a.a(th);
        }
    }
}
