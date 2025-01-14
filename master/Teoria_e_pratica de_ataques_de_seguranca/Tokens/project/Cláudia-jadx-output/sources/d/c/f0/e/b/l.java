package d.c.f0.e.b;
/* compiled from: FlowableFromObservable.java */
/* loaded from: classes.dex */
public final class l<T> extends d.c.j<T> {

    /* renamed from: b  reason: collision with root package name */
    public final d.c.o<T> f4889b;

    /* compiled from: FlowableFromObservable.java */
    /* loaded from: classes.dex */
    public static class a<T> implements d.c.s<T>, g.b.d {

        /* renamed from: a  reason: collision with root package name */
        public final g.b.c<? super T> f4890a;

        /* renamed from: b  reason: collision with root package name */
        public d.c.c0.b f4891b;

        public a(g.b.c<? super T> cVar) {
            this.f4890a = cVar;
        }

        @Override // d.c.s
        public void a() {
            this.f4890a.a();
        }

        @Override // g.b.d
        public void a(long j) {
        }

        @Override // g.b.d
        public void cancel() {
            this.f4891b.b();
        }

        @Override // d.c.s
        public void a(Throwable th) {
            this.f4890a.a(th);
        }

        @Override // d.c.s
        public void a(T t) {
            this.f4890a.a((g.b.c<? super T>) t);
        }

        @Override // d.c.s
        public void a(d.c.c0.b bVar) {
            this.f4891b = bVar;
            this.f4890a.a((g.b.d) this);
        }
    }

    public l(d.c.o<T> oVar) {
        this.f4889b = oVar;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f4889b.a((d.c.s) new a(cVar));
    }
}
