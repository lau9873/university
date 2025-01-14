package g.a.a.n.r;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
/* compiled from: CycledLeScannerForJellyBeanMr2.java */
@TargetApi(18)
/* loaded from: classes.dex */
public class d extends g.a.a.n.r.b {
    public BluetoothAdapter.LeScanCallback z;

    /* compiled from: CycledLeScannerForJellyBeanMr2.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a((Boolean) true);
        }
    }

    /* compiled from: CycledLeScannerForJellyBeanMr2.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BluetoothAdapter f6198a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BluetoothAdapter.LeScanCallback f6199b;

        public b(d dVar, BluetoothAdapter bluetoothAdapter, BluetoothAdapter.LeScanCallback leScanCallback) {
            this.f6198a = bluetoothAdapter;
            this.f6199b = leScanCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6198a.startLeScan(this.f6199b);
            } catch (Exception e2) {
                g.a.a.m.d.a(e2, "CycledLeScannerForJellyBeanMr2", "Internal Android exception in startLeScan()", new Object[0]);
            }
        }
    }

    /* compiled from: CycledLeScannerForJellyBeanMr2.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BluetoothAdapter f6200a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BluetoothAdapter.LeScanCallback f6201b;

        public c(d dVar, BluetoothAdapter bluetoothAdapter, BluetoothAdapter.LeScanCallback leScanCallback) {
            this.f6200a = bluetoothAdapter;
            this.f6201b = leScanCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6200a.stopLeScan(this.f6201b);
            } catch (Exception e2) {
                g.a.a.m.d.a(e2, "CycledLeScannerForJellyBeanMr2", "Internal Android exception in stopLeScan()", new Object[0]);
            }
        }
    }

    /* compiled from: CycledLeScannerForJellyBeanMr2.java */
    /* renamed from: g.a.a.n.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0125d implements BluetoothAdapter.LeScanCallback {
        public C0125d() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            g.a.a.m.d.a("CycledLeScannerForJellyBeanMr2", "got record", new Object[0]);
            d.this.u.onLeScan(bluetoothDevice, i2, bArr);
            d dVar = d.this;
            g.a.b.b bVar = dVar.t;
            if (bVar != null) {
                bVar.a(bluetoothDevice, dVar.t());
            }
        }
    }

    public d(Context context, long j, long j2, boolean z, g.a.a.n.r.a aVar, g.a.b.b bVar) {
        super(context, j, j2, z, aVar, bVar);
    }

    @Override // g.a.a.n.r.b
    public boolean e() {
        long elapsedRealtime = this.f6188d - SystemClock.elapsedRealtime();
        if (elapsedRealtime > 0) {
            g.a.a.m.d.a("CycledLeScannerForJellyBeanMr2", "Waiting to start next Bluetooth scan for another %s milliseconds", Long.valueOf(elapsedRealtime));
            if (this.v) {
                o();
            }
            Handler handler = this.q;
            a aVar = new a();
            if (elapsedRealtime > 1000) {
                elapsedRealtime = 1000;
            }
            handler.postDelayed(aVar, elapsedRealtime);
            return true;
        }
        return false;
    }

    @Override // g.a.a.n.r.b
    public void g() {
        v();
        this.f6193i = true;
    }

    @Override // g.a.a.n.r.b
    public void q() {
        u();
    }

    @Override // g.a.a.n.r.b
    public void s() {
        v();
    }

    public final BluetoothAdapter.LeScanCallback t() {
        if (this.z == null) {
            this.z = new C0125d();
        }
        return this.z;
    }

    public final void u() {
        BluetoothAdapter i2 = i();
        if (i2 == null) {
            return;
        }
        BluetoothAdapter.LeScanCallback t = t();
        this.r.removeCallbacksAndMessages(null);
        this.r.post(new b(this, i2, t));
    }

    public final void v() {
        BluetoothAdapter i2 = i();
        if (i2 == null) {
            return;
        }
        BluetoothAdapter.LeScanCallback t = t();
        this.r.removeCallbacksAndMessages(null);
        this.r.post(new c(this, i2, t));
    }
}
