package p136d.p153c.p160f0.p165e.p167b;

import java.util.Iterator;
import p136d.p153c.Flowable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.ConditionalSubscriber;
import p136d.p153c.p160f0.p174i.BasicQueueSubscription;
import p136d.p153c.p160f0.p174i.EmptySubscription;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.k */
/* loaded from: classes.dex */
public final class FlowableFromIterable<T> extends Flowable<T> {

    /* renamed from: b */
    public final Iterable<? extends T> f7200b;

    /* compiled from: FlowableFromIterable.java */
    /* renamed from: d.c.f0.e.b.k$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1617a<T> extends BasicQueueSubscription<T> {

        /* renamed from: a */
        public Iterator<? extends T> f7201a;

        /* renamed from: b */
        public volatile boolean f7202b;

        /* renamed from: c */
        public boolean f7203c;

        public AbstractC1617a(Iterator<? extends T> it) {
            this.f7201a = it;
        }

        @Override // p136d.p153c.p160f0.p163c.QueueFuseable
        /* renamed from: a */
        public final int mo3356a(int i) {
            return i & 1;
        }

        /* renamed from: a */
        public abstract void mo3545a();

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public final void mo2185a(long j) {
            if (SubscriptionHelper.m3424c(j) && BackpressureHelper.m3416a(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    mo3545a();
                } else {
                    mo3544b(j);
                }
            }
        }

        /* renamed from: b */
        public abstract void mo3544b(long j);

        @Override // p193g.p204b.Subscription
        public final void cancel() {
            this.f7202b = true;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public final void clear() {
            this.f7201a = null;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public final boolean isEmpty() {
            Iterator<? extends T> it = this.f7201a;
            return it == null || !it.hasNext();
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public final T poll() {
            Iterator<? extends T> it = this.f7201a;
            if (it == null) {
                return null;
            }
            if (!this.f7203c) {
                this.f7203c = true;
            } else if (!it.hasNext()) {
                return null;
            }
            T next = this.f7201a.next();
            ObjectHelper.m3598a((Object) next, "Iterator.next() returned a null value");
            return next;
        }
    }

    /* compiled from: FlowableFromIterable.java */
    /* renamed from: d.c.f0.e.b.k$b */
    /* loaded from: classes.dex */
    public static final class C1618b<T> extends AbstractC1617a<T> {

        /* renamed from: d */
        public final ConditionalSubscriber<? super T> f7204d;

        public C1618b(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it) {
            super(it);
            this.f7204d = conditionalSubscriber;
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableFromIterable.AbstractC1617a
        /* renamed from: a */
        public void mo3545a() {
            Iterator<? extends T> it = this.f7201a;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f7204d;
            while (!this.f7202b) {
                try {
                    Object obj = (T) it.next();
                    if (this.f7202b) {
                        return;
                    }
                    if (obj == null) {
                        conditionalSubscriber.mo2186a((Throwable) new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    conditionalSubscriber.m3596c(obj);
                    if (this.f7202b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f7202b) {
                                return;
                            }
                            conditionalSubscriber.mo2189a();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m3660b(th);
                        conditionalSubscriber.mo2186a(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    conditionalSubscriber.mo2186a(th2);
                    return;
                }
            }
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableFromIterable.AbstractC1617a
        /* renamed from: b */
        public void mo3544b(long j) {
            Iterator<? extends T> it = this.f7201a;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f7204d;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (this.f7202b) {
                            return;
                        }
                        try {
                            Object obj = (T) it.next();
                            if (this.f7202b) {
                                return;
                            }
                            if (obj == null) {
                                conditionalSubscriber.mo2186a((Throwable) new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            boolean m3596c = conditionalSubscriber.m3596c(obj);
                            if (this.f7202b) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.f7202b) {
                                        return;
                                    }
                                    conditionalSubscriber.mo2189a();
                                    return;
                                } else if (m3596c) {
                                    j3++;
                                }
                            } catch (Throwable th) {
                                Exceptions.m3660b(th);
                                conditionalSubscriber.mo2186a(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.m3660b(th2);
                            conditionalSubscriber.mo2186a(th2);
                            return;
                        }
                    } else {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = addAndGet(-j3);
                        }
                    }
                }
            } while (j2 != 0);
        }
    }

    /* compiled from: FlowableFromIterable.java */
    /* renamed from: d.c.f0.e.b.k$c */
    /* loaded from: classes.dex */
    public static final class C1619c<T> extends AbstractC1617a<T> {

        /* renamed from: d */
        public final Subscriber<? super T> f7205d;

        public C1619c(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            super(it);
            this.f7205d = subscriber;
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableFromIterable.AbstractC1617a
        /* renamed from: a */
        public void mo3545a() {
            Iterator<? extends T> it = this.f7201a;
            Subscriber<? super T> subscriber = this.f7205d;
            while (!this.f7202b) {
                try {
                    Object obj = (T) it.next();
                    if (this.f7202b) {
                        return;
                    }
                    if (obj == null) {
                        subscriber.mo2186a((Throwable) new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    subscriber.mo2187a((Subscriber<? super T>) obj);
                    if (this.f7202b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f7202b) {
                                return;
                            }
                            subscriber.mo2189a();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m3660b(th);
                        subscriber.mo2186a(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.m3660b(th2);
                    subscriber.mo2186a(th2);
                    return;
                }
            }
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableFromIterable.AbstractC1617a
        /* renamed from: b */
        public void mo3544b(long j) {
            Iterator<? extends T> it = this.f7201a;
            Subscriber<? super T> subscriber = this.f7205d;
            long j2 = j;
            do {
                long j3 = 0;
                while (true) {
                    if (j3 != j2) {
                        if (this.f7202b) {
                            return;
                        }
                        try {
                            Object obj = (T) it.next();
                            if (this.f7202b) {
                                return;
                            }
                            if (obj == null) {
                                subscriber.mo2186a((Throwable) new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            subscriber.mo2187a((Subscriber<? super T>) obj);
                            if (this.f7202b) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (this.f7202b) {
                                        return;
                                    }
                                    subscriber.mo2189a();
                                    return;
                                }
                                j3++;
                            } catch (Throwable th) {
                                Exceptions.m3660b(th);
                                subscriber.mo2186a(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.m3660b(th2);
                            subscriber.mo2186a(th2);
                            return;
                        }
                    } else {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = addAndGet(-j3);
                        }
                    }
                }
            } while (j2 != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f7200b = iterable;
    }

    /* renamed from: a */
    public static <T> void m3546a(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.m3440a(subscriber);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.mo2188a((Subscription) new C1618b((ConditionalSubscriber) subscriber, it));
            } else {
                subscriber.mo2188a((Subscription) new C1619c(subscriber, it));
            }
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptySubscription.m3439a(th, subscriber);
        }
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        try {
            m3546a(subscriber, this.f7200b.iterator());
        } catch (Throwable th) {
            Exceptions.m3660b(th);
            EmptySubscription.m3439a(th, subscriber);
        }
    }
}
