package p136d.p153c.p157c0;

/* renamed from: d.c.c0.f */
/* loaded from: classes.dex */
public final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + mo577c() + ", " + get() + ")";
    }

    @Override // p136d.p153c.p157c0.ReferenceDisposable
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo3663a(Runnable runnable) {
        runnable.run();
    }
}
