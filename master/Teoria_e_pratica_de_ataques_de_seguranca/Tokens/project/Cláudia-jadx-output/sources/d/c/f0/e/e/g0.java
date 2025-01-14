package d.c.f0.e.e;
/* compiled from: SingleMap.java */
/* loaded from: classes.dex */
public final class g0<T, R> extends d.c.u<R> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5107a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.e0.n<? super T, ? extends R> f5108b;

    /* compiled from: SingleMap.java */
    /* loaded from: classes.dex */
    public static final class a<T, R> implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super R> f5109a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.e0.n<? super T, ? extends R> f5110b;

        public a(d.c.w<? super R> wVar, d.c.e0.n<? super T, ? extends R> nVar) {
            this.f5109a = wVar;
            this.f5110b = nVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f5109a.a(bVar);
        }

        @Override // d.c.w
        public void b(T t) {
            try {
                this.f5109a.b(this.f5110b.a(t));
            } catch (Throwable th) {
                d.c.d0.a.b(th);
                a(th);
            }
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5109a.a(th);
        }
    }

    public g0(d.c.z<? extends T> zVar, d.c.e0.n<? super T, ? extends R> nVar) {
        this.f5107a = zVar;
        this.f5108b = nVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super R> wVar) {
        this.f5107a.subscribe(new a(wVar, this.f5108b));
    }
}
