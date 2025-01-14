package p136d.p153c.p160f0.p175j;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: d.c.f0.j.f */
/* loaded from: classes.dex */
public final class ExceptionHelper {

    /* renamed from: a */
    public static final Throwable f7711a = new C1715a("No further exceptions");

    /* compiled from: ExceptionHelper.java */
    /* renamed from: d.c.f0.j.f$a */
    /* loaded from: classes.dex */
    public static class C1715a extends Throwable {
        public C1715a(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: a */
    public static RuntimeException m3413a(Throwable th) {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                return (RuntimeException) th;
            }
            return new RuntimeException(th);
        }
        throw ((Error) th);
    }

    /* renamed from: a */
    public static <T> boolean m3411a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == f7711a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new CompositeException(th2, th)));
        return true;
    }

    /* renamed from: a */
    public static <T> Throwable m3412a(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f7711a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }
}
