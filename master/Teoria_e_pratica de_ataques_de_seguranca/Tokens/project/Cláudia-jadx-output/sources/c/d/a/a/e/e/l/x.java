package c.d.a.a.e.e.l;

import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public abstract class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ n f3441a;

    public x(n nVar) {
        this.f3441a = nVar;
    }

    public /* synthetic */ x(n nVar, o oVar) {
        this(nVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        Lock lock2;
        f0 f0Var;
        lock = this.f3441a.f3355b;
        lock.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    a();
                }
            } catch (RuntimeException e2) {
                f0Var = this.f3441a.f3354a;
                f0Var.a(e2);
            }
        } finally {
            lock2 = this.f3441a.f3355b;
            lock2.unlock();
        }
    }
}
