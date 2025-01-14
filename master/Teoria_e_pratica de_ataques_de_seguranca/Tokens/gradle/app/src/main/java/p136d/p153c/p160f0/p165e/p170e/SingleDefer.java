package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.Callable;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.f0.e.e.e */
/* loaded from: classes.dex */
public final class SingleDefer<T> extends Single<T> {

    /* renamed from: a */
    public final Callable<? extends SingleSource<? extends T>> f7423a;

    public SingleDefer(Callable<? extends SingleSource<? extends T>> callable) {
        this.f7423a = callable;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            SingleSource<? extends T> call = this.f7423a.call();
            ObjectHelper.m3598a(call, "The singleSupplier returned a null SingleSource");
            call.subscribe(singleObserver);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptyDisposable.m3637a(th, singleObserver);
        }
    }
}
