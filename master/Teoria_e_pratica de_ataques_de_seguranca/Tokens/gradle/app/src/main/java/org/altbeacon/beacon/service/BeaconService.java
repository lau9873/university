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
import com.j256.ormlite.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.BeaconLocalBroadcastProcessor;
import p193g.p194a.p195a.Region;
import p193g.p194a.p195a.p197l.ModelSpecificDistanceCalculator;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p195a.p199n.C1836a;
import p193g.p194a.p195a.p199n.C1842o;
import p193g.p194a.p195a.p199n.ExtraDataBeaconTracker;
import p193g.p194a.p195a.p199n.MonitoringStatus;
import p193g.p194a.p195a.p199n.RangeState;
import p193g.p194a.p195a.p199n.ScanHelper;
import p193g.p194a.p195a.p199n.StartRMData;
import p193g.p194a.p195a.p202p.ProcessUtils;
import p193g.p194a.p203b.BluetoothCrashResolver;

/* loaded from: classes.dex */
public class BeaconService extends Service {

    /* renamed from: b */
    public BluetoothCrashResolver f10633b;

    /* renamed from: c */
    public ScanHelper f10634c;

    /* renamed from: d */
    public BeaconLocalBroadcastProcessor f10635d;

    /* renamed from: a */
    public final Handler f10632a = new Handler();

    /* renamed from: e */
    public final Messenger f10636e = new Messenger(new HandlerC2660a(this));

    /* renamed from: org.altbeacon.beacon.service.BeaconService$a */
    /* loaded from: classes.dex */
    public static class HandlerC2660a extends Handler {

        /* renamed from: a */
        public final WeakReference<BeaconService> f10637a;

        public HandlerC2660a(BeaconService beaconService) {
            super(Looper.getMainLooper());
            this.f10637a = new WeakReference<>(beaconService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BeaconService beaconService = this.f10637a.get();
            if (beaconService != null) {
                StartRMData m2296a = StartRMData.m2296a(message.getData());
                if (m2296a != null) {
                    int i = message.what;
                    if (i == 2) {
                        LogManager.m2428c("BeaconService", "start ranging received", new Object[0]);
                        beaconService.m407b(m2296a.m2293d(), new C1836a(m2296a.m2294c()));
                        beaconService.m413a(m2296a.m2292e(), m2296a.m2295b(), m2296a.m2297a());
                    } else if (i == 3) {
                        LogManager.m2428c("BeaconService", "stop ranging received", new Object[0]);
                        beaconService.m408b(m2296a.m2293d());
                        beaconService.m413a(m2296a.m2292e(), m2296a.m2295b(), m2296a.m2297a());
                    } else if (i == 4) {
                        LogManager.m2428c("BeaconService", "start monitoring received", new Object[0]);
                        beaconService.m411a(m2296a.m2293d(), new C1836a(m2296a.m2294c()));
                        beaconService.m413a(m2296a.m2292e(), m2296a.m2295b(), m2296a.m2297a());
                    } else if (i == 5) {
                        LogManager.m2428c("BeaconService", "stop monitoring received", new Object[0]);
                        beaconService.m412a(m2296a.m2293d());
                        beaconService.m413a(m2296a.m2292e(), m2296a.m2295b(), m2296a.m2297a());
                    } else if (i != 6) {
                        super.handleMessage(message);
                    } else {
                        LogManager.m2428c("BeaconService", "set scan intervals received", new Object[0]);
                        beaconService.m413a(m2296a.m2292e(), m2296a.m2295b(), m2296a.m2297a());
                    }
                } else if (message.what == 7) {
                    LogManager.m2428c("BeaconService", "Received settings update from other process", new Object[0]);
                    C1842o m2299a = C1842o.m2299a(message.getData());
                    if (m2299a != null) {
                        m2299a.m2298a(beaconService);
                    } else {
                        LogManager.m2427d("BeaconService", "Settings data missing", new Object[0]);
                    }
                } else {
                    LogManager.m2428c("BeaconService", "Received unknown message from other process : " + message.what, new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m414a() {
        if (this.f10635d == null) {
            this.f10635d = new BeaconLocalBroadcastProcessor(this);
            this.f10635d.m2488a();
        }
    }

    /* renamed from: b */
    public final PendingIntent m409b() {
        return PendingIntent.getBroadcast(getApplicationContext(), 1, new Intent(getApplicationContext(), StartupBroadcastReceiver.class), 1073741824);
    }

    /* renamed from: c */
    public void m406c() {
        this.f10634c.m2332g();
    }

    /* renamed from: d */
    public final void m405d() {
        BeaconManager m477a = BeaconManager.m477a(getApplicationContext());
        Notification m446m = m477a.m446m();
        int m445n = m477a.m445n();
        if (m446m == null || Build.VERSION.SDK_INT < 16) {
            return;
        }
        startForeground(m445n, m446m);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogManager.m2428c("BeaconService", "binding", new Object[0]);
        return this.f10636e.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        if (Build.VERSION.SDK_INT < 21) {
            this.f10633b = new BluetoothCrashResolver(this);
            this.f10633b.m2215i();
        }
        this.f10634c = new ScanHelper(this);
        if (this.f10634c.m2355a() == null) {
            this.f10634c.m2344a(false, this.f10633b);
        }
        this.f10634c.m2350a(MonitoringStatus.m2405a(this));
        this.f10634c.m2346a(new HashMap());
        this.f10634c.m2345a(new HashSet());
        this.f10634c.m2351a(new ExtraDataBeaconTracker());
        BeaconManager m477a = BeaconManager.m477a(getApplicationContext());
        m477a.m459c(true);
        if (m477a.m434y()) {
            LogManager.m2428c("BeaconService", "beaconService version %s is starting up on the main process", "2.16.3");
            m414a();
        } else {
            LogManager.m2428c("BeaconService", "beaconService version %s is starting up on a separate process", "2.16.3");
            ProcessUtils processUtils = new ProcessUtils(this);
            LogManager.m2428c("BeaconService", "beaconService PID is " + processUtils.m2236b() + " with process name " + processUtils.m2235c(), new Object[0]);
        }
        String m410a = m410a("longScanForcingEnabled");
        if (m410a != null && m410a.equals("true")) {
            LogManager.m2428c("BeaconService", "longScanForcingEnabled to keep scans going on Android N for > 30 minutes", new Object[0]);
            if (this.f10634c.m2355a() != null) {
                this.f10634c.m2355a().m2272b(true);
            }
        }
        this.f10634c.m2332g();
        Beacon.m2509a(new ModelSpecificDistanceCalculator(this, BeaconManager.m484G()));
        try {
            this.f10634c.m2347a((List) Class.forName("org.altbeacon.beacon.SimulatedScanData").getField("beacons").get(null));
        } catch (ClassNotFoundException unused) {
            LogManager.m2432a("BeaconService", "No org.altbeacon.beacon.SimulatedScanData class exists.", new Object[0]);
        } catch (Exception e) {
            LogManager.m2431a(e, "BeaconService", "Cannot get simulated Scan data.  Make sure your org.altbeacon.beacon.SimulatedScanData class defines a field with the signature 'public static List<Beacon> beacons'", new Object[0]);
        }
        m405d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogManager.m2430b("BeaconService", "onDestroy()", new Object[0]);
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.m2427d("BeaconService", "Not supported prior to API 18.", new Object[0]);
            return;
        }
        BeaconLocalBroadcastProcessor beaconLocalBroadcastProcessor = this.f10635d;
        if (beaconLocalBroadcastProcessor != null) {
            beaconLocalBroadcastProcessor.m2487b();
        }
        BluetoothCrashResolver bluetoothCrashResolver = this.f10633b;
        if (bluetoothCrashResolver != null) {
            bluetoothCrashResolver.m2213k();
        }
        LogManager.m2428c("BeaconService", "onDestroy called.  stopping scanning", new Object[0]);
        this.f10632a.removeCallbacksAndMessages(null);
        if (this.f10634c.m2355a() != null) {
            this.f10634c.m2355a().m2259r();
            this.f10634c.m2355a().m2269f();
        }
        this.f10634c.m2340c().m2387j();
        this.f10634c.m2330i();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        if (intent == null) {
            str = "starting with null intent";
        } else {
            str = "starting with intent " + intent.toString();
        }
        LogManager.m2428c("BeaconService", str, new Object[0]);
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        LogManager.m2432a("BeaconService", "task removed", new Object[0]);
        if (Build.VERSION.RELEASE.contains("4.4.1") || Build.VERSION.RELEASE.contains("4.4.2") || Build.VERSION.RELEASE.contains("4.4.3")) {
            ((AlarmManager) getApplicationContext().getSystemService("alarm")).set(0, System.currentTimeMillis() + 1000, m409b());
            LogManager.m2432a("BeaconService", "Setting a wakeup alarm to go off due to Android 4.4.2 service restarting bug.", new Object[0]);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        LogManager.m2428c("BeaconService", "unbinding so destroying self", new Object[0]);
        stopForeground(true);
        stopSelf();
        return false;
    }

    /* renamed from: b */
    public void m407b(Region region, C1836a c1836a) {
        synchronized (this.f10634c.m2338d()) {
            if (this.f10634c.m2338d().containsKey(region)) {
                LogManager.m2428c("BeaconService", "Already ranging that region -- will replace existing region.", new Object[0]);
                this.f10634c.m2338d().remove(region);
            }
            this.f10634c.m2338d().put(region, new RangeState(c1836a));
            LogManager.m2432a("BeaconService", "Currently ranging %s regions.", Integer.valueOf(this.f10634c.m2338d().size()));
        }
        if (this.f10634c.m2355a() != null) {
            this.f10634c.m2355a().m2260p();
        }
    }

    /* renamed from: a */
    public final String m410a(String str) {
        try {
            ServiceInfo serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, BeaconService.class), Logger.DEFAULT_FULL_MESSAGE_LENGTH);
            if (serviceInfo == null || ((PackageItemInfo) serviceInfo).metaData == null) {
                return null;
            }
            return ((PackageItemInfo) serviceInfo).metaData.get(str).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void m411a(Region region, C1836a c1836a) {
        LogManager.m2432a("BeaconService", "startMonitoring called", new Object[0]);
        this.f10634c.m2340c().m2397b(region, c1836a);
        LogManager.m2432a("BeaconService", "Currently monitoring %s regions.", Integer.valueOf(this.f10634c.m2340c().m2392e()));
        if (this.f10634c.m2355a() != null) {
            this.f10634c.m2355a().m2260p();
        }
    }

    /* renamed from: a */
    public void m412a(Region region) {
        LogManager.m2432a("BeaconService", "stopMonitoring called", new Object[0]);
        this.f10634c.m2340c().m2395c(region);
        LogManager.m2432a("BeaconService", "Currently monitoring %s regions.", Integer.valueOf(this.f10634c.m2340c().m2392e()));
        if (this.f10634c.m2340c().m2392e() == 0 && this.f10634c.m2338d().size() == 0 && this.f10634c.m2355a() != null) {
            this.f10634c.m2355a().m2259r();
        }
    }

    /* renamed from: b */
    public void m408b(Region region) {
        int size;
        synchronized (this.f10634c.m2338d()) {
            this.f10634c.m2338d().remove(region);
            size = this.f10634c.m2338d().size();
            LogManager.m2432a("BeaconService", "Currently ranging %s regions.", Integer.valueOf(this.f10634c.m2338d().size()));
        }
        if (size == 0 && this.f10634c.m2340c().m2392e() == 0 && this.f10634c.m2355a() != null) {
            this.f10634c.m2355a().m2259r();
        }
    }

    /* renamed from: a */
    public void m413a(long j, long j2, boolean z) {
        if (this.f10634c.m2355a() != null) {
            this.f10634c.m2355a().m2279a(j, j2, z);
        }
    }
}
