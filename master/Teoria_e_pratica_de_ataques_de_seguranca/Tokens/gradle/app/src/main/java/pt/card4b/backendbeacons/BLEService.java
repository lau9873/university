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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import p205h.p206a.p207a.AppLog;
import p205h.p206a.p207a.BLEDevice;
import p205h.p206a.p207a.C2222t;
import p205h.p206a.p207a.Consuela;
import p205h.p206a.p207a.DiscoveryResult;
import p205h.p206a.p207a.LocationTracker;
import p205h.p206a.p207a.ScanPeriodData;
import p205h.p206a.p207a.SysDateManager;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* loaded from: classes.dex */
public class BLEService extends Service {

    /* renamed from: b */
    public BluetoothAdapter.LeScanCallback f10662b;

    /* renamed from: c */
    public ScanCallback f10663c;

    /* renamed from: d */
    public final ConcurrentHashMap<String, BLEDevice> f10664d;

    /* renamed from: e */
    public BluetoothAdapter f10665e;

    /* renamed from: f */
    public HandlerThread f10666f;

    /* renamed from: g */
    public Handler f10667g;

    /* renamed from: h */
    public boolean f10668h;

    /* renamed from: i */
    public Messenger f10669i;

    /* renamed from: j */
    public ScanPeriodData f10670j;

    /* renamed from: k */
    public ScanPeriodData f10671k;

    /* renamed from: p */
    public PowerManager.WakeLock f10676p;

    /* renamed from: r */
    public Messenger f10678r;

    /* renamed from: x */
    public LocationTracker f10684x;

    /* renamed from: l */
    public int f10672l = 2;

    /* renamed from: m */
    public boolean f10673m = false;

    /* renamed from: n */
    public boolean f10674n = false;

    /* renamed from: o */
    public boolean f10675o = false;

    /* renamed from: q */
    public Object f10677q = new Object();

    /* renamed from: s */
    public final ParcelUuid f10679s = ParcelUuid.fromString("0000feaa-0000-1000-8000-00805f9b34fb");

    /* renamed from: t */
    public final byte[] f10680t = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: u */
    public final byte[] f10681u = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: v */
    public boolean f10682v = true;

    /* renamed from: w */
    public boolean f10683w = false;

    /* renamed from: y */
    public Object f10685y = new Object();

    /* renamed from: z */
    public boolean f10686z = false;

    /* renamed from: A */
    public long f10655A = 0;

    /* renamed from: B */
    public long f10656B = 0;

    /* renamed from: C */
    public Object f10657C = new Object();

    /* renamed from: D */
    public BroadcastReceiver f10658D = new C2665a();

    /* renamed from: E */
    public Runnable f10659E = new RunnableC2667c();

    /* renamed from: F */
    public Runnable f10660F = new RunnableC2668d();

    /* renamed from: a */
    public final Messenger f10661a = new Messenger(new HandlerC2670e(this, null));

    /* renamed from: pt.card4b.backendbeacons.BLEService$a */
    /* loaded from: classes.dex */
    public class C2665a extends BroadcastReceiver {
        public C2665a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.SCREEN_ON")) {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "screenStateReceiver", "Device screen ON detected");
                BLEService.this.f10686z = false;
                BLEService.this.f10656B = 0L;
            } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "screenStateReceiver", "Device screen OFF detected");
                if (!BLEService.this.f10686z && Build.MANUFACTURER.equalsIgnoreCase("Huawei") && Build.VERSION.SDK_INT >= 24) {
                    AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "screenStateReceiver", "Activate scanning restrictions with screen off");
                    BLEService.this.f10686z = true;
                }
                if (BLEService.this.f10656B == 0) {
                    BLEService.this.f10656B = SysDateManager.m1497d().m1493h();
                }
            }
        }
    }

    /* renamed from: pt.card4b.backendbeacons.BLEService$b */
    /* loaded from: classes.dex */
    public class C2666b extends ScanCallback {
        public C2666b() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            try {
                synchronized (BLEService.this.f10657C) {
                    byte[] bArr = null;
                    byte b = 0;
                    for (ScanResult scanResult : list) {
                        if (!BLEService.this.f10664d.containsKey(scanResult.getDevice().getAddress())) {
                            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onBatchScanResults", "BLE scan result found: " + scanResult.getDevice().getAddress());
                            if (scanResult.getScanRecord().getServiceData(BLEService.this.f10679s) != null && scanResult.getScanRecord().getServiceData(BLEService.this.f10679s).length >= 18) {
                                bArr = Arrays.copyOfRange(scanResult.getScanRecord().getServiceData(BLEService.this.f10679s), 2, 18);
                                b = scanResult.getScanRecord().getServiceData(BLEService.this.f10679s)[1];
                            }
                            BLEService.this.f10664d.put(scanResult.getDevice().getAddress(), new BLEDevice(scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b, scanResult.getRssi(), bArr));
                        }
                    }
                }
            } catch (Throwable th) {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onBatchScanResults", "Exception: " + Log.getStackTraceString(th));
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            try {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onScanFailed", "BLE scan callback reported a failure with error " + i);
                if (BLEService.this.f10682v) {
                    BLEService.this.f10682v = false;
                    AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onScanFailed", "Try to solve disabling the use of hardware callback types");
                }
                BLEService.this.f10683w = true;
            } catch (Throwable th) {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onScanFailed", "Exception: " + Log.getStackTraceString(th));
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            byte[] bArr;
            byte b;
            try {
                synchronized (BLEService.this.f10657C) {
                    if (!BLEService.this.f10664d.containsKey(scanResult.getDevice().getAddress())) {
                        AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onScanResult", "BLE scan result found: " + scanResult.getDevice().getAddress());
                        if (scanResult.getScanRecord().getServiceData(BLEService.this.f10679s) == null || scanResult.getScanRecord().getServiceData(BLEService.this.f10679s).length < 18) {
                            bArr = null;
                            b = 0;
                        } else {
                            bArr = Arrays.copyOfRange(scanResult.getScanRecord().getServiceData(BLEService.this.f10679s), 2, 18);
                            b = scanResult.getScanRecord().getServiceData(BLEService.this.f10679s)[1];
                        }
                        BLEService.this.f10664d.put(scanResult.getDevice().getAddress(), new BLEDevice(scanResult.getDevice().getAddress(), scanResult.getDevice().getName(), b, scanResult.getRssi(), bArr));
                    }
                }
            } catch (Throwable th) {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onScanResult", "Exception: " + Log.getStackTraceString(th));
            }
        }
    }

    /* renamed from: pt.card4b.backendbeacons.BLEService$c */
    /* loaded from: classes.dex */
    public class RunnableC2667c implements Runnable {
        public RunnableC2667c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BLEService.this.m355g();
        }
    }

    /* renamed from: pt.card4b.backendbeacons.BLEService$d */
    /* loaded from: classes.dex */
    public class RunnableC2668d implements Runnable {

        /* renamed from: pt.card4b.backendbeacons.BLEService$d$a */
        /* loaded from: classes.dex */
        public class C2669a implements BackendListeners.InterfaceC2675c {

            /* renamed from: a */
            public final /* synthetic */ long f10691a;

            /* renamed from: b */
            public final /* synthetic */ long f10692b;

            /* renamed from: c */
            public final /* synthetic */ HashMap f10693c;

            public C2669a(long j, long j2, HashMap hashMap) {
                this.f10691a = j;
                this.f10692b = j2;
                this.f10693c = hashMap;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2675c
            /* renamed from: a */
            public void mo337a(Location location) {
                try {
                    Message obtain = Message.obtain((Handler) null, 888);
                    obtain.obj = new DiscoveryResult(this.f10691a, this.f10692b, this.f10693c.values(), location != null ? location.getLatitude() : 0.0d, location != null ? location.getLongitude() : 0.0d, location != null ? location.getAccuracy() : 0.0d);
                    BLEService.this.f10678r.send(obtain);
                } catch (Throwable th) {
                    AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "AfterScanCycleTask", "Error while delivering responses: " + Log.getStackTraceString(th));
                }
            }
        }

        public RunnableC2668d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BLEService.this.m379a();
                long m1493h = SysDateManager.m1497d().m1493h();
                long m1494g = SysDateManager.m1497d().m1494g();
                if (BLEService.this.f10656B != 0 && m1493h - BLEService.this.f10656B > 1500000) {
                    Consuela.m1790k().m1767z();
                }
                if (!BLEService.this.f10686z || m1493h - BLEService.this.f10655A > 1800000) {
                    BLEService.this.m351i();
                }
                HashMap hashMap = new HashMap();
                synchronized (BLEService.this.f10657C) {
                    if (BLEService.this.f10664d.size() > 0) {
                        hashMap.putAll(BLEService.this.f10664d);
                    }
                    BLEService.this.f10664d.clear();
                }
                AppLog.m2158a("LOGIC_BEACONS", "BLEService", "processDiscovery", String.format("After scan task. found %d devices:", Integer.valueOf(hashMap.size())));
                if (hashMap.size() > 0) {
                    if (BLEService.this.f10673m && BLEService.this.f10684x != null) {
                        BLEService.this.f10684x.m1575a(new C2669a(m1493h, m1494g, hashMap));
                    } else {
                        Message obtain = Message.obtain((Handler) null, 888);
                        obtain.obj = new DiscoveryResult(m1493h, m1494g, hashMap.values(), 0.0d, 0.0d, 0.0d);
                        BLEService.this.f10678r.send(obtain);
                    }
                }
            } catch (Throwable th) {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "afterScanRunnable", "Exception: " + Log.getStackTraceString(th));
            }
            if (BLEService.this.m360e() == 0) {
                BLEService.this.f10667g.post(BLEService.this.f10659E);
            } else {
                BLEService.this.f10667g.postDelayed(BLEService.this.f10659E, BLEService.this.m360e());
            }
        }
    }

    /* renamed from: pt.card4b.backendbeacons.BLEService$e */
    /* loaded from: classes.dex */
    public class HandlerC2670e extends Handler {

        /* renamed from: pt.card4b.backendbeacons.BLEService$e$a */
        /* loaded from: classes.dex */
        public class RunnableC2671a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f10696a;

            /* renamed from: b */
            public final /* synthetic */ Messenger f10697b;

            /* renamed from: c */
            public final /* synthetic */ Object f10698c;

            public RunnableC2671a(int i, Messenger messenger, Object obj) {
                this.f10696a = i;
                this.f10697b = messenger;
                this.f10698c = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.f10696a;
                if (i == 7) {
                    BLEService.this.f10669i = this.f10697b;
                } else if (i == 666) {
                    BLEService.this.f10678r = this.f10697b;
                    AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "StartDiscovery");
                    BLEService.this.m357f();
                } else if (i != 777) {
                    switch (i) {
                        case 9:
                            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "Setting foreground scan period: " + BLEService.this.f10670j);
                            BLEService.this.f10670j = (ScanPeriodData) this.f10698c;
                            return;
                        case 10:
                            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "Setting background scan period: " + BLEService.this.f10671k);
                            BLEService.this.f10671k = (ScanPeriodData) this.f10698c;
                            return;
                        case 11:
                            BLEService.this.f10672l = ((Integer) this.f10698c).intValue();
                            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", String.format("Bluetooth ScanMode set to %d", Integer.valueOf(BLEService.this.f10672l)));
                            return;
                        case 12:
                            BLEService.this.f10673m = ((Boolean) this.f10698c).booleanValue();
                            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", String.format("Add location info set to %s", Boolean.valueOf(BLEService.this.f10673m)));
                            return;
                        case 13:
                            BLEService.this.f10674n = ((Boolean) this.f10698c).booleanValue();
                            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", String.format("Add use scan filters set to %s", Boolean.valueOf(BLEService.this.f10674n)));
                            return;
                        default:
                            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "Unknown message: what=" + this.f10696a + " obj=" + this.f10698c);
                            return;
                    }
                } else {
                    AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "IncomingHandler", "StopDiscovery");
                    BLEService.this.m353h();
                }
            }
        }

        public /* synthetic */ HandlerC2670e(BLEService bLEService, C2665a c2665a) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            Object obj = message.obj;
            BLEService.this.f10667g.post(new RunnableC2671a(i, message.replyTo, obj));
        }

        public HandlerC2670e() {
        }
    }

    /* renamed from: pt.card4b.backendbeacons.BLEService$f */
    /* loaded from: classes.dex */
    public class C2672f implements BluetoothAdapter.LeScanCallback {
        public /* synthetic */ C2672f(BLEService bLEService, C2665a c2665a) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0020 A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #2 {all -> 0x0041, blocks: (B:6:0x0007, B:8:0x000c, B:10:0x0019, B:11:0x001f, B:12:0x0020, B:13:0x003c), top: B:21:0x0007 }] */
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
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
                java.lang.Object r12 = pt.card4b.backendbeacons.BLEService.m343p(r12)     // Catch: java.lang.Throwable -> L41
                monitor-enter(r12)     // Catch: java.lang.Throwable -> L41
                pt.card4b.backendbeacons.BLEService r0 = pt.card4b.backendbeacons.BLEService.this     // Catch: java.lang.Throwable -> L3e
                java.util.concurrent.ConcurrentHashMap r6 = pt.card4b.backendbeacons.BLEService.m342q(r0)     // Catch: java.lang.Throwable -> L3e
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
                p205h.p206a.p207a.AppLog.m2158a(r11, r12, r0, r10)
            L60:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: pt.card4b.backendbeacons.BLEService.C2672f.onLeScan(android.bluetooth.BluetoothDevice, int, byte[]):void");
        }

        public C2672f() {
        }
    }

    public BLEService() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f10663c = new C2666b();
        } else {
            this.f10662b = new C2672f(this, null);
        }
        this.f10664d = new ConcurrentHashMap<>();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f10670j = new ScanPeriodData(timeUnit.toMillis(3L), timeUnit.toMillis(0L));
        this.f10671k = new ScanPeriodData(timeUnit.toMillis(5L), timeUnit.toMillis(30L));
        try {
            this.f10684x = new LocationTracker();
        } catch (Throwable th) {
            this.f10684x = null;
            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "BLEService", "Failed to create location tracker instance." + Log.getStackTraceString(th));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f10661a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f10665e = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        HandlerThread handlerThread = new HandlerThread("BeaconServiceThread", 10);
        this.f10666f = handlerThread;
        handlerThread.start();
        this.f10667g = new Handler(this.f10666f.getLooper());
        this.f10656B = 0L;
        this.f10686z = false;
        if (((PowerManager) getSystemService("power")).isInteractive()) {
            this.f10686z = false;
            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onCreate", "BLE service start - The screen is ON");
        } else {
            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onCreate", "BLE service start - The screen is OFF");
            if (Build.MANUFACTURER.equalsIgnoreCase("Huawei") && Build.VERSION.SDK_INT >= 24) {
                this.f10686z = true;
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onCreate", "Activate scanning restrictions with screen off");
            }
            this.f10656B = SysDateManager.m1497d().m1493h();
        }
        if (Build.VERSION.SDK_INT >= 27 && Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
            this.f10675o = true;
            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "onCreate", "Device is Samsung 8.1+. Force the use of scan filters");
        } else {
            this.f10675o = false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        App.getContext().registerReceiver(this.f10658D, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f10665e != null) {
            m351i();
        }
        m366c();
        this.f10666f.quit();
        m371b();
        App.getContext().unregisterReceiver(this.f10658D);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1 A[Catch: all -> 0x0127, TryCatch #1 {Exception -> 0x012a, blocks: (B:2:0x0000, B:3:0x0002, B:4:0x0003, B:6:0x0007, B:7:0x0026, B:9:0x002a, B:48:0x0122, B:10:0x0037, B:11:0x003c, B:14:0x0043, B:16:0x004b, B:18:0x0058, B:20:0x005e, B:22:0x0067, B:27:0x0070, B:29:0x0093, B:31:0x0097, B:34:0x009c, B:36:0x00b3, B:38:0x00c1, B:40:0x00c8, B:42:0x00cc, B:43:0x00eb, B:46:0x0105, B:47:0x0110, B:35:0x00a8, B:28:0x007d, B:44:0x00fb, B:52:0x0126), top: B:60:0x0000 }] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m355g() {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: pt.card4b.backendbeacons.BLEService.m355g():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m351i() {
        try {
            synchronized (this.f10685y) {
                this.f10668h = false;
                m366c();
                if (Build.VERSION.SDK_INT >= 21) {
                    BluetoothAdapter bluetoothAdapter = this.f10665e;
                    if (bluetoothAdapter != null && bluetoothAdapter.getBluetoothLeScanner() != null) {
                        this.f10665e.getBluetoothLeScanner().stopScan(this.f10663c);
                    }
                } else {
                    this.f10665e.stopLeScan(this.f10662b);
                }
            }
        } catch (Exception e) {
            AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "stopScanning", "BluetoothAdapter throws unexpected exception");
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public void m357f() {
        m379a();
        C2222t.m1568a(this.f10665e, "Bluetooth adapter cannot be null");
        PowerManager powerManager = (PowerManager) getSystemService("power");
        synchronized (this.f10677q) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "beacons:BLEServiceWLock");
            this.f10676p = newWakeLock;
            newWakeLock.acquire();
        }
        this.f10682v = true;
        m355g();
    }

    /* renamed from: h */
    public void m353h() {
        m379a();
        m351i();
        synchronized (this.f10657C) {
            this.f10664d.clear();
        }
        m371b();
    }

    /* renamed from: c */
    private void m366c() {
        Runnable runnable = this.f10660F;
        if (runnable != null) {
            this.f10667g.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f10659E;
        if (runnable2 != null) {
            this.f10667g.removeCallbacks(runnable2);
        }
    }

    /* renamed from: d */
    private long m363d() {
        if (this.f10686z) {
            return Long.MAX_VALUE;
        }
        return this.f10670j.f9416a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public long m360e() {
        return this.f10670j.f9417b;
    }

    /* renamed from: b */
    private void m371b() {
        synchronized (this.f10677q) {
            PowerManager.WakeLock wakeLock = this.f10676p;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.f10676p.release();
            }
        }
    }

    /* renamed from: a */
    private void m372a(DataModels.Error error) {
        if (this.f10669i != null) {
            Message obtain = Message.obtain((Handler) null, 111);
            obtain.obj = error;
            try {
                this.f10669i.send(obtain);
            } catch (RemoteException e) {
                AppLog.m2158a("COMM_BLUETOOTH", "BLEService", "sendError", "Error while reporting message, funny right?");
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m379a() {
        C2222t.m1567a(Looper.getMainLooper().getThread() != Thread.currentThread(), "This cannot be run on UI thread, starting BLE scan can be expensive");
        C2222t.m1568a(Boolean.valueOf(this.f10666f.getLooper() == Looper.myLooper()), "It must be executed on service's handlerThread");
    }
}
