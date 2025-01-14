package p193g.p194a.p203b;

import android.app.NotificationManager;
import android.app.TaskStackBuilder;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import java.util.List;
import p000a.p006b.p030g.p031a.NotificationCompat;
import p000a.p006b.p030g.p032b.LocalBroadcastManager;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.b.c */
/* loaded from: classes.dex */
public class BluetoothMedic {

    /* renamed from: j */
    public static final String f8724j = "c";

    /* renamed from: k */
    public static BluetoothMedic f8725k;

    /* renamed from: a */
    public BluetoothAdapter f8726a;

    /* renamed from: b */
    public LocalBroadcastManager f8727b;

    /* renamed from: c */
    public Handler f8728c = new Handler();

    /* renamed from: d */
    public Boolean f8729d = null;

    /* renamed from: e */
    public Boolean f8730e = null;

    /* renamed from: f */
    public boolean f8731f = false;

    /* renamed from: g */
    public int f8732g = 0;

    /* renamed from: h */
    public long f8733h = 0;

    /* renamed from: i */
    public BroadcastReceiver f8734i = new C1859a();

    /* compiled from: BluetoothMedic.java */
    /* renamed from: g.a.b.c$a */
    /* loaded from: classes.dex */
    public class C1859a extends BroadcastReceiver {
        public C1859a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogManager.m2432a(BluetoothMedic.f8724j, "Broadcast notification received.", new Object[0]);
            String action = intent.getAction();
            if (action != null) {
                if (action.equalsIgnoreCase("onScanFailed")) {
                    if (intent.getIntExtra("errorCode", -1) == 2) {
                        BluetoothMedic.this.m2208a(context, "scan failed", "Power cycling bluetooth");
                        LogManager.m2432a(BluetoothMedic.f8724j, "Detected a SCAN_FAILED_APPLICATION_REGISTRATION_FAILED.  We need to cycle bluetooth to recover", new Object[0]);
                        if (BluetoothMedic.this.m2204b()) {
                            return;
                        }
                        BluetoothMedic.this.m2208a(context, "scan failed", "Cannot power cycle bluetooth again");
                    }
                } else if (!action.equalsIgnoreCase("onStartFailed")) {
                    LogManager.m2432a(BluetoothMedic.f8724j, "Unknown event.", new Object[0]);
                } else if (intent.getIntExtra("errorCode", -1) == 4) {
                    BluetoothMedic.this.m2208a(context, "advertising failed", "Expected failure.  Power cycling.");
                    if (BluetoothMedic.this.m2204b()) {
                        return;
                    }
                    BluetoothMedic.this.m2208a(context, "advertising failed", "Cannot power cycle bluetooth again");
                }
            }
        }
    }

    /* compiled from: BluetoothMedic.java */
    /* renamed from: g.a.b.c$b */
    /* loaded from: classes.dex */
    public class C1860b extends ScanCallback {

        /* renamed from: a */
        public final /* synthetic */ BluetoothLeScanner f8736a;

        /* renamed from: b */
        public final /* synthetic */ Context f8737b;

        public C1860b(BluetoothLeScanner bluetoothLeScanner, Context context) {
            this.f8736a = bluetoothLeScanner;
            this.f8737b = context;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i) {
            super.onScanFailed(i);
            String str = BluetoothMedic.f8724j;
            LogManager.m2432a(str, "Sending onScanFailed broadcast with " + BluetoothMedic.this.f8727b, new Object[0]);
            Intent intent = new Intent("onScanFailed");
            intent.putExtra("errorCode", i);
            if (BluetoothMedic.this.f8727b != null) {
                BluetoothMedic.this.f8727b.m10010a(intent);
            }
            String str2 = BluetoothMedic.f8724j;
            LogManager.m2432a(str2, "broadcast: " + intent + " should be received by " + BluetoothMedic.this.f8734i, new Object[0]);
            if (i == 2) {
                LogManager.m2427d(BluetoothMedic.f8724j, "Scan test failed in a way we consider a failure", new Object[0]);
                BluetoothMedic.this.m2208a(this.f8737b, "scan failed", "bluetooth not ok");
                BluetoothMedic.this.f8730e = false;
                return;
            }
            LogManager.m2428c(BluetoothMedic.f8724j, "Scan test failed in a way we do not consider a failure", new Object[0]);
            BluetoothMedic.this.f8730e = true;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            BluetoothMedic.this.f8730e = true;
            LogManager.m2428c(BluetoothMedic.f8724j, "Scan test succeeded", new Object[0]);
            try {
                this.f8736a.stopScan(this);
            } catch (IllegalStateException unused) {
            }
        }
    }

    /* compiled from: BluetoothMedic.java */
    /* renamed from: g.a.b.c$c */
    /* loaded from: classes.dex */
    public class C1861c extends AdvertiseCallback {

        /* renamed from: a */
        public final /* synthetic */ BluetoothLeAdvertiser f8739a;

        /* renamed from: b */
        public final /* synthetic */ Context f8740b;

        public C1861c(BluetoothLeAdvertiser bluetoothLeAdvertiser, Context context) {
            this.f8739a = bluetoothLeAdvertiser;
            this.f8740b = context;
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int i) {
            super.onStartFailure(i);
            Intent intent = new Intent("onStartFailed");
            intent.putExtra("errorCode", i);
            String str = BluetoothMedic.f8724j;
            LogManager.m2432a(str, "Sending onStartFailure broadcast with " + BluetoothMedic.this.f8727b, new Object[0]);
            if (BluetoothMedic.this.f8727b != null) {
                BluetoothMedic.this.f8727b.m10010a(intent);
            }
            if (i == 4) {
                BluetoothMedic.this.f8729d = false;
                LogManager.m2427d(BluetoothMedic.f8724j, "Transmitter test failed in a way we consider a test failure", new Object[0]);
                BluetoothMedic.this.m2208a(this.f8740b, "transmitter failed", "bluetooth not ok");
                return;
            }
            BluetoothMedic.this.f8729d = true;
            LogManager.m2428c(BluetoothMedic.f8724j, "Transmitter test failed, but not in a way we consider a test failure", new Object[0]);
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(AdvertiseSettings advertiseSettings) {
            super.onStartSuccess(advertiseSettings);
            LogManager.m2428c(BluetoothMedic.f8724j, "Transmitter test succeeded", new Object[0]);
            this.f8739a.stopAdvertising(this);
            BluetoothMedic.this.f8729d = true;
        }
    }

    /* compiled from: BluetoothMedic.java */
    /* renamed from: g.a.b.c$d */
    /* loaded from: classes.dex */
    public class RunnableC1862d implements Runnable {
        public RunnableC1862d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogManager.m2432a(BluetoothMedic.f8724j, "Turning Bluetooth back on.", new Object[0]);
            if (BluetoothMedic.this.f8726a != null) {
                BluetoothMedic.this.f8726a.enable();
            }
        }
    }

    /* renamed from: d */
    public static BluetoothMedic m2197d() {
        if (f8725k == null) {
            f8725k = new BluetoothMedic();
        }
        return f8725k;
    }

    /* renamed from: b */
    public boolean m2203b(Context context) {
        m2209a(context);
        this.f8730e = null;
        LogManager.m2428c(f8724j, "Starting scan test", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        BluetoothAdapter bluetoothAdapter = this.f8726a;
        if (bluetoothAdapter != null) {
            BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
            C1860b c1860b = new C1860b(bluetoothLeScanner, context);
            if (bluetoothLeScanner != null) {
                try {
                    bluetoothLeScanner.startScan(c1860b);
                    while (true) {
                        if (this.f8730e != null) {
                            break;
                        }
                        LogManager.m2432a(f8724j, "Waiting for scan test to complete...", new Object[0]);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException unused) {
                        }
                        if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                            LogManager.m2432a(f8724j, "Timeout running scan test", new Object[0]);
                            break;
                        }
                    }
                    bluetoothLeScanner.stopScan(c1860b);
                } catch (IllegalStateException unused2) {
                    LogManager.m2432a(f8724j, "Bluetooth is off.  Cannot run scan test.", new Object[0]);
                } catch (NullPointerException e) {
                    LogManager.m2430b(f8724j, "NullPointerException. Cannot run scan test.", e);
                }
            } else {
                LogManager.m2432a(f8724j, "Cannot get scanner", new Object[0]);
            }
        }
        LogManager.m2432a(f8724j, "scan test complete", new Object[0]);
        Boolean bool = this.f8730e;
        return bool == null || bool.booleanValue();
    }

    /* renamed from: c */
    public boolean m2199c(Context context) {
        m2209a(context);
        this.f8729d = null;
        long currentTimeMillis = System.currentTimeMillis();
        BluetoothAdapter bluetoothAdapter = this.f8726a;
        if (bluetoothAdapter != null) {
            BluetoothLeAdvertiser m2210a = m2210a(bluetoothAdapter);
            if (m2210a != null) {
                AdvertiseSettings build = new AdvertiseSettings.Builder().setAdvertiseMode(0).build();
                AdvertiseData build2 = new AdvertiseData.Builder().addManufacturerData(0, new byte[]{0}).build();
                LogManager.m2428c(f8724j, "Starting transmitter test", new Object[0]);
                m2210a.startAdvertising(build, build2, new C1861c(m2210a, context));
            } else {
                LogManager.m2432a(f8724j, "Cannot get advertiser", new Object[0]);
            }
            while (true) {
                if (this.f8729d != null) {
                    break;
                }
                LogManager.m2432a(f8724j, "Waiting for transmitter test to complete...", new Object[0]);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                    LogManager.m2432a(f8724j, "Timeout running transmitter test", new Object[0]);
                    break;
                }
            }
        }
        LogManager.m2432a(f8724j, "transmitter test complete", new Object[0]);
        Boolean bool = this.f8729d;
        return bool != null && bool.booleanValue();
    }

    /* renamed from: a */
    public final void m2209a(Context context) {
        if (this.f8726a == null || this.f8727b == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
            if (bluetoothManager != null) {
                this.f8726a = bluetoothManager.getAdapter();
                this.f8727b = LocalBroadcastManager.m10011a(context);
                return;
            }
            throw new NullPointerException("Cannot get BluetoothManager");
        }
    }

    /* renamed from: a */
    public final void m2211a() {
        LogManager.m2432a(f8724j, "Power cycling bluetooth", new Object[0]);
        LogManager.m2432a(f8724j, "Turning Bluetooth off.", new Object[0]);
        BluetoothAdapter bluetoothAdapter = this.f8726a;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.disable();
            this.f8728c.postDelayed(new RunnableC1862d(), 1000L);
            return;
        }
        LogManager.m2427d(f8724j, "Cannot cycle bluetooth.  Manager is null.", new Object[0]);
    }

    /* renamed from: a */
    public final void m2208a(Context context, String str, String str2) {
        m2209a(context);
        if (this.f8731f) {
            NotificationCompat.C0189c c0189c = new NotificationCompat.C0189c(context, "err");
            c0189c.m10044b((CharSequence) ("BluetoothMedic: " + str));
            c0189c.m10041c(this.f8732g);
            c0189c.m10047a(new long[]{200, 100, 200});
            c0189c.m10050a((CharSequence) str2);
            TaskStackBuilder create = TaskStackBuilder.create(context);
            create.addNextIntent(new Intent("NoOperation"));
            c0189c.m10051a(create.getPendingIntent(0, 134217728));
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(1, c0189c.m10057a());
            }
        }
    }

    /* renamed from: b */
    public final boolean m2204b() {
        long currentTimeMillis = System.currentTimeMillis() - this.f8733h;
        if (currentTimeMillis < 60000) {
            String str = f8724j;
            LogManager.m2432a(str, "Not cycling bluetooth because we just did so " + currentTimeMillis + " milliseconds ago.", new Object[0]);
            return false;
        }
        this.f8733h = System.currentTimeMillis();
        LogManager.m2432a(f8724j, "Power cycling bluetooth", new Object[0]);
        m2211a();
        return true;
    }

    /* renamed from: a */
    public final BluetoothLeAdvertiser m2210a(BluetoothAdapter bluetoothAdapter) {
        try {
            return bluetoothAdapter.getBluetoothLeAdvertiser();
        } catch (Exception e) {
            LogManager.m2427d(f8724j, "Cannot get bluetoothLeAdvertiser", e);
            return null;
        }
    }
}
