package p193g.p194a.p195a.p199n;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
import p193g.p194a.p195a.Beacon;
import p193g.p194a.p195a.Region;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p195a.p199n.p200r.CycledLeScanCallback;
import p193g.p194a.p195a.p199n.p200r.CycledLeScanner;
import p193g.p194a.p195a.p199n.p200r.DistinctPacketDetector;
import p193g.p194a.p195a.p199n.p200r.NonBeaconLeScanCallback;
import p193g.p194a.p195a.p199n.p200r.ScanFilterUtils;
import p193g.p194a.p203b.BluetoothCrashResolver;

/* renamed from: g.a.a.n.l */
/* loaded from: classes.dex */
public class ScanHelper {

    /* renamed from: k */
    public static final String f8590k = "l";

    /* renamed from: a */
    public ExecutorService f8591a;

    /* renamed from: b */
    public BeaconManager f8592b;

    /* renamed from: c */
    public CycledLeScanner f8593c;

    /* renamed from: d */
    public MonitoringStatus f8594d;

    /* renamed from: i */
    public Context f8599i;

    /* renamed from: e */
    public final Map<Region, RangeState> f8595e = new HashMap();

    /* renamed from: f */
    public DistinctPacketDetector f8596f = new DistinctPacketDetector();

    /* renamed from: g */
    public ExtraDataBeaconTracker f8597g = new ExtraDataBeaconTracker();

    /* renamed from: h */
    public Set<BeaconParser> f8598h = new HashSet();

    /* renamed from: j */
    public final CycledLeScanCallback f8600j = new C1839a();

    /* compiled from: ScanHelper.java */
    /* renamed from: g.a.a.n.l$a */
    /* loaded from: classes.dex */
    public class C1839a implements CycledLeScanCallback {
        public C1839a() {
        }

        @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanCallback
        @SuppressLint({"WrongThread"})
        /* renamed from: a */
        public void mo2281a() {
            if (BeaconManager.m485F() != null) {
                LogManager.m2432a(ScanHelper.f8590k, "Beacon simulator enabled", new Object[0]);
                if (BeaconManager.m485F().m2238a() != null) {
                    ApplicationInfo applicationInfo = ScanHelper.this.f8599i.getApplicationInfo();
                    int i = applicationInfo.flags & 2;
                    applicationInfo.flags = i;
                    if (i != 0) {
                        String str = ScanHelper.f8590k;
                        LogManager.m2432a(str, "Beacon simulator returns " + BeaconManager.m485F().m2238a().size() + " beacons.", new Object[0]);
                        for (Beacon beacon : BeaconManager.m485F().m2238a()) {
                            ScanHelper.this.m2353a(beacon);
                        }
                    } else {
                        LogManager.m2427d(ScanHelper.f8590k, "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.", new Object[0]);
                    }
                } else {
                    LogManager.m2427d(ScanHelper.f8590k, "getBeacons is returning null. No simulated beacons to report.", new Object[0]);
                }
            } else if (LogManager.m2433a()) {
                LogManager.m2432a(ScanHelper.f8590k, "Beacon simulator not enabled", new Object[0]);
            }
            ScanHelper.this.f8596f.m2244a();
            ScanHelper.this.f8594d.m2386k();
            ScanHelper.this.m2334f();
        }

        @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanCallback
        @TargetApi(11)
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            ScanHelper.this.m2354a(bluetoothDevice, i, bArr);
        }
    }

    /* compiled from: ScanHelper.java */
    /* renamed from: g.a.a.n.l$b */
    /* loaded from: classes.dex */
    public class C1840b {

        /* renamed from: a */
        public final int f8602a;

        /* renamed from: b */
        public BluetoothDevice f8603b;

        /* renamed from: c */
        public byte[] f8604c;

        public C1840b(ScanHelper scanHelper, BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            this.f8603b = bluetoothDevice;
            this.f8602a = i;
            this.f8604c = bArr;
        }
    }

    /* compiled from: ScanHelper.java */
    /* renamed from: g.a.a.n.l$c */
    /* loaded from: classes.dex */
    public class AsyncTaskC1841c extends AsyncTask<C1840b, Void, Void> {

        /* renamed from: a */
        public final DetectionTracker f8605a = DetectionTracker.m2416c();

        /* renamed from: b */
        public final NonBeaconLeScanCallback f8606b;

        public AsyncTaskC1841c(NonBeaconLeScanCallback nonBeaconLeScanCallback) {
            this.f8606b = nonBeaconLeScanCallback;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(C1840b... c1840bArr) {
            C1840b c1840b = c1840bArr[0];
            Iterator it = ScanHelper.this.f8598h.iterator();
            Beacon beacon = null;
            while (it.hasNext() && (beacon = ((BeaconParser) it.next()).mo425a(c1840b.f8604c, c1840b.f8602a, c1840b.f8603b)) == null) {
            }
            if (beacon != null) {
                if (LogManager.m2433a()) {
                    LogManager.m2432a(ScanHelper.f8590k, "Beacon packet detected for: " + beacon + " with rssi " + beacon.m2496i(), new Object[0]);
                }
                this.f8605a.m2417b();
                if (ScanHelper.this.f8593c != null && !ScanHelper.this.f8593c.m2266j() && !ScanHelper.this.f8596f.m2243a(c1840b.f8603b.getAddress(), c1840b.f8604c)) {
                    LogManager.m2428c(ScanHelper.f8590k, "Non-distinct packets detected in a single scan.  Restarting scans unecessary.", new Object[0]);
                    ScanHelper.this.f8593c.m2274a(true);
                }
                ScanHelper.this.m2353a(beacon);
            } else {
                NonBeaconLeScanCallback nonBeaconLeScanCallback = this.f8606b;
                if (nonBeaconLeScanCallback != null) {
                    nonBeaconLeScanCallback.m2242a(c1840b.f8603b, c1840b.f8602a, c1840b.f8604c);
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Void r1) {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onProgressUpdate(Void... voidArr) {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
        }
    }

    public ScanHelper(Context context) {
        this.f8599i = context;
        this.f8592b = BeaconManager.m477a(context);
    }

    /* renamed from: a */
    public void m2347a(List<Beacon> list) {
    }

    public void finalize() {
        super.finalize();
        m2330i();
    }

    /* renamed from: g */
    public void m2332g() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f8592b.m451h());
        boolean z = true;
        for (BeaconParser beaconParser : this.f8592b.m451h()) {
            if (beaconParser.m422b().size() > 0) {
                z = false;
                hashSet.addAll(beaconParser.m422b());
            }
        }
        this.f8598h = hashSet;
        this.f8597g = new ExtraDataBeaconTracker(z);
    }

    /* renamed from: h */
    public void m2331h() {
        try {
            BluetoothAdapter adapter = ((BluetoothManager) this.f8599i.getApplicationContext().getSystemService("bluetooth")).getAdapter();
            if (adapter == null) {
                LogManager.m2427d(f8590k, "Failed to construct a BluetoothAdapter", new Object[0]);
            } else if (!adapter.isEnabled()) {
                LogManager.m2427d(f8590k, "BluetoothAdapter is not enabled", new Object[0]);
            } else {
                BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.stopScan(m2336e());
                }
            }
        } catch (NullPointerException e) {
            LogManager.m2430b(f8590k, "NullPointerException stopping Android O background scanner", e);
        } catch (SecurityException unused) {
            LogManager.m2430b(f8590k, "SecurityException stopping Android O background scanner", new Object[0]);
        } catch (RuntimeException e2) {
            LogManager.m2430b(f8590k, "Unexpected runtime exception stopping Android O background scanner", e2);
        }
    }

    /* renamed from: i */
    public void m2330i() {
        ExecutorService executorService = this.f8591a;
        if (executorService != null) {
            executorService.shutdown();
            try {
                if (!this.f8591a.awaitTermination(10L, TimeUnit.MILLISECONDS)) {
                    LogManager.m2430b(f8590k, "Can't stop beacon parsing thread.", new Object[0]);
                }
            } catch (InterruptedException unused) {
                LogManager.m2430b(f8590k, "Interrupted waiting to stop beacon parsing thread.", new Object[0]);
            }
            this.f8591a = null;
        }
    }

    /* renamed from: b */
    public final ExecutorService m2343b() {
        if (this.f8591a == null) {
            this.f8591a = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        }
        return this.f8591a;
    }

    /* renamed from: c */
    public MonitoringStatus m2340c() {
        return this.f8594d;
    }

    /* renamed from: d */
    public Map<Region, RangeState> m2338d() {
        return this.f8595e;
    }

    /* renamed from: e */
    public PendingIntent m2336e() {
        Intent intent = new Intent(this.f8599i, StartupBroadcastReceiver.class);
        intent.putExtra("o-scan", true);
        return PendingIntent.getBroadcast(this.f8599i, 0, intent, 134217728);
    }

    /* renamed from: f */
    public final void m2334f() {
        synchronized (this.f8595e) {
            for (Region region : this.f8595e.keySet()) {
                RangeState rangeState = this.f8595e.get(region);
                LogManager.m2432a(f8590k, "Calling ranging callback", new Object[0]);
                rangeState.m2382b().m2419a(this.f8599i, "rangingData", new RangingData(rangeState.m2385a(), region).m2367c());
            }
        }
    }

    /* renamed from: a */
    public CycledLeScanner m2355a() {
        return this.f8593c;
    }

    /* renamed from: a */
    public void m2350a(MonitoringStatus monitoringStatus) {
        this.f8594d = monitoringStatus;
    }

    /* renamed from: a */
    public void m2346a(Map<Region, RangeState> map) {
        synchronized (this.f8595e) {
            this.f8595e.clear();
            this.f8595e.putAll(map);
        }
    }

    /* renamed from: b */
    public void m2341b(Set<BeaconParser> set) {
        ScanSettings build = new ScanSettings.Builder().setScanMode(0).build();
        List<ScanFilter> m2240a = new ScanFilterUtils().m2240a(new ArrayList(set));
        try {
            BluetoothAdapter adapter = ((BluetoothManager) this.f8599i.getApplicationContext().getSystemService("bluetooth")).getAdapter();
            if (adapter == null) {
                LogManager.m2427d(f8590k, "Failed to construct a BluetoothAdapter", new Object[0]);
            } else if (!adapter.isEnabled()) {
                LogManager.m2427d(f8590k, "Failed to start background scan on Android O: BluetoothAdapter is not enabled", new Object[0]);
            } else {
                BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    int startScan = bluetoothLeScanner.startScan(m2240a, build, m2336e());
                    if (startScan != 0) {
                        String str = f8590k;
                        LogManager.m2430b(str, "Failed to start background scan on Android O.  Code: " + startScan, new Object[0]);
                    } else {
                        LogManager.m2432a(f8590k, "Started passive beacon scan", new Object[0]);
                    }
                } else {
                    LogManager.m2430b(f8590k, "Failed to start background scan on Android O: scanner is null", new Object[0]);
                }
            }
        } catch (NullPointerException e) {
            LogManager.m2430b(f8590k, "NullPointerException starting Android O background scanner", e);
        } catch (SecurityException unused) {
            LogManager.m2430b(f8590k, "SecurityException making Android O background scanner", new Object[0]);
        } catch (RuntimeException e2) {
            LogManager.m2430b(f8590k, "Unexpected runtime exception starting Android O background scanner", e2);
        }
    }

    /* renamed from: a */
    public void m2351a(ExtraDataBeaconTracker extraDataBeaconTracker) {
        this.f8597g = extraDataBeaconTracker;
    }

    /* renamed from: a */
    public void m2345a(Set<BeaconParser> set) {
        this.f8598h = set;
    }

    /* renamed from: a */
    public void m2344a(boolean z, BluetoothCrashResolver bluetoothCrashResolver) {
        this.f8593c = CycledLeScanner.m2278a(this.f8599i, 1100L, 0L, z, this.f8600j, bluetoothCrashResolver);
    }

    @TargetApi(11)
    /* renamed from: a */
    public void m2354a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        try {
            new AsyncTaskC1841c(this.f8592b.m442q()).executeOnExecutor(m2343b(), new C1840b(this, bluetoothDevice, i, bArr));
        } catch (OutOfMemoryError unused) {
            LogManager.m2427d(f8590k, "Ignoring scan result because we cannot start a thread to keep up.", new Object[0]);
        } catch (RejectedExecutionException unused2) {
            LogManager.m2427d(f8590k, "Ignoring scan result because we cannot keep up.", new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m2353a(Beacon beacon) {
        if (Stats.m2282f().m2286b()) {
            Stats.m2282f().m2289a(beacon);
        }
        if (LogManager.m2433a()) {
            LogManager.m2432a(f8590k, "beacon detected : %s", beacon.toString());
        }
        Beacon m2414b = this.f8597g.m2414b(beacon);
        if (m2414b == null) {
            if (LogManager.m2433a()) {
                LogManager.m2432a(f8590k, "not processing detections for GATT extra data beacon", new Object[0]);
                return;
            }
            return;
        }
        this.f8594d.m2399b(m2414b);
        LogManager.m2432a(f8590k, "looking for ranging region matches for this beacon", new Object[0]);
        synchronized (this.f8595e) {
            for (Region region : m2352a(m2414b, this.f8595e.keySet())) {
                LogManager.m2432a(f8590k, "matches ranging region: %s", region);
                RangeState rangeState = this.f8595e.get(region);
                if (rangeState != null) {
                    rangeState.m2384a(m2414b);
                }
            }
        }
    }

    /* renamed from: a */
    public final List<Region> m2352a(Beacon beacon, Collection<Region> collection) {
        ArrayList arrayList = new ArrayList();
        for (Region region : collection) {
            if (region != null) {
                if (region.m2470a(beacon)) {
                    arrayList.add(region);
                } else {
                    LogManager.m2432a(f8590k, "This region (%s) does not match beacon: %s", region, beacon);
                }
            }
        }
        return arrayList;
    }
}
