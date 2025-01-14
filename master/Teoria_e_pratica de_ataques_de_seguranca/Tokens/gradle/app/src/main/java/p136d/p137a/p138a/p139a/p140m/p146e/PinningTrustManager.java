package p136d.p137a.p138a.p139a.p140m.p146e;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p136d.p137a.p138a.p139a.Fabric;

/* renamed from: d.a.a.a.m.e.g */
/* loaded from: classes.dex */
public class PinningTrustManager implements X509TrustManager {

    /* renamed from: f */
    public static final X509Certificate[] f6587f = new X509Certificate[0];

    /* renamed from: a */
    public final TrustManager[] f6588a;

    /* renamed from: b */
    public final SystemKeyStore f6589b;

    /* renamed from: c */
    public final long f6590c;

    /* renamed from: d */
    public final List<byte[]> f6591d = new LinkedList();

    /* renamed from: e */
    public final Set<X509Certificate> f6592e = Collections.synchronizedSet(new HashSet());

    public PinningTrustManager(SystemKeyStore systemKeyStore, InterfaceC1521f interfaceC1521f) {
        this.f6588a = m3913a(systemKeyStore);
        this.f6589b = systemKeyStore;
        this.f6590c = interfaceC1521f.mo3914d();
        for (String str : interfaceC1521f.mo3915c()) {
            this.f6591d.add(m3912a(str));
        }
    }

    /* renamed from: a */
    public final TrustManager[] m3913a(SystemKeyStore systemKeyStore) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(systemKeyStore.f6593a);
            return trustManagerFactory.getTrustManagers();
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (this.f6592e.contains(x509CertificateArr[0])) {
            return;
        }
        m3909a(x509CertificateArr, str);
        m3910a(x509CertificateArr);
        this.f6592e.add(x509CertificateArr[0]);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return f6587f;
    }

    /* renamed from: a */
    public final boolean m3911a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] bArr : this.f6591d) {
                if (Arrays.equals(bArr, digest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    /* renamed from: a */
    public final void m3909a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.f6588a) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* renamed from: a */
    public final void m3910a(X509Certificate[] x509CertificateArr) {
        if (this.f6590c != -1 && System.currentTimeMillis() - this.f6590c > 15552000000L) {
            Fabric.m4197h().mo4164a("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f6590c) + " millis vs 15552000000 millis) falling back to system trust.");
            return;
        }
        for (X509Certificate x509Certificate : CertificateChainCleaner.m3925a(x509CertificateArr, this.f6589b)) {
            if (m3911a(x509Certificate)) {
                return;
            }
        }
        throw new CertificateException("No valid pins found in chain!");
    }

    /* renamed from: a */
    public final byte[] m3912a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
