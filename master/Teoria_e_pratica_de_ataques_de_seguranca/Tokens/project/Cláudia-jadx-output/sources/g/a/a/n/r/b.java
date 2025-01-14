package g.a.a.n.r;

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
/* compiled from: CycledLeScanner.java */
@TargetApi(18)
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public BluetoothAdapter f6185a;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6192h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6193i;
    public final Context l;
    public long m;
    public long p;
    public final Handler r;
    public final g.a.b.b t;
    public final g.a.a.n.r.a u;
    public boolean v;

    /* renamed from: b  reason: collision with root package name */
    public long f6186b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f6187c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f6188d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f6189e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f6190f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6191g = false;
    public boolean j = false;
    public boolean k = false;
    public boolean n = false;
    public BroadcastReceiver o = null;
    public final Handler q = new Handler(Looper.getMainLooper());
    public boolean w = false;
    public volatile boolean x = false;
    public PendingIntent y = null;
    public final HandlerThread s = new HandlerThread("CycledLeScannerThread");

    /* compiled from: CycledLeScanner.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a.a.m.d.a("CycledLeScanner", "Quitting scan thread", new Object[0]);
            b.this.s.quit();
        }
    }

    /* compiled from: CycledLeScanner.java */
    /* renamed from: g.a.a.n.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0124b implements Runnable {
        public RunnableC0124b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.n();
        }
    }

    /* compiled from: CycledLeScanner.java */
    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            g.a.a.m.d.d("CycledLeScanner", "User switch detected.  Cancelling alarm to prevent potential crash.", new Object[0]);
            b.this.b();
        }
    }

    public b(Context context, long j, long j2, boolean z, g.a.a.n.r.a aVar, g.a.b.b bVar) {
        this.v = false;
        this.m = j;
        this.p = j2;
        this.l = context;
        this.u = aVar;
        this.t = bVar;
        this.v = z;
        this.s.start();
        this.r = new Handler(this.s.getLooper());
    }

    public void b(boolean z) {
        this.f6191g = z;
    }

    public final boolean c() {
        return a("android.permission.ACCESS_COARSE_LOCATION") || a("android.permission.ACCESS_FINE_LOCATION");
    }

    public void d() {
        BroadcastReceiver broadcastReceiver = this.o;
        if (broadcastReceiver != null) {
            try {
                this.l.unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
            this.o = null;
        }
    }

    public abstract boolean e();

    public void f() {
        g.a.a.m.d.a("CycledLeScanner", "Destroying", new Object[0]);
        this.q.removeCallbacksAndMessages(null);
        this.r.post(new a());
        d();
    }

    public abstract void g();

    public final void h() {
        g.a.a.m.d.a("CycledLeScanner", "Done with scan cycle", new Object[0]);
        try {
            this.u.a();
            if (this.f6192h) {
                if (i() != null) {
                    if (i().isEnabled()) {
                        if (this.x && this.p == 0 && !m()) {
                            g.a.a.m.d.a("CycledLeScanner", "Not stopping scanning.  Device capable of multiple indistinct detections per scan.", new Object[0]);
                            this.n = true;
                            this.f6187c = SystemClock.elapsedRealtime();
                        }
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (Build.VERSION.SDK_INT >= 24 && this.p + this.m < 6000 && elapsedRealtime - this.f6186b < 6000) {
                            g.a.a.m.d.a("CycledLeScanner", "Not stopping scan because this is Android N and we keep scanning for a minimum of 6 seconds at a time. We will stop in " + (6000 - (elapsedRealtime - this.f6186b)) + " millisconds.", new Object[0]);
                            this.n = true;
                        } else {
                            try {
                                g.a.a.m.d.a("CycledLeScanner", "stopping bluetooth le scan", new Object[0]);
                                g();
                                this.n = false;
                            } catch (Exception e2) {
                                g.a.a.m.d.b(e2, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
                            }
                        }
                        this.f6187c = SystemClock.elapsedRealtime();
                    } else {
                        g.a.a.m.d.a("CycledLeScanner", "Bluetooth is disabled.  Cannot scan for beacons.", new Object[0]);
                        this.w = true;
                    }
                }
                this.f6188d = k();
                if (this.k) {
                    a((Boolean) true);
                }
            }
            if (this.k) {
                return;
            }
            g.a.a.m.d.a("CycledLeScanner", "Scanning disabled. ", new Object[0]);
            this.j = false;
            b();
        } catch (SecurityException unused) {
            g.a.a.m.d.d("CycledLeScanner", "SecurityException working accessing bluetooth.", new Object[0]);
        }
    }

    public BluetoothAdapter i() {
        try {
            if (this.f6185a == null) {
                this.f6185a = ((BluetoothManager) this.l.getApplicationContext().getSystemService("bluetooth")).getAdapter();
                if (this.f6185a == null) {
                    g.a.a.m.d.d("CycledLeScanner", "Failed to construct a BluetoothAdapter", new Object[0]);
                }
            }
        } catch (SecurityException unused) {
            g.a.a.m.d.b("CycledLeScanner", "Cannot consruct bluetooth adapter.  Security Exception", new Object[0]);
        }
        return this.f6185a;
    }

    public boolean j() {
        return this.x;
    }

    public final long k() {
        long j = this.p;
        if (j == 0) {
            return SystemClock.elapsedRealtime();
        }
        long elapsedRealtime = j - (SystemClock.elapsedRealtime() % (this.m + j));
        g.a.a.m.d.a("CycledLeScanner", "Normalizing between scan period from %s to %s", Long.valueOf(this.p), Long.valueOf(elapsedRealtime));
        return SystemClock.elapsedRealtime() + elapsedRealtime;
    }

    public PendingIntent l() {
        if (this.y == null) {
            Intent intent = new Intent(this.l, StartupBroadcastReceiver.class);
            intent.putExtra("wakeup", true);
            this.y = PendingIntent.getBroadcast(this.l, 0, intent, 134217728);
        }
        return this.y;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m() {
        /*
            r9 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = r9.p
            long r0 = r0 + r2
            long r2 = r9.m
            long r0 = r0 + r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 1
            r4 = 0
            r5 = 24
            if (r2 < r5) goto L24
            long r5 = r9.f6190f
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
            g.a.a.m.d.a(r1, r2, r0)
            boolean r0 = r9.f6191g
            if (r0 == 0) goto L3c
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r2 = "Stopping scan to prevent Android N scan timeout."
            g.a.a.m.d.a(r1, r2, r0)
            return r3
        L3c:
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r2 = "Allowing a long running scan to be stopped by the OS.  To prevent this, set longScanForcingEnabled in the AndroidBeaconLibrary."
            g.a.a.m.d.d(r1, r2, r0)
        L43:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.n.r.b.m():boolean");
    }

    public void n() {
        long elapsedRealtime = this.f6189e - SystemClock.elapsedRealtime();
        if (this.k && elapsedRealtime > 0) {
            g.a.a.m.d.a("CycledLeScanner", "Waiting to stop scan cycle for another %s milliseconds", Long.valueOf(elapsedRealtime));
            if (this.v) {
                o();
            }
            Handler handler = this.q;
            RunnableC0124b runnableC0124b = new RunnableC0124b();
            if (elapsedRealtime > 1000) {
                elapsedRealtime = 1000;
            }
            handler.postDelayed(runnableC0124b, elapsedRealtime);
            return;
        }
        h();
    }

    public void o() {
        long j = this.p;
        if (300000 >= j) {
            j = 300000;
        }
        long j2 = this.m;
        if (j < j2) {
            j = j2;
        }
        ((AlarmManager) this.l.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, l());
        g.a.a.m.d.a("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", Long.valueOf(j), l());
        a();
    }

    public void p() {
        g.a.a.m.d.a("CycledLeScanner", "start called", new Object[0]);
        this.k = true;
        if (!this.j) {
            a((Boolean) true);
        } else {
            g.a.a.m.d.a("CycledLeScanner", "scanning already started", new Object[0]);
        }
    }

    public abstract void q();

    public void r() {
        g.a.a.m.d.a("CycledLeScanner", "stop called", new Object[0]);
        this.k = false;
        if (this.j) {
            a((Boolean) false);
            if (this.n) {
                g.a.a.m.d.a("CycledLeScanner", "Stopping scanning previously left on.", new Object[0]);
                this.n = false;
                try {
                    g.a.a.m.d.a("CycledLeScanner", "stopping bluetooth le scan", new Object[0]);
                    g();
                    return;
                } catch (Exception e2) {
                    g.a.a.m.d.b(e2, "CycledLeScanner", "Internal Android exception scanning for beacons", new Object[0]);
                    return;
                }
            }
            return;
        }
        g.a.a.m.d.a("CycledLeScanner", "scanning already stopped", new Object[0]);
    }

    public abstract void s();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static g.a.a.n.r.b a(android.content.Context r14, long r15, long r17, boolean r19, g.a.a.n.r.a r20, g.a.b.b r21) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = "CycledLeScanner"
            r2 = 0
            r3 = 18
            if (r0 >= r3) goto L12
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "Not supported prior to API 18."
            g.a.a.m.d.d(r1, r2, r0)
            r0 = 0
            return r0
        L12:
            r3 = 21
            r4 = 1
            if (r0 >= r3) goto L20
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is pre Android 5.0.  We are using old scanning APIs"
            g.a.a.m.d.c(r1, r3, r0)
        L1e:
            r4 = 0
            goto L43
        L20:
            r3 = 26
            if (r0 >= r3) goto L3a
            boolean r0 = org.altbeacon.beacon.BeaconManager.J()
            if (r0 == 0) goto L32
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is Android 5.0, but L scanning is disabled. We are using old scanning APIs"
            g.a.a.m.d.c(r1, r3, r0)
            goto L1e
        L32:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "This is Android 5.0.  We are using new scanning APIs"
            g.a.a.m.d.c(r1, r3, r0)
            goto L43
        L3a:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "Using Android O scanner"
            g.a.a.m.d.c(r1, r3, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.n.r.b.a(android.content.Context, long, long, boolean, g.a.a.n.r.a, g.a.b.b):g.a.a.n.r.b");
    }

    public void b() {
        g.a.a.m.d.a("CycledLeScanner", "cancel wakeup alarm: %s", this.y);
        ((AlarmManager) this.l.getSystemService("alarm")).set(2, Long.MAX_VALUE, l());
        g.a.a.m.d.a("CycledLeScanner", "Set a wakeup alarm to go off in %s ms: %s", Long.valueOf(Long.MAX_VALUE - SystemClock.elapsedRealtime()), l());
    }

    public void a(long j, long j2, boolean z) {
        g.a.a.m.d.a("CycledLeScanner", "Set scan periods called with %s, %s Background mode must have changed.", Long.valueOf(j), Long.valueOf(j2));
        if (this.v != z) {
            this.w = true;
        }
        this.v = z;
        this.m = j;
        this.p = j2;
        if (this.v) {
            g.a.a.m.d.a("CycledLeScanner", "We are in the background.  Setting wakeup alarm", new Object[0]);
            o();
        } else {
            g.a.a.m.d.a("CycledLeScanner", "We are not in the background.  Cancelling wakeup alarm", new Object[0]);
            b();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = this.f6188d;
        if (j3 > elapsedRealtime) {
            long j4 = this.f6187c + j2;
            if (j4 < j3) {
                this.f6188d = j4;
                g.a.a.m.d.c("CycledLeScanner", "Adjusted nextScanStartTime to be %s", new Date((this.f6188d - SystemClock.elapsedRealtime()) + System.currentTimeMillis()));
            }
        }
        long j5 = this.f6189e;
        if (j5 > elapsedRealtime) {
            long j6 = this.f6186b + j;
            if (j6 < j5) {
                this.f6189e = j6;
                g.a.a.m.d.c("CycledLeScanner", "Adjusted scanStopTime to be %s", Long.valueOf(this.f6189e));
            }
        }
    }

    public void a(boolean z) {
        this.x = z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:14|(3:21|22|23)|24|25|26|(2:28|(3:30|(2:36|(5:38|(1:40)(1:50)|41|42|(1:46))(1:51))(1:34)|35)(1:52))|22|23) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d2, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d3, code lost:
        g.a.a.m.d.a(r8, "CycledLeScanner", "Exception starting Bluetooth scan.  Perhaps Bluetooth is disabled or unavailable?", new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.Boolean r8) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.n.r.b.a(java.lang.Boolean):void");
    }

    public void a() {
        if (this.o == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_BACKGROUND");
            intentFilter.addAction("android.intent.action.USER_FOREGROUND");
            this.o = new c();
            this.l.registerReceiver(this.o, intentFilter);
        }
    }

    public final boolean a(String str) {
        return this.l.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
