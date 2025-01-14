package c.g.a.a.a.d$b$d;

import android.content.Context;
import c.g.a.a.a.a.a;
import c.g.a.a.a.d;
import c.g.c.a.a.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d.b.c {
    public a(Context context, JSONObject jSONObject, int i2, int i3) {
        super(context, jSONObject, i2, i3);
    }

    @Override // c.g.a.a.a.d.b.c
    public boolean b(JSONObject jSONObject, int i2) {
        return true;
    }

    @Override // c.g.a.a.a.d.b.c
    public String f() {
        return "EditSettings";
    }

    @Override // c.g.a.a.a.d.b.c
    public JSONObject g() {
        f.b().b("autoupdatesEnabled", d().getBoolean("autoupdatesEnabled"));
        f.b().b("validationsEnabled", d().getBoolean("validationsEnabled"));
        a.b.f3946f = null;
        return null;
    }
}
