package c.b.a.b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* compiled from: AnswersAttributes.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final d f2851a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Object> f2852b = new ConcurrentHashMap();

    public b(d dVar) {
        this.f2851a = dVar;
    }

    public void a(String str, String str2) {
        if (this.f2851a.a(str, "key") || this.f2851a.a(str2, "value")) {
            return;
        }
        a(this.f2851a.a(str), (Object) this.f2851a.a(str2));
    }

    public String toString() {
        return new JSONObject(this.f2852b).toString();
    }

    public void a(String str, Number number) {
        if (this.f2851a.a(str, "key") || this.f2851a.a(number, "value")) {
            return;
        }
        a(this.f2851a.a(str), (Object) number);
    }

    public void a(String str, Object obj) {
        if (this.f2851a.a(this.f2852b, str)) {
            return;
        }
        this.f2852b.put(str, obj);
    }
}
