package p181e;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import p181e.p182i0.Util;
import p181e.p182i0.p190l.AbstractC1795b;
import p192f.C1822f;

/* renamed from: e.g */
/* loaded from: classes.dex */
public final class CertificatePinner {

    /* renamed from: c */
    public static final CertificatePinner f7899c = new C1749a().m3181a();

    /* renamed from: a */
    public final Set<C1750b> f7900a;

    /* renamed from: b */
    public final AbstractC1795b f7901b;

    /* compiled from: CertificatePinner.java */
    /* renamed from: e.g$a */
    /* loaded from: classes.dex */
    public static final class C1749a {

        /* renamed from: a */
        public final List<C1750b> f7902a = new ArrayList();

        /* renamed from: a */
        public CertificatePinner m3181a() {
            return new CertificatePinner(new LinkedHashSet(this.f7902a), null);
        }
    }

    /* compiled from: CertificatePinner.java */
    /* renamed from: e.g$b */
    /* loaded from: classes.dex */
    public static final class C1750b {

        /* renamed from: a */
        public final String f7903a;

        /* renamed from: b */
        public final String f7904b;

        /* renamed from: c */
        public final String f7905c;

        /* renamed from: d */
        public final C1822f f7906d;

        /* renamed from: a */
        public boolean m3180a(String str) {
            if (this.f7903a.startsWith("*.")) {
                String str2 = this.f7904b;
                return str.regionMatches(false, str.indexOf(46) + 1, str2, 0, str2.length());
            }
            return str.equals(this.f7904b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1750b) {
                C1750b c1750b = (C1750b) obj;
                if (this.f7903a.equals(c1750b.f7903a) && this.f7905c.equals(c1750b.f7905c) && this.f7906d.equals(c1750b.f7906d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f7903a.hashCode()) * 31) + this.f7905c.hashCode()) * 31) + this.f7906d.hashCode();
        }

        public String toString() {
            return this.f7905c + this.f7906d.mo2540b();
        }
    }

    public CertificatePinner(Set<C1750b> set, AbstractC1795b abstractC1795b) {
        this.f7900a = set;
        this.f7901b = abstractC1795b;
    }

    /* renamed from: b */
    public static C1822f m3182b(X509Certificate x509Certificate) {
        return C1822f.m2599a(x509Certificate.getPublicKey().getEncoded()).mo2536e();
    }

    /* renamed from: a */
    public void m3185a(String str, List<Certificate> list) {
        List<C1750b> m3186a = m3186a(str);
        if (m3186a.isEmpty()) {
            return;
        }
        AbstractC1795b abstractC1795b = this.f7901b;
        if (abstractC1795b != null) {
            list = abstractC1795b.mo2843a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = m3186a.size();
            C1822f c1822f = null;
            C1822f c1822f2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                C1750b c1750b = m3186a.get(i2);
                if (c1750b.f7905c.equals("sha256/")) {
                    if (c1822f == null) {
                        c1822f = m3182b(x509Certificate);
                    }
                    if (c1750b.f7906d.equals(c1822f)) {
                        return;
                    }
                } else if (c1750b.f7905c.equals("sha1/")) {
                    if (c1822f2 == null) {
                        c1822f2 = m3183a(x509Certificate);
                    }
                    if (c1750b.f7906d.equals(c1822f2)) {
                        return;
                    }
                } else {
                    throw new AssertionError();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(m3184a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = m3186a.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ");
            sb.append(m3186a.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Util.m3167a(this.f7901b, certificatePinner.f7901b) && this.f7900a.equals(certificatePinner.f7900a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC1795b abstractC1795b = this.f7901b;
        return ((abstractC1795b != null ? abstractC1795b.hashCode() : 0) * 31) + this.f7900a.hashCode();
    }

    /* renamed from: a */
    public List<C1750b> m3186a(String str) {
        List<C1750b> emptyList = Collections.emptyList();
        for (C1750b c1750b : this.f7900a) {
            if (c1750b.m3180a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(c1750b);
            }
        }
        return emptyList;
    }

    /* renamed from: a */
    public CertificatePinner m3187a(AbstractC1795b abstractC1795b) {
        return Util.m3167a(this.f7901b, abstractC1795b) ? this : new CertificatePinner(this.f7900a, abstractC1795b);
    }

    /* renamed from: a */
    public static String m3184a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + m3182b((X509Certificate) certificate).mo2540b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    public static C1822f m3183a(X509Certificate x509Certificate) {
        return C1822f.m2599a(x509Certificate.getPublicKey().getEncoded()).mo2537d();
    }
}
