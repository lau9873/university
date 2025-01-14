package e;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
/* compiled from: CertificatePinner.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final g f5536c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    public final Set<b> f5537a;

    /* renamed from: b  reason: collision with root package name */
    public final e.i0.l.b f5538b;

    /* compiled from: CertificatePinner.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<b> f5539a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f5539a), null);
        }
    }

    /* compiled from: CertificatePinner.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f5540a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5541b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5542c;

        /* renamed from: d  reason: collision with root package name */
        public final f.f f5543d;

        public boolean a(String str) {
            if (this.f5540a.startsWith("*.")) {
                String str2 = this.f5541b;
                return str.regionMatches(false, str.indexOf(46) + 1, str2, 0, str2.length());
            }
            return str.equals(this.f5541b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f5540a.equals(bVar.f5540a) && this.f5542c.equals(bVar.f5542c) && this.f5543d.equals(bVar.f5543d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f5540a.hashCode()) * 31) + this.f5542c.hashCode()) * 31) + this.f5543d.hashCode();
        }

        public String toString() {
            return this.f5542c + this.f5543d.b();
        }
    }

    public g(Set<b> set, e.i0.l.b bVar) {
        this.f5537a = set;
        this.f5538b = bVar;
    }

    public static f.f b(X509Certificate x509Certificate) {
        return f.f.a(x509Certificate.getPublicKey().getEncoded()).e();
    }

    public void a(String str, List<Certificate> list) {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        e.i0.l.b bVar = this.f5538b;
        if (bVar != null) {
            list = bVar.a(list, str);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            int size2 = a2.size();
            f.f fVar = null;
            f.f fVar2 = null;
            for (int i3 = 0; i3 < size2; i3++) {
                b bVar2 = a2.get(i3);
                if (bVar2.f5542c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = b(x509Certificate);
                    }
                    if (bVar2.f5543d.equals(fVar)) {
                        return;
                    }
                } else if (bVar2.f5542c.equals("sha1/")) {
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar2.f5543d.equals(fVar2)) {
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
        for (int i4 = 0; i4 < size3; i4++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = a2.size();
        for (int i5 = 0; i5 < size4; i5++) {
            sb.append("\n    ");
            sb.append(a2.get(i5));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (e.i0.c.a(this.f5538b, gVar.f5538b) && this.f5537a.equals(gVar.f5537a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        e.i0.l.b bVar = this.f5538b;
        return ((bVar != null ? bVar.hashCode() : 0) * 31) + this.f5537a.hashCode();
    }

    public List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f5537a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public g a(e.i0.l.b bVar) {
        return e.i0.c.a(this.f5538b, bVar) ? this : new g(this.f5537a, bVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static f.f a(X509Certificate x509Certificate) {
        return f.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }
}
