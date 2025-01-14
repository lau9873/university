package p136d.p153c.p160f0.p164d;

import p136d.p153c.CompletableObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.d.k */
/* loaded from: classes.dex */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {

    /* renamed from: a */
    public final Subscriber<? super T> f6916a;

    /* renamed from: b */
    public Disposable f6917b;

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.f6916a = subscriber;
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3489a() {
        this.f6916a.mo2189a();
    }

    @Override // p193g.p204b.Subscription
    /* renamed from: a */
    public void mo2185a(long j) {
    }

    @Override // p193g.p204b.Subscription
    public void cancel() {
        this.f6917b.mo578b();
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3501a(Throwable th) {
        this.f6916a.mo2186a(th);
    }

    @Override // p136d.p153c.CompletableObserver
    /* renamed from: a */
    public void mo3502a(Disposable disposable) {
        if (DisposableHelper.m3648a(this.f6917b, disposable)) {
            this.f6917b = disposable;
            this.f6916a.mo2188a((Subscription) this);
        }
    }
}
