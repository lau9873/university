package p181e;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import p181e.p182i0.Util;
import p192f.Buffer;
import p192f.BufferedSink;
import p192f.C1822f;

/* renamed from: e.x */
/* loaded from: classes.dex */
public final class MultipartBody extends RequestBody {

    /* renamed from: e */
    public static final MediaType f8362e = MediaType.m2692a("multipart/mixed");

    /* renamed from: f */
    public static final MediaType f8363f;

    /* renamed from: g */
    public static final byte[] f8364g;

    /* renamed from: h */
    public static final byte[] f8365h;

    /* renamed from: i */
    public static final byte[] f8366i;

    /* renamed from: a */
    public final C1822f f8367a;

    /* renamed from: b */
    public final MediaType f8368b;

    /* renamed from: c */
    public final List<C1814b> f8369c;

    /* renamed from: d */
    public long f8370d = -1;

    /* compiled from: MultipartBody.java */
    /* renamed from: e.x$a */
    /* loaded from: classes.dex */
    public static final class C1813a {

        /* renamed from: a */
        public final C1822f f8371a;

        /* renamed from: b */
        public MediaType f8372b;

        /* renamed from: c */
        public final List<C1814b> f8373c;

        public C1813a() {
            this(UUID.randomUUID().toString());
        }

        /* renamed from: a */
        public C1813a m2686a(MediaType mediaType) {
            if (mediaType != null) {
                if (mediaType.m2693a().equals("multipart")) {
                    this.f8372b = mediaType;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + mediaType);
            }
            throw new NullPointerException("type == null");
        }

        public C1813a(String str) {
            this.f8372b = MultipartBody.f8362e;
            this.f8373c = new ArrayList();
            this.f8371a = C1822f.m2596c(str);
        }

        /* renamed from: a */
        public C1813a m2687a(Headers headers, RequestBody requestBody) {
            m2685a(C1814b.m2684a(headers, requestBody));
            return this;
        }

        /* renamed from: a */
        public C1813a m2685a(C1814b c1814b) {
            if (c1814b != null) {
                this.f8373c.add(c1814b);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        /* renamed from: a */
        public MultipartBody m2688a() {
            if (!this.f8373c.isEmpty()) {
                return new MultipartBody(this.f8371a, this.f8372b, this.f8373c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    static {
        MediaType.m2692a("multipart/alternative");
        MediaType.m2692a("multipart/digest");
        MediaType.m2692a("multipart/parallel");
        f8363f = MediaType.m2692a("multipart/form-data");
        f8364g = new byte[]{58, 32};
        f8365h = new byte[]{13, 10};
        f8366i = new byte[]{45, 45};
    }

    public MultipartBody(C1822f c1822f, MediaType mediaType, List<C1814b> list) {
        this.f8367a = c1822f;
        this.f8368b = MediaType.m2692a(mediaType + "; boundary=" + c1822f.mo2532i());
        this.f8369c = Util.m3157a(list);
    }

    @Override // p181e.RequestBody
    /* renamed from: a */
    public long mo645a() {
        long j = this.f8370d;
        if (j != -1) {
            return j;
        }
        long m2690a = m2690a((BufferedSink) null, true);
        this.f8370d = m2690a;
        return m2690a;
    }

    @Override // p181e.RequestBody
    /* renamed from: b */
    public MediaType mo643b() {
        return this.f8368b;
    }

    @Override // p181e.RequestBody
    /* renamed from: a */
    public void mo644a(BufferedSink bufferedSink) {
        m2690a(bufferedSink, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final long m2690a(BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.f8369c.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C1814b c1814b = this.f8369c.get(i);
            Headers headers = c1814b.f8374a;
            RequestBody requestBody = c1814b.f8375b;
            bufferedSink.write(f8366i);
            bufferedSink.mo2575a(this.f8367a);
            bufferedSink.write(f8365h);
            if (headers != null) {
                int m2762b = headers.m2762b();
                for (int i2 = 0; i2 < m2762b; i2++) {
                    bufferedSink.mo2573a(headers.m2766a(i2)).write(f8364g).mo2573a(headers.m2761b(i2)).write(f8365h);
                }
            }
            MediaType mo643b = requestBody.mo643b();
            if (mo643b != null) {
                bufferedSink.mo2573a("Content-Type: ").mo2573a(mo643b.toString()).write(f8365h);
            }
            long mo645a = requestBody.mo645a();
            if (mo645a != -1) {
                bufferedSink.mo2573a("Content-Length: ").mo2571f(mo645a).write(f8365h);
            } else if (z) {
                buffer.m2612l();
                return -1L;
            }
            bufferedSink.write(f8365h);
            if (z) {
                j += mo645a;
            } else {
                requestBody.mo644a(bufferedSink);
            }
            bufferedSink.write(f8365h);
        }
        bufferedSink.write(f8366i);
        bufferedSink.mo2575a(this.f8367a);
        bufferedSink.write(f8366i);
        bufferedSink.write(f8365h);
        if (z) {
            long m2605s = j + buffer.m2605s();
            buffer.m2612l();
            return m2605s;
        }
        return j;
    }

    /* compiled from: MultipartBody.java */
    /* renamed from: e.x$b */
    /* loaded from: classes.dex */
    public static final class C1814b {

        /* renamed from: a */
        public final Headers f8374a;

        /* renamed from: b */
        public final RequestBody f8375b;

        public C1814b(Headers headers, RequestBody requestBody) {
            this.f8374a = headers;
            this.f8375b = requestBody;
        }

        /* renamed from: a */
        public static C1814b m2684a(Headers headers, RequestBody requestBody) {
            if (requestBody != null) {
                if (headers != null && headers.m2765a("Content-Type") != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if (headers != null && headers.m2765a("Content-Length") != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                return new C1814b(headers, requestBody);
            }
            throw new NullPointerException("body == null");
        }

        /* renamed from: a */
        public static C1814b m2683a(String str, String str2, RequestBody requestBody) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=");
                MultipartBody.m2689a(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    MultipartBody.m2689a(sb, str2);
                }
                return m2684a(Headers.m2764a("Content-Disposition", sb.toString()), requestBody);
            }
            throw new NullPointerException("name == null");
        }
    }

    /* renamed from: a */
    public static StringBuilder m2689a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }
}
