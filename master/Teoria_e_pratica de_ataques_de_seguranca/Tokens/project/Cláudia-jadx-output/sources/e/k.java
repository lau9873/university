package e;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* compiled from: ConnectionSpec.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: e  reason: collision with root package name */
    public static final h[] f5879e = {h.m, h.o, h.n, h.p, h.r, h.q, h.f5558i, h.k, h.j, h.l, h.f5556g, h.f5557h, h.f5554e, h.f5555f, h.f5553d};

    /* renamed from: f  reason: collision with root package name */
    public static final k f5880f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f5881g;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5882a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f5883b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f5884c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f5885d;

    static {
        a aVar = new a(true);
        aVar.a(f5879e);
        aVar.a(g0.TLS_1_3, g0.TLS_1_2, g0.TLS_1_1, g0.TLS_1_0);
        aVar.a(true);
        f5880f = aVar.a();
        a aVar2 = new a(f5880f);
        aVar2.a(g0.TLS_1_0);
        aVar2.a(true);
        aVar2.a();
        f5881g = new a(false).a();
    }

    public k(a aVar) {
        this.f5882a = aVar.f5886a;
        this.f5884c = aVar.f5887b;
        this.f5885d = aVar.f5888c;
        this.f5883b = aVar.f5889d;
    }

    public List<h> a() {
        String[] strArr = this.f5884c;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public boolean b() {
        return this.f5882a;
    }

    public boolean c() {
        return this.f5883b;
    }

    public List<g0> d() {
        String[] strArr = this.f5885d;
        if (strArr != null) {
            return g0.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (obj == this) {
                return true;
            }
            k kVar = (k) obj;
            boolean z = this.f5882a;
            if (z != kVar.f5882a) {
                return false;
            }
            return !z || (Arrays.equals(this.f5884c, kVar.f5884c) && Arrays.equals(this.f5885d, kVar.f5885d) && this.f5883b == kVar.f5883b);
        }
        return false;
    }

    public int hashCode() {
        if (this.f5882a) {
            return ((((527 + Arrays.hashCode(this.f5884c)) * 31) + Arrays.hashCode(this.f5885d)) * 31) + (!this.f5883b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f5882a) {
            String obj = this.f5884c != null ? a().toString() : "[all enabled]";
            String obj2 = this.f5885d != null ? d().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f5883b + ")";
        }
        return "ConnectionSpec()";
    }

    /* compiled from: ConnectionSpec.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f5886a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f5887b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f5888c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5889d;

        public a(boolean z) {
            this.f5886a = z;
        }

        public a a(h... hVarArr) {
            if (this.f5886a) {
                String[] strArr = new String[hVarArr.length];
                for (int i2 = 0; i2 < hVarArr.length; i2++) {
                    strArr[i2] = hVarArr[i2].f5559a;
                }
                a(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a b(String... strArr) {
            if (this.f5886a) {
                if (strArr.length != 0) {
                    this.f5888c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(k kVar) {
            this.f5886a = kVar.f5882a;
            this.f5887b = kVar.f5884c;
            this.f5888c = kVar.f5885d;
            this.f5889d = kVar.f5883b;
        }

        public a a(String... strArr) {
            if (this.f5886a) {
                if (strArr.length != 0) {
                    this.f5887b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(g0... g0VarArr) {
            if (this.f5886a) {
                String[] strArr = new String[g0VarArr.length];
                for (int i2 = 0; i2 < g0VarArr.length; i2++) {
                    strArr[i2] = g0VarArr[i2].f5550a;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.f5886a) {
                this.f5889d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public k a() {
            return new k(this);
        }
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        k b2 = b(sSLSocket, z);
        String[] strArr = b2.f5885d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f5884c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public final k b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f5884c != null) {
            enabledCipherSuites = e.i0.c.a(h.f5551b, sSLSocket.getEnabledCipherSuites(), this.f5884c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f5885d != null) {
            enabledProtocols = e.i0.c.a(e.i0.c.o, sSLSocket.getEnabledProtocols(), this.f5885d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = e.i0.c.a(h.f5551b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = e.i0.c.a(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        a aVar = new a(this);
        aVar.a(enabledCipherSuites);
        aVar.b(enabledProtocols);
        return aVar.a();
    }

    public boolean a(SSLSocket sSLSocket) {
        if (this.f5882a) {
            String[] strArr = this.f5885d;
            if (strArr == null || e.i0.c.b(e.i0.c.o, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f5884c;
                return strArr2 == null || e.i0.c.b(h.f5551b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }
}
