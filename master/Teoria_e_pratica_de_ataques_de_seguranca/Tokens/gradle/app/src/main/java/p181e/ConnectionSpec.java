package p181e;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p181e.p182i0.Util;

/* renamed from: e.k */
/* loaded from: classes.dex */
public final class ConnectionSpec {

    /* renamed from: e */
    public static final CipherSuite[] f8287e = {CipherSuite.f7925m, CipherSuite.f7927o, CipherSuite.f7926n, CipherSuite.f7928p, CipherSuite.f7930r, CipherSuite.f7929q, CipherSuite.f7921i, CipherSuite.f7923k, CipherSuite.f7922j, CipherSuite.f7924l, CipherSuite.f7919g, CipherSuite.f7920h, CipherSuite.f7917e, CipherSuite.f7918f, CipherSuite.f7916d};

    /* renamed from: f */
    public static final ConnectionSpec f8288f;

    /* renamed from: g */
    public static final ConnectionSpec f8289g;

    /* renamed from: a */
    public final boolean f8290a;

    /* renamed from: b */
    public final boolean f8291b;

    /* renamed from: c */
    public final String[] f8292c;

    /* renamed from: d */
    public final String[] f8293d;

    static {
        C1802a c1802a = new C1802a(true);
        c1802a.m2804a(f8287e);
        c1802a.m2805a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        c1802a.m2806a(true);
        f8288f = c1802a.m2807a();
        C1802a c1802a2 = new C1802a(f8288f);
        c1802a2.m2805a(TlsVersion.TLS_1_0);
        c1802a2.m2806a(true);
        c1802a2.m2807a();
        f8289g = new C1802a(false).m2807a();
    }

    public ConnectionSpec(C1802a c1802a) {
        this.f8290a = c1802a.f8294a;
        this.f8292c = c1802a.f8295b;
        this.f8293d = c1802a.f8296c;
        this.f8291b = c1802a.f8297d;
    }

    /* renamed from: a */
    public List<CipherSuite> m2814a() {
        String[] strArr = this.f8292c;
        if (strArr != null) {
            return CipherSuite.m3175a(strArr);
        }
        return null;
    }

    /* renamed from: b */
    public boolean m2811b() {
        return this.f8290a;
    }

    /* renamed from: c */
    public boolean m2809c() {
        return this.f8291b;
    }

    /* renamed from: d */
    public List<TlsVersion> m2808d() {
        String[] strArr = this.f8293d;
        if (strArr != null) {
            return TlsVersion.m3178a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ConnectionSpec) {
            if (obj == this) {
                return true;
            }
            ConnectionSpec connectionSpec = (ConnectionSpec) obj;
            boolean z = this.f8290a;
            if (z != connectionSpec.f8290a) {
                return false;
            }
            return !z || (Arrays.equals(this.f8292c, connectionSpec.f8292c) && Arrays.equals(this.f8293d, connectionSpec.f8293d) && this.f8291b == connectionSpec.f8291b);
        }
        return false;
    }

    public int hashCode() {
        if (this.f8290a) {
            return ((((527 + Arrays.hashCode(this.f8292c)) * 31) + Arrays.hashCode(this.f8293d)) * 31) + (!this.f8291b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f8290a) {
            String obj = this.f8292c != null ? m2814a().toString() : "[all enabled]";
            String obj2 = this.f8293d != null ? m2808d().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f8291b + ")";
        }
        return "ConnectionSpec()";
    }

    /* compiled from: ConnectionSpec.java */
    /* renamed from: e.k$a */
    /* loaded from: classes.dex */
    public static final class C1802a {

        /* renamed from: a */
        public boolean f8294a;

        /* renamed from: b */
        public String[] f8295b;

        /* renamed from: c */
        public String[] f8296c;

        /* renamed from: d */
        public boolean f8297d;

        public C1802a(boolean z) {
            this.f8294a = z;
        }

        /* renamed from: a */
        public C1802a m2804a(CipherSuite... cipherSuiteArr) {
            if (this.f8294a) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].f7931a;
                }
                m2803a(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: b */
        public C1802a m2802b(String... strArr) {
            if (this.f8294a) {
                if (strArr.length != 0) {
                    this.f8296c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C1802a(ConnectionSpec connectionSpec) {
            this.f8294a = connectionSpec.f8290a;
            this.f8295b = connectionSpec.f8292c;
            this.f8296c = connectionSpec.f8293d;
            this.f8297d = connectionSpec.f8291b;
        }

        /* renamed from: a */
        public C1802a m2803a(String... strArr) {
            if (this.f8294a) {
                if (strArr.length != 0) {
                    this.f8295b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public C1802a m2805a(TlsVersion... tlsVersionArr) {
            if (this.f8294a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].f7913a;
                }
                m2802b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: a */
        public C1802a m2806a(boolean z) {
            if (this.f8294a) {
                this.f8297d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public ConnectionSpec m2807a() {
            return new ConnectionSpec(this);
        }
    }

    /* renamed from: a */
    public void m2812a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec m2810b = m2810b(sSLSocket, z);
        String[] strArr = m2810b.f8293d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = m2810b.f8292c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    public final ConnectionSpec m2810b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f8292c != null) {
            enabledCipherSuites = Util.m3158a(CipherSuite.f7914b, sSLSocket.getEnabledCipherSuites(), this.f8292c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f8293d != null) {
            enabledProtocols = Util.m3158a(Util.f7948o, sSLSocket.getEnabledProtocols(), this.f8293d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int m3159a = Util.m3159a(CipherSuite.f7914b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && m3159a != -1) {
            enabledCipherSuites = Util.m3155a(enabledCipherSuites, supportedCipherSuites[m3159a]);
        }
        C1802a c1802a = new C1802a(this);
        c1802a.m2803a(enabledCipherSuites);
        c1802a.m2802b(enabledProtocols);
        return c1802a.m2807a();
    }

    /* renamed from: a */
    public boolean m2813a(SSLSocket sSLSocket) {
        if (this.f8290a) {
            String[] strArr = this.f8293d;
            if (strArr == null || Util.m3151b(Util.f7948o, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f8292c;
                return strArr2 == null || Util.m3151b(CipherSuite.f7914b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }
}
