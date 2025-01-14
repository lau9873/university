package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.Callable;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.EmptyDisposable;
import p136d.p153c.p160f0.p162b.ObjectHelper;

/* renamed from: d.c.f0.e.a.n */
/* loaded from: classes.dex */
public final class CompletableErrorSupplier extends Completable {

    /* renamed from: a */
    public final Callable<? extends Throwable> f7046a;

    public CompletableErrorSupplier(Callable<? extends Throwable> callable) {
        this.f7046a = callable;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            Throwable call = this.f7046a.call();
            ObjectHelper.m3598a(call, "The error returned is null");
            th = call;
        } catch (Throwable th) {
            th = th;
            Exceptions.m3660b(th);
        }
        EmptyDisposable.m3639a(th, completableObserver);
    }
}
