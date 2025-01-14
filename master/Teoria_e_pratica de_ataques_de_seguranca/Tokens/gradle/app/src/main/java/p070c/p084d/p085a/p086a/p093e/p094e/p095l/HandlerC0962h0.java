package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: c.d.a.a.e.e.l.h0 */
/* loaded from: classes.dex */
public final class HandlerC0962h0 extends Handler {

    /* renamed from: a */
    public /* synthetic */ C0954f0 f5185a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0962h0(C0954f0 c0954f0, Looper looper) {
        super(looper);
        this.f5185a = c0954f0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((AbstractC0958g0) message.obj).m5521a(this.f5185a);
        } else if (i == 2) {
            throw ((RuntimeException) message.obj);
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i);
            Log.w("GACStateManager", sb.toString());
        }
    }
}
