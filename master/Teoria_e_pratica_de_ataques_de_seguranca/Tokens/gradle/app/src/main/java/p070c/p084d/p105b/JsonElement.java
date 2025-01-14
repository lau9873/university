package p070c.p084d.p105b;

import java.io.IOException;
import java.io.StringWriter;
import p070c.p084d.p105b.p107v.Streams;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.l */
/* loaded from: classes.dex */
public abstract class JsonElement {
    /* renamed from: a */
    public JsonArray m4911a() {
        if (m4908q()) {
            return (JsonArray) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    /* renamed from: n */
    public JsonObject m4910n() {
        if (m4906s()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    /* renamed from: o */
    public JsonPrimitive m4909o() {
        if (m4905t()) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    /* renamed from: p */
    public String mo4896p() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: q */
    public boolean m4908q() {
        return this instanceof JsonArray;
    }

    /* renamed from: r */
    public boolean m4907r() {
        return this instanceof JsonNull;
    }

    /* renamed from: s */
    public boolean m4906s() {
        return this instanceof JsonObject;
    }

    /* renamed from: t */
    public boolean m4905t() {
        return this instanceof JsonPrimitive;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.m4696b(true);
            Streams.m4821a(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
