package d.c.f0.e.a;

import java.util.concurrent.Callable;
/* compiled from: CompletableDefer.java */
/* loaded from: classes.dex */
public final class g extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<? extends d.c.g> f4686a;

    public g(Callable<? extends d.c.g> callable) {
        this.f4686a = callable;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        try {
            d.c.g call = this.f4686a.call();
            d.c.f0.b.b.a(call, "The completableSupplier returned a null CompletableSource");
            call.subscribe(dVar);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.a.c.a(th, dVar);
        }
    }
}
