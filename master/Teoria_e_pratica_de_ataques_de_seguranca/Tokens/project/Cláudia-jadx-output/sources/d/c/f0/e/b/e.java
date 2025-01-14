package d.c.f0.e.b;
/* compiled from: FlowableDelaySubscriptionOther.java */
/* loaded from: classes.dex */
public final class e<T, U> extends d.c.j<T> {

    /* renamed from: b  reason: collision with root package name */
    public final g.b.b<? extends T> f4839b;

    /* renamed from: c  reason: collision with root package name */
    public final g.b.b<U> f4840c;

    public e(g.b.b<? extends T> bVar, g.b.b<U> bVar2) {
        this.f4839b = bVar;
        this.f4840c = bVar2;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        d.c.f0.i.f fVar = new d.c.f0.i.f();
        cVar.a((g.b.d) fVar);
        this.f4840c.a(new a(fVar, cVar));
    }

    /* compiled from: FlowableDelaySubscriptionOther.java */
    /* loaded from: classes.dex */
    public class a implements d.c.k<U> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4841a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.c.f0.i.f f4842b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g.b.c f4843c;

        /* compiled from: FlowableDelaySubscriptionOther.java */
        /* renamed from: d.c.f0.e.b.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0104a implements g.b.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g.b.d f4845a;

            public C0104a(a aVar, g.b.d dVar) {
                this.f4845a = dVar;
            }

            @Override // g.b.d
            public void a(long j) {
            }

            @Override // g.b.d
            public void cancel() {
                this.f4845a.cancel();
            }
        }

        /* compiled from: FlowableDelaySubscriptionOther.java */
        /* loaded from: classes.dex */
        public class b implements d.c.k<T> {
            public b() {
            }

            @Override // g.b.c
            public void a(g.b.d dVar) {
                a.this.f4842b.b(dVar);
            }

            @Override // g.b.c
            public void a(T t) {
                a.this.f4843c.a((g.b.c) t);
            }

            @Override // g.b.c
            public void a(Throwable th) {
                a.this.f4843c.a(th);
            }

            @Override // g.b.c
            public void a() {
                a.this.f4843c.a();
            }
        }

        public a(d.c.f0.i.f fVar, g.b.c cVar) {
            this.f4842b = fVar;
            this.f4843c = cVar;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            this.f4842b.b(new C0104a(this, dVar));
            dVar.a(Long.MAX_VALUE);
        }

        @Override // g.b.c
        public void a(U u) {
            a();
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f4841a) {
                d.c.h0.a.b(th);
                return;
            }
            this.f4841a = true;
            this.f4843c.a(th);
        }

        @Override // g.b.c
        public void a() {
            if (this.f4841a) {
                return;
            }
            this.f4841a = true;
            e.this.f4839b.a(new b());
        }
    }
}
