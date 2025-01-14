package p136d.p153c.p178i0;

import p136d.p153c.p160f0.p175j.AppendOnlyLinkedArrayList;
import p136d.p153c.p160f0.p175j.NotificationLite;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.i0.b */
/* loaded from: classes.dex */
public final class SerializedProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: b */
    public final FlowableProcessor<T> f7761b;

    /* renamed from: c */
    public boolean f7762c;

    /* renamed from: d */
    public AppendOnlyLinkedArrayList<Object> f7763d;

    /* renamed from: e */
    public volatile boolean f7764e;

    public SerializedProcessor(FlowableProcessor<T> flowableProcessor) {
        this.f7761b = flowableProcessor;
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2188a(Subscription subscription) {
        boolean z = true;
        if (!this.f7764e) {
            synchronized (this) {
                if (!this.f7764e) {
                    if (this.f7762c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7763d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f7763d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) NotificationLite.m3407a(subscription));
                        return;
                    }
                    this.f7762c = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
            return;
        }
        this.f7761b.mo2188a(subscription);
        m3363j();
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7761b.mo2190a((Subscriber) subscriber);
    }

    /* renamed from: j */
    public void m3363j() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f7763d;
                if (appendOnlyLinkedArrayList == null) {
                    this.f7762c = false;
                    return;
                }
                this.f7763d = null;
            }
            appendOnlyLinkedArrayList.m3422a((Subscriber) this.f7761b);
        }
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2187a(T t) {
        if (this.f7764e) {
            return;
        }
        synchronized (this) {
            if (this.f7764e) {
                return;
            }
            if (this.f7762c) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7763d;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f7763d = appendOnlyLinkedArrayList;
                }
                NotificationLite.m3406a(t);
                appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) t);
                return;
            }
            this.f7762c = true;
            this.f7761b.mo2187a((FlowableProcessor<T>) t);
            m3363j();
        }
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2186a(Throwable th) {
        boolean z;
        if (this.f7764e) {
            RxJavaPlugins.m3371b(th);
            return;
        }
        synchronized (this) {
            if (this.f7764e) {
                z = true;
            } else {
                this.f7764e = true;
                if (this.f7762c) {
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7763d;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.f7763d = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.m3420b(NotificationLite.m3403a(th));
                    return;
                }
                z = false;
                this.f7762c = true;
            }
            if (z) {
                RxJavaPlugins.m3371b(th);
            } else {
                this.f7761b.mo2186a(th);
            }
        }
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2189a() {
        if (this.f7764e) {
            return;
        }
        synchronized (this) {
            if (this.f7764e) {
                return;
            }
            this.f7764e = true;
            if (this.f7762c) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7763d;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f7763d = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) NotificationLite.m3402b());
                return;
            }
            this.f7762c = true;
            this.f7761b.mo2189a();
        }
    }
}
