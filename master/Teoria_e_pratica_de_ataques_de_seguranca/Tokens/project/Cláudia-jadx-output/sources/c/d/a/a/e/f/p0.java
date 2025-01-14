package c.d.a.a.e.f;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public final class p0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final int f3532a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ h0 f3533b;

    public p0(h0 h0Var, int i2) {
        this.f3533b = h0Var;
        this.f3532a = i2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        v wVar;
        h0 h0Var = this.f3533b;
        if (iBinder == null) {
            h0Var.c(16);
            return;
        }
        obj = h0Var.k;
        synchronized (obj) {
            h0 h0Var2 = this.f3533b;
            if (iBinder == null) {
                wVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                wVar = (queryLocalInterface == null || !(queryLocalInterface instanceof v)) ? new w(iBinder) : (v) queryLocalInterface;
            }
            h0Var2.l = wVar;
        }
        this.f3533b.a(0, (Bundle) null, this.f3532a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.f3533b.k;
        synchronized (obj) {
            this.f3533b.l = null;
        }
        Handler handler = this.f3533b.f3502i;
        handler.sendMessage(handler.obtainMessage(6, this.f3532a, 1));
    }
}
