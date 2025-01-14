package d.c.f0.j;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: HalfSerializer.java */
/* loaded from: classes.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(g.b.c<? super T> cVar, T t, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.a((g.b.c<? super T>) t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable a2 = bVar.a();
                if (a2 != null) {
                    cVar.a(a2);
                } else {
                    cVar.a();
                }
            }
        }
    }

    public static void a(g.b.c<?> cVar, Throwable th, AtomicInteger atomicInteger, b bVar) {
        if (bVar.a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                cVar.a(bVar.a());
                return;
            }
            return;
        }
        d.c.h0.a.b(th);
    }

    public static void a(g.b.c<?> cVar, AtomicInteger atomicInteger, b bVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable a2 = bVar.a();
            if (a2 != null) {
                cVar.a(a2);
            } else {
                cVar.a();
            }
        }
    }
}
