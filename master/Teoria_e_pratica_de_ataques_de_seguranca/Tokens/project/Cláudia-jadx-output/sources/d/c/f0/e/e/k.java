package d.c.f0.e.e;
/* compiled from: SingleDoAfterSuccess.java */
/* loaded from: classes.dex */
public final class k<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5138a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.f<? super T> f5139b;

    public k(d.c.z<T> zVar, d.c.e0.f<? super T> fVar) {
        this.f5138a = zVar;
        this.f5139b = fVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5138a.subscribe(new a(wVar, this.f5139b));
    }

    /* compiled from: SingleDoAfterSuccess.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5140a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.f<? super T> f5141b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c0.b f5142c;

        public a(d.c.w<? super T> wVar, d.c.e0.f<? super T> fVar) {
            this.f5140a = wVar;
            this.f5141b = fVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5142c, bVar)) {
                this.f5142c = bVar;
                this.f5140a.a(this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5140a.b(t);
            try {
                this.f5141b.accept(t);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                d.c.h0.a.b(th);
            }
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5142c.c();
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5140a.a(th);
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5142c.b();
        }
    }
}
