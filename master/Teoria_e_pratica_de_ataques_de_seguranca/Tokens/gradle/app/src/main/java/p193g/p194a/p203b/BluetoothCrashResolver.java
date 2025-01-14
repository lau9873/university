package p193g.p194a.p203b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import p193g.p194a.p195a.p198m.LogManager;

/* renamed from: g.a.b.b */
/* loaded from: classes.dex */
public class BluetoothCrashResolver {

    /* renamed from: j */
    public Context f8719j;

    /* renamed from: k */
    public InterfaceC1858b f8720k;

    /* renamed from: a */
    public boolean f8710a = false;

    /* renamed from: b */
    public boolean f8711b = false;

    /* renamed from: c */
    public long f8712c = 0;

    /* renamed from: d */
    public long f8713d = 0;

    /* renamed from: e */
    public long f8714e = 0;

    /* renamed from: f */
    public int f8715f = 0;

    /* renamed from: g */
    public int f8716g = 0;

    /* renamed from: h */
    public boolean f8717h = false;

    /* renamed from: i */
    public long f8718i = 0;

    /* renamed from: l */
    public final Set<String> f8721l = new HashSet();

    /* renamed from: m */
    public final BroadcastReceiver f8722m = new C1857a();

    /* compiled from: BluetoothCrashResolver.java */
    /* renamed from: g.a.b.b$a */
    /* loaded from: classes.dex */
    public class C1857a extends BroadcastReceiver {
        public C1857a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                if (BluetoothCrashResolver.this.f8710a) {
                    LogManager.m2432a("BluetoothCrashResolver", "Bluetooth discovery finished", new Object[0]);
                    BluetoothCrashResolver.this.m2223c();
                } else {
                    LogManager.m2432a("BluetoothCrashResolver", "Bluetooth discovery finished (external)", new Object[0]);
                }
            }
            if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                if (BluetoothCrashResolver.this.f8710a) {
                    BluetoothCrashResolver.this.f8711b = true;
                    LogManager.m2432a("BluetoothCrashResolver", "Bluetooth discovery started", new Object[0]);
                } else {
                    LogManager.m2432a("BluetoothCrashResolver", "Bluetooth discovery started (external)", new Object[0]);
                }
            }
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                if (intExtra != Integer.MIN_VALUE) {
                    switch (intExtra) {
                        case 10:
                            LogManager.m2432a("BluetoothCrashResolver", "Bluetooth state is OFF", new Object[0]);
                            BluetoothCrashResolver.this.f8712c = SystemClock.elapsedRealtime();
                            return;
                        case 11:
                            BluetoothCrashResolver.this.f8713d = SystemClock.elapsedRealtime();
                            LogManager.m2432a("BluetoothCrashResolver", "Bluetooth state is TURNING_ON", new Object[0]);
                            return;
                        case 12:
                            LogManager.m2432a("BluetoothCrashResolver", "Bluetooth state is ON", new Object[0]);
                            LogManager.m2432a("BluetoothCrashResolver", "Bluetooth was turned off for %s milliseconds", Long.valueOf(BluetoothCrashResolver.this.f8713d - BluetoothCrashResolver.this.f8712c));
                            if (BluetoothCrashResolver.this.f8713d - BluetoothCrashResolver.this.f8712c < 600) {
                                BluetoothCrashResolver.this.m2226b();
                                return;
                            }
                            return;
                        case 13:
                        default:
                            return;
                    }
                }
                LogManager.m2432a("BluetoothCrashResolver", "Bluetooth state is ERROR", new Object[0]);
            }
        }
    }

    /* compiled from: BluetoothCrashResolver.java */
    /* renamed from: g.a.b.b$b */
    /* loaded from: classes.dex */
    public interface InterfaceC1858b {
        /* renamed from: a */
        void m2212a();
    }

    public BluetoothCrashResolver(Context context) {
        this.f8719j = null;
        this.f8719j = context.getApplicationContext();
        LogManager.m2432a("BluetoothCrashResolver", "constructed", new Object[0]);
        m2218f();
    }

    /* renamed from: d */
    public final int m2221d() {
        return 1590;
    }

    /* renamed from: e */
    public boolean m2219e() {
        return this.f8710a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
        if (r4 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
        r4.close();
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
        if (r4 == null) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2218f() {
        /*
            r8 = this;
            java.lang.String r0 = "BluetoothCrashResolver"
            java.lang.String r1 = "BluetoothCrashResolverState.txt"
            r2 = 0
            r3 = 1
            r4 = 0
            android.content.Context r5 = r8.f8719j     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            java.io.FileInputStream r5 = r5.openFileInput(r1)     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L23
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            r8.f8714e = r4     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
        L23:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L2f
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            r8.f8715f = r4     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
        L2f:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L3b
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            r8.f8716g = r4     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
        L3b:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L4d
            r8.f8717h = r2     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            java.lang.String r5 = "1"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L4d
            r8.f8717h = r3     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
        L4d:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L59
            java.util.Set<java.lang.String> r5 = r8.f8721l     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            r5.add(r4)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            goto L4d
        L59:
            r6.close()     // Catch: java.io.IOException -> L81
            goto L81
        L5d:
            r0 = move-exception
            goto L95
        L5f:
            r4 = r6
            goto L66
        L61:
            r4 = r6
            goto L75
        L63:
            r0 = move-exception
            r6 = r4
            goto L95
        L66:
            java.lang.String r5 = "Can't parse file %s"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L63
            r6[r2] = r1     // Catch: java.lang.Throwable -> L63
            p193g.p194a.p195a.p198m.LogManager.m2427d(r0, r5, r6)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L81
        L71:
            r4.close()     // Catch: java.io.IOException -> L81
            goto L81
        L75:
            java.lang.String r5 = "Can't read macs from %s"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L63
            r6[r2] = r1     // Catch: java.lang.Throwable -> L63
            p193g.p194a.p195a.p198m.LogManager.m2427d(r0, r5, r6)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L81
            goto L71
        L81:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.util.Set<java.lang.String> r3 = r8.f8721l
            int r3 = r3.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "Read %s Bluetooth addresses"
            p193g.p194a.p195a.p198m.LogManager.m2432a(r0, r2, r1)
            return
        L95:
            if (r6 == 0) goto L9a
            r6.close()     // Catch: java.io.IOException -> L9a
        L9a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p193g.p194a.p203b.BluetoothCrashResolver.m2218f():void");
    }

    /* renamed from: g */
    public final void m2217g() {
        InterfaceC1858b interfaceC1858b = this.f8720k;
        if (interfaceC1858b != null) {
            interfaceC1858b.m2212a();
        }
        if (SystemClock.elapsedRealtime() - this.f8718i > 60000) {
            m2216h();
        }
    }

    /* renamed from: h */
    public final void m2216h() {
        OutputStreamWriter outputStreamWriter;
        this.f8718i = SystemClock.elapsedRealtime();
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                try {
                    outputStreamWriter = new OutputStreamWriter(this.f8719j.openFileOutput("BluetoothCrashResolverState.txt", 0));
                    try {
                        outputStreamWriter.write(this.f8714e + "\n");
                        outputStreamWriter.write(this.f8715f + "\n");
                        outputStreamWriter.write(this.f8716g + "\n");
                        outputStreamWriter.write(this.f8717h ? "1\n" : "0\n");
                        synchronized (this.f8721l) {
                            for (String str : this.f8721l) {
                                outputStreamWriter.write(str);
                                outputStreamWriter.write("\n");
                            }
                        }
                        outputStreamWriter.close();
                    } catch (IOException unused) {
                        outputStreamWriter2 = outputStreamWriter;
                        LogManager.m2427d("BluetoothCrashResolver", "Can't write macs to %s", "BluetoothCrashResolverState.txt");
                        if (outputStreamWriter2 != null) {
                            outputStreamWriter2.close();
                        }
                        LogManager.m2432a("BluetoothCrashResolver", "Wrote %s Bluetooth addresses", Integer.valueOf(this.f8721l.size()));
                    } catch (Throwable th) {
                        th = th;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStreamWriter = outputStreamWriter2;
                }
            } catch (IOException unused3) {
            }
        } catch (IOException unused4) {
        }
        LogManager.m2432a("BluetoothCrashResolver", "Wrote %s Bluetooth addresses", Integer.valueOf(this.f8721l.size()));
    }

    /* renamed from: i */
    public void m2215i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        this.f8719j.registerReceiver(this.f8722m, intentFilter);
        LogManager.m2432a("BluetoothCrashResolver", "started listening for BluetoothAdapter events", new Object[0]);
    }

    @TargetApi(17)
    /* renamed from: j */
    public final void m2214j() {
        this.f8716g++;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        LogManager.m2432a("BluetoothCrashResolver", "about to check if discovery is active", new Object[0]);
        if (!defaultAdapter.isDiscovering()) {
            LogManager.m2427d("BluetoothCrashResolver", "Recovery attempt started", new Object[0]);
            this.f8710a = true;
            this.f8711b = false;
            LogManager.m2432a("BluetoothCrashResolver", "about to command discovery", new Object[0]);
            if (!defaultAdapter.startDiscovery()) {
                LogManager.m2427d("BluetoothCrashResolver", "Can't start discovery.  Is Bluetooth turned on?", new Object[0]);
            }
            LogManager.m2432a("BluetoothCrashResolver", "startDiscovery commanded.  isDiscovering()=%s", Boolean.valueOf(defaultAdapter.isDiscovering()));
            LogManager.m2432a("BluetoothCrashResolver", "We will be cancelling this discovery in %s milliseconds.", 5000);
            m2231a();
            return;
        }
        LogManager.m2427d("BluetoothCrashResolver", "Already discovering.  Recovery attempt abandoned.", new Object[0]);
    }

    /* renamed from: k */
    public void m2213k() {
        this.f8719j.unregisterReceiver(this.f8722m);
        LogManager.m2432a("BluetoothCrashResolver", "stopped listening for BluetoothAdapter events", new Object[0]);
        m2216h();
    }

    /* renamed from: c */
    public final void m2223c() {
        LogManager.m2427d("BluetoothCrashResolver", "Recovery attempt finished", new Object[0]);
        synchronized (this.f8721l) {
            this.f8721l.clear();
        }
        this.f8710a = false;
    }

    /* renamed from: b */
    public void m2226b() {
        if (Build.VERSION.SDK_INT < 18) {
            LogManager.m2432a("BluetoothCrashResolver", "Ignoring crashes before API 18, because BLE is unsupported.", new Object[0]);
            return;
        }
        LogManager.m2427d("BluetoothCrashResolver", "BluetoothService crash detected", new Object[0]);
        if (this.f8721l.size() > 0) {
            LogManager.m2432a("BluetoothCrashResolver", "Distinct Bluetooth devices seen at crash: %s", Integer.valueOf(this.f8721l.size()));
        }
        this.f8714e = SystemClock.elapsedRealtime();
        this.f8715f++;
        if (this.f8710a) {
            LogManager.m2432a("BluetoothCrashResolver", "Ignoring Bluetooth crash because recovery is already in progress.", new Object[0]);
        } else {
            m2214j();
        }
        m2217g();
    }

    @TargetApi(18)
    /* renamed from: a */
    public void m2230a(BluetoothDevice bluetoothDevice, BluetoothAdapter.LeScanCallback leScanCallback) {
        int size = this.f8721l.size();
        synchronized (this.f8721l) {
            this.f8721l.add(bluetoothDevice.getAddress());
        }
        int size2 = this.f8721l.size();
        if (size != size2 && size2 % 100 == 0) {
            LogManager.m2432a("BluetoothCrashResolver", "Distinct Bluetooth devices seen: %s", Integer.valueOf(this.f8721l.size()));
        }
        if (this.f8721l.size() <= m2221d() || this.f8710a) {
            return;
        }
        LogManager.m2427d("BluetoothCrashResolver", "Large number of Bluetooth devices detected: %s Proactively attempting to clear out address list to prevent a crash", Integer.valueOf(this.f8721l.size()));
        LogManager.m2427d("BluetoothCrashResolver", "Stopping LE Scan", new Object[0]);
        BluetoothAdapter.getDefaultAdapter().stopLeScan(leScanCallback);
        m2214j();
        m2217g();
    }

    /* renamed from: a */
    public final void m2231a() {
        try {
            Thread.sleep(5000L);
            if (!this.f8711b) {
                LogManager.m2427d("BluetoothCrashResolver", "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.", new Object[0]);
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter.isDiscovering()) {
                LogManager.m2432a("BluetoothCrashResolver", "Cancelling discovery", new Object[0]);
                defaultAdapter.cancelDiscovery();
                return;
            }
            LogManager.m2432a("BluetoothCrashResolver", "Discovery not running.  Won't cancel it", new Object[0]);
        } catch (InterruptedException unused) {
            LogManager.m2432a("BluetoothCrashResolver", "DiscoveryCanceller sleep interrupted.", new Object[0]);
        }
    }
}
