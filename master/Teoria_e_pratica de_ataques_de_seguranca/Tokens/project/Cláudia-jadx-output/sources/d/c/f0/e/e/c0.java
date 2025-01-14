package d.c.f0.e.e;
/* compiled from: SingleHide.java */
/* loaded from: classes.dex */
public final class c0<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5077a;

    /* compiled from: SingleHide.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5078a;

        /* renamed from: b  reason: collision with root package name */
        public d.c.c0.b f5079b;

        public a(d.c.w<? super T> wVar) {
            this.f5078a = wVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5079b, bVar)) {
                this.f5079b = bVar;
                this.f5078a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5079b.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5079b.c();
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5078a.b(t);
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5078a.a(th);
        }
    }

    public c0(d.c.z<? extends T> zVar) {
        this.f5077a = zVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5077a.subscribe(new a(wVar));
    }
}
