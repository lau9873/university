package p070c.p084d.p085a.p086a.p093e.p096f;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import p070c.p084d.p085a.p086a.p093e.p097g.C1097a;

/* renamed from: c.d.a.a.e.f.j */
/* loaded from: classes.dex */
public final class C1063j extends AbstractC1059h implements Handler.Callback {

    /* renamed from: d */
    public final Context f5444d;

    /* renamed from: e */
    public final Handler f5445e;

    /* renamed from: c */
    public final HashMap<C1061i, ServiceConnectionC1065k> f5443c = new HashMap<>();

    /* renamed from: f */
    public final C1097a f5446f = C1097a.m5147a();

    /* renamed from: g */
    public final long f5447g = 5000;

    /* renamed from: h */
    public final long f5448h = 300000;

    public C1063j(Context context) {
        this.f5444d = context.getApplicationContext();
        this.f5445e = new Handler(context.getMainLooper(), this);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1059h
    /* renamed from: a */
    public final boolean mo5219a(C1061i c1061i, ServiceConnection serviceConnection, String str) {
        boolean m5204d;
        C1049c0.m5293a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f5443c) {
            ServiceConnectionC1065k serviceConnectionC1065k = this.f5443c.get(c1061i);
            if (serviceConnectionC1065k == null) {
                serviceConnectionC1065k = new ServiceConnectionC1065k(this, c1061i);
                serviceConnectionC1065k.m5210a(serviceConnection, str);
                serviceConnectionC1065k.m5209a(str);
                this.f5443c.put(c1061i, serviceConnectionC1065k);
            } else {
                this.f5445e.removeMessages(0, c1061i);
                if (serviceConnectionC1065k.m5211a(serviceConnection)) {
                    String valueOf = String.valueOf(c1061i);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                serviceConnectionC1065k.m5210a(serviceConnection, str);
                int m5205c = serviceConnectionC1065k.m5205c();
                if (m5205c == 1) {
                    serviceConnection.onServiceConnected(serviceConnectionC1065k.m5208b(), serviceConnectionC1065k.m5212a());
                } else if (m5205c == 2) {
                    serviceConnectionC1065k.m5209a(str);
                }
            }
            m5204d = serviceConnectionC1065k.m5204d();
        }
        return m5204d;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1059h
    /* renamed from: b */
    public final void mo5217b(C1061i c1061i, ServiceConnection serviceConnection, String str) {
        C1049c0.m5293a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f5443c) {
            ServiceConnectionC1065k serviceConnectionC1065k = this.f5443c.get(c1061i);
            if (serviceConnectionC1065k == null) {
                String valueOf = String.valueOf(c1061i);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (!serviceConnectionC1065k.m5211a(serviceConnection)) {
                String valueOf2 = String.valueOf(c1061i);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            } else {
                serviceConnectionC1065k.m5207b(serviceConnection, str);
                if (serviceConnectionC1065k.m5203e()) {
                    this.f5445e.sendMessageDelayed(this.f5445e.obtainMessage(0, c1061i), this.f5447g);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f5443c) {
                C1061i c1061i = (C1061i) message.obj;
                ServiceConnectionC1065k serviceConnectionC1065k = this.f5443c.get(c1061i);
                if (serviceConnectionC1065k != null && serviceConnectionC1065k.m5203e()) {
                    if (serviceConnectionC1065k.m5204d()) {
                        serviceConnectionC1065k.m5206b("GmsClientSupervisor");
                    }
                    this.f5443c.remove(c1061i);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f5443c) {
                C1061i c1061i2 = (C1061i) message.obj;
                ServiceConnectionC1065k serviceConnectionC1065k2 = this.f5443c.get(c1061i2);
                if (serviceConnectionC1065k2 != null && serviceConnectionC1065k2.m5205c() == 3) {
                    String valueOf = String.valueOf(c1061i2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.wtf("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName m5208b = serviceConnectionC1065k2.m5208b();
                    if (m5208b == null) {
                        m5208b = c1061i2.m5223a();
                    }
                    if (m5208b == null) {
                        m5208b = new ComponentName(c1061i2.m5221b(), "unknown");
                    }
                    serviceConnectionC1065k2.onServiceDisconnected(m5208b);
                }
            }
            return true;
        }
    }
}
