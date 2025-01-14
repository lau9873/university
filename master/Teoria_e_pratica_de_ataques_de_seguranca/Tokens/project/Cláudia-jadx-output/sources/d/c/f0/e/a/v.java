package d.c.f0.e.a;
/* compiled from: CompletableHide.java */
/* loaded from: classes.dex */
public final class v extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4771a;

    public v(d.c.g gVar) {
        this.f4771a = gVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4771a.subscribe(new a(dVar));
    }

    /* compiled from: CompletableHide.java */
    /* loaded from: classes.dex */
    public static final class a implements d.c.d, d.c.c0.b {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4772a;

        /* renamed from: b  reason: collision with root package name */
        public d.c.c0.b f4773b;

        public a(d.c.d dVar) {
            this.f4772a = dVar;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f4773b, bVar)) {
                this.f4773b = bVar;
                this.f4772a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4773b.b();
            this.f4773b = d.c.f0.a.b.DISPOSED;
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4773b.c();
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4772a.a(th);
        }

        @Override // d.c.d
        public void a() {
            this.f4772a.a();
        }
    }
}
