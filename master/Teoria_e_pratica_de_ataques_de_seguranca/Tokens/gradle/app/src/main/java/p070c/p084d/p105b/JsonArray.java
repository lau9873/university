package p070c.p084d.p105b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: c.d.b.i */
/* loaded from: classes.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* renamed from: a */
    public final List<JsonElement> f5684a = new ArrayList();

    /* renamed from: a */
    public void m4912a(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f5685a;
        }
        this.f5684a.add(jsonElement);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).f5684a.equals(this.f5684a));
    }

    public int hashCode() {
        return this.f5684a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.f5684a.iterator();
    }

    @Override // p070c.p084d.p105b.JsonElement
    /* renamed from: p */
    public String mo4896p() {
        if (this.f5684a.size() == 1) {
            return this.f5684a.get(0).mo4896p();
        }
        throw new IllegalStateException();
    }
}
