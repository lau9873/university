package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p161a.SequentialDisposable;

/* renamed from: d.c.f0.e.a.h0 */
/* loaded from: classes.dex */
public final class CompletableSubscribeOn extends Completable {

    /* renamed from: a */
    public final CompletableSource f6999a;

    /* renamed from: b */
    public final Scheduler f7000b;

    /* compiled from: CompletableSubscribeOn.java */
    /* renamed from: d.c.f0.e.a.h0$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1579a extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {

        /* renamed from: a */
        public final CompletableObserver f7001a;

        /* renamed from: b */
        public final SequentialDisposable f7002b = new SequentialDisposable();

        /* renamed from: c */
        public final CompletableSource f7003c;

        public RunnableC1579a(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f7001a = completableObserver;
            this.f7003c = completableSource;
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
            this.f7002b.mo578b();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return DisposableHelper.m3649a(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7003c.subscribe(this);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            this.f7001a.mo3501a(th);
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            this.f7001a.mo3489a();
        }
    }

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f6999a = completableSource;
        this.f7000b = scheduler;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        RunnableC1579a runnableC1579a = new RunnableC1579a(completableObserver, this.f6999a);
        completableObserver.mo3502a(runnableC1579a);
        runnableC1579a.f7002b.m3632a(this.f7000b.mo3292a(runnableC1579a));
    }
}
