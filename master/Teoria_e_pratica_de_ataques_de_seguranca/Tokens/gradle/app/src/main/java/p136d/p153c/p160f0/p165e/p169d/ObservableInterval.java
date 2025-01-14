package p136d.p153c.p160f0.p165e.p169d;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p136d.p153c.InterfaceC1730s;
import p136d.p153c.Observable;
import p136d.p153c.Scheduler;
import p136d.p153c.p157c0.Disposable;
import p136d.p153c.p160f0.p161a.DisposableHelper;

/* renamed from: d.c.f0.e.d.k */
/* loaded from: classes.dex */
public final class ObservableInterval extends Observable<Long> {

    /* renamed from: a */
    public final Scheduler f7360a;

    /* renamed from: b */
    public final long f7361b;

    /* renamed from: c */
    public final long f7362c;

    /* renamed from: d */
    public final TimeUnit f7363d;

    /* compiled from: ObservableInterval.java */
    /* renamed from: d.c.f0.e.d.k$a */
    /* loaded from: classes.dex */
    public static final class RunnableC1647a extends AtomicReference<Disposable> implements Disposable, Runnable {

        /* renamed from: a */
        public final InterfaceC1730s<? super Long> f7364a;

        /* renamed from: b */
        public long f7365b;

        public RunnableC1647a(InterfaceC1730s<? super Long> interfaceC1730s) {
            this.f7364a = interfaceC1730s;
        }

        /* renamed from: a */
        public void m3515a(Disposable disposable) {
            DisposableHelper.m3644c(this, disposable);
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
            if (get() != DisposableHelper.DISPOSED) {
                InterfaceC1730s<? super Long> interfaceC1730s = this.f7364a;
                long j = this.f7365b;
                this.f7365b = 1 + j;
                interfaceC1730s.mo570a((InterfaceC1730s<? super Long>) Long.valueOf(j));
            }
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f7361b = j;
        this.f7362c = j2;
        this.f7363d = timeUnit;
        this.f7360a = scheduler;
    }

    @Override // p136d.p153c.Observable
    /* renamed from: b */
    public void mo574b(InterfaceC1730s<? super Long> interfaceC1730s) {
        RunnableC1647a runnableC1647a = new RunnableC1647a(interfaceC1730s);
        interfaceC1730s.mo572a((Disposable) runnableC1647a);
        runnableC1647a.m3515a(this.f7360a.mo3291a(runnableC1647a, this.f7361b, this.f7362c, this.f7363d));
    }
}
