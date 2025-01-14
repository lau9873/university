package c.d.b.x;

import c.d.b.v.f;
import c.d.b.v.n.e;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public class a implements Closeable {
    public static final char[] q = ")]}'\n".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    public final Reader f3891a;

    /* renamed from: i  reason: collision with root package name */
    public long f3899i;
    public int j;
    public String k;
    public int n;
    public String[] o;
    public int[] p;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3892b = false;

    /* renamed from: c  reason: collision with root package name */
    public final char[] f3893c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    public int f3894d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f3895e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f3896f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f3897g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f3898h = 0;
    public int[] m = new int[32];

    /* compiled from: JsonReader.java */
    /* renamed from: c.d.b.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0068a extends f {
        @Override // c.d.b.v.f
        public void a(a aVar) {
            if (aVar instanceof e) {
                ((e) aVar).L();
                return;
            }
            int i2 = aVar.f3898h;
            if (i2 == 0) {
                i2 = aVar.n();
            }
            if (i2 == 13) {
                aVar.f3898h = 9;
            } else if (i2 == 12) {
                aVar.f3898h = 8;
            } else if (i2 == 14) {
                aVar.f3898h = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.C() + aVar.t());
            }
        }
    }

    static {
        f.f3773a = new C0068a();
    }

    public a(Reader reader) {
        this.n = 0;
        int[] iArr = this.m;
        int i2 = this.n;
        this.n = i2 + 1;
        iArr[i2] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader != null) {
            this.f3891a = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public String A() {
        String str;
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 10) {
            str = B();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b('\"');
        } else if (i2 == 11) {
            str = this.k;
            this.k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f3899i);
        } else if (i2 == 16) {
            str = new String(this.f3893c, this.f3894d, this.j);
            this.f3894d += this.j;
        } else {
            throw new IllegalStateException("Expected a string but was " + C() + t());
        }
        this.f3898h = 0;
        int[] iArr = this.p;
        int i3 = this.n - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
        l();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String B() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            r1 = 0
        L4:
            int r3 = r6.f3894d
            int r4 = r3 + r1
            int r5 = r6.f3895e
            if (r4 >= r5) goto L4f
            char[] r4 = r6.f3893c
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
            r6.l()
            goto L5d
        L4f:
            char[] r3 = r6.f3893c
            int r3 = r3.length
            if (r1 >= r3) goto L5f
            int r3 = r1 + 1
            boolean r3 = r6.a(r3)
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
            char[] r3 = r6.f3893c
            int r4 = r6.f3894d
            r2.append(r3, r4, r1)
            int r3 = r6.f3894d
            int r3 = r3 + r1
            r6.f3894d = r3
            r1 = 1
            boolean r1 = r6.a(r1)
            if (r1 != 0) goto L3
        L7f:
            if (r2 != 0) goto L8b
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f3893c
            int r3 = r6.f3894d
            r1.<init>(r2, r3, r0)
            goto L96
        L8b:
            char[] r1 = r6.f3893c
            int r3 = r6.f3894d
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L96:
            int r2 = r6.f3894d
            int r2 = r2 + r0
            r6.f3894d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.x.a.B():java.lang.String");
    }

    public b C() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final int D() {
        int i2;
        String str;
        String str2;
        char c2 = this.f3893c[this.f3894d];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f3894d + i3 >= this.f3895e && !a(i3 + 1)) {
                return 0;
            }
            char c3 = this.f3893c[this.f3894d + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f3894d + length < this.f3895e || a(length + 1)) && a(this.f3893c[this.f3894d + length])) {
            return 0;
        }
        this.f3894d += length;
        this.f3898h = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0098, code lost:
        if (a(r14) != false) goto L76;
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
        r18.f3899i = r11;
        r18.f3894d += r3;
        r18.f3898h = 15;
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
        r18.j = r3;
        r18.f3898h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cf, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00d0, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int E() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.x.a.E():int");
    }

    public final char F() {
        int i2;
        int i3;
        if (this.f3894d == this.f3895e && !a(1)) {
            c("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.f3893c;
        int i4 = this.f3894d;
        this.f3894d = i4 + 1;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f3896f++;
            this.f3897g = this.f3894d;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 != 'b') {
                if (c2 != 'f') {
                    if (c2 != 'n') {
                        if (c2 != 'r') {
                            if (c2 != 't') {
                                if (c2 == 'u') {
                                    if (this.f3894d + 4 > this.f3895e && !a(4)) {
                                        c("Unterminated escape sequence");
                                        throw null;
                                    }
                                    char c3 = 0;
                                    int i5 = this.f3894d;
                                    int i6 = i5 + 4;
                                    while (i5 < i6) {
                                        char c4 = this.f3893c[i5];
                                        char c5 = (char) (c3 << 4);
                                        if (c4 < '0' || c4 > '9') {
                                            if (c4 >= 'a' && c4 <= 'f') {
                                                i2 = c4 - 'a';
                                            } else if (c4 < 'A' || c4 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.f3893c, this.f3894d, 4));
                                            } else {
                                                i2 = c4 - 'A';
                                            }
                                            i3 = i2 + 10;
                                        } else {
                                            i3 = c4 - '0';
                                        }
                                        c3 = (char) (c5 + i3);
                                        i5++;
                                    }
                                    this.f3894d += 4;
                                    return c3;
                                }
                                c("Invalid escape sequence");
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
        return c2;
    }

    public final void G() {
        char c2;
        do {
            if (this.f3894d >= this.f3895e && !a(1)) {
                return;
            }
            char[] cArr = this.f3893c;
            int i2 = this.f3894d;
            this.f3894d = i2 + 1;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f3896f++;
                this.f3897g = this.f3894d;
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        l();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H() {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f3894d
            int r2 = r1 + r0
            int r3 = r4.f3895e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f3893c
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
            r4.l()
        L4b:
            int r1 = r4.f3894d
            int r1 = r1 + r0
            r4.f3894d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f3894d = r1
            r0 = 1
            boolean r0 = r4.a(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.x.a.H():void");
    }

    public void I() {
        int i2 = 0;
        do {
            int i3 = this.f3898h;
            if (i3 == 0) {
                i3 = n();
            }
            if (i3 == 3) {
                b(1);
            } else if (i3 == 1) {
                b(3);
            } else {
                if (i3 == 4) {
                    this.n--;
                } else if (i3 == 2) {
                    this.n--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        H();
                    } else if (i3 == 8 || i3 == 12) {
                        c('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        c('\"');
                    } else if (i3 == 16) {
                        this.f3894d += this.j;
                    }
                    this.f3898h = 0;
                }
                i2--;
                this.f3898h = 0;
            }
            i2++;
            this.f3898h = 0;
        } while (i2 != 0);
        int[] iArr = this.p;
        int i4 = this.n;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.o[i4 - 1] = "null";
    }

    public final boolean a(char c2) {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
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
        l();
        return false;
    }

    public final void b(boolean z) {
        this.f3892b = z;
    }

    public final void c(char c2) {
        char[] cArr = this.f3893c;
        do {
            int i2 = this.f3894d;
            int i3 = this.f3895e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f3894d = i4;
                    return;
                } else if (c3 == '\\') {
                    this.f3894d = i4;
                    F();
                    i2 = this.f3894d;
                    i3 = this.f3895e;
                } else {
                    if (c3 == '\n') {
                        this.f3896f++;
                        this.f3897g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f3894d = i2;
        } while (a(1));
        c("Unterminated string");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3898h = 0;
        this.m[0] = 8;
        this.n = 1;
        this.f3891a.close();
    }

    public void j() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 3) {
            b(1);
            this.p[this.n - 1] = 0;
            this.f3898h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + C() + t());
    }

    public void k() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 1) {
            b(3);
            this.f3898h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + C() + t());
    }

    public final void l() {
        if (this.f3892b) {
            return;
        }
        c("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final void m() {
        a(true);
        this.f3894d--;
        int i2 = this.f3894d;
        char[] cArr = q;
        if (i2 + cArr.length > this.f3895e && !a(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = q;
            if (i3 < cArr2.length) {
                if (this.f3893c[this.f3894d + i3] != cArr2[i3]) {
                    return;
                }
                i3++;
            } else {
                this.f3894d += cArr2.length;
                return;
            }
        }
    }

    public int n() {
        int a2;
        int[] iArr = this.m;
        int i2 = this.n;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int a3 = a(true);
            if (a3 != 44) {
                if (a3 != 59) {
                    if (a3 == 93) {
                        this.f3898h = 4;
                        return 4;
                    }
                    c("Unterminated array");
                    throw null;
                }
                l();
            }
        } else if (i3 == 3 || i3 == 5) {
            this.m[this.n - 1] = 4;
            if (i3 == 5 && (a2 = a(true)) != 44) {
                if (a2 != 59) {
                    if (a2 == 125) {
                        this.f3898h = 2;
                        return 2;
                    }
                    c("Unterminated object");
                    throw null;
                }
                l();
            }
            int a4 = a(true);
            if (a4 == 34) {
                this.f3898h = 13;
                return 13;
            } else if (a4 == 39) {
                l();
                this.f3898h = 12;
                return 12;
            } else if (a4 == 125) {
                if (i3 != 5) {
                    this.f3898h = 2;
                    return 2;
                }
                c("Expected name");
                throw null;
            } else {
                l();
                this.f3894d--;
                if (a((char) a4)) {
                    this.f3898h = 14;
                    return 14;
                }
                c("Expected name");
                throw null;
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int a5 = a(true);
            if (a5 != 58) {
                if (a5 == 61) {
                    l();
                    if (this.f3894d < this.f3895e || a(1)) {
                        char[] cArr = this.f3893c;
                        int i4 = this.f3894d;
                        if (cArr[i4] == '>') {
                            this.f3894d = i4 + 1;
                        }
                    }
                } else {
                    c("Expected ':'");
                    throw null;
                }
            }
        } else if (i3 == 6) {
            if (this.f3892b) {
                m();
            }
            this.m[this.n - 1] = 7;
        } else if (i3 == 7) {
            if (a(false) == -1) {
                this.f3898h = 17;
                return 17;
            }
            l();
            this.f3894d--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int a6 = a(true);
        if (a6 == 34) {
            this.f3898h = 9;
            return 9;
        } else if (a6 == 39) {
            l();
            this.f3898h = 8;
            return 8;
        } else {
            if (a6 != 44 && a6 != 59) {
                if (a6 == 91) {
                    this.f3898h = 3;
                    return 3;
                } else if (a6 != 93) {
                    if (a6 != 123) {
                        this.f3894d--;
                        int D = D();
                        if (D != 0) {
                            return D;
                        }
                        int E = E();
                        if (E != 0) {
                            return E;
                        }
                        if (a(this.f3893c[this.f3894d])) {
                            l();
                            this.f3898h = 10;
                            return 10;
                        }
                        c("Expected value");
                        throw null;
                    }
                    this.f3898h = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f3898h = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                c("Unexpected value");
                throw null;
            }
            l();
            this.f3894d--;
            this.f3898h = 7;
            return 7;
        }
    }

    public void o() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 4) {
            this.n--;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f3898h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + C() + t());
    }

    public void p() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 2) {
            this.n--;
            String[] strArr = this.o;
            int i3 = this.n;
            strArr[i3] = null;
            int[] iArr = this.p;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f3898h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + C() + t());
    }

    public String q() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.n;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.m[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.p[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.o;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public boolean r() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean s() {
        return this.f3892b;
    }

    public String t() {
        return " at line " + (this.f3896f + 1) + " column " + ((this.f3894d - this.f3897g) + 1) + " path " + q();
    }

    public String toString() {
        return getClass().getSimpleName() + t();
    }

    public boolean u() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 5) {
            this.f3898h = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f3898h = 0;
            int[] iArr2 = this.p;
            int i4 = this.n - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + C() + t());
        }
    }

    public double v() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 15) {
            this.f3898h = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f3899i;
        }
        if (i2 == 16) {
            this.k = new String(this.f3893c, this.f3894d, this.j);
            this.f3894d += this.j;
        } else if (i2 == 8 || i2 == 9) {
            this.k = b(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.k = B();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + C() + t());
        }
        this.f3898h = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (!this.f3892b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + t());
        }
        this.k = null;
        this.f3898h = 0;
        int[] iArr2 = this.p;
        int i4 = this.n - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }

    public int w() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 15) {
            long j = this.f3899i;
            int i3 = (int) j;
            if (j == i3) {
                this.f3898h = 0;
                int[] iArr = this.p;
                int i4 = this.n - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f3899i + t());
        }
        if (i2 == 16) {
            this.k = new String(this.f3893c, this.f3894d, this.j);
            this.f3894d += this.j;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected an int but was " + C() + t());
        } else {
            if (i2 == 10) {
                this.k = B();
            } else {
                this.k = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.f3898h = 0;
                int[] iArr2 = this.p;
                int i5 = this.n - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3898h = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i6 = (int) parseDouble;
        if (i6 == parseDouble) {
            this.k = null;
            this.f3898h = 0;
            int[] iArr3 = this.p;
            int i7 = this.n - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.k + t());
    }

    public long x() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 15) {
            this.f3898h = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f3899i;
        }
        if (i2 == 16) {
            this.k = new String(this.f3893c, this.f3894d, this.j);
            this.f3894d += this.j;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected a long but was " + C() + t());
        } else {
            if (i2 == 10) {
                this.k = B();
            } else {
                this.k = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.f3898h = 0;
                int[] iArr2 = this.p;
                int i4 = this.n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3898h = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.k = null;
            this.f3898h = 0;
            int[] iArr3 = this.p;
            int i5 = this.n - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.k + t());
    }

    public String y() {
        String b2;
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 14) {
            b2 = B();
        } else if (i2 == 12) {
            b2 = b('\'');
        } else if (i2 == 13) {
            b2 = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + C() + t());
        }
        this.f3898h = 0;
        this.o[this.n - 1] = b2;
        return b2;
    }

    public void z() {
        int i2 = this.f3898h;
        if (i2 == 0) {
            i2 = n();
        }
        if (i2 == 7) {
            this.f3898h = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + C() + t());
    }

    public final boolean a(int i2) {
        int i3;
        char[] cArr = this.f3893c;
        int i4 = this.f3897g;
        int i5 = this.f3894d;
        this.f3897g = i4 - i5;
        int i6 = this.f3895e;
        if (i6 != i5) {
            this.f3895e = i6 - i5;
            System.arraycopy(cArr, i5, cArr, 0, this.f3895e);
        } else {
            this.f3895e = 0;
        }
        this.f3894d = 0;
        do {
            Reader reader = this.f3891a;
            int i7 = this.f3895e;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            this.f3895e += read;
            if (this.f3896f == 0 && (i3 = this.f3897g) == 0 && this.f3895e > 0 && cArr[0] == 65279) {
                this.f3894d++;
                this.f3897g = i3 + 1;
                i2++;
            }
        } while (this.f3895e < i2);
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
        r10.f3894d = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(char r11) {
        /*
            r10 = this;
            char[] r0 = r10.f3893c
            r1 = 0
            r2 = r1
        L4:
            int r3 = r10.f3894d
            int r4 = r10.f3895e
        L8:
            r5 = r3
        L9:
            r6 = 16
            r7 = 1
            if (r3 >= r4) goto L5c
            int r8 = r3 + 1
            char r3 = r0[r3]
            if (r3 != r11) goto L28
            r10.f3894d = r8
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
            r10.f3894d = r8
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
            char r3 = r10.F()
            r2.append(r3)
            int r3 = r10.f3894d
            int r4 = r10.f3895e
            goto L8
        L4f:
            r6 = 10
            if (r3 != r6) goto L5a
            int r3 = r10.f3896f
            int r3 = r3 + r7
            r10.f3896f = r3
            r10.f3897g = r8
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
            r10.f3894d = r3
            boolean r3 = r10.a(r7)
            if (r3 == 0) goto L7a
            goto L4
        L7a:
            java.lang.String r11 = "Unterminated string"
            r10.c(r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.x.a.b(char):java.lang.String");
    }

    public final int a(boolean z) {
        char[] cArr = this.f3893c;
        int i2 = this.f3894d;
        int i3 = this.f3895e;
        while (true) {
            if (i2 == i3) {
                this.f3894d = i2;
                if (!a(1)) {
                    if (z) {
                        throw new EOFException("End of input" + t());
                    }
                    return -1;
                }
                i2 = this.f3894d;
                i3 = this.f3895e;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f3896f++;
                this.f3897g = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f3894d = i4;
                    if (i4 == i3) {
                        this.f3894d--;
                        boolean a2 = a(2);
                        this.f3894d++;
                        if (!a2) {
                            return c2;
                        }
                    }
                    l();
                    int i5 = this.f3894d;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f3894d = i5 + 1;
                        if (b("*/")) {
                            i2 = this.f3894d + 2;
                            i3 = this.f3895e;
                        } else {
                            c("Unterminated comment");
                            throw null;
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f3894d = i5 + 1;
                        G();
                        i2 = this.f3894d;
                        i3 = this.f3895e;
                    }
                } else if (c2 == '#') {
                    this.f3894d = i4;
                    l();
                    G();
                    i2 = this.f3894d;
                    i3 = this.f3895e;
                } else {
                    this.f3894d = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    public final IOException c(String str) {
        throw new MalformedJsonException(str + t());
    }

    public final void b(int i2) {
        int i3 = this.n;
        int[] iArr = this.m;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            int[] iArr3 = new int[i3 * 2];
            String[] strArr = new String[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.p, 0, iArr3, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr2;
            this.p = iArr3;
            this.o = strArr;
        }
        int[] iArr4 = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iArr4[i4] = i2;
    }

    public final boolean b(String str) {
        int length = str.length();
        while (true) {
            if (this.f3894d + length > this.f3895e && !a(length)) {
                return false;
            }
            char[] cArr = this.f3893c;
            int i2 = this.f3894d;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f3893c[this.f3894d + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f3896f++;
            this.f3897g = i2 + 1;
            this.f3894d++;
        }
    }
}
