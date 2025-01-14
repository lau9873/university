package c.g.a.a.a.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import c.g.a.a.a.d;
import c.g.c.a.a.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: c.g.a.a.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0078a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f3989a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Intent f3990b;

        public RunnableC0078a(Context context, Intent intent) {
            this.f3989a = context;
            this.f3990b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b(this.f3989a).a(this.f3990b);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static String f3991a = "com.spirtech.surpass.api.RequestReceiver";

        public static String a(Context context) {
            return f.b(context).a("package", "calypso.hce.android.spirtech.com.mexico");
        }

        public static void a(Context context, String str) {
            f.b(context).b("package", str);
        }
    }

    public static Intent a(JSONObject jSONObject, Integer num, int i2, int i3, Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(b.a(context), b.f3991a));
        intent.setAction("SPA_TO_PTOA");
        intent.putExtra("REQ_ID", num);
        intent.putExtra("LISTENER_ID", i2);
        intent.putExtra("result", i3);
        intent.putExtra("data", jSONObject.toString());
        return intent;
    }

    public static void a(Context context, String str) {
        b.a(context, str);
    }

    public static void a(Intent intent, Context context) {
        new Handler(context.getMainLooper()).post(new RunnableC0078a(context, intent));
    }

    public static void a(Integer num, int i2, int i3, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", i2);
            b(a(jSONObject, num, i3, i2, context), context);
        } catch (Exception e2) {
            c.g.c.a.a.a.a("sendBackError", a.class, e2);
        }
    }

    public static void b(Intent intent, Context context) {
        c.g.b.a.d.a.b(intent, context);
    }
}
