package p181e.p182i0.p190l;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import p181e.p182i0.Util;

/* renamed from: e.i0.l.d */
/* loaded from: classes.dex */
public final class OkHostnameVerifier implements HostnameVerifier {

    /* renamed from: a */
    public static final OkHostnameVerifier f8266a = new OkHostnameVerifier();

    /* renamed from: a */
    public boolean m2832a(String str, X509Certificate x509Certificate) {
        if (Util.m3148d(str)) {
            return m2828c(str, x509Certificate);
        }
        return m2829b(str, x509Certificate);
    }

    /* renamed from: b */
    public final boolean m2829b(String str, X509Certificate x509Certificate) {
        String m2839a;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> m2830a = m2830a(x509Certificate, 2);
        int size = m2830a.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (m2833a(lowerCase, m2830a.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (m2839a = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).m2839a("cn")) == null) {
            return false;
        }
        return m2833a(lowerCase, m2839a);
    }

    /* renamed from: c */
    public final boolean m2828c(String str, X509Certificate x509Certificate) {
        List<String> m2830a = m2830a(x509Certificate, 7);
        int size = m2830a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(m2830a.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m2832a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static List<String> m2831a(X509Certificate x509Certificate) {
        List<String> m2830a = m2830a(x509Certificate, 7);
        List<String> m2830a2 = m2830a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(m2830a.size() + m2830a2.size());
        arrayList.addAll(m2830a);
        arrayList.addAll(m2830a2);
        return arrayList;
    }

    /* renamed from: a */
    public static List<String> m2830a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public boolean m2833a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (str.endsWith(substring)) {
                int length = str.length() - substring.length();
                return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
            }
            return false;
        }
        return false;
    }
}
