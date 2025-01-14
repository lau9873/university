package p181e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: e.h */
/* loaded from: classes.dex */
public final class CipherSuite {

    /* renamed from: b */
    public static final Comparator<String> f7914b = new C1751a();

    /* renamed from: c */
    public static final Map<String, CipherSuite> f7915c = new TreeMap(f7914b);

    /* renamed from: d */
    public static final CipherSuite f7916d;

    /* renamed from: e */
    public static final CipherSuite f7917e;

    /* renamed from: f */
    public static final CipherSuite f7918f;

    /* renamed from: g */
    public static final CipherSuite f7919g;

    /* renamed from: h */
    public static final CipherSuite f7920h;

    /* renamed from: i */
    public static final CipherSuite f7921i;

    /* renamed from: j */
    public static final CipherSuite f7922j;

    /* renamed from: k */
    public static final CipherSuite f7923k;

    /* renamed from: l */
    public static final CipherSuite f7924l;

    /* renamed from: m */
    public static final CipherSuite f7925m;

    /* renamed from: n */
    public static final CipherSuite f7926n;

    /* renamed from: o */
    public static final CipherSuite f7927o;

    /* renamed from: p */
    public static final CipherSuite f7928p;

    /* renamed from: q */
    public static final CipherSuite f7929q;

    /* renamed from: r */
    public static final CipherSuite f7930r;

    /* renamed from: a */
    public final String f7931a;

    /* compiled from: CipherSuite.java */
    /* renamed from: e.h$a */
    /* loaded from: classes.dex */
    public class C1751a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            for (int i = 4; i < min; i++) {
                char charAt = str.charAt(i);
                char charAt2 = str2.charAt(i);
                if (charAt != charAt2) {
                    return charAt < charAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    static {
        m3176a("SSL_RSA_WITH_NULL_MD5", 1);
        m3176a("SSL_RSA_WITH_NULL_SHA", 2);
        m3176a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        m3176a("SSL_RSA_WITH_RC4_128_MD5", 4);
        m3176a("SSL_RSA_WITH_RC4_128_SHA", 5);
        m3176a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        m3176a("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f7916d = m3176a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        m3176a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        m3176a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        m3176a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        m3176a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        m3176a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        m3176a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        m3176a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        m3176a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        m3176a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        m3176a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        m3176a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        m3176a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        m3176a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        m3176a("TLS_KRB5_WITH_RC4_128_SHA", 32);
        m3176a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        m3176a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        m3176a("TLS_KRB5_WITH_RC4_128_MD5", 36);
        m3176a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        m3176a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        m3176a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        m3176a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f7917e = m3176a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        m3176a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        m3176a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        m3176a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f7918f = m3176a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        m3176a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        m3176a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        m3176a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        m3176a("TLS_RSA_WITH_NULL_SHA256", 59);
        m3176a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        m3176a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        m3176a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        m3176a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        m3176a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        m3176a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        m3176a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        m3176a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        m3176a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        m3176a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        m3176a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        m3176a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        m3176a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        m3176a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        m3176a("TLS_PSK_WITH_RC4_128_SHA", 138);
        m3176a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        m3176a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        m3176a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        m3176a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f7919g = m3176a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f7920h = m3176a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        m3176a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        m3176a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        m3176a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        m3176a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        m3176a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        m3176a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        m3176a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        m3176a("TLS_FALLBACK_SCSV", 22016);
        m3176a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        m3176a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        m3176a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        m3176a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        m3176a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        m3176a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        m3176a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        m3176a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        f7921i = m3176a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        f7922j = m3176a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        m3176a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        m3176a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        m3176a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        m3176a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        m3176a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        m3176a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        m3176a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        m3176a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f7923k = m3176a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f7924l = m3176a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        m3176a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        m3176a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        m3176a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        m3176a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        m3176a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        m3176a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        m3176a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        m3176a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        m3176a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        m3176a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        m3176a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        m3176a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        m3176a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f7925m = m3176a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f7926n = m3176a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        m3176a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        m3176a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f7927o = m3176a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f7928p = m3176a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        m3176a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        m3176a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        m3176a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        m3176a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        f7929q = m3176a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        f7930r = m3176a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    public CipherSuite(String str) {
        if (str != null) {
            this.f7931a = str;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static synchronized CipherSuite m3177a(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            cipherSuite = f7915c.get(str);
            if (cipherSuite == null) {
                cipherSuite = new CipherSuite(str);
                f7915c.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    public String toString() {
        return this.f7931a;
    }

    /* renamed from: a */
    public static List<CipherSuite> m3175a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(m3177a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public static CipherSuite m3176a(String str, int i) {
        return m3177a(str);
    }
}
