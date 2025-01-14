package e;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* compiled from: Handshake.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final g0 f5915a;

    /* renamed from: b  reason: collision with root package name */
    public final h f5916b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Certificate> f5917c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Certificate> f5918d;

    public s(g0 g0Var, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f5915a = g0Var;
        this.f5916b = hVar;
        this.f5917c = list;
        this.f5918d = list2;
    }

    public static s a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            h a2 = h.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                g0 a3 = g0.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    emptyList = e.i0.c.a(certificateArr);
                } else {
                    emptyList = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    emptyList2 = e.i0.c.a(localCertificates);
                } else {
                    emptyList2 = Collections.emptyList();
                }
                return new s(a3, a2, emptyList, emptyList2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public List<Certificate> b() {
        return this.f5917c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            return this.f5915a.equals(sVar.f5915a) && this.f5916b.equals(sVar.f5916b) && this.f5917c.equals(sVar.f5917c) && this.f5918d.equals(sVar.f5918d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f5915a.hashCode()) * 31) + this.f5916b.hashCode()) * 31) + this.f5917c.hashCode()) * 31) + this.f5918d.hashCode();
    }

    public h a() {
        return this.f5916b;
    }
}
