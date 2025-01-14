package d.c.f0.e.a;
/* compiled from: CompletableDisposeOn.java */
/* loaded from: classes.dex */
public final class i extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4709a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.t f4710b;

    public i(d.c.g gVar, d.c.t tVar) {
        this.f4709a = gVar;
        this.f4710b = tVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4709a.subscribe(new a(dVar, this.f4710b));
    }

    /* compiled from: CompletableDisposeOn.java */
    /* loaded from: classes.dex */
    public static final class a implements d.c.d, d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4711a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.t f4712b;

        /* renamed from: c  reason: collision with root package name */
        public d.c.c0.b f4713c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f4714d;

        public a(d.c.d dVar, d.c.t tVar) {
            this.f4711a = dVar;
            this.f4712b = tVar;
        }

        @Override // d.c.d
        public void a() {
            if (this.f4714d) {
                return;
            }
            this.f4711a.a();
        }

        @Override // d.c.c0.b
        public void b() {
            this.f4714d = true;
            this.f4712b.a(this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return this.f4714d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4713c.b();
            this.f4713c = d.c.f0.a.b.DISPOSED;
        }

        @Override // d.c.d
        public void a(Throwable th) {
            if (this.f4714d) {
                d.c.h0.a.b(th);
            } else {
                this.f4711a.a(th);
            }
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.a(this.f4713c, bVar)) {
                this.f4713c = bVar;
                this.f4711a.a(this);
            }
        }
    }
}
