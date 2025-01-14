package p136d.p153c.p160f0.p165e.p167b;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p159e0.Action;
import p136d.p153c.p160f0.p163c.SimplePlainQueue;
import p136d.p153c.p160f0.p171f.SpscArrayQueue;
import p136d.p153c.p160f0.p171f.SpscLinkedArrayQueue;
import p136d.p153c.p160f0.p174i.BasicIntQueueSubscription;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.b.o */
/* loaded from: classes.dex */
public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: c */
    public final int f7211c;

    /* renamed from: d */
    public final boolean f7212d;

    /* renamed from: e */
    public final boolean f7213e;

    /* renamed from: f */
    public final Action f7214f;

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i, boolean z, boolean z2, Action action) {
        super(flowable);
        this.f7211c = i;
        this.f7212d = z;
        this.f7213e = z2;
        this.f7214f = action;
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        this.f7090b.m3347a((FlowableSubscriber) new C1621a(subscriber, this.f7211c, this.f7212d, this.f7213e, this.f7214f));
    }

    /* compiled from: FlowableOnBackpressureBuffer.java */
    /* renamed from: d.c.f0.e.b.o$a */
    /* loaded from: classes.dex */
    public static final class C1621a<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {

        /* renamed from: a */
        public final Subscriber<? super T> f7215a;

        /* renamed from: b */
        public final SimplePlainQueue<T> f7216b;

        /* renamed from: c */
        public final boolean f7217c;

        /* renamed from: d */
        public final Action f7218d;

        /* renamed from: e */
        public Subscription f7219e;

        /* renamed from: f */
        public volatile boolean f7220f;

        /* renamed from: g */
        public volatile boolean f7221g;

        /* renamed from: h */
        public Throwable f7222h;

        /* renamed from: i */
        public final AtomicLong f7223i = new AtomicLong();

        /* renamed from: j */
        public boolean f7224j;

        public C1621a(Subscriber<? super T> subscriber, int i, boolean z, boolean z2, Action action) {
            SimplePlainQueue<T> spscArrayQueue;
            this.f7215a = subscriber;
            this.f7218d = action;
            this.f7217c = z2;
            if (z) {
                spscArrayQueue = new SpscLinkedArrayQueue<>(i);
            } else {
                spscArrayQueue = new SpscArrayQueue<>(i);
            }
            this.f7216b = spscArrayQueue;
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7219e, subscription)) {
                this.f7219e = subscription;
                this.f7215a.mo2188a((Subscription) this);
                subscription.mo2185a(Long.MAX_VALUE);
            }
        }

        /* renamed from: b */
        public void m3542b() {
            int i;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.f7216b;
                Subscriber<? super T> subscriber = this.f7215a;
                int i2 = 1;
                while (!m3543a(this.f7221g, simplePlainQueue.isEmpty(), subscriber)) {
                    long j = this.f7223i.get();
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
                            break;
                        }
                        boolean z = this.f7221g;
                        Object obj = (T) simplePlainQueue.poll();
                        boolean z2 = obj == null;
                        if (m3543a(z, z2, subscriber)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        subscriber.mo2187a((Subscriber<? super T>) obj);
                        j2++;
                    }
                    if (i == 0 && m3543a(this.f7221g, simplePlainQueue.isEmpty(), subscriber)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.f7223i.addAndGet(-j2);
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            if (this.f7220f) {
                return;
            }
            this.f7220f = true;
            this.f7219e.cancel();
            if (getAndIncrement() == 0) {
                this.f7216b.clear();
            }
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public void clear() {
            this.f7216b.clear();
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public boolean isEmpty() {
            return this.f7216b.isEmpty();
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public T poll() {
            return this.f7216b.poll();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(T t) {
            if (!this.f7216b.offer(t)) {
                this.f7219e.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.f7218d.run();
                } catch (Throwable th) {
                    Exceptions.m3660b(th);
                    missingBackpressureException.initCause(th);
                }
                mo2186a((Throwable) missingBackpressureException);
            } else if (this.f7224j) {
                this.f7215a.mo2187a((Subscriber<? super T>) null);
            } else {
                m3542b();
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            this.f7222h = th;
            this.f7221g = true;
            if (this.f7224j) {
                this.f7215a.mo2186a(th);
            } else {
                m3542b();
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f7221g = true;
            if (this.f7224j) {
                this.f7215a.mo2189a();
            } else {
                m3542b();
            }
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            if (this.f7224j || !SubscriptionHelper.m3424c(j)) {
                return;
            }
            BackpressureHelper.m3416a(this.f7223i, j);
            m3542b();
        }

        /* renamed from: a */
        public boolean m3543a(boolean z, boolean z2, Subscriber<? super T> subscriber) {
            if (this.f7220f) {
                this.f7216b.clear();
                return true;
            } else if (z) {
                if (this.f7217c) {
                    if (z2) {
                        Throwable th = this.f7222h;
                        if (th != null) {
                            subscriber.mo2186a(th);
                        } else {
                            subscriber.mo2189a();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f7222h;
                if (th2 != null) {
                    this.f7216b.clear();
                    subscriber.mo2186a(th2);
                    return true;
                } else if (z2) {
                    subscriber.mo2189a();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // p136d.p153c.p160f0.p163c.QueueFuseable
        /* renamed from: a */
        public int mo3356a(int i) {
            if ((i & 2) != 0) {
                this.f7224j = true;
                return 2;
            }
            return 0;
        }
    }
}
