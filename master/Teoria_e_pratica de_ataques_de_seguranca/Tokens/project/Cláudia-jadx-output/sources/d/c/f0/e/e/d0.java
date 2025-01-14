package d.c.f0.e.e;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
/* compiled from: SingleInternalHelper.java */
/* loaded from: classes.dex */
public final class d0 {

    /* compiled from: SingleInternalHelper.java */
    /* loaded from: classes.dex */
    public enum a implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() {
            return new NoSuchElementException();
        }
    }

    /* compiled from: SingleInternalHelper.java */
    /* loaded from: classes.dex */
    public enum b implements d.c.e0.n<d.c.z, g.b.b> {
        INSTANCE;

        @Override // d.c.e0.n
        public g.b.b a(d.c.z zVar) {
            return new p0(zVar);
        }
    }

    /* compiled from: SingleInternalHelper.java */
    /* loaded from: classes.dex */
    public enum c implements d.c.e0.n<d.c.z, d.c.o> {
        INSTANCE;

        @Override // d.c.e0.n
        public d.c.o a(d.c.z zVar) {
            return new q0(zVar);
        }
    }

    public static <T> Callable<NoSuchElementException> a() {
        return a.INSTANCE;
    }

    public static <T> d.c.e0.n<d.c.z<? extends T>, g.b.b<? extends T>> b() {
        return b.INSTANCE;
    }

    public static <T> d.c.e0.n<d.c.z<? extends T>, d.c.o<? extends T>> c() {
        return c.INSTANCE;
    }
}
