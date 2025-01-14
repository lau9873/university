package d.c.f0.e.d;

import d.c.s;
import d.c.t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableInterval.java */
/* loaded from: classes.dex */
public final class k extends d.c.o<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final t f5025a;

    /* renamed from: b  reason: collision with root package name */
    public final long f5026b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5027c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f5028d;

    /* compiled from: ObservableInterval.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<d.c.c0.b> implements d.c.c0.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final s<? super Long> f5029a;

        /* renamed from: b  reason: collision with root package name */
        public long f5030b;

        public a(s<? super Long> sVar) {
            this.f5029a = sVar;
        }

        public void a(d.c.c0.b bVar) {
            d.c.f0.a.b.c(this, bVar);
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
            if (get() != d.c.f0.a.b.DISPOSED) {
                s<? super Long> sVar = this.f5029a;
                long j = this.f5030b;
                this.f5030b = 1 + j;
                sVar.a((s<? super Long>) Long.valueOf(j));
            }
        }
    }

    public k(long j, long j2, TimeUnit timeUnit, t tVar) {
        this.f5026b = j;
        this.f5027c = j2;
        this.f5028d = timeUnit;
        this.f5025a = tVar;
    }

    @Override // d.c.o
    public void b(s<? super Long> sVar) {
        a aVar = new a(sVar);
        sVar.a((d.c.c0.b) aVar);
        aVar.a(this.f5025a.a(aVar, this.f5026b, this.f5027c, this.f5028d));
    }
}
