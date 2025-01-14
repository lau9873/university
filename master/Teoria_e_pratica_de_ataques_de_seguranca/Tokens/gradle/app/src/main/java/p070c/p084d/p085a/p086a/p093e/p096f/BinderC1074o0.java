package p070c.p084d.p085a.p086a.p093e.p096f;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* renamed from: c.d.a.a.e.f.o0 */
/* loaded from: classes.dex */
public final class BinderC1074o0 extends AbstractBinderC1085u {

    /* renamed from: a */
    public AbstractC1060h0 f5463a;

    /* renamed from: b */
    public final int f5464b;

    public BinderC1074o0(AbstractC1060h0 abstractC1060h0, int i) {
        this.f5463a = abstractC1060h0;
        this.f5464b = i;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1083t
    /* renamed from: a */
    public final void mo5185a(int i, IBinder iBinder, Bundle bundle) {
        C1049c0.m5293a(this.f5463a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f5463a.m5265a(i, iBinder, bundle, this.f5464b);
        this.f5463a = null;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1083t
    /* renamed from: b */
    public final void mo5184b(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
