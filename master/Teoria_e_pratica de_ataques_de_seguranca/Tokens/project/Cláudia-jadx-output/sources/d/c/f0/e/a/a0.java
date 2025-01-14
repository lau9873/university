package d.c.f0.e.a;

import d.c.f0.e.a.z;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: CompletableMergeDelayErrorIterable.java */
/* loaded from: classes.dex */
public final class a0 extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Iterable<? extends d.c.g> f4630a;

    public a0(Iterable<? extends d.c.g> iterable) {
        this.f4630a = iterable;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.c0.a aVar = new d.c.c0.a();
        dVar.a(aVar);
        try {
            Iterator<? extends d.c.g> it = this.f4630a.iterator();
            d.c.f0.b.b.a(it, "The source iterator returned is null");
            Iterator<? extends d.c.g> it2 = it;
            AtomicInteger atomicInteger = new AtomicInteger(1);
            d.c.f0.j.b bVar = new d.c.f0.j.b();
            while (!aVar.c()) {
                try {
                    if (it2.hasNext()) {
                        if (aVar.c()) {
                            return;
                        }
                        try {
                            d.c.g next = it2.next();
                            d.c.f0.b.b.a(next, "The iterator returned a null CompletableSource");
                            d.c.g gVar = next;
                            if (aVar.c()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            gVar.subscribe(new z.a(dVar, aVar, bVar, atomicInteger));
                        } catch (Throwable th) {
                            d.c.d0.a.b(th);
                            bVar.a(th);
                        }
                    }
                } catch (Throwable th2) {
                    d.c.d0.a.b(th2);
                    bVar.a(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable a2 = bVar.a();
                    if (a2 == null) {
                        dVar.a();
                        return;
                    } else {
                        dVar.a(a2);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th3) {
            d.c.d0.a.b(th3);
            dVar.a(th3);
        }
    }
}
