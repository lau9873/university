package p136d.p153c.p160f0.p165e.p167b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Function;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p163c.QueueSubscription;
import p136d.p153c.p160f0.p163c.SimplePlainQueue;
import p136d.p153c.p160f0.p163c.SimpleQueue;
import p136d.p153c.p160f0.p171f.SpscArrayQueue;
import p136d.p153c.p160f0.p171f.SpscLinkedArrayQueue;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.AtomicThrowable;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p136d.p153c.p160f0.p175j.ExceptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.g */
/* loaded from: classes.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: c */
    public final Function<? super T, ? extends Publisher<? extends U>> f7155c;

    /* renamed from: d */
    public final boolean f7156d;

    /* renamed from: e */
    public final int f7157e;

    /* renamed from: f */
    public final int f7158f;

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        super(flowable);
        this.f7155c = function;
        this.f7156d = z;
        this.f7157e = i;
        this.f7158f = i2;
    }

    /* renamed from: a */
    public static <T, U> FlowableSubscriber<T> m3562a(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        return new C1613b(subscriber, function, z, i, i2);
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.m3534a(this.f7090b, subscriber, this.f7155c)) {
            return;
        }
        this.f7090b.m3347a((FlowableSubscriber) m3562a(subscriber, this.f7155c, this.f7156d, this.f7157e, this.f7158f));
    }

    /* compiled from: FlowableFlatMap.java */
    /* renamed from: d.c.f0.e.b.g$b */
    /* loaded from: classes.dex */
    public static final class C1613b<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* renamed from: s */
        public static final C1612a<?, ?>[] f7167s = new C1612a[0];

        /* renamed from: t */
        public static final C1612a<?, ?>[] f7168t = new C1612a[0];

        /* renamed from: a */
        public final Subscriber<? super U> f7169a;

        /* renamed from: b */
        public final Function<? super T, ? extends Publisher<? extends U>> f7170b;

        /* renamed from: c */
        public final boolean f7171c;

        /* renamed from: d */
        public final int f7172d;

        /* renamed from: e */
        public final int f7173e;

        /* renamed from: f */
        public volatile SimplePlainQueue<U> f7174f;

        /* renamed from: g */
        public volatile boolean f7175g;

        /* renamed from: i */
        public volatile boolean f7177i;

        /* renamed from: m */
        public Subscription f7180m;

        /* renamed from: n */
        public long f7181n;

        /* renamed from: o */
        public long f7182o;

        /* renamed from: p */
        public int f7183p;

        /* renamed from: q */
        public int f7184q;

        /* renamed from: r */
        public final int f7185r;

        /* renamed from: h */
        public final AtomicThrowable f7176h = new AtomicThrowable();

        /* renamed from: j */
        public final AtomicReference<C1612a<?, ?>[]> f7178j = new AtomicReference<>();

        /* renamed from: k */
        public final AtomicLong f7179k = new AtomicLong();

        public C1613b(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
            this.f7169a = subscriber;
            this.f7170b = function;
            this.f7171c = z;
            this.f7172d = i;
            this.f7173e = i2;
            this.f7185r = Math.max(1, i >> 1);
            this.f7178j.lazySet(f7167s);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7180m, subscription)) {
                this.f7180m = subscription;
                this.f7169a.mo2188a((Subscription) this);
                if (this.f7177i) {
                    return;
                }
                int i = this.f7172d;
                if (i == Integer.MAX_VALUE) {
                    subscription.mo2185a(Long.MAX_VALUE);
                } else {
                    subscription.mo2185a(i);
                }
            }
        }

        /* renamed from: b */
        public void m3555b(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.f7179k.get();
                SimpleQueue<U> simpleQueue = this.f7174f;
                if (j != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    this.f7169a.mo2187a((Subscriber<? super U>) u);
                    if (j != Long.MAX_VALUE) {
                        this.f7179k.decrementAndGet();
                    }
                    if (this.f7172d != Integer.MAX_VALUE && !this.f7177i) {
                        int i = this.f7184q + 1;
                        this.f7184q = i;
                        int i2 = this.f7185r;
                        if (i == i2) {
                            this.f7184q = 0;
                            this.f7180m.mo2185a(i2);
                        }
                    }
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = m3549g();
                    }
                    if (!simpleQueue.offer(u)) {
                        mo2186a((Throwable) new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!m3549g().offer(u)) {
                mo2186a((Throwable) new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            m3550f();
        }

        /* renamed from: c */
        public void m3553c(C1612a<T, U> c1612a) {
            C1612a<?, ?>[] c1612aArr;
            C1612a<?, ?>[] c1612aArr2;
            do {
                c1612aArr = this.f7178j.get();
                if (c1612aArr == f7168t || c1612aArr == f7167s) {
                    return;
                }
                int length = c1612aArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (c1612aArr[i2] == c1612a) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    c1612aArr2 = f7167s;
                } else {
                    C1612a<?, ?>[] c1612aArr3 = new C1612a[length - 1];
                    System.arraycopy(c1612aArr, 0, c1612aArr3, 0, i);
                    System.arraycopy(c1612aArr, i + 1, c1612aArr3, i, (length - i) - 1);
                    c1612aArr2 = c1612aArr3;
                }
            } while (!this.f7178j.compareAndSet(c1612aArr, c1612aArr2));
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            if (this.f7177i) {
                return;
            }
            this.f7177i = true;
            this.f7180m.cancel();
            m3552d();
            if (getAndIncrement() != 0 || (simplePlainQueue = this.f7174f) == null) {
                return;
            }
            simplePlainQueue.clear();
        }

        /* renamed from: d */
        public void m3552d() {
            C1612a<?, ?>[] andSet;
            C1612a<?, ?>[] c1612aArr = this.f7178j.get();
            C1612a<?, ?>[] c1612aArr2 = f7168t;
            if (c1612aArr == c1612aArr2 || (andSet = this.f7178j.getAndSet(c1612aArr2)) == f7168t) {
                return;
            }
            for (C1612a<?, ?> c1612a : andSet) {
                c1612a.mo578b();
            }
            Throwable m3419a = this.f7176h.m3419a();
            if (m3419a == null || m3419a == ExceptionHelper.f7711a) {
                return;
            }
            RxJavaPlugins.m3371b(m3419a);
        }

        /* renamed from: e */
        public void m3551e() {
            if (getAndIncrement() == 0) {
                m3550f();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:118:0x0188, code lost:
            r24.f7183p = r4;
            r24.f7182o = r11[r4].f7159a;
            r3 = r16;
            r5 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x012b, code lost:
            if (r8 == r14) goto L124;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x012d, code lost:
            if (r10 != false) goto L123;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x012f, code lost:
            r5 = r24.f7179k.addAndGet(-r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0137, code lost:
            r5 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x013c, code lost:
            r7.m3561a(r8);
            r8 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0142, code lost:
            r8 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0145, code lost:
            if (r5 == r8) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0147, code lost:
            if (r22 != null) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x014a, code lost:
            r8 = r11;
            r9 = r13;
            r11 = r22;
            r14 = 0;
         */
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m3550f() {
            /*
                Method dump skipped, instructions count: 440
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p136d.p153c.p160f0.p165e.p167b.FlowableFlatMap.C1613b.m3550f():void");
        }

        /* renamed from: g */
        public SimpleQueue<U> m3549g() {
            SimplePlainQueue<U> simplePlainQueue = this.f7174f;
            if (simplePlainQueue == null) {
                int i = this.f7172d;
                if (i == Integer.MAX_VALUE) {
                    simplePlainQueue = new SpscLinkedArrayQueue<>(this.f7173e);
                } else {
                    simplePlainQueue = new SpscArrayQueue(i);
                }
                this.f7174f = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            if (this.f7175g) {
                return;
            }
            try {
                Publisher<? extends U> mo3490a = this.f7170b.mo3490a(t);
                ObjectHelper.m3598a(mo3490a, "The mapper returned a null Publisher");
                Publisher<? extends U> publisher = mo3490a;
                if (publisher instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher).call();
                        if (call != null) {
                            m3555b((C1613b<T, U>) call);
                            return;
                        } else if (this.f7172d == Integer.MAX_VALUE || this.f7177i) {
                            return;
                        } else {
                            int i = this.f7184q + 1;
                            this.f7184q = i;
                            int i2 = this.f7185r;
                            if (i == i2) {
                                this.f7184q = 0;
                                this.f7180m.mo2185a(i2);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m3660b(th);
                        this.f7176h.m3418a(th);
                        m3551e();
                        return;
                    }
                }
                long j = this.f7181n;
                this.f7181n = 1 + j;
                C1612a c1612a = new C1612a(this, j);
                if (m3560a(c1612a)) {
                    publisher.mo2190a(c1612a);
                }
            } catch (Throwable th2) {
                Exceptions.m3660b(th2);
                this.f7180m.cancel();
                mo2186a(th2);
            }
        }

        /* renamed from: c */
        public void m3554c() {
            SimplePlainQueue<U> simplePlainQueue = this.f7174f;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        /* renamed from: b */
        public SimpleQueue<U> m3556b(C1612a<T, U> c1612a) {
            SimpleQueue<U> simpleQueue = c1612a.f7164f;
            if (simpleQueue == null) {
                SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f7173e);
                c1612a.f7164f = spscArrayQueue;
                return spscArrayQueue;
            }
            return simpleQueue;
        }

        /* renamed from: b */
        public boolean m3557b() {
            if (this.f7177i) {
                m3554c();
                return true;
            } else if (this.f7171c || this.f7176h.get() == null) {
                return false;
            } else {
                m3554c();
                this.f7169a.mo2186a(this.f7176h.m3419a());
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public boolean m3560a(C1612a<T, U> c1612a) {
            C1612a<?, ?>[] c1612aArr;
            C1612a[] c1612aArr2;
            do {
                c1612aArr = this.f7178j.get();
                if (c1612aArr == f7168t) {
                    c1612a.mo578b();
                    return false;
                }
                int length = c1612aArr.length;
                c1612aArr2 = new C1612a[length + 1];
                System.arraycopy(c1612aArr, 0, c1612aArr2, 0, length);
                c1612aArr2[length] = c1612a;
            } while (!this.f7178j.compareAndSet(c1612aArr, c1612aArr2));
            return true;
        }

        /* renamed from: a */
        public void m3558a(U u, C1612a<T, U> c1612a) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.f7179k.get();
                SimpleQueue<U> simpleQueue = c1612a.f7164f;
                if (j != 0 && (simpleQueue == null || simpleQueue.isEmpty())) {
                    this.f7169a.mo2187a((Subscriber<? super U>) u);
                    if (j != Long.MAX_VALUE) {
                        this.f7179k.decrementAndGet();
                    }
                    c1612a.m3561a(1L);
                } else {
                    if (simpleQueue == null) {
                        simpleQueue = m3556b((C1612a) c1612a);
                    }
                    if (!simpleQueue.offer(u)) {
                        mo2186a((Throwable) new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue2 = c1612a.f7164f;
                if (simpleQueue2 == null) {
                    simpleQueue2 = new SpscArrayQueue(this.f7173e);
                    c1612a.f7164f = simpleQueue2;
                }
                if (!simpleQueue2.offer(u)) {
                    mo2186a((Throwable) new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            m3550f();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f7175g) {
                RxJavaPlugins.m3371b(th);
            } else if (this.f7176h.m3418a(th)) {
                this.f7175g = true;
                m3551e();
            } else {
                RxJavaPlugins.m3371b(th);
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (this.f7175g) {
                return;
            }
            this.f7175g = true;
            m3551e();
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            if (SubscriptionHelper.m3424c(j)) {
                BackpressureHelper.m3416a(this.f7179k, j);
                m3551e();
            }
        }

        /* renamed from: a */
        public void m3559a(C1612a<T, U> c1612a, Throwable th) {
            if (this.f7176h.m3418a(th)) {
                c1612a.f7163e = true;
                if (!this.f7171c) {
                    this.f7180m.cancel();
                    for (C1612a<?, ?> c1612a2 : this.f7178j.getAndSet(f7168t)) {
                        c1612a2.mo578b();
                    }
                }
                m3551e();
                return;
            }
            RxJavaPlugins.m3371b(th);
        }
    }

    /* compiled from: FlowableFlatMap.java */
    /* renamed from: d.c.f0.e.b.g$a */
    /* loaded from: classes.dex */
    public static final class C1612a<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {

        /* renamed from: a */
        public final long f7159a;

        /* renamed from: b */
        public final C1613b<T, U> f7160b;

        /* renamed from: c */
        public final int f7161c;

        /* renamed from: d */
        public final int f7162d;

        /* renamed from: e */
        public volatile boolean f7163e;

        /* renamed from: f */
        public volatile SimpleQueue<U> f7164f;

        /* renamed from: g */
        public long f7165g;

        /* renamed from: h */
        public int f7166h;

        public C1612a(C1613b<T, U> c1613b, long j) {
            this.f7159a = j;
            this.f7160b = c1613b;
            this.f7162d = c1613b.f7173e;
            this.f7161c = this.f7162d >> 2;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3429a(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int mo3356a = queueSubscription.mo3356a(7);
                    if (mo3356a == 1) {
                        this.f7166h = mo3356a;
                        this.f7164f = queueSubscription;
                        this.f7163e = true;
                        this.f7160b.m3551e();
                        return;
                    } else if (mo3356a == 2) {
                        this.f7166h = mo3356a;
                        this.f7164f = queueSubscription;
                    }
                }
                subscription.mo2185a(this.f7162d);
            }
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            SubscriptionHelper.m3430a(this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(U u) {
            if (this.f7166h != 2) {
                this.f7160b.m3558a((C1613b<T, U>) u, (C1612a<T, C1613b<T, U>>) this);
            } else {
                this.f7160b.m3551e();
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.f7160b.m3559a(this, th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7163e = true;
            this.f7160b.m3551e();
        }

        /* renamed from: a */
        public void m3561a(long j) {
            if (this.f7166h != 1) {
                long j2 = this.f7165g + j;
                if (j2 >= this.f7161c) {
                    this.f7165g = 0L;
                    get().mo2185a(j2);
                    return;
                }
                this.f7165g = j2;
            }
        }
    }
}
