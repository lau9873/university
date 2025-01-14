package p181e.p182i0.p185g;

import java.util.List;
import java.util.regex.Pattern;
import p181e.C1744d0;
import p181e.Cookie;
import p181e.CookieJar;
import p181e.Headers;
import p181e.HttpUrl;

/* renamed from: e.i0.g.e */
/* loaded from: classes.dex */
public final class HttpHeaders {
    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    /* renamed from: a */
    public static long m3073a(C1744d0 c1744d0) {
        return m3071a(c1744d0.m3221n());
    }

    /* renamed from: b */
    public static boolean m3067b(C1744d0 c1744d0) {
        if (c1744d0.m3216s().m3256e().equals("HEAD")) {
            return false;
        }
        int m3223l = c1744d0.m3223l();
        return (((m3223l >= 100 && m3223l < 200) || m3223l == 204 || m3223l == 304) && m3073a(c1744d0) == -1 && !"chunked".equalsIgnoreCase(c1744d0.m3226b("Transfer-Encoding"))) ? false : true;
    }

    /* renamed from: a */
    public static long m3071a(Headers headers) {
        return m3070a(headers.m2765a("Content-Length"));
    }

    /* renamed from: a */
    public static long m3070a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* renamed from: a */
    public static void m3072a(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.f8311a) {
            return;
        }
        List<Cookie> m2799a = Cookie.m2799a(httpUrl, headers);
        if (m2799a.isEmpty()) {
            return;
        }
        cookieJar.mo2789a(httpUrl, m2799a);
    }

    /* renamed from: b */
    public static int m3066b(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m3068a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m3069a(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
