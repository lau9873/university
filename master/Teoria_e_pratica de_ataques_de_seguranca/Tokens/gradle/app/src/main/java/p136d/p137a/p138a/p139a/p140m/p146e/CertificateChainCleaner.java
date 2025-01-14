package p136d.p137a.p138a.p139a.p140m.p146e;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* renamed from: d.a.a.a.m.e.a */
/* loaded from: classes.dex */
public final class CertificateChainCleaner {
    /* renamed from: a */
    public static X509Certificate[] m3925a(X509Certificate[] x509CertificateArr, SystemKeyStore systemKeyStore) {
        LinkedList linkedList = new LinkedList();
        boolean m3905b = systemKeyStore.m3905b(x509CertificateArr[0]);
        linkedList.add(x509CertificateArr[0]);
        boolean z = true;
        boolean z2 = m3905b;
        int i = 1;
        while (i < x509CertificateArr.length) {
            if (systemKeyStore.m3905b(x509CertificateArr[i])) {
                z2 = true;
            }
            if (!m3926a(x509CertificateArr[i], x509CertificateArr[i - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i]);
            i++;
        }
        X509Certificate m3906a = systemKeyStore.m3906a(x509CertificateArr[i - 1]);
        if (m3906a != null) {
            linkedList.add(m3906a);
        } else {
            z = z2;
        }
        if (z) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    /* renamed from: a */
    public static boolean m3926a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            try {
                x509Certificate2.verify(x509Certificate.getPublicKey());
                return true;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        }
        return false;
    }
}
