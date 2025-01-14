package c.g.b.a;

import android.content.Context;
import c.g.b.a.d.a;
import c.g.c.a.a.d;
import c.g.c.a.a.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f4002a = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4003b = false;

    public static b a() {
        if (f4002a == null) {
            f4002a = new b();
        }
        return f4002a;
    }

    public static void a(boolean z) {
        f4003b = z;
    }

    public static boolean a(int i2) {
        return i2 == 222 || i2 == 971 || i2 == 9223 || i2 == 225 || i2 == 223 || i2 == 972 || i2 == 9224 || i2 == 2223 || i2 == 2221 || i2 == 2222;
    }

    public static boolean b(Context context) {
        return f4003b && System.currentTimeMillis() - f.b(context).a("lastSuccessfulUageOfAPI", System.currentTimeMillis()) < 30000;
    }

    public final String a(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt >= '0' && charAt <= '9') || (charAt == '+' && sb.length() == 0)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public final void a(int i2, JSONObject jSONObject, Context context, a aVar) {
        if (!a(i2)) {
            a(true);
        }
        c.g.b.a.d.a.a(c.g.b.a.d.a.a(i2, jSONObject, aVar != null ? c.a(aVar) : -1, context), context);
    }

    public final void a(Context context, int i2) {
        try {
            a(9224, new JSONObject().put("ManagerVersion", i2), context, (a) null);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("initializationIntent", b.class, e2);
        }
    }

    public void a(Context context, int i2, String str, a aVar) {
        if (a(context, 221, aVar, false)) {
            String a2 = a(str);
            try {
                f.b(context).b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("networkID", i2);
                jSONObject.put("clientPhoneNbr", a2);
                d.b().e("wholeEnrolmentTime");
                a(221, jSONObject, context, aVar);
            } catch (Exception e2) {
                c.g.c.a.a.a.a("enroll", b.class, e2);
                a(false);
                aVar.notifyAnswer(-1, 221, null);
            }
        }
    }

    public void a(Context context, a aVar) {
        if (a(context, 972, aVar, false)) {
            try {
                f.b(context).b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ManagerDate", "2018-05-04");
                a(972, jSONObject, context, aVar);
            } catch (Exception e2) {
                c.g.c.a.a.a.a("getInformations", b.class, e2);
                a(false);
                aVar.notifyAnswer(-1, 972, null);
            }
        }
    }

    public void a(Context context, String str) {
        a(context, str, 0);
    }

    public void a(Context context, String str, int i2) {
        c.g.c.a.a.a.a(context);
        c.g.b.a.d.a.a(context, str);
        a(context, i2);
        c.g.c.a.a.a.a("VERIFICATIONDEV", 4, "environment = PRODPORTO ");
    }

    public final void a(Context context, JSONObject jSONObject, int i2, a aVar) {
        if (a(context, i2, aVar, true)) {
            f.b(context).b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
            try {
                if (i2 == 222 || i2 == 2222 || i2 == 2223 || i2 == 2221) {
                    if (jSONObject == null) {
                        throw new Exception("null param");
                    }
                    a(i2, jSONObject, context, aVar);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("apiCall ");
                sb.append(i2);
                sb.append(" is not a synchronize-like call");
                throw new Exception(sb.toString());
            } catch (Exception e2) {
                c.g.c.a.a.a.a("synchronize", b.class, e2);
                aVar.notifyAnswer(-1, i2, null);
            }
        }
    }

    public void a(Context context, JSONObject jSONObject, a aVar) {
        if (a(context, 223, aVar, true)) {
            try {
                f.b(context).b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
                a(223, jSONObject, context, aVar);
            } catch (Exception e2) {
                c.g.c.a.a.a.a("getContents", b.class, e2);
                a(false);
                aVar.notifyAnswer(-1, 223, null);
            }
        }
    }

    public void a(Context context, boolean z, boolean z2, a aVar) {
        if (a(context, 9223, aVar, true)) {
            try {
                f.b(context).b("lastSuccessfulUageOfAPI", System.currentTimeMillis());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("autoupdatesEnabled", z);
                jSONObject.put("validationsEnabled", z2);
                a(9223, jSONObject, context, aVar);
            } catch (Exception e2) {
                c.g.c.a.a.a.a("editSettings", b.class, e2);
                a(false);
                aVar.notifyAnswer(-1, 9223, null);
            }
        }
    }

    public void a(a aVar) {
        c.b(aVar);
    }

    public boolean a(Context context) {
        return f.b(context).a("SpirtechEnrolledState", false);
    }

    public final boolean a(Context context, int i2, a aVar, boolean z) {
        int i3;
        f.b(context);
        c.f4006c++;
        if (b(context)) {
            i3 = -2;
        } else if (!a.C0080a.b(context)) {
            i3 = -3;
        } else if (!z || a(context)) {
            return true;
        } else {
            i3 = -5;
        }
        aVar.notifyAnswer(i3, i2, null);
        return false;
    }

    public void b(Context context, a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unregister", false);
            a(context, jSONObject, 222, aVar);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("synchronize", b.class, e2, "difficulty creating JSON arg for synchronize call");
            aVar.notifyAnswer(-1, 222, null);
        }
    }
}
