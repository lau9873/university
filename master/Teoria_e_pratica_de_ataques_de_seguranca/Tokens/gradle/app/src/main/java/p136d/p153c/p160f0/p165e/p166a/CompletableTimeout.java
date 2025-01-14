package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.i0 */
/* loaded from: classes.dex */
public final class CompletableTimeout extends Completable {

    /* renamed from: a */
    public final CompletableSource f7010a;

    /* renamed from: b */
    public final long f7011b;

    /* renamed from: c */
    public final TimeUnit f7012c;

    /* renamed from: d */
    public final Scheduler f7013d;

    /* renamed from: e */
    public final CompletableSource f7014e;

    /* compiled from: CompletableTimeout.java */
    /* renamed from: d.c.f0.e.a.i0$a */
    /* loaded from: classes.dex */
    public class RunnableC1581a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AtomicBoolean f7015a;

        /* renamed from: b */
        public final /* synthetic */ CompositeDisposable f7016b;

        /* renamed from: c */
        public final /* synthetic */ CompletableObserver f7017c;

        /* compiled from: CompletableTimeout.java */
        /* renamed from: d.c.f0.e.a.i0$a$a */
        /* loaded from: classes.dex */
        public class C1582a implements CompletableObserver {
            public C1582a() {
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3502a(Disposable disposable) {
                RunnableC1581a.this.f7016b.mo3633c(disposable);
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3501a(Throwable th) {
                RunnableC1581a.this.f7016b.mo578b();
                RunnableC1581a.this.f7017c.mo3501a(th);
            }

            @Override // p136d.p153c.CompletableObserver
            /* renamed from: a */
            public void mo3489a() {
                RunnableC1581a.this.f7016b.mo578b();
                RunnableC1581a.this.f7017c.mo3489a();
            }
        }

        public RunnableC1581a(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f7015a = atomicBoolean;
            this.f7016b = compositeDisposable;
            this.f7017c = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7015a.compareAndSet(false, true)) {
                this.f7016b.m3670a();
                CompletableSource completableSource = CompletableTimeout.this.f7014e;
                if (completableSource == null) {
                    this.f7017c.mo3501a(new TimeoutException());
                } else {
                    completableSource.subscribe(new C1582a());
                }
            }
        }
    }

    /* compiled from: CompletableTimeout.java */
    /* renamed from: d.c.f0.e.a.i0$b */
    /* loaded from: classes.dex */
    public class C1583b implements CompletableObserver {

        /* renamed from: a */
        public final /* synthetic */ CompositeDisposable f7020a;

        /* renamed from: b */
        public final /* synthetic */ AtomicBoolean f7021b;

        /* renamed from: c */
        public final /* synthetic */ CompletableObserver f7022c;

        public C1583b(CompletableTimeout completableTimeout, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.f7020a = compositeDisposable;
            this.f7021b = atomicBoolean;
            this.f7022c = completableObserver;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f7020a.mo3633c(disposable);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            if (this.f7021b.compareAndSet(false, true)) {
                this.f7020a.mo578b();
                this.f7022c.mo3501a(th);
                return;
            }
            RxJavaPlugins.m3371b(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            if (this.f7021b.compareAndSet(false, true)) {
                this.f7020a.mo578b();
                this.f7022c.mo3489a();
            }
        }
    }

    public CompletableTimeout(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.f7010a = completableSource;
        this.f7011b = j;
        this.f7012c = timeUnit;
        this.f7013d = scheduler;
        this.f7014e = completableSource2;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.mo3502a(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.mo3633c(this.f7013d.mo3290a(new RunnableC1581a(atomicBoolean, compositeDisposable, completableObserver), this.f7011b, this.f7012c));
        this.f7010a.subscribe(new C1583b(this, compositeDisposable, atomicBoolean, completableObserver));
    }
}
