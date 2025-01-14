package d.c.f0.i;

import d.c.f0.c.k;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: BasicQueueSubscription.java */
/* loaded from: classes.dex */
public abstract class b<T> extends AtomicLong implements k<T> {
    @Override // d.c.f0.c.n
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
