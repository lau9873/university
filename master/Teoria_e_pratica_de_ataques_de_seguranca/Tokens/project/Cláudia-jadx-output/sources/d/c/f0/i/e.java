package d.c.f0.i;

import d.c.f0.c.k;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ScalarSubscription.java */
/* loaded from: classes.dex */
public final class e<T> extends AtomicInteger implements k<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f5356a;

    /* renamed from: b  reason: collision with root package name */
    public final g.b.c<? super T> f5357b;

    public e(g.b.c<? super T> cVar, T t) {
        this.f5357b = cVar;
        this.f5356a = t;
    }

    @Override // d.c.f0.c.j
    public int a(int i2) {
        return i2 & 1;
    }

    @Override // g.b.d
    public void a(long j) {
        if (g.c(j) && compareAndSet(0, 1)) {
            g.b.c<? super T> cVar = this.f5357b;
            cVar.a((g.b.c<? super T>) ((T) this.f5356a));
            if (get() != 2) {
                cVar.a();
            }
        }
    }

    @Override // g.b.d
    public void cancel() {
        lazySet(2);
    }

    @Override // d.c.f0.c.n
    public void clear() {
        lazySet(1);
    }

    @Override // d.c.f0.c.n
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // d.c.f0.c.n
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // d.c.f0.c.n
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.f5356a;
        }
        return null;
    }
}
