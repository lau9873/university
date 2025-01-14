package h.a.a;

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
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.BackendListeners;
/* compiled from: BLEAltBeaconManager.java */
/* loaded from: classes.dex */
public class e implements g.a.a.d {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6272a;

    /* renamed from: b  reason: collision with root package name */
    public BeaconManager f6273b;

    /* renamed from: c  reason: collision with root package name */
    public g.a.a.j f6274c;

    /* renamed from: d  reason: collision with root package name */
    public d f6275d;

    /* renamed from: e  reason: collision with root package name */
    public r f6276e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6277f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6278g = false;

    /* renamed from: h  reason: collision with root package name */
    public long f6279h = 5000;

    /* renamed from: i  reason: collision with root package name */
    public long f6280i = 3000;
    public g.a.a.h j = new a(this);
    public g.a.a.i k = new b();
    public BroadcastReceiver l = new c();

    /* compiled from: BLEAltBeaconManager.java */
    /* loaded from: classes.dex */
    public class a implements g.a.a.h {
        public a(e eVar) {
        }

        @Override // g.a.a.h
        public void didDetermineStateForRegion(int i2, g.a.a.j jVar) {
            q.b("");
        }

        @Override // g.a.a.h
        public void didEnterRegion(g.a.a.j jVar) {
            q.b("");
        }

        @Override // g.a.a.h
        public void didExitRegion(g.a.a.j jVar) {
            q.b("");
        }
    }

    /* compiled from: BLEAltBeaconManager.java */
    /* loaded from: classes.dex */
    public class b implements g.a.a.i {

        /* compiled from: BLEAltBeaconManager.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f6282a;

            public a(List list) {
                this.f6282a = list;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.c
            public void a(Location location) {
                try {
                    if (e.this.f6275d != null) {
                        e.this.f6275d.a(w.d().h(), w.d().g(), this.f6282a, location != null ? location.getLatitude() : 0.0d, location != null ? location.getLongitude() : 0.0d, location != null ? location.getAccuracy() : 0.0d);
                    }
                } catch (Throwable th) {
                    h.a.a.c.a("COMM_BLUETOOTH", "BLEAltBeaconManager", "didRangeBeaconsInRegion", "Error while reporting to listener: " + Log.getStackTraceString(th));
                }
            }
        }

        public b() {
        }

        @Override // g.a.a.i
        public void didRangeBeaconsInRegion(Collection<g.a.a.c> collection, g.a.a.j jVar) {
            h.a.a.c.a("COMM_BLUETOOTH", "BLEAltBeaconManager", "didRangeBeaconsInRegion", (collection == null || collection.size() <= 0) ? "No beacons found" : collection.size() + " beacons found");
            if (collection == null || collection.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (g.a.a.c cVar : collection) {
                if (cVar.j() == 65194 && cVar.a() == 0) {
                    h.a.a.c.a("COMM_BLUETOOTH", "BLEAltBeaconManager", "didRangeBeaconsInRegion", "BLE scan result found: " + cVar.b());
                    byte[] bArr = null;
                    if (cVar.g() != null && cVar.g().b() == 10 && cVar.h() != null && cVar.h().b() == 6) {
                        bArr = Arrays.copyOf(cVar.g().c(), cVar.g().b() + cVar.h().b());
                        System.arraycopy(cVar.h().c(), 0, bArr, cVar.g().b(), cVar.h().b());
                    }
                    arrayList.add(new f(cVar.b(), cVar.c(), cVar.k(), cVar.i(), bArr));
                }
            }
            if (!e.this.f6277f || e.this.f6276e == null) {
                if (e.this.f6275d != null) {
                    e.this.f6275d.a(w.d().h(), w.d().g(), arrayList, 0.0d, 0.0d, 0.0d);
                    return;
                }
                return;
            }
            e.this.f6276e.a(new a(arrayList));
        }
    }

    /* compiled from: BLEAltBeaconManager.java */
    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.SCREEN_ON")) {
                if (e.this.f6278g) {
                    if (!Build.MANUFACTURER.equalsIgnoreCase("Huawei")) {
                        e.this.f6278g = false;
                    } else {
                        h.a.a.c.a("COMM_BLUETOOTH", "BLEAltBeaconManager", "screenStateReceiver", "Huawei device with screen on detected");
                        e.this.f6278g = false;
                    }
                    e eVar = e.this;
                    eVar.a(eVar.f6279h, e.this.f6280i);
                }
            } else if (action.equals("android.intent.action.SCREEN_OFF") && !e.this.f6278g && Build.MANUFACTURER.equalsIgnoreCase("Huawei")) {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEAltBeaconManager", "screenStateReceiver", "Huawei device with screen off detected");
                e.this.f6278g = true;
                e eVar2 = e.this;
                eVar2.a(Long.MAX_VALUE, eVar2.f6280i);
            }
        }
    }

    /* compiled from: BLEAltBeaconManager.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(long j, long j2, List<f> list, double d2, double d3, double d4);
    }

    public e(Context context) {
        this.f6274c = null;
        Context context2 = (Context) t.a(context);
        this.f6272a = context2;
        BeaconManager a2 = BeaconManager.a(context2);
        this.f6273b = a2;
        List<BeaconParser> h2 = a2.h();
        BeaconParser beaconParser = new BeaconParser();
        beaconParser.a("s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19");
        h2.add(beaconParser);
        this.f6274c = new g.a.a.j("pt.card4b.backendbeacons", null, null, null);
        try {
            this.f6276e = new r();
        } catch (Throwable th) {
            this.f6276e = null;
            h.a.a.c.a("COMM_BLUETOOTH", "BLEAltBeaconManager", "BLEAltBeaconManager", "Failed to create location tracker instance." + Log.getStackTraceString(th));
        }
        this.f6273b.b(false);
        this.f6273b.a(this.j);
        this.f6273b.a(this.k);
    }

    @Override // g.a.a.d
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        return App.getContext().bindService(intent, serviceConnection, i2);
    }

    @Override // g.a.a.d
    public Context getApplicationContext() {
        return this.f6272a;
    }

    @Override // g.a.a.d
    public void onBeaconServiceConnect() {
        try {
            this.f6273b.a(false);
            this.f6273b.a(this.f6274c);
        } catch (Throwable unused) {
        }
    }

    @Override // g.a.a.d
    public void unbindService(ServiceConnection serviceConnection) {
        App.getContext().unbindService(serviceConnection);
    }

    public void b(long j, long j2) {
        this.f6279h = j;
        this.f6280i = j2;
        a(j, j2);
    }

    public void c() {
        try {
            if (this.f6273b.b(this)) {
                this.f6273b.b(this.f6274c);
                this.f6273b.c(this);
            }
            App.getContext().unregisterReceiver(this.l);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        this.f6273b.d(this.f6279h);
        this.f6273b.c(this.f6280i);
        this.f6273b.b(this.f6279h);
        this.f6273b.a(this.f6280i);
        this.f6273b.a();
    }

    public void b() {
        try {
            if (!this.f6273b.b(this)) {
                this.f6273b.a(this);
            }
            if (((PowerManager) getApplicationContext().getSystemService("power")).isInteractive()) {
                this.f6278g = false;
            } else if (Build.MANUFACTURER.equalsIgnoreCase("Huawei")) {
                this.f6278g = true;
                h.a.a.c.a("COMM_BLUETOOTH", "BLEAltBeaconManager", "onCreate", "Huawei device with screen off detected");
                a(Long.MAX_VALUE, this.f6280i);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            App.getContext().registerReceiver(this.l, intentFilter);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        this.f6277f = z;
    }

    public void a() {
        c();
    }

    public void a(d dVar) {
        this.f6275d = dVar;
    }
}
