package p181e.p182i0.p187i;

import com.j256.ormlite.logger.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p181e.p182i0.Util;
import p192f.Buffer;
import p192f.BufferedSource;
import p192f.C1822f;
import p192f.Okio;
import p192f.Source;

/* renamed from: e.i0.i.c */
/* loaded from: classes.dex */
public final class Hpack {

    /* renamed from: a */
    public static final C1766b[] f8073a = {new C1766b(C1766b.f8069i, ""), new C1766b(C1766b.f8066f, "GET"), new C1766b(C1766b.f8066f, "POST"), new C1766b(C1766b.f8067g, "/"), new C1766b(C1766b.f8067g, "/index.html"), new C1766b(C1766b.f8068h, "http"), new C1766b(C1766b.f8068h, "https"), new C1766b(C1766b.f8065e, "200"), new C1766b(C1766b.f8065e, "204"), new C1766b(C1766b.f8065e, "206"), new C1766b(C1766b.f8065e, "304"), new C1766b(C1766b.f8065e, "400"), new C1766b(C1766b.f8065e, "404"), new C1766b(C1766b.f8065e, "500"), new C1766b("accept-charset", ""), new C1766b("accept-encoding", "gzip, deflate"), new C1766b("accept-language", ""), new C1766b("accept-ranges", ""), new C1766b("accept", ""), new C1766b("access-control-allow-origin", ""), new C1766b("age", ""), new C1766b("allow", ""), new C1766b("authorization", ""), new C1766b("cache-control", ""), new C1766b("content-disposition", ""), new C1766b("content-encoding", ""), new C1766b("content-language", ""), new C1766b("content-length", ""), new C1766b("content-location", ""), new C1766b("content-range", ""), new C1766b("content-type", ""), new C1766b("cookie", ""), new C1766b("date", ""), new C1766b("etag", ""), new C1766b("expect", ""), new C1766b("expires", ""), new C1766b("from", ""), new C1766b("host", ""), new C1766b("if-match", ""), new C1766b("if-modified-since", ""), new C1766b("if-none-match", ""), new C1766b("if-range", ""), new C1766b("if-unmodified-since", ""), new C1766b("last-modified", ""), new C1766b("link", ""), new C1766b("location", ""), new C1766b("max-forwards", ""), new C1766b("proxy-authenticate", ""), new C1766b("proxy-authorization", ""), new C1766b("range", ""), new C1766b("referer", ""), new C1766b("refresh", ""), new C1766b("retry-after", ""), new C1766b("server", ""), new C1766b("set-cookie", ""), new C1766b("strict-transport-security", ""), new C1766b("transfer-encoding", ""), new C1766b("user-agent", ""), new C1766b("vary", ""), new C1766b("via", ""), new C1766b("www-authenticate", "")};

    /* renamed from: b */
    public static final Map<C1822f, Integer> f8074b = m3033a();

    /* compiled from: Hpack.java */
    /* renamed from: e.i0.i.c$a */
    /* loaded from: classes.dex */
    public static final class C1767a {

        /* renamed from: a */
        public final List<C1766b> f8075a;

        /* renamed from: b */
        public final BufferedSource f8076b;

        /* renamed from: c */
        public final int f8077c;

        /* renamed from: d */
        public int f8078d;

        /* renamed from: e */
        public C1766b[] f8079e;

        /* renamed from: f */
        public int f8080f;

        /* renamed from: g */
        public int f8081g;

        /* renamed from: h */
        public int f8082h;

        public C1767a(int i, Source source) {
            this(i, i, source);
        }

        /* renamed from: a */
        public final void m3031a() {
            int i = this.f8078d;
            int i2 = this.f8082h;
            if (i < i2) {
                if (i == 0) {
                    m3027b();
                } else {
                    m3026b(i2 - i);
                }
            }
        }

        /* renamed from: b */
        public final void m3027b() {
            Arrays.fill(this.f8079e, (Object) null);
            this.f8080f = this.f8079e.length - 1;
            this.f8081g = 0;
            this.f8082h = 0;
        }

        /* renamed from: c */
        public List<C1766b> m3025c() {
            ArrayList arrayList = new ArrayList(this.f8075a);
            this.f8075a.clear();
            return arrayList;
        }

        /* renamed from: d */
        public final boolean m3022d(int i) {
            return i >= 0 && i <= Hpack.f8073a.length - 1;
        }

        /* renamed from: e */
        public final void m3020e(int i) {
            if (m3022d(i)) {
                this.f8075a.add(Hpack.f8073a[i]);
                return;
            }
            int m3030a = m3030a(i - Hpack.f8073a.length);
            if (m3030a >= 0) {
                C1766b[] c1766bArr = this.f8079e;
                if (m3030a <= c1766bArr.length - 1) {
                    this.f8075a.add(c1766bArr[m3030a]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: f */
        public void m3019f() {
            while (!this.f8076b.mo2557e()) {
                int readByte = this.f8076b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & Logger.DEFAULT_FULL_MESSAGE_LENGTH) == 128) {
                    m3020e(m3029a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    m3017g();
                } else if ((readByte & 64) == 64) {
                    m3018f(m3029a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.f8078d = m3029a(readByte, 31);
                    int i = this.f8078d;
                    if (i >= 0 && i <= this.f8077c) {
                        m3031a();
                    } else {
                        throw new IOException("Invalid dynamic table size update " + this.f8078d);
                    }
                } else if (readByte != 16 && readByte != 0) {
                    m3016g(m3029a(readByte, 15) - 1);
                } else {
                    m3015h();
                }
            }
        }

        /* renamed from: g */
        public final void m3016g(int i) {
            this.f8075a.add(new C1766b(m3024c(i), m3021e()));
        }

        /* renamed from: h */
        public final void m3015h() {
            C1822f m3021e = m3021e();
            Hpack.m3032a(m3021e);
            this.f8075a.add(new C1766b(m3021e, m3021e()));
        }

        public C1767a(int i, int i2, Source source) {
            this.f8075a = new ArrayList();
            this.f8079e = new C1766b[8];
            this.f8080f = this.f8079e.length - 1;
            this.f8081g = 0;
            this.f8082h = 0;
            this.f8077c = i;
            this.f8078d = i2;
            this.f8076b = Okio.m2586a(source);
        }

        /* renamed from: d */
        public final int m3023d() {
            return this.f8076b.readByte() & 255;
        }

        /* renamed from: c */
        public final C1822f m3024c(int i) {
            if (m3022d(i)) {
                return Hpack.f8073a[i].f8070a;
            }
            return this.f8079e[m3030a(i - Hpack.f8073a.length)].f8070a;
        }

        /* renamed from: a */
        public final int m3030a(int i) {
            return this.f8080f + 1 + i;
        }

        /* renamed from: g */
        public final void m3017g() {
            C1822f m3021e = m3021e();
            Hpack.m3032a(m3021e);
            m3028a(-1, new C1766b(m3021e, m3021e()));
        }

        /* renamed from: a */
        public final void m3028a(int i, C1766b c1766b) {
            this.f8075a.add(c1766b);
            int i2 = c1766b.f8072c;
            if (i != -1) {
                i2 -= this.f8079e[m3030a(i)].f8072c;
            }
            int i3 = this.f8078d;
            if (i2 > i3) {
                m3027b();
                return;
            }
            int m3026b = m3026b((this.f8082h + i2) - i3);
            if (i == -1) {
                int i4 = this.f8081g + 1;
                C1766b[] c1766bArr = this.f8079e;
                if (i4 > c1766bArr.length) {
                    C1766b[] c1766bArr2 = new C1766b[c1766bArr.length * 2];
                    System.arraycopy(c1766bArr, 0, c1766bArr2, c1766bArr.length, c1766bArr.length);
                    this.f8080f = this.f8079e.length - 1;
                    this.f8079e = c1766bArr2;
                }
                int i5 = this.f8080f;
                this.f8080f = i5 - 1;
                this.f8079e[i5] = c1766b;
                this.f8081g++;
            } else {
                this.f8079e[i + m3030a(i) + m3026b] = c1766b;
            }
            this.f8082h += i2;
        }

        /* renamed from: b */
        public final int m3026b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f8079e.length;
                while (true) {
                    length--;
                    if (length < this.f8080f || i <= 0) {
                        break;
                    }
                    C1766b[] c1766bArr = this.f8079e;
                    i -= c1766bArr[length].f8072c;
                    this.f8082h -= c1766bArr[length].f8072c;
                    this.f8081g--;
                    i2++;
                }
                C1766b[] c1766bArr2 = this.f8079e;
                int i3 = this.f8080f;
                System.arraycopy(c1766bArr2, i3 + 1, c1766bArr2, i3 + 1 + i2, this.f8081g);
                this.f8080f += i2;
            }
            return i2;
        }

        /* renamed from: e */
        public C1822f m3021e() {
            int m3023d = m3023d();
            boolean z = (m3023d & Logger.DEFAULT_FULL_MESSAGE_LENGTH) == 128;
            int m3029a = m3029a(m3023d, 127);
            if (z) {
                return C1822f.m2599a(Huffman.m2893b().m2894a(this.f8076b.mo2560c(m3029a)));
            }
            return this.f8076b.mo2562b(m3029a);
        }

        /* renamed from: f */
        public final void m3018f(int i) {
            m3028a(-1, new C1766b(m3024c(i), m3021e()));
        }

        /* renamed from: a */
        public int m3029a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int m3023d = m3023d();
                if ((m3023d & Logger.DEFAULT_FULL_MESSAGE_LENGTH) == 0) {
                    return i2 + (m3023d << i4);
                }
                i2 += (m3023d & 127) << i4;
                i4 += 7;
            }
        }
    }

    /* compiled from: Hpack.java */
    /* renamed from: e.i0.i.c$b */
    /* loaded from: classes.dex */
    public static final class C1768b {

        /* renamed from: a */
        public final Buffer f8083a;

        /* renamed from: b */
        public final boolean f8084b;

        /* renamed from: c */
        public int f8085c;

        /* renamed from: d */
        public boolean f8086d;

        /* renamed from: e */
        public int f8087e;

        /* renamed from: f */
        public C1766b[] f8088f;

        /* renamed from: g */
        public int f8089g;

        /* renamed from: h */
        public int f8090h;

        /* renamed from: i */
        public int f8091i;

        public C1768b(Buffer buffer) {
            this(4096, true, buffer);
        }

        /* renamed from: a */
        public final int m3013a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f8088f.length;
                while (true) {
                    length--;
                    if (length < this.f8089g || i <= 0) {
                        break;
                    }
                    C1766b[] c1766bArr = this.f8088f;
                    i -= c1766bArr[length].f8072c;
                    this.f8091i -= c1766bArr[length].f8072c;
                    this.f8090h--;
                    i2++;
                }
                C1766b[] c1766bArr2 = this.f8088f;
                int i3 = this.f8089g;
                System.arraycopy(c1766bArr2, i3 + 1, c1766bArr2, i3 + 1 + i2, this.f8090h);
                C1766b[] c1766bArr3 = this.f8088f;
                int i4 = this.f8089g;
                Arrays.fill(c1766bArr3, i4 + 1, i4 + 1 + i2, (Object) null);
                this.f8089g += i2;
            }
            return i2;
        }

        /* renamed from: b */
        public final void m3008b() {
            Arrays.fill(this.f8088f, (Object) null);
            this.f8089g = this.f8088f.length - 1;
            this.f8090h = 0;
            this.f8091i = 0;
        }

        public C1768b(int i, boolean z, Buffer buffer) {
            this.f8085c = Integer.MAX_VALUE;
            this.f8088f = new C1766b[8];
            this.f8089g = this.f8088f.length - 1;
            this.f8090h = 0;
            this.f8091i = 0;
            this.f8087e = i;
            this.f8084b = z;
            this.f8083a = buffer;
        }

        /* renamed from: b */
        public void m3007b(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.f8087e;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.f8085c = Math.min(this.f8085c, min);
            }
            this.f8086d = true;
            this.f8087e = min;
            m3014a();
        }

        /* renamed from: a */
        public final void m3011a(C1766b c1766b) {
            int i = c1766b.f8072c;
            int i2 = this.f8087e;
            if (i > i2) {
                m3008b();
                return;
            }
            m3013a((this.f8091i + i) - i2);
            int i3 = this.f8090h + 1;
            C1766b[] c1766bArr = this.f8088f;
            if (i3 > c1766bArr.length) {
                C1766b[] c1766bArr2 = new C1766b[c1766bArr.length * 2];
                System.arraycopy(c1766bArr, 0, c1766bArr2, c1766bArr.length, c1766bArr.length);
                this.f8089g = this.f8088f.length - 1;
                this.f8088f = c1766bArr2;
            }
            int i4 = this.f8089g;
            this.f8089g = i4 - 1;
            this.f8088f[i4] = c1766b;
            this.f8090h++;
            this.f8091i += i;
        }

        /* renamed from: a */
        public void m3009a(List<C1766b> list) {
            int i;
            int i2;
            if (this.f8086d) {
                int i3 = this.f8085c;
                if (i3 < this.f8087e) {
                    m3012a(i3, 31, 32);
                }
                this.f8086d = false;
                this.f8085c = Integer.MAX_VALUE;
                m3012a(this.f8087e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                C1766b c1766b = list.get(i4);
                C1822f mo2534g = c1766b.f8070a.mo2534g();
                C1822f c1822f = c1766b.f8071b;
                Integer num = Hpack.f8074b.get(mo2534g);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        if (Util.m3167a(Hpack.f8073a[i - 1].f8071b, c1822f)) {
                            i2 = i;
                        } else if (Util.m3167a(Hpack.f8073a[i].f8071b, c1822f)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.f8089g + 1;
                    int length = this.f8088f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (Util.m3167a(this.f8088f[i5].f8070a, mo2534g)) {
                            if (Util.m3167a(this.f8088f[i5].f8071b, c1822f)) {
                                i = Hpack.f8073a.length + (i5 - this.f8089g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.f8089g) + Hpack.f8073a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    m3012a(i, 127, Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                } else if (i2 == -1) {
                    this.f8083a.writeByte(64);
                    m3010a(mo2534g);
                    m3010a(c1822f);
                    m3011a(c1766b);
                } else if (mo2534g.m2598b(C1766b.f8064d) && !C1766b.f8069i.equals(mo2534g)) {
                    m3012a(i2, 15, 0);
                    m3010a(c1822f);
                } else {
                    m3012a(i2, 63, 64);
                    m3010a(c1822f);
                    m3011a(c1766b);
                }
            }
        }

        /* renamed from: a */
        public void m3012a(int i, int i2, int i3) {
            if (i < i2) {
                this.f8083a.writeByte(i | i3);
                return;
            }
            this.f8083a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f8083a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f8083a.writeByte(i4);
        }

        /* renamed from: a */
        public void m3010a(C1822f c1822f) {
            if (this.f8084b && Huffman.m2893b().m2896a(c1822f) < c1822f.mo2535f()) {
                Buffer buffer = new Buffer();
                Huffman.m2893b().m2895a(c1822f, buffer);
                C1822f m2608p = buffer.m2608p();
                m3012a(m2608p.mo2535f(), 127, Logger.DEFAULT_FULL_MESSAGE_LENGTH);
                this.f8083a.mo2575a(m2608p);
                return;
            }
            m3012a(c1822f.mo2535f(), 127, 0);
            this.f8083a.mo2575a(c1822f);
        }

        /* renamed from: a */
        public final void m3014a() {
            int i = this.f8087e;
            int i2 = this.f8091i;
            if (i < i2) {
                if (i == 0) {
                    m3008b();
                } else {
                    m3013a(i2 - i);
                }
            }
        }
    }

    /* renamed from: a */
    public static Map<C1822f, Integer> m3033a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f8073a.length);
        int i = 0;
        while (true) {
            C1766b[] c1766bArr = f8073a;
            if (i < c1766bArr.length) {
                if (!linkedHashMap.containsKey(c1766bArr[i].f8070a)) {
                    linkedHashMap.put(f8073a[i].f8070a, Integer.valueOf(i));
                }
                i++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }

    /* renamed from: a */
    public static C1822f m3032a(C1822f c1822f) {
        int mo2535f = c1822f.mo2535f();
        for (int i = 0; i < mo2535f; i++) {
            byte mo2545a = c1822f.mo2545a(i);
            if (mo2545a >= 65 && mo2545a <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c1822f.mo2532i());
            }
        }
        return c1822f;
    }
}
