package p070c.p071a.p072a.p073o;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;
import p070c.p071a.p072a.Request;

/* renamed from: c.a.a.o.a */
/* loaded from: classes.dex */
public class AdaptedHttpStack extends BaseHttpStack {

    /* renamed from: a */
    public final HttpStack f4609a;

    public AdaptedHttpStack(HttpStack httpStack) {
        this.f4609a = httpStack;
    }

    @Override // p070c.p071a.p072a.p073o.BaseHttpStack
    /* renamed from: b */
    public HttpResponse mo6102b(Request<?> request, Map<String, String> map) {
        try {
            HttpResponse mo6110a = this.f4609a.mo6110a(request, map);
            int statusCode = mo6110a.getStatusLine().getStatusCode();
            Header[] allHeaders = mo6110a.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new p070c.p071a.p072a.Header(header.getName(), header.getValue()));
            }
            if (mo6110a.getEntity() == null) {
                return new HttpResponse(statusCode, arrayList);
            }
            long contentLength = mo6110a.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new HttpResponse(statusCode, arrayList, (int) mo6110a.getEntity().getContentLength(), mo6110a.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
