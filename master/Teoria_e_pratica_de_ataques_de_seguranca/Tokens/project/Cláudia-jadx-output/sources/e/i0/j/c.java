package e.i0.j;

import e.z;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* compiled from: JdkWithJettyBootPlatform.java */
/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: c  reason: collision with root package name */
    public final Method f5829c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f5830d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f5831e;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f5832f;

    /* renamed from: g  reason: collision with root package name */
    public final Class<?> f5833g;

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* loaded from: classes.dex */
    public static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f5834a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5835b;

        /* renamed from: c  reason: collision with root package name */
        public String f5836c;

        public a(List<String> list) {
            this.f5834a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = e.i0.c.f5563b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f5835b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f5834a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f5834a.contains(list.get(i2))) {
                            String str = (String) list.get(i2);
                            this.f5836c = str;
                            return str;
                        }
                    }
                    String str2 = this.f5834a.get(0);
                    this.f5836c = str2;
                    return str2;
                } else if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                    this.f5836c = (String) objArr[0];
                    return null;
                } else {
                    return method.invoke(this, objArr);
                }
            }
        }
    }

    public c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f5829c = method;
        this.f5830d = method2;
        this.f5831e = method3;
        this.f5832f = cls;
        this.f5833g = cls2;
    }

    public static e c() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), cls3, Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // e.i0.j.e
    public void a(SSLSocket sSLSocket, String str, List<z> list) {
        try {
            this.f5829c.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f5832f, this.f5833g}, new a(e.a(list))));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // e.i0.j.e
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f5830d.invoke(null, sSLSocket));
            if (!aVar.f5835b && aVar.f5836c == null) {
                e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (aVar.f5835b) {
                return null;
            } else {
                return aVar.f5836c;
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }

    @Override // e.i0.j.e
    public void a(SSLSocket sSLSocket) {
        try {
            this.f5831e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            throw new AssertionError();
        }
    }
}
