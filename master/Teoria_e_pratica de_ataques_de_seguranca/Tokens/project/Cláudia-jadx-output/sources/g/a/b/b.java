package g.a.b;

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
/* compiled from: BluetoothCrashResolver.java */
/* loaded from: classes.dex */
public class b {
    public Context j;
    public InterfaceC0126b k;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6219a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6220b = false;

    /* renamed from: c  reason: collision with root package name */
    public long f6221c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f6222d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f6223e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f6224f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f6225g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6226h = false;

    /* renamed from: i  reason: collision with root package name */
    public long f6227i = 0;
    public final Set<String> l = new HashSet();
    public final BroadcastReceiver m = new a();

    /* compiled from: BluetoothCrashResolver.java */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                if (b.this.f6219a) {
                    g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth discovery finished", new Object[0]);
                    b.this.c();
                } else {
                    g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth discovery finished (external)", new Object[0]);
                }
            }
            if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                if (b.this.f6219a) {
                    b.this.f6220b = true;
                    g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth discovery started", new Object[0]);
                } else {
                    g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth discovery started (external)", new Object[0]);
                }
            }
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                if (intExtra != Integer.MIN_VALUE) {
                    switch (intExtra) {
                        case 10:
                            g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth state is OFF", new Object[0]);
                            b.this.f6221c = SystemClock.elapsedRealtime();
                            return;
                        case 11:
                            b.this.f6222d = SystemClock.elapsedRealtime();
                            g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth state is TURNING_ON", new Object[0]);
                            return;
                        case 12:
                            g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth state is ON", new Object[0]);
                            g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth was turned off for %s milliseconds", Long.valueOf(b.this.f6222d - b.this.f6221c));
                            if (b.this.f6222d - b.this.f6221c < 600) {
                                b.this.b();
                                return;
                            }
                            return;
                        case 13:
                        default:
                            return;
                    }
                }
                g.a.a.m.d.a("BluetoothCrashResolver", "Bluetooth state is ERROR", new Object[0]);
            }
        }
    }

    /* compiled from: BluetoothCrashResolver.java */
    /* renamed from: g.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0126b {
        void a();
    }

    public b(Context context) {
        this.j = null;
        this.j = context.getApplicationContext();
        g.a.a.m.d.a("BluetoothCrashResolver", "constructed", new Object[0]);
        f();
    }

    public final int d() {
        return 1590;
    }

    public boolean e() {
        return this.f6219a;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r8 = this;
            java.lang.String r0 = "BluetoothCrashResolver"
            java.lang.String r1 = "BluetoothCrashResolverState.txt"
            r2 = 0
            r3 = 1
            r4 = 0
            android.content.Context r5 = r8.j     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            java.io.FileInputStream r5 = r5.openFileInput(r1)     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L63 java.lang.NumberFormatException -> L66 java.io.IOException -> L75
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L23
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            r8.f6223e = r4     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
        L23:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L2f
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            r8.f6224f = r4     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
        L2f:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L3b
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            r8.f6225g = r4     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
        L3b:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L4d
            r8.f6226h = r2     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            java.lang.String r5 = "1"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L4d
            r8.f6226h = r3     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
        L4d:
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
            if (r4 == 0) goto L59
            java.util.Set<java.lang.String> r5 = r8.l     // Catch: java.lang.Throwable -> L5d java.lang.NumberFormatException -> L5f java.io.IOException -> L61
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
            g.a.a.m.d.d(r0, r5, r6)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L81
        L71:
            r4.close()     // Catch: java.io.IOException -> L81
            goto L81
        L75:
            java.lang.String r5 = "Can't read macs from %s"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L63
            r6[r2] = r1     // Catch: java.lang.Throwable -> L63
            g.a.a.m.d.d(r0, r5, r6)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L81
            goto L71
        L81:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.util.Set<java.lang.String> r3 = r8.l
            int r3 = r3.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "Read %s Bluetooth addresses"
            g.a.a.m.d.a(r0, r2, r1)
            return
        L95:
            if (r6 == 0) goto L9a
            r6.close()     // Catch: java.io.IOException -> L9a
        L9a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.b.b.f():void");
    }

    public final void g() {
        InterfaceC0126b interfaceC0126b = this.k;
        if (interfaceC0126b != null) {
            interfaceC0126b.a();
        }
        if (SystemClock.elapsedRealtime() - this.f6227i > 60000) {
            h();
        }
    }

    public final void h() {
        OutputStreamWriter outputStreamWriter;
        this.f6227i = SystemClock.elapsedRealtime();
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                try {
                    outputStreamWriter = new OutputStreamWriter(this.j.openFileOutput("BluetoothCrashResolverState.txt", 0));
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th) {
            th = th;
            outputStreamWriter = outputStreamWriter2;
        }
        try {
            outputStreamWriter.write(this.f6223e + "\n");
            outputStreamWriter.write(this.f6224f + "\n");
            outputStreamWriter.write(this.f6225g + "\n");
            outputStreamWriter.write(this.f6226h ? "1\n" : "0\n");
            synchronized (this.l) {
                for (String str : this.l) {
                    outputStreamWriter.write(str);
                    outputStreamWriter.write("\n");
                }
            }
            outputStreamWriter.close();
        } catch (IOException unused3) {
            outputStreamWriter2 = outputStreamWriter;
            g.a.a.m.d.d("BluetoothCrashResolver", "Can't write macs to %s", "BluetoothCrashResolverState.txt");
            if (outputStreamWriter2 != null) {
                outputStreamWriter2.close();
            }
            g.a.a.m.d.a("BluetoothCrashResolver", "Wrote %s Bluetooth addresses", Integer.valueOf(this.l.size()));
        } catch (Throwable th2) {
            th = th2;
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
        g.a.a.m.d.a("BluetoothCrashResolver", "Wrote %s Bluetooth addresses", Integer.valueOf(this.l.size()));
    }

    public void i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        this.j.registerReceiver(this.m, intentFilter);
        g.a.a.m.d.a("BluetoothCrashResolver", "started listening for BluetoothAdapter events", new Object[0]);
    }

    @TargetApi(17)
    public final void j() {
        this.f6225g++;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        g.a.a.m.d.a("BluetoothCrashResolver", "about to check if discovery is active", new Object[0]);
        if (!defaultAdapter.isDiscovering()) {
            g.a.a.m.d.d("BluetoothCrashResolver", "Recovery attempt started", new Object[0]);
            this.f6219a = true;
            this.f6220b = false;
            g.a.a.m.d.a("BluetoothCrashResolver", "about to command discovery", new Object[0]);
            if (!defaultAdapter.startDiscovery()) {
                g.a.a.m.d.d("BluetoothCrashResolver", "Can't start discovery.  Is Bluetooth turned on?", new Object[0]);
            }
            g.a.a.m.d.a("BluetoothCrashResolver", "startDiscovery commanded.  isDiscovering()=%s", Boolean.valueOf(defaultAdapter.isDiscovering()));
            g.a.a.m.d.a("BluetoothCrashResolver", "We will be cancelling this discovery in %s milliseconds.", 5000);
            a();
            return;
        }
        g.a.a.m.d.d("BluetoothCrashResolver", "Already discovering.  Recovery attempt abandoned.", new Object[0]);
    }

    public void k() {
        this.j.unregisterReceiver(this.m);
        g.a.a.m.d.a("BluetoothCrashResolver", "stopped listening for BluetoothAdapter events", new Object[0]);
        h();
    }

    public final void c() {
        g.a.a.m.d.d("BluetoothCrashResolver", "Recovery attempt finished", new Object[0]);
        synchronized (this.l) {
            this.l.clear();
        }
        this.f6219a = false;
    }

    public void b() {
        if (Build.VERSION.SDK_INT < 18) {
            g.a.a.m.d.a("BluetoothCrashResolver", "Ignoring crashes before API 18, because BLE is unsupported.", new Object[0]);
            return;
        }
        g.a.a.m.d.d("BluetoothCrashResolver", "BluetoothService crash detected", new Object[0]);
        if (this.l.size() > 0) {
            g.a.a.m.d.a("BluetoothCrashResolver", "Distinct Bluetooth devices seen at crash: %s", Integer.valueOf(this.l.size()));
        }
        this.f6223e = SystemClock.elapsedRealtime();
        this.f6224f++;
        if (this.f6219a) {
            g.a.a.m.d.a("BluetoothCrashResolver", "Ignoring Bluetooth crash because recovery is already in progress.", new Object[0]);
        } else {
            j();
        }
        g();
    }

    @TargetApi(18)
    public void a(BluetoothDevice bluetoothDevice, BluetoothAdapter.LeScanCallback leScanCallback) {
        int size = this.l.size();
        synchronized (this.l) {
            this.l.add(bluetoothDevice.getAddress());
        }
        int size2 = this.l.size();
        if (size != size2 && size2 % 100 == 0) {
            g.a.a.m.d.a("BluetoothCrashResolver", "Distinct Bluetooth devices seen: %s", Integer.valueOf(this.l.size()));
        }
        if (this.l.size() <= d() || this.f6219a) {
            return;
        }
        g.a.a.m.d.d("BluetoothCrashResolver", "Large number of Bluetooth devices detected: %s Proactively attempting to clear out address list to prevent a crash", Integer.valueOf(this.l.size()));
        g.a.a.m.d.d("BluetoothCrashResolver", "Stopping LE Scan", new Object[0]);
        BluetoothAdapter.getDefaultAdapter().stopLeScan(leScanCallback);
        j();
        g();
    }

    public final void a() {
        try {
            Thread.sleep(5000L);
            if (!this.f6220b) {
                g.a.a.m.d.d("BluetoothCrashResolver", "BluetoothAdapter.ACTION_DISCOVERY_STARTED never received.  Recovery may fail.", new Object[0]);
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter.isDiscovering()) {
                g.a.a.m.d.a("BluetoothCrashResolver", "Cancelling discovery", new Object[0]);
                defaultAdapter.cancelDiscovery();
                return;
            }
            g.a.a.m.d.a("BluetoothCrashResolver", "Discovery not running.  Won't cancel it", new Object[0]);
        } catch (InterruptedException unused) {
            g.a.a.m.d.a("BluetoothCrashResolver", "DiscoveryCanceller sleep interrupted.", new Object[0]);
        }
    }
}
