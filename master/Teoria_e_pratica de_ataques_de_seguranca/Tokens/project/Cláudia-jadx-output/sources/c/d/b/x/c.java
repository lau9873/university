package c.d.b.x;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* compiled from: JsonWriter.java */
/* loaded from: classes.dex */
public class c implements Closeable, Flushable {
    public static final String[] j = new String[128];
    public static final String[] k;

    /* renamed from: a  reason: collision with root package name */
    public final Writer f3909a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f3910b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    public int f3911c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f3912d;

    /* renamed from: e  reason: collision with root package name */
    public String f3913e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3914f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3915g;

    /* renamed from: h  reason: collision with root package name */
    public String f3916h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3917i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            j[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        k = (String[]) strArr.clone();
        String[] strArr2 = k;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.f3913e = ":";
        this.f3917i = true;
        if (writer != null) {
            this.f3909a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final void a(boolean z) {
        this.f3915g = z;
    }

    public final void b(boolean z) {
        this.f3914f = z;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f3912d = null;
            this.f3913e = ":";
            return;
        }
        this.f3912d = str;
        this.f3913e = ": ";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3909a.close();
        int i2 = this.f3911c;
        if (i2 <= 1 && (i2 != 1 || this.f3910b[i2 - 1] == 7)) {
            this.f3911c = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public c d(boolean z) {
        v();
        k();
        this.f3909a.write(z ? "true" : "false");
        return this;
    }

    public c e(String str) {
        if (str == null) {
            return t();
        }
        v();
        k();
        d(str);
        return this;
    }

    public void flush() {
        if (this.f3911c != 0) {
            this.f3909a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c g(long j2) {
        v();
        k();
        this.f3909a.write(Long.toString(j2));
        return this;
    }

    public final void j() {
        int u = u();
        if (u == 5) {
            this.f3909a.write(44);
        } else if (u != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        s();
        b(4);
    }

    public final void k() {
        int u = u();
        if (u == 1) {
            b(2);
            s();
        } else if (u == 2) {
            this.f3909a.append(',');
            s();
        } else if (u != 4) {
            if (u != 6) {
                if (u == 7) {
                    if (!this.f3914f) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            b(7);
        } else {
            this.f3909a.append((CharSequence) this.f3913e);
            b(5);
        }
    }

    public c l() {
        v();
        a(1, "[");
        return this;
    }

    public c m() {
        v();
        a(3, "{");
        return this;
    }

    public c n() {
        a(1, 2, "]");
        return this;
    }

    public c o() {
        a(3, 5, "}");
        return this;
    }

    public final boolean p() {
        return this.f3917i;
    }

    public final boolean q() {
        return this.f3915g;
    }

    public boolean r() {
        return this.f3914f;
    }

    public final void s() {
        if (this.f3912d == null) {
            return;
        }
        this.f3909a.write("\n");
        int i2 = this.f3911c;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f3909a.write(this.f3912d);
        }
    }

    public c t() {
        if (this.f3916h != null) {
            if (this.f3917i) {
                v();
            } else {
                this.f3916h = null;
                return this;
            }
        }
        k();
        this.f3909a.write("null");
        return this;
    }

    public final int u() {
        int i2 = this.f3911c;
        if (i2 != 0) {
            return this.f3910b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void v() {
        if (this.f3916h != null) {
            j();
            d(this.f3916h);
            this.f3916h = null;
        }
    }

    public final c a(int i2, String str) {
        k();
        a(i2);
        this.f3909a.write(str);
        return this;
    }

    public final void b(int i2) {
        this.f3910b[this.f3911c - 1] = i2;
    }

    public c b(String str) {
        if (str != null) {
            if (this.f3916h == null) {
                if (this.f3911c != 0) {
                    this.f3916h = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f3915g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = c.d.b.x.c.k
            goto L9
        L7:
            java.lang.String[] r0 = c.d.b.x.c.j
        L9:
            java.io.Writer r1 = r8.f3909a
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f3909a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f3909a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f3909a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f3909a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.x.c.d(java.lang.String):void");
    }

    public final c a(int i2, int i3, String str) {
        int u = u();
        if (u != i3 && u != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3916h == null) {
            this.f3911c--;
            if (u == i3) {
                s();
            }
            this.f3909a.write(str);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f3916h);
    }

    public final void c(boolean z) {
        this.f3917i = z;
    }

    public final void a(int i2) {
        int i3 = this.f3911c;
        int[] iArr = this.f3910b;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f3910b = iArr2;
        }
        int[] iArr3 = this.f3910b;
        int i4 = this.f3911c;
        this.f3911c = i4 + 1;
        iArr3[i4] = i2;
    }

    public c a(Boolean bool) {
        if (bool == null) {
            return t();
        }
        v();
        k();
        this.f3909a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c a(Number number) {
        if (number == null) {
            return t();
        }
        v();
        String obj = number.toString();
        if (!this.f3914f && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        k();
        this.f3909a.append((CharSequence) obj);
        return this;
    }
}
