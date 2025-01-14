package e.i0.j;

import e.z;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
/* compiled from: Jdk9Platform.java */
/* loaded from: classes.dex */
public final class b extends e {

    /* renamed from: c  reason: collision with root package name */
    public final Method f5827c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f5828d;

    public b(Method method, Method method2) {
        this.f5827c = method;
        this.f5828d = method2;
    }

    public static b c() {
        try {
            return new b(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // e.i0.j.e
    public void a(SSLSocket sSLSocket, String str, List<z> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = e.a(list);
            this.f5827c.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    @Override // e.i0.j.e
    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f5828d.invoke(sSLSocket, new Object[0]);
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
