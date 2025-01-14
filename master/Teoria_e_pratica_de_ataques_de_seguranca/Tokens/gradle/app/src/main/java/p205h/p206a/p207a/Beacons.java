package p205h.p206a.p207a;

import android.os.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p205h.p206a.p207a.BLEAltBeaconManager;
import p205h.p206a.p207a.BLEManager;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.a.a.k */
/* loaded from: classes.dex */
public class Beacons {

    /* renamed from: f */
    public static short f9050f = 1;

    /* renamed from: g */
    public static short f9051g = 2;

    /* renamed from: a */
    public BLEManager f9052a = null;

    /* renamed from: b */
    public BLEAltBeaconManager f9053b = null;

    /* renamed from: c */
    public short f9054c = 2;

    /* renamed from: d */
    public short f9055d;

    /* renamed from: e */
    public InterfaceC2010d f9056e;

    /* compiled from: Beacons.java */
    /* renamed from: h.a.a.k$a */
    /* loaded from: classes.dex */
    public class C2007a implements BLEManager.InterfaceC1898b {
        public C2007a() {
        }

        @Override // p205h.p206a.p207a.BLEManager.InterfaceC1898b
        /* renamed from: a */
        public void mo1875a(long j, long j2, List<BLEDevice> list, double d, double d2, double d3) {
            Beacons.this.m1886a(j, j2, list, d, d2, d3);
        }

        @Override // p205h.p206a.p207a.BLEManager.InterfaceC1898b
        public void onError(DataModels.Error error) {
            Beacons.this.f9056e.onError(error);
        }
    }

    /* compiled from: Beacons.java */
    /* renamed from: h.a.a.k$b */
    /* loaded from: classes.dex */
    public class C2008b implements BLEAltBeaconManager.InterfaceC1896d {
        public C2008b() {
        }

        @Override // p205h.p206a.p207a.BLEAltBeaconManager.InterfaceC1896d
        /* renamed from: a */
        public void mo1874a(long j, long j2, List<BLEDevice> list, double d, double d2, double d3) {
            Beacons.this.m1886a(j, j2, list, d, d2, d3);
        }
    }

    /* compiled from: Beacons.java */
    /* renamed from: h.a.a.k$c */
    /* loaded from: classes.dex */
    public class C2009c implements BLEManager.InterfaceC1901e {

        /* renamed from: a */
        public final /* synthetic */ int f9059a;

        /* renamed from: b */
        public final /* synthetic */ long f9060b;

        /* renamed from: c */
        public final /* synthetic */ long f9061c;

        /* renamed from: d */
        public final /* synthetic */ boolean f9062d;

        /* renamed from: e */
        public final /* synthetic */ boolean f9063e;

        public C2009c(int i, long j, long j2, boolean z, boolean z2) {
            this.f9059a = i;
            this.f9060b = j;
            this.f9061c = j2;
            this.f9062d = z;
            this.f9063e = z2;
        }

        @Override // p205h.p206a.p207a.BLEManager.InterfaceC1901e
        /* renamed from: a */
        public void mo1873a() {
            try {
                Beacons.this.f9052a.m2112a(this.f9059a);
                BLEManager bLEManager = Beacons.this.f9052a;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                bLEManager.m2111a(timeUnit.toMillis(this.f9060b), timeUnit.toMillis(this.f9061c));
                Beacons.this.f9052a.m2103a(this.f9062d);
                Beacons.this.f9052a.m2099b(this.f9063e);
                Beacons.this.f9052a.m2090g();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Beacons.java */
    /* renamed from: h.a.a.k$d */
    /* loaded from: classes.dex */
    public interface InterfaceC2010d {
        /* renamed from: a */
        void mo1872a(DataModels.C2693c c2693c);

        void onError(DataModels.Error error);
    }

    public Beacons(short s) {
        short s2 = f9050f;
        this.f9055d = s2;
        this.f9055d = s;
        if (s == s2) {
            m1881b();
        } else if (s == f9051g) {
            m1888a();
        }
    }

    /* renamed from: c */
    private void m1878c() {
        BLEAltBeaconManager bLEAltBeaconManager = this.f9053b;
        if (bLEAltBeaconManager != null) {
            try {
                bLEAltBeaconManager.m2123c();
                this.f9053b.m2133a();
                this.f9053b = null;
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    private void m1877d() {
        BLEManager bLEManager = this.f9052a;
        if (bLEManager != null) {
            bLEManager.m2088h();
            this.f9052a.m2102b();
            this.f9052a = null;
        }
    }

    /* renamed from: e */
    public void m1876e() {
        BLEAltBeaconManager bLEAltBeaconManager;
        AppLog.m2158a("LOGIC_BEACONS", "Beacons", "stopBeaconService", "enteredMethod");
        short s = this.f9055d;
        if (s == f9050f) {
            BLEManager bLEManager = this.f9052a;
            if (bLEManager != null) {
                bLEManager.m2088h();
                this.f9052a.m2102b();
            }
        } else if (s != f9051g || (bLEAltBeaconManager = this.f9053b) == null) {
        } else {
            bLEAltBeaconManager.m2123c();
            this.f9053b.m2133a();
        }
    }

    /* renamed from: b */
    private void m1881b() {
        BLEManager bLEManager = new BLEManager(App.getInstance(), false);
        this.f9052a = bLEManager;
        bLEManager.m2110a(new C2007a());
    }

    /* renamed from: a */
    private void m1888a() {
        BLEAltBeaconManager bLEAltBeaconManager = new BLEAltBeaconManager(App.getInstance());
        this.f9053b = bLEAltBeaconManager;
        bLEAltBeaconManager.m2131a(new C2008b());
    }

    /* renamed from: b */
    private DataModels.C2693c m1880b(int i, byte[] bArr, long j, long j2, String str, String str2, int i2, double d, double d2, double d3) {
        int i3 = 0;
        int i4 = bArr[0] & 255;
        int i5 = bArr[1] & 255;
        int i6 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        int i7 = bArr[4] & 255;
        int i8 = bArr[5] & 255;
        int i9 = bArr[6] & 255;
        int i10 = bArr[7] & 255;
        int i11 = ((bArr[8] & 255) * 256) + (bArr[9] & 255);
        int i12 = bArr[10] & 255;
        int i13 = (bArr[11] >> 4) & 15;
        int i14 = bArr[11] & 15;
        if (i13 >= 2) {
            Map<String, DataModels.C2708q> m1773t = Consuela.m1790k().m1773t();
            DataModels.C2708q c2708q = m1773t.get(i11 + "|" + i5);
            if (c2708q != null) {
                i3 = c2708q.m112d();
            }
        } else {
            i3 = i11;
        }
        DataModels.C2693c c2693c = new DataModels.C2693c(i5 + "|" + i6 + "|" + i8 + "|" + i9 + "|" + i10 + "|" + i3 + "|" + i12, str2, str, i2, i, j, j2, false, 0L, d, d2, d3, 0L, null, 0L);
        c2693c.m223a(i4, i5, i6, i7, i8, i9, i10, i3, i12, i13, i14);
        return c2693c;
    }

    /* renamed from: a */
    public short m1882a(short s) {
        this.f9055d = s;
        return s;
    }

    /* renamed from: a */
    public void m1885a(InterfaceC2010d interfaceC2010d, int i, long j, long j2, short s, boolean z, boolean z2) {
        this.f9056e = interfaceC2010d;
        if (s > 0) {
            this.f9054c = s;
        }
        if (!App.getInstance().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            interfaceC2010d.onError(DataModels.Error.bleNotSupported());
            AppLog.m2158a("LOGIC_BEACONS", "Beacons", "startBeaconService", DataModels.Error.bleNotSupported().getType().toString());
        } else if (this.f9055d == f9051g) {
            m1877d();
            if (this.f9053b == null) {
                m1888a();
            }
            BLEAltBeaconManager bLEAltBeaconManager = this.f9053b;
            if (bLEAltBeaconManager != null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                bLEAltBeaconManager.m2125b(timeUnit.toMillis(j), timeUnit.toMillis(j2));
                this.f9053b.m2127a(z);
                this.f9053b.m2126b();
            }
        } else {
            m1878c();
            if (this.f9052a == null) {
                m1881b();
            }
            BLEManager bLEManager = this.f9052a;
            if (bLEManager != null) {
                bLEManager.m2109a(new C2009c(i, j, j2, z, z2));
            }
        }
    }

    /* renamed from: a */
    private DataModels.C2693c m1887a(int i, byte[] bArr, long j, long j2, String str, String str2, int i2, double d, double d2, double d3) {
        int i3 = bArr[0] & 255;
        int i4 = bArr[1] & 255;
        int i5 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        int i6 = bArr[4] & 255;
        int i7 = bArr[5] & 255;
        int i8 = bArr[10] & 255;
        byte b = bArr[11];
        int i9 = ((bArr[12] & 255) * 256) + (bArr[13] & 255);
        int i10 = bArr[14] & 255;
        int i11 = bArr[15] & 255;
        DataModels.C2693c c2693c = new DataModels.C2693c(i4 + "|" + i5 + "|" + i7 + "|" + i8 + "|" + ((int) b) + "|" + i9 + "|" + i10, str2, str, i2, i, j, j2, false, 0L, d, d2, d3, 0L, null, 0L);
        c2693c.m223a(i3, i4, i5, i6, i7, i8, b, i9, i10, 0, i11);
        return c2693c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0165  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m1886a(long r29, long r31, java.util.List<p205h.p206a.p207a.BLEDevice> r33, double r34, double r36, double r38) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p205h.p206a.p207a.Beacons.m1886a(long, long, java.util.List, double, double, double):void");
    }
}
