package d.c.c0;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: FutureDisposable.java */
/* loaded from: classes.dex */
public final class d extends AtomicReference<Future<?>> implements b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4579a;

    public d(Future<?> future, boolean z) {
        super(future);
        this.f4579a = z;
    }

    @Override // d.c.c0.b
    public void b() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.f4579a);
        }
    }

    @Override // d.c.c0.b
    public boolean c() {
        Future<?> future = get();
        return future == null || future.isDone();
    }
}
