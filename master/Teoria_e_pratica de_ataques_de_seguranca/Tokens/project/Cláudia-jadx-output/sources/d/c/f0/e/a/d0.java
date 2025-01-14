package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CompletableObserveOn.java */
/* loaded from: classes.dex */
public final class d0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g f4661a;

    /* renamed from: b  reason: collision with root package name */
    public final d.c.t f4662b;

    public d0(d.c.g gVar, d.c.t tVar) {
        this.f4661a = gVar;
        this.f4662b = tVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        this.f4661a.subscribe(new a(dVar, this.f4662b));
    }

    /* compiled from: CompletableObserveOn.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<d.c.c0.b> implements d.c.d, d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4663a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.t f4664b;

        /* renamed from: c  reason: collision with root package name */
        public Throwable f4665c;

        public a(d.c.d dVar, d.c.t tVar) {
            this.f4663a = dVar;
            this.f4664b = tVar;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            if (d.c.f0.a.b.c(this, bVar)) {
                this.f4663a.a(this);
            }
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return d.c.f0.a.b.a(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f4665c;
            if (th != null) {
                this.f4665c = null;
                this.f4663a.a(th);
                return;
            }
            this.f4663a.a();
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4665c = th;
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this, this.f4664b.a(this));
        }

        @Override // d.c.d
        public void a() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this, this.f4664b.a(this));
        }
    }
}
