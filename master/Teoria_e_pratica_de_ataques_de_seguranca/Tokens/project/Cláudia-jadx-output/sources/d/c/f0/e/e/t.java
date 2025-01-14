package d.c.f0.e.e;

import java.util.concurrent.Callable;
/* compiled from: SingleError.java */
/* loaded from: classes.dex */
public final class t<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<? extends Throwable> f5234a;

    public t(Callable<? extends Throwable> callable) {
        this.f5234a = callable;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        try {
            Throwable call = this.f5234a.call();
            d.c.f0.b.b.a(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = call;
        } catch (Throwable th) {
            th = th;
            d.c.d0.a.b(th);
        }
        d.c.f0.a.c.a(th, wVar);
    }
}
