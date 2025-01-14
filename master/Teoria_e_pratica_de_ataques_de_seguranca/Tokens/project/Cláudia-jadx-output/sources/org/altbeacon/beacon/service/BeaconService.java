package org.altbeacon.beacon.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import g.a.a.e;
import g.a.a.j;
import g.a.a.m.d;
import g.a.a.n.c;
import g.a.a.n.f;
import g.a.a.n.l;
import g.a.a.n.o;
import g.a.a.n.p;
import g.a.b.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
/* loaded from: classes.dex */
public class BeaconService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public b f7616b;

    /* renamed from: c  reason: collision with root package name */
    public l f7617c;

    /* renamed from: d  reason: collision with root package name */
    public e f7618d;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f7615a = new Handler();

    /* renamed from: e  reason: collision with root package name */
    public final Messenger f7619e = new Messenger(new a(this));

    /* loaded from: classes.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<BeaconService> f7620a;

        public a(BeaconService beaconService) {
            super(Looper.getMainLooper());
            this.f7620a = new WeakReference<>(beaconService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BeaconService beaconService = this.f7620a.get();
            if (beaconService != null) {
                p a2 = p.a(message.getData());
                if (a2 != null) {
                    int i2 = message.what;
                    if (i2 == 2) {
                        d.c("BeaconService", "start ranging received", new Object[0]);
                        beaconService.b(a2.d(), new g.a.a.n.a(a2.c()));
                        beaconService.a(a2.e(), a2.b(), a2.a());
                    } else if (i2 == 3) {
                        d.c("BeaconService", "stop ranging received", new Object[0]);
                        beaconService.b(a2.d());
                        beaconService.a(a2.e(), a2.b(), a2.a());
                    } else if (i2 == 4) {
                        d.c("BeaconService", "start monitoring received", new Object[0]);
                        beaconService.a(a2.d(), new g.a.a.n.a(a2.c()));
                        beaconService.a(a2.e(), a2.b(), a2.a());
                    } else if (i2 == 5) {
                        d.c("BeaconService", "stop monitoring received", new Object[0]);
                        beaconService.a(a2.d());
                        beaconService.a(a2.e(), a2.b(), a2.a());
                    } else if (i2 != 6) {
                        super.handleMessage(message);
                    } else {
                        d.c("BeaconService", "set scan intervals received", new Object[0]);
                        beaconService.a(a2.e(), a2.b(), a2.a());
                    }
                } else if (message.what == 7) {
                    d.c("BeaconService", "Received settings update from other process", new Object[0]);
                    o a3 = o.a(message.getData());
                    if (a3 != null) {
                        a3.a(beaconService);
                    } else {
                        d.d("BeaconService", "Settings data missing", new Object[0]);
                    }
                } else {
                    d.c("BeaconService", "Received unknown message from other process : " + message.what, new Object[0]);
                }
            }
        }
    }

    public final void a() {
        if (this.f7618d == null) {
            this.f7618d = new e(this);
            this.f7618d.a();
        }
    }

    public final PendingIntent b() {
        return PendingIntent.getBroadcast(getApplicationContext(), 1, new Intent(getApplicationContext(), StartupBroadcastReceiver.class), 1073741824);
    }

    public void c() {
        this.f7617c.g();
    }

    public final void d() {
        BeaconManager a2 = BeaconManager.a(getApplicationContext());
        Notification m = a2.m();
        int n = a2.n();
        if (m == null || Build.VERSION.SDK_INT < 16) {
            return;
        }
        startForeground(n, m);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        d.c("BeaconService", "binding", new Object[0]);
        return this.f7619e.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        if (Build.VERSION.SDK_INT < 21) {
            this.f7616b = new b(this);
            this.f7616b.i();
        }
        this.f7617c = new l(this);
        if (this.f7617c.a() == null) {
            this.f7617c.a(false, this.f7616b);
        }
        this.f7617c.a(g.a.a.n.e.a(this));
        this.f7617c.a(new HashMap());
        this.f7617c.a(new HashSet());
        this.f7617c.a(new c());
        BeaconManager a2 = BeaconManager.a(getApplicationContext());
        a2.c(true);
        if (a2.y()) {
            d.c("BeaconService", "beaconService version %s is starting up on the main process", "2.16.3");
            a();
        } else {
            d.c("BeaconService", "beaconService version %s is starting up on a separate process", "2.16.3");
            g.a.a.p.a aVar = new g.a.a.p.a(this);
            d.c("BeaconService", "beaconService PID is " + aVar.b() + " with process name " + aVar.c(), new Object[0]);
        }
        String a3 = a("longScanForcingEnabled");
        if (a3 != null && a3.equals("true")) {
            d.c("BeaconService", "longScanForcingEnabled to keep scans going on Android N for > 30 minutes", new Object[0]);
            if (this.f7617c.a() != null) {
                this.f7617c.a().b(true);
            }
        }
        this.f7617c.g();
        g.a.a.c.a(new g.a.a.l.e(this, BeaconManager.G()));
        try {
            this.f7617c.a((List) Class.forName("org.altbeacon.beacon.SimulatedScanData").getField("beacons").get(null));
        } catch (ClassNotFoundException unused) {
            d.a("BeaconService", "No org.altbeacon.beacon.SimulatedScanData class exists.", new Object[0]);
        } catch (Exception e2) {
            d.a(e2, "BeaconService", "Cannot get simulated Scan data.  Make sure your org.altbeacon.beacon.SimulatedScanData class defines a field with the signature 'public static List<Beacon> beacons'", new Object[0]);
        }
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        d.b("BeaconService", "onDestroy()", new Object[0]);
        if (Build.VERSION.SDK_INT < 18) {
            d.d("BeaconService", "Not supported prior to API 18.", new Object[0]);
            return;
        }
        e eVar = this.f7618d;
        if (eVar != null) {
            eVar.b();
        }
        b bVar = this.f7616b;
        if (bVar != null) {
            bVar.k();
        }
        d.c("BeaconService", "onDestroy called.  stopping scanning", new Object[0]);
        this.f7615a.removeCallbacksAndMessages(null);
        if (this.f7617c.a() != null) {
            this.f7617c.a().r();
            this.f7617c.a().f();
        }
        this.f7617c.c().j();
        this.f7617c.i();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String str;
        if (intent == null) {
            str = "starting with null intent";
        } else {
            str = "starting with intent " + intent.toString();
        }
        d.c("BeaconService", str, new Object[0]);
        return super.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        d.a("BeaconService", "task removed", new Object[0]);
        if (Build.VERSION.RELEASE.contains("4.4.1") || Build.VERSION.RELEASE.contains("4.4.2") || Build.VERSION.RELEASE.contains("4.4.3")) {
            ((AlarmManager) getApplicationContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 1000, b());
            d.a("BeaconService", "Setting a wakeup alarm to go off due to Android 4.4.2 service restarting bug.", new Object[0]);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        d.c("BeaconService", "unbinding so destroying self", new Object[0]);
        stopForeground(true);
        stopSelf();
        return false;
    }

    public void b(j jVar, g.a.a.n.a aVar) {
        synchronized (this.f7617c.d()) {
            if (this.f7617c.d().containsKey(jVar)) {
                d.c("BeaconService", "Already ranging that region -- will replace existing region.", new Object[0]);
                this.f7617c.d().remove(jVar);
            }
            this.f7617c.d().put(jVar, new f(aVar));
            d.a("BeaconService", "Currently ranging %s regions.", Integer.valueOf(this.f7617c.d().size()));
        }
        if (this.f7617c.a() != null) {
            this.f7617c.a().p();
        }
    }

    public final String a(String str) {
        try {
            ServiceInfo serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, BeaconService.class), 128);
            if (serviceInfo == null || ((PackageItemInfo) serviceInfo).metaData == null) {
                return null;
            }
            return ((PackageItemInfo) serviceInfo).metaData.get(str).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public void a(j jVar, g.a.a.n.a aVar) {
        d.a("BeaconService", "startMonitoring called", new Object[0]);
        this.f7617c.c().b(jVar, aVar);
        d.a("BeaconService", "Currently monitoring %s regions.", Integer.valueOf(this.f7617c.c().e()));
        if (this.f7617c.a() != null) {
            this.f7617c.a().p();
        }
    }

    public void a(j jVar) {
        d.a("BeaconService", "stopMonitoring called", new Object[0]);
        this.f7617c.c().c(jVar);
        d.a("BeaconService", "Currently monitoring %s regions.", Integer.valueOf(this.f7617c.c().e()));
        if (this.f7617c.c().e() == 0 && this.f7617c.d().size() == 0 && this.f7617c.a() != null) {
            this.f7617c.a().r();
        }
    }

    public void b(j jVar) {
        int size;
        synchronized (this.f7617c.d()) {
            this.f7617c.d().remove(jVar);
            size = this.f7617c.d().size();
            d.a("BeaconService", "Currently ranging %s regions.", Integer.valueOf(this.f7617c.d().size()));
        }
        if (size == 0 && this.f7617c.c().e() == 0 && this.f7617c.a() != null) {
            this.f7617c.a().r();
        }
    }

    public void a(long j, long j2, boolean z) {
        if (this.f7617c.a() != null) {
            this.f7617c.a().a(j, j2, z);
        }
    }
}
