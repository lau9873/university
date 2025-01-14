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

    /* renamed from: k */
    public static InterfaceC2648c f10537k = InterfaceC2648c.f10553a;

    /* renamed from: b */
    public final URL f10539b;

    /* renamed from: c */
    public final String f10540c;

    /* renamed from: d */
    public C2651e f10541d;

    /* renamed from: e */
    public boolean f10542e;

    /* renamed from: i */
    public String f10546i;

    /* renamed from: j */
    public int f10547j;

    /* renamed from: a */
    public HttpURLConnection f10538a = null;

    /* renamed from: f */
    public boolean f10543f = true;

    /* renamed from: g */
    public boolean f10544g = false;

    /* renamed from: h */
    public int f10545h = 8192;

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

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$a */
    /* loaded from: classes.dex */
    public class C2646a extends AbstractC2647b<HttpRequest> {

        /* renamed from: c */
        public final /* synthetic */ InputStream f10548c;

        /* renamed from: d */
        public final /* synthetic */ OutputStream f10549d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2646a(Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
            super(closeable, z);
            this.f10548c = inputStream;
            this.f10549d = outputStream;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.AbstractCallableC2650d
        /* renamed from: b */
        public HttpRequest mo502b() {
            byte[] bArr = new byte[HttpRequest.this.f10545h];
            while (true) {
                int read = this.f10548c.read(bArr);
                if (read != -1) {
                    this.f10549d.write(bArr, 0, read);
                } else {
                    return HttpRequest.this;
                }
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2647b<V> extends AbstractCallableC2650d<V> {

        /* renamed from: a */
        public final Closeable f10551a;

        /* renamed from: b */
        public final boolean f10552b;

        public AbstractC2647b(Closeable closeable, boolean z) {
            this.f10551a = closeable;
            this.f10552b = z;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.AbstractCallableC2650d
        /* renamed from: a */
        public void mo503a() {
            Closeable closeable = this.f10551a;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (this.f10552b) {
                try {
                    this.f10551a.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            this.f10551a.close();
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$c */
    /* loaded from: classes.dex */
    public interface InterfaceC2648c {

        /* renamed from: a */
        public static final InterfaceC2648c f10553a = new C2649a();

        /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$c$a */
        /* loaded from: classes.dex */
        public static class C2649a implements InterfaceC2648c {
            @Override // io.fabric.sdk.android.services.network.HttpRequest.InterfaceC2648c
            /* renamed from: a */
            public HttpURLConnection mo505a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            @Override // io.fabric.sdk.android.services.network.HttpRequest.InterfaceC2648c
            /* renamed from: a */
            public HttpURLConnection mo504a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        /* renamed from: a */
        HttpURLConnection mo505a(URL url);

        /* renamed from: a */
        HttpURLConnection mo504a(URL url, Proxy proxy);
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractCallableC2650d<V> implements Callable<V> {
        /* renamed from: a */
        public abstract void mo503a();

        /* renamed from: b */
        public abstract V mo502b();

        @Override // java.util.concurrent.Callable
        public V call() {
            Throwable th;
            boolean z = true;
            try {
                try {
                    V mo502b = mo502b();
                    try {
                        mo503a();
                        return mo502b;
                    } catch (IOException e) {
                        throw new HttpRequestException(e);
                    }
                } catch (HttpRequestException e2) {
                    throw e2;
                } catch (IOException e3) {
                    throw new HttpRequestException(e3);
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                    try {
                        mo503a();
                    } catch (IOException e4) {
                        if (!z) {
                            throw new HttpRequestException(e4);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                mo503a();
                throw th;
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest$e */
    /* loaded from: classes.dex */
    public static class C2651e extends BufferedOutputStream {

        /* renamed from: a */
        public final CharsetEncoder f10554a;

        public C2651e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f10554a = Charset.forName(HttpRequest.m519f(str)).newEncoder();
        }

        /* renamed from: b */
        public C2651e m501b(String str) {
            ByteBuffer encode = this.f10554a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public HttpRequest(CharSequence charSequence, String str) {
        try {
            this.f10539b = new URL(charSequence.toString());
            this.f10540c = str;
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: b */
    public static StringBuilder m534b(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    /* renamed from: c */
    public static String m532c(CharSequence charSequence) {
        int port;
        int i;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            if (url.getPort() != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf <= 0 || (i = indexOf + 1) >= aSCIIString.length()) {
                    return aSCIIString;
                }
                return aSCIIString.substring(0, i) + aSCIIString.substring(i).replace("+", "%2B");
            } catch (URISyntaxException e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    /* renamed from: d */
    public static HttpRequest m528d(CharSequence charSequence) {
        return new HttpRequest(charSequence, "GET");
    }

    /* renamed from: f */
    public static String m519f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    /* renamed from: g */
    public int m517g() {
        try {
            m525e();
            return m512l().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: h */
    public String m516h() {
        return m531c("Content-Encoding");
    }

    /* renamed from: i */
    public int m515i() {
        return m527d("Content-Length");
    }

    /* renamed from: j */
    public final HttpURLConnection m514j() {
        HttpURLConnection mo505a;
        try {
            if (this.f10546i != null) {
                mo505a = f10537k.mo504a(this.f10539b, m513k());
            } else {
                mo505a = f10537k.mo505a(this.f10539b);
            }
            mo505a.setRequestMethod(this.f10540c);
            return mo505a;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: k */
    public final Proxy m513k() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f10546i, this.f10547j));
    }

    /* renamed from: l */
    public HttpURLConnection m512l() {
        if (this.f10538a == null) {
            this.f10538a = m514j();
        }
        return this.f10538a;
    }

    /* renamed from: m */
    public String m511m() {
        return m512l().getRequestMethod();
    }

    /* renamed from: n */
    public boolean m510n() {
        return 200 == m517g();
    }

    /* renamed from: o */
    public HttpRequest m509o() {
        if (this.f10541d != null) {
            return this;
        }
        m512l().setDoOutput(true);
        this.f10541d = new C2651e(m512l().getOutputStream(), m536b(m512l().getRequestProperty("Content-Type"), "charset"), this.f10545h);
        return this;
    }

    /* renamed from: p */
    public HttpRequest m508p() {
        if (!this.f10542e) {
            this.f10542e = true;
            m537b("multipart/form-data; boundary=00content0boundary00");
            m509o();
            this.f10541d.m501b("--00content0boundary00\r\n");
        } else {
            this.f10541d.m501b("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    /* renamed from: q */
    public InputStream m507q() {
        InputStream inputStream;
        if (m517g() < 400) {
            try {
                inputStream = m512l().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        } else {
            inputStream = m512l().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = m512l().getInputStream();
                } catch (IOException e2) {
                    throw new HttpRequestException(e2);
                }
            }
        }
        if (this.f10544g && "gzip".equals(m516h())) {
            try {
                return new GZIPInputStream(inputStream);
            } catch (IOException e3) {
                throw new HttpRequestException(e3);
            }
        }
        return inputStream;
    }

    /* renamed from: r */
    public URL m506r() {
        return m512l().getURL();
    }

    public String toString() {
        return m511m() + ' ' + m506r();
    }

    /* renamed from: a */
    public static StringBuilder m543a(String str, StringBuilder sb) {
        int indexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (indexOf == -1) {
            sb.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    /* renamed from: e */
    public static HttpRequest m524e(CharSequence charSequence) {
        return new HttpRequest(charSequence, "POST");
    }

    /* renamed from: f */
    public static HttpRequest m520f(CharSequence charSequence) {
        return new HttpRequest(charSequence, "PUT");
    }

    /* renamed from: d */
    public int m527d(String str) {
        return m551a(str, -1);
    }

    /* renamed from: b */
    public static HttpRequest m538b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String m554a = m554a(charSequence, map);
        if (z) {
            m554a = m532c((CharSequence) m554a);
        }
        return m524e((CharSequence) m554a);
    }

    /* renamed from: d */
    public String m526d(String str, String str2) {
        return m536b(m531c(str), str2);
    }

    /* renamed from: e */
    public HttpRequest m525e() {
        C2651e c2651e = this.f10541d;
        if (c2651e == null) {
            return this;
        }
        if (this.f10542e) {
            c2651e.m501b("\r\n--00content0boundary00--\r\n");
        }
        if (this.f10543f) {
            try {
                this.f10541d.close();
            } catch (IOException unused) {
            }
        } else {
            this.f10541d.close();
        }
        this.f10541d = null;
        return this;
    }

    /* renamed from: f */
    public HttpRequest m521f() {
        try {
            m525e();
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: d */
    public String m529d() {
        return m526d("Content-Type", "charset");
    }

    /* renamed from: b */
    public static HttpRequest m539b(CharSequence charSequence) {
        return new HttpRequest(charSequence, "DELETE");
    }

    /* renamed from: f */
    public HttpRequest m518f(String str, String str2) {
        m555a((CharSequence) str);
        m555a(": ");
        m555a((CharSequence) str2);
        m555a("\r\n");
        return this;
    }

    /* renamed from: b */
    public BufferedInputStream m540b() {
        return new BufferedInputStream(m507q(), this.f10545h);
    }

    /* renamed from: a */
    public static String m554a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        m534b(charSequence2, sb);
        m543a(charSequence2, sb);
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

    /* renamed from: b */
    public String m536b(String str, String str2) {
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
                            int i = length - 1;
                            if ('\"' == trim.charAt(i)) {
                                return trim.substring(1, i);
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

    /* renamed from: e */
    public HttpRequest m522e(String str, String str2) {
        m547a(str, (String) null, str2);
        return this;
    }

    /* renamed from: c */
    public ByteArrayOutputStream m533c() {
        int m515i = m515i();
        if (m515i > 0) {
            return new ByteArrayOutputStream(m515i);
        }
        return new ByteArrayOutputStream();
    }

    /* renamed from: c */
    public HttpRequest m530c(String str, String str2) {
        m512l().setRequestProperty(str, str2);
        return this;
    }

    /* renamed from: b */
    public HttpRequest m537b(String str) {
        m549a(str, (String) null);
        return this;
    }

    /* renamed from: c */
    public String m531c(String str) {
        m521f();
        return m512l().getHeaderField(str);
    }

    /* renamed from: b */
    public HttpRequest m535b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append('\"');
        m518f("Content-Disposition", sb.toString());
        if (str3 != null) {
            m518f("Content-Type", str3);
        }
        m555a("\r\n");
        return this;
    }

    /* renamed from: a */
    public static HttpRequest m553a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String m554a = m554a(charSequence, map);
        if (z) {
            m554a = m532c((CharSequence) m554a);
        }
        return m528d((CharSequence) m554a);
    }

    /* renamed from: a */
    public String m552a(String str) {
        ByteArrayOutputStream m533c = m533c();
        try {
            m556a(m540b(), m533c);
            return m533c.toString(m519f(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public String m559a() {
        return m552a(m529d());
    }

    /* renamed from: a */
    public HttpRequest m558a(int i) {
        m512l().setConnectTimeout(i);
        return this;
    }

    /* renamed from: a */
    public HttpRequest m542a(Map.Entry<String, String> entry) {
        m530c(entry.getKey(), entry.getValue());
        return this;
    }

    /* renamed from: a */
    public int m551a(String str, int i) {
        m521f();
        return m512l().getHeaderFieldInt(str, i);
    }

    /* renamed from: a */
    public HttpRequest m541a(boolean z) {
        m512l().setUseCaches(z);
        return this;
    }

    /* renamed from: a */
    public HttpRequest m549a(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            m530c("Content-Type", str + "; charset=" + str2);
            return this;
        }
        m530c("Content-Type", str);
        return this;
    }

    /* renamed from: a */
    public HttpRequest m556a(InputStream inputStream, OutputStream outputStream) {
        return new C2646a(inputStream, this.f10543f, inputStream, outputStream).call();
    }

    /* renamed from: a */
    public HttpRequest m547a(String str, String str2, String str3) {
        m544a(str, str2, (String) null, str3);
        return this;
    }

    /* renamed from: a */
    public HttpRequest m544a(String str, String str2, String str3, String str4) {
        try {
            m508p();
            m535b(str, str2, str3);
            this.f10541d.m501b(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public HttpRequest m550a(String str, Number number) {
        m548a(str, (String) null, number);
        return this;
    }

    /* renamed from: a */
    public HttpRequest m548a(String str, String str2, Number number) {
        m547a(str, str2, number != null ? number.toString() : null);
        return this;
    }

    /* renamed from: a */
    public HttpRequest m546a(String str, String str2, String str3, File file) {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    m545a(str, str2, str3, bufferedInputStream2);
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return this;
                } catch (IOException e) {
                    e = e;
                    bufferedInputStream = bufferedInputStream2;
                    throw new HttpRequestException(e);
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* renamed from: a */
    public HttpRequest m545a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m508p();
            m535b(str, str2, str3);
            m556a(inputStream, this.f10541d);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    /* renamed from: a */
    public HttpRequest m555a(CharSequence charSequence) {
        try {
            m509o();
            this.f10541d.m501b(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }
}
