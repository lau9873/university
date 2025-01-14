package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CompletableSubscribeOn.java */
/* loaded from: classes.dex */
public final class h0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4704a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.t f4705b;

    /* compiled from: CompletableSubscribeOn.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<d.c.c0.b> implements d.c.d, d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4706a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.f0.a.e f4707b = new d.c.f0.a.e();

        /* renamed from: c  reason: collision with root package name */
        public final d.c.g f4708c;

        public a(d.c.d dVar, d.c.g gVar) {
            this.f4706a = dVar;
            this.f4708c = gVar;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.c(this, bVar);
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
            this.f4707b.b();
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4708c.subscribe(this);
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4706a.a(th);
        }

        @Override // d.c.d
        public void a() {
            this.f4706a.a();
        }
    }

    public h0(d.c.g gVar, d.c.t tVar) {
        this.f4704a = gVar;
        this.f4705b = tVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        a aVar = new a(dVar, this.f4704a);
        dVar.a(aVar);
        aVar.f4707b.a(this.f4705b.a(aVar));
    }
}
