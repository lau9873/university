package p181e.p182i0.p185g;

import java.util.List;
import p181e.C1737b0;
import p181e.C1744d0;
import p181e.Cookie;
import p181e.CookieJar;
import p181e.Headers;
import p181e.Interceptor;
import p181e.MediaType;
import p181e.RequestBody;
import p181e.p182i0.Util;
import p181e.p182i0.Version;
import p192f.GzipSource;
import p192f.Okio;

/* renamed from: e.i0.g.a */
/* loaded from: classes.dex */
public final class BridgeInterceptor implements Interceptor {

    /* renamed from: a */
    public final CookieJar f8011a;

    public BridgeInterceptor(CookieJar cookieJar) {
        this.f8011a = cookieJar;
    }

    /* renamed from: a */
    public final String m3076a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.m2801a());
            sb.append('=');
            sb.append(cookie.m2792b());
        }
        return sb.toString();
    }

    @Override // p181e.Interceptor
    public C1744d0 intercept(Interceptor.InterfaceC1812a interfaceC1812a) {
        C1737b0 mo2696a = interfaceC1812a.mo2696a();
        C1737b0.C1738a m3255f = mo2696a.m3255f();
        RequestBody m3261a = mo2696a.m3261a();
        if (m3261a != null) {
            MediaType mo643b = m3261a.mo643b();
            if (mo643b != null) {
                m3255f.m3247b("Content-Type", mo643b.toString());
            }
            long mo645a = m3261a.mo645a();
            if (mo645a != -1) {
                m3255f.m3247b("Content-Length", Long.toString(mo645a));
                m3255f.m3250a("Transfer-Encoding");
            } else {
                m3255f.m3247b("Transfer-Encoding", "chunked");
                m3255f.m3250a("Content-Length");
            }
        }
        boolean z = false;
        if (mo2696a.m3260a("Host") == null) {
            m3255f.m3247b("Host", Util.m3172a(mo2696a.m3254g(), false));
        }
        if (mo2696a.m3260a("Connection") == null) {
            m3255f.m3247b("Connection", "Keep-Alive");
        }
        if (mo2696a.m3260a("Accept-Encoding") == null && mo2696a.m3260a("Range") == null) {
            z = true;
            m3255f.m3247b("Accept-Encoding", "gzip");
        }
        List<Cookie> mo2790a = this.f8011a.mo2790a(mo2696a.m3254g());
        if (!mo2790a.isEmpty()) {
            m3255f.m3247b("Cookie", m3076a(mo2790a));
        }
        if (mo2696a.m3260a("User-Agent") == null) {
            m3255f.m3247b("User-Agent", Version.m3146a());
        }
        C1744d0 mo2695a = interfaceC1812a.mo2695a(m3255f.m3253a());
        HttpHeaders.m3072a(this.f8011a, mo2696a.m3254g(), mo2695a.m3221n());
        C1744d0.C1745a m3218q = mo2695a.m3218q();
        m3218q.m3211a(mo2696a);
        if (z && "gzip".equalsIgnoreCase(mo2695a.m3226b("Content-Encoding")) && HttpHeaders.m3067b(mo2695a)) {
            GzipSource gzipSource = new GzipSource(mo2695a.m3225j().mo670n());
            Headers.C1809a m2767a = mo2695a.m3221n().m2767a();
            m2767a.m2756b("Content-Encoding");
            m2767a.m2756b("Content-Length");
            Headers m2759a = m2767a.m2759a();
            m3218q.m3207a(m2759a);
            m3218q.m3209a(new RealResponseBody(m2759a, Okio.m2586a(gzipSource)));
        }
        return m3218q.m3214a();
    }
}
