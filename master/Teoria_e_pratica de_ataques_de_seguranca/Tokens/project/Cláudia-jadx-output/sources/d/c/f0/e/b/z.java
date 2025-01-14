package d.c.f0.e.b;
/* compiled from: FlowableSingle.java */
/* loaded from: classes.dex */
public final class z<T> extends d.c.f0.e.b.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final T f4955c;

    public z(d.c.j<T> jVar, T t) {
        super(jVar);
        this.f4955c = t;
    }

    @Override // d.c.j
    public void b(g.b.c<? super T> cVar) {
        this.f4795b.a((d.c.k) new a(cVar, this.f4955c));
    }

    /* compiled from: FlowableSingle.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends d.c.f0.i.c<T> implements d.c.k<T> {

        /* renamed from: c  reason: collision with root package name */
        public final T f4956c;

        /* renamed from: d  reason: collision with root package name */
        public g.b.d f4957d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4958e;

        public a(g.b.c<? super T> cVar, T t) {
            super(cVar);
            this.f4956c = t;
        }

        @Override // g.b.c
        public void a(g.b.d dVar) {
            if (d.c.f0.i.g.a(this.f4957d, dVar)) {
                this.f4957d = dVar;
                this.f5352a.a((g.b.d) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        @Override // d.c.f0.i.c, g.b.d
        public void cancel() {
            super.cancel();
            this.f4957d.cancel();
        }

        @Override // g.b.c
        public void a(T t) {
            if (this.f4958e) {
                return;
            }
            if (this.f5353b != null) {
                this.f4958e = true;
                this.f4957d.cancel();
                this.f5352a.a((Throwable) new IllegalArgumentException("Sequence contains more than one element!"));
                return;
            }
            this.f5353b = t;
        }

        @Override // g.b.c
        public void a(Throwable th) {
            if (this.f4958e) {
                d.c.h0.a.b(th);
                return;
            }
            this.f4958e = true;
            this.f5352a.a(th);
        }

        @Override // g.b.c
        public void a() {
            if (this.f4958e) {
                return;
            }
            this.f4958e = true;
            T t = this.f5353b;
            this.f5353b = null;
            if (t == null) {
                t = this.f4956c;
            }
            if (t == null) {
                this.f5352a.a();
            } else {
                d(t);
            }
        }
    }
}
