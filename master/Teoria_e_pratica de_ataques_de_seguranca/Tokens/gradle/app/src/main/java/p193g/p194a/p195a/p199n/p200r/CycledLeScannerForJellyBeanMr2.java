package p193g.p194a.p195a.p199n.p200r;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import p193g.p194a.p195a.p198m.LogManager;
import p193g.p194a.p203b.BluetoothCrashResolver;

@TargetApi(18)
/* renamed from: g.a.a.n.r.d */
/* loaded from: classes.dex */
public class CycledLeScannerForJellyBeanMr2 extends CycledLeScanner {

    /* renamed from: z */
    public BluetoothAdapter.LeScanCallback f8680z;

    /* compiled from: CycledLeScannerForJellyBeanMr2.java */
    /* renamed from: g.a.a.n.r.d$a */
    /* loaded from: classes.dex */
    public class RunnableC1848a implements Runnable {
        public RunnableC1848a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CycledLeScannerForJellyBeanMr2.this.m2276a((Boolean) true);
        }
    }

    /* compiled from: CycledLeScannerForJellyBeanMr2.java */
    /* renamed from: g.a.a.n.r.d$b */
    /* loaded from: classes.dex */
    public class RunnableC1849b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ BluetoothAdapter f8682a;

        /* renamed from: b */
        public final /* synthetic */ BluetoothAdapter.LeScanCallback f8683b;

        public RunnableC1849b(CycledLeScannerForJellyBeanMr2 cycledLeScannerForJellyBeanMr2, BluetoothAdapter bluetoothAdapter, BluetoothAdapter.LeScanCallback leScanCallback) {
            this.f8682a = bluetoothAdapter;
            this.f8683b = leScanCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8682a.startLeScan(this.f8683b);
            } catch (Exception e) {
                LogManager.m2431a(e, "CycledLeScannerForJellyBeanMr2", "Internal Android exception in startLeScan()", new Object[0]);
            }
        }
    }

    /* compiled from: CycledLeScannerForJellyBeanMr2.java */
    /* renamed from: g.a.a.n.r.d$c */
    /* loaded from: classes.dex */
    public class RunnableC1850c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ BluetoothAdapter f8684a;

        /* renamed from: b */
        public final /* synthetic */ BluetoothAdapter.LeScanCallback f8685b;

        public RunnableC1850c(CycledLeScannerForJellyBeanMr2 cycledLeScannerForJellyBeanMr2, BluetoothAdapter bluetoothAdapter, BluetoothAdapter.LeScanCallback leScanCallback) {
            this.f8684a = bluetoothAdapter;
            this.f8685b = leScanCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8684a.stopLeScan(this.f8685b);
            } catch (Exception e) {
                LogManager.m2431a(e, "CycledLeScannerForJellyBeanMr2", "Internal Android exception in stopLeScan()", new Object[0]);
            }
        }
    }

    /* compiled from: CycledLeScannerForJellyBeanMr2.java */
    /* renamed from: g.a.a.n.r.d$d */
    /* loaded from: classes.dex */
    public class C1851d implements BluetoothAdapter.LeScanCallback {
        public C1851d() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            LogManager.m2432a("CycledLeScannerForJellyBeanMr2", "got record", new Object[0]);
            CycledLeScannerForJellyBeanMr2.this.f8672u.onLeScan(bluetoothDevice, i, bArr);
            CycledLeScannerForJellyBeanMr2 cycledLeScannerForJellyBeanMr2 = CycledLeScannerForJellyBeanMr2.this;
            BluetoothCrashResolver bluetoothCrashResolver = cycledLeScannerForJellyBeanMr2.f8671t;
            if (bluetoothCrashResolver != null) {
                bluetoothCrashResolver.m2230a(bluetoothDevice, cycledLeScannerForJellyBeanMr2.m2257t());
            }
        }
    }

    public CycledLeScannerForJellyBeanMr2(Context context, long j, long j2, boolean z, CycledLeScanCallback cycledLeScanCallback, BluetoothCrashResolver bluetoothCrashResolver) {
        super(context, j, j2, z, cycledLeScanCallback, bluetoothCrashResolver);
    }

    @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanner
    /* renamed from: e */
    public boolean mo2252e() {
        long elapsedRealtime = this.f8655d - SystemClock.elapsedRealtime();
        if (elapsedRealtime > 0) {
            LogManager.m2432a("CycledLeScannerForJellyBeanMr2", "Waiting to start next Bluetooth scan for another %s milliseconds", Long.valueOf(elapsedRealtime));
            if (this.f8673v) {
                m2261o();
            }
            Handler handler = this.f8668q;
            RunnableC1848a runnableC1848a = new RunnableC1848a();
            if (elapsedRealtime > 1000) {
                elapsedRealtime = 1000;
            }
            handler.postDelayed(runnableC1848a, elapsedRealtime);
            return true;
        }
        return false;
    }

    @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanner
    /* renamed from: g */
    public void mo2251g() {
        m2255v();
        this.f8660i = true;
    }

    @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanner
    /* renamed from: q */
    public void mo2250q() {
        m2256u();
    }

    @Override // p193g.p194a.p195a.p199n.p200r.CycledLeScanner
    /* renamed from: s */
    public void mo2249s() {
        m2255v();
    }

    /* renamed from: t */
    public final BluetoothAdapter.LeScanCallback m2257t() {
        if (this.f8680z == null) {
            this.f8680z = new C1851d();
        }
        return this.f8680z;
    }

    /* renamed from: u */
    public final void m2256u() {
        BluetoothAdapter m2267i = m2267i();
        if (m2267i == null) {
            return;
        }
        BluetoothAdapter.LeScanCallback m2257t = m2257t();
        this.f8669r.removeCallbacksAndMessages(null);
        this.f8669r.post(new RunnableC1849b(this, m2267i, m2257t));
    }

    /* renamed from: v */
    public final void m2255v() {
        BluetoothAdapter m2267i = m2267i();
        if (m2267i == null) {
            return;
        }
        BluetoothAdapter.LeScanCallback m2257t = m2257t();
        this.f8669r.removeCallbacksAndMessages(null);
        this.f8669r.post(new RunnableC1850c(this, m2267i, m2257t));
    }
}
