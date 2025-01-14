package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p175j.ErrorMode;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.e.b.d */
/* loaded from: classes.dex */
public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final Publisher<T> f7142b;

    /* renamed from: c */
    public final Function<? super T, ? extends Publisher<? extends R>> f7143c;

    /* renamed from: d */
    public final int f7144d;

    /* renamed from: e */
    public final ErrorMode f7145e;

    public FlowableConcatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.f7142b = publisher;
        this.f7143c = function;
        this.f7144d = i;
        this.f7145e = errorMode;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.m3534a(this.f7142b, subscriber, this.f7143c)) {
            return;
        }
        this.f7142b.mo2190a(FlowableConcatMap.m3568a(subscriber, this.f7143c, this.f7144d, this.f7145e));
    }
}
