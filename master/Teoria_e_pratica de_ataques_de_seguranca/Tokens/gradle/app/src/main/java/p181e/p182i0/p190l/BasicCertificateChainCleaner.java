package p181e.p182i0.p190l;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: e.i0.l.a */
/* loaded from: classes.dex */
public final class BasicCertificateChainCleaner extends AbstractC1795b {

    /* renamed from: a */
    public final TrustRootIndex f8258a;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        this.f8258a = trustRootIndex;
    }

    @Override // p181e.p182i0.p190l.AbstractC1795b
    /* renamed from: a */
    public List<Certificate> mo2843a(List<Certificate> list, String str) {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate mo2825a = this.f8258a.mo2825a(x509Certificate);
            if (mo2825a != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(mo2825a)) {
                    arrayList.add(mo2825a);
                }
                if (m2844a(mo2825a, mo2825a)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (m2844a(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicCertificateChainCleaner) && ((BasicCertificateChainCleaner) obj).f8258a.equals(this.f8258a);
    }

    public int hashCode() {
        return this.f8258a.hashCode();
    }

    /* renamed from: a */
    public final boolean m2844a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return true;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        }
        return false;
    }
}
