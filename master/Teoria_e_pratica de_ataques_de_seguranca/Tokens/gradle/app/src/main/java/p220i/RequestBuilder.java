package p220i;

import p181e.C1737b0;
import p181e.FormBody;
import p181e.Headers;
import p181e.HttpUrl;
import p181e.MediaType;
import p181e.MultipartBody;
import p181e.RequestBody;
import p192f.Buffer;
import p192f.BufferedSink;

/* renamed from: i.k */
/* loaded from: classes.dex */
public final class RequestBuilder {

    /* renamed from: k */
    public static final char[] f10433k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public final String f10434a;

    /* renamed from: b */
    public final HttpUrl f10435b;

    /* renamed from: c */
    public String f10436c;

    /* renamed from: d */
    public HttpUrl.C1810a f10437d;

    /* renamed from: e */
    public final C1737b0.C1738a f10438e = new C1737b0.C1738a();

    /* renamed from: f */
    public MediaType f10439f;

    /* renamed from: g */
    public final boolean f10440g;

    /* renamed from: h */
    public MultipartBody.C1813a f10441h;

    /* renamed from: i */
    public FormBody.C1808a f10442i;

    /* renamed from: j */
    public RequestBody f10443j;

    /* compiled from: RequestBuilder.java */
    /* renamed from: i.k$a */
    /* loaded from: classes.dex */
    public static class C2631a extends RequestBody {

        /* renamed from: a */
        public final RequestBody f10444a;

        /* renamed from: b */
        public final MediaType f10445b;

        public C2631a(RequestBody requestBody, MediaType mediaType) {
            this.f10444a = requestBody;
            this.f10445b = mediaType;
        }

        @Override // p181e.RequestBody
        /* renamed from: a */
        public long mo645a() {
            return this.f10444a.mo645a();
        }

        @Override // p181e.RequestBody
        /* renamed from: b */
        public MediaType mo643b() {
            return this.f10445b;
        }

        @Override // p181e.RequestBody
        /* renamed from: a */
        public void mo644a(BufferedSink bufferedSink) {
            this.f10444a.mo644a(bufferedSink);
        }
    }

    public RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.f10434a = str;
        this.f10435b = httpUrl;
        this.f10436c = str2;
        this.f10439f = mediaType;
        this.f10440g = z;
        if (headers != null) {
            this.f10438e.m3252a(headers);
        }
        if (z2) {
            this.f10442i = new FormBody.C1808a();
        } else if (z3) {
            this.f10441h = new MultipartBody.C1813a();
            this.f10441h.m2686a(MultipartBody.f8363f);
        }
    }

    /* renamed from: a */
    public void m650a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            MediaType m2692a = MediaType.m2692a(str2);
            if (m2692a != null) {
                this.f10439f = m2692a;
                return;
            }
            throw new IllegalArgumentException("Malformed content type: " + str2);
        }
        this.f10438e.m3248a(str, str2);
    }

    /* renamed from: b */
    public void m647b(String str, String str2, boolean z) {
        String str3 = this.f10436c;
        if (str3 != null) {
            this.f10436c = str3.replace("{" + str + "}", m648a(str2, z));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public void m646c(String str, String str2, boolean z) {
        String str3 = this.f10436c;
        if (str3 != null) {
            this.f10437d = this.f10435b.m2748a(str3);
            if (this.f10437d != null) {
                this.f10436c = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f10435b + ", Relative: " + this.f10436c);
            }
        }
        if (z) {
            this.f10437d.m2714a(str, str2);
        } else {
            this.f10437d.m2709b(str, str2);
        }
    }

    /* renamed from: a */
    public static String m648a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.m2621a(str, 0, i);
                m651a(buffer, str, i, length, z);
                return buffer.m2607q();
            }
        }
        return str;
    }

    /* renamed from: a */
    public static void m651a(Buffer buffer, String str, int i, int i2, boolean z) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                    buffer.m2617c(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.m2617c(codePointAt);
                    while (!buffer2.mo2557e()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f10433k[(readByte >> 4) & 15]);
                        buffer.writeByte((int) f10433k[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    public void m649a(String str, String str2, boolean z) {
        if (z) {
            this.f10442i.m2771b(str, str2);
        } else {
            this.f10442i.m2772a(str, str2);
        }
    }

    /* renamed from: a */
    public void m653a(Headers headers, RequestBody requestBody) {
        this.f10441h.m2687a(headers, requestBody);
    }

    /* renamed from: a */
    public void m652a(MultipartBody.C1814b c1814b) {
        this.f10441h.m2685a(c1814b);
    }

    /* renamed from: a */
    public void m654a(RequestBody requestBody) {
        this.f10443j = requestBody;
    }

    /* renamed from: a */
    public C1737b0 m655a() {
        HttpUrl m2739b;
        HttpUrl.C1810a c1810a = this.f10437d;
        if (c1810a != null) {
            m2739b = c1810a.m2721a();
        } else {
            m2739b = this.f10435b.m2739b(this.f10436c);
            if (m2739b == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f10435b + ", Relative: " + this.f10436c);
            }
        }
        C2631a c2631a = this.f10443j;
        if (c2631a == null) {
            FormBody.C1808a c1808a = this.f10442i;
            if (c1808a != null) {
                c2631a = c1808a.m2773a();
            } else {
                MultipartBody.C1813a c1813a = this.f10441h;
                if (c1813a != null) {
                    c2631a = c1813a.m2688a();
                } else if (this.f10440g) {
                    c2631a = RequestBody.m3244a((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f10439f;
        if (mediaType != null) {
            if (c2631a != null) {
                c2631a = new C2631a(c2631a, mediaType);
            } else {
                this.f10438e.m3248a("Content-Type", mediaType.toString());
            }
        }
        C1737b0.C1738a c1738a = this.f10438e;
        c1738a.m3251a(m2739b);
        c1738a.m3249a(this.f10434a, c2631a);
        return c1738a.m3253a();
    }
}
