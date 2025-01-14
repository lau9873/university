package p181e.p182i0.p188j;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import p181e.OkHttpClient;
import p181e.Protocol;
import p181e.p182i0.p190l.AbstractC1795b;
import p181e.p182i0.p190l.BasicCertificateChainCleaner;
import p181e.p182i0.p190l.TrustRootIndex;
import p192f.Buffer;

/* renamed from: e.i0.j.e */
/* loaded from: classes.dex */
public class Platform {

    /* renamed from: a */
    public static final Platform f8248a = m2862a();

    /* renamed from: b */
    public static final Logger f8249b = Logger.getLogger(OkHttpClient.class.getName());

    /* renamed from: b */
    public static Platform m2853b() {
        return f8248a;
    }

    /* renamed from: a */
    public void mo2858a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo2856a(SSLSocket sSLSocket) {
    }

    /* renamed from: a */
    public void mo2855a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    /* renamed from: b */
    public String mo2850b(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: b */
    public boolean mo2852b(String str) {
        return true;
    }

    /* renamed from: b */
    public static byte[] m2851b(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.mo2573a(protocol.toString());
            }
        }
        return buffer.m2609o();
    }

    /* renamed from: a */
    public void mo2861a(int i, String str, Throwable th) {
        f8249b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public Object mo2860a(String str) {
        if (f8249b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo2859a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo2861a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public static List<String> m2857a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public AbstractC1795b mo2854a(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(TrustRootIndex.m2827a(x509TrustManager));
    }

    /* renamed from: a */
    public static Platform m2862a() {
        Platform m2875c = AndroidPlatform.m2875c();
        if (m2875c != null) {
            return m2875c;
        }
        Jdk9Platform m2871c = Jdk9Platform.m2871c();
        if (m2871c != null) {
            return m2871c;
        }
        Platform m2870c = JdkWithJettyBootPlatform.m2870c();
        return m2870c != null ? m2870c : new Platform();
    }
}
