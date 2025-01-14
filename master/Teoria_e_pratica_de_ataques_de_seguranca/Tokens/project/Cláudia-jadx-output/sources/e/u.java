package e;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: HttpUrl.java */
/* loaded from: classes.dex */
public final class u {
    public static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public final String f5921a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5922b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5923c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5924d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5925e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f5926f;

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f5927g;

    /* renamed from: h  reason: collision with root package name */
    public final String f5928h;

    /* renamed from: i  reason: collision with root package name */
    public final String f5929i;

    /* compiled from: HttpUrl.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f5930a;

        /* renamed from: d  reason: collision with root package name */
        public String f5933d;

        /* renamed from: g  reason: collision with root package name */
        public List<String> f5936g;

        /* renamed from: h  reason: collision with root package name */
        public String f5937h;

        /* renamed from: b  reason: collision with root package name */
        public String f5931b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f5932c = "";

        /* renamed from: e  reason: collision with root package name */
        public int f5934e = -1;

        /* renamed from: f  reason: collision with root package name */
        public final List<String> f5935f = new ArrayList();

        /* compiled from: HttpUrl.java */
        /* renamed from: e.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0121a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f5935f.add("");
        }

        public a a(int i2) {
            if (i2 > 0 && i2 <= 65535) {
                this.f5934e = i2;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i2);
        }

        public a b(String str) {
            if (str != null) {
                String b2 = b(str, 0, str.length());
                if (b2 != null) {
                    this.f5933d = b2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public final boolean c(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public a d() {
            int size = this.f5935f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f5935f.set(i2, u.a(this.f5935f.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.f5936g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f5936g.get(i3);
                    if (str != null) {
                        this.f5936g.set(i3, u.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f5937h;
            if (str2 != null) {
                this.f5937h = u.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a e(String str) {
            if (str != null) {
                this.f5932c = u.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public a f(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.f5930a = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.f5930a = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a g(String str) {
            if (str != null) {
                this.f5931b = u.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5930a);
            sb.append("://");
            if (!this.f5931b.isEmpty() || !this.f5932c.isEmpty()) {
                sb.append(this.f5931b);
                if (!this.f5932c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f5932c);
                }
                sb.append('@');
            }
            if (this.f5933d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f5933d);
                sb.append(']');
            } else {
                sb.append(this.f5933d);
            }
            int b2 = b();
            if (b2 != u.c(this.f5930a)) {
                sb.append(':');
                sb.append(b2);
            }
            u.b(sb, this.f5935f);
            if (this.f5936g != null) {
                sb.append('?');
                u.a(sb, this.f5936g);
            }
            if (this.f5937h != null) {
                sb.append('#');
                sb.append(this.f5937h);
            }
            return sb.toString();
        }

        public final void c() {
            List<String> list = this.f5935f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f5935f.isEmpty()) {
                List<String> list2 = this.f5935f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f5935f.add("");
        }

        public static int e(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        public static int g(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        public a a(String str) {
            this.f5936g = str != null ? u.e(u.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public int b() {
            int i2 = this.f5934e;
            return i2 != -1 ? i2 : u.c(this.f5930a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.net.InetAddress c(java.lang.String r10, int r11, int r12) {
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
                boolean r10 = a(r10, r5, r12, r0, r11)
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
                int r8 = e.u.a(r8)
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
            throw new UnsupportedOperationException("Method not decompiled: e.u.a.c(java.lang.String, int, int):java.net.InetAddress");
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (this.f5936g == null) {
                    this.f5936g = new ArrayList();
                }
                this.f5936g.add(u.a(str, " \"'<>#&=", true, false, true, true));
                this.f5936g.add(str2 != null ? u.a(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public a b(String str, String str2) {
            if (str != null) {
                if (this.f5936g == null) {
                    this.f5936g = new ArrayList();
                }
                this.f5936g.add(u.a(str, " \"'<>#&=", false, false, true, true));
                this.f5936g.add(str2 != null ? u.a(str2, " \"'<>#&=", false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public static int f(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static String b(String str, int i2, int i3) {
            InetAddress c2;
            String a2 = u.a(str, i2, i3, false);
            if (a2.contains(":")) {
                if (a2.startsWith("[") && a2.endsWith("]")) {
                    c2 = c(a2, 1, a2.length() - 1);
                } else {
                    c2 = c(a2, 0, a2.length());
                }
                if (c2 == null) {
                    return null;
                }
                byte[] address = c2.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError();
            }
            return e.i0.c.b(a2);
        }

        public u a() {
            if (this.f5930a != null) {
                if (this.f5933d != null) {
                    return new u(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final boolean d(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public static int d(String str, int i2, int i3) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(u.a(str, i2, i3, "", false, false, false, true));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public EnumC0121a a(u uVar, String str) {
            int a2;
            int i2;
            int i3;
            int a3 = e.i0.c.a(str, 0, str.length());
            int b2 = e.i0.c.b(str, a3, str.length());
            if (f(str, a3, b2) != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.f5930a = "https";
                    a3 += 6;
                } else if (str.regionMatches(true, a3, "http:", 0, 5)) {
                    this.f5930a = "http";
                    a3 += 5;
                } else {
                    return EnumC0121a.UNSUPPORTED_SCHEME;
                }
            } else if (uVar != null) {
                this.f5930a = uVar.f5921a;
            } else {
                return EnumC0121a.MISSING_SCHEME;
            }
            int g2 = g(str, a3, b2);
            char c2 = '?';
            char c3 = '#';
            if (g2 < 2 && uVar != null && uVar.f5921a.equals(this.f5930a)) {
                this.f5931b = uVar.f();
                this.f5932c = uVar.b();
                this.f5933d = uVar.f5924d;
                this.f5934e = uVar.f5925e;
                this.f5935f.clear();
                this.f5935f.addAll(uVar.d());
                if (a3 == b2 || str.charAt(a3) == '#') {
                    a(uVar.e());
                }
                i2 = a3;
            } else {
                int i4 = a3 + g2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = e.i0.c.a(str, i4, b2, "@/\\?#");
                    char charAt = a2 != b2 ? str.charAt(a2) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a4 = e.i0.c.a(str, i4, a2, ':');
                            i3 = a2;
                            String a5 = u.a(str, i4, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (z2) {
                                a5 = this.f5931b + "%40" + a5;
                            }
                            this.f5931b = a5;
                            if (a4 != i3) {
                                this.f5932c = u.a(str, a4 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i3 = a2;
                            this.f5932c += "%40" + u.a(str, i4, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        }
                        i4 = i3 + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                i2 = a2;
                int e2 = e(str, i4, i2);
                int i5 = e2 + 1;
                if (i5 < i2) {
                    this.f5933d = b(str, i4, e2);
                    this.f5934e = d(str, i5, i2);
                    if (this.f5934e == -1) {
                        return EnumC0121a.INVALID_PORT;
                    }
                } else {
                    this.f5933d = b(str, i4, e2);
                    this.f5934e = u.c(this.f5930a);
                }
                if (this.f5933d == null) {
                    return EnumC0121a.INVALID_HOST;
                }
            }
            int a6 = e.i0.c.a(str, i2, b2, "?#");
            a(str, i2, a6);
            if (a6 < b2 && str.charAt(a6) == '?') {
                int a7 = e.i0.c.a(str, a6, b2, '#');
                this.f5936g = u.e(u.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true));
                a6 = a7;
            }
            if (a6 < b2 && str.charAt(a6) == '#') {
                this.f5937h = u.a(str, 1 + a6, b2, "", true, false, false, false);
            }
            return EnumC0121a.SUCCESS;
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(java.lang.String r11, int r12, int r13) {
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
                java.util.List<java.lang.String> r0 = r10.f5935f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f5935f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f5935f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = e.i0.c.a(r11, r6, r13, r12)
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
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: e.u.a.a(java.lang.String, int, int):void");
        }

        public final void a(String str, int i2, int i3, boolean z, boolean z2) {
            String a2 = u.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (c(a2)) {
                return;
            }
            if (d(a2)) {
                c();
                return;
            }
            List<String> list = this.f5935f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f5935f;
                list2.set(list2.size() - 1, a2);
            } else {
                this.f5935f.add(a2);
            }
            if (z) {
                this.f5935f.add("");
            }
        }

        public static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
            int i5 = i4;
            while (i2 < i3) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i4) {
                    if (str.charAt(i2) != '.') {
                        return false;
                    }
                    i2++;
                }
                int i6 = i2;
                int i7 = 0;
                while (i6 < i3) {
                    char charAt = str.charAt(i6);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i6++;
                    }
                }
                if (i6 - i2 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i7;
                i5++;
                i2 = i6;
            }
            return i5 == i4 + 4;
        }

        public static String a(byte[] bArr) {
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            int i5 = 0;
            while (i3 < bArr.length) {
                int i6 = i3;
                while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                    i6 += 2;
                }
                int i7 = i6 - i3;
                if (i7 > i5 && i7 >= 4) {
                    i4 = i3;
                    i5 = i7;
                }
                i3 = i6 + 2;
            }
            f.c cVar = new f.c();
            while (i2 < bArr.length) {
                if (i2 == i4) {
                    cVar.writeByte(58);
                    i2 += i5;
                    if (i2 == 16) {
                        cVar.writeByte(58);
                    }
                } else {
                    if (i2 > 0) {
                        cVar.writeByte(58);
                    }
                    cVar.e(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                    i2 += 2;
                }
            }
            return cVar.q();
        }
    }

    public u(a aVar) {
        this.f5921a = aVar.f5930a;
        this.f5922b = a(aVar.f5931b, false);
        this.f5923c = a(aVar.f5932c, false);
        this.f5924d = aVar.f5933d;
        this.f5925e = aVar.b();
        this.f5926f = a(aVar.f5935f, false);
        List<String> list = aVar.f5936g;
        this.f5927g = list != null ? a(list, true) : null;
        String str = aVar.f5937h;
        this.f5928h = str != null ? a(str, false) : null;
        this.f5929i = aVar.toString();
    }

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static int c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String b() {
        if (this.f5923c.isEmpty()) {
            return "";
        }
        int indexOf = this.f5929i.indexOf(64);
        return this.f5929i.substring(this.f5929i.indexOf(58, this.f5921a.length() + 3) + 1, indexOf);
    }

    public List<String> d() {
        int indexOf = this.f5929i.indexOf(47, this.f5921a.length() + 3);
        String str = this.f5929i;
        int a2 = e.i0.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = e.i0.c.a(this.f5929i, i2, a2, '/');
            arrayList.add(this.f5929i.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String e() {
        if (this.f5927g == null) {
            return null;
        }
        int indexOf = this.f5929i.indexOf(63) + 1;
        String str = this.f5929i;
        return this.f5929i.substring(indexOf, e.i0.c.a(str, indexOf + 1, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).f5929i.equals(this.f5929i);
    }

    public String f() {
        if (this.f5922b.isEmpty()) {
            return "";
        }
        int length = this.f5921a.length() + 3;
        String str = this.f5929i;
        return this.f5929i.substring(length, e.i0.c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f5924d;
    }

    public boolean h() {
        return this.f5921a.equals("https");
    }

    public int hashCode() {
        return this.f5929i.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f5930a = this.f5921a;
        aVar.f5931b = f();
        aVar.f5932c = b();
        aVar.f5933d = this.f5924d;
        aVar.f5934e = this.f5925e != c(this.f5921a) ? this.f5925e : -1;
        aVar.f5935f.clear();
        aVar.f5935f.addAll(d());
        aVar.a(e());
        aVar.f5937h = a();
        return aVar;
    }

    public List<String> j() {
        return this.f5926f;
    }

    public int k() {
        return this.f5925e;
    }

    public String l() {
        if (this.f5927g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f5927g);
        return sb.toString();
    }

    public String m() {
        a a2 = a("/...");
        a2.g("");
        a2.e("");
        return a2.a().toString();
    }

    public String n() {
        return this.f5921a;
    }

    public URI o() {
        a i2 = i();
        i2.d();
        String aVar = i2.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String toString() {
        return this.f5929i;
    }

    public String c() {
        int indexOf = this.f5929i.indexOf(47, this.f5921a.length() + 3);
        String str = this.f5929i;
        return this.f5929i.substring(indexOf, e.i0.c.a(str, indexOf, str.length(), "?#"));
    }

    public static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static u d(String str) {
        a aVar = new a();
        if (aVar.a((u) null, str) == a.EnumC0121a.SUCCESS) {
            return aVar.a();
        }
        return null;
    }

    public String a() {
        if (this.f5928h == null) {
            return null;
        }
        return this.f5929i.substring(this.f5929i.indexOf(35) + 1);
    }

    public u b(String str) {
        a a2 = a(str);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    public a a(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0121a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    public final List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                f.c cVar = new f.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z);
                return cVar.q();
            }
        }
        return str.substring(i2, i3);
    }

    public static void a(f.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = a(str.charAt(i2 + 1));
                int a3 = a(str.charAt(i4));
                if (a2 != -1 && a3 != -1) {
                    cVar.writeByte((a2 << 4) + a3);
                    i2 = i4;
                }
                cVar.c(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.writeByte(32);
                }
                cVar.c(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && a(str.charAt(i2 + 1)) != -1 && a(str.charAt(i4)) != -1;
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            f.c cVar = new f.c();
            cVar.a(str, i2, i4);
            a(cVar, str, i4, i3, str2, z, z2, z3, z4);
            return cVar.q();
        }
        return str.substring(i2, i3);
    }

    public static void a(f.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        f.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.a(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i2, i3)))))) {
                    cVar.c(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new f.c();
                    }
                    cVar2.c(codePointAt);
                    while (!cVar2.e()) {
                        int readByte = cVar2.readByte() & 255;
                        cVar.writeByte(37);
                        cVar.writeByte((int) j[(readByte >> 4) & 15]);
                        cVar.writeByte((int) j[readByte & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
