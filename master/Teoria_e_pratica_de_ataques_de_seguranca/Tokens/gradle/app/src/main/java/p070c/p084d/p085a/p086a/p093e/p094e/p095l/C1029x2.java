package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Bundle;
import java.util.concurrent.locks.Lock;
import p070c.p084d.p085a.p086a.p093e.C0900a;

/* renamed from: c.d.a.a.e.e.l.x2 */
/* loaded from: classes.dex */
public final class C1029x2 implements InterfaceC1031y0 {

    /* renamed from: a */
    public /* synthetic */ C1017u2 f5355a;

    public C1029x2(C1017u2 c1017u2) {
        this.f5355a = c1017u2;
    }

    public /* synthetic */ C1029x2(C1017u2 c1017u2, RunnableC1021v2 runnableC1021v2) {
        this(c1017u2);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5320a(int i, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        C0954f0 c0954f0;
        lock = this.f5355a.f5338l;
        lock.lock();
        try {
            z2 = this.f5355a.f5337k;
            if (z2) {
                this.f5355a.f5337k = false;
                this.f5355a.m5365a(i, z);
            } else {
                this.f5355a.f5337k = true;
                c0954f0 = this.f5355a.f5329c;
                c0954f0.onConnectionSuspended(i);
            }
        } finally {
            lock2 = this.f5355a.f5338l;
            lock2.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5319a(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.f5355a.f5338l;
        lock.lock();
        try {
            this.f5355a.f5336j = C0900a.f5050e;
            this.f5355a.m5350e();
        } finally {
            lock2 = this.f5355a.f5338l;
            lock2.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC1031y0
    /* renamed from: a */
    public final void mo5318a(C0900a c0900a) {
        Lock lock;
        Lock lock2;
        lock = this.f5355a.f5338l;
        lock.lock();
        try {
            this.f5355a.f5336j = c0900a;
            this.f5355a.m5350e();
        } finally {
            lock2 = this.f5355a.f5338l;
            lock2.unlock();
        }
    }
}
