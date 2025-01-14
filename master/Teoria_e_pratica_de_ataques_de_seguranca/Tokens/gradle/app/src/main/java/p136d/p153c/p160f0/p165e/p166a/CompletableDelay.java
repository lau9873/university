package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.TimeUnit;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.CompositeDisposable;
import p136d.p153c.p157c0.Disposable;

/* renamed from: d.c.f0.e.a.h */
/* loaded from: classes.dex */
public final class CompletableDelay extends Completable {

    /* renamed from: a */
    public final CompletableSource f6988a;

    /* renamed from: b */
    public final long f6989b;

    /* renamed from: c */
    public final TimeUnit f6990c;

    /* renamed from: d */
    public final Scheduler f6991d;

    /* renamed from: e */
    public final boolean f6992e;

    /* compiled from: CompletableDelay.java */
    /* renamed from: d.c.f0.e.a.h$a */
    /* loaded from: classes.dex */
    public class C1576a implements CompletableObserver {

        /* renamed from: a */
        public final /* synthetic */ CompositeDisposable f6993a;

        /* renamed from: b */
        public final /* synthetic */ CompletableObserver f6994b;

        /* compiled from: CompletableDelay.java */
        /* renamed from: d.c.f0.e.a.h$a$a */
        /* loaded from: classes.dex */
        public class RunnableC1577a implements Runnable {
            public RunnableC1577a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1576a.this.f6994b.mo3489a();
            }
        }

        /* compiled from: CompletableDelay.java */
        /* renamed from: d.c.f0.e.a.h$a$b */
        /* loaded from: classes.dex */
        public class RunnableC1578b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Throwable f6997a;

            public RunnableC1578b(Throwable th) {
                this.f6997a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1576a.this.f6994b.mo3501a(this.f6997a);
            }
        }

        public C1576a(CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f6993a = compositeDisposable;
            this.f6994b = completableObserver;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            CompositeDisposable compositeDisposable = this.f6993a;
            Scheduler scheduler = CompletableDelay.this.f6991d;
            RunnableC1577a runnableC1577a = new RunnableC1577a();
            CompletableDelay completableDelay = CompletableDelay.this;
            compositeDisposable.mo3633c(scheduler.mo3290a(runnableC1577a, completableDelay.f6989b, completableDelay.f6990c));
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            CompositeDisposable compositeDisposable = this.f6993a;
            Scheduler scheduler = CompletableDelay.this.f6991d;
            RunnableC1578b runnableC1578b = new RunnableC1578b(th);
            CompletableDelay completableDelay = CompletableDelay.this;
            compositeDisposable.mo3633c(scheduler.mo3290a(runnableC1578b, completableDelay.f6992e ? completableDelay.f6989b : 0L, CompletableDelay.this.f6990c));
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            this.f6993a.mo3633c(disposable);
            this.f6994b.mo3502a(this.f6993a);
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.f6988a = completableSource;
        this.f6989b = j;
        this.f6990c = timeUnit;
        this.f6991d = scheduler;
        this.f6992e = z;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f6988a.subscribe(new C1576a(new CompositeDisposable(), completableObserver));
    }
}
