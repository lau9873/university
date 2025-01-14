package p070c.p115g.p116a.p117a.p118a.p124e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p125b.p126a.p127d.C1421a;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.a.a.a.e.a */
/* loaded from: classes.dex */
public class C1409a {

    /* renamed from: c.g.a.a.a.e.a$a */
    /* loaded from: classes.dex */
    public static class RunnableC1410a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f6018a;

        /* renamed from: b */
        public final /* synthetic */ Intent f6019b;

        public RunnableC1410a(Context context, Intent intent) {
            this.f6018a = context;
            this.f6019b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1373d.m4613b(this.f6018a).m4615a(this.f6019b);
        }
    }

    /* renamed from: c.g.a.a.a.e.a$b */
    /* loaded from: classes.dex */
    public static class C1411b {

        /* renamed from: a */
        public static String f6020a = "com.spirtech.surpass.api.RequestReceiver";

        /* renamed from: a */
        public static String m4550a(Context context) {
            return C1429f.m4444b(context).m4447a("package", "calypso.hce.android.spirtech.com.mexico");
        }

        /* renamed from: a */
        public static void m4549a(Context context, String str) {
            C1429f.m4444b(context).m4440b("package", str);
        }
    }

    /* renamed from: a */
    public static Intent m4552a(JSONObject jSONObject, Integer num, int i, int i2, Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(C1411b.m4550a(context), C1411b.f6020a));
        intent.setAction("SPA_TO_PTOA");
        intent.putExtra("REQ_ID", num);
        intent.putExtra("LISTENER_ID", i);
        intent.putExtra("result", i2);
        intent.putExtra("data", jSONObject.toString());
        return intent;
    }

    /* renamed from: a */
    public static void m4555a(Context context, String str) {
        C1411b.m4549a(context, str);
    }

    /* renamed from: a */
    public static void m4554a(Intent intent, Context context) {
        new Handler(context.getMainLooper()).post(new RunnableC1410a(context, intent));
    }

    /* renamed from: a */
    public static void m4553a(Integer num, int i, int i2, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", i);
            m4551b(m4552a(jSONObject, num, i2, i, context), context);
        } catch (Exception e) {
            C1423a.m4477a("sendBackError", C1409a.class, e);
        }
    }

    /* renamed from: b */
    public static void m4551b(Intent intent, Context context) {
        C1421a.m4487b(intent, context);
    }
}
