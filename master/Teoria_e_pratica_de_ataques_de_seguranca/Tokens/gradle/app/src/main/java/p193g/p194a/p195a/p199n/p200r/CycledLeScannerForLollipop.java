package p193g.p194a.p195a.p199n.p200r;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelUuid;
import android.os.PowerManager;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.BeaconManager;
import p000a.p006b.p030g.p032b.LocalBroadcastManager;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p195a.p199n.DetectionTracker;
import p193g.p194a.p203b.BluetoothCrashResolver;

@TargetApi(21)
/* renamed from: g.a.a.n.r.e */
/* loaded from: classes.dex */
public class CycledLeScannerForLollipop extends CycledLeScanner {

    /* renamed from: A */
    public ScanCallback f8687A;

    /* renamed from: B */
    public long f8688B;

    /* renamed from: C */
    public long f8689C;

    /* renamed from: D */
    public boolean f8690D;

    /* renamed from: E */
    public final BeaconManager f8691E;

    /* renamed from: F */
    public final PowerManager f8692F;

    /* renamed from: z */
    public BluetoothLeScanner f8693z;

    /* compiled from: CycledLeScannerForLollipop.java */
    /* renamed from: g.a.a.n.r.e$a */
    /* loaded from: classes.dex */
    public class RunnableC1852a implements Runnable {
        public RunnableC1852a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CycledLeScannerForLollipop.this.m2276a((Boolean) true);
        }
    }

    /* compiled from: CycledLeScannerForLollipop.java */
    /* renamed from: g.a.a.n.r.e$b */
    /* loaded from: classes.dex */
    public class RunnableC1853b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ BluetoothLeScanner f8695a;

        /* renamed from: b */
        public final /* synthetic */ List f8696b;

        /* renamed from: c */
        public final /* synthetic */ ScanSettings f8697c;

        /* renamed from: d */
        public final /* synthetic */ ScanCallback f8698d;

        public RunnableC1853b(CycledLeScannerForLollipop cycledLeScannerForLollipop, BluetoothLeScanner bluetoothLeScanner, List list, ScanSettings scanSettings, ScanCallback scanCallback) {
            this.f8695a = bluetoothLeScanner;
            this.f8696b = list;
            this.f8697c = scanSettings;
            this.f8698d = scanCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8695a.startScan(this.f8696b, this.f8697c, this.f8698d);
            } catch (IllegalStateException unused) {
                LogManager.m2427d("CycledLeScannerForLollipop", "Cannot start scan. Bluetooth may be turned off.", new Object[0]);
            } catch (NullPointerException e) {
                LogManager.m2431a(e, "CycledLeScannerForLollipop", "Cannot start scan. Unexpected NPE.", new Object[0]);
            } catch (SecurityException unused2) {
                LogManager.m2430b("CycledLeScannerForLollipop", "Cannot start scan.  Security Exception", new Object[0]);
            }
        }
    }

    /* compiled from: CycledLeScannerForLollipop.java */
    /* renamed from: g.a.a.n.r.e$c */
    /* loaded from: classes.dex */
    public class RunnableC1854c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ BluetoothLeScanner f8699a;

        /* renamed from: b */
        public final /* synthetic */ ScanCallback f8700b;

        public RunnableC1854c(CycledLeScannerForLollipop cycledLeScannerForLollipop, BluetoothLeScanner bluetoothLeScanner, ScanCallback scanCallback) {
            this.f8699a = bluetoothLeScanner;
            this.f8700b = scanCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LogManager.m2432a("CycledLeScannerForLollipop", "Stopping LE scan on scan handler", new Object[0]);
                this.f8699a.stopScan(this.f8700b);
            } catch (IllegalStateException unused) {
                LogManager.m2427d("CycledLeScannerForLollipop", "Cannot stop scan. Bluetooth may be turned off.", new Object[0]);
            } catch (NullPointerException e) {
                LogManager.m2431a(e, "CycledLeScannerForLollipop", "Cannot stop scan. Unexpected NPE.", new Object[0]);
            } catch (SecurityException unused2) {
                LogManager.m2430b("CycledLeScannerForLollipop", "Cannot stop scan.  Security Exception", new Object[0]);
            }
        }
    }

    /* compiled from: CycledLeScannerForLollipop.java */
    /* renamed from: g.a.a.n.r.e$d */
    /* loaded from: classes.dex */
    public class C1855d extends ScanCallback {
        public C1855d() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            LogManager.m2432a("CycledLeScannerForLollipop", "got batch records", new Object[0]);
            for (ScanResult scanResult : list) {
                CycledLeScannerForLollipop.this.f8672u.onLeScan(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
            }
            if (CycledLeScannerForLollipop.this.f8688B > 0) {
                LogManager.m2432a("CycledLeScannerForLollipop", "got a filtered batch scan result in the background.", new Object[0]);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            Intent intent = new Intent("onScanFailed");
            intent.putExtra("errorCode", i);
            LocalBroadcastManager.m10011a(CycledLeScannerForLollipop.this.f8663l).m10010a(intent);
            if (i == 1) {
                LogManager.m2430b("CycledLeScannerForLollipop", "Scan failed: a BLE scan with the same settings is already started by the app", new Object[0]);
            } else if (i == 2) {
                LogManager.m2430b("CycledLeScannerForLollipop", "Scan failed: app cannot be registered", new Object[0]);
            } else if (i == 3) {
                LogManager.m2430b("CycledLeScannerForLollipop", "Scan failed: internal error", new Object[0]);
            } else if (i != 4) {
                LogManager.m2430b("CycledLeScannerForLollipop", "Scan failed with unknown error (errorCode=" + i + ")", new Object[0]);
            } else {
                LogManager.m2430b("CycledLeScannerForLollipop", "Scan failed: power optimized scan feature is not supported", new Object[0]);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            if (LogManager.m2433a()) {
                LogManager.m2432a("CycledLeScannerForLollipop", "got record", new Object[0]);
                List<ParcelUuid> serviceUuids = scanResult.getScanRecord().getServiceUuids();
                if (serviceUuids != null) {
                    Iterator<ParcelUuid> it = serviceUuids.iterator();
                    while (it.hasNext()) {
                        LogManager.m2432a("CycledLeScannerForLollipop", "with service uuid: " + it.next(), new Object[0]);
                    }
                }
            }
            CycledLeScannerForLollipop.this.f8672u.onLeScan(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
            if (CycledLeScannerForLollipop.this.f8688B > 0) {
                LogManager.m2432a("CycledLeScannerForLollipop", "got a filtered scan result in the background.", new Object[0]);
            }
        }
    }

    public CycledLeScannerForLollipop(Context context, long j, long j2, boolean z, CycledLeScanCallback cycledLeScanCallback, BluetoothCrashResolver bluetoothCrashResolver) {
        super(context, j, j2, z, cycledLeScanCallback, bluetoothCrashResolver);
        this.f8688B = 0L;
        this.f8689C = 0L;
        this.f8690D = false;
        this.f8691E = BeaconManager.m477a(this.f8663l);
        this.f8692F = (PowerManager) context.getSystemService("power");
    }

    @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanner
    /* renamed from: e */
    public boolean mo2252e() {
        long elapsedRealtime = this.f8655d - SystemClock.elapsedRealtime();
        boolean z = elapsedRealtime > 0;
        boolean z2 = this.f8690D;
        this.f8690D = !z;
        if (z) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - DetectionTracker.m2416c().m2418a();
            if (z2) {
                if (elapsedRealtime2 > 10000) {
                    this.f8688B = SystemClock.elapsedRealtime();
                    this.f8689C = 0L;
                    LogManager.m2432a("CycledLeScannerForLollipop", "This is Android L. Preparing to do a filtered scan for the background.", new Object[0]);
                    if (this.f8667p > 6000) {
                        mo2250q();
                    } else {
                        LogManager.m2432a("CycledLeScannerForLollipop", "Suppressing scan between cycles because the between scan cycle is too short.", new Object[0]);
                    }
                } else {
                    LogManager.m2432a("CycledLeScannerForLollipop", "This is Android L, but we last saw a beacon only %s ago, so we will not keep scanning in background.", Long.valueOf(elapsedRealtime2));
                }
            }
            if (this.f8688B > 0 && DetectionTracker.m2416c().m2418a() > this.f8688B) {
                if (this.f8689C == 0) {
                    this.f8689C = DetectionTracker.m2416c().m2418a();
                }
                if (SystemClock.elapsedRealtime() - this.f8689C >= 10000) {
                    LogManager.m2432a("CycledLeScannerForLollipop", "We've been detecting for a bit.  Stopping Android L background scanning", new Object[0]);
                    mo2249s();
                    this.f8688B = 0L;
                } else {
                    LogManager.m2432a("CycledLeScannerForLollipop", "Delivering Android L background scanning results", new Object[0]);
                    this.f8672u.mo2281a();
                }
            }
            LogManager.m2432a("CycledLeScannerForLollipop", "Waiting to start full Bluetooth scan for another %s milliseconds", Long.valueOf(elapsedRealtime));
            if (z2 && this.f8673v) {
                m2261o();
            }
            Handler handler = this.f8668q;
            RunnableC1852a runnableC1852a = new RunnableC1852a();
            if (elapsedRealtime > 1000) {
                elapsedRealtime = 1000;
            }
            handler.postDelayed(runnableC1852a, elapsedRealtime);
        } else if (this.f8688B > 0) {
            mo2249s();
            this.f8688B = 0L;
        }
        return z;
    }

    @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanner
    /* renamed from: g */
    public void mo2251g() {
        LogManager.m2432a("CycledLeScannerForLollipop", "Stopping scan", new Object[0]);
        mo2249s();
        this.f8660i = true;
    }

    @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanner
    /* renamed from: q */
    public void mo2250q() {
        ScanSettings build;
        if (!m2246v()) {
            LogManager.m2432a("CycledLeScannerForLollipop", "Not starting scan because bluetooth is off", new Object[0]);
            return;
        }
        List<ScanFilter> arrayList = new ArrayList<>();
        if (!this.f8690D) {
            LogManager.m2432a("CycledLeScannerForLollipop", "starting filtered scan in SCAN_MODE_LOW_POWER", new Object[0]);
            build = new ScanSettings.Builder().setScanMode(0).build();
            arrayList = new ScanFilterUtils().m2240a(this.f8691E.m451h());
        } else {
            LogManager.m2432a("CycledLeScannerForLollipop", "starting a scan in SCAN_MODE_LOW_LATENCY", new Object[0]);
            build = new ScanSettings.Builder().setScanMode(2).build();
            if (Build.VERSION.SDK_INT >= 27) {
                if (Build.MANUFACTURER.equalsIgnoreCase("samsung") && !this.f8692F.isInteractive()) {
                    LogManager.m2432a("CycledLeScannerForLollipop", "Using a non-empty scan filter since this is Samsung 8.1+", new Object[0]);
                    arrayList = new ScanFilterUtils().m2240a(this.f8691E.m451h());
                } else {
                    LogManager.m2432a("CycledLeScannerForLollipop", "Using an empty scan filter since this is 8.1+ on Non-Samsung", new Object[0]);
                    arrayList = new ScanFilterUtils().m2241a();
                }
            } else {
                LogManager.m2432a("CycledLeScannerForLollipop", "Using no scan filter since this is pre-8.1", new Object[0]);
            }
        }
        if (build != null) {
            m2253a(arrayList, build);
        }
    }

    @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanner
    /* renamed from: s */
    public void mo2249s() {
        m2245w();
    }

    /* renamed from: t */
    public final ScanCallback m2248t() {
        if (this.f8687A == null) {
            this.f8687A = new C1855d();
        }
        return this.f8687A;
    }

    /* renamed from: u */
    public final BluetoothLeScanner m2247u() {
        try {
            if (this.f8693z == null) {
                LogManager.m2432a("CycledLeScannerForLollipop", "Making new Android L scanner", new Object[0]);
                if (m2267i() != null) {
                    this.f8693z = m2267i().getBluetoothLeScanner();
                }
                if (this.f8693z == null) {
                    LogManager.m2427d("CycledLeScannerForLollipop", "Failed to make new Android L scanner", new Object[0]);
                }
            }
        } catch (SecurityException unused) {
            LogManager.m2427d("CycledLeScannerForLollipop", "SecurityException making new Android L scanner", new Object[0]);
        }
        return this.f8693z;
    }

    /* renamed from: v */
    public final boolean m2246v() {
        BluetoothAdapter m2267i;
        try {
            m2267i = m2267i();
        } catch (SecurityException unused) {
            LogManager.m2427d("CycledLeScannerForLollipop", "SecurityException checking if bluetooth is on", new Object[0]);
        }
        if (m2267i != null) {
            return m2267i.getState() == 12;
        }
        LogManager.m2427d("CycledLeScannerForLollipop", "Cannot get bluetooth adapter", new Object[0]);
        return false;
    }

    /* renamed from: w */
    public final void m2245w() {
        if (!m2246v()) {
            LogManager.m2432a("CycledLeScannerForLollipop", "Not stopping scan because bluetooth is off", new Object[0]);
            return;
        }
        BluetoothLeScanner m2247u = m2247u();
        if (m2247u == null) {
            return;
        }
        ScanCallback m2248t = m2248t();
        this.f8669r.removeCallbacksAndMessages(null);
        this.f8669r.post(new RunnableC1854c(this, m2247u, m2248t));
    }

    /* renamed from: a */
    public final void m2253a(List<ScanFilter> list, ScanSettings scanSettings) {
        BluetoothLeScanner m2247u = m2247u();
        if (m2247u == null) {
            return;
        }
        ScanCallback m2248t = m2248t();
        this.f8669r.removeCallbacksAndMessages(null);
        this.f8669r.post(new RunnableC1853b(this, m2247u, list, scanSettings, m2248t));
    }
}
