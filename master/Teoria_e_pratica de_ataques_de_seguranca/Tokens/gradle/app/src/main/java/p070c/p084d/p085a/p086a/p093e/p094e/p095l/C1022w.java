package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Bundle;
import java.util.concurrent.locks.Lock;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.l.w */
/* loaded from: classes.dex */
public final class C1022w implements AbstractC0921d.InterfaceC0923b, AbstractC0921d.InterfaceC0924c {

    /* renamed from: a */
    public /* synthetic */ C0986n f5349a;

    public C1022w(C0986n c0986n) {
        this.f5349a = c0986n;
    }

    public /* synthetic */ C1022w(C0986n c0986n, RunnableC0990o runnableC0990o) {
        this(c0986n);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnected(Bundle bundle) {
        InterfaceC1199x0 interfaceC1199x0;
        interfaceC1199x0 = this.f5349a.f5257k;
        interfaceC1199x0.mo5005a(new BinderC1014u(this.f5349a));
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0924c
    public final void onConnectionFailed(C0900a c0900a) {
        Lock lock;
        Lock lock2;
        boolean m5431a;
        lock = this.f5349a.f5248b;
        lock.lock();
        try {
            m5431a = this.f5349a.m5431a(c0900a);
            if (m5431a) {
                this.f5349a.m5411g();
                this.f5349a.m5415e();
            } else {
                this.f5349a.m5422b(c0900a);
            }
        } finally {
            lock2 = this.f5349a.f5248b;
            lock2.unlock();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0923b
    public final void onConnectionSuspended(int i) {
    }
}
