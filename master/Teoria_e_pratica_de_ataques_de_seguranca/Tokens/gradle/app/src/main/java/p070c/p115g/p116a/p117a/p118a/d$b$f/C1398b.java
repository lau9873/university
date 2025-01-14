package p070c.p115g.p116a.p117a.p118a.d$b$f;

import android.content.Context;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p116a.p117a.p118a.C1415f;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1424b;
import p070c.p115g.p128c.p129a.p130a.C1425c;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.a.a.a.d$b$f.b */
/* loaded from: classes.dex */
public class C1398b extends C1373d.InterfaceC1375b.AbstractC1377c {
    public C1398b(Context context, JSONObject jSONObject, int i, int i2) {
        super(context, jSONObject, i, i2);
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: b */
    public boolean mo4564b(JSONObject jSONObject, int i) {
        return true;
    }

    /* renamed from: c */
    public final String m4599c(int i) {
        try {
            byte[] m4526e = C1415f.m4532b(m4578c()).m4526e();
            int parseInt = Integer.parseInt(C1425c.m4469a(Arrays.copyOfRange(m4526e, 2, m4526e.length)), 16);
            return i + "-559-" + parseInt;
        } catch (Exception e) {
            C1423a.m4476a("buildClientVersion", getClass(), e, "SERIOUS");
            return "";
        }
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: f */
    public String mo4563f() {
        return "GetInformation";
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: g */
    public JSONObject mo4562g() {
        JSONObject jSONObject = new JSONObject();
        String m4599c = m4599c(C1429f.m4444b(m4578c()).m4450a("hostAppVersion"));
        JSONArray m4472a = C1424b.m4472a("updateAttempts", m4578c());
        JSONArray m4474c = C1423a.m4474c();
        jSONObject.put("ManagerVersion", m4599c);
        jSONObject.put("ManagerDate", m4577d().getString("ManagerDate"));
        jSONObject.put("autoupdatesEnabled", C1429f.m4445b().m4446a("autoupdatesEnabled", true));
        jSONObject.put("validationsEnabled", C1429f.m4445b().m4446a("validationsEnabled", mo4575h()));
        jSONObject.put("updatesMonitoring", m4472a);
        if (m4474c == null) {
            m4474c = new JSONArray();
        }
        jSONObject.put("exceptionsMonitoring", m4474c);
        return jSONObject;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: h */
    public boolean mo4575h() {
        return true;
    }
}
