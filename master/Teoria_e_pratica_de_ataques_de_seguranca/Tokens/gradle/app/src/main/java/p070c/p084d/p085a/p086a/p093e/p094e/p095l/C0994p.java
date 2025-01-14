package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1072n0;

/* renamed from: c.d.a.a.e.e.l.p */
/* loaded from: classes.dex */
public final class C0994p implements InterfaceC1072n0 {

    /* renamed from: a */
    public final WeakReference<C0986n> f5287a;

    /* renamed from: b */
    public final C0905a<?> f5288b;

    /* renamed from: c */
    public final boolean f5289c;

    public C0994p(C0986n c0986n, C0905a<?> c0905a, boolean z) {
        this.f5287a = new WeakReference<>(c0986n);
        this.f5288b = c0905a;
        this.f5289c = z;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1072n0
    /* renamed from: a */
    public final void mo5188a(C0900a c0900a) {
        C0954f0 c0954f0;
        Lock lock;
        Lock lock2;
        boolean m5432a;
        boolean m5417d;
        C0986n c0986n = this.f5287a.get();
        if (c0986n == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        c0954f0 = c0986n.f5247a;
        C1049c0.m5285b(myLooper == c0954f0.f5172m.mo5369c(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = c0986n.f5248b;
        lock.lock();
        try {
            m5432a = c0986n.m5432a(0);
            if (m5432a) {
                if (!c0900a.m5641f()) {
                    c0986n.m5421b(c0900a, this.f5288b, this.f5289c);
                }
                m5417d = c0986n.m5417d();
                if (m5417d) {
                    c0986n.m5415e();
                }
            }
        } finally {
            lock2 = c0986n.f5248b;
            lock2.unlock();
        }
    }
}
