package h.a.a;

import android.os.RemoteException;
import h.a.a.e;
import h.a.a.g;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: Beacons.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static short f6522f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static short f6523g = 2;

    /* renamed from: a  reason: collision with root package name */
    public g f6524a = null;

    /* renamed from: b  reason: collision with root package name */
    public e f6525b = null;

    /* renamed from: c  reason: collision with root package name */
    public short f6526c = 2;

    /* renamed from: d  reason: collision with root package name */
    public short f6527d;

    /* renamed from: e  reason: collision with root package name */
    public d f6528e;

    /* compiled from: Beacons.java */
    /* loaded from: classes.dex */
    public class a implements g.b {
        public a() {
        }

        @Override // h.a.a.g.b
        public void a(long j, long j2, List<f> list, double d2, double d3, double d4) {
            k.this.a(j, j2, list, d2, d3, d4);
        }

        @Override // h.a.a.g.b
        public void onError(DataModels.Error error) {
            k.this.f6528e.onError(error);
        }
    }

    /* compiled from: Beacons.java */
    /* loaded from: classes.dex */
    public class b implements e.d {
        public b() {
        }

        @Override // h.a.a.e.d
        public void a(long j, long j2, List<f> list, double d2, double d3, double d4) {
            k.this.a(j, j2, list, d2, d3, d4);
        }
    }

    /* compiled from: Beacons.java */
    /* loaded from: classes.dex */
    public class c implements g.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f6531a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f6532b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f6533c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f6534d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6535e;

        public c(int i2, long j, long j2, boolean z, boolean z2) {
            this.f6531a = i2;
            this.f6532b = j;
            this.f6533c = j2;
            this.f6534d = z;
            this.f6535e = z2;
        }

        @Override // h.a.a.g.e
        public void a() {
            try {
                k.this.f6524a.a(this.f6531a);
                g gVar = k.this.f6524a;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                gVar.a(timeUnit.toMillis(this.f6532b), timeUnit.toMillis(this.f6533c));
                k.this.f6524a.a(this.f6534d);
                k.this.f6524a.b(this.f6535e);
                k.this.f6524a.g();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: Beacons.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(DataModels.c cVar);

        void onError(DataModels.Error error);
    }

    public k(short s) {
        short s2 = f6522f;
        this.f6527d = s2;
        this.f6527d = s;
        if (s == s2) {
            b();
        } else if (s == f6523g) {
            a();
        }
    }

    private void c() {
        e eVar = this.f6525b;
        if (eVar != null) {
            try {
                eVar.c();
                this.f6525b.a();
                this.f6525b = null;
            } catch (Throwable unused) {
            }
        }
    }

    private void d() {
        g gVar = this.f6524a;
        if (gVar != null) {
            gVar.h();
            this.f6524a.b();
            this.f6524a = null;
        }
    }

    public void e() {
        e eVar;
        h.a.a.c.a("LOGIC_BEACONS", "Beacons", "stopBeaconService", "enteredMethod");
        short s = this.f6527d;
        if (s == f6522f) {
            g gVar = this.f6524a;
            if (gVar != null) {
                gVar.h();
                this.f6524a.b();
            }
        } else if (s != f6523g || (eVar = this.f6525b) == null) {
        } else {
            eVar.c();
            this.f6525b.a();
        }
    }

    private void b() {
        g gVar = new g(App.getInstance(), false);
        this.f6524a = gVar;
        gVar.a(new a());
    }

    private void a() {
        e eVar = new e(App.getInstance());
        this.f6525b = eVar;
        eVar.a(new b());
    }

    private DataModels.c b(int i2, byte[] bArr, long j, long j2, String str, String str2, int i3, double d2, double d3, double d4) {
        int i4 = 0;
        int i5 = bArr[0] & 255;
        int i6 = bArr[1] & 255;
        int i7 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        int i8 = bArr[4] & 255;
        int i9 = bArr[5] & 255;
        int i10 = bArr[6] & 255;
        int i11 = bArr[7] & 255;
        int i12 = ((bArr[8] & 255) * 256) + (bArr[9] & 255);
        int i13 = bArr[10] & 255;
        int i14 = (bArr[11] >> 4) & 15;
        int i15 = bArr[11] & 15;
        if (i14 >= 2) {
            Map<String, DataModels.q> t = l.k().t();
            DataModels.q qVar = t.get(i12 + "|" + i6);
            if (qVar != null) {
                i4 = qVar.d();
            }
        } else {
            i4 = i12;
        }
        DataModels.c cVar = new DataModels.c(i6 + "|" + i7 + "|" + i9 + "|" + i10 + "|" + i11 + "|" + i4 + "|" + i13, str2, str, i3, i2, j, j2, false, 0L, d2, d3, d4, 0L, null, 0L);
        cVar.a(i5, i6, i7, i8, i9, i10, i11, i4, i13, i14, i15);
        return cVar;
    }

    public short a(short s) {
        this.f6527d = s;
        return s;
    }

    public void a(d dVar, int i2, long j, long j2, short s, boolean z, boolean z2) {
        this.f6528e = dVar;
        if (s > 0) {
            this.f6526c = s;
        }
        if (!App.getInstance().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            dVar.onError(DataModels.Error.bleNotSupported());
            h.a.a.c.a("LOGIC_BEACONS", "Beacons", "startBeaconService", DataModels.Error.bleNotSupported().getType().toString());
        } else if (this.f6527d == f6523g) {
            d();
            if (this.f6525b == null) {
                a();
            }
            e eVar = this.f6525b;
            if (eVar != null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                eVar.b(timeUnit.toMillis(j), timeUnit.toMillis(j2));
                this.f6525b.a(z);
                this.f6525b.b();
            }
        } else {
            c();
            if (this.f6524a == null) {
                b();
            }
            g gVar = this.f6524a;
            if (gVar != null) {
                gVar.a(new c(i2, j, j2, z, z2));
            }
        }
    }

    private DataModels.c a(int i2, byte[] bArr, long j, long j2, String str, String str2, int i3, double d2, double d3, double d4) {
        int i4 = bArr[0] & 255;
        int i5 = bArr[1] & 255;
        int i6 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        int i7 = bArr[4] & 255;
        int i8 = bArr[5] & 255;
        int i9 = bArr[10] & 255;
        byte b2 = bArr[11];
        int i10 = ((bArr[12] & 255) * 256) + (bArr[13] & 255);
        int i11 = bArr[14] & 255;
        int i12 = bArr[15] & 255;
        DataModels.c cVar = new DataModels.c(i5 + "|" + i6 + "|" + i8 + "|" + i9 + "|" + ((int) b2) + "|" + i10 + "|" + i11, str2, str, i3, i2, j, j2, false, 0L, d2, d3, d4, 0L, null, 0L);
        cVar.a(i4, i5, i6, i7, i8, i9, b2, i10, i11, 0, i12);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r29, long r31, java.util.List<h.a.a.f> r33, double r34, double r36, double r38) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.a.k.a(long, long, java.util.List, double, double, double):void");
    }
}
