package g.a.b;

import a.b.g.a.y;
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
/* compiled from: BluetoothMedic.java */
/* loaded from: classes.dex */
public class c {
    public static final String j = "c";
    public static c k;

    /* renamed from: a  reason: collision with root package name */
    public BluetoothAdapter f6229a;

    /* renamed from: b  reason: collision with root package name */
    public a.b.g.b.d f6230b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f6231c = new Handler();

    /* renamed from: d  reason: collision with root package name */
    public Boolean f6232d = null;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f6233e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6234f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f6235g = 0;

    /* renamed from: h  reason: collision with root package name */
    public long f6236h = 0;

    /* renamed from: i  reason: collision with root package name */
    public BroadcastReceiver f6237i = new a();

    /* compiled from: BluetoothMedic.java */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            g.a.a.m.d.a(c.j, "Broadcast notification received.", new Object[0]);
            String action = intent.getAction();
            if (action != null) {
                if (action.equalsIgnoreCase("onScanFailed")) {
                    if (intent.getIntExtra("errorCode", -1) == 2) {
                        c.this.a(context, "scan failed", "Power cycling bluetooth");
                        g.a.a.m.d.a(c.j, "Detected a SCAN_FAILED_APPLICATION_REGISTRATION_FAILED.  We need to cycle bluetooth to recover", new Object[0]);
                        if (c.this.b()) {
                            return;
                        }
                        c.this.a(context, "scan failed", "Cannot power cycle bluetooth again");
                    }
                } else if (!action.equalsIgnoreCase("onStartFailed")) {
                    g.a.a.m.d.a(c.j, "Unknown event.", new Object[0]);
                } else if (intent.getIntExtra("errorCode", -1) == 4) {
                    c.this.a(context, "advertising failed", "Expected failure.  Power cycling.");
                    if (c.this.b()) {
                        return;
                    }
                    c.this.a(context, "advertising failed", "Cannot power cycle bluetooth again");
                }
            }
        }
    }

    /* compiled from: BluetoothMedic.java */
    /* loaded from: classes.dex */
    public class b extends ScanCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BluetoothLeScanner f6239a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f6240b;

        public b(BluetoothLeScanner bluetoothLeScanner, Context context) {
            this.f6239a = bluetoothLeScanner;
            this.f6240b = context;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i2) {
            super.onScanFailed(i2);
            String str = c.j;
            g.a.a.m.d.a(str, "Sending onScanFailed broadcast with " + c.this.f6230b, new Object[0]);
            Intent intent = new Intent("onScanFailed");
            intent.putExtra("errorCode", i2);
            if (c.this.f6230b != null) {
                c.this.f6230b.a(intent);
            }
            String str2 = c.j;
            g.a.a.m.d.a(str2, "broadcast: " + intent + " should be received by " + c.this.f6237i, new Object[0]);
            if (i2 == 2) {
                g.a.a.m.d.d(c.j, "Scan test failed in a way we consider a failure", new Object[0]);
                c.this.a(this.f6240b, "scan failed", "bluetooth not ok");
                c.this.f6233e = false;
                return;
            }
            g.a.a.m.d.c(c.j, "Scan test failed in a way we do not consider a failure", new Object[0]);
            c.this.f6233e = true;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i2, ScanResult scanResult) {
            super.onScanResult(i2, scanResult);
            c.this.f6233e = true;
            g.a.a.m.d.c(c.j, "Scan test succeeded", new Object[0]);
            try {
                this.f6239a.stopScan(this);
            } catch (IllegalStateException unused) {
            }
        }
    }

    /* compiled from: BluetoothMedic.java */
    /* renamed from: g.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0127c extends AdvertiseCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BluetoothLeAdvertiser f6242a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f6243b;

        public C0127c(BluetoothLeAdvertiser bluetoothLeAdvertiser, Context context) {
            this.f6242a = bluetoothLeAdvertiser;
            this.f6243b = context;
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartFailure(int i2) {
            super.onStartFailure(i2);
            Intent intent = new Intent("onStartFailed");
            intent.putExtra("errorCode", i2);
            String str = c.j;
            g.a.a.m.d.a(str, "Sending onStartFailure broadcast with " + c.this.f6230b, new Object[0]);
            if (c.this.f6230b != null) {
                c.this.f6230b.a(intent);
            }
            if (i2 == 4) {
                c.this.f6232d = false;
                g.a.a.m.d.d(c.j, "Transmitter test failed in a way we consider a test failure", new Object[0]);
                c.this.a(this.f6243b, "transmitter failed", "bluetooth not ok");
                return;
            }
            c.this.f6232d = true;
            g.a.a.m.d.c(c.j, "Transmitter test failed, but not in a way we consider a test failure", new Object[0]);
        }

        @Override // android.bluetooth.le.AdvertiseCallback
        public void onStartSuccess(AdvertiseSettings advertiseSettings) {
            super.onStartSuccess(advertiseSettings);
            g.a.a.m.d.c(c.j, "Transmitter test succeeded", new Object[0]);
            this.f6242a.stopAdvertising(this);
            c.this.f6232d = true;
        }
    }

    /* compiled from: BluetoothMedic.java */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.a.a.m.d.a(c.j, "Turning Bluetooth back on.", new Object[0]);
            if (c.this.f6229a != null) {
                c.this.f6229a.enable();
            }
        }
    }

    public static c d() {
        if (k == null) {
            k = new c();
        }
        return k;
    }

    public boolean b(Context context) {
        a(context);
        this.f6233e = null;
        g.a.a.m.d.c(j, "Starting scan test", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        BluetoothAdapter bluetoothAdapter = this.f6229a;
        if (bluetoothAdapter != null) {
            BluetoothLeScanner bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
            b bVar = new b(bluetoothLeScanner, context);
            if (bluetoothLeScanner != null) {
                try {
                    bluetoothLeScanner.startScan(bVar);
                    while (true) {
                        if (this.f6233e != null) {
                            break;
                        }
                        g.a.a.m.d.a(j, "Waiting for scan test to complete...", new Object[0]);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException unused) {
                        }
                        if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                            g.a.a.m.d.a(j, "Timeout running scan test", new Object[0]);
                            break;
                        }
                    }
                    bluetoothLeScanner.stopScan(bVar);
                } catch (IllegalStateException unused2) {
                    g.a.a.m.d.a(j, "Bluetooth is off.  Cannot run scan test.", new Object[0]);
                } catch (NullPointerException e2) {
                    g.a.a.m.d.b(j, "NullPointerException. Cannot run scan test.", e2);
                }
            } else {
                g.a.a.m.d.a(j, "Cannot get scanner", new Object[0]);
            }
        }
        g.a.a.m.d.a(j, "scan test complete", new Object[0]);
        Boolean bool = this.f6233e;
        return bool == null || bool.booleanValue();
    }

    public boolean c(Context context) {
        a(context);
        this.f6232d = null;
        long currentTimeMillis = System.currentTimeMillis();
        BluetoothAdapter bluetoothAdapter = this.f6229a;
        if (bluetoothAdapter != null) {
            BluetoothLeAdvertiser a2 = a(bluetoothAdapter);
            if (a2 != null) {
                AdvertiseSettings build = new AdvertiseSettings.Builder().setAdvertiseMode(0).build();
                AdvertiseData build2 = new AdvertiseData.Builder().addManufacturerData(0, new byte[]{0}).build();
                g.a.a.m.d.c(j, "Starting transmitter test", new Object[0]);
                a2.startAdvertising(build, build2, new C0127c(a2, context));
            } else {
                g.a.a.m.d.a(j, "Cannot get advertiser", new Object[0]);
            }
            while (true) {
                if (this.f6232d != null) {
                    break;
                }
                g.a.a.m.d.a(j, "Waiting for transmitter test to complete...", new Object[0]);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                if (System.currentTimeMillis() - currentTimeMillis > 5000) {
                    g.a.a.m.d.a(j, "Timeout running transmitter test", new Object[0]);
                    break;
                }
            }
        }
        g.a.a.m.d.a(j, "transmitter test complete", new Object[0]);
        Boolean bool = this.f6232d;
        return bool != null && bool.booleanValue();
    }

    public final void a(Context context) {
        if (this.f6229a == null || this.f6230b == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
            if (bluetoothManager != null) {
                this.f6229a = bluetoothManager.getAdapter();
                this.f6230b = a.b.g.b.d.a(context);
                return;
            }
            throw new NullPointerException("Cannot get BluetoothManager");
        }
    }

    public final void a() {
        g.a.a.m.d.a(j, "Power cycling bluetooth", new Object[0]);
        g.a.a.m.d.a(j, "Turning Bluetooth off.", new Object[0]);
        BluetoothAdapter bluetoothAdapter = this.f6229a;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.disable();
            this.f6231c.postDelayed(new d(), 1000L);
            return;
        }
        g.a.a.m.d.d(j, "Cannot cycle bluetooth.  Manager is null.", new Object[0]);
    }

    public final void a(Context context, String str, String str2) {
        a(context);
        if (this.f6234f) {
            y.c cVar = new y.c(context, "err");
            cVar.b((CharSequence) ("BluetoothMedic: " + str));
            cVar.c(this.f6235g);
            cVar.a(new long[]{200, 100, 200});
            cVar.a((CharSequence) str2);
            TaskStackBuilder create = TaskStackBuilder.create(context);
            create.addNextIntent(new Intent("NoOperation"));
            cVar.a(create.getPendingIntent(0, 134217728));
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(1, cVar.a());
            }
        }
    }

    public final boolean b() {
        long currentTimeMillis = System.currentTimeMillis() - this.f6236h;
        if (currentTimeMillis < 60000) {
            String str = j;
            g.a.a.m.d.a(str, "Not cycling bluetooth because we just did so " + currentTimeMillis + " milliseconds ago.", new Object[0]);
            return false;
        }
        this.f6236h = System.currentTimeMillis();
        g.a.a.m.d.a(j, "Power cycling bluetooth", new Object[0]);
        a();
        return true;
    }

    public final BluetoothLeAdvertiser a(BluetoothAdapter bluetoothAdapter) {
        try {
            return bluetoothAdapter.getBluetoothLeAdvertiser();
        } catch (Exception e2) {
            g.a.a.m.d.d(j, "Cannot get bluetoothLeAdvertiser", e2);
            return null;
        }
    }
}
