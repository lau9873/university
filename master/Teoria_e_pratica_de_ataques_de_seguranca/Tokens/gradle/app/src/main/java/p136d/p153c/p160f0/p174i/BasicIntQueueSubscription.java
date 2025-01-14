package p136d.p153c.p160f0.p174i;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.p160f0.p163c.QueueSubscription;

/* renamed from: d.c.f0.i.a */
/* loaded from: classes.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
