package d.c.f0.e.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: CompletableTimer.java */
/* loaded from: classes.dex */
public final class j0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final long f4733a;

    /* renamed from: b  reason: collision with root package name */
    public final TimeUnit f4734b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.t f4735c;

    /* compiled from: CompletableTimer.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<d.c.c0.b> implements d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4736a;

        public a(d.c.d dVar) {
            this.f4736a = dVar;
        }

        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this, bVar);
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
            this.f4736a.a();
        }
    }

    public j0(long j, TimeUnit timeUnit, d.c.t tVar) {
        this.f4733a = j;
        this.f4734b = timeUnit;
        this.f4735c = tVar;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        a aVar = new a(dVar);
        dVar.a(aVar);
        aVar.a(this.f4735c.a(aVar, this.f4733a, this.f4734b));
    }
}
