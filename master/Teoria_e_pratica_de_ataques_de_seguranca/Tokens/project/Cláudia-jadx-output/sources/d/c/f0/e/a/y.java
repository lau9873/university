package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: CompletableMergeArray.java */
/* loaded from: classes.dex */
public final class y extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g[] f4786a;

    /* compiled from: CompletableMergeArray.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicInteger implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4787a;

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f4788b;

        /* renamed from: c  reason: collision with root package name */
        public final d.c.c0.a f4789c;

        public a(d.c.d dVar, AtomicBoolean atomicBoolean, d.c.c0.a aVar, int i2) {
            this.f4787a = dVar;
            this.f4788b = atomicBoolean;
            this.f4789c = aVar;
            lazySet(i2);
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4789c.c(bVar);
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4789c.b();
            if (this.f4788b.compareAndSet(false, true)) {
                this.f4787a.a(th);
            } else {
                d.c.h0.a.b(th);
            }
        }

        @Override // d.c.d
        public void a() {
            if (decrementAndGet() == 0 && this.f4788b.compareAndSet(false, true)) {
                this.f4787a.a();
            }
        }
    }

    public y(d.c.g[] gVarArr) {
        this.f4786a = gVarArr;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.g[] gVarArr;
        d.c.c0.a aVar = new d.c.c0.a();
        a aVar2 = new a(dVar, new AtomicBoolean(), aVar, this.f4786a.length + 1);
        dVar.a(aVar);
        for (d.c.g gVar : this.f4786a) {
            if (aVar.c()) {
                return;
            }
            if (gVar == null) {
                aVar.b();
                aVar2.a(new NullPointerException("A completable source is null"));
                return;
            }
            gVar.subscribe(aVar2);
        }
        aVar2.a();
    }
}
