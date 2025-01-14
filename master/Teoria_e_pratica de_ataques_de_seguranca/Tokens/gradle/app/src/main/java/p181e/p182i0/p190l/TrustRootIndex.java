package p181e.p182i0.p190l;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* renamed from: e.i0.l.e */
/* loaded from: classes.dex */
public abstract class TrustRootIndex {

    /* compiled from: TrustRootIndex.java */
    /* renamed from: e.i0.l.e$a */
    /* loaded from: classes.dex */
    public static final class C1796a extends TrustRootIndex {

        /* renamed from: a */
        public final X509TrustManager f8267a;

        /* renamed from: b */
        public final Method f8268b;

        public C1796a(X509TrustManager x509TrustManager, Method method) {
            this.f8268b = method;
            this.f8267a = x509TrustManager;
        }

        @Override // p181e.p182i0.p190l.TrustRootIndex
        /* renamed from: a */
        public X509Certificate mo2825a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f8268b.invoke(this.f8267a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C1796a) {
                C1796a c1796a = (C1796a) obj;
                return this.f8267a.equals(c1796a.f8267a) && this.f8268b.equals(c1796a.f8268b);
            }
            return false;
        }

        public int hashCode() {
            return this.f8267a.hashCode() + (this.f8268b.hashCode() * 31);
        }
    }

    /* compiled from: TrustRootIndex.java */
    /* renamed from: e.i0.l.e$b */
    /* loaded from: classes.dex */
    public static final class C1797b extends TrustRootIndex {

        /* renamed from: a */
        public final Map<X500Principal, Set<X509Certificate>> f8269a = new LinkedHashMap();

        public C1797b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set<X509Certificate> set = this.f8269a.get(subjectX500Principal);
                if (set == null) {
                    set = new LinkedHashSet<>(1);
                    this.f8269a.put(subjectX500Principal, set);
                }
                set.add(x509Certificate);
            }
        }

        @Override // p181e.p182i0.p190l.TrustRootIndex
        /* renamed from: a */
        public X509Certificate mo2825a(X509Certificate x509Certificate) {
            Set<X509Certificate> set = this.f8269a.get(x509Certificate.getIssuerX500Principal());
            if (set == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : set) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof C1797b) && ((C1797b) obj).f8269a.equals(this.f8269a);
        }

        public int hashCode() {
            return this.f8269a.hashCode();
        }
    }

    /* renamed from: a */
    public static TrustRootIndex m2827a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new C1796a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return m2826a(x509TrustManager.getAcceptedIssuers());
        }
    }

    /* renamed from: a */
    public abstract X509Certificate mo2825a(X509Certificate x509Certificate);

    /* renamed from: a */
    public static TrustRootIndex m2826a(X509Certificate... x509CertificateArr) {
        return new C1797b(x509CertificateArr);
    }
}
