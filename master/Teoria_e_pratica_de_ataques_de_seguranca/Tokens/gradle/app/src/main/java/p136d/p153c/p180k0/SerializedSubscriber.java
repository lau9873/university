package p136d.p153c.p180k0;

import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.AppendOnlyLinkedArrayList;
import p136d.p153c.p160f0.p175j.NotificationLite;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.k0.a */
/* loaded from: classes.dex */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: a */
    public final Subscriber<? super T> f7783a;

    /* renamed from: b */
    public final boolean f7784b;

    /* renamed from: c */
    public Subscription f7785c;

    /* renamed from: d */
    public boolean f7786d;

    /* renamed from: e */
    public AppendOnlyLinkedArrayList<Object> f7787e;

    /* renamed from: f */
    public volatile boolean f7788f;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2188a(Subscription subscription) {
        if (SubscriptionHelper.m3431a(this.f7785c, subscription)) {
            this.f7785c = subscription;
            this.f7783a.mo2188a((Subscription) this);
        }
    }

    /* renamed from: b */
    public void m3322b() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f7787e;
                if (appendOnlyLinkedArrayList == null) {
                    this.f7786d = false;
                    return;
                }
                this.f7787e = null;
            }
        } while (!appendOnlyLinkedArrayList.m3422a((Subscriber<? super T>) this.f7783a));
    }

    @Override // p193g.p204b.Subscription
    public void cancel() {
        this.f7785c.cancel();
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z) {
        this.f7783a = subscriber;
        this.f7784b = z;
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2187a(T t) {
        if (this.f7788f) {
            return;
        }
        if (t == null) {
            this.f7785c.cancel();
            mo2186a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f7788f) {
                return;
            }
            if (this.f7786d) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7787e;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f7787e = appendOnlyLinkedArrayList;
                }
                NotificationLite.m3406a(t);
                appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) t);
                return;
            }
            this.f7786d = true;
            this.f7783a.mo2187a((Subscriber<? super T>) t);
            m3322b();
        }
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2186a(Throwable th) {
        if (this.f7788f) {
            RxJavaPlugins.m3371b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f7788f) {
                if (this.f7786d) {
                    this.f7788f = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7787e;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.f7787e = appendOnlyLinkedArrayList;
                    }
                    Object m3403a = NotificationLite.m3403a(th);
                    if (this.f7784b) {
                        appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) m3403a);
                    } else {
                        appendOnlyLinkedArrayList.m3420b(m3403a);
                    }
                    return;
                }
                this.f7788f = true;
                this.f7786d = true;
                z = false;
            }
            if (z) {
                RxJavaPlugins.m3371b(th);
            } else {
                this.f7783a.mo2186a(th);
            }
        }
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2189a() {
        if (this.f7788f) {
            return;
        }
        synchronized (this) {
            if (this.f7788f) {
                return;
            }
            if (this.f7786d) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f7787e;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.f7787e = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.m3421a((AppendOnlyLinkedArrayList<Object>) NotificationLite.m3402b());
                return;
            }
            this.f7788f = true;
            this.f7786d = true;
            this.f7783a.mo2189a();
        }
    }

    @Override // p193g.p204b.Subscription
    /* renamed from: a */
    public void mo2185a(long j) {
        this.f7785c.mo2185a(j);
    }
}
