package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import com.google.android.gms.common.api.GoogleApiActivity;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C0902c;

/* renamed from: c.d.a.a.e.e.l.p2 */
/* loaded from: classes.dex */
public final class RunnableC0997p2 implements Runnable {

    /* renamed from: a */
    public final C0993o2 f5293a;

    /* renamed from: b */
    public final /* synthetic */ AbstractDialogInterface$OnCancelListenerC0989n2 f5294b;

    public RunnableC0997p2(AbstractDialogInterface$OnCancelListenerC0989n2 abstractDialogInterface$OnCancelListenerC0989n2, C0993o2 c0993o2) {
        this.f5294b = abstractDialogInterface$OnCancelListenerC0989n2;
        this.f5293a = c0993o2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5294b.f5277b) {
            C0900a m5392b = this.f5293a.m5392b();
            if (m5392b.m5642e()) {
                AbstractDialogInterface$OnCancelListenerC0989n2 abstractDialogInterface$OnCancelListenerC0989n2 = this.f5294b;
                abstractDialogInterface$OnCancelListenerC0989n2.f6131a.startActivityForResult(GoogleApiActivity.m4375a(abstractDialogInterface$OnCancelListenerC0989n2.m4351a(), m5392b.m5643d(), this.f5293a.m5393a(), false), 1);
            } else if (this.f5294b.f5280e.mo5117b(m5392b.m5645b())) {
                AbstractDialogInterface$OnCancelListenerC0989n2 abstractDialogInterface$OnCancelListenerC0989n22 = this.f5294b;
                abstractDialogInterface$OnCancelListenerC0989n22.f5280e.m5636a(abstractDialogInterface$OnCancelListenerC0989n22.m4351a(), this.f5294b.f6131a, m5392b.m5645b(), 2, this.f5294b);
            } else if (m5392b.m5645b() != 18) {
                this.f5294b.mo5398a(m5392b, this.f5293a.m5393a());
            } else {
                C0902c.m5630a(this.f5294b.m4351a().getApplicationContext(), new C1001q2(this, C0902c.m5637a(this.f5294b.m4351a(), this.f5294b)));
            }
        }
    }
}
