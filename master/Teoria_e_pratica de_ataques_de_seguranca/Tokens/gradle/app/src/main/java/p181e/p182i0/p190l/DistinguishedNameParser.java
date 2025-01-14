package p181e.p182i0.p190l;

import javax.security.auth.x500.X500Principal;

/* renamed from: e.i0.l.c */
/* loaded from: classes.dex */
public final class DistinguishedNameParser {

    /* renamed from: a */
    public final String f8259a;

    /* renamed from: b */
    public final int f8260b;

    /* renamed from: c */
    public int f8261c;

    /* renamed from: d */
    public int f8262d;

    /* renamed from: e */
    public int f8263e;

    /* renamed from: f */
    public int f8264f;

    /* renamed from: g */
    public char[] f8265g;

    public DistinguishedNameParser(X500Principal x500Principal) {
        this.f8259a = x500Principal.getName("RFC2253");
        this.f8260b = this.f8259a.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f8264f - r2);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m2841a() {
        /*
            r8 = this;
            int r0 = r8.f8261c
            r8.f8262d = r0
            r8.f8263e = r0
        L6:
            int r0 = r8.f8261c
            int r1 = r8.f8260b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f8265g
            int r2 = r8.f8262d
            int r3 = r8.f8263e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f8265g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f8263e
            int r3 = r2 + 1
            r8.f8263e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f8261c = r0
            goto L6
        L40:
            int r0 = r8.f8263e
            int r2 = r0 + 1
            r8.f8263e = r2
            char r2 = r8.m2838b()
            r1[r0] = r2
            int r0 = r8.f8261c
            int r0 = r0 + 1
            r8.f8261c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f8265g
            int r2 = r8.f8262d
            int r3 = r8.f8263e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f8263e
            r8.f8264f = r2
            int r0 = r0 + 1
            r8.f8261c = r0
            int r0 = r2 + 1
            r8.f8263e = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f8261c
            int r1 = r8.f8260b
            if (r0 >= r1) goto L87
            char[] r1 = r8.f8265g
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.f8263e
            int r7 = r2 + 1
            r8.f8263e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f8261c = r0
            goto L6e
        L87:
            int r0 = r8.f8261c
            int r1 = r8.f8260b
            if (r0 == r1) goto L9b
            char[] r1 = r8.f8265g
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f8265g
            int r2 = r8.f8262d
            int r3 = r8.f8264f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p181e.p182i0.p190l.DistinguishedNameParser.m2841a():java.lang.String");
    }

    /* renamed from: b */
    public final char m2838b() {
        this.f8261c++;
        int i = this.f8261c;
        if (i != this.f8260b) {
            char c = this.f8265g[i];
            if (c != ' ' && c != '%' && c != '\\' && c != '_' && c != '\"' && c != '#') {
                switch (c) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return m2837c();
                        }
                }
            }
            return this.f8265g[this.f8261c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f8259a);
    }

    /* renamed from: c */
    public final char m2837c() {
        int i;
        int i2;
        int m2840a = m2840a(this.f8261c);
        this.f8261c++;
        if (m2840a < 128) {
            return (char) m2840a;
        }
        if (m2840a < 192 || m2840a > 247) {
            return '?';
        }
        if (m2840a <= 223) {
            i2 = m2840a & 31;
            i = 1;
        } else if (m2840a <= 239) {
            i = 2;
            i2 = m2840a & 15;
        } else {
            i = 3;
            i2 = m2840a & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f8261c++;
            int i4 = this.f8261c;
            if (i4 == this.f8260b || this.f8265g[i4] != '\\') {
                return '?';
            }
            this.f8261c = i4 + 1;
            int m2840a2 = m2840a(this.f8261c);
            this.f8261c++;
            if ((m2840a2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (m2840a2 & 63);
        }
        return (char) i2;
    }

    /* renamed from: d */
    public final String m2836d() {
        int i = this.f8261c;
        if (i + 4 < this.f8260b) {
            this.f8262d = i;
            this.f8261c = i + 1;
            while (true) {
                int i2 = this.f8261c;
                if (i2 == this.f8260b) {
                    break;
                }
                char[] cArr = this.f8265g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f8263e = i2;
                    this.f8261c = i2 + 1;
                    while (true) {
                        int i3 = this.f8261c;
                        if (i3 >= this.f8260b || this.f8265g[i3] != ' ') {
                            break;
                        }
                        this.f8261c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f8261c++;
                }
            }
            this.f8263e = this.f8261c;
            int i4 = this.f8263e;
            int i5 = this.f8262d;
            int i6 = i4 - i5;
            if (i6 >= 5 && (i6 & 1) != 0) {
                byte[] bArr = new byte[i6 / 2];
                int i7 = i5 + 1;
                for (int i8 = 0; i8 < bArr.length; i8++) {
                    bArr[i8] = (byte) m2840a(i7);
                    i7 += 2;
                }
                return new String(this.f8265g, this.f8262d, i6);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f8259a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f8259a);
    }

    /* renamed from: e */
    public final String m2835e() {
        while (true) {
            int i = this.f8261c;
            if (i >= this.f8260b || this.f8265g[i] != ' ') {
                break;
            }
            this.f8261c = i + 1;
        }
        int i2 = this.f8261c;
        if (i2 == this.f8260b) {
            return null;
        }
        this.f8262d = i2;
        this.f8261c = i2 + 1;
        while (true) {
            int i3 = this.f8261c;
            if (i3 >= this.f8260b) {
                break;
            }
            char[] cArr = this.f8265g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f8261c = i3 + 1;
        }
        int i4 = this.f8261c;
        if (i4 < this.f8260b) {
            this.f8263e = i4;
            if (this.f8265g[i4] == ' ') {
                while (true) {
                    int i5 = this.f8261c;
                    if (i5 >= this.f8260b) {
                        break;
                    }
                    char[] cArr2 = this.f8265g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f8261c = i5 + 1;
                }
                char[] cArr3 = this.f8265g;
                int i6 = this.f8261c;
                if (cArr3[i6] != '=' || i6 == this.f8260b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f8259a);
                }
            }
            this.f8261c++;
            while (true) {
                int i7 = this.f8261c;
                if (i7 >= this.f8260b || this.f8265g[i7] != ' ') {
                    break;
                }
                this.f8261c = i7 + 1;
            }
            int i8 = this.f8263e;
            int i9 = this.f8262d;
            if (i8 - i9 > 4) {
                char[] cArr4 = this.f8265g;
                if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                    char[] cArr5 = this.f8265g;
                    int i10 = this.f8262d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f8265g;
                        int i11 = this.f8262d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f8262d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f8265g;
            int i12 = this.f8262d;
            return new String(cArr7, i12, this.f8263e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f8259a);
    }

    /* renamed from: f */
    public final String m2834f() {
        this.f8261c++;
        this.f8262d = this.f8261c;
        this.f8263e = this.f8262d;
        while (true) {
            int i = this.f8261c;
            if (i != this.f8260b) {
                char[] cArr = this.f8265g;
                if (cArr[i] == '\"') {
                    this.f8261c = i + 1;
                    while (true) {
                        int i2 = this.f8261c;
                        if (i2 >= this.f8260b || this.f8265g[i2] != ' ') {
                            break;
                        }
                        this.f8261c = i2 + 1;
                    }
                    char[] cArr2 = this.f8265g;
                    int i3 = this.f8262d;
                    return new String(cArr2, i3, this.f8263e - i3);
                }
                if (cArr[i] == '\\') {
                    cArr[this.f8263e] = m2838b();
                } else {
                    cArr[this.f8263e] = cArr[i];
                }
                this.f8261c++;
                this.f8263e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f8259a);
            }
        }
    }

    /* renamed from: a */
    public final int m2840a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f8260b) {
            char c = this.f8265g[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f8259a);
            } else {
                i2 = c - '7';
            }
            char c2 = this.f8265g[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f8259a);
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f8259a);
    }

    /* renamed from: a */
    public String m2839a(String str) {
        String m2834f;
        this.f8261c = 0;
        this.f8262d = 0;
        this.f8263e = 0;
        this.f8264f = 0;
        this.f8265g = this.f8259a.toCharArray();
        String m2835e = m2835e();
        if (m2835e == null) {
            return null;
        }
        do {
            int i = this.f8261c;
            if (i == this.f8260b) {
                return null;
            }
            char c = this.f8265g[i];
            if (c == '\"') {
                m2834f = m2834f();
            } else if (c != '#') {
                m2834f = (c == '+' || c == ',' || c == ';') ? "" : m2841a();
            } else {
                m2834f = m2836d();
            }
            if (str.equalsIgnoreCase(m2835e)) {
                return m2834f;
            }
            int i2 = this.f8261c;
            if (i2 >= this.f8260b) {
                return null;
            }
            char[] cArr = this.f8265g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f8259a);
            }
            this.f8261c++;
            m2835e = m2835e();
        } while (m2835e != null);
        throw new IllegalStateException("Malformed DN: " + this.f8259a);
    }
}
