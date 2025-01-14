package c.a.a.o;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
/* compiled from: BaseHttpStack.java */
/* loaded from: classes.dex */
public abstract class b implements i {
    @Override // c.a.a.o.i
    @Deprecated
    public final HttpResponse a(c.a.a.i<?> iVar, Map<String, String> map) {
        h b2 = b(iVar, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), b2.d(), ""));
        ArrayList arrayList = new ArrayList();
        for (c.a.a.e eVar : b2.c()) {
            arrayList.add(new BasicHeader(eVar.a(), eVar.b()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream a2 = b2.a();
        if (a2 != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(a2);
            basicHttpEntity.setContentLength(b2.b());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }

    public abstract h b(c.a.a.i<?> iVar, Map<String, String> map);
}
