package p070c.p084d.p085a.p086a.p093e.p096f;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import p070c.p084d.p085a.p086a.p093e.C0900a;

/* renamed from: c.d.a.a.e.f.l0 */
/* loaded from: classes.dex */
public final class HandlerC1068l0 extends Handler {

    /* renamed from: a */
    public /* synthetic */ AbstractC1060h0 f5456a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1068l0(AbstractC1060h0 abstractC1060h0, Looper looper) {
        super(looper);
        this.f5456a = abstractC1060h0;
    }

    /* renamed from: a */
    public static void m5199a(Message message) {
        AbstractC1070m0 abstractC1070m0 = (AbstractC1070m0) message.obj;
        abstractC1070m0.mo5191c();
        abstractC1070m0.m5192b();
    }

    /* renamed from: b */
    public static boolean m5198b(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        InterfaceC1064j0 interfaceC1064j0;
        InterfaceC1064j0 interfaceC1064j02;
        C0900a c0900a;
        boolean m5224y;
        C0900a c0900a2;
        boolean z;
        if (this.f5456a.f5435x.get() != message.arg1) {
            if (m5198b(message)) {
                m5199a(message);
                return;
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || i == 4 || i == 5) && !this.f5456a.m5240h()) {
            m5199a(message);
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            this.f5456a.f5433v = new C0900a(message.arg2);
            m5224y = this.f5456a.m5224y();
            if (m5224y) {
                z = this.f5456a.f5434w;
                if (!z) {
                    this.f5456a.m5264a(3, (int) null);
                    return;
                }
            }
            c0900a2 = this.f5456a.f5433v;
            C0900a c0900a3 = c0900a2 != null ? this.f5456a.f5433v : new C0900a(8);
            this.f5456a.f5424m.mo5188a(c0900a3);
            this.f5456a.m5262a(c0900a3);
        } else if (i2 == 5) {
            c0900a = this.f5456a.f5433v;
            C0900a c0900a4 = c0900a != null ? this.f5456a.f5433v : new C0900a(8);
            this.f5456a.f5424m.mo5188a(c0900a4);
            this.f5456a.m5262a(c0900a4);
        } else if (i2 == 3) {
            Object obj = message.obj;
            C0900a c0900a5 = new C0900a(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f5456a.f5424m.mo5188a(c0900a5);
            this.f5456a.m5262a(c0900a5);
        } else if (i2 == 6) {
            this.f5456a.m5264a(5, (int) null);
            interfaceC1064j0 = this.f5456a.f5429r;
            if (interfaceC1064j0 != null) {
                interfaceC1064j02 = this.f5456a.f5429r;
                interfaceC1064j02.onConnectionSuspended(message.arg2);
            }
            this.f5456a.m5268a(message.arg2);
            this.f5456a.m5267a(5, 1, (int) null);
        } else if (i2 == 2 && !this.f5456a.m5248c()) {
            m5199a(message);
        } else if (m5198b(message)) {
            ((AbstractC1070m0) message.obj).m5190d();
        } else {
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(45);
            sb.append("Don't know how to handle message: ");
            sb.append(i3);
            Log.wtf("GmsClient", sb.toString(), new Exception());
        }
    }
}
