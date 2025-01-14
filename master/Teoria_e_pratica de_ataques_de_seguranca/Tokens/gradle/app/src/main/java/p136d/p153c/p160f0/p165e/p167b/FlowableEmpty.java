package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.p160f0.p163c.ScalarCallable;
import p136d.p153c.p160f0.p174i.EmptySubscription;
import p193g.p204b.Subscriber;

/* renamed from: d.c.f0.e.b.f */
/* loaded from: classes.dex */
public final class FlowableEmpty extends Flowable<Object> implements ScalarCallable<Object> {

    /* renamed from: b */
    public static final Flowable<Object> f7154b = new FlowableEmpty();

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super Object> subscriber) {
        EmptySubscription.m3440a(subscriber);
    }

    @Override // p136d.p153c.p160f0.p163c.ScalarCallable, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
