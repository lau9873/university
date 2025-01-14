package c.g.a.a.a.d$b$c$c;

import android.content.Context;
import c.g.a.a.a.d;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d.b.c.C0076d {
    public a(Context context, JSONObject jSONObject, int i2, int i3) {
        super(context, jSONObject, i2, i3);
    }

    @Override // c.g.a.a.a.d.b.c.C0076d, c.g.a.a.a.d.b.c
    public boolean b(JSONObject jSONObject, int i2) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.has("storedValue") || !jSONObject.has("records")) ? false : true;
    }

    @Override // c.g.a.a.a.d.b.c.C0076d, c.g.a.a.a.d.b.c
    public JSONObject g() {
        JSONObject g2 = super.g();
        if (g2 != null && g2.has("records")) {
            g2.put("records", a(a(a(g2.getJSONArray("records"), 23, (Integer) 1, (Integer) 2), 3, 0, 1), 3, 250, 2));
        }
        return g2;
    }
}
