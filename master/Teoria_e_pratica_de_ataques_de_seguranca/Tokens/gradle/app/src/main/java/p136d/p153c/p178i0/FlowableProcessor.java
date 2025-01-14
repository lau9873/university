package p136d.p153c.p178i0;

import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p193g.p204b.Processor;

/* renamed from: d.c.i0.a */
/* loaded from: classes.dex */
public abstract class FlowableProcessor<T> extends Flowable<T> implements Processor<T, T>, FlowableSubscriber<T> {
    /* renamed from: i */
    public final FlowableProcessor<T> m3364i() {
        return this instanceof SerializedProcessor ? this : new SerializedProcessor(this);
    }
}
