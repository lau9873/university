package e.i0.l;

import javax.security.auth.x500.X500Principal;
/* compiled from: DistinguishedNameParser.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f5851a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5852b;

    /* renamed from: c  reason: collision with root package name */
    public int f5853c;

    /* renamed from: d  reason: collision with root package name */
    public int f5854d;

    /* renamed from: e  reason: collision with root package name */
    public int f5855e;

    /* renamed from: f  reason: collision with root package name */
    public int f5856f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f5857g;

    public c(X500Principal x500Principal) {
        this.f5851a = x500Principal.getName("RFC2253");
        this.f5852b = this.f5851a.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f5856f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f5853c
            r8.f5854d = r0
            r8.f5855e = r0
        L6:
            int r0 = r8.f5853c
            int r1 = r8.f5852b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f5857g
            int r2 = r8.f5854d
            int r3 = r8.f5855e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f5857g
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
            int r2 = r8.f5855e
            int r3 = r2 + 1
            r8.f5855e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f5853c = r0
            goto L6
        L40:
            int r0 = r8.f5855e
            int r2 = r0 + 1
            r8.f5855e = r2
            char r2 = r8.b()
            r1[r0] = r2
            int r0 = r8.f5853c
            int r0 = r0 + 1
            r8.f5853c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f5857g
            int r2 = r8.f5854d
            int r3 = r8.f5855e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f5855e
            r8.f5856f = r2
            int r0 = r0 + 1
            r8.f5853c = r0
            int r0 = r2 + 1
            r8.f5855e = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f5853c
            int r1 = r8.f5852b
            if (r0 >= r1) goto L87
            char[] r1 = r8.f5857g
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.f5855e
            int r7 = r2 + 1
            r8.f5855e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f5853c = r0
            goto L6e
        L87:
            int r0 = r8.f5853c
            int r1 = r8.f5852b
            if (r0 == r1) goto L9b
            char[] r1 = r8.f5857g
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f5857g
            int r2 = r8.f5854d
            int r3 = r8.f5856f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i0.l.c.a():java.lang.String");
    }

    public final char b() {
        this.f5853c++;
        int i2 = this.f5853c;
        if (i2 != this.f5852b) {
            char c2 = this.f5857g[i2];
            if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return c();
                        }
                }
            }
            return this.f5857g[this.f5853c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f5851a);
    }

    public final char c() {
        int i2;
        int i3;
        int a2 = a(this.f5853c);
        this.f5853c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i3 = a2 & 31;
            i2 = 1;
        } else if (a2 <= 239) {
            i2 = 2;
            i3 = a2 & 15;
        } else {
            i2 = 3;
            i3 = a2 & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f5853c++;
            int i5 = this.f5853c;
            if (i5 == this.f5852b || this.f5857g[i5] != '\\') {
                return '?';
            }
            this.f5853c = i5 + 1;
            int a3 = a(this.f5853c);
            this.f5853c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (a3 & 63);
        }
        return (char) i3;
    }

    public final String d() {
        int i2 = this.f5853c;
        if (i2 + 4 < this.f5852b) {
            this.f5854d = i2;
            this.f5853c = i2 + 1;
            while (true) {
                int i3 = this.f5853c;
                if (i3 == this.f5852b) {
                    break;
                }
                char[] cArr = this.f5857g;
                if (cArr[i3] == '+' || cArr[i3] == ',' || cArr[i3] == ';') {
                    break;
                } else if (cArr[i3] == ' ') {
                    this.f5855e = i3;
                    this.f5853c = i3 + 1;
                    while (true) {
                        int i4 = this.f5853c;
                        if (i4 >= this.f5852b || this.f5857g[i4] != ' ') {
                            break;
                        }
                        this.f5853c = i4 + 1;
                    }
                } else {
                    if (cArr[i3] >= 'A' && cArr[i3] <= 'F') {
                        cArr[i3] = (char) (cArr[i3] + ' ');
                    }
                    this.f5853c++;
                }
            }
            this.f5855e = this.f5853c;
            int i5 = this.f5855e;
            int i6 = this.f5854d;
            int i7 = i5 - i6;
            if (i7 >= 5 && (i7 & 1) != 0) {
                byte[] bArr = new byte[i7 / 2];
                int i8 = i6 + 1;
                for (int i9 = 0; i9 < bArr.length; i9++) {
                    bArr[i9] = (byte) a(i8);
                    i8 += 2;
                }
                return new String(this.f5857g, this.f5854d, i7);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f5851a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f5851a);
    }

    public final String e() {
        while (true) {
            int i2 = this.f5853c;
            if (i2 >= this.f5852b || this.f5857g[i2] != ' ') {
                break;
            }
            this.f5853c = i2 + 1;
        }
        int i3 = this.f5853c;
        if (i3 == this.f5852b) {
            return null;
        }
        this.f5854d = i3;
        this.f5853c = i3 + 1;
        while (true) {
            int i4 = this.f5853c;
            if (i4 >= this.f5852b) {
                break;
            }
            char[] cArr = this.f5857g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f5853c = i4 + 1;
        }
        int i5 = this.f5853c;
        if (i5 < this.f5852b) {
            this.f5855e = i5;
            if (this.f5857g[i5] == ' ') {
                while (true) {
                    int i6 = this.f5853c;
                    if (i6 >= this.f5852b) {
                        break;
                    }
                    char[] cArr2 = this.f5857g;
                    if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                        break;
                    }
                    this.f5853c = i6 + 1;
                }
                char[] cArr3 = this.f5857g;
                int i7 = this.f5853c;
                if (cArr3[i7] != '=' || i7 == this.f5852b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f5851a);
                }
            }
            this.f5853c++;
            while (true) {
                int i8 = this.f5853c;
                if (i8 >= this.f5852b || this.f5857g[i8] != ' ') {
                    break;
                }
                this.f5853c = i8 + 1;
            }
            int i9 = this.f5855e;
            int i10 = this.f5854d;
            if (i9 - i10 > 4) {
                char[] cArr4 = this.f5857g;
                if (cArr4[i10 + 3] == '.' && (cArr4[i10] == 'O' || cArr4[i10] == 'o')) {
                    char[] cArr5 = this.f5857g;
                    int i11 = this.f5854d;
                    if (cArr5[i11 + 1] == 'I' || cArr5[i11 + 1] == 'i') {
                        char[] cArr6 = this.f5857g;
                        int i12 = this.f5854d;
                        if (cArr6[i12 + 2] == 'D' || cArr6[i12 + 2] == 'd') {
                            this.f5854d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f5857g;
            int i13 = this.f5854d;
            return new String(cArr7, i13, this.f5855e - i13);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f5851a);
    }

    public final String f() {
        this.f5853c++;
        this.f5854d = this.f5853c;
        this.f5855e = this.f5854d;
        while (true) {
            int i2 = this.f5853c;
            if (i2 != this.f5852b) {
                char[] cArr = this.f5857g;
                if (cArr[i2] == '\"') {
                    this.f5853c = i2 + 1;
                    while (true) {
                        int i3 = this.f5853c;
                        if (i3 >= this.f5852b || this.f5857g[i3] != ' ') {
                            break;
                        }
                        this.f5853c = i3 + 1;
                    }
                    char[] cArr2 = this.f5857g;
                    int i4 = this.f5854d;
                    return new String(cArr2, i4, this.f5855e - i4);
                }
                if (cArr[i2] == '\\') {
                    cArr[this.f5855e] = b();
                } else {
                    cArr[this.f5855e] = cArr[i2];
                }
                this.f5853c++;
                this.f5855e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5851a);
            }
        }
    }

    public final int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.f5852b) {
            char c2 = this.f5857g[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f5851a);
            } else {
                i3 = c2 - '7';
            }
            char c3 = this.f5857g[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f5851a);
            } else {
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.f5851a);
    }

    public String a(String str) {
        String f2;
        this.f5853c = 0;
        this.f5854d = 0;
        this.f5855e = 0;
        this.f5856f = 0;
        this.f5857g = this.f5851a.toCharArray();
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        do {
            int i2 = this.f5853c;
            if (i2 == this.f5852b) {
                return null;
            }
            char c2 = this.f5857g[i2];
            if (c2 == '\"') {
                f2 = f();
            } else if (c2 != '#') {
                f2 = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
            } else {
                f2 = d();
            }
            if (str.equalsIgnoreCase(e2)) {
                return f2;
            }
            int i3 = this.f5853c;
            if (i3 >= this.f5852b) {
                return null;
            }
            char[] cArr = this.f5857g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f5851a);
            }
            this.f5853c++;
            e2 = e();
        } while (e2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f5851a);
    }
}
