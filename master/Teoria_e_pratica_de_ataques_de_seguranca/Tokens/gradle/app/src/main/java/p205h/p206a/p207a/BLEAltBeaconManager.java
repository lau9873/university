package p205h.p206a.p207a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.BeaconConsumer;
import p193g.p194a.p195a.MonitorNotifier;
import p193g.p194a.p195a.RangeNotifier;
import p193g.p194a.p195a.Region;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.BackendListeners;

/* renamed from: h.a.a.e */
/* loaded from: classes.dex */
public class BLEAltBeaconManager implements BeaconConsumer {

    /* renamed from: a */
    public final Context f8769a;

    /* renamed from: b */
    public BeaconManager f8770b;

    /* renamed from: c */
    public Region f8771c;

    /* renamed from: d */
    public InterfaceC1896d f8772d;

    /* renamed from: e */
    public LocationTracker f8773e;

    /* renamed from: f */
    public boolean f8774f = false;

    /* renamed from: g */
    public boolean f8775g = false;

    /* renamed from: h */
    public long f8776h = 5000;

    /* renamed from: i */
    public long f8777i = 3000;

    /* renamed from: j */
    public MonitorNotifier f8778j = new C1892a(this);

    /* renamed from: k */
    public RangeNotifier f8779k = new C1893b();

    /* renamed from: l */
    public BroadcastReceiver f8780l = new C1895c();

    /* compiled from: BLEAltBeaconManager.java */
    /* renamed from: h.a.a.e$a */
    /* loaded from: classes.dex */
    public class C1892a implements MonitorNotifier {
        public C1892a(BLEAltBeaconManager bLEAltBeaconManager) {
        }

        @Override // p193g.p194a.p195a.MonitorNotifier
        public void didDetermineStateForRegion(int i, Region region) {
            L.m1579b("");
        }

        @Override // p193g.p194a.p195a.MonitorNotifier
        public void didEnterRegion(Region region) {
            L.m1579b("");
        }

        @Override // p193g.p194a.p195a.MonitorNotifier
        public void didExitRegion(Region region) {
            L.m1579b("");
        }
    }

    /* compiled from: BLEAltBeaconManager.java */
    /* renamed from: h.a.a.e$b */
    /* loaded from: classes.dex */
    public class C1893b implements RangeNotifier {

        /* compiled from: BLEAltBeaconManager.java */
        /* renamed from: h.a.a.e$b$a */
        /* loaded from: classes.dex */
        public class C1894a implements BackendListeners.InterfaceC2675c {

            /* renamed from: a */
            public final /* synthetic */ List f8782a;

            public C1894a(List list) {
                this.f8782a = list;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2675c
            /* renamed from: a */
            public void mo337a(Location location) {
                try {
                    if (BLEAltBeaconManager.this.f8772d != null) {
                        BLEAltBeaconManager.this.f8772d.mo1874a(SysDateManager.m1497d().m1493h(), SysDateManager.m1497d().m1494g(), this.f8782a, location != null ? location.getLatitude() : 0.0d, location != null ? location.getLongitude() : 0.0d, location != null ? location.getAccuracy() : 0.0d);
                    }
                } catch (Throwable th) {
                    AppLog.m2158a("COMM_BLUETOOTH", "BLEAltBeaconManager", "didRangeBeaconsInRegion", "Error while reporting to listener: " + Log.getStackTraceString(th));
                }
            }
        }

        public C1893b() {
        }

        @Override // p193g.p194a.p195a.RangeNotifier
        public void didRangeBeaconsInRegion(Collection<Beacon> collection, Region region) {
            AppLog.m2158a("COMM_BLUETOOTH", "BLEAltBeaconManager", "didRangeBeaconsInRegion", (collection == null || collection.size() <= 0) ? "No beacons found" : collection.size() + " beacons found");
            if (collection == null || collection.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Beacon beacon : collection) {
                if (beacon.m2495j() == 65194 && beacon.m2513a() == 0) {
                    AppLog.m2158a("COMM_BLUETOOTH", "BLEAltBeaconManager", "didRangeBeaconsInRegion", "BLE scan result found: " + beacon.m2506b());
                    byte[] bArr = null;
                    if (beacon.m2498g() != null && beacon.m2498g().m2479b() == 10 && beacon.m2497h() != null && beacon.m2497h().m2479b() == 6) {
                        bArr = Arrays.copyOf(beacon.m2498g().m2477c(), beacon.m2498g().m2479b() + beacon.m2497h().m2479b());
                        System.arraycopy(beacon.m2497h().m2477c(), 0, bArr, beacon.m2498g().m2479b(), beacon.m2497h().m2479b());
                    }
                    arrayList.add(new BLEDevice(beacon.m2506b(), beacon.m2504c(), beacon.m2494k(), beacon.m2496i(), bArr));
                }
            }
            if (!BLEAltBeaconManager.this.f8774f || BLEAltBeaconManager.this.f8773e == null) {
                if (BLEAltBeaconManager.this.f8772d != null) {
                    BLEAltBeaconManager.this.f8772d.mo1874a(SysDateManager.m1497d().m1493h(), SysDateManager.m1497d().m1494g(), arrayList, 0.0d, 0.0d, 0.0d);
                    return;
                }
                return;
            }
            BLEAltBeaconManager.this.f8773e.m1575a(new C1894a(arrayList));
        }
    }

    /* compiled from: BLEAltBeaconManager.java */
    /* renamed from: h.a.a.e$c */
    /* loaded from: classes.dex */
    public class C1895c extends BroadcastReceiver {
        public C1895c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.SCREEN_ON")) {
                if (BLEAltBeaconManager.this.f8775g) {
                    if (!Build.MANUFACTURER.equalsIgnoreCase("Huawei")) {
                        BLEAltBeaconManager.this.f8775g = false;
                    } else {
                        AppLog.m2158a("COMM_BLUETOOTH", "BLEAltBeaconManager", "screenStateReceiver", "Huawei device with screen on detected");
                        BLEAltBeaconManager.this.f8775g = false;
                    }
                    BLEAltBeaconManager bLEAltBeaconManager = BLEAltBeaconManager.this;
                    bLEAltBeaconManager.m2132a(bLEAltBeaconManager.f8776h, BLEAltBeaconManager.this.f8777i);
                }
            } else if (action.equals("android.intent.action.SCREEN_OFF") && !BLEAltBeaconManager.this.f8775g && Build.MANUFACTURER.equalsIgnoreCase("Huawei")) {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEAltBeaconManager", "screenStateReceiver", "Huawei device with screen off detected");
                BLEAltBeaconManager.this.f8775g = true;
                BLEAltBeaconManager bLEAltBeaconManager2 = BLEAltBeaconManager.this;
                bLEAltBeaconManager2.m2132a(Long.MAX_VALUE, bLEAltBeaconManager2.f8777i);
            }
        }
    }

    /* compiled from: BLEAltBeaconManager.java */
    /* renamed from: h.a.a.e$d */
    /* loaded from: classes.dex */
    public interface InterfaceC1896d {
        /* renamed from: a */
        void mo1874a(long j, long j2, List<BLEDevice> list, double d, double d2, double d3);
    }

    public BLEAltBeaconManager(Context context) {
        this.f8771c = null;
        Context context2 = (Context) C2222t.m1569a(context);
        this.f8769a = context2;
        BeaconManager m477a = BeaconManager.m477a(context2);
        this.f8770b = m477a;
        List<BeaconParser> m451h = m477a.m451h();
        BeaconParser beaconParser = new BeaconParser();
        beaconParser.m429a("s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19");
        m451h.add(beaconParser);
        this.f8771c = new Region("pt.card4b.backendbeacons", null, null, null);
        try {
            this.f8773e = new LocationTracker();
        } catch (Throwable th) {
            this.f8773e = null;
            AppLog.m2158a("COMM_BLUETOOTH", "BLEAltBeaconManager", "BLEAltBeaconManager", "Failed to create location tracker instance." + Log.getStackTraceString(th));
        }
        this.f8770b.m463b(false);
        this.f8770b.m475a(this.f8778j);
        this.f8770b.m474a(this.f8779k);
    }

    @Override // p193g.p194a.p195a.BeaconConsumer
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return App.getContext().bindService(intent, serviceConnection, i);
    }

    @Override // p193g.p194a.p195a.BeaconConsumer
    public Context getApplicationContext() {
        return this.f8769a;
    }

    @Override // p193g.p194a.p195a.BeaconConsumer
    public void onBeaconServiceConnect() {
        try {
            this.f8770b.m469a(false);
            this.f8770b.m473a(this.f8771c);
        } catch (Throwable unused) {
        }
    }

    @Override // p193g.p194a.p195a.BeaconConsumer
    public void unbindService(ServiceConnection serviceConnection) {
        App.getContext().unbindService(serviceConnection);
    }

    /* renamed from: b */
    public void m2125b(long j, long j2) {
        this.f8776h = j;
        this.f8777i = j2;
        m2132a(j, j2);
    }

    /* renamed from: c */
    public void m2123c() {
        try {
            if (this.f8770b.m466b(this)) {
                this.f8770b.m465b(this.f8771c);
                this.f8770b.m460c(this);
            }
            App.getContext().unregisterReceiver(this.f8780l);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2132a(long j, long j2) {
        this.f8770b.m457d(this.f8776h);
        this.f8770b.m461c(this.f8777i);
        this.f8770b.m467b(this.f8776h);
        this.f8770b.m478a(this.f8777i);
        this.f8770b.m480a();
    }

    /* renamed from: b */
    public void m2126b() {
        try {
            if (!this.f8770b.m466b(this)) {
                this.f8770b.m476a(this);
            }
            if (((PowerManager) getApplicationContext().getSystemService("power")).isInteractive()) {
                this.f8775g = false;
            } else if (Build.MANUFACTURER.equalsIgnoreCase("Huawei")) {
                this.f8775g = true;
                AppLog.m2158a("COMM_BLUETOOTH", "BLEAltBeaconManager", "onCreate", "Huawei device with screen off detected");
                m2132a(Long.MAX_VALUE, this.f8777i);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            App.getContext().registerReceiver(this.f8780l, intentFilter);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m2127a(boolean z) {
        this.f8774f = z;
    }

    /* renamed from: a */
    public void m2133a() {
        m2123c();
    }

    /* renamed from: a */
    public void m2131a(InterfaceC1896d interfaceC1896d) {
        this.f8772d = interfaceC1896d;
    }
}
