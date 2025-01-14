package d.c.f0.e.e;

import java.util.concurrent.Callable;
/* compiled from: SingleDefer.java */
/* loaded from: classes.dex */
public final class e<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<? extends d.c.z<? extends T>> f5088a;

    public e(Callable<? extends d.c.z<? extends T>> callable) {
        this.f5088a = callable;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        try {
            d.c.z<? extends T> call = this.f5088a.call();
            d.c.f0.b.b.a(call, "The singleSupplier returned a null SingleSource");
            call.subscribe(wVar);
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            d.c.f0.a.c.a(th, wVar);
        }
    }
}
