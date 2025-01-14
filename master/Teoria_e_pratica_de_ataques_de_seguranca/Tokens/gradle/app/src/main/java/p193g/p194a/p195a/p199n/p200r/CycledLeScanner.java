package p193g.p194a.p195a.p199n.p200r;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import java.util.Date;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p203b.BluetoothCrashResolver;

@TargetApi(18)
/* renamed from: g.a.a.n.r.b */
/* loaded from: classes.dex */
public abstract class CycledLeScanner {

    /* renamed from: a */
    public BluetoothAdapter f8652a;

    /* renamed from: h */
    public boolean f8659h;

    /* renamed from: i */
    public boolean f8660i;

    /* renamed from: l */
    public final Context f8663l;

    /* renamed from: m */
    public long f8664m;

    /* renamed from: p */
    public long f8667p;

    /* renamed from: r */
    public final Handler f8669r;

    /* renamed from: t */
    public final BluetoothCrashResolver f8671t;

    /* renamed from: u */
    public final CycledLeScanCallback f8672u;

    /* renamed from: v */
    public boolean f8673v;

    /* renamed from: b */
    public long f8653b = 0;

    /* renamed from: c */
    public long f8654c = 0;

    /* renamed from: d */
    public long f8655d = 0;

    /* renamed from: e */
    public long f8656e = 0;

    /* renamed from: f */
    public long f8657f = 0;

    /* renamed from: g */
    public boolean f8658g = false;

    /* renamed from: j */
    public boolean f8661j = false;

    /* renamed from: k */
    public boolean f8662k = false;

    /* renamed from: n */
    public boolean f8665n = false;

    /* renamed from: o */
    public BroadcastReceiver f8666o = null;

    /* renamed from: q */
    public final Handler f8668q = new Handler(Looper.getMainLooper());

    /* renamed from: w */
    public boolean f8674w = false;

    /* renamed from: x */
    public volatile boolean f8675x = false;

    /* renamed from: y */
    public PendingIntent f8676y = null;

    /* renamed from: s */
    public final HandlerThread f8670s = new HandlerThread("CycledLeScannerThread");

    /* compiled from: CycledLeScanner.java */
    /* renamed from: g.a.a.n.r.b$a */
    /* loaded from: classes.dex */
    public class RunnableC1845a implements Runnable {
        public RunnableC1845a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogManager.m2432a("CycledLeScanner", "Quitting scan thread", new Object[0]);
            CycledLeScanner.this.f8670s.quit();
        }
    }

    /* compiled from: CycledLeScanner.java */
    /* renamed from: g.a.a.n.r.b$b */
    /* loaded from: classes.dex */
    public class RunnableC1846b implements Runnable {
        public RunnableC1846b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CycledLeScanner.this.m2262n();
        }
    }

    /* compiled from: CycledLeScanner.java */
    /* renamed from: g.a.a.n.r.b$c */
    /* loaded from: classes.dex */
    public class C1847c extends BroadcastReceiver {
        public C1847c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogManager.m2427d("CycledLeScanner", "User switch detected.  Cancelling alarm to prevent potential crash.", new Object[0]);
            CycledLeScanner.this.m2273b();
        }
    }

    public CycledLeScanner(Context context, long j, long j2, boolean z, CycledLeScanCallback cycledLeScanCallback, BluetoothCrashResolver bluetoothCrashResolver) {
        this.f8673v = false;
        this.f8664m = j;
        this.f8667p = j2;
        this.f8663l = context;
        this.f8672u = cycledLeScanCallback;
        this.f8671t = bluetoothCrashResolver;
        this.f8673v = z;
        this.f8670s.start();
        this.f8669r = new Handler(this.f8670s.getLooper());
    }

    /* renamed from: b */
    public void m2272b(boolean z) {
        this.f8658g = z;
    }

    /* renamed from: c */
    public final boolean m2271c() {
        return m2275a("android.permission.ACCESS_COARSE_LOCATION") || m2275a("android.permission.ACCESS_FINE_LOCATION");
    }

    /* renamed from: d */
    public void m2270d() {
        BroadcastReceiver broadcastReceiver = this.f8666o;
        if (broadcastReceiver != null) {
            try {
                this.f8663l.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.f8666o = null;
        }
    }

    /* renamed from: e */
    public abstract boolean mo2252e();

    /* renamed from: f */
    public void m2269f() {
        LogManager.m2432a("CycledLeScanner", "Destroying", new Object[0]);
        this.f8668q.removeCallbacksAndMessages(null);
        this.f8669r.post(new RunnableC1845a());
        m2270d();
    }

    /* renamed from: g */
    public abstract void mo2251g();

    /* renamed from: h */
    public final void m2268h() {
        LogManager.m2432a("CycledLeScanner", "Done with scan cycle", new Object[0]);
        try {
            this.f8672u.mo2281a();
            if (this.f8659h) {
                if (m2267i() != null) {
                    if (m2267i().isEnabled()) {
                        if (this.f8675x && this.f8667p == 0 && !m2263m()) {
                            LogManager.m2432a("CycledLeScanner", "Not stopping scanning.  Device capable of multiple indistinct detections per scan.", new Object[0]);
                            this.f8665n = true;
                            this.f8654c = SystemClock.elapsedRealtime();
                        }
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (Build.VERSION.SDK_INT >= 24 && this.f8667p + this.f8664m < 6000 && elapsedRealtime - this.f8653b < 6000) {
                            LogManager.m2432a("CycledLeScanner", "Not stopping scan because this is Android N and we keep scanning for a minimum of 6 seconds at a time. We will stop in " + (6000 - (elapsedRealtime - this.f8653b)) + " millisconds.", new Object[0]);
                            this.f8665n = true;
                        } else {
                            try {
                                LogManager.m2432a("CycledLeScanner", "stopping bluetooth le scan", new Object[0]);
                                mo2251g();
                                this.f8665n = false;
                            } catch (Exception e) {
                                LogManager.m2429b(e, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
                            }
                        }
                        this.f8654c = SystemClock.elapsedRealtime();
                    } else {
                        LogManager.m2432a("CycledLeScanner", "Bluetooth is disabled.  Cannot scan for beacons.", new Object[0]);
                        this.f8674w = true;
                    }
                }
                this.f8655d = m2265k();
                if (this.f8662k) {
                    m2276a((Boolean) true);
                }
            }
            if (this.f8662k) {
                return;
            }
            LogManager.m2432a("CycledLeScanner", "Scanning disabled. ", new Object[0]);
            this.f8661j = false;
            m2273b();
        } catch (SecurityException unused) {
            LogManager.m2427d("CycledLeScanner", "SecurityException working accessing bluetooth.", new Object[0]);
        }
    }

    /* renamed from: i */
    public BluetoothAdapter m2267i() {
        try {
            if (this.f8652a == null) {
                this.f8652a = ((BluetoothManager) this.f8663l.getApplicationContext().getSystemService("bluetooth")).getAdapter();
                if (this.f8652a == null) {
                    LogManager.m2427d("CycledLeScanner", "Failed to construct a BluetoothAdapter", new Object[0]);
                }
            }
        } catch (SecurityException unused) {
            LogManager.m2430b("CycledLeScanner", "Cannot consruct bluetooth adapter.  Security Exception", new Object[0]);
        }
        return this.f8652a;
    }

    /* renamed from: j */
    public boolean m2266j() {
        return this.f8675x;
    }

    /* renamed from: k */
    public final long m2265k() {
        long j = this.f8667p;
        if (j == 0) {
            return SystemClock.elapsedRealtime();
        }
        long elapsedRealtime = j - (SystemClock.elapsedRealtime() % (this.f8664m + j));
        LogManager.m2432a("CycledLeScanner", "Normalizing between scan period from %s to %s", Long.valueOf(this.f8667p), Long.valueOf(elapsedRealtime));
        return SystemClock.elapsedRealtime() + elapsedRealtime;
    }

    /* renamed from: l */
    public PendingIntent m2264l() {
        if (this.f8676y == null) {
            Intent intent = new Intent(this.f8663l, StartupBroadcastReceiver.class);
            intent.putExtra("wakeup", true);
            this.f8676y = PendingIntent.getBroadcast(this.f8663l, 0, intent, 134217728);
        }
        return this.f8676y;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m2263m() {
        /*
            r9 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = r9.f8667p
            long r0 = r0 + r2
            long r2 = r9.f8664m
            long r0 = r0 + r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 1
            r4 = 0
            r5 = 24
            if (r2 < r5) goto L24
            long r5 = r9.f8657f
            r7 = 0
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L24
            long r0 = r0 - r5
            r5 = 1800000(0x1b7740, double:8.89318E-318)
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 <= 0) goto L24
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 == 0) goto L43
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r1 = "CycledLeScanner"
            java.lang.String r2 = "The next scan cycle would go over the Android N max duration."
            p193g.p194a.p195a.p198m.LogManager.m2432a(r1, r2, r0)
            boolean r0 = r9.f8658g
            if (r0 == 0) goto L3c
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r2 = "Stopping scan to prevent Android N scan timeout."
            p193g.p194a.p195a.p198m.LogManager.m2432a(r1, r2, r0)
            return r3
        L3c:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r2 = "Allowing a long running scan to be stopped by the OS.  To prevent this, set longScanForcingEnabled in the AndroidBeaconLibrary."
            p193g.p194a.p195a.p198m.LogManager.m2427d(r1, r2, r0)
        L43:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p195a.p199n.p200r.CycledLeScanner.m2263m():boolean");
    }

    /* renamed from: n */
    public void m2262n() {
        long elapsedRealtime = this.f8656e - SystemClock.elapsedRealtime();
        if (this.f8662k && elapsedRealtime > 0) {
            LogManager.m2432a("CycledLeScanner", "Waiting to stop scan cycle for another %s milliseconds", Long.valueOf(elapsedRealtime));
            if (this.f8673v) {
                m2261o();
            }
            Handler handler = this.f8668q;
            RunnableC1846b runnableC1846b = new RunnableC1846b();
            if (elapsedRealtime > 1000) {
                elapsedRealtime = 1000;
            }
            handler.postDelayed(runnableC1846b, elapsedRealtime);
            return;
        }
        m2268h();
    }

    /* renamed from: o */
    public void m2261o() {
        long j = this.f8667p;
        if (300000 >= j) {
            j = 300000;
        }
        long j2 = this.f8664m;
        if (j < j2) {
            j = j2;
        }
        ((AlarmManager) this.f8663l.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, m2264l());
        LogManager.m2432a("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", Long.valueOf(j), m2264l());
        m2280a();
    }

    /* renamed from: p */
    public void m2260p() {
        LogManager.m2432a("CycledLeScanner", "start called", new Object[0]);
        this.f8662k = true;
        if (!this.f8661j) {
            m2276a((Boolean) true);
        } else {
            LogManager.m2432a("CycledLeScanner", "scanning already started", new Object[0]);
        }
    }

    /* renamed from: q */
    public abstract void mo2250q();

    /* renamed from: r */
    public void m2259r() {
        LogManager.m2432a("CycledLeScanner", "stop called", new Object[0]);
        this.f8662k = false;
        if (this.f8661j) {
            m2276a((Boolean) false);
            if (this.f8665n) {
                LogManager.m2432a("CycledLeScanner", "Stopping scanning previously left on.", new Object[0]);
                this.f8665n = false;
                try {
                    LogManager.m2432a("CycledLeScanner", "stopping bluetooth le scan", new Object[0]);
                    mo2251g();
                    return;
                } catch (Exception e) {
                    LogManager.m2429b(e, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
                    return;
                }
            }
            return;
        }
        LogManager.m2432a("CycledLeScanner", "scanning already stopped", new Object[0]);
    }

    /* renamed from: s */
    public abstract void mo2249s();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p193g.p194a.p195a.p199n.p200r.CycledLeScanner m2278a(android.content.Context r14, long r15, long r17, boolean r19, p193g.p194a.p195a.p199n.p200r.CycledLeScanCallback r20, p193g.p194a.p203b.BluetoothCrashResolver r21) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "CycledLeScanner"
            r2 = 0
            r3 = 18
            if (r0 >= r3) goto L12
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "Not supported prior to API 18."
            p193g.p194a.p195a.p198m.LogManager.m2427d(r1, r2, r0)
            r0 = 0
            return r0
        L12:
            r3 = 21
            r4 = 1
            if (r0 >= r3) goto L20
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is pre Android 5.0.  We are using old scanning APIs"
            p193g.p194a.p195a.p198m.LogManager.m2428c(r1, r3, r0)
        L1e:
            r4 = 0
            goto L43
        L20:
            r3 = 26
            if (r0 >= r3) goto L3a
            boolean r0 = org.altbeacon.beacon.BeaconManager.m481J()
            if (r0 == 0) goto L32
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is Android 5.0, but L scanning is disabled. We are using old scanning APIs"
            p193g.p194a.p195a.p198m.LogManager.m2428c(r1, r3, r0)
            goto L1e
        L32:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is Android 5.0.  We are using new scanning APIs"
            p193g.p194a.p195a.p198m.LogManager.m2428c(r1, r3, r0)
            goto L43
        L3a:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "Using Android O scanner"
            p193g.p194a.p195a.p198m.LogManager.m2428c(r1, r3, r0)
            r2 = 1
            goto L1e
        L43:
            if (r2 == 0) goto L56
            g.a.a.n.r.c r0 = new g.a.a.n.r.c
            r5 = r0
            r6 = r14
            r7 = r15
            r9 = r17
            r11 = r19
            r12 = r20
            r13 = r21
            r5.<init>(r6, r7, r9, r11, r12, r13)
            return r0
        L56:
            if (r4 == 0) goto L69
            g.a.a.n.r.e r0 = new g.a.a.n.r.e
            r1 = r0
            r2 = r14
            r3 = r15
            r5 = r17
            r7 = r19
            r8 = r20
            r9 = r21
            r1.<init>(r2, r3, r5, r7, r8, r9)
            return r0
        L69:
            g.a.a.n.r.d r0 = new g.a.a.n.r.d
            r1 = r0
            r2 = r14
            r3 = r15
            r5 = r17
            r7 = r19
            r8 = r20
            r9 = r21
            r1.<init>(r2, r3, r5, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p195a.p199n.p200r.CycledLeScanner.m2278a(android.content.Context, long, long, boolean, g.a.a.n.r.a, g.a.b.b):g.a.a.n.r.b");
    }

    /* renamed from: b */
    public void m2273b() {
        LogManager.m2432a("CycledLeScanner", "cancel wakeup alarm: %s", this.f8676y);
        ((AlarmManager) this.f8663l.getSystemService("alarm")).set(2, Long.MAX_VALUE, m2264l());
        LogManager.m2432a("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", Long.valueOf(Long.MAX_VALUE - SystemClock.elapsedRealtime()), m2264l());
    }

    /* renamed from: a */
    public void m2279a(long j, long j2, boolean z) {
        LogManager.m2432a("CycledLeScanner", "Set scan periods called with %s, %s Background mode must have changed.", Long.valueOf(j), Long.valueOf(j2));
        if (this.f8673v != z) {
            this.f8674w = true;
        }
        this.f8673v = z;
        this.f8664m = j;
        this.f8667p = j2;
        if (this.f8673v) {
            LogManager.m2432a("CycledLeScanner", "We are in the background.  Setting wakeup alarm", new Object[0]);
            m2261o();
        } else {
            LogManager.m2432a("CycledLeScanner", "We are not in the background.  Cancelling wakeup alarm", new Object[0]);
            m2273b();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.f8655d;
        if (j3 > elapsedRealtime) {
            long j4 = this.f8654c + j2;
            if (j4 < j3) {
                this.f8655d = j4;
                LogManager.m2428c("CycledLeScanner", "Adjusted nextScanStartTime to be %s", new Date((this.f8655d - SystemClock.elapsedRealtime()) + System.currentTimeMillis()));
            }
        }
        long j5 = this.f8656e;
        if (j5 > elapsedRealtime) {
            long j6 = this.f8653b + j;
            if (j6 < j5) {
                this.f8656e = j6;
                LogManager.m2428c("CycledLeScanner", "Adjusted scanStopTime to be %s", Long.valueOf(this.f8656e));
            }
        }
    }

    /* renamed from: a */
    public void m2274a(boolean z) {
        this.f8675x = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:14|(3:21|22|23)|24|25|26|(2:28|(3:30|(2:36|(5:38|(1:40)(1:50)|41|42|(1:46))(1:51))(1:34)|35)(1:52))|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d2, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d3, code lost:
        p193g.p194a.p195a.p198m.LogManager.m2431a(r8, "CycledLeScanner", "Exception starting Bluetooth scan.  Perhaps Bluetooth is disabled or unavailable?", new java.lang.Object[0]);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2276a(java.lang.Boolean r8) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p195a.p199n.p200r.CycledLeScanner.m2276a(java.lang.Boolean):void");
    }

    /* renamed from: a */
    public void m2280a() {
        if (this.f8666o == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_BACKGROUND");
            intentFilter.addAction("android.intent.action.USER_FOREGROUND");
            this.f8666o = new C1847c();
            this.f8663l.registerReceiver(this.f8666o, intentFilter);
        }
    }

    /* renamed from: a */
    public final boolean m2275a(String str) {
        return this.f8663l.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
