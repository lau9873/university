package p136d.p153c.p160f0.p165e.p170e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.Scheduler;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.e.o0 */
/* loaded from: classes.dex */
public final class SingleTimer extends Single<Long> {

    /* renamed from: a */
    public final long f7523a;

    /* renamed from: b */
    public final TimeUnit f7524b;

    /* renamed from: c */
    public final Scheduler f7525c;

    /* compiled from: SingleTimer.java */
    /* renamed from: d.c.f0.e.e.o0$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1685a extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: a */
        public final SingleObserver<? super Long> f7526a;

        public RunnableC1685a(SingleObserver<? super Long> singleObserver) {
            this.f7526a = singleObserver;
        }

        /* renamed from: a */
        public void m3496a(Disposable disposable) {
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
            this.f7526a.mo3282b(0L);
        }
    }

    public SingleTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f7523a = j;
        this.f7524b = timeUnit;
        this.f7525c = scheduler;
    }

    @Override // p136d.p153c.Single
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        RunnableC1685a runnableC1685a = new RunnableC1685a(singleObserver);
        singleObserver.mo3284a(runnableC1685a);
        runnableC1685a.m3496a(this.f7525c.mo3290a(runnableC1685a, this.f7523a, this.f7524b));
    }
}
