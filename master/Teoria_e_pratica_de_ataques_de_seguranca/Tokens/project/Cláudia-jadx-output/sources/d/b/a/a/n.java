package d.b.a.a;

import java.io.Serializable;
/* compiled from: Phonenumber.java */
/* loaded from: classes.dex */
public class n implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public boolean f4543c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4545e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4547g;
    public boolean j;
    public boolean m;

    /* renamed from: a  reason: collision with root package name */
    public int f4541a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f4542b = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f4544d = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f4546f = false;

    /* renamed from: h  reason: collision with root package name */
    public int f4548h = 1;

    /* renamed from: i  reason: collision with root package name */
    public String f4549i = "";
    public String n = "";
    public a k = a.UNSPECIFIED;

    /* compiled from: Phonenumber.java */
    /* loaded from: classes.dex */
    public enum a {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    public n a(int i2) {
        this.f4541a = i2;
        return this;
    }

    public int b() {
        return this.f4541a;
    }

    public n c(String str) {
        if (str != null) {
            this.f4549i = str;
            return this;
        }
        throw new NullPointerException();
    }

    public String d() {
        return this.f4544d;
    }

    public long e() {
        return this.f4542b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof n) && a((n) obj);
    }

    public int f() {
        return this.f4548h;
    }

    public String g() {
        return this.n;
    }

    public String h() {
        return this.f4549i;
    }

    public int hashCode() {
        return ((((((((((((((((2173 + b()) * 53) + Long.valueOf(e()).hashCode()) * 53) + d().hashCode()) * 53) + (n() ? 1231 : 1237)) * 53) + f()) * 53) + h().hashCode()) * 53) + c().hashCode()) * 53) + g().hashCode()) * 53) + (m() ? 1231 : 1237);
    }

    public boolean i() {
        return this.j;
    }

    public boolean j() {
        return this.f4543c;
    }

    public boolean k() {
        return this.f4545e;
    }

    public boolean l() {
        return this.f4547g;
    }

    public boolean m() {
        return this.m;
    }

    public boolean n() {
        return this.f4546f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Country Code: ");
        sb.append(this.f4541a);
        sb.append(" National Number: ");
        sb.append(this.f4542b);
        if (k() && n()) {
            sb.append(" Leading Zero(s): true");
        }
        if (l()) {
            sb.append(" Number of leading zeros: ");
            sb.append(this.f4548h);
        }
        if (j()) {
            sb.append(" Extension: ");
            sb.append(this.f4544d);
        }
        if (i()) {
            sb.append(" Country Code Source: ");
            sb.append(this.k);
        }
        if (m()) {
            sb.append(" Preferred Domestic Carrier Code: ");
            sb.append(this.n);
        }
        return sb.toString();
    }

    public n a(long j) {
        this.f4542b = j;
        return this;
    }

    public n b(int i2) {
        this.f4547g = true;
        this.f4548h = i2;
        return this;
    }

    public n a(String str) {
        if (str != null) {
            this.f4543c = true;
            this.f4544d = str;
            return this;
        }
        throw new NullPointerException();
    }

    public a c() {
        return this.k;
    }

    public n b(String str) {
        if (str != null) {
            this.m = true;
            this.n = str;
            return this;
        }
        throw new NullPointerException();
    }

    public n a(boolean z) {
        this.f4545e = true;
        this.f4546f = z;
        return this;
    }

    public n a(a aVar) {
        if (aVar != null) {
            this.j = true;
            this.k = aVar;
            return this;
        }
        throw new NullPointerException();
    }

    public n a() {
        this.j = false;
        this.k = a.UNSPECIFIED;
        return this;
    }

    public boolean a(n nVar) {
        if (nVar == null) {
            return false;
        }
        if (this == nVar) {
            return true;
        }
        return this.f4541a == nVar.f4541a && this.f4542b == nVar.f4542b && this.f4544d.equals(nVar.f4544d) && this.f4546f == nVar.f4546f && this.f4548h == nVar.f4548h && this.f4549i.equals(nVar.f4549i) && this.k == nVar.k && this.n.equals(nVar.n) && m() == nVar.m();
    }
}
