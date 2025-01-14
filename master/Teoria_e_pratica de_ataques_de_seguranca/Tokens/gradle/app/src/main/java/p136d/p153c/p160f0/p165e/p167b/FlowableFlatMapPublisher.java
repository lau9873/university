package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.p159e0.Function;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.e.b.h */
/* loaded from: classes.dex */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: b */
    public final Publisher<T> f7186b;

    /* renamed from: c */
    public final Function<? super T, ? extends Publisher<? extends U>> f7187c;

    /* renamed from: d */
    public final boolean f7188d;

    /* renamed from: e */
    public final int f7189e;

    /* renamed from: f */
    public final int f7190f;

    public FlowableFlatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        this.f7186b = publisher;
        this.f7187c = function;
        this.f7188d = z;
        this.f7189e = i;
        this.f7190f = i2;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.m3534a(this.f7186b, subscriber, this.f7187c)) {
            return;
        }
        this.f7186b.mo2190a(FlowableFlatMap.m3562a(subscriber, this.f7187c, this.f7188d, this.f7189e, this.f7190f));
    }
}
