package p181e;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import p181e.p182i0.Util;

/* renamed from: e.s */
/* loaded from: classes.dex */
public final class Handshake {

    /* renamed from: a */
    public final TlsVersion f8327a;

    /* renamed from: b */
    public final CipherSuite f8328b;

    /* renamed from: c */
    public final List<Certificate> f8329c;

    /* renamed from: d */
    public final List<Certificate> f8330d;

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f8327a = tlsVersion;
        this.f8328b = cipherSuite;
        this.f8329c = list;
        this.f8330d = list2;
    }

    /* renamed from: a */
    public static Handshake m2769a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            CipherSuite m3177a = CipherSuite.m3177a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                TlsVersion m3179a = TlsVersion.m3179a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    emptyList = Util.m3156a(certificateArr);
                } else {
                    emptyList = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    emptyList2 = Util.m3156a(localCertificates);
                } else {
                    emptyList2 = Collections.emptyList();
                }
                return new Handshake(m3179a, m3177a, emptyList, emptyList2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    /* renamed from: b */
    public List<Certificate> m2768b() {
        return this.f8329c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            return this.f8327a.equals(handshake.f8327a) && this.f8328b.equals(handshake.f8328b) && this.f8329c.equals(handshake.f8329c) && this.f8330d.equals(handshake.f8330d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f8327a.hashCode()) * 31) + this.f8328b.hashCode()) * 31) + this.f8329c.hashCode()) * 31) + this.f8330d.hashCode();
    }

    /* renamed from: a */
    public CipherSuite m2770a() {
        return this.f8328b;
    }
}
