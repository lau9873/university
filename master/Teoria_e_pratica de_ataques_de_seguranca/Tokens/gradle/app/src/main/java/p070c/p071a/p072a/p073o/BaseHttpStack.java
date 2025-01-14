package p070c.p071a.p072a.p073o;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import p070c.p071a.p072a.Header;
import p070c.p071a.p072a.Request;

/* renamed from: c.a.a.o.b */
/* loaded from: classes.dex */
public abstract class BaseHttpStack implements HttpStack {
    @Override // p070c.p071a.p072a.p073o.HttpStack
    @Deprecated
    /* renamed from: a */
    public final HttpResponse mo6110a(Request<?> request, Map<String, String> map) {
        HttpResponse mo6102b = mo6102b(request, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), mo6102b.m6111d(), ""));
        ArrayList arrayList = new ArrayList();
        for (Header header : mo6102b.m6112c()) {
            arrayList.add(new BasicHeader(header.m6229a(), header.m6228b()));
        }
        basicHttpResponse.setHeaders((org.apache.http.Header[]) arrayList.toArray(new org.apache.http.Header[arrayList.size()]));
        InputStream m6114a = mo6102b.m6114a();
        if (m6114a != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(m6114a);
            basicHttpEntity.setContentLength(mo6102b.m6113b());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }

    /* renamed from: b */
    public abstract HttpResponse mo6102b(Request<?> request, Map<String, String> map);
}
