package g.a.a.n.r;

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
/* compiled from: CycledLeScannerForLollipop.java */
@TargetApi(21)
/* loaded from: classes.dex */
public class e extends g.a.a.n.r.b {
    public ScanCallback A;
    public long B;
    public long C;
    public boolean D;
    public final BeaconManager E;
    public final PowerManager F;
    public BluetoothLeScanner z;

    /* compiled from: CycledLeScannerForLollipop.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a((Boolean) true);
        }
    }

    /* compiled from: CycledLeScannerForLollipop.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BluetoothLeScanner f6204a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f6205b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ScanSettings f6206c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ScanCallback f6207d;

        public b(e eVar, BluetoothLeScanner bluetoothLeScanner, List list, ScanSettings scanSettings, ScanCallback scanCallback) {
            this.f6204a = bluetoothLeScanner;
            this.f6205b = list;
            this.f6206c = scanSettings;
            this.f6207d = scanCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6204a.startScan(this.f6205b, this.f6206c, this.f6207d);
            } catch (IllegalStateException unused) {
                g.a.a.m.d.d("CycledLeScannerForLollipop", "Cannot start scan. Bluetooth may be turned off.", new Object[0]);
            } catch (NullPointerException e2) {
                g.a.a.m.d.a(e2, "CycledLeScannerForLollipop", "Cannot start scan. Unexpected NPE.", new Object[0]);
            } catch (SecurityException unused2) {
                g.a.a.m.d.b("CycledLeScannerForLollipop", "Cannot start scan.  Security Exception", new Object[0]);
            }
        }
    }

    /* compiled from: CycledLeScannerForLollipop.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BluetoothLeScanner f6208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ScanCallback f6209b;

        public c(e eVar, BluetoothLeScanner bluetoothLeScanner, ScanCallback scanCallback) {
            this.f6208a = bluetoothLeScanner;
            this.f6209b = scanCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                g.a.a.m.d.a("CycledLeScannerForLollipop", "Stopping LE scan on scan handler", new Object[0]);
                this.f6208a.stopScan(this.f6209b);
            } catch (IllegalStateException unused) {
                g.a.a.m.d.d("CycledLeScannerForLollipop", "Cannot stop scan. Bluetooth may be turned off.", new Object[0]);
            } catch (NullPointerException e2) {
                g.a.a.m.d.a(e2, "CycledLeScannerForLollipop", "Cannot stop scan. Unexpected NPE.", new Object[0]);
            } catch (SecurityException unused2) {
                g.a.a.m.d.b("CycledLeScannerForLollipop", "Cannot stop scan.  Security Exception", new Object[0]);
            }
        }
    }

    /* compiled from: CycledLeScannerForLollipop.java */
    /* loaded from: classes.dex */
    public class d extends ScanCallback {
        public d() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            g.a.a.m.d.a("CycledLeScannerForLollipop", "got batch records", new Object[0]);
            for (ScanResult scanResult : list) {
                e.this.u.onLeScan(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
            }
            if (e.this.B > 0) {
                g.a.a.m.d.a("CycledLeScannerForLollipop", "got a filtered batch scan result in the background.", new Object[0]);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i2) {
            Intent intent = new Intent("onScanFailed");
            intent.putExtra("errorCode", i2);
            a.b.g.b.d.a(e.this.l).a(intent);
            if (i2 == 1) {
                g.a.a.m.d.b("CycledLeScannerForLollipop", "Scan failed: a BLE scan with the same settings is already started by the app", new Object[0]);
            } else if (i2 == 2) {
                g.a.a.m.d.b("CycledLeScannerForLollipop", "Scan failed: app cannot be registered", new Object[0]);
            } else if (i2 == 3) {
                g.a.a.m.d.b("CycledLeScannerForLollipop", "Scan failed: internal error", new Object[0]);
            } else if (i2 != 4) {
                g.a.a.m.d.b("CycledLeScannerForLollipop", "Scan failed with unknown error (errorCode=" + i2 + ")", new Object[0]);
            } else {
                g.a.a.m.d.b("CycledLeScannerForLollipop", "Scan failed: power optimized scan feature is not supported", new Object[0]);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i2, ScanResult scanResult) {
            if (g.a.a.m.d.a()) {
                g.a.a.m.d.a("CycledLeScannerForLollipop", "got record", new Object[0]);
                List<ParcelUuid> serviceUuids = scanResult.getScanRecord().getServiceUuids();
                if (serviceUuids != null) {
                    Iterator<ParcelUuid> it = serviceUuids.iterator();
                    while (it.hasNext()) {
                        g.a.a.m.d.a("CycledLeScannerForLollipop", "with service uuid: " + it.next(), new Object[0]);
                    }
                }
            }
            e.this.u.onLeScan(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
            if (e.this.B > 0) {
                g.a.a.m.d.a("CycledLeScannerForLollipop", "got a filtered scan result in the background.", new Object[0]);
            }
        }
    }

    public e(Context context, long j, long j2, boolean z, g.a.a.n.r.a aVar, g.a.b.b bVar) {
        super(context, j, j2, z, aVar, bVar);
        this.B = 0L;
        this.C = 0L;
        this.D = false;
        this.E = BeaconManager.a(this.l);
        this.F = (PowerManager) context.getSystemService("power");
    }

    @Override // g.a.a.n.r.b
    public boolean e() {
        long elapsedRealtime = this.f6188d - SystemClock.elapsedRealtime();
        boolean z = elapsedRealtime > 0;
        boolean z2 = this.D;
        this.D = !z;
        if (z) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - g.a.a.n.b.c().a();
            if (z2) {
                if (elapsedRealtime2 > 10000) {
                    this.B = SystemClock.elapsedRealtime();
                    this.C = 0L;
                    g.a.a.m.d.a("CycledLeScannerForLollipop", "This is Android L. Preparing to do a filtered scan for the background.", new Object[0]);
                    if (this.p > 6000) {
                        q();
                    } else {
                        g.a.a.m.d.a("CycledLeScannerForLollipop", "Suppressing scan between cycles because the between scan cycle is too short.", new Object[0]);
                    }
                } else {
                    g.a.a.m.d.a("CycledLeScannerForLollipop", "This is Android L, but we last saw a beacon only %s ago, so we will not keep scanning in background.", Long.valueOf(elapsedRealtime2));
                }
            }
            if (this.B > 0 && g.a.a.n.b.c().a() > this.B) {
                if (this.C == 0) {
                    this.C = g.a.a.n.b.c().a();
                }
                if (SystemClock.elapsedRealtime() - this.C >= 10000) {
                    g.a.a.m.d.a("CycledLeScannerForLollipop", "We've been detecting for a bit.  Stopping Android L background scanning", new Object[0]);
                    s();
                    this.B = 0L;
                } else {
                    g.a.a.m.d.a("CycledLeScannerForLollipop", "Delivering Android L background scanning results", new Object[0]);
                    this.u.a();
                }
            }
            g.a.a.m.d.a("CycledLeScannerForLollipop", "Waiting to start full Bluetooth scan for another %s milliseconds", Long.valueOf(elapsedRealtime));
            if (z2 && this.v) {
                o();
            }
            Handler handler = this.q;
            a aVar = new a();
            if (elapsedRealtime > 1000) {
                elapsedRealtime = 1000;
            }
            handler.postDelayed(aVar, elapsedRealtime);
        } else if (this.B > 0) {
            s();
            this.B = 0L;
        }
        return z;
    }

    @Override // g.a.a.n.r.b
    public void g() {
        g.a.a.m.d.a("CycledLeScannerForLollipop", "Stopping scan", new Object[0]);
        s();
        this.f6193i = true;
    }

    @Override // g.a.a.n.r.b
    public void q() {
        ScanSettings build;
        if (!v()) {
            g.a.a.m.d.a("CycledLeScannerForLollipop", "Not starting scan because bluetooth is off", new Object[0]);
            return;
        }
        List<ScanFilter> arrayList = new ArrayList<>();
        if (!this.D) {
            g.a.a.m.d.a("CycledLeScannerForLollipop", "starting filtered scan in SCAN_MODE_LOW_POWER", new Object[0]);
            build = new ScanSettings.Builder().setScanMode(0).build();
            arrayList = new h().a(this.E.h());
        } else {
            g.a.a.m.d.a("CycledLeScannerForLollipop", "starting a scan in SCAN_MODE_LOW_LATENCY", new Object[0]);
            build = new ScanSettings.Builder().setScanMode(2).build();
            if (Build.VERSION.SDK_INT >= 27) {
                if (Build.MANUFACTURER.equalsIgnoreCase("samsung") && !this.F.isInteractive()) {
                    g.a.a.m.d.a("CycledLeScannerForLollipop", "Using a non-empty scan filter since this is Samsung 8.1+", new Object[0]);
                    arrayList = new h().a(this.E.h());
                } else {
                    g.a.a.m.d.a("CycledLeScannerForLollipop", "Using an empty scan filter since this is 8.1+ on Non-Samsung", new Object[0]);
                    arrayList = new h().a();
                }
            } else {
                g.a.a.m.d.a("CycledLeScannerForLollipop", "Using no scan filter since this is pre-8.1", new Object[0]);
            }
        }
        if (build != null) {
            a(arrayList, build);
        }
    }

    @Override // g.a.a.n.r.b
    public void s() {
        w();
    }

    public final ScanCallback t() {
        if (this.A == null) {
            this.A = new d();
        }
        return this.A;
    }

    public final BluetoothLeScanner u() {
        try {
            if (this.z == null) {
                g.a.a.m.d.a("CycledLeScannerForLollipop", "Making new Android L scanner", new Object[0]);
                if (i() != null) {
                    this.z = i().getBluetoothLeScanner();
                }
                if (this.z == null) {
                    g.a.a.m.d.d("CycledLeScannerForLollipop", "Failed to make new Android L scanner", new Object[0]);
                }
            }
        } catch (SecurityException unused) {
            g.a.a.m.d.d("CycledLeScannerForLollipop", "SecurityException making new Android L scanner", new Object[0]);
        }
        return this.z;
    }

    public final boolean v() {
        BluetoothAdapter i2;
        try {
            i2 = i();
        } catch (SecurityException unused) {
            g.a.a.m.d.d("CycledLeScannerForLollipop", "SecurityException checking if bluetooth is on", new Object[0]);
        }
        if (i2 != null) {
            return i2.getState() == 12;
        }
        g.a.a.m.d.d("CycledLeScannerForLollipop", "Cannot get bluetooth adapter", new Object[0]);
        return false;
    }

    public final void w() {
        if (!v()) {
            g.a.a.m.d.a("CycledLeScannerForLollipop", "Not stopping scan because bluetooth is off", new Object[0]);
            return;
        }
        BluetoothLeScanner u = u();
        if (u == null) {
            return;
        }
        ScanCallback t = t();
        this.r.removeCallbacksAndMessages(null);
        this.r.post(new c(this, u, t));
    }

    public final void a(List<ScanFilter> list, ScanSettings scanSettings) {
        BluetoothLeScanner u = u();
        if (u == null) {
            return;
        }
        ScanCallback t = t();
        this.r.removeCallbacksAndMessages(null);
        this.r.post(new b(this, u, list, scanSettings, t));
    }
}
