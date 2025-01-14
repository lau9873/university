package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import java.util.concurrent.locks.Lock;

/* renamed from: c.d.a.a.e.e.l.x */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1026x implements Runnable {

    /* renamed from: a */
    public /* synthetic */ C0986n f5354a;

    public AbstractRunnableC1026x(C0986n c0986n) {
        this.f5354a = c0986n;
    }

    public /* synthetic */ AbstractRunnableC1026x(C0986n c0986n, RunnableC0990o runnableC0990o) {
        this(c0986n);
    }

    /* renamed from: a */
    public abstract void mo5332a();

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        Lock lock2;
        C0954f0 c0954f0;
        lock = this.f5354a.f5248b;
        lock.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    mo5332a();
                }
            } catch (RuntimeException e) {
                c0954f0 = this.f5354a.f5247a;
                c0954f0.m5526a(e);
            }
        } finally {
            lock2 = this.f5354a.f5248b;
            lock2.unlock();
        }
    }
}
