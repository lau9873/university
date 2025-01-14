package h.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;
import pt.card4b.backendbeacons.BLEService;
import pt.card4b.backendbeacons.DataModels;
import pt.card4b.backendbeacons.OnTripService;
/* compiled from: BLEManager.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6290a;

    /* renamed from: d  reason: collision with root package name */
    public Messenger f6293d;

    /* renamed from: e  reason: collision with root package name */
    public b f6294e;

    /* renamed from: f  reason: collision with root package name */
    public e f6295f;

    /* renamed from: g  reason: collision with root package name */
    public u f6296g;

    /* renamed from: h  reason: collision with root package name */
    public u f6297h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6298i;
    public boolean j = false;

    /* renamed from: b  reason: collision with root package name */
    public final d f6291b = new d();

    /* renamed from: c  reason: collision with root package name */
    public final Messenger f6292c = new Messenger(new c());

    /* compiled from: BLEManager.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(long j, long j2, List<f> list, double d2, double d3, double d4);

        void onError(DataModels.Error error);
    }

    /* compiled from: BLEManager.java */
    /* loaded from: classes.dex */
    public class c extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 111) {
                if (g.this.f6294e != null) {
                    g.this.f6294e.onError((DataModels.Error) message.obj);
                }
            } else if (i2 == 888) {
                if (g.this.f6294e != null) {
                    o oVar = (o) message.obj;
                    g.this.f6294e.a(oVar.f6841a, oVar.f6842b, oVar.f6843c, oVar.f6844d, oVar.f6845e, oVar.f6846f);
                    if (g.this.f6298i) {
                        g.this.f();
                    }
                }
            } else {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEManager", "IncomingHandler:handleMessage", "Unknown message: " + message);
            }
        }

        public c() {
        }
    }

    /* compiled from: BLEManager.java */
    /* loaded from: classes.dex */
    public class d implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.f6293d = new Messenger(iBinder);
            if (g.this.f6294e != null) {
                g.this.e();
            }
            if (g.this.f6296g != null) {
                g gVar = g.this;
                gVar.a(gVar.f6296g, 9);
                g.this.f6296g = null;
            }
            if (g.this.f6297h != null) {
                g gVar2 = g.this;
                gVar2.a(gVar2.f6297h, 10);
                g.this.f6297h = null;
            }
            if (g.this.f6295f != null) {
                g.this.f6295f.a();
                g.this.f6295f = null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h.a.a.c.a("COMM_BLUETOOTH", "BLEManager", "InternalServiceConnection:onServiceDisconnected", "Service disconnected, crashed? " + componentName);
            g.this.f6293d = null;
        }

        public d() {
        }
    }

    /* compiled from: BLEManager.java */
    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    public g(Context context, boolean z) {
        this.f6298i = false;
        this.f6290a = (Context) t.a(context);
        this.f6298i = z;
    }

    public void h() {
        h.a.a.c.a("COMM_BLUETOOTH", "BLEManager", "stopDiscovery", "entered method");
        try {
            if (!d()) {
                q.b("Not stopping discovery, not connected to service");
            } else {
                c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c() {
        h.a.a.c.a("COMM_BLUETOOTH", "BLEManager", "internalStopDiscovery", "entered method");
        try {
            this.f6293d.send(Message.obtain((Handler) null, 777));
        } catch (RemoteException e2) {
            q.a("Error while stopping discovery", e2);
            throw e2;
        }
    }

    private boolean d() {
        return this.f6293d != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Message obtain = Message.obtain((Handler) null, 7);
        obtain.replyTo = this.f6292c;
        try {
            this.f6293d.send(obtain);
        } catch (RemoteException unused) {
            q.a("Error while registering error listener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            h();
            if (this.j) {
                g();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        h.a.a.c.a("COMM_BLUETOOTH", "BLEManager", "startDiscovery", "entered method");
        if (!d()) {
            q.b("Not starting discovery, not connected to service");
            return;
        }
        Message obtain = Message.obtain((Handler) null, 666);
        obtain.replyTo = this.f6292c;
        try {
            this.f6293d.send(obtain);
        } catch (RemoteException e2) {
            q.a("Error while starting discovery", e2);
            throw e2;
        }
    }

    public void b() {
        h.a.a.c.a("COMM_BLUETOOTH", "BLEManager", "disconnect", "entered method");
        try {
            if (!d()) {
                q.b("Not disconnecting because was not connected to service");
                return;
            }
            this.f6290a.unbindService(this.f6291b);
            this.f6293d = null;
            this.j = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean a() {
        PackageManager packageManager = this.f6290a.getPackageManager();
        return packageManager.checkPermission("android.permission.BLUETOOTH", this.f6290a.getPackageName()) == 0 && packageManager.checkPermission("android.permission.BLUETOOTH_ADMIN", this.f6290a.getPackageName()) == 0 && packageManager.queryIntentServices(new Intent(this.f6290a, OnTripService.class), 65536).size() > 0;
    }

    public void b(boolean z) {
        Message obtain = Message.obtain((Handler) null, 13);
        obtain.obj = Boolean.valueOf(z);
        try {
            this.f6293d.send(obtain);
        } catch (RemoteException unused) {
            q.a("Error while setting user scan filters property: 13");
        }
    }

    public void a(e eVar) {
        h.a.a.c.a("COMM_BLUETOOTH", "BLEManager", "connect", "entered method");
        if (!a()) {
            q.a("AndroidManifest.xml does not contain android.permission.BLUETOOTH or android.permission.BLUETOOTH_ADMIN permissions. BLEService may be also not declared in AndroidManifest.xml.");
        }
        this.f6295f = (e) t.a(eVar, "callback cannot be null");
        if (d()) {
            eVar.a();
        }
        Context context = this.f6290a;
        if (!context.bindService(new Intent(context, BLEService.class), this.f6291b, 1)) {
            q.d("Could not bind service");
        }
        this.j = true;
    }

    public void a(b bVar) {
        this.f6294e = (b) t.a(bVar, "listener cannot be null");
        if (d()) {
            e();
        }
    }

    public void a(long j, long j2) {
        if (d()) {
            a(new u(j, j2), 9);
        } else {
            this.f6296g = new u(j, j2);
        }
    }

    public void a(u uVar, int i2) {
        Message obtain = Message.obtain((Handler) null, i2);
        obtain.obj = uVar;
        try {
            this.f6293d.send(obtain);
        } catch (RemoteException unused) {
            q.a("Error while setting scan periods: " + i2);
        }
    }

    public void a(int i2) {
        Message obtain = Message.obtain((Handler) null, 11);
        obtain.obj = Integer.valueOf(i2);
        try {
            this.f6293d.send(obtain);
        } catch (RemoteException unused) {
            q.a("Error while setting scan periods: 11");
        }
    }

    public void a(boolean z) {
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.obj = Boolean.valueOf(z);
        try {
            this.f6293d.send(obtain);
        } catch (RemoteException unused) {
            q.a("Error while setting add location info property: 12");
        }
    }
}
