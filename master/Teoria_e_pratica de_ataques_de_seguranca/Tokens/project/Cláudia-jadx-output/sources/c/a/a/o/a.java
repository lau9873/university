package c.a.a.o;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;
/* compiled from: AdaptedHttpStack.java */
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public final i f2812a;

    public a(i iVar) {
        this.f2812a = iVar;
    }

    @Override // c.a.a.o.b
    public h b(c.a.a.i<?> iVar, Map<String, String> map) {
        try {
            HttpResponse a2 = this.f2812a.a(iVar, map);
            int statusCode = a2.getStatusLine().getStatusCode();
            Header[] allHeaders = a2.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new c.a.a.e(header.getName(), header.getValue()));
            }
            if (a2.getEntity() == null) {
                return new h(statusCode, arrayList);
            }
            long contentLength = a2.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new h(statusCode, arrayList, (int) a2.getEntity().getContentLength(), a2.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e2) {
            throw new SocketTimeoutException(e2.getMessage());
        }
    }
}
