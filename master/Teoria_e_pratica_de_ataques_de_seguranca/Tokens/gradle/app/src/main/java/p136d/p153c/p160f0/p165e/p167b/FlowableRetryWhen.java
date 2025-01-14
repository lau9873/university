package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p165e.p167b.FlowableRepeatWhen;
import p136d.p153c.p160f0.p174i.EmptySubscription;
import p136d.p153c.p178i0.FlowableProcessor;
import p136d.p153c.p178i0.UnicastProcessor;
import p136d.p153c.p180k0.SerializedSubscriber;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.x */
/* loaded from: classes.dex */
public final class FlowableRetryWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final Function<? super Flowable<Throwable>, ? extends Publisher<?>> f7272c;

    /* compiled from: FlowableRetryWhen.java */
    /* renamed from: d.c.f0.e.b.x$a */
    /* loaded from: classes.dex */
    public static final class C1632a<T> extends FlowableRepeatWhen.AbstractC1629c<T, Throwable> {
        public C1632a(Subscriber<? super T> subscriber, FlowableProcessor<Throwable> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            m3537b((C1632a<T>) th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7257j.cancel();
            this.f7255h.mo2189a();
        }
    }

    public FlowableRetryWhen(Flowable<T> flowable, Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        super(flowable);
        this.f7272c = function;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor<T> m3364i = UnicastProcessor.m3362a(8).m3364i();
        try {
            Publisher<?> mo3490a = this.f7272c.mo3490a(m3364i);
            ObjectHelper.m3598a(mo3490a, "handler returned a null Publisher");
            Publisher<?> publisher = mo3490a;
            FlowableRepeatWhen.C1628b c1628b = new FlowableRepeatWhen.C1628b(this.f7090b);
            C1632a c1632a = new C1632a(serializedSubscriber, m3364i, c1628b);
            c1628b.f7254d = c1632a;
            subscriber.mo2188a((Subscription) c1632a);
            publisher.mo2190a(c1628b);
            c1628b.mo2187a((Object) 0);
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptySubscription.m3439a(th, subscriber);
        }
    }
}
