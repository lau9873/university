package p070c.p074b.p075a.p076b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: c.b.a.b.b */
/* loaded from: classes.dex */
public class AnswersAttributes {

    /* renamed from: a */
    public final AnswersEventValidator f4652a;

    /* renamed from: b */
    public final Map<String, Object> f4653b = new ConcurrentHashMap();

    public AnswersAttributes(AnswersEventValidator answersEventValidator) {
        this.f4652a = answersEventValidator;
    }

    /* renamed from: a */
    public void m6071a(String str, String str2) {
        if (this.f4652a.m6067a(str, "key") || this.f4652a.m6067a(str2, "value")) {
            return;
        }
        m6072a(this.f4652a.m6065a(str), (Object) this.f4652a.m6065a(str2));
    }

    public String toString() {
        return new JSONObject(this.f4653b).toString();
    }

    /* renamed from: a */
    public void m6073a(String str, Number number) {
        if (this.f4652a.m6067a(str, "key") || this.f4652a.m6067a(number, "value")) {
            return;
        }
        m6072a(this.f4652a.m6065a(str), (Object) number);
    }

    /* renamed from: a */
    public void m6072a(String str, Object obj) {
        if (this.f4652a.m6064a(this.f4653b, str)) {
            return;
        }
        this.f4653b.put(str, obj);
    }
}
