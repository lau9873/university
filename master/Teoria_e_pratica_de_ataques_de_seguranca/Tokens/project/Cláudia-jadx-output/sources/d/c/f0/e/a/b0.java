package d.c.f0.e.a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: CompletableMergeIterable.java */
/* loaded from: classes.dex */
public final class b0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Iterable<? extends d.c.g> f4639a;

    /* compiled from: CompletableMergeIterable.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicBoolean implements d.c.d {

        /* renamed from: a  reason: collision with root package name */
        public final d.c.c0.a f4640a;

        /* renamed from: b  reason: collision with root package name */
        public final d.c.d f4641b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f4642c;

        public a(d.c.d dVar, d.c.c0.a aVar, AtomicInteger atomicInteger) {
            this.f4641b = dVar;
            this.f4640a = aVar;
            this.f4642c = atomicInteger;
        }

        @Override // d.c.d
        public void a(d.c.c0.b bVar) {
            this.f4640a.c(bVar);
        }

        @Override // d.c.d
        public void a(Throwable th) {
            this.f4640a.b();
            if (compareAndSet(false, true)) {
                this.f4641b.a(th);
            } else {
                d.c.h0.a.b(th);
            }
        }

        @Override // d.c.d
        public void a() {
            if (this.f4642c.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.f4641b.a();
            }
        }
    }

    public b0(Iterable<? extends d.c.g> iterable) {
        this.f4639a = iterable;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.c0.a aVar = new d.c.c0.a();
        dVar.a(aVar);
        try {
            Iterator<? extends d.c.g> it = this.f4639a.iterator();
            d.c.f0.b.b.a(it, "The source iterator returned is null");
            Iterator<? extends d.c.g> it2 = it;
            AtomicInteger atomicInteger = new AtomicInteger(1);
            a aVar2 = new a(dVar, aVar, atomicInteger);
            while (!aVar.c()) {
                try {
                    if (!it2.hasNext()) {
                        aVar2.a();
                        return;
                    } else if (aVar.c()) {
                        return;
                    } else {
                        try {
                            d.c.g next = it2.next();
                            d.c.f0.b.b.a(next, "The iterator returned a null CompletableSource");
                            d.c.g gVar = next;
                            if (aVar.c()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            gVar.subscribe(aVar2);
                        } catch (Throwable th) {
                            d.c.d0.a.b(th);
                            aVar.b();
                            aVar2.a(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    aVar.b();
                    aVar2.a(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            d.c.d0.a.b(th3);
            dVar.a(th3);
        }
    }
}
