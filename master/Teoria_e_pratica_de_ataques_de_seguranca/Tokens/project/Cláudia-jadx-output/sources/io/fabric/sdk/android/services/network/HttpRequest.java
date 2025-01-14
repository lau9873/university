package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class HttpRequest {
    public static c k = c.f7576a;

    /* renamed from: b  reason: collision with root package name */
    public final URL f7563b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7564c;

    /* renamed from: d  reason: collision with root package name */
    public e f7565d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7566e;

    /* renamed from: i  reason: collision with root package name */
    public String f7570i;
    public int j;

    /* renamed from: a  reason: collision with root package name */
    public HttpURLConnection f7562a = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7567f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7568g = false;

    /* renamed from: h  reason: collision with root package name */
    public int f7569h = 8192;

    /* loaded from: classes.dex */
    public static class HttpRequestException extends RuntimeException {
        public HttpRequestException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* loaded from: classes.dex */
    public class a extends b<HttpRequest> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InputStream f7571c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OutputStream f7572d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
            super(closeable, z);
            this.f7571c = inputStream;
            this.f7572d = outputStream;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.d
        public HttpRequest b() {
            byte[] bArr = new byte[HttpRequest.this.f7569h];
            while (true) {
                int read = this.f7571c.read(bArr);
                if (read != -1) {
                    this.f7572d.write(bArr, 0, read);
                } else {
                    return HttpRequest.this;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<V> extends d<V> {

        /* renamed from: a  reason: collision with root package name */
        public final Closeable f7574a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7575b;

        public b(Closeable closeable, boolean z) {
            this.f7574a = closeable;
            this.f7575b = z;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.d
        public void a() {
            Closeable closeable = this.f7574a;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.f7575b) {
                try {
                    this.f7574a.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            this.f7574a.close();
        }
    }

    /* loaded from: classes.dex */
    public interface c {

        /* renamed from: a  reason: collision with root package name */
        public static final c f7576a = new a();

        /* loaded from: classes.dex */
        public static class a implements c {
            @Override // io.fabric.sdk.android.services.network.HttpRequest.c
            public HttpURLConnection a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            @Override // io.fabric.sdk.android.services.network.HttpRequest.c
            public HttpURLConnection a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        HttpURLConnection a(URL url);

        HttpURLConnection a(URL url, Proxy proxy);
    }

    /* loaded from: classes.dex */
    public static abstract class d<V> implements Callable<V> {
        public abstract void a();

        public abstract V b();

        @Override // java.util.concurrent.Callable
        public V call() {
            Throwable th;
            boolean z = true;
            try {
                try {
                    V b2 = b();
                    try {
                        a();
                        return b2;
                    } catch (IOException e2) {
                        throw new HttpRequestException(e2);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        a();
                    } catch (IOException e3) {
                        if (!z) {
                            throw new HttpRequestException(e3);
                        }
                    }
                    throw th;
                }
            } catch (HttpRequestException e4) {
                throw e4;
            } catch (IOException e5) {
                throw new HttpRequestException(e5);
            } catch (Throwable th3) {
                th = th3;
                z = false;
                a();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends BufferedOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final CharsetEncoder f7577a;

        public e(OutputStream outputStream, String str, int i2) {
            super(outputStream, i2);
            this.f7577a = Charset.forName(HttpRequest.f(str)).newEncoder();
        }

        public e b(String str) {
            ByteBuffer encode = this.f7577a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public HttpRequest(CharSequence charSequence, String str) {
        try {
            this.f7563b = new URL(charSequence.toString());
            this.f7564c = str;
        } catch (MalformedURLException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static StringBuilder b(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    public static String c(CharSequence charSequence) {
        int port;
        int i2;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            if (url.getPort() != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf <= 0 || (i2 = indexOf + 1) >= aSCIIString.length()) {
                    return aSCIIString;
                }
                return aSCIIString.substring(0, i2) + aSCIIString.substring(i2).replace("+", "%2B");
            } catch (URISyntaxException e2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e2);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e3) {
            throw new HttpRequestException(e3);
        }
    }

    public static HttpRequest d(CharSequence charSequence) {
        return new HttpRequest(charSequence, "GET");
    }

    public static String f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    public int g() {
        try {
            e();
            return l().getResponseCode();
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public String h() {
        return c("Content-Encoding");
    }

    public int i() {
        return d("Content-Length");
    }

    public final HttpURLConnection j() {
        HttpURLConnection a2;
        try {
            if (this.f7570i != null) {
                a2 = k.a(this.f7563b, k());
            } else {
                a2 = k.a(this.f7563b);
            }
            a2.setRequestMethod(this.f7564c);
            return a2;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public final Proxy k() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f7570i, this.j));
    }

    public HttpURLConnection l() {
        if (this.f7562a == null) {
            this.f7562a = j();
        }
        return this.f7562a;
    }

    public String m() {
        return l().getRequestMethod();
    }

    public boolean n() {
        return 200 == g();
    }

    public HttpRequest o() {
        if (this.f7565d != null) {
            return this;
        }
        l().setDoOutput(true);
        this.f7565d = new e(l().getOutputStream(), b(l().getRequestProperty("Content-Type"), "charset"), this.f7569h);
        return this;
    }

    public HttpRequest p() {
        if (!this.f7566e) {
            this.f7566e = true;
            b("multipart/form-data; boundary=00content0boundary00");
            o();
            this.f7565d.b("--00content0boundary00\r\n");
        } else {
            this.f7565d.b("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    public InputStream q() {
        InputStream inputStream;
        if (g() < 400) {
            try {
                inputStream = l().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        } else {
            inputStream = l().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = l().getInputStream();
                } catch (IOException e3) {
                    throw new HttpRequestException(e3);
                }
            }
        }
        if (this.f7568g && "gzip".equals(h())) {
            try {
                return new GZIPInputStream(inputStream);
            } catch (IOException e4) {
                throw new HttpRequestException(e4);
            }
        }
        return inputStream;
    }

    public URL r() {
        return l().getURL();
    }

    public String toString() {
        return m() + ' ' + r();
    }

    public static StringBuilder a(String str, StringBuilder sb) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    public static HttpRequest e(CharSequence charSequence) {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest f(CharSequence charSequence) {
        return new HttpRequest(charSequence, "PUT");
    }

    public int d(String str) {
        return a(str, -1);
    }

    public static HttpRequest b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a2 = a(charSequence, map);
        if (z) {
            a2 = c((CharSequence) a2);
        }
        return e((CharSequence) a2);
    }

    public String d(String str, String str2) {
        return b(c(str), str2);
    }

    public HttpRequest e() {
        e eVar = this.f7565d;
        if (eVar == null) {
            return this;
        }
        if (this.f7566e) {
            eVar.b("\r\n--00content0boundary00--\r\n");
        }
        if (this.f7567f) {
            try {
                this.f7565d.close();
            } catch (IOException unused) {
            }
        } else {
            this.f7565d.close();
        }
        this.f7565d = null;
        return this;
    }

    public HttpRequest f() {
        try {
            e();
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public String d() {
        return d("Content-Type", "charset");
    }

    public static HttpRequest b(CharSequence charSequence) {
        return new HttpRequest(charSequence, "DELETE");
    }

    public HttpRequest f(String str, String str2) {
        a((CharSequence) str);
        a(": ");
        a((CharSequence) str2);
        a("\r\n");
        return this;
    }

    public BufferedInputStream b() {
        return new BufferedInputStream(q(), this.f7569h);
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        b(charSequence2, sb);
        a(charSequence2, sb);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry<?, ?> next = it.next();
        sb.append(next.getKey().toString());
        sb.append('=');
        Object value = next.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append('&');
            Map.Entry<?, ?> next2 = it.next();
            sb.append(next2.getKey().toString());
            sb.append('=');
            Object value2 = next2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    public String b(String str, String str2) {
        String trim;
        int length;
        if (str != null && str.length() != 0) {
            int length2 = str.length();
            int indexOf = str.indexOf(59) + 1;
            if (indexOf != 0 && indexOf != length2) {
                int indexOf2 = str.indexOf(59, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = length2;
                }
                while (indexOf < indexOf2) {
                    int indexOf3 = str.indexOf(61, indexOf);
                    if (indexOf3 != -1 && indexOf3 < indexOf2 && str2.equals(str.substring(indexOf, indexOf3).trim()) && (length = (trim = str.substring(indexOf3 + 1, indexOf2).trim()).length()) != 0) {
                        if (length > 2 && '\"' == trim.charAt(0)) {
                            int i2 = length - 1;
                            if ('\"' == trim.charAt(i2)) {
                                return trim.substring(1, i2);
                            }
                        }
                        return trim;
                    }
                    indexOf = indexOf2 + 1;
                    indexOf2 = str.indexOf(59, indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = length2;
                    }
                }
            }
        }
        return null;
    }

    public HttpRequest e(String str, String str2) {
        a(str, (String) null, str2);
        return this;
    }

    public ByteArrayOutputStream c() {
        int i2 = i();
        if (i2 > 0) {
            return new ByteArrayOutputStream(i2);
        }
        return new ByteArrayOutputStream();
    }

    public HttpRequest c(String str, String str2) {
        l().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest b(String str) {
        a(str, (String) null);
        return this;
    }

    public String c(String str) {
        f();
        return l().getHeaderField(str);
    }

    public HttpRequest b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append('\"');
        f("Content-Disposition", sb.toString());
        if (str3 != null) {
            f("Content-Type", str3);
        }
        a("\r\n");
        return this;
    }

    public static HttpRequest a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String a2 = a(charSequence, map);
        if (z) {
            a2 = c((CharSequence) a2);
        }
        return d((CharSequence) a2);
    }

    public String a(String str) {
        ByteArrayOutputStream c2 = c();
        try {
            a(b(), c2);
            return c2.toString(f(str));
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public String a() {
        return a(d());
    }

    public HttpRequest a(int i2) {
        l().setConnectTimeout(i2);
        return this;
    }

    public HttpRequest a(Map.Entry<String, String> entry) {
        c(entry.getKey(), entry.getValue());
        return this;
    }

    public int a(String str, int i2) {
        f();
        return l().getHeaderFieldInt(str, i2);
    }

    public HttpRequest a(boolean z) {
        l().setUseCaches(z);
        return this;
    }

    public HttpRequest a(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            c("Content-Type", str + "; charset=" + str2);
            return this;
        }
        c("Content-Type", str);
        return this;
    }

    public HttpRequest a(InputStream inputStream, OutputStream outputStream) {
        return new a(inputStream, this.f7567f, inputStream, outputStream).call();
    }

    public HttpRequest a(String str, String str2, String str3) {
        a(str, str2, (String) null, str3);
        return this;
    }

    public HttpRequest a(String str, String str2, String str3, String str4) {
        try {
            p();
            b(str, str2, str3);
            this.f7565d.b(str4);
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest a(String str, Number number) {
        a(str, (String) null, number);
        return this;
    }

    public HttpRequest a(String str, String str2, Number number) {
        a(str, str2, number != null ? number.toString() : null);
        return this;
    }

    public HttpRequest a(String str, String str2, String str3, File file) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            a(str, str2, str3, bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
            }
            return this;
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            throw new HttpRequestException(e);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public HttpRequest a(String str, String str2, String str3, InputStream inputStream) {
        try {
            p();
            b(str, str2, str3);
            a(inputStream, this.f7565d);
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public HttpRequest a(CharSequence charSequence) {
        try {
            o();
            this.f7565d.b(charSequence.toString());
            return this;
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }
}
