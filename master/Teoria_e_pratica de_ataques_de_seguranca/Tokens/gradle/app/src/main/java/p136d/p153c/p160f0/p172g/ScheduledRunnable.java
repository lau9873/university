package p136d.p153c.p160f0.p172g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableContainer;

/* renamed from: d.c.f0.g.g */
/* loaded from: classes.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {

    /* renamed from: b */
    public static final Object f7656b = new Object();

    /* renamed from: c */
    public static final Object f7657c = new Object();

    /* renamed from: a */
    public final Runnable f7658a;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(2);
        this.f7658a = runnable;
        lazySet(0, disposableContainer);
    }

    /* renamed from: a */
    public void m3449a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f7657c) {
                return;
            }
            if (obj == f7656b) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: b */
    public void mo578b() {
        Object obj;
        Object obj2;
        Object obj3;
        while (true) {
            Object obj4 = get(1);
            if (obj4 == f7657c || obj4 == (obj3 = f7656b)) {
                break;
            } else if (compareAndSet(1, obj4, obj3)) {
                if (obj4 != null) {
                    ((Future) obj4).cancel(true);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f7657c || obj == (obj2 = f7656b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((DisposableContainer) obj).mo3636a(this);
    }

    @Override // p136d.p153c.p157c0.Disposable
    /* renamed from: c */
    public boolean mo577c() {
        Object obj = get(1);
        return obj == f7656b || obj == f7657c;
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.lang.Runnable r2 = r5.f7658a     // Catch: java.lang.Throwable -> L8
            r2.run()     // Catch: java.lang.Throwable -> L8
            goto Lc
        L8:
            r2 = move-exception
            p136d.p153c.p177h0.RxJavaPlugins.m3371b(r2)     // Catch: java.lang.Throwable -> L34
        Lc:
            java.lang.Object r2 = r5.get(r1)
            java.lang.Object r3 = p136d.p153c.p160f0.p172g.ScheduledRunnable.f7656b
            if (r2 == r3) goto L23
            if (r2 == 0) goto L23
            java.lang.Object r3 = p136d.p153c.p160f0.p172g.ScheduledRunnable.f7657c
            boolean r1 = r5.compareAndSet(r1, r2, r3)
            if (r1 == 0) goto L23
            d.c.f0.a.a r2 = (p136d.p153c.p160f0.p161a.DisposableContainer) r2
            r2.mo3636a(r5)
        L23:
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = p136d.p153c.p160f0.p172g.ScheduledRunnable.f7656b
            if (r1 == r2) goto L33
            java.lang.Object r2 = p136d.p153c.p160f0.p172g.ScheduledRunnable.f7657c
            boolean r1 = r5.compareAndSet(r0, r1, r2)
            if (r1 == 0) goto L23
        L33:
            return
        L34:
            r2 = move-exception
            java.lang.Object r3 = r5.get(r1)
            java.lang.Object r4 = p136d.p153c.p160f0.p172g.ScheduledRunnable.f7656b
            if (r3 == r4) goto L4c
            if (r3 == 0) goto L4c
            java.lang.Object r4 = p136d.p153c.p160f0.p172g.ScheduledRunnable.f7657c
            boolean r1 = r5.compareAndSet(r1, r3, r4)
            if (r1 == 0) goto L4c
            d.c.f0.a.a r3 = (p136d.p153c.p160f0.p161a.DisposableContainer) r3
            r3.mo3636a(r5)
        L4c:
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r3 = p136d.p153c.p160f0.p172g.ScheduledRunnable.f7656b
            if (r1 == r3) goto L5d
            java.lang.Object r3 = p136d.p153c.p160f0.p172g.ScheduledRunnable.f7657c
            boolean r1 = r5.compareAndSet(r0, r1, r3)
            if (r1 != 0) goto L5d
            goto L4c
        L5d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p136d.p153c.p160f0.p172g.ScheduledRunnable.run():void");
    }
}
