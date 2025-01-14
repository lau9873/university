package d.c.f0.e.e;

import java.util.concurrent.Callable;
/* compiled from: SingleFromCallable.java */
/* loaded from: classes.dex */
public final class z<T> extends d.c.u<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Callable<? extends T> f5265a;

    public z(Callable<? extends T> callable) {
        this.f5265a = callable;
    }

    @Override // d.c.u
    public void subscribeActual(d.c.w<? super T> wVar) {
        wVar.a(d.c.f0.a.c.INSTANCE);
        try {
            Object obj = (T) this.f5265a.call();
            if (obj != null) {
                wVar.b(obj);
            } else {
                wVar.a(new NullPointerException("The callable returned a null value"));
            }
        } catch (Throwable th) {
            d.c.d0.a.b(th);
            wVar.a(th);
        }
    }
}
