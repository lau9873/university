package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p136d.p153c.Scheduler;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.e.e.n0 */
/* loaded from: classes.dex */
public final class SingleTimeout<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7506a;

    /* renamed from: b */
    public final long f7507b;

    /* renamed from: c */
    public final TimeUnit f7508c;

    /* renamed from: d */
    public final Scheduler f7509d;

    /* renamed from: e */
    public final SingleSource<? extends T> f7510e;

    /* compiled from: SingleTimeout.java */
    /* renamed from: d.c.f0.e.e.n0$a */
    /* loaded from: classes.dex */
    public class RunnableC1681a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AtomicBoolean f7511a;

        /* renamed from: b */
        public final /* synthetic */ CompositeDisposable f7512b;

        /* renamed from: c */
        public final /* synthetic */ SingleObserver f7513c;

        public RunnableC1681a(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, SingleObserver singleObserver) {
            this.f7511a = atomicBoolean;
            this.f7512b = compositeDisposable;
            this.f7513c = singleObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7511a.compareAndSet(false, true)) {
                if (SingleTimeout.this.f7510e != null) {
                    this.f7512b.m3670a();
                    SingleTimeout.this.f7510e.subscribe(new C1682a());
                    return;
                }
                this.f7512b.mo578b();
                this.f7513c.mo3283a(new TimeoutException());
            }
        }

        /* compiled from: SingleTimeout.java */
        /* renamed from: d.c.f0.e.e.n0$a$a */
        /* loaded from: classes.dex */
        public class C1682a implements SingleObserver<T> {
            public C1682a() {
            }

            @Override // p136d.p153c.SingleObserver
            /* renamed from: a */
            public void mo3283a(Throwable th) {
                RunnableC1681a.this.f7512b.mo578b();
                RunnableC1681a.this.f7513c.mo3283a(th);
            }

            @Override // p136d.p153c.SingleObserver
            /* renamed from: b */
            public void mo3282b(T t) {
                RunnableC1681a.this.f7512b.mo578b();
                RunnableC1681a.this.f7513c.mo3282b(t);
            }

            @Override // p136d.p153c.SingleObserver
            /* renamed from: a */
            public void mo3284a(Disposable disposable) {
                RunnableC1681a.this.f7512b.mo3633c(disposable);
            }
        }
    }

    public SingleTimeout(SingleSource<T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.f7506a = singleSource;
        this.f7507b = j;
        this.f7508c = timeUnit;
        this.f7509d = scheduler;
        this.f7510e = singleSource2;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.mo3284a(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.mo3633c(this.f7509d.mo3290a(new RunnableC1681a(atomicBoolean, compositeDisposable, singleObserver), this.f7507b, this.f7508c));
        this.f7506a.subscribe(new C1683b(this, atomicBoolean, compositeDisposable, singleObserver));
    }

    /* compiled from: SingleTimeout.java */
    /* renamed from: d.c.f0.e.e.n0$b */
    /* loaded from: classes.dex */
    public class C1683b implements SingleObserver<T> {

        /* renamed from: a */
        public final /* synthetic */ AtomicBoolean f7516a;

        /* renamed from: b */
        public final /* synthetic */ CompositeDisposable f7517b;

        /* renamed from: c */
        public final /* synthetic */ SingleObserver f7518c;

        public C1683b(SingleTimeout singleTimeout, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, SingleObserver singleObserver) {
            this.f7516a = atomicBoolean;
            this.f7517b = compositeDisposable;
            this.f7518c = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            if (this.f7516a.compareAndSet(false, true)) {
                this.f7517b.mo578b();
                this.f7518c.mo3283a(th);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            if (this.f7516a.compareAndSet(false, true)) {
                this.f7517b.mo578b();
                this.f7518c.mo3282b(t);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7517b.mo3633c(disposable);
        }
    }
}
