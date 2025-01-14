package d.c.f0.e.d;

import d.c.s;
import d.c.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableTimer.java */
/* loaded from: classes.dex */
public final class q extends d.c.o<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final t f5048a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5049b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f5050c;

    /* compiled from: ObservableTimer.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<d.c.c0.b> implements d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super Long> f5051a;

        public a(s<? super Long> sVar) {
            this.f5051a = sVar;
        }

        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.d(this, bVar);
        }

        @Override // d.c.c0.b
        public void b() {
            d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
        }

        @Override // d.c.c0.b
        public boolean c() {
            return get() == d.c.f0.a.b.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c()) {
                return;
            }
            this.f5051a.a((s<? super Long>) 0L);
            lazySet(d.c.f0.a.c.INSTANCE);
            this.f5051a.a();
        }
    }

    public q(long j, TimeUnit timeUnit, t tVar) {
        this.f5049b = j;
        this.f5050c = timeUnit;
        this.f5048a = tVar;
    }

    @Override // d.c.o
    public void b(s<? super Long> sVar) {
        a aVar = new a(sVar);
        sVar.a((d.c.c0.b) aVar);
        aVar.a(this.f5048a.a(aVar, this.f5049b, this.f5050c));
    }
}
