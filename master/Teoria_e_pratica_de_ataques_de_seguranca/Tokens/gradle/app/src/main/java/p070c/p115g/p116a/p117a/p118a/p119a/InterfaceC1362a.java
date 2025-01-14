package p070c.p115g.p116a.p117a.p118a.p119a;

import android.content.Context;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p116a.p117a.p118a.C1415f;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.a.a.a.a.a */
/* loaded from: classes.dex */
public interface InterfaceC1362a {

    /* renamed from: c.g.a.a.a.a.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1363a {
        /* renamed from: a */
        void mo4232a(byte[] bArr);
    }

    /* renamed from: c.g.a.a.a.a.a$b */
    /* loaded from: classes.dex */
    public class C1364b implements InterfaceC1362a {

        /* renamed from: e */
        public static boolean f5972e = false;

        /* renamed from: f */
        public static Boolean f5973f;

        /* renamed from: a */
        public InterfaceC1363a f5974a;

        /* renamed from: b */
        public Context f5975b;

        /* renamed from: c */
        public boolean f5976c = true;

        /* renamed from: d */
        public final byte[] f5977d = {111, 66};

        public C1364b(Context context, EnumC1368c enumC1368c, boolean z) {
            this.f5975b = context;
            if (z) {
                m4647c();
            }
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a
        /* renamed from: a */
        public void mo4652a() {
            C1415f.m4532b(this.f5975b.getApplicationContext()).m4541a(2);
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a
        /* renamed from: a */
        public void mo4651a(InterfaceC1363a interfaceC1363a) {
            this.f5974a = interfaceC1363a;
        }

        /* renamed from: a */
        public boolean m4650a(byte[] bArr, byte[] bArr2) {
            byte b = bArr[1];
            return b != -30 ? b == 48 && bArr2.length >= 2 && ((bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0) || (bArr2[bArr2.length - 2] == 98 && bArr2[bArr2.length - 1] == 0)) && !(bArr[5] == 0 && bArr[6] == 0 && bArr[7] == 0) : bArr[3] == 64 && bArr[4] == 29 && bArr2.length >= 2 && bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0;
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a
        /* renamed from: b */
        public void mo4649b() {
            C1415f.m4532b(this.f5975b.getApplicationContext()).m4541a(1);
        }

        /* renamed from: b */
        public boolean m4648b(byte[] bArr, byte[] bArr2) {
            return bArr[1] == -114 && bArr[4] == 4 && bArr2.length >= 2 && bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0;
        }

        /* renamed from: c */
        public void m4647c() {
            f5973f = null;
            f5972e = false;
        }

        /* renamed from: c */
        public boolean m4646c(byte[] bArr, byte[] bArr2) {
            return bArr[1] == -118 && bArr2.length >= 2 && bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0;
        }

        /* renamed from: d */
        public InterfaceC1363a m4645d() {
            return this.f5974a;
        }

        /* renamed from: e */
        public boolean m4644e() {
            if (f5973f == null) {
                f5973f = Boolean.valueOf(C1429f.m4444b(this.f5975b.getApplicationContext()).m4446a("validationsEnabled", this.f5976c) && C1373d.m4610d(this.f5975b.getApplicationContext()));
            }
            return f5973f.booleanValue();
        }
    }

    /* renamed from: c.g.a.a.a.a.a$c */
    /* loaded from: classes.dex */
    public class C1365c extends C1364b {
        public C1365c(Context context, EnumC1368c enumC1368c, boolean z) {
            super(context, enumC1368c, z);
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a
        /* renamed from: a */
        public byte[] mo4643a(byte[] bArr) {
            try {
                return C1415f.m4532b(this.f5975b.getApplicationContext()).m4538a(bArr);
            } catch (Exception e) {
                C1423a.m4476a("transceive", C1365c.class, e, "local apdu error ");
                return this.f5977d;
            }
        }
    }

    /* renamed from: c.g.a.a.a.a.a$d */
    /* loaded from: classes.dex */
    public class C1366d extends C1364b {

        /* renamed from: g */
        public static byte[] f5978g;

        public C1366d(Context context, EnumC1368c enumC1368c, boolean z) {
            super(context, enumC1368c, z);
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a
        /* renamed from: a */
        public byte[] mo4643a(byte[] bArr) {
            byte[] bArr2;
            if (!m4644e()) {
                byte[] bArr3 = this.f5977d;
                C1423a.m4476a("transceive", C1366d.class, null, "APDU rejected: contactless not allowed");
                return bArr3;
            }
            try {
                bArr2 = C1415f.m4532b(this.f5975b.getApplicationContext()).m4538a(bArr);
            } catch (Exception e) {
                C1423a.m4477a("processCommandApdu", C1366d.class, e);
                bArr2 = this.f5977d;
            }
            if (m4642d(bArr, bArr2)) {
                f5978g = bArr;
            }
            if (m4646c(bArr, bArr2)) {
                C1364b.f5972e = false;
            } else {
                C1364b.f5972e = C1364b.f5972e || m4650a(bArr, bArr2);
                if (C1364b.f5972e && m4648b(bArr, bArr2)) {
                    C1364b.f5972e = false;
                    if (m4645d() != null) {
                        m4645d().mo4232a(f5978g);
                    }
                }
            }
            return bArr2;
        }

        /* renamed from: d */
        public final boolean m4642d(byte[] bArr, byte[] bArr2) {
            return bArr[1] == -92 && bArr[2] == 4 && bArr2.length >= 2 && bArr2[bArr2.length - 2] == -112 && bArr2[bArr2.length - 1] == 0;
        }
    }

    /* renamed from: a */
    void mo4652a();

    /* renamed from: a */
    void mo4651a(InterfaceC1363a interfaceC1363a);

    /* renamed from: a */
    byte[] mo4643a(byte[] bArr);

    /* renamed from: b */
    void mo4649b();
}
