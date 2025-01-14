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
import g.a.a.d;
import g.a.a.h;
import g.a.a.i;
import g.a.a.j;
import g.a.a.n.e;
import g.a.a.n.k;
import g.a.a.n.m;
import g.a.a.n.o;
import g.a.a.n.p;
import g.a.a.n.r.g;
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
/* loaded from: classes.dex */
public class BeaconManager {
    public static String A = "https://s3.amazonaws.com/android-beacon-library/android-distance.json";
    public static volatile BeaconManager u = null;
    public static boolean v = false;
    public static boolean w = false;
    public static long y = 10000;
    public static g.a.a.o.a z;

    /* renamed from: a  reason: collision with root package name */
    public final Context f7594a;

    /* renamed from: i  reason: collision with root package name */
    public g f7602i;
    public static final Object x = new Object();
    public static Class B = k.class;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<d, c> f7595b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public Messenger f7596c = null;

    /* renamed from: d  reason: collision with root package name */
    public final Set<i> f7597d = new CopyOnWriteArraySet();

    /* renamed from: e  reason: collision with root package name */
    public i f7598e = null;

    /* renamed from: f  reason: collision with root package name */
    public final Set<h> f7599f = new CopyOnWriteArraySet();

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<j> f7600g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public final List<BeaconParser> f7601h = new CopyOnWriteArrayList();
    public boolean j = true;
    public boolean k = false;
    public boolean l = false;
    public Boolean m = null;
    public boolean n = false;
    public Notification o = null;
    public int p = -1;
    public long q = 1100;
    public long r = 0;
    public long s = 10000;
    public long t = 300000;

    /* loaded from: classes.dex */
    public class ServiceNotDeclaredException extends RuntimeException {
        public ServiceNotDeclaredException(BeaconManager beaconManager) {
            super("The BeaconService is not properly declared in AndroidManifest.xml.  If using Eclipse, please verify that your project.properties has manifestmerger.enabled=true");
        }
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.a.a.m.d.a("BeaconManager", "we have a connection to the service now", new Object[0]);
            if (BeaconManager.this.m == null) {
                BeaconManager.this.m = false;
            }
            BeaconManager.this.f7596c = new Messenger(iBinder);
            BeaconManager.this.a();
            synchronized (BeaconManager.this.f7595b) {
                for (Map.Entry entry : BeaconManager.this.f7595b.entrySet()) {
                    if (!((c) entry.getValue()).f7604a) {
                        ((d) entry.getKey()).onBeaconServiceConnect();
                        ((c) entry.getValue()).f7604a = true;
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            g.a.a.m.d.b("BeaconManager", "onServiceDisconnected", new Object[0]);
            BeaconManager.this.f7596c = null;
        }

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7604a;

        /* renamed from: b  reason: collision with root package name */
        public b f7605b;

        public c(BeaconManager beaconManager) {
            this.f7604a = false;
            this.f7604a = false;
            this.f7605b = new b();
        }
    }

    public BeaconManager(Context context) {
        this.f7594a = context.getApplicationContext();
        c();
        if (!w) {
            E();
        }
        this.f7601h.add(new g.a.a.b());
        B();
    }

    public static g.a.a.o.a F() {
        return z;
    }

    public static String G() {
        return A;
    }

    public static long H() {
        return y;
    }

    public static Class I() {
        return B;
    }

    public static boolean J() {
        return v;
    }

    public static void e(long j) {
        y = j;
        BeaconManager beaconManager = u;
        if (beaconManager != null) {
            beaconManager.a();
        }
    }

    public boolean A() {
        Boolean bool = this.m;
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public final void B() {
        this.n = Build.VERSION.SDK_INT >= 26;
    }

    public void C() {
        if (this.n) {
            if (Build.VERSION.SDK_INT >= 21) {
                m.b().a(this.f7594a, this);
                return;
            }
            return;
        }
        try {
            a(7, (j) null);
        } catch (RemoteException e2) {
            g.a.a.m.d.b("BeaconManager", "Failed to sync settings to service", e2);
        }
    }

    @TargetApi(18)
    public void D() {
        if (!x()) {
            g.a.a.m.d.d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        } else if (d()) {
        } else {
            g.a.a.m.d.a("BeaconManager", "updating background flag to %s", Boolean.valueOf(this.k));
            g.a.a.m.d.a("BeaconManager", "updating scan period to %s, %s", Long.valueOf(t()), Long.valueOf(i()));
            a(6, (j) null);
        }
    }

    public final void E() {
        List<ResolveInfo> queryIntentServices = this.f7594a.getPackageManager().queryIntentServices(new Intent(this.f7594a, BeaconService.class), 65536);
        if (queryIntentServices != null && queryIntentServices.isEmpty()) {
            throw new ServiceNotDeclaredException(this);
        }
    }

    public void c(long j) {
        this.r = j;
    }

    public void d(long j) {
        this.q = j;
    }

    public boolean f() {
        return this.k;
    }

    public long g() {
        return this.s;
    }

    public List<BeaconParser> h() {
        return this.f7601h;
    }

    public final long i() {
        if (this.k) {
            return this.t;
        }
        return this.r;
    }

    public i j() {
        return this.f7598e;
    }

    public long k() {
        return this.r;
    }

    public long l() {
        return this.q;
    }

    public Notification m() {
        return this.o;
    }

    public int n() {
        return this.p;
    }

    public Collection<j> o() {
        return e.a(this.f7594a).d();
    }

    public Set<h> p() {
        return Collections.unmodifiableSet(this.f7599f);
    }

    public g q() {
        return this.f7602i;
    }

    public Collection<j> r() {
        ArrayList arrayList;
        synchronized (this.f7600g) {
            arrayList = new ArrayList(this.f7600g);
        }
        return arrayList;
    }

    public Set<i> s() {
        return Collections.unmodifiableSet(this.f7597d);
    }

    public final long t() {
        if (this.k) {
            return this.s;
        }
        return this.q;
    }

    public boolean u() {
        return this.n;
    }

    public boolean v() {
        boolean z2;
        synchronized (this.f7595b) {
            z2 = !this.f7595b.isEmpty() && (this.n || this.f7596c != null);
        }
        return z2;
    }

    public final boolean w() {
        if (Build.VERSION.SDK_INT < 18) {
            g.a.a.m.d.d("BeaconManager", "Bluetooth LE not supported prior to API 18.", new Object[0]);
            return false;
        } else if (this.f7594a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return true;
        } else {
            g.a.a.m.d.d("BeaconManager", "This device does not support bluetooth LE.", new Object[0]);
            return false;
        }
    }

    public final boolean x() {
        if (F() != null) {
            return true;
        }
        return w();
    }

    public boolean y() {
        return this.l;
    }

    public boolean z() {
        return this.j;
    }

    public static void d(boolean z2) {
        v = z2;
        BeaconManager beaconManager = u;
        if (beaconManager != null) {
            beaconManager.a();
        }
    }

    public void b(long j) {
        this.s = j;
    }

    public void c(boolean z2) {
        this.m = Boolean.valueOf(z2);
    }

    public boolean b(d dVar) {
        boolean z2;
        synchronized (this.f7595b) {
            if (dVar != null) {
                try {
                    z2 = (this.f7595b.get(dVar) != null && (this.n || this.f7596c != null)) ? true : true;
                } finally {
                }
            }
            z2 = false;
        }
        return z2;
    }

    public void c() {
        g.a.a.p.a aVar = new g.a.a.p.a(this.f7594a);
        String c2 = aVar.c();
        String a2 = aVar.a();
        int b2 = aVar.b();
        this.l = aVar.d();
        g.a.a.m.d.c("BeaconManager", "BeaconManager started up on pid " + b2 + " named '" + c2 + "' for application package '" + a2 + "'.  isMainProcess=" + this.l, new Object[0]);
    }

    public void a(long j) {
        this.t = j;
        if (Build.VERSION.SDK_INT < 26 || this.t >= 900000) {
            return;
        }
        g.a.a.m.d.d("BeaconManager", "Setting a short backgroundBetweenScanPeriod has no effect on Android 8+, which is limited to scanning every ~15 minutes", new Object[0]);
    }

    public long e() {
        return this.t;
    }

    public final boolean d() {
        if (!A() || y()) {
            return false;
        }
        g.a.a.m.d.d("BeaconManager", "Ranging/Monitoring may not be controlled from a separate BeaconScanner process.  To remove this warning, please wrap this call in: if (beaconManager.isMainProcess())", new Object[0]);
        return true;
    }

    public void b(boolean z2) {
        if (!v()) {
            if (z2 && Build.VERSION.SDK_INT < 21) {
                g.a.a.m.d.b("BeaconManager", "ScanJob may not be configured because JobScheduler is not availble prior to Android 5.0", new Object[0]);
                return;
            }
            if (!z2 && Build.VERSION.SDK_INT >= 26) {
                g.a.a.m.d.d("BeaconManager", "Disabling ScanJobs on Android 8+ may disable delivery of beacon callbacks in the background unless a foreground service is active.", new Object[0]);
            }
            if (!z2 && Build.VERSION.SDK_INT >= 21) {
                m.b().a(this.f7594a);
            }
            this.n = z2;
            return;
        }
        g.a.a.m.d.b("BeaconManager", "ScanJob may not be configured because a consumer is already bound.", new Object[0]);
        throw new IllegalStateException("Method must be called before calling bind()");
    }

    public static BeaconManager a(Context context) {
        BeaconManager beaconManager = u;
        if (beaconManager == null) {
            synchronized (x) {
                beaconManager = u;
                if (beaconManager == null) {
                    beaconManager = new BeaconManager(context);
                    u = beaconManager;
                }
            }
        }
        return beaconManager;
    }

    public void c(d dVar) {
        if (!x()) {
            g.a.a.m.d.d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
            return;
        }
        synchronized (this.f7595b) {
            if (this.f7595b.containsKey(dVar)) {
                g.a.a.m.d.a("BeaconManager", "Unbinding", new Object[0]);
                if (this.n) {
                    g.a.a.m.d.a("BeaconManager", "Not unbinding from scanning service as we are using scan jobs.", new Object[0]);
                } else {
                    dVar.unbindService(this.f7595b.get(dVar).f7605b);
                }
                g.a.a.m.d.a("BeaconManager", "Before unbind, consumer count is " + this.f7595b.size(), new Object[0]);
                this.f7595b.remove(dVar);
                g.a.a.m.d.a("BeaconManager", "After unbind, consumer count is " + this.f7595b.size(), new Object[0]);
                if (this.f7595b.size() == 0) {
                    this.f7596c = null;
                    this.k = false;
                    if (this.n && Build.VERSION.SDK_INT >= 21) {
                        g.a.a.m.d.c("BeaconManager", "Cancelling scheduled jobs after unbind of last consumer.", new Object[0]);
                        m.b().a(this.f7594a);
                    }
                }
            } else {
                g.a.a.m.d.a("BeaconManager", "This consumer is not bound to: %s", dVar);
                g.a.a.m.d.a("BeaconManager", "Bound consumers: ", new Object[0]);
                for (Map.Entry<d, c> entry : this.f7595b.entrySet()) {
                    g.a.a.m.d.a("BeaconManager", String.valueOf(entry.getValue()), new Object[0]);
                }
            }
        }
    }

    public void a(d dVar) {
        if (!x()) {
            g.a.a.m.d.d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
            return;
        }
        synchronized (this.f7595b) {
            c cVar = new c(this);
            if (this.f7595b.putIfAbsent(dVar, cVar) != null) {
                g.a.a.m.d.a("BeaconManager", "This consumer is already bound", new Object[0]);
            } else {
                g.a.a.m.d.a("BeaconManager", "This consumer is not bound.  Binding now: %s", dVar);
                if (this.n) {
                    g.a.a.m.d.a("BeaconManager", "Not starting beacon scanning service. Using scheduled jobs", new Object[0]);
                    dVar.onBeaconServiceConnect();
                } else {
                    g.a.a.m.d.a("BeaconManager", "Binding to service", new Object[0]);
                    Intent intent = new Intent(dVar.getApplicationContext(), BeaconService.class);
                    if (Build.VERSION.SDK_INT >= 26 && m() != null) {
                        if (v()) {
                            g.a.a.m.d.c("BeaconManager", "Not starting foreground beacon scanning service.  A consumer is already bound, so it should be started", new Object[0]);
                        } else {
                            g.a.a.m.d.c("BeaconManager", "Starting foreground beacon scanning service.", new Object[0]);
                            this.f7594a.startForegroundService(intent);
                        }
                    }
                    dVar.bindService(intent, cVar.f7605b, 1);
                }
                g.a.a.m.d.a("BeaconManager", "consumer count is now: %s", Integer.valueOf(this.f7595b.size()));
            }
        }
    }

    @TargetApi(18)
    public void b(j jVar) {
        if (!x()) {
            g.a.a.m.d.d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        } else if (d()) {
        } else {
            synchronized (this.f7600g) {
                j jVar2 = null;
                Iterator<j> it = this.f7600g.iterator();
                while (it.hasNext()) {
                    j next = it.next();
                    if (jVar.a().equals(next.a())) {
                        jVar2 = next;
                    }
                }
                this.f7600g.remove(jVar2);
            }
            a(3, jVar);
        }
    }

    public final String b() {
        String packageName = this.f7594a.getPackageName();
        g.a.a.m.d.a("BeaconManager", "callback packageName: %s", packageName);
        return packageName;
    }

    public void a(boolean z2) {
        if (!x()) {
            g.a.a.m.d.d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        } else if (z2 != this.k) {
            this.k = z2;
            try {
                D();
            } catch (RemoteException unused) {
                g.a.a.m.d.b("BeaconManager", "Cannot contact service to set scan periods", new Object[0]);
            }
        }
    }

    public void a(i iVar) {
        if (iVar != null) {
            this.f7597d.add(iVar);
        }
    }

    public void a(h hVar) {
        if (d() || hVar == null) {
            return;
        }
        this.f7599f.add(hVar);
    }

    @TargetApi(18)
    public void a(j jVar) {
        if (!x()) {
            g.a.a.m.d.d("BeaconManager", "Method invocation will be ignored.", new Object[0]);
        } else if (d()) {
        } else {
            synchronized (this.f7600g) {
                this.f7600g.add(jVar);
            }
            a(2, jVar);
        }
    }

    public void a() {
        if (d()) {
            return;
        }
        if (!v()) {
            g.a.a.m.d.a("BeaconManager", "Not synchronizing settings to service, as it has not started up yet", new Object[0]);
        } else if (A()) {
            g.a.a.m.d.a("BeaconManager", "Synchronizing settings to service", new Object[0]);
            C();
        } else {
            g.a.a.m.d.a("BeaconManager", "Not synchronizing settings to service, as it is in the same process", new Object[0]);
        }
    }

    @TargetApi(18)
    public final void a(int i2, j jVar) {
        if (!v()) {
            g.a.a.m.d.d("BeaconManager", "The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()", new Object[0]);
        } else if (this.n) {
            if (Build.VERSION.SDK_INT >= 21) {
                m.b().a(this.f7594a, this);
            }
        } else {
            Message obtain = Message.obtain(null, i2, 0, 0);
            if (i2 == 6) {
                obtain.setData(new p(t(), i(), this.k).f());
            } else if (i2 == 7) {
                o oVar = new o();
                oVar.a(this.f7594a);
                obtain.setData(oVar.a());
            } else {
                obtain.setData(new p(jVar, b(), t(), i(), this.k).f());
            }
            this.f7596c.send(obtain);
        }
    }
}
