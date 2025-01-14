package e.i0.l;

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
/* compiled from: TrustRootIndex.java */
/* loaded from: classes.dex */
public abstract class e {

    /* compiled from: TrustRootIndex.java */
    /* loaded from: classes.dex */
    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        public final X509TrustManager f5859a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f5860b;

        public a(X509TrustManager x509TrustManager, Method method) {
            this.f5860b = method;
            this.f5859a = x509TrustManager;
        }

        @Override // e.i0.l.e
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f5860b.invoke(this.f5859a, x509Certificate);
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
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f5859a.equals(aVar.f5859a) && this.f5860b.equals(aVar.f5860b);
            }
            return false;
        }

        public int hashCode() {
            return this.f5859a.hashCode() + (this.f5860b.hashCode() * 31);
        }
    }

    /* compiled from: TrustRootIndex.java */
    /* loaded from: classes.dex */
    public static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Map<X500Principal, Set<X509Certificate>> f5861a = new LinkedHashMap();

        public b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set<X509Certificate> set = this.f5861a.get(subjectX500Principal);
                if (set == null) {
                    set = new LinkedHashSet<>(1);
                    this.f5861a.put(subjectX500Principal, set);
                }
                set.add(x509Certificate);
            }
        }

        @Override // e.i0.l.e
        public X509Certificate a(X509Certificate x509Certificate) {
            Set<X509Certificate> set = this.f5861a.get(x509Certificate.getIssuerX500Principal());
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
            return (obj instanceof b) && ((b) obj).f5861a.equals(this.f5861a);
        }

        public int hashCode() {
            return this.f5861a.hashCode();
        }
    }

    public static e a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return a(x509TrustManager.getAcceptedIssuers());
        }
    }

    public abstract X509Certificate a(X509Certificate x509Certificate);

    public static e a(X509Certificate... x509CertificateArr) {
        return new b(x509CertificateArr);
    }
}
