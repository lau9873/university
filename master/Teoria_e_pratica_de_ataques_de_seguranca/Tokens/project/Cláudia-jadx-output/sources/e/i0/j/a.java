package e.i0.j;

import android.util.Log;
import e.z;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* compiled from: AndroidPlatform.java */
/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: c  reason: collision with root package name */
    public final d<Socket> f5817c;

    /* renamed from: d  reason: collision with root package name */
    public final d<Socket> f5818d;

    /* renamed from: e  reason: collision with root package name */
    public final d<Socket> f5819e;

    /* renamed from: f  reason: collision with root package name */
    public final d<Socket> f5820f;

    /* renamed from: g  reason: collision with root package name */
    public final b f5821g = b.a();

    /* compiled from: AndroidPlatform.java */
    /* renamed from: e.i0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0118a extends e.i0.l.b {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5822a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f5823b;

        public C0118a(Object obj, Method method) {
            this.f5822a = obj;
            this.f5823b = method;
        }

        @Override // e.i0.l.b
        public List<Certificate> a(List<Certificate> list, String str) {
            try {
                return (List) this.f5823b.invoke(this.f5822a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0118a;
        }

        public int hashCode() {
            return 0;
        }
    }

    public a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.f5817c = dVar;
        this.f5818d = dVar2;
        this.f5819e = dVar3;
        this.f5820f = dVar4;
    }

    public static e c() {
        Class<?> cls;
        d dVar;
        d dVar2;
        d dVar3;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        } catch (ClassNotFoundException unused2) {
            cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        Class<?> cls2 = cls;
        d dVar4 = new d(null, "setUseSessionTickets", Boolean.TYPE);
        d dVar5 = new d(null, "setHostname", String.class);
        try {
            Class.forName("android.net.Network");
            dVar = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
        } catch (ClassNotFoundException unused3) {
            dVar = null;
        }
        try {
            dVar3 = new d(null, "setAlpnProtocols", byte[].class);
            dVar2 = dVar;
        } catch (ClassNotFoundException unused4) {
            dVar2 = dVar;
            dVar3 = null;
            return new a(cls2, dVar4, dVar5, dVar2, dVar3);
        }
        return new a(cls2, dVar4, dVar5, dVar2, dVar3);
    }

    @Override // e.i0.j.e
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (!e.i0.c.a(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (SecurityException e3) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e3);
            throw iOException;
        }
    }

    @Override // e.i0.j.e
    public String b(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.f5819e;
        if (dVar == null || !dVar.a((d<Socket>) sSLSocket) || (bArr = (byte[]) this.f5819e.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, e.i0.c.f5570i);
    }

    /* compiled from: AndroidPlatform.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Method f5824a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f5825b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f5826c;

        public b(Method method, Method method2, Method method3) {
            this.f5824a = method;
            this.f5825b = method2;
            this.f5826c = method3;
        }

        public Object a(String str) {
            Method method = this.f5824a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f5825b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public boolean a(Object obj) {
            if (obj != null) {
                try {
                    this.f5826c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        public static b a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new b(method3, method2, method);
        }
    }

    @Override // e.i0.j.e
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    @Override // e.i0.j.e
    public void a(SSLSocket sSLSocket, String str, List<z> list) {
        if (str != null) {
            this.f5817c.c(sSLSocket, true);
            this.f5818d.c(sSLSocket, str);
        }
        d<Socket> dVar = this.f5820f;
        if (dVar == null || !dVar.a((d<Socket>) sSLSocket)) {
            return;
        }
        this.f5820f.d(sSLSocket, e.b(list));
    }

    @Override // e.i0.j.e
    public void a(int i2, String str, Throwable th) {
        int min;
        int i3 = i2 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + 4000);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    @Override // e.i0.j.e
    public Object a(String str) {
        return this.f5821g.a(str);
    }

    @Override // e.i0.j.e
    public void a(String str, Object obj) {
        if (this.f5821g.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    @Override // e.i0.j.e
    public e.i0.l.b a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0118a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }
}
