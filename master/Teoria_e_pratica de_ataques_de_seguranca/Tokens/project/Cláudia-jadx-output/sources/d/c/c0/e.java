package d.c.c0;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ReferenceDisposable.java */
/* loaded from: classes.dex */
public abstract class e<T> extends AtomicReference<T> implements b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(T t) {
        super(t);
        d.c.f0.b.b.a((Object) t, "value is null");
    }

    public abstract void a(T t);

    @Override // d.c.c0.b
    public final void b() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        a(andSet);
    }

    @Override // d.c.c0.b
    public final boolean c() {
        return get() == null;
    }
}
