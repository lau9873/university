package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;

/* renamed from: d.c.f0.e.a.u */
/* loaded from: classes.dex */
public final class CompletableFromUnsafeSource extends Completable {

    /* renamed from: a */
    public final CompletableSource f7065a;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.f7065a = completableSource;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7065a.subscribe(completableObserver);
    }
}
