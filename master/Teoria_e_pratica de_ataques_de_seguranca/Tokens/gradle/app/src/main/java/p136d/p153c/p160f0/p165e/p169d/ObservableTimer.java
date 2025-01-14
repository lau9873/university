package p136d.p153c.p160f0.p165e.p169d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;
import p136d.p153c.p160f0.p161a.EmptyDisposable;

/* renamed from: d.c.f0.e.d.q */
/* loaded from: classes.dex */
public final class ObservableTimer extends Observable<Long> {

    /* renamed from: a */
    public final Scheduler f7383a;

    /* renamed from: b */
    public final long f7384b;

    /* renamed from: c */
    public final TimeUnit f7385c;

    /* compiled from: ObservableTimer.java */
    /* renamed from: d.c.f0.e.d.q$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1653a extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: a */
        public final InterfaceC1730s<? super Long> f7386a;

        public RunnableC1653a(InterfaceC1730s<? super Long> interfaceC1730s) {
            this.f7386a = interfaceC1730s;
        }

        /* renamed from: a */
        public void m3511a(Disposable disposable) {
            DisposableHelper.m3642d(this, disposable);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: b */
        public void mo578b() {
            DisposableHelper.m3647a((AtomicReference<Disposable>) this);
        }

        @Override // p136d.p153c.p157c0.Disposable
        /* renamed from: c */
        public boolean mo577c() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mo577c()) {
                return;
            }
            this.f7386a.mo570a((InterfaceC1730s<? super Long>) 0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.f7386a.mo573a();
        }
    }

    public ObservableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f7384b = j;
        this.f7385c = timeUnit;
        this.f7383a = scheduler;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super Long> interfaceC1730s) {
        RunnableC1653a runnableC1653a = new RunnableC1653a(interfaceC1730s);
        interfaceC1730s.mo572a((Disposable) runnableC1653a);
        runnableC1653a.m3511a(this.f7383a.mo3290a(runnableC1653a, this.f7384b, this.f7385c));
    }
}
