package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.CompletableSource;
import p136d.p153c.Flowable;
import p136d.p153c.p160f0.p164d.SubscriberCompletableObserver;
import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.e.a.k0 */
/* loaded from: classes.dex */
public final class CompletableToFlowable<T> extends Flowable<T> {

    /* renamed from: b */
    public final CompletableSource f7036b;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.f7036b = completableSource;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7036b.subscribe(new SubscriberCompletableObserver(subscriber));
    }
}
