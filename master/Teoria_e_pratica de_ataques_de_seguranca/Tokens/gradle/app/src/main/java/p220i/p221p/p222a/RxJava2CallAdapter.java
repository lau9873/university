package p220i.p221p.p222a;

import java.lang.reflect.Type;
import p136d.p153c.BackpressureStrategy;
import p136d.p153c.Observable;
import p136d.p153c.Scheduler;
import p220i.CallAdapter;
import p220i.InterfaceC2600b;

/* renamed from: i.p.a.f */
/* loaded from: classes.dex */
public final class RxJava2CallAdapter<R> implements CallAdapter<R, Object> {

    /* renamed from: a */
    public final Type f10519a;

    /* renamed from: b */
    public final Scheduler f10520b;

    /* renamed from: c */
    public final boolean f10521c;

    /* renamed from: d */
    public final boolean f10522d;

    /* renamed from: e */
    public final boolean f10523e;

    /* renamed from: f */
    public final boolean f10524f;

    /* renamed from: g */
    public final boolean f10525g;

    /* renamed from: h */
    public final boolean f10526h;

    /* renamed from: i */
    public final boolean f10527i;

    public RxJava2CallAdapter(Type type, Scheduler scheduler, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f10519a = type;
        this.f10520b = scheduler;
        this.f10521c = z;
        this.f10522d = z2;
        this.f10523e = z3;
        this.f10524f = z4;
        this.f10525g = z5;
        this.f10526h = z6;
        this.f10527i = z7;
    }

    @Override // p220i.CallAdapter
    /* renamed from: a */
    public Type mo568a() {
        return this.f10519a;
    }

    @Override // p220i.CallAdapter
    /* renamed from: a */
    public Object mo567a(InterfaceC2600b<R> interfaceC2600b) {
        Observable callExecuteObservable;
        Observable bodyObservable;
        if (this.f10521c) {
            callExecuteObservable = new CallEnqueueObservable(interfaceC2600b);
        } else {
            callExecuteObservable = new CallExecuteObservable(interfaceC2600b);
        }
        if (this.f10522d) {
            bodyObservable = new ResultObservable(callExecuteObservable);
        } else {
            bodyObservable = this.f10523e ? new BodyObservable(callExecuteObservable) : callExecuteObservable;
        }
        Scheduler scheduler = this.f10520b;
        if (scheduler != null) {
            bodyObservable = bodyObservable.m3305a(scheduler);
        }
        if (this.f10524f) {
            return bodyObservable.m3317a(BackpressureStrategy.LATEST);
        }
        if (this.f10525g) {
            return bodyObservable.m3298c();
        }
        if (this.f10526h) {
            return bodyObservable.m3301b();
        }
        return this.f10527i ? bodyObservable.m3321a() : bodyObservable;
    }
}
