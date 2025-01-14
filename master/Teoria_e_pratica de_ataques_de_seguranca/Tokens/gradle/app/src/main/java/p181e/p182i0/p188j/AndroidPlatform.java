package p181e.p182i0.p188j;

import android.util.Log;
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
import p181e.Protocol;
import p181e.p182i0.Util;
import p181e.p182i0.p190l.AbstractC1795b;

/* renamed from: e.i0.j.a */
/* loaded from: classes.dex */
public class AndroidPlatform extends Platform {

    /* renamed from: c */
    public final OptionalMethod<Socket> f8225c;

    /* renamed from: d */
    public final OptionalMethod<Socket> f8226d;

    /* renamed from: e */
    public final OptionalMethod<Socket> f8227e;

    /* renamed from: f */
    public final OptionalMethod<Socket> f8228f;

    /* renamed from: g */
    public final C1793b f8229g = C1793b.m2874a();

    /* compiled from: AndroidPlatform.java */
    /* renamed from: e.i0.j.a$a */
    /* loaded from: classes.dex */
    public static final class C1792a extends AbstractC1795b {

        /* renamed from: a */
        public final Object f8230a;

        /* renamed from: b */
        public final Method f8231b;

        public C1792a(Object obj, Method method) {
            this.f8230a = obj;
            this.f8231b = method;
        }

        @Override // p181e.p182i0.p190l.AbstractC1795b
        /* renamed from: a */
        public List<Certificate> mo2843a(List<Certificate> list, String str) {
            try {
                return (List) this.f8231b.invoke(this.f8230a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C1792a;
        }

        public int hashCode() {
            return 0;
        }
    }

    public AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f8225c = optionalMethod;
        this.f8226d = optionalMethod2;
        this.f8227e = optionalMethod3;
        this.f8228f = optionalMethod4;
    }

    /* renamed from: c */
    public static Platform m2875c() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        OptionalMethod optionalMethod3;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            OptionalMethod optionalMethod4 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
            OptionalMethod optionalMethod5 = new OptionalMethod(null, "setHostname", String.class);
            try {
                Class.forName("android.net.Network");
                optionalMethod = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                try {
                    optionalMethod3 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                    optionalMethod2 = optionalMethod;
                } catch (ClassNotFoundException unused2) {
                    optionalMethod2 = optionalMethod;
                    optionalMethod3 = null;
                    return new AndroidPlatform(cls2, optionalMethod4, optionalMethod5, optionalMethod2, optionalMethod3);
                }
            } catch (ClassNotFoundException unused3) {
                optionalMethod = null;
            }
            return new AndroidPlatform(cls2, optionalMethod4, optionalMethod5, optionalMethod2, optionalMethod3);
        } catch (ClassNotFoundException unused4) {
            return null;
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public void mo2858a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!Util.m3168a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: b */
    public String mo2850b(SSLSocket sSLSocket) {
        byte[] bArr;
        OptionalMethod<Socket> optionalMethod = this.f8227e;
        if (optionalMethod == null || !optionalMethod.m2867a((OptionalMethod<Socket>) sSLSocket) || (bArr = (byte[]) this.f8227e.m2863d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, Util.f7942i);
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: e.i0.j.a$b */
    /* loaded from: classes.dex */
    public static final class C1793b {

        /* renamed from: a */
        public final Method f8232a;

        /* renamed from: b */
        public final Method f8233b;

        /* renamed from: c */
        public final Method f8234c;

        public C1793b(Method method, Method method2, Method method3) {
            this.f8232a = method;
            this.f8233b = method2;
            this.f8234c = method3;
        }

        /* renamed from: a */
        public Object m2872a(String str) {
            Method method = this.f8232a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f8233b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: a */
        public boolean m2873a(Object obj) {
            if (obj != null) {
                try {
                    this.f8234c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        /* renamed from: a */
        public static C1793b m2874a() {
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
            return new C1793b(method3, method2, method);
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: b */
    public boolean mo2852b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), str)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo2852b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public void mo2855a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f8225c.m2864c(sSLSocket, true);
            this.f8226d.m2864c(sSLSocket, str);
        }
        OptionalMethod<Socket> optionalMethod = this.f8228f;
        if (optionalMethod == null || !optionalMethod.m2867a((OptionalMethod<Socket>) sSLSocket)) {
            return;
        }
        this.f8228f.m2863d(sSLSocket, Platform.m2851b(list));
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public void mo2861a(int i, String str, Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public Object mo2860a(String str) {
        return this.f8229g.m2872a(str);
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public void mo2859a(String str, Object obj) {
        if (this.f8229g.m2873a(obj)) {
            return;
        }
        mo2861a(5, str, (Throwable) null);
    }

    @Override // p181e.p182i0.p188j.Platform
    /* renamed from: a */
    public AbstractC1795b mo2854a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C1792a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.mo2854a(x509TrustManager);
        }
    }
}
