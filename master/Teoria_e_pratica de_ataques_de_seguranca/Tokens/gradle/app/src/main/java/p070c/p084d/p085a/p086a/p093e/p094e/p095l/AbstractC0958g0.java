package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import java.util.concurrent.locks.Lock;

/* renamed from: c.d.a.a.e.e.l.g0 */
/* loaded from: classes.dex */
public abstract class AbstractC0958g0 {

    /* renamed from: a */
    public final InterfaceC0950e0 f5178a;

    public AbstractC0958g0(InterfaceC0950e0 interfaceC0950e0) {
        this.f5178a = interfaceC0950e0;
    }

    /* renamed from: a */
    public abstract void mo5344a();

    /* renamed from: a */
    public final void m5521a(C0954f0 c0954f0) {
        Lock lock;
        Lock lock2;
        InterfaceC0950e0 interfaceC0950e0;
        lock = c0954f0.f5160a;
        lock.lock();
        try {
            interfaceC0950e0 = c0954f0.f5170k;
            if (interfaceC0950e0 == this.f5178a) {
                mo5344a();
            }
        } finally {
            lock2 = c0954f0.f5160a;
            lock2.unlock();
        }
    }
}
