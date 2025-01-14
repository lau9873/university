package d.c.f0.a;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: DisposableHelper.java */
/* loaded from: classes.dex */
public enum b implements d.c.c0.b {
    DISPOSED;

    public static boolean a(d.c.c0.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean b(AtomicReference<d.c.c0.b> atomicReference, d.c.c0.b bVar) {
        d.c.c0.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.b();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 != null) {
            bVar2.b();
            return true;
        }
        return true;
    }

    public static boolean c(AtomicReference<d.c.c0.b> atomicReference, d.c.c0.b bVar) {
        d.c.f0.b.b.a(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.b();
        if (atomicReference.get() != DISPOSED) {
            d();
            return false;
        }
        return false;
    }

    public static void d() {
        d.c.h0.a.b(new ProtocolViolationException("Disposable already set!"));
    }

    @Override // d.c.c0.b
    public void b() {
    }

    @Override // d.c.c0.b
    public boolean c() {
        return true;
    }

    public static boolean a(AtomicReference<d.c.c0.b> atomicReference, d.c.c0.b bVar) {
        d.c.c0.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.b();
                    return false;
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean d(AtomicReference<d.c.c0.b> atomicReference, d.c.c0.b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.b();
            return false;
        }
        return false;
    }

    public static boolean a(AtomicReference<d.c.c0.b> atomicReference) {
        d.c.c0.b andSet;
        d.c.c0.b bVar = atomicReference.get();
        b bVar2 = DISPOSED;
        if (bVar == bVar2 || (andSet = atomicReference.getAndSet(bVar2)) == bVar2) {
            return false;
        }
        if (andSet != null) {
            andSet.b();
            return true;
        }
        return true;
    }

    public static boolean a(d.c.c0.b bVar, d.c.c0.b bVar2) {
        if (bVar2 == null) {
            d.c.h0.a.b(new NullPointerException("next is null"));
            return false;
        } else if (bVar != null) {
            bVar2.b();
            d();
            return false;
        } else {
            return true;
        }
    }
}
