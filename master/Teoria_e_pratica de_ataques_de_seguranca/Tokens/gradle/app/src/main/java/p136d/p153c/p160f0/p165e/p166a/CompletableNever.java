package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p160f0.p161a.EmptyDisposable;

/* renamed from: d.c.f0.e.a.c0 */
/* loaded from: classes.dex */
public final class CompletableNever extends Completable {

    /* renamed from: a */
    public static final Completable f6950a = new CompletableNever();

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        completableObserver.mo3502a(EmptyDisposable.NEVER);
    }
}
