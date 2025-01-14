package pt.card4b.backendbeacons;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.ParcelUuid;
import android.os.PowerManager;
import android.os.RemoteException;
import android.util.Log;
import h.a.a.l;
import h.a.a.o;
import h.a.a.r;
import h.a.a.t;
import h.a.a.u;
import h.a.a.w;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* loaded from: classes.dex */
public class BLEService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public BluetoothAdapter.LeScanCallback f7647b;

    /* renamed from: c  reason: collision with root package name */
    public ScanCallback f7648c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentHashMap<String, h.a.a.f> f7649d;

    /* renamed from: e  reason: collision with root package name */
    public BluetoothAdapter f7650e;

    /* renamed from: f  reason: collision with root package name */
    public HandlerThread f7651f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f7652g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7653h;

    /* renamed from: i  reason: collision with root package name */
    public Messenger f7654i;
    public u j;
    public u k;
    public PowerManager.WakeLock p;
    public Messenger r;
    public r x;
    public int l = 2;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public Object q = new Object();
    public final ParcelUuid s = ParcelUuid.fromString("0000feaa-0000-1000-8000-00805f9b34fb");
    public final byte[] t = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public final byte[] u = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public boolean v = true;
    public boolean w = false;
    public Object y = new Object();
    public boolean z = false;
    public long A = 0;
    public long B = 0;
    public Object C = new Object();
    public BroadcastReceiver D = new a();
    public Runnable E = new c();
    public Runnable F = new d();

    /* renamed from: a  reason: collision with root package name */
    public final Messenger f7646a = new Messenger(new e(this, null));

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.SCREEN_ON")) {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "screenStateReceiver", "Device screen ON detected");
                BLEService.this.z = false;
                BLEService.this.B = 0L;
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "screenStateReceiver", "Device screen OFF detected");
                if (!BLEService.this.z && Build.MANUFACTURER.equalsIgnoreCase("Huawei") && Build.VERSION.SDK_INT >= 24) {
                    h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "screenStateReceiver", "Activate scanning restrictions with screen off");
                    BLEService.this.z = true;
                }
                if (BLEService.this.B == 0) {
                    BLEService.this.B = w.d().h();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ScanCallback {
        public b() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            try {
                synchronized (BLEService.this.C) {
                    byte[] bArr = null;
                    byte b2 = 0;
                    for (ScanResult scanResult : list) {
                        if (!BLEService.this.f7649d.containsKey(scanResult.getDevice().getAddress())) {
                            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onBatchScanResults", "BLE scan result found: " + scanResult.getDevice().getAddress());
                            if (scanResult.getScanRecord().getServiceData(BLEService.this.s) != null && scanResult.getScanRecord().getServiceData(BLEService.this.s).length >= 18) {
                                bArr = Arrays.copyOfRange(scanResult.getScanRecord().getServiceData(BLEService.this.s), 2, 18);
                                b2 = scanResult.getScanRecord().getServiceData(BLEService.this.s)[1];
                            }
                            BLEService.this.f7649d.put(scanResult.getDevice().getAddress(), new h.a.a.f(scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b2, scanResult.getRssi(), bArr));
                        }
                    }
                }
            } catch (Throwable th) {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onBatchScanResults", "Exception: " + Log.getStackTraceString(th));
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i2) {
            try {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onScanFailed", "BLE scan callback reported a failure with error " + i2);
                if (BLEService.this.v) {
                    BLEService.this.v = false;
                    h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onScanFailed", "Try to solve disabling the use of hardware callback types");
                }
                BLEService.this.w = true;
            } catch (Throwable th) {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onScanFailed", "Exception: " + Log.getStackTraceString(th));
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i2, ScanResult scanResult) {
            byte[] bArr;
            byte b2;
            try {
                synchronized (BLEService.this.C) {
                    if (!BLEService.this.f7649d.containsKey(scanResult.getDevice().getAddress())) {
                        h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onScanResult", "BLE scan result found: " + scanResult.getDevice().getAddress());
                        if (scanResult.getScanRecord().getServiceData(BLEService.this.s) == null || scanResult.getScanRecord().getServiceData(BLEService.this.s).length < 18) {
                            bArr = null;
                            b2 = 0;
                        } else {
                            bArr = Arrays.copyOfRange(scanResult.getScanRecord().getServiceData(BLEService.this.s), 2, 18);
                            b2 = scanResult.getScanRecord().getServiceData(BLEService.this.s)[1];
                        }
                        BLEService.this.f7649d.put(scanResult.getDevice().getAddress(), new h.a.a.f(scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b2, scanResult.getRssi(), bArr));
                    }
                }
            } catch (Throwable th) {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onScanResult", "Exception: " + Log.getStackTraceString(th));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BLEService.this.g();
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* loaded from: classes.dex */
        public class a implements BackendListeners.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f7659a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f7660b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ HashMap f7661c;

            public a(long j, long j2, HashMap hashMap) {
                this.f7659a = j;
                this.f7660b = j2;
                this.f7661c = hashMap;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.c
            public void a(Location location) {
                try {
                    Message obtain = Message.obtain((Handler) null, 888);
                    obtain.obj = new o(this.f7659a, this.f7660b, this.f7661c.values(), location != null ? location.getLatitude() : 0.0d, location != null ? location.getLongitude() : 0.0d, location != null ? location.getAccuracy() : 0.0d);
                    BLEService.this.r.send(obtain);
                } catch (Throwable th) {
                    h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "AfterScanCycleTask", "Error while delivering responses: " + Log.getStackTraceString(th));
                }
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BLEService.this.a();
                long h2 = w.d().h();
                long g2 = w.d().g();
                if (BLEService.this.B != 0 && h2 - BLEService.this.B > 1500000) {
                    l.k().z();
                }
                if (!BLEService.this.z || h2 - BLEService.this.A > 1800000) {
                    BLEService.this.i();
                }
                HashMap hashMap = new HashMap();
                synchronized (BLEService.this.C) {
                    if (BLEService.this.f7649d.size() > 0) {
                        hashMap.putAll(BLEService.this.f7649d);
                    }
                    BLEService.this.f7649d.clear();
                }
                h.a.a.c.a("LOGIC_BEACONS", "BLEService", "processDiscovery", String.format("After scan task. found %d devices:", Integer.valueOf(hashMap.size())));
                if (hashMap.size() > 0) {
                    if (BLEService.this.m && BLEService.this.x != null) {
                        BLEService.this.x.a(new a(h2, g2, hashMap));
                    } else {
                        Message obtain = Message.obtain((Handler) null, 888);
                        obtain.obj = new o(h2, g2, hashMap.values(), 0.0d, 0.0d, 0.0d);
                        BLEService.this.r.send(obtain);
                    }
                }
            } catch (Throwable th) {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "afterScanRunnable", "Exception: " + Log.getStackTraceString(th));
            }
            if (BLEService.this.e() == 0) {
                BLEService.this.f7652g.post(BLEService.this.E);
            } else {
                BLEService.this.f7652g.postDelayed(BLEService.this.E, BLEService.this.e());
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends Handler {

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f7664a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Messenger f7665b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Object f7666c;

            public a(int i2, Messenger messenger, Object obj) {
                this.f7664a = i2;
                this.f7665b = messenger;
                this.f7666c = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2 = this.f7664a;
                if (i2 == 7) {
                    BLEService.this.f7654i = this.f7665b;
                } else if (i2 == 666) {
                    BLEService.this.r = this.f7665b;
                    h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "StartDiscovery");
                    BLEService.this.f();
                } else if (i2 != 777) {
                    switch (i2) {
                        case 9:
                            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "Setting foreground scan period: " + BLEService.this.j);
                            BLEService.this.j = (u) this.f7666c;
                            return;
                        case 10:
                            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "Setting background scan period: " + BLEService.this.k);
                            BLEService.this.k = (u) this.f7666c;
                            return;
                        case 11:
                            BLEService.this.l = ((Integer) this.f7666c).intValue();
                            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", String.format("Bluetooth ScanMode set to %d", Integer.valueOf(BLEService.this.l)));
                            return;
                        case 12:
                            BLEService.this.m = ((Boolean) this.f7666c).booleanValue();
                            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", String.format("Add location info set to %s", Boolean.valueOf(BLEService.this.m)));
                            return;
                        case 13:
                            BLEService.this.n = ((Boolean) this.f7666c).booleanValue();
                            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", String.format("Add use scan filters set to %s", Boolean.valueOf(BLEService.this.n)));
                            return;
                        default:
                            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "Unknown message: what=" + this.f7664a + " obj=" + this.f7666c);
                            return;
                    }
                } else {
                    h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "StopDiscovery");
                    BLEService.this.h();
                }
            }
        }

        public /* synthetic */ e(BLEService bLEService, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            Object obj = message.obj;
            BLEService.this.f7652g.post(new a(i2, message.replyTo, obj));
        }

        public e() {
        }
    }

    /* loaded from: classes.dex */
    public class f implements BluetoothAdapter.LeScanCallback {
        public /* synthetic */ f(BLEService bLEService, a aVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0020 A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #2 {all -> 0x0041, blocks: (B:6:0x0007, B:8:0x000c, B:10:0x0019, B:11:0x001f, B:12:0x0020, B:13:0x003c), top: B:21:0x0007 }] */
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onLeScan(android.bluetooth.BluetoothDevice r10, int r11, byte[] r12) {
            /*
                r9 = this;
                if (r10 != 0) goto L3
                return
            L3:
                r0 = 0
                r1 = 0
                if (r12 == 0) goto L17
                int r2 = r12.length     // Catch: java.lang.Throwable -> L41
                r3 = 18
                if (r2 < r3) goto L17
                r0 = 2
                byte[] r0 = java.util.Arrays.copyOfRange(r12, r0, r3)     // Catch: java.lang.Throwable -> L41
                r1 = 1
                r1 = r12[r1]     // Catch: java.lang.Throwable -> L41
                r5 = r0
                r3 = r1
                goto L19
            L17:
                r5 = r0
                r3 = 0
            L19:
                pt.card4b.backendbeacons.BLEService r12 = pt.card4b.backendbeacons.BLEService.this     // Catch: java.lang.Throwable -> L41
                java.lang.Object r12 = pt.card4b.backendbeacons.BLEService.p(r12)     // Catch: java.lang.Throwable -> L41
                monitor-enter(r12)     // Catch: java.lang.Throwable -> L41
                pt.card4b.backendbeacons.BLEService r0 = pt.card4b.backendbeacons.BLEService.this     // Catch: java.lang.Throwable -> L3e
                java.util.concurrent.ConcurrentHashMap r6 = pt.card4b.backendbeacons.BLEService.q(r0)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r7 = r10.getAddress()     // Catch: java.lang.Throwable -> L3e
                h.a.a.f r8 = new h.a.a.f     // Catch: java.lang.Throwable -> L3e
                java.lang.String r1 = r10.getAddress()     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = r10.getName()     // Catch: java.lang.Throwable -> L3e
                r0 = r8
                r4 = r11
                r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3e
                r6.put(r7, r8)     // Catch: java.lang.Throwable -> L3e
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L3e
                goto L60
            L3e:
                r10 = move-exception
                monitor-exit(r12)     // Catch: java.lang.Throwable -> L3e
                throw r10     // Catch: java.lang.Throwable -> L41
            L41:
                r10 = move-exception
                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                r11.<init>()
                java.lang.String r12 = "Exception: "
                r11.append(r12)
                java.lang.String r10 = android.util.Log.getStackTraceString(r10)
                r11.append(r10)
                java.lang.String r10 = r11.toString()
                java.lang.String r11 = "COMM_BLUETOOTH"
                java.lang.String r12 = "BLEService"
                java.lang.String r0 = "onLeScan"
                h.a.a.c.a(r11, r12, r0, r10)
            L60:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: pt.card4b.backendbeacons.BLEService.f.onLeScan(android.bluetooth.BluetoothDevice, int, byte[]):void");
        }

        public f() {
        }
    }

    public BLEService() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f7648c = new b();
        } else {
            this.f7647b = new f(this, null);
        }
        this.f7649d = new ConcurrentHashMap<>();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.j = new u(timeUnit.toMillis(3L), timeUnit.toMillis(0L));
        this.k = new u(timeUnit.toMillis(5L), timeUnit.toMillis(30L));
        try {
            this.x = new r();
        } catch (Throwable th) {
            this.x = null;
            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "BLEService", "Failed to create location tracker instance." + Log.getStackTraceString(th));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f7646a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f7650e = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        HandlerThread handlerThread = new HandlerThread("BeaconServiceThread", 10);
        this.f7651f = handlerThread;
        handlerThread.start();
        this.f7652g = new Handler(this.f7651f.getLooper());
        this.B = 0L;
        this.z = false;
        if (((PowerManager) getSystemService("power")).isInteractive()) {
            this.z = false;
            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onCreate", "BLE service start - The screen is ON");
        } else {
            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onCreate", "BLE service start - The screen is OFF");
            if (Build.MANUFACTURER.equalsIgnoreCase("Huawei") && Build.VERSION.SDK_INT >= 24) {
                this.z = true;
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onCreate", "Activate scanning restrictions with screen off");
            }
            this.B = w.d().h();
        }
        if (Build.VERSION.SDK_INT >= 27 && Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
            this.o = true;
            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "onCreate", "Device is Samsung 8.1+. Force the use of scan filters");
        } else {
            this.o = false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        App.getContext().registerReceiver(this.D, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f7650e != null) {
            i();
        }
        c();
        this.f7651f.quit();
        b();
        App.getContext().unregisterReceiver(this.D);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1 A[Catch: all -> 0x0127, TryCatch #1 {Exception -> 0x012a, blocks: (B:2:0x0000, B:3:0x0002, B:4:0x0003, B:6:0x0007, B:7:0x0026, B:9:0x002a, B:48:0x0122, B:10:0x0037, B:11:0x003c, B:14:0x0043, B:16:0x004b, B:18:0x0058, B:20:0x005e, B:22:0x0067, B:27:0x0070, B:29:0x0093, B:31:0x0097, B:34:0x009c, B:36:0x00b3, B:38:0x00c1, B:40:0x00c8, B:42:0x00cc, B:43:0x00eb, B:46:0x0105, B:47:0x0110, B:35:0x00a8, B:28:0x007d, B:44:0x00fb, B:52:0x0126), top: B:60:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g() {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pt.card4b.backendbeacons.BLEService.g():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            synchronized (this.y) {
                this.f7653h = false;
                c();
                if (Build.VERSION.SDK_INT >= 21) {
                    BluetoothAdapter bluetoothAdapter = this.f7650e;
                    if (bluetoothAdapter != null && bluetoothAdapter.getBluetoothLeScanner() != null) {
                        this.f7650e.getBluetoothLeScanner().stopScan(this.f7648c);
                    }
                } else {
                    this.f7650e.stopLeScan(this.f7647b);
                }
            }
        } catch (Exception e2) {
            h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "stopScanning", "BluetoothAdapter throws unexpected exception");
            e2.printStackTrace();
        }
    }

    public void f() {
        a();
        t.a(this.f7650e, "Bluetooth adapter cannot be null");
        PowerManager powerManager = (PowerManager) getSystemService("power");
        synchronized (this.q) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "beacons:BLEServiceWLock");
            this.p = newWakeLock;
            newWakeLock.acquire();
        }
        this.v = true;
        g();
    }

    public void h() {
        a();
        i();
        synchronized (this.C) {
            this.f7649d.clear();
        }
        b();
    }

    private void c() {
        Runnable runnable = this.F;
        if (runnable != null) {
            this.f7652g.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.E;
        if (runnable2 != null) {
            this.f7652g.removeCallbacks(runnable2);
        }
    }

    private long d() {
        if (this.z) {
            return Long.MAX_VALUE;
        }
        return this.j.f6861a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long e() {
        return this.j.f6862b;
    }

    private void b() {
        synchronized (this.q) {
            PowerManager.WakeLock wakeLock = this.p;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.p.release();
            }
        }
    }

    private void a(DataModels.Error error) {
        if (this.f7654i != null) {
            Message obtain = Message.obtain((Handler) null, 111);
            obtain.obj = error;
            try {
                this.f7654i.send(obtain);
            } catch (RemoteException e2) {
                h.a.a.c.a("COMM_BLUETOOTH", "BLEService", "sendError", "Error while reporting message, funny right?");
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        t.a(Looper.getMainLooper().getThread() != Thread.currentThread(), "This cannot be run on UI thread, starting BLE scan can be expensive");
        t.a(Boolean.valueOf(this.f7651f.getLooper() == Looper.myLooper()), "It must be executed on service's handlerThread");
    }
}
