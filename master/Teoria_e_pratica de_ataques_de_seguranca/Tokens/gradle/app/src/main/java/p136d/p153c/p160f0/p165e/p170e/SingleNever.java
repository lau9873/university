package p136d.p153c.p160f0.p165e.p170e;

import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p160f0.p161a.EmptyDisposable;

/* renamed from: d.c.f0.e.e.h0 */
/* loaded from: classes.dex */
public final class SingleNever extends Single<Object> {

    /* renamed from: a */
    public static final Single<Object> f7451a = new SingleNever();

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super Object> singleObserver) {
        singleObserver.mo3284a(EmptyDisposable.NEVER);
    }
}
