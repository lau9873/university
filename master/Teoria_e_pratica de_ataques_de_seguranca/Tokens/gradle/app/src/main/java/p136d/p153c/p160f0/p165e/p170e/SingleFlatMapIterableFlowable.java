package p136d.p153c.p160f0.p165e.p170e;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import p136d.p153c.Flowable;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p174i.BasicIntQueueSubscription;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.e.w */
/* loaded from: classes.dex */
public final class SingleFlatMapIterableFlowable<T, R> extends Flowable<R> {

    /* renamed from: b */
    public final SingleSource<T> f7583b;

    /* renamed from: c */
    public final Function<? super T, ? extends Iterable<? extends R>> f7584c;

    public SingleFlatMapIterableFlowable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.f7583b = singleSource;
        this.f7584c = function;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super R> subscriber) {
        this.f7583b.subscribe(new C1700a(subscriber, this.f7584c));
    }

    /* compiled from: SingleFlatMapIterableFlowable.java */
    /* renamed from: d.c.f0.e.e.w$a */
    /* loaded from: classes.dex */
    public static final class C1700a<T, R> extends BasicIntQueueSubscription<R> implements SingleObserver<T> {

        /* renamed from: a */
        public final Subscriber<? super R> f7585a;

        /* renamed from: b */
        public final Function<? super T, ? extends Iterable<? extends R>> f7586b;

        /* renamed from: c */
        public final AtomicLong f7587c = new AtomicLong();

        /* renamed from: d */
        public Disposable f7588d;

        /* renamed from: e */
        public volatile Iterator<? extends R> f7589e;

        /* renamed from: f */
        public volatile boolean f7590f;

        /* renamed from: g */
        public boolean f7591g;

        public C1700a(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f7585a = subscriber;
            this.f7586b = function;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7588d, disposable)) {
                this.f7588d = disposable;
                this.f7585a.mo2188a((Subscription) this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            try {
                Iterator<? extends R> it = this.f7586b.mo3490a(t).iterator();
                if (!it.hasNext()) {
                    this.f7585a.mo2189a();
                    return;
                }
                this.f7589e = it;
                m3487b();
            } catch (Throwable th) {
                Exceptions.m3660b(th);
                this.f7585a.mo2186a(th);
            }
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            this.f7590f = true;
            this.f7588d.mo578b();
            this.f7588d = DisposableHelper.DISPOSED;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public void clear() {
            this.f7589e = null;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public boolean isEmpty() {
            return this.f7589e == null;
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public R poll() {
            Iterator<? extends R> it = this.f7589e;
            if (it != null) {
                R next = it.next();
                ObjectHelper.m3598a(next, "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.f7589e = null;
                }
                return next;
            }
            return null;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7588d = DisposableHelper.DISPOSED;
            this.f7585a.mo2186a(th);
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            if (SubscriptionHelper.m3424c(j)) {
                BackpressureHelper.m3416a(this.f7587c, j);
                m3487b();
            }
        }

        /* renamed from: b */
        public void m3487b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.f7585a;
            Iterator<? extends R> it = this.f7589e;
            if (this.f7591g && it != null) {
                subscriber.mo2187a((Subscriber<? super R>) null);
                subscriber.mo2189a();
                return;
            }
            int i = 1;
            while (true) {
                if (it != null) {
                    long j = this.f7587c.get();
                    if (j == Long.MAX_VALUE) {
                        m3488a(subscriber, it);
                        return;
                    }
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.f7590f) {
                            return;
                        }
                        try {
                            Object obj = (R) it.next();
                            ObjectHelper.m3598a(obj, "The iterator returned a null value");
                            subscriber.mo2187a((Subscriber<? super R>) obj);
                            if (this.f7590f) {
                                return;
                            }
                            j2++;
                            try {
                                if (!it.hasNext()) {
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
                    if (j2 != 0) {
                        BackpressureHelper.m3415b(this.f7587c, j2);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (it == null) {
                    it = this.f7589e;
                }
            }
        }

        /* renamed from: a */
        public void m3488a(Subscriber<? super R> subscriber, Iterator<? extends R> it) {
            while (!this.f7590f) {
                try {
                    subscriber.mo2187a((Subscriber<? super R>) ((R) it.next()));
                    if (this.f7590f) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
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

        @Override // p136d.p153c.p160f0.p163c.QueueFuseable
        /* renamed from: a */
        public int mo3356a(int i) {
            if ((i & 2) != 0) {
                this.f7591g = true;
                return 2;
            }
            return 0;
        }
    }
}
