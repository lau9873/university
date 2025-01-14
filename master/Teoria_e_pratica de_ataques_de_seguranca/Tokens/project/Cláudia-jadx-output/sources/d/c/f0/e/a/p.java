package d.c.f0.e.a;

import java.util.concurrent.Callable;
/* compiled from: CompletableFromCallable.java */
/* loaded from: classes.dex */
public final class p extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<?> f4761a;

    public p(Callable<?> callable) {
        this.f4761a = callable;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        d.c.c0.b b2 = d.c.c0.c.b();
        dVar.a(b2);
        try {
            this.f4761a.call();
            if (b2.c()) {
                return;
            }
            dVar.a();
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            if (b2.c()) {
                return;
            }
            dVar.a(th);
        }
    }
}
