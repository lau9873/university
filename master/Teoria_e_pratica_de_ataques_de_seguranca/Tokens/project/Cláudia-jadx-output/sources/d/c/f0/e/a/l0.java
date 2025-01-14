package d.c.f0.e.a;
/* compiled from: CompletableToObservable.java */
/* loaded from: classes.dex */
public final class l0<T> extends d.c.o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4743a;

    /* compiled from: CompletableToObservable.java */
    /* loaded from: classes.dex */
    public static final class a implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.s<?> f4744a;

        public a(d.c.s<?> sVar) {
            this.f4744a = sVar;
        }

        @Override // d.c.d
        public void a() {
            this.f4744a.a();
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4744a.a(th);
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4744a.a(bVar);
        }
    }

    public l0(d.c.g gVar) {
        this.f4743a = gVar;
    }

    @Override // d.c.o
    public void b(d.c.s<? super T> sVar) {
        this.f4743a.subscribe(new a(sVar));
    }
}
