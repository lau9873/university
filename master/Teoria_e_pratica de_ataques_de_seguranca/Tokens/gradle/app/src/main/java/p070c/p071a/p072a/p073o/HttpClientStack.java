package p070c.p071a.p072a.p073o;

import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import p070c.p071a.p072a.Request;

@Deprecated
/* renamed from: c.a.a.o.f */
/* loaded from: classes.dex */
public class HttpClientStack implements HttpStack {

    /* renamed from: a */
    public final HttpClient f4632a;

    /* compiled from: HttpClientStack.java */
    /* renamed from: c.a.a.o.f$a */
    /* loaded from: classes.dex */
    public static final class C0796a extends HttpEntityEnclosingRequestBase {
        public C0796a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public HttpClientStack(HttpClient httpClient) {
        this.f4632a = httpClient;
    }

    /* renamed from: a */
    public static void m6123a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    /* renamed from: b */
    public static HttpUriRequest m6122b(Request<?> request, Map<String, String> map) {
        switch (request.m6202h()) {
            case -1:
                byte[] mo6093k = request.mo6093k();
                if (mo6093k != null) {
                    HttpPost httpPost = new HttpPost(request.m6194r());
                    httpPost.addHeader("Content-Type", request.mo6092l());
                    httpPost.setEntity(new ByteArrayEntity(mo6093k));
                    return httpPost;
                }
                return new HttpGet(request.m6194r());
            case 0:
                return new HttpGet(request.m6194r());
            case 1:
                HttpPost httpPost2 = new HttpPost(request.m6194r());
                httpPost2.addHeader("Content-Type", request.mo6094d());
                m6125a((HttpEntityEnclosingRequestBase) httpPost2, request);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(request.m6194r());
                httpPut.addHeader("Content-Type", request.mo6094d());
                m6125a((HttpEntityEnclosingRequestBase) httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.m6194r());
            case 4:
                return new HttpHead(request.m6194r());
            case 5:
                return new HttpOptions(request.m6194r());
            case 6:
                return new HttpTrace(request.m6194r());
            case 7:
                C0796a c0796a = new C0796a(request.m6194r());
                c0796a.addHeader("Content-Type", request.mo6094d());
                m6125a(c0796a, request);
                return c0796a;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    /* renamed from: a */
    public void m6124a(HttpUriRequest httpUriRequest) {
    }

    @Override // p070c.p071a.p072a.p073o.HttpStack
    /* renamed from: a */
    public HttpResponse mo6110a(Request<?> request, Map<String, String> map) {
        HttpUriRequest m6122b = m6122b(request, map);
        m6123a(m6122b, map);
        m6123a(m6122b, request.m6203g());
        m6124a(m6122b);
        HttpParams params = m6122b.getParams();
        int m6196p = request.m6196p();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, m6196p);
        return this.f4632a.execute(m6122b);
    }

    /* renamed from: a */
    public static void m6125a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) {
        byte[] mo6095c = request.mo6095c();
        if (mo6095c != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(mo6095c));
        }
    }
}
