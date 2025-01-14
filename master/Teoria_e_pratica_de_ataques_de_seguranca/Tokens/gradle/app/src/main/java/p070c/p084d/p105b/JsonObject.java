package p070c.p084d.p105b;

import java.util.Map;
import java.util.Set;
import p070c.p084d.p105b.p107v.LinkedTreeMap;

/* renamed from: c.d.b.n */
/* loaded from: classes.dex */
public final class JsonObject extends JsonElement {

    /* renamed from: a */
    public final LinkedTreeMap<String, JsonElement> f5686a = new LinkedTreeMap<>();

    /* renamed from: a */
    public void m4904a(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f5685a;
        }
        this.f5686a.put(str, jsonElement);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).f5686a.equals(this.f5686a));
    }

    public int hashCode() {
        return this.f5686a.hashCode();
    }

    /* renamed from: u */
    public Set<Map.Entry<String, JsonElement>> m4903u() {
        return this.f5686a.entrySet();
    }
}
