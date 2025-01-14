package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.p160f0.p161a.EmptyDisposable;

/* renamed from: d.c.f0.e.a.l */
/* loaded from: classes.dex */
public final class CompletableEmpty extends Completable {

    /* renamed from: a */
    public static final Completable f7037a = new CompletableEmpty();

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.m3641a(completableObserver);
    }
}
