package d.c.f0.d;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BasicIntQueueDisposable.java */
/* loaded from: classes.dex */
public abstract class a<T> extends AtomicInteger implements d.c.f0.c.i<T> {
    @Override // d.c.f0.c.n
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
