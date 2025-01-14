package c.a.a.o;

import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: HurlStack.java */
/* loaded from: classes.dex */
public class j extends c.a.a.o.b {

    /* renamed from: a  reason: collision with root package name */
    public final b f2840a;

    /* renamed from: b  reason: collision with root package name */
    public final SSLSocketFactory f2841b;

    /* compiled from: HurlStack.java */
    /* loaded from: classes.dex */
    public static class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        public final HttpURLConnection f2842a;

        public a(HttpURLConnection httpURLConnection) {
            super(j.b(httpURLConnection));
            this.f2842a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.f2842a.disconnect();
        }
    }

    /* compiled from: HurlStack.java */
    /* loaded from: classes.dex */
    public interface b {
        String a(String str);
    }

    public j() {
        this(null);
    }

    public static boolean a(int i2, int i3) {
        return (i2 == 4 || (100 <= i3 && i3 < 200) || i3 == 204 || i3 == 304) ? false : true;
    }

    @Override // c.a.a.o.b
    public h b(c.a.a.i<?> iVar, Map<String, String> map) {
        String str;
        String r = iVar.r();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(iVar.g());
        b bVar = this.f2840a;
        if (bVar != null) {
            str = bVar.a(r);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + r);
            }
        } else {
            str = r;
        }
        HttpURLConnection a2 = a(new URL(str), iVar);
        try {
            for (String str2 : hashMap.keySet()) {
                a2.setRequestProperty(str2, (String) hashMap.get(str2));
            }
            b(a2, iVar);
            int responseCode = a2.getResponseCode();
            if (responseCode != -1) {
                if (!a(iVar.h(), responseCode)) {
                    h hVar = new h(responseCode, a(a2.getHeaderFields()));
                    a2.disconnect();
                    return hVar;
                }
                return new h(responseCode, a(a2.getHeaderFields()), a2.getContentLength(), new a(a2));
            }
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } catch (Throwable th) {
            if (0 == 0) {
                a2.disconnect();
            }
            throw th;
        }
    }

    public j(b bVar) {
        this(bVar, null);
    }

    public static List<c.a.a.e> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new c.a.a.e(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    public j(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f2840a = bVar;
        this.f2841b = sSLSocketFactory;
    }

    public HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public final HttpURLConnection a(URL url, c.a.a.i<?> iVar) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection a2 = a(url);
        int p = iVar.p();
        a2.setConnectTimeout(p);
        a2.setReadTimeout(p);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f2841b) != null) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(sSLSocketFactory);
        }
        return a2;
    }

    public static void a(HttpURLConnection httpURLConnection, c.a.a.i<?> iVar) {
        byte[] c2 = iVar.c();
        if (c2 != null) {
            a(httpURLConnection, iVar, c2);
        }
    }

    public static void a(HttpURLConnection httpURLConnection, c.a.a.i<?> iVar, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", iVar.d());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static void b(HttpURLConnection httpURLConnection, c.a.a.i<?> iVar) {
        switch (iVar.h()) {
            case -1:
                byte[] k = iVar.k();
                if (k != null) {
                    httpURLConnection.setRequestMethod("POST");
                    a(httpURLConnection, iVar, k);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                a(httpURLConnection, iVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                a(httpURLConnection, iVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                a(httpURLConnection, iVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
