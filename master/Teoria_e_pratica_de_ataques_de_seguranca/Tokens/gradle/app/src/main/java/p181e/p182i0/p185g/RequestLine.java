package p181e.p182i0.p185g;

import java.net.Proxy;
import p181e.C1737b0;
import p181e.HttpUrl;

/* renamed from: e.i0.g.i */
/* loaded from: classes.dex */
public final class RequestLine {
    /* renamed from: a */
    public static String m3057a(C1737b0 c1737b0, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(c1737b0.m3256e());
        sb.append(' ');
        if (m3055b(c1737b0, type)) {
            sb.append(c1737b0.m3254g());
        } else {
            sb.append(m3056a(c1737b0.m3254g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m3055b(C1737b0 c1737b0, Proxy.Type type) {
        return !c1737b0.m3257d() && type == Proxy.Type.HTTP;
    }

    /* renamed from: a */
    public static String m3056a(HttpUrl httpUrl) {
        String m2737c = httpUrl.m2737c();
        String m2733e = httpUrl.m2733e();
        if (m2733e != null) {
            return m2737c + '?' + m2733e;
        }
        return m2737c;
    }
}
