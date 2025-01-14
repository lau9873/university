package p070c.p115g.p125b.p126a.p127d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.p124e.C1409a;
import p070c.p115g.p125b.p126a.C1418c;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.b.a.d.a */
/* loaded from: classes.dex */
public class C1421a {

    /* renamed from: c.g.b.a.d.a$a */
    /* loaded from: classes.dex */
    public static class C1422a {

        /* renamed from: a */
        public static String f6039a = "com.spirtech.android.hce.calypso.CalypsoService";

        /* renamed from: a */
        public static String m4486a(Context context) {
            return C1429f.m4444b(context).m4447a("package", "");
        }

        /* renamed from: a */
        public static void m4485a(String str, Context context) {
            C1429f.m4444b(context).m4440b("package", str);
        }

        /* renamed from: b */
        public static boolean m4484b(Context context) {
            return !m4486a(context).equals("");
        }
    }

    /* renamed from: a */
    public static Intent m4490a(int i, JSONObject jSONObject, int i2, Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(C1422a.m4486a(context), C1422a.f6039a));
        intent.setAction("PTOA_TO_SPA");
        intent.putExtra("REQ_ID", i);
        intent.putExtra("LISTENER_ID", i2);
        intent.putExtra("package", C1422a.m4486a(context));
        intent.putExtra("data", jSONObject.toString());
        return intent;
    }

    /* renamed from: a */
    public static void m4489a(Context context, String str) {
        C1422a.m4485a(str, context);
    }

    /* renamed from: a */
    public static void m4488a(Intent intent, Context context) {
        C1409a.m4554a(intent, context);
    }

    /* renamed from: b */
    public static void m4487b(Intent intent, Context context) {
        C1418c.m4492c().m4497a(context, intent);
    }
}
