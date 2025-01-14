package c.d.b.v.n;

import c.d.b.o;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class e extends c.d.b.x.a {
    public static final Object v;
    public Object[] r;
    public int s;
    public String[] t;
    public int[] u;

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes.dex */
    public static class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    static {
        new a();
        v = new Object();
    }

    private String t() {
        return " at path " + q();
    }

    @Override // c.d.b.x.a
    public String A() {
        c.d.b.x.b C = C();
        if (C != c.d.b.x.b.STRING && C != c.d.b.x.b.NUMBER) {
            throw new IllegalStateException("Expected " + c.d.b.x.b.STRING + " but was " + C + t());
        }
        String p = ((o) K()).p();
        int i2 = this.s;
        if (i2 > 0) {
            int[] iArr = this.u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return p;
    }

    @Override // c.d.b.x.a
    public c.d.b.x.b C() {
        if (this.s == 0) {
            return c.d.b.x.b.END_DOCUMENT;
        }
        Object J = J();
        if (J instanceof Iterator) {
            boolean z = this.r[this.s - 2] instanceof c.d.b.n;
            Iterator it = (Iterator) J;
            if (!it.hasNext()) {
                return z ? c.d.b.x.b.END_OBJECT : c.d.b.x.b.END_ARRAY;
            } else if (z) {
                return c.d.b.x.b.NAME;
            } else {
                a(it.next());
                return C();
            }
        } else if (J instanceof c.d.b.n) {
            return c.d.b.x.b.BEGIN_OBJECT;
        } else {
            if (J instanceof c.d.b.i) {
                return c.d.b.x.b.BEGIN_ARRAY;
            }
            if (J instanceof o) {
                o oVar = (o) J;
                if (oVar.C()) {
                    return c.d.b.x.b.STRING;
                }
                if (oVar.A()) {
                    return c.d.b.x.b.BOOLEAN;
                }
                if (oVar.B()) {
                    return c.d.b.x.b.NUMBER;
                }
                throw new AssertionError();
            } else if (J instanceof c.d.b.m) {
                return c.d.b.x.b.NULL;
            } else {
                if (J == v) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // c.d.b.x.a
    public void I() {
        if (C() == c.d.b.x.b.NAME) {
            y();
            this.t[this.s - 2] = "null";
        } else {
            K();
            int i2 = this.s;
            if (i2 > 0) {
                this.t[i2 - 1] = "null";
            }
        }
        int i3 = this.s;
        if (i3 > 0) {
            int[] iArr = this.u;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    public final Object J() {
        return this.r[this.s - 1];
    }

    public final Object K() {
        Object[] objArr = this.r;
        int i2 = this.s - 1;
        this.s = i2;
        Object obj = objArr[i2];
        objArr[this.s] = null;
        return obj;
    }

    public void L() {
        a(c.d.b.x.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) J()).next();
        a(entry.getValue());
        a(new o((String) entry.getKey()));
    }

    public final void a(c.d.b.x.b bVar) {
        if (C() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + C() + t());
    }

    @Override // c.d.b.x.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.r = new Object[]{v};
        this.s = 1;
    }

    @Override // c.d.b.x.a
    public void j() {
        a(c.d.b.x.b.BEGIN_ARRAY);
        a(((c.d.b.i) J()).iterator());
        this.u[this.s - 1] = 0;
    }

    @Override // c.d.b.x.a
    public void k() {
        a(c.d.b.x.b.BEGIN_OBJECT);
        a(((c.d.b.n) J()).u().iterator());
    }

    @Override // c.d.b.x.a
    public void o() {
        a(c.d.b.x.b.END_ARRAY);
        K();
        K();
        int i2 = this.s;
        if (i2 > 0) {
            int[] iArr = this.u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // c.d.b.x.a
    public void p() {
        a(c.d.b.x.b.END_OBJECT);
        K();
        K();
        int i2 = this.s;
        if (i2 > 0) {
            int[] iArr = this.u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // c.d.b.x.a
    public String q() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (i2 < this.s) {
            Object[] objArr = this.r;
            if (objArr[i2] instanceof c.d.b.i) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.u[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof c.d.b.n) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.t;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    @Override // c.d.b.x.a
    public boolean r() {
        c.d.b.x.b C = C();
        return (C == c.d.b.x.b.END_OBJECT || C == c.d.b.x.b.END_ARRAY) ? false : true;
    }

    @Override // c.d.b.x.a
    public String toString() {
        return e.class.getSimpleName();
    }

    @Override // c.d.b.x.a
    public boolean u() {
        a(c.d.b.x.b.BOOLEAN);
        boolean u = ((o) K()).u();
        int i2 = this.s;
        if (i2 > 0) {
            int[] iArr = this.u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return u;
    }

    @Override // c.d.b.x.a
    public double v() {
        c.d.b.x.b C = C();
        if (C != c.d.b.x.b.NUMBER && C != c.d.b.x.b.STRING) {
            throw new IllegalStateException("Expected " + c.d.b.x.b.NUMBER + " but was " + C + t());
        }
        double w = ((o) J()).w();
        if (!s() && (Double.isNaN(w) || Double.isInfinite(w))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + w);
        }
        K();
        int i2 = this.s;
        if (i2 > 0) {
            int[] iArr = this.u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return w;
    }

    @Override // c.d.b.x.a
    public int w() {
        c.d.b.x.b C = C();
        if (C != c.d.b.x.b.NUMBER && C != c.d.b.x.b.STRING) {
            throw new IllegalStateException("Expected " + c.d.b.x.b.NUMBER + " but was " + C + t());
        }
        int x = ((o) J()).x();
        K();
        int i2 = this.s;
        if (i2 > 0) {
            int[] iArr = this.u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return x;
    }

    @Override // c.d.b.x.a
    public long x() {
        c.d.b.x.b C = C();
        if (C != c.d.b.x.b.NUMBER && C != c.d.b.x.b.STRING) {
            throw new IllegalStateException("Expected " + c.d.b.x.b.NUMBER + " but was " + C + t());
        }
        long y = ((o) J()).y();
        K();
        int i2 = this.s;
        if (i2 > 0) {
            int[] iArr = this.u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return y;
    }

    @Override // c.d.b.x.a
    public String y() {
        a(c.d.b.x.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) J()).next();
        String str = (String) entry.getKey();
        this.t[this.s - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // c.d.b.x.a
    public void z() {
        a(c.d.b.x.b.NULL);
        K();
        int i2 = this.s;
        if (i2 > 0) {
            int[] iArr = this.u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final void a(Object obj) {
        int i2 = this.s;
        Object[] objArr = this.r;
        if (i2 == objArr.length) {
            Object[] objArr2 = new Object[i2 * 2];
            int[] iArr = new int[i2 * 2];
            String[] strArr = new String[i2 * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.u, 0, iArr, 0, this.s);
            System.arraycopy(this.t, 0, strArr, 0, this.s);
            this.r = objArr2;
            this.u = iArr;
            this.t = strArr;
        }
        Object[] objArr3 = this.r;
        int i3 = this.s;
        this.s = i3 + 1;
        objArr3[i3] = obj;
    }
}
