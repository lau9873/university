package e.i0.l;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
/* compiled from: CertificateChainCleaner.java */
/* loaded from: classes.dex */
public abstract class b {
    public static b a(X509TrustManager x509TrustManager) {
        return e.i0.j.e.b().a(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str);
}
