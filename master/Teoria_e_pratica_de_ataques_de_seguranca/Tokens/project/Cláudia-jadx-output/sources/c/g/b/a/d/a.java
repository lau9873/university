package c.g.b.a.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import c.g.b.a.c;
import c.g.c.a.a.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: c.g.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0080a {

        /* renamed from: a  reason: collision with root package name */
        public static String f4010a = "com.spirtech.android.hce.calypso.CalypsoService";

        public static String a(Context context) {
            return f.b(context).a("package", "");
        }

        public static void a(String str, Context context) {
            f.b(context).b("package", str);
        }

        public static boolean b(Context context) {
            return !a(context).equals("");
        }
    }

    public static Intent a(int i2, JSONObject jSONObject, int i3, Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(C0080a.a(context), C0080a.f4010a));
        intent.setAction("PTOA_TO_SPA");
        intent.putExtra("REQ_ID", i2);
        intent.putExtra("LISTENER_ID", i3);
        intent.putExtra("package", C0080a.a(context));
        intent.putExtra("data", jSONObject.toString());
        return intent;
    }

    public static void a(Context context, String str) {
        C0080a.a(str, context);
    }

    public static void a(Intent intent, Context context) {
        c.g.a.a.a.e.a.a(intent, context);
    }

    public static void b(Intent intent, Context context) {
        c.c().a(context, intent);
    }
}
