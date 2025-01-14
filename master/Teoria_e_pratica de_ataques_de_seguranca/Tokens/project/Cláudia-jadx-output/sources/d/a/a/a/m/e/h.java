package d.a.a.a.m.e;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;
/* compiled from: SystemKeyStore.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final KeyStore f4389a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<Principal, X509Certificate> f4390b;

    public h(InputStream inputStream, String str) {
        KeyStore a2 = a(inputStream, str);
        this.f4390b = a(a2);
        this.f4389a = a2;
    }

    public X509Certificate a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = this.f4390b.get(x509Certificate.getIssuerX500Principal());
        if (x509Certificate2 == null || x509Certificate2.getSubjectX500Principal().equals(x509Certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return x509Certificate2;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public boolean b(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = this.f4390b.get(x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
    }

    public final HashMap<Principal, X509Certificate> a(KeyStore keyStore) {
        try {
            HashMap<Principal, X509Certificate> hashMap = new HashMap<>();
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                if (x509Certificate != null) {
                    hashMap.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                }
            }
            return hashMap;
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    public final KeyStore a(InputStream inputStream, String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("BKS");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                keyStore.load(bufferedInputStream, str.toCharArray());
                return keyStore;
            } finally {
                bufferedInputStream.close();
            }
        } catch (IOException e2) {
            throw new AssertionError(e2);
        } catch (KeyStoreException e3) {
            throw new AssertionError(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new AssertionError(e4);
        } catch (CertificateException e5) {
            throw new AssertionError(e5);
        }
    }
}
