package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Scheduler;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.SingleSource;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.e.i0 */
/* loaded from: classes.dex */
public final class SingleObserveOn<T> extends Single<T> {

    /* renamed from: a */
    public final SingleSource<T> f7458a;

    /* renamed from: b */
    public final Scheduler f7459b;

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f7458a = singleSource;
        this.f7459b = scheduler;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f7458a.subscribe(new RunnableC1670a(singleObserver, this.f7459b));
    }

    /* compiled from: SingleObserveOn.java */
    /* renamed from: d.c.f0.e.e.i0$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1670a<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {

        /* renamed from: a */
        public final SingleObserver<? super T> f7460a;

        /* renamed from: b */
        public final Scheduler f7461b;

        /* renamed from: c */
        public T f7462c;

        /* renamed from: d */
        public Throwable f7463d;

        public RunnableC1670a(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f7460a = singleObserver;
            this.f7461b = scheduler;
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3284a(Disposable disposable) {
            if (DisposableHelper.m3644c(this, disposable)) {
                this.f7460a.mo3284a(this);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: b */
        public void mo3282b(T t) {
            this.f7462c = t;
            DisposableHelper.m3646a((AtomicReference<Disposable>) this, this.f7461b.mo3292a(this));
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f7463d;
            if (th != null) {
                this.f7460a.mo3283a(th);
            } else {
                this.f7460a.mo3282b((T) this.f7462c);
            }
        }

        @Override // p136d.p153c.SingleObserver
        /* renamed from: a */
        public void mo3283a(Throwable th) {
            this.f7463d = th;
            DisposableHelper.m3646a((AtomicReference<Disposable>) this, this.f7461b.mo3292a(this));
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }
    }
}
