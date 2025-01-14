package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p160f0.p161a.EmptyDisposable;

/* renamed from: d.c.f0.e.a.m */
/* loaded from: classes.dex */
public final class CompletableError extends Completable {

    /* renamed from: a */
    public final Throwable f7040a;

    public CompletableError(Throwable th) {
        this.f7040a = th;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.m3639a(this.f7040a, completableObserver);
    }
}
