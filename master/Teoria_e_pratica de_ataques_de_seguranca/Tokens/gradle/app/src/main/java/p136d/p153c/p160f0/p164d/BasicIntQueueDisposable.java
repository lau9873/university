package p136d.p153c.p160f0.p164d;

import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.p160f0.p163c.QueueDisposable;

/* renamed from: d.c.f0.d.a */
/* loaded from: classes.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements QueueDisposable<T> {
    @Override // p136d.p153c.p160f0.p163c.SimpleQueue
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}