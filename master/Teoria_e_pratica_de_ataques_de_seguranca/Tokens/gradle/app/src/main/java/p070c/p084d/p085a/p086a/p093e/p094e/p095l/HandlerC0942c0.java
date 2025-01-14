package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: c.d.a.a.e.e.l.c0 */
/* loaded from: classes.dex */
public final class HandlerC0942c0 extends Handler {

    /* renamed from: a */
    public /* synthetic */ C0934a0 f5147a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0942c0(C0934a0 c0934a0, Looper looper) {
        super(looper);
        this.f5147a = c0934a0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.f5147a.m5572h();
        } else if (i == 2) {
            this.f5147a.m5574f();
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i);
            Log.w("GoogleApiClientImpl", sb.toString());
        }
    }
}
