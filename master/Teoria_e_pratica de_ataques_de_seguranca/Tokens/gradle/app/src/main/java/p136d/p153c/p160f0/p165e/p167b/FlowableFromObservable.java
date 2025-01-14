package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.p157c0.Disposable;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.l */
/* loaded from: classes.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {

    /* renamed from: b */
    public final Observable<T> f7206b;

    /* compiled from: FlowableFromObservable.java */
    /* renamed from: d.c.f0.e.b.l$a */
    /* loaded from: classes.dex */
    public static class C1620a<T> implements InterfaceC1730s<T>, Subscription {

        /* renamed from: a */
        public final Subscriber<? super T> f7207a;

        /* renamed from: b */
        public Disposable f7208b;

        public C1620a(Subscriber<? super T> subscriber) {
            this.f7207a = subscriber;
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo573a() {
            this.f7207a.mo2189a();
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            this.f7208b.mo578b();
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo569a(Throwable th) {
            this.f7207a.mo2186a(th);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo570a(T t) {
            this.f7207a.mo2187a((Subscriber<? super T>) t);
        }

        @Override // p136d.p153c.InterfaceC1730s
        /* renamed from: a */
        public void mo572a(Disposable disposable) {
            this.f7208b = disposable;
            this.f7207a.mo2188a((Subscription) this);
        }
    }

    public FlowableFromObservable(Observable<T> observable) {
        this.f7206b = observable;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7206b.mo3294a((InterfaceC1730s) new C1620a(subscriber));
    }
}
