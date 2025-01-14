package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.HasUpstreamPublisher;

/* renamed from: d.c.f0.e.b.a */
/* loaded from: classes.dex */
public abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {

    /* renamed from: b */
    public final Flowable<T> f7090b;

    public AbstractFlowableWithUpstream(Flowable<T> flowable) {
        ObjectHelper.m3598a(flowable, "source is null");
        this.f7090b = flowable;
    }
}
