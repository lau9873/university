package p136d.p153c.p160f0.p165e.p166a;

import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.Flowable;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p158d0.Exceptions;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p163c.QueueSubscription;
import p136d.p153c.p160f0.p163c.SimpleQueue;
import p136d.p153c.p160f0.p171f.SpscArrayQueue;
import p136d.p153c.p160f0.p171f.SpscLinkedArrayQueue;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.a.c */
/* loaded from: classes.dex */
public final class CompletableConcat extends Completable {

    /* renamed from: a */
    public final Publisher<? extends CompletableSource> f6936a;

    /* renamed from: b */
    public final int f6937b;

    /* compiled from: CompletableConcat.java */
    /* renamed from: d.c.f0.e.a.c$a */
    /* loaded from: classes.dex */
    public static final class C1565a extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {

        /* renamed from: a */
        public final CompletableObserver f6938a;

        /* renamed from: b */
        public final int f6939b;

        /* renamed from: c */
        public final int f6940c;

        /* renamed from: d */
        public final C1566a f6941d = new C1566a(this);

        /* renamed from: e */
        public final AtomicBoolean f6942e = new AtomicBoolean();

        /* renamed from: f */
        public int f6943f;

        /* renamed from: g */
        public int f6944g;

        /* renamed from: h */
        public SimpleQueue<CompletableSource> f6945h;

        /* renamed from: i */
        public Subscription f6946i;

        /* renamed from: j */
        public volatile boolean f6947j;

        /* renamed from: k */
        public volatile boolean f6948k;

        /* compiled from: CompletableConcat.java */
        /* renamed from: d.c.f0.e.a.c$a$a */
        /* loaded from: classes.dex */
        public static final class C1566a extends AtomicReference<Disposable> implements CompletableObserver {

            /* renamed from: a */
            public final C1565a f6949a;

            public C1566a(C1565a c1565a) {
                this.f6949a = c1565a;
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3502a(Disposable disposable) {
                DisposableHelper.m3646a(this, disposable);
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3501a(Throwable th) {
                this.f6949a.m3585b(th);
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3489a() {
                this.f6949a.m3583e();
            }
        }

        public C1565a(CompletableObserver completableObserver, int i) {
            this.f6938a = completableObserver;
            this.f6939b = i;
            this.f6940c = i - (i >> 2);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f6946i.cancel();
            DisposableHelper.m3647a(this.f6941d);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(this.f6941d.get());
        }

        /* renamed from: d */
        public void m3584d() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!mo577c()) {
                if (!this.f6948k) {
                    boolean z = this.f6947j;
                    try {
                        CompletableSource poll = this.f6945h.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            if (this.f6942e.compareAndSet(false, true)) {
                                this.f6938a.mo3489a();
                                return;
                            }
                            return;
                        } else if (!z2) {
                            this.f6948k = true;
                            poll.subscribe(this.f6941d);
                            m3582f();
                        }
                    } catch (Throwable th) {
                        Exceptions.m3660b(th);
                        m3585b(th);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* renamed from: e */
        public void m3583e() {
            this.f6948k = false;
            m3584d();
        }

        /* renamed from: f */
        public void m3582f() {
            if (this.f6943f != 1) {
                int i = this.f6944g + 1;
                if (i == this.f6940c) {
                    this.f6944g = 0;
                    this.f6946i.mo2185a(i);
                    return;
                }
                this.f6944g = i;
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f6946i, subscription)) {
                this.f6946i = subscription;
                int i = this.f6939b;
                long j = i == Integer.MAX_VALUE ? Long.MAX_VALUE : i;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int mo3356a = queueSubscription.mo3356a(3);
                    if (mo3356a == 1) {
                        this.f6943f = mo3356a;
                        this.f6945h = queueSubscription;
                        this.f6947j = true;
                        this.f6938a.mo3502a(this);
                        m3584d();
                        return;
                    } else if (mo3356a == 2) {
                        this.f6943f = mo3356a;
                        this.f6945h = queueSubscription;
                        this.f6938a.mo3502a(this);
                        subscription.mo2185a(j);
                        return;
                    }
                }
                int i2 = this.f6939b;
                if (i2 == Integer.MAX_VALUE) {
                    this.f6945h = new SpscLinkedArrayQueue(Flowable.m3326g());
                } else {
                    this.f6945h = new SpscArrayQueue(i2);
                }
                this.f6938a.mo3502a(this);
                subscription.mo2185a(j);
            }
        }

        /* renamed from: b */
        public void m3585b(Throwable th) {
            if (this.f6942e.compareAndSet(false, true)) {
                this.f6946i.cancel();
                this.f6938a.mo3501a(th);
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(CompletableSource completableSource) {
            if (this.f6943f == 0 && !this.f6945h.offer(completableSource)) {
                mo2186a((Throwable) new MissingBackpressureException());
            } else {
                m3584d();
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (this.f6942e.compareAndSet(false, true)) {
                DisposableHelper.m3647a(this.f6941d);
                this.f6938a.mo3501a(th);
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            this.f6947j = true;
            m3584d();
        }
    }

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int i) {
        this.f6936a = publisher;
        this.f6937b = i;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f6936a.mo2190a(new C1565a(completableObserver, this.f6937b));
    }
}
