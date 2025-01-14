package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.TimeUnit;
import p136d.p153c.Scheduler;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.SequentialDisposable;

/* renamed from: d.c.f0.e.e.f */
/* loaded from: classes.dex */
public final class SingleDelay<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7425a;

    /* renamed from: b */
    public final long f7426b;

    /* renamed from: c */
    public final TimeUnit f7427c;

    /* renamed from: d */
    public final Scheduler f7428d;

    /* compiled from: SingleDelay.java */
    /* renamed from: d.c.f0.e.e.f$a */
    /* loaded from: classes.dex */
    public class C1663a implements SingleObserver<T> {

        /* renamed from: a */
        public final /* synthetic */ SequentialDisposable f7429a;

        /* renamed from: b */
        public final /* synthetic */ SingleObserver f7430b;

        /* compiled from: SingleDelay.java */
        /* renamed from: d.c.f0.e.e.f$a$a */
        /* loaded from: classes.dex */
        public class RunnableC1664a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Object f7432a;

            public RunnableC1664a(Object obj) {
                this.f7432a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                C1663a.this.f7430b.mo3282b(this.f7432a);
            }
        }

        /* compiled from: SingleDelay.java */
        /* renamed from: d.c.f0.e.e.f$a$b */
        /* loaded from: classes.dex */
        public class RunnableC1665b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Throwable f7434a;

            public RunnableC1665b(Throwable th) {
                this.f7434a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1663a.this.f7430b.mo3283a(this.f7434a);
            }
        }

        public C1663a(SequentialDisposable sequentialDisposable, SingleObserver singleObserver) {
            this.f7429a = sequentialDisposable;
            this.f7430b = singleObserver;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            this.f7429a.m3632a(disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            SequentialDisposable sequentialDisposable = this.f7429a;
            Scheduler scheduler = SingleDelay.this.f7428d;
            RunnableC1664a runnableC1664a = new RunnableC1664a(t);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.m3632a(scheduler.mo3290a(runnableC1664a, singleDelay.f7426b, singleDelay.f7427c));
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7429a.m3632a(SingleDelay.this.f7428d.mo3290a(new RunnableC1665b(th), 0L, SingleDelay.this.f7427c));
        }
    }

    public SingleDelay(SingleSource<? extends T> singleSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f7425a = singleSource;
        this.f7426b = j;
        this.f7427c = timeUnit;
        this.f7428d = scheduler;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.mo3284a(sequentialDisposable);
        this.f7425a.subscribe(new C1663a(sequentialDisposable, singleObserver));
    }
}
