package p205h.p206a.p207a;

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

/* renamed from: h.a.a.g */
/* loaded from: classes.dex */
public class BLEManager {

    /* renamed from: a */
    public final Context f8790a;

    /* renamed from: d */
    public Messenger f8793d;

    /* renamed from: e */
    public InterfaceC1898b f8794e;

    /* renamed from: f */
    public InterfaceC1901e f8795f;

    /* renamed from: g */
    public ScanPeriodData f8796g;

    /* renamed from: h */
    public ScanPeriodData f8797h;

    /* renamed from: i */
    public boolean f8798i;

    /* renamed from: j */
    public boolean f8799j = false;

    /* renamed from: b */
    public final ServiceConnectionC1900d f8791b = new ServiceConnectionC1900d();

    /* renamed from: c */
    public final Messenger f8792c = new Messenger(new HandlerC1899c());

    /* compiled from: BLEManager.java */
    /* renamed from: h.a.a.g$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1898b {
        /* renamed from: a */
        void mo1875a(long j, long j2, List<BLEDevice> list, double d, double d2, double d3);

        void onError(DataModels.Error error);
    }

    /* compiled from: BLEManager.java */
    /* renamed from: h.a.a.g$c */
    /* loaded from: classes.dex */
    public class HandlerC1899c extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 111) {
                if (BLEManager.this.f8794e != null) {
                    BLEManager.this.f8794e.onError((DataModels.Error) message.obj);
                }
            } else if (i == 888) {
                if (BLEManager.this.f8794e != null) {
                    DiscoveryResult discoveryResult = (DiscoveryResult) message.obj;
                    BLEManager.this.f8794e.mo1875a(discoveryResult.f9396a, discoveryResult.f9397b, discoveryResult.f9398c, discoveryResult.f9399d, discoveryResult.f9400e, discoveryResult.f9401f);
                    if (BLEManager.this.f8798i) {
                        BLEManager.this.m2092f();
                    }
                }
            } else {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEManager", "IncomingHandler:handleMessage", "Unknown message: " + message);
            }
        }

        public HandlerC1899c() {
        }
    }

    /* compiled from: BLEManager.java */
    /* renamed from: h.a.a.g$d */
    /* loaded from: classes.dex */
    public class ServiceConnectionC1900d implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BLEManager.this.f8793d = new Messenger(iBinder);
            if (BLEManager.this.f8794e != null) {
                BLEManager.this.m2094e();
            }
            if (BLEManager.this.f8796g != null) {
                BLEManager bLEManager = BLEManager.this;
                bLEManager.m2104a(bLEManager.f8796g, 9);
                BLEManager.this.f8796g = null;
            }
            if (BLEManager.this.f8797h != null) {
                BLEManager bLEManager2 = BLEManager.this;
                bLEManager2.m2104a(bLEManager2.f8797h, 10);
                BLEManager.this.f8797h = null;
            }
            if (BLEManager.this.f8795f != null) {
                BLEManager.this.f8795f.mo1873a();
                BLEManager.this.f8795f = null;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AppLog.m2158a("COMM_BLUETOOTH", "BLEManager", "InternalServiceConnection:onServiceDisconnected", "Service disconnected, crashed? " + componentName);
            BLEManager.this.f8793d = null;
        }

        public ServiceConnectionC1900d() {
        }
    }

    /* compiled from: BLEManager.java */
    /* renamed from: h.a.a.g$e */
    /* loaded from: classes.dex */
    public interface InterfaceC1901e {
        /* renamed from: a */
        void mo1873a();
    }

    public BLEManager(Context context, boolean z) {
        this.f8798i = false;
        this.f8790a = (Context) C2222t.m1569a(context);
        this.f8798i = z;
    }

    /* renamed from: h */
    public void m2088h() {
        AppLog.m2158a("COMM_BLUETOOTH", "BLEManager", "stopDiscovery", "entered method");
        try {
            if (!m2096d()) {
                L.m1579b("Not stopping discovery, not connected to service");
            } else {
                m2098c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m2098c() {
        AppLog.m2158a("COMM_BLUETOOTH", "BLEManager", "internalStopDiscovery", "entered method");
        try {
            this.f8793d.send(Message.obtain((Handler) null, 777));
        } catch (RemoteException e) {
            L.m1581a("Error while stopping discovery", e);
            throw e;
        }
    }

    /* renamed from: d */
    private boolean m2096d() {
        return this.f8793d != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2094e() {
        Message obtain = Message.obtain((Handler) null, 7);
        obtain.replyTo = this.f8792c;
        try {
            this.f8793d.send(obtain);
        } catch (RemoteException unused) {
            L.m1582a("Error while registering error listener");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2092f() {
        try {
            m2088h();
            if (this.f8799j) {
                m2090g();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public void m2090g() {
        AppLog.m2158a("COMM_BLUETOOTH", "BLEManager", "startDiscovery", "entered method");
        if (!m2096d()) {
            L.m1579b("Not starting discovery, not connected to service");
            return;
        }
        Message obtain = Message.obtain((Handler) null, 666);
        obtain.replyTo = this.f8792c;
        try {
            this.f8793d.send(obtain);
        } catch (RemoteException e) {
            L.m1581a("Error while starting discovery", e);
            throw e;
        }
    }

    /* renamed from: b */
    public void m2102b() {
        AppLog.m2158a("COMM_BLUETOOTH", "BLEManager", "disconnect", "entered method");
        try {
            if (!m2096d()) {
                L.m1579b("Not disconnecting because was not connected to service");
                return;
            }
            this.f8790a.unbindService(this.f8791b);
            this.f8793d = null;
            this.f8799j = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean m2113a() {
        PackageManager packageManager = this.f8790a.getPackageManager();
        return packageManager.checkPermission("android.permission.BLUETOOTH", this.f8790a.getPackageName()) == 0 && packageManager.checkPermission("android.permission.BLUETOOTH_ADMIN", this.f8790a.getPackageName()) == 0 && packageManager.queryIntentServices(new Intent(this.f8790a, OnTripService.class), 65536).size() > 0;
    }

    /* renamed from: b */
    public void m2099b(boolean z) {
        Message obtain = Message.obtain((Handler) null, 13);
        obtain.obj = Boolean.valueOf(z);
        try {
            this.f8793d.send(obtain);
        } catch (RemoteException unused) {
            L.m1582a("Error while setting user scan filters property: 13");
        }
    }

    /* renamed from: a */
    public void m2109a(InterfaceC1901e interfaceC1901e) {
        AppLog.m2158a("COMM_BLUETOOTH", "BLEManager", "connect", "entered method");
        if (!m2113a()) {
            L.m1582a("AndroidManifest.xml does not contain android.permission.BLUETOOTH or android.permission.BLUETOOTH_ADMIN permissions. BLEService may be also not declared in AndroidManifest.xml.");
        }
        this.f8795f = (InterfaceC1901e) C2222t.m1568a(interfaceC1901e, "callback cannot be null");
        if (m2096d()) {
            interfaceC1901e.mo1873a();
        }
        Context context = this.f8790a;
        if (!context.bindService(new Intent(context, BLEService.class), this.f8791b, 1)) {
            L.m1577d("Could not bind service");
        }
        this.f8799j = true;
    }

    /* renamed from: a */
    public void m2110a(InterfaceC1898b interfaceC1898b) {
        this.f8794e = (InterfaceC1898b) C2222t.m1568a(interfaceC1898b, "listener cannot be null");
        if (m2096d()) {
            m2094e();
        }
    }

    /* renamed from: a */
    public void m2111a(long j, long j2) {
        if (m2096d()) {
            m2104a(new ScanPeriodData(j, j2), 9);
        } else {
            this.f8796g = new ScanPeriodData(j, j2);
        }
    }

    /* renamed from: a */
    public void m2104a(ScanPeriodData scanPeriodData, int i) {
        Message obtain = Message.obtain((Handler) null, i);
        obtain.obj = scanPeriodData;
        try {
            this.f8793d.send(obtain);
        } catch (RemoteException unused) {
            L.m1582a("Error while setting scan periods: " + i);
        }
    }

    /* renamed from: a */
    public void m2112a(int i) {
        Message obtain = Message.obtain((Handler) null, 11);
        obtain.obj = Integer.valueOf(i);
        try {
            this.f8793d.send(obtain);
        } catch (RemoteException unused) {
            L.m1582a("Error while setting scan periods: 11");
        }
    }

    /* renamed from: a */
    public void m2103a(boolean z) {
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.obj = Boolean.valueOf(z);
        try {
            this.f8793d.send(obtain);
        } catch (RemoteException unused) {
            L.m1582a("Error while setting add location info property: 12");
        }
    }
}
