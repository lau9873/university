package p181e.p182i0.p188j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p181e.Protocol;
import p181e.p182i0.Util;

/* renamed from: e.i0.j.c */
/* loaded from: classes.dex */
public class JdkWithJettyBootPlatform extends Platform {

    /* renamed from: c */
    public final Method f8237c;

    /* renamed from: d */
    public final Method f8238d;

    /* renamed from: e */
    public final Method f8239e;

    /* renamed from: f */
    public final Class<?> f8240f;

    /* renamed from: g */
    public final Class<?> f8241g;

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* renamed from: e.i0.j.c$a */
    /* loaded from: classes.dex */
    public static class C1794a implements InvocationHandler {

        /* renamed from: a */
        public final List<String> f8242a;

        /* renamed from: b */
        public boolean f8243b;

        /* renamed from: c */
        public String f8244c;

        public C1794a(List<String> list) {
            this.f8242a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.f7935b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f8243b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f8242a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f8242a.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.f8244c = str;
                            return str;
                        }
                    }
                    String str2 = this.f8242a.get(0);
                    this.f8244c = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f8244c = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }

    public JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f8237c = method;
        this.f8238d = method2;
        this.f8239e = method3;
        this.f8240f = cls;
        this.f8241g = cls2;
    }

    /* renamed from: c */
    public static Platform m2870c() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new JdkWithJettyBootPlatform(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public void mo2855a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        try {
            this.f8237c.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.f8240f, this.f8241g}, new C1794a(Platform.m2857a(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: b */
    public String mo2850b(SSLSocket sSLSocket) {
        try {
            C1794a c1794a = (C1794a) Proxy.getInvocationHandler(this.f8238d.invoke(null, sSLSocket));
            if (!c1794a.f8243b && c1794a.f8244c == null) {
                Platform.m2853b().mo2861a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (c1794a.f8243b) {
                return null;
            } else {
                return c1794a.f8244c;
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public void mo2856a(SSLSocket sSLSocket) {
        try {
            this.f8239e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }
}
