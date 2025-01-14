package e.i0.j;

import e.y;
import e.z;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f5840a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f5841b = Logger.getLogger(y.class.getName());

    public static e b() {
        return f5840a;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) {
        socket.connect(inetSocketAddress, i2);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<z> list) {
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    public static byte[] b(List<z> list) {
        f.c cVar = new f.c();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            z zVar = list.get(i2);
            if (zVar != z.HTTP_1_0) {
                cVar.writeByte(zVar.toString().length());
                cVar.a(zVar.toString());
            }
        }
        return cVar.o();
    }

    public void a(int i2, String str, Throwable th) {
        f5841b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f5841b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<z> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            z zVar = list.get(i2);
            if (zVar != z.HTTP_1_0) {
                arrayList.add(zVar.toString());
            }
        }
        return arrayList;
    }

    public e.i0.l.b a(X509TrustManager x509TrustManager) {
        return new e.i0.l.a(e.i0.l.e.a(x509TrustManager));
    }

    public static e a() {
        e c2 = a.c();
        if (c2 != null) {
            return c2;
        }
        b c3 = b.c();
        if (c3 != null) {
            return c3;
        }
        e c4 = c.c();
        return c4 != null ? c4 : new e();
    }
}
