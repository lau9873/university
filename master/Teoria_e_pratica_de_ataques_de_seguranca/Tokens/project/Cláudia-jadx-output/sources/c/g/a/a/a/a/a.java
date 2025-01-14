package c.g.a.a.a.a;

import android.content.Context;
import c.g.a.a.a.f;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: c.g.a.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
        void a(byte[] bArr);
    }

    /* loaded from: classes.dex */
    public class b implements a {

        /* renamed from: e  reason: collision with root package name */
        public static boolean f3945e = false;

        /* renamed from: f  reason: collision with root package name */
        public static Boolean f3946f;

        /* renamed from: a  reason: collision with root package name */
        public InterfaceC0072a f3947a;

        /* renamed from: b  reason: collision with root package name */
        public Context f3948b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3949c = true;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f3950d = {111, 66};

        public b(Context context, c.g.a.a.a.a.c cVar, boolean z) {
            this.f3948b = context;
            if (z) {
                c();
            }
        }

        @Override // c.g.a.a.a.a.a
        public void a() {
            f.b(this.f3948b.getApplicationContext()).a(2);
        }

        @Override // c.g.a.a.a.a.a
        public void a(InterfaceC0072a interfaceC0072a) {
            this.f3947a = interfaceC0072a;
        }

        public boolean a(byte[] bArr, byte[] bArr2) {
            byte b2 = bArr[1];
            return b2 != -30 ? b2 == 48 && bArr2.length >= 2 && ((bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0) || (bArr2[bArr2.length - 2] == 98 && bArr2[bArr2.length - 1] == 0)) && !(bArr[5] == 0 && bArr[6] == 0 && bArr[7] == 0) : bArr[3] == 64 && bArr[4] == 29 && bArr2.length >= 2 && bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0;
        }

        @Override // c.g.a.a.a.a.a
        public void b() {
            f.b(this.f3948b.getApplicationContext()).a(1);
        }

        public boolean b(byte[] bArr, byte[] bArr2) {
            return bArr[1] == -114 && bArr[4] == 4 && bArr2.length >= 2 && bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0;
        }

        public void c() {
            f3946f = null;
            f3945e = false;
        }

        public boolean c(byte[] bArr, byte[] bArr2) {
            return bArr[1] == -118 && bArr2.length >= 2 && bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0;
        }

        public InterfaceC0072a d() {
            return this.f3947a;
        }

        public boolean e() {
            if (f3946f == null) {
                f3946f = Boolean.valueOf(c.g.c.a.a.f.b(this.f3948b.getApplicationContext()).a("validationsEnabled", this.f3949c) && c.g.a.a.a.d.d(this.f3948b.getApplicationContext()));
            }
            return f3946f.booleanValue();
        }
    }

    /* loaded from: classes.dex */
    public class c extends b {
        public c(Context context, c.g.a.a.a.a.c cVar, boolean z) {
            super(context, cVar, z);
        }

        @Override // c.g.a.a.a.a.a
        public byte[] a(byte[] bArr) {
            try {
                return f.b(this.f3948b.getApplicationContext()).a(bArr);
            } catch (Exception e2) {
                c.g.c.a.a.a.a("transceive", c.class, e2, "local apdu error ");
                return this.f3950d;
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b {

        /* renamed from: g  reason: collision with root package name */
        public static byte[] f3951g;

        public d(Context context, c.g.a.a.a.a.c cVar, boolean z) {
            super(context, cVar, z);
        }

        @Override // c.g.a.a.a.a.a
        public byte[] a(byte[] bArr) {
            byte[] bArr2;
            if (!e()) {
                byte[] bArr3 = this.f3950d;
                c.g.c.a.a.a.a("transceive", d.class, null, "APDU rejected: contactless not allowed");
                return bArr3;
            }
            try {
                bArr2 = f.b(this.f3948b.getApplicationContext()).a(bArr);
            } catch (Exception e2) {
                c.g.c.a.a.a.a("processCommandApdu", d.class, e2);
                bArr2 = this.f3950d;
            }
            if (d(bArr, bArr2)) {
                f3951g = bArr;
            }
            if (c(bArr, bArr2)) {
                b.f3945e = false;
            } else {
                b.f3945e = b.f3945e || a(bArr, bArr2);
                if (b.f3945e && b(bArr, bArr2)) {
                    b.f3945e = false;
                    if (d() != null) {
                        d().a(f3951g);
                    }
                }
            }
            return bArr2;
        }

        public final boolean d(byte[] bArr, byte[] bArr2) {
            return bArr[1] == -92 && bArr[2] == 4 && bArr2.length >= 2 && bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0;
        }
    }

    void a();

    void a(InterfaceC0072a interfaceC0072a);

    byte[] a(byte[] bArr);

    void b();
}
