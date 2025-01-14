package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.Callable;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.f0.e.a.g */
/* loaded from: classes.dex */
public final class CompletableDefer extends Completable {

    /* renamed from: a */
    public final Callable<? extends CompletableSource> f6981a;

    public CompletableDefer(Callable<? extends CompletableSource> callable) {
        this.f6981a = callable;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            CompletableSource call = this.f6981a.call();
            ObjectHelper.m3598a(call, "The completableSupplier returned a null CompletableSource");
            call.subscribe(completableObserver);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptyDisposable.m3639a(th, completableObserver);
        }
    }
}
