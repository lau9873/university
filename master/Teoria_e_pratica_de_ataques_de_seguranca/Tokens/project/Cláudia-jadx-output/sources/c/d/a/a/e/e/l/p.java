package c.d.a.a.e.e.l;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class p implements c.d.a.a.e.f.n0 {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<n> f3382a;

    /* renamed from: b  reason: collision with root package name */
    public final c.d.a.a.e.e.a<?> f3383b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3384c;

    public p(n nVar, c.d.a.a.e.e.a<?> aVar, boolean z) {
        this.f3382a = new WeakReference<>(nVar);
        this.f3383b = aVar;
        this.f3384c = z;
    }

    @Override // c.d.a.a.e.f.n0
    public final void a(c.d.a.a.e.a aVar) {
        f0 f0Var;
        Lock lock;
        Lock lock2;
        boolean a2;
        boolean d2;
        n nVar = this.f3382a.get();
        if (nVar == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        f0Var = nVar.f3354a;
        c.d.a.a.e.f.c0.b(myLooper == f0Var.m.c(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = nVar.f3355b;
        lock.lock();
        try {
            a2 = nVar.a(0);
            if (a2) {
                if (!aVar.f()) {
                    nVar.b(aVar, this.f3383b, this.f3384c);
                }
                d2 = nVar.d();
                if (d2) {
                    nVar.e();
                }
            }
        } finally {
            lock2 = nVar.f3355b;
            lock2.unlock();
        }
    }
}
