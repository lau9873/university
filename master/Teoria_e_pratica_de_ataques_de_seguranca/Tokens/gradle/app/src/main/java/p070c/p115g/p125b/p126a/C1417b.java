package p070c.p115g.p125b.p126a;

import android.content.Context;
import org.json.JSONObject;
import p070c.p115g.p125b.p126a.p127d.C1421a;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1426d;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.b.a.b */
/* loaded from: classes.dex */
public class C1417b {

    /* renamed from: a */
    public static C1417b f6031a = null;

    /* renamed from: b */
    public static boolean f6032b = false;

    /* renamed from: a */
    public static C1417b m4518a() {
        if (f6031a == null) {
            f6031a = new C1417b();
        }
        return f6031a;
    }

    /* renamed from: a */
    public static void m4503a(boolean z) {
        f6032b = z;
    }

    /* renamed from: a */
    public static boolean m4517a(int i) {
        return i == 222 || i == 971 || i == 9223 || i == 225 || i == 223 || i == 972 || i == 9224 || i == 2223 || i == 2221 || i == 2222;
    }

    /* renamed from: b */
    public static boolean m4502b(Context context) {
        return f6032b && System.currentTimeMillis() - C1429f.m4444b(context).m4448a("lastSuccessfulUageOfAPI", System.currentTimeMillis()) < 30000;
    }

    /* renamed from: a */
    public final String m4504a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt >= '0' && charAt <= '9') || (charAt == '+' && sb.length() == 0)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public final void m4516a(int i, JSONObject jSONObject, Context context, InterfaceC1416a interfaceC1416a) {
        if (!m4517a(i)) {
            m4503a(true);
        }
        C1421a.m4488a(C1421a.m4490a(i, jSONObject, interfaceC1416a != null ? C1418c.m4495a(interfaceC1416a) : -1, context), context);
    }

    /* renamed from: a */
    public final void m4514a(Context context, int i) {
        try {
            m4516a(9224, new JSONObject().put("ManagerVersion", i), context, (InterfaceC1416a) null);
        } catch (Exception e) {
            C1423a.m4477a("initializationIntent", C1417b.class, e);
        }
    }

    /* renamed from: a */
    public void m4512a(Context context, int i, String str, InterfaceC1416a interfaceC1416a) {
        if (m4513a(context, 221, interfaceC1416a, false)) {
            String m4504a = m4504a(str);
            try {
                C1429f.m4444b(context).m4441b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("networkID", i);
                jSONObject.put("clientPhoneNbr", m4504a);
                C1426d.m4461b().m4457e("wholeEnrolmentTime");
                m4516a(221, jSONObject, context, interfaceC1416a);
            } catch (Exception e) {
                C1423a.m4477a("enroll", C1417b.class, e);
                m4503a(false);
                interfaceC1416a.notifyAnswer(-1, 221, null);
            }
        }
    }

    /* renamed from: a */
    public void m4511a(Context context, InterfaceC1416a interfaceC1416a) {
        if (m4513a(context, 972, interfaceC1416a, false)) {
            try {
                C1429f.m4444b(context).m4441b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ManagerDate", "2018-05-04");
                m4516a(972, jSONObject, context, interfaceC1416a);
            } catch (Exception e) {
                C1423a.m4477a("getInformations", C1417b.class, e);
                m4503a(false);
                interfaceC1416a.notifyAnswer(-1, 972, null);
            }
        }
    }

    /* renamed from: a */
    public void m4510a(Context context, String str) {
        m4509a(context, str, 0);
    }

    /* renamed from: a */
    public void m4509a(Context context, String str, int i) {
        C1423a.m4480a(context);
        C1421a.m4489a(context, str);
        m4514a(context, i);
        C1423a.m4478a("VERIFICATIONDEV", 4, "environment = PRODPORTO ");
    }

    /* renamed from: a */
    public final void m4508a(Context context, JSONObject jSONObject, int i, InterfaceC1416a interfaceC1416a) {
        if (m4513a(context, i, interfaceC1416a, true)) {
            C1429f.m4444b(context).m4441b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
            try {
                if (i == 222 || i == 2222 || i == 2223 || i == 2221) {
                    if (jSONObject == null) {
                        throw new Exception("null param");
                    }
                    m4516a(i, jSONObject, context, interfaceC1416a);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("apiCall ");
                sb.append(i);
                sb.append(" is not a synchronize-like call");
                throw new Exception(sb.toString());
            } catch (Exception e) {
                C1423a.m4477a("synchronize", C1417b.class, e);
                interfaceC1416a.notifyAnswer(-1, i, null);
            }
        }
    }

    /* renamed from: a */
    public void m4507a(Context context, JSONObject jSONObject, InterfaceC1416a interfaceC1416a) {
        if (m4513a(context, 223, interfaceC1416a, true)) {
            try {
                C1429f.m4444b(context).m4441b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
                m4516a(223, jSONObject, context, interfaceC1416a);
            } catch (Exception e) {
                C1423a.m4477a("getContents", C1417b.class, e);
                m4503a(false);
                interfaceC1416a.notifyAnswer(-1, 223, null);
            }
        }
    }

    /* renamed from: a */
    public void m4506a(Context context, boolean z, boolean z2, InterfaceC1416a interfaceC1416a) {
        if (m4513a(context, 9223, interfaceC1416a, true)) {
            try {
                C1429f.m4444b(context).m4441b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("autoupdatesEnabled", z);
                jSONObject.put("validationsEnabled", z2);
                m4516a(9223, jSONObject, context, interfaceC1416a);
            } catch (Exception e) {
                C1423a.m4477a("editSettings", C1417b.class, e);
                m4503a(false);
                interfaceC1416a.notifyAnswer(-1, 9223, null);
            }
        }
    }

    /* renamed from: a */
    public void m4505a(InterfaceC1416a interfaceC1416a) {
        C1418c.m4493b(interfaceC1416a);
    }

    /* renamed from: a */
    public boolean m4515a(Context context) {
        return C1429f.m4444b(context).m4446a("SpirtechEnrolledState", false);
    }

    /* renamed from: a */
    public final boolean m4513a(Context context, int i, InterfaceC1416a interfaceC1416a, boolean z) {
        int i2;
        C1429f.m4444b(context);
        C1418c.f6035c++;
        if (m4502b(context)) {
            i2 = -2;
        } else if (!C1421a.C1422a.m4484b(context)) {
            i2 = -3;
        } else if (!z || m4515a(context)) {
            return true;
        } else {
            i2 = -5;
        }
        interfaceC1416a.notifyAnswer(i2, i, null);
        return false;
    }

    /* renamed from: b */
    public void m4501b(Context context, InterfaceC1416a interfaceC1416a) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unregister", false);
            m4508a(context, jSONObject, 222, interfaceC1416a);
        } catch (Exception e) {
            C1423a.m4476a("synchronize", C1417b.class, e, "difficulty creating JSON arg for synchronize call");
            interfaceC1416a.notifyAnswer(-1, 222, null);
        }
    }
}
