package c.d.a.a.e.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class j extends h implements Handler.Callback {

    /* renamed from: d  reason: collision with root package name */
    public final Context f3511d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f3512e;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<i, k> f3510c = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public final c.d.a.a.e.g.a f3513f = c.d.a.a.e.g.a.a();

    /* renamed from: g  reason: collision with root package name */
    public final long f3514g = 5000;

    /* renamed from: h  reason: collision with root package name */
    public final long f3515h = 300000;

    public j(Context context) {
        this.f3511d = context.getApplicationContext();
        this.f3512e = new Handler(context.getMainLooper(), this);
    }

    @Override // c.d.a.a.e.f.h
    public final boolean a(i iVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        c0.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f3510c) {
            k kVar = this.f3510c.get(iVar);
            if (kVar == null) {
                kVar = new k(this, iVar);
                kVar.a(serviceConnection, str);
                kVar.a(str);
                this.f3510c.put(iVar, kVar);
            } else {
                this.f3512e.removeMessages(0, iVar);
                if (kVar.a(serviceConnection)) {
                    String valueOf = String.valueOf(iVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                kVar.a(serviceConnection, str);
                int c2 = kVar.c();
                if (c2 == 1) {
                    serviceConnection.onServiceConnected(kVar.b(), kVar.a());
                } else if (c2 == 2) {
                    kVar.a(str);
                }
            }
            d2 = kVar.d();
        }
        return d2;
    }

    @Override // c.d.a.a.e.f.h
    public final void b(i iVar, ServiceConnection serviceConnection, String str) {
        c0.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f3510c) {
            k kVar = this.f3510c.get(iVar);
            if (kVar == null) {
                String valueOf = String.valueOf(iVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (!kVar.a(serviceConnection)) {
                String valueOf2 = String.valueOf(iVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            } else {
                kVar.b(serviceConnection, str);
                if (kVar.e()) {
                    this.f3512e.sendMessageDelayed(this.f3512e.obtainMessage(0, iVar), this.f3514g);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f3510c) {
                i iVar = (i) message.obj;
                k kVar = this.f3510c.get(iVar);
                if (kVar != null && kVar.e()) {
                    if (kVar.d()) {
                        kVar.b("GmsClientSupervisor");
                    }
                    this.f3510c.remove(iVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.f3510c) {
                i iVar2 = (i) message.obj;
                k kVar2 = this.f3510c.get(iVar2);
                if (kVar2 != null && kVar2.c() == 3) {
                    String valueOf = String.valueOf(iVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.wtf("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName b2 = kVar2.b();
                    if (b2 == null) {
                        b2 = iVar2.a();
                    }
                    if (b2 == null) {
                        b2 = new ComponentName(iVar2.b(), "unknown");
                    }
                    kVar2.onServiceDisconnected(b2);
                }
            }
            return true;
        }
    }
}
