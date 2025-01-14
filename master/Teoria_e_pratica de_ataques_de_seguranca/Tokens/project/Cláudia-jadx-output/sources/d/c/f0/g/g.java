package d.c.f0.g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: ScheduledRunnable.java */
/* loaded from: classes.dex */
public final class g extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, d.c.c0.b {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f5320b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f5321c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f5322a;

    public g(Runnable runnable, d.c.f0.a.a aVar) {
        super(2);
        this.f5322a = runnable;
        lazySet(0, aVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f5321c) {
                return;
            }
            if (obj == f5320b) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // d.c.c0.b
    public void b() {
        Object obj;
        Object obj2;
        Object obj3;
        while (true) {
            Object obj4 = get(1);
            if (obj4 == f5321c || obj4 == (obj3 = f5320b)) {
                break;
            } else if (compareAndSet(1, obj4, obj3)) {
                if (obj4 != null) {
                    ((Future) obj4).cancel(true);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f5321c || obj == (obj2 = f5320b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((d.c.f0.a.a) obj).a(this);
    }

    @Override // d.c.c0.b
    public boolean c() {
        Object obj = get(1);
        return obj == f5320b || obj == f5321c;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0033 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.lang.Runnable r2 = r5.f5322a     // Catch: java.lang.Throwable -> L8
            r2.run()     // Catch: java.lang.Throwable -> L8
            goto Lc
        L8:
            r2 = move-exception
            d.c.h0.a.b(r2)     // Catch: java.lang.Throwable -> L34
        Lc:
            java.lang.Object r2 = r5.get(r1)
            java.lang.Object r3 = d.c.f0.g.g.f5320b
            if (r2 == r3) goto L23
            if (r2 == 0) goto L23
            java.lang.Object r3 = d.c.f0.g.g.f5321c
            boolean r1 = r5.compareAndSet(r1, r2, r3)
            if (r1 == 0) goto L23
            d.c.f0.a.a r2 = (d.c.f0.a.a) r2
            r2.a(r5)
        L23:
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = d.c.f0.g.g.f5320b
            if (r1 == r2) goto L33
            java.lang.Object r2 = d.c.f0.g.g.f5321c
            boolean r1 = r5.compareAndSet(r0, r1, r2)
            if (r1 == 0) goto L23
        L33:
            return
        L34:
            r2 = move-exception
            java.lang.Object r3 = r5.get(r1)
            java.lang.Object r4 = d.c.f0.g.g.f5320b
            if (r3 == r4) goto L4c
            if (r3 == 0) goto L4c
            java.lang.Object r4 = d.c.f0.g.g.f5321c
            boolean r1 = r5.compareAndSet(r1, r3, r4)
            if (r1 == 0) goto L4c
            d.c.f0.a.a r3 = (d.c.f0.a.a) r3
            r3.a(r5)
        L4c:
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r3 = d.c.f0.g.g.f5320b
            if (r1 == r3) goto L5d
            java.lang.Object r3 = d.c.f0.g.g.f5321c
            boolean r1 = r5.compareAndSet(r0, r1, r3)
            if (r1 != 0) goto L5d
            goto L4c
        L5d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.f0.g.g.run():void");
    }
}
