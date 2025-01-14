package p070c.p084d.p105b.p112x;

import com.j256.ormlite.logger.Logger;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* renamed from: c.d.b.x.c */
/* loaded from: classes.dex */
public class JsonWriter implements Closeable, Flushable {

    /* renamed from: j */
    public static final String[] f5923j = new String[Logger.DEFAULT_FULL_MESSAGE_LENGTH];

    /* renamed from: k */
    public static final String[] f5924k;

    /* renamed from: a */
    public final Writer f5925a;

    /* renamed from: b */
    public int[] f5926b = new int[32];

    /* renamed from: c */
    public int f5927c = 0;

    /* renamed from: d */
    public String f5928d;

    /* renamed from: e */
    public String f5929e;

    /* renamed from: f */
    public boolean f5930f;

    /* renamed from: g */
    public boolean f5931g;

    /* renamed from: h */
    public String f5932h;

    /* renamed from: i */
    public boolean f5933i;

    static {
        for (int i = 0; i <= 31; i++) {
            f5923j[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f5923j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f5924k = (String[]) strArr.clone();
        String[] strArr2 = f5924k;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        m4704a(6);
        this.f5929e = ":";
        this.f5933i = true;
        if (writer != null) {
            this.f5925a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    /* renamed from: a */
    public final void m4699a(boolean z) {
        this.f5931g = z;
    }

    /* renamed from: b */
    public final void m4696b(boolean z) {
        this.f5930f = z;
    }

    /* renamed from: c */
    public final void m4695c(String str) {
        if (str.length() == 0) {
            this.f5928d = null;
            this.f5929e = ":";
            return;
        }
        this.f5928d = str;
        this.f5929e = ": ";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5925a.close();
        int i = this.f5927c;
        if (i <= 1 && (i != 1 || this.f5926b[i - 1] == 7)) {
            this.f5927c = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    /* renamed from: d */
    public JsonWriter mo4692d(boolean z) {
        m4677v();
        m4688k();
        this.f5925a.write(z ? "true" : "false");
        return this;
    }

    /* renamed from: e */
    public JsonWriter mo4691e(String str) {
        if (str == null) {
            return mo4679t();
        }
        m4677v();
        m4688k();
        m4693d(str);
        return this;
    }

    public void flush() {
        if (this.f5927c != 0) {
            this.f5925a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: g */
    public JsonWriter mo4690g(long j) {
        m4677v();
        m4688k();
        this.f5925a.write(Long.toString(j));
        return this;
    }

    /* renamed from: j */
    public final void m4689j() {
        int mo4678u = mo4678u();
        if (mo4678u == 5) {
            this.f5925a.write(44);
        } else if (mo4678u != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m4680s();
        m4698b(4);
    }

    /* renamed from: k */
    public final void m4688k() {
        int mo4678u = mo4678u();
        if (mo4678u == 1) {
            m4698b(2);
            m4680s();
        } else if (mo4678u == 2) {
            this.f5925a.append(',');
            m4680s();
        } else if (mo4678u != 4) {
            if (mo4678u != 6) {
                if (mo4678u == 7) {
                    if (!this.f5930f) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            m4698b(7);
        } else {
            this.f5925a.append((CharSequence) this.f5929e);
            m4698b(5);
        }
    }

    /* renamed from: l */
    public JsonWriter mo4687l() {
        m4677v();
        m4702a(1, "[");
        return this;
    }

    /* renamed from: m */
    public JsonWriter mo4686m() {
        m4677v();
        m4702a(3, "{");
        return this;
    }

    /* renamed from: n */
    public JsonWriter mo4685n() {
        m4703a(1, 2, "]");
        return this;
    }

    /* renamed from: o */
    public JsonWriter mo4684o() {
        m4703a(3, 5, "}");
        return this;
    }

    /* renamed from: p */
    public final boolean m4683p() {
        return this.f5933i;
    }

    /* renamed from: q */
    public final boolean m4682q() {
        return this.f5931g;
    }

    /* renamed from: r */
    public boolean m4681r() {
        return this.f5930f;
    }

    /* renamed from: s */
    public final void m4680s() {
        if (this.f5928d == null) {
            return;
        }
        this.f5925a.write("\n");
        int i = this.f5927c;
        for (int i2 = 1; i2 < i; i2++) {
            this.f5925a.write(this.f5928d);
        }
    }

    /* renamed from: t */
    public JsonWriter mo4679t() {
        if (this.f5932h != null) {
            if (this.f5933i) {
                m4677v();
            } else {
                this.f5932h = null;
                return this;
            }
        }
        m4688k();
        this.f5925a.write("null");
        return this;
    }

    /* renamed from: u */
    public final int mo4678u() {
        int i = this.f5927c;
        if (i != 0) {
            return this.f5926b[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: v */
    public final void m4677v() {
        if (this.f5932h != null) {
            m4689j();
            m4693d(this.f5932h);
            this.f5932h = null;
        }
    }

    /* renamed from: a */
    public final JsonWriter m4702a(int i, String str) {
        m4688k();
        m4704a(i);
        this.f5925a.write(str);
        return this;
    }

    /* renamed from: b */
    public final void m4698b(int i) {
        this.f5926b[this.f5927c - 1] = i;
    }

    /* renamed from: b */
    public JsonWriter mo4697b(String str) {
        if (str != null) {
            if (this.f5932h == null) {
                if (this.f5927c != 0) {
                    this.f5932h = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4693d(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f5931g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = p070c.p084d.p105b.p112x.JsonWriter.f5924k
            goto L9
        L7:
            java.lang.String[] r0 = p070c.p084d.p105b.p112x.JsonWriter.f5923j
        L9:
            java.io.Writer r1 = r8.f5925a
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
            java.io.Writer r6 = r8.f5925a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f5925a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f5925a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f5925a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p084d.p105b.p112x.JsonWriter.m4693d(java.lang.String):void");
    }

    /* renamed from: a */
    public final JsonWriter m4703a(int i, int i2, String str) {
        int mo4678u = mo4678u();
        if (mo4678u != i2 && mo4678u != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f5932h == null) {
            this.f5927c--;
            if (mo4678u == i2) {
                m4680s();
            }
            this.f5925a.write(str);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f5932h);
    }

    /* renamed from: c */
    public final void m4694c(boolean z) {
        this.f5933i = z;
    }

    /* renamed from: a */
    public final void m4704a(int i) {
        int i2 = this.f5927c;
        int[] iArr = this.f5926b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f5926b = iArr2;
        }
        int[] iArr3 = this.f5926b;
        int i3 = this.f5927c;
        this.f5927c = i3 + 1;
        iArr3[i3] = i;
    }

    /* renamed from: a */
    public JsonWriter mo4701a(Boolean bool) {
        if (bool == null) {
            return mo4679t();
        }
        m4677v();
        m4688k();
        this.f5925a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    /* renamed from: a */
    public JsonWriter mo4700a(Number number) {
        if (number == null) {
            return mo4679t();
        }
        m4677v();
        String obj = number.toString();
        if (!this.f5930f && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        m4688k();
        this.f5925a.append((CharSequence) obj);
        return this;
    }
}
