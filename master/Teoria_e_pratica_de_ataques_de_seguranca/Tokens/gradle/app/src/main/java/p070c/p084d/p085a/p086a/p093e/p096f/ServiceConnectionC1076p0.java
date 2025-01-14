package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: c.d.a.a.e.f.p0 */
/* loaded from: classes.dex */
public final class ServiceConnectionC1076p0 implements ServiceConnection {

    /* renamed from: a */
    public final int f5465a;

    /* renamed from: b */
    public /* synthetic */ AbstractC1060h0 f5466b;

    public ServiceConnectionC1076p0(AbstractC1060h0 abstractC1060h0, int i) {
        this.f5466b = abstractC1060h0;
        this.f5465a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        InterfaceC1087v c1089w;
        AbstractC1060h0 abstractC1060h0 = this.f5466b;
        if (iBinder == null) {
            abstractC1060h0.m5247c(16);
            return;
        }
        obj = abstractC1060h0.f5422k;
        synchronized (obj) {
            AbstractC1060h0 abstractC1060h02 = this.f5466b;
            if (iBinder == null) {
                c1089w = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                c1089w = (queryLocalInterface == null || !(queryLocalInterface instanceof InterfaceC1087v)) ? new C1089w(iBinder) : (InterfaceC1087v) queryLocalInterface;
            }
            abstractC1060h02.f5423l = c1089w;
        }
        this.f5466b.m5266a(0, (Bundle) null, this.f5465a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.f5466b.f5422k;
        synchronized (obj) {
            this.f5466b.f5423l = null;
        }
        Handler handler = this.f5466b.f5420i;
        handler.sendMessage(handler.obtainMessage(6, this.f5465a, 1));
    }
}
