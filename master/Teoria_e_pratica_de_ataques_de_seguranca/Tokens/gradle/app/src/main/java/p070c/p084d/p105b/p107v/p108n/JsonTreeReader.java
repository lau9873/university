package p070c.p084d.p105b.p107v.p108n;

import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import p070c.p084d.p105b.JsonArray;
import p070c.p084d.p105b.JsonNull;
import p070c.p084d.p105b.JsonObject;
import p070c.p084d.p105b.JsonPrimitive;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;

/* renamed from: c.d.b.v.n.e */
/* loaded from: classes.dex */
public final class JsonTreeReader extends JsonReader {

    /* renamed from: v */
    public static final Object f5767v;

    /* renamed from: r */
    public Object[] f5768r;

    /* renamed from: s */
    public int f5769s;

    /* renamed from: t */
    public String[] f5770t;

    /* renamed from: u */
    public int[] f5771u;

    /* compiled from: JsonTreeReader.java */
    /* renamed from: c.d.b.v.n.e$a */
    /* loaded from: classes.dex */
    public static class C1299a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    static {
        new C1299a();
        f5767v = new Object();
    }

    /* renamed from: t */
    private String m4806t() {
        return " at path " + mo4715q();
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: A */
    public String mo4740A() {
        JsonToken mo4738C = mo4738C();
        if (mo4738C != JsonToken.STRING && mo4738C != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + mo4738C + m4806t());
        }
        String mo4896p = ((JsonPrimitive) m4810K()).mo4896p();
        int i = this.f5769s;
        if (i > 0) {
            int[] iArr = this.f5771u;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return mo4896p;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: C */
    public JsonToken mo4738C() {
        if (this.f5769s == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object m4811J = m4811J();
        if (m4811J instanceof Iterator) {
            boolean z = this.f5768r[this.f5769s - 2] instanceof JsonObject;
            Iterator it = (Iterator) m4811J;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                m4807a(it.next());
                return mo4738C();
            }
        } else if (m4811J instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (m4811J instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (m4811J instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) m4811J;
                if (jsonPrimitive.m4900C()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.m4902A()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.m4901B()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (m4811J instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (m4811J == f5767v) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: I */
    public void mo4732I() {
        if (mo4738C() == JsonToken.NAME) {
            mo4707y();
            this.f5770t[this.f5769s - 2] = "null";
        } else {
            m4810K();
            int i = this.f5769s;
            if (i > 0) {
                this.f5770t[i - 1] = "null";
            }
        }
        int i2 = this.f5769s;
        if (i2 > 0) {
            int[] iArr = this.f5771u;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    /* renamed from: J */
    public final Object m4811J() {
        return this.f5768r[this.f5769s - 1];
    }

    /* renamed from: K */
    public final Object m4810K() {
        Object[] objArr = this.f5768r;
        int i = this.f5769s - 1;
        this.f5769s = i;
        Object obj = objArr[i];
        objArr[this.f5769s] = null;
        return obj;
    }

    /* renamed from: L */
    public void m4809L() {
        m4808a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m4811J()).next();
        m4807a(entry.getValue());
        m4807a(new JsonPrimitive((String) entry.getKey()));
    }

    /* renamed from: a */
    public final void m4808a(JsonToken jsonToken) {
        if (mo4738C() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + mo4738C() + m4806t());
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5768r = new Object[]{f5767v};
        this.f5769s = 1;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: j */
    public void mo4722j() {
        m4808a(JsonToken.BEGIN_ARRAY);
        m4807a(((JsonArray) m4811J()).iterator());
        this.f5771u[this.f5769s - 1] = 0;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: k */
    public void mo4721k() {
        m4808a(JsonToken.BEGIN_OBJECT);
        m4807a(((JsonObject) m4811J()).m4903u().iterator());
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: o */
    public void mo4717o() {
        m4808a(JsonToken.END_ARRAY);
        m4810K();
        m4810K();
        int i = this.f5769s;
        if (i > 0) {
            int[] iArr = this.f5771u;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: p */
    public void mo4716p() {
        m4808a(JsonToken.END_OBJECT);
        m4810K();
        m4810K();
        int i = this.f5769s;
        if (i > 0) {
            int[] iArr = this.f5771u;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: q */
    public String mo4715q() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.f5769s) {
            Object[] objArr = this.f5768r;
            if (objArr[i] instanceof JsonArray) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.f5771u[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof JsonObject) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.f5770t;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: r */
    public boolean mo4714r() {
        JsonToken mo4738C = mo4738C();
        return (mo4738C == JsonToken.END_OBJECT || mo4738C == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    public String toString() {
        return JsonTreeReader.class.getSimpleName();
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: u */
    public boolean mo4711u() {
        m4808a(JsonToken.BOOLEAN);
        boolean m4895u = ((JsonPrimitive) m4810K()).m4895u();
        int i = this.f5769s;
        if (i > 0) {
            int[] iArr = this.f5771u;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return m4895u;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: v */
    public double mo4710v() {
        JsonToken mo4738C = mo4738C();
        if (mo4738C != JsonToken.NUMBER && mo4738C != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + mo4738C + m4806t());
        }
        double m4893w = ((JsonPrimitive) m4811J()).m4893w();
        if (!m4713s() && (Double.isNaN(m4893w) || Double.isInfinite(m4893w))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + m4893w);
        }
        m4810K();
        int i = this.f5769s;
        if (i > 0) {
            int[] iArr = this.f5771u;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return m4893w;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: w */
    public int mo4709w() {
        JsonToken mo4738C = mo4738C();
        if (mo4738C != JsonToken.NUMBER && mo4738C != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + mo4738C + m4806t());
        }
        int m4892x = ((JsonPrimitive) m4811J()).m4892x();
        m4810K();
        int i = this.f5769s;
        if (i > 0) {
            int[] iArr = this.f5771u;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return m4892x;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: x */
    public long mo4708x() {
        JsonToken mo4738C = mo4738C();
        if (mo4738C != JsonToken.NUMBER && mo4738C != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + mo4738C + m4806t());
        }
        long m4891y = ((JsonPrimitive) m4811J()).m4891y();
        m4810K();
        int i = this.f5769s;
        if (i > 0) {
            int[] iArr = this.f5771u;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return m4891y;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: y */
    public String mo4707y() {
        m4808a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m4811J()).next();
        String str = (String) entry.getKey();
        this.f5770t[this.f5769s - 1] = str;
        m4807a(entry.getValue());
        return str;
    }

    @Override // p070c.p084d.p105b.p112x.JsonReader
    /* renamed from: z */
    public void mo4706z() {
        m4808a(JsonToken.NULL);
        m4810K();
        int i = this.f5769s;
        if (i > 0) {
            int[] iArr = this.f5771u;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    /* renamed from: a */
    public final void m4807a(Object obj) {
        int i = this.f5769s;
        Object[] objArr = this.f5768r;
        if (i == objArr.length) {
            Object[] objArr2 = new Object[i * 2];
            int[] iArr = new int[i * 2];
            String[] strArr = new String[i * 2];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f5771u, 0, iArr, 0, this.f5769s);
            System.arraycopy(this.f5770t, 0, strArr, 0, this.f5769s);
            this.f5768r = objArr2;
            this.f5771u = iArr;
            this.f5770t = strArr;
        }
        Object[] objArr3 = this.f5768r;
        int i2 = this.f5769s;
        this.f5769s = i2 + 1;
        objArr3[i2] = obj;
    }
}
