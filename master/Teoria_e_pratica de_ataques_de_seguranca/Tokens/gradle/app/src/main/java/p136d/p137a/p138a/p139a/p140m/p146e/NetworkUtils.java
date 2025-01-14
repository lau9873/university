package p136d.p137a.p138a.p139a.p140m.p146e;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: d.a.a.a.m.e.e */
/* loaded from: classes.dex */
public final class NetworkUtils {
    /* renamed from: a */
    public static final SSLSocketFactory m3918a(InterfaceC1521f interfaceC1521f) {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new TrustManager[]{new PinningTrustManager(new SystemKeyStore(interfaceC1521f.mo3916b(), interfaceC1521f.mo3917a()), interfaceC1521f)}, null);
        return sSLContext.getSocketFactory();
    }
}
