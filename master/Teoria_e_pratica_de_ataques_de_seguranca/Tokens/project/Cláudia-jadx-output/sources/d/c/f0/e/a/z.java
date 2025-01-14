package d.c.f0.e.a;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: CompletableMergeDelayErrorArray.java */
/* loaded from: classes.dex */
public final class z extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final d.c.g[] f4790a;

    /* compiled from: CompletableMergeDelayErrorArray.java */
    /* loaded from: classes.dex */
    public static final class a implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.d f4791a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.c0.a f4792b;

        /* renamed from: c  reason: collision with root package name */
        public final d.c.f0.j.b f4793c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f4794d;

        public a(d.c.d dVar, d.c.c0.a aVar, d.c.f0.j.b bVar, AtomicInteger atomicInteger) {
            this.f4791a = dVar;
            this.f4792b = aVar;
            this.f4793c = bVar;
            this.f4794d = atomicInteger;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4792b.c(bVar);
        }

        public void b() {
            if (this.f4794d.decrementAndGet() == 0) {
                Throwable a2 = this.f4793c.a();
                if (a2 == null) {
                    this.f4791a.a();
                } else {
                    this.f4791a.a(a2);
                }
            }
        }

        @Override // d.c.d
        public void a(Throwable th) {
            if (this.f4793c.a(th)) {
                b();
            } else {
                d.c.h0.a.b(th);
            }
        }

        @Override // d.c.d
        public void a() {
            b();
        }
    }

    public z(d.c.g[] gVarArr) {
        this.f4790a = gVarArr;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.g[] gVarArr;
        d.c.c0.a aVar = new d.c.c0.a();
        AtomicInteger atomicInteger = new AtomicInteger(this.f4790a.length + 1);
        d.c.f0.j.b bVar = new d.c.f0.j.b();
        dVar.a(aVar);
        for (d.c.g gVar : this.f4790a) {
            if (aVar.c()) {
                return;
            }
            if (gVar == null) {
                bVar.a(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                gVar.subscribe(new a(dVar, aVar, bVar, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable a2 = bVar.a();
            if (a2 == null) {
                dVar.a();
            } else {
                dVar.a(a2);
            }
        }
    }
}
