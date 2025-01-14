package p181e;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p181e.p182i0.Util;
import p192f.Buffer;

/* renamed from: e.u */
/* loaded from: classes.dex */
public final class HttpUrl {

    /* renamed from: j */
    public static final char[] f8333j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public final String f8334a;

    /* renamed from: b */
    public final String f8335b;

    /* renamed from: c */
    public final String f8336c;

    /* renamed from: d */
    public final String f8337d;

    /* renamed from: e */
    public final int f8338e;

    /* renamed from: f */
    public final List<String> f8339f;

    /* renamed from: g */
    public final List<String> f8340g;

    /* renamed from: h */
    public final String f8341h;

    /* renamed from: i */
    public final String f8342i;

    /* compiled from: HttpUrl.java */
    /* renamed from: e.u$a */
    /* loaded from: classes.dex */
    public static final class C1810a {

        /* renamed from: a */
        public String f8343a;

        /* renamed from: d */
        public String f8346d;

        /* renamed from: g */
        public List<String> f8349g;

        /* renamed from: h */
        public String f8350h;

        /* renamed from: b */
        public String f8344b = "";

        /* renamed from: c */
        public String f8345c = "";

        /* renamed from: e */
        public int f8347e = -1;

        /* renamed from: f */
        public final List<String> f8348f = new ArrayList();

        /* compiled from: HttpUrl.java */
        /* renamed from: e.u$a$a */
        /* loaded from: classes.dex */
        public enum EnumC1811a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public C1810a() {
            this.f8348f.add("");
        }

        /* renamed from: a */
        public C1810a m2720a(int i) {
            if (i > 0 && i <= 65535) {
                this.f8347e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        /* renamed from: b */
        public C1810a m2711b(String str) {
            if (str != null) {
                String m2710b = m2710b(str, 0, str.length());
                if (m2710b != null) {
                    this.f8346d = m2710b;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* renamed from: c */
        public final boolean m2707c(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: d */
        public C1810a m2705d() {
            int size = this.f8348f.size();
            for (int i = 0; i < size; i++) {
                this.f8348f.set(i, HttpUrl.m2744a(this.f8348f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f8349g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f8349g.get(i2);
                    if (str != null) {
                        this.f8349g.set(i2, HttpUrl.m2744a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f8350h;
            if (str2 != null) {
                this.f8350h = HttpUrl.m2744a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* renamed from: e */
        public C1810a m2702e(String str) {
            if (str != null) {
                this.f8345c = HttpUrl.m2744a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        /* renamed from: f */
        public C1810a m2700f(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f8343a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f8343a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        /* renamed from: g */
        public C1810a m2698g(String str) {
            if (str != null) {
                this.f8344b = HttpUrl.m2744a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8343a);
            sb.append("://");
            if (!this.f8344b.isEmpty() || !this.f8345c.isEmpty()) {
                sb.append(this.f8344b);
                if (!this.f8345c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f8345c);
                }
                sb.append('@');
            }
            if (this.f8346d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f8346d);
                sb.append(']');
            } else {
                sb.append(this.f8346d);
            }
            int m2712b = m2712b();
            if (m2712b != HttpUrl.m2736c(this.f8343a)) {
                sb.append(':');
                sb.append(m2712b);
            }
            HttpUrl.m2738b(sb, this.f8348f);
            if (this.f8349g != null) {
                sb.append('?');
                HttpUrl.m2742a(sb, this.f8349g);
            }
            if (this.f8350h != null) {
                sb.append('#');
                sb.append(this.f8350h);
            }
            return sb.toString();
        }

        /* renamed from: c */
        public final void m2708c() {
            List<String> list = this.f8348f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f8348f.isEmpty()) {
                List<String> list2 = this.f8348f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f8348f.add("");
        }

        /* renamed from: e */
        public static int m2701e(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        /* renamed from: g */
        public static int m2697g(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: a */
        public C1810a m2718a(String str) {
            this.f8349g = str != null ? HttpUrl.m2732e(HttpUrl.m2744a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* renamed from: b */
        public int m2712b() {
            int i = this.f8347e;
            return i != -1 ? i : HttpUrl.m2736c(this.f8343a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0050  */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.net.InetAddress m2706c(java.lang.String r10, int r11, int r12) {
            /*
                r0 = 16
                byte[] r0 = new byte[r0]
                r1 = -1
                r2 = 0
                r3 = 0
                r4 = -1
                r5 = -1
            L9:
                r6 = 0
                if (r11 >= r12) goto L7b
                int r7 = r0.length
                if (r3 != r7) goto L10
                return r6
            L10:
                int r7 = r11 + 2
                if (r7 > r12) goto L28
                r8 = 2
                java.lang.String r9 = "::"
                boolean r8 = r10.regionMatches(r11, r9, r2, r8)
                if (r8 == 0) goto L28
                if (r4 == r1) goto L20
                return r6
            L20:
                int r3 = r3 + 2
                r4 = r3
                if (r7 != r12) goto L26
                goto L7b
            L26:
                r5 = r7
                goto L4c
            L28:
                if (r3 == 0) goto L4b
                r7 = 1
                java.lang.String r8 = ":"
                boolean r8 = r10.regionMatches(r11, r8, r2, r7)
                if (r8 == 0) goto L36
                int r11 = r11 + 1
                goto L4b
            L36:
                java.lang.String r8 = "."
                boolean r11 = r10.regionMatches(r11, r8, r2, r7)
                if (r11 == 0) goto L4a
                int r11 = r3 + (-2)
                boolean r10 = m2715a(r10, r5, r12, r0, r11)
                if (r10 != 0) goto L47
                return r6
            L47:
                int r3 = r3 + 2
                goto L7b
            L4a:
                return r6
            L4b:
                r5 = r11
            L4c:
                r11 = r5
                r7 = 0
            L4e:
                if (r11 >= r12) goto L61
                char r8 = r10.charAt(r11)
                int r8 = p181e.HttpUrl.m2751a(r8)
                if (r8 != r1) goto L5b
                goto L61
            L5b:
                int r7 = r7 << 4
                int r7 = r7 + r8
                int r11 = r11 + 1
                goto L4e
            L61:
                int r8 = r11 - r5
                if (r8 == 0) goto L7a
                r9 = 4
                if (r8 <= r9) goto L69
                goto L7a
            L69:
                int r6 = r3 + 1
                int r8 = r7 >>> 8
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r0[r3] = r8
                int r3 = r6 + 1
                r7 = r7 & 255(0xff, float:3.57E-43)
                byte r7 = (byte) r7
                r0[r6] = r7
                goto L9
            L7a:
                return r6
            L7b:
                int r10 = r0.length
                if (r3 == r10) goto L8e
                if (r4 != r1) goto L81
                return r6
            L81:
                int r10 = r0.length
                int r11 = r3 - r4
                int r10 = r10 - r11
                java.lang.System.arraycopy(r0, r4, r0, r10, r11)
                int r10 = r0.length
                int r10 = r10 - r3
                int r10 = r10 + r4
                java.util.Arrays.fill(r0, r4, r10, r2)
            L8e:
                java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L93
                return r10
            L93:
                java.lang.AssertionError r10 = new java.lang.AssertionError
                r10.<init>()
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: p181e.HttpUrl.C1810a.m2706c(java.lang.String, int, int):java.net.InetAddress");
        }

        /* renamed from: a */
        public C1810a m2714a(String str, String str2) {
            if (str != null) {
                if (this.f8349g == null) {
                    this.f8349g = new ArrayList();
                }
                this.f8349g.add(HttpUrl.m2744a(str, " \"'<>#&=", true, false, true, true));
                this.f8349g.add(str2 != null ? HttpUrl.m2744a(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        /* renamed from: b */
        public C1810a m2709b(String str, String str2) {
            if (str != null) {
                if (this.f8349g == null) {
                    this.f8349g = new ArrayList();
                }
                this.f8349g.add(HttpUrl.m2744a(str, " \"'<>#&=", false, false, true, true));
                this.f8349g.add(str2 != null ? HttpUrl.m2744a(str2, " \"'<>#&=", false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        /* renamed from: f */
        public static int m2699f(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: b */
        public static String m2710b(String str, int i, int i2) {
            InetAddress m2706c;
            String m2745a = HttpUrl.m2745a(str, i, i2, false);
            if (m2745a.contains(":")) {
                if (m2745a.startsWith("[") && m2745a.endsWith("]")) {
                    m2706c = m2706c(m2745a, 1, m2745a.length() - 1);
                } else {
                    m2706c = m2706c(m2745a, 0, m2745a.length());
                }
                if (m2706c == null) {
                    return null;
                }
                byte[] address = m2706c.getAddress();
                if (address.length == 16) {
                    return m2713a(address);
                }
                throw new AssertionError();
            }
            return Util.m3153b(m2745a);
        }

        /* renamed from: a */
        public HttpUrl m2721a() {
            if (this.f8343a != null) {
                if (this.f8346d != null) {
                    return new HttpUrl(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        /* renamed from: d */
        public final boolean m2704d(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: d */
        public static int m2703d(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.m2746a(str, i, i2, "", false, false, false, true));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        /* renamed from: a */
        public EnumC1811a m2719a(HttpUrl httpUrl, String str) {
            int m3163a;
            int i;
            int i2;
            int m3165a = Util.m3165a(str, 0, str.length());
            int m3152b = Util.m3152b(str, m3165a, str.length());
            if (m2699f(str, m3165a, m3152b) != -1) {
                if (str.regionMatches(true, m3165a, "https:", 0, 6)) {
                    this.f8343a = "https";
                    m3165a += 6;
                } else if (str.regionMatches(true, m3165a, "http:", 0, 5)) {
                    this.f8343a = "http";
                    m3165a += 5;
                } else {
                    return EnumC1811a.UNSUPPORTED_SCHEME;
                }
            } else if (httpUrl != null) {
                this.f8343a = httpUrl.f8334a;
            } else {
                return EnumC1811a.MISSING_SCHEME;
            }
            int m2697g = m2697g(str, m3165a, m3152b);
            char c = '?';
            char c2 = '#';
            if (m2697g < 2 && httpUrl != null && httpUrl.f8334a.equals(this.f8343a)) {
                this.f8344b = httpUrl.m2731f();
                this.f8345c = httpUrl.m2740b();
                this.f8346d = httpUrl.f8337d;
                this.f8347e = httpUrl.f8338e;
                this.f8348f.clear();
                this.f8348f.addAll(httpUrl.m2735d());
                if (m3165a == m3152b || str.charAt(m3165a) == '#') {
                    m2718a(httpUrl.m2733e());
                }
                i = m3165a;
            } else {
                int i3 = m3165a + m2697g;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    m3163a = Util.m3163a(str, i3, m3152b, "@/\\?#");
                    char charAt = m3163a != m3152b ? str.charAt(m3163a) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int m3164a = Util.m3164a(str, i3, m3163a, ':');
                            i2 = m3163a;
                            String m2746a = HttpUrl.m2746a(str, i3, m3164a, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (z2) {
                                m2746a = this.f8344b + "%40" + m2746a;
                            }
                            this.f8344b = m2746a;
                            if (m3164a != i2) {
                                this.f8345c = HttpUrl.m2746a(str, m3164a + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i2 = m3163a;
                            this.f8345c += "%40" + HttpUrl.m2746a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        }
                        i3 = i2 + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
                i = m3163a;
                int m2701e = m2701e(str, i3, i);
                int i4 = m2701e + 1;
                if (i4 < i) {
                    this.f8346d = m2710b(str, i3, m2701e);
                    this.f8347e = m2703d(str, i4, i);
                    if (this.f8347e == -1) {
                        return EnumC1811a.INVALID_PORT;
                    }
                } else {
                    this.f8346d = m2710b(str, i3, m2701e);
                    this.f8347e = HttpUrl.m2736c(this.f8343a);
                }
                if (this.f8346d == null) {
                    return EnumC1811a.INVALID_HOST;
                }
            }
            int m3163a2 = Util.m3163a(str, i, m3152b, "?#");
            m2717a(str, i, m3163a2);
            if (m3163a2 < m3152b && str.charAt(m3163a2) == '?') {
                int m3164a2 = Util.m3164a(str, m3163a2, m3152b, '#');
                this.f8349g = HttpUrl.m2732e(HttpUrl.m2746a(str, m3163a2 + 1, m3164a2, " \"'<>#", true, false, true, true));
                m3163a2 = m3164a2;
            }
            if (m3163a2 < m3152b && str.charAt(m3163a2) == '#') {
                this.f8350h = HttpUrl.m2746a(str, 1 + m3163a2, m3152b, "", true, false, false, false);
            }
            return EnumC1811a.SUCCESS;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m2717a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f8348f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f8348f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f8348f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = p181e.p182i0.Util.m3163a(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.m2716a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p181e.HttpUrl.C1810a.m2717a(java.lang.String, int, int):void");
        }

        /* renamed from: a */
        public final void m2716a(String str, int i, int i2, boolean z, boolean z2) {
            String m2746a = HttpUrl.m2746a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (m2707c(m2746a)) {
                return;
            }
            if (m2704d(m2746a)) {
                m2708c();
                return;
            }
            List<String> list = this.f8348f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f8348f;
                list2.set(list2.size() - 1, m2746a);
            } else {
                this.f8348f.add(m2746a);
            }
            if (z) {
                this.f8348f.add("");
            }
        }

        /* renamed from: a */
        public static boolean m2715a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        /* renamed from: a */
        public static String m2713a(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i2 < bArr.length) {
                int i5 = i2;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i2;
                if (i6 > i4 && i6 >= 4) {
                    i3 = i2;
                    i4 = i6;
                }
                i2 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i < bArr.length) {
                if (i == i3) {
                    buffer.writeByte(58);
                    i += i4;
                    if (i == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.mo2572e(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                    i += 2;
                }
            }
            return buffer.m2607q();
        }
    }

    public HttpUrl(C1810a c1810a) {
        this.f8334a = c1810a.f8343a;
        this.f8335b = m2743a(c1810a.f8344b, false);
        this.f8336c = m2743a(c1810a.f8345c, false);
        this.f8337d = c1810a.f8346d;
        this.f8338e = c1810a.m2712b();
        this.f8339f = m2741a(c1810a.f8348f, false);
        List<String> list = c1810a.f8349g;
        this.f8340g = list != null ? m2741a(list, true) : null;
        String str = c1810a.f8350h;
        this.f8341h = str != null ? m2743a(str, false) : null;
        this.f8342i = c1810a.toString();
    }

    /* renamed from: a */
    public static int m2751a(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    return -1;
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    /* renamed from: a */
    public static void m2742a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* renamed from: c */
    public static int m2736c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: b */
    public String m2740b() {
        if (this.f8336c.isEmpty()) {
            return "";
        }
        int indexOf = this.f8342i.indexOf(64);
        return this.f8342i.substring(this.f8342i.indexOf(58, this.f8334a.length() + 3) + 1, indexOf);
    }

    /* renamed from: d */
    public List<String> m2735d() {
        int indexOf = this.f8342i.indexOf(47, this.f8334a.length() + 3);
        String str = this.f8342i;
        int m3163a = Util.m3163a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < m3163a) {
            int i = indexOf + 1;
            int m3164a = Util.m3164a(this.f8342i, i, m3163a, '/');
            arrayList.add(this.f8342i.substring(i, m3164a));
            indexOf = m3164a;
        }
        return arrayList;
    }

    /* renamed from: e */
    public String m2733e() {
        if (this.f8340g == null) {
            return null;
        }
        int indexOf = this.f8342i.indexOf(63) + 1;
        String str = this.f8342i;
        return this.f8342i.substring(indexOf, Util.m3164a(str, indexOf + 1, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f8342i.equals(this.f8342i);
    }

    /* renamed from: f */
    public String m2731f() {
        if (this.f8335b.isEmpty()) {
            return "";
        }
        int length = this.f8334a.length() + 3;
        String str = this.f8342i;
        return this.f8342i.substring(length, Util.m3163a(str, length, str.length(), ":@"));
    }

    /* renamed from: g */
    public String m2730g() {
        return this.f8337d;
    }

    /* renamed from: h */
    public boolean m2729h() {
        return this.f8334a.equals("https");
    }

    public int hashCode() {
        return this.f8342i.hashCode();
    }

    /* renamed from: i */
    public C1810a m2728i() {
        C1810a c1810a = new C1810a();
        c1810a.f8343a = this.f8334a;
        c1810a.f8344b = m2731f();
        c1810a.f8345c = m2740b();
        c1810a.f8346d = this.f8337d;
        c1810a.f8347e = this.f8338e != m2736c(this.f8334a) ? this.f8338e : -1;
        c1810a.f8348f.clear();
        c1810a.f8348f.addAll(m2735d());
        c1810a.m2718a(m2733e());
        c1810a.f8350h = m2752a();
        return c1810a;
    }

    /* renamed from: j */
    public List<String> m2727j() {
        return this.f8339f;
    }

    /* renamed from: k */
    public int m2726k() {
        return this.f8338e;
    }

    /* renamed from: l */
    public String m2725l() {
        if (this.f8340g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m2742a(sb, this.f8340g);
        return sb.toString();
    }

    /* renamed from: m */
    public String m2724m() {
        C1810a m2748a = m2748a("/...");
        m2748a.m2698g("");
        m2748a.m2702e("");
        return m2748a.m2721a().toString();
    }

    /* renamed from: n */
    public String m2723n() {
        return this.f8334a;
    }

    /* renamed from: o */
    public URI m2722o() {
        C1810a m2728i = m2728i();
        m2728i.m2705d();
        String c1810a = m2728i.toString();
        try {
            return new URI(c1810a);
        } catch (URISyntaxException e) {
            try {
                return URI.create(c1810a.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return this.f8342i;
    }

    /* renamed from: c */
    public String m2737c() {
        int indexOf = this.f8342i.indexOf(47, this.f8334a.length() + 3);
        String str = this.f8342i;
        return this.f8342i.substring(indexOf, Util.m3163a(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: b */
    public static void m2738b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* renamed from: e */
    public static List<String> m2732e(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: d */
    public static HttpUrl m2734d(String str) {
        C1810a c1810a = new C1810a();
        if (c1810a.m2719a((HttpUrl) null, str) == C1810a.EnumC1811a.SUCCESS) {
            return c1810a.m2721a();
        }
        return null;
    }

    /* renamed from: a */
    public String m2752a() {
        if (this.f8341h == null) {
            return null;
        }
        return this.f8342i.substring(this.f8342i.indexOf(35) + 1);
    }

    /* renamed from: b */
    public HttpUrl m2739b(String str) {
        C1810a m2748a = m2748a(str);
        if (m2748a != null) {
            return m2748a.m2721a();
        }
        return null;
    }

    /* renamed from: a */
    public C1810a m2748a(String str) {
        C1810a c1810a = new C1810a();
        if (c1810a.m2719a(this, str) == C1810a.EnumC1811a.SUCCESS) {
            return c1810a;
        }
        return null;
    }

    /* renamed from: a */
    public static String m2743a(String str, boolean z) {
        return m2745a(str, 0, str.length(), z);
    }

    /* renamed from: a */
    public final List<String> m2741a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m2743a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public static String m2745a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.m2621a(str, i, i3);
                m2749a(buffer, str, i3, i2, z);
                return buffer.m2607q();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    public static void m2749a(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int m2751a = m2751a(str.charAt(i + 1));
                int m2751a2 = m2751a(str.charAt(i3));
                if (m2751a != -1 && m2751a2 != -1) {
                    buffer.writeByte((m2751a << 4) + m2751a2);
                    i = i3;
                }
                buffer.m2617c(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.m2617c(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    public static boolean m2747a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && m2751a(str.charAt(i + 1)) != -1 && m2751a(str.charAt(i3)) != -1;
    }

    /* renamed from: a */
    public static String m2746a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m2747a(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.m2621a(str, i, i3);
            m2750a(buffer, str, i3, i2, str2, z, z2, z3, z4);
            return buffer.m2607q();
        }
        return str.substring(i, i2);
    }

    /* renamed from: a */
    public static void m2750a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.mo2573a(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || m2747a(str, i, i2)))))) {
                    buffer.m2617c(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.m2617c(codePointAt);
                    while (!buffer2.mo2557e()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f8333j[(readByte >> 4) & 15]);
                        buffer.writeByte((int) f8333j[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: a */
    public static String m2744a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m2746a(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
