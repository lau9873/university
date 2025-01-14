package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.a.d0 */
/* loaded from: classes.dex */
public final class CompletableObserveOn extends Completable {

    /* renamed from: a */
    public final CompletableSource f6956a;

    /* renamed from: b */
    public final Scheduler f6957b;

    public CompletableObserveOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f6956a = completableSource;
        this.f6957b = scheduler;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f6956a.subscribe(new RunnableC1568a(completableObserver, this.f6957b));
    }

    /* compiled from: CompletableObserveOn.java */
    /* renamed from: d.c.f0.e.a.d0$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1568a extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {

        /* renamed from: a */
        public final CompletableObserver f6958a;

        /* renamed from: b */
        public final Scheduler f6959b;

        /* renamed from: c */
        public Throwable f6960c;

        public RunnableC1568a(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f6958a = completableObserver;
            this.f6959b = scheduler;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            if (DisposableHelper.m3644c(this, disposable)) {
                this.f6958a.mo3502a(this);
            }
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

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f6960c;
            if (th != null) {
                this.f6960c = null;
                this.f6958a.mo3501a(th);
                return;
            }
            this.f6958a.mo3489a();
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f6960c = th;
            DisposableHelper.m3646a((AtomicReference<Disposable>) this, this.f6959b.mo3292a(this));
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            DisposableHelper.m3646a((AtomicReference<Disposable>) this, this.f6959b.mo3292a(this));
        }
    }
}
