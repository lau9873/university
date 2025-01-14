package d.a.a.a.m.e;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
/* compiled from: NetworkUtils.java */
/* loaded from: classes.dex */
public final class e {
    public static final SSLSocketFactory a(f fVar) {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{new g(new h(fVar.b(), fVar.a()), fVar)}, null);
        return sSLContext.getSocketFactory();
    }
}
