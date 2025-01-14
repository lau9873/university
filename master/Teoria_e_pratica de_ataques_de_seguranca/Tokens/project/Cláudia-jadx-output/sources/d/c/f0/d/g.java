package d.c.f0.d;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: EmptyCompletableObserver.java */
/* loaded from: classes.dex */
public final class g extends AtomicReference<d.c.c0.b> implements d.c.d, d.c.c0.b {
    @Override // d.c.d
    public void a() {
        lazySet(d.c.f0.a.b.DISPOSED);
    }

    @Override // d.c.c0.b
    public void b() {
        d.c.f0.a.b.a((AtomicReference<d.c.c0.b>) this);
    }

    @Override // d.c.c0.b
    public boolean c() {
        return get() == d.c.f0.a.b.DISPOSED;
    }

    @Override // d.c.d
    public void a(Throwable th) {
        lazySet(d.c.f0.a.b.DISPOSED);
        d.c.h0.a.b(new OnErrorNotImplementedException(th));
    }

    @Override // d.c.d
    public void a(d.c.c0.b bVar) {
        d.c.f0.a.b.c(this, bVar);
    }
}
