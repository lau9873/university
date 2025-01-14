package c.d.a.a.e.e.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
public final class c0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ a0 f3272a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(a0 a0Var, Looper looper) {
        super(looper);
        this.f3272a = a0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.f3272a.h();
        } else if (i2 == 2) {
            this.f3272a.f();
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GoogleApiClientImpl", sb.toString());
        }
    }
}
