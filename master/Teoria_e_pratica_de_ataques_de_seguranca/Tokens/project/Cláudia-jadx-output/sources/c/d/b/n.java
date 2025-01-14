package c.d.b;

import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* loaded from: classes.dex */
public final class n extends l {

    /* renamed from: a  reason: collision with root package name */
    public final c.d.b.v.h<String, l> f3734a = new c.d.b.v.h<>();

    public void a(String str, l lVar) {
        if (lVar == null) {
            lVar = m.f3733a;
        }
        this.f3734a.put(str, lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).f3734a.equals(this.f3734a));
    }

    public int hashCode() {
        return this.f3734a.hashCode();
    }

    public Set<Map.Entry<String, l>> u() {
        return this.f3734a.entrySet();
    }
}
