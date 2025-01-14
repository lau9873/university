package p136d.p149b.p150a.p151a;

import java.io.Serializable;

/* renamed from: d.b.a.a.n */
/* loaded from: classes.dex */
public class Phonenumber implements Serializable {

    /* renamed from: c */
    public boolean f6832c;

    /* renamed from: e */
    public boolean f6834e;

    /* renamed from: g */
    public boolean f6836g;

    /* renamed from: j */
    public boolean f6839j;

    /* renamed from: m */
    public boolean f6841m;

    /* renamed from: a */
    public int f6830a = 0;

    /* renamed from: b */
    public long f6831b = 0;

    /* renamed from: d */
    public String f6833d = "";

    /* renamed from: f */
    public boolean f6835f = false;

    /* renamed from: h */
    public int f6837h = 1;

    /* renamed from: i */
    public String f6838i = "";

    /* renamed from: n */
    public String f6842n = "";

    /* renamed from: k */
    public EnumC1531a f6840k = EnumC1531a.UNSPECIFIED;

    /* compiled from: Phonenumber.java */
    /* renamed from: d.b.a.a.n$a */
    /* loaded from: classes.dex */
    public enum EnumC1531a {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    /* renamed from: a */
    public Phonenumber m3708a(int i) {
        this.f6830a = i;
        return this;
    }

    /* renamed from: b */
    public int m3702b() {
        return this.f6830a;
    }

    /* renamed from: c */
    public Phonenumber m3698c(String str) {
        if (str != null) {
            this.f6838i = str;
            return this;
        }
        throw new NullPointerException();
    }

    /* renamed from: d */
    public String m3697d() {
        return this.f6833d;
    }

    /* renamed from: e */
    public long m3696e() {
        return this.f6831b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Phonenumber) && m3705a((Phonenumber) obj);
    }

    /* renamed from: f */
    public int m3695f() {
        return this.f6837h;
    }

    /* renamed from: g */
    public String m3694g() {
        return this.f6842n;
    }

    /* renamed from: h */
    public String m3693h() {
        return this.f6838i;
    }

    public int hashCode() {
        return ((((((((((((((((2173 + m3702b()) * 53) + Long.valueOf(m3696e()).hashCode()) * 53) + m3697d().hashCode()) * 53) + (m3687n() ? 1231 : 1237)) * 53) + m3695f()) * 53) + m3693h().hashCode()) * 53) + m3699c().hashCode()) * 53) + m3694g().hashCode()) * 53) + (m3688m() ? 1231 : 1237);
    }

    /* renamed from: i */
    public boolean m3692i() {
        return this.f6839j;
    }

    /* renamed from: j */
    public boolean m3691j() {
        return this.f6832c;
    }

    /* renamed from: k */
    public boolean m3690k() {
        return this.f6834e;
    }

    /* renamed from: l */
    public boolean m3689l() {
        return this.f6836g;
    }

    /* renamed from: m */
    public boolean m3688m() {
        return this.f6841m;
    }

    /* renamed from: n */
    public boolean m3687n() {
        return this.f6835f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Country Code: ");
        sb.append(this.f6830a);
        sb.append(" National Number: ");
        sb.append(this.f6831b);
        if (m3690k() && m3687n()) {
            sb.append(" Leading Zero(s): true");
        }
        if (m3689l()) {
            sb.append(" Number of leading zeros: ");
            sb.append(this.f6837h);
        }
        if (m3691j()) {
            sb.append(" Extension: ");
            sb.append(this.f6833d);
        }
        if (m3692i()) {
            sb.append(" Country Code Source: ");
            sb.append(this.f6840k);
        }
        if (m3688m()) {
            sb.append(" Preferred Domestic Carrier Code: ");
            sb.append(this.f6842n);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public Phonenumber m3707a(long j) {
        this.f6831b = j;
        return this;
    }

    /* renamed from: b */
    public Phonenumber m3701b(int i) {
        this.f6836g = true;
        this.f6837h = i;
        return this;
    }

    /* renamed from: a */
    public Phonenumber m3704a(String str) {
        if (str != null) {
            this.f6832c = true;
            this.f6833d = str;
            return this;
        }
        throw new NullPointerException();
    }

    /* renamed from: c */
    public EnumC1531a m3699c() {
        return this.f6840k;
    }

    /* renamed from: b */
    public Phonenumber m3700b(String str) {
        if (str != null) {
            this.f6841m = true;
            this.f6842n = str;
            return this;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public Phonenumber m3703a(boolean z) {
        this.f6834e = true;
        this.f6835f = z;
        return this;
    }

    /* renamed from: a */
    public Phonenumber m3706a(EnumC1531a enumC1531a) {
        if (enumC1531a != null) {
            this.f6839j = true;
            this.f6840k = enumC1531a;
            return this;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public Phonenumber m3709a() {
        this.f6839j = false;
        this.f6840k = EnumC1531a.UNSPECIFIED;
        return this;
    }

    /* renamed from: a */
    public boolean m3705a(Phonenumber phonenumber) {
        if (phonenumber == null) {
            return false;
        }
        if (this == phonenumber) {
            return true;
        }
        return this.f6830a == phonenumber.f6830a && this.f6831b == phonenumber.f6831b && this.f6833d.equals(phonenumber.f6833d) && this.f6835f == phonenumber.f6835f && this.f6837h == phonenumber.f6837h && this.f6838i.equals(phonenumber.f6838i) && this.f6840k == phonenumber.f6840k && this.f6842n.equals(phonenumber.f6842n) && m3688m() == phonenumber.m3688m();
    }
}
