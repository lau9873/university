package p070c.p071a.p072a.p073o;

import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import p070c.p071a.p072a.Header;
import p070c.p071a.p072a.Request;

/* renamed from: c.a.a.o.j */
/* loaded from: classes.dex */
public class HurlStack extends BaseHttpStack {

    /* renamed from: a */
    public final InterfaceC0798b f4637a;

    /* renamed from: b */
    public final SSLSocketFactory f4638b;

    /* compiled from: HurlStack.java */
    /* renamed from: c.a.a.o.j$a */
    /* loaded from: classes.dex */
    public static class C0797a extends FilterInputStream {

        /* renamed from: a */
        public final HttpURLConnection f4639a;

        public C0797a(HttpURLConnection httpURLConnection) {
            super(HurlStack.m6101b(httpURLConnection));
            this.f4639a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.f4639a.disconnect();
        }
    }

    /* compiled from: HurlStack.java */
    /* renamed from: c.a.a.o.j$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0798b {
        /* renamed from: a */
        String m6099a(String str);
    }

    public HurlStack() {
        this(null);
    }

    /* renamed from: a */
    public static boolean m6109a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    @Override // p070c.p071a.p072a.p073o.BaseHttpStack
    /* renamed from: b */
    public HttpResponse mo6102b(Request<?> request, Map<String, String> map) {
        String str;
        String m6194r = request.m6194r();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(request.m6203g());
        InterfaceC0798b interfaceC0798b = this.f4637a;
        if (interfaceC0798b != null) {
            str = interfaceC0798b.m6099a(m6194r);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + m6194r);
            }
        } else {
            str = m6194r;
        }
        HttpURLConnection m6104a = m6104a(new URL(str), request);
        try {
            for (String str2 : hashMap.keySet()) {
                m6104a.setRequestProperty(str2, (String) hashMap.get(str2));
            }
            m6100b(m6104a, request);
            int responseCode = m6104a.getResponseCode();
            if (responseCode != -1) {
                if (!m6109a(request.m6202h(), responseCode)) {
                    HttpResponse httpResponse = new HttpResponse(responseCode, m6103a(m6104a.getHeaderFields()));
                    m6104a.disconnect();
                    return httpResponse;
                }
                return new HttpResponse(responseCode, m6103a(m6104a.getHeaderFields()), m6104a.getContentLength(), new C0797a(m6104a));
            }
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } catch (Throwable th) {
            if (0 == 0) {
                m6104a.disconnect();
            }
            throw th;
        }
    }

    public HurlStack(InterfaceC0798b interfaceC0798b) {
        this(interfaceC0798b, null);
    }

    /* renamed from: a */
    public static List<Header> m6103a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new Header(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    public HurlStack(InterfaceC0798b interfaceC0798b, SSLSocketFactory sSLSocketFactory) {
        this.f4637a = interfaceC0798b;
        this.f4638b = sSLSocketFactory;
    }

    /* renamed from: a */
    public HttpURLConnection m6105a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    /* renamed from: a */
    public final HttpURLConnection m6104a(URL url, Request<?> request) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection m6105a = m6105a(url);
        int m6196p = request.m6196p();
        m6105a.setConnectTimeout(m6196p);
        m6105a.setReadTimeout(m6196p);
        m6105a.setUseCaches(false);
        m6105a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f4638b) != null) {
            ((HttpsURLConnection) m6105a).setSSLSocketFactory(sSLSocketFactory);
        }
        return m6105a;
    }

    /* renamed from: a */
    public static void m6107a(HttpURLConnection httpURLConnection, Request<?> request) {
        byte[] mo6095c = request.mo6095c();
        if (mo6095c != null) {
            m6106a(httpURLConnection, request, mo6095c);
        }
    }

    /* renamed from: a */
    public static void m6106a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.mo6094d());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    /* renamed from: b */
    public static InputStream m6101b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    /* renamed from: b */
    public static void m6100b(HttpURLConnection httpURLConnection, Request<?> request) {
        switch (request.m6202h()) {
            case -1:
                byte[] mo6093k = request.mo6093k();
                if (mo6093k != null) {
                    httpURLConnection.setRequestMethod("POST");
                    m6106a(httpURLConnection, request, mo6093k);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                m6107a(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                m6107a(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                m6107a(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
