package p136d.p153c.p178i0;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.p160f0.p162b.ObjectHelper;
import p136d.p153c.p160f0.p171f.SpscLinkedArrayQueue;
import p136d.p153c.p160f0.p174i.BasicIntQueueSubscription;
import p136d.p153c.p160f0.p174i.EmptySubscription;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.BackpressureHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Subscriber;
import p193g.p204b.Subscription;

/* renamed from: d.c.i0.c */
/* loaded from: classes.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* renamed from: b */
    public final SpscLinkedArrayQueue<T> f7765b;

    /* renamed from: c */
    public final AtomicReference<Runnable> f7766c;

    /* renamed from: d */
    public volatile boolean f7767d;

    /* renamed from: e */
    public Throwable f7768e;

    /* renamed from: f */
    public final AtomicReference<Subscriber<? super T>> f7769f;

    /* renamed from: g */
    public volatile boolean f7770g;

    /* renamed from: h */
    public final AtomicBoolean f7771h;

    /* renamed from: i */
    public final BasicIntQueueSubscription<T> f7772i;

    /* renamed from: j */
    public final AtomicLong f7773j;

    /* renamed from: k */
    public boolean f7774k;

    /* compiled from: UnicastProcessor.java */
    /* renamed from: d.c.i0.c$a */
    /* loaded from: classes.dex */
    public final class C1720a extends BasicIntQueueSubscription<T> {
        public C1720a() {
        }

        @Override // p136d.p153c.p160f0.p163c.QueueFuseable
        /* renamed from: a */
        public int mo3356a(int i) {
            if ((i & 2) != 0) {
                UnicastProcessor.this.f7774k = true;
                return 2;
            }
            return 0;
        }

        @Override // p193g.p204b.Subscription
        public void cancel() {
            if (UnicastProcessor.this.f7770g) {
                return;
            }
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            unicastProcessor.f7770g = true;
            unicastProcessor.m3358j();
            UnicastProcessor unicastProcessor2 = UnicastProcessor.this;
            if (unicastProcessor2.f7774k || unicastProcessor2.f7772i.getAndIncrement() != 0) {
                return;
            }
            UnicastProcessor.this.f7765b.clear();
            UnicastProcessor.this.f7769f.lazySet(null);
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public void clear() {
            UnicastProcessor.this.f7765b.clear();
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.f7765b.isEmpty();
        }

        @Override // p136d.p153c.p160f0.p163c.SimpleQueue
        public T poll() {
            return UnicastProcessor.this.f7765b.poll();
        }

        @Override // p193g.p204b.Subscription
        /* renamed from: a */
        public void mo2185a(long j) {
            if (SubscriptionHelper.m3424c(j)) {
                BackpressureHelper.m3416a(UnicastProcessor.this.f7773j, j);
                UnicastProcessor.this.m3357k();
            }
        }
    }

    public UnicastProcessor(int i) {
        ObjectHelper.m3601a(i, "capacityHint");
        this.f7765b = new SpscLinkedArrayQueue<>(i);
        this.f7766c = new AtomicReference<>();
        this.f7769f = new AtomicReference<>();
        this.f7771h = new AtomicBoolean();
        this.f7772i = new C1720a();
        this.f7773j = new AtomicLong();
    }

    /* renamed from: a */
    public static <T> UnicastProcessor<T> m3362a(int i) {
        return new UnicastProcessor<>(i);
    }

    @Override // p136d.p153c.Flowable
    /* renamed from: b */
    public void mo3333b(Subscriber<? super T> subscriber) {
        if (!this.f7771h.get() && this.f7771h.compareAndSet(false, true)) {
            subscriber.mo2188a((Subscription) this.f7772i);
            this.f7769f.set(subscriber);
            if (this.f7770g) {
                this.f7769f.lazySet(null);
                return;
            } else {
                m3357k();
                return;
            }
        }
        EmptySubscription.m3439a(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
    }

    /* renamed from: c */
    public void m3360c(Subscriber<? super T> subscriber) {
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f7765b;
        int i = 1;
        while (!this.f7770g) {
            boolean z = this.f7767d;
            subscriber.mo2187a((Subscriber<? super T>) null);
            if (z) {
                this.f7769f.lazySet(null);
                Throwable th = this.f7768e;
                if (th != null) {
                    subscriber.mo2186a(th);
                    return;
                } else {
                    subscriber.mo2189a();
                    return;
                }
            }
            i = this.f7772i.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.f7769f.lazySet(null);
    }

    /* renamed from: d */
    public void m3359d(Subscriber<? super T> subscriber) {
        int i;
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f7765b;
        int i2 = 1;
        do {
            long j = this.f7773j.get();
            long j2 = 0;
            while (true) {
                i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z = this.f7767d;
                T poll = spscLinkedArrayQueue.poll();
                boolean z2 = poll == null;
                if (m3361a(z, z2, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (z2) {
                    break;
                }
                subscriber.mo2187a((Subscriber<? super T>) poll);
                j2++;
            }
            if (i == 0 && m3361a(this.f7767d, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.f7773j.addAndGet(-j2);
            }
            i2 = this.f7772i.addAndGet(-i2);
        } while (i2 != 0);
    }

    /* renamed from: j */
    public void m3358j() {
        Runnable runnable = this.f7766c.get();
        if (runnable == null || !this.f7766c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    /* renamed from: k */
    public void m3357k() {
        if (this.f7772i.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        Subscriber<? super T> subscriber = this.f7769f.get();
        while (subscriber == null) {
            i = this.f7772i.addAndGet(-i);
            if (i == 0) {
                return;
            }
            subscriber = this.f7769f.get();
        }
        if (this.f7774k) {
            m3360c(subscriber);
        } else {
            m3359d(subscriber);
        }
    }

    /* renamed from: a */
    public boolean m3361a(boolean z, boolean z2, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.f7770g) {
            spscLinkedArrayQueue.clear();
            this.f7769f.lazySet(null);
            return true;
        } else if (z && z2) {
            Throwable th = this.f7768e;
            this.f7769f.lazySet(null);
            if (th != null) {
                subscriber.mo2186a(th);
            } else {
                subscriber.mo2189a();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2188a(Subscription subscription) {
        if (!this.f7767d && !this.f7770g) {
            subscription.mo2185a(Long.MAX_VALUE);
        } else {
            subscription.cancel();
        }
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2187a(T t) {
        if (this.f7767d || this.f7770g) {
            return;
        }
        if (t == null) {
            mo2186a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.f7765b.offer(t);
        m3357k();
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2186a(Throwable th) {
        if (!this.f7767d && !this.f7770g) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f7768e = th;
            this.f7767d = true;
            m3358j();
            m3357k();
            return;
        }
        RxJavaPlugins.m3371b(th);
    }

    @Override // p193g.p204b.Subscriber
    /* renamed from: a */
    public void mo2189a() {
        if (this.f7767d || this.f7770g) {
            return;
        }
        this.f7767d = true;
        m3358j();
        m3357k();
    }
}
