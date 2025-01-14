package c.d.a.a.e.e.l;

import android.os.Bundle;
import c.d.a.a.e.e.d;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class w implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ n f3436a;

    public w(n nVar) {
        this.f3436a = nVar;
    }

    public /* synthetic */ w(n nVar, o oVar) {
        this(nVar);
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnected(Bundle bundle) {
        c.d.a.a.h.x0 x0Var;
        x0Var = this.f3436a.k;
        x0Var.a(new u(this.f3436a));
    }

    @Override // c.d.a.a.e.e.d.c
    public final void onConnectionFailed(c.d.a.a.e.a aVar) {
        Lock lock;
        Lock lock2;
        boolean a2;
        lock = this.f3436a.f3355b;
        lock.lock();
        try {
            a2 = this.f3436a.a(aVar);
            if (a2) {
                this.f3436a.g();
                this.f3436a.e();
            } else {
                this.f3436a.b(aVar);
            }
        } finally {
            lock2 = this.f3436a.f3355b;
            lock2.unlock();
        }
    }

    @Override // c.d.a.a.e.e.d.b
    public final void onConnectionSuspended(int i2) {
    }
}
