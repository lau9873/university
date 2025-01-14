package d.c.f0.e.a;
/* compiled from: CompletableFromSingle.java */
/* loaded from: classes.dex */
public final class t<T> extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<T> f4768a;

    /* compiled from: CompletableFromSingle.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.w<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4769a;

        public a(d.c.d dVar) {
            this.f4769a = dVar;
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f4769a.a(th);
        }

        @Override // d.c.w
        public void b(T t) {
            this.f4769a.a();
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            this.f4769a.a(bVar);
        }
    }

    public t(d.c.z<T> zVar) {
        this.f4768a = zVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4768a.subscribe(new a(dVar));
    }
}
