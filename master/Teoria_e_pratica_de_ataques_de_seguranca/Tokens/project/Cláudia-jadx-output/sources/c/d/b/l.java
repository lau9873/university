package c.d.b;

import java.io.IOException;
import java.io.StringWriter;
/* compiled from: JsonElement.java */
/* loaded from: classes.dex */
public abstract class l {
    public i a() {
        if (q()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public n n() {
        if (s()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public o o() {
        if (t()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String p() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean q() {
        return this instanceof i;
    }

    public boolean r() {
        return this instanceof m;
    }

    public boolean s() {
        return this instanceof n;
    }

    public boolean t() {
        return this instanceof o;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c.d.b.x.c cVar = new c.d.b.x.c(stringWriter);
            cVar.b(true);
            c.d.b.v.l.a(this, cVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
