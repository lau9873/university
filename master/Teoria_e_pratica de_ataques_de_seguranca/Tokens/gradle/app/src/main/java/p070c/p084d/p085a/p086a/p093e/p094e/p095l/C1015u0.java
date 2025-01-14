package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: c.d.a.a.e.e.l.u0 */
/* loaded from: classes.dex */
public final class C1015u0 extends BroadcastReceiver {

    /* renamed from: a */
    public Context f5325a;

    /* renamed from: b */
    public final AbstractC1019v0 f5326b;

    public C1015u0(AbstractC1019v0 abstractC1019v0) {
        this.f5326b = abstractC1019v0;
    }

    /* renamed from: a */
    public final synchronized void m5367a() {
        if (this.f5325a != null) {
            this.f5325a.unregisterReceiver(this);
        }
        this.f5325a = null;
    }

    /* renamed from: a */
    public final void m5366a(Context context) {
        this.f5325a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f5326b.mo5343a();
            m5367a();
        }
    }
}
