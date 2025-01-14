package d.c.f0.e.e;
/* compiled from: SingleDoOnSubscribe.java */
/* loaded from: classes.dex */
public final class q<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f5198a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.f<? super d.c.c0.b> f5199b;

    public q(d.c.z<T> zVar, d.c.e0.f<? super d.c.c0.b> fVar) {
        this.f5198a = zVar;
        this.f5199b = fVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        this.f5198a.subscribe(new a(wVar, this.f5199b));
    }

    /* compiled from: SingleDoOnSubscribe.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super T> f5200a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.f<? super d.c.c0.b> f5201b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5202c;

        public a(d.c.w<? super T> wVar, d.c.e0.f<? super d.c.c0.b> fVar) {
            this.f5200a = wVar;
            this.f5201b = fVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            try {
                this.f5201b.accept(bVar);
                this.f5200a.a(bVar);
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                this.f5202c = true;
                bVar.b();
                d.c.f0.a.c.a(th, this.f5200a);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            if (this.f5202c) {
                return;
            }
            this.f5200a.b(t);
        }

        @Override // d.c.w
        public void a(Throwable th) {
            if (this.f5202c) {
                d.c.h0.a.b(th);
            } else {
                this.f5200a.a(th);
            }
        }
    }
}
