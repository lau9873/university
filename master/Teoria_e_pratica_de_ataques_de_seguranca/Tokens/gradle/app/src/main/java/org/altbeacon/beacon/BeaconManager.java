package org.altbeacon.beacon;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.altbeacon.beacon.service.BeaconService;
import p193g.p194a.p195a.AltBeaconParser;
import p193g.p194a.p195a.BeaconConsumer;
import p193g.p194a.p195a.MonitorNotifier;
import p193g.p194a.p195a.RangeNotifier;
import p193g.p194a.p195a.Region;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p195a.p199n.C1842o;
import p193g.p194a.p195a.p199n.MonitoringStatus;
import p193g.p194a.p195a.p199n.RunningAverageRssiFilter;
import p193g.p194a.p195a.p199n.ScanJobScheduler;
import p193g.p194a.p195a.p199n.StartRMData;
import p193g.p194a.p195a.p199n.p200r.NonBeaconLeScanCallback;
import p193g.p194a.p195a.p201o.BeaconSimulator;
import p193g.p194a.p195a.p202p.ProcessUtils;

/* loaded from: classes.dex */
public class BeaconManager {

    /* renamed from: A */
    public static String f10571A = "https://s3.amazonaws.com/android-beacon-library/android-distance.json";

    /* renamed from: u */
    public static volatile BeaconManager f10573u = null;

    /* renamed from: v */
    public static boolean f10574v = false;

    /* renamed from: w */
    public static boolean f10575w = false;

    /* renamed from: y */
    public static long f10577y = 10000;

    /* renamed from: z */
    public static BeaconSimulator f10578z;

    /* renamed from: a */
    public final Context f10579a;

    /* renamed from: i */
    public NonBeaconLeScanCallback f10587i;

    /* renamed from: x */
    public static final Object f10576x = new Object();

    /* renamed from: B */
    public static Class f10572B = RunningAverageRssiFilter.class;

    /* renamed from: b */
    public final ConcurrentMap<BeaconConsumer, C2659c> f10580b = new ConcurrentHashMap();

    /* renamed from: c */
    public Messenger f10581c = null;

    /* renamed from: d */
    public final Set<RangeNotifier> f10582d = new CopyOnWriteArraySet();

    /* renamed from: e */
    public RangeNotifier f10583e = null;

    /* renamed from: f */
    public final Set<MonitorNotifier> f10584f = new CopyOnWriteArraySet();

    /* renamed from: g */
    public final ArrayList<Region> f10585g = new ArrayList<>();

    /* renamed from: h */
    public final List<BeaconParser> f10586h = new CopyOnWriteArrayList();

    /* renamed from: j */
    public boolean f10588j = true;

    /* renamed from: k */
    public boolean f10589k = false;

    /* renamed from: l */
    public boolean f10590l = false;

    /* renamed from: m */
    public Boolean f10591m = null;

    /* renamed from: n */
    public boolean f10592n = false;

    /* renamed from: o */
    public Notification f10593o = null;

    /* renamed from: p */
    public int f10594p = -1;

    /* renamed from: q */
    public long f10595q = 1100;

    /* renamed from: r */
    public long f10596r = 0;

    /* renamed from: s */
    public long f10597s = 10000;

    /* renamed from: t */
    public long f10598t = 300000;

    /* loaded from: classes.dex */
    public class ServiceNotDeclaredException extends RuntimeException {
        public ServiceNotDeclaredException(BeaconManager beaconManager) {
            super("The BeaconService is not properly declared in AndroidManifest.xml.  If using Eclipse, please verify that your project.properties has manifestmerger.enabled=true");
        }
    }

    /* renamed from: org.altbeacon.beacon.BeaconManager$b */
    /* loaded from: classes.dex */
    public class ServiceConnectionC2658b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogManager.m2432a("BeaconManager", "we have a connection to the service now", new Object[0]);
            if (BeaconManager.this.f10591m == null) {
                BeaconManager.this.f10591m = false;
            }
            BeaconManager.this.f10581c = new Messenger(iBinder);
            BeaconManager.this.m480a();
            synchronized (BeaconManager.this.f10580b) {
                for (Map.Entry entry : BeaconManager.this.f10580b.entrySet()) {
                    if (!((C2659c) entry.getValue()).f10600a) {
                        ((BeaconConsumer) entry.getKey()).onBeaconServiceConnect();
                        ((C2659c) entry.getValue()).f10600a = true;
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogManager.m2430b("BeaconManager", "onServiceDisconnected", new Object[0]);
            BeaconManager.this.f10581c = null;
        }

        public ServiceConnectionC2658b() {
        }
    }

    /* renamed from: org.altbeacon.beacon.BeaconManager$c */
    /* loaded from: classes.dex */
    public class C2659c {

        /* renamed from: a */
        public boolean f10600a;

        /* renamed from: b */
        public ServiceConnectionC2658b f10601b;

        public C2659c(BeaconManager beaconManager) {
            this.f10600a = false;
            this.f10600a = false;
            this.f10601b = new ServiceConnectionC2658b();
        }
    }

    public BeaconManager(Context context) {
        this.f10579a = context.getApplicationContext();
        m462c();
        if (!f10575w) {
            m486E();
        }
        this.f10586h.add(new AltBeaconParser());
        m489B();
    }

    /* renamed from: F */
    public static BeaconSimulator m485F() {
        return f10578z;
    }

    /* renamed from: G */
    public static String m484G() {
        return f10571A;
    }

    /* renamed from: H */
    public static long m483H() {
        return f10577y;
    }

    /* renamed from: I */
    public static Class m482I() {
        return f10572B;
    }

    /* renamed from: J */
    public static boolean m481J() {
        return f10574v;
    }

    /* renamed from: e */
    public static void m454e(long j) {
        f10577y = j;
        BeaconManager beaconManager = f10573u;
        if (beaconManager != null) {
            beaconManager.m480a();
        }
    }

    /* renamed from: A */
    public boolean m490A() {
        Boolean bool = this.f10591m;
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    /* renamed from: B */
    public final void m489B() {
        this.f10592n = Build.VERSION.SDK_INT >= 26;
    }

    /* renamed from: C */
    public void m488C() {
        if (this.f10592n) {
            if (Build.VERSION.SDK_INT >= 21) {
                ScanJobScheduler.m2319b().m2321a(this.f10579a, this);
                return;
            }
            return;
        }
        try {
            m479a(7, (Region) null);
        } catch (RemoteException e) {
            LogManager.m2430b("BeaconManager", "Failed to sync settings to service", e);
        }
    }

    @TargetApi(18)
    /* renamed from: D */
    public void m487D() {
        if (!m435x()) {
            LogManager.m2427d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        } else if (m458d()) {
        } else {
            LogManager.m2432a("BeaconManager", "updating background flag to %s", Boolean.valueOf(this.f10589k));
            LogManager.m2432a("BeaconManager", "updating scan period to %s, %s", Long.valueOf(m439t()), Long.valueOf(m450i()));
            m479a(6, (Region) null);
        }
    }

    /* renamed from: E */
    public final void m486E() {
        List<ResolveInfo> queryIntentServices = this.f10579a.getPackageManager().queryIntentServices(new Intent(this.f10579a, BeaconService.class), 65536);
        if (queryIntentServices != null && queryIntentServices.isEmpty()) {
            throw new ServiceNotDeclaredException(this);
        }
    }

    /* renamed from: c */
    public void m461c(long j) {
        this.f10596r = j;
    }

    /* renamed from: d */
    public void m457d(long j) {
        this.f10595q = j;
    }

    /* renamed from: f */
    public boolean m453f() {
        return this.f10589k;
    }

    /* renamed from: g */
    public long m452g() {
        return this.f10597s;
    }

    /* renamed from: h */
    public List<BeaconParser> m451h() {
        return this.f10586h;
    }

    /* renamed from: i */
    public final long m450i() {
        if (this.f10589k) {
            return this.f10598t;
        }
        return this.f10596r;
    }

    /* renamed from: j */
    public RangeNotifier m449j() {
        return this.f10583e;
    }

    /* renamed from: k */
    public long m448k() {
        return this.f10596r;
    }

    /* renamed from: l */
    public long m447l() {
        return this.f10595q;
    }

    /* renamed from: m */
    public Notification m446m() {
        return this.f10593o;
    }

    /* renamed from: n */
    public int m445n() {
        return this.f10594p;
    }

    /* renamed from: o */
    public Collection<Region> m444o() {
        return MonitoringStatus.m2405a(this.f10579a).m2394d();
    }

    /* renamed from: p */
    public Set<MonitorNotifier> m443p() {
        return Collections.unmodifiableSet(this.f10584f);
    }

    /* renamed from: q */
    public NonBeaconLeScanCallback m442q() {
        return this.f10587i;
    }

    /* renamed from: r */
    public Collection<Region> m441r() {
        ArrayList arrayList;
        synchronized (this.f10585g) {
            arrayList = new ArrayList(this.f10585g);
        }
        return arrayList;
    }

    /* renamed from: s */
    public Set<RangeNotifier> m440s() {
        return Collections.unmodifiableSet(this.f10582d);
    }

    /* renamed from: t */
    public final long m439t() {
        if (this.f10589k) {
            return this.f10597s;
        }
        return this.f10595q;
    }

    /* renamed from: u */
    public boolean m438u() {
        return this.f10592n;
    }

    /* renamed from: v */
    public boolean m437v() {
        boolean z;
        synchronized (this.f10580b) {
            z = !this.f10580b.isEmpty() && (this.f10592n || this.f10581c != null);
        }
        return z;
    }

    /* renamed from: w */
    public final boolean m436w() {
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.m2427d("BeaconManager", "Bluetooth LE not supported prior to API 18.", new Object[0]);
            return false;
        } else if (this.f10579a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return true;
        } else {
            LogManager.m2427d("BeaconManager", "This device does not support bluetooth LE.", new Object[0]);
            return false;
        }
    }

    /* renamed from: x */
    public final boolean m435x() {
        if (m485F() != null) {
            return true;
        }
        return m436w();
    }

    /* renamed from: y */
    public boolean m434y() {
        return this.f10590l;
    }

    /* renamed from: z */
    public boolean m433z() {
        return this.f10588j;
    }

    /* renamed from: d */
    public static void m456d(boolean z) {
        f10574v = z;
        BeaconManager beaconManager = f10573u;
        if (beaconManager != null) {
            beaconManager.m480a();
        }
    }

    /* renamed from: b */
    public void m467b(long j) {
        this.f10597s = j;
    }

    /* renamed from: c */
    public void m459c(boolean z) {
        this.f10591m = Boolean.valueOf(z);
    }

    /* renamed from: b */
    public boolean m466b(BeaconConsumer beaconConsumer) {
        boolean z;
        synchronized (this.f10580b) {
            if (beaconConsumer != null) {
                try {
                    z = (this.f10580b.get(beaconConsumer) != null && (this.f10592n || this.f10581c != null)) ? true : true;
                } finally {
                }
            }
            z = false;
        }
        return z;
    }

    /* renamed from: c */
    public void m462c() {
        ProcessUtils processUtils = new ProcessUtils(this.f10579a);
        String m2235c = processUtils.m2235c();
        String m2237a = processUtils.m2237a();
        int m2236b = processUtils.m2236b();
        this.f10590l = processUtils.m2234d();
        LogManager.m2428c("BeaconManager", "BeaconManager started up on pid " + m2236b + " named '" + m2235c + "' for application package '" + m2237a + "'.  isMainProcess=" + this.f10590l, new Object[0]);
    }

    /* renamed from: a */
    public void m478a(long j) {
        this.f10598t = j;
        if (Build.VERSION.SDK_INT < 26 || this.f10598t >= 900000) {
            return;
        }
        LogManager.m2427d("BeaconManager", "Setting a short backgroundBetweenScanPeriod has no effect on Android 8+, which is limited to scanning every ~15 minutes", new Object[0]);
    }

    /* renamed from: e */
    public long m455e() {
        return this.f10598t;
    }

    /* renamed from: d */
    public final boolean m458d() {
        if (!m490A() || m434y()) {
            return false;
        }
        LogManager.m2427d("BeaconManager", "Ranging/Monitoring may not be controlled from a separate BeaconScanner process.  To remove this warning, please wrap this call in: if (beaconManager.isMainProcess())", new Object[0]);
        return true;
    }

    /* renamed from: b */
    public void m463b(boolean z) {
        if (!m437v()) {
            if (z && Build.VERSION.SDK_INT < 21) {
                LogManager.m2430b("BeaconManager", "ScanJob may not be configured because JobScheduler is not availble prior to Android 5.0", new Object[0]);
                return;
            }
            if (!z && Build.VERSION.SDK_INT >= 26) {
                LogManager.m2427d("BeaconManager", "Disabling ScanJobs on Android 8+ may disable delivery of beacon callbacks in the background unless a foreground service is active.", new Object[0]);
            }
            if (!z && Build.VERSION.SDK_INT >= 21) {
                ScanJobScheduler.m2319b().m2324a(this.f10579a);
            }
            this.f10592n = z;
            return;
        }
        LogManager.m2430b("BeaconManager", "ScanJob may not be configured because a consumer is already bound.", new Object[0]);
        throw new IllegalStateException("Method must be called before calling bind()");
    }

    /* renamed from: a */
    public static BeaconManager m477a(Context context) {
        BeaconManager beaconManager = f10573u;
        if (beaconManager == null) {
            synchronized (f10576x) {
                beaconManager = f10573u;
                if (beaconManager == null) {
                    beaconManager = new BeaconManager(context);
                    f10573u = beaconManager;
                }
            }
        }
        return beaconManager;
    }

    /* renamed from: c */
    public void m460c(BeaconConsumer beaconConsumer) {
        if (!m435x()) {
            LogManager.m2427d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
            return;
        }
        synchronized (this.f10580b) {
            if (this.f10580b.containsKey(beaconConsumer)) {
                LogManager.m2432a("BeaconManager", "Unbinding", new Object[0]);
                if (this.f10592n) {
                    LogManager.m2432a("BeaconManager", "Not unbinding from scanning service as we are using scan jobs.", new Object[0]);
                } else {
                    beaconConsumer.unbindService(this.f10580b.get(beaconConsumer).f10601b);
                }
                LogManager.m2432a("BeaconManager", "Before unbind, consumer count is " + this.f10580b.size(), new Object[0]);
                this.f10580b.remove(beaconConsumer);
                LogManager.m2432a("BeaconManager", "After unbind, consumer count is " + this.f10580b.size(), new Object[0]);
                if (this.f10580b.size() == 0) {
                    this.f10581c = null;
                    this.f10589k = false;
                    if (this.f10592n && Build.VERSION.SDK_INT >= 21) {
                        LogManager.m2428c("BeaconManager", "Cancelling scheduled jobs after unbind of last consumer.", new Object[0]);
                        ScanJobScheduler.m2319b().m2324a(this.f10579a);
                    }
                }
            } else {
                LogManager.m2432a("BeaconManager", "This consumer is not bound to: %s", beaconConsumer);
                LogManager.m2432a("BeaconManager", "Bound consumers: ", new Object[0]);
                for (Map.Entry<BeaconConsumer, C2659c> entry : this.f10580b.entrySet()) {
                    LogManager.m2432a("BeaconManager", String.valueOf(entry.getValue()), new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    public void m476a(BeaconConsumer beaconConsumer) {
        if (!m435x()) {
            LogManager.m2427d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
            return;
        }
        synchronized (this.f10580b) {
            C2659c c2659c = new C2659c(this);
            if (this.f10580b.putIfAbsent(beaconConsumer, c2659c) != null) {
                LogManager.m2432a("BeaconManager", "This consumer is already bound", new Object[0]);
            } else {
                LogManager.m2432a("BeaconManager", "This consumer is not bound.  Binding now: %s", beaconConsumer);
                if (this.f10592n) {
                    LogManager.m2432a("BeaconManager", "Not starting beacon scanning service. Using scheduled jobs", new Object[0]);
                    beaconConsumer.onBeaconServiceConnect();
                } else {
                    LogManager.m2432a("BeaconManager", "Binding to service", new Object[0]);
                    Intent intent = new Intent(beaconConsumer.getApplicationContext(), BeaconService.class);
                    if (Build.VERSION.SDK_INT >= 26 && m446m() != null) {
                        if (m437v()) {
                            LogManager.m2428c("BeaconManager", "Not starting foreground beacon scanning service.  A consumer is already bound, so it should be started", new Object[0]);
                        } else {
                            LogManager.m2428c("BeaconManager", "Starting foreground beacon scanning service.", new Object[0]);
                            this.f10579a.startForegroundService(intent);
                        }
                    }
                    beaconConsumer.bindService(intent, c2659c.f10601b, 1);
                }
                LogManager.m2432a("BeaconManager", "consumer count is now: %s", Integer.valueOf(this.f10580b.size()));
            }
        }
    }

    @TargetApi(18)
    /* renamed from: b */
    public void m465b(Region region) {
        if (!m435x()) {
            LogManager.m2427d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        } else if (m458d()) {
        } else {
            synchronized (this.f10585g) {
                Region region2 = null;
                Iterator<Region> it = this.f10585g.iterator();
                while (it.hasNext()) {
                    Region next = it.next();
                    if (region.m2472a().equals(next.m2472a())) {
                        region2 = next;
                    }
                }
                this.f10585g.remove(region2);
            }
            m479a(3, region);
        }
    }

    /* renamed from: b */
    public final String m468b() {
        String packageName = this.f10579a.getPackageName();
        LogManager.m2432a("BeaconManager", "callback packageName: %s", packageName);
        return packageName;
    }

    /* renamed from: a */
    public void m469a(boolean z) {
        if (!m435x()) {
            LogManager.m2427d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        } else if (z != this.f10589k) {
            this.f10589k = z;
            try {
                m487D();
            } catch (RemoteException unused) {
                LogManager.m2430b("BeaconManager", "Cannot contact service to set scan periods", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public void m474a(RangeNotifier rangeNotifier) {
        if (rangeNotifier != null) {
            this.f10582d.add(rangeNotifier);
        }
    }

    /* renamed from: a */
    public void m475a(MonitorNotifier monitorNotifier) {
        if (m458d() || monitorNotifier == null) {
            return;
        }
        this.f10584f.add(monitorNotifier);
    }

    @TargetApi(18)
    /* renamed from: a */
    public void m473a(Region region) {
        if (!m435x()) {
            LogManager.m2427d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        } else if (m458d()) {
        } else {
            synchronized (this.f10585g) {
                this.f10585g.add(region);
            }
            m479a(2, region);
        }
    }

    /* renamed from: a */
    public void m480a() {
        if (m458d()) {
            return;
        }
        if (!m437v()) {
            LogManager.m2432a("BeaconManager", "Not synchronizing settings to service, as it has not started up yet", new Object[0]);
        } else if (m490A()) {
            LogManager.m2432a("BeaconManager", "Synchronizing settings to service", new Object[0]);
            m488C();
        } else {
            LogManager.m2432a("BeaconManager", "Not synchronizing settings to service, as it is in the same process", new Object[0]);
        }
    }

    @TargetApi(18)
    /* renamed from: a */
    public final void m479a(int i, Region region) {
        if (!m437v()) {
            LogManager.m2427d("BeaconManager", "The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()", new Object[0]);
        } else if (this.f10592n) {
            if (Build.VERSION.SDK_INT >= 21) {
                ScanJobScheduler.m2319b().m2321a(this.f10579a, this);
            }
        } else {
            Message obtain = Message.obtain(null, i, 0, 0);
            if (i == 6) {
                obtain.setData(new StartRMData(m439t(), m450i(), this.f10589k).m2291f());
            } else if (i == 7) {
                C1842o c1842o = new C1842o();
                c1842o.m2300a(this.f10579a);
                obtain.setData(c1842o.m2301a());
            } else {
                obtain.setData(new StartRMData(region, m468b(), m439t(), m450i(), this.f10589k).m2291f());
            }
            this.f10581c.send(obtain);
        }
    }
}
