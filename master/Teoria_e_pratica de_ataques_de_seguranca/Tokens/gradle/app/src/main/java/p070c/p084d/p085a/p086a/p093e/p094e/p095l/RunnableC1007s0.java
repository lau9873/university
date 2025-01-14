package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import java.util.Collections;
import java.util.Map;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;

/* renamed from: c.d.a.a.e.e.l.s0 */
/* loaded from: classes.dex */
public final class RunnableC1007s0 implements Runnable {

    /* renamed from: a */
    public /* synthetic */ C0900a f5309a;

    /* renamed from: b */
    public /* synthetic */ C1003r0 f5310b;

    public RunnableC1007s0(C1003r0 c1003r0, C0900a c0900a) {
        this.f5310b = c1003r0;
        this.f5309a = c0900a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        C0960g2 c0960g2;
        C0905a.InterfaceC0916f interfaceC0916f;
        C0905a.InterfaceC0916f interfaceC0916f2;
        if (!this.f5309a.m5641f()) {
            map = this.f5310b.f5307f.f5214i;
            c0960g2 = this.f5310b.f5303b;
            ((C0979l0) map.get(c0960g2)).onConnectionFailed(this.f5309a);
            return;
        }
        this.f5310b.f5306e = true;
        interfaceC0916f = this.f5310b.f5302a;
        if (interfaceC0916f.mo5043e()) {
            this.f5310b.m5389a();
            return;
        }
        interfaceC0916f2 = this.f5310b.f5302a;
        interfaceC0916f2.m5613a(null, Collections.emptySet());
    }
}
