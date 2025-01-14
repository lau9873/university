package d.c.f0.e.e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SingleTimer.java */
/* loaded from: classes.dex */
public final class o0 extends d.c.u<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final long f5188a;

    /* renamed from: b  reason: collision with root package name */
    public final TimeUnit f5189b;

    /* renamed from: c  reason: collision with root package name */
    public final d.c.t f5190c;

    /* compiled from: SingleTimer.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<d.c.c0.b> implements d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.w<? super Long> f5191a;

        public a(d.c.w<? super Long> wVar) {
            this.f5191a = wVar;
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
            this.f5191a.b(0L);
        }
    }

    public o0(long j, TimeUnit timeUnit, d.c.t tVar) {
        this.f5188a = j;
        this.f5189b = timeUnit;
        this.f5190c = tVar;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super Long> wVar) {
        a aVar = new a(wVar);
        wVar.a(aVar);
        aVar.a(this.f5190c.a(aVar, this.f5188a, this.f5189b));
    }
}
