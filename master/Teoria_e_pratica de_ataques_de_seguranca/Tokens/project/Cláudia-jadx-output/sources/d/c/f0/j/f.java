package d.c.f0.j;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ExceptionHelper.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f5375a = new a("No further exceptions");

    /* compiled from: ExceptionHelper.java */
    /* loaded from: classes.dex */
    public static class a extends Throwable {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static RuntimeException a(Throwable th) {
        if (!(th instanceof Error)) {
            if (th instanceof RuntimeException) {
                return (RuntimeException) th;
            }
            return new RuntimeException(th);
        }
        throw ((Error) th);
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == f5375a) {
                return false;
            }
        } while (!atomicReference.compareAndSet(th2, th2 == null ? th : new CompositeException(th2, th)));
        return true;
    }

    public static <T> Throwable a(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f5375a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }
}
