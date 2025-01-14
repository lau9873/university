package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.lang.ref.WeakReference;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0925e;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0931j;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;

/* renamed from: c.d.a.a.e.e.l.w1 */
/* loaded from: classes.dex */
public final class RunnableC1024w1 implements Runnable {

    /* renamed from: a */
    public /* synthetic */ InterfaceC0928g f5351a;

    /* renamed from: b */
    public /* synthetic */ C1020v1 f5352b;

    public RunnableC1024w1(C1020v1 c1020v1, InterfaceC0928g interfaceC0928g) {
        this.f5352b = c1020v1;
        this.f5351a = interfaceC0928g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        HandlerC1028x1 handlerC1028x1;
        HandlerC1028x1 handlerC1028x12;
        WeakReference weakReference2;
        AbstractC0931j abstractC0931j;
        HandlerC1028x1 handlerC1028x13;
        HandlerC1028x1 handlerC1028x14;
        WeakReference weakReference3;
        try {
            try {
                BasePendingResult.f6114p.set(true);
                abstractC0931j = this.f5352b.f5342a;
                AbstractC0925e m5584a = abstractC0931j.m5584a((AbstractC0931j) this.f5351a);
                handlerC1028x13 = this.f5352b.f5348g;
                handlerC1028x14 = this.f5352b.f5348g;
                handlerC1028x13.sendMessage(handlerC1028x14.obtainMessage(0, m5584a));
                BasePendingResult.f6114p.set(false);
                C1020v1 c1020v1 = this.f5352b;
                C1020v1.m5341a(this.f5351a);
                weakReference3 = this.f5352b.f5347f;
                AbstractC0921d abstractC0921d = (AbstractC0921d) weakReference3.get();
                if (abstractC0921d != null) {
                    abstractC0921d.mo5370a(this.f5352b);
                }
            } catch (RuntimeException e) {
                handlerC1028x1 = this.f5352b.f5348g;
                handlerC1028x12 = this.f5352b.f5348g;
                handlerC1028x1.sendMessage(handlerC1028x12.obtainMessage(1, e));
                BasePendingResult.f6114p.set(false);
                C1020v1 c1020v12 = this.f5352b;
                C1020v1.m5341a(this.f5351a);
                weakReference2 = this.f5352b.f5347f;
                AbstractC0921d abstractC0921d2 = (AbstractC0921d) weakReference2.get();
                if (abstractC0921d2 != null) {
                    abstractC0921d2.mo5370a(this.f5352b);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.f6114p.set(false);
            C1020v1 c1020v13 = this.f5352b;
            C1020v1.m5341a(this.f5351a);
            weakReference = this.f5352b.f5347f;
            AbstractC0921d abstractC0921d3 = (AbstractC0921d) weakReference.get();
            if (abstractC0921d3 != null) {
                abstractC0921d3.mo5370a(this.f5352b);
            }
            throw th;
        }
    }
}
