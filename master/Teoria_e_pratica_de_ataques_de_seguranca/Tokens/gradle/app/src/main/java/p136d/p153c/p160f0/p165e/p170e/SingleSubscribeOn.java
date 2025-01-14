package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Scheduler;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p161a.SequentialDisposable;

/* renamed from: d.c.f0.e.e.l0 */
/* loaded from: classes.dex */
public final class SingleSubscribeOn<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<? extends T> f7487a;

    /* renamed from: b */
    public final Scheduler f7488b;

    /* compiled from: SingleSubscribeOn.java */
    /* renamed from: d.c.f0.e.e.l0$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1676a<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7489a;

        /* renamed from: b */
        public final SequentialDisposable f7490b = new SequentialDisposable();

        /* renamed from: c */
        public final SingleSource<? extends T> f7491c;

        public RunnableC1676a(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f7489a = singleObserver;
            this.f7491c = singleSource;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            DisposableHelper.m3644c(this, disposable);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7489a.mo3282b(t);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7491c.subscribe(this);
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7489a.mo3283a(th);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
            this.f7490b.mo578b();
        }
    }

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.f7487a = singleSource;
        this.f7488b = scheduler;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        RunnableC1676a runnableC1676a = new RunnableC1676a(singleObserver, this.f7487a);
        singleObserver.mo3284a(runnableC1676a);
        runnableC1676a.f7490b.m3632a(this.f7488b.mo3292a(runnableC1676a));
    }
}
