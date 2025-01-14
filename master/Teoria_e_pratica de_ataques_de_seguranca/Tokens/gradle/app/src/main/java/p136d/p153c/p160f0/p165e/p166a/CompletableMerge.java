package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.FlowableSubscriber;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p174i.SubscriptionHelper;
import p136d.p153c.p160f0.p175j.AtomicThrowable;
import p136d.p153c.p177h0.RxJavaPlugins;
import p193g.p204b.Publisher;
import p193g.p204b.Subscription;

/* renamed from: d.c.f0.e.a.x */
/* loaded from: classes.dex */
public final class CompletableMerge extends Completable {

    /* renamed from: a */
    public final Publisher<? extends CompletableSource> f7071a;

    /* renamed from: b */
    public final int f7072b;

    /* renamed from: c */
    public final boolean f7073c;

    /* compiled from: CompletableMerge.java */
    /* renamed from: d.c.f0.e.a.x$a */
    /* loaded from: classes.dex */
    public static final class C1594a extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {

        /* renamed from: a */
        public final CompletableObserver f7074a;

        /* renamed from: b */
        public final int f7075b;

        /* renamed from: c */
        public final boolean f7076c;

        /* renamed from: f */
        public Subscription f7079f;

        /* renamed from: e */
        public final CompositeDisposable f7078e = new CompositeDisposable();

        /* renamed from: d */
        public final AtomicThrowable f7077d = new AtomicThrowable();

        /* compiled from: CompletableMerge.java */
        /* renamed from: d.c.f0.e.a.x$a$a */
        /* loaded from: classes.dex */
        public final class C1595a extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            public C1595a() {
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3502a(Disposable disposable) {
                DisposableHelper.m3644c(this, disposable);
            }

            @Override // p136d.p153c.p157c0.Disposable
            /* renamed from: b */
            public void mo578b() {
                DisposableHelper.m3647a((AtomicReference<Disposable>) this);
            }

            @Override // p136d.p153c.p157c0.Disposable
            /* renamed from: c */
            public boolean mo577c() {
                return DisposableHelper.m3649a(get());
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3501a(Throwable th) {
                C1594a.this.m3573a(this, th);
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3489a() {
                C1594a.this.m3574a(this);
            }
        }

        public C1594a(CompletableObserver completableObserver, int i, boolean z) {
            this.f7074a = completableObserver;
            this.f7075b = i;
            this.f7076c = z;
            lazySet(1);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7079f.cancel();
            this.f7078e.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7078e.mo577c();
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2188a(Subscription subscription) {
            if (SubscriptionHelper.m3431a(this.f7079f, subscription)) {
                this.f7079f = subscription;
                this.f7074a.mo3502a(this);
                int i = this.f7075b;
                if (i == Integer.MAX_VALUE) {
                    subscription.mo2185a(Long.MAX_VALUE);
                } else {
                    subscription.mo2185a(i);
                }
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2187a(CompletableSource completableSource) {
            getAndIncrement();
            C1595a c1595a = new C1595a();
            this.f7078e.mo3633c(c1595a);
            completableSource.subscribe(c1595a);
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2186a(Throwable th) {
            if (!this.f7076c) {
                this.f7078e.mo578b();
                if (this.f7077d.m3418a(th)) {
                    if (getAndSet(0) > 0) {
                        this.f7074a.mo3501a(this.f7077d.m3419a());
                        return;
                    }
                    return;
                }
                RxJavaPlugins.m3371b(th);
            } else if (this.f7077d.m3418a(th)) {
                if (decrementAndGet() == 0) {
                    this.f7074a.mo3501a(this.f7077d.m3419a());
                }
            } else {
                RxJavaPlugins.m3371b(th);
            }
        }

        @Override // p193g.p204b.Subscriber
        /* renamed from: a */
        public void mo2189a() {
            if (decrementAndGet() == 0) {
                if (this.f7077d.get() != null) {
                    this.f7074a.mo3501a(this.f7077d.m3419a());
                } else {
                    this.f7074a.mo3489a();
                }
            }
        }

        /* renamed from: a */
        public void m3573a(C1595a c1595a, Throwable th) {
            this.f7078e.mo3636a(c1595a);
            if (!this.f7076c) {
                this.f7079f.cancel();
                this.f7078e.mo578b();
                if (this.f7077d.m3418a(th)) {
                    if (getAndSet(0) > 0) {
                        this.f7074a.mo3501a(this.f7077d.m3419a());
                        return;
                    }
                    return;
                }
                RxJavaPlugins.m3371b(th);
            } else if (this.f7077d.m3418a(th)) {
                if (decrementAndGet() == 0) {
                    this.f7074a.mo3501a(this.f7077d.m3419a());
                } else if (this.f7075b != Integer.MAX_VALUE) {
                    this.f7079f.mo2185a(1L);
                }
            } else {
                RxJavaPlugins.m3371b(th);
            }
        }

        /* renamed from: a */
        public void m3574a(C1595a c1595a) {
            this.f7078e.mo3636a(c1595a);
            if (decrementAndGet() == 0) {
                Throwable th = this.f7077d.get();
                if (th != null) {
                    this.f7074a.mo3501a(th);
                } else {
                    this.f7074a.mo3489a();
                }
            } else if (this.f7075b != Integer.MAX_VALUE) {
                this.f7079f.mo2185a(1L);
            }
        }
    }

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        this.f7071a = publisher;
        this.f7072b = i;
        this.f7073c = z;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7071a.mo2190a(new C1594a(completableObserver, this.f7072b, this.f7073c));
    }
}
