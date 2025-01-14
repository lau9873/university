package d.c.f0.e.e;
/* compiled from: SingleToObservable.java */
/* loaded from: classes.dex */
public final class q0<T> extends d.c.o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.z<? extends T> f5203a;

    public q0(d.c.z<? extends T> zVar) {
        this.f5203a = zVar;
    }

    @Override // d.c.o
    public void b(d.c.s<? super T> sVar) {
        this.f5203a.subscribe(new a(sVar));
    }

    /* compiled from: SingleToObservable.java */
    /* loaded from: classes.dex */
    public static final class a<T> implements d.c.w<T>, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.s<? super T> f5204a;

        /* renamed from: b  reason: collision with root package name */
        public d.c.c0.b f5205b;

        public a(d.c.s<? super T> sVar) {
            this.f5204a = sVar;
        }

        @Override // d.c.w
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f5205b, bVar)) {
                this.f5205b = bVar;
                this.f5204a.a((d.c.c0.b) this);
            }
        }

        @Override // d.c.w
        public void b(T t) {
            this.f5204a.a((d.c.s<? super T>) t);
            this.f5204a.a();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f5205b.c();
        }

        @Override // d.c.c0.b
        public void b() {
            this.f5205b.b();
        }

        @Override // d.c.w
        public void a(Throwable th) {
            this.f5204a.a(th);
        }
    }
}
