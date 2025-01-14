package d.c.c0;
/* compiled from: RunnableDisposable.java */
/* loaded from: classes.dex */
public final class f extends e<Runnable> {
    public f(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + c() + ", " + get() + ")";
    }

    @Override // d.c.c0.e
    public void a(Runnable runnable) {
        runnable.run();
    }
}
