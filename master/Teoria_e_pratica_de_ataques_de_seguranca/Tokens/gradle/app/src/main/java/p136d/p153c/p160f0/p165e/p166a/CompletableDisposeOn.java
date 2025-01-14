package p136d.p153c.p160f0.p165e.p166a;

import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.CompletableSource;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p177h0.RxJavaPlugins;

/* renamed from: d.c.f0.e.a.i */
/* loaded from: classes.dex */
public final class CompletableDisposeOn extends Completable {

    /* renamed from: a */
    public final CompletableSource f7004a;

    /* renamed from: b */
    public final Scheduler f7005b;

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f7004a = completableSource;
        this.f7005b = scheduler;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f7004a.subscribe(new RunnableC1580a(completableObserver, this.f7005b));
    }

    /* compiled from: CompletableDisposeOn.java */
    /* renamed from: d.c.f0.e.a.i$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1580a implements CompletableObserver, Disposable, Runnable {

        /* renamed from: a */
        public final CompletableObserver f7006a;

        /* renamed from: b */
        public final Scheduler f7007b;

        /* renamed from: c */
        public Disposable f7008c;

        /* renamed from: d */
        public volatile boolean f7009d;

        public RunnableC1580a(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f7006a = completableObserver;
            this.f7007b = scheduler;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3489a() {
            if (this.f7009d) {
                return;
            }
            this.f7006a.mo3489a();
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            this.f7009d = true;
            this.f7007b.mo3292a(this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return this.f7009d;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7008c.mo578b();
            this.f7008c = DisposableHelper.DISPOSED;
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3501a(Throwable th) {
            if (this.f7009d) {
                RxJavaPlugins.m3371b(th);
            } else {
                this.f7006a.mo3501a(th);
            }
        }

        @Override // p136d.p153c.CompletableObserver
        /* renamed from: a */
        public void mo3502a(Disposable disposable) {
            if (DisposableHelper.m3648a(this.f7008c, disposable)) {
                this.f7008c = disposable;
                this.f7006a.mo3502a(this);
            }
        }
    }
}
