package c.d.a.a.e.e.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
public final class h0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ f0 f3305a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(f0 f0Var, Looper looper) {
        super(looper);
        this.f3305a = f0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            ((g0) message.obj).a(this.f3305a);
        } else if (i2 == 2) {
            throw ((RuntimeException) message.obj);
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GACStateManager", sb.toString());
        }
    }
}
