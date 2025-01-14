package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposables;

/* renamed from: d.c.f0.e.e.e0 */
/* loaded from: classes.dex */
public final class SingleJust<T> extends Single<T> {

    /* renamed from: a */
    public final T f7424a;

    public SingleJust(T t) {
        this.f7424a = t;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.mo3284a(Disposables.m3668a());
        singleObserver.mo3282b((T) this.f7424a);
    }
}
