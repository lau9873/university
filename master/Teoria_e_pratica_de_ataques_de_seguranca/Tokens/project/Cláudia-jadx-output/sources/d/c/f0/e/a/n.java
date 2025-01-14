package d.c.f0.e.a;

import java.util.concurrent.Callable;
/* compiled from: CompletableErrorSupplier.java */
/* loaded from: classes.dex */
public final class n extends d.c.b {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<? extends Throwable> f4751a;

    public n(Callable<? extends Throwable> callable) {
        this.f4751a = callable;
    }

    @Override // d.c.b
    public void subscribeActual(d.c.d dVar) {
        try {
            Throwable call = this.f4751a.call();
            d.c.f0.b.b.a(call, "The error returned is null");
            th = call;
        } catch (Throwable th) {
            th = th;
            d.c.d0.a.b(th);
        }
        d.c.f0.a.c.a(th, dVar);
    }
}
