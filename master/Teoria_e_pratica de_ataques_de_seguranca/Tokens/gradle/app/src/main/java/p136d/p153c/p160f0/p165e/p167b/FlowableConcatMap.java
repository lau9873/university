package p136d.p153c.p160f0.p165e.p167b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.QueueSubscription;
import p136d.p153c.p160f0.p163c.SimpleQueue;
import p136d.p153c.p160f0.p171f.SpscArrayQueue;
import p136d.p153c.p160f0.p174i.SubscriptionArbiter;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.AtomicThrowable;
import p136d.p153c.p160f0.p175j.ErrorMode;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.c */
/* loaded from: classes.dex */
public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: c */
    public final Function<? super T, ? extends Publisher<? extends R>> f7117c;

    /* renamed from: d */
    public final int f7118d;

    /* renamed from: e */
    public final ErrorMode f7119e;

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: d.c.f0.e.b.c$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1602a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f7120a = new int[ErrorMode.values().length];

        static {
            try {
                f7120a[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7120a[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: d.c.f0.e.b.c$c */
    /* loaded from: classes.dex */
    public static final class C1604c<T, R> extends AbstractC1603b<T, R> {

        /* renamed from: n */
        public final Subscriber<? super R> f7133n;

        /* renamed from: o */
        public final boolean f7134o;

        public C1604c(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            super(function, i);
            this.f7133n = subscriber;
            this.f7134o = z;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7130j.m3418a(th)) {
                this.f7128h = true;
                mo3567c();
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.InterfaceC1607f
        /* renamed from: b */
        public void mo3564b(R r) {
            this.f7133n.mo2187a((Subscriber<? super R>) r);
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.AbstractC1603b
        /* renamed from: c */
        public void mo3567c() {
            if (getAndIncrement() == 0) {
                while (!this.f7129i) {
                    if (!this.f7131k) {
                        boolean z = this.f7128h;
                        if (z && !this.f7134o && this.f7130j.get() != null) {
                            this.f7133n.mo2186a(this.f7130j.m3419a());
                            return;
                        }
                        try {
                            T poll = this.f7127g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable m3419a = this.f7130j.m3419a();
                                if (m3419a != null) {
                                    this.f7133n.mo2186a(m3419a);
                                    return;
                                } else {
                                    this.f7133n.mo2189a();
                                    return;
                                }
                            } else if (!z2) {
                                try {
                                    Publisher<? extends R> mo3490a = this.f7122b.mo3490a(poll);
                                    ObjectHelper.m3598a(mo3490a, "The mapper returned a null Publisher");
                                    Publisher<? extends R> publisher = mo3490a;
                                    if (this.f7132m != 1) {
                                        int i = this.f7126f + 1;
                                        if (i == this.f7124d) {
                                            this.f7126f = 0;
                                            this.f7125e.mo2185a(i);
                                        } else {
                                            this.f7126f = i;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.f7121a.m3433e()) {
                                                this.f7133n.mo2187a((Subscriber<? super R>) call);
                                            } else {
                                                this.f7131k = true;
                                                C1606e<R> c1606e = this.f7121a;
                                                c1606e.m3436b(new C1608g(call, c1606e));
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.m3660b(th);
                                            this.f7125e.cancel();
                                            this.f7130j.m3418a(th);
                                            this.f7133n.mo2186a(this.f7130j.m3419a());
                                            return;
                                        }
                                    } else {
                                        this.f7131k = true;
                                        publisher.mo2190a(this.f7121a);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.m3660b(th2);
                                    this.f7125e.cancel();
                                    this.f7130j.m3418a(th2);
                                    this.f7133n.mo2186a(this.f7130j.m3419a());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.m3660b(th3);
                            this.f7125e.cancel();
                            this.f7130j.m3418a(th3);
                            this.f7133n.mo2186a(this.f7130j.m3419a());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            if (this.f7129i) {
                return;
            }
            this.f7129i = true;
            this.f7121a.cancel();
            this.f7125e.cancel();
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.AbstractC1603b
        /* renamed from: d */
        public void mo3566d() {
            this.f7133n.mo2188a((Subscription) this);
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.InterfaceC1607f
        /* renamed from: b */
        public void mo3563b(Throwable th) {
            if (this.f7130j.m3418a(th)) {
                if (!this.f7134o) {
                    this.f7125e.cancel();
                    this.f7128h = true;
                }
                this.f7131k = false;
                mo3567c();
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            this.f7121a.mo2185a(j);
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: d.c.f0.e.b.c$e */
    /* loaded from: classes.dex */
    public static final class C1606e<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {

        /* renamed from: h */
        public final InterfaceC1607f<R> f7137h;

        /* renamed from: i */
        public long f7138i;

        public C1606e(InterfaceC1607f<R> interfaceC1607f) {
            this.f7137h = interfaceC1607f;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            m3436b(subscription);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(R r) {
            this.f7138i++;
            this.f7137h.mo3564b((InterfaceC1607f<R>) r);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            long j = this.f7138i;
            if (j != 0) {
                this.f7138i = 0L;
                m3437b(j);
            }
            this.f7137h.mo3563b(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            long j = this.f7138i;
            if (j != 0) {
                this.f7138i = 0L;
                m3437b(j);
            }
            this.f7137h.mo3565b();
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: d.c.f0.e.b.c$f */
    /* loaded from: classes.dex */
    public interface InterfaceC1607f<T> {
        /* renamed from: b */
        void mo3565b();

        /* renamed from: b */
        void mo3564b(T t);

        /* renamed from: b */
        void mo3563b(Throwable th);
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: d.c.f0.e.b.c$g */
    /* loaded from: classes.dex */
    public static final class C1608g<T> implements Subscription {

        /* renamed from: a */
        public final Subscriber<? super T> f7139a;

        /* renamed from: b */
        public final T f7140b;

        /* renamed from: c */
        public boolean f7141c;

        public C1608g(T t, Subscriber<? super T> subscriber) {
            this.f7140b = t;
            this.f7139a = subscriber;
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            if (j <= 0 || this.f7141c) {
                return;
            }
            this.f7141c = true;
            Subscriber<? super T> subscriber = this.f7139a;
            subscriber.mo2187a((Subscriber<? super T>) ((T) this.f7140b));
            subscriber.mo2189a();
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
        }
    }

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        super(flowable);
        this.f7117c = function;
        this.f7118d = i;
        this.f7119e = errorMode;
    }

    /* renamed from: a */
    public static <T, R> Subscriber<T> m3568a(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        int i2 = C1602a.f7120a[errorMode.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return new C1605d(subscriber, function, i);
            }
            return new C1604c(subscriber, function, i, true);
        }
        return new C1604c(subscriber, function, i, false);
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.m3534a(this.f7090b, subscriber, this.f7117c)) {
            return;
        }
        this.f7090b.mo2190a(m3568a(subscriber, this.f7117c, this.f7118d, this.f7119e));
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: d.c.f0.e.b.c$d */
    /* loaded from: classes.dex */
    public static final class C1605d<T, R> extends AbstractC1603b<T, R> {

        /* renamed from: n */
        public final Subscriber<? super R> f7135n;

        /* renamed from: o */
        public final AtomicInteger f7136o;

        public C1605d(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i) {
            super(function, i);
            this.f7135n = subscriber;
            this.f7136o = new AtomicInteger();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7130j.m3418a(th)) {
                this.f7121a.cancel();
                if (getAndIncrement() == 0) {
                    this.f7135n.mo2186a(this.f7130j.m3419a());
                    return;
                }
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.InterfaceC1607f
        /* renamed from: b */
        public void mo3564b(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f7135n.mo2187a((Subscriber<? super R>) r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.f7135n.mo2186a(this.f7130j.m3419a());
            }
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.AbstractC1603b
        /* renamed from: c */
        public void mo3567c() {
            if (this.f7136o.getAndIncrement() == 0) {
                while (!this.f7129i) {
                    if (!this.f7131k) {
                        boolean z = this.f7128h;
                        try {
                            T poll = this.f7127g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.f7135n.mo2189a();
                                return;
                            } else if (!z2) {
                                try {
                                    Publisher<? extends R> mo3490a = this.f7122b.mo3490a(poll);
                                    ObjectHelper.m3598a(mo3490a, "The mapper returned a null Publisher");
                                    Publisher<? extends R> publisher = mo3490a;
                                    if (this.f7132m != 1) {
                                        int i = this.f7126f + 1;
                                        if (i == this.f7124d) {
                                            this.f7126f = 0;
                                            this.f7125e.mo2185a(i);
                                        } else {
                                            this.f7126f = i;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (this.f7121a.m3433e()) {
                                                if (get() == 0 && compareAndSet(0, 1)) {
                                                    this.f7135n.mo2187a((Subscriber<? super R>) call);
                                                    if (!compareAndSet(1, 0)) {
                                                        this.f7135n.mo2186a(this.f7130j.m3419a());
                                                        return;
                                                    }
                                                }
                                            } else {
                                                this.f7131k = true;
                                                C1606e<R> c1606e = this.f7121a;
                                                c1606e.m3436b(new C1608g(call, c1606e));
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.m3660b(th);
                                            this.f7125e.cancel();
                                            this.f7130j.m3418a(th);
                                            this.f7135n.mo2186a(this.f7130j.m3419a());
                                            return;
                                        }
                                    } else {
                                        this.f7131k = true;
                                        publisher.mo2190a(this.f7121a);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.m3660b(th2);
                                    this.f7125e.cancel();
                                    this.f7130j.m3418a(th2);
                                    this.f7135n.mo2186a(this.f7130j.m3419a());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.m3660b(th3);
                            this.f7125e.cancel();
                            this.f7130j.m3418a(th3);
                            this.f7135n.mo2186a(this.f7130j.m3419a());
                            return;
                        }
                    }
                    if (this.f7136o.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            if (this.f7129i) {
                return;
            }
            this.f7129i = true;
            this.f7121a.cancel();
            this.f7125e.cancel();
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.AbstractC1603b
        /* renamed from: d */
        public void mo3566d() {
            this.f7135n.mo2188a((Subscription) this);
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.InterfaceC1607f
        /* renamed from: b */
        public void mo3563b(Throwable th) {
            if (this.f7130j.m3418a(th)) {
                this.f7125e.cancel();
                if (getAndIncrement() == 0) {
                    this.f7135n.mo2186a(this.f7130j.m3419a());
                    return;
                }
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            this.f7121a.mo2185a(j);
        }
    }

    /* compiled from: FlowableConcatMap.java */
    /* renamed from: d.c.f0.e.b.c$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1603b<T, R> extends AtomicInteger implements FlowableSubscriber<T>, InterfaceC1607f<R>, Subscription {

        /* renamed from: b */
        public final Function<? super T, ? extends Publisher<? extends R>> f7122b;

        /* renamed from: c */
        public final int f7123c;

        /* renamed from: d */
        public final int f7124d;

        /* renamed from: e */
        public Subscription f7125e;

        /* renamed from: f */
        public int f7126f;

        /* renamed from: g */
        public SimpleQueue<T> f7127g;

        /* renamed from: h */
        public volatile boolean f7128h;

        /* renamed from: i */
        public volatile boolean f7129i;

        /* renamed from: k */
        public volatile boolean f7131k;

        /* renamed from: m */
        public int f7132m;

        /* renamed from: a */
        public final C1606e<R> f7121a = new C1606e<>(this);

        /* renamed from: j */
        public final AtomicThrowable f7130j = new AtomicThrowable();

        public AbstractC1603b(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
            this.f7122b = function;
            this.f7123c = i;
            this.f7124d = i - (i >> 2);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public final void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7125e, subscription)) {
                this.f7125e = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int mo3356a = queueSubscription.mo3356a(3);
                    if (mo3356a == 1) {
                        this.f7132m = mo3356a;
                        this.f7127g = queueSubscription;
                        this.f7128h = true;
                        mo3566d();
                        mo3567c();
                        return;
                    } else if (mo3356a == 2) {
                        this.f7132m = mo3356a;
                        this.f7127g = queueSubscription;
                        mo3566d();
                        subscription.mo2185a(this.f7123c);
                        return;
                    }
                }
                this.f7127g = new SpscArrayQueue(this.f7123c);
                mo3566d();
                subscription.mo2185a(this.f7123c);
            }
        }

        @Override // p136d.p153c.p160f0.p165e.p167b.FlowableConcatMap.InterfaceC1607f
        /* renamed from: b */
        public final void mo3565b() {
            this.f7131k = false;
            mo3567c();
        }

        /* renamed from: c */
        public abstract void mo3567c();

        /* renamed from: d */
        public abstract void mo3566d();

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public final void mo2187a(T t) {
            if (this.f7132m != 2 && !this.f7127g.offer(t)) {
                this.f7125e.cancel();
                mo2186a((Throwable) new IllegalStateException("Queue full?!"));
                return;
            }
            mo3567c();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public final void mo2189a() {
            this.f7128h = true;
            mo3567c();
        }
    }
}
