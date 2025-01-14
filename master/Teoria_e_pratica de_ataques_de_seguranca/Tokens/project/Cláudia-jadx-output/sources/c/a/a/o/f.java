package c.a.a.o;

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
/* compiled from: HttpClientStack.java */
@Deprecated
/* loaded from: classes.dex */
public class f implements i {

    /* renamed from: a  reason: collision with root package name */
    public final HttpClient f2835a;

    /* compiled from: HttpClientStack.java */
    /* loaded from: classes.dex */
    public static final class a extends HttpEntityEnclosingRequestBase {
        public a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public f(HttpClient httpClient) {
        this.f2835a = httpClient;
    }

    public static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    public static HttpUriRequest b(c.a.a.i<?> iVar, Map<String, String> map) {
        switch (iVar.h()) {
            case -1:
                byte[] k = iVar.k();
                if (k != null) {
                    HttpPost httpPost = new HttpPost(iVar.r());
                    httpPost.addHeader("Content-Type", iVar.l());
                    httpPost.setEntity(new ByteArrayEntity(k));
                    return httpPost;
                }
                return new HttpGet(iVar.r());
            case 0:
                return new HttpGet(iVar.r());
            case 1:
                HttpPost httpPost2 = new HttpPost(iVar.r());
                httpPost2.addHeader("Content-Type", iVar.d());
                a((HttpEntityEnclosingRequestBase) httpPost2, iVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(iVar.r());
                httpPut.addHeader("Content-Type", iVar.d());
                a((HttpEntityEnclosingRequestBase) httpPut, iVar);
                return httpPut;
            case 3:
                return new HttpDelete(iVar.r());
            case 4:
                return new HttpHead(iVar.r());
            case 5:
                return new HttpOptions(iVar.r());
            case 6:
                return new HttpTrace(iVar.r());
            case 7:
                a aVar = new a(iVar.r());
                aVar.addHeader("Content-Type", iVar.d());
                a(aVar, iVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    public void a(HttpUriRequest httpUriRequest) {
    }

    @Override // c.a.a.o.i
    public HttpResponse a(c.a.a.i<?> iVar, Map<String, String> map) {
        HttpUriRequest b2 = b(iVar, map);
        a(b2, map);
        a(b2, iVar.g());
        a(b2);
        HttpParams params = b2.getParams();
        int p = iVar.p();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, p);
        return this.f2835a.execute(b2);
    }

    public static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, c.a.a.i<?> iVar) {
        byte[] c2 = iVar.c();
        if (c2 != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(c2));
        }
    }
}
