package c.d.a.a.e.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class k implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Set<ServiceConnection> f3516a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public int f3517b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3518c;

    /* renamed from: d  reason: collision with root package name */
    public IBinder f3519d;

    /* renamed from: e  reason: collision with root package name */
    public final i f3520e;

    /* renamed from: f  reason: collision with root package name */
    public ComponentName f3521f;

    /* renamed from: g  reason: collision with root package name */
    public /* synthetic */ j f3522g;

    public k(j jVar, i iVar) {
        this.f3522g = jVar;
        this.f3520e = iVar;
    }

    public final IBinder a() {
        return this.f3519d;
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        Context context;
        c.d.a.a.e.g.a unused;
        Context unused2;
        unused = this.f3522g.f3513f;
        unused2 = this.f3522g.f3511d;
        i iVar = this.f3520e;
        context = this.f3522g.f3511d;
        iVar.a(context);
        this.f3516a.add(serviceConnection);
    }

    public final void a(String str) {
        c.d.a.a.e.g.a aVar;
        Context context;
        Context context2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        c.d.a.a.e.g.a unused;
        this.f3517b = 3;
        aVar = this.f3522g.f3513f;
        context = this.f3522g.f3511d;
        i iVar = this.f3520e;
        context2 = this.f3522g.f3511d;
        this.f3518c = aVar.a(context, str, iVar.a(context2), this, this.f3520e.c());
        if (this.f3518c) {
            handler = this.f3522g.f3512e;
            Message obtainMessage = handler.obtainMessage(1, this.f3520e);
            handler2 = this.f3522g.f3512e;
            j = this.f3522g.f3515h;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.f3517b = 2;
        try {
            unused = this.f3522g.f3513f;
            context3 = this.f3522g.f3511d;
            context3.unbindService(this);
        } catch (IllegalArgumentException unused2) {
        }
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.f3516a.contains(serviceConnection);
    }

    public final ComponentName b() {
        return this.f3521f;
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        c.d.a.a.e.g.a unused;
        Context unused2;
        unused = this.f3522g.f3513f;
        unused2 = this.f3522g.f3511d;
        this.f3516a.remove(serviceConnection);
    }

    public final void b(String str) {
        Handler handler;
        Context context;
        c.d.a.a.e.g.a unused;
        handler = this.f3522g.f3512e;
        handler.removeMessages(1, this.f3520e);
        unused = this.f3522g.f3513f;
        context = this.f3522g.f3511d;
        context.unbindService(this);
        this.f3518c = false;
        this.f3517b = 2;
    }

    public final int c() {
        return this.f3517b;
    }

    public final boolean d() {
        return this.f3518c;
    }

    public final boolean e() {
        return this.f3516a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f3522g.f3510c;
        synchronized (hashMap) {
            handler = this.f3522g.f3512e;
            handler.removeMessages(1, this.f3520e);
            this.f3519d = iBinder;
            this.f3521f = componentName;
            for (ServiceConnection serviceConnection : this.f3516a) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f3517b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f3522g.f3510c;
        synchronized (hashMap) {
            handler = this.f3522g.f3512e;
            handler.removeMessages(1, this.f3520e);
            this.f3519d = null;
            this.f3521f = componentName;
            for (ServiceConnection serviceConnection : this.f3516a) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f3517b = 2;
        }
    }
}
