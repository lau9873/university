package d.c.f0.i;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SubscriptionHelper.java */
/* loaded from: classes.dex */
public enum g implements g.b.d {
    CANCELLED;

    public static boolean a(g.b.d dVar, g.b.d dVar2) {
        if (dVar2 == null) {
            d.c.h0.a.b(new NullPointerException("next is null"));
            return false;
        } else if (dVar != null) {
            dVar2.cancel();
            b();
            return false;
        } else {
            return true;
        }
    }

    public static void b() {
        d.c.h0.a.b(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean c(long j) {
        if (j <= 0) {
            d.c.h0.a.b(new IllegalArgumentException("n > 0 required but it was " + j));
            return false;
        }
        return true;
    }

    @Override // g.b.d
    public void a(long j) {
    }

    @Override // g.b.d
    public void cancel() {
    }

    public static void b(long j) {
        d.c.h0.a.b(new ProtocolViolationException("More produced than requested: " + j));
    }

    public static boolean a(g.b.d dVar) {
        return dVar == CANCELLED;
    }

    public static boolean a(AtomicReference<g.b.d> atomicReference, g.b.d dVar) {
        d.c.f0.b.b.a(dVar, "d is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.cancel();
        if (atomicReference.get() != CANCELLED) {
            b();
            return false;
        }
        return false;
    }

    public static boolean a(AtomicReference<g.b.d> atomicReference) {
        g.b.d andSet;
        g.b.d dVar = atomicReference.get();
        g gVar = CANCELLED;
        if (dVar == gVar || (andSet = atomicReference.getAndSet(gVar)) == CANCELLED) {
            return false;
        }
        if (andSet != null) {
            andSet.cancel();
            return true;
        }
        return true;
    }

    public static boolean a(AtomicReference<g.b.d> atomicReference, AtomicLong atomicLong, g.b.d dVar) {
        if (a(atomicReference, dVar)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                dVar.a(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    public static void a(AtomicReference<g.b.d> atomicReference, AtomicLong atomicLong, long j) {
        g.b.d dVar = atomicReference.get();
        if (dVar != null) {
            dVar.a(j);
        } else if (c(j)) {
            d.c.f0.j.c.a(atomicLong, j);
            g.b.d dVar2 = atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dVar2.a(andSet);
                }
            }
        }
    }
}
