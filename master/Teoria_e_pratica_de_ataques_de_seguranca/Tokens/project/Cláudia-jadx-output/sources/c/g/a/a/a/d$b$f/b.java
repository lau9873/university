package c.g.a.a.a.d$b$f;

import android.content.Context;
import c.g.a.a.a.d;
import c.g.a.a.a.f;
import c.g.c.a.a.a;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends d.b.c {
    public b(Context context, JSONObject jSONObject, int i2, int i3) {
        super(context, jSONObject, i2, i3);
    }

    @Override // c.g.a.a.a.d.b.c
    public boolean b(JSONObject jSONObject, int i2) {
        return true;
    }

    public final String c(int i2) {
        try {
            byte[] e2 = f.b(c()).e();
            int parseInt = Integer.parseInt(c.g.c.a.a.c.a(Arrays.copyOfRange(e2, 2, e2.length)), 16);
            return i2 + "-559-" + parseInt;
        } catch (Exception e3) {
            a.a("buildClientVersion", getClass(), e3, "SERIOUS");
            return "";
        }
    }

    @Override // c.g.a.a.a.d.b.c
    public String f() {
        return "GetInformation";
    }

    @Override // c.g.a.a.a.d.b.c
    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        String c2 = c(c.g.c.a.a.f.b(c()).a("hostAppVersion"));
        JSONArray a2 = c.g.c.a.a.b.a("updateAttempts", c());
        JSONArray c3 = a.c();
        jSONObject.put("ManagerVersion", c2);
        jSONObject.put("ManagerDate", d().getString("ManagerDate"));
        jSONObject.put("autoupdatesEnabled", c.g.c.a.a.f.b().a("autoupdatesEnabled", true));
        jSONObject.put("validationsEnabled", c.g.c.a.a.f.b().a("validationsEnabled", h()));
        jSONObject.put("updatesMonitoring", a2);
        if (c3 == null) {
            c3 = new JSONArray();
        }
        jSONObject.put("exceptionsMonitoring", c3);
        return jSONObject;
    }

    @Override // c.g.a.a.a.d.b.c
    public boolean h() {
        return true;
    }
}
