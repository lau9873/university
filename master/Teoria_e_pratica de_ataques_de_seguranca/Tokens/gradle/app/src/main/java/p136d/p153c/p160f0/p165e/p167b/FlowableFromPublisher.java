package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.e.b.m */
/* loaded from: classes.dex */
public final class FlowableFromPublisher<T> extends Flowable<T> {

    /* renamed from: b */
    public final Publisher<? extends T> f7209b;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.f7209b = publisher;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7209b.mo2190a(subscriber);
    }
}
