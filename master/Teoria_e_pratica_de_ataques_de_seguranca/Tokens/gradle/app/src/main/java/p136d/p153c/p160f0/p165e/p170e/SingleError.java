package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.Callable;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.f0.e.e.t */
/* loaded from: classes.dex */
public final class SingleError<T> extends Single<T> {

    /* renamed from: a */
    public final Callable<? extends Throwable> f7569a;

    public SingleError(Callable<? extends Throwable> callable) {
        this.f7569a = callable;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            Throwable call = this.f7569a.call();
            ObjectHelper.m3598a(call, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = call;
        } catch (Throwable th) {
            th = th;
            Exceptions.m3660b(th);
        }
        EmptyDisposable.m3637a(th, singleObserver);
    }
}
