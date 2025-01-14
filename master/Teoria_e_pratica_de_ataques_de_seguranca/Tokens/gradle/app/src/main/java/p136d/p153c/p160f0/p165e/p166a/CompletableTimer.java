package p136d.p153c.p160f0.p165e.p166a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Completable;
import p136d.p153c.CompletableObserver;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.a.j0 */
/* loaded from: classes.dex */
public final class CompletableTimer extends Completable {

    /* renamed from: a */
    public final long f7028a;

    /* renamed from: b */
    public final TimeUnit f7029b;

    /* renamed from: c */
    public final Scheduler f7030c;

    /* compiled from: CompletableTimer.java */
    /* renamed from: d.c.f0.e.a.j0$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1585a extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: a */
        public final CompletableObserver f7031a;

        public RunnableC1585a(CompletableObserver completableObserver) {
            this.f7031a = completableObserver;
        }

        /* renamed from: a */
        public void m3576a(Disposable disposable) {
            DisposableHelper.m3646a((AtomicReference<Disposable>) this, disposable);
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
            this.f7031a.mo3489a();
        }
    }

    public CompletableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f7028a = j;
        this.f7029b = timeUnit;
        this.f7030c = scheduler;
    }

    @Override // p136d.p153c.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        RunnableC1585a runnableC1585a = new RunnableC1585a(completableObserver);
        completableObserver.mo3502a(runnableC1585a);
        runnableC1585a.m3576a(this.f7030c.mo3290a(runnableC1585a, this.f7028a, this.f7029b));
    }
}
