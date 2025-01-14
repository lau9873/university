package p181e.p182i0.p188j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import p181e.Protocol;

/* renamed from: e.i0.j.b */
/* loaded from: classes.dex */
public final class Jdk9Platform extends Platform {

    /* renamed from: c */
    public final Method f8235c;

    /* renamed from: d */
    public final Method f8236d;

    public Jdk9Platform(Method method, Method method2) {
        this.f8235c = method;
        this.f8236d = method2;
    }

    /* renamed from: c */
    public static Jdk9Platform m2871c() {
        try {
            return new Jdk9Platform(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public void mo2855a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> m2857a = Platform.m2857a(list);
            this.f8235c.invoke(sSLParameters, m2857a.toArray(new String[m2857a.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: b */
    public String mo2850b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f8236d.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (str.equals("")) {
                    return null;
                }
                return str;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }
}
