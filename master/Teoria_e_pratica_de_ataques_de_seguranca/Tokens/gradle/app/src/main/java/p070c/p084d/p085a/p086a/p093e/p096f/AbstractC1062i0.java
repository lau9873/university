package p070c.p084d.p085a.p086a.p093e.p096f;

import android.app.PendingIntent;
import android.os.Bundle;
import p070c.p084d.p085a.p086a.p093e.C0900a;

/* renamed from: c.d.a.a.e.f.i0 */
/* loaded from: classes.dex */
public abstract class AbstractC1062i0 extends AbstractC1070m0<Boolean> {

    /* renamed from: d */
    public int f5440d;

    /* renamed from: e */
    public Bundle f5441e;

    /* renamed from: f */
    public /* synthetic */ AbstractC1060h0 f5442f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1062i0(AbstractC1060h0 abstractC1060h0, int i, Bundle bundle) {
        super(abstractC1060h0, true);
        this.f5442f = abstractC1060h0;
        this.f5440d = i;
        this.f5441e = bundle;
    }

    /* renamed from: a */
    public abstract void mo5187a(C0900a c0900a);

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1070m0
    /* renamed from: a */
    public final /* synthetic */ void mo5193a(Boolean bool) {
        if (bool == null) {
            this.f5442f.m5264a(1, (int) null);
            return;
        }
        int i = this.f5440d;
        if (i == 0) {
            if (mo5186e()) {
                return;
            }
            this.f5442f.m5264a(1, (int) null);
            mo5187a(new C0900a(8, null));
        } else if (i == 10) {
            this.f5442f.m5264a(1, (int) null);
            throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
        } else {
            this.f5442f.m5264a(1, (int) null);
            Bundle bundle = this.f5441e;
            mo5187a(new C0900a(this.f5440d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1070m0
    /* renamed from: c */
    public final void mo5191c() {
    }

    /* renamed from: e */
    public abstract boolean mo5186e();
}
