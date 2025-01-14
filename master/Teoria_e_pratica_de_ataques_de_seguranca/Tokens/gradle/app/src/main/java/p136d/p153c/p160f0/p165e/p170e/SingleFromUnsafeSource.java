package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;

/* renamed from: d.c.f0.e.e.b0 */
/* loaded from: classes.dex */
public final class SingleFromUnsafeSource<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7406a;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.f7406a = singleSource;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7406a.subscribe(singleObserver);
    }
}
