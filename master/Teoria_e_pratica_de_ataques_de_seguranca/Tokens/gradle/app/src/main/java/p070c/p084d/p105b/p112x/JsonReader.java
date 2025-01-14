package p070c.p084d.p105b.p112x;

import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import p070c.p084d.p105b.p107v.JsonReaderInternalAccess;
import p070c.p084d.p105b.p107v.p108n.JsonTreeReader;

/* renamed from: c.d.b.x.a */
/* loaded from: classes.dex */
public class JsonReader implements Closeable {

    /* renamed from: q */
    public static final char[] f5896q = ")]}'\n".toCharArray();

    /* renamed from: a */
    public final Reader f5897a;

    /* renamed from: i */
    public long f5905i;

    /* renamed from: j */
    public int f5906j;

    /* renamed from: k */
    public String f5907k;

    /* renamed from: n */
    public int f5909n;

    /* renamed from: o */
    public String[] f5910o;

    /* renamed from: p */
    public int[] f5911p;

    /* renamed from: b */
    public boolean f5898b = false;

    /* renamed from: c */
    public final char[] f5899c = new char[1024];

    /* renamed from: d */
    public int f5900d = 0;

    /* renamed from: e */
    public int f5901e = 0;

    /* renamed from: f */
    public int f5902f = 0;

    /* renamed from: g */
    public int f5903g = 0;

    /* renamed from: h */
    public int f5904h = 0;

    /* renamed from: m */
    public int[] f5908m = new int[32];

    /* compiled from: JsonReader.java */
    /* renamed from: c.d.b.x.a$a */
    /* loaded from: classes.dex */
    public static class C1351a extends JsonReaderInternalAccess {
        @Override // p070c.p084d.p105b.p107v.JsonReaderInternalAccess
        /* renamed from: a */
        public void mo4705a(JsonReader jsonReader) {
            if (jsonReader instanceof JsonTreeReader) {
                ((JsonTreeReader) jsonReader).m4809L();
                return;
            }
            int i = jsonReader.f5904h;
            if (i == 0) {
                i = jsonReader.m4718n();
            }
            if (i == 13) {
                jsonReader.f5904h = 9;
            } else if (i == 12) {
                jsonReader.f5904h = 8;
            } else if (i == 14) {
                jsonReader.f5904h = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + jsonReader.mo4738C() + jsonReader.m4712t());
            }
        }
    }

    static {
        JsonReaderInternalAccess.f5725a = new C1351a();
    }

    public JsonReader(Reader reader) {
        this.f5909n = 0;
        int[] iArr = this.f5908m;
        int i = this.f5909n;
        this.f5909n = i + 1;
        iArr[i] = 6;
        this.f5910o = new String[32];
        this.f5911p = new int[32];
        if (reader != null) {
            this.f5897a = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    /* renamed from: A */
    public String mo4740A() {
        String str;
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 10) {
            str = m4739B();
        } else if (i == 8) {
            str = m4728b('\'');
        } else if (i == 9) {
            str = m4728b('\"');
        } else if (i == 11) {
            str = this.f5907k;
            this.f5907k = null;
        } else if (i == 15) {
            str = Long.toString(this.f5905i);
        } else if (i == 16) {
            str = new String(this.f5899c, this.f5900d, this.f5906j);
            this.f5900d += this.f5906j;
        } else {
            throw new IllegalStateException("Expected a string but was " + mo4738C() + m4712t());
        }
        this.f5904h = 0;
        int[] iArr = this.f5911p;
        int i2 = this.f5909n - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
        m4720l();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m4739B() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            r1 = 0
        L4:
            int r3 = r6.f5900d
            int r4 = r3 + r1
            int r5 = r6.f5901e
            if (r4 >= r5) goto L4f
            char[] r4 = r6.f5899c
            int r3 = r3 + r1
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5d
            r4 = 10
            if (r3 == r4) goto L5d
            r4 = 12
            if (r3 == r4) goto L5d
            r4 = 13
            if (r3 == r4) goto L5d
            r4 = 32
            if (r3 == r4) goto L5d
            r4 = 35
            if (r3 == r4) goto L4b
            r4 = 44
            if (r3 == r4) goto L5d
            r4 = 47
            if (r3 == r4) goto L4b
            r4 = 61
            if (r3 == r4) goto L4b
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5d
            r4 = 58
            if (r3 == r4) goto L5d
            r4 = 59
            if (r3 == r4) goto L4b
            switch(r3) {
                case 91: goto L5d;
                case 92: goto L4b;
                case 93: goto L5d;
                default: goto L48;
            }
        L48:
            int r1 = r1 + 1
            goto L4
        L4b:
            r6.m4720l()
            goto L5d
        L4f:
            char[] r3 = r6.f5899c
            int r3 = r3.length
            if (r1 >= r3) goto L5f
            int r3 = r1 + 1
            boolean r3 = r6.m4730a(r3)
            if (r3 == 0) goto L5d
            goto L4
        L5d:
            r0 = r1
            goto L7f
        L5f:
            if (r2 != 0) goto L6c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r1, r3)
            r2.<init>(r3)
        L6c:
            char[] r3 = r6.f5899c
            int r4 = r6.f5900d
            r2.append(r3, r4, r1)
            int r3 = r6.f5900d
            int r3 = r3 + r1
            r6.f5900d = r3
            r1 = 1
            boolean r1 = r6.m4730a(r1)
            if (r1 != 0) goto L3
        L7f:
            if (r2 != 0) goto L8b
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f5899c
            int r3 = r6.f5900d
            r1.<init>(r2, r3, r0)
            goto L96
        L8b:
            char[] r1 = r6.f5899c
            int r3 = r6.f5900d
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L96:
            int r2 = r6.f5900d
            int r2 = r2 + r0
            r6.f5900d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p105b.p112x.JsonReader.m4739B():java.lang.String");
    }

    /* renamed from: C */
    public JsonToken mo4738C() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: D */
    public final int m4737D() {
        int i;
        String str;
        String str2;
        char c = this.f5899c[this.f5900d];
        if (c == 't' || c == 'T') {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f5900d + i2 >= this.f5901e && !m4730a(i2 + 1)) {
                return 0;
            }
            char c2 = this.f5899c[this.f5900d + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f5900d + length < this.f5901e || m4730a(length + 1)) && m4731a(this.f5899c[this.f5900d + length])) {
            return 0;
        }
        this.f5900d += length;
        this.f5904h = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0098, code lost:
        if (m4731a(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009a, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009c, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a2, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a4, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00aa, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ac, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b1, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b2, code lost:
        r18.f5905i = r11;
        r18.f5900d += r3;
        r18.f5904h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bd, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c1, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c4, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c7, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c9, code lost:
        r18.f5906j = r3;
        r18.f5904h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cf, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00d0, code lost:
        return 0;
     */
    /* renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m4736E() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p105b.p112x.JsonReader.m4736E():int");
    }

    /* renamed from: F */
    public final char m4735F() {
        int i;
        int i2;
        if (this.f5900d == this.f5901e && !m4730a(1)) {
            m4723c("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.f5899c;
        int i3 = this.f5900d;
        this.f5900d = i3 + 1;
        char c = cArr[i3];
        if (c == '\n') {
            this.f5902f++;
            this.f5903g = this.f5900d;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c != 'b') {
                if (c != 'f') {
                    if (c != 'n') {
                        if (c != 'r') {
                            if (c != 't') {
                                if (c == 'u') {
                                    if (this.f5900d + 4 > this.f5901e && !m4730a(4)) {
                                        m4723c("Unterminated escape sequence");
                                        throw null;
                                    }
                                    char c2 = 0;
                                    int i4 = this.f5900d;
                                    int i5 = i4 + 4;
                                    while (i4 < i5) {
                                        char c3 = this.f5899c[i4];
                                        char c4 = (char) (c2 << 4);
                                        if (c3 < '0' || c3 > '9') {
                                            if (c3 >= 'a' && c3 <= 'f') {
                                                i = c3 - 'a';
                                            } else if (c3 < 'A' || c3 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.f5899c, this.f5900d, 4));
                                            } else {
                                                i = c3 - 'A';
                                            }
                                            i2 = i + 10;
                                        } else {
                                            i2 = c3 - '0';
                                        }
                                        c2 = (char) (c4 + i2);
                                        i4++;
                                    }
                                    this.f5900d += 4;
                                    return c2;
                                }
                                m4723c("Invalid escape sequence");
                                throw null;
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c;
    }

    /* renamed from: G */
    public final void m4734G() {
        char c;
        do {
            if (this.f5900d >= this.f5901e && !m4730a(1)) {
                return;
            }
            char[] cArr = this.f5899c;
            int i = this.f5900d;
            this.f5900d = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.f5902f++;
                this.f5903g = this.f5900d;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        m4720l();
     */
    /* renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4733H() {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f5900d
            int r2 = r1 + r0
            int r3 = r4.f5901e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f5899c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.m4720l()
        L4b:
            int r1 = r4.f5900d
            int r1 = r1 + r0
            r4.f5900d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f5900d = r1
            r0 = 1
            boolean r0 = r4.m4730a(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p105b.p112x.JsonReader.m4733H():void");
    }

    /* renamed from: I */
    public void mo4732I() {
        int i = 0;
        do {
            int i2 = this.f5904h;
            if (i2 == 0) {
                i2 = m4718n();
            }
            if (i2 == 3) {
                m4727b(1);
            } else if (i2 == 1) {
                m4727b(3);
            } else {
                if (i2 == 4) {
                    this.f5909n--;
                } else if (i2 == 2) {
                    this.f5909n--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        m4733H();
                    } else if (i2 == 8 || i2 == 12) {
                        m4724c('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        m4724c('\"');
                    } else if (i2 == 16) {
                        this.f5900d += this.f5906j;
                    }
                    this.f5904h = 0;
                }
                i--;
                this.f5904h = 0;
            }
            i++;
            this.f5904h = 0;
        } while (i != 0);
        int[] iArr = this.f5911p;
        int i3 = this.f5909n;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f5910o[i3 - 1] = "null";
    }

    /* renamed from: a */
    public final boolean m4731a(char c) {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m4720l();
        return false;
    }

    /* renamed from: b */
    public final void m4725b(boolean z) {
        this.f5898b = z;
    }

    /* renamed from: c */
    public final void m4724c(char c) {
        char[] cArr = this.f5899c;
        do {
            int i = this.f5900d;
            int i2 = this.f5901e;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f5900d = i3;
                    return;
                } else if (c2 == '\\') {
                    this.f5900d = i3;
                    m4735F();
                    i = this.f5900d;
                    i2 = this.f5901e;
                } else {
                    if (c2 == '\n') {
                        this.f5902f++;
                        this.f5903g = i3;
                    }
                    i = i3;
                }
            }
            this.f5900d = i;
        } while (m4730a(1));
        m4723c("Unterminated string");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5904h = 0;
        this.f5908m[0] = 8;
        this.f5909n = 1;
        this.f5897a.close();
    }

    /* renamed from: j */
    public void mo4722j() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 3) {
            m4727b(1);
            this.f5911p[this.f5909n - 1] = 0;
            this.f5904h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + mo4738C() + m4712t());
    }

    /* renamed from: k */
    public void mo4721k() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 1) {
            m4727b(3);
            this.f5904h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + mo4738C() + m4712t());
    }

    /* renamed from: l */
    public final void m4720l() {
        if (this.f5898b) {
            return;
        }
        m4723c("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* renamed from: m */
    public final void m4719m() {
        m4729a(true);
        this.f5900d--;
        int i = this.f5900d;
        char[] cArr = f5896q;
        if (i + cArr.length > this.f5901e && !m4730a(cArr.length)) {
            return;
        }
        int i2 = 0;
        while (true) {
            char[] cArr2 = f5896q;
            if (i2 < cArr2.length) {
                if (this.f5899c[this.f5900d + i2] != cArr2[i2]) {
                    return;
                }
                i2++;
            } else {
                this.f5900d += cArr2.length;
                return;
            }
        }
    }

    /* renamed from: n */
    public int m4718n() {
        int m4729a;
        int[] iArr = this.f5908m;
        int i = this.f5909n;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int m4729a2 = m4729a(true);
            if (m4729a2 != 44) {
                if (m4729a2 != 59) {
                    if (m4729a2 == 93) {
                        this.f5904h = 4;
                        return 4;
                    }
                    m4723c("Unterminated array");
                    throw null;
                }
                m4720l();
            }
        } else if (i2 == 3 || i2 == 5) {
            this.f5908m[this.f5909n - 1] = 4;
            if (i2 == 5 && (m4729a = m4729a(true)) != 44) {
                if (m4729a != 59) {
                    if (m4729a == 125) {
                        this.f5904h = 2;
                        return 2;
                    }
                    m4723c("Unterminated object");
                    throw null;
                }
                m4720l();
            }
            int m4729a3 = m4729a(true);
            if (m4729a3 == 34) {
                this.f5904h = 13;
                return 13;
            } else if (m4729a3 == 39) {
                m4720l();
                this.f5904h = 12;
                return 12;
            } else if (m4729a3 == 125) {
                if (i2 != 5) {
                    this.f5904h = 2;
                    return 2;
                }
                m4723c("Expected name");
                throw null;
            } else {
                m4720l();
                this.f5900d--;
                if (m4731a((char) m4729a3)) {
                    this.f5904h = 14;
                    return 14;
                }
                m4723c("Expected name");
                throw null;
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int m4729a4 = m4729a(true);
            if (m4729a4 != 58) {
                if (m4729a4 == 61) {
                    m4720l();
                    if (this.f5900d < this.f5901e || m4730a(1)) {
                        char[] cArr = this.f5899c;
                        int i3 = this.f5900d;
                        if (cArr[i3] == '>') {
                            this.f5900d = i3 + 1;
                        }
                    }
                } else {
                    m4723c("Expected ':'");
                    throw null;
                }
            }
        } else if (i2 == 6) {
            if (this.f5898b) {
                m4719m();
            }
            this.f5908m[this.f5909n - 1] = 7;
        } else if (i2 == 7) {
            if (m4729a(false) == -1) {
                this.f5904h = 17;
                return 17;
            }
            m4720l();
            this.f5900d--;
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int m4729a5 = m4729a(true);
        if (m4729a5 == 34) {
            this.f5904h = 9;
            return 9;
        } else if (m4729a5 == 39) {
            m4720l();
            this.f5904h = 8;
            return 8;
        } else {
            if (m4729a5 != 44 && m4729a5 != 59) {
                if (m4729a5 == 91) {
                    this.f5904h = 3;
                    return 3;
                } else if (m4729a5 != 93) {
                    if (m4729a5 != 123) {
                        this.f5900d--;
                        int m4737D = m4737D();
                        if (m4737D != 0) {
                            return m4737D;
                        }
                        int m4736E = m4736E();
                        if (m4736E != 0) {
                            return m4736E;
                        }
                        if (m4731a(this.f5899c[this.f5900d])) {
                            m4720l();
                            this.f5904h = 10;
                            return 10;
                        }
                        m4723c("Expected value");
                        throw null;
                    }
                    this.f5904h = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.f5904h = 4;
                    return 4;
                }
            }
            if (i2 != 1 && i2 != 2) {
                m4723c("Unexpected value");
                throw null;
            }
            m4720l();
            this.f5900d--;
            this.f5904h = 7;
            return 7;
        }
    }

    /* renamed from: o */
    public void mo4717o() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 4) {
            this.f5909n--;
            int[] iArr = this.f5911p;
            int i2 = this.f5909n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f5904h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + mo4738C() + m4712t());
    }

    /* renamed from: p */
    public void mo4716p() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 2) {
            this.f5909n--;
            String[] strArr = this.f5910o;
            int i2 = this.f5909n;
            strArr[i2] = null;
            int[] iArr = this.f5911p;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f5904h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + mo4738C() + m4712t());
    }

    /* renamed from: q */
    public String mo4715q() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.f5909n;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f5908m[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.f5911p[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.f5910o;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: r */
    public boolean mo4714r() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    /* renamed from: s */
    public final boolean m4713s() {
        return this.f5898b;
    }

    /* renamed from: t */
    public String m4712t() {
        return " at line " + (this.f5902f + 1) + " column " + ((this.f5900d - this.f5903g) + 1) + " path " + mo4715q();
    }

    public String toString() {
        return getClass().getSimpleName() + m4712t();
    }

    /* renamed from: u */
    public boolean mo4711u() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 5) {
            this.f5904h = 0;
            int[] iArr = this.f5911p;
            int i2 = this.f5909n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.f5904h = 0;
            int[] iArr2 = this.f5911p;
            int i3 = this.f5909n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + mo4738C() + m4712t());
        }
    }

    /* renamed from: v */
    public double mo4710v() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 15) {
            this.f5904h = 0;
            int[] iArr = this.f5911p;
            int i2 = this.f5909n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f5905i;
        }
        if (i == 16) {
            this.f5907k = new String(this.f5899c, this.f5900d, this.f5906j);
            this.f5900d += this.f5906j;
        } else if (i == 8 || i == 9) {
            this.f5907k = m4728b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f5907k = m4739B();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + mo4738C() + m4712t());
        }
        this.f5904h = 11;
        double parseDouble = Double.parseDouble(this.f5907k);
        if (!this.f5898b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + m4712t());
        }
        this.f5907k = null;
        this.f5904h = 0;
        int[] iArr2 = this.f5911p;
        int i3 = this.f5909n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    /* renamed from: w */
    public int mo4709w() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 15) {
            long j = this.f5905i;
            int i2 = (int) j;
            if (j == i2) {
                this.f5904h = 0;
                int[] iArr = this.f5911p;
                int i3 = this.f5909n - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.f5905i + m4712t());
        }
        if (i == 16) {
            this.f5907k = new String(this.f5899c, this.f5900d, this.f5906j);
            this.f5900d += this.f5906j;
        } else if (i != 8 && i != 9 && i != 10) {
            throw new IllegalStateException("Expected an int but was " + mo4738C() + m4712t());
        } else {
            if (i == 10) {
                this.f5907k = m4739B();
            } else {
                this.f5907k = m4728b(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f5907k);
                this.f5904h = 0;
                int[] iArr2 = this.f5911p;
                int i4 = this.f5909n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f5904h = 11;
        double parseDouble = Double.parseDouble(this.f5907k);
        int i5 = (int) parseDouble;
        if (i5 == parseDouble) {
            this.f5907k = null;
            this.f5904h = 0;
            int[] iArr3 = this.f5911p;
            int i6 = this.f5909n - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        throw new NumberFormatException("Expected an int but was " + this.f5907k + m4712t());
    }

    /* renamed from: x */
    public long mo4708x() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 15) {
            this.f5904h = 0;
            int[] iArr = this.f5911p;
            int i2 = this.f5909n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f5905i;
        }
        if (i == 16) {
            this.f5907k = new String(this.f5899c, this.f5900d, this.f5906j);
            this.f5900d += this.f5906j;
        } else if (i != 8 && i != 9 && i != 10) {
            throw new IllegalStateException("Expected a long but was " + mo4738C() + m4712t());
        } else {
            if (i == 10) {
                this.f5907k = m4739B();
            } else {
                this.f5907k = m4728b(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f5907k);
                this.f5904h = 0;
                int[] iArr2 = this.f5911p;
                int i3 = this.f5909n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f5904h = 11;
        double parseDouble = Double.parseDouble(this.f5907k);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.f5907k = null;
            this.f5904h = 0;
            int[] iArr3 = this.f5911p;
            int i4 = this.f5909n - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.f5907k + m4712t());
    }

    /* renamed from: y */
    public String mo4707y() {
        String m4728b;
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 14) {
            m4728b = m4739B();
        } else if (i == 12) {
            m4728b = m4728b('\'');
        } else if (i == 13) {
            m4728b = m4728b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + mo4738C() + m4712t());
        }
        this.f5904h = 0;
        this.f5910o[this.f5909n - 1] = m4728b;
        return m4728b;
    }

    /* renamed from: z */
    public void mo4706z() {
        int i = this.f5904h;
        if (i == 0) {
            i = m4718n();
        }
        if (i == 7) {
            this.f5904h = 0;
            int[] iArr = this.f5911p;
            int i2 = this.f5909n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + mo4738C() + m4712t());
    }

    /* renamed from: a */
    public final boolean m4730a(int i) {
        int i2;
        char[] cArr = this.f5899c;
        int i3 = this.f5903g;
        int i4 = this.f5900d;
        this.f5903g = i3 - i4;
        int i5 = this.f5901e;
        if (i5 != i4) {
            this.f5901e = i5 - i4;
            System.arraycopy(cArr, i4, cArr, 0, this.f5901e);
        } else {
            this.f5901e = 0;
        }
        this.f5900d = 0;
        do {
            Reader reader = this.f5897a;
            int i6 = this.f5901e;
            int read = reader.read(cArr, i6, cArr.length - i6);
            if (read == -1) {
                return false;
            }
            this.f5901e += read;
            if (this.f5902f == 0 && (i2 = this.f5903g) == 0 && this.f5901e > 0 && cArr[0] == 65279) {
                this.f5900d++;
                this.f5903g = i2 + 1;
                i++;
            }
        } while (this.f5901e < i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r2 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r5) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r2.append(r0, r5, r3 - r5);
        r10.f5900d = r3;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m4728b(char r11) {
        /*
            r10 = this;
            char[] r0 = r10.f5899c
            r1 = 0
            r2 = r1
        L4:
            int r3 = r10.f5900d
            int r4 = r10.f5901e
        L8:
            r5 = r3
        L9:
            r6 = 16
            r7 = 1
            if (r3 >= r4) goto L5c
            int r8 = r3 + 1
            char r3 = r0[r3]
            if (r3 != r11) goto L28
            r10.f5900d = r8
            int r8 = r8 - r5
            int r8 = r8 - r7
            if (r2 != 0) goto L20
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r5, r8)
            return r11
        L20:
            r2.append(r0, r5, r8)
            java.lang.String r11 = r2.toString()
            return r11
        L28:
            r9 = 92
            if (r3 != r9) goto L4f
            r10.f5900d = r8
            int r8 = r8 - r5
            int r8 = r8 - r7
            if (r2 != 0) goto L40
            int r2 = r8 + 1
            int r2 = r2 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r3.<init>(r2)
            r2 = r3
        L40:
            r2.append(r0, r5, r8)
            char r3 = r10.m4735F()
            r2.append(r3)
            int r3 = r10.f5900d
            int r4 = r10.f5901e
            goto L8
        L4f:
            r6 = 10
            if (r3 != r6) goto L5a
            int r3 = r10.f5902f
            int r3 = r3 + r7
            r10.f5902f = r3
            r10.f5903g = r8
        L5a:
            r3 = r8
            goto L9
        L5c:
            if (r2 != 0) goto L6c
            int r2 = r3 - r5
            int r2 = r2 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r4.<init>(r2)
            r2 = r4
        L6c:
            int r4 = r3 - r5
            r2.append(r0, r5, r4)
            r10.f5900d = r3
            boolean r3 = r10.m4730a(r7)
            if (r3 == 0) goto L7a
            goto L4
        L7a:
            java.lang.String r11 = "Unterminated string"
            r10.m4723c(r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p105b.p112x.JsonReader.m4728b(char):java.lang.String");
    }

    /* renamed from: a */
    public final int m4729a(boolean z) {
        char[] cArr = this.f5899c;
        int i = this.f5900d;
        int i2 = this.f5901e;
        while (true) {
            if (i == i2) {
                this.f5900d = i;
                if (!m4730a(1)) {
                    if (z) {
                        throw new EOFException("End of input" + m4712t());
                    }
                    return -1;
                }
                i = this.f5900d;
                i2 = this.f5901e;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f5902f++;
                this.f5903g = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f5900d = i3;
                    if (i3 == i2) {
                        this.f5900d--;
                        boolean m4730a = m4730a(2);
                        this.f5900d++;
                        if (!m4730a) {
                            return c;
                        }
                    }
                    m4720l();
                    int i4 = this.f5900d;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.f5900d = i4 + 1;
                        if (m4726b("*/")) {
                            i = this.f5900d + 2;
                            i2 = this.f5901e;
                        } else {
                            m4723c("Unterminated comment");
                            throw null;
                        }
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.f5900d = i4 + 1;
                        m4734G();
                        i = this.f5900d;
                        i2 = this.f5901e;
                    }
                } else if (c == '#') {
                    this.f5900d = i3;
                    m4720l();
                    m4734G();
                    i = this.f5900d;
                    i2 = this.f5901e;
                } else {
                    this.f5900d = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    /* renamed from: c */
    public final IOException m4723c(String str) {
        throw new MalformedJsonException(str + m4712t());
    }

    /* renamed from: b */
    public final void m4727b(int i) {
        int i2 = this.f5909n;
        int[] iArr = this.f5908m;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            int[] iArr3 = new int[i2 * 2];
            String[] strArr = new String[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.f5911p, 0, iArr3, 0, this.f5909n);
            System.arraycopy(this.f5910o, 0, strArr, 0, this.f5909n);
            this.f5908m = iArr2;
            this.f5911p = iArr3;
            this.f5910o = strArr;
        }
        int[] iArr4 = this.f5908m;
        int i3 = this.f5909n;
        this.f5909n = i3 + 1;
        iArr4[i3] = i;
    }

    /* renamed from: b */
    public final boolean m4726b(String str) {
        int length = str.length();
        while (true) {
            if (this.f5900d + length > this.f5901e && !m4730a(length)) {
                return false;
            }
            char[] cArr = this.f5899c;
            int i = this.f5900d;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.f5899c[this.f5900d + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.f5902f++;
            this.f5903g = i + 1;
            this.f5900d++;
        }
    }
}
