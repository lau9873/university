package p136d.p153c.p160f0.p165e.p167b;

import p136d.p153c.Flowable;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.ConditionalSubscriber;
import p136d.p153c.p160f0.p174i.BasicQueueSubscription;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.i */
/* loaded from: classes.dex */
public final class FlowableFromArray<T> extends Flowable<T> {

    /* renamed from: b */
    public final T[] f7191b;

    /* compiled from: FlowableFromArray.java */
    /* renamed from: d.c.f0.e.b.i$a */
    /* loaded from: classes.dex */
    public static final class C1614a<T> extends AbstractC1616c<T> {

        /* renamed from: d */
        public final ConditionalSubscriber<? super T> f7192d;

        public C1614a(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
            super(tArr);
            this.f7192d = conditionalSubscriber;
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableFromArray.AbstractC1616c
        /* renamed from: a */
        public void mo3548a() {
            T[] tArr = this.f7194a;
            int length = tArr.length;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f7192d;
            for (int i = this.f7195b; i != length; i++) {
                if (this.f7196c) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    conditionalSubscriber.mo2186a((Throwable) new NullPointerException("array element is null"));
                    return;
                }
                conditionalSubscriber.m3596c(t);
            }
            if (this.f7196c) {
                return;
            }
            conditionalSubscriber.mo2189a();
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableFromArray.AbstractC1616c
        /* renamed from: b */
        public void mo3547b(long j) {
            T[] tArr = this.f7194a;
            int length = tArr.length;
            int i = this.f7195b;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f7192d;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i == length) {
                        if (i == length) {
                            if (this.f7196c) {
                                return;
                            }
                            conditionalSubscriber.mo2189a();
                            return;
                        }
                        j2 = get();
                        if (j3 == j2) {
                            this.f7195b = i;
                            j2 = addAndGet(-j3);
                        }
                    } else if (this.f7196c) {
                        return;
                    } else {
                        T t = tArr[i];
                        if (t == null) {
                            conditionalSubscriber.mo2186a((Throwable) new NullPointerException("array element is null"));
                            return;
                        }
                        if (conditionalSubscriber.m3596c(t)) {
                            j3++;
                        }
                        i++;
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableFromArray.java */
    /* renamed from: d.c.f0.e.b.i$b */
    /* loaded from: classes.dex */
    public static final class C1615b<T> extends AbstractC1616c<T> {

        /* renamed from: d */
        public final Subscriber<? super T> f7193d;

        public C1615b(Subscriber<? super T> subscriber, T[] tArr) {
            super(tArr);
            this.f7193d = subscriber;
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableFromArray.AbstractC1616c
        /* renamed from: a */
        public void mo3548a() {
            T[] tArr = this.f7194a;
            int length = tArr.length;
            Subscriber<? super T> subscriber = this.f7193d;
            for (int i = this.f7195b; i != length; i++) {
                if (this.f7196c) {
                    return;
                }
                T t = tArr[i];
                if (t == null) {
                    subscriber.mo2186a((Throwable) new NullPointerException("array element is null"));
                    return;
                }
                subscriber.mo2187a((Subscriber<? super T>) t);
            }
            if (this.f7196c) {
                return;
            }
            subscriber.mo2189a();
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableFromArray.AbstractC1616c
        /* renamed from: b */
        public void mo3547b(long j) {
            T[] tArr = this.f7194a;
            int length = tArr.length;
            int i = this.f7195b;
            Subscriber<? super T> subscriber = this.f7193d;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2 || i == length) {
                        if (i == length) {
                            if (this.f7196c) {
                                return;
                            }
                            subscriber.mo2189a();
                            return;
                        }
                        j2 = get();
                        if (j3 == j2) {
                            this.f7195b = i;
                            j2 = addAndGet(-j3);
                        }
                    } else if (this.f7196c) {
                        return;
                    } else {
                        T t = tArr[i];
                        if (t == null) {
                            subscriber.mo2186a((Throwable) new NullPointerException("array element is null"));
                            return;
                        }
                        subscriber.mo2187a((Subscriber<? super T>) t);
                        j3++;
                        i++;
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableFromArray.java */
    /* renamed from: d.c.f0.e.b.i$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1616c<T> extends BasicQueueSubscription<T> {

        /* renamed from: a */
        public final T[] f7194a;

        /* renamed from: b */
        public int f7195b;

        /* renamed from: c */
        public volatile boolean f7196c;

        public AbstractC1616c(T[] tArr) {
            this.f7194a = tArr;
        }

        @Override // p136d.p153c.p160f0.p163c.QueueFuseable
        /* renamed from: a */
        public final int mo3356a(int i) {
            return i & 1;
        }

        /* renamed from: a */
        public abstract void mo3548a();

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public final void mo2185a(long j) {
            if (SubscriptionHelper.m3424c(j) && BackpressureHelper.m3416a(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo3548a();
                } else {
                    mo3547b(j);
                }
            }
        }

        /* renamed from: b */
        public abstract void mo3547b(long j);

        @Override // p193g.p204b.Subscription
        public final void cancel() {
            this.f7196c = true;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public final void clear() {
            this.f7195b = this.f7194a.length;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public final boolean isEmpty() {
            return this.f7195b == this.f7194a.length;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public final T poll() {
            int i = this.f7195b;
            T[] tArr = this.f7194a;
            if (i == tArr.length) {
                return null;
            }
            this.f7195b = i + 1;
            T t = tArr[i];
            ObjectHelper.m3598a((Object) t, "array element is null");
            return t;
        }
    }

    public FlowableFromArray(T[] tArr) {
        this.f7191b = tArr;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.mo2188a((Subscription) new C1614a((ConditionalSubscriber) subscriber, this.f7191b));
        } else {
            subscriber.mo2188a((Subscription) new C1615b(subscriber, this.f7191b));
        }
    }
}
