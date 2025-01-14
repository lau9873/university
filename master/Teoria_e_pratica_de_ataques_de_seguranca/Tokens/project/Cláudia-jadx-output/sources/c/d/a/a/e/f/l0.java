package c.d.a.a.e.f;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes.dex */
public final class l0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ h0 f3523a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(h0 h0Var, Looper looper) {
        super(looper);
        this.f3523a = h0Var;
    }

    public static void a(Message message) {
        m0 m0Var = (m0) message.obj;
        m0Var.c();
        m0Var.b();
    }

    public static boolean b(Message message) {
        int i2 = message.what;
        return i2 == 2 || i2 == 1 || i2 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        j0 j0Var;
        j0 j0Var2;
        c.d.a.a.e.a aVar;
        boolean y;
        c.d.a.a.e.a aVar2;
        boolean z;
        if (this.f3523a.x.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 7 || i2 == 4 || i2 == 5) && !this.f3523a.h()) {
            a(message);
            return;
        }
        int i3 = message.what;
        if (i3 == 4) {
            this.f3523a.v = new c.d.a.a.e.a(message.arg2);
            y = this.f3523a.y();
            if (y) {
                z = this.f3523a.w;
                if (!z) {
                    this.f3523a.a(3, (int) null);
                    return;
                }
            }
            aVar2 = this.f3523a.v;
            c.d.a.a.e.a aVar3 = aVar2 != null ? this.f3523a.v : new c.d.a.a.e.a(8);
            this.f3523a.m.a(aVar3);
            this.f3523a.a(aVar3);
        } else if (i3 == 5) {
            aVar = this.f3523a.v;
            c.d.a.a.e.a aVar4 = aVar != null ? this.f3523a.v : new c.d.a.a.e.a(8);
            this.f3523a.m.a(aVar4);
            this.f3523a.a(aVar4);
        } else if (i3 == 3) {
            Object obj = message.obj;
            c.d.a.a.e.a aVar5 = new c.d.a.a.e.a(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f3523a.m.a(aVar5);
            this.f3523a.a(aVar5);
        } else if (i3 == 6) {
            this.f3523a.a(5, (int) null);
            j0Var = this.f3523a.r;
            if (j0Var != null) {
                j0Var2 = this.f3523a.r;
                j0Var2.onConnectionSuspended(message.arg2);
            }
            this.f3523a.a(message.arg2);
            this.f3523a.a(5, 1, (int) null);
        } else if (i3 == 2 && !this.f3523a.c()) {
            a(message);
        } else if (b(message)) {
            ((m0) message.obj).d();
        } else {
            int i4 = message.what;
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i4);
            Log.wtf("GmsClient", sb.toString(), new Exception());
        }
    }
}
