package d.c.f0.e.e;
/* compiled from: SingleDoAfterTerminate.java */
/* loaded from: classes.dex */
public final class l<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5147a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.a f5148b;

    public l(d.c.z<T> zVar, d.c.e0.a aVar) {
        this.f5147a = zVar;
        this.f5148b = aVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5147a.subscribe(new a(wVar, this.f5148b));
    }

    /* compiled from: SingleDoAfterTerminate.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5149a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.a f5150b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c0.b f5151c;

        public a(d.c.w<? super T> wVar, d.c.e0.a aVar) {
            this.f5149a = wVar;
            this.f5150b = aVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5151c, bVar)) {
                this.f5151c = bVar;
                this.f5149a.a(this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5149a.b(t);
            a();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5151c.c();
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5151c.b();
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5149a.a(th);
            a();
        }

        public final void a() {
            try {
                this.f5150b.run();
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                d.c.h0.a.b(th);
            }
        }
    }
}
