package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.Callable;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;

/* renamed from: d.c.f0.e.e.z */
/* loaded from: classes.dex */
public final class SingleFromCallable<T> extends Single<T> {

    /* renamed from: a */
    public final Callable<? extends T> f7600a;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.f7600a = callable;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.mo3284a(EmptyDisposable.INSTANCE);
        try {
            Object obj = (T) this.f7600a.call();
            if (obj != null) {
                singleObserver.mo3282b(obj);
            } else {
                singleObserver.mo3283a(new NullPointerException("The callable returned a null value"));
            }
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            singleObserver.mo3283a(th);
        }
    }
}
