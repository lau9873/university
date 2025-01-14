package g.a.a.n;

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
/* compiled from: ScanHelper.java */
/* loaded from: classes.dex */
public class l {
    public static final String k = "l";

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f6128a;

    /* renamed from: b  reason: collision with root package name */
    public BeaconManager f6129b;

    /* renamed from: c  reason: collision with root package name */
    public g.a.a.n.r.b f6130c;

    /* renamed from: d  reason: collision with root package name */
    public e f6131d;

    /* renamed from: i  reason: collision with root package name */
    public Context f6136i;

    /* renamed from: e  reason: collision with root package name */
    public final Map<g.a.a.j, f> f6132e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public g.a.a.n.r.f f6133f = new g.a.a.n.r.f();

    /* renamed from: g  reason: collision with root package name */
    public g.a.a.n.c f6134g = new g.a.a.n.c();

    /* renamed from: h  reason: collision with root package name */
    public Set<BeaconParser> f6135h = new HashSet();
    public final g.a.a.n.r.a j = new a();

    /* compiled from: ScanHelper.java */
    /* loaded from: classes.dex */
    public class a implements g.a.a.n.r.a {
        public a() {
        }

        @Override // g.a.a.n.r.a
        @SuppressLint({"WrongThread"})
        public void a() {
            if (BeaconManager.F() != null) {
                g.a.a.m.d.a(l.k, "Beacon simulator enabled", new Object[0]);
                if (BeaconManager.F().a() != null) {
                    ApplicationInfo applicationInfo = l.this.f6136i.getApplicationInfo();
                    int i2 = applicationInfo.flags & 2;
                    applicationInfo.flags = i2;
                    if (i2 != 0) {
                        String str = l.k;
                        g.a.a.m.d.a(str, "Beacon simulator returns " + BeaconManager.F().a().size() + " beacons.", new Object[0]);
                        for (g.a.a.c cVar : BeaconManager.F().a()) {
                            l.this.a(cVar);
                        }
                    } else {
                        g.a.a.m.d.d(l.k, "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.", new Object[0]);
                    }
                } else {
                    g.a.a.m.d.d(l.k, "getBeacons is returning null. No simulated beacons to report.", new Object[0]);
                }
            } else if (g.a.a.m.d.a()) {
                g.a.a.m.d.a(l.k, "Beacon simulator not enabled", new Object[0]);
            }
            l.this.f6133f.a();
            l.this.f6131d.k();
            l.this.f();
        }

        @Override // g.a.a.n.r.a
        @TargetApi(11)
        public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            l.this.a(bluetoothDevice, i2, bArr);
        }
    }

    /* compiled from: ScanHelper.java */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6138a;

        /* renamed from: b  reason: collision with root package name */
        public BluetoothDevice f6139b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f6140c;

        public b(l lVar, BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            this.f6139b = bluetoothDevice;
            this.f6138a = i2;
            this.f6140c = bArr;
        }
    }

    /* compiled from: ScanHelper.java */
    /* loaded from: classes.dex */
    public class c extends AsyncTask<b, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final g.a.a.n.b f6141a = g.a.a.n.b.c();

        /* renamed from: b  reason: collision with root package name */
        public final g.a.a.n.r.g f6142b;

        public c(g.a.a.n.r.g gVar) {
            this.f6142b = gVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(b... bVarArr) {
            b bVar = bVarArr[0];
            Iterator it = l.this.f6135h.iterator();
            g.a.a.c cVar = null;
            while (it.hasNext() && (cVar = ((BeaconParser) it.next()).a(bVar.f6140c, bVar.f6138a, bVar.f6139b)) == null) {
            }
            if (cVar != null) {
                if (g.a.a.m.d.a()) {
                    g.a.a.m.d.a(l.k, "Beacon packet detected for: " + cVar + " with rssi " + cVar.i(), new Object[0]);
                }
                this.f6141a.b();
                if (l.this.f6130c != null && !l.this.f6130c.j() && !l.this.f6133f.a(bVar.f6139b.getAddress(), bVar.f6140c)) {
                    g.a.a.m.d.c(l.k, "Non-distinct packets detected in a single scan.  Restarting scans unecessary.", new Object[0]);
                    l.this.f6130c.a(true);
                }
                l.this.a(cVar);
            } else {
                g.a.a.n.r.g gVar = this.f6142b;
                if (gVar != null) {
                    gVar.a(bVar.f6139b, bVar.f6138a, bVar.f6140c);
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

    public l(Context context) {
        this.f6136i = context;
        this.f6129b = BeaconManager.a(context);
    }

    public void a(List<g.a.a.c> list) {
    }

    public void finalize() {
        super.finalize();
        i();
    }

    public void g() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f6129b.h());
        boolean z = true;
        for (BeaconParser beaconParser : this.f6129b.h()) {
            if (beaconParser.b().size() > 0) {
                z = false;
                hashSet.addAll(beaconParser.b());
            }
        }
        this.f6135h = hashSet;
        this.f6134g = new g.a.a.n.c(z);
    }

    public void h() {
        try {
            BluetoothAdapter adapter = ((BluetoothManager) this.f6136i.getApplicationContext().getSystemService("bluetooth")).getAdapter();
            if (adapter == null) {
                g.a.a.m.d.d(k, "Failed to construct a BluetoothAdapter", new Object[0]);
            } else if (!adapter.isEnabled()) {
                g.a.a.m.d.d(k, "BluetoothAdapter is not enabled", new Object[0]);
            } else {
                BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.stopScan(e());
                }
            }
        } catch (NullPointerException e2) {
            g.a.a.m.d.b(k, "NullPointerException stopping Android O background scanner", e2);
        } catch (SecurityException unused) {
            g.a.a.m.d.b(k, "SecurityException stopping Android O background scanner", new Object[0]);
        } catch (RuntimeException e3) {
            g.a.a.m.d.b(k, "Unexpected runtime exception stopping Android O background scanner", e3);
        }
    }

    public void i() {
        ExecutorService executorService = this.f6128a;
        if (executorService != null) {
            executorService.shutdown();
            try {
                if (!this.f6128a.awaitTermination(10L, TimeUnit.MILLISECONDS)) {
                    g.a.a.m.d.b(k, "Can't stop beacon parsing thread.", new Object[0]);
                }
            } catch (InterruptedException unused) {
                g.a.a.m.d.b(k, "Interrupted waiting to stop beacon parsing thread.", new Object[0]);
            }
            this.f6128a = null;
        }
    }

    public final ExecutorService b() {
        if (this.f6128a == null) {
            this.f6128a = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        }
        return this.f6128a;
    }

    public e c() {
        return this.f6131d;
    }

    public Map<g.a.a.j, f> d() {
        return this.f6132e;
    }

    public PendingIntent e() {
        Intent intent = new Intent(this.f6136i, StartupBroadcastReceiver.class);
        intent.putExtra("o-scan", true);
        return PendingIntent.getBroadcast(this.f6136i, 0, intent, 134217728);
    }

    public final void f() {
        synchronized (this.f6132e) {
            for (g.a.a.j jVar : this.f6132e.keySet()) {
                f fVar = this.f6132e.get(jVar);
                g.a.a.m.d.a(k, "Calling ranging callback", new Object[0]);
                fVar.b().a(this.f6136i, "rangingData", new h(fVar.a(), jVar).c());
            }
        }
    }

    public g.a.a.n.r.b a() {
        return this.f6130c;
    }

    public void a(e eVar) {
        this.f6131d = eVar;
    }

    public void a(Map<g.a.a.j, f> map) {
        synchronized (this.f6132e) {
            this.f6132e.clear();
            this.f6132e.putAll(map);
        }
    }

    public void b(Set<BeaconParser> set) {
        ScanSettings build = new ScanSettings.Builder().setScanMode(0).build();
        List<ScanFilter> a2 = new g.a.a.n.r.h().a(new ArrayList(set));
        try {
            BluetoothAdapter adapter = ((BluetoothManager) this.f6136i.getApplicationContext().getSystemService("bluetooth")).getAdapter();
            if (adapter == null) {
                g.a.a.m.d.d(k, "Failed to construct a BluetoothAdapter", new Object[0]);
            } else if (!adapter.isEnabled()) {
                g.a.a.m.d.d(k, "Failed to start background scan on Android O: BluetoothAdapter is not enabled", new Object[0]);
            } else {
                BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    int startScan = bluetoothLeScanner.startScan(a2, build, e());
                    if (startScan != 0) {
                        String str = k;
                        g.a.a.m.d.b(str, "Failed to start background scan on Android O.  Code: " + startScan, new Object[0]);
                    } else {
                        g.a.a.m.d.a(k, "Started passive beacon scan", new Object[0]);
                    }
                } else {
                    g.a.a.m.d.b(k, "Failed to start background scan on Android O: scanner is null", new Object[0]);
                }
            }
        } catch (NullPointerException e2) {
            g.a.a.m.d.b(k, "NullPointerException starting Android O background scanner", e2);
        } catch (SecurityException unused) {
            g.a.a.m.d.b(k, "SecurityException making Android O background scanner", new Object[0]);
        } catch (RuntimeException e3) {
            g.a.a.m.d.b(k, "Unexpected runtime exception starting Android O background scanner", e3);
        }
    }

    public void a(g.a.a.n.c cVar) {
        this.f6134g = cVar;
    }

    public void a(Set<BeaconParser> set) {
        this.f6135h = set;
    }

    public void a(boolean z, g.a.b.b bVar) {
        this.f6130c = g.a.a.n.r.b.a(this.f6136i, 1100L, 0L, z, this.j, bVar);
    }

    @TargetApi(11)
    public void a(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
        try {
            new c(this.f6129b.q()).executeOnExecutor(b(), new b(this, bluetoothDevice, i2, bArr));
        } catch (OutOfMemoryError unused) {
            g.a.a.m.d.d(k, "Ignoring scan result because we cannot start a thread to keep up.", new Object[0]);
        } catch (RejectedExecutionException unused2) {
            g.a.a.m.d.d(k, "Ignoring scan result because we cannot keep up.", new Object[0]);
        }
    }

    public final void a(g.a.a.c cVar) {
        if (q.f().b()) {
            q.f().a(cVar);
        }
        if (g.a.a.m.d.a()) {
            g.a.a.m.d.a(k, "beacon detected : %s", cVar.toString());
        }
        g.a.a.c b2 = this.f6134g.b(cVar);
        if (b2 == null) {
            if (g.a.a.m.d.a()) {
                g.a.a.m.d.a(k, "not processing detections for GATT extra data beacon", new Object[0]);
                return;
            }
            return;
        }
        this.f6131d.b(b2);
        g.a.a.m.d.a(k, "looking for ranging region matches for this beacon", new Object[0]);
        synchronized (this.f6132e) {
            for (g.a.a.j jVar : a(b2, this.f6132e.keySet())) {
                g.a.a.m.d.a(k, "matches ranging region: %s", jVar);
                f fVar = this.f6132e.get(jVar);
                if (fVar != null) {
                    fVar.a(b2);
                }
            }
        }
    }

    public final List<g.a.a.j> a(g.a.a.c cVar, Collection<g.a.a.j> collection) {
        ArrayList arrayList = new ArrayList();
        for (g.a.a.j jVar : collection) {
            if (jVar != null) {
                if (jVar.a(cVar)) {
                    arrayList.add(jVar);
                } else {
                    g.a.a.m.d.a(k, "This region (%s) does not match beacon: %s", jVar, cVar);
                }
            }
        }
        return arrayList;
    }
}
