package c.d.a.a.e.e.l;

import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public abstract class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f3298a;

    public g0(e0 e0Var) {
        this.f3298a = e0Var;
    }

    public abstract void a();

    public final void a(f0 f0Var) {
        Lock lock;
        Lock lock2;
        e0 e0Var;
        lock = f0Var.f3285a;
        lock.lock();
        try {
            e0Var = f0Var.k;
            if (e0Var == this.f3298a) {
                a();
            }
        } finally {
            lock2 = f0Var.f3285a;
            lock2.unlock();
        }
    }
}
