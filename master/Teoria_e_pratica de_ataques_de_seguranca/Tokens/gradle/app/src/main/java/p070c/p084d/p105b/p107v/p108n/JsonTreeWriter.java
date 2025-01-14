package p070c.p084d.p105b.p107v.p108n;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import p070c.p084d.p105b.JsonArray;
import p070c.p084d.p105b.JsonElement;
import p070c.p084d.p105b.JsonNull;
import p070c.p084d.p105b.JsonObject;
import p070c.p084d.p105b.JsonPrimitive;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.f */
/* loaded from: classes.dex */
public final class JsonTreeWriter extends JsonWriter {

    /* renamed from: p */
    public static final Writer f5772p = new C1300a();

    /* renamed from: q */
    public static final JsonPrimitive f5773q = new JsonPrimitive("closed");

    /* renamed from: m */
    public final List<JsonElement> f5774m;

    /* renamed from: n */
    public String f5775n;

    /* renamed from: o */
    public JsonElement f5776o;

    /* compiled from: JsonTreeWriter.java */
    /* renamed from: c.d.b.v.n.f$a */
    /* loaded from: classes.dex */
    public static class C1300a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public JsonTreeWriter() {
        super(f5772p);
        this.f5774m = new ArrayList();
        this.f5776o = JsonNull.f5685a;
    }

    /* renamed from: a */
    public final void m4805a(JsonElement jsonElement) {
        if (this.f5775n != null) {
            if (!jsonElement.m4907r() || m4683p()) {
                ((JsonObject) mo4678u()).m4904a(this.f5775n, jsonElement);
            }
            this.f5775n = null;
        } else if (this.f5774m.isEmpty()) {
            this.f5776o = jsonElement;
        } else {
            JsonElement mo4678u = mo4678u();
            if (mo4678u instanceof JsonArray) {
                ((JsonArray) mo4678u).m4912a(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: b */
    public JsonWriter mo4697b(String str) {
        if (!this.f5774m.isEmpty() && this.f5775n == null) {
            if (mo4678u() instanceof JsonObject) {
                this.f5775n = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f5774m.isEmpty()) {
            this.f5774m.add(f5773q);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: d */
    public JsonWriter mo4692d(boolean z) {
        m4805a(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: e */
    public JsonWriter mo4691e(String str) {
        if (str == null) {
            mo4679t();
            return this;
        }
        m4805a(new JsonPrimitive(str));
        return this;
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter, java.io.Flushable
    public void flush() {
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: g */
    public JsonWriter mo4690g(long j) {
        m4805a(new JsonPrimitive(Long.valueOf(j)));
        return this;
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: l */
    public JsonWriter mo4687l() {
        JsonArray jsonArray = new JsonArray();
        m4805a(jsonArray);
        this.f5774m.add(jsonArray);
        return this;
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: m */
    public JsonWriter mo4686m() {
        JsonObject jsonObject = new JsonObject();
        m4805a(jsonObject);
        this.f5774m.add(jsonObject);
        return this;
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: n */
    public JsonWriter mo4685n() {
        if (!this.f5774m.isEmpty() && this.f5775n == null) {
            if (mo4678u() instanceof JsonArray) {
                List<JsonElement> list = this.f5774m;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: o */
    public JsonWriter mo4684o() {
        if (!this.f5774m.isEmpty() && this.f5775n == null) {
            if (mo4678u() instanceof JsonObject) {
                List<JsonElement> list = this.f5774m;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: t */
    public JsonWriter mo4679t() {
        m4805a(JsonNull.f5685a);
        return this;
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: u */
    public final JsonElement mo4678u() {
        List<JsonElement> list = this.f5774m;
        return list.get(list.size() - 1);
    }

    /* renamed from: w */
    public JsonElement m4804w() {
        if (this.f5774m.isEmpty()) {
            return this.f5776o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f5774m);
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: a */
    public JsonWriter mo4701a(Boolean bool) {
        if (bool == null) {
            mo4679t();
            return this;
        }
        m4805a(new JsonPrimitive(bool));
        return this;
    }

    @Override // p070c.p084d.p105b.p112x.JsonWriter
    /* renamed from: a */
    public JsonWriter mo4700a(Number number) {
        if (number == null) {
            mo4679t();
            return this;
        }
        if (!m4681r()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m4805a(new JsonPrimitive(number));
        return this;
    }
}
