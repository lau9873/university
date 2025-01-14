package d.a.a.a.m.e;

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
/* compiled from: PinningTrustManager.java */
/* loaded from: classes.dex */
public class g implements X509TrustManager {

    /* renamed from: f  reason: collision with root package name */
    public static final X509Certificate[] f4383f = new X509Certificate[0];

    /* renamed from: a  reason: collision with root package name */
    public final TrustManager[] f4384a;

    /* renamed from: b  reason: collision with root package name */
    public final h f4385b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4386c;

    /* renamed from: d  reason: collision with root package name */
    public final List<byte[]> f4387d = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    public final Set<X509Certificate> f4388e = Collections.synchronizedSet(new HashSet());

    public g(h hVar, f fVar) {
        this.f4384a = a(hVar);
        this.f4385b = hVar;
        this.f4386c = fVar.d();
        for (String str : fVar.c()) {
            this.f4387d.add(a(str));
        }
    }

    public final TrustManager[] a(h hVar) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
            trustManagerFactory.init(hVar.f4389a);
            return trustManagerFactory.getTrustManagers();
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (this.f4388e.contains(x509CertificateArr[0])) {
            return;
        }
        a(x509CertificateArr, str);
        a(x509CertificateArr);
        this.f4388e.add(x509CertificateArr[0]);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return f4383f;
    }

    public final boolean a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] bArr : this.f4387d) {
                if (Arrays.equals(bArr, digest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e2) {
            throw new CertificateException(e2);
        }
    }

    public final void a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.f4384a) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    public final void a(X509Certificate[] x509CertificateArr) {
        if (this.f4386c != -1 && System.currentTimeMillis() - this.f4386c > 15552000000L) {
            d.a.a.a.c.h().a("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f4386c) + " millis vs 15552000000 millis) falling back to system trust.");
            return;
        }
        for (X509Certificate x509Certificate : a.a(x509CertificateArr, this.f4385b)) {
            if (a(x509Certificate)) {
                return;
            }
        }
        throw new CertificateException("No valid pins found in chain!");
    }

    public final byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }
}
